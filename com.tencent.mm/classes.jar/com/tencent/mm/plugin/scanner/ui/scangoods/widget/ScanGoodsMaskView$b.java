package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.view.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanGoodsMaskView$b
  extends AnimatorListenerAdapter
{
  ScanGoodsMaskView$b(ScanGoodsMaskView paramScanGoodsMaskView) {}
  
  public final void onAnimationEnd(Animator paramAnimator)
  {
    AppMethodBeat.i(314617);
    super.onAnimationEnd(paramAnimator);
    ImageView localImageView = ScanGoodsMaskView.c(this.PeI);
    paramAnimator = localImageView;
    if (localImageView == null)
    {
      s.bIx("successDecorationView");
      paramAnimator = null;
    }
    paramAnimator = paramAnimator.animate();
    if (paramAnimator != null)
    {
      paramAnimator = paramAnimator.alpha(0.0F);
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.setDuration(200L);
        if (paramAnimator != null)
        {
          paramAnimator = paramAnimator.setInterpolator((TimeInterpolator)new LinearInterpolator());
          if (paramAnimator != null)
          {
            paramAnimator = paramAnimator.setListener((Animator.AnimatorListener)new a(this.PeI));
            if (paramAnimator != null)
            {
              paramAnimator = paramAnimator.setUpdateListener(null);
              if (paramAnimator != null) {
                paramAnimator.start();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(314617);
  }
  
  public final void onAnimationStart(Animator paramAnimator)
  {
    AppMethodBeat.i(314619);
    super.onAnimationStart(paramAnimator);
    ScanGoodsMaskView.d(this.PeI);
    AppMethodBeat.o(314619);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanGoodsMaskView$animateCustomSuccessView$2$onAnimationEnd$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(ScanGoodsMaskView paramScanGoodsMaskView) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314636);
      super.onAnimationEnd(paramAnimator);
      paramAnimator = ScanGoodsMaskView.d(this.PeI);
      if (paramAnimator != null) {
        paramAnimator.BY(false);
      }
      AppMethodBeat.o(314636);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView.b
 * JD-Core Version:    0.7.0.1
 */