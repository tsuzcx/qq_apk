package com.tencent.mm.ui.anim.content;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/anim/content/SizeAnimController;", "Lcom/tencent/mm/ui/anim/content/ISizeAnimController;", "attachView", "Landroid/view/View;", "(Landroid/view/View;)V", "getAttachView", "()Landroid/view/View;", "enableSizeAnim", "", "isLayoutByAnim", "mCurAnimHeight", "", "Ljava/lang/Integer;", "mIsDelayAnim", "mLastH", "mSizeAnimAnimator", "Landroid/animation/ValueAnimator;", "mSizeAnimListener", "Lcom/tencent/mm/ui/anim/content/ISizeAnimController$SizeAnimListener;", "targetValue", "cancel", "", "enable", "enabled", "handleAnim", "Lkotlin/Pair;", "startValue", "isSetAnimFlagAtStart", "animEndCallback", "Lkotlin/Function0;", "onLayoutAfter", "changed", "left", "top", "right", "bottom", "onMeasureAfter", "widthMeasureSpec", "heightMeasureSpec", "onMeasureBefore", "pause", "requestGone", "requestVisible", "resume", "setSizeAnimListener", "listener", "Companion", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements b
{
  public static final c.a adMv;
  final View App;
  private Integer adMA;
  private ValueAnimator adMB;
  public b.b adMC;
  private Integer adMD;
  boolean adMw;
  public boolean adMx;
  private boolean adMy;
  private int adMz;
  
  static
  {
    AppMethodBeat.i(251261);
    adMv = new c.a((byte)0);
    AppMethodBeat.o(251261);
  }
  
  public c(View paramView)
  {
    AppMethodBeat.i(251234);
    this.App = paramView;
    this.adMz = -1;
    AppMethodBeat.o(251234);
  }
  
  private final r<Integer, Integer> a(int paramInt1, int paramInt2, boolean paramBoolean, final a<ah> parama)
  {
    AppMethodBeat.i(251240);
    ValueAnimator localValueAnimator = this.adMB;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    if (paramBoolean) {
      this.adMy = true;
    }
    localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    int i = this.App.getMeasuredWidth();
    this.adMD = Integer.valueOf(paramInt2);
    localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(this));
    localValueAnimator.addListener((Animator.AnimatorListener)new c(this, parama));
    localValueAnimator.setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator());
    localValueAnimator.setDuration(200L);
    if (this.adMx) {}
    for (this.adMB = localValueAnimator;; this.adMB = localValueAnimator)
    {
      parama = new r(Integer.valueOf(i), Integer.valueOf(paramInt1));
      AppMethodBeat.o(251240);
      return parama;
      localValueAnimator.start();
    }
  }
  
  public final void Lw(boolean paramBoolean)
  {
    this.adMw = paramBoolean;
  }
  
  public final void a(b.b paramb)
  {
    this.adMC = paramb;
  }
  
  public final void cancel()
  {
    int i = 1;
    AppMethodBeat.i(251280);
    if (this.adMx)
    {
      AppMethodBeat.o(251280);
      return;
    }
    Object localObject = this.adMB;
    if ((localObject != null) && (((ValueAnimator)localObject).isRunning() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localObject = this.adMB;
        if (localObject != null) {
          ((ValueAnimator)localObject).cancel();
        }
        this.adMB = null;
        this.adMy = false;
        localObject = this.adMD;
        if (localObject != null) {
          this.adMz = ((Number)localObject).intValue();
        }
        this.App.requestLayout();
      }
      AppMethodBeat.o(251280);
      return;
      i = 0;
    }
  }
  
  public final r<Integer, Integer> jlB()
  {
    AppMethodBeat.i(251288);
    if (!this.adMw)
    {
      AppMethodBeat.o(251288);
      return null;
    }
    if ((this.adMw) && (this.adMA != null) && (this.adMy))
    {
      int i = this.App.getMeasuredWidth();
      Object localObject = this.adMA;
      s.checkNotNull(localObject);
      localObject = new r(Integer.valueOf(i), localObject);
      AppMethodBeat.o(251288);
      return localObject;
    }
    AppMethodBeat.o(251288);
    return null;
  }
  
  public final r<Integer, Integer> jlC()
  {
    AppMethodBeat.i(251291);
    if (!this.adMw)
    {
      AppMethodBeat.o(251291);
      return null;
    }
    this.App.getMeasuredWidth();
    int i = this.App.getMeasuredHeight();
    if ((this.adMz != -1) && (i != this.adMz))
    {
      localObject = a(this.adMz, i, false, null);
      AppMethodBeat.o(251291);
      return localObject;
    }
    Object localObject = this.adMB;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    this.adMB = null;
    AppMethodBeat.o(251291);
    return null;
  }
  
  public final void jlD()
  {
    AppMethodBeat.i(251297);
    if (this.App.getVisibility() == 8)
    {
      AppMethodBeat.o(251297);
      return;
    }
    a(this.adMz, 0, true, (a)new d(this));
    AppMethodBeat.o(251297);
  }
  
  public final void jlE()
  {
    AppMethodBeat.i(251301);
    if (this.App.getVisibility() == 0)
    {
      AppMethodBeat.o(251301);
      return;
    }
    this.App.setVisibility(0);
    this.App.requestLayout();
    AppMethodBeat.o(251301);
  }
  
  public final void ob(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251294);
    ValueAnimator localValueAnimator = this.adMB;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      this.adMy = true;
      AppMethodBeat.o(251294);
      return;
    }
    this.adMy = false;
    this.adMz = (paramInt2 - paramInt1);
    AppMethodBeat.o(251294);
  }
  
  public final void pause()
  {
    this.adMx = true;
  }
  
  public final void resume()
  {
    AppMethodBeat.i(251277);
    this.adMx = false;
    ValueAnimator localValueAnimator = this.adMB;
    if (localValueAnimator != null) {
      localValueAnimator.start();
    }
    this.adMB = null;
    AppMethodBeat.o(251277);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/anim/content/SizeAnimController$handleAnim$1", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "i", "", "getI", "()I", "setI", "(I)V", "onAnimationUpdate", "", "animation", "Landroid/animation/ValueAnimator;", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    private int i;
    
    b(c paramc) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(251227);
      s.u(paramValueAnimator, "animation");
      this.i += 1;
      c localc = this.adME;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(251227);
        throw paramValueAnimator;
      }
      c.a(localc, Integer.valueOf(((Integer)paramValueAnimator).intValue()));
      this.adME.App.requestLayout();
      AppMethodBeat.o(251227);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/anim/content/SizeAnimController$handleAnim$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "isReverse", "", "onAnimationStart", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(c paramc, a<ah> parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(251232);
      super.onAnimationCancel(paramAnimator);
      AppMethodBeat.o(251232);
    }
    
    public final void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(251226);
      s.u(paramAnimator, "animation");
      paramAnimator = c.a(this.adME);
      if (paramAnimator != null) {
        paramAnimator.cE(this.adME.hashCode(), false);
      }
      paramAnimator = parama;
      if (paramAnimator != null) {
        paramAnimator.invoke();
      }
      AppMethodBeat.o(251226);
    }
    
    public final void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
    {
      AppMethodBeat.i(251221);
      s.u(paramAnimator, "animation");
      paramAnimator = c.a(this.adME);
      if (paramAnimator != null) {
        paramAnimator.cE(this.adME.hashCode(), true);
      }
      AppMethodBeat.o(251221);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(c paramc)
    {
      super();
    }
    
    private static final void b(c paramc)
    {
      AppMethodBeat.i(251219);
      s.u(paramc, "this$0");
      paramc.App.setVisibility(8);
      AppMethodBeat.o(251219);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.anim.content.c
 * JD-Core Version:    0.7.0.1
 */