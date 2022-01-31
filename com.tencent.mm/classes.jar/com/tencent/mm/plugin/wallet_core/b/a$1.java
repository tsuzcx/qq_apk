package com.tencent.mm.plugin.wallet_core.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class a$1
  implements DialogInterface.OnClickListener
{
  a$1(a parama, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46467);
    this.ubn.b(this.tVi, this.ubn.mEJ);
    if (this.tVi.isTransparent()) {
      this.tVi.finish();
    }
    this.tVi.clearErr();
    AppMethodBeat.o(46467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.b.a.1
 * JD-Core Version:    0.7.0.1
 */