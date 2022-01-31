package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.j;

final class WebViewUI$g$9
  implements DialogInterface.OnDismissListener
{
  WebViewUI$g$9(WebViewUI.g paramg, PBool paramPBool, j paramj) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(7909);
    ab.d("MicroMsg.WebViewUI", "onJsConfirm, onDismiss");
    if (!this.vgO.value) {
      this.vgP.cancel();
    }
    AppMethodBeat.o(7909);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g.9
 * JD-Core Version:    0.7.0.1
 */