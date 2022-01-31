package com.tencent.mm.plugin.offline.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.offline.a.m;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

final class WalletOfflineCoinPurseUI$26
  implements View.OnClickListener
{
  WalletOfflineCoinPurseUI$26(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI) {}
  
  public final void onClick(View paramView)
  {
    k.bpX();
    k.bqa();
    y.i("MicroMsg.WalletOfflineCoinPurseUI", "do get token, %s", new Object[] { Integer.valueOf(i.bpW()) });
    k.bpX();
    k.bqa();
    if (i.bpW() <= 0)
    {
      paramView = new m((int)(System.currentTimeMillis() / 1000L), 10);
      this.mNj.a(paramView, true, false);
      return;
    }
    WalletOfflineCoinPurseUI.K(this.mNj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.26
 * JD-Core Version:    0.7.0.1
 */