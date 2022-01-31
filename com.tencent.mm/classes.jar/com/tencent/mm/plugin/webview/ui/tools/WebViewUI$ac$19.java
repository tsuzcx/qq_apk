package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.59;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

final class WebViewUI$ac$19
  implements Runnable
{
  WebViewUI$ac$19(WebViewUI.ac paramac, JSONArray paramJSONArray) {}
  
  public final void run()
  {
    d locald;
    JSONArray localJSONArray;
    if (this.rqr.rpH.rbk != null)
    {
      locald = this.rqr.rpH.rbk;
      localJSONArray = this.val$jsonArray;
      if (localJSONArray == null) {
        y.e("MicroMsg.JsApiHandler", "onGetMsgProofItems fail, not ready");
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onGetMsgProofItems success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("msgs", localJSONArray);
    ai.d(new d.59(locald, i.a.a("onGetMsgProofItems", localHashMap, locald.rxI, locald.rxJ)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.19
 * JD-Core Version:    0.7.0.1
 */