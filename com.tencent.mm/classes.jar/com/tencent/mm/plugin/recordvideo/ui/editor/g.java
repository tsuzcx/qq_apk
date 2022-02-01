package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.b;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;)V", "TAG", "currentEmojiFrame", "Landroid/graphics/Bitmap;", "getCurrentEmojiFrame", "()Landroid/graphics/Bitmap;", "setCurrentEmojiFrame", "(Landroid/graphics/Bitmap;)V", "currentEmojiFrameDuration", "", "getCurrentEmojiFrameDuration", "()J", "setCurrentEmojiFrameDuration", "(J)V", "currentEmojiFrameStartTime", "", "getCurrentEmojiFrameStartTime", "()F", "setCurrentEmojiFrameStartTime", "(F)V", "emojiPassDuration", "getEmojiPassDuration", "setEmojiPassDuration", "targetFrameCount", "", "getTargetFrameCount", "()I", "setTargetFrameCount", "(I)V", "targetFrameDuration", "getTargetFrameDuration", "setTargetFrameDuration", "targetFrameRate", "getTargetFrameRate", "setTargetFrameRate", "targetPassDuration", "getTargetPassDuration", "setTargetPassDuration", "targetPassFrame", "getTargetPassFrame", "setTargetPassFrame", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoFrameDuration", "getVideoFrameDuration", "setVideoFrameDuration", "videoFrameFps", "getVideoFrameFps", "setVideoFrameFps", "videoPassDuration", "getVideoPassDuration", "setVideoPassDuration", "videoPassFrame", "getVideoPassFrame", "setVideoPassFrame", "frameDuration", "needSkipFrame", "", "syncMixNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "framePass", "NextFrameInfo", "plugin-recordvideo_release"})
public class g
{
  public final String TAG;
  protected int videoDuration;
  protected int videoFrameCount;
  protected int ycM;
  public int ycN;
  private float ycO;
  public Bitmap ycP;
  public float ycQ;
  protected int ycR;
  public int ycS;
  protected int ycT;
  public float ycU;
  public float ycV;
  public float ycW;
  public float ycX;
  public final b ycY;
  
  public g(String paramString, b paramb)
  {
    AppMethodBeat.i(206901);
    this.ycY = paramb;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.ycO = -1.0F;
    paramString = e.ayN(paramString);
    if ((paramString instanceof a))
    {
      this.ycM = paramString.frameRate;
      this.videoDuration = paramString.videoDuration;
      this.ycU = (1000.0F / paramString.frameRate);
      this.videoFrameCount = ((int)(this.ycM * (this.videoDuration / 1000.0D)));
    }
    for (;;)
    {
      this.ycT = this.ycM;
      this.ycW = this.ycU;
      this.ycR = this.videoFrameCount;
      this.ycS = 0;
      AppMethodBeat.o(206901);
      return;
      this.videoFrameCount = 0;
      this.ycM = 0;
      this.ycU = 0.0F;
      this.videoDuration = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.g
 * JD-Core Version:    0.7.0.1
 */