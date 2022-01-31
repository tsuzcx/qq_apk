package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class WalletPayUI$29$1$2
  implements View.OnClickListener
{
  WalletPayUI$29$1$2(WalletPayUI.29.1 param1) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletPayUI", "Balance amount not meet, after favor selection! payWithNewBankcard");
    this.qob.qoa.qnV.b(false, 0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.29.1.2
 * JD-Core Version:    0.7.0.1
 */