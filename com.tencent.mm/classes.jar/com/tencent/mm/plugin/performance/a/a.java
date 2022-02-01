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
  private final List<c> GLq;
  private final Map<Class<? extends c>, c> GLr;
  
  static
  {
    AppMethodBeat.i(145998);
    GLp = new a("INSTANCE");
    GLs = new a[] { GLp };
    AppMethodBeat.o(145998);
  }
  
  private a()
  {
    AppMethodBeat.i(145994);
    this.GLq = new CopyOnWriteArrayList();
    this.GLr = new ConcurrentHashMap();
    AppMethodBeat.o(145994);
  }
  
  public static String fnm()
  {
    return ".cmd.diagnostic";
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(145995);
    if (this.GLr.containsKey(paramc.getClass()))
    {
      AppMethodBeat.o(145995);
      return;
    }
    this.GLq.add(paramc);
    this.GLr.put(paramc.getClass(), paramc);
    paramc.fnn();
    AppMethodBeat.o(145995);
  }
  
  public final void aUm(String paramString)
  {
    AppMethodBeat.i(241151);
    Log.i("MicroMsg.DiagnosticManager", "received cmd: %s", new Object[] { paramString });
    au(XmlParser.parseXml(paramString, "cmd", null));
    AppMethodBeat.o(241151);
  }
  
  public final void au(Map<String, String> paramMap)
  {
    AppMethodBeat.i(241150);
    if ((paramMap == null) || (!paramMap.containsKey(".cmd.diagnostic")))
    {
      Log.d("MicroMsg.DiagnosticManager", "just ignore other ipxx cmd");
      AppMethodBeat.o(241150);
      return;
    }
    Iterator localIterator = this.GLq.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (paramMap.containsKey(localc.fnm())) {
        localc.au(paramMap);
      }
    }
    AppMethodBeat.o(241150);
  }
  
  public final <T extends c> T bn(Class<T> paramClass)
  {
    AppMethodBeat.i(145996);
    paramClass = (c)this.GLr.get(paramClass);
    AppMethodBeat.o(145996);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.a
 * JD-Core Version:    0.7.0.1
 */