package com.tencent.mm.sdk.platformtools;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ay$1
  implements MediaPlayer.OnErrorListener
{
  ay$1(MediaPlayer paramMediaPlayer) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52221);
    ab.i("MicroMsg.PlaySound", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramMediaPlayer != null) {}
    try
    {
      paramMediaPlayer.release();
      if (this.kNg != null) {
        this.kNg.release();
      }
    }
    catch (Exception paramMediaPlayer)
    {
      label52:
      break label52;
    }
    AppMethodBeat.o(52221);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ay.1
 * JD-Core Version:    0.7.0.1
 */