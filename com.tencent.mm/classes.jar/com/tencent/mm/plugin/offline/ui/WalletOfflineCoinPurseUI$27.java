package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;

final class WalletOfflineCoinPurseUI$27
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$27(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43534);
    a.bZH();
    a.i(this.pny, WalletOfflineCoinPurseUI.c(this.pny));
    this.pny.finish();
    AppMethodBeat.o(43534);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.27
 * JD-Core Version:    0.7.0.1
 */