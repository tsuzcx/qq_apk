package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import d.a.a.c;

final class WalletSuccPageAwardWidget$2
  implements WalletScratchShakeView.a
{
  WalletSuccPageAwardWidget$2(WalletSuccPageAwardWidget paramWalletSuccPageAwardWidget) {}
  
  public final void cWM()
  {
    AppMethodBeat.i(47942);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "onFinishScratchOrShake");
    if (WalletSuccPageAwardWidget.j(this.uxM).CLr != 0) {
      WalletSuccPageAwardWidget.cWX();
    }
    AppMethodBeat.o(47942);
  }
  
  public final void nW(boolean paramBoolean)
  {
    int i = 2;
    AppMethodBeat.i(47941);
    ab.i("MicroMsg.WalletSuccPageAwardWidget", "onStartScratchOrShake, isScratch: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.uxM;
    int j;
    if (paramBoolean)
    {
      j = 1;
      WalletSuccPageAwardWidget.a((WalletSuccPageAwardWidget)localObject, j, false);
      if (!paramBoolean) {
        break label113;
      }
      localObject = h.qsU;
      if (!WalletSuccPageAwardWidget.e(this.uxM)) {
        break label108;
      }
    }
    for (;;)
    {
      ((h)localObject).e(15225, new Object[] { Integer.valueOf(5), Integer.valueOf(i) });
      WalletSuccPageAwardWidget.f(this.uxM);
      AppMethodBeat.o(47941);
      return;
      j = 2;
      break;
      label108:
      i = 1;
    }
    label113:
    localObject = h.qsU;
    if (WalletSuccPageAwardWidget.e(this.uxM)) {}
    for (;;)
    {
      ((h)localObject).e(15225, new Object[] { Integer.valueOf(4), Integer.valueOf(i) });
      break;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.2
 * JD-Core Version:    0.7.0.1
 */