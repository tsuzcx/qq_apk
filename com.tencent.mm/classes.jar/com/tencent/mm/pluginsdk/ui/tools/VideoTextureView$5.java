package com.tencent.mm.pluginsdk.ui.tools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class VideoTextureView$5
  implements MediaPlayer.OnSeekCompleteListener
{
  VideoTextureView$5(VideoTextureView paramVideoTextureView) {}
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(118012);
    if (paramMediaPlayer != null) {}
    for (int i = paramMediaPlayer.getCurrentPosition();; i = -1)
    {
      ab.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b] pauseWhenUpdated[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(VideoTextureView.g(this.wga)), Boolean.valueOf(VideoTextureView.j(this.wga)) });
      if (!VideoTextureView.g(this.wga)) {
        break label141;
      }
      if (!VideoTextureView.j(this.wga)) {
        break;
      }
      AppMethodBeat.o(118012);
      return;
    }
    this.wga.start();
    for (;;)
    {
      if (VideoTextureView.k(this.wga) != null) {
        VideoTextureView.k(this.wga).dg(VideoTextureView.g(this.wga));
      }
      VideoTextureView.a(this.wga, 0L);
      AppMethodBeat.o(118012);
      return;
      label141:
      this.wga.pause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.VideoTextureView.5
 * JD-Core Version:    0.7.0.1
 */