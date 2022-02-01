package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsy;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$11
  implements MenuItem.OnMenuItemClickListener
{
  WalletLqtDetailUI$11(WalletLqtDetailUI paramWalletLqtDetailUI, bsy parambsy) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(68797);
    if (this.zIW.DPZ != 1)
    {
      if (this.zIW.DPZ != 2) {
        break label62;
      }
      if (!bt.isNullOrNil(this.zIW.DcE)) {
        e.o(this.zIT, this.zIW.DcE, false);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(68797);
      return false;
      label62:
      if ((this.zIW.DPZ == 3) && (!bt.isNullOrNil(this.zIW.CRC)) && (!bt.isNullOrNil(this.zIW.DcE))) {
        e.v(this.zIW.CRC, this.zIW.DcE, 0, 1061);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.11
 * JD-Core Version:    0.7.0.1
 */