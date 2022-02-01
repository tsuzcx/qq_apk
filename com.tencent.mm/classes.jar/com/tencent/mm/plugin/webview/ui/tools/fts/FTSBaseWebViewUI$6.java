package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ad;

final class FTSBaseWebViewUI$6
  implements Runnable
{
  FTSBaseWebViewUI$6(FTSBaseWebViewUI paramFTSBaseWebViewUI, int paramInt, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80586);
    if (this.EgM.DzP != null)
    {
      this.EgM.DzP.a(this.puQ, this.Ego, this.oFb);
      ad.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(this.puQ), Long.valueOf(this.Ego), this.oFb });
    }
    AppMethodBeat.o(80586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */