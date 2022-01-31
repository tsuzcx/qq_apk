package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.35;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;
import org.json.JSONObject;

final class BaseSOSWebViewUI$5
  implements Runnable
{
  BaseSOSWebViewUI$5(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString) {}
  
  public final void run()
  {
    d locald;
    String str;
    if (BaseSOSWebViewUI.s(this.rtA) != null)
    {
      locald = BaseSOSWebViewUI.t(this.rtA);
      str = this.hdV;
      if (!locald.ready) {
        y.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
      }
    }
    else
    {
      return;
    }
    y.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
    try
    {
      ai.d(new d.35(locald, i.a.a("onSearchHistoryReady", new JSONObject(str), locald.rxI, locald.rxJ)));
      return;
    }
    catch (JSONException localJSONException)
    {
      y.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */