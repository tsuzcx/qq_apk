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
    AppMethodBeat.i(70442);
    if (VideoSurfaceView.e(this.wfS) != null)
    {
      VideoSurfaceView.e(this.wfS).dP(VideoSurfaceView.g(this.wfS).getCurrentPosition(), VideoSurfaceView.g(this.wfS).getDuration());
      VideoSurfaceView.e(this.wfS).Es();
    }
    AppMethodBeat.o(70442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */