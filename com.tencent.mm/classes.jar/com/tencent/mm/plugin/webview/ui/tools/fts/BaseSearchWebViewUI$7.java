package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.36;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

final class BaseSearchWebViewUI$7
  implements ae
{
  BaseSearchWebViewUI$7(BaseSearchWebViewUI paramBaseSearchWebViewUI) {}
  
  public final void ka(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(80579);
    if (this.JnH.getJsapi() != null)
    {
      h localh = this.JnH.getJsapi();
      if (!localh.GBl)
      {
        Log.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
        AppMethodBeat.o(80579);
        return;
      }
      Log.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("index", Integer.valueOf(paramInt1));
      localHashMap.put("actionSheetId", Integer.valueOf(paramInt2));
      MMHandlerThread.postToMainThread(new h.36(localh, n.a.b("onSearchActionSheetClick", localHashMap, localh.IRj, localh.zpY)));
    }
    AppMethodBeat.o(80579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.7
 * JD-Core Version:    0.7.0.1
 */