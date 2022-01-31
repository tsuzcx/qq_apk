package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.m.i;
import com.tencent.filter.m.n;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetectorManager;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AudioUtils;
import com.tencent.ttpic.util.AudioUtils.Player;
import com.tencent.ttpic.util.VideoBitmapUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class NormalVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = NormalVideoFilter.class.getSimpleName();
  protected long frameStartTime;
  protected boolean isImageReady;
  protected StickerItem item;
  private int lastImageIndex = -1;
  private AudioUtils.Player mPlayer;
  private int mRandomGroupValue;
  protected ActVideoDecoder mVideoDecoder;
  protected final String materialId;
  protected int playCount = 0;
  private int[] tex = new int[1];
  protected boolean triggered = false;
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL);
    this.item = paramStickerItem;
    this.dataPath = paramString;
    this.materialId = VideoMaterialUtil.getMaterialId(paramString);
    setStickerItem(paramStickerItem);
    initParams();
    initAudio();
  }
  
  private int getFrameIndex(FaceRangeStatus paramFaceRangeStatus, long paramLong)
  {
    if (!this.triggered) {
      this.frameStartTime = paramLong;
    }
    long l = this.frameStartTime;
    int i = 0;
    if (this.item.frameType == 0)
    {
      i = (int)((paramLong - l) / Math.max(this.item.frameDuration, 1.0D));
      if (i >= this.item.frames * (this.playCount + 1)) {
        this.playCount += 1;
      }
      i %= Math.max(this.item.frames, 1);
    }
    while (this.item.frameType != 1) {
      return i;
    }
    return (int)((VideoFilterUtil.getFaceStatus(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange) - this.item.featureStatValueRange.min) / ((this.item.featureStatValueRange.max - this.item.featureStatValueRange.min) / this.item.frames));
  }
  
  private int getNextFrame(int paramInt)
  {
    if (VideoMaterialUtil.isEmptyItem(this.item)) {
      return this.tex[0];
    }
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.mVideoDecoder != null))
    {
      this.mVideoDecoder.decodeFrame(paramInt);
      if (this.mVideoDecoder.updateFrame()) {
        this.isImageReady = true;
      }
      this.lastImageIndex = paramInt;
    }
    label236:
    for (;;)
    {
      return this.tex[0];
      if (this.tex[0] != 0)
      {
        Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
        if ((localObject == null) && ((!this.isImageReady) || (this.mIsRenderForBitmap)))
        {
          localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
          localObject = VideoBitmapUtil.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        }
        for (int i = 1;; i = 0)
        {
          if (!VideoBitmapUtil.isLegal((Bitmap)localObject)) {
            break label236;
          }
          GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
          if (i != 0) {
            ((Bitmap)localObject).recycle();
          }
          this.isImageReady = true;
          this.lastImageIndex = paramInt;
          break;
        }
      }
    }
  }
  
  private void initAudio()
  {
    if (this.mPlayer != null) {}
    while ((this.item == null) || (TextUtils.isEmpty(this.dataPath)) || (TextUtils.isEmpty(this.item.id)) || (TextUtils.isEmpty(this.item.audio))) {
      return;
    }
    String str = this.dataPath + File.separator + this.item.id + File.separator + this.item.audio;
    if (str.startsWith("assets://"))
    {
      this.mPlayer = AudioUtils.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);
      return;
    }
    this.mPlayer = AudioUtils.createPlayerFromUri(VideoGlobalContext.getContext(), str, false);
  }
  
  private boolean isFullScreenRender(AttributeParam paramAttributeParam)
  {
    if (paramAttributeParam == null) {
      return false;
    }
    paramAttributeParam = paramAttributeParam.vertices;
    int j = paramAttributeParam.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label52;
      }
      float f = paramAttributeParam[i];
      if ((Float.compare(-1.0F, f) != 0) && (Float.compare(1.0F, f) != 0)) {
        break;
      }
      i += 1;
    }
    label52:
    return true;
  }
  
  private boolean isRandomGroupValueHit()
  {
    if (this.item.randomGroupNum == 0) {}
    while (this.mRandomGroupValue == this.item.randomGroupNum) {
      return true;
    }
    return false;
  }
  
  private boolean isRangeValueHit()
  {
    return ((this.item.charmRange == null) || (this.item.charmRange.isHit())) && ((this.item.ageRange == null) || (this.item.ageRange.isHit())) && ((this.item.genderRange == null) || (this.item.genderRange.isHit())) && ((this.item.popularRange == null) || (this.item.popularRange.isHit())) && ((this.item.cpRange == null) || (this.item.cpRange.isHit()));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GLES20.glGenTextures(this.tex.length, this.tex, 0);
    if (this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) {
      this.mVideoDecoder = new ActVideoDecoder(this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + ".mp4", this.tex[0]);
    }
  }
  
  public boolean canUseBlendMode()
  {
    return (this.item.blendMode < 2) || (this.item.blendMode > 12);
  }
  
  public void clearGLSLSelf()
  {
    int i = 0;
    super.clearGLSLSelf();
    GLES20.glDeleteTextures(this.tex.length, this.tex, 0);
    try
    {
      while (i < this.tex.length)
      {
        this.tex[i] = 0;
        i += 1;
      }
      if (this.mVideoDecoder != null)
      {
        this.mVideoDecoder.release();
        this.mVideoDecoder = null;
      }
      return;
    }
    finally {}
  }
  
  protected void clearTextureParam()
  {
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
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
  }
  
  public StickerItem getStickerItem()
  {
    return this.item;
  }
  
  public void initParams()
  {
    addParam(new m.i("blendMode", this.item.blendMode));
    addParam(new m.n("inputImageTexture2", 0, 33986));
  }
  
  public boolean isRenderReady()
  {
    return (this.triggered) && (this.isImageReady);
  }
  
  public boolean needCopyTex()
  {
    if (this.item == null) {}
    while ((this.item.blendMode < 2) || (this.item.blendMode > 12)) {
      return false;
    }
    return true;
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable) {}
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  protected void updateActionTriggered(Map<Integer, FaceActionCounter> paramMap, FaceRangeStatus paramFaceRangeStatus, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (this.item == null) {
      return;
    }
    boolean bool3;
    label92:
    int i;
    label125:
    int j;
    if (this.item.activateTriggerTotalCount != 0)
    {
      if ((this.item.preTriggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) && ((!VideoMaterialUtil.isFaceTriggerType(this.item.preTriggerType)) || (!paramSet.contains(Integer.valueOf(this.item.preTriggerType))))) {
        break label542;
      }
      bool3 = VideoMaterialUtil.isFaceTriggerType(this.item.countTriggerType);
      if (bool3)
      {
        paramFaceRangeStatus = paramMap;
        if (paramFaceRangeStatus == null) {
          break label542;
        }
        if (!bool3) {
          break label302;
        }
        i = ((FaceActionCounter)paramMap.get(Integer.valueOf(this.item.countTriggerType))).count;
        if (i % this.item.activateTriggerTotalCount != this.item.activateTriggerCount) {
          break label542;
        }
        if ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)) {
          break label329;
        }
        j = 1;
        label172:
        if (this.playCount >= this.item.playCount) {
          break label335;
        }
        i = j;
        if (bool3)
        {
          FaceDetectorManager.getInstance().getCurrentFaceDetector().lockActionCounter();
          i = j;
        }
      }
    }
    for (;;)
    {
      if ((i != 0) && (isRangeValueHit()) && (isRandomGroupValueHit()))
      {
        i = 1;
        label230:
        if (i == 0) {
          break label478;
        }
        if (!this.triggered)
        {
          this.frameStartTime = paramLong;
          bool1 = true;
        }
        this.triggered = true;
        label256:
        if ((VideoPrefsUtil.getMaterialMute()) || (!this.triggered)) {
          break label528;
        }
        initAudio();
        if (this.item.audioLoopCount <= 0) {
          break label518;
        }
        if (!bool1) {
          break;
        }
        AudioUtils.startPlayer(this.mPlayer, true);
        return;
        paramFaceRangeStatus = paramMap1;
        break label92;
        label302:
        i = ((HandActionCounter)paramMap1.get(Integer.valueOf(this.item.countTriggerType))).count;
        break label125;
        label329:
        j = 0;
        break label172;
        label335:
        i = j;
        if (this.item.playCount <= 0) {
          continue;
        }
        i = j;
        if (!bool3) {
          continue;
        }
        FaceDetectorManager.getInstance().getCurrentFaceDetector().clearActionCounter();
        i = j;
        continue;
        if (VideoMaterialUtil.isFaceTriggerType(this.item.triggerType))
        {
          if (paramSet == null) {
            break label536;
          }
          if ((paramSet.contains(Integer.valueOf(this.item.triggerType))) && (VideoFilterUtil.isStatusTriggered(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange))) {
            i = 1;
          }
        }
      }
      for (;;)
      {
        if ((i != 0) || (this.mIsRenderForBitmap))
        {
          i = 1;
          break;
          i = 0;
          continue;
          i = 0;
          continue;
        }
        i = 0;
        break;
        i = 0;
        break label230;
        label478:
        if (!this.item.alwaysTriggered)
        {
          bool1 = bool2;
          if (this.playCount < this.item.playCount) {
            break label256;
          }
        }
        this.triggered = false;
        bool1 = bool2;
        break label256;
        label518:
        AudioUtils.startPlayer(this.mPlayer, bool1);
        return;
        label528:
        AudioUtils.stopPlayer(this.mPlayer);
        return;
        label536:
        i = 0;
      }
      label542:
      i = 0;
    }
  }
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat);
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    FaceRangeStatus localFaceRangeStatus = VideoPreviewFaceOutlineDetector.getInstance().detectFaceRangeStatus(paramList1);
    int i = getFrameIndex(localFaceRangeStatus, paramLong);
    updateActionTriggered(paramMap, localFaceRangeStatus, paramMap1, paramSet, paramLong);
    if (!needRenderTexture())
    {
      clearTextureParam();
      this.playCount = 0;
      VideoMemoryManager.getInstance().reset(this.item.id);
      updateTextureParam(0, paramLong);
      return;
    }
    if (!VideoMaterialUtil.isGestureItem(this.item)) {
      updatePositions(paramList1, paramArrayOfFloat, paramFloat);
    }
    for (;;)
    {
      updateTextureParam(i, paramLong);
      return;
      updatePositions(paramList2, paramArrayOfFloat, paramFloat);
    }
  }
  
  public void updateRandomGroupValue(int paramInt)
  {
    this.mRandomGroupValue = paramInt;
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (paramInt == this.lastImageIndex) {
      return;
    }
    if ((this.lastImageIndex > paramInt) && (this.mVideoDecoder != null)) {
      this.mVideoDecoder.reset();
    }
    addParam(new m.n("inputImageTexture2", getNextFrame(paramInt), 33986));
  }
  
  public void updateTextureParam(long paramLong)
  {
    int i = getFrameIndex(null, paramLong);
    try
    {
      updateTextureParam(i, paramLong);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.NormalVideoFilter
 * JD-Core Version:    0.7.0.1
 */