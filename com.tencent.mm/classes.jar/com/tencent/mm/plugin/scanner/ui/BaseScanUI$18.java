package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.view.View;

final class BaseScanUI$18
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseScanUI$18(BaseScanUI paramBaseScanUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    BaseScanUI.m(this.nJg).setTranslationY(BaseScanUI.m(this.nJg).getHeight() * f);
    this.nJg.getSupportActionBar().getCustomView().setTranslationY(-f * this.nJg.getSupportActionBar().getHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.18
 * JD-Core Version:    0.7.0.1
 */