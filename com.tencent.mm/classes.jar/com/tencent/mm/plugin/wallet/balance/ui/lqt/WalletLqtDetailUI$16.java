package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ctg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$16
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$16(WalletLqtDetailUI paramWalletLqtDetailUI, ctg paramctg) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(213940);
    if (this.Hym.Myg != 1)
    {
      if (this.Hym.Myg != 2) {
        break label62;
      }
      if (!Util.isNullOrNil(this.Hym.yUB)) {
        f.o(this.Hyi, this.Hym.yUB, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(213940);
      return false;
      label62:
      if ((this.Hym.Myg == 3) && (!Util.isNullOrNil(this.Hym.KZR)) && (!Util.isNullOrNil(this.Hym.yUB))) {
        f.u(this.Hym.KZR, this.Hym.yUB, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.16
 * JD-Core Version:    0.7.0.1
 */