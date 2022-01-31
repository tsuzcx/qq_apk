package com.tencent.mm.plugin.webview.ui.tools;

import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$32
  implements MenuItem.OnMenuItemClickListener
{
  WebViewUI$32(WebViewUI paramWebViewUI, String paramString1, String paramString2) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    try
    {
      this.rpH.gGn.h(this.gGH, this.rpH.cdR(), WebViewUI.Tx(this.gGI), this.rpH.gGr, this.rpH.gGs);
      y.i("MicroMsg.WebViewUI", "onMenuItemClick recognize qbcode");
      return false;
    }
    catch (RemoteException paramMenuItem)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewUI", "recognize qbar result failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.32
 * JD-Core Version:    0.7.0.1
 */