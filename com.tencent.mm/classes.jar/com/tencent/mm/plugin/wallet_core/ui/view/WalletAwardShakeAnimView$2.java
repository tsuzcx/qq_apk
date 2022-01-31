package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.mm.pluginsdk.i.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class WalletAwardShakeAnimView$2
  extends c.a
{
  WalletAwardShakeAnimView$2(WalletAwardShakeAnimView paramWalletAwardShakeAnimView) {}
  
  public final void bnY()
  {
    y.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
    long l = bk.cp(WalletAwardShakeAnimView.b(this.qIg));
    if (!WalletAwardShakeAnimView.c(this.qIg)) {
      if (l >= 1200L) {
        break label45;
      }
    }
    label45:
    do
    {
      do
      {
        return;
      } while (l < 80L);
      WalletAwardShakeAnimView.a(this.qIg, bk.UZ());
      WalletAwardShakeAnimView.d(this.qIg);
    } while (WalletAwardShakeAnimView.e(this.qIg));
    WalletAwardShakeAnimView.f(this.qIg);
    WalletAwardShakeAnimView.g(this.qIg);
  }
  
  public final void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.2
 * JD-Core Version:    0.7.0.1
 */