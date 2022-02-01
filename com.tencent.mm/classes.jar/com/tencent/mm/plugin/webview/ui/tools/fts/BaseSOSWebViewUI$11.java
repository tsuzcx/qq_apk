package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ac;

final class BaseSOSWebViewUI$11
  implements Runnable
{
  BaseSOSWebViewUI$11(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(80534);
    if (this.CCB.Cjc != null)
    {
      this.CCB.Cjc.a(this.oRg, this.CCF, this.obI);
      ac.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(this.oRg), Long.valueOf(this.CCF), this.obI });
    }
    AppMethodBeat.o(80534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.11
 * JD-Core Version:    0.7.0.1
 */