package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class WalletOrderInfoUI$1
  implements am.b.a
{
  WalletOrderInfoUI$1(WalletOrderInfoUI paramWalletOrderInfoUI) {}
  
  public final void m(String paramString, boolean paramBoolean)
  {
    g.DQ();
    ad localad = ((j)g.r(j.class)).Fw().abl(paramString);
    y.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + paramString + " succ: " + paramBoolean);
    this.qFk.O(localad);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI.1
 * JD-Core Version:    0.7.0.1
 */