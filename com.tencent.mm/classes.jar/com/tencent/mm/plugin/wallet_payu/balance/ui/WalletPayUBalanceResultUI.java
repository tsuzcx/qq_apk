package com.tencent.mm.plugin.wallet_payu.balance.ui;

import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;

public class WalletPayUBalanceResultUI
  extends WalletBalanceResultUI
{
  protected final void aZ()
  {
    if (this.nEh != null)
    {
      this.qhs.setText(e.d(this.nEh.nCq, this.nEh.mOZ));
      if ((this.qhv != null) && (!bk.bl(this.qhv.field_bankName)))
      {
        if (bk.bl(this.qhv.field_bankcardTail)) {
          break label117;
        }
        this.nvx.setText(this.qhv.field_bankName + " " + getString(a.i.wallet_pay_bankcard_tail) + this.qhv.field_bankcardTail);
      }
    }
    return;
    label117:
    this.nvx.setText(this.qhv.field_bankName);
  }
  
  protected final void initView()
  {
    super.initView();
    this.qhu.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.balance.ui.WalletPayUBalanceResultUI
 * JD-Core Version:    0.7.0.1
 */