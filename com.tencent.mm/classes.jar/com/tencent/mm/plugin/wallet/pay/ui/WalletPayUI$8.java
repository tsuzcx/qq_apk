package com.tencent.mm.plugin.wallet.pay.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.aa;

final class WalletPayUI$8
  implements View.OnClickListener
{
  WalletPayUI$8(WalletPayUI paramWalletPayUI) {}
  
  public final void onClick(View paramView)
  {
    y.i("MicroMsg.WalletPayUI", "WalletPwdDialog event1 %s", new Object[] { bk.csb().toString() });
    this.qnV.qmA = ((FavorPayInfo)paramView.getTag());
    if (this.qnV.qmA != null) {
      this.qnV.qmA.qvG = "";
    }
    int i;
    if (this.qnV.nDu == null)
    {
      i = 0;
      if (this.qnV.nDu != null) {
        break label150;
      }
    }
    label150:
    for (paramView = "";; paramView = this.qnV.nDu.bMX)
    {
      aa.d(i, paramView, 10, "");
      this.qnV.c(false, 0, "");
      this.qnV.qgo.dismiss();
      this.qnV.frT = null;
      this.qnV.qgo = null;
      this.qnV.qmC = null;
      return;
      i = this.qnV.nDu.bUV;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.8
 * JD-Core Version:    0.7.0.1
 */