package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class WalletPwdConfirmUI$1
  implements View.OnClickListener
{
  WalletPwdConfirmUI$1(WalletPwdConfirmUI paramWalletPwdConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47538);
    if (this.usw.needConfirmFinish())
    {
      this.usw.hideVKB();
      this.usw.showDialog(1000);
      AppMethodBeat.o(47538);
      return;
    }
    this.usw.finish();
    AppMethodBeat.o(47538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.1
 * JD-Core Version:    0.7.0.1
 */