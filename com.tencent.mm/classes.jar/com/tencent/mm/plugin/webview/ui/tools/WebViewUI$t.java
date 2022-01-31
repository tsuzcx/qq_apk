package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import com.tencent.mm.plugin.webview.model.ac.c;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$t
  implements b
{
  private WebViewUI$t(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    String str = this.rpH.getIntent().getStringExtra("geta8key_username");
    return ac.c.a(paramString, str, WebViewUI.b(this.rpH, str), this.rpH.gGn, WebViewUI.aR(this.rpH), WebViewUI.b(this.rpH), this.rpH.hashCode());
  }
  
  public final boolean Ty(String paramString)
  {
    d locald = this.rpH.gGn;
    if (6 == this.rpH.getIntent().getIntExtra("geta8key_scene", 0)) {
      y.i("MicroMsg.OauthAuthorizeLogic", "shouldNativeOauthIntercept from oauth");
    }
    while ((bk.bl(paramString)) || (locald == null) || (!ac.c.a(locald)) || (!ac.c.b(paramString, locald))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.t
 * JD-Core Version:    0.7.0.1
 */