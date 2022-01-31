package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMWebView;

final class OAuthUI$6
  implements MenuItem.OnMenuItemClickListener
{
  OAuthUI$6(OAuthUI paramOAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(7422);
    if (OAuthUI.b(this.vaY) != null) {
      OAuthUI.b(this.vaY);
    }
    this.vaY.pOd.stopLoading();
    this.vaY.Y(false, false);
    OAuthUI.c(this.vaY);
    AppMethodBeat.o(7422);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OAuthUI.6
 * JD-Core Version:    0.7.0.1
 */