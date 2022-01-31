package com.tencent.mm.plugin.wxcredit.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

final class WalletBindDepositUI$2
  implements View.OnClickListener
{
  WalletBindDepositUI$2(WalletBindDepositUI paramWalletBindDepositUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(48673);
    if (WalletBindDepositUI.e(this.vHY)) {
      this.vHY.getNetController().p(new Object[] { WalletBindDepositUI.a(this.vHY).getText(), WalletBindDepositUI.d(this.vHY).poq, WalletBindDepositUI.f(this.vHY).getText(), WalletBindDepositUI.d(this.vHY).uhA, Boolean.FALSE });
    }
    AppMethodBeat.o(48673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletBindDepositUI.2
 * JD-Core Version:    0.7.0.1
 */