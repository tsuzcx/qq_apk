package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class WalletAwardShakeAnimView$2
  extends d.a
{
  WalletAwardShakeAnimView$2(WalletAwardShakeAnimView paramWalletAwardShakeAnimView) {}
  
  public final void onRelease() {}
  
  public final void onShake(boolean paramBoolean)
  {
    AppMethodBeat.i(142574);
    ab.i("MicroMsg.WalletAwardShakeAnimView", "onShake");
    long l = bo.av(WalletAwardShakeAnimView.b(this.uwO));
    if (!WalletAwardShakeAnimView.c(this.uwO))
    {
      if (l < 1200L) {
        AppMethodBeat.o(142574);
      }
    }
    else if (l < 80L)
    {
      AppMethodBeat.o(142574);
      return;
    }
    WalletAwardShakeAnimView.a(this.uwO, bo.yB());
    WalletAwardShakeAnimView.d(this.uwO);
    if (!WalletAwardShakeAnimView.e(this.uwO))
    {
      WalletAwardShakeAnimView.f(this.uwO);
      WalletAwardShakeAnimView.g(this.uwO);
    }
    AppMethodBeat.o(142574);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.2
 * JD-Core Version:    0.7.0.1
 */