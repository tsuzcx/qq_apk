package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.y;

final class WebViewStubProxyUI$3
  implements DialogInterface.OnCancelListener
{
  WebViewStubProxyUI$3(WebViewStubProxyUI paramWebViewStubProxyUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    y.i("MicroMsg.WebViewStubProxyUI", "addshortcut, user cancel");
    this.rjS.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.3
 * JD-Core Version:    0.7.0.1
 */