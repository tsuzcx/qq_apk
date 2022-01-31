package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$p
  implements b
{
  private WebViewUI$p(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7961);
    paramString = paramString.substring(17);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.WebViewUI", "handleUrl fail, username is null");
      AppMethodBeat.o(7961);
      return true;
    }
    if ((this.vgz.igV != null) && (this.vgz.igV.ddV() != null) && (this.vgz.igV.ddV().jy(2))) {
      this.vgz.uQS.aiX(paramString);
    }
    AppMethodBeat.o(7961);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7960);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7960);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://profile/");
    AppMethodBeat.o(7960);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.p
 * JD-Core Version:    0.7.0.1
 */