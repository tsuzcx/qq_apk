package com.tencent.mm.plugin.wxcredit.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class WalletWXCreditOpenUI$1
  implements CompoundButton.OnCheckedChangeListener
{
  WalletWXCreditOpenUI$1(WalletWXCreditOpenUI paramWalletWXCreditOpenUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    WalletWXCreditOpenUI.a(this.rRU).setEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wxcredit.ui.WalletWXCreditOpenUI.1
 * JD-Core Version:    0.7.0.1
 */