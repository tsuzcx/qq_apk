package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.c;
import com.tencent.mm.plugin.wallet_core.model.c.a;
import com.tencent.mm.plugin.wallet_core.model.c.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class WalletBalanceFetchUI$22$1
  implements n.c
{
  WalletBalanceFetchUI$22$1(WalletBalanceFetchUI.22 param22) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(45383);
    c.c[] arrayOfc = this.tOv.tOu.ufs.ufu;
    int k = arrayOfc.length;
    int j = 0;
    int i = 0;
    if (j < k)
    {
      c.c localc = arrayOfc[j];
      if (!bo.isNullOrNil(localc.title))
      {
        if (bo.isNullOrNil(localc.desc)) {
          break label90;
        }
        paraml.a(i, localc.title, localc.desc);
      }
      for (;;)
      {
        j += 1;
        i += 1;
        break;
        label90:
        paraml.e(i, localc.title);
      }
    }
    AppMethodBeat.o(45383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.22.1
 * JD-Core Version:    0.7.0.1
 */