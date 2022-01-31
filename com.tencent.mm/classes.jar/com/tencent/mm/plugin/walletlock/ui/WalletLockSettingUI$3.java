package com.tencent.mm.plugin.walletlock.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.a;

final class WalletLockSettingUI$3
  implements Runnable
{
  WalletLockSettingUI$3(WalletLockSettingUI paramWalletLockSettingUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(51746);
    try
    {
      a.Sn(3);
      AppMethodBeat.o(51746);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.WalletLockSettingUI", "Remove AK after open gesture lock failed! " + localException.getMessage());
      AppMethodBeat.o(51746);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.walletlock.ui.WalletLockSettingUI.3
 * JD-Core Version:    0.7.0.1
 */