package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$3
  implements MediaPlayer.OnPreparedListener
{
  VideoTextureView$3(VideoTextureView paramVideoTextureView) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if ((paramMediaPlayer != VideoTextureView.a(this.snF)) && (paramMediaPlayer != null))
    {
      y.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramMediaPlayer, VideoTextureView.a(this.snF) });
      VideoTextureView.a(this.snF, paramMediaPlayer);
    }
    label298:
    for (;;)
    {
      return;
      VideoTextureView.f(this.snF);
      VideoTextureView localVideoTextureView = this.snF;
      int i;
      if (paramMediaPlayer != null)
      {
        i = paramMediaPlayer.getVideoWidth();
        VideoTextureView.a(localVideoTextureView, i);
        localVideoTextureView = this.snF;
        if (paramMediaPlayer == null) {
          break label247;
        }
        i = paramMediaPlayer.getVideoHeight();
        label91:
        VideoTextureView.b(localVideoTextureView, i);
        y.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(VideoTextureView.b(this.snF)), Integer.valueOf(VideoTextureView.c(this.snF)), Boolean.valueOf(VideoTextureView.g(this.snF)) });
        VideoTextureView.e(this.snF);
        if ((VideoTextureView.b(this.snF) == 0) || (VideoTextureView.c(this.snF) == 0)) {
          break label252;
        }
        if (VideoTextureView.g(this.snF))
        {
          VideoTextureView.a(this.snF).start();
          VideoTextureView.a(this.snF).setLooping(VideoTextureView.h(this.snF));
          VideoTextureView.i(this.snF);
        }
      }
      for (;;)
      {
        if (VideoTextureView.d(this.snF) == null) {
          break label298;
        }
        VideoTextureView.d(this.snF).kA();
        return;
        i = 0;
        break;
        label247:
        i = 0;
        break label91;
        label252:
        if (VideoTextureView.g(this.snF))
        {
          VideoTextureView.a(this.snF).start();
          VideoTextureView.i(this.snF);
          VideoTextureView.a(this.snF).setLooping(VideoTextureView.h(this.snF));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.3
 * JD-Core Version:    0.7.0.1
 */