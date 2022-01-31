package com.tencent.mm.plugin.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class q$b
  implements DialogInterface.OnCancelListener
{
  private DialogInterface.OnCancelListener utw = null;
  
  private q$b(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    this.utw = paramOnCancelListener;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(47604);
    q.nR(false);
    if (this.utw != null) {
      this.utw.onCancel(paramDialogInterface);
    }
    AppMethodBeat.o(47604);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.q.b
 * JD-Core Version:    0.7.0.1
 */