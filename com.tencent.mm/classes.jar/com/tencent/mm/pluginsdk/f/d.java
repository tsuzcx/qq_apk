package com.tencent.mm.pluginsdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class d
{
  public static d vME;
  private boolean bTy;
  private ConcurrentHashMap<String, Integer> vMB;
  private ConcurrentHashMap<String, Long> vMC;
  private String vMD;
  
  static
  {
    AppMethodBeat.i(79452);
    vME = new d("default");
    AppMethodBeat.o(79452);
  }
  
  public d(String paramString)
  {
    AppMethodBeat.i(79450);
    this.vMB = new ConcurrentHashMap();
    this.vMC = new ConcurrentHashMap();
    this.vMD = "";
    this.bTy = false;
    if (b.dsf()) {
      this.bTy = true;
    }
    this.vMD = paramString;
    AppMethodBeat.o(79450);
  }
  
  public final void alD(String paramString)
  {
    AppMethodBeat.i(79451);
    if (!this.bTy)
    {
      AppMethodBeat.o(79451);
      return;
    }
    int i;
    if (this.vMB.containsKey(paramString))
    {
      i = ((Integer)this.vMB.get(paramString)).intValue();
      i += 1;
      this.vMB.put(paramString, Integer.valueOf(i));
      if (!this.vMC.containsKey(paramString)) {
        break label171;
      }
    }
    label171:
    for (long l = ((Long)this.vMC.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l > 1000L)
      {
        new StringBuilder().append(this.vMD).append("user get fps ").append(i).append(" fpswraper: ").append(paramString);
        this.vMB.put(paramString, Integer.valueOf(0));
        this.vMC.put(paramString, Long.valueOf(System.currentTimeMillis()));
      }
      AppMethodBeat.o(79451);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.d
 * JD-Core Version:    0.7.0.1
 */