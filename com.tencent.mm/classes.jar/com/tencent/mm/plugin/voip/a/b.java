package com.tencent.mm.plugin.voip.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.a;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;

public final class b
  extends com.tencent.mm.plugin.ball.service.f
{
  public b(com.tencent.mm.plugin.ball.a.f paramf)
  {
    super(paramf);
  }
  
  public final void G(int paramInt, String paramString)
  {
    AppMethodBeat.i(184045);
    super.G(paramInt, paramString);
    ciw().hDa = 10;
    if (c.fFg() != null) {
      ciw().dPJ = String.valueOf(c.fFg().GYS.GSZ.GVV.ypH);
    }
    cit();
    AppMethodBeat.o(184045);
  }
  
  public final void aGf()
  {
    AppMethodBeat.i(235478);
    ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(true);
    super.aGf();
    AppMethodBeat.o(235478);
  }
  
  public final boolean aGg()
  {
    return false;
  }
  
  public final boolean aGh()
  {
    return false;
  }
  
  public final void aGi()
  {
    AppMethodBeat.i(184047);
    super.aGi();
    this.oXA.hb(false);
    AppMethodBeat.o(184047);
  }
  
  public final void aGj()
  {
    AppMethodBeat.i(184048);
    ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(false);
    this.oWE.oWs.opType = 4;
    if (this.oWG != null) {
      this.oWG.q(this.oWE);
    }
    AppMethodBeat.o(184048);
  }
  
  public final void fFm()
  {
    AppMethodBeat.i(235479);
    ((com.tencent.mm.plugin.ball.c.b)g.af(com.tencent.mm.plugin.ball.c.b.class)).jS(true);
    this.oWE.oWs.opType = 4;
    if (this.oWG != null) {
      this.oWG.q(this.oWE);
    }
    AppMethodBeat.o(235479);
  }
  
  public final boolean wu(int paramInt)
  {
    AppMethodBeat.i(184046);
    boolean bool = super.wu(paramInt);
    AppMethodBeat.o(184046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.b
 * JD-Core Version:    0.7.0.1
 */