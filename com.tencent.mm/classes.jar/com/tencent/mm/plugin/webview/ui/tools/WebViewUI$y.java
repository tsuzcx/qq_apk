package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WebViewUI$y
  implements b
{
  private WebViewUI$y(WebViewUI paramWebViewUI) {}
  
  public final boolean ait(String paramString)
  {
    AppMethodBeat.i(7979);
    try
    {
      if (!this.vgz.igU.isSDCardAvailable())
      {
        this.vgz.igU.a(2, null, this.vgz.hashCode());
        AppMethodBeat.o(7979);
        return true;
      }
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.WebViewUI", "edw handleUrl, ex = " + paramString.getMessage());
      AppMethodBeat.o(7979);
      return false;
    }
    WebViewUI.f(this.vgz, paramString.substring(19));
    ab.i("MicroMsg.WebViewUI", "viewimage currentUrl :" + WebViewUI.R(this.vgz));
    u.a(this.vgz.pOd, "weixin://private/gethtml/", "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", WebViewUI.S(this.vgz));
    AppMethodBeat.o(7979);
    return true;
  }
  
  public final boolean aiz(String paramString)
  {
    AppMethodBeat.i(7978);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(7978);
      return false;
    }
    boolean bool = u.x(paramString, "weixin://viewimage/");
    AppMethodBeat.o(7978);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.y
 * JD-Core Version:    0.7.0.1
 */