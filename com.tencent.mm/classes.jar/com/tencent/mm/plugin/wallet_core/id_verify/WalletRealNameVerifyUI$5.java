package com.tencent.mm.plugin.wallet_core.id_verify;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class WalletRealNameVerifyUI$5
  implements CompoundButton.OnCheckedChangeListener
{
  WalletRealNameVerifyUI$5(WalletRealNameVerifyUI paramWalletRealNameVerifyUI) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WalletRealNameVerifyUI.d(this.qse).setEnabled(true);
      WalletRealNameVerifyUI.d(this.qse).setClickable(true);
      return;
    }
    WalletRealNameVerifyUI.d(this.qse).setEnabled(false);
    WalletRealNameVerifyUI.d(this.qse).setClickable(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.id_verify.WalletRealNameVerifyUI.5
 * JD-Core Version:    0.7.0.1
 */