package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.sdk.platformtools.Log;

final class BaseSearchWebViewUI$5
  implements Runnable
{
  BaseSearchWebViewUI$5(BaseSearchWebViewUI paramBaseSearchWebViewUI, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(80577);
    this.JnH.getJsapi().g(this.qQL, this.val$errMsg, this.pZr, this.DHv, "onSearchWebQueryReady");
    Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onSearchWebQueryReady, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(this.qQL), this.val$errMsg, this.pZr });
    AppMethodBeat.o(80577);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.5
 * JD-Core Version:    0.7.0.1
 */