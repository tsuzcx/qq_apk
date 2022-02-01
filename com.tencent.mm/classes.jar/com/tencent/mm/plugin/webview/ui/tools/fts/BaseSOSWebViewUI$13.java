package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.sdk.platformtools.Log;

final class BaseSOSWebViewUI$13
  implements Runnable
{
  BaseSOSWebViewUI$13(BaseSOSWebViewUI paramBaseSOSWebViewUI, int paramInt, long paramLong, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(211208);
    if (this.Jnm.IBw != null)
    {
      this.Jnm.IBw.a(this.qQL, this.Jnr, this.pZr);
      Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", new Object[] { Integer.valueOf(this.qQL), Long.valueOf(this.Jnr), this.pZr });
    }
    AppMethodBeat.o(211208);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.13
 * JD-Core Version:    0.7.0.1
 */