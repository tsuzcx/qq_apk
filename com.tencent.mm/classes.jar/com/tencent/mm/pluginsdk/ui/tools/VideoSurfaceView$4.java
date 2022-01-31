package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSurfaceView$4
  implements MediaPlayer.OnErrorListener
{
  VideoSurfaceView$4(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.VideoSurfaceView", "Error: " + paramInt1 + "," + paramInt2);
    if (VideoSurfaceView.e(this.snx) != null) {
      VideoSurfaceView.e(this.snx).onError(paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.4
 * JD-Core Version:    0.7.0.1
 */