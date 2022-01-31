package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import com.tencent.ttpic.util.youtu.GestureDetector;
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
  private boolean mAudioPause;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  protected boolean mIsRenderForBitmap = false;
  private PlayerUtil.Player mPlayer;
  public List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  protected double mScreenScale;
  private long mTimesForLostProtect = 2000L;
  protected ActVideoDecoder mVideoDecoder;
  protected int playCount = 0;
  protected RenderParam renderParam = new RenderParam();
  private int[] tex = new int[1];
  protected TriggerCtrlItem triggerCtrlItem;
  protected boolean triggered = false;
  protected int width;
  
  FastSticker(StickerItem paramStickerItem, String paramString)
  {
    this.item = paramStickerItem;
    this.dataPath = paramString;
    this.renderParam.id = paramStickerItem.id;
    this.triggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
    initAudio();
  }
  
  private void avoidBodyPointsShake(PTDetectInfo paramPTDetectInfo)
  {
    if ((paramPTDetectInfo.bodyPoints == null) || (paramPTDetectInfo.bodyPoints.isEmpty()))
    {
      this.mHasBodyDetected = false;
      if (this.mHasSeenValid)
      {
        if (System.currentTimeMillis() - this.mPreviousLostTime < this.mTimesForLostProtect) {
          paramPTDetectInfo.bodyPoints = this.mPreviousBodyPoints;
        }
        return;
      }
      this.mHasSeenValid = false;
      return;
    }
    this.mHasBodyDetected = true;
    this.mHasSeenValid = true;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
  }
  
  private int getFrameIndex(long paramLong)
  {
    if (!this.triggered) {
      this.frameStartTime = paramLong;
    }
    int i = (int)((paramLong - this.frameStartTime) / Math.max(this.item.frameDuration, 1.0D));
    if (i >= this.item.frames * (this.playCount + 1)) {
      this.playCount += 1;
    }
    return i % Math.max(this.item.frames, 1);
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
          localObject = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        }
        for (int i = 1;; i = 0)
        {
          if (!BitmapUtils.isLegal((Bitmap)localObject)) {
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
      this.mPlayer = PlayerUtil.createPlayerFromAssets(VideoGlobalContext.getContext(), str.replace("assets://", ""), false);
      return;
    }
    this.mPlayer = PlayerUtil.createPlayerFromUri(VideoGlobalContext.getContext(), str, false);
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
    this.renderParam.position = GlUtil.EMPTY_POSITIONS_TRIANGLES;
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    PlayerUtil.destroyPlayer(this.mPlayer);
  }
  
  public void destroyAudio()
  {
    PlayerUtil.destroyPlayer(this.mPlayer);
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
  
  public void reset()
  {
    this.triggered = false;
    this.playCount = 0;
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mPreviousBodyPoints = null;
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setBitmapDrawable(BitmapDrawable paramBitmapDrawable) {}
  
  public void setStickerItem(StickerItem paramStickerItem)
  {
    this.item = paramStickerItem;
  }
  
  protected void updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (this.item == null) {
      return;
    }
    Map localMap1 = paramPTDetectInfo.faceActionCounter;
    Map localMap2 = paramPTDetectInfo.handActionCounter;
    Object localObject = paramPTDetectInfo.triggeredExpression;
    List localList = paramPTDetectInfo.bodyPoints;
    this.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
    boolean bool1;
    label127:
    int i;
    if (this.item.activateTriggerTotalCount != 0)
    {
      label141:
      label180:
      int j;
      if (this.item.preTriggerType != PTFaceAttr.PTExpression.ALWAYS.value)
      {
        if (VideoMaterialUtil.isFaceTriggerType(this.item.preTriggerType)) {
          if (!((Set)localObject).contains(Integer.valueOf(this.item.preTriggerType))) {
            break label325;
          }
        }
      }
      else
      {
        bool1 = VideoMaterialUtil.isFaceTriggerType(this.item.countTriggerType);
        if (!bool1) {
          break label330;
        }
        localObject = localMap1;
        if (localObject == null) {
          break label325;
        }
        if (!bool1) {
          break label337;
        }
        localObject = localMap1;
        if (((Map)localObject).size() == 0) {
          break label325;
        }
        if (!bool1) {
          break label344;
        }
        i = ((FaceActionCounter)localMap1.get(Integer.valueOf(this.item.countTriggerType))).count;
        if (i % this.item.activateTriggerTotalCount != this.item.activateTriggerCount) {
          break label325;
        }
        if ((this.item.playCount != 0) && (this.playCount >= this.item.playCount)) {
          break label371;
        }
        j = 1;
        label225:
        if (this.playCount >= this.item.playCount) {
          break label387;
        }
        if (!bool1) {
          break label376;
        }
        paramPTDetectInfo.faceDetector.lockActionCounter();
        i = j;
      }
      for (;;)
      {
        label253:
        if ((i == 0) || (!isRangeValueHit())) {
          break label539;
        }
        i = 1;
        label266:
        if (i == 0) {
          break label544;
        }
        bool1 = bool3;
        if (!this.triggered)
        {
          this.frameStartTime = paramPTDetectInfo.timestamp;
          bool1 = true;
        }
        this.triggered = true;
        label297:
        if (this.triggered) {
          break label584;
        }
        destroyAudio();
        return;
        if (GestureDetector.getInstance().isGestureTriggered(this.item.preTriggerType)) {
          break;
        }
        label325:
        i = 0;
        continue;
        label330:
        localObject = localMap2;
        break label127;
        label337:
        localObject = localMap2;
        break label141;
        label344:
        i = ((HandActionCounter)localMap2.get(Integer.valueOf(this.item.countTriggerType))).count;
        break label180;
        label371:
        j = 0;
        break label225;
        label376:
        GestureDetector.getInstance().lockActionCounter();
        i = j;
        continue;
        label387:
        i = j;
        if (this.item.playCount > 0) {
          if (bool1)
          {
            paramPTDetectInfo.faceDetector.clearActionCounter();
            i = j;
          }
          else
          {
            GestureDetector.getInstance().clearActionCounter();
            i = j;
          }
        }
      }
    }
    if (VideoMaterialUtil.isFaceTriggerType(this.item.triggerType)) {
      bool1 = ((Set)localObject).contains(Integer.valueOf(this.item.triggerType));
    }
    for (;;)
    {
      if ((bool1) || (this.mIsRenderForBitmap))
      {
        i = 1;
        break label253;
        if (VideoMaterialUtil.isBodyDetectType(this.item.triggerType))
        {
          if (localList == null)
          {
            bool1 = true;
            continue;
          }
          if (localList.isEmpty()) {
            break label643;
          }
          bool1 = true;
          continue;
        }
        bool1 = GestureDetector.getInstance().isGestureTriggered(this.item.triggerType);
        continue;
      }
      i = 0;
      break label253;
      label539:
      i = 0;
      break label266;
      label544:
      if (!this.item.alwaysTriggered)
      {
        bool1 = bool2;
        if (this.playCount < this.item.playCount) {
          break label297;
        }
      }
      this.triggered = false;
      bool1 = bool2;
      break label297;
      label584:
      if ((!VideoPrefsUtil.getMaterialMute()) && (!this.mAudioPause))
      {
        initAudio();
        if (this.item.audioLoopCount > 0)
        {
          if (!bool1) {
            break;
          }
          PlayerUtil.startPlayer(this.mPlayer, true);
          return;
        }
        PlayerUtil.startPlayer(this.mPlayer, bool1);
        return;
      }
      PlayerUtil.stopPlayer(this.mPlayer);
      return;
      label643:
      bool1 = false;
    }
  }
  
  protected abstract void updatePositions(List<PointF> paramList);
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat);
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
      avoidBodyPointsShake(paramPTDetectInfo);
    }
    int i = getFrameIndex(paramPTDetectInfo.timestamp);
    updateActionTriggered(paramPTDetectInfo);
    if (!needRenderTexture())
    {
      clearTextureParam();
      this.playCount = 0;
      VideoMemoryManager.getInstance().reset(this.item.id);
      updateTextureParam(0);
      return;
    }
    if (VideoMaterialUtil.isFaceItem(this.item)) {
      updatePositions(paramPTDetectInfo.facePoints, paramPTDetectInfo.faceAngles);
    }
    for (;;)
    {
      updateTextureParam(i);
      return;
      if (VideoMaterialUtil.isBodyDetectItem(this.item))
      {
        updatePositions(paramPTDetectInfo.bodyPoints);
        if (!this.mHasBodyDetected) {
          paramPTDetectInfo.bodyPoints = null;
        }
      }
      else
      {
        updatePositions(paramPTDetectInfo.handPoints, new float[] { 0.0F, 0.0F, 0.0F });
      }
    }
  }
  
  protected void updateTextureParam(int paramInt)
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
    int i = getFrameIndex(paramLong);
    try
    {
      updateTextureParam(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.ttpic.model.FastSticker
 * JD-Core Version:    0.7.0.1
 */