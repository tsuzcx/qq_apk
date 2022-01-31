package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.h;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.filter.m.n;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetectorManager;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FaceOffFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffFragmentShader.dat");
  private static final String TAG = FaceOffFilter.class.getSimpleName();
  public static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffVertexShader.dat");
  private byte[] data = null;
  private int faceImageHeight;
  private int faceImageWidth;
  private float[] faceVertices = new float[1380];
  private long frameStartTime;
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices = new float[1380];
  private boolean isFaceImageReady;
  private boolean isGrayImageReady;
  private FaceItem item;
  private int lastIndex = -1;
  public float level1 = 0.0F;
  public float level2 = 0.0F;
  public int levelCount = 0;
  byte[] mData = null;
  private int mRandomGroupValue;
  private h origFrame = null;
  float percent1 = 0.05F;
  float percent2 = 0.15F;
  private int playCount;
  private boolean sequenceMode;
  public double sumg = 0.0D;
  public double sumr = 0.0D;
  private float[] texVertices = new float[1380];
  private int[] texture = new int[2];
  private boolean triggered;
  
  public FaceOffFilter(FaceItem paramFaceItem, String paramString)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF);
    this.item = paramFaceItem;
    this.dataPath = paramString;
    this.sequenceMode = TextUtils.isEmpty(paramFaceItem.faceExchangeImage);
    initParams();
  }
  
  private float getAverageGreen(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    if (this.data == null) {
      return 0.0F;
    }
    int i = (int)(((PointF)paramList.get(66)).x - ((PointF)paramList.get(65)).x);
    int m = (int)(((PointF)paramList.get(69)).y - ((PointF)paramList.get(78)).y);
    int j = (int)((PointF)paramList.get(65)).x;
    int k = (int)((PointF)paramList.get(78)).y;
    if ((j >= paramInt1) || (k >= paramInt2) || (i <= 0) || (m <= 0)) {
      return 0.0F;
    }
    if (j < 0) {
      j = 0;
    }
    for (;;)
    {
      if (k < 0) {
        k = 0;
      }
      for (;;)
      {
        if (j + i > paramInt1) {
          i = paramInt1 - j;
        }
        for (;;)
        {
          if (k + m > paramInt2) {
            paramInt2 -= k;
          }
          for (;;)
          {
            paramList = new byte[i * paramInt2 * 4];
            m = 0;
            while (m < paramInt2)
            {
              int n = 0;
              while (n < i)
              {
                int i1 = (m * i + n) * 4;
                int i2 = ((m + k) * paramInt1 + n + j) * 4;
                paramList[i1] = this.data[i2];
                paramList[(i1 + 1)] = this.data[(i2 + 1)];
                paramList[(i1 + 2)] = this.data[(i2 + 2)];
                paramList[(i1 + 3)] = this.data[(i2 + 3)];
                n += 1;
              }
              m += 1;
            }
            int[] arrayOfInt = new int[256];
            this.sumg = 0.0D;
            this.sumr = 0.0D;
            paramInt1 = 0;
            while (paramInt1 < paramInt2)
            {
              j = 0;
              while (j < i)
              {
                k = paramList[((paramInt1 * i + j) * 4)] & 0xFF;
                this.sumr += k;
                m = paramList[((paramInt1 * i + j) * 4 + 1)];
                this.sumg += (m & 0xFF);
                arrayOfInt[k] += 1;
                j += 1;
              }
              paramInt1 += 1;
            }
            this.sumg /= i * paramInt2;
            this.sumr /= i * paramInt2;
            this.levelCount = 0;
            paramInt1 = 255;
            if (paramInt1 >= 0)
            {
              this.levelCount += arrayOfInt[paramInt1];
              if (this.levelCount >= paramInt2 * i * this.percent1) {
                this.level1 = paramInt1;
              }
            }
            else
            {
              this.levelCount = 0;
              paramInt1 = 255;
            }
            for (;;)
            {
              if (paramInt1 >= 0)
              {
                this.levelCount += arrayOfInt[paramInt1];
                if (this.levelCount >= paramInt2 * i * this.percent2) {
                  this.level2 = paramInt1;
                }
              }
              else
              {
                return (float)this.sumr;
                paramInt1 -= 1;
                break;
              }
              paramInt1 -= 1;
            }
            paramInt2 = m;
          }
        }
      }
    }
  }
  
  private boolean initFaceImage()
  {
    if (this.isFaceImageReady) {
      return true;
    }
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.faceExchangeImage);
    int i = VideoMemoryManager.getInstance().getSampleSize();
    if (VideoBitmapUtil.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap);
      this.faceImageWidth = (localBitmap.getWidth() * i);
      this.faceImageHeight = (localBitmap.getHeight() * i);
      initFaceTexCoords();
      addParam(new m.n("inputImageTexture2", this.texture[0], 33986));
      this.isFaceImageReady = true;
    }
    return this.isFaceImageReady;
  }
  
  private void initFaceTexCoords()
  {
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.genPoints(this.item.facePoints), 2.0F), this.faceImageWidth, this.faceImageHeight, this.texVertices));
  }
  
  private boolean initGrayImage()
  {
    if (this.isGrayImageReady) {
      return true;
    }
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.featureType);
    int i = VideoMemoryManager.getInstance().getSampleSize();
    if (VideoBitmapUtil.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[1], localBitmap);
      this.grayImageWidth = (localBitmap.getWidth() * i);
      this.grayImageHeight = (localBitmap.getHeight() * i);
      initGrayTexCoords();
      addParam(new m.n("inputImageTexture3", this.texture[1], 33987));
      this.isGrayImageReady = true;
    }
    return this.isGrayImageReady;
  }
  
  private void initGrayTexCoords()
  {
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoords(FaceOffUtil.getGrayCoords(this.item.featureType), 2.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
  }
  
  private boolean isCharmRangeHit()
  {
    return (this.item.charmRange == null) || (this.item.charmRange.isHit());
  }
  
  private boolean isRandomGroupValueHit()
  {
    if (this.item.randomGroupNum == 0) {}
    while (this.mRandomGroupValue == this.item.randomGroupNum) {
      return true;
    }
    return false;
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.texture.length, this.texture, 0);
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item != null) && (this.item.blendMode < 2);
  }
  
  public void clearGLSLSelf()
  {
    GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
    super.clearGLSLSelf();
  }
  
  public FaceItem getFaceOffItem()
  {
    return this.item;
  }
  
  public int getNextFrame(int paramInt)
  {
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (VideoBitmapUtil.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap);
      this.isFaceImageReady = true;
      return this.texture[0];
    }
    return -1;
  }
  
  public void initAttribParams()
  {
    super.initAttribParams();
    initFaceTexCoords();
    initGrayTexCoords();
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
  }
  
  public void initParams()
  {
    this.faceImageWidth = this.item.width;
    this.faceImageHeight = this.item.height;
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.n("inputImageTexture3", 0, 33987));
    addParam(new m.i("enableFaceOff", 1));
    addParam(new m.f("alpha", this.item.blendAlpha));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.f("positionRotate", 0.0F));
    addParam(new m.i("enableAlphaFromGray", this.item.grayScale));
    addParam(new m.i("blendMode", this.item.blendMode));
    if (this.item.blendMode == 13)
    {
      addParam(new m.f("level1", 0.0F));
      addParam(new m.f("level2", 0.0F));
    }
    if (this.item.blendMode == 14)
    {
      addParam(new m.k("inputImageTexture4", FaceOffUtil.getFaceBitmap(this.dataPath + File.separator + this.item.irisImage), 33988, true));
      float[] arrayOfFloat = new float[2];
      float[] tmp278_277 = arrayOfFloat;
      tmp278_277[0] = 0.0F;
      float[] tmp282_278 = tmp278_277;
      tmp282_278[1] = 0.0F;
      tmp282_278;
      addParam(new m.g("center1", arrayOfFloat));
      addParam(new m.g("center2", arrayOfFloat));
      addParam(new m.g("size", arrayOfFloat));
      addParam(new m.f("radius1", 0.0F));
      addParam(new m.f("radius2", 0.0F));
    }
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isFaceImageReady) && (this.isGrayImageReady);
  }
  
  public void setCosAlpha(float paramFloat)
  {
    addParam(new m.f("alpha", paramFloat));
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.data = paramArrayOfByte;
  }
  
  public void setOrigFrame(h paramh)
  {
    this.origFrame = paramh;
  }
  
  public void updateActionTriggered(Map<Integer, FaceActionCounter> paramMap, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    boolean bool;
    int i;
    label110:
    int j;
    if (this.item.activateTriggerTotalCount != 0)
    {
      if (((this.item.preTriggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) && (!VideoMaterialUtil.isFaceTriggerType(this.item.preTriggerType))) || (!paramSet.contains(Integer.valueOf(this.item.preTriggerType)))) {
        break label433;
      }
      bool = VideoMaterialUtil.isFaceTriggerType(this.item.countTriggerType);
      if (bool)
      {
        paramSet = paramMap;
        if (paramSet == null) {
          break label433;
        }
        if (!bool) {
          break label244;
        }
        i = ((FaceActionCounter)paramMap.get(Integer.valueOf(this.item.countTriggerType))).count;
        if (i % this.item.activateTriggerTotalCount != this.item.activateTriggerCount) {
          break label433;
        }
        if ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)) {
          break label271;
        }
        j = 1;
        label157:
        if (this.playCount >= this.item.playCount) {
          break label277;
        }
        i = j;
        if (bool)
        {
          FaceDetectorManager.getInstance().getCurrentFaceDetector().lockActionCounter();
          i = j;
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (isCharmRangeHit()) && (isRandomGroupValueHit()))
      {
        i = 1;
        label215:
        if (i == 0) {
          break label387;
        }
        if (!this.triggered) {
          this.frameStartTime = paramLong;
        }
        this.triggered = true;
        label238:
        return;
        paramSet = paramMap1;
        break;
        label244:
        i = ((HandActionCounter)paramMap1.get(Integer.valueOf(this.item.countTriggerType))).count;
        break label110;
        label271:
        j = 0;
        break label157;
        label277:
        i = j;
        if (this.item.playCount <= 0) {
          continue;
        }
        i = j;
        if (!bool) {
          continue;
        }
        FaceDetectorManager.getInstance().getCurrentFaceDetector().clearActionCounter();
        i = j;
        continue;
        if (VideoMaterialUtil.isFaceTriggerType(this.item.triggerType))
        {
          if (paramSet == null) {
            break label427;
          }
          bool = paramSet.contains(Integer.valueOf(this.item.triggerType));
        }
      }
      for (;;)
      {
        if ((bool) || (this.mIsRenderForBitmap))
        {
          i = 1;
          break;
          bool = false;
          continue;
        }
        i = 0;
        break;
        i = 0;
        break label215;
        label387:
        if ((!this.item.alwaysTriggered) && ((this.item.playCount <= 0) || (this.playCount < this.item.playCount))) {
          break label238;
        }
        this.triggered = false;
        return;
        label427:
        bool = false;
      }
      label433:
      i = 0;
    }
  }
  
  public void updatePointParams(List<PointF> paramList)
  {
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoords(VideoMaterialUtil.copyList(paramList), 2.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
    if (this.item.blendMode == 13)
    {
      getAverageGreen(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale));
      addParam(new m.f("level1", this.level1 / 255.0F));
      addParam(new m.f("level2", this.level2 / 255.0F));
    }
    if (this.item.blendMode == 14)
    {
      float f1 = AlgoUtils.getDistance((PointF)paramList.get(35), (PointF)paramList.get(39));
      float f2 = AlgoUtils.getDistance((PointF)paramList.get(45), (PointF)paramList.get(49));
      float f3 = Math.max(((PointF)paramList.get(44)).x - ((PointF)paramList.get(43)).x, ((PointF)paramList.get(54)).x - ((PointF)paramList.get(53)).x);
      f3 = ((float)Math.pow(Math.abs(f3) / Math.max(f1, f2), 1.0D) * 20.0F + 1.0F) * f3;
      f1 = (float)((((PointF)paramList.get(44)).x + f3) / this.mFaceDetScale);
      f2 = (float)(((PointF)paramList.get(44)).y / this.mFaceDetScale);
      f3 = (float)((((PointF)paramList.get(54)).x + f3) / this.mFaceDetScale);
      float f4 = (float)(((PointF)paramList.get(54)).y / this.mFaceDetScale);
      float f5 = this.width;
      float f6 = this.height;
      float f7 = (float)(AlgoUtils.getDistance((PointF)paramList.get(39), (PointF)paramList.get(35)) / this.mFaceDetScale / 4.0D);
      float f8 = (float)(AlgoUtils.getDistance((PointF)paramList.get(49), (PointF)paramList.get(45)) / this.mFaceDetScale / 4.0D);
      addParam(new m.g("center1", new float[] { f1, f2 }));
      addParam(new m.g("center2", new float[] { f3, f4 }));
      addParam(new m.g("size", new float[] { f5, f6 }));
      addParam(new m.f("radius1", f7 * 0.9F));
      addParam(new m.f("radius2", f8 * 0.9F));
    }
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    paramList1 = VideoMaterialUtil.copyList(paramList1);
    updateActionTriggered(paramMap, paramMap1, paramSet, paramLong);
    if (!this.triggered)
    {
      this.playCount = 0;
      this.lastIndex = -1;
      return;
    }
    updatePointParams(paramList1);
    updateTextureParams(paramLong);
  }
  
  public void updateRandomGroupValue(int paramInt)
  {
    this.mRandomGroupValue = paramInt;
  }
  
  public void updateTextureParams(long paramLong)
  {
    if (!initGrayImage()) {}
    int i;
    int j;
    do
    {
      do
      {
        return;
        long l = this.frameStartTime;
        if (!this.sequenceMode) {
          break;
        }
        i = (int)((paramLong - l) / Math.max(this.item.frameDuration, 1));
        if (i >= this.item.frames * (this.playCount + 1)) {
          this.playCount += 1;
        }
        i %= Math.max(this.item.frames, 1);
      } while (i == this.lastIndex);
      j = getNextFrame(i);
    } while (j <= 0);
    addParam(new m.n("inputImageTexture2", j, 33986));
    this.lastIndex = i;
    return;
    initFaceImage();
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffFilter
 * JD-Core Version:    0.7.0.1
 */