package com.tencent.mm.plugin.wallet.pay;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class b$7
  implements DialogInterface.OnClickListener
{
  b$7(b paramb, WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45872);
    b.y(this.tVh).putInt("key_err_code", -1003);
    this.tVh.a(this.tVi, 0, b.z(this.tVh));
    if (this.tVi.isTransparent()) {
      this.tVi.finish();
    }
    AppMethodBeat.o(45872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.b.7
 * JD-Core Version:    0.7.0.1
 */