package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.aa;

final class WalletPayUI$2
  implements View.OnClickListener
{
  WalletPayUI$2(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    int j = 0;
    p.bTK();
    int i;
    if (p.bTL().bVO())
    {
      if (this.qnV.nDu == null)
      {
        i = 0;
        if (this.qnV.nDu != null) {
          break label131;
        }
        paramView = "";
        label40:
        aa.d(i, paramView, 6, "");
      }
    }
    else
    {
      if (this.qnV.nEh.qwP != 1) {
        break label173;
      }
      p.bTK();
      if (p.bTL().bVO())
      {
        if (this.qnV.nDu != null) {
          break label145;
        }
        i = j;
        label88:
        if (this.qnV.nDu != null) {
          break label159;
        }
      }
    }
    label131:
    label145:
    label159:
    for (paramView = "";; paramView = this.qnV.nDu.bMX)
    {
      aa.d(i, paramView, 5, "");
      WalletPayUI.f(this.qnV);
      return;
      i = this.qnV.nDu.bUV;
      break;
      paramView = this.qnV.nDu.bMX;
      break label40;
      i = this.qnV.nDu.bUV;
      break label88;
    }
    label173:
    y.i("MicroMsg.WalletPayUI", "SimpleReg , assigned userinfo pay! payWithNewBankcard");
    p.bTK();
    if (p.bTL().bVO())
    {
      if (this.qnV.nDu != null) {
        break label238;
      }
      i = 0;
      if (this.qnV.nDu != null) {
        break label252;
      }
    }
    label238:
    label252:
    for (paramView = "";; paramView = this.qnV.nDu.bMX)
    {
      aa.d(i, paramView, 5, "");
      this.qnV.b(false, 0, "");
      return;
      i = this.qnV.nDu.bUV;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.2
 * JD-Core Version:    0.7.0.1
 */