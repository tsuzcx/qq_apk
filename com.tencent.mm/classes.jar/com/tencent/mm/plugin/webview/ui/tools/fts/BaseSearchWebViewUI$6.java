package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.plugin.webview.c.f.34;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.Map;

final class BaseSearchWebViewUI$6
  implements aa
{
  BaseSearchWebViewUI$6(BaseSearchWebViewUI paramBaseSearchWebViewUI) {}
  
  public final void iQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(208168);
    if (this.EgE.getJsapi() != null)
    {
      f localf = this.EgE.getJsapi();
      if (!localf.BHY)
      {
        ad.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
        AppMethodBeat.o(208168);
        return;
      }
      ad.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
      HashMap localHashMap = new HashMap();
      localHashMap.put("index", Integer.valueOf(paramInt1));
      localHashMap.put("actionSheetId", Integer.valueOf(paramInt2));
      aq.f(new f.34(localf, l.a.b("onSearchActionSheetClick", localHashMap, localf.DMD, localf.vJP)));
    }
    AppMethodBeat.o(208168);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */