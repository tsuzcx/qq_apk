package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SDKOAuthUI$3
  implements DialogInterface.OnClickListener
{
  SDKOAuthUI$3(SDKOAuthUI paramSDKOAuthUI, String paramString, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7526);
    if (!SDKOAuthUI.o(this.vbR)) {
      SDKOAuthUI.b(this.vbR, this.ftO);
    }
    if (this.vbT) {
      this.vbR.finish();
    }
    AppMethodBeat.o(7526);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.SDKOAuthUI.3
 * JD-Core Version:    0.7.0.1
 */