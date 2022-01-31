package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.j;

final class i$6
  implements DialogInterface.OnClickListener
{
  i$6(i parami, j paramj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(9908);
    this.vgP.cancel();
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
    this.vsn.onClose();
    AppMethodBeat.o(9908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.widget.i.6
 * JD-Core Version:    0.7.0.1
 */