package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ccg;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$14
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$14(WalletLqtDetailUI paramWalletLqtDetailUI, ccg paramccg) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(199209);
    if (this.CBw.GVZ != 1)
    {
      if (this.CBw.GVZ != 2) {
        break label62;
      }
      if (!bt.isNullOrNil(this.CBw.Gdh)) {
        e.n(this.CBs, this.CBw.Gdh, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199209);
      return false;
      label62:
      if ((this.CBw.GVZ == 3) && (!bt.isNullOrNil(this.CBw.FRw)) && (!bt.isNullOrNil(this.CBw.Gdh))) {
        e.v(this.CBw.FRw, this.CBw.Gdh, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.14
 * JD-Core Version:    0.7.0.1
 */