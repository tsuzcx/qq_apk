package com.tencent.mm.ui.chatting.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.sdk.platformtools.bt;

public final class b
  extends com.tencent.mm.ui.chatting.c.a
  implements com.tencent.mm.ui.chatting.c.b.a
{
  private a GzD;
  
  public b(a parama)
  {
    this.GzD = parama;
  }
  
  private boolean eXa()
  {
    AppMethodBeat.i(35816);
    if (bt.isNullOrNil(this.cOd.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (w.tm(this.cOd.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (this.GzD != null)
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
    if (this.GzD != null) {
      this.GzD.a(parama);
    }
    AppMethodBeat.o(35804);
  }
  
  public final void eQA()
  {
    AppMethodBeat.i(35806);
    if (eXa()) {
      this.GzD.eQA();
    }
    AppMethodBeat.o(35806);
  }
  
  public final void eQB()
  {
    AppMethodBeat.i(35807);
    if (eXa()) {
      this.GzD.eQB();
    }
    AppMethodBeat.o(35807);
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35808);
    if (eXa()) {
      this.GzD.eQC();
    }
    AppMethodBeat.o(35808);
  }
  
  public final void eQD()
  {
    AppMethodBeat.i(35809);
    if (eXa()) {
      this.GzD.eQD();
    }
    AppMethodBeat.o(35809);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35810);
    if (eXa()) {
      this.GzD.eQE();
    }
    AppMethodBeat.o(35810);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35811);
    if (eXa()) {
      this.GzD.eQF();
    }
    AppMethodBeat.o(35811);
  }
  
  public final void eQG()
  {
    AppMethodBeat.i(35812);
    if (eXa()) {
      this.GzD.eQG();
    }
    AppMethodBeat.o(35812);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35805);
    super.eWx();
    if (this.GzD != null) {
      this.GzD.eWx();
    }
    AppMethodBeat.o(35805);
  }
  
  public final void eXQ()
  {
    AppMethodBeat.i(35813);
    if (eXa()) {
      this.GzD.eXQ();
    }
    AppMethodBeat.o(35813);
  }
  
  public final void eYU()
  {
    AppMethodBeat.i(35814);
    if (eXa()) {
      this.GzD.eYU();
    }
    AppMethodBeat.o(35814);
  }
  
  public final String eYV()
  {
    AppMethodBeat.i(35815);
    if (eXa())
    {
      String str = this.GzD.eYV();
      AppMethodBeat.o(35815);
      return str;
    }
    AppMethodBeat.o(35815);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.b
 * JD-Core Version:    0.7.0.1
 */