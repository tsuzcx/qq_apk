package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.11;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class WebViewUI$ac$51
  implements Runnable
{
  WebViewUI$ac$51(WebViewUI.ac paramac, String paramString, int paramInt) {}
  
  public final void run()
  {
    d locald;
    String str;
    int i;
    if (this.rqr.rpH.rbk != null)
    {
      locald = this.rqr.rpH.rbk;
      str = this.wuK;
      i = this.rqp;
      if (!locald.ready) {
        y.e("MicroMsg.JsApiHandler", "onMediaFileUploadProgress fail, not ready");
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onMediaFileUploadProgress, local id : %s, percent : %d", new Object[] { str, Integer.valueOf(i) });
    HashMap localHashMap = new HashMap();
    localHashMap.put("localId", str);
    localHashMap.put("percent", Integer.valueOf(i));
    ai.d(new d.11(locald, i.a.a("onMediaFileUploadProgress", localHashMap, locald.rxI, locald.rxJ)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.51
 * JD-Core Version:    0.7.0.1
 */