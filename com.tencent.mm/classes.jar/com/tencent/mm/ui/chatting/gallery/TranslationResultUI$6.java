package com.tencent.mm.ui.chatting.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.MultiTouchImageView;

final class TranslationResultUI$6
  extends AnimatorListenerAdapter
{
  TranslationResultUI$6(TranslationResultUI paramTranslationResultUI) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(138651);
    super.onAnimationEnd(paramAnimator);
    this.zOm.finish();
    this.zOm.overridePendingTransition(2131034130, 2131034130);
    AppMethodBeat.o(138651);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(138650);
    super.onAnimationStart(paramAnimator);
    if (TranslationResultUI.f(this.zOm).getScale() > 1.0F) {
      TranslationResultUI.f(this.zOm).dDJ();
    }
    TranslationResultUI.a(this.zOm, TranslationResultUI.f(this.zOm).getTranslationX());
    TranslationResultUI.b(this.zOm, TranslationResultUI.f(this.zOm).getTranslationY());
    TranslationResultUI.c(this.zOm, TranslationResultUI.f(this.zOm).getScaleX());
    TranslationResultUI.d(this.zOm, TranslationResultUI.f(this.zOm).getScaleY());
    AppMethodBeat.o(138650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.TranslationResultUI.6
 * JD-Core Version:    0.7.0.1
 */