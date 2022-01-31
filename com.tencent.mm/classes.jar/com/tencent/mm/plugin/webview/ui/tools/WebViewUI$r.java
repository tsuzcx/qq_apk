package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$r
  implements b
{
  private WebViewUI$r(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7963);
    h.qsU.idkeyStat(405L, 26L, 1L, true);
    WebViewUI.f(this.vgz, 3);
    AppMethodBeat.o(7963);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7962);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7962);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://manual_update/");
    AppMethodBeat.o(7962);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.r
 * JD-Core Version:    0.7.0.1
 */