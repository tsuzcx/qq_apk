package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;

final class WalletOrderInfoOldUI$5
  implements az.b.a
{
  WalletOrderInfoOldUI$5(WalletOrderInfoOldUI paramWalletOrderInfoOldUI) {}
  
  public final void getContactCallBack(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(71048);
    au localau = ((n)h.ax(n.class)).bzA().JE(paramString);
    Log.d("MicroMsg.WalletOrderInfoOldUI", "call back from contactServer " + paramString + " succ: " + paramBoolean);
    this.VRm.au(localau);
    AppMethodBeat.o(71048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoOldUI.5
 * JD-Core Version:    0.7.0.1
 */