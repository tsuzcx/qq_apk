package com.tencent.mm.plugin.walletlock.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.a;

final class WalletLockSettingUI$5
  implements Runnable
{
  WalletLockSettingUI$5(WalletLockSettingUI paramWalletLockSettingUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(51747);
    try
    {
      a.Sn(3);
      AppMethodBeat.o(51747);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WalletLockSettingUI", "Remove AK after close wallet lock failed! " + localException.getMessage());
      AppMethodBeat.o(51747);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.5
 * JD-Core Version:    0.7.0.1
 */