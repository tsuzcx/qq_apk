package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.e;

final class WalletPayUI$27
  implements View.OnClickListener
{
  WalletPayUI$27(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    if (this.qnV.qns) {
      this.qnV.qnB.setImageResource(a.e.pay_dital_bill_guid_down);
    }
    for (this.qnV.qns = false;; this.qnV.qns = true)
    {
      this.qnV.qnF.notifyDataSetChanged();
      return;
      this.qnV.qnB.setImageResource(a.e.pay_dital_bill_guid_up);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.27
 * JD-Core Version:    0.7.0.1
 */