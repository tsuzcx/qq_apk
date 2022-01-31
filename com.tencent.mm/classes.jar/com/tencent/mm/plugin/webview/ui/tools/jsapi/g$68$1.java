package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.d;

final class g$68$1
  implements DialogInterface.OnClickListener
{
  g$68$1(g.68 param68) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(154988);
    if (g.j(this.vqZ.vqm) != null) {
      d.cc(g.j(this.vqZ.vqm));
    }
    AppMethodBeat.o(154988);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.68.1
 * JD-Core Version:    0.7.0.1
 */