package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.c.f;
import com.tencent.mm.sdk.platformtools.ac;

final class BaseSearchWebViewUI$4
  implements Runnable
{
  BaseSearchWebViewUI$4(BaseSearchWebViewUI paramBaseSearchWebViewUI, int paramInt, String paramString1, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(188516);
    this.CCV.getJsapi().g(this.oRg, this.val$errMsg, this.obI, "", "onSimilarEmoticonReady");
    ac.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "wxaapp_opsearch resp, ret = %d, errMsg = %s, json = %s", new Object[] { Integer.valueOf(this.oRg), this.val$errMsg, this.obI });
    AppMethodBeat.o(188516);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.4
 * JD-Core Version:    0.7.0.1
 */