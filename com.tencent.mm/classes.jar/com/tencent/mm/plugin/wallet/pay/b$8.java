package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$8
  implements DialogInterface.OnClickListener
{
  b$8(b paramb, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45873);
    this.tVh.b(this.tVi, b.A(this.tVh));
    if (this.tVi.isTransparent()) {
      this.tVi.finish();
    }
    AppMethodBeat.o(45873);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.8
 * JD-Core Version:    0.7.0.1
 */