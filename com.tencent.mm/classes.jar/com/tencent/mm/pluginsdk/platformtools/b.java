package com.tencent.mm.pluginsdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  public static b XUO;
  private ConcurrentHashMap<String, Integer> XUL;
  private ConcurrentHashMap<String, Long> XUM;
  private String XUN;
  private boolean egk;
  
  static
  {
    AppMethodBeat.i(151895);
    XUO = new b("default");
    AppMethodBeat.o(151895);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(151893);
    this.XUL = new ConcurrentHashMap();
    this.XUM = new ConcurrentHashMap();
    this.XUN = "";
    this.egk = false;
    if (CrashReportFactory.hasDebuger()) {
      this.egk = true;
    }
    this.XUN = paramString;
    AppMethodBeat.o(151893);
  }
  
  public final void bqd(String paramString)
  {
    AppMethodBeat.i(151894);
    if (!this.egk)
    {
      AppMethodBeat.o(151894);
      return;
    }
    int i;
    if (this.XUL.containsKey(paramString))
    {
      i = ((Integer)this.XUL.get(paramString)).intValue();
      i += 1;
      this.XUL.put(paramString, Integer.valueOf(i));
      if (!this.XUM.containsKey(paramString)) {
        break label171;
      }
    }
    label171:
    for (long l = ((Long)this.XUM.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 1000L)
      {
        new StringBuilder().append(this.XUN).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.XUL.put(paramString, Integer.valueOf(0));
        this.XUM.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(151894);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.platformtools.b
 * JD-Core Version:    0.7.0.1
 */