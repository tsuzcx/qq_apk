package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.k;

final class WalletOfflineCoinPurseUI$19
  extends k
{
  WalletOfflineCoinPurseUI$19(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void dr(View paramView)
  {
    AppMethodBeat.i(269133);
    Log.i("MicroMsg.WalletOfflineCoinPurseUI", "click change_bankcard_layout() card：%s", new Object[] { WalletOfflineCoinPurseUI.d(this.MCi) });
    h.OAn.b(14515, new Object[] { Integer.valueOf(1) });
    WalletOfflineCoinPurseUI.s(this.MCi);
    WalletOfflineCoinPurseUI.t(this.MCi);
    AppMethodBeat.o(269133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.19
 * JD-Core Version:    0.7.0.1
 */