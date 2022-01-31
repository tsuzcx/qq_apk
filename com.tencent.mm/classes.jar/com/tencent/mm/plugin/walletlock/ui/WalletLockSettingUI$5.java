package com.tencent.mm.plugin.walletlock.ui;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.soter.a.a;

final class WalletLockSettingUI$5
  implements Runnable
{
  WalletLockSettingUI$5(WalletLockSettingUI paramWalletLockSettingUI) {}
  
  public final void run()
  {
    try
    {
      a.Jr(3);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.5
 * JD-Core Version:    0.7.0.1
 */