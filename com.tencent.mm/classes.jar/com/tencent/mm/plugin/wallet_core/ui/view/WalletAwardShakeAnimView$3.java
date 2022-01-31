package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.au;

final class WalletAwardShakeAnimView$3
  implements View.OnClickListener
{
  WalletAwardShakeAnimView$3(WalletAwardShakeAnimView paramWalletAwardShakeAnimView) {}
  
  public final void onClick(View paramView)
  {
    if (!WalletAwardShakeAnimView.e(this.qIg))
    {
      WalletAwardShakeAnimView.f(this.qIg);
      au.G(this.qIg.getContext(), a.i.shake_sound_male);
      WalletAwardShakeAnimView.h(this.qIg);
      if (WalletAwardShakeAnimView.i(this.qIg) != null) {
        WalletAwardShakeAnimView.i(this.qIg).kM(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.3
 * JD-Core Version:    0.7.0.1
 */