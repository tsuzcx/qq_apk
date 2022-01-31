package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;

final class VideoView$5
  implements MediaPlayer.OnBufferingUpdateListener
{
  VideoView$5(VideoView paramVideoView) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    VideoView.c(this.wiD, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.5
 * JD-Core Version:    0.7.0.1
 */