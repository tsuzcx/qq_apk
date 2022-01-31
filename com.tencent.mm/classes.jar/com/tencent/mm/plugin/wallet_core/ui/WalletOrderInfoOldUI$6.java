package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class WalletOrderInfoOldUI$6
  implements am.b.a
{
  WalletOrderInfoOldUI$6(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    ad localad = ((j)g.r(j.class)).Fw().abl(paramString);
    y.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + paramString + " succ: " + paramBoolean);
    this.qEN.O(localad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.6
 * JD-Core Version:    0.7.0.1
 */