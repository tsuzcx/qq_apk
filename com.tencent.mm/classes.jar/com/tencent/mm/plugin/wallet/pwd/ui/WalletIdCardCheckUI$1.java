package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class WalletIdCardCheckUI$1
  implements MenuItem.OnMenuItemClickListener
{
  WalletIdCardCheckUI$1(WalletIdCardCheckUI paramWalletIdCardCheckUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    y.i("Micromsg.WalletIdCardCheckUI", "onbackbtn click");
    this.qpp.finish();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletIdCardCheckUI.1
 * JD-Core Version:    0.7.0.1
 */