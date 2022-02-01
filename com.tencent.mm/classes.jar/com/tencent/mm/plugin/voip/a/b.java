package com.tencent.mm.plugin.voip.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.a;
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
  
  public final void Z(int paramInt, String paramString)
  {
    AppMethodBeat.i(184045);
    super.Z(paramInt, paramString);
    bzz().mDz = 10;
    if (com.tencent.mm.plugin.voip.c.dRQ() != null) {
      bzz().dnC = String.valueOf(com.tencent.mm.plugin.voip.c.dRQ().zlR.zfA.ziZ.sAY);
    }
    bzv();
    AppMethodBeat.o(184045);
  }
  
  public final boolean aVX()
  {
    return false;
  }
  
  public final boolean aVY()
  {
    return false;
  }
  
  public final void aWa()
  {
    AppMethodBeat.i(184048);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).im(false);
    this.mDH.mDw.opType = 4;
    if (this.mDJ != null) {
      this.mDJ.p(this.mDH);
    }
    AppMethodBeat.o(184048);
  }
  
  public final void aWb()
  {
    AppMethodBeat.i(184047);
    super.aWb();
    this.mEA.fF(false);
    AppMethodBeat.o(184047);
  }
  
  public final void bzl()
  {
    AppMethodBeat.i(191889);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).im(true);
    super.bzl();
    AppMethodBeat.o(191889);
  }
  
  public final boolean rg(int paramInt)
  {
    AppMethodBeat.i(184046);
    boolean bool = super.rg(paramInt);
    AppMethodBeat.o(184046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.b
 * JD-Core Version:    0.7.0.1
 */