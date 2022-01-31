package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.aa;

final class WalletPayUI$29
  implements View.OnClickListener
{
  WalletPayUI$29(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    int i;
    if (this.qnV.nDu == null)
    {
      i = 0;
      if (this.qnV.nDu != null) {
        break label88;
      }
    }
    label88:
    for (paramView = "";; paramView = this.qnV.nDu.bMX)
    {
      aa.d(i, paramView, 12, "");
      j.a(this.qnV.mController.uMN, this.qnV.nEh, this.qnV.qmA.qvC, new WalletPayUI.29.1(this));
      return;
      i = this.qnV.nDu.bUV;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.29
 * JD-Core Version:    0.7.0.1
 */