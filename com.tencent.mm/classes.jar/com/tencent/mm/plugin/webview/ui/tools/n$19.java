package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.7;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

final class n$19
  implements Runnable
{
  n$19(n paramn, WebViewUI paramWebViewUI, d paramd, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(7731);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7731);
      return;
    }
    d locald;
    HashMap localHashMap;
    if (this.vdp != null)
    {
      locald = this.vdp;
      boolean bool = this.vdE;
      if (!locald.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange fail, not ready");
        AppMethodBeat.o(7731);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onWXDeviceLanStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
      localHashMap = new HashMap();
      if (!bool) {
        break label141;
      }
      localHashMap.put("state", "on");
    }
    for (;;)
    {
      al.d(new d.7(locald, i.a.b("onWXDeviceLanStateChange", localHashMap, locald.voB, locald.voC)));
      AppMethodBeat.o(7731);
      return;
      label141:
      localHashMap.put("state", "off");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.19
 * JD-Core Version:    0.7.0.1
 */