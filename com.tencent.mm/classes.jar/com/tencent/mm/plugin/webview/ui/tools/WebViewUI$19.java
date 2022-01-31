package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewUI$19
  implements MenuItem.OnMenuItemClickListener
{
  WebViewUI$19(WebViewUI paramWebViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(153233);
    this.vgz.hideVKB();
    this.vgz.deE();
    ab.i("MicroMsg.WebViewUI", "on back btn press");
    AppMethodBeat.o(153233);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.19
 * JD-Core Version:    0.7.0.1
 */