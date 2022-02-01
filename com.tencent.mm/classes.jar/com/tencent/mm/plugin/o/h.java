package com.tencent.mm.plugin.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
{
  public long bdJ = 0L;
  private int businessType;
  public long dOX = 0L;
  private boolean fMP;
  public boolean pUP = true;
  public boolean pUQ = false;
  public long vLl = 0L;
  public long vLm = -1L;
  public long vLn = 0L;
  public long vLo = 0L;
  public long vLp = 0L;
  public long vLq = 10L;
  public boolean vLr = true;
  public boolean vLs = false;
  boolean vLt = false;
  boolean vLu = false;
  
  public h(boolean paramBoolean, int paramInt)
  {
    this.fMP = paramBoolean;
    this.businessType = paramInt;
  }
  
  public final void aqH(String paramString)
  {
    AppMethodBeat.i(133911);
    if (!this.vLr)
    {
      AppMethodBeat.o(133911);
      return;
    }
    g.yhR.idkeyStat(dmu(), 152L, 1L, false);
    g.yhR.f(dmt(), new Object[] { Integer.valueOf(500), Long.valueOf(bt.aQJ()), paramString });
    AppMethodBeat.o(133911);
  }
  
  public final void aqI(String paramString)
  {
    AppMethodBeat.i(133912);
    if (!this.vLr)
    {
      AppMethodBeat.o(133912);
      return;
    }
    g.yhR.idkeyStat(dmu(), 153L, 1L, false);
    g.yhR.f(dmt(), new Object[] { Integer.valueOf(501), Long.valueOf(bt.aQJ()), paramString });
    AppMethodBeat.o(133912);
  }
  
  public final void dms()
  {
    AppMethodBeat.i(133913);
    if (!this.vLr)
    {
      AppMethodBeat.o(133913);
      return;
    }
    g.yhR.idkeyStat(dmu(), 155L, 1L, false);
    g.yhR.f(dmt(), new Object[] { Integer.valueOf(503), Long.valueOf(bt.aQJ()), "" });
    AppMethodBeat.o(133913);
  }
  
  public final int dmt()
  {
    if (this.businessType == 1) {
      return 20439;
    }
    return 13836;
  }
  
  public final int dmu()
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