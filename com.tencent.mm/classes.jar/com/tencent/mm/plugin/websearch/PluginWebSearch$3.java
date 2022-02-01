package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

final class PluginWebSearch$3
  implements Runnable
{
  PluginWebSearch$3(PluginWebSearch paramPluginWebSearch) {}
  
  public final void run()
  {
    AppMethodBeat.i(116511);
    long l = ad.We(0);
    if (((Long)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IEA, Long.valueOf(0L))).longValue() != l)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(17040, new Object[] { Integer.valueOf(2), Long.valueOf(l) });
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.IEA, Long.valueOf(l));
      com.tencent.mm.kernel.g.ajC().ajl().fqc();
    }
    AppMethodBeat.o(116511);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.3
 * JD-Core Version:    0.7.0.1
 */