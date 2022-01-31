package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class WalletLqtSaveFetchUI$16
  implements Runnable
{
  WalletLqtSaveFetchUI$16(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(155089);
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.tRZ.findViewById(2131829206).getLocationInWindow(arrayOfInt1);
    WalletLqtSaveFetchUI.r(this.tRZ).getLocationInWindow(arrayOfInt2);
    ab.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
    WalletLqtSaveFetchUI.r(this.tRZ).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
    AppMethodBeat.o(155089);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.16
 * JD-Core Version:    0.7.0.1
 */