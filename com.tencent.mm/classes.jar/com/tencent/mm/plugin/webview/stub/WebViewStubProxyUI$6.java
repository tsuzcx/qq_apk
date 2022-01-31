package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewStubProxyUI$6
  implements DialogInterface.OnDismissListener
{
  WebViewStubProxyUI$6(WebViewStubProxyUI paramWebViewStubProxyUI) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7095);
    if (!this.uZk.isFinishing()) {
      this.uZk.finish();
    }
    AppMethodBeat.o(7095);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubProxyUI.6
 * JD-Core Version:    0.7.0.1
 */