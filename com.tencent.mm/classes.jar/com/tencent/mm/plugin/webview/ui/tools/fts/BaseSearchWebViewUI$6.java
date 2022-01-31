package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.x;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;

final class BaseSearchWebViewUI$6
  implements x
{
  BaseSearchWebViewUI$6(BaseSearchWebViewUI paramBaseSearchWebViewUI) {}
  
  public final void gE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153284);
    if (this.vkb.getJsapi() != null) {
      this.vkb.getJsapi().gQ(paramInt1, paramInt2);
    }
    AppMethodBeat.o(153284);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.6
 * JD-Core Version:    0.7.0.1
 */