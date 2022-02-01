package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;)V", "TAG", "currentEmojiFrame", "Landroid/graphics/Bitmap;", "getCurrentEmojiFrame", "()Landroid/graphics/Bitmap;", "setCurrentEmojiFrame", "(Landroid/graphics/Bitmap;)V", "currentEmojiFrameDuration", "", "getCurrentEmojiFrameDuration", "()J", "setCurrentEmojiFrameDuration", "(J)V", "currentEmojiFrameStartTime", "", "getCurrentEmojiFrameStartTime", "()F", "setCurrentEmojiFrameStartTime", "(F)V", "emojiPassDuration", "getEmojiPassDuration", "setEmojiPassDuration", "targetFrameCount", "", "getTargetFrameCount", "()I", "setTargetFrameCount", "(I)V", "targetFrameDuration", "getTargetFrameDuration", "setTargetFrameDuration", "targetFrameRate", "getTargetFrameRate", "setTargetFrameRate", "targetPassDuration", "getTargetPassDuration", "setTargetPassDuration", "targetPassFrame", "getTargetPassFrame", "setTargetPassFrame", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoFrameDuration", "getVideoFrameDuration", "setVideoFrameDuration", "videoFrameFps", "getVideoFrameFps", "setVideoFrameFps", "videoPassDuration", "getVideoPassDuration", "setVideoPassDuration", "videoPassFrame", "getVideoPassFrame", "setVideoPassFrame", "frameDuration", "needSkipFrame", "", "syncMixNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "framePass", "NextFrameInfo", "plugin-recordvideo_release"})
public class g
{
  private int Iae;
  public int Iaf;
  private float Iag;
  public Bitmap Iah;
  public float Iai;
  private int Iaj;
  public int Iak;
  private int Ial;
  public float Iam;
  public float Ian;
  public float Iao;
  public float Iap;
  public final com.tencent.mm.plugin.recordvideo.ui.editor.b.b Iaq;
  public final String TAG;
  private int videoDuration;
  private int videoFrameCount;
  
  public g(String paramString, com.tencent.mm.plugin.recordvideo.ui.editor.b.b paramb)
  {
    AppMethodBeat.i(216662);
    this.Iaq = paramb;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.Iag = -1.0F;
    paramString = f.aYg(paramString);
    if ((paramString instanceof com.tencent.mm.plugin.sight.base.b))
    {
      this.Iae = paramString.frameRate;
      this.videoDuration = paramString.videoDuration;
      this.Iam = (1000.0F / paramString.frameRate);
      this.videoFrameCount = ((int)(this.Iae * (this.videoDuration / 1000.0D)));
    }
    for (;;)
    {
      this.Ial = this.Iae;
      this.Iao = this.Iam;
      this.Iaj = this.videoFrameCount;
      this.Iak = 0;
      AppMethodBeat.o(216662);
      return;
      this.videoFrameCount = 0;
      this.Iae = 0;
      this.Iam = 0.0F;
      this.videoDuration = 0;
    }
  }
  
  protected final void acE(int paramInt)
  {
    this.Iaj = paramInt;
  }
  
  protected final void acF(int paramInt)
  {
    this.Ial = paramInt;
  }
  
  protected final int fyv()
  {
    return this.videoFrameCount;
  }
  
  protected final int fyw()
  {
    return this.Iae;
  }
  
  protected final int fyx()
  {
    return this.Iaj;
  }
  
  protected final int fyy()
  {
    return this.Ial;
  }
  
  protected final int getVideoDuration()
  {
    return this.videoDuration;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.g
 * JD-Core Version:    0.7.0.1
 */