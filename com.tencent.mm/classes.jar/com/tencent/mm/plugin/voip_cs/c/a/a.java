package com.tencent.mm.plugin.voip_cs.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ai;

public final class a
{
  private static a AVp;
  public i oue;
  
  private a()
  {
    AppMethodBeat.i(125364);
    this.oue = new i(ai.getContext());
    AppMethodBeat.o(125364);
  }
  
  public static a enL()
  {
    AppMethodBeat.i(125365);
    if (AVp == null) {
      AVp = new a();
    }
    a locala = AVp;
    AppMethodBeat.o(125365);
    return locala;
  }
  
  public static a enM()
  {
    AppMethodBeat.i(125366);
    if (AVp == null) {
      AVp = enL();
    }
    a locala = AVp;
    AppMethodBeat.o(125366);
    return locala;
  }
  
  public final boolean bVB()
  {
    AppMethodBeat.i(125369);
    if (this.oue != null)
    {
      boolean bool = this.oue.Na();
      AppMethodBeat.o(125369);
      return bool;
    }
    AppMethodBeat.o(125369);
    return true;
  }
  
  public final void enN()
  {
    AppMethodBeat.i(125367);
    if (this.oue != null) {
      this.oue.aI(0, true);
    }
    AppMethodBeat.o(125367);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(125368);
    if (this.oue != null) {
      this.oue.stop();
    }
    AppMethodBeat.o(125368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a.a
 * JD-Core Version:    0.7.0.1
 */