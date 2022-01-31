package com.tencent.mm.plugin.offline.ui;

import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.d;
import java.util.List;

final class WalletOfflineCoinPurseUI$31
  implements n.d
{
  WalletOfflineCoinPurseUI$31(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, d paramd, List paramList) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(43541);
    if (this.gEx != null)
    {
      this.gEx.cre();
      paramMenuItem = (Bankcard)this.nIy.get(paramInt);
      h.qsU.e(14515, new Object[] { Integer.valueOf(3) });
      if ((!bo.isNullOrNil(paramMenuItem.field_forbid_title)) || (!bo.isNullOrNil(paramMenuItem.field_forbidWord)) || (!paramMenuItem.field_support_micropay)) {
        h.qsU.e(14515, new Object[] { Integer.valueOf(4) });
      }
      paramMenuItem = paramMenuItem.field_bindSerial;
      if ((!TextUtils.isEmpty(paramMenuItem)) && (!paramMenuItem.equals(WalletOfflineCoinPurseUI.G(this.pny))))
      {
        WalletOfflineCoinPurseUI.a(this.pny, paramMenuItem);
        a.Wr(WalletOfflineCoinPurseUI.G(this.pny));
        k.bYF();
        k.bYH().pjW = WalletOfflineCoinPurseUI.G(this.pny);
        this.pny.bZg();
        WalletOfflineCoinPurseUI.C(this.pny);
        WalletOfflineCoinPurseUI.D(this.pny);
      }
    }
    AppMethodBeat.o(43541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.31
 * JD-Core Version:    0.7.0.1
 */