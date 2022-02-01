package com.tencent.mm.plugin.performance.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public enum a
{
  private final List<c> ASc;
  private final Map<Class<? extends c>, c> ASd;
  
  static
  {
    AppMethodBeat.i(145998);
    ASb = new a("INSTANCE");
    ASe = new a[] { ASb };
    AppMethodBeat.o(145998);
  }
  
  private a()
  {
    AppMethodBeat.i(145994);
    this.ASc = new CopyOnWriteArrayList();
    this.ASd = new ConcurrentHashMap();
    AppMethodBeat.o(145994);
  }
  
  public static String eBC()
  {
    return ".cmd.diagnostic";
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(145995);
    if (this.ASd.containsKey(paramc.getClass()))
    {
      AppMethodBeat.o(145995);
      return;
    }
    this.ASc.add(paramc);
    this.ASd.put(paramc.getClass(), paramc);
    paramc.eBD();
    AppMethodBeat.o(145995);
  }
  
  public final void aA(Map<String, String> paramMap)
  {
    AppMethodBeat.i(194242);
    if ((paramMap == null) || (!paramMap.containsKey(".cmd.diagnostic")))
    {
      Log.d("MicroMsg.DiagnosticManager", "just ignore other ipxx cmd");
      AppMethodBeat.o(194242);
      return;
    }
    Iterator localIterator = this.ASc.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (paramMap.containsKey(localc.eBC())) {
        localc.aA(paramMap);
      }
    }
    AppMethodBeat.o(194242);
  }
  
  public final void aJQ(String paramString)
  {
    AppMethodBeat.i(194243);
    Log.i("MicroMsg.DiagnosticManager", "received cmd: %s", new Object[] { paramString });
    aA(XmlParser.parseXml(paramString, "cmd", null));
    AppMethodBeat.o(194243);
  }
  
  public final <T extends c> T aT(Class<T> paramClass)
  {
    AppMethodBeat.i(145996);
    paramClass = (c)this.ASd.get(paramClass);
    AppMethodBeat.o(145996);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.a
 * JD-Core Version:    0.7.0.1
 */