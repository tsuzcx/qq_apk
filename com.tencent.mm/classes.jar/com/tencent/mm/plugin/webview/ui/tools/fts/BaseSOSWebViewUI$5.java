package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.h.46;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

final class BaseSOSWebViewUI$5
  implements Runnable
{
  BaseSOSWebViewUI$5(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80528);
    if (this.Jnm.getJsapi() != null)
    {
      h localh = this.Jnm.getJsapi();
      String str1 = this.nWD;
      String str2 = this.IPc;
      if (!localh.GBl)
      {
        Log.e("MicroMsg.JsApiHandler", "onChatSearchDataReady fail, not ready");
        AppMethodBeat.o(80528);
        return;
      }
      Log.i("MicroMsg.JsApiHandler", "onChatSearchDataReady success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str1);
      localHashMap.put("requestId", str2);
      MMHandlerThread.postToMainThread(new h.46(localh, n.a.b("onChatSearchDataReady", localHashMap, localh.IRj, localh.zpY)));
    }
    AppMethodBeat.o(80528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */