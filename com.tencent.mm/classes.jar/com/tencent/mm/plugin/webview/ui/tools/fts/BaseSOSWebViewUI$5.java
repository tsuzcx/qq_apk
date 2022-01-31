package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.36;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import org.json.JSONException;
import org.json.JSONObject;

final class BaseSOSWebViewUI$5
  implements Runnable
{
  BaseSOSWebViewUI$5(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8335);
    if (this.vjG.getJsapi() != null)
    {
      d locald = this.vjG.getJsapi();
      String str = this.iOH;
      if (!locald.ready)
      {
        ab.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
        AppMethodBeat.o(8335);
        return;
      }
      ab.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
      try
      {
        al.d(new d.36(locald, i.a.a("onSearchHistoryReady", new JSONObject(str), locald.voB, locald.voC)));
        AppMethodBeat.o(8335);
        return;
      }
      catch (JSONException localJSONException)
      {
        ab.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(8335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */