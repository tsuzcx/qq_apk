package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class a$6
  implements DialogInterface.OnClickListener
{
  a$6(a parama, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46136);
    this.tXB.b(this.tVi, a.g(this.tXB));
    if (this.tVi.isTransparent()) {
      this.tVi.finish();
    }
    this.tVi.clearErr();
    AppMethodBeat.o(46136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.a.6
 * JD-Core Version:    0.7.0.1
 */