package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class WalletPwdConfirmUI$1
  implements View.OnClickListener
{
  WalletPwdConfirmUI$1(WalletPwdConfirmUI paramWalletPwdConfirmUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.qFp.bTZ())
    {
      this.qFp.XM();
      this.qFp.showDialog(1000);
      return;
    }
    this.qFp.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletPwdConfirmUI.1
 * JD-Core Version:    0.7.0.1
 */