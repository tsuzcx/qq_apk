package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

final class WalletOrderInfoOldUI$6
  implements ay.b.a
{
  WalletOrderInfoOldUI$6(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void p(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71048);
    as localas = ((l)g.af(l.class)).aSN().Kn(paramString);
    Log.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + paramString + " succ: " + paramBoolean);
    this.Iir.ai(localas);
    AppMethodBeat.o(71048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.6
 * JD-Core Version:    0.7.0.1
 */