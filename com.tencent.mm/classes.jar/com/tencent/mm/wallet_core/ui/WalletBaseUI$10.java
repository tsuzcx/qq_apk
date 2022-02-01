package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.a;

final class WalletBaseUI$10
  implements DialogInterface.OnClickListener
{
  WalletBaseUI$10(WalletBaseUI paramWalletBaseUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(72969);
    a.b(this.YWY, null, -10000);
    AppMethodBeat.o(72969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.10
 * JD-Core Version:    0.7.0.1
 */