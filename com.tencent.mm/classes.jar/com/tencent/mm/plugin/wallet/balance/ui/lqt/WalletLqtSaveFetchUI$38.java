package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.a.g.a;

final class WalletLqtSaveFetchUI$38
  implements g.a
{
  WalletLqtSaveFetchUI$38(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI, g paramg) {}
  
  public final void onClick()
  {
    AppMethodBeat.i(214013);
    Log.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch");
    WalletLqtSaveFetchUI.G(this.HBI);
    this.Cmm.bMo();
    h.CyF.a(20287, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(214013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.38
 * JD-Core Version:    0.7.0.1
 */