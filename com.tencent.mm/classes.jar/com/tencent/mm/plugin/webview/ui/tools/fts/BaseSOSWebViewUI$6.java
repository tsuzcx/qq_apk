package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.39;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import org.json.JSONException;
import org.json.JSONObject;

final class BaseSOSWebViewUI$6
  implements Runnable
{
  BaseSOSWebViewUI$6(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80529);
    if (this.Jnm.getJsapi() != null)
    {
      h localh = this.Jnm.getJsapi();
      String str = this.nWD;
      if (!localh.GBl)
      {
        Log.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
        AppMethodBeat.o(80529);
        return;
      }
      Log.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
      try
      {
        MMHandlerThread.postToMainThread(new h.39(localh, n.a.a("onSearchHistoryReady", new JSONObject(str), localh.IRj, localh.zpY)));
        AppMethodBeat.o(80529);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.printErrStackTrace("MicroMsg.JsApiHandler", localJSONException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(80529);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */