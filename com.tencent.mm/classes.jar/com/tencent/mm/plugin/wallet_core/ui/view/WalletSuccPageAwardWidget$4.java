package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Color;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;

final class WalletSuccPageAwardWidget$4
  implements WalletAwardShakeAnimView.a
{
  WalletSuccPageAwardWidget$4(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void kM(boolean paramBoolean)
  {
    y.i("MicroMsg.WalletSuccPageAwardWidget", "onStartShakeOrClick, isShake: %s, isClickH5OrTinyApp: %s", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(WalletSuccPageAwardWidget.e(this.qJe)) });
    if (paramBoolean)
    {
      localh = h.nFQ;
      if (WalletSuccPageAwardWidget.e(this.qJe)) {}
      for (i = 2;; i = 1)
      {
        localh.f(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
        WalletSuccPageAwardWidget.d(this.qJe).setShakeHintWording(this.qJe.getContext().getString(a.i.wallet_shake_award_shaking_wording));
        WalletSuccPageAwardWidget.d(this.qJe).setShakeHintWordingColor(Color.parseColor("#9C9C9C"));
        WalletSuccPageAwardWidget.a(this.qJe, 2, false);
        WalletSuccPageAwardWidget.f(this.qJe);
        return;
      }
    }
    h localh = h.nFQ;
    if (WalletSuccPageAwardWidget.e(this.qJe)) {}
    for (int i = 2;; i = 1)
    {
      localh.f(15225, new Object[] { Integer.valueOf(7), Integer.valueOf(i) });
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.4
 * JD-Core Version:    0.7.0.1
 */