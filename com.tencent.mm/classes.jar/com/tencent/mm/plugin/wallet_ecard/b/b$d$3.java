package com.tencent.mm.plugin.wallet_ecard.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$d$3
  implements DialogInterface.OnDismissListener
{
  b$d$3(b.d paramd) {}
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(48089);
    ab.i("MicroMsg.OpenECardProcess", "dismiss alert");
    this.uzv.gNn = null;
    AppMethodBeat.o(48089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.b.b.d.3
 * JD-Core Version:    0.7.0.1
 */