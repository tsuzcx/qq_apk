package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class VideoSurfaceView$3
  implements MediaPlayer.OnCompletionListener
{
  VideoSurfaceView$3(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(116296);
    if (VideoSurfaceView.e(this.Ryc) != null)
    {
      VideoSurfaceView.e(this.Ryc).fE(VideoSurfaceView.g(this.Ryc).getCurrentPosition(), VideoSurfaceView.g(this.Ryc).getDuration());
      VideoSurfaceView.e(this.Ryc).onCompletion();
    }
    AppMethodBeat.o(116296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */