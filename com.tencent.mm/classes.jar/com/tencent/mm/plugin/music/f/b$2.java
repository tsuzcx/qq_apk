package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements MediaPlayer.OnSeekCompleteListener
{
  b$2(b paramb) {}
  
  public final void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(137549);
    if ((this.paE.gaO != null) && (this.paE.gaO.isPlaying()))
    {
      ab.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
      try
      {
        this.paE.gaO.start();
        AppMethodBeat.o(137549);
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        ab.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", paramMediaPlayer, "start", new Object[0]);
      }
    }
    AppMethodBeat.o(137549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.2
 * JD-Core Version:    0.7.0.1
 */