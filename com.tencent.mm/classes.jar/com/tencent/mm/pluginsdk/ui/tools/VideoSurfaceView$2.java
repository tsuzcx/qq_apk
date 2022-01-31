package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoSurfaceView$2
  implements MediaPlayer.OnPreparedListener
{
  VideoSurfaceView$2(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(70441);
    VideoSurfaceView.d(this.wfS);
    if (VideoSurfaceView.e(this.wfS) != null) {
      VideoSurfaceView.e(this.wfS).mG();
    }
    VideoSurfaceView.a(this.wfS, paramMediaPlayer.getVideoWidth());
    VideoSurfaceView.b(this.wfS, paramMediaPlayer.getVideoHeight());
    VideoSurfaceView.c(this.wfS);
    if ((VideoSurfaceView.a(this.wfS) != 0) && (VideoSurfaceView.b(this.wfS) != 0))
    {
      if (VideoSurfaceView.f(this.wfS))
      {
        VideoSurfaceView.g(this.wfS).start();
        VideoSurfaceView.h(this.wfS);
        AppMethodBeat.o(70441);
      }
    }
    else if (VideoSurfaceView.f(this.wfS))
    {
      VideoSurfaceView.g(this.wfS).start();
      VideoSurfaceView.h(this.wfS);
    }
    AppMethodBeat.o(70441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.2
 * JD-Core Version:    0.7.0.1
 */