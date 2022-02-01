package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dtx;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.i;

final class WalletLqtDetailUI$17
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$17(WalletLqtDetailUI paramWalletLqtDetailUI, dtx paramdtx) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(316469);
    if (this.Vfh.aaZv != 1)
    {
      if (this.Vfh.aaZv != 2) {
        break label62;
      }
      if (!Util.isNullOrNil(this.Vfh.Krl)) {
        i.o(this.VeZ, this.Vfh.Krl, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(316469);
      return false;
      label62:
      if ((this.Vfh.aaZv == 3) && (!Util.isNullOrNil(this.Vfh.YYZ)) && (!Util.isNullOrNil(this.Vfh.Krl))) {
        i.y(this.Vfh.YYZ, this.Vfh.Krl, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.17
 * JD-Core Version:    0.7.0.1
 */