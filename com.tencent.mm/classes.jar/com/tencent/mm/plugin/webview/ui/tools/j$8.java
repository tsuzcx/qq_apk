package com.tencent.mm.plugin.webview.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.ui.widget.b.c;

final class j$8
  implements DialogInterface.OnClickListener
{
  j$8(j paramj, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(7649);
    if (paramDialogInterface == null) {}
    for (paramDialogInterface = "";; paramDialogInterface = ((c)paramDialogInterface).dOY())
    {
      this.vcO.ddt().uQS.o(this.vcQ, paramDialogInterface, 0);
      AppMethodBeat.o(7649);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.j.8
 * JD-Core Version:    0.7.0.1
 */