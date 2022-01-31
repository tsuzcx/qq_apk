package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.5;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class WebViewUI$ac$14
  implements Runnable
{
  WebViewUI$ac$14(WebViewUI.ac paramac, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    d locald;
    String str;
    boolean bool;
    if (this.rqr.rpH.rbk != null)
    {
      locald = this.rqr.rpH.rbk;
      str = this.rpN;
      bool = this.rqw;
      if (!locald.ready) {
        y.e("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange fail, not ready");
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onWXDeviceBindStateChange: device id = %s, isBound = %s", new Object[] { str, Boolean.valueOf(bool) });
    if (bk.bl(str))
    {
      y.e("MicroMsg.JsApiHandler", "parameter error!!!");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("deviceId", str);
    if (bool) {
      localHashMap.put("state", "bind");
    }
    for (;;)
    {
      ai.d(new d.5(locald, i.a.a("onWXDeviceBindStateChange", localHashMap, locald.rxI, locald.rxJ)));
      return;
      localHashMap.put("state", "unbind");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.14
 * JD-Core Version:    0.7.0.1
 */