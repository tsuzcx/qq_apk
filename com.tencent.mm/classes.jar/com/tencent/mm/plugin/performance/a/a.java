package com.tencent.mm.plugin.performance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public enum a
  implements c
{
  private List<c> wGo;
  private Map<Class<? extends c>, c> wGp;
  
  static
  {
    AppMethodBeat.i(145998);
    wGn = new a("INSTANCE");
    wGq = new a[] { wGn };
    AppMethodBeat.o(145998);
  }
  
  private a()
  {
    AppMethodBeat.i(145994);
    this.wGo = new CopyOnWriteArrayList();
    this.wGp = new ConcurrentHashMap();
    AppMethodBeat.o(145994);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(145995);
    if (this.wGp.containsKey(paramc.getClass()))
    {
      AppMethodBeat.o(145995);
      return;
    }
    this.wGo.add(paramc);
    this.wGp.put(paramc.getClass(), paramc);
    AppMethodBeat.o(145995);
  }
  
  public final <T extends c> T aR(Class<T> paramClass)
  {
    AppMethodBeat.i(145996);
    paramClass = (c)this.wGp.get(paramClass);
    AppMethodBeat.o(145996);
    return paramClass;
  }
  
  public final void au(Map<String, String> paramMap)
  {
    AppMethodBeat.i(145997);
    if ((paramMap == null) || (!paramMap.containsKey(".cmd.diagnostic")))
    {
      ad.d("MicroMsg.DiagnosticManager", "just ignore other ipxx cmd");
      AppMethodBeat.o(145997);
      return;
    }
    Iterator localIterator = this.wGo.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).au(paramMap);
    }
    AppMethodBeat.o(145997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.a
 * JD-Core Version:    0.7.0.1
 */