package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$13
  implements DialogInterface.OnDismissListener
{
  g$13(g paramg, i parami) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(154931);
    this.vqm.a(this.uZa, "share_weibo:no_weibo", null);
    AppMethodBeat.o(154931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.13
 * JD-Core Version:    0.7.0.1
 */