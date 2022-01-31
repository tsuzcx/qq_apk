package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.j;

final class WebViewUI$g$3
  implements DialogInterface.OnDismissListener
{
  WebViewUI$g$3(WebViewUI.g paramg, PBool paramPBool, j paramj) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7903);
    ab.d("MicroMsg.WebViewUI", "onJsAlert, onDismiss");
    if (!this.vgO.value) {
      this.vgP.cancel();
    }
    AppMethodBeat.o(7903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g.3
 * JD-Core Version:    0.7.0.1
 */