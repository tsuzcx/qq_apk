package com.tencent.mm.plugin.wallet.bind.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.wallet_core.a;

final class WalletBankcardManageUI$10
  implements Runnable
{
  WalletBankcardManageUI$10(WalletBankcardManageUI paramWalletBankcardManageUI, Bundle paramBundle) {}
  
  public final void run()
  {
    AppMethodBeat.i(45774);
    this.tTp.putInt("key_bind_scene", 15);
    this.tTp.putBoolean("key_bind_show_change_card", true);
    a.a(this.tTk, b.class, this.tTp, null);
    AppMethodBeat.o(45774);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.10
 * JD-Core Version:    0.7.0.1
 */