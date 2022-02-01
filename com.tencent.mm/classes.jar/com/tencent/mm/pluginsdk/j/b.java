package com.tencent.mm.pluginsdk.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import java.util.concurrent.ConcurrentHashMap;

public final class b
{
  public static b QYO;
  private ConcurrentHashMap<String, Integer> QYL;
  private ConcurrentHashMap<String, Long> QYM;
  private String QYN;
  private boolean dih;
  
  static
  {
    AppMethodBeat.i(151895);
    QYO = new b("default");
    AppMethodBeat.o(151895);
  }
  
  public b(String paramString)
  {
    AppMethodBeat.i(151893);
    this.QYL = new ConcurrentHashMap();
    this.QYM = new ConcurrentHashMap();
    this.QYN = "";
    this.dih = false;
    if (CrashReportFactory.hasDebuger()) {
      this.dih = true;
    }
    this.QYN = paramString;
    AppMethodBeat.o(151893);
  }
  
  public final void bqq(String paramString)
  {
    AppMethodBeat.i(151894);
    if (!this.dih)
    {
      AppMethodBeat.o(151894);
      return;
    }
    int i;
    if (this.QYL.containsKey(paramString))
    {
      i = ((Integer)this.QYL.get(paramString)).intValue();
      i += 1;
      this.QYL.put(paramString, Integer.valueOf(i));
      if (!this.QYM.containsKey(paramString)) {
        break label171;
      }
    }
    label171:
    for (long l = ((Long)this.QYM.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 1000L)
      {
        new StringBuilder().append(this.QYN).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.QYL.put(paramString, Integer.valueOf(0));
        this.QYM.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(151894);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.b
 * JD-Core Version:    0.7.0.1
 */