package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.List;

final class WalletLqtPlanHomeUI$5
  implements n.c
{
  WalletLqtPlanHomeUI$5(WalletLqtPlanHomeUI paramWalletLqtPlanHomeUI, List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(45608);
    Iterator localIterator = this.tQX.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      switch (i)
      {
      default: 
        break;
      case 1: 
        paraml.hx(i, 2131305262);
        break;
      case 2: 
        paraml.e(i, this.tQV.getString(2131305263));
        break;
      case 3: 
        paraml.hx(i, 2131305260);
        break;
      case 4: 
        paraml.hx(i, 2131305261);
      }
    }
    AppMethodBeat.o(45608);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI.5
 * JD-Core Version:    0.7.0.1
 */