package com.tencent.mm.plugin.scanner.ui.scangoods.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import androidx.d.a.c;
import androidx.d.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper;", "", "()V", "TAG", "", "animateCustomSuccessView", "", "successView", "Landroid/view/View;", "animateDefaultSuccessView", "successMarkView", "successAnimationListener", "Lcom/tencent/mm/plugin/scanner/view/ScanResultAnimationListener;", "animateScanTipsImage", "Landroidx/dynamicanimation/animation/SpringAnimation;", "view", "doSpringAnimation", "plugin-scan_release"})
public final class h
{
  public static final h IVm;
  
  static
  {
    AppMethodBeat.i(217228);
    IVm = new h();
    AppMethodBeat.o(217228);
  }
  
  public static final void a(View paramView, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(217225);
    p.k(paramView, "successMarkView");
    paramView.setAlpha(0.0F);
    paramView.setScaleX(0.0F);
    paramView.setScaleY(0.0F);
    paramView.animate().alpha(1.0F).scaleX(1.0F).scaleY(1.0F).setDuration(300L).setListener((Animator.AnimatorListener)new b(paramd)).setInterpolator((TimeInterpolator)new LinearInterpolator()).start();
    AppMethodBeat.o(217225);
  }
  
  public static final void fW(View paramView)
  {
    AppMethodBeat.i(217226);
    p.k(paramView, "successView");
    paramView.setAlpha(1.0F);
    Object localObject1 = new androidx.d.a.d(paramView, (c)androidx.d.a.d.SM, (byte)0);
    Object localObject2 = ((androidx.d.a.d)localObject1).hZ();
    p.j(localObject2, "animationX.spring");
    ((e)localObject2).p(200.0F);
    localObject2 = ((androidx.d.a.d)localObject1).hZ();
    p.j(localObject2, "animationX.spring");
    ((e)localObject2).q(0.5F);
    ((androidx.d.a.d)localObject1).n(0.0F);
    localObject2 = new androidx.d.a.d(paramView, (c)androidx.d.a.d.SN, (byte)0);
    e locale = ((androidx.d.a.d)localObject2).hZ();
    p.j(locale, "animationY.spring");
    locale.p(200.0F);
    locale = ((androidx.d.a.d)localObject2).hZ();
    p.j(locale, "animationY.spring");
    locale.q(0.5F);
    ((androidx.d.a.d)localObject2).n(0.0F);
    ((androidx.d.a.d)localObject1).start();
    ((androidx.d.a.d)localObject2).start();
    localObject1 = ValueAnimator.ofFloat(new float[] { 15.0F, 0.0F });
    ((ValueAnimator)localObject1).setDuration(300L);
    ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)new LinearInterpolator());
    ((ValueAnimator)localObject1).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(paramView));
    ((ValueAnimator)localObject1).start();
    AppMethodBeat.o(217226);
  }
  
  public static final androidx.d.a.d fX(View paramView)
  {
    AppMethodBeat.i(217227);
    p.k(paramView, "view");
    paramView = new androidx.d.a.d(paramView, (c)androidx.d.a.d.SJ);
    paramView.hW();
    e locale = new e(0.0F);
    locale.p(3000.0F);
    locale.q(0.05F);
    paramView.a(locale);
    paramView.n(-10.0F);
    paramView.start();
    AppMethodBeat.o(217227);
    return paramView;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateCustomSuccessView$1$1"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(221491);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(221491);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.IVn.setRotation(360.0F - Math.abs(f));
      AppMethodBeat.o(221491);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/scangoods/widget/ScanAnimationHelper$animateDefaultSuccessView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "plugin-scan_release"})
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(com.tencent.mm.plugin.scanner.view.d paramd) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(222218);
      paramAnimator = this.IVo;
      if (paramAnimator != null)
      {
        paramAnimator.xs(false);
        AppMethodBeat.o(222218);
        return;
      }
      AppMethodBeat.o(222218);
    }
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.scangoods.widget.h
 * JD-Core Version:    0.7.0.1
 */