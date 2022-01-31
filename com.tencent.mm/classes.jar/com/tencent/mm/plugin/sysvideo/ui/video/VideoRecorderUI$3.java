package com.tencent.mm.plugin.sysvideo.ui.video;

import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.b;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoRecorderUI$3
  implements SurfaceHolder.Callback
{
  VideoRecorderUI$3(VideoRecorderUI paramVideoRecorderUI) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25647);
    ab.d("MicroMsg.VideoRecorderUI", "surfaceChanged for:" + paramInt1 + " w:" + paramInt2 + " h:" + paramInt3);
    if (VideoRecorderUI.h(this.tbs).b(paramSurfaceHolder) != 0) {
      VideoRecorderUI.s(this.tbs);
    }
    VideoRecorderUI.a(this.tbs, false);
    VideoRecorderUI.b(this.tbs, false);
    VideoRecorderUI.x(this.tbs);
    AppMethodBeat.o(25647);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(25645);
    ab.d("MicroMsg.VideoRecorderUI", "surfaceCreated");
    if (VideoRecorderUI.h(this.tbs).b(this.tbs, VideoRecorderUI.q(this.tbs)) != 0) {
      VideoRecorderUI.s(this.tbs);
    }
    AppMethodBeat.o(25645);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(25646);
    ab.d("MicroMsg.VideoRecorderUI", "surfaceDestroyed");
    VideoRecorderUI.b(this.tbs, true);
    VideoRecorderUI.h(this.tbs).dmH();
    AppMethodBeat.o(25646);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI.3
 * JD-Core Version:    0.7.0.1
 */