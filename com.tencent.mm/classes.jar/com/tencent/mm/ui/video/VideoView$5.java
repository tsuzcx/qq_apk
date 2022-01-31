package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoView$5
  implements MediaPlayer.OnBufferingUpdateListener
{
  VideoView$5(VideoView paramVideoView) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    AppMethodBeat.i(35287);
    VideoView.c(this.ABv, paramInt);
    AppMethodBeat.o(35287);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.5
 * JD-Core Version:    0.7.0.1
 */