package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$4
  implements MediaPlayer.OnSeekCompleteListener
{
  VideoTextureView$4(VideoTextureView paramVideoTextureView) {}
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {}
    for (int i = paramMediaPlayer.getCurrentPosition();; i = -1)
    {
      y.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(VideoTextureView.g(this.snF)), Boolean.valueOf(VideoTextureView.j(this.snF)) });
      if (!VideoTextureView.g(this.snF)) {
        break label126;
      }
      if (!VideoTextureView.j(this.snF)) {
        break;
      }
      return;
    }
    this.snF.start();
    for (;;)
    {
      if (VideoTextureView.k(this.snF) != null) {
        VideoTextureView.k(this.snF).cd(VideoTextureView.g(this.snF));
      }
      VideoTextureView.a(this.snF, 0L);
      return;
      label126:
      this.snF.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.4
 * JD-Core Version:    0.7.0.1
 */