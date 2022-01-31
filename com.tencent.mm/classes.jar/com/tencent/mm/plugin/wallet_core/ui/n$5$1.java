package com.tencent.mm.plugin.wallet_core.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class n$5$1
  implements Animation.AnimationListener
{
  n$5$1(n.5 param5) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    y.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash end");
    ai.d(new n.5.1.2(this));
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    y.i("MicroMsg.WalletPwdCustomDialog", "hy: on flash start");
    ai.d(new n.5.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.n.5.1
 * JD-Core Version:    0.7.0.1
 */