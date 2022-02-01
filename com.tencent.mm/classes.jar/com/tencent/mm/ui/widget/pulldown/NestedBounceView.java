package com.tencent.mm.ui.widget.pulldown;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.b.a;
import androidx.core.g.p;
import androidx.core.g.r;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.k;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceCommon;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScrollCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "customNestedChild", "Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "getCustomNestedChild", "()Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;", "setCustomNestedChild", "(Lcom/tencent/mm/ui/widget/pulldown/ICustomNestedChild;)V", "isAtEndWhenIntercept", "", "()Z", "setAtEndWhenIntercept", "(Z)V", "isAtStartWhenIntercept", "setAtStartWhenIntercept", "isFlinging", "setFlinging", "lastType", "", "getLastType", "()I", "setLastType", "(I)V", "mBounceOffsetChangedListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "getMBounceOffsetChangedListeners", "()Ljava/util/LinkedList;", "mCompatScrollViewChild", "Landroid/widget/ScrollView;", "getMCompatScrollViewChild", "()Landroid/widget/ScrollView;", "setMCompatScrollViewChild", "(Landroid/widget/ScrollView;)V", "mCurNestedChild", "Landroid/view/View;", "mDirectionToEnd", "getMDirectionToEnd$annotations", "()V", "mDirectionToStart", "mDownEventCaptured", "mFlingRunnable", "Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView$FlingRunnable;", "mIsEnabled", "getMIsEnabled", "setMIsEnabled", "mIsScrolling", "mLastXForCheckScrolling", "mLastY", "mLastYForCheckScrolling", "mOverScroller", "Landroid/widget/OverScroller;", "mOverScrolling", "mOverscrollListener", "Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "getMOverscrollListener", "()Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "mParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "mPullDownEnableFlag", "getMPullDownEnableFlag", "setMPullDownEnableFlag", "mSpringBackAnimator", "Landroid/animation/ValueAnimator;", "mSpringBackInterpolator", "Landroid/view/animation/Interpolator;", "mTouchSlop", "addBounceOffsetChangedListener", "", "bounceOffsetChangedListener", "canScroll", "overScroll", "child", "scrollDirection", "checkInterceptScroll", "deltaY", "checkIsScrolling", "ev", "Landroid/view/MotionEvent;", "checkScrollDirectionMatchEdge", "isAtStart", "isAtEnd", "computerOffset", "newOffset", "minOffset", "maxOffset", "computerWithDampingFactor", "distance", "dispatchDownEventManually", "enableEnd2Start", "enable", "enableStart2End", "fling", "overScroller", "target", "getDampingFactor", "", "getMaxFlingOffset", "getMaxOffset", "getMinFlingVelocity", "getMinOffset", "getNestedScrollAxes", "getOffset", "onInterceptTouchEvent", "onNestedFling", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "type", "onNestedPreScrollInner", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "nestedScrollAxes", "axes", "onNestedScrollInternal", "onOffsetChanged", "offset", "onSpringBack", "onStartNestedScroll", "onStopNestedScroll", "onStopSpringingBack", "onTouchEvent", "event", "preCalculate", "diff", "removeBounceOffsetChangedListener", "requestDisallowInterceptTouchEvent", "disallowIntercept", "scroll", "scrollWithoutDampingFactor", "setBounce", "setOffset", "springBack", "stopSpringBack", "contains", "Companion", "FlingRunnable", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public class NestedBounceView
  extends FrameLayout
  implements p, e, h
{
  public static final NestedBounceView.a aglU;
  private boolean XQs;
  private boolean aggn;
  private boolean agkT;
  private final Interpolator aglA;
  private View aglV;
  private int aglW;
  private g aglX;
  private final LinkedList<f.a> aglY;
  private final k aglZ;
  private OverScroller aglw;
  private int aglx;
  private int agly;
  private ValueAnimator aglz;
  private ScrollView agma;
  private boolean agmb;
  private boolean agmc;
  private int agmd;
  private int agme;
  private b agmf;
  private int lastType;
  private final int mTouchSlop;
  private final r pE;
  private boolean tyg;
  private int tyi;
  private boolean tyj;
  
  static
  {
    AppMethodBeat.i(251993);
    aglU = new NestedBounceView.a((byte)0);
    AppMethodBeat.o(251993);
  }
  
  public NestedBounceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(251943);
    this.agkT = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.NestedBounceView);
    s.s(paramAttributeSet, "context.obtainStyledAttr…yleable.NestedBounceView)");
    this.agkT = paramAttributeSet.getBoolean(a.k.NestedBounceView_isBounceEnable, true);
    paramAttributeSet.recycle();
    paramAttributeSet = j.aglL;
    this.aglA = ((Interpolator)new DecelerateInterpolator(j.jIQ()));
    this.aglW = 3;
    this.aglY = new LinkedList();
    this.aglZ = new k();
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.pE = new r();
    AppMethodBeat.o(251943);
  }
  
  private static final void a(NestedBounceView paramNestedBounceView, View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(251989);
    s.u(paramNestedBounceView, "this$0");
    s.u(paramView, "$child");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramNestedBounceView = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(251989);
      throw paramNestedBounceView;
    }
    paramNestedBounceView.P(paramView, ((Integer)paramValueAnimator).intValue());
    AppMethodBeat.o(251989);
  }
  
  private static boolean a(h paramh, View paramView)
  {
    AppMethodBeat.i(251986);
    s.u(paramh, "overScroll");
    s.u(paramView, "child");
    boolean bool = k.a(paramh, paramView);
    AppMethodBeat.o(251986);
    return bool;
  }
  
  private final int f(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = 0;
    AppMethodBeat.i(251963);
    int n = cI(paramView);
    int i;
    if (paramInt2 <= n) {
      if (n <= paramInt3) {
        i = 1;
      }
    }
    for (;;)
    {
      int k = m;
      int j = paramInt1;
      if (i != 0)
      {
        paramInt1 = a.clamp(paramInt1, paramInt2, paramInt3);
        k = m;
        j = paramInt1;
        if (n != paramInt1)
        {
          P(paramView, paramInt1);
          k = n - paramInt1;
          j = paramInt1;
        }
      }
      paramView = j.aglL;
      if (j.jIW()) {
        new StringBuilder("[computerOffset] newOffset:").append(j).append(" curOffset").append(n).append(" consumed:").append(k).append(" minOffset:").append(paramInt2).append(" maxOffset:").append(paramInt3);
      }
      AppMethodBeat.o(251963);
      return k;
      i = 0;
      continue;
      i = 0;
    }
  }
  
  private final int g(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(251953);
    int j = cI(paramView);
    h localh = (h)this;
    s.u(localh, "overScroll");
    s.u(paramView, "child");
    float f = k.c(localh, paramView);
    if (f == 0.0F) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        f = 1.0F;
      }
      paramInt1 = f(paramView, j - (int)(paramInt1 / f + 0.5F), paramInt2, paramInt3);
      AppMethodBeat.o(251953);
      return paramInt1;
    }
  }
  
  private void mo(View paramView)
  {
    AppMethodBeat.i(251979);
    s.u(paramView, "child");
    Object localObject = j.aglL;
    if (j.jIW()) {
      new StringBuilder("springBack child:").append(paramView.getClass().getSimpleName()).append('@').append(paramView.hashCode());
    }
    int j = cI(paramView);
    if (j == 0)
    {
      AppMethodBeat.o(251979);
      return;
    }
    if (a((h)this, paramView))
    {
      AppMethodBeat.o(251979);
      return;
    }
    if (this.aglz == null) {
      this.aglz = ValueAnimator.ofInt(new int[0]);
    }
    localObject = this.aglz;
    if ((localObject != null) && (((ValueAnimator)localObject).isStarted() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(251979);
      return;
    }
    localObject = this.aglz;
    if (localObject != null) {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
    }
    localObject = this.aglz;
    if (localObject != null) {
      ((ValueAnimator)localObject).addUpdateListener(new NestedBounceView..ExternalSyntheticLambda0(this, paramView));
    }
    float f1 = Math.abs(j) * 1.0F / cJ(paramView);
    paramView = j.aglL;
    float f2 = j.jIR();
    paramView = this.aglz;
    if (paramView != null)
    {
      i = (int)(f1 * f2);
      localObject = j.aglL;
      paramView.setDuration(Math.max(i, j.jIS()));
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
    AppMethodBeat.o(251979);
  }
  
  private void mp(View paramView)
  {
    int i = 1;
    AppMethodBeat.i(251970);
    s.u(paramView, "child");
    ValueAnimator localValueAnimator;
    if (this.aglz != null)
    {
      localValueAnimator = this.aglz;
      if ((localValueAnimator == null) || (localValueAnimator.isRunning() != true)) {
        break label71;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        localValueAnimator = this.aglz;
        if (localValueAnimator != null) {
          localValueAnimator.cancel();
        }
      }
      k.e((h)this, paramView);
      AppMethodBeat.o(251970);
      return;
      label71:
      i = 0;
    }
  }
  
  public final void NI(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = this.aglW | 0x1;; i = this.aglW & 0xFFFFFFFE)
    {
      this.aglW = i;
      return;
    }
  }
  
  public final void NJ(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = this.aglW | 0x2;; i = this.aglW & 0xFFFFFFFD)
    {
      this.aglW = i;
      return;
    }
  }
  
  public void P(View paramView, int paramInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(252232);
    Object localObject2 = j.aglL;
    if (j.jIW())
    {
      localObject2 = new StringBuilder("[setOffset] offset:").append(paramInt).append(" child:");
      if (paramView != null) {
        break label131;
      }
      localObject1 = ((StringBuilder)localObject2).append(localObject1).append('@');
      if (paramView == null) {
        break label152;
      }
    }
    label131:
    label152:
    for (int i = paramView.hashCode();; i = 0)
    {
      ((StringBuilder)localObject1).append(i).append('}');
      localObject1 = j.aglL;
      j.jIX().P(paramView, paramInt);
      paramView = this.aglY.iterator();
      while (paramView.hasNext()) {
        ((f.a)paramView.next()).Wm(paramInt);
      }
      Class localClass = paramView.getClass();
      if (localClass == null) {
        break;
      }
      localObject1 = localClass.getSimpleName();
      break;
    }
    AppMethodBeat.o(252232);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(252157);
    s.u(paramView, "target");
    a(paramView, paramInt4, paramInt5, null);
    AppMethodBeat.o(252157);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(252199);
    s.u(paramView, "target");
    Object localObject2 = j.aglL;
    if (j.jIW())
    {
      localObject2 = new StringBuilder("[onNestedScrollInternal] dyUnconsumed:").append(paramInt1).append(", type:").append(paramInt2).append(", consumed:");
      if (paramArrayOfInt != null) {
        break label117;
      }
    }
    label117:
    for (paramArrayOfInt = null;; paramArrayOfInt = kotlin.a.k.Y(paramArrayOfInt))
    {
      ((StringBuilder)localObject2).append(paramArrayOfInt);
      this.XQs = false;
      localObject2 = this.aglZ;
      if (paramInt1 != 0) {
        requestDisallowInterceptTouchEvent(true);
      }
      if (paramInt1 >= 0) {
        break label395;
      }
      if (k.b((h)this, paramView)) {
        break;
      }
      AppMethodBeat.o(252199);
      return;
    }
    if (paramInt2 == 0)
    {
      g(paramView, paramInt1, 0, cJ(paramView));
      AppMethodBeat.o(252199);
      return;
    }
    OverScroller localOverScroller = this.aglw;
    if (localOverScroller == null)
    {
      paramArrayOfInt = null;
      if (localOverScroller != null) {
        break label354;
      }
    }
    int i;
    for (;;)
    {
      paramInt2 = k.a((h)this, paramView, this.aglx);
      i = cI(paramView);
      int j = Math.abs(((k)localObject2).d((h)this, paramView));
      if ((localOverScroller != null) && (localOverScroller.computeScrollOffset()) && (Math.abs(localOverScroller.getCurrVelocity()) >= j) && (i < paramInt2)) {
        break label367;
      }
      localObject2 = j.aglL;
      if (j.jIW()) {
        new StringBuilder("[stopNestedScroll] when reach edge distanceUnconsumed:").append(paramInt1).append(" computeScrollOffset:").append(paramArrayOfInt).append(" curVelocity:").append(localObject1).append(" minFlingVelocity:").append(j).append(" curOffset:").append(i).append(" maxFlingOffset:").append(paramInt2);
      }
      z.at(paramView);
      if (localOverScroller == null) {
        break label574;
      }
      localOverScroller.forceFinished(true);
      AppMethodBeat.o(252199);
      return;
      paramArrayOfInt = Boolean.valueOf(localOverScroller.computeScrollOffset());
      break;
      label354:
      localObject1 = Float.valueOf(localOverScroller.getCurrVelocity());
    }
    label367:
    g(paramView, paramInt1, i, k.a((h)this, paramView, this.aglx));
    AppMethodBeat.o(252199);
    return;
    label395:
    if (paramInt1 > 0)
    {
      if (!k.b((h)this, paramView))
      {
        AppMethodBeat.o(252199);
        return;
      }
      if (paramInt2 == 0)
      {
        g(paramView, paramInt1, cK(paramView), 0);
        AppMethodBeat.o(252199);
        return;
      }
      paramArrayOfInt = this.aglw;
      if ((paramArrayOfInt == null) || (!paramArrayOfInt.computeScrollOffset()) || (Math.abs(paramArrayOfInt.getCurrVelocity()) < Math.abs(((k)localObject2).d((h)this, paramView))) || (cI(paramView) <= k.a((h)this, paramView, this.agly)))
      {
        localObject1 = j.aglL;
        if (j.jIW()) {
          s.X("[stopNestedScroll] when reach edge distanceUnconsumed:", Integer.valueOf(paramInt1));
        }
        z.at(paramView);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt.forceFinished(true);
          AppMethodBeat.o(252199);
        }
      }
      else
      {
        g(paramView, paramInt1, k.a((h)this, paramView, this.agly), cI(paramView));
      }
    }
    label574:
    AppMethodBeat.o(252199);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(252168);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    int i = paramArrayOfInt[1];
    int j = b(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    paramArrayOfInt[1] = j;
    j localj = j.aglL;
    if (j.jIW()) {
      new StringBuilder("[onNestedPreScroll]target:").append(paramView.getClass().getName()).append(", dx:").append(paramInt1).append(", dy:").append(paramInt2).append(", consumed: ").append(kotlin.a.k.Y(paramArrayOfInt)).append(", type: ").append(paramInt3).append(" comsumedBefore:").append(i).append(" comsumedAfter:").append(j);
    }
    AppMethodBeat.o(252168);
  }
  
  public final void a(f.a parama)
  {
    AppMethodBeat.i(252028);
    if ((parama != null) && (!this.aglY.contains(parama))) {
      this.aglY.add(parama);
    }
    AppMethodBeat.o(252028);
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252092);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    j localj = j.aglL;
    if (j.jIW()) {
      new StringBuilder("[onStartNestedScroll] target:").append(paramView2.getClass().getName()).append(" enable:").append(this.agkT).append(" axes:").append(paramInt1).append(" type:").append(paramInt2).append(" isAtStart:").append(l.mq(paramView1)).append(" isAtEnd:").append(l.mr(paramView1));
    }
    if (!this.agkT)
    {
      AppMethodBeat.o(252092);
      return false;
    }
    this.lastType = paramInt2;
    this.XQs = false;
    if ((paramInt1 & 0x2) != 0)
    {
      AppMethodBeat.o(252092);
      return true;
    }
    AppMethodBeat.o(252092);
    return false;
  }
  
  protected int b(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(252178);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    if (paramInt2 != 0)
    {
      if (paramInt2 < 0)
      {
        if (!k.b((h)this, (View)this))
        {
          AppMethodBeat.o(252178);
          return 0;
        }
        paramInt3 = cI(paramView);
        paramInt1 = 0;
      }
      while (paramInt3 < paramInt1)
      {
        paramInt1 = f(paramView, cI(paramView) - paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(252178);
        return paramInt1;
        if (!k.b((h)this, (View)this))
        {
          AppMethodBeat.o(252178);
          return 0;
        }
        paramInt1 = cI(paramView);
        paramInt3 = 0;
      }
    }
    AppMethodBeat.o(252178);
    return 0;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252110);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    this.pE.aA(paramInt1, paramInt2);
    j localj = j.aglL;
    if (j.jIW()) {
      new StringBuilder("[onNestedScrollAccepted] target:").append(paramView2).append(" enable:").append(paramView2.isNestedScrollingEnabled()).append(" axes:").append(paramInt1).append(" type:").append(paramInt2);
    }
    this.aglV = paramView2;
    if (paramInt2 == 0) {
      mp(paramView1);
    }
    if (paramInt2 == 0)
    {
      paramView1 = this.aglw;
      if (paramView1 != null) {
        paramView1.forceFinished(true);
      }
    }
    if ((paramInt1 & 0x2) != 0)
    {
      this.aglx = 2;
      this.agly = 1;
      AppMethodBeat.o(252110);
      return;
    }
    this.aglx = 8;
    this.agly = 4;
    AppMethodBeat.o(252110);
  }
  
  public int cI(View paramView)
  {
    AppMethodBeat.i(252238);
    j localj = j.aglL;
    int i = j.jIX().cI(paramView);
    AppMethodBeat.o(252238);
    return i;
  }
  
  public final int cJ(View paramView)
  {
    AppMethodBeat.i(252246);
    j localj = j.aglL;
    int i = j.jIX().cJ(paramView);
    AppMethodBeat.o(252246);
    return i;
  }
  
  public final int cK(View paramView)
  {
    AppMethodBeat.i(252251);
    j localj = j.aglL;
    int i = j.jIX().cK(paramView);
    AppMethodBeat.o(252251);
    return i;
  }
  
  public final g getCustomNestedChild()
  {
    return this.aglX;
  }
  
  public final int getLastType()
  {
    return this.lastType;
  }
  
  protected final LinkedList<f.a> getMBounceOffsetChangedListeners()
  {
    return this.aglY;
  }
  
  public final ScrollView getMCompatScrollViewChild()
  {
    return this.agma;
  }
  
  protected final boolean getMIsEnabled()
  {
    return this.agkT;
  }
  
  public final k getMOverscrollListener()
  {
    return this.aglZ;
  }
  
  protected final int getMPullDownEnableFlag()
  {
    return this.aglW;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(252213);
    int i = this.pE.getNestedScrollAxes();
    AppMethodBeat.o(252213);
    return i;
  }
  
  public void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(252133);
    s.u(paramView, "target");
    Object localObject = j.aglL;
    if (j.jIW()) {
      new StringBuilder("[onStopNestedScroll] target:").append(paramView.getClass().getName()).append('@').append(paramView.hashCode()).append(" type:").append(paramInt).append(" lastType:").append(this.lastType).append(" curOffset:").append(cI(paramView)).append(" isFling:").append(this.XQs).append(' ');
    }
    this.pE.eq(paramInt);
    OverScroller localOverScroller = this.aglw;
    label184:
    label206:
    int i;
    if (paramInt == 0)
    {
      localObject = j.aglL;
      if (j.jIW())
      {
        StringBuilder localStringBuilder = new StringBuilder("[onStopNestedScroll] mOverScroller:");
        if (localOverScroller == null)
        {
          localObject = null;
          localStringBuilder = localStringBuilder.append(localObject).append(" velocity:");
          if (localOverScroller != null) {
            break label265;
          }
          localObject = null;
          localObject = localStringBuilder.append(localObject).append(" delta:");
          if (localOverScroller != null) {
            break label278;
          }
          paramInt = 0;
          if (localOverScroller != null) {
            break label287;
          }
          i = 0;
          label213:
          ((StringBuilder)localObject).append(paramInt - i);
        }
      }
      else
      {
        if (cI(paramView) == 0) {
          break label327;
        }
        if (localOverScroller != null) {
          break label296;
        }
        mo(paramView);
      }
    }
    for (;;)
    {
      this.aglV = null;
      AppMethodBeat.o(252133);
      return;
      localObject = Boolean.valueOf(localOverScroller.computeScrollOffset());
      break;
      label265:
      localObject = Float.valueOf(localOverScroller.getCurrVelocity());
      break label184;
      label278:
      paramInt = localOverScroller.getCurrY();
      break label206;
      label287:
      i = localOverScroller.getStartY();
      break label213;
      label296:
      if (!localOverScroller.computeScrollOffset())
      {
        mo(paramView);
      }
      else if (this.XQs)
      {
        mo(paramView);
        continue;
        label327:
        if ((this.XQs) && (localOverScroller != null) && (localOverScroller.computeScrollOffset()))
        {
          localObject = j.aglL;
          if (this.agmf == null) {
            this.agmf = new b(localOverScroller, paramView);
          }
          paramView = this.agmf;
          if (paramView != null)
          {
            paramView.caH = paramView.bwz.getCurrY();
            paramView.agmh.postOnAnimation((Runnable)paramView);
            continue;
            if (cI(paramView) != 0) {
              mo(paramView);
            }
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252075);
    boolean bool4;
    boolean bool5;
    label46:
    boolean bool6;
    label59:
    label68:
    Object localObject1;
    label100:
    boolean bool3;
    label108:
    boolean bool2;
    label116:
    boolean bool1;
    boolean bool7;
    if (((this.aglV instanceof AbsListView)) || ((this.aglV instanceof ScrollView)))
    {
      bool4 = true;
      if ((this.agma == null) || (this.aglV != null)) {
        break label445;
      }
      bool5 = true;
      if ((!bool4) && (!bool5)) {
        break label451;
      }
      bool6 = true;
      if (this.aglX == null) {
        break label457;
      }
      i = 1;
      if ((!this.agkT) || ((!bool6) && (i == 0))) {
        break label1288;
      }
      if (!bool6) {
        break label690;
      }
      if (!bool4) {
        break label462;
      }
      localObject1 = this.aglV;
      if (localObject1 != null) {
        break label660;
      }
      bool3 = false;
      if (localObject1 != null) {
        break label670;
      }
      bool2 = false;
      if ((!bool3) || (!bool2)) {
        break label680;
      }
      bool1 = true;
      bool7 = bool2;
      label133:
      if (!this.aggn) {
        break label797;
      }
      if (paramMotionEvent != null) {
        break label788;
      }
      i = 0;
      label146:
      this.agme = i;
      bool2 = this.aggn;
      label157:
      this.aggn = bool2;
      localObject1 = j.aglL;
      if (j.jIW())
      {
        localObject1 = new StringBuilder("[onInterceptTouchEvent] action:");
        if (paramMotionEvent != null) {
          break label935;
        }
        i = -1;
        label192:
        localObject1 = ((StringBuilder)localObject1).append(MotionEvent.actionToString(i)).append(" isAtStart:").append(bool3).append(" isAtEnd:").append(bool7).append(" isScrollOver:").append(bool1).append(" mIsScrolling:").append(this.aggn).append(" hasCompactView:").append(bool6).append(" isCompactView:").append(bool4).append(" isCompactScrollView:").append(bool5).append(" mCurNestedChild!=null：");
        if (this.aglV == null) {
          break label943;
        }
        bool2 = true;
        label298:
        ((StringBuilder)localObject1).append(bool2);
      }
      if (!bool1) {
        break label1277;
      }
      if (paramMotionEvent != null) {
        break label949;
      }
      localObject1 = null;
      label318:
      if (localObject1 != null) {
        break label961;
      }
      label323:
      if (localObject1 != null) {
        break label985;
      }
      label328:
      if (localObject1 != null) {
        break label1231;
      }
      label333:
      if (localObject1 != null) {
        break label1245;
      }
      label338:
      i = 0;
      label340:
      if (i == 0) {
        break label1259;
      }
      this.tyg = false;
      this.tyj = false;
      this.aggn = false;
      localObject1 = j.aglL;
      bool1 = false;
      label367:
      if (paramMotionEvent != null) {
        break label1268;
      }
    }
    label445:
    label451:
    label457:
    label462:
    label591:
    label598:
    label861:
    label1259:
    label1268:
    for (int i = 0;; i = (int)paramMotionEvent.getY())
    {
      this.tyi = i;
      paramMotionEvent = j.aglL;
      if (j.jIW()) {
        new StringBuilder("[onInterceptTouchEvent] return res:").append(bool1).append(" mOverScrolling :").append(this.tyg).append(" mLastY:").append(this.tyi);
      }
      AppMethodBeat.o(252075);
      return bool1;
      bool4 = false;
      break;
      bool5 = false;
      break label46;
      bool6 = false;
      break label59;
      i = 0;
      break label68;
      if (bool5)
      {
        localObject1 = this.agma;
        if (localObject1 != null)
        {
          Object localObject2 = (View)localObject1;
          s.u(localObject2, "<this>");
          if (paramMotionEvent != null)
          {
            localObject1 = new Rect();
            ((View)localObject2).getGlobalVisibleRect((Rect)localObject1);
            bool1 = ((Rect)localObject1).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
            if (bool1)
            {
              localObject2 = j.aglL;
              if (j.jIW()) {
                new StringBuilder("contains() called with:actualPosition=").append(localObject1).append(" containRes = ").append(bool1).append(" ev = ").append(paramMotionEvent).append(' ');
              }
              i = 1;
              if (i != 1) {
                break label644;
              }
              i = 1;
              if (i == 0) {
                break label654;
              }
              localObject1 = this.agma;
              if ((localObject1 == null) || (((ScrollView)localObject1).getVisibility() != 0)) {
                break label649;
              }
            }
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label654;
          }
          localObject1 = (View)this.agma;
          break;
          i = 0;
          break label591;
          i = 0;
          break label598;
        }
      }
      localObject1 = null;
      break label100;
      bool3 = l.mq((View)localObject1);
      break label108;
      bool2 = l.mr((View)localObject1);
      break label116;
      bool1 = false;
      bool7 = bool2;
      break label133;
      localObject1 = this.aglX;
      if (localObject1 == null)
      {
        bool1 = false;
        localObject1 = this.aglX;
        if (localObject1 != null) {
          break label758;
        }
      }
      label758:
      for (bool2 = false;; bool2 = ((g)localObject1).aau())
      {
        if ((!bool1) && (!bool2)) {
          break label770;
        }
        bool7 = true;
        bool3 = bool1;
        bool1 = bool7;
        bool7 = bool2;
        break;
        bool1 = ((g)localObject1).grG();
        break label704;
      }
      bool7 = false;
      bool3 = bool1;
      bool1 = bool7;
      bool7 = bool2;
      break label133;
      i = (int)paramMotionEvent.getY();
      break label146;
      if (paramMotionEvent == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label832;
        }
        if (localObject1 != null) {
          break label861;
        }
      }
      while (((Integer)localObject1).intValue() != 2) {
        for (;;)
        {
          bool2 = false;
          break;
          localObject1 = Integer.valueOf(paramMotionEvent.getAction());
          break label804;
          if (((Integer)localObject1).intValue() != 0) {
            break label809;
          }
          this.agmd = ((int)paramMotionEvent.getX());
          this.agme = ((int)paramMotionEvent.getY());
        }
      }
      i = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int j = this.agmd;
      k -= this.agme;
      if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) > Math.abs(i - j)))
      {
        bool2 = true;
        break label157;
      }
      bool2 = false;
      break label157;
      i = paramMotionEvent.getAction();
      break label192;
      bool2 = false;
      break label298;
      localObject1 = Integer.valueOf(paramMotionEvent.getAction());
      break label318;
      if (((Integer)localObject1).intValue() != 0) {
        break label323;
      }
      this.tyg = false;
      this.tyj = true;
      bool1 = false;
      break label367;
      if (((Integer)localObject1).intValue() != 2) {
        break label328;
      }
      if (this.tyg)
      {
        localObject1 = j.aglL;
        bool1 = true;
        break label367;
      }
      if (!this.tyj)
      {
        this.tyg = false;
        this.tyj = true;
        bool1 = false;
        break label367;
      }
      j = (int)paramMotionEvent.getY();
      k = j - this.tyi;
      if (this.aggn) {
        if (((k > 0) && (bool3)) || ((k < 0) && (bool7)))
        {
          i = 1;
          if (i == 0) {
            break label1225;
          }
          if (((k <= 0) || ((this.aglW & 0x1) == 0)) && ((k >= 0) || ((this.aglW & 0x2) == 0))) {
            break label1220;
          }
          i = 1;
          if (i == 0) {
            break label1225;
          }
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        localObject1 = j.aglL;
        if (j.jIW()) {
          new StringBuilder("[onInterceptTouchEvent] move res:").append(bool1).append(" dy:").append(k).append(" mLast:").append(this.tyi).append(" currentY:").append(j);
        }
        if (bool1)
        {
          this.tyi = j;
          this.tyg = true;
          this.tyj = false;
          this.agmb = bool3;
          this.agmc = bool7;
        }
        break;
        i = 0;
        break label1078;
        i = 0;
        break label1112;
      }
      if (((Integer)localObject1).intValue() != 3) {
        break label333;
      }
      i = 1;
      break label340;
      if (((Integer)localObject1).intValue() != 1) {
        break label338;
      }
      i = 1;
      break label340;
      bool1 = this.tyg;
      break label367;
    }
    label644:
    label649:
    label654:
    label660:
    label670:
    label680:
    label690:
    label704:
    label961:
    label985:
    label1245:
    label1277:
    if (paramMotionEvent == null) {}
    label770:
    label788:
    label797:
    label804:
    label809:
    label832:
    label1112:
    for (i = 0;; i = (int)paramMotionEvent.getY())
    {
      this.tyi = i;
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(252075);
      return bool1;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(252220);
    s.u(paramView, "target");
    j localj = j.aglL;
    if (j.jIW()) {
      new StringBuilder("[onNestedFling] velocityX:").append(paramFloat1).append(" velocityY:").append(paramFloat2).append(" consumed:").append(paramBoolean);
    }
    paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(252220);
    return paramBoolean;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(252226);
    s.u(paramView, "target");
    Object localObject = j.aglL;
    if (j.jIW()) {
      new StringBuilder("[onNestedPreFling] velocityX:").append(paramFloat1).append(" velocityY:").append(paramFloat2).append(" velocityY:").append(paramFloat2);
    }
    if (this.aglw == null) {
      this.aglw = new OverScroller(getContext());
    }
    localObject = this.aglw;
    if (localObject != null) {
      ((OverScroller)localObject).fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    }
    this.XQs = true;
    boolean bool = super.onNestedPreFling(paramView, paramFloat1, paramFloat2);
    AppMethodBeat.o(252226);
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(252206);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
    AppMethodBeat.o(252206);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(252148);
    s.u(paramView, "target");
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
    AppMethodBeat.o(252148);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(252118);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    b(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(252118);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(252099);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    boolean bool = a(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(252099);
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(252140);
    s.u(paramView, "target");
    l(paramView, 0);
    AppMethodBeat.o(252140);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(252084);
    s.u(paramMotionEvent, "event");
    Object localObject = j.aglL;
    if (j.jIW()) {
      s.X("[onTouchEvent] action:", MotionEvent.actionToString(paramMotionEvent.getAction()));
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      paramMotionEvent = j.aglL;
      AppMethodBeat.o(252084);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 2: 
      do
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(252084);
        return bool;
      } while (!this.tyg);
      if (!this.tyj)
      {
        this.tyi = ((int)paramMotionEvent.getY());
        this.tyj = true;
        mp((View)this);
        paramMotionEvent = this.aglw;
        if (paramMotionEvent != null) {
          paramMotionEvent.forceFinished(true);
        }
        paramMotionEvent = j.aglL;
        AppMethodBeat.o(252084);
        return true;
      }
      int k = this.tyi - (int)paramMotionEvent.getY();
      this.tyi = ((int)paramMotionEvent.getY());
      localObject = this.aglX;
      int m;
      int n;
      int i;
      if (localObject == null)
      {
        localObject = (View)this;
        m = cI((View)localObject);
        n = m - k;
        if (m != 0) {
          break label391;
        }
        if (((n > 0) && (this.agmb)) || ((n < 0) && (this.agmc))) {
          break label452;
        }
        i = 0;
      }
      for (;;)
      {
        if (i != k)
        {
          s.u(paramMotionEvent, "ev");
          j = paramMotionEvent.getAction();
          paramMotionEvent.setAction(0);
          dispatchTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(j);
        }
        int j = i - b((View)localObject, 0, i, new int[2], 0);
        if (j != 0) {
          a((View)localObject, j, 0, new int[2]);
        }
        paramMotionEvent = j.aglL;
        if (j.jIW()) {
          new StringBuilder("[onTouchEvent] real diff:").append(i).append(" left diff:").append(j);
        }
        AppMethodBeat.o(252084);
        return true;
        localObject = ((g)localObject).iCf();
        if (localObject == null)
        {
          localObject = (View)this;
          break;
        }
        break;
        label391:
        if (m < 0)
        {
          i = 1;
          label398:
          if (n >= 0) {
            break label447;
          }
        }
        label447:
        for (j = 1;; j = 0)
        {
          if ((i == j) || ((n > 0) && (this.agmb)) || ((n < 0) && (this.agmc))) {
            break label452;
          }
          i = m + 0;
          break;
          i = 0;
          break label398;
        }
        label452:
        i = k;
      }
    }
    this.tyj = false;
    this.tyg = false;
    this.aggn = false;
    localObject = this.aglX;
    if (localObject == null) {
      localObject = (View)this;
    }
    for (;;)
    {
      l((View)localObject, 0);
      break;
      View localView = ((g)localObject).iCf();
      localObject = localView;
      if (localView == null) {
        localObject = (View)this;
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(252054);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    j localj = j.aglL;
    if (j.jIW()) {
      s.X("requestDisallowInterceptTouchEvent() called with: disallowIntercept = ", Boolean.valueOf(paramBoolean));
    }
    AppMethodBeat.o(252054);
  }
  
  public final void setAtEndWhenIntercept(boolean paramBoolean)
  {
    this.agmc = paramBoolean;
  }
  
  public final void setAtStartWhenIntercept(boolean paramBoolean)
  {
    this.agmb = paramBoolean;
  }
  
  public final void setBounce(boolean paramBoolean)
  {
    this.agkT = paramBoolean;
  }
  
  public final void setCustomNestedChild(g paramg)
  {
    this.aglX = paramg;
  }
  
  public final void setFlinging(boolean paramBoolean)
  {
    this.XQs = paramBoolean;
  }
  
  public final void setLastType(int paramInt)
  {
    this.lastType = paramInt;
  }
  
  public final void setMCompatScrollViewChild(ScrollView paramScrollView)
  {
    this.agma = paramScrollView;
  }
  
  protected final void setMIsEnabled(boolean paramBoolean)
  {
    this.agkT = paramBoolean;
  }
  
  protected final void setMPullDownEnableFlag(int paramInt)
  {
    this.aglW = paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView$FlingRunnable;", "Ljava/lang/Runnable;", "mScroller", "Landroid/widget/OverScroller;", "target", "Landroid/view/View;", "(Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;Landroid/widget/OverScroller;Landroid/view/View;)V", "mLastFlingY", "", "getMScroller", "()Landroid/widget/OverScroller;", "getTarget", "()Landroid/view/View;", "run", "", "start", "weui-native-android-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements Runnable
  {
    private final View agmg;
    final OverScroller bwz;
    int caH;
    
    public b(View paramView)
    {
      AppMethodBeat.i(251906);
      this.bwz = paramView;
      this.agmg = localObject;
      this.caH = this.bwz.getCurrY();
      AppMethodBeat.o(251906);
    }
    
    public final void run()
    {
      AppMethodBeat.i(251912);
      OverScroller localOverScroller = this.bwz;
      boolean bool = localOverScroller.computeScrollOffset();
      int i = localOverScroller.getCurrY();
      int j = i - this.caH;
      if (((this.agmg instanceof AbsListView)) || ((this.agmg instanceof ScrollView)))
      {
        j localj = j.aglL;
        if (j.jIW()) {
          new StringBuilder("[fling] hasMore:").append(bool).append(" velocity:").append(localOverScroller.getCurrVelocity()).append(" delta:").append(j).append(" mLastFlingY:").append(this.caH).append(" y:").append(i).append(" isAtStart:").append(l.mq(this.agmg)).append(" isAtEnd:").append(l.mr(this.agmg));
        }
        if (bool)
        {
          if ((j < 0) && (l.mq(this.agmg))) {
            NestedBounceView.this.a(this.agmg, j, 1, new int[2]);
          }
          for (;;)
          {
            this.caH = i;
            NestedBounceView.this.postOnAnimation((Runnable)this);
            AppMethodBeat.o(251912);
            return;
            if ((j > 0) && (l.mr(this.agmg))) {
              NestedBounceView.this.a(this.agmg, j, 1, new int[2]);
            }
          }
        }
        NestedBounceView.this.l(this.agmg, 1);
      }
      AppMethodBeat.o(251912);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.NestedBounceView
 * JD-Core Version:    0.7.0.1
 */