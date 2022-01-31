package com.tencent.mm.plugin.wallet.pwd;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class c$3
  implements DialogInterface.OnClickListener
{
  c$3(c paramc, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(46159);
    this.tXE.b(this.tVi, c.f(this.tXE));
    if (this.tVi.isTransparent()) {
      this.tVi.finish();
    }
    this.tVi.clearErr();
    AppMethodBeat.o(46159);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.c.3
 * JD-Core Version:    0.7.0.1
 */