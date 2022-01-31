package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.v7.app.ActionBar;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BaseScanUI$25
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseScanUI$25(BaseScanUI paramBaseScanUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(138484);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    BaseScanUI.m(this.qwI).setTranslationY(BaseScanUI.m(this.qwI).getHeight() * f);
    this.qwI.getSupportActionBar().getCustomView().setTranslationY(-f * this.qwI.getSupportActionBar().getHeight());
    AppMethodBeat.o(138484);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI.25
 * JD-Core Version:    0.7.0.1
 */