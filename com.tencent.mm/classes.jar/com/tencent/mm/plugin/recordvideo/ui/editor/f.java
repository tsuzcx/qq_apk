package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;)V", "TAG", "currentEmojiFrame", "Landroid/graphics/Bitmap;", "getCurrentEmojiFrame", "()Landroid/graphics/Bitmap;", "setCurrentEmojiFrame", "(Landroid/graphics/Bitmap;)V", "currentEmojiFrameDuration", "", "getCurrentEmojiFrameDuration", "()J", "setCurrentEmojiFrameDuration", "(J)V", "currentEmojiFrameStartTime", "", "getCurrentEmojiFrameStartTime", "()F", "setCurrentEmojiFrameStartTime", "(F)V", "emojiPassDuration", "getEmojiPassDuration", "setEmojiPassDuration", "targetFrameCount", "", "getTargetFrameCount", "()I", "setTargetFrameCount", "(I)V", "targetFrameDuration", "getTargetFrameDuration", "setTargetFrameDuration", "targetFrameRate", "getTargetFrameRate", "setTargetFrameRate", "targetPassDuration", "getTargetPassDuration", "setTargetPassDuration", "targetPassFrame", "getTargetPassFrame", "setTargetPassFrame", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoFrameDuration", "getVideoFrameDuration", "setVideoFrameDuration", "videoFrameFps", "getVideoFrameFps", "setVideoFrameFps", "videoPassDuration", "getVideoPassDuration", "setVideoPassDuration", "videoPassFrame", "getVideoPassFrame", "setVideoPassFrame", "frameDuration", "needSkipFrame", "", "syncMixNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "framePass", "NextFrameInfo", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public class f
{
  public final com.tencent.mm.plugin.recordvideo.ui.editor.b.b NWG;
  private int NWH;
  public int NWI;
  private float NWJ;
  public Bitmap NWK;
  public float NWL;
  private int NWM;
  public int NWN;
  private int NWO;
  public float NWP;
  public float NWQ;
  public float NWR;
  public float NWS;
  public final String TAG;
  private int videoDuration;
  private int videoFrameCount;
  
  public f(String paramString, com.tencent.mm.plugin.recordvideo.ui.editor.b.b paramb)
  {
    AppMethodBeat.i(279876);
    this.NWG = paramb;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.NWJ = -1.0F;
    paramString = com.tencent.mm.plugin.sight.base.f.aVX(paramString);
    if (paramString != null)
    {
      this.NWH = paramString.frameRate;
      this.videoDuration = paramString.videoDuration;
      this.NWP = (1000.0F / paramString.frameRate);
      this.videoFrameCount = ((int)(this.NWH * (this.videoDuration / 1000.0D)));
    }
    for (;;)
    {
      this.NWO = this.NWH;
      this.NWR = this.NWP;
      this.NWM = this.videoFrameCount;
      this.NWN = 0;
      AppMethodBeat.o(279876);
      return;
      this.videoFrameCount = 0;
      this.NWH = 0;
      this.NWP = 0.0F;
      this.videoDuration = 0;
    }
  }
  
  protected final void agU(int paramInt)
  {
    this.NWM = paramInt;
  }
  
  protected final void agV(int paramInt)
  {
    this.NWO = paramInt;
  }
  
  protected final int gKh()
  {
    return this.NWH;
  }
  
  protected final int gKi()
  {
    return this.NWM;
  }
  
  protected final int gKj()
  {
    return this.NWO;
  }
  
  protected final int getVideoDuration()
  {
    return this.videoDuration;
  }
  
  protected final int getVideoFrameCount()
  {
    return this.videoFrameCount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.f
 * JD-Core Version:    0.7.0.1
 */