package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

final class p$27
  implements Runnable
{
  p$27(p paramp) {}
  
  public final void run()
  {
    AppMethodBeat.i(190613);
    if ((p.C(this.wnP) == 0) && (!p.ab(this.wnP)))
    {
      ae.i("MicroMsg.Multitalk.ILinkService", "hy: still not join room in %d ms. directly release", new Object[] { Long.valueOf(180000L) });
      p.ac(this.wnP);
    }
    AppMethodBeat.o(190613);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.p.27
 * JD-Core Version:    0.7.0.1
 */