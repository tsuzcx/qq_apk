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
  
  public final void aa(int paramInt, String paramString)
  {
    AppMethodBeat.i(184045);
    super.aa(paramInt, paramString);
    bGv().nfG = 10;
    if (com.tencent.mm.plugin.voip.c.ehb() != null) {
      bGv().dlk = String.valueOf(com.tencent.mm.plugin.voip.c.ehb().AEF.Ayh.ABJ.tIG);
    }
    bGr();
    AppMethodBeat.o(184045);
  }
  
  public final void bGh()
  {
    AppMethodBeat.i(208207);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).iM(true);
    super.bGh();
    AppMethodBeat.o(208207);
  }
  
  public final boolean bcV()
  {
    return false;
  }
  
  public final boolean bcW()
  {
    return false;
  }
  
  public final void bcY()
  {
    AppMethodBeat.i(184048);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).iM(false);
    this.nfN.nfD.opType = 4;
    if (this.nfP != null) {
      this.nfP.q(this.nfN);
    }
    AppMethodBeat.o(184048);
  }
  
  public final void bcZ()
  {
    AppMethodBeat.i(184047);
    super.bcZ();
    this.ngF.gb(false);
    AppMethodBeat.o(184047);
  }
  
  public final boolean rT(int paramInt)
  {
    AppMethodBeat.i(184046);
    boolean bool = super.rT(paramInt);
    AppMethodBeat.o(184046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.b
 * JD-Core Version:    0.7.0.1
 */