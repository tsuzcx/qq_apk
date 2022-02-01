package com.tencent.mm.plugin.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  public long KSB = 0L;
  public long KSC = -1L;
  public long KSD = 0L;
  public long KSE = 0L;
  public long KSF = 0L;
  public long KSG = 10L;
  public boolean KSH = true;
  public boolean KSI = false;
  boolean KSJ = false;
  boolean KSK = false;
  private int businessType;
  public long cHd = 0L;
  private boolean lAj;
  public long startMs = 0L;
  public boolean ykl = true;
  public boolean ykm = false;
  
  public h(boolean paramBoolean, int paramInt)
  {
    this.lAj = paramBoolean;
    this.businessType = paramInt;
  }
  
  public final void aMp(String paramString)
  {
    AppMethodBeat.i(133911);
    if (!this.KSH)
    {
      AppMethodBeat.o(133911);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(gbG(), 152L, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.b(gbF(), new Object[] { Integer.valueOf(500), Long.valueOf(Util.nowSecond()), paramString });
    AppMethodBeat.o(133911);
  }
  
  public final void aMq(String paramString)
  {
    AppMethodBeat.i(133912);
    if (!this.KSH)
    {
      AppMethodBeat.o(133912);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(gbG(), 153L, 1L, false);
    com.tencent.mm.plugin.report.service.h.OAn.b(gbF(), new Object[] { Integer.valueOf(501), Long.valueOf(Util.nowSecond()), paramString });
    AppMethodBeat.o(133912);
  }
  
  public final int gbF()
  {
    if (this.businessType == 1) {
      return 20439;
    }
    return 13836;
  }
  
  public final int gbG()
  {
    if (this.businessType == 1) {
      return 1427;
    }
    return 354;
  }
  
  public final String info()
  {
    AppMethodBeat.i(133910);
    String str = hashCode();
    AppMethodBeat.o(133910);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.u.h
 * JD-Core Version:    0.7.0.1
 */