package com.tencent.mm.ui.f;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.ah.e;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/dialog/HalfScreenDialogDragHelper;", "", "halfScreenWebView", "Ljava/lang/ref/WeakReference;", "Landroidx/appcompat/app/AppCompatDialog;", "(Ljava/lang/ref/WeakReference;)V", "currentTranslationY", "", "getCurrentTranslationY", "()F", "setCurrentTranslationY", "(F)V", "downY", "getDownY", "setDownY", "getHalfScreenWebView", "()Ljava/lang/ref/WeakReference;", "moveY", "getMoveY", "setMoveY", "animateDialogVerticalTranslation", "", "toDragView", "Landroid/view/View;", "fromTranslationY", "targetTranslationY", "duration", "", "initDragView", "view", "finishHeight", "", "alpha", "toDispatchView", "onTouchUp", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a afuN;
  private final WeakReference<e> Xpn;
  float afuO;
  private float fig;
  private float ree;
  
  static
  {
    AppMethodBeat.i(250731);
    afuN = new b.a((byte)0);
    AppMethodBeat.o(250731);
  }
  
  public b(WeakReference<e> paramWeakReference)
  {
    AppMethodBeat.i(250714);
    this.Xpn = paramWeakReference;
    AppMethodBeat.o(250714);
  }
  
  private static final boolean a(View paramView1, b paramb, ah.e parame, float paramFloat, View paramView2, View paramView3, int paramInt, View paramView4, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(250725);
    s.u(paramb, "this$0");
    s.u(parame, "$downTime");
    if (paramView1 != null) {
      paramView1.dispatchTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
      AppMethodBeat.o(250725);
      return true;
    case 0: 
      paramb.fig = paramMotionEvent.getRawY();
      parame.aixc = System.currentTimeMillis();
      if (paramFloat == 1.0F) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        paramView2.setAlpha(paramFloat);
        break;
      }
    case 2: 
      if (paramb.ree == 0.0F)
      {
        paramInt = 1;
        label124:
        if (paramInt != 0)
        {
          parame.aixc = System.currentTimeMillis();
          paramb.ree = paramMotionEvent.getRawY();
        }
        paramb.ree = paramMotionEvent.getRawY();
        paramFloat = k.bt(paramb.ree - paramb.fig + paramb.afuO, 0.0F);
        if (paramFloat != paramb.afuO) {
          break label226;
        }
      }
      label226:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0)
        {
          paramb.afuO = paramFloat;
          if (paramView3 != null) {
            paramView3.setTranslationY(paramb.afuO);
          }
        }
        paramb.fig = paramb.ree;
        break;
        paramInt = 0;
        break label124;
      }
    }
    if (System.currentTimeMillis() - parame.aixc < 350L) {
      paramView2.performClick();
    }
    if (paramView3 != null)
    {
      if (paramb.afuO <= paramInt) {
        break label302;
      }
      paramView1 = (e)paramb.Xpn.get();
      if (paramView1 != null) {
        paramView1.cancel();
      }
    }
    for (;;)
    {
      paramb.fig = 0.0F;
      paramView2.setAlpha(1.0F);
      break;
      label302:
      if (paramb.afuO == 0.0F)
      {
        paramInt = 1;
        label314:
        if (paramInt != 0) {
          break label377;
        }
        paramFloat = paramb.afuO;
        Log.v("MicroMsg.HalfScreenDialogDragHelper", "animateDialogVerticalTranslation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat), Float.valueOf(0.0F) });
        if (paramFloat != 0.0F) {
          break label379;
        }
      }
      label377:
      label379:
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt == 0) {
          break label385;
        }
        Log.w("MicroMsg.HalfScreenDialogDragHelper", "animateDialogVerticalTranslation start equals end and ignore");
        break;
        paramInt = 0;
        break label314;
        break;
      }
      label385:
      paramView1 = ValueAnimator.ofFloat(new float[] { paramFloat, 0.0F });
      paramView1.setInterpolator((TimeInterpolator)new DecelerateInterpolator());
      paramView1.setDuration(350L);
      paramView1.addUpdateListener(new b..ExternalSyntheticLambda0(paramView3));
      paramView1.addListener((Animator.AnimatorListener)new b(paramb));
      paramView1.start();
    }
  }
  
  private static final void g(View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(250728);
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(250728);
      throw paramView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    if (paramView != null) {
      paramView.setTranslationY(f);
    }
    AppMethodBeat.o(250728);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/dialog/HalfScreenDialogDragHelper$animateDialogVerticalTranslation$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    b(b paramb) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      this.afuP.afuO = this.afuQ;
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.f.b
 * JD-Core Version:    0.7.0.1
 */