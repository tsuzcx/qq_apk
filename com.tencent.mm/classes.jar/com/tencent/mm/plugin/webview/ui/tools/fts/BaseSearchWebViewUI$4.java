package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;

final class BaseSearchWebViewUI$4
  implements Runnable
{
  BaseSearchWebViewUI$4(BaseSearchWebViewUI paramBaseSearchWebViewUI, int paramInt, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(208167);
    this.EgE.getJsapi().g(this.puQ, this.val$errMsg, this.oFb, "", "onSimilarEmoticonReady");
    ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(this.puQ), this.val$errMsg, this.oFb });
    AppMethodBeat.o(208167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */