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
  public static final e MJy;
  private final Map<String, a> MJz;
  
  static
  {
    AppMethodBeat.i(300889);
    MJy = new e();
    AppMethodBeat.o(300889);
  }
  
  public e()
  {
    AppMethodBeat.i(300884);
    this.MJz = new HashMap();
    AppMethodBeat.o(300884);
  }
  
  public final void a(String paramString, a parama)
  {
    AppMethodBeat.i(300895);
    if (TextUtils.isEmpty(paramString))
    {
      Log.e("MicroMsg.ReportLogic", "tag or reporter should not be null");
      AppMethodBeat.o(300895);
      return;
    }
    this.MJz.put(paramString, parama);
    AppMethodBeat.o(300895);
  }
  
  public final void aK(Map<String, String> paramMap)
  {
    AppMethodBeat.i(300905);
    Iterator localIterator = this.MJz.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramMap.containsKey(".cmd.diagnostic.report." + (String)localEntry.getKey())) {
        ((a)localEntry.getValue()).gyo();
      }
    }
    AppMethodBeat.o(300905);
  }
  
  public final String gxZ()
  {
    return ".cmd.diagnostic.report";
  }
  
  public final void gya() {}
  
  public static abstract interface a
  {
    public abstract void gyo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.diagnostic.e
 * JD-Core Version:    0.7.0.1
 */