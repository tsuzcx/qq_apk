package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.android.wechat.MyKeyboardWindow;

final class WalletConfirmCardIDUI$2
  implements View.OnClickListener
{
  WalletConfirmCardIDUI$2(WalletConfirmCardIDUI paramWalletConfirmCardIDUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47366);
    if ((!WalletConfirmCardIDUI.a(this.uqm).isShown()) && (!WalletConfirmCardIDUI.b(this.uqm)))
    {
      WalletConfirmCardIDUI.c(this.uqm).setVisibility(0);
      WalletConfirmCardIDUI.d(this.uqm).setVisibility(0);
    }
    WalletConfirmCardIDUI.e(this.uqm);
    AppMethodBeat.o(47366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI.2
 * JD-Core Version:    0.7.0.1
 */