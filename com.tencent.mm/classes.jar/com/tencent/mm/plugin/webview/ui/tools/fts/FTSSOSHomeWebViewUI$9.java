package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll;

final class FTSSOSHomeWebViewUI$9
  implements ViewTreeObserver.OnPreDrawListener
{
  FTSSOSHomeWebViewUI$9(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final boolean onPreDraw()
  {
    FTSSOSHomeWebViewUI.C(this.ruD).getViewTreeObserver().removeOnPreDrawListener(this);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.C(this.ruD), View.TRANSLATION_Y, new float[] { -FTSSOSHomeWebViewUI.C(this.ruD).getHeight(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.D(this.ruD), View.ALPHA, new float[] { 0.0F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setInterpolator(new AccelerateInterpolator());
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
    localAnimatorSet.start();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.9
 * JD-Core Version:    0.7.0.1
 */