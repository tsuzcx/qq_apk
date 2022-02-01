package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  public static d BRF;
  private ConcurrentHashMap<String, Integer> BRC;
  private ConcurrentHashMap<String, Long> BRD;
  private String BRE;
  private boolean cEP;
  
  static
  {
    AppMethodBeat.i(151895);
    BRF = new d("default");
    AppMethodBeat.o(151895);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(151893);
    this.BRC = new ConcurrentHashMap();
    this.BRD = new ConcurrentHashMap();
    this.BRE = "";
    this.cEP = false;
    if (b.eEQ()) {
      this.cEP = true;
    }
    this.BRE = paramString;
    AppMethodBeat.o(151893);
  }
  
  public final void aBe(String paramString)
  {
    AppMethodBeat.i(151894);
    if (!this.cEP)
    {
      AppMethodBeat.o(151894);
      return;
    }
    int i;
    if (this.BRC.containsKey(paramString))
    {
      i = ((Integer)this.BRC.get(paramString)).intValue();
      i += 1;
      this.BRC.put(paramString, Integer.valueOf(i));
      if (!this.BRD.containsKey(paramString)) {
        break label171;
      }
    }
    label171:
    for (long l = ((Long)this.BRD.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 1000L)
      {
        new StringBuilder().append(this.BRE).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.BRC.put(paramString, Integer.valueOf(0));
        this.BRD.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(151894);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.d
 * JD-Core Version:    0.7.0.1
 */