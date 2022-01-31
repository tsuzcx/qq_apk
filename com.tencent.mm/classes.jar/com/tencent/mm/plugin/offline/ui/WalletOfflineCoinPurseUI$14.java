package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;

final class WalletOfflineCoinPurseUI$14
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$14(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43520);
    h.qsU.e(14515, new Object[] { Integer.valueOf(1) });
    WalletOfflineCoinPurseUI.s(this.pny);
    AppMethodBeat.o(43520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.14
 * JD-Core Version:    0.7.0.1
 */