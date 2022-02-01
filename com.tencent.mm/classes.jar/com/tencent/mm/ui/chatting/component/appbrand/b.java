package com.tencent.mm.ui.chatting.component.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;

public final class b
  extends com.tencent.mm.ui.chatting.component.a
  implements com.tencent.mm.ui.chatting.component.api.a
{
  private a aezJ;
  
  public b(a parama)
  {
    this.aezJ = parama;
  }
  
  private boolean jrv()
  {
    AppMethodBeat.i(35816);
    if (Util.isNullOrNil(this.hlc.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (au.bwy(this.hlc.getTalkerUserName()))
    {
      AppMethodBeat.o(35816);
      return false;
    }
    if (this.aezJ != null)
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
    if (this.aezJ != null) {
      this.aezJ.a(parama);
    }
    AppMethodBeat.o(35804);
  }
  
  public final void jjf()
  {
    AppMethodBeat.i(35806);
    if (jrv()) {
      this.aezJ.jjf();
    }
    AppMethodBeat.o(35806);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(35807);
    if (jrv()) {
      this.aezJ.jjg();
    }
    AppMethodBeat.o(35807);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35808);
    if (jrv()) {
      this.aezJ.jjh();
    }
    AppMethodBeat.o(35808);
  }
  
  public final void jji()
  {
    AppMethodBeat.i(35809);
    if (jrv()) {
      this.aezJ.jji();
    }
    AppMethodBeat.o(35809);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35810);
    if (jrv()) {
      this.aezJ.jjj();
    }
    AppMethodBeat.o(35810);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35811);
    if (jrv()) {
      this.aezJ.jjk();
    }
    AppMethodBeat.o(35811);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(35812);
    if (jrv()) {
      this.aezJ.jjl();
    }
    AppMethodBeat.o(35812);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35805);
    super.jqF();
    if (this.aezJ != null) {
      this.aezJ.jqF();
    }
    AppMethodBeat.o(35805);
  }
  
  public final void jrB()
  {
    AppMethodBeat.i(35813);
    if (jrv()) {
      this.aezJ.jrB();
    }
    AppMethodBeat.o(35813);
  }
  
  public final void juC()
  {
    AppMethodBeat.i(35814);
    if (jrv()) {
      this.aezJ.juC();
    }
    AppMethodBeat.o(35814);
  }
  
  public final String juD()
  {
    AppMethodBeat.i(35815);
    if (jrv())
    {
      String str = this.aezJ.juD();
      AppMethodBeat.o(35815);
      return str;
    }
    AppMethodBeat.o(35815);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.appbrand.b
 * JD-Core Version:    0.7.0.1
 */