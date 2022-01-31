package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wallet_core.model.b.a;
import com.tencent.mm.plugin.wallet_core.model.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class WalletBalanceFetchUI$18$1
  implements n.c
{
  WalletBalanceFetchUI$18$1(WalletBalanceFetchUI.18 param18) {}
  
  public final void a(l paraml)
  {
    b.c[] arrayOfc = this.qgZ.qgY.qth.qtj;
    int k = arrayOfc.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      b.c localc = arrayOfc[j];
      if (!bk.bl(localc.title))
      {
        if (bk.bl(localc.desc)) {
          break label85;
        }
        paraml.a(i, localc.title, localc.desc);
      }
      for (;;)
      {
        j += 1;
        i += 1;
        break;
        label85:
        paraml.e(i, localc.title);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.18.1
 * JD-Core Version:    0.7.0.1
 */