package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.ArrayList;
import java.util.Iterator;

final class WalletLqtSaveFetchUI$5$1
  implements n.c
{
  WalletLqtSaveFetchUI$5$1(WalletLqtSaveFetchUI.5 param5) {}
  
  public final void a(l paraml)
  {
    Iterator localIterator = this.qjb.qja.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      paraml.add(0, i, 0, ((java.lang.String)localIterator.next()).split("\\|\\|")[0]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.5.1
 * JD-Core Version:    0.7.0.1
 */