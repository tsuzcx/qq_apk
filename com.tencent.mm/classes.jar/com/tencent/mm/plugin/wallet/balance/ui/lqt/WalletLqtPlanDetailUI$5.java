package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import java.util.Iterator;
import java.util.List;

final class WalletLqtPlanDetailUI$5
  implements n.d
{
  WalletLqtPlanDetailUI$5(WalletLqtPlanDetailUI paramWalletLqtPlanDetailUI, List paramList) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(68907);
    Iterator localIterator = this.CCZ.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      switch (i)
      {
      default: 
        break;
      case 1: 
        paraml.jI(i, 2131765470);
        break;
      case 2: 
        paraml.c(i, this.CCW.getString(2131765471));
        break;
      case 3: 
        paraml.a(i, this.CCW.getContext().getResources().getColor(2131099803), this.CCW.getString(2131765468));
        break;
      case 4: 
        paraml.jI(i, 2131765469);
      }
    }
    AppMethodBeat.o(68907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.5
 * JD-Core Version:    0.7.0.1
 */