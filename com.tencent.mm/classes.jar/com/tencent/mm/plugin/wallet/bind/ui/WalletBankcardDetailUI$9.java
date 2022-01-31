package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletBankcardDetailUI$9
  implements DialogInterface.OnClickListener
{
  WalletBankcardDetailUI$9(WalletBankcardDetailUI paramWalletBankcardDetailUI, int paramInt) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45749);
    if (this.jDp == 2) {
      WalletBankcardDetailUI.b(this.tSV);
    }
    paramDialogInterface.dismiss();
    AppMethodBeat.o(45749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.9
 * JD-Core Version:    0.7.0.1
 */