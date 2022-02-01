package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.b;
import com.tencent.mm.plugin.sight.base.a;
import com.tencent.mm.plugin.sight.base.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr;", "", "videoPath", "", "emojiFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameRetriever;)V", "TAG", "currentEmojiFrame", "Landroid/graphics/Bitmap;", "getCurrentEmojiFrame", "()Landroid/graphics/Bitmap;", "setCurrentEmojiFrame", "(Landroid/graphics/Bitmap;)V", "currentEmojiFrameDuration", "", "getCurrentEmojiFrameDuration", "()J", "setCurrentEmojiFrameDuration", "(J)V", "currentEmojiFrameStartTime", "", "getCurrentEmojiFrameStartTime", "()F", "setCurrentEmojiFrameStartTime", "(F)V", "emojiPassDuration", "getEmojiPassDuration", "setEmojiPassDuration", "targetFrameCount", "", "getTargetFrameCount", "()I", "setTargetFrameCount", "(I)V", "targetFrameDuration", "getTargetFrameDuration", "setTargetFrameDuration", "targetFrameRate", "getTargetFrameRate", "setTargetFrameRate", "targetPassDuration", "getTargetPassDuration", "setTargetPassDuration", "targetPassFrame", "getTargetPassFrame", "setTargetPassFrame", "videoDuration", "getVideoDuration", "setVideoDuration", "videoFrameCount", "getVideoFrameCount", "setVideoFrameCount", "videoFrameDuration", "getVideoFrameDuration", "setVideoFrameDuration", "videoFrameFps", "getVideoFrameFps", "setVideoFrameFps", "videoPassDuration", "getVideoPassDuration", "setVideoPassDuration", "videoPassFrame", "getVideoPassFrame", "setVideoPassFrame", "frameDuration", "needSkipFrame", "", "syncMixNextFrame", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/MixFrameSyncMgr$NextFrameInfo;", "framePass", "NextFrameInfo", "plugin-recordvideo_release"})
public class g
{
  public final String TAG;
  protected int videoDuration;
  protected int videoFrameCount;
  protected int xMS;
  public int xMT;
  private float xMU;
  public Bitmap xMV;
  public float xMW;
  protected int xMX;
  public int xMY;
  protected int xMZ;
  public float xNa;
  public float xNb;
  public float xNc;
  public float xNd;
  public final b xNe;
  
  public g(String paramString, b paramb)
  {
    AppMethodBeat.i(200643);
    this.xNe = paramb;
    this.TAG = "MicroMsg.MixFrameSyncMgr";
    this.xMU = -1.0F;
    paramString = e.axx(paramString);
    if ((paramString instanceof a))
    {
      this.xMS = paramString.frameRate;
      this.videoDuration = paramString.videoDuration;
      this.xNa = (1000.0F / paramString.frameRate);
      this.videoFrameCount = ((int)(this.xMS * (this.videoDuration / 1000.0D)));
    }
    for (;;)
    {
      this.xMZ = this.xMS;
      this.xNc = this.xNa;
      this.xMX = this.videoFrameCount;
      this.xMY = 0;
      AppMethodBeat.o(200643);
      return;
      this.videoFrameCount = 0;
      this.xMS = 0;
      this.xNa = 0.0F;
      this.videoDuration = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.g
 * JD-Core Version:    0.7.0.1
 */