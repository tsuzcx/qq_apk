package com.tencent.mm.ui.chatting.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  extends com.tencent.mm.ui.chatting.c.a
  implements com.tencent.mm.ui.chatting.c.b.a
{
  private a HZz;
  
  public b(a parama)
  {
    this.HZz = parama;
  }
  
  private boolean fmM()
  {
    AppMethodBeat.i(35816);
    if (bs.isNullOrNil(this.cLy.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (w.xp(this.cLy.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (this.HZz != null)
    {
      AppMethodBeat.o(35816);
      return true;
    }
    AppMethodBeat.o(35816);
    return false;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(35804);
    super.a(parama);
    if (this.HZz != null) {
      this.HZz.a(parama);
    }
    AppMethodBeat.o(35804);
  }
  
  public final void fgg()
  {
    AppMethodBeat.i(35806);
    if (fmM()) {
      this.HZz.fgg();
    }
    AppMethodBeat.o(35806);
  }
  
  public final void fgh()
  {
    AppMethodBeat.i(35807);
    if (fmM()) {
      this.HZz.fgh();
    }
    AppMethodBeat.o(35807);
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35808);
    if (fmM()) {
      this.HZz.fgi();
    }
    AppMethodBeat.o(35808);
  }
  
  public final void fgj()
  {
    AppMethodBeat.i(35809);
    if (fmM()) {
      this.HZz.fgj();
    }
    AppMethodBeat.o(35809);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35810);
    if (fmM()) {
      this.HZz.fgk();
    }
    AppMethodBeat.o(35810);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35811);
    if (fmM()) {
      this.HZz.fgl();
    }
    AppMethodBeat.o(35811);
  }
  
  public final void fgm()
  {
    AppMethodBeat.i(35812);
    if (fmM()) {
      this.HZz.fgm();
    }
    AppMethodBeat.o(35812);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35805);
    super.fmj();
    if (this.HZz != null) {
      this.HZz.fmj();
    }
    AppMethodBeat.o(35805);
  }
  
  public final void fnC()
  {
    AppMethodBeat.i(35813);
    if (fmM()) {
      this.HZz.fnC();
    }
    AppMethodBeat.o(35813);
  }
  
  public final void foK()
  {
    AppMethodBeat.i(35814);
    if (fmM()) {
      this.HZz.foK();
    }
    AppMethodBeat.o(35814);
  }
  
  public final String foL()
  {
    AppMethodBeat.i(35815);
    if (fmM())
    {
      String str = this.HZz.foL();
      AppMethodBeat.o(35815);
      return str;
    }
    AppMethodBeat.o(35815);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.b
 * JD-Core Version:    0.7.0.1
 */