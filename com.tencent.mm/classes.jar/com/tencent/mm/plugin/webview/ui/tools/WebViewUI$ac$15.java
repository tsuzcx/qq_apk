package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.6;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class WebViewUI$ac$15
  implements Runnable
{
  WebViewUI$ac$15(WebViewUI.ac paramac, boolean paramBoolean) {}
  
  public final void run()
  {
    d locald;
    boolean bool;
    if (this.rqr.rpH.rbk != null)
    {
      locald = this.rqr.rpH.rbk;
      bool = this.rqx;
      if (!locald.ready) {
        y.e("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange fail, not ready");
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onWXDeviceBTStateChange: state = %s", new Object[] { Boolean.valueOf(bool) });
    HashMap localHashMap = new HashMap();
    if (bool) {
      localHashMap.put("state", "on");
    }
    for (;;)
    {
      ai.d(new d.6(locald, i.a.a("onWXDeviceBluetoothStateChange", localHashMap, locald.rxI, locald.rxJ)));
      return;
      localHashMap.put("state", "off");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.15
 * JD-Core Version:    0.7.0.1
 */