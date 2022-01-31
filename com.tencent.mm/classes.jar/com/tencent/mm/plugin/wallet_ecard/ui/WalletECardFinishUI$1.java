package com.tencent.mm.plugin.wallet_ecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Button;
import com.tencent.mm.sdk.platformtools.y;

final class WalletECardFinishUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletECardFinishUI$1(WalletECardFinishUI paramWalletECardFinishUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.i("MicroMsg.WalletECardFinishUI", "press back btn");
    WalletECardFinishUI.a(this.qKO).performClick();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI.1
 * JD-Core Version:    0.7.0.1
 */