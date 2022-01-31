package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ay$3
  implements MediaPlayer.OnPreparedListener
{
  ay$3(String paramString, MediaPlayer paramMediaPlayer, int paramInt) {}
  
  public final void onPrepared(MediaPlayer paramMediaPlayer)
  {
    AppMethodBeat.i(141964);
    if (paramMediaPlayer == null) {}
    for (int i = -1;; i = paramMediaPlayer.hashCode())
    {
      ab.i("MicroMsg.PlaySound", "play onPrepared mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.val$path });
      try
      {
        if (this.kNg != null) {
          this.kNg.start();
        }
        AppMethodBeat.o(141964);
        return;
      }
      catch (Exception paramMediaPlayer)
      {
        ab.printErrStackTrace("MicroMsg.PlaySound", paramMediaPlayer, "play failed pathId:%d", new Object[] { Integer.valueOf(this.ypx) });
        AppMethodBeat.o(141964);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ay.3
 * JD-Core Version:    0.7.0.1
 */