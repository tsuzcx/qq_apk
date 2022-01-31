package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.b;

final class WebViewUI$30
  implements MenuItem.OnMenuItemClickListener
{
  WebViewUI$30(WebViewUI paramWebViewUI, String paramString) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      bool = this.rpH.gGn.isSDCardAvailable();
    }
    catch (Exception paramMenuItem)
    {
      for (;;)
      {
        try
        {
          s.a(this.rpH, this.gGE, b.cSe().getCookie(this.gGE), bool);
          return true;
        }
        catch (Exception paramMenuItem)
        {
          boolean bool;
          y.e("MicroMsg.WebViewUI", "save to sdcard failed : %s", new Object[] { paramMenuItem.getMessage() });
        }
        paramMenuItem = paramMenuItem;
        y.e("MicroMsg.WebViewUI", "onMenuItemClick fail, ex = " + paramMenuItem.getMessage());
        bool = false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.30
 * JD-Core Version:    0.7.0.1
 */