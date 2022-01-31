package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class VideoView$3
  implements MediaPlayer.OnCompletionListener
{
  VideoView$3(VideoView paramVideoView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (VideoView.l(this.wiD) != null) {
      VideoView.l(this.wiD).onCompletion(VideoView.e(this.wiD));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.3
 * JD-Core Version:    0.7.0.1
 */