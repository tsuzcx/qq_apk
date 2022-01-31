package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.c;

final class WalletOfflineCoinPurseUI$15
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$15(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43521);
    long l;
    if ((paramView.getId() == 2131829221) || (paramView.getId() == 2131829220) || (paramView.getId() == 2131829219))
    {
      if ((paramView.getId() == 2131829221) && (WalletOfflineCoinPurseUI.t(this.pny) != null) && (WalletOfflineCoinPurseUI.t(this.pny).isShowing()))
      {
        ab.i("MicroMsg.WalletOfflineCoinPurseUI", "offlineAlertView is showing");
        AppMethodBeat.o(43521);
        return;
      }
      l = System.currentTimeMillis();
      if (((WalletOfflineCoinPurseUI.t(this.pny) == null) || (!WalletOfflineCoinPurseUI.t(this.pny).isShowing())) && (l - WalletOfflineCoinPurseUI.u(this.pny) >= 400L) && (a.bZw()) && (!WalletOfflineCoinPurseUI.v(this.pny)))
      {
        if (paramView.getId() != 2131829221) {
          break label204;
        }
        WalletOfflineCoinPurseUI.a(this.pny, false);
      }
    }
    for (;;)
    {
      if (WalletOfflineCoinPurseUI.w(this.pny) != null)
      {
        WalletOfflineCoinPurseUI.x(this.pny);
        WalletOfflineCoinPurseUI.w(this.pny).H(paramView, WalletOfflineCoinPurseUI.y(this.pny));
      }
      WalletOfflineCoinPurseUI.a(this.pny, l);
      AppMethodBeat.o(43521);
      return;
      label204:
      if ((paramView.getId() == 2131829220) || (paramView.getId() == 2131829219))
      {
        h.qsU.e(13958, new Object[] { Integer.valueOf(4) });
        WalletOfflineCoinPurseUI.a(this.pny, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.15
 * JD-Core Version:    0.7.0.1
 */