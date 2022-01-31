package com.tencent.mm.plugin.webview.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewStubTempUI$2
  implements DialogInterface.OnClickListener
{
  WebViewStubTempUI$2(WebViewStubTempUI paramWebViewStubTempUI, ResultReceiver paramResultReceiver) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7219);
    this.uZL.send(0, null);
    this.uZM.finish();
    AppMethodBeat.o(7219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.stub.WebViewStubTempUI.2
 * JD-Core Version:    0.7.0.1
 */