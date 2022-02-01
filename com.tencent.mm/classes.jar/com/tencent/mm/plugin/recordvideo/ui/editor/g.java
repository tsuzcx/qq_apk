package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.b;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;)V", "TAG", "currentEmojiFrame", "Landroid/graphics/Bitmap;", "getCurrentEmojiFrame", "()Landroid/graphics/Bitmap;", "setCurrentEmojiFrame", "(Landroid/graphics/Bitmap;)V", "currentEmojiFrameDuration", "", "getCurrentEmojiFrameDuration", "()J", "setCurrentEmojiFrameDuration", "(J)V", "currentEmojiFrameStartTime", "", "getCurrentEmojiFrameStartTime", "()F", "setCurrentEmojiFrameStartTime", "(F)V", "emojiPassDuration", "getEmojiPassDuration", "setEmojiPassDuration", "targetFrameCount", "", "getTargetFrameCount", "()I", "setTargetFrameCount", "(I)V", "targetFrameDuration", "getTargetFrameDuration", "setTargetFrameDuration", "targetFrameRate", "getTargetFrameRate", "setTargetFrameRate", "targetPassDuration", "getTargetPassDuration", "setTargetPassDuration", "targetPassFrame", "getTargetPassFrame", "setTargetPassFrame", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoFrameDuration", "getVideoFrameDuration", "setVideoFrameDuration", "videoFrameFps", "getVideoFrameFps", "setVideoFrameFps", "videoPassDuration", "getVideoPassDuration", "setVideoPassDuration", "videoPassFrame", "getVideoPassFrame", "setVideoPassFrame", "frameDuration", "needSkipFrame", "", "syncMixNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "framePass", "NextFrameInfo", "plugin-recordvideo_release"})
public class g
{
  protected int CdO;
  public int CdP;
  private float CdQ;
  public Bitmap CdR;
  public float CdS;
  protected int CdT;
  public int CdU;
  protected int CdV;
  public float CdW;
  public float CdX;
  public float CdY;
  public float CdZ;
  public final b Cea;
  public final String TAG;
  protected int videoDuration;
  protected int videoFrameCount;
  
  public g(String paramString, b paramb)
  {
    AppMethodBeat.i(237737);
    this.Cea = paramb;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.CdQ = -1.0F;
    paramString = e.aNx(paramString);
    if ((paramString instanceof a))
    {
      this.CdO = paramString.frameRate;
      this.videoDuration = paramString.videoDuration;
      this.CdW = (1000.0F / paramString.frameRate);
      this.videoFrameCount = ((int)(this.CdO * (this.videoDuration / 1000.0D)));
    }
    for (;;)
    {
      this.CdV = this.CdO;
      this.CdY = this.CdW;
      this.CdT = this.videoFrameCount;
      this.CdU = 0;
      AppMethodBeat.o(237737);
      return;
      this.videoFrameCount = 0;
      this.CdO = 0;
      this.CdW = 0.0F;
      this.videoDuration = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.g
 * JD-Core Version:    0.7.0.1
 */