package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class VideoSurfaceView$2
  implements MediaPlayer.OnPreparedListener
{
  VideoSurfaceView$2(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    VideoSurfaceView.d(this.snx);
    if (VideoSurfaceView.e(this.snx) != null) {
      VideoSurfaceView.e(this.snx).kA();
    }
    VideoSurfaceView.a(this.snx, paramMediaPlayer.getVideoWidth());
    VideoSurfaceView.b(this.snx, paramMediaPlayer.getVideoHeight());
    VideoSurfaceView.c(this.snx);
    if ((VideoSurfaceView.a(this.snx) != 0) && (VideoSurfaceView.b(this.snx) != 0)) {
      if (VideoSurfaceView.f(this.snx))
      {
        VideoSurfaceView.g(this.snx).start();
        VideoSurfaceView.h(this.snx);
      }
    }
    while (!VideoSurfaceView.f(this.snx)) {
      return;
    }
    VideoSurfaceView.g(this.snx).start();
    VideoSurfaceView.h(this.snx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */