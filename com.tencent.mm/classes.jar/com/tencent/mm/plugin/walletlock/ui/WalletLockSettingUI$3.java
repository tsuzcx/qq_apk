package com.tencent.mm.plugin.walletlock.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.a;

final class WalletLockSettingUI$3
  implements Runnable
{
  WalletLockSettingUI$3(WalletLockSettingUI paramWalletLockSettingUI) {}
  
  public final void run()
  {
    try
    {
      a.Jr(3);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.3
 * JD-Core Version:    0.7.0.1
 */