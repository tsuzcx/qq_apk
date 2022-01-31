package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AccelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.fts.widget.FTSMainUIEducationLayoutWithAll;

final class FTSSOSHomeWebViewUI$9
  implements ViewTreeObserver.OnPreDrawListener
{
  FTSSOSHomeWebViewUI$9(FTSSOSHomeWebViewUI paramFTSSOSHomeWebViewUI) {}
  
  public final boolean onPreDraw()
  {
    AppMethodBeat.i(153292);
    FTSSOSHomeWebViewUI.y(this.vkS).getViewTreeObserver().removeOnPreDrawListener(this);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.y(this.vkS), View.TRANSLATION_Y, new float[] { -FTSSOSHomeWebViewUI.y(this.vkS).getHeight(), 0.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(FTSSOSHomeWebViewUI.z(this.vkS), View.ALPHA, new float[] { 0.0F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setInterpolator(new AccelerateInterpolator());
    localAnimatorSet.setDuration(300L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
    localAnimatorSet.start();
    AppMethodBeat.o(153292);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSHomeWebViewUI.9
 * JD-Core Version:    0.7.0.1
 */