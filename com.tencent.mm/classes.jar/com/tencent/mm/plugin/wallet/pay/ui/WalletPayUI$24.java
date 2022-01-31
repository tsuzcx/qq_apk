package com.tencent.mm.plugin.wallet.pay.ui;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mm.ui.widget.a.c;

final class WalletPayUI$24
  implements CompoundButton.OnCheckedChangeListener
{
  WalletPayUI$24(WalletPayUI paramWalletPayUI, c paramc) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = this.qnZ.getButton(-2);
    if (paramBoolean)
    {
      paramCompoundButton.setEnabled(false);
      return;
    }
    paramCompoundButton.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.24
 * JD-Core Version:    0.7.0.1
 */