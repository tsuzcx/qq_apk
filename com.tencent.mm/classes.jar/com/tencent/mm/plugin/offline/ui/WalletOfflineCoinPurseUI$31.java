package com.tencent.mm.plugin.offline.ui;

import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d;
import java.util.List;

final class WalletOfflineCoinPurseUI$31
  implements n.d
{
  WalletOfflineCoinPurseUI$31(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, d paramd, List paramList) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (this.fnd != null)
    {
      this.fnd.bFp();
      paramMenuItem = (Bankcard)this.llc.get(paramInt);
      h.nFQ.f(14515, new Object[] { Integer.valueOf(3) });
      if ((!bk.bl(paramMenuItem.field_forbid_title)) || (!bk.bl(paramMenuItem.field_forbidWord)) || (!paramMenuItem.field_support_micropay)) {
        h.nFQ.f(14515, new Object[] { Integer.valueOf(4) });
      }
      paramMenuItem = paramMenuItem.field_bindSerial;
      if ((!TextUtils.isEmpty(paramMenuItem)) && (!paramMenuItem.equals(WalletOfflineCoinPurseUI.H(this.mNj))))
      {
        WalletOfflineCoinPurseUI.a(this.mNj, paramMenuItem);
        a.Kp(WalletOfflineCoinPurseUI.H(this.mNj));
        k.bpX();
        k.bpZ().mJH = WalletOfflineCoinPurseUI.H(this.mNj);
        this.mNj.bqx();
        WalletOfflineCoinPurseUI.D(this.mNj);
        WalletOfflineCoinPurseUI.E(this.mNj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.31
 * JD-Core Version:    0.7.0.1
 */