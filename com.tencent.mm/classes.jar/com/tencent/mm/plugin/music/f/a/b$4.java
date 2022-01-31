package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$4
  implements Runnable
{
  b$4(b paramb, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(137652);
    ab.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", new Object[] { Boolean.valueOf(this.pba) });
    this.paZ.paW.c(this.paZ.oYB, this.pba);
    AppMethodBeat.o(137652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b.4
 * JD-Core Version:    0.7.0.1
 */