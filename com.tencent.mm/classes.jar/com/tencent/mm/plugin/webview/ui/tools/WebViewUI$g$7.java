package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PBool;
import com.tencent.xweb.j;

final class WebViewUI$g$7
  implements DialogInterface.OnClickListener
{
  WebViewUI$g$7(WebViewUI.g paramg, PBool paramPBool, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7907);
    this.vgO.value = true;
    this.vgP.confirm();
    AppMethodBeat.o(7907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g.7
 * JD-Core Version:    0.7.0.1
 */