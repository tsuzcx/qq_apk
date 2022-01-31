package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.mm.sdk.platformtools.y;

final class VideoTextureView$2
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoTextureView$2(VideoTextureView paramVideoTextureView) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    try
    {
      if (paramMediaPlayer != VideoTextureView.a(this.snF))
      {
        y.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramMediaPlayer, VideoTextureView.a(this.snF) });
        return;
      }
      VideoTextureView.a(this.snF, paramMediaPlayer.getVideoWidth());
      VideoTextureView.b(this.snF, paramMediaPlayer.getVideoHeight());
      y.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(this.snF) + " , " + VideoTextureView.c(this.snF) + " )");
      if (VideoTextureView.d(this.snF) != null) {
        VideoTextureView.d(this.snF).cw(VideoTextureView.b(this.snF), VideoTextureView.c(this.snF));
      }
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.VideoTextureView", paramMediaPlayer, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
    }
    VideoTextureView.e(this.snF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.2
 * JD-Core Version:    0.7.0.1
 */