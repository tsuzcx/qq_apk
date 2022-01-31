package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBankcardDetailUI$6
  implements DialogInterface.OnClickListener
{
  WalletBankcardDetailUI$6(WalletBankcardDetailUI paramWalletBankcardDetailUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(45746);
    ((b)g.E(b.class)).j(this.tSV, 1);
    e.RX(1);
    AppMethodBeat.o(45746);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardDetailUI.6
 * JD-Core Version:    0.7.0.1
 */