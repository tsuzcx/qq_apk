package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ay;

final class WalletAwardShakeAnimView$3
  implements View.OnClickListener
{
  WalletAwardShakeAnimView$3(WalletAwardShakeAnimView paramWalletAwardShakeAnimView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(47891);
    if (!WalletAwardShakeAnimView.e(this.uwO))
    {
      WalletAwardShakeAnimView.f(this.uwO);
      ay.ax(this.uwO.getContext(), 2131303636);
      WalletAwardShakeAnimView.h(this.uwO);
      if (WalletAwardShakeAnimView.i(this.uwO) != null) {
        WalletAwardShakeAnimView.i(this.uwO).nV(false);
      }
    }
    AppMethodBeat.o(47891);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.3
 * JD-Core Version:    0.7.0.1
 */