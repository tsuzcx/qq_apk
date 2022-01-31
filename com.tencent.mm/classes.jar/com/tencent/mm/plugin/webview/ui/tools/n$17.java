package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.5;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

final class n$17
  implements Runnable
{
  n$17(n paramn, WebViewUI paramWebViewUI, d paramd, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(7729);
    if ((this.vdo == null) || (this.vdo.isFinishing()))
    {
      AppMethodBeat.o(7729);
      return;
    }
    d locald;
    HashMap localHashMap;
    if (this.vdp != null)
    {
      locald = this.vdp;
      String str = this.vdy;
      boolean bool = this.vdD;
      if (!locald.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
        AppMethodBeat.o(7729);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[] { str, Boolean.valueOf(bool) });
      if (bo.isNullOrNil(str))
      {
        ab.e("MicroMsg.JsApiHandler", "parameter error!!!");
        AppMethodBeat.o(7729);
        return;
      }
      localHashMap = new HashMap();
      localHashMap.put("deviceId", str);
      if (!bool) {
        break label185;
      }
      localHashMap.put("state", "bind");
    }
    for (;;)
    {
      al.d(new d.5(locald, i.a.b("onWXDeviceBindStateChange", localHashMap, locald.voB, locald.voC)));
      AppMethodBeat.o(7729);
      return;
      label185:
      localHashMap.put("state", "unbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.n.17
 * JD-Core Version:    0.7.0.1
 */