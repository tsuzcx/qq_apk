package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$5
  implements MediaPlayer.OnBufferingUpdateListener
{
  VideoTextureView$5(VideoTextureView paramVideoTextureView) {}
  
  public final void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    y.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", new Object[] { Integer.valueOf(paramInt) });
    VideoTextureView.c(this.snF, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.5
 * JD-Core Version:    0.7.0.1
 */