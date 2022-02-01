package com.tencent.mm.pluginsdk.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  public static e Fht;
  private ConcurrentHashMap<String, Integer> Fhq;
  private ConcurrentHashMap<String, Long> Fhr;
  private String Fhs;
  private boolean cNF;
  
  static
  {
    AppMethodBeat.i(151895);
    Fht = new e("default");
    AppMethodBeat.o(151895);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(151893);
    this.Fhq = new ConcurrentHashMap();
    this.Fhr = new ConcurrentHashMap();
    this.Fhs = "";
    this.cNF = false;
    if (b.fnF()) {
      this.cNF = true;
    }
    this.Fhs = paramString;
    AppMethodBeat.o(151893);
  }
  
  public final void aNs(String paramString)
  {
    AppMethodBeat.i(151894);
    if (!this.cNF)
    {
      AppMethodBeat.o(151894);
      return;
    }
    int i;
    if (this.Fhq.containsKey(paramString))
    {
      i = ((Integer)this.Fhq.get(paramString)).intValue();
      i += 1;
      this.Fhq.put(paramString, Integer.valueOf(i));
      if (!this.Fhr.containsKey(paramString)) {
        break label171;
      }
    }
    label171:
    for (long l = ((Long)this.Fhr.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 1000L)
      {
        new StringBuilder().append(this.Fhs).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.Fhq.put(paramString, Integer.valueOf(0));
        this.Fhr.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(151894);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.e
 * JD-Core Version:    0.7.0.1
 */