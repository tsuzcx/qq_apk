package com.tencent.mm.plugin.webview.ui.tools;

import com.tencent.mm.R.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.b;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

final class WebViewUI$u
  implements b
{
  private WebViewUI$u(WebViewUI paramWebViewUI) {}
  
  public final boolean Tq(String paramString)
  {
    paramString = this.rpH.getString(R.l.readerapp_share_weibo);
    WebViewUI localWebViewUI = this.rpH;
    WebViewUI.u.1 local1 = new WebViewUI.u.1(this);
    h.a(localWebViewUI, "", new String[] { paramString }, "", local1);
    return true;
  }
  
  public final boolean Ty(String paramString)
  {
    if (bk.bl(paramString)) {
      return false;
    }
    return s.n(paramString, "weixin://readershare/");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.u
 * JD-Core Version:    0.7.0.1
 */