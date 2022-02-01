package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;

final class WalletOrderInfoOldUI$6
  implements au.b.a
{
  WalletOrderInfoOldUI$6(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71048);
    an localan = ((l)g.ab(l.class)).azF().BH(paramString);
    ae.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + paramString + " succ: " + paramBoolean);
    this.Dzg.ag(localan);
    AppMethodBeat.o(71048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.6
 * JD-Core Version:    0.7.0.1
 */