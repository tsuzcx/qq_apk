package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.Iterator;
import java.util.List;

final class WalletLqtPlanDetailUI$5
  implements o.f
{
  WalletLqtPlanDetailUI$5(WalletLqtPlanDetailUI paramWalletLqtPlanDetailUI, List paramList) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(68907);
    Iterator localIterator = this.HzP.iterator();
    while (localIterator.hasNext())
    {
      int i = ((Integer)localIterator.next()).intValue();
      switch (i)
      {
      default: 
        break;
      case 1: 
        paramm.kV(i, 2131767919);
        break;
      case 2: 
        paramm.d(i, this.HzM.getString(2131767920));
        break;
      case 3: 
        paramm.a(i, this.HzM.getContext().getResources().getColor(2131099818), this.HzM.getString(2131767917));
        break;
      case 4: 
        paramm.kV(i, 2131767918);
      }
    }
    AppMethodBeat.o(68907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanDetailUI.5
 * JD-Core Version:    0.7.0.1
 */