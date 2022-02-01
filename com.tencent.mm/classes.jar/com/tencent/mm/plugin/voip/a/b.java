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
    bKG().nGc = 10;
    if (com.tencent.mm.plugin.voip.c.euM() != null) {
      bKG().dwX = String.valueOf(com.tencent.mm.plugin.voip.c.euM().CdF.BXC.CaI.uLt);
    }
    bKC();
    AppMethodBeat.o(184045);
  }
  
  public final void bKs()
  {
    AppMethodBeat.i(216238);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).iV(true);
    super.bKs();
    AppMethodBeat.o(216238);
  }
  
  public final boolean bgA()
  {
    return false;
  }
  
  public final void bgC()
  {
    AppMethodBeat.i(184048);
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).iV(false);
    this.nGj.nFZ.opType = 4;
    if (this.nGl != null) {
      this.nGl.r(this.nGj);
    }
    AppMethodBeat.o(184048);
  }
  
  public final void bgD()
  {
    AppMethodBeat.i(184047);
    super.bgD();
    this.nHb.gg(false);
    AppMethodBeat.o(184047);
  }
  
  public final boolean bgz()
  {
    return false;
  }
  
  public final boolean sv(int paramInt)
  {
    AppMethodBeat.i(184046);
    boolean bool = super.sv(paramInt);
    AppMethodBeat.o(184046);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.a.b
 * JD-Core Version:    0.7.0.1
 */