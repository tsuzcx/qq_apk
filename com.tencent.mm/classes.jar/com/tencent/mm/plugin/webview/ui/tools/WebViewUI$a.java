package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$a
  implements b
{
  private WebViewUI$a(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    if (!this.rpH.gGo.cdJ().coV())
    {
      y.e("MicroMsg.WebViewUI", "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", new Object[] { paramString });
      return true;
    }
    try
    {
      this.rpH.gGn.bn(paramString, this.rpH.gGo.cdI().hi(7));
      return true;
    }
    catch (Exception paramString)
    {
      y.w("MicroMsg.WebViewUI", "ActivityJumpHandler, ex = " + paramString.getMessage());
    }
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://jump/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.a
 * JD-Core Version:    0.7.0.1
 */