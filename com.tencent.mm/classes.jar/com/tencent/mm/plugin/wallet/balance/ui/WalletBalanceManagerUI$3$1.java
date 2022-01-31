package com.tencent.mm.plugin.wallet.balance.ui;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class WalletBalanceManagerUI$3$1
  implements n.d
{
  WalletBalanceManagerUI$3$1(WalletBalanceManagerUI.3 param3) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(142280);
    if (paramInt < WalletBalanceManagerUI.e(this.tOL.tOJ).wnb.size())
    {
      paramMenuItem = (az)WalletBalanceManagerUI.e(this.tOL.tOJ).wnb.get(paramInt);
      if (paramMenuItem.wna != null)
      {
        if (paramMenuItem.wna.type == 1)
        {
          h.qsU.e(16503, new Object[] { Integer.valueOf(2), paramMenuItem.wna.url });
          AppMethodBeat.o(142280);
          return;
        }
        if (paramMenuItem.wna.type == 2)
        {
          h.qsU.e(16503, new Object[] { Integer.valueOf(3), paramMenuItem.wna.xJx.username });
          AppMethodBeat.o(142280);
          return;
        }
        if (paramMenuItem.wna.type == 5) {
          h.qsU.e(16503, new Object[] { Integer.valueOf(4), paramMenuItem.wna.url });
        }
      }
    }
    AppMethodBeat.o(142280);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceManagerUI.3.1
 * JD-Core Version:    0.7.0.1
 */