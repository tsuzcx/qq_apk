package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.modelgeo.d;

final class j$1
  implements Runnable
{
  j$1(j paramj) {}
  
  public final void run()
  {
    AppMethodBeat.i(9821);
    if ((this.vsc.vsa == null) || (this.vsc.fwu == null))
    {
      AppMethodBeat.o(9821);
      return;
    }
    this.vsc.ofr.a(this.vsc.vrY);
    this.vsc.fwu.c(this.vsc.vsa);
    this.vsc.vsa.a(false, 0.0F, 0.0F, 0, 0.0D, 0.0D, 0.0D);
    AppMethodBeat.o(9821);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.j.1
 * JD-Core Version:    0.7.0.1
 */