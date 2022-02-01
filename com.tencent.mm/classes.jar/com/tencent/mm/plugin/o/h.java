package com.tencent.mm.plugin.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bu;

public final class h
{
  public long bdJ = 0L;
  private int businessType;
  public long dQn = 0L;
  private boolean fOX;
  public boolean qbu = true;
  public boolean qbv = false;
  public long vXp = 0L;
  public long vXq = -1L;
  public long vXr = 0L;
  public long vXs = 0L;
  public long vXt = 0L;
  public long vXu = 10L;
  public boolean vXv = true;
  public boolean vXw = false;
  boolean vXx = false;
  boolean vXy = false;
  
  public h(boolean paramBoolean, int paramInt)
  {
    this.fOX = paramBoolean;
    this.businessType = paramInt;
  }
  
  public final void arM(String paramString)
  {
    AppMethodBeat.i(133911);
    if (!this.vXv)
    {
      AppMethodBeat.o(133911);
      return;
    }
    g.yxI.idkeyStat(dps(), 152L, 1L, false);
    g.yxI.f(dpr(), new Object[] { Integer.valueOf(500), Long.valueOf(bu.aRi()), paramString });
    AppMethodBeat.o(133911);
  }
  
  public final void arN(String paramString)
  {
    AppMethodBeat.i(133912);
    if (!this.vXv)
    {
      AppMethodBeat.o(133912);
      return;
    }
    g.yxI.idkeyStat(dps(), 153L, 1L, false);
    g.yxI.f(dpr(), new Object[] { Integer.valueOf(501), Long.valueOf(bu.aRi()), paramString });
    AppMethodBeat.o(133912);
  }
  
  public final void dpq()
  {
    AppMethodBeat.i(133913);
    if (!this.vXv)
    {
      AppMethodBeat.o(133913);
      return;
    }
    g.yxI.idkeyStat(dps(), 155L, 1L, false);
    g.yxI.f(dpr(), new Object[] { Integer.valueOf(503), Long.valueOf(bu.aRi()), "" });
    AppMethodBeat.o(133913);
  }
  
  public final int dpr()
  {
    if (this.businessType == 1) {
      return 20439;
    }
    return 13836;
  }
  
  public final int dps()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.o.h
 * JD-Core Version:    0.7.0.1
 */