package com.tencent.mm.ui.chatting.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends com.tencent.mm.ui.chatting.d.a
  implements com.tencent.mm.ui.chatting.d.b.a
{
  private a JOL;
  
  public b(a parama)
  {
    this.JOL = parama;
  }
  
  private boolean fDg()
  {
    AppMethodBeat.i(35816);
    if (bt.isNullOrNil(this.cWM.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (w.Am(this.cWM.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (this.JOL != null)
    {
      AppMethodBeat.o(35816);
      return true;
    }
    AppMethodBeat.o(35816);
    return false;
  }
  
  public final void a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(35804);
    super.a(parama);
    if (this.JOL != null) {
      this.JOL.a(parama);
    }
    AppMethodBeat.o(35804);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35805);
    super.fCC();
    if (this.JOL != null) {
      this.JOL.fCC();
    }
    AppMethodBeat.o(35805);
  }
  
  public final void fDo()
  {
    AppMethodBeat.i(35813);
    if (fDg()) {
      this.JOL.fDo();
    }
    AppMethodBeat.o(35813);
  }
  
  public final void fFp()
  {
    AppMethodBeat.i(35814);
    if (fDg()) {
      this.JOL.fFp();
    }
    AppMethodBeat.o(35814);
  }
  
  public final String fFq()
  {
    AppMethodBeat.i(35815);
    if (fDg())
    {
      String str = this.JOL.fFq();
      AppMethodBeat.o(35815);
      return str;
    }
    AppMethodBeat.o(35815);
    return null;
  }
  
  public final void fws()
  {
    AppMethodBeat.i(35806);
    if (fDg()) {
      this.JOL.fws();
    }
    AppMethodBeat.o(35806);
  }
  
  public final void fwt()
  {
    AppMethodBeat.i(35807);
    if (fDg()) {
      this.JOL.fwt();
    }
    AppMethodBeat.o(35807);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35808);
    if (fDg()) {
      this.JOL.fwu();
    }
    AppMethodBeat.o(35808);
  }
  
  public final void fwv()
  {
    AppMethodBeat.i(35809);
    if (fDg()) {
      this.JOL.fwv();
    }
    AppMethodBeat.o(35809);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35810);
    if (fDg()) {
      this.JOL.fww();
    }
    AppMethodBeat.o(35810);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35811);
    if (fDg()) {
      this.JOL.fwx();
    }
    AppMethodBeat.o(35811);
  }
  
  public final void fwy()
  {
    AppMethodBeat.i(35812);
    if (fDg()) {
      this.JOL.fwy();
    }
    AppMethodBeat.o(35812);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.b
 * JD-Core Version:    0.7.0.1
 */