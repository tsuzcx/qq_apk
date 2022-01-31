package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewUI$63
  implements DialogInterface.OnClickListener
{
  WebViewUI$63(WebViewUI paramWebViewUI, CheckBox paramCheckBox) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.pSR != null) && (this.pSR.isChecked())) {}
    try
    {
      if (this.rpH.gGn.cdg()) {
        this.rpH.gGn.eI(327792, 1);
      }
      this.rpH.roY = true;
      WebViewUI.aW(this.rpH);
      h.rnm.close();
      this.rpH.finish();
      return;
    }
    catch (Exception paramDialogInterface)
    {
      for (;;)
      {
        y.e("MicroMsg.WebViewUI", "tryShowCloseWindowConfirmInfo, ex = " + paramDialogInterface.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.63
 * JD-Core Version:    0.7.0.1
 */