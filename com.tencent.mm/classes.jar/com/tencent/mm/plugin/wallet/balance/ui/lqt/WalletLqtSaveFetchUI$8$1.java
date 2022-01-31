package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.d.a;

final class WalletLqtSaveFetchUI$8$1
  implements d.a
{
  WalletLqtSaveFetchUI$8$1(WalletLqtSaveFetchUI.8 param8) {}
  
  public final void aE(Object paramObject)
  {
    y.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", new Object[] { paramObject });
    this.qje.qiZ.bTy();
    if (paramObject != null) {
      if (!(paramObject instanceof String)) {
        break label53;
      }
    }
    label53:
    for (paramObject = paramObject.toString();; paramObject = this.qje.qiZ.getString(a.i.wallet_lqt_network_error))
    {
      this.qje.qiZ.Lz(paramObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.8.1
 * JD-Core Version:    0.7.0.1
 */