package com.tencent.mm.plugin.wallet.pwd.ui;

import android.content.Intent;
import android.view.View;
import com.tencent.mm.wallet_core.ui.d;

final class WalletDigitalCertUI$1
  extends d
{
  WalletDigitalCertUI$1(WalletDigitalCertUI paramWalletDigitalCertUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.setClass(this.qoE, WalletIdCardCheckUI.class);
    this.qoE.startActivityForResult(paramView, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletDigitalCertUI.1
 * JD-Core Version:    0.7.0.1
 */