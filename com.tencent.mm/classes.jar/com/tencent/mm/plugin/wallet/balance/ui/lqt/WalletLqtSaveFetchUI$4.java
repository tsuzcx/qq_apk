package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class WalletLqtSaveFetchUI$4
  implements CompoundButton.OnCheckedChangeListener
{
  WalletLqtSaveFetchUI$4(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      WalletLqtSaveFetchUI.a(this.qiZ, false);
      return;
    }
    WalletLqtSaveFetchUI.a(this.qiZ, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.4
 * JD-Core Version:    0.7.0.1
 */