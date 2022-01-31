package com.tencent.mm.plugin.offline.ui;

import android.graphics.Point;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;

final class WalletOfflineCoinPurseUI$6
  implements Runnable
{
  WalletOfflineCoinPurseUI$6(WalletOfflineCoinPurseUI paramWalletOfflineCoinPurseUI, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5) {}
  
  public final void run()
  {
    ScrollView localScrollView = (ScrollView)this.mNj.findViewById(a.f.offline_root_layout);
    if (localScrollView == null) {
      return;
    }
    int[] arrayOfInt = new int[2];
    localScrollView.getLocationInWindow(arrayOfInt);
    int i = ak.gx(this.mNj.mController.uMN).y;
    int j = i;
    if (ak.gw(this.mNj.mController.uMN))
    {
      y.d("MicroMsg.WalletOfflineCoinPurseUI", "has navi");
      j = i - ak.gv(this.mNj.mController.uMN);
    }
    if (this.mNk) {}
    for (i = arrayOfInt[1] + WalletOfflineCoinPurseUI.h(this.mNj).getBottom();; i = 0)
    {
      if (this.mNl) {
        i = arrayOfInt[1] + WalletOfflineCoinPurseUI.i(this.mNj).getBottom();
      }
      if (this.mNm) {
        i = arrayOfInt[1] + WalletOfflineCoinPurseUI.j(this.mNj).getBottom();
      }
      if (this.mNn) {
        i = arrayOfInt[1] + WalletOfflineCoinPurseUI.k(this.mNj).getBottom();
      }
      if (this.mNo) {
        i = arrayOfInt[1] + WalletOfflineCoinPurseUI.l(this.mNj).getBottom();
      }
      y.d("MicroMsg.WalletOfflineCoinPurseUI", "f2f: %s, screen: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      i -= j;
      if (i > 0) {
        localScrollView.scrollBy(0, i);
      }
      g.DP().Dz().c(ac.a.uyv, Boolean.valueOf(true));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.offline.ui.WalletOfflineCoinPurseUI.6
 * JD-Core Version:    0.7.0.1
 */