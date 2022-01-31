package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.m.b;
import com.tencent.filter.m.f;
import com.tencent.filter.m.g;
import com.tencent.filter.m.i;
import com.tencent.filter.m.k;
import com.tencent.filter.m.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.FaceOffUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.List;

public class FaceOffFilter
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER;
  private static final String TAG;
  public static final String VERTEX_SHADER;
  private byte[] data;
  protected int faceImageHeight;
  protected int faceImageWidth;
  private float[] faceVertices;
  private int grayImageHeight;
  private int grayImageWidth;
  private float[] grayVertices;
  protected boolean isFaceImageReady;
  private boolean isGrayImageReady;
  protected FaceItem item;
  private int lastIndex;
  public float level1;
  public float level2;
  public int levelCount;
  byte[] mData;
  float percent1;
  float percent2;
  private boolean sequenceMode;
  public double sumg;
  public double sumr;
  private float[] texVertices;
  protected int[] texture;
  private TriggerCtrlItem triggerCtrlItem;
  private boolean triggered;
  
  static
  {
    AppMethodBeat.i(82434);
    TAG = FaceOffFilter.class.getSimpleName();
    VERTEX_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffVertexShader.dat");
    FRAGMENT_SHADER = FileUtils.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/FaceOffFragmentShader.dat");
    AppMethodBeat.o(82434);
  }
  
  public FaceOffFilter(FaceItem paramFaceItem, String paramString)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.FACEOFF);
    AppMethodBeat.i(82413);
    this.faceVertices = new float[1380];
    this.texVertices = new float[1380];
    this.grayVertices = new float[1380];
    this.texture = new int[2];
    this.lastIndex = -1;
    this.mData = null;
    this.data = null;
    this.level1 = 0.0F;
    this.level2 = 0.0F;
    this.percent1 = 0.05F;
    this.percent2 = 0.15F;
    this.sumg = 0.0D;
    this.sumr = 0.0D;
    this.levelCount = 0;
    this.item = paramFaceItem;
    this.dataPath = paramString;
    this.sequenceMode = TextUtils.isEmpty(paramFaceItem.faceExchangeImage);
    this.triggerCtrlItem = new TriggerCtrlItem(paramFaceItem);
    initParams();
    AppMethodBeat.o(82413);
  }
  
  private float getAverageGreen(List<PointF> paramList, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(82428);
    if ((this.data == null) || (this.data.length < paramInt2 * paramInt1 * 4))
    {
      AppMethodBeat.o(82428);
      return 0.0F;
    }
    int i = (int)(((PointF)paramList.get(66)).x - ((PointF)paramList.get(65)).x);
    int m = (int)(((PointF)paramList.get(69)).y - ((PointF)paramList.get(78)).y);
    int j = (int)((PointF)paramList.get(65)).x;
    int k = (int)((PointF)paramList.get(78)).y;
    if ((j >= paramInt1) || (k >= paramInt2) || (i <= 0) || (m <= 0))
    {
      AppMethodBeat.o(82428);
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
                float f = (float)this.sumr;
                AppMethodBeat.o(82428);
                return f;
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
  
  private void initGrayTexCoords()
  {
    AppMethodBeat.i(82419);
    setGrayCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(FaceOffUtil.getGrayCoords(this.item.featureType), 2.0F), this.grayImageWidth, this.grayImageHeight, this.grayVertices));
    AppMethodBeat.o(82419);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(82429);
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.texture.length, this.texture, 0);
    AppMethodBeat.o(82429);
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item != null) && (this.item.blendMode < 2);
  }
  
  public void clearGLSLSelf()
  {
    AppMethodBeat.i(82430);
    GLES20.glDeleteTextures(this.texture.length, this.texture, 0);
    super.clearGLSLSelf();
    AppMethodBeat.o(82430);
  }
  
  public FaceItem getFaceOffItem()
  {
    return this.item;
  }
  
  public int getNextFrame(int paramInt)
  {
    AppMethodBeat.i(82426);
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
    if (BitmapUtils.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap);
      this.isFaceImageReady = true;
      paramInt = this.texture[0];
      AppMethodBeat.o(82426);
      return paramInt;
    }
    AppMethodBeat.o(82426);
    return -1;
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(82417);
    super.initAttribParams();
    initFaceTexCoords();
    initGrayTexCoords();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLES);
    setCoordNum(690);
    AppMethodBeat.o(82417);
  }
  
  protected boolean initFaceImage()
  {
    AppMethodBeat.i(82423);
    if (this.isFaceImageReady)
    {
      AppMethodBeat.o(82423);
      return true;
    }
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.faceExchangeImage, this.item.faceExchangeImage);
    int i = VideoMemoryManager.getInstance().getSampleSize();
    if (BitmapUtils.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[0], localBitmap);
      this.faceImageWidth = (localBitmap.getWidth() * i);
      this.faceImageHeight = (localBitmap.getHeight() * i);
      initFaceTexCoords();
      addParam(new m.n("inputImageTexture2", this.texture[0], 33986));
      this.isFaceImageReady = true;
    }
    boolean bool = this.isFaceImageReady;
    AppMethodBeat.o(82423);
    return bool;
  }
  
  protected void initFaceTexCoords()
  {
    AppMethodBeat.i(82418);
    setTexCords(FaceOffUtil.initMaterialFaceTexCoords(FaceOffUtil.getFullCoordsForFaceOffFilter(FaceOffUtil.genPoints(this.item.facePoints), 2.0F), this.faceImageWidth, this.faceImageHeight, this.texVertices));
    AppMethodBeat.o(82418);
  }
  
  protected boolean initGrayImage()
  {
    AppMethodBeat.i(82424);
    if (this.isGrayImageReady)
    {
      AppMethodBeat.o(82424);
      return true;
    }
    Bitmap localBitmap = VideoMemoryManager.getInstance().loadImage(this.item.featureType);
    int i = VideoMemoryManager.getInstance().getSampleSize();
    if (BitmapUtils.isLegal(localBitmap))
    {
      GlUtil.loadTexture(this.texture[1], localBitmap);
      this.grayImageWidth = (localBitmap.getWidth() * i);
      this.grayImageHeight = (localBitmap.getHeight() * i);
      initGrayTexCoords();
      addParam(new m.n("inputImageTexture3", this.texture[1], 33987));
      this.isGrayImageReady = true;
    }
    boolean bool = this.isGrayImageReady;
    AppMethodBeat.o(82424);
    return bool;
  }
  
  public void initParams()
  {
    AppMethodBeat.i(82414);
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
      float[] tmp286_285 = arrayOfFloat;
      tmp286_285[0] = 0.0F;
      float[] tmp290_286 = tmp286_285;
      tmp290_286[1] = 0.0F;
      tmp290_286;
      addParam(new m.g("center1", arrayOfFloat));
      addParam(new m.g("center2", arrayOfFloat));
      addParam(new m.g("size", arrayOfFloat));
      addParam(new m.f("radius1", 0.0F));
      addParam(new m.f("radius2", 0.0F));
      addParam(new m.f("leftEyeClosed", 0.0F));
      addParam(new m.f("rightEyeClosed", 0.0F));
    }
    AppMethodBeat.o(82414);
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isFaceImageReady) && (this.isGrayImageReady);
  }
  
  public void reset()
  {
    AppMethodBeat.i(82432);
    this.triggerCtrlItem.reset();
    AppMethodBeat.o(82432);
  }
  
  public void setCosAlpha(float paramFloat)
  {
    AppMethodBeat.i(82415);
    addParam(new m.f("alpha", paramFloat));
    AppMethodBeat.o(82415);
  }
  
  public void setImageData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    this.data = paramArrayOfByte;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    AppMethodBeat.i(82431);
    this.triggerCtrlItem.setRenderForBitmap(paramBoolean);
    AppMethodBeat.o(82431);
  }
  
  public void setTriggerWords(String paramString)
  {
    AppMethodBeat.i(82433);
    this.triggerCtrlItem.setTriggerWords(paramString);
    AppMethodBeat.o(82433);
  }
  
  public TRIGGERED_STATUS updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82421);
    paramPTDetectInfo = this.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
    AppMethodBeat.o(82421);
    return paramPTDetectInfo;
  }
  
  public void updatePointParams(List<PointF> paramList)
  {
    float f2 = 1.0F;
    int j = 1;
    AppMethodBeat.i(82425);
    setPositions(FaceOffUtil.initFacePositions(FaceOffUtil.getFullCoordsForFaceOffFilter(VideoMaterialUtil.copyList(paramList), 2.0F), (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale), this.faceVertices));
    setCoordNum(690);
    if (this.item.blendMode == 13)
    {
      getAverageGreen(paramList, (int)(this.width * this.mFaceDetScale), (int)(this.height * this.mFaceDetScale));
      addParam(new m.f("level1", this.level1 / 255.0F));
      addParam(new m.f("level2", this.level2 / 255.0F));
    }
    float f1;
    float f3;
    float f4;
    float f5;
    float f6;
    float f7;
    float f8;
    float f9;
    if (this.item.blendMode == 14)
    {
      f1 = AlgoUtils.getDistance((PointF)paramList.get(35), (PointF)paramList.get(39));
      f3 = AlgoUtils.getDistance((PointF)paramList.get(45), (PointF)paramList.get(49));
      f4 = Math.max(((PointF)paramList.get(44)).x - ((PointF)paramList.get(43)).x, ((PointF)paramList.get(54)).x - ((PointF)paramList.get(53)).x);
      f4 = ((float)Math.pow(Math.abs(f4) / Math.max(f1, f3), 1.0D) * 20.0F + 1.0F) * f4;
      f1 = (float)((((PointF)paramList.get(44)).x + f4) / this.mFaceDetScale);
      f3 = (float)(((PointF)paramList.get(44)).y / this.mFaceDetScale);
      f4 = (float)((((PointF)paramList.get(54)).x + f4) / this.mFaceDetScale);
      f5 = (float)(((PointF)paramList.get(54)).y / this.mFaceDetScale);
      f6 = this.width;
      f7 = this.height;
      f8 = (float)(AlgoUtils.getDistance((PointF)paramList.get(39), (PointF)paramList.get(35)) / this.mFaceDetScale / 4.0D) * 0.9F;
      f9 = (float)(AlgoUtils.getDistance((PointF)paramList.get(49), (PointF)paramList.get(45)) / this.mFaceDetScale / 4.0D) * 0.9F;
      if (AlgoUtils.getDistance((PointF)paramList.get(41), (PointF)paramList.get(37)) / f8 >= 0.1F) {
        break label749;
      }
    }
    label738:
    label749:
    for (int i = 1;; i = 0)
    {
      if (AlgoUtils.getDistance((PointF)paramList.get(51), (PointF)paramList.get(47)) / f9 < 0.1F) {}
      for (;;)
      {
        addParam(new m.g("center1", new float[] { f1, f3 }));
        addParam(new m.g("center2", new float[] { f4, f5 }));
        addParam(new m.g("size", new float[] { f6, f7 }));
        addParam(new m.f("radius1", f8));
        addParam(new m.f("radius2", f9));
        if (i != 0)
        {
          f1 = 1.0F;
          addParam(new m.f("leftEyeClosed", f1));
          if (j == 0) {
            break label738;
          }
        }
        for (f1 = f2;; f1 = 0.0F)
        {
          addParam(new m.f("rightEyeClosed", f1));
          AppMethodBeat.o(82425);
          return;
          f1 = 0.0F;
          break;
        }
        j = 0;
      }
    }
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(82416);
    List localList = VideoMaterialUtil.copyList(paramPTDetectInfo.facePoints);
    updateActionTriggered(paramPTDetectInfo);
    this.triggered = this.triggerCtrlItem.isTriggered();
    if (!this.triggered)
    {
      this.lastIndex = -1;
      AppMethodBeat.o(82416);
      return;
    }
    updatePointParams(localList);
    updateTextureParams(paramPTDetectInfo.timestamp);
    AppMethodBeat.o(82416);
  }
  
  public void updateRandomGroupValue(int paramInt)
  {
    AppMethodBeat.i(82427);
    this.triggerCtrlItem.setRandomGroupValue(paramInt);
    AppMethodBeat.o(82427);
  }
  
  public void updateTextureParams(long paramLong)
  {
    AppMethodBeat.i(82422);
    if (!initGrayImage())
    {
      AppMethodBeat.o(82422);
      return;
    }
    if (this.sequenceMode)
    {
      this.triggerCtrlItem.updateFrameIndex(paramLong);
      int i = this.triggerCtrlItem.getFrameIndex();
      if (i == this.lastIndex)
      {
        AppMethodBeat.o(82422);
        return;
      }
      int j = getNextFrame(i);
      if (j <= 0)
      {
        AppMethodBeat.o(82422);
        return;
      }
      addParam(new m.n("inputImageTexture2", j, 33986));
      this.lastIndex = i;
      AppMethodBeat.o(82422);
      return;
    }
    initFaceImage();
    AppMethodBeat.o(82422);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    AppMethodBeat.i(82420);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
    AppMethodBeat.o(82420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.filter.FaceOffFilter
 * JD-Core Version:    0.7.0.1
 */