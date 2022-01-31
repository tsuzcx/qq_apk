package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.snackbar.a.c;

final class g$70
  implements a.c
{
  g$70(g paramg) {}
  
  public final void cPa() {}
  
  public final void onHide()
  {
    AppMethodBeat.i(9132);
    this.vqm.a(g.k(this.vqm), "send_app_msg:ok", null);
    AppMethodBeat.o(9132);
  }
  
  public final void onShow() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.70
 * JD-Core Version:    0.7.0.1
 */