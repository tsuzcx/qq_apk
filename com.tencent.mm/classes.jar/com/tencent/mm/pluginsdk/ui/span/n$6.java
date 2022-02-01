package com.tencent.mm.pluginsdk.ui.span;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n$6
  implements DialogInterface.OnCancelListener
{
  n$6(DialogInterface.OnDismissListener paramOnDismissListener) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(31926);
    if (this.Rsq != null) {
      this.Rsq.onDismiss(null);
    }
    AppMethodBeat.o(31926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.n.6
 * JD-Core Version:    0.7.0.1
 */