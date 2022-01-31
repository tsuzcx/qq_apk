package com.tencent.mm.plugin.wallet.balance.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletBalanceSaveUI$1
  extends com.tencent.mm.ui.t
{
  WalletBalanceSaveUI$1(WalletBalanceSaveUI paramWalletBalanceSaveUI) {}
  
  public final void bhX()
  {
    AppMethodBeat.i(45469);
    this.tOS.qlk = bo.getDouble(this.tOS.kRl.getText(), 0.0D);
    if ((this.tOS.qlk > 0.0D) && (this.tOS.kRl.asv()))
    {
      this.tOS.cRi();
      AppMethodBeat.o(45469);
      return;
    }
    com.tencent.mm.ui.base.t.makeText(this.tOS.getContext(), 2131304847, 0).show();
    AppMethodBeat.o(45469);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI.1
 * JD-Core Version:    0.7.0.1
 */