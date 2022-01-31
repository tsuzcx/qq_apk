package com.tencent.mm.plugin.wallet_core.ui.cashier;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class a$3
  implements DialogInterface.OnDismissListener
{
  a$3(a parama) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(47738);
    a.b(this.uuG).destory();
    AppMethodBeat.o(47738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.cashier.a.3
 * JD-Core Version:    0.7.0.1
 */