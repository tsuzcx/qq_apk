package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

final class WalletOrderInfoUI$1
  implements ao.b.a
{
  WalletOrderInfoUI$1(WalletOrderInfoUI paramWalletOrderInfoUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(47523);
    g.RM();
    ad localad = ((j)g.E(j.class)).YA().arw(paramString);
    ab.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + paramString + " succ: " + paramBoolean);
    this.usr.R(localad);
    AppMethodBeat.o(47523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI.1
 * JD-Core Version:    0.7.0.1
 */