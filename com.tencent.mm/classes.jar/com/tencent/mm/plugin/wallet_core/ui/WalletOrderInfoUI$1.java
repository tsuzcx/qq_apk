package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

final class WalletOrderInfoUI$1
  implements ay.b.a
{
  WalletOrderInfoUI$1(WalletOrderInfoUI paramWalletOrderInfoUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71092);
    g.aAi();
    as localas = ((l)g.af(l.class)).aSN().Kn(paramString);
    Log.d("MicroMsg.WalletOrderInfoUI", "call back from contactServer " + paramString + " succ: " + paramBoolean);
    this.IiN.ai(localas);
    AppMethodBeat.o(71092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoUI.1
 * JD-Core Version:    0.7.0.1
 */