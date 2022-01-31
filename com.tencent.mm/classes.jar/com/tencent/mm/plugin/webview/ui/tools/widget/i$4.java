package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

final class i$4
  implements DialogInterface.OnClickListener
{
  i$4(i parami, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(9906);
    this.vgP.confirm();
    AppMethodBeat.o(9906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i.4
 * JD-Core Version:    0.7.0.1
 */