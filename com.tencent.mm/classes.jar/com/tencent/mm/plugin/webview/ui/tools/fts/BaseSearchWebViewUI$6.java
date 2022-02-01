package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.41;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

final class BaseSearchWebViewUI$6
  implements Runnable
{
  BaseSearchWebViewUI$6(BaseSearchWebViewUI paramBaseSearchWebViewUI, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80578);
    h localh = this.JnH.getJsapi();
    String str = this.pZr;
    if (!localh.GBl) {
      Log.e("MicroMsg.JsApiHandler", "onCurrentLocationReady fail, not ready");
    }
    for (;;)
    {
      Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onCurrentLocationReady, json = %s", new Object[] { this.pZr });
      AppMethodBeat.o(80578);
      return;
      Log.i("MicroMsg.JsApiHandler", "onCurrentLocationReady success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str);
      MMHandlerThread.postToMainThread(new h.41(localh, n.a.b("onCurrentLocationReady", localHashMap, localh.IRj, localh.zpY)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */