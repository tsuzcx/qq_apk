package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class WebViewUI$43
  implements MenuItem.OnMenuItemClickListener
{
  WebViewUI$43(WebViewUI paramWebViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    paramMenuItem = new Intent();
    paramMenuItem.setClassName(this.rpH, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
    paramMenuItem.putExtra("entry_fix_tools", 1);
    this.rpH.startActivity(paramMenuItem);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.43
 * JD-Core Version:    0.7.0.1
 */