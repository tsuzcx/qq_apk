package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  public static d DjV;
  private ConcurrentHashMap<String, Integer> DjS;
  private ConcurrentHashMap<String, Long> DjT;
  private String DjU;
  private boolean cBX;
  
  static
  {
    AppMethodBeat.i(151895);
    DjV = new d("default");
    AppMethodBeat.o(151895);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(151893);
    this.DjS = new ConcurrentHashMap();
    this.DjT = new ConcurrentHashMap();
    this.DjU = "";
    this.cBX = false;
    if (b.eUk()) {
      this.cBX = true;
    }
    this.DjU = paramString;
    AppMethodBeat.o(151893);
  }
  
  public final void aGw(String paramString)
  {
    AppMethodBeat.i(151894);
    if (!this.cBX)
    {
      AppMethodBeat.o(151894);
      return;
    }
    int i;
    if (this.DjS.containsKey(paramString))
    {
      i = ((Integer)this.DjS.get(paramString)).intValue();
      i += 1;
      this.DjS.put(paramString, Integer.valueOf(i));
      if (!this.DjT.containsKey(paramString)) {
        break label171;
      }
    }
    label171:
    for (long l = ((Long)this.DjT.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 1000L)
      {
        new StringBuilder().append(this.DjU).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.DjS.put(paramString, Integer.valueOf(0));
        this.DjT.put(paramString, Long.valueOf(System.currentTimeMillis()));
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