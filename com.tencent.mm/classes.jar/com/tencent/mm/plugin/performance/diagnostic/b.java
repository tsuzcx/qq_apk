package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic;
import java.util.Map;

public final class b
  extends a
{
  protected final void ao(Map<String, String> paramMap)
  {
    AppMethodBeat.i(124913);
    if ((paramMap.containsKey(".cmd.diagnostic.report" + ".memory")) && ((MemoryHookLogic)com.tencent.mm.plugin.performance.a.a.urg.aQ(MemoryHookLogic.class) != null)) {
      MemoryHookLogic.report();
    }
    AppMethodBeat.o(124913);
  }
  
  public final String dat()
  {
    return ".cmd.diagnostic.report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b
 * JD-Core Version:    0.7.0.1
 */