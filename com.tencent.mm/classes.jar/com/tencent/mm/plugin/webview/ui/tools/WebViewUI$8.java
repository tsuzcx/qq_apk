package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$8
  implements MenuItem.OnMenuItemClickListener
{
  WebViewUI$8(WebViewUI paramWebViewUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      paramMenuItem = this.rpH.gGn.SV(null);
      this.rpH.b(paramMenuItem, null, false);
      return false;
    }
    catch (RemoteException paramMenuItem)
    {
      y.printErrStackTrace("MicroMsg.WebViewUI", paramMenuItem, "[oneliang]feedback exception:%s", new Object[] { paramMenuItem.getMessage() });
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.8
 * JD-Core Version:    0.7.0.1
 */