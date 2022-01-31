package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;

final class BaseSOSWebViewUI$11
  implements Runnable
{
  BaseSOSWebViewUI$11(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8341);
    if (this.vjG.uQS != null)
    {
      this.vjG.uQS.a(this.qac, this.vjL, this.ktr);
      ab.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(this.qac), Long.valueOf(this.vjL), this.ktr });
    }
    AppMethodBeat.o(8341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.11
 * JD-Core Version:    0.7.0.1
 */