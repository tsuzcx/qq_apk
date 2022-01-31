package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoTextureView$3
  implements MediaPlayer.OnVideoSizeChangedListener
{
  VideoTextureView$3(VideoTextureView paramVideoTextureView) {}
  
  public final void onVideoSizeChanged(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(118010);
    try
    {
      if (paramMediaPlayer != VideoTextureView.a(this.wga))
      {
        ab.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", new Object[] { paramMediaPlayer, VideoTextureView.a(this.wga) });
        AppMethodBeat.o(118010);
        return;
      }
      VideoTextureView.a(this.wga, paramMediaPlayer.getVideoWidth());
      VideoTextureView.b(this.wga, paramMediaPlayer.getVideoHeight());
      ab.i("MicroMsg.VideoTextureView", "on size change size:( " + VideoTextureView.b(this.wga) + " , " + VideoTextureView.c(this.wga) + " )");
      if (VideoTextureView.d(this.wga) != null) {
        VideoTextureView.d(this.wga).dQ(VideoTextureView.b(this.wga), VideoTextureView.c(this.wga));
      }
    }
    catch (Exception paramMediaPlayer)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.VideoTextureView", paramMediaPlayer, "on video size changed error[%d, %d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      }
    }
    VideoTextureView.e(this.wga);
    AppMethodBeat.o(118010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.3
 * JD-Core Version:    0.7.0.1
 */