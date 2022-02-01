package com.tencent.mm.plugin.u;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  public long EWP = 0L;
  public long EWQ = -1L;
  public long EWR = 0L;
  public long EWS = 0L;
  public long EWT = 0L;
  public long EWU = 10L;
  public boolean EWV = true;
  public boolean EWW = false;
  boolean EWX = false;
  boolean EWY = false;
  public long aNh = 0L;
  private int businessType;
  public long gcH = 0L;
  private boolean iYs;
  public boolean uXX = true;
  public boolean uXY = false;
  
  public h(boolean paramBoolean, int paramInt)
  {
    this.iYs = paramBoolean;
    this.businessType = paramInt;
  }
  
  public final void aPr(String paramString)
  {
    AppMethodBeat.i(133911);
    if (!this.EWV)
    {
      AppMethodBeat.o(133911);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(eSN(), 152L, 1L, false);
    com.tencent.mm.plugin.report.service.h.IzE.a(eSM(), new Object[] { Integer.valueOf(500), Long.valueOf(Util.nowSecond()), paramString });
    AppMethodBeat.o(133911);
  }
  
  public final void aPs(String paramString)
  {
    AppMethodBeat.i(133912);
    if (!this.EWV)
    {
      AppMethodBeat.o(133912);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(eSN(), 153L, 1L, false);
    com.tencent.mm.plugin.report.service.h.IzE.a(eSM(), new Object[] { Integer.valueOf(501), Long.valueOf(Util.nowSecond()), paramString });
    AppMethodBeat.o(133912);
  }
  
  public final int eSM()
  {
    if (this.businessType == 1) {
      return 20439;
    }
    return 13836;
  }
  
  public final int eSN()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.u.h
 * JD-Core Version:    0.7.0.1
 */