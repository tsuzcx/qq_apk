package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.pluginsdk.n;

final class g$114
  implements DialogInterface.OnClickListener
{
  g$114(g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(155034);
    a.gmO.g(new Intent(), g.j(this.vqm));
    AppMethodBeat.o(155034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.114
 * JD-Core Version:    0.7.0.1
 */