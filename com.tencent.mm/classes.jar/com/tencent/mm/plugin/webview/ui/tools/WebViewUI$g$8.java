package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

final class WebViewUI$g$8
  implements DialogInterface.OnClickListener
{
  WebViewUI$g$8(WebViewUI.g paramg, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7908);
    this.vgP.cancel();
    AppMethodBeat.o(7908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g.8
 * JD-Core Version:    0.7.0.1
 */