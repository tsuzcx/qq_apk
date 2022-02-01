package com.tencent.mm.ui.widget.pulldown;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.b.a;
import androidx.core.g.w;
import com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/AppLayoutPullDownBehavior;", "Lcom/google/android/material/appbar/AppBarLayout$ScrollingViewBehavior;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mDirectionToEnd", "", "mDirectionToEnd$annotations", "()V", "mDirectionToStart", "mMinFlingVelocity", "mOverScroller", "Landroid/widget/OverScroller;", "mSpringBackAnimator", "Landroid/animation/ValueAnimator;", "mSpringBackInterpolator", "Landroid/view/animation/Interpolator;", "computerOffset", "child", "Landroid/view/View;", "newOffset", "minOffset", "maxOffset", "computerWithDampingFactor", "distance", "getDampingFactor", "", "scrollDirection", "getMaxFlingOffset", "getMaxOffset", "getMinFlingVelocity", "getMinOffset", "getOffset", "layoutDependsOn", "", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "dependency", "onDependentViewChanged", "onLayoutChild", "layoutDirection", "onNestedFling", "coordinatorLayout", "target", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "", "dx", "dy", "", "type", "onNestedPreScrollInner", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "directTargetChild", "axes", "onNestedScrollInner", "distanceConsumed", "distanceUnconsumed", "onStartNestedScroll", "onStopNestedScroll", "scroll", "scrollWithoutDampingFactor", "setOffset", "offset", "springBack", "stopSpringBack", "Companion", "weui-native-android-lib_release"})
public final class AppLayoutPullDownBehavior
  extends AppBarLayout.ScrollingViewBehavior
{
  public static final AppLayoutPullDownBehavior.a Ytl;
  private OverScroller Ytg;
  private int Yth;
  private int Yti;
  private ValueAnimator Ytj;
  private final Interpolator Ytk;
  private int vZ;
  
  static
  {
    AppMethodBeat.i(252420);
    Ytl = new AppLayoutPullDownBehavior.a((byte)0);
    AppMethodBeat.o(252420);
  }
  
  public AppLayoutPullDownBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(252419);
    this.Ytk = ((Interpolator)new DecelerateInterpolator(0.8F));
    AppMethodBeat.o(252419);
  }
  
  public static void K(View paramView, int paramInt)
  {
    AppMethodBeat.i(252397);
    p.k(paramView, "child");
    paramView.setTranslationY(paramInt);
    AppMethodBeat.o(252397);
  }
  
  private static int aV(View paramView, int paramInt)
  {
    AppMethodBeat.i(252399);
    p.k(paramView, "child");
    if ((paramInt == 2) || (paramInt == 8))
    {
      paramInt = paramView.getHeight() / 3;
      AppMethodBeat.o(252399);
      return paramInt;
    }
    paramInt = -paramView.getHeight() / 3;
    AppMethodBeat.o(252399);
    return paramInt;
  }
  
  private static int aW(View paramView, int paramInt)
  {
    AppMethodBeat.i(252402);
    float f2 = iQ(paramView);
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    paramInt = (int)(paramInt / f1 + 0.5F);
    AppMethodBeat.o(252402);
    return paramInt;
  }
  
  private static int cm(View paramView)
  {
    AppMethodBeat.i(252394);
    p.k(paramView, "child");
    int i = (int)paramView.getTranslationY();
    AppMethodBeat.o(252394);
    return i;
  }
  
  private static int cn(View paramView)
  {
    AppMethodBeat.i(252404);
    p.k(paramView, "child");
    int i = paramView.getHeight();
    AppMethodBeat.o(252404);
    return i;
  }
  
  private static int g(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(252396);
    int k = cm(paramView);
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
          K(paramView, paramInt1);
          i = k - paramInt1;
        }
      }
    }
    AppMethodBeat.o(252396);
    return i;
  }
  
  private final int h(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(252401);
    paramInt1 = g(paramView, cm(paramView) - aW(paramView, paramInt1), paramInt2, paramInt3);
    AppMethodBeat.o(252401);
    return paramInt1;
  }
  
  private int iP(View paramView)
  {
    AppMethodBeat.i(252400);
    p.k(paramView, "child");
    if (this.vZ <= 0)
    {
      paramView = ViewConfiguration.get(paramView.getContext());
      p.j(paramView, "ViewConfiguration.get(child.context)");
      this.vZ = (paramView.getScaledMinimumFlingVelocity() * 15);
    }
    int i = this.vZ;
    AppMethodBeat.o(252400);
    return i;
  }
  
  private static float iQ(View paramView)
  {
    AppMethodBeat.i(252403);
    p.k(paramView, "child");
    float f = Math.abs(cm(paramView)) * 1.0F / paramView.getHeight();
    AppMethodBeat.o(252403);
    return f * 4.0F + 1.0F;
  }
  
  private void iR(View paramView)
  {
    AppMethodBeat.i(252409);
    p.k(paramView, "child");
    int i = cm(paramView);
    if (i == 0)
    {
      AppMethodBeat.o(252409);
      return;
    }
    if (this.Ytj == null)
    {
      this.Ytj = ValueAnimator.ofInt(new int[0]);
      localValueAnimator = this.Ytj;
      if (localValueAnimator != null) {
        localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new AppLayoutPullDownBehavior.b(this, paramView));
      }
    }
    ValueAnimator localValueAnimator = this.Ytj;
    if ((localValueAnimator != null) && (localValueAnimator.isStarted() == true))
    {
      AppMethodBeat.o(252409);
      return;
    }
    float f = Math.abs(i) * 1.0F / cn(paramView);
    paramView = this.Ytj;
    if (paramView != null) {
      paramView.setDuration(Math.max((int)(f * 300.0F), 150));
    }
    paramView = this.Ytj;
    if (paramView != null) {
      paramView.setInterpolator((TimeInterpolator)this.Ytk);
    }
    paramView = this.Ytj;
    if (paramView != null) {
      paramView.setIntValues(new int[] { i, 0 });
    }
    paramView = this.Ytj;
    if (paramView != null)
    {
      paramView.start();
      AppMethodBeat.o(252409);
      return;
    }
    AppMethodBeat.o(252409);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(252408);
    p.k(paramCoordinatorLayout, "coordinatorLayout");
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    new StringBuilder("onStopNestedScroll() called with:child = ").append(paramView1.getClass()).append(", target = ").append(paramView2).append(", type = ").append(paramInt);
    if (paramInt == 0)
    {
      if (cm((View)paramCoordinatorLayout) != 0)
      {
        paramView1 = this.Ytg;
        if ((paramView1 == null) || (!paramView1.computeScrollOffset()))
        {
          iR((View)paramCoordinatorLayout);
          AppMethodBeat.o(252408);
        }
      }
    }
    else if (cm((View)paramCoordinatorLayout) != 0) {
      iR((View)paramCoordinatorLayout);
    }
    AppMethodBeat.o(252408);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(252398);
    p.k(paramCoordinatorLayout, "coordinatorLayout");
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    new StringBuilder("onNestedScroll() called with: child = ").append(paramView1.getClass().getName()).append(", target = ").append(paramView2.getClass().getName()).append(", dxConsumed = ").append(paramInt1).append(", dyConsumed = ").append(paramInt2).append(", dxUnconsumed = ").append(paramInt3).append(", dyUnconsumed = ").append(paramInt4).append(", type = ").append(paramInt5);
    if ((paramInt2 == 0) && (paramInt4 != 0))
    {
      p.k(paramCoordinatorLayout, "coordinatorLayout");
      p.k(paramView1, "child");
      p.k(paramView2, "target");
      new StringBuilder("onNestedScrollInner() called with, child = ").append(paramView1.getClass().getName()).append(", target = ").append(paramView2.getClass().getName()).append(", distanceConsumed = ").append(paramInt2).append(", distanceUnconsumed = ").append(paramInt4).append(", type = ").append(paramInt5);
      if (paramInt4 < 0)
      {
        if (paramInt5 == 0)
        {
          h((View)paramCoordinatorLayout, paramInt4, 0, cn((View)paramCoordinatorLayout));
          AppMethodBeat.o(252398);
          return;
        }
        paramView1 = this.Ytg;
        if ((paramView1 == null) || (!paramView1.computeScrollOffset()) || (Math.abs(paramView1.getCurrVelocity()) < Math.abs(iP((View)paramCoordinatorLayout))) || (cm((View)paramCoordinatorLayout) >= aV((View)paramCoordinatorLayout, this.Yth)))
        {
          w.ag(paramView2);
          AppMethodBeat.o(252398);
          return;
        }
        h((View)paramCoordinatorLayout, paramInt4, cm((View)paramCoordinatorLayout), aV((View)paramCoordinatorLayout, this.Yth));
        AppMethodBeat.o(252398);
        return;
      }
      if (paramInt4 > 0)
      {
        if (paramInt5 == 0)
        {
          paramView1 = (View)paramCoordinatorLayout;
          paramCoordinatorLayout = (View)paramCoordinatorLayout;
          p.k(paramCoordinatorLayout, "child");
          h(paramView1, paramInt4, -paramCoordinatorLayout.getHeight(), 0);
          AppMethodBeat.o(252398);
          return;
        }
        paramView1 = this.Ytg;
        if ((paramView1 == null) || (!paramView1.computeScrollOffset()) || (Math.abs(paramView1.getCurrVelocity()) < Math.abs(iP((View)paramCoordinatorLayout))) || (cm((View)paramCoordinatorLayout) <= aV((View)paramCoordinatorLayout, this.Yti)))
        {
          w.ag(paramView2);
          AppMethodBeat.o(252398);
          return;
        }
        h((View)paramCoordinatorLayout, paramInt4, aV((View)paramCoordinatorLayout, this.Yti), cm((View)paramCoordinatorLayout));
      }
      AppMethodBeat.o(252398);
      return;
    }
    super.a(paramCoordinatorLayout, paramView1, paramView2, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5);
    AppMethodBeat.o(252398);
  }
  
  public final void a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(252393);
    p.k(paramCoordinatorLayout, "coordinatorLayout");
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    p.k(paramArrayOfInt, "consumed");
    p.k(paramCoordinatorLayout, "coordinatorLayout");
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    new StringBuilder("onNestedPreScrollInner() called with:  child = ").append(paramView1.getClass()).append(", target = ").append(paramView2.getClass()).append(", distance = ").append(paramInt2).append(", type = ").append(paramInt3);
    if (paramInt2 != 0) {
      if (paramInt2 < 0)
      {
        paramInt3 = cm((View)paramCoordinatorLayout);
        paramInt1 = 0;
        if (paramInt3 == paramInt1) {
          break label204;
        }
        paramCoordinatorLayout = (View)paramCoordinatorLayout;
      }
    }
    label204:
    for (paramInt1 = g(paramCoordinatorLayout, cm(paramCoordinatorLayout) - paramInt2, paramInt3, paramInt1);; paramInt1 = 0)
    {
      paramArrayOfInt[1] = paramInt1;
      new StringBuilder("onNestedPreScroll() comsumed[1]=").append(paramArrayOfInt[1]);
      AppMethodBeat.o(252393);
      return;
      paramInt1 = cm((View)paramCoordinatorLayout);
      paramInt3 = 0;
      break;
    }
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView, int paramInt)
  {
    AppMethodBeat.i(252414);
    p.k(paramCoordinatorLayout, "parent");
    p.k(paramView, "child");
    new StringBuilder("onLayoutChild() called with: parent = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView.getClass().getName()).append(", layoutDirection = ").append(Integer.TYPE.getName());
    boolean bool = super.a(paramCoordinatorLayout, paramView, paramInt);
    AppMethodBeat.o(252414);
    return bool;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    AppMethodBeat.i(252411);
    p.k(paramCoordinatorLayout, "parent");
    p.k(paramView1, "child");
    p.k(paramView2, "dependency");
    new StringBuilder("layoutDependsOn() called with: parent = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", dependency = ").append(paramView2.getClass().getName());
    boolean bool = super.a(paramCoordinatorLayout, paramView1, paramView2);
    AppMethodBeat.o(252411);
    return bool;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252417);
    p.k(paramCoordinatorLayout, "coordinatorLayout");
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    new StringBuilder("onNestedPreFling() called with: coordinatorLayout = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", target = ").append(paramView2.getClass().getName()).append(", velocityX = ").append(paramFloat1).append(", velocityY = ").append(paramFloat2);
    if (this.Ytg == null) {
      this.Ytg = new OverScroller(paramCoordinatorLayout.getContext());
    }
    paramCoordinatorLayout = this.Ytg;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    }
    AppMethodBeat.o(252417);
    return false;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(252415);
    p.k(paramCoordinatorLayout, "coordinatorLayout");
    p.k(paramView1, "child");
    p.k(paramView2, "target");
    new StringBuilder("onNestedFling() called with: coordinatorLayout = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", target = ").append(paramView2).append(", velocityX = ").append(paramFloat1).append(", velocityY = ").append(paramFloat2).append(", consumed = ").append(paramBoolean);
    paramBoolean = super.a(paramCoordinatorLayout, paramView1, paramView2, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(252415);
    return paramBoolean;
  }
  
  public final boolean a(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252406);
    p.k(paramCoordinatorLayout, "coordinatorLayout");
    p.k(paramView1, "child");
    p.k(paramView2, "directTargetChild");
    p.k(paramView3, "target");
    new StringBuilder("onStartNestedScroll() called with: coordinatorLayout = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", directTargetChild = ").append(paramView2.getClass().getName()).append(", target = ").append(paramView3.getClass().getName()).append(", axes = ").append(paramInt1).append(", type = ").append(paramInt2);
    if ((paramInt1 & 0x2) != 0)
    {
      AppMethodBeat.o(252406);
      return true;
    }
    AppMethodBeat.o(252406);
    return false;
  }
  
  public final void b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2, View paramView3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252410);
    p.k(paramCoordinatorLayout, "coordinatorLayout");
    p.k(paramView1, "child");
    p.k(paramView2, "directTargetChild");
    p.k(paramView3, "target");
    new StringBuilder("onNestedScrollAccepted() called with: coordinatorLayout = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", directTargetChild = ").append(paramView2).append(", target = ").append(paramView3.getClass().getName()).append(", axes = ").append(paramInt1).append(", type = ").append(paramInt2);
    if (paramInt2 == 0)
    {
      p.k(paramView1, "child");
      if (this.Ytj != null)
      {
        paramCoordinatorLayout = this.Ytj;
        if (paramCoordinatorLayout == null) {
          p.iCn();
        }
        if (paramCoordinatorLayout.isRunning())
        {
          paramCoordinatorLayout = this.Ytj;
          if (paramCoordinatorLayout == null) {
            p.iCn();
          }
          paramCoordinatorLayout.cancel();
        }
      }
    }
    if (paramInt2 == 0)
    {
      paramCoordinatorLayout = this.Ytg;
      if (paramCoordinatorLayout != null) {
        paramCoordinatorLayout.forceFinished(true);
      }
    }
    if ((paramInt1 & 0x2) != 0)
    {
      this.Yth = 2;
      this.Yti = 1;
      AppMethodBeat.o(252410);
      return;
    }
    this.Yth = 8;
    this.Yti = 4;
    AppMethodBeat.o(252410);
  }
  
  public final boolean b(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    AppMethodBeat.i(252412);
    p.k(paramCoordinatorLayout, "parent");
    p.k(paramView1, "child");
    p.k(paramView2, "dependency");
    new StringBuilder("onDependentViewChanged() called with: parent = ").append(paramCoordinatorLayout.getClass().getName()).append(", child = ").append(paramView1.getClass().getName()).append(", dependency = ").append(paramView2.getClass().getName());
    boolean bool = super.b(paramCoordinatorLayout, paramView1, paramView2);
    AppMethodBeat.o(252412);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.AppLayoutPullDownBehavior
 * JD-Core Version:    0.7.0.1
 */