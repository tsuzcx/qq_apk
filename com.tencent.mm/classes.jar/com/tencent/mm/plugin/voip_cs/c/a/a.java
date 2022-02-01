package com.tencent.mm.plugin.voip_cs.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  private static a Cvx;
  public i oXA;
  
  private a()
  {
    AppMethodBeat.i(125364);
    this.oXA = new i(aj.getContext());
    AppMethodBeat.o(125364);
  }
  
  public static a eBK()
  {
    AppMethodBeat.i(125365);
    if (Cvx == null) {
      Cvx = new a();
    }
    a locala = Cvx;
    AppMethodBeat.o(125365);
    return locala;
  }
  
  public static a eBL()
  {
    AppMethodBeat.i(125366);
    if (Cvx == null) {
      Cvx = eBK();
    }
    a locala = Cvx;
    AppMethodBeat.o(125366);
    return locala;
  }
  
  public final boolean cae()
  {
    AppMethodBeat.i(125369);
    if (this.oXA != null)
    {
      boolean bool = this.oXA.OJ();
      AppMethodBeat.o(125369);
      return bool;
    }
    AppMethodBeat.o(125369);
    return true;
  }
  
  public final void eBM()
  {
    AppMethodBeat.i(125367);
    if (this.oXA != null) {
      this.oXA.aO(0, true);
    }
    AppMethodBeat.o(125367);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(125368);
    if (this.oXA != null) {
      this.oXA.stop();
    }
    AppMethodBeat.o(125368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a.a
 * JD-Core Version:    0.7.0.1
 */