package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.m.b;
import com.tencent.filter.m.d;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.k;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import com.tencent.util.g;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DynamicNumFilter
  extends NormalVideoFilter
{
  private static final String TAG = NormalVideoFilter.class.getSimpleName();
  private Point canvasCenter;
  private long frameStartTime;
  private PointF mAnchor = new PointF();
  private float mAngle;
  private Map<String, Point> mBitSizeMap = new HashMap();
  private float[] mFaceAngles;
  private List<PointF> mFacePoints;
  private FaceRangeStatus mFaceStatus;
  private boolean mIsUnitExists = false;
  private int mLastBitIndex = -1;
  private Map<String, Integer> mLastImageIndexMap = new HashMap();
  private int mNum = -1;
  private AudioUtils.Player mPlayer;
  protected m.k mTextureParam;
  private long mTimestamp;
  protected int playCount = 0;
  protected boolean triggered = false;
  
  public DynamicNumFilter(StickerItem paramStickerItem, String paramString)
  {
    super(paramStickerItem, paramString);
  }
  
  private Bitmap getNextFrame(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("_").append(paramInt2).append("_");
    if (paramInt1 == -1) {}
    for (Object localObject = "x";; localObject = Integer.valueOf(paramInt1))
    {
      localObject = localObject + ".png";
      localObject = VideoMemoryManager.getInstance().loadImage(paramString, (String)localObject);
      if (!VideoBitmapUtil.isLegal((Bitmap)localObject)) {
        break;
      }
      return localObject;
    }
    return loadFromAssetsOrFile(paramString, paramInt1, paramInt2);
  }
  
  private int getTotalBit(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i > 0)
    {
      i /= 10;
      paramInt += 1;
    }
    return paramInt;
  }
  
  private Bitmap loadFromAssetsOrFile(String paramString, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(this.dataPath).append(File.separator).append(paramString).append(File.separator).append(paramString).append("_").append(paramInt2).append("_");
    if (paramInt1 == -1) {}
    for (paramString = "x";; paramString = Integer.valueOf(paramInt1))
    {
      paramString = paramString + ".png";
      if (!this.dataPath.startsWith("assets://")) {
        break;
      }
      return VideoBitmapUtil.decodeSampleBitmapFromAssets(VideoGlobalContext.getContext(), VideoUtil.getRealPath(paramString), MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
    }
    return VideoBitmapUtil.decodeSampledBitmapFromFile(paramString, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
  }
  
  private void updateNumPosition(String paramString, int paramInt1, int paramInt2)
  {
    PointF localPointF = (PointF)this.mFacePoints.get(this.item.alignFacePoints[0]);
    Object localObject = this.mFacePoints;
    int i;
    if (this.item.alignFacePoints.length == 1)
    {
      i = this.item.alignFacePoints[0];
      localObject = (PointF)((List)localObject).get(i);
      float f1 = (localPointF.x + ((PointF)localObject).x) / 2.0F;
      float f2 = ((PointF)localObject).y;
      localPointF = new PointF(f1, (((PointF)localObject).y + f2) / 2.0F);
      localPointF.x = ((float)(localPointF.x * (1.0D / this.mFaceDetScale)));
      localPointF.y = ((float)(localPointF.y * (1.0D / this.mFaceDetScale)));
      if (!this.mBitSizeMap.containsKey(paramString)) {
        break label735;
      }
      paramString = (Point)this.mBitSizeMap.get(paramString);
      label174:
      double d = this.item.height;
      i = (int)(paramString.x * 1.0D / paramString.y * d);
      int j = (this.item.width - paramInt2 * i) / 2;
      f1 = localPointF.x;
      f2 = this.item.anchorPoint[0];
      float f3 = (paramInt2 - paramInt1 - 1) * i;
      f1 = j + (f1 - f2 + f3);
      f2 = this.height - localPointF.y + this.item.anchorPoint[1];
      setPositions(AlgoUtils.calPositions(f1, f2, i + f1, f2 - this.item.height, this.width, this.height));
      addParam(new m.b("texAnchor", localPointF.x - this.canvasCenter.x, this.canvasCenter.y - localPointF.y));
      this.mAnchor.x = (localPointF.x - this.canvasCenter.x);
      this.mAnchor.y = (this.canvasCenter.y - localPointF.y);
      paramString = new PointF(((PointF)this.mFacePoints.get(this.item.scalePivots[0])).x, ((PointF)this.mFacePoints.get(this.item.scalePivots[0])).y);
      paramString.x = ((float)(paramString.x * (1.0D / this.mFaceDetScale)));
      paramString.y = ((float)(paramString.y * (1.0D / this.mFaceDetScale)));
      localPointF = new PointF(((PointF)this.mFacePoints.get(this.item.scalePivots[1])).x, ((PointF)this.mFacePoints.get(this.item.scalePivots[1])).y);
      localPointF.x = ((float)(localPointF.x * (1.0D / this.mFaceDetScale)));
      localPointF.y = ((float)(localPointF.y * (1.0D / this.mFaceDetScale)));
      d = Math.pow(paramString.x - localPointF.x, 2.0D);
      addParam(new m.f("texScale", (float)(Math.sqrt(Math.pow(paramString.y - localPointF.y, 2.0D) + d) / this.item.scaleFactor)));
      if (this.item.support3D != 1) {
        break label760;
      }
      addParam(new m.d("texRotate", this.mFaceAngles[0], this.mFaceAngles[1], this.mFaceAngles[2]));
    }
    for (;;)
    {
      addParam(new m.f("positionRotate", -this.mAngle));
      return;
      i = this.item.alignFacePoints[1];
      break;
      label735:
      paramString = new Point(this.item.width, this.item.height);
      break label174;
      label760:
      addParam(new m.d("texRotate", 0.0F, 0.0F, this.mFaceAngles[2]));
    }
  }
  
  private void updateTextureParam(String paramString, int paramInt1, FaceRangeStatus paramFaceRangeStatus, long paramLong, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder().append(paramString).append("_");
    if (paramInt1 == -1) {}
    int i;
    for (Object localObject = "x";; localObject = Integer.valueOf(paramInt1))
    {
      localObject = localObject;
      long l = this.frameStartTime;
      i = 0;
      if (this.item.frameType != 0) {
        break;
      }
      i = (int)((paramLong - l) / Math.max(this.item.frameDuration, 1.0D));
      if ((i >= this.item.frames * (this.playCount + 1)) && (!VideoPrefsUtil.getMaterialMute()))
      {
        this.playCount += 1;
        AudioUtils.startPlayer(this.mPlayer, true);
      }
      i %= Math.max(this.item.frames, 1);
      if ((paramInt2 != this.mLastBitIndex) || (!this.mLastImageIndexMap.containsKey(localObject)) || (i != ((Integer)this.mLastImageIndexMap.get(localObject)).intValue()) || (this.mTextureParam == null)) {
        break label488;
      }
      return;
    }
    paramInt2 = i;
    if (this.item.frameType == 1) {}
    label488:
    for (paramInt2 = (int)((VideoFilterUtil.getFaceStatus(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange) - this.item.featureStatValueRange.min) / ((this.item.featureStatValueRange.max - this.item.featureStatValueRange.min) / this.item.frames));; paramInt2 = i)
    {
      paramFaceRangeStatus = getNextFrame(paramString, paramInt1, paramInt2);
      if ((!VideoBitmapUtil.isLegal(paramFaceRangeStatus)) || (needClearTexture()))
      {
        clearTextureParam();
        return;
      }
      if (paramInt1 == -1) {
        this.mIsUnitExists = true;
      }
      if (!this.mBitSizeMap.containsKey(localObject)) {
        this.mBitSizeMap.put(localObject, new Point(paramFaceRangeStatus.getWidth(), paramFaceRangeStatus.getHeight()));
      }
      try
      {
        if (this.mTextureParam != null) {
          this.mTextureParam.g(paramFaceRangeStatus);
        }
        for (;;)
        {
          paramFaceRangeStatus = this.mLastImageIndexMap;
          localObject = new StringBuilder().append(paramString).append("_");
          if (paramInt1 != -1) {
            break;
          }
          paramString = "x";
          paramFaceRangeStatus.put(paramString, Integer.valueOf(paramInt2));
          return;
          this.mTextureParam = new m.k("inputImageTexture2", paramFaceRangeStatus, 33986, false);
          this.mTextureParam.initialParams(getProgramIds());
          addParam(this.mTextureParam);
        }
      }
      catch (Exception paramFaceRangeStatus)
      {
        for (;;)
        {
          g.i(this, paramFaceRangeStatus.getMessage());
          continue;
          paramString = Integer.valueOf(paramInt1);
        }
      }
    }
  }
  
  public void clearTextureParam()
  {
    if (this.mTextureParam != null)
    {
      this.mTextureParam.clear();
      this.mTextureParam = null;
    }
    setPositions(VideoFilterUtil.EMPTY_POSITIONS);
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    AudioUtils.destroyPlayer(this.mPlayer);
  }
  
  public void destroyAudio()
  {
    AudioUtils.destroyPlayer(this.mPlayer);
    this.mPlayer = null;
  }
  
  public float getFrameDuration(long paramLong)
  {
    if (!this.triggered) {
      return 0.0F;
    }
    return (float)((paramLong - this.frameStartTime) / 1000.0D);
  }
  
  public void initParams()
  {
    addParam(new m.i("texNeedTransform", 1));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.b("texAnchor", 0.0F, 0.0F));
    addParam(new m.f("texScale", 1.0F));
    addParam(new m.d("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new m.f("positionRotate", 0.0F));
    addParam(new m.i("blendMode", this.item.blendMode));
    addParam(new m.j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
  }
  
  public boolean isRenderReady()
  {
    return this.mNum >= 0;
  }
  
  protected boolean needClearTexture()
  {
    return (this.item.triggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) && ((!this.triggered) || ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)));
  }
  
  public boolean renderTexture(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    int m = 0;
    int j = 0;
    if ((VideoUtil.isEmpty(this.mFacePoints)) || (this.mFaceAngles == null) || (this.mFaceAngles.length < 3) || (this.mFaceStatus == null) || (this.mNum < 0)) {
      return true;
    }
    int n = getTotalBit(this.mNum);
    updateTextureParam(this.item.id, -1, this.mFaceStatus, this.mTimestamp, 0);
    int i = n;
    if (this.mIsUnitExists)
    {
      i = n + 1;
      updateNumPosition(this.item.id + "_x", 0, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = 0;
    }
    if (this.mNum < 10)
    {
      if (this.mIsUnitExists) {
        j = 1;
      }
      updateTextureParam(this.item.id, this.mNum, this.mFaceStatus, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + this.mNum, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      return true;
    }
    if ((10 <= this.mNum) && (this.mNum < 100))
    {
      j = k;
      if (this.mIsUnitExists) {
        j = 1;
      }
      k = this.mNum % 10;
      updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + k, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      j += 1;
      k = this.mNum / 10;
      updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
      updateNumPosition(this.item.id + "_" + k, j, i);
      OnDrawFrameGLSL();
      super.renderTexture(paramInt1, paramInt2, paramInt3);
      this.mLastBitIndex = j;
      return true;
    }
    j = m;
    if (this.mIsUnitExists) {
      j = 1;
    }
    k = this.mNum % 10;
    updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
    updateNumPosition(this.item.id + "_" + k, j, i);
    OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
    this.mLastBitIndex = j;
    j += 1;
    k = this.mNum / 10 % 10;
    updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
    updateNumPosition(this.item.id + "_" + k, j, i);
    OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
    this.mLastBitIndex = j;
    j += 1;
    k = this.mNum / 100;
    updateTextureParam(this.item.id, k, this.mFaceStatus, this.mTimestamp, j);
    updateNumPosition(this.item.id + "_" + k, j, i);
    OnDrawFrameGLSL();
    super.renderTexture(paramInt1, paramInt2, paramInt3);
    this.mLastBitIndex = j;
    return true;
  }
  
  public void setNum(int paramInt)
  {
    this.mNum = paramInt;
  }
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  protected void updateActionTriggered(Map<Integer, FaceActionCounter> paramMap, FaceRangeStatus paramFaceRangeStatus, Set<Integer> paramSet, long paramLong)
  {
    if ((this.item != null) && (paramSet.contains(Integer.valueOf(this.item.triggerType))) && (VideoFilterUtil.isStatusTriggered(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange)))
    {
      if (this.triggered) {
        break label272;
      }
      this.frameStartTime = paramLong;
    }
    label272:
    for (boolean bool = true;; bool = false)
    {
      this.triggered = true;
      if ((this.item != null) && (!TextUtils.isEmpty(this.dataPath)) && (!TextUtils.isEmpty(this.item.id)) && (!TextUtils.isEmpty(this.item.audio)))
      {
        if ((this.mPlayer == null) && (!VideoPrefsUtil.getMaterialMute()))
        {
          paramMap = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
          if (!paramMap.startsWith("assets://")) {
            break label217;
          }
          this.mPlayer = AudioUtils.createPlayerFromAssets(VideoGlobalContext.getContext(), paramMap.replace("assets://", ""), false);
        }
        if (!VideoPrefsUtil.getMaterialMute()) {
          break label232;
        }
        AudioUtils.stopPlayer(this.mPlayer);
      }
      label217:
      label232:
      do
      {
        return;
        this.mPlayer = AudioUtils.createPlayerFromUri(VideoGlobalContext.getContext(), paramMap, false);
        break;
        AudioUtils.startPlayer(this.mPlayer, bool);
        return;
      } while ((this.item == null) || (!this.item.alwaysTriggered));
      this.triggered = false;
      AudioUtils.stopPlayer(this.mPlayer);
      return;
    }
  }
  
  protected void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    if ((VideoUtil.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramArrayOfFloat.length < 3))
    {
      clearTextureParam();
      this.mFacePoints = null;
      this.mFaceAngles = null;
      this.mAngle = 0.0F;
      this.mNum = -1;
      return;
    }
    this.mFacePoints = paramList;
    this.mFaceAngles = paramArrayOfFloat;
    this.mAngle = paramFloat;
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    paramList2 = VideoPreviewFaceOutlineDetector.getInstance().detectFaceRangeStatus(paramList1);
    updateActionTriggered(paramMap, paramList2, paramSet, paramLong);
    if (needClearTexture())
    {
      clearTextureParam();
      this.triggered = false;
      this.playCount = 0;
      this.mFaceStatus = null;
      this.mTimestamp = -1L;
      this.mNum = -1;
      return;
    }
    this.mFaceStatus = paramList2;
    this.mTimestamp = paramLong;
    updatePositions(paramList1, paramArrayOfFloat, paramFloat);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    this.canvasCenter = new Point(paramInt1 / 2, paramInt2 / 2);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.filter.DynamicNumFilter
 * JD-Core Version:    0.7.0.1
 */