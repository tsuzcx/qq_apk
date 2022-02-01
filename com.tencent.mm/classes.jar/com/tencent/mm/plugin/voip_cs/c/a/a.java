package com.tencent.mm.plugin.voip_cs.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.i;
import com.tencent.mm.sdk.platformtools.aj;

public final class a
{
  private static a zDc;
  public i zmt;
  
  private a()
  {
    AppMethodBeat.i(125364);
    this.zmt = new i(aj.getContext());
    AppMethodBeat.o(125364);
  }
  
  public static a dYp()
  {
    AppMethodBeat.i(125365);
    if (zDc == null) {
      zDc = new a();
    }
    a locala = zDc;
    AppMethodBeat.o(125365);
    return locala;
  }
  
  public static a dYq()
  {
    AppMethodBeat.i(125366);
    if (zDc == null) {
      zDc = dYp();
    }
    a locala = zDc;
    AppMethodBeat.o(125366);
    return locala;
  }
  
  public final boolean cSx()
  {
    AppMethodBeat.i(125369);
    if (this.zmt != null)
    {
      boolean bool = this.zmt.Nc();
      AppMethodBeat.o(125369);
      return bool;
    }
    AppMethodBeat.o(125369);
    return true;
  }
  
  public final void dYr()
  {
    AppMethodBeat.i(125367);
    if (this.zmt != null) {
      this.zmt.aE(0, true);
    }
    AppMethodBeat.o(125367);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(125368);
    if (this.zmt != null) {
      this.zmt.stop();
    }
    AppMethodBeat.o(125368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a.a
 * JD-Core Version:    0.7.0.1
 */