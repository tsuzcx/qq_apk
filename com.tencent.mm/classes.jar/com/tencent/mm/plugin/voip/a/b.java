package com.tencent.mm.plugin.voip.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.plugin.voip.c;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;

public final class b
  extends e
{
  public b(f paramf)
  {
    super(paramf);
  }
  
  public final void I(int paramInt, String paramString)
  {
    AppMethodBeat.i(184045);
    super.I(paramInt, paramString);
    cvL().kqZ = 10;
    if (c.gxs() != null) {
      cvL().fIZ = String.valueOf(c.gxs().NPf.NJk.NMi.DPJ);
    }
    cvG();
    AppMethodBeat.o(184045);
  }
  
  public final void aOf()
  {
    AppMethodBeat.i(242937);
    ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(true);
    super.aOf();
    AppMethodBeat.o(242937);
  }
  
  public final boolean aOg()
  {
    return false;
  }
  
  public final boolean aOh()
  {
    return false;
  }
  
  public final void aOi()
  {
    AppMethodBeat.i(184047);
    super.aOi();
    this.rZC.hS(false);
    AppMethodBeat.o(184047);
  }
  
  public final void aOj()
  {
    AppMethodBeat.i(184048);
    ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(false);
    this.rYE.rYs.opType = 4;
    if (this.rYG != null) {
      this.rYG.q(this.rYE);
    }
    AppMethodBeat.o(184048);
  }
  
  public final void gxy()
  {
    AppMethodBeat.i(242942);
    ((com.tencent.mm.plugin.ball.c.b)h.ae(com.tencent.mm.plugin.ball.c.b.class)).ld(true);
    this.rYE.rYs.opType = 4;
    if (this.rYG != null) {
      this.rYG.q(this.rYE);
    }
    AppMethodBeat.o(242942);
  }
  
  public final boolean zH(int paramInt)
  {
    AppMethodBeat.i(184046);
    boolean bool = super.zH(paramInt);
    AppMethodBeat.o(184046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.b
 * JD-Core Version:    0.7.0.1
 */