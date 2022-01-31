package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.sdk.platformtools.y;

final class VideoRecorderUI$3
  implements SurfaceHolder.Callback
{
  VideoRecorderUI$3(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    y.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + paramInt1 + " w:" + paramInt2 + " h:" + paramInt3);
    if (VideoRecorderUI.h(this.pzG).b(paramSurfaceHolder) != 0) {
      VideoRecorderUI.s(this.pzG);
    }
    VideoRecorderUI.a(this.pzG, false);
    VideoRecorderUI.b(this.pzG, false);
    VideoRecorderUI.x(this.pzG);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    y.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
    if (VideoRecorderUI.h(this.pzG).a(this.pzG, VideoRecorderUI.q(this.pzG)) != 0) {
      VideoRecorderUI.s(this.pzG);
    }
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    y.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
    VideoRecorderUI.b(this.pzG, true);
    VideoRecorderUI.h(this.pzG).clT();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.3
 * JD-Core Version:    0.7.0.1
 */