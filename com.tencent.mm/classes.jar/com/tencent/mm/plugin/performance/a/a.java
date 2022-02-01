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
  private final List<c> MIl;
  private final Map<Class<? extends c>, c> MIm;
  
  static
  {
    AppMethodBeat.i(145998);
    MIk = new a("INSTANCE");
    MIn = new a[] { MIk };
    AppMethodBeat.o(145998);
  }
  
  private a()
  {
    AppMethodBeat.i(145994);
    this.MIl = new CopyOnWriteArrayList();
    this.MIm = new ConcurrentHashMap();
    AppMethodBeat.o(145994);
  }
  
  public static String gxZ()
  {
    return ".cmd.diagnostic";
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(145995);
    if (this.MIm.containsKey(paramc.getClass()))
    {
      AppMethodBeat.o(145995);
      return;
    }
    this.MIl.add(paramc);
    this.MIm.put(paramc.getClass(), paramc);
    paramc.gya();
    AppMethodBeat.o(145995);
  }
  
  public final void aK(Map<String, String> paramMap)
  {
    AppMethodBeat.i(300818);
    Iterator localIterator = this.MIl.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (paramMap.containsKey(localc.gxZ())) {
        localc.aK(paramMap);
      }
    }
    AppMethodBeat.o(300818);
  }
  
  public final void aRq(String paramString)
  {
    AppMethodBeat.i(300821);
    Log.i("MicroMsg.DiagnosticManager", "received cmd: %s", new Object[] { paramString });
    aK(XmlParser.parseXml(paramString, "cmd", null));
    AppMethodBeat.o(300821);
  }
  
  public final <T extends c> T bX(Class<T> paramClass)
  {
    AppMethodBeat.i(145996);
    paramClass = (c)this.MIm.get(paramClass);
    AppMethodBeat.o(145996);
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.a.a
 * JD-Core Version:    0.7.0.1
 */