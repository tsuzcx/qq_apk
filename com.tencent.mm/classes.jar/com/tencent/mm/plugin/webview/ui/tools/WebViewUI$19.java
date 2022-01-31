package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$19
  implements DialogInterface.OnCancelListener
{
  WebViewUI$19(WebViewUI paramWebViewUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if ((this.rpH.gGt != null) && (this.rpH.gGn != null)) {}
    try
    {
      this.rpH.gGn.SU(this.rpH.gGt.riI);
      this.rpH.gGt.ccQ();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      y.e("MicroMsg.WebViewUI", "cancel capture failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.19
 * JD-Core Version:    0.7.0.1
 */