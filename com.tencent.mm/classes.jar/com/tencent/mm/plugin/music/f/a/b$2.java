package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(137650);
    ab.i("MicroMsg.Music.BasePlayer", "onStart %b", new Object[] { Boolean.valueOf(this.paZ.isPlaying()) });
    this.paZ.paW.k(this.paZ.oYB);
    AppMethodBeat.o(137650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.f.a.b.2
 * JD-Core Version:    0.7.0.1
 */