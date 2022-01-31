package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class VideoSurfaceView$3
  implements MediaPlayer.OnCompletionListener
{
  VideoSurfaceView$3(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (VideoSurfaceView.e(this.snx) != null)
    {
      VideoSurfaceView.e(this.snx).cv(VideoSurfaceView.g(this.snx).getCurrentPosition(), VideoSurfaceView.g(this.snx).getDuration());
      VideoSurfaceView.e(this.snx).ug();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.3
 * JD-Core Version:    0.7.0.1
 */