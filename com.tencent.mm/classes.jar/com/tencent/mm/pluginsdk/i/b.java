package com.tencent.mm.pluginsdk.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  public static b JYm;
  private ConcurrentHashMap<String, Integer> JYj;
  private ConcurrentHashMap<String, Long> JYk;
  private String JYl;
  private boolean ded;
  
  static
  {
    AppMethodBeat.i(151895);
    JYm = new b("default");
    AppMethodBeat.o(151895);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(151893);
    this.JYj = new ConcurrentHashMap();
    this.JYk = new ConcurrentHashMap();
    this.JYl = "";
    this.ded = false;
    if (CrashReportFactory.hasDebuger()) {
      this.ded = true;
    }
    this.JYl = paramString;
    AppMethodBeat.o(151893);
  }
  
  public final void bdU(String paramString)
  {
    AppMethodBeat.i(151894);
    if (!this.ded)
    {
      AppMethodBeat.o(151894);
      return;
    }
    int i;
    if (this.JYj.containsKey(paramString))
    {
      i = ((Integer)this.JYj.get(paramString)).intValue();
      i += 1;
      this.JYj.put(paramString, Integer.valueOf(i));
      if (!this.JYk.containsKey(paramString)) {
        break label171;
      }
    }
    label171:
    for (long l = ((Long)this.JYk.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 1000L)
      {
        new StringBuilder().append(this.JYl).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.JYj.put(paramString, Integer.valueOf(0));
        this.JYk.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(151894);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.b
 * JD-Core Version:    0.7.0.1
 */