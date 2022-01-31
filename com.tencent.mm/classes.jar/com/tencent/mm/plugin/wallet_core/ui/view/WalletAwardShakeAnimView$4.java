package com.tencent.mm.plugin.wallet_core.ui.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class WalletAwardShakeAnimView$4
  implements ValueAnimator.AnimatorUpdateListener
{
  WalletAwardShakeAnimView$4(WalletAwardShakeAnimView paramWalletAwardShakeAnimView) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    WalletAwardShakeAnimView.j(this.qIg).setRotation(((Float)paramValueAnimator.getAnimatedValue()).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.view.WalletAwardShakeAnimView.4
 * JD-Core Version:    0.7.0.1
 */