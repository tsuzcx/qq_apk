package com.tencent.mm.plugin.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bt;

public final class h
{
  public long aSw = 0L;
  public long bof = 0L;
  private boolean fqj;
  public boolean oNP = true;
  public boolean oNQ = false;
  public long tzJ = 0L;
  public long tzK = -1L;
  public long tzL = 0L;
  public long tzM = 0L;
  public long tzN = 0L;
  public long tzO = 10L;
  public boolean tzP = true;
  public boolean tzQ = false;
  boolean tzR = false;
  boolean tzS = false;
  
  public h(boolean paramBoolean)
  {
    this.fqj = paramBoolean;
  }
  
  public final void agX(String paramString)
  {
    AppMethodBeat.i(133911);
    if (!this.tzP)
    {
      AppMethodBeat.o(133911);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 152L, 1L, false);
    com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(500), Long.valueOf(bt.aGK()), paramString });
    AppMethodBeat.o(133911);
  }
  
  public final void agY(String paramString)
  {
    AppMethodBeat.i(133912);
    if (!this.tzP)
    {
      AppMethodBeat.o(133912);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 153L, 1L, false);
    com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(501), Long.valueOf(bt.aGK()), paramString });
    AppMethodBeat.o(133912);
  }
  
  public final void cPp()
  {
    AppMethodBeat.i(133913);
    if (!this.tzP)
    {
      AppMethodBeat.o(133913);
      return;
    }
    com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(354L, 155L, 1L, false);
    com.tencent.mm.plugin.report.service.h.vKh.f(13836, new Object[] { Integer.valueOf(503), Long.valueOf(bt.aGK()), "" });
    AppMethodBeat.o(133913);
  }
  
  public final String info()
  {
    AppMethodBeat.i(133910);
    String str = hashCode();
    AppMethodBeat.o(133910);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.o.h
 * JD-Core Version:    0.7.0.1
 */