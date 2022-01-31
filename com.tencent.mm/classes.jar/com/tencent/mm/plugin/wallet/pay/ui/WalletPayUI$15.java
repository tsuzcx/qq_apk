package com.tencent.mm.plugin.wallet.pay.ui;

import com.tencent.mm.plugin.wallet.pay.a.c.e;
import com.tencent.mm.wallet_core.c.d;
import com.tencent.mm.wallet_core.c.i;

final class WalletPayUI$15
  implements d
{
  WalletPayUI$15(WalletPayUI paramWalletPayUI, i parami, e parame) {}
  
  public final void bTn()
  {
    if (this.qgR.cMu())
    {
      WalletPayUI.a(this.qnV, this.qnX);
      return;
    }
    this.qnV.bUf();
  }
  
  public final void bTo()
  {
    if (this.qgR.cMu())
    {
      WalletPayUI.a(this.qnV, this.qnX);
      return;
    }
    this.qnV.finish();
  }
  
  public final void onCancel()
  {
    if (this.qgR.cMu())
    {
      WalletPayUI.a(this.qnV, this.qnX);
      return;
    }
    this.qnV.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.15
 * JD-Core Version:    0.7.0.1
 */