package com.tencent.mm.plugin.webview.ui.tools;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$ac$30$1
  implements View.OnCreateContextMenuListener
{
  WebViewUI$ac$30$1(WebViewUI.ac.30 param30) {}
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if (this.rqC.rqr.rpH.gGu != null)
    {
      y.d("MicroMsg.WebViewUI", "show webkit menu");
      WebViewUI.a(this.rqC.rqr.rpH, paramContextMenu, this.rqC.rqr.rpH.gGu);
      this.rqC.rqr.rpH.gGu = null;
    }
    while (this.rqC.rqr.rpH.gGv == null) {
      return;
    }
    y.d("MicroMsg.WebViewUI", "show IX5 menu");
    WebViewUI.b(this.rqC.rqr.rpH, paramContextMenu, this.rqC.rqr.rpH.gGv);
    this.rqC.rqr.rpH.gGv = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.ac.30.1
 * JD-Core Version:    0.7.0.1
 */