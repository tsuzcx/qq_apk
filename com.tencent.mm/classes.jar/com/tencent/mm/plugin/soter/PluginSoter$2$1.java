package com.tencent.mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.soter.a.a;

final class PluginSoter$2$1
  implements Runnable
{
  PluginSoter$2$1(PluginSoter.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(130783);
    long l1 = ((Long)g.aAh().azQ().get(ar.a.Ofr, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if ((l2 - l1 > 86400000L) && (a.hlC()))
    {
      h.CyF.dN(1034, 1);
      g.aAh().azQ().set(ar.a.Ofr, Long.valueOf(l2));
    }
    AppMethodBeat.o(130783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter.2.1
 * JD-Core Version:    0.7.0.1
 */