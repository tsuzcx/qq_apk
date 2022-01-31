package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$e
  implements b
{
  private WebViewUI$e(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7898);
    h.qsU.idkeyStat(405L, 25L, 1L, true);
    WebViewUI.f(this.vgz, 1);
    AppMethodBeat.o(7898);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7897);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7897);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://critical_update/");
    AppMethodBeat.o(7897);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.e
 * JD-Core Version:    0.7.0.1
 */