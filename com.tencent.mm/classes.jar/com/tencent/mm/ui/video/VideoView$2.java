package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoView$2
  implements MediaPlayer.OnPreparedListener
{
  VideoView$2(VideoView paramVideoView) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(35284);
    VideoView.c(this.ABv);
    if (VideoView.d(this.ABv) != null) {
      VideoView.d(this.ABv).onPrepared(VideoView.e(this.ABv));
    }
    VideoView.a(this.ABv, paramMediaPlayer.getVideoWidth());
    VideoView.b(this.ABv, paramMediaPlayer.getVideoHeight());
    this.ABv.dOA();
    if ((VideoView.a(this.ABv) != 0) && (VideoView.b(this.ABv) != 0))
    {
      if (VideoView.f(this.ABv))
      {
        VideoView.e(this.ABv).start();
        VideoView.g(this.ABv);
      }
      if ((VideoView.h(this.ABv) == VideoView.a(this.ABv)) && (VideoView.i(this.ABv) == VideoView.b(this.ABv)))
      {
        if (VideoView.j(this.ABv) != 0)
        {
          VideoView.e(this.ABv).seekTo(VideoView.j(this.ABv));
          VideoView.k(this.ABv);
        }
        if ((VideoView.f(this.ABv)) || (this.ABv.isPlaying()) || (VideoView.j(this.ABv) != 0) || (this.ABv.getCurrentPosition() <= 0)) {}
      }
    }
    for (;;)
    {
      if ((VideoView.e(this.ABv).isPlaying()) && (VideoView.l(this.ABv) != null))
      {
        VideoView.l(this.ABv);
        VideoView.m(this.ABv);
      }
      AppMethodBeat.o(35284);
      return;
      if (VideoView.j(this.ABv) != 0)
      {
        VideoView.e(this.ABv).seekTo(VideoView.j(this.ABv));
        VideoView.k(this.ABv);
      }
      if (VideoView.f(this.ABv))
      {
        VideoView.e(this.ABv).start();
        VideoView.g(this.ABv);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.2
 * JD-Core Version:    0.7.0.1
 */