package com.tencent.mm.plugin.o;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public final class h
{
  public long aTp = 0L;
  public long dCK = 0L;
  private boolean ftN;
  public boolean prj = true;
  public boolean prk = false;
  public long uIg = 0L;
  public long uIh = -1L;
  public long uIi = 0L;
  public long uIj = 0L;
  public long uIk = 0L;
  public long uIl = 10L;
  public boolean uIm = true;
  public boolean uIn = false;
  boolean uIo = false;
  boolean uIp = false;
  
  public h(boolean paramBoolean)
  {
    this.ftN = paramBoolean;
  }
  
  public final void alS(String paramString)
  {
    AppMethodBeat.i(133911);
    if (!this.uIm)
    {
      AppMethodBeat.o(133911);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 152L, 1L, false);
    com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(500), Long.valueOf(bs.aNx()), paramString });
    AppMethodBeat.o(133911);
  }
  
  public final void alT(String paramString)
  {
    AppMethodBeat.i(133912);
    if (!this.uIm)
    {
      AppMethodBeat.o(133912);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 153L, 1L, false);
    com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(501), Long.valueOf(bs.aNx()), paramString });
    AppMethodBeat.o(133912);
  }
  
  public final void dcY()
  {
    AppMethodBeat.i(133913);
    if (!this.uIm)
    {
      AppMethodBeat.o(133913);
      return;
    }
    com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(354L, 155L, 1L, false);
    com.tencent.mm.plugin.report.service.h.wUl.f(13836, new Object[] { Integer.valueOf(503), Long.valueOf(bs.aNx()), "" });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.o.h
 * JD-Core Version:    0.7.0.1
 */