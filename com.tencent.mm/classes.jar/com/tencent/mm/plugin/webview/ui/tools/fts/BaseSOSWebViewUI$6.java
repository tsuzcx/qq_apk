package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.37;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import org.json.JSONException;
import org.json.JSONObject;

final class BaseSOSWebViewUI$6
  implements Runnable
{
  BaseSOSWebViewUI$6(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80529);
    if (this.Egk.getJsapi() != null)
    {
      f localf = this.Egk.getJsapi();
      String str = this.mEz;
      if (!localf.BHY)
      {
        ad.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
        AppMethodBeat.o(80529);
        return;
      }
      ad.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
      try
      {
        aq.f(new f.37(localf, l.a.a("onSearchHistoryReady", new JSONObject(str), localf.DMD, localf.vJP)));
        AppMethodBeat.o(80529);
        return;
      }
      catch (JSONException localJSONException)
      {
        ad.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(80529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */