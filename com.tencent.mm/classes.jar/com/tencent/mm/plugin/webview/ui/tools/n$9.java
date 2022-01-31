package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.20;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

final class n$9
  implements Runnable
{
  n$9(n paramn, WebViewUI paramWebViewUI, d paramd, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(7721);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7721);
      return;
    }
    if (this.vdp != null)
    {
      d locald = this.vdp;
      int i = this.val$errCode;
      if (!locald.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
        AppMethodBeat.o(7721);
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("errCode", Integer.valueOf(i));
      al.d(new d.20(locald, i.a.b("onNfcTouch", localHashMap, locald.voB, locald.voC)));
    }
    AppMethodBeat.o(7721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.9
 * JD-Core Version:    0.7.0.1
 */