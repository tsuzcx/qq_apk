package com.tencent.mm.ui.chatting.gallery;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.MMGestureGallery;

final class TranslationResultUI$5
  implements ValueAnimator.AnimatorUpdateListener
{
  TranslationResultUI$5(TranslationResultUI paramTranslationResultUI) {}
  
  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(138649);
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = (FrameLayout.LayoutParams)TranslationResultUI.e(this.zOm).getLayoutParams();
    paramValueAnimator.leftMargin = ((int)(TranslationResultUI.i(this.zOm) * f));
    paramValueAnimator.topMargin = ((int)(TranslationResultUI.j(this.zOm) * f));
    paramValueAnimator.rightMargin = ((int)(TranslationResultUI.h(this.zOm).getWidth() * f - TranslationResultUI.k(this.zOm) * f - paramValueAnimator.leftMargin));
    paramValueAnimator.bottomMargin = ((int)(TranslationResultUI.h(this.zOm).getHeight() * f - TranslationResultUI.l(this.zOm) * f - paramValueAnimator.topMargin));
    TranslationResultUI.e(this.zOm).setLayoutParams(paramValueAnimator);
    TranslationResultUI.f(this.zOm).setTranslationX(TranslationResultUI.m(this.zOm) * (1.0F - f));
    TranslationResultUI.f(this.zOm).setTranslationY(TranslationResultUI.n(this.zOm) * (1.0F - f));
    TranslationResultUI.f(this.zOm).setScaleX((1.0F - f) * TranslationResultUI.o(this.zOm) + f);
    TranslationResultUI.f(this.zOm).setScaleY((1.0F - f) * TranslationResultUI.p(this.zOm) + f);
    TranslationResultUI.q(this.zOm).setAlpha(1.0F - f);
    AppMethodBeat.o(138649);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.TranslationResultUI.5
 * JD-Core Version:    0.7.0.1
 */