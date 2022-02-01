package com.tencent.mm.pluginsdk.k.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class p
{
  static void cxi()
  {
    AppMethodBeat.i(152007);
    m localm = new m();
    h.aHF().kcd.a(localm, 0);
    hiA();
    AppMethodBeat.o(152007);
  }
  
  private static void hiA()
  {
    AppMethodBeat.i(152006);
    if (!h.aHE().aGM())
    {
      AppMethodBeat.o(152006);
      return;
    }
    long l = Util.nowSecond();
    h.aHG().aHp().set(ar.a.VjU, Long.valueOf(l + 86400L));
    AppMethodBeat.o(152006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.k.a.a.p
 * JD-Core Version:    0.7.0.1
 */