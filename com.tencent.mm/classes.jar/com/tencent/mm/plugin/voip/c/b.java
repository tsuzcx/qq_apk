package com.tencent.mm.plugin.voip.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ball.a.f;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.service.e;
import com.tencent.mm.plugin.voip.SubCoreVoip;
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
  
  public final void J(int paramInt, String paramString)
  {
    AppMethodBeat.i(184045);
    super.J(paramInt, paramString);
    cYv().mUU = 10;
    if (SubCoreVoip.hVp() != null) {
      cYv().hOH = String.valueOf(SubCoreVoip.hVp().UBE.UvO.UyU.Hnt);
    }
    cYr();
    AppMethodBeat.o(184045);
  }
  
  public final void bhT()
  {
    AppMethodBeat.i(292225);
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(true);
    super.bhT();
    AppMethodBeat.o(292225);
  }
  
  public final boolean bhU()
  {
    return false;
  }
  
  public final void bhV()
  {
    AppMethodBeat.i(184047);
    super.bhV();
    this.vkT.iR(false);
    AppMethodBeat.o(184047);
  }
  
  public final void bhW()
  {
    AppMethodBeat.i(184048);
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(false);
    this.vjV.vjI.opType = 4;
    if (this.vjX != null) {
      this.vjX.q(this.vjV);
    }
    AppMethodBeat.o(184048);
  }
  
  public final void hVv()
  {
    AppMethodBeat.i(292243);
    ((com.tencent.mm.plugin.ball.c.b)h.ax(com.tencent.mm.plugin.ball.c.b.class)).mq(true);
    this.vjV.vjI.opType = 4;
    if (this.vjX != null) {
      this.vjX.q(this.vjV);
    }
    AppMethodBeat.o(292243);
  }
  
  public final boolean zX(int paramInt)
  {
    AppMethodBeat.i(184046);
    boolean bool = super.zX(paramInt);
    AppMethodBeat.o(184046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.c.b
 * JD-Core Version:    0.7.0.1
 */