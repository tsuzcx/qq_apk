package com.tencent.mm.plugin.webview.ui.tools.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.b;
import com.tencent.mm.sdk.platformtools.ab;

final class BaseSearchWebViewUI$1
  implements d.b
{
  BaseSearchWebViewUI$1(BaseSearchWebViewUI paramBaseSearchWebViewUI) {}
  
  public final void onReady()
  {
    AppMethodBeat.i(8379);
    BaseSearchWebViewUI.a(this.vkb);
    ab.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
    z.cZj();
    AppMethodBeat.o(8379);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.1
 * JD-Core Version:    0.7.0.1
 */