package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class h$8
  implements MediaPlayer.OnErrorListener
{
  public h$8(h paramh) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5099);
    if (paramMediaPlayer != null)
    {
      paramMediaPlayer.release();
      this.tHs.tHo = 5;
      ab.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[] { paramMediaPlayer, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    AppMethodBeat.o(5099);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.h.8
 * JD-Core Version:    0.7.0.1
 */