package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$8
  implements MediaPlayer.OnErrorListener
{
  VideoTextureView$8(VideoTextureView paramVideoTextureView) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.w("MicroMsg.VideoTextureView", "Error: " + paramInt1 + "," + paramInt2);
    if (VideoTextureView.d(this.snF) != null) {
      VideoTextureView.d(this.snF).onError(paramInt1, paramInt2);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.8
 * JD-Core Version:    0.7.0.1
 */