package com.tencent.mm.plugin.webview.ui.tools;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$b
  implements b
{
  public final String rqE = "weixin://addfriend/";
  
  private WebViewUI$b(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    if (!this.rpH.gGo.cdI().hi(5))
    {
      y.e("MicroMsg.WebViewUI", "AddFriendHandler, permission fail");
      return true;
    }
    paramString = paramString.substring(19);
    if (bk.bl(paramString)) {
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_webview", true);
    localBundle.putString("userName", paramString);
    try
    {
      this.rpH.gGn.a(8, localBundle, this.rpH.hashCode());
      return true;
    }
    catch (Exception paramString)
    {
      y.w("MicroMsg.WebViewUI", "AddFriendHandler, ex = " + paramString.getMessage());
    }
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://addfriend/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.b
 * JD-Core Version:    0.7.0.1
 */