package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class OAuthUI$5
  implements MenuItem.OnMenuItemClickListener
{
  OAuthUI$5(OAuthUI paramOAuthUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(7421);
    OAuthUI.a(this.vaY);
    this.vaY.finish();
    AppMethodBeat.o(7421);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.OAuthUI.5
 * JD-Core Version:    0.7.0.1
 */