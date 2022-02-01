package com.tencent.mm.plugin.performance.diagnostic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class c
  implements com.tencent.mm.plugin.performance.a.c
{
  public static final c ATi;
  private final Map<String, a> ATj;
  
  static
  {
    AppMethodBeat.i(201042);
    ATi = new c();
    AppMethodBeat.o(201042);
  }
  
  public c()
  {
    AppMethodBeat.i(201039);
    this.ATj = new HashMap();
    AppMethodBeat.o(201039);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(201040);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.ReportLogic", "tag or reporter should not be null");
      AppMethodBeat.o(201040);
      return;
    }
    this.ATj.put(paramString, parama);
    AppMethodBeat.o(201040);
  }
  
  public final void aA(Map<String, String> paramMap)
  {
    AppMethodBeat.i(201041);
    Iterator localIterator = this.ATj.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramMap.containsKey(".cmd.diagnostic.report." + (String)localEntry.getKey())) {
        ((a)localEntry.getValue()).eBN();
      }
    }
    AppMethodBeat.o(201041);
  }
  
  public final String eBC()
  {
    return ".cmd.diagnostic.report";
  }
  
  public final void eBD() {}
  
  public static abstract interface a
  {
    public abstract void eBN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.c
 * JD-Core Version:    0.7.0.1
 */