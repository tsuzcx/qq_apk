package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.36;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;
import org.json.JSONObject;

final class BaseSOSWebViewUI$5
  implements Runnable
{
  BaseSOSWebViewUI$5(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80528);
    if (this.CCB.getJsapi() != null)
    {
      f localf = this.CCB.getJsapi();
      String str = this.meg;
      if (!localf.Apr)
      {
        ac.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
        AppMethodBeat.o(80528);
        return;
      }
      ac.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
      try
      {
        ap.f(new f.36(localf, l.a.a("onSearchHistoryReady", new JSONObject(str), localf.Cjz, localf.CjA)));
        AppMethodBeat.o(80528);
        return;
      }
      catch (JSONException localJSONException)
      {
        ac.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(80528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */