package com.tencent.mm.wallet_core.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

final class WalletBaseUI$4
  implements MenuItem.OnMenuItemClickListener
{
  WalletBaseUI$4(WalletBaseUI paramWalletBaseUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    if (this.wCn.bTZ())
    {
      this.wCn.XM();
      this.wCn.showDialog(1000);
    }
    for (;;)
    {
      return true;
      this.wCn.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.wallet_core.ui.WalletBaseUI.4
 * JD-Core Version:    0.7.0.1
 */