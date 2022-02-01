package com.tencent.mm.pluginsdk.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class e
{
  public static e EOY;
  private ConcurrentHashMap<String, Integer> EOV;
  private ConcurrentHashMap<String, Long> EOW;
  private String EOX;
  private boolean cMW;
  
  static
  {
    AppMethodBeat.i(151895);
    EOY = new e("default");
    AppMethodBeat.o(151895);
  }
  
  public e(String paramString)
  {
    AppMethodBeat.i(151893);
    this.EOV = new ConcurrentHashMap();
    this.EOW = new ConcurrentHashMap();
    this.EOX = "";
    this.cMW = false;
    if (b.fjN()) {
      this.cMW = true;
    }
    this.EOX = paramString;
    AppMethodBeat.o(151893);
  }
  
  public final void aLW(String paramString)
  {
    AppMethodBeat.i(151894);
    if (!this.cMW)
    {
      AppMethodBeat.o(151894);
      return;
    }
    int i;
    if (this.EOV.containsKey(paramString))
    {
      i = ((Integer)this.EOV.get(paramString)).intValue();
      i += 1;
      this.EOV.put(paramString, Integer.valueOf(i));
      if (!this.EOW.containsKey(paramString)) {
        break label171;
      }
    }
    label171:
    for (long l = ((Long)this.EOW.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 1000L)
      {
        new StringBuilder().append(this.EOX).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.EOV.put(paramString, Integer.valueOf(0));
        this.EOW.put(paramString, Long.valueOf(System.currentTimeMillis()));
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