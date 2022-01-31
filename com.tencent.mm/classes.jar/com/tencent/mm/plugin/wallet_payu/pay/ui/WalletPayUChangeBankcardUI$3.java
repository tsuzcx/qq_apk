package com.tencent.mm.plugin.wallet_payu.pay.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPayUChangeBankcardUI$3
  implements DialogInterface.OnCancelListener
{
  WalletPayUChangeBankcardUI$3(WalletPayUChangeBankcardUI paramWalletPayUChangeBankcardUI) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(48463);
    WalletPayUChangeBankcardUI.j(this.uDl);
    if (WalletPayUChangeBankcardUI.k(this.uDl).getVisibility() != 0) {
      WalletPayUChangeBankcardUI.l(this.uDl);
    }
    AppMethodBeat.o(48463);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.pay.ui.WalletPayUChangeBankcardUI.3
 * JD-Core Version:    0.7.0.1
 */