package com.tencent.mm.ui.chatting.d.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.sdk.platformtools.bu;

public final class b
  extends com.tencent.mm.ui.chatting.d.a
  implements com.tencent.mm.ui.chatting.d.b.a
{
  private a KjX;
  
  public b(a parama)
  {
    this.KjX = parama;
  }
  
  private boolean fHi()
  {
    AppMethodBeat.i(35816);
    if (bu.isNullOrNil(this.cXJ.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (x.AW(this.cXJ.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (this.KjX != null)
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
    if (this.KjX != null) {
      this.KjX.a(parama);
    }
    AppMethodBeat.o(35804);
  }
  
  public final void fAs()
  {
    AppMethodBeat.i(35806);
    if (fHi()) {
      this.KjX.fAs();
    }
    AppMethodBeat.o(35806);
  }
  
  public final void fAt()
  {
    AppMethodBeat.i(35807);
    if (fHi()) {
      this.KjX.fAt();
    }
    AppMethodBeat.o(35807);
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35808);
    if (fHi()) {
      this.KjX.fAu();
    }
    AppMethodBeat.o(35808);
  }
  
  public final void fAv()
  {
    AppMethodBeat.i(35809);
    if (fHi()) {
      this.KjX.fAv();
    }
    AppMethodBeat.o(35809);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35810);
    if (fHi()) {
      this.KjX.fAw();
    }
    AppMethodBeat.o(35810);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35811);
    if (fHi()) {
      this.KjX.fAx();
    }
    AppMethodBeat.o(35811);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(35812);
    if (fHi()) {
      this.KjX.fAy();
    }
    AppMethodBeat.o(35812);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35805);
    super.fGE();
    if (this.KjX != null) {
      this.KjX.fGE();
    }
    AppMethodBeat.o(35805);
  }
  
  public final void fHr()
  {
    AppMethodBeat.i(35813);
    if (fHi()) {
      this.KjX.fHr();
    }
    AppMethodBeat.o(35813);
  }
  
  public final void fJw()
  {
    AppMethodBeat.i(35814);
    if (fHi()) {
      this.KjX.fJw();
    }
    AppMethodBeat.o(35814);
  }
  
  public final String fJx()
  {
    AppMethodBeat.i(35815);
    if (fHi())
    {
      String str = this.KjX.fJx();
      AppMethodBeat.o(35815);
      return str;
    }
    AppMethodBeat.o(35815);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.c.b
 * JD-Core Version:    0.7.0.1
 */