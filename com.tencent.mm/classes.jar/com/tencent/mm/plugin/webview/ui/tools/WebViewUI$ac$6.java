package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.20;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class WebViewUI$ac$6
  implements Runnable
{
  WebViewUI$ac$6(WebViewUI.ac paramac, int paramInt) {}
  
  public final void run()
  {
    d locald;
    int i;
    if (this.rqr.rpH.rbk != null)
    {
      locald = this.rqr.rpH.rbk;
      i = this.bEg;
      if (!locald.ready) {
        y.e("MicroMsg.JsApiHandler", "onNfcTouch fail, not ready");
      }
    }
    else
    {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(i));
    ai.d(new d.20(locald, i.a.a("onNfcTouch", localHashMap, locald.rxI, locald.rxJ)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.6
 * JD-Core Version:    0.7.0.1
 */