package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$u
  implements b
{
  private WebViewUI$u(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7970);
    h.qsU.idkeyStat(405L, 24L, 1L, true);
    WebViewUI.f(this.vgz, 2);
    AppMethodBeat.o(7970);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7969);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7969);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://recommend_update/");
    AppMethodBeat.o(7969);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.u
 * JD-Core Version:    0.7.0.1
 */