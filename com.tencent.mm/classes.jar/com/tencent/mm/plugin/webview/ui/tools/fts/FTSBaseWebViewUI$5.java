package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.platformtools.ab;

final class FTSBaseWebViewUI$5
  implements Runnable
{
  FTSBaseWebViewUI$5(FTSBaseWebViewUI paramFTSBaseWebViewUI, int paramInt, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(8388);
    if (this.vkg.uQS != null)
    {
      this.vkg.uQS.a(this.qac, this.vjL, this.ktr);
      ab.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(this.qac), Long.valueOf(this.vjL), this.ktr });
    }
    AppMethodBeat.o(8388);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */