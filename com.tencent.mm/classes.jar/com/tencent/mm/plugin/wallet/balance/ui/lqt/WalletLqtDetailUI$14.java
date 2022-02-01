package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.f;

final class WalletLqtDetailUI$14
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$14(WalletLqtDetailUI paramWalletLqtDetailUI, cda paramcda) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(190066);
    if (this.CTd.Hpz != 1)
    {
      if (this.CTd.Hpz != 2) {
        break label62;
      }
      if (!bu.isNullOrNil(this.CTd.GvO)) {
        f.o(this.CSZ, this.CTd.GvO, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(190066);
      return false;
      label62:
      if ((this.CTd.Hpz == 3) && (!bu.isNullOrNil(this.CTd.GjV)) && (!bu.isNullOrNil(this.CTd.GvO))) {
        f.u(this.CTd.GjV, this.CTd.GvO, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.14
 * JD-Core Version:    0.7.0.1
 */