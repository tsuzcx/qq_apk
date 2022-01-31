package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoSurfaceView$5
  implements SurfaceHolder.Callback
{
  VideoSurfaceView$5(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(70444);
    ab.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((VideoSurfaceView.g(this.wfS) != null) && (VideoSurfaceView.i(this.wfS)) && (VideoSurfaceView.a(this.wfS) == paramInt2) && (VideoSurfaceView.b(this.wfS) == paramInt3)) {
      VideoSurfaceView.g(this.wfS).start();
    }
    AppMethodBeat.o(70444);
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(70445);
    ab.i("MicroMsg.VideoSurfaceView", "on surface created");
    VideoSurfaceView.a(this.wfS, paramSurfaceHolder);
    VideoSurfaceView.j(this.wfS);
    AppMethodBeat.o(70445);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(70446);
    ab.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
    VideoSurfaceView.a(this.wfS, null);
    if (VideoSurfaceView.g(this.wfS) != null)
    {
      VideoSurfaceView.e(this.wfS).dP(VideoSurfaceView.g(this.wfS).getCurrentPosition(), VideoSurfaceView.g(this.wfS).getDuration());
      VideoSurfaceView.g(this.wfS).reset();
      VideoSurfaceView.g(this.wfS).release();
      VideoSurfaceView.k(this.wfS);
    }
    AppMethodBeat.o(70446);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */