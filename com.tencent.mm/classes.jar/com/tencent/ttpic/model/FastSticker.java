package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.facedetect.FaceDetector;
import com.tencent.ttpic.facedetect.FaceDetectorManager;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.recorder.ActVideoDecoder;
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

public abstract class FastSticker
{
  protected String dataPath;
  protected long frameStartTime;
  protected int height;
  protected boolean isImageReady;
  protected StickerItem item;
  private int lastImageIndex = -1;
  protected boolean mIsRenderForBitmap = false;
  private AudioUtils.Player mPlayer;
  protected double mScreenScale;
  protected ActVideoDecoder mVideoDecoder;
  protected int playCount = 0;
  protected RenderParam renderParam = new RenderParam();
  private int[] tex = new int[1];
  protected boolean triggered = false;
  protected int width;
  
  FastSticker(StickerItem paramStickerItem, String paramString)
  {
    this.item = paramStickerItem;
    this.dataPath = paramString;
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
    if ((this.item.sourceType != VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE) && (this.mVideoDecoder != null))
    {
      this.mVideoDecoder.decodeFrame(paramInt);
      this.mVideoDecoder.updateFrame();
      this.isImageReady = true;
      this.lastImageIndex = paramInt;
    }
    label207:
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
            break label207;
          }
          GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
          if (i == 0) {
            break;
          }
          ((Bitmap)localObject).recycle();
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
        break label51;
      }
      float f = paramAttributeParam[i];
      if ((Float.compare(-1.0F, f) != 0) && (Float.compare(1.0F, f) != 0)) {
        break;
      }
      i += 1;
    }
    label51:
    return true;
  }
  
  private boolean isRangeValueHit()
  {
    return ((this.item.charmRange == null) || (this.item.charmRange.isHit())) && ((this.item.ageRange == null) || (this.item.ageRange.isHit())) && ((this.item.genderRange == null) || (this.item.genderRange.isHit())) && ((this.item.popularRange == null) || (this.item.popularRange.isHit())) && ((this.item.cpRange == null) || (this.item.cpRange.isHit()));
  }
  
  public void ApplyGLSLFilter()
  {
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
    this.renderParam.position = VideoFilterUtil.EMPTY_POSITIONS_TRIANGLES;
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
  
  public RenderParam getRenderParam()
  {
    return this.renderParam;
  }
  
  public int getTexture()
  {
    return this.tex[0];
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
  
  public boolean needRender(int paramInt)
  {
    if ((this.item.personID != -1) && (this.item.personID != paramInt)) {}
    while ((!this.triggered) || (!this.isImageReady)) {
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
        break label524;
      }
      bool3 = VideoMaterialUtil.isFaceTriggerType(this.item.countTriggerType);
      if (bool3)
      {
        paramFaceRangeStatus = paramMap;
        if (paramFaceRangeStatus == null) {
          break label524;
        }
        if (!bool3) {
          break label295;
        }
        i = ((FaceActionCounter)paramMap.get(Integer.valueOf(this.item.countTriggerType))).count;
        if (i % this.item.activateTriggerTotalCount != this.item.activateTriggerCount) {
          break label524;
        }
        if ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)) {
          break label322;
        }
        j = 1;
        label172:
        if (this.playCount >= this.item.playCount) {
          break label328;
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
      label208:
      if ((i != 0) && (isRangeValueHit()))
      {
        i = 1;
        label223:
        if (i == 0) {
          break label466;
        }
        if (!this.triggered)
        {
          this.frameStartTime = paramLong;
          bool1 = true;
        }
        this.triggered = true;
      }
      for (;;)
      {
        if ((!VideoPrefsUtil.getMaterialMute()) && (this.triggered))
        {
          initAudio();
          if (this.item.audioLoopCount > 0)
          {
            if (!bool1) {
              break;
            }
            AudioUtils.startPlayer(this.mPlayer, true);
            return;
            paramFaceRangeStatus = paramMap1;
            break label92;
            label295:
            i = ((HandActionCounter)paramMap1.get(Integer.valueOf(this.item.countTriggerType))).count;
            break label125;
            label322:
            j = 0;
            break label172;
            label328:
            i = j;
            if (this.item.playCount <= 0) {
              break label208;
            }
            i = j;
            if (!bool3) {
              break label208;
            }
            FaceDetectorManager.getInstance().getCurrentFaceDetector().clearActionCounter();
            i = j;
            break label208;
            if (VideoMaterialUtil.isFaceTriggerType(this.item.triggerType)) {
              if ((paramSet.contains(Integer.valueOf(this.item.triggerType))) && (VideoFilterUtil.isStatusTriggered(paramFaceRangeStatus, this.item.featureStatType, this.item.featureStatValueRange))) {
                i = 1;
              }
            }
            for (;;)
            {
              if ((i == 0) && (!this.mIsRenderForBitmap)) {
                break label454;
              }
              i = 1;
              break;
              i = 0;
              continue;
              i = 0;
            }
            label454:
            i = 0;
            break label208;
            i = 0;
            break label223;
            label466:
            if (!this.item.alwaysTriggered)
            {
              bool1 = bool2;
              if (this.playCount < this.item.playCount) {
                continue;
              }
            }
            this.triggered = false;
            bool1 = bool2;
            continue;
          }
          AudioUtils.startPlayer(this.mPlayer, bool1);
          return;
        }
      }
      AudioUtils.stopPlayer(this.mPlayer);
      return;
      label524:
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
      updatePositions(paramList2, new float[] { 0.0F, 0.0F, 0.0F }, paramFloat);
    }
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (paramInt == this.lastImageIndex) {
      return;
    }
    if ((this.lastImageIndex > paramInt) && (this.mVideoDecoder != null)) {
      this.mVideoDecoder.reset();
    }
    this.renderParam.texture = getNextFrame(paramInt);
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
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    this.width = paramInt1;
    this.height = paramInt2;
    this.mScreenScale = paramDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.model.FastSticker
 * JD-Core Version:    0.7.0.1
 */