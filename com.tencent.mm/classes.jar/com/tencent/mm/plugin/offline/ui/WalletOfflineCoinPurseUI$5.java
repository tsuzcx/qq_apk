package com.tencent.mm.plugin.offline.ui;

import android.widget.TextView;
import com.tencent.mm.h.a.ti;
import com.tencent.mm.h.a.ti.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.e;

final class WalletOfflineCoinPurseUI$5
  implements Runnable
{
  WalletOfflineCoinPurseUI$5(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, ti paramti) {}
  
  public final void run()
  {
    if (!bk.bl(this.iLQ.ccV.ccW))
    {
      e.a((TextView)this.mNj.findViewById(a.f.banner_tips), this.iLQ.ccV.ccW, this.iLQ.ccV.content, this.iLQ.ccV.url);
      return;
    }
    y.i("MicroMsg.WalletOfflineCoinPurseUI", "no bulletin data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.5
 * JD-Core Version:    0.7.0.1
 */