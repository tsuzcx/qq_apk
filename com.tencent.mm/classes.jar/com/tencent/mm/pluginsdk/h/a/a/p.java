package com.tencent.mm.pluginsdk.h.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;

final class p
{
  static void bHP()
  {
    AppMethodBeat.i(152007);
    m localm = new m();
    g.agQ().ghe.a(localm, 0);
    eLY();
    AppMethodBeat.o(152007);
  }
  
  private static void eLY()
  {
    AppMethodBeat.i(152006);
    if (!g.agP().afY())
    {
      AppMethodBeat.o(152006);
      return;
    }
    long l = bs.aNx();
    g.agR().agA().set(ah.a.GHd, Long.valueOf(l + 86400L));
    AppMethodBeat.o(152006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.h.a.a.p
 * JD-Core Version:    0.7.0.1
 */