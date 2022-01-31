package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b;

final class WebViewUI$31
  implements MenuItem.OnMenuItemClickListener
{
  WebViewUI$31(WebViewUI paramWebViewUI, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      boolean bool = this.rpH.gGn.isSDCardAvailable();
      paramMenuItem = this.gGE.replaceAll("tp=webp", "");
      s.a(this.rpH, paramMenuItem, b.cSe().getCookie(paramMenuItem), bool, new WebViewUI.31.1(this));
      return true;
    }
    catch (Exception paramMenuItem)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + paramMenuItem.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.31
 * JD-Core Version:    0.7.0.1
 */