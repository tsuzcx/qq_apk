package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.39;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.Map;

final class BaseSOSWebViewUI$5
  implements Runnable
{
  BaseSOSWebViewUI$5(BaseSOSWebViewUI paramBaseSOSWebViewUI, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(80528);
    if (this.Egk.getJsapi() != null)
    {
      f localf = this.Egk.getJsapi();
      String str1 = this.mEz;
      String str2 = this.DKG;
      if (!localf.BHY)
      {
        ad.e("MicroMsg.JsApiHandler", "onChatSearchDataReady fail, not ready");
        AppMethodBeat.o(80528);
        return;
      }
      ad.i("MicroMsg.JsApiHandler", "onChatSearchDataReady success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("json", str1);
      localHashMap.put("requestId", str2);
      aq.f(new f.39(localf, l.a.b("onChatSearchDataReady", localHashMap, localf.DMD, localf.vJP)));
    }
    AppMethodBeat.o(80528);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */