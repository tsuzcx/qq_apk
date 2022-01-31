package com.tencent.mm.ui.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoView$4
  implements MediaPlayer.OnErrorListener
{
  VideoView$4(VideoView paramVideoView) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.VideoView", "Error: " + paramInt1 + "," + paramInt2);
    if ((VideoView.m(this.wiD) != null) && (VideoView.m(this.wiD).onError(VideoView.e(this.wiD), paramInt1, paramInt2))) {
      return true;
    }
    this.wiD.getWindowToken();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.video.VideoView.4
 * JD-Core Version:    0.7.0.1
 */