package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.a.c;
import android.support.a.e;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper;", "", "()V", "TAG", "", "animateCustomSuccessView", "", "successView", "Landroid/view/View;", "animateDefaultSuccessView", "successMarkView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "animateScanTipsImage", "Landroid/support/animation/SpringAnimation;", "view", "doSpringAnimation", "plugin-scan_release"})
public final class h
{
  public static final h CPK;
  
  static
  {
    AppMethodBeat.i(240596);
    CPK = new h();
    AppMethodBeat.o(240596);
  }
  
  public static final void a(View paramView, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(240593);
    p.h(paramView, "successMarkView");
    paramView.setAlpha(0.0F);
    paramView.setScaleX(0.0F);
    paramView.setScaleY(0.0F);
    paramView.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new b(paramd)).setInterpolator((TimeInterpolator)new LinearInterpolator()).start();
    AppMethodBeat.o(240593);
  }
  
  public static final void eS(View paramView)
  {
    AppMethodBeat.i(240594);
    p.h(paramView, "successView");
    paramView.setAlpha(1.0F);
    Object localObject1 = new android.support.a.d(paramView, (c)android.support.a.d.fN, (byte)0);
    Object localObject2 = ((android.support.a.d)localObject1).aJ();
    p.g(localObject2, "animationX.spring");
    ((e)localObject2).g(200.0F);
    localObject2 = ((android.support.a.d)localObject1).aJ();
    p.g(localObject2, "animationX.spring");
    ((e)localObject2).h(0.5F);
    ((android.support.a.d)localObject1).e(0.0F);
    localObject2 = new android.support.a.d(paramView, (c)android.support.a.d.fO, (byte)0);
    e locale = ((android.support.a.d)localObject2).aJ();
    p.g(locale, "animationY.spring");
    locale.g(200.0F);
    locale = ((android.support.a.d)localObject2).aJ();
    p.g(locale, "animationY.spring");
    locale.h(0.5F);
    ((android.support.a.d)localObject2).e(0.0F);
    ((android.support.a.d)localObject1).start();
    ((android.support.a.d)localObject2).start();
    localObject1 = ValueAnimator.ofFloat(new float[] { 15.0F, 0.0F });
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new h.a(paramView));
    ((ValueAnimator)localObject1).start();
    AppMethodBeat.o(240594);
  }
  
  public static final android.support.a.d eT(View paramView)
  {
    AppMethodBeat.i(240595);
    p.h(paramView, "view");
    paramView = new android.support.a.d(paramView, (c)android.support.a.d.fK);
    paramView.aH();
    e locale = new e(0.0F);
    locale.g(3000.0F);
    locale.h(0.05F);
    paramView.a(locale);
    paramView.e(-10.0F);
    paramView.start();
    AppMethodBeat.o(240595);
    return paramView;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateDefaultSuccessView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(com.tencent.mm.plugin.scanner.view.d paramd) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(240592);
      paramAnimator = this.CPM;
      if (paramAnimator != null)
      {
        paramAnimator.eQG();
        AppMethodBeat.o(240592);
        return;
      }
      AppMethodBeat.o(240592);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.h
 * JD-Core Version:    0.7.0.1
 */