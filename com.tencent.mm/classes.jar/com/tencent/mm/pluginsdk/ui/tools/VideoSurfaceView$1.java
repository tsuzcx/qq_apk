package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoSurfaceView$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoSurfaceView$1(VideoSurfaceView paramVideoSurfaceView) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VideoSurfaceView.a(this.snx, paramMediaPlayer.getVideoWidth());
    VideoSurfaceView.b(this.snx, paramMediaPlayer.getVideoHeight());
    y.v("MicroMsg.VideoSurfaceView", "on size change size:( " + VideoSurfaceView.a(this.snx) + " , " + VideoSurfaceView.b(this.snx) + " )");
    VideoSurfaceView.c(this.snx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */