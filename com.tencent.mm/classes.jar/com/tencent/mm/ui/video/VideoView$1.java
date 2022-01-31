package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoView$1
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoView$1(VideoView paramVideoView) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    VideoView.a(this.wiD, paramMediaPlayer.getVideoWidth());
    VideoView.b(this.wiD, paramMediaPlayer.getVideoHeight());
    y.v("MicroMsg.VideoView", "on size change size:( " + VideoView.a(this.wiD) + " , " + VideoView.b(this.wiD) + " )");
    this.wiD.cJL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.1
 * JD-Core Version:    0.7.0.1
 */