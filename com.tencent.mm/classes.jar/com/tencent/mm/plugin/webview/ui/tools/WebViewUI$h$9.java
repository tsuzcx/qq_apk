package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.xweb.f;

final class WebViewUI$h$9
  implements DialogInterface.OnDismissListener
{
  WebViewUI$h$9(WebViewUI.h paramh, PBool paramPBool, f paramf) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    y.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
    if (!this.rqK.value) {
      this.rqL.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h.9
 * JD-Core Version:    0.7.0.1
 */