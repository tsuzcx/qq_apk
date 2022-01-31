package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.c.a;

final class j$2$1
  implements c.a
{
  j$2$1(j.2 param2) {}
  
  public final void b(Addr paramAddr)
  {
    AppMethodBeat.i(9822);
    if ((this.vsd.vsc.vrU != null) && (this.vsd.vsc.vrY != null))
    {
      this.vsd.vsc.vrU.vse = paramAddr.agM();
      this.vsd.vsc.dgR();
    }
    AppMethodBeat.o(9822);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.2.1
 * JD-Core Version:    0.7.0.1
 */