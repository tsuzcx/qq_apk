package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.sdk.platformtools.Log;

final class FTSBaseWebViewUI$6
  implements Runnable
{
  FTSBaseWebViewUI$6(FTSBaseWebViewUI paramFTSBaseWebViewUI, int paramInt, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80586);
    if (this.JnQ.IBw != null)
    {
      this.JnQ.IBw.a(this.qQL, this.Jnr, this.pZr);
      Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(this.qQL), Long.valueOf(this.Jnr), this.pZr });
    }
    AppMethodBeat.o(80586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */