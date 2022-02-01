package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class h
{
  public long bdG = 0L;
  private int businessType;
  public long eiq = 0L;
  private boolean guh;
  public boolean rsr = true;
  public boolean rss = false;
  boolean zrA = false;
  public long zrr = 0L;
  public long zrs = -1L;
  public long zrt = 0L;
  public long zru = 0L;
  public long zrv = 0L;
  public long zrw = 10L;
  public boolean zrx = true;
  public boolean zry = false;
  boolean zrz = false;
  
  public h(boolean paramBoolean, int paramInt)
  {
    this.guh = paramBoolean;
    this.businessType = paramInt;
  }
  
  public final void aFh(String paramString)
  {
    AppMethodBeat.i(133911);
    if (!this.zrx)
    {
      AppMethodBeat.o(133911);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(ejh(), 152L, 1L, false);
    com.tencent.mm.plugin.report.service.h.CyF.a(ejg(), new Object[] { Integer.valueOf(500), Long.valueOf(Util.nowSecond()), paramString });
    AppMethodBeat.o(133911);
  }
  
  public final void aFi(String paramString)
  {
    AppMethodBeat.i(133912);
    if (!this.zrx)
    {
      AppMethodBeat.o(133912);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(ejh(), 153L, 1L, false);
    com.tencent.mm.plugin.report.service.h.CyF.a(ejg(), new Object[] { Integer.valueOf(501), Long.valueOf(Util.nowSecond()), paramString });
    AppMethodBeat.o(133912);
  }
  
  public final void ejf()
  {
    AppMethodBeat.i(133913);
    if (!this.zrx)
    {
      AppMethodBeat.o(133913);
      return;
    }
    com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(ejh(), 155L, 1L, false);
    com.tencent.mm.plugin.report.service.h.CyF.a(ejg(), new Object[] { Integer.valueOf(503), Long.valueOf(Util.nowSecond()), "" });
    AppMethodBeat.o(133913);
  }
  
  public final int ejg()
  {
    if (this.businessType == 1) {
      return 20439;
    }
    return 13836;
  }
  
  public final int ejh()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.n.h
 * JD-Core Version:    0.7.0.1
 */