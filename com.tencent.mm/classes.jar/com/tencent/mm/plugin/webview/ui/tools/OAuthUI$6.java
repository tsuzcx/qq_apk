package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.widget.MMWebView;

final class OAuthUI$6
  implements MenuItem.OnMenuItemClickListener
{
  OAuthUI$6(OAuthUI paramOAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (OAuthUI.b(this.rlw) != null) {
      OAuthUI.b(this.rlw);
    }
    this.rlw.niQ.stopLoading();
    this.rlw.O(false, false);
    OAuthUI.c(this.rlw);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OAuthUI.6
 * JD-Core Version:    0.7.0.1
 */