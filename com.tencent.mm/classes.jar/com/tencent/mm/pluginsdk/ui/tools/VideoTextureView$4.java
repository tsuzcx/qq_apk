package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoTextureView$4
  implements MediaPlayer.OnPreparedListener
{
  VideoTextureView$4(VideoTextureView paramVideoTextureView) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(118011);
    if ((paramMediaPlayer != VideoTextureView.a(this.wga)) && (paramMediaPlayer != null))
    {
      ab.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", new Object[] { paramMediaPlayer, VideoTextureView.a(this.wga) });
      VideoTextureView.a(this.wga, paramMediaPlayer);
      AppMethodBeat.o(118011);
      return;
    }
    VideoTextureView.f(this.wga);
    VideoTextureView localVideoTextureView = this.wga;
    int i;
    if (paramMediaPlayer != null)
    {
      i = paramMediaPlayer.getVideoWidth();
      VideoTextureView.a(localVideoTextureView, i);
      localVideoTextureView = this.wga;
      if (paramMediaPlayer == null) {
        break label262;
      }
      i = paramMediaPlayer.getVideoHeight();
      label101:
      VideoTextureView.b(localVideoTextureView, i);
      ab.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", new Object[] { Integer.valueOf(VideoTextureView.b(this.wga)), Integer.valueOf(VideoTextureView.c(this.wga)), Boolean.valueOf(VideoTextureView.g(this.wga)) });
      VideoTextureView.e(this.wga);
      if ((VideoTextureView.b(this.wga) == 0) || (VideoTextureView.c(this.wga) == 0)) {
        break label267;
      }
      if (VideoTextureView.g(this.wga))
      {
        VideoTextureView.a(this.wga).start();
        VideoTextureView.a(this.wga).setLooping(VideoTextureView.h(this.wga));
        VideoTextureView.i(this.wga);
      }
    }
    for (;;)
    {
      if (VideoTextureView.d(this.wga) != null) {
        VideoTextureView.d(this.wga).mG();
      }
      AppMethodBeat.o(118011);
      return;
      i = 0;
      break;
      label262:
      i = 0;
      break label101;
      label267:
      if (VideoTextureView.g(this.wga))
      {
        VideoTextureView.a(this.wga).start();
        VideoTextureView.i(this.wga);
        VideoTextureView.a(this.wga).setLooping(VideoTextureView.h(this.wga));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.4
 * JD-Core Version:    0.7.0.1
 */