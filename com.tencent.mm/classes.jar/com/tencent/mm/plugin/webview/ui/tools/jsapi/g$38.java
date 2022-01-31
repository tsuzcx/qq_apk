package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;

final class g$38
  implements DialogInterface.OnClickListener
{
  g$38(g paramg, i parami, Map paramMap) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(154961);
    this.vqm.a(this.uZa, this.uZa.vrQ + ":ok", this.vqI);
    AppMethodBeat.o(154961);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.38
 * JD-Core Version:    0.7.0.1
 */