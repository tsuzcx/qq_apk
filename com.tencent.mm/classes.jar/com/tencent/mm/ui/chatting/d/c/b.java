package com.tencent.mm.ui.chatting.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.sdk.platformtools.Util;

public final class b
  extends com.tencent.mm.ui.chatting.d.a
  implements com.tencent.mm.ui.chatting.d.b.a
{
  private a WQq;
  
  public b(a parama)
  {
    this.WQq = parama;
  }
  
  private boolean hOE()
  {
    AppMethodBeat.i(35816);
    if (Util.isNullOrNil(this.fgR.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (ab.QU(this.fgR.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (this.WQq != null)
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
    if (this.WQq != null) {
      this.WQq.a(parama);
    }
    AppMethodBeat.o(35804);
  }
  
  public final void hGU()
  {
    AppMethodBeat.i(35806);
    if (hOE()) {
      this.WQq.hGU();
    }
    AppMethodBeat.o(35806);
  }
  
  public final void hGV()
  {
    AppMethodBeat.i(35807);
    if (hOE()) {
      this.WQq.hGV();
    }
    AppMethodBeat.o(35807);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35808);
    if (hOE()) {
      this.WQq.hGW();
    }
    AppMethodBeat.o(35808);
  }
  
  public final void hGX()
  {
    AppMethodBeat.i(35809);
    if (hOE()) {
      this.WQq.hGX();
    }
    AppMethodBeat.o(35809);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35810);
    if (hOE()) {
      this.WQq.hGY();
    }
    AppMethodBeat.o(35810);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35811);
    if (hOE()) {
      this.WQq.hGZ();
    }
    AppMethodBeat.o(35811);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(35812);
    if (hOE()) {
      this.WQq.hHa();
    }
    AppMethodBeat.o(35812);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35805);
    super.hNZ();
    if (this.WQq != null) {
      this.WQq.hNZ();
    }
    AppMethodBeat.o(35805);
  }
  
  public final void hOL()
  {
    AppMethodBeat.i(35813);
    if (hOE()) {
      this.WQq.hOL();
    }
    AppMethodBeat.o(35813);
  }
  
  public final void hRd()
  {
    AppMethodBeat.i(35814);
    if (hOE()) {
      this.WQq.hRd();
    }
    AppMethodBeat.o(35814);
  }
  
  public final String hRe()
  {
    AppMethodBeat.i(35815);
    if (hOE())
    {
      String str = this.WQq.hRe();
      AppMethodBeat.o(35815);
      return str;
    }
    AppMethodBeat.o(35815);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.b
 * JD-Core Version:    0.7.0.1
 */