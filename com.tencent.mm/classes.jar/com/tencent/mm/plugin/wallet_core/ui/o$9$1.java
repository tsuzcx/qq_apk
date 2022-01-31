package com.tencent.mm.plugin.wallet_core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class o$9$1
  implements Animation.AnimationListener
{
  o$9$1(o.9 param9) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    y.i("MicroMsg.WalletPwdDialog", "hy: on flash end");
    ai.d(new o.9.1.2(this));
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.i("MicroMsg.WalletPwdDialog", "hy: on flash start");
    ai.d(new o.9.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.o.9.1
 * JD-Core Version:    0.7.0.1
 */