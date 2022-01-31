package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.ui.u;
import com.tencent.mm.wallet_core.c.aa;

final class WalletPayUI$28
  extends u
{
  WalletPayUI$28(WalletPayUI paramWalletPayUI) {}
  
  public final void aEI()
  {
    p.bTK();
    int i;
    if (!p.bTL().bVO())
    {
      if (this.qnV.nDu != null) {
        break label55;
      }
      i = 0;
      if (this.qnV.nDu != null) {
        break label69;
      }
    }
    label55:
    label69:
    for (String str = "";; str = this.qnV.nDu.bMX)
    {
      aa.d(i, str, 6, "");
      this.qnV.bUl();
      return;
      i = this.qnV.nDu.bUV;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.28
 * JD-Core Version:    0.7.0.1
 */