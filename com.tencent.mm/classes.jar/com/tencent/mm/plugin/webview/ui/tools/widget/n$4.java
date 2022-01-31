package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class n$4
  implements DialogInterface.OnCancelListener
{
  n$4(n paramn, n.a parama) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(79177);
    ab.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
    this.vte.h(3, null);
    AppMethodBeat.o(79177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.n.4
 * JD-Core Version:    0.7.0.1
 */