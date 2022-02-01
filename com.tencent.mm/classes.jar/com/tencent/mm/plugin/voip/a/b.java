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
  
  public final void ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(184045);
    super.ac(paramInt, paramString);
    bLD().nLC = 10;
    if (com.tencent.mm.plugin.voip.c.eys() != null) {
      bLD().dyc = String.valueOf(com.tencent.mm.plugin.voip.c.eys().Cvg.Cpd.Csj.uXg);
    }
    bLz();
    AppMethodBeat.o(184045);
  }
  
  public final void bLp()
  {
    AppMethodBeat.i(209915);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).iU(true);
    super.bLp();
    AppMethodBeat.o(209915);
  }
  
  public final boolean bhh()
  {
    return false;
  }
  
  public final boolean bhi()
  {
    return false;
  }
  
  public final void bhk()
  {
    AppMethodBeat.i(184048);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).iU(false);
    this.nLK.nLw.opType = 4;
    if (this.nLM != null) {
      this.nLM.r(this.nLK);
    }
    AppMethodBeat.o(184048);
  }
  
  public final void bhl()
  {
    AppMethodBeat.i(184047);
    super.bhl();
    this.nME.ge(false);
    AppMethodBeat.o(184047);
  }
  
  public final boolean sy(int paramInt)
  {
    AppMethodBeat.i(184046);
    boolean bool = super.sy(paramInt);
    AppMethodBeat.o(184046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.b
 * JD-Core Version:    0.7.0.1
 */