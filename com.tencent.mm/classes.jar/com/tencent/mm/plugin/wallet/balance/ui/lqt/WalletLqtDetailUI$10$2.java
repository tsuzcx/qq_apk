package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.protocal.protobuf.bpw;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;

final class WalletLqtDetailUI$10$2
  implements n.d
{
  WalletLqtDetailUI$10$2(WalletLqtDetailUI.10 param10) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(142293);
    if ((paramMenuItem.getItemId() == -1) && (!WalletLqtDetailUI.e(this.tPT.tPQ).xEa))
    {
      if (!bo.isNullOrNil(WalletLqtDetailUI.e(this.tPT.tPQ).xEf)) {
        paramMenuItem = WalletLqtDetailUI.e(this.tPT.tPQ).xEf;
      }
      for (;;)
      {
        h.a(this.tPT.tPQ, paramMenuItem, "", this.tPT.tPQ.getString(2131298417), new WalletLqtDetailUI.10.2.1(this));
        AppMethodBeat.o(142293);
        return;
        if (WalletLqtDetailUI.e(this.tPT.tPQ).wMx == 0) {
          paramMenuItem = this.tPT.tPQ.getString(2131305189);
        } else {
          paramMenuItem = this.tPT.tPQ.getString(2131305180);
        }
      }
    }
    if ((WalletLqtDetailUI.e(this.tPT.tPQ).xEn != null) && (WalletLqtDetailUI.e(this.tPT.tPQ).xEn.size() > 0) && (paramMenuItem.getItemId() < WalletLqtDetailUI.e(this.tPT.tPQ).xEn.size()))
    {
      paramMenuItem = (bfx)WalletLqtDetailUI.e(this.tPT.tPQ).xEn.get(paramMenuItem.getItemId());
      if (paramMenuItem.xuO != 1) {
        if (paramMenuItem.xuO == 2)
        {
          if (!bo.isNullOrNil(paramMenuItem.wPJ))
          {
            e.m(this.tPT.tPQ, paramMenuItem.wPJ, false);
            AppMethodBeat.o(142293);
          }
        }
        else if ((paramMenuItem.xuO == 3) && (!bo.isNullOrNil(paramMenuItem.wFW)) && (!bo.isNullOrNil(paramMenuItem.wPJ))) {
          e.q(paramMenuItem.wFW, paramMenuItem.wPJ, 0, 1061);
        }
      }
    }
    AppMethodBeat.o(142293);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtDetailUI.10.2
 * JD-Core Version:    0.7.0.1
 */