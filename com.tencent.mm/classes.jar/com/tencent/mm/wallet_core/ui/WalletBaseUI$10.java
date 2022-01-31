package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;

final class WalletBaseUI$10
  implements DialogInterface.OnClickListener
{
  WalletBaseUI$10(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(49246);
    this.AYz.cancelQRPay();
    paramDialogInterface = a.aM(this.AYz);
    this.AYz.mPayResultType = 4;
    if (paramDialogInterface != null)
    {
      if (!paramDialogInterface.h(this.AYz, this.AYz.getInput()))
      {
        paramDialogInterface.b(this.AYz, this.AYz.getInput());
        AppMethodBeat.o(49246);
      }
    }
    else {
      this.AYz.finish();
    }
    AppMethodBeat.o(49246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.10
 * JD-Core Version:    0.7.0.1
 */