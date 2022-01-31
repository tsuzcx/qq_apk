package com.tencent.mm.plugin.wallet.pay.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.c.a;

final class WalletPayUI$25
  implements c.a
{
  WalletPayUI$25(WalletPayUI paramWalletPayUI) {}
  
  public final Intent m(int paramInt, Bundle paramBundle)
  {
    y.d("MicroMsg.WalletPayUI", "pay process end");
    this.qnV.qnp = false;
    return new Intent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pay.ui.WalletPayUI.25
 * JD-Core Version:    0.7.0.1
 */