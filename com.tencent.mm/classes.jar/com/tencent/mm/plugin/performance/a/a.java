package com.tencent.mm.plugin.performance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public enum a
  implements c
{
  private List<c> vAd;
  private Map<Class<? extends c>, c> vAe;
  
  static
  {
    AppMethodBeat.i(145998);
    vAc = new a("INSTANCE");
    vAf = new a[] { vAc };
    AppMethodBeat.o(145998);
  }
  
  private a()
  {
    AppMethodBeat.i(145994);
    this.vAd = new CopyOnWriteArrayList();
    this.vAe = new ConcurrentHashMap();
    AppMethodBeat.o(145994);
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(145995);
    if (this.vAe.containsKey(paramc.getClass()))
    {
      AppMethodBeat.o(145995);
      return;
    }
    this.vAd.add(paramc);
    this.vAe.put(paramc.getClass(), paramc);
    AppMethodBeat.o(145995);
  }
  
  public final <T extends c> T aR(Class<T> paramClass)
  {
    AppMethodBeat.i(145996);
    paramClass = (c)this.vAe.get(paramClass);
    AppMethodBeat.o(145996);
    return paramClass;
  }
  
  public final void ap(Map<String, String> paramMap)
  {
    AppMethodBeat.i(145997);
    if (!paramMap.containsKey(".cmd.diagnostic"))
    {
      ac.d("MicroMsg.DiagnosticManager", "just ignore other ipxx cmd");
      AppMethodBeat.o(145997);
      return;
    }
    Iterator localIterator = this.vAd.iterator();
    while (localIterator.hasNext()) {
      ((c)localIterator.next()).ap(paramMap);
    }
    AppMethodBeat.o(145997);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.a
 * JD-Core Version:    0.7.0.1
 */