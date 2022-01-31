package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

final class WebViewStubProxyUI$6
  implements DialogInterface.OnDismissListener
{
  WebViewStubProxyUI$6(WebViewStubProxyUI paramWebViewStubProxyUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.rjS.isFinishing()) {
      this.rjS.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.6
 * JD-Core Version:    0.7.0.1
 */