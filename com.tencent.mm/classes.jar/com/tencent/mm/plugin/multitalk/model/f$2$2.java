package com.tencent.mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.sdk.platformtools.ab;

final class f$2$2
  implements Runnable
{
  f$2$2(f.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(53939);
    p.bTE().oTa.rT(false);
    if ((g.KC() != null) && (g.KC().KH()))
    {
      ab.i("MicroMsg.MT.MultiTalkManager", "is bluetooth can use and start bluetooth");
      g.KC().KE();
      AppMethodBeat.o(53939);
      return;
    }
    this.oTO.oTN.jF(p.bTF().oTm);
    AppMethodBeat.o(53939);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.f.2.2
 * JD-Core Version:    0.7.0.1
 */