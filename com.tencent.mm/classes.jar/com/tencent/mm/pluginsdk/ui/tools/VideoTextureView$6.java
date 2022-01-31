package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$6
  implements MediaPlayer.OnInfoListener
{
  VideoTextureView$6(VideoTextureView paramVideoTextureView) {}
  
  public final boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (VideoTextureView.l(this.snF) != null) {
      VideoTextureView.l(this.snF).eX(paramInt1, paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.6
 * JD-Core Version:    0.7.0.1
 */