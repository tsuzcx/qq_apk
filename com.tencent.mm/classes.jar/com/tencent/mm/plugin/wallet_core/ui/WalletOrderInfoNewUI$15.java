package com.tencent.mm.plugin.wallet_core.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.y;

final class WalletOrderInfoNewUI$15
  implements Runnable
{
  WalletOrderInfoNewUI$15(WalletOrderInfoNewUI paramWalletOrderInfoNewUI) {}
  
  public final void run()
  {
    int m = WalletOrderInfoNewUI.e(this.qEr).getHeight();
    int n = this.qEr.findViewById(a.f.root_layout).getHeight();
    int j;
    label57:
    int k;
    if (WalletOrderInfoNewUI.f(this.qEr).getVisibility() == 0)
    {
      j = 1;
      if (WalletOrderInfoNewUI.g(this.qEr).getVisibility() != 0) {
        break label298;
      }
      i = 1;
      if (WalletOrderInfoNewUI.h(this.qEr).getVisibility() != 0) {
        break label303;
      }
      k = 1;
      label72:
      if (i == 0) {
        break label327;
      }
    }
    label298:
    label303:
    label327:
    for (int i = WalletOrderInfoNewUI.g(this.qEr).getBottom();; i = -1)
    {
      if (j != 0) {
        i = WalletOrderInfoNewUI.f(this.qEr).getBottom();
      }
      for (;;)
      {
        if (k != 0) {
          i = WalletOrderInfoNewUI.h(this.qEr).getBottom();
        }
        j = i;
        if (i <= 0) {
          j = this.qEr.findViewById(a.f.pay_info_layout).getBottom();
        }
        if ((WalletOrderInfoNewUI.i(this.qEr).getVisibility() != 0) && (WalletOrderInfoNewUI.c(this.qEr).getVisibility() != 0)) {}
        for (i = a.fromDPToPix(this.qEr, 70) + m;; i = m)
        {
          k = n - j - i;
          m = a.fromDPToPix(this.qEr, 50);
          y.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m) });
          ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)WalletOrderInfoNewUI.e(this.qEr).getLayoutParams();
          if (k > m) {}
          for (localMarginLayoutParams.topMargin = k;; localMarginLayoutParams.topMargin = m)
          {
            WalletOrderInfoNewUI.e(this.qEr).setLayoutParams(localMarginLayoutParams);
            WalletOrderInfoNewUI.e(this.qEr).setVisibility(0);
            return;
            j = 0;
            break;
            i = 0;
            break label57;
            k = 0;
            break label72;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletOrderInfoNewUI.15
 * JD-Core Version:    0.7.0.1
 */