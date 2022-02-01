package com.tencent.mm.pluginsdk.j.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class p
{
  static void bMa()
  {
    AppMethodBeat.i(152007);
    m localm = new m();
    g.ajB().gAO.a(localm, 0);
    faV();
    AppMethodBeat.o(152007);
  }
  
  private static void faV()
  {
    AppMethodBeat.i(152006);
    if (!g.ajA().aiK())
    {
      AppMethodBeat.o(152006);
      return;
    }
    long l = bt.aQJ();
    g.ajC().ajl().set(al.a.Itv, Long.valueOf(l + 86400L));
    AppMethodBeat.o(152006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.a.a.p
 * JD-Core Version:    0.7.0.1
 */