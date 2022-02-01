package com.tencent.mm.pluginsdk.ui.span;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class m$6
  implements DialogInterface.OnCancelListener
{
  m$6(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31926);
    if (this.FhF != null) {
      this.FhF.onDismiss(null);
    }
    AppMethodBeat.o(31926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.m.6
 * JD-Core Version:    0.7.0.1
 */