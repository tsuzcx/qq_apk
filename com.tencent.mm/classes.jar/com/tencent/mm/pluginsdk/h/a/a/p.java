package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;

final class p
{
  static void bAT()
  {
    AppMethodBeat.i(152007);
    m localm = new m();
    g.afA().gcy.a(localm, 0);
    ewE();
    AppMethodBeat.o(152007);
  }
  
  private static void ewE()
  {
    AppMethodBeat.i(152006);
    if (!g.afz().aeI())
    {
      AppMethodBeat.o(152006);
      return;
    }
    long l = bt.aGK();
    g.afB().afk().set(ae.a.Fjo, Long.valueOf(l + 86400L));
    AppMethodBeat.o(152006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.p
 * JD-Core Version:    0.7.0.1
 */