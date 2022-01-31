package com.tencent.mm.plugin.sight.decode.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$i$1
  implements MediaPlayer.OnErrorListener
{
  b$i$1(b.i parami) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(70242);
    ab.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", new Object[] { b.a(this.qTx.qTn), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.qTx.qTn.clear();
    if (b.b(this.qTx.qTn) != null) {
      b.b(this.qTx.qTn).c(this.qTx.qTn, -1);
    }
    AppMethodBeat.o(70242);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sight.decode.a.b.i.1
 * JD-Core Version:    0.7.0.1
 */