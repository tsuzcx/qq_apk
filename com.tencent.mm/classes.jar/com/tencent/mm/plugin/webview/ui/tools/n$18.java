package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.6;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Map;

final class n$18
  implements Runnable
{
  n$18(n paramn, WebViewUI paramWebViewUI, d paramd, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(7730);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7730);
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
        ab.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
        AppMethodBeat.o(7730);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
      localHashMap = new HashMap();
      if (!bool) {
        break label141;
      }
      localHashMap.put("state", "on");
    }
    for (;;)
    {
      al.d(new d.6(locald, i.a.b("onWXDeviceBluetoothStateChange", localHashMap, locald.voB, locald.voC)));
      AppMethodBeat.o(7730);
      return;
      label141:
      localHashMap.put("state", "off");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.18
 * JD-Core Version:    0.7.0.1
 */