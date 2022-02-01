package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.a.d;
import android.support.a.e;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper;", "", "()V", "TAG", "", "animateCustomSuccessView", "", "successView", "Landroid/view/View;", "animateDefaultSuccessView", "successMarkView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "animateScanTipsImage", "Landroid/support/animation/SpringAnimation;", "view", "doSpringAnimation", "plugin-scan_release"})
public final class h
{
  public static final h xhR;
  
  static
  {
    AppMethodBeat.i(199635);
    xhR = new h();
    AppMethodBeat.o(199635);
  }
  
  public static final void a(View paramView, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(199632);
    k.h(paramView, "successMarkView");
    paramView.setAlpha(0.0F);
    paramView.setScaleX(0.0F);
    paramView.setScaleY(0.0F);
    paramView.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new b(paramc)).setInterpolator((TimeInterpolator)new LinearInterpolator()).start();
    AppMethodBeat.o(199632);
  }
  
  public static final void et(View paramView)
  {
    AppMethodBeat.i(199633);
    k.h(paramView, "successView");
    paramView.setAlpha(1.0F);
    Object localObject1 = new d(paramView, (android.support.a.c)d.dR, (byte)0);
    Object localObject2 = ((d)localObject1).ar();
    k.g(localObject2, "animationX.spring");
    ((e)localObject2).h(200.0F);
    localObject2 = ((d)localObject1).ar();
    k.g(localObject2, "animationX.spring");
    ((e)localObject2).i(0.5F);
    ((d)localObject1).f(0.0F);
    localObject2 = new d(paramView, (android.support.a.c)d.dS, (byte)0);
    e locale = ((d)localObject2).ar();
    k.g(locale, "animationY.spring");
    locale.h(200.0F);
    locale = ((d)localObject2).ar();
    k.g(locale, "animationY.spring");
    locale.i(0.5F);
    ((d)localObject2).f(0.0F);
    ((d)localObject1).start();
    ((d)localObject2).start();
    localObject1 = ValueAnimator.ofFloat(new float[] { 15.0F, 0.0F });
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new h.a(paramView));
    ((ValueAnimator)localObject1).start();
    AppMethodBeat.o(199633);
  }
  
  public static final d eu(View paramView)
  {
    AppMethodBeat.i(199634);
    k.h(paramView, "view");
    paramView = new d(paramView, (android.support.a.c)d.dO);
    paramView.ap();
    e locale = new e(0.0F);
    locale.h(3000.0F);
    locale.i(0.05F);
    paramView.a(locale);
    paramView.f(-10.0F);
    paramView.start();
    AppMethodBeat.o(199634);
    return paramView;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateDefaultSuccessView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(com.tencent.mm.plugin.scanner.view.c paramc) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(199631);
      paramAnimator = this.xhT;
      if (paramAnimator != null)
      {
        paramAnimator.dAf();
        AppMethodBeat.o(199631);
        return;
      }
      AppMethodBeat.o(199631);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.h
 * JD-Core Version:    0.7.0.1
 */