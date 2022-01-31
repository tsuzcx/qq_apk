package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.picker.b;
import java.util.ArrayList;
import java.util.List;

final class WalletCardElementUI$11
  implements View.OnClickListener
{
  WalletCardElementUI$11(WalletCardElementUI paramWalletCardElementUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = new ArrayList();
    paramView.add(this.qCj.getString(a.i.wallet_deposit_card));
    paramView.add(this.qCj.getString(a.i.wallet_credit_card));
    ElementQuery localElementQuery;
    if (WalletCardElementUI.d(this.qCj).size() == 1)
    {
      localElementQuery = (ElementQuery)WalletCardElementUI.d(this.qCj).get(0);
      if (!localElementQuery.bVc()) {
        break label152;
      }
      paramView.remove(1);
    }
    for (;;)
    {
      paramView = new b(this.qCj.mController.uMN, paramView);
      paramView.IC(WalletCardElementUI.e(this.qCj));
      paramView.wov = new WalletCardElementUI.11.1(this, paramView);
      paramView.IB(a.fromDPToPix(this.qCj.mController.uMN, 288));
      paramView.show();
      return;
      label152:
      if (localElementQuery.bUS()) {
        paramView.remove(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardElementUI.11
 * JD-Core Version:    0.7.0.1
 */