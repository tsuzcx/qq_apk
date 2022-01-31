package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;

final class WebViewStubTempUI$2
  implements DialogInterface.OnClickListener
{
  WebViewStubTempUI$2(WebViewStubTempUI paramWebViewStubTempUI, ResultReceiver paramResultReceiver) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.rkr.send(0, null);
    this.rks.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.2
 * JD-Core Version:    0.7.0.1
 */