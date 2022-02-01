package com.tencent.mm.plugin.voip_cs.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip_cs.a.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private static a UXY;
  public e wVi;
  
  private a()
  {
    AppMethodBeat.i(125364);
    this.wVi = new e(MMApplicationContext.getContext());
    AppMethodBeat.o(125364);
  }
  
  public static a iee()
  {
    AppMethodBeat.i(125365);
    if (UXY == null) {
      UXY = new a();
    }
    a locala = UXY;
    AppMethodBeat.o(125365);
    return locala;
  }
  
  public static a ief()
  {
    AppMethodBeat.i(125366);
    if (UXY == null) {
      UXY = iee();
    }
    a locala = UXY;
    AppMethodBeat.o(125366);
    return locala;
  }
  
  public final boolean dro()
  {
    AppMethodBeat.i(125369);
    if (this.wVi != null)
    {
      boolean bool = this.wVi.aFG();
      AppMethodBeat.o(125369);
      return bool;
    }
    AppMethodBeat.o(125369);
    return true;
  }
  
  public final void ieg()
  {
    AppMethodBeat.i(125367);
    if (this.wVi != null) {
      this.wVi.mK(a.d.phonering, 0);
    }
    AppMethodBeat.o(125367);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(125368);
    if (this.wVi != null) {
      this.wVi.stop();
    }
    AppMethodBeat.o(125368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.a.a
 * JD-Core Version:    0.7.0.1
 */