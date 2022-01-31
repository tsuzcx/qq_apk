package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$9
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$9(WalletLqtDetailUI paramWalletLqtDetailUI, bfx parambfx) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(45533);
    if (this.tPS.xuO != 1)
    {
      if (this.tPS.xuO != 2) {
        break label62;
      }
      if (!bo.isNullOrNil(this.tPS.wPJ)) {
        e.m(this.tPQ, this.tPS.wPJ, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(45533);
      return false;
      label62:
      if ((this.tPS.xuO == 3) && (!bo.isNullOrNil(this.tPS.wFW)) && (!bo.isNullOrNil(this.tPS.wPJ))) {
        e.q(this.tPS.wFW, this.tPS.wPJ, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.9
 * JD-Core Version:    0.7.0.1
 */