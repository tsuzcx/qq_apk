package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;

final class BaseSearchWebViewUI$5
  implements Runnable
{
  BaseSearchWebViewUI$5(BaseSearchWebViewUI paramBaseSearchWebViewUI, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(80577);
    this.EgE.getJsapi().g(this.puQ, this.val$errMsg, this.oFb, this.zgw, "onSearchWebQueryReady");
    ad.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(this.puQ), this.val$errMsg, this.oFb });
    AppMethodBeat.o(80577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */