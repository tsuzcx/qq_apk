package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.45;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

final class FTSSOSHomeWebViewUI$13
  implements Runnable
{
  FTSSOSHomeWebViewUI$13(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI, JSONArray paramJSONArray, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(211252);
    h localh = this.Jos.getJsapi();
    JSONArray localJSONArray = this.Jou;
    String str = this.dqb;
    if (!localh.GBl)
    {
      Log.e("MicroMsg.JsApiHandler", "onGetVertSearchEntriesData fail, not ready");
      AppMethodBeat.o(211252);
      return;
    }
    Log.i("MicroMsg.JsApiHandler", "onGetVertSearchEntriesData success, ready");
    HashMap localHashMap = new HashMap();
    localHashMap.put("items", localJSONArray);
    localHashMap.put("title", str);
    MMHandlerThread.postToMainThread(new h.45(localh, n.a.b("onGetVertSearchEntriesData", localHashMap, localh.IRj, localh.zpY)));
    AppMethodBeat.o(211252);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.13
 * JD-Core Version:    0.7.0.1
 */