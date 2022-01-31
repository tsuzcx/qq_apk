package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class h$1
  implements DialogInterface.OnClickListener
{
  h$1(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49125);
    if (this.tVi.isTransparent()) {
      this.tVi.finish();
    }
    AppMethodBeat.o(49125);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.wallet_core.d.h.1
 * JD-Core Version:    0.7.0.1
 */