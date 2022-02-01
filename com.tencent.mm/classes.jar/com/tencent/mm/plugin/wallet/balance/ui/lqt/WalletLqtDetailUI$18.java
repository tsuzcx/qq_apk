package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dcf;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.g;

final class WalletLqtDetailUI$18
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$18(WalletLqtDetailUI paramWalletLqtDetailUI, dcf paramdcf) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(216340);
    if (this.Oqd.TJG != 1)
    {
      if (this.Oqd.TJG != 2) {
        break label62;
      }
      if (!Util.isNullOrNil(this.Oqd.Eyy)) {
        g.o(this.OpW, this.Oqd.Eyy, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(216340);
      return false;
      label62:
      if ((this.Oqd.TJG == 3) && (!Util.isNullOrNil(this.Oqd.Sba)) && (!Util.isNullOrNil(this.Oqd.Eyy))) {
        g.v(this.Oqd.Sba, this.Oqd.Eyy, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.18
 * JD-Core Version:    0.7.0.1
 */