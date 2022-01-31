package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSurfaceView$5
  implements SurfaceHolder.Callback
{
  VideoSurfaceView$5(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((VideoSurfaceView.g(this.snx) != null) && (VideoSurfaceView.i(this.snx)) && (VideoSurfaceView.a(this.snx) == paramInt2) && (VideoSurfaceView.b(this.snx) == paramInt3)) {
      VideoSurfaceView.g(this.snx).start();
    }
  }
  
  public final void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    y.i("MicroMsg.VideoSurfaceView", "on surface created");
    VideoSurfaceView.a(this.snx, paramSurfaceHolder);
    VideoSurfaceView.j(this.snx);
  }
  
  public final void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    y.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
    VideoSurfaceView.a(this.snx, null);
    if (VideoSurfaceView.g(this.snx) != null)
    {
      VideoSurfaceView.e(this.snx).cv(VideoSurfaceView.g(this.snx).getCurrentPosition(), VideoSurfaceView.g(this.snx).getDuration());
      VideoSurfaceView.g(this.snx).reset();
      VideoSurfaceView.g(this.snx).release();
      VideoSurfaceView.k(this.snx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.5
 * JD-Core Version:    0.7.0.1
 */