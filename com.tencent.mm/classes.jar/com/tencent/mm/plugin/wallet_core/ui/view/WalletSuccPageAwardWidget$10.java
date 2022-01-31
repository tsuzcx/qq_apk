package com.tencent.mm.plugin.wallet_core.ui.view;

import b.a.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

final class WalletSuccPageAwardWidget$10
  implements WalletScratchShakeView.a
{
  WalletSuccPageAwardWidget$10(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void bXl()
  {
    y.i("MicroMsg.WalletSuccPageAwardWidget", "onFinishScratchOrShake");
    if (WalletSuccPageAwardWidget.j(this.qJe).xpp != 0) {
      WalletSuccPageAwardWidget.bXs();
    }
  }
  
  public final void kN(boolean paramBoolean)
  {
    int i = 2;
    y.i("MicroMsg.WalletSuccPageAwardWidget", "onStartScratchOrShake, isScratch: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.qJe;
    int j;
    if (paramBoolean)
    {
      j = 1;
      WalletSuccPageAwardWidget.a((WalletSuccPageAwardWidget)localObject, j, false);
      if (!paramBoolean) {
        break label103;
      }
      localObject = h.nFQ;
      if (!WalletSuccPageAwardWidget.e(this.qJe)) {
        break label98;
      }
    }
    for (;;)
    {
      ((h)localObject).f(15225, new Object[] { Integer.valueOf(5), Integer.valueOf(i) });
      WalletSuccPageAwardWidget.f(this.qJe);
      return;
      j = 2;
      break;
      label98:
      i = 1;
    }
    label103:
    localObject = h.nFQ;
    if (WalletSuccPageAwardWidget.e(this.qJe)) {}
    for (;;)
    {
      ((h)localObject).f(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
      break;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.10
 * JD-Core Version:    0.7.0.1
 */