package com.tencent.mm.ui.widget.pulldown;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.b.a;
import androidx.core.g.z;
import com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/AppLayoutPullDownBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDirectionToEnd", "", "getMDirectionToEnd$annotations", "()V", "mDirectionToStart", "mMinFlingVelocity", "mOverScroller", "Landroid/widget/OverScroller;", "mSpringBackAnimator", "Landroid/animation/ValueAnimator;", "mSpringBackInterpolator", "Landroid/view/animation/Interpolator;", "computerOffset", "child", "Landroid/view/View;", "newOffset", "minOffset", "maxOffset", "computerWithDampingFactor", "distance", "getDampingFactor", "", "scrollDirection", "getMaxFlingOffset", "getMaxOffset", "getMinFlingVelocity", "getMinOffset", "getOffset", "layoutDependsOn", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "dependency", "onDependentViewChanged", "onLayoutChild", "layoutDirection", "onNestedFling", "coordinatorLayout", "target", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "", "dx", "dy", "", "type", "onNestedPreScrollInner", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "directTargetChild", "axes", "onNestedScrollInner", "distanceConsumed", "distanceUnconsumed", "onStartNestedScroll", "onStopNestedScroll", "scroll", "scrollWithoutDampingFactor", "setOffset", "offset", "springBack", "stopSpringBack", "Companion", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppLayoutPullDownBehavior
  extends AppBarLayout.ScrollingViewBehavior
{
  public static final AppLayoutPullDownBehavior.a aglv;
  private final Interpolator aglA;
  private OverScroller aglw;
  private int aglx;
  private int agly;
  private ValueAnimator aglz;
  private int wV;
  
  static
  {
    AppMethodBeat.i(252029);
    aglv = new AppLayoutPullDownBehavior.a((byte)0);
    AppMethodBeat.o(252029);
  }
  
  public AppLayoutPullDownBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251977);
    this.aglA = ((Interpolator)new DecelerateInterpolator(0.8F));
    AppMethodBeat.o(251977);
  }
  
  private static void P(View paramView, int paramInt)
  {
    AppMethodBeat.i(251992);
    s.u(paramView, "child");
    paramView.setTranslationY(paramInt);
    AppMethodBeat.o(251992);
  }
  
  private static final void a(AppLayoutPullDownBehavior paramAppLayoutPullDownBehavior, View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(252023);
    s.u(paramAppLayoutPullDownBehavior, "this$0");
    s.u(paramView, "$child");
    paramAppLayoutPullDownBehavior = paramValueAnimator.getAnimatedValue();
    if (paramAppLayoutPullDownBehavior == null)
    {
      paramAppLayoutPullDownBehavior = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(252023);
      throw paramAppLayoutPullDownBehavior;
    }
    P(paramView, ((Integer)paramAppLayoutPullDownBehavior).intValue());
    AppMethodBeat.o(252023);
  }
  
  private static int bs(View paramView, int paramInt)
  {
    AppMethodBeat.i(251995);
    s.u(paramView, "child");
    switch (paramInt)
    {
    default: 
      paramInt = -paramView.getHeight() / 3;
      AppMethodBeat.o(251995);
      return paramInt;
    }
    paramInt = paramView.getHeight() / 3;
    AppMethodBeat.o(251995);
    return paramInt;
  }
  
  private static int bt(View paramView, int paramInt)
  {
    AppMethodBeat.i(252008);
    float f = mn(paramView);
    if (f == 0.0F) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        f = 1.0F;
      }
      paramInt = (int)(paramInt / f + 0.5F);
      AppMethodBeat.o(252008);
      return paramInt;
    }
  }
  
  private static int cI(View paramView)
  {
    AppMethodBeat.i(251982);
    s.u(paramView, "child");
    int i = (int)paramView.getTranslationY();
    AppMethodBeat.o(251982);
    return i;
  }
  
  private static int cJ(View paramView)
  {
    AppMethodBeat.i(252015);
    s.u(paramView, "child");
    int i = paramView.getHeight();
    AppMethodBeat.o(252015);
    return i;
  }
  
  private static int f(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(251988);
    int k = cI(paramView);
    int j = 0;
    int i = j;
    if (k >= paramInt2)
    {
      i = j;
      if (k <= paramInt3)
      {
        paramInt1 = a.clamp(paramInt1, paramInt2, paramInt3);
        i = j;
        if (k != paramInt1)
        {
          P(paramView, paramInt1);
          i = k - paramInt1;
        }
      }
    }
    AppMethodBeat.o(251988);
    return i;
  }
  
  private final int g(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(252005);
    paramInt1 = f(paramView, cI(paramView) - bt(paramView, paramInt1), paramInt2, paramInt3);
    AppMethodBeat.o(252005);
    return paramInt1;
  }
  
  private int mm(View paramView)
  {
    AppMethodBeat.i(252001);
    s.u(paramView, "child");
    if (this.wV <= 0) {
      this.wV = (ViewConfiguration.get(paramView.getContext()).getScaledMinimumFlingVelocity() * 15);
    }
    int i = this.wV;
    AppMethodBeat.o(252001);
    return i;
  }
  
  private static float mn(View paramView)
  {
    AppMethodBeat.i(252012);
    s.u(paramView, "child");
    float f = Math.abs(cI(paramView)) * 1.0F / paramView.getHeight();
    AppMethodBeat.o(252012);
    return f * 4.0F + 1.0F;
  }
  
  private void mo(View paramView)
  {
    AppMethodBeat.i(252018);
    s.u(paramView, "child");
    int j = cI(paramView);
    if (j == 0)
    {
      AppMethodBeat.o(252018);
      return;
    }
    if (this.aglz == null)
    {
      this.aglz = ValueAnimator.ofInt(new int[0]);
      localValueAnimator = this.aglz;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener(new AppLayoutPullDownBehavior..ExternalSyntheticLambda0(this, paramView));
      }
    }
    ValueAnimator localValueAnimator = this.aglz;
    if ((localValueAnimator != null) && (localValueAnimator.isStarted() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(252018);
      return;
    }
    float f = Math.abs(j) * 1.0F / cJ(paramView);
    paramView = this.aglz;
    if (paramView != null) {
      paramView.setDuration(Math.max((int)(f * 300.0F), 150));
    }
    paramView = this.aglz;
    if (paramView != null) {
      paramView.setInterpolator((TimeInterpolator)this.aglA);
    }
    paramView = this.aglz;
    if (paramView != null) {
      paramView.setIntValues(new int[] { j, 0 });
    }
    paramView = this.aglz;
    if (paramView != null) {
      paramView.start();
    }
    AppMethodBeat.o(252018);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(252059);
    s.u(paramCoordinatorLayout, "coordinatorLayout");
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    new StringBuilder("onStopNestedScroll() called with:child = ").append(paramView1.getClass()).append(", target = ").append(paramView2).append(", type = ").append(paramInt);
    if (paramInt == 0)
    {
      if (cI((View)paramCoordinatorLayout) != 0)
      {
        paramView1 = this.aglw;
        if ((paramView1 == null) || (!paramView1.computeScrollOffset()))
        {
          mo((View)paramCoordinatorLayout);
          AppMethodBeat.o(252059);
        }
      }
    }
    else if (cI((View)paramCoordinatorLayout) != 0) {
      mo((View)paramCoordinatorLayout);
    }
    AppMethodBeat.o(252059);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(252051);
    s.u(paramCoordinatorLayout, "coordinatorLayout");
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    new StringBuilder("onNestedScroll() called with: child = ").append(paramView1.getClass().getName()).append(", target = ").append(paramView2.getClass().getName()).append(", dxConsumed = ").append(paramInt1).append(", dyConsumed = ").append(paramInt2).append(", dxUnconsumed = ").append(paramInt3).append(", dyUnconsumed = ").append(paramInt4).append(", type = ").append(paramInt5);
    if ((paramInt2 == 0) && (paramInt4 != 0))
    {
      s.u(paramCoordinatorLayout, "coordinatorLayout");
      s.u(paramView1, "child");
      s.u(paramView2, "target");
      new StringBuilder("onNestedScrollInner() called with, child = ").append(paramView1.getClass().getName()).append(", target = ").append(paramView2.getClass().getName()).append(", distanceConsumed = ").append(paramInt2).append(", distanceUnconsumed = ").append(paramInt4).append(", type = ").append(paramInt5);
      if (paramInt4 < 0)
      {
        if (paramInt5 == 0)
        {
          g((View)paramCoordinatorLayout, paramInt4, 0, cJ((View)paramCoordinatorLayout));
          AppMethodBeat.o(252051);
          return;
        }
        paramView1 = this.aglw;
        if ((paramView1 == null) || (!paramView1.computeScrollOffset()) || (Math.abs(paramView1.getCurrVelocity()) < Math.abs(mm((View)paramCoordinatorLayout))) || (cI((View)paramCoordinatorLayout) >= bs((View)paramCoordinatorLayout, this.aglx)))
        {
          z.at(paramView2);
          AppMethodBeat.o(252051);
          return;
        }
        g((View)paramCoordinatorLayout, paramInt4, cI((View)paramCoordinatorLayout), bs((View)paramCoordinatorLayout, this.aglx));
        AppMethodBeat.o(252051);
        return;
      }
      if (paramInt4 > 0)
      {
        if (paramInt5 == 0)
        {
          paramView1 = (View)paramCoordinatorLayout;
          paramCoordinatorLayout = (View)paramCoordinatorLayout;
          s.u(paramCoordinatorLayout, "child");
          g(paramView1, paramInt4, -paramCoordinatorLayout.getHeight(), 0);
          AppMethodBeat.o(252051);
          return;
        }
        paramView1 = this.aglw;
        if ((paramView1 == null) || (!paramView1.computeScrollOffset()) || (Math.abs(paramView1.getCurrVelocity()) < Math.abs(mm((View)paramCoordinatorLayout))) || (cI((View)paramCoordinatorLayout) <= bs((View)paramCoordinatorLayout, this.agly)))
        {
          z.at(paramView2);
          AppMethodBeat.o(252051);
          return;
        }
        g((View)paramCoordinatorLayout, paramInt4, bs((View)paramCoordinatorLayout, this.agly), cI((View)paramCoordinatorLayout));
      }
      AppMethodBeat.o(252051);
      return;
    }
    super.a(paramCoordinatorLayout, paramView1, paramView2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(252051);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(252040);
    s.u(paramCoordinatorLayout, "coordinatorLayout");
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    s.u(paramArrayOfInt, "consumed");
    s.u(paramCoordinatorLayout, "coordinatorLayout");
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    new StringBuilder("onNestedPreScrollInner() called with:  child = ").append(paramView1.getClass()).append(", target = ").append(paramView2.getClass()).append(", distance = ").append(paramInt2).append(", type = ").append(paramInt3);
    if (paramInt2 != 0) {
      if (paramInt2 < 0)
      {
        paramInt3 = cI((View)paramCoordinatorLayout);
        paramInt1 = 0;
        if (paramInt3 == paramInt1) {
          break label200;
        }
        paramCoordinatorLayout = (View)paramCoordinatorLayout;
      }
    }
    label200:
    for (paramInt1 = f(paramCoordinatorLayout, cI(paramCoordinatorLayout) - paramInt2, paramInt3, paramInt1);; paramInt1 = 0)
    {
      paramArrayOfInt[1] = paramInt1;
      s.X("onNestedPreScroll() comsumed[1]=", Integer.valueOf(paramArrayOfInt[1]));
      AppMethodBeat.o(252040);
      return;
      paramInt1 = cI((View)paramCoordinatorLayout);
      paramInt3 = 0;
      break;
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    AppMethodBeat.i(252077);
    s.u(paramCoordinatorLayout, "parent");
    s.u(paramView, "child");
    new StringBuilder("onLayoutChild() called with: parent = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView.getClass().getName()).append(", layoutDirection = ").append(Integer.TYPE.getName());
    boolean bool = super.a(paramCoordinatorLayout, paramView, paramInt);
    AppMethodBeat.o(252077);
    return bool;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    AppMethodBeat.i(252068);
    s.u(paramCoordinatorLayout, "parent");
    s.u(paramView1, "child");
    s.u(paramView2, "dependency");
    new StringBuilder("layoutDependsOn() called with: parent = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", dependency = ").append(paramView2.getClass().getName());
    boolean bool = super.a(paramCoordinatorLayout, paramView1, paramView2);
    AppMethodBeat.o(252068);
    return bool;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252085);
    s.u(paramCoordinatorLayout, "coordinatorLayout");
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    new StringBuilder("onNestedPreFling() called with: coordinatorLayout = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", target = ").append(paramView2.getClass().getName()).append(", velocityX = ").append(paramFloat1).append(", velocityY = ").append(paramFloat2);
    if (this.aglw == null) {
      this.aglw = new OverScroller(paramCoordinatorLayout.getContext());
    }
    paramCoordinatorLayout = this.aglw;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    }
    AppMethodBeat.o(252085);
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(252081);
    s.u(paramCoordinatorLayout, "coordinatorLayout");
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    new StringBuilder("onNestedFling() called with: coordinatorLayout = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", target = ").append(paramView2).append(", velocityX = ").append(paramFloat1).append(", velocityY = ").append(paramFloat2).append(", consumed = ").append(paramBoolean);
    paramBoolean = super.a(paramCoordinatorLayout, paramView1, paramView2, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(252081);
    return paramBoolean;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252055);
    s.u(paramCoordinatorLayout, "coordinatorLayout");
    s.u(paramView1, "child");
    s.u(paramView2, "directTargetChild");
    s.u(paramView3, "target");
    new StringBuilder("onStartNestedScroll() called with: coordinatorLayout = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", directTargetChild = ").append(paramView2.getClass().getName()).append(", target = ").append(paramView3.getClass().getName()).append(", axes = ").append(paramInt1).append(", type = ").append(paramInt2);
    if ((paramInt1 & 0x2) != 0)
    {
      AppMethodBeat.o(252055);
      return true;
    }
    AppMethodBeat.o(252055);
    return false;
  }
  
  public final void b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252064);
    s.u(paramCoordinatorLayout, "coordinatorLayout");
    s.u(paramView1, "child");
    s.u(paramView2, "directTargetChild");
    s.u(paramView3, "target");
    new StringBuilder("onNestedScrollAccepted() called with: coordinatorLayout = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", directTargetChild = ").append(paramView2).append(", target = ").append(paramView3.getClass().getName()).append(", axes = ").append(paramInt1).append(", type = ").append(paramInt2);
    if (paramInt2 == 0)
    {
      s.u(paramView1, "child");
      if (this.aglz != null)
      {
        paramCoordinatorLayout = this.aglz;
        s.checkNotNull(paramCoordinatorLayout);
        if (paramCoordinatorLayout.isRunning())
        {
          paramCoordinatorLayout = this.aglz;
          s.checkNotNull(paramCoordinatorLayout);
          paramCoordinatorLayout.cancel();
        }
      }
    }
    if (paramInt2 == 0)
    {
      paramCoordinatorLayout = this.aglw;
      if (paramCoordinatorLayout != null) {
        paramCoordinatorLayout.forceFinished(true);
      }
    }
    if ((paramInt1 & 0x2) != 0)
    {
      this.aglx = 2;
      this.agly = 1;
      AppMethodBeat.o(252064);
      return;
    }
    this.aglx = 8;
    this.agly = 4;
    AppMethodBeat.o(252064);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    AppMethodBeat.i(252073);
    s.u(paramCoordinatorLayout, "parent");
    s.u(paramView1, "child");
    s.u(paramView2, "dependency");
    new StringBuilder("onDependentViewChanged() called with: parent = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", dependency = ").append(paramView2.getClass().getName());
    boolean bool = super.b(paramCoordinatorLayout, paramView1, paramView2);
    AppMethodBeat.o(252073);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.AppLayoutPullDownBehavior
 * JD-Core Version:    0.7.0.1
 */