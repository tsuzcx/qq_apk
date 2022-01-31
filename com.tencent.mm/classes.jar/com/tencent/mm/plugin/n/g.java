package com.tencent.mm.plugin.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class g
{
  public long axe = 0L;
  public long cNY = 0L;
  private boolean efg;
  public boolean lxE = true;
  public boolean lxF = false;
  public long oED = 0L;
  public long oEE = -1L;
  public long oEF = 0L;
  public long oEG = 0L;
  public long oEH = 0L;
  public long oEI = 10L;
  public boolean oEJ = true;
  public boolean oEK = false;
  boolean oEL = false;
  boolean oEM = false;
  
  public g(boolean paramBoolean)
  {
    this.efg = paramBoolean;
  }
  
  public final void TS(String paramString)
  {
    AppMethodBeat.i(117872);
    if (!this.oEJ)
    {
      AppMethodBeat.o(117872);
      return;
    }
    h.qsU.idkeyStat(354L, 152L, 1L, false);
    h.qsU.e(13836, new Object[] { Integer.valueOf(500), Long.valueOf(bo.aox()), paramString });
    AppMethodBeat.o(117872);
  }
  
  public final void TT(String paramString)
  {
    AppMethodBeat.i(117873);
    if (!this.oEJ)
    {
      AppMethodBeat.o(117873);
      return;
    }
    h.qsU.idkeyStat(354L, 153L, 1L, false);
    h.qsU.e(13836, new Object[] { Integer.valueOf(501), Long.valueOf(bo.aox()), paramString });
    AppMethodBeat.o(117873);
  }
  
  public final void bQu()
  {
    AppMethodBeat.i(117874);
    if (!this.oEJ)
    {
      AppMethodBeat.o(117874);
      return;
    }
    h.qsU.idkeyStat(354L, 155L, 1L, false);
    h.qsU.e(13836, new Object[] { Integer.valueOf(503), Long.valueOf(bo.aox()), "" });
    AppMethodBeat.o(117874);
  }
  
  public final String bau()
  {
    AppMethodBeat.i(117871);
    String str = hashCode();
    AppMethodBeat.o(117871);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.n.g
 * JD-Core Version:    0.7.0.1
 */