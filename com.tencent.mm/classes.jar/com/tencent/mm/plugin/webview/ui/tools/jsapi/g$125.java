package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class g$125
  implements DialogInterface.OnDismissListener
{
  g$125(g paramg, i parami) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(155039);
    this.vqm.a(this.uZa, "share_weibo:not_bind_qq", null);
    AppMethodBeat.o(155039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.125
 * JD-Core Version:    0.7.0.1
 */