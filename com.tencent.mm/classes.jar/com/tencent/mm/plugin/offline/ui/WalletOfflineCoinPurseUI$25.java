package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;

final class WalletOfflineCoinPurseUI$25
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$25(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43532);
    a.h(this.pny, WalletOfflineCoinPurseUI.c(this.pny));
    this.pny.finish();
    AppMethodBeat.o(43532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.25
 * JD-Core Version:    0.7.0.1
 */