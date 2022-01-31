package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;

final class WebViewUI$8
  implements MenuItem.OnMenuItemClickListener
{
  WebViewUI$8(WebViewUI paramWebViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(7816);
    try
    {
      paramMenuItem = this.vgz.igU.ahX(null);
      this.vgz.loadUrl(paramMenuItem);
      AppMethodBeat.o(7816);
      return false;
    }
    catch (RemoteException paramMenuItem)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WebViewUI", paramMenuItem, "[oneliang]feedback exception:%s", new Object[] { paramMenuItem.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.8
 * JD-Core Version:    0.7.0.1
 */