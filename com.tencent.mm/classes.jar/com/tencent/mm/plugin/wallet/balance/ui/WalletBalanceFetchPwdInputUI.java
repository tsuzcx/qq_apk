package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

@a(3)
public class WalletBalanceFetchPwdInputUI
  extends WalletBaseUI
{
  private String mTitle = "";
  private String qgn = "";
  private o qgo;
  
  private void showDialog()
  {
    if ((this.qgo != null) && (this.qgo.isShowing())) {
      this.qgo.dismiss();
    }
    Orders localOrders = (Orders)this.BX.getParcelable("key_orders");
    String str = "";
    if (localOrders.nyC > 0.0D) {
      str = getResources().getString(a.i.wallet_balance_additional_deduction_fee_tips_2, new Object[] { e.d(localOrders.nyC, localOrders.mOZ) });
    }
    if (this.qgo == null)
    {
      this.qgo = o.a(this, this.mTitle, this.qgn, str, new WalletBalanceFetchPwdInputUI.2(this), new WalletBalanceFetchPwdInputUI.3(this), new WalletBalanceFetchPwdInputUI.4(this));
      return;
    }
    this.qgo.bvr();
    this.qgo.show();
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    int i = 1;
    super.onCreate(paramBundle);
    vN(4);
    this.mTitle = this.BX.getString("key_pwd_cash_title");
    this.qgn = this.BX.getString("key_pwd_cash_money");
    y.i("MicroMsg.WalletBalanceFetchPwdInputUI", "hy: money : %s, title : %s", new Object[] { bk.pm(this.qgn), bk.pm(this.mTitle) });
    if ((!bk.bl(this.mTitle)) && (!bk.bl(this.qgn))) {}
    while (i == 0)
    {
      h.a(this.mController.uMN, a.i.wallet_order_info_err, 0, new WalletBalanceFetchPwdInputUI.1(this));
      return;
      i = 0;
    }
    showDialog();
  }
  
  public final void st(int paramInt)
  {
    if (paramInt == 0) {
      finish();
    }
    while (paramInt != 1) {
      return;
    }
    showDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchPwdInputUI
 * JD-Core Version:    0.7.0.1
 */