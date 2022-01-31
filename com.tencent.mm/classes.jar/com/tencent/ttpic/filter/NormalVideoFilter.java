package com.tencent.ttpic.filter;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.opengl.ETC1Util.ETC1Texture;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.filter.m.b;
import com.tencent.filter.m.d;
import com.tencent.filter.m.f;
import com.tencent.filter.m.i;
import com.tencent.filter.m.j;
import com.tencent.filter.m.n;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.config.MediaConfig;
import com.tencent.ttpic.gles.AttributeParam;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.recorder.ActVideoDecoder;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.MatrixUtil;
import com.tencent.ttpic.util.PlayerUtil;
import com.tencent.ttpic.util.PlayerUtil.Player;
import com.tencent.ttpic.util.VideoFilterFactory.STICKER_TYPE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.ITEM_SOURCE_TYPE;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.io.File;
import java.util.List;

public abstract class NormalVideoFilter
  extends VideoFilterBase
{
  private static final String TAG = NormalVideoFilter.class.getSimpleName();
  protected boolean isImageReady;
  protected StickerItem item;
  private int lastImageIndex = -1;
  private boolean mAudioPause;
  private boolean mHasBodyDetected = false;
  private boolean mHasSeenValid = false;
  private PlayerUtil.Player mPlayer;
  public List<PointF> mPreviousBodyPoints = null;
  private long mPreviousLostTime = System.currentTimeMillis();
  private long mTimesForLostProtect = 2000L;
  protected ActVideoDecoder mVideoDecoder;
  private int[] tex = new int[2];
  protected TriggerCtrlItem triggerCtrlItem;
  protected boolean triggered = false;
  
  public NormalVideoFilter(StickerItem paramStickerItem, String paramString)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.STICKER_NORMAL);
    this.item = paramStickerItem;
    this.dataPath = paramString;
    this.triggerCtrlItem = new TriggerCtrlItem(paramStickerItem);
    initParams();
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
      }
      else {
        return;
      }
      this.mHasSeenValid = false;
      this.mPreviousBodyPoints = null;
      return;
    }
    this.mHasBodyDetected = true;
    this.mHasSeenValid = true;
    this.mPreviousLostTime = System.currentTimeMillis();
    this.mPreviousBodyPoints = paramPTDetectInfo.bodyPoints;
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
    label250:
    for (;;)
    {
      return this.tex[0];
      if (this.tex[0] != 0)
      {
        Object localObject = VideoMemoryManager.getInstance().loadImage(this.item.id, paramInt);
        if ((localObject == null) && ((!this.isImageReady) || (this.triggerCtrlItem.isRenderForBitmap())))
        {
          localObject = this.dataPath + File.separator + this.item.subFolder + File.separator + this.item.id + "_" + paramInt + ".png";
          localObject = BitmapUtils.decodeSampleBitmap(VideoGlobalContext.getContext(), (String)localObject, MediaConfig.VIDEO_OUTPUT_WIDTH, MediaConfig.VIDEO_OUTPUT_HEIGHT);
        }
        for (int i = 1;; i = 0)
        {
          if (!BitmapUtils.isLegal((Bitmap)localObject)) {
            break label250;
          }
          BenchUtil.benchStart("normal loadTexture");
          GlUtil.loadTexture(this.tex[0], (Bitmap)localObject);
          BenchUtil.benchEnd("normal loadTexture");
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
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    GlUtil.createEtcTexture(this.tex);
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
    setPositions(GlUtil.EMPTY_POSITIONS);
  }
  
  public void destroy()
  {
    clearGLSLSelf();
    destroyAudio();
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
    return (float)((paramLong - this.triggerCtrlItem.getFrameStartTime()) / 1000.0D);
  }
  
  public int getLastFrameIndex()
  {
    return this.lastImageIndex;
  }
  
  public StickerItem getStickerItem()
  {
    return this.item;
  }
  
  protected int getTextureId()
  {
    return this.tex[0];
  }
  
  public void initParams()
  {
    addParam(new m.i("blendMode", this.item.blendMode));
    addParam(new m.n("inputImageTexture2", 0, 33986));
    addParam(new m.n("inputImageTexture3", 0, 33987));
    addParam(new m.i("texNeedTransform", 1));
    addParam(new m.b("canvasSize", 0.0F, 0.0F));
    addParam(new m.b("texAnchor", 0.0F, 0.0F));
    addParam(new m.f("texScale", 1.0F));
    addParam(new m.d("texRotate", 0.0F, 0.0F, 0.0F));
    addParam(new m.j("u_MVPMatrix", MatrixUtil.getMVPMatrix(6.0F, 4.0F, 10.0F)));
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
  
  boolean needLoadImage()
  {
    return this.item.stickerType != VideoFilterFactory.STICKER_TYPE.FACE_FEATURE.type;
  }
  
  public boolean needRenderTexture()
  {
    return this.triggered;
  }
  
  public void reset()
  {
    this.mHasBodyDetected = false;
    this.mHasSeenValid = false;
    this.mPreviousBodyPoints = null;
    this.triggerCtrlItem.reset();
  }
  
  public void setAudioPause(boolean paramBoolean)
  {
    this.mAudioPause = paramBoolean;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    this.triggerCtrlItem.setRenderForBitmap(paramBoolean);
  }
  
  public void setTriggerWords(String paramString)
  {
    TriggerCtrlItem localTriggerCtrlItem = this.triggerCtrlItem;
    String str = paramString;
    if (this.item != null)
    {
      str = paramString;
      if (!TextUtils.isEmpty(this.item.triggerWords)) {
        str = this.item.triggerWords;
      }
    }
    localTriggerCtrlItem.setTriggerWords(str);
  }
  
  protected TRIGGERED_STATUS updateActionTriggered(PTDetectInfo paramPTDetectInfo)
  {
    return this.triggerCtrlItem.getTriggeredStatus(paramPTDetectInfo);
  }
  
  protected void updatePlayer(boolean paramBoolean)
  {
    this.triggered = this.triggerCtrlItem.isTriggered();
    if (!this.triggered) {
      destroyAudio();
    }
    do
    {
      return;
      if ((VideoPrefsUtil.getMaterialMute()) || (this.mAudioPause)) {
        break label72;
      }
      initAudio();
      if (this.item.audioLoopCount <= 0) {
        break;
      }
    } while (!paramBoolean);
    PlayerUtil.startPlayer(this.mPlayer, true);
    return;
    PlayerUtil.startPlayer(this.mPlayer, paramBoolean);
    return;
    label72:
    PlayerUtil.stopPlayer(this.mPlayer);
  }
  
  protected void updatePositions(List<PointF> paramList) {}
  
  protected abstract void updatePositions(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat);
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    if (VideoMaterialUtil.isBodyDetectItem(this.item)) {
      avoidBodyPointsShake(paramPTDetectInfo);
    }
    if (updateActionTriggered(paramPTDetectInfo) == TRIGGERED_STATUS.FIRST_TRIGGERED) {}
    int i;
    for (boolean bool = true;; bool = false)
    {
      updatePlayer(bool);
      i = this.triggerCtrlItem.getFrameIndex();
      if (needRenderTexture()) {
        break;
      }
      clearTextureParam();
      VideoMemoryManager.getInstance().reset(this.item.id);
      updateTextureParam(0, paramPTDetectInfo.timestamp);
      return;
    }
    if (VideoMaterialUtil.isGestureItem(this.item)) {
      updatePositions(paramPTDetectInfo.handPoints, paramPTDetectInfo.faceAngles, paramPTDetectInfo.phoneAngle);
    }
    for (;;)
    {
      updateTextureParam(i, paramPTDetectInfo.timestamp);
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
        updatePositions(paramPTDetectInfo.facePoints, paramPTDetectInfo.faceAngles, paramPTDetectInfo.phoneAngle);
      }
    }
  }
  
  public void updateRandomGroupValue(int paramInt)
  {
    this.triggerCtrlItem.setRandomGroupValue(paramInt);
  }
  
  public void updateTextureParam(int paramInt)
  {
    if (needLoadImage()) {
      return;
    }
    addParam(new m.n("inputImageTexture2", paramInt, 33986));
    this.isImageReady = true;
  }
  
  protected void updateTextureParam(int paramInt, long paramLong)
  {
    if (!needLoadImage()) {}
    ETC1Util.ETC1Texture localETC1Texture1;
    ETC1Util.ETC1Texture localETC1Texture2;
    do
    {
      do
      {
        return;
      } while (paramInt == this.lastImageIndex);
      if ((this.lastImageIndex > paramInt) && (this.mVideoDecoder != null)) {
        this.mVideoDecoder.reset();
      }
      if (this.item.stickerType != VideoFilterFactory.STICKER_TYPE.ETC.type) {
        break;
      }
      localETC1Texture1 = VideoMemoryManager.getInstance().loadETCRGBTexture(this.item.id, paramInt);
      localETC1Texture2 = VideoMemoryManager.getInstance().loadETCAlphaTexture(this.item.id, paramInt);
    } while ((localETC1Texture1 == null) || (localETC1Texture2 == null));
    BenchUtil.benchStart("mPkmReader loadTexture");
    GlUtil.loadTexture(this.tex[0], localETC1Texture1);
    GlUtil.loadTexture(this.tex[1], localETC1Texture2);
    BenchUtil.benchEnd("mPkmReader loadTexture");
    addParam(new m.n("inputImageTexture2", this.tex[0], 33986));
    addParam(new m.n("inputImageTexture3", this.tex[1], 33987));
    this.isImageReady = true;
    this.lastImageIndex = paramInt;
    return;
    addParam(new m.n("inputImageTexture2", getNextFrame(paramInt), 33986));
  }
  
  public void updateTextureParam(long paramLong)
  {
    this.triggerCtrlItem.updateFrameIndex(paramLong);
    int i = this.triggerCtrlItem.getFrameIndex();
    try
    {
      updateTextureParam(i, paramLong);
      return;
    }
    finally {}
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.b("canvasSize", paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.ttpic.filter.NormalVideoFilter
 * JD-Core Version:    0.7.0.1
 */