package com.tencent.mm.plugin.voip_cs.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.plugin.voip_cs.a.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a
{
  private static a OjD;
  public e tRS;
  
  private a()
  {
    AppMethodBeat.i(125364);
    this.tRS = new e(MMApplicationContext.getContext());
    AppMethodBeat.o(125364);
  }
  
  public static a gFe()
  {
    AppMethodBeat.i(125365);
    if (OjD == null) {
      OjD = new a();
    }
    a locala = OjD;
    AppMethodBeat.o(125365);
    return locala;
  }
  
  public static a gFf()
  {
    AppMethodBeat.i(125366);
    if (OjD == null) {
      OjD = gFe();
    }
    a locala = OjD;
    AppMethodBeat.o(125366);
    return locala;
  }
  
  public final boolean cNL()
  {
    AppMethodBeat.i(125369);
    if (this.tRS != null)
    {
      boolean bool = this.tRS.adI();
      AppMethodBeat.o(125369);
      return bool;
    }
    AppMethodBeat.o(125369);
    return true;
  }
  
  public final void gFg()
  {
    AppMethodBeat.i(125367);
    if (this.tRS != null) {
      this.tRS.M(a.d.phonering, 0, true);
    }
    AppMethodBeat.o(125367);
  }
  
  public final void stopRing()
  {
    AppMethodBeat.i(125368);
    if (this.tRS != null) {
      this.tRS.stop();
    }
    AppMethodBeat.o(125368);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.a.a
 * JD-Core Version:    0.7.0.1
 */