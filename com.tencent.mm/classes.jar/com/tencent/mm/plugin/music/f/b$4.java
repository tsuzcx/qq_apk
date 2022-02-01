package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

final class b$4
  implements MediaPlayer.OnErrorListener
{
  b$4(b paramb) {}
  
  public final boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137301);
    ad.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.wlY.pd(false);
    AppMethodBeat.o(137301);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.b.4
 * JD-Core Version:    0.7.0.1
 */