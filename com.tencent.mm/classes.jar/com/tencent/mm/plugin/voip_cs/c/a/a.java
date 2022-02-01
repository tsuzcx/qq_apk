package com.tencent.mm.plugin.voip_cs.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  private static a CNc;
  public i ped;
  
  private a()
  {
    AppMethodBeat.i(125364);
    this.ped = new i(ak.getContext());
    AppMethodBeat.o(125364);
  }
  
  public static a eFs()
  {
    AppMethodBeat.i(125365);
    if (CNc == null) {
      CNc = new a();
    }
    a locala = CNc;
    AppMethodBeat.o(125365);
    return locala;
  }
  
  public static a eFt()
  {
    AppMethodBeat.i(125366);
    if (CNc == null) {
      CNc = eFs();
    }
    a locala = CNc;
    AppMethodBeat.o(125366);
    return locala;
  }
  
  public final boolean cbt()
  {
    AppMethodBeat.i(125369);
    if (this.ped != null)
    {
      boolean bool = this.ped.OH();
      AppMethodBeat.o(125369);
      return bool;
    }
    AppMethodBeat.o(125369);
    return true;
  }
  
  public final void eFu()
  {
    AppMethodBeat.i(125367);
    if (this.ped != null) {
      this.ped.aU(0, true);
    }
    AppMethodBeat.o(125367);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(125368);
    if (this.ped != null) {
      this.ped.stop();
    }
    AppMethodBeat.o(125368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a.a
 * JD-Core Version:    0.7.0.1
 */