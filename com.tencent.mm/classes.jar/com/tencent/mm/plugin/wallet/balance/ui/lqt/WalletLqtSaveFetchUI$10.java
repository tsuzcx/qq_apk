package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import android.widget.ScrollView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.y;

final class WalletLqtSaveFetchUI$10
  implements Runnable
{
  WalletLqtSaveFetchUI$10(WalletLqtSaveFetchUI paramWalletLqtSaveFetchUI) {}
  
  public final void run()
  {
    int[] arrayOfInt1 = new int[2];
    int[] arrayOfInt2 = new int[2];
    this.qiZ.findViewById(a.f.lqt_divider_line_1).getLocationInWindow(arrayOfInt1);
    WalletLqtSaveFetchUI.q(this.qiZ).getLocationInWindow(arrayOfInt2);
    y.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", new Object[] { Integer.valueOf(arrayOfInt1[1] - arrayOfInt2[1]) });
    WalletLqtSaveFetchUI.q(this.qiZ).scrollBy(0, arrayOfInt1[1] - arrayOfInt2[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.10
 * JD-Core Version:    0.7.0.1
 */