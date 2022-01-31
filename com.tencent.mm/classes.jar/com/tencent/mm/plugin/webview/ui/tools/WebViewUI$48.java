package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WebViewUI$48
  implements DialogInterface.OnClickListener
{
  WebViewUI$48(WebViewUI paramWebViewUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7878);
    this.vgz.vfK = true;
    m.vdm.close();
    this.vgz.finish();
    AppMethodBeat.o(7878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.48
 * JD-Core Version:    0.7.0.1
 */