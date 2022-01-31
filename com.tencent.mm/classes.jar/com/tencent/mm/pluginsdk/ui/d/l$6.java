package com.tencent.mm.pluginsdk.ui.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class l$6
  implements DialogInterface.OnCancelListener
{
  l$6(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(28136);
    if (this.wcs != null) {
      this.wcs.onDismiss(null);
    }
    AppMethodBeat.o(28136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.d.l.6
 * JD-Core Version:    0.7.0.1
 */