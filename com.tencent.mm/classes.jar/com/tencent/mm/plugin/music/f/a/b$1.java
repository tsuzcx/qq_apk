package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$1
  implements Runnable
{
  b$1(b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(137649);
    ab.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", new Object[] { Boolean.valueOf(this.paY) });
    this.paZ.paW.d(this.paZ.oYB, this.paY);
    AppMethodBeat.o(137649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b.1
 * JD-Core Version:    0.7.0.1
 */