package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class WalletSetPasswordUI$1
  implements View.OnClickListener
{
  WalletSetPasswordUI$1(WalletSetPasswordUI paramWalletSetPasswordUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.qGE.bTZ())
    {
      this.qGE.XM();
      this.qGE.showDialog(1000);
      return;
    }
    this.qGE.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletSetPasswordUI.1
 * JD-Core Version:    0.7.0.1
 */