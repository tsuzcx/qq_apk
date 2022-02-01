package com.tencent.mm.plugin.performance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public enum a
  implements c
{
  private List<c> wWb;
  private Map<Class<? extends c>, c> wWc;
  
  static
  {
    AppMethodBeat.i(145998);
    wWa = new a("INSTANCE");
    wWd = new a[] { wWa };
    AppMethodBeat.o(145998);
  }
  
  private a()
  {
    AppMethodBeat.i(145994);
    this.wWb = new CopyOnWriteArrayList();
    this.wWc = new ConcurrentHashMap();
    AppMethodBeat.o(145994);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(145995);
    if (this.wWc.containsKey(paramc.getClass()))
    {
      AppMethodBeat.o(145995);
      return;
    }
    this.wWb.add(paramc);
    this.wWc.put(paramc.getClass(), paramc);
    AppMethodBeat.o(145995);
  }
  
  public final void aA(Map<String, String> paramMap)
  {
    AppMethodBeat.i(145997);
    if ((paramMap == null) || (!paramMap.containsKey(".cmd.diagnostic")))
    {
      ae.d("MicroMsg.DiagnosticManager", "just ignore other ipxx cmd");
      AppMethodBeat.o(145997);
      return;
    }
    Iterator localIterator = this.wWb.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).aA(paramMap);
    }
    AppMethodBeat.o(145997);
  }
  
  public final <T extends c> T aR(Class<T> paramClass)
  {
    AppMethodBeat.i(145996);
    paramClass = (c)this.wWc.get(paramClass);
    AppMethodBeat.o(145996);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.a
 * JD-Core Version:    0.7.0.1
 */