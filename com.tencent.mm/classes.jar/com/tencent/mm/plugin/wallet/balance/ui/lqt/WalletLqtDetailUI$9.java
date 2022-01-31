package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.wallet_core.ui.e;

final class WalletLqtDetailUI$9
  implements View.OnClickListener
{
  WalletLqtDetailUI$9(WalletLqtDetailUI paramWalletLqtDetailUI) {}
  
  public final void onClick(View paramView)
  {
    if (!bk.bl(WalletLqtDetailUI.c(this.qil).tCl)) {
      e.l(this.qil, WalletLqtDetailUI.c(this.qil).tCl, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.9
 * JD-Core Version:    0.7.0.1
 */