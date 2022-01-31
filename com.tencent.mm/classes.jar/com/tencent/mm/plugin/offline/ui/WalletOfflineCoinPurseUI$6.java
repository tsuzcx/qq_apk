package com.tencent.mm.plugin.offline.ui;

import android.graphics.Point;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.af;

final class WalletOfflineCoinPurseUI$6
  implements Runnable
{
  WalletOfflineCoinPurseUI$6(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {}
  
  public final void run()
  {
    AppMethodBeat.i(43509);
    ScrollView localScrollView = (ScrollView)this.pny.findViewById(2131829239);
    if (localScrollView == null)
    {
      AppMethodBeat.o(43509);
      return;
    }
    int[] arrayOfInt = new int[2];
    localScrollView.getLocationInWindow(arrayOfInt);
    int i = af.hQ(this.pny.getContext()).y;
    int j = i;
    if (af.hO(this.pny.getContext()))
    {
      ab.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
      j = i - af.fx(this.pny.getContext());
    }
    if (this.pnz) {}
    for (i = arrayOfInt[1] + WalletOfflineCoinPurseUI.h(this.pny).getBottom();; i = 0)
    {
      if (this.pnA) {
        i = arrayOfInt[1] + WalletOfflineCoinPurseUI.i(this.pny).getBottom();
      }
      if (this.pnB) {
        i = arrayOfInt[1] + WalletOfflineCoinPurseUI.j(this.pny).getBottom();
      }
      if (this.pnC) {
        i = arrayOfInt[1] + WalletOfflineCoinPurseUI.k(this.pny).getBottom();
      }
      if (this.pnD) {
        i = arrayOfInt[1] + WalletOfflineCoinPurseUI.l(this.pny).getBottom();
      }
      ab.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      i -= j;
      if (i > 0) {
        localScrollView.scrollBy(0, i);
      }
      g.RL().Ru().set(ac.a.yIF, Boolean.TRUE);
      AppMethodBeat.o(43509);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.6
 * JD-Core Version:    0.7.0.1
 */