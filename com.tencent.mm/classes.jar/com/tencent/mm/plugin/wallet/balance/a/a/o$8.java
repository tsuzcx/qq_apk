package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d.a;

public final class o$8
  implements d.a
{
  public o$8(o paramo) {}
  
  public final void aE(Object paramObject)
  {
    y.i("MicroMsg.LqtSaveFetchLogic", "doRedeemFund interrupt: %s", new Object[] { paramObject });
    o.a(this.qgd).bTy();
    if (o.c(this.qgd) != null) {
      o.c(this.qgd).cg(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.o.8
 * JD-Core Version:    0.7.0.1
 */