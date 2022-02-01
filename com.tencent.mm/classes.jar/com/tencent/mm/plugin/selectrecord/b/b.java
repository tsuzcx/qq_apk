package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ia;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static b JcK = null;
  public ia JcL;
  
  public b()
  {
    AppMethodBeat.i(255260);
    this.JcL = null;
    this.JcL = new ia();
    AppMethodBeat.o(255260);
  }
  
  public static b fFC()
  {
    AppMethodBeat.i(255255);
    if (JcK == null) {
      fFD();
    }
    b localb = JcK;
    AppMethodBeat.o(255255);
    return localb;
  }
  
  public static void fFD()
  {
    AppMethodBeat.i(255257);
    JcK = new b();
    AppMethodBeat.o(255257);
  }
  
  public final void Qb(long paramLong)
  {
    this.JcL.gHK = paramLong;
  }
  
  public final void aej(int paramInt)
  {
    AppMethodBeat.i(255263);
    ia localia = this.JcL;
    localia.gHJ = localia.z("HasConfirmed", String.valueOf(paramInt), true);
    AppMethodBeat.o(255263);
  }
  
  public final boolean bpa()
  {
    AppMethodBeat.i(255265);
    this.JcL.gHO = 1L;
    Log.d("MicroMsg.MultiMessageForwardReportManager", "%s", new Object[] { this.JcL.agI() });
    boolean bool = this.JcL.bpa();
    AppMethodBeat.o(255265);
    return bool;
  }
  
  public final boolean fFE()
  {
    AppMethodBeat.i(255264);
    aej(2);
    boolean bool = bpa();
    AppMethodBeat.o(255264);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.b
 * JD-Core Version:    0.7.0.1
 */