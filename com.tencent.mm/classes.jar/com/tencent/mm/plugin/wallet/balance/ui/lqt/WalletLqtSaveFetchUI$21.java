package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

final class WalletLqtSaveFetchUI$21
  implements Runnable
{
  WalletLqtSaveFetchUI$21(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI)
  {
    AppMethodBeat.i(160856);
    AppMethodBeat.o(160856);
  }
  
  public final void run()
  {
    AppMethodBeat.i(213993);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.HBI.findViewById(2131304001).getLocationInWindow(arrayOfInt1);
    WalletLqtSaveFetchUI.u(this.HBI).getLocationInWindow(arrayOfInt2);
    Log.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
    WalletLqtSaveFetchUI.u(this.HBI).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
    AppMethodBeat.o(213993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.21
 * JD-Core Version:    0.7.0.1
 */