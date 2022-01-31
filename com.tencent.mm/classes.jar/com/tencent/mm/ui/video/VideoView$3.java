package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoView$3
  implements MediaPlayer.OnCompletionListener
{
  VideoView$3(VideoView paramVideoView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(35285);
    if (VideoView.n(this.ABv) != null) {
      VideoView.n(this.ABv).onCompletion(VideoView.e(this.ABv));
    }
    AppMethodBeat.o(35285);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.3
 * JD-Core Version:    0.7.0.1
 */