package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class PluginWebSearch$3
  implements Runnable
{
  PluginWebSearch$3(PluginWebSearch paramPluginWebSearch) {}
  
  public final void run()
  {
    AppMethodBeat.i(91307);
    aa.nj(5000L);
    long l = aa.Jn(1);
    if (((Long)g.RL().Ru().get(ac.a.yKP, Long.valueOf(0L))).longValue() != l)
    {
      h.qsU.e(17040, new Object[] { Integer.valueOf(2), Long.valueOf(l) });
      g.RL().Ru().set(ac.a.yKP, Long.valueOf(l));
      g.RL().Ru().dww();
    }
    AppMethodBeat.o(91307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.3
 * JD-Core Version:    0.7.0.1
 */