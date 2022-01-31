package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1, LinkedList paramLinkedList, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(6278);
    n localn = new n(((com.tencent.mm.plugin.webview.luggage.e)this.uTp.njN.byE).mContext);
    c.1.1.1 local1 = new c.1.1.1(this);
    if ((this.hDM != null) && (this.hDM.size() > 0))
    {
      if (!localn.a(this.hDM, this.uTn, this.uTo, local1)) {
        this.uTp.njN.a("fail", null);
      }
      AppMethodBeat.o(6278);
      return;
    }
    ab.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
    this.uTp.njN.a("fail", null);
    AppMethodBeat.o(6278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c.1.1
 * JD-Core Version:    0.7.0.1
 */