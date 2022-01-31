package com.tencent.mm.plugin.wallet.bind.ui;

import android.os.Bundle;
import com.tencent.mm.plugin.wallet_core.b.b;
import com.tencent.mm.wallet_core.a;

final class WalletBankcardManageUI$10
  implements Runnable
{
  WalletBankcardManageUI$10(WalletBankcardManageUI paramWalletBankcardManageUI, Bundle paramBundle) {}
  
  public final void run()
  {
    this.qkp.putInt("key_bind_scene", 15);
    this.qkp.putBoolean("key_bind_show_change_card", true);
    a.a(this.qkk, b.class, this.qkp, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.bind.ui.WalletBankcardManageUI.10
 * JD-Core Version:    0.7.0.1
 */