package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;
import java.util.Iterator;

final class WalletLqtSaveFetchUI$9$1
  implements n.c
{
  WalletLqtSaveFetchUI$9$1(WalletLqtSaveFetchUI.9 param9) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(155075);
    Iterator localIterator = this.tSe.tSd.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paraml.add(0, i, 0, ((java.lang.String)localIterator.next()).split("\\|\\|")[0]);
      i += 1;
    }
    AppMethodBeat.o(155075);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.9.1
 * JD-Core Version:    0.7.0.1
 */