package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxp;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$11
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$11(WalletLqtDetailUI paramWalletLqtDetailUI, bxp parambxp) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68797);
    if (this.Bbi.Fmq != 1)
    {
      if (this.Bbi.Fmq != 2) {
        break label62;
      }
      if (!bs.isNullOrNil(this.Bbi.EvL)) {
        e.n(this.Bbf, this.Bbi.EvL, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68797);
      return false;
      label62:
      if ((this.Bbi.Fmq == 3) && (!bs.isNullOrNil(this.Bbi.Ekn)) && (!bs.isNullOrNil(this.Bbi.EvL))) {
        e.v(this.Bbi.Ekn, this.Bbi.EvL, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.11
 * JD-Core Version:    0.7.0.1
 */