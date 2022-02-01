package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.e.a.c;
import androidx.e.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper;", "", "()V", "TAG", "", "animateCustomSuccessView", "", "successView", "Landroid/view/View;", "animateDefaultSuccessView", "successMarkView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "animateScanTipsImage", "Landroidx/dynamicanimation/animation/SpringAnimation;", "view", "doSpringAnimation", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h Peb;
  
  static
  {
    AppMethodBeat.i(314634);
    Peb = new h();
    AppMethodBeat.o(314634);
  }
  
  public static final void a(View paramView, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(314620);
    s.u(paramView, "successMarkView");
    paramView.setAlpha(0.0F);
    paramView.setScaleX(0.0F);
    paramView.setScaleY(0.0F);
    paramView.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new a(paramd)).setInterpolator((TimeInterpolator)new LinearInterpolator()).start();
    AppMethodBeat.o(314620);
  }
  
  private static final void e(View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314632);
    s.u(paramView, "$successView");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314632);
      throw paramView;
    }
    paramView.setRotation(360.0F - Math.abs(((Float)paramValueAnimator).floatValue()));
    AppMethodBeat.o(314632);
  }
  
  public static final void iX(View paramView)
  {
    AppMethodBeat.i(314623);
    s.u(paramView, "successView");
    paramView.setAlpha(1.0F);
    Object localObject = new androidx.e.a.d(paramView, (c)androidx.e.a.d.bzc, (byte)0);
    ((androidx.e.a.d)localObject).bzy.aw(200.0F);
    ((androidx.e.a.d)localObject).bzy.ax(0.5F);
    ((androidx.e.a.d)localObject).at(0.0F);
    androidx.e.a.d locald = new androidx.e.a.d(paramView, (c)androidx.e.a.d.bzd, (byte)0);
    locald.bzy.aw(200.0F);
    locald.bzy.ax(0.5F);
    locald.at(0.0F);
    ((androidx.e.a.d)localObject).start();
    locald.start();
    localObject = ValueAnimator.ofFloat(new float[] { 15.0F, 0.0F });
    ((ValueAnimator)localObject).setDuration(300L);
    ((ValueAnimator)localObject).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ValueAnimator)localObject).addUpdateListener(new h..ExternalSyntheticLambda0(paramView));
    ((ValueAnimator)localObject).start();
    AppMethodBeat.o(314623);
  }
  
  public static final androidx.e.a.d iY(View paramView)
  {
    AppMethodBeat.i(314627);
    s.u(paramView, "view");
    paramView = new androidx.e.a.d(paramView, (c)androidx.e.a.d.byZ);
    paramView.bzn = 4000.0F;
    e locale = new e(0.0F);
    locale.aw(3000.0F);
    locale.ax(0.05F);
    ah localah = ah.aiuX;
    paramView.bzy = locale;
    paramView.at(-10.0F);
    paramView.start();
    AppMethodBeat.o(314627);
    return paramView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateDefaultSuccessView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends AnimatorListenerAdapter
  {
    a(com.tencent.mm.plugin.scanner.view.d paramd) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314602);
      paramAnimator = this.Pec;
      if (paramAnimator != null) {
        paramAnimator.BY(false);
      }
      AppMethodBeat.o(314602);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.h
 * JD-Core Version:    0.7.0.1
 */