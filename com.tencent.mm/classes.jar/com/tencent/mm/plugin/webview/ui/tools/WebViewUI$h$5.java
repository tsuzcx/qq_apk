package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.xweb.f;

final class WebViewUI$h$5
  implements DialogInterface.OnClickListener
{
  WebViewUI$h$5(WebViewUI.h paramh, String paramString, f paramf) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    h.nFQ.f(11683, new Object[] { this.val$url, Integer.valueOf(1), Integer.valueOf(WebViewUI.az(this.rqJ.rpH)) });
    this.rqL.cancel();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.rqJ.rpH.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h.5
 * JD-Core Version:    0.7.0.1
 */