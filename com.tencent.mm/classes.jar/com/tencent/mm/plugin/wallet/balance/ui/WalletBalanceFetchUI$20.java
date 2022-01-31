package com.tencent.mm.plugin.wallet.balance.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vd;
import com.tencent.mm.g.a.vd.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.e;

final class WalletBalanceFetchUI$20
  implements Runnable
{
  WalletBalanceFetchUI$20(WalletBalanceFetchUI paramWalletBalanceFetchUI, vd paramvd) {}
  
  public final void run()
  {
    AppMethodBeat.i(45380);
    if (!bo.isNullOrNil(this.kSA.cLF.cLG))
    {
      e.a(WalletBalanceFetchUI.m(this.tOj), this.kSA.cLF.cLG, this.kSA.cLF.content, this.kSA.cLF.url);
      AppMethodBeat.o(45380);
      return;
    }
    ab.i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
    AppMethodBeat.o(45380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI.20
 * JD-Core Version:    0.7.0.1
 */