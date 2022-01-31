package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

final class i$3
  implements DialogInterface.OnClickListener
{
  i$3(i parami, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(9905);
    this.vgP.cancel();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.vsn.onClose();
    AppMethodBeat.o(9905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i.3
 * JD-Core Version:    0.7.0.1
 */