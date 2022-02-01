package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ke;
import com.tencent.mm.sdk.platformtools.Log;

public final class d
{
  public static d PmH = null;
  public ke PmI;
  
  public d()
  {
    AppMethodBeat.i(266724);
    this.PmI = null;
    this.PmI = new ke();
    AppMethodBeat.o(266724);
  }
  
  public static d gUK()
  {
    AppMethodBeat.i(266715);
    if (PmH == null) {
      gUL();
    }
    d locald = PmH;
    AppMethodBeat.o(266715);
    return locald;
  }
  
  public static void gUL()
  {
    AppMethodBeat.i(266720);
    PmH = new d();
    AppMethodBeat.o(266720);
  }
  
  public final void aiO(int paramInt)
  {
    AppMethodBeat.i(266736);
    ke localke = this.PmI;
    localke.iWb = localke.F("HasConfirmed", String.valueOf(paramInt), true);
    AppMethodBeat.o(266736);
  }
  
  public final boolean bMH()
  {
    AppMethodBeat.i(266761);
    this.PmI.iWg = 1L;
    Log.d("MicroMsg.MultiMessageForwardReportManager", "%s", new Object[] { this.PmI.aIF() });
    boolean bool = this.PmI.bMH();
    AppMethodBeat.o(266761);
    return bool;
  }
  
  public final boolean gUM()
  {
    AppMethodBeat.i(266753);
    aiO(2);
    boolean bool = bMH();
    AppMethodBeat.o(266753);
    return bool;
  }
  
  public final void ug(long paramLong)
  {
    this.PmI.iWc = paramLong;
  }
  
  public final void uh(long paramLong)
  {
    this.PmI.iWe = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.d
 * JD-Core Version:    0.7.0.1
 */