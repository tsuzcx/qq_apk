package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;

final class p
{
  static void bMY()
  {
    AppMethodBeat.i(152007);
    m localm = new m();
    g.ajQ().gDv.a(localm, 0);
    feJ();
    AppMethodBeat.o(152007);
  }
  
  private static void feJ()
  {
    AppMethodBeat.i(152006);
    if (!g.ajP().aiZ())
    {
      AppMethodBeat.o(152006);
      return;
    }
    long l = bu.aRi();
    g.ajR().ajA().set(am.a.INR, Long.valueOf(l + 86400L));
    AppMethodBeat.o(152006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.p
 * JD-Core Version:    0.7.0.1
 */