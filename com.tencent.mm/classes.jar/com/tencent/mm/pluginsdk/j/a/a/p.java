package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class p
{
  static void cjR()
  {
    AppMethodBeat.i(152007);
    m localm = new m();
    g.aAg().hqi.a(localm, 0);
    gnT();
    AppMethodBeat.o(152007);
  }
  
  private static void gnT()
  {
    AppMethodBeat.i(152006);
    if (!g.aAf().azp())
    {
      AppMethodBeat.o(152006);
      return;
    }
    long l = Util.nowSecond();
    g.aAh().azQ().set(ar.a.NVU, Long.valueOf(l + 86400L));
    AppMethodBeat.o(152006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.p
 * JD-Core Version:    0.7.0.1
 */