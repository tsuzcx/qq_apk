package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;

final class WalletOrderInfoUI$1
  implements ar.b.a
{
  WalletOrderInfoUI$1(WalletOrderInfoUI paramWalletOrderInfoUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71092);
    g.agS();
    ai localai = ((k)g.ab(k.class)).awB().aNt(paramString);
    ac.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + paramString + " succ: " + paramBoolean);
    this.BHG.Z(localai);
    AppMethodBeat.o(71092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI.1
 * JD-Core Version:    0.7.0.1
 */