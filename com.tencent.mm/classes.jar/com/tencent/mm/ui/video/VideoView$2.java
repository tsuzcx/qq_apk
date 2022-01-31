package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class VideoView$2
  implements MediaPlayer.OnPreparedListener
{
  VideoView$2(VideoView paramVideoView) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    VideoView.c(this.wiD);
    if (VideoView.d(this.wiD) != null) {
      VideoView.d(this.wiD).onPrepared(VideoView.e(this.wiD));
    }
    VideoView.a(this.wiD, paramMediaPlayer.getVideoWidth());
    VideoView.b(this.wiD, paramMediaPlayer.getVideoHeight());
    this.wiD.cJL();
    if ((VideoView.a(this.wiD) != 0) && (VideoView.b(this.wiD) != 0))
    {
      if (VideoView.f(this.wiD))
      {
        VideoView.e(this.wiD).start();
        VideoView.g(this.wiD);
      }
      if ((VideoView.h(this.wiD) == VideoView.a(this.wiD)) && (VideoView.i(this.wiD) == VideoView.b(this.wiD)))
      {
        if (VideoView.j(this.wiD) != 0)
        {
          VideoView.e(this.wiD).seekTo(VideoView.j(this.wiD));
          VideoView.k(this.wiD);
        }
        if ((VideoView.f(this.wiD)) || (this.wiD.isPlaying()) || (VideoView.j(this.wiD) != 0) || (this.wiD.getCurrentPosition() <= 0)) {}
      }
    }
    for (;;)
    {
      VideoView.e(this.wiD).isPlaying();
      return;
      if (VideoView.j(this.wiD) != 0)
      {
        VideoView.e(this.wiD).seekTo(VideoView.j(this.wiD));
        VideoView.k(this.wiD);
      }
      if (VideoView.f(this.wiD))
      {
        VideoView.e(this.wiD).start();
        VideoView.g(this.wiD);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.2
 * JD-Core Version:    0.7.0.1
 */