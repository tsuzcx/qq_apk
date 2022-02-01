package com.tencent.mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.soter.a.a;

final class PluginSoter$2$1
  implements Runnable
{
  PluginSoter$2$1(PluginSoter.2 param2) {}
  
  public final void run()
  {
    AppMethodBeat.i(130783);
    long l1 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICy, Long.valueOf(0L))).longValue();
    long l2 = System.currentTimeMillis();
    if ((l2 - l1 > 86400000L) && (a.fUS()))
    {
      com.tencent.mm.plugin.report.service.g.yhR.dD(1034, 1);
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICy, Long.valueOf(l2));
    }
    AppMethodBeat.o(130783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.soter.PluginSoter.2.1
 * JD-Core Version:    0.7.0.1
 */