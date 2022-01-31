package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$c
  implements b
{
  private WebViewUI$c(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7890);
    if (!this.vgz.igV.ddV().jy(17))
    {
      ab.e("MicroMsg.WebViewUI", "close window permission fail");
      AppMethodBeat.o(7890);
      return true;
    }
    this.vgz.finish();
    AppMethodBeat.o(7890);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7889);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7889);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://webview/close/");
    AppMethodBeat.o(7889);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.c
 * JD-Core Version:    0.7.0.1
 */