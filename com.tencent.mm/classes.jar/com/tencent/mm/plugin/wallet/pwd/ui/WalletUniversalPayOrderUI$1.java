package com.tencent.mm.plugin.wallet.pwd.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.h;

final class WalletUniversalPayOrderUI$1
  implements DragSortListView.h
{
  WalletUniversalPayOrderUI$1(WalletUniversalPayOrderUI paramWalletUniversalPayOrderUI) {}
  
  public final void dp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46422);
    if (paramInt1 == paramInt2)
    {
      ab.d("MicroMsg.WalletUniversalPayOrderUI", "no change: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(46422);
      return;
    }
    WalletUniversalPayOrderUI.a(this.ubc, paramInt1, paramInt2);
    h.qsU.e(16343, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(46422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.pwd.ui.WalletUniversalPayOrderUI.1
 * JD-Core Version:    0.7.0.1
 */