package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewDownloadUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WebViewDownloadUI$1(WebViewDownloadUI paramWebViewDownloadUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(7592);
    this.vcl.finish();
    AppMethodBeat.o(7592);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewDownloadUI.1
 * JD-Core Version:    0.7.0.1
 */