package com.tencent.mm.plugin.performance.diagnostic;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.performance.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class e
  implements c
{
  public static final e GMC;
  private final Map<String, a> GMD;
  
  static
  {
    AppMethodBeat.i(201347);
    GMC = new e();
    AppMethodBeat.o(201347);
  }
  
  public e()
  {
    AppMethodBeat.i(201342);
    this.GMD = new HashMap();
    AppMethodBeat.o(201342);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(201343);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.ReportLogic", "tag or reporter should not be null");
      AppMethodBeat.o(201343);
      return;
    }
    this.GMD.put(paramString, parama);
    AppMethodBeat.o(201343);
  }
  
  public final void au(Map<String, String> paramMap)
  {
    AppMethodBeat.i(201345);
    Iterator localIterator = this.GMD.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramMap.containsKey(".cmd.diagnostic.report." + (String)localEntry.getKey())) {
        ((a)localEntry.getValue()).fnA();
      }
    }
    AppMethodBeat.o(201345);
  }
  
  public final String fnm()
  {
    return ".cmd.diagnostic.report";
  }
  
  public final void fnn() {}
  
  public static abstract interface a
  {
    public abstract void fnA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.e
 * JD-Core Version:    0.7.0.1
 */