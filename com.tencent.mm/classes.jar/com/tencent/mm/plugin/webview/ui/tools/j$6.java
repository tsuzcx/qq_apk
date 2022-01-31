package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;

final class j$6
  implements DialogInterface.OnClickListener
{
  j$6(j paramj, Intent paramIntent) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7647);
    d.b(this.vcO.ddt(), "webview", ".ui.tools.WebViewUI", this.val$intent);
    AppMethodBeat.o(7647);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.6
 * JD-Core Version:    0.7.0.1
 */