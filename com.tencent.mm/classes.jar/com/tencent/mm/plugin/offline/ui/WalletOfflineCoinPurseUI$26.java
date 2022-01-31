package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletOfflineCoinPurseUI$26
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$26(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(43533);
    k.bYF();
    k.bYI();
    ab.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(i.bYE()) });
    k.bYF();
    k.bYI();
    if (i.bYE() <= 0)
    {
      paramView = new m((int)(System.currentTimeMillis() / 1000L), 10);
      this.pny.doSceneForceProgress(paramView);
      AppMethodBeat.o(43533);
      return;
    }
    WalletOfflineCoinPurseUI.J(this.pny);
    AppMethodBeat.o(43533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.26
 * JD-Core Version:    0.7.0.1
 */