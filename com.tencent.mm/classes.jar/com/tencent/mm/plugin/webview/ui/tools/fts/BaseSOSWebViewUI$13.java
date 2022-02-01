package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;

final class BaseSOSWebViewUI$13
  implements Runnable
{
  BaseSOSWebViewUI$13(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(208152);
    if (this.Egk.DzP != null)
    {
      this.Egk.DzP.a(this.puQ, this.Ego, this.oFb);
      ad.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(this.puQ), Long.valueOf(this.Ego), this.oFb });
    }
    AppMethodBeat.o(208152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.13
 * JD-Core Version:    0.7.0.1
 */