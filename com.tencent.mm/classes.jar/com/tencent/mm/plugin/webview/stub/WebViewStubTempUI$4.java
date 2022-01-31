package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewStubTempUI$4
  implements DialogInterface.OnCancelListener
{
  WebViewStubTempUI$4(WebViewStubTempUI paramWebViewStubTempUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7221);
    this.uZM.finish();
    AppMethodBeat.o(7221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.4
 * JD-Core Version:    0.7.0.1
 */