package com.tencent.mm.plugin.performance.diagnostic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.diagnostic.memory.MemoryHookLogic;
import com.tencent.mm.plugin.performance.diagnostic.pthread.PthreadHookLogic;
import java.util.Map;

public final class b
  extends a
{
  protected final void aB(Map<String, String> paramMap)
  {
    AppMethodBeat.i(124913);
    if ((paramMap.containsKey(".cmd.diagnostic.report" + ".memory")) && ((MemoryHookLogic)com.tencent.mm.plugin.performance.a.a.wWa.aR(MemoryHookLogic.class) != null)) {
      MemoryHookLogic.report();
    }
    if (paramMap.containsKey(".cmd.diagnostic.report" + ".pthread"))
    {
      com.tencent.mm.plugin.performance.a.a.wWa.aR(PthreadHookLogic.class);
      PthreadHookLogic.report();
    }
    AppMethodBeat.o(124913);
  }
  
  public final String dBO()
  {
    return ".cmd.diagnostic.report";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.b
 * JD-Core Version:    0.7.0.1
 */