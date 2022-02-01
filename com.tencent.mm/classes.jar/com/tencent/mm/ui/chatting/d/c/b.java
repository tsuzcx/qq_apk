package com.tencent.mm.ui.chatting.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends com.tencent.mm.ui.chatting.d.a
  implements com.tencent.mm.ui.chatting.d.b.a
{
  private a PvX;
  
  public b(a parama)
  {
    this.PvX = parama;
  }
  
  private boolean gPo()
  {
    AppMethodBeat.i(35816);
    if (Util.isNullOrNil(this.dom.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (ab.JB(this.dom.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (this.PvX != null)
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
    if (this.PvX != null) {
      this.PvX.a(parama);
    }
    AppMethodBeat.o(35804);
  }
  
  public final void cFx()
  {
    AppMethodBeat.i(35809);
    if (gPo()) {
      this.PvX.cFx();
    }
    AppMethodBeat.o(35809);
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35810);
    if (gPo()) {
      this.PvX.cFy();
    }
    AppMethodBeat.o(35810);
  }
  
  public final void gIk()
  {
    AppMethodBeat.i(35806);
    if (gPo()) {
      this.PvX.gIk();
    }
    AppMethodBeat.o(35806);
  }
  
  public final void gIl()
  {
    AppMethodBeat.i(35807);
    if (gPo()) {
      this.PvX.gIl();
    }
    AppMethodBeat.o(35807);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35808);
    if (gPo()) {
      this.PvX.gIm();
    }
    AppMethodBeat.o(35808);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35811);
    if (gPo()) {
      this.PvX.gIn();
    }
    AppMethodBeat.o(35811);
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(35812);
    if (gPo()) {
      this.PvX.gIo();
    }
    AppMethodBeat.o(35812);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35805);
    super.gOK();
    if (this.PvX != null) {
      this.PvX.gOK();
    }
    AppMethodBeat.o(35805);
  }
  
  public final void gPx()
  {
    AppMethodBeat.i(35813);
    if (gPo()) {
      this.PvX.gPx();
    }
    AppMethodBeat.o(35813);
  }
  
  public final void gRG()
  {
    AppMethodBeat.i(35814);
    if (gPo()) {
      this.PvX.gRG();
    }
    AppMethodBeat.o(35814);
  }
  
  public final String gRH()
  {
    AppMethodBeat.i(35815);
    if (gPo())
    {
      String str = this.PvX.gRH();
      AppMethodBeat.o(35815);
      return str;
    }
    AppMethodBeat.o(35815);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.b
 * JD-Core Version:    0.7.0.1
 */