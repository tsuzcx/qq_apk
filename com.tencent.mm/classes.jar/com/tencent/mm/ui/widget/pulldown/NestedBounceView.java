package com.tencent.mm.ui.widget.pulldown;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import androidx.core.g.r;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.k;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent2;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceCommon;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScroll;", "Lcom/tencent/mm/ui/widget/pulldown/IOverScrollCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isFlinging", "", "()Z", "setFlinging", "(Z)V", "lastType", "", "getLastType", "()I", "setLastType", "(I)V", "mBounceOffsetChangedListeners", "Ljava/util/LinkedList;", "Lcom/tencent/mm/ui/widget/pulldown/IBounceView$BounceOffsetChangedListener;", "getMBounceOffsetChangedListeners", "()Ljava/util/LinkedList;", "mCompatScrollViewChild", "Landroid/widget/ScrollView;", "getMCompatScrollViewChild", "()Landroid/widget/ScrollView;", "setMCompatScrollViewChild", "(Landroid/widget/ScrollView;)V", "mCurNestedChild", "Landroid/view/View;", "mDirectionToEnd", "mDirectionToEnd$annotations", "()V", "mDirectionToStart", "mDownEventCaptured", "mFlingRunnable", "Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView$FlingRunnable;", "mIsEnabled", "getMIsEnabled", "setMIsEnabled", "mLastX", "mLastY", "mOpened", "mOverScroller", "Landroid/widget/OverScroller;", "mOverScrolling", "mOverscrollListener", "Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "getMOverscrollListener", "()Lcom/tencent/mm/ui/widget/pulldown/SimpleOverScrollCallback;", "mParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "mSpringBackAnimator", "Landroid/animation/ValueAnimator;", "mSpringBackInterpolator", "Landroid/view/animation/Interpolator;", "mStartY", "mTouchSlop", "addBounceOffsetChangedListener", "", "bounceOffsetChangedListener", "canScroll", "overScroll", "child", "scrollDirection", "checkInterceptScroll", "deltaY", "computerOffset", "newOffset", "minOffset", "maxOffset", "computerWithDampingFactor", "distance", "fling", "overScroller", "target", "getDampingFactor", "", "getMaxFlingOffset", "getMaxOffset", "getMinFlingVelocity", "getMinOffset", "getNestedScrollAxes", "getOffset", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onNestedFling", "velocityX", "velocityY", "consumed", "onNestedPreFling", "onNestedPreScroll", "dx", "dy", "", "type", "onNestedPreScrollInner", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScrollAccepted", "nestedScrollAxes", "axes", "onNestedScrollInternal", "onOffsetChanged", "offset", "onSpringBack", "onStartNestedScroll", "onStopNestedScroll", "onStopSpringingBack", "onTouchEvent", "event", "removeBounceOffsetChangedListener", "requestDisallowInterceptTouchEvent", "disallowIntercept", "scroll", "scrollWithoutDampingFactor", "setBounce", "enable", "setOffset", "springBack", "stopSpringBack", "contains", "Companion", "FlingRunnable", "weui-native-android-lib_release"})
public class NestedBounceView
  extends FrameLayout
  implements androidx.core.g.p, f, g
{
  public static final NestedBounceView.a YtM;
  private boolean QUr;
  private boolean YsE;
  private View YtI;
  private final j YtJ;
  private ScrollView YtK;
  private b YtL;
  private OverScroller Ytg;
  private int Yth;
  private int Yti;
  private ValueAnimator Ytj;
  private final Interpolator Ytk;
  private final LinkedList<e.a> aado;
  private int asF;
  private int lastType;
  private final int mTouchSlop;
  private final r oH;
  private boolean qtA;
  private boolean qtB;
  private int qtC;
  private int qtD;
  private boolean qtE;
  
  static
  {
    AppMethodBeat.i(249899);
    YtM = new NestedBounceView.a((byte)0);
    AppMethodBeat.o(249899);
  }
  
  public NestedBounceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(249896);
    this.YsE = true;
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.NestedBounceView);
    kotlin.g.b.p.j(paramAttributeSet, "context.obtainStyledAttr…yleable.NestedBounceView)");
    this.YsE = paramAttributeSet.getBoolean(a.k.NestedBounceView_isBounceEnable, true);
    paramAttributeSet.recycle();
    paramAttributeSet = i.YtH;
    this.Ytk = ((Interpolator)new DecelerateInterpolator(i.idI()));
    this.aado = new LinkedList();
    this.YtJ = new j();
    paramContext = ViewConfiguration.get(paramContext);
    kotlin.g.b.p.j(paramContext, "ViewConfiguration.get(context)");
    this.mTouchSlop = paramContext.getScaledTouchSlop();
    this.oH = new r();
    AppMethodBeat.o(249896);
  }
  
  private static boolean a(f paramf, View paramView)
  {
    AppMethodBeat.i(249894);
    kotlin.g.b.p.k(paramf, "overScroll");
    kotlin.g.b.p.k(paramView, "child");
    boolean bool = j.a(paramf, paramView);
    AppMethodBeat.o(249894);
    return bool;
  }
  
  private final int g(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(249872);
    int m = cm(paramView);
    int k = 0;
    int j;
    int i;
    if (paramInt2 > m)
    {
      j = paramInt1;
      i = k;
    }
    for (;;)
    {
      paramView = i.YtH;
      if (i.idO()) {
        new StringBuilder("[computerOffset] newOffset:").append(j).append(" curOffset").append(m).append(" consumed:").append(i).append(" minOffset:").append(paramInt2).append(" maxOffset:").append(paramInt3);
      }
      AppMethodBeat.o(249872);
      return i;
      i = k;
      j = paramInt1;
      if (paramInt3 >= m)
      {
        paramInt1 = a.clamp(paramInt1, paramInt2, paramInt3);
        i = k;
        j = paramInt1;
        if (m != paramInt1)
        {
          K(paramView, paramInt1);
          i = m - paramInt1;
          j = paramInt1;
        }
      }
    }
  }
  
  private final int h(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(249870);
    int i = cm(paramView);
    f localf = (f)this;
    kotlin.g.b.p.k(localf, "overScroll");
    kotlin.g.b.p.k(paramView, "child");
    float f2 = j.e(localf, paramView);
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = 1.0F;
    }
    paramInt1 = g(paramView, i - (int)(paramInt1 / f1 + 0.5F), paramInt2, paramInt3);
    AppMethodBeat.o(249870);
    return paramInt1;
  }
  
  private void iR(View paramView)
  {
    AppMethodBeat.i(249891);
    kotlin.g.b.p.k(paramView, "child");
    Object localObject = i.YtH;
    if (i.idO()) {
      new StringBuilder("springBack child:").append(paramView.getClass().getSimpleName()).append('@').append(paramView.hashCode());
    }
    int i = cm(paramView);
    if (i == 0)
    {
      AppMethodBeat.o(249891);
      return;
    }
    if (a((f)this, paramView))
    {
      AppMethodBeat.o(249891);
      return;
    }
    if (this.Ytj == null) {
      this.Ytj = ValueAnimator.ofInt(new int[0]);
    }
    localObject = this.Ytj;
    if ((localObject != null) && (((ValueAnimator)localObject).isStarted() == true))
    {
      AppMethodBeat.o(249891);
      return;
    }
    localObject = this.Ytj;
    if (localObject != null) {
      ((ValueAnimator)localObject).removeAllUpdateListeners();
    }
    localObject = this.Ytj;
    if (localObject != null) {
      ((ValueAnimator)localObject).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new NestedBounceView.c(this, paramView));
    }
    float f1 = Math.abs(i) * 1.0F / cn(paramView);
    paramView = i.YtH;
    float f2 = i.idJ();
    paramView = this.Ytj;
    if (paramView != null)
    {
      int j = (int)(f1 * f2);
      localObject = i.YtH;
      paramView.setDuration(Math.max(j, i.idK()));
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
      AppMethodBeat.o(249891);
      return;
    }
    AppMethodBeat.o(249891);
  }
  
  private void iS(View paramView)
  {
    AppMethodBeat.i(249889);
    kotlin.g.b.p.k(paramView, "child");
    if (this.Ytj != null)
    {
      ValueAnimator localValueAnimator = this.Ytj;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning() == true))
      {
        localValueAnimator = this.Ytj;
        if (localValueAnimator != null) {
          localValueAnimator.cancel();
        }
      }
    }
    j.d((f)this, paramView);
    AppMethodBeat.o(249889);
  }
  
  public void K(View paramView, int paramInt)
  {
    AppMethodBeat.i(249883);
    Object localObject = i.YtH;
    if (i.idO())
    {
      StringBuilder localStringBuilder = new StringBuilder("[setOffset] offset:").append(paramInt).append(" child:");
      if (paramView == null) {
        break label146;
      }
      localObject = paramView.getClass();
      if (localObject == null) {
        break label146;
      }
      localObject = ((Class)localObject).getSimpleName();
      localObject = localStringBuilder.append((String)localObject).append('@');
      if (paramView == null) {
        break label152;
      }
    }
    label146:
    label152:
    for (int i = paramView.hashCode();; i = 0)
    {
      ((StringBuilder)localObject).append(i).append('}');
      localObject = i.YtH;
      i.idP().K(paramView, paramInt);
      paramView = this.aado.iterator();
      while (paramView.hasNext()) {
        ((e.a)paramView.next()).alg(paramInt);
      }
      localObject = null;
      break;
    }
    AppMethodBeat.o(249883);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    AppMethodBeat.i(249865);
    kotlin.g.b.p.k(paramView, "target");
    a(paramView, paramInt4, paramInt5, null);
    AppMethodBeat.o(249865);
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    Object localObject1 = null;
    AppMethodBeat.i(249874);
    kotlin.g.b.p.k(paramView, "target");
    Object localObject2 = i.YtH;
    if (i.idO())
    {
      localObject2 = new StringBuilder("[onNestedScrollInternal] dyUnconsumed:").append(paramInt1).append(", type:").append(paramInt2).append(", consumed:");
      if (paramArrayOfInt == null) {
        break label136;
      }
    }
    label136:
    for (paramArrayOfInt = e.V(paramArrayOfInt);; paramArrayOfInt = null)
    {
      ((StringBuilder)localObject2).append(paramArrayOfInt);
      this.QUr = false;
      localObject2 = this.YtJ;
      if (paramInt1 != 0) {
        requestDisallowInterceptTouchEvent(true);
      }
      if (paramInt1 >= 0) {
        break label390;
      }
      j.b((f)this, paramView);
      if (paramInt2 != 0) {
        break;
      }
      h(paramView, paramInt1, 0, cn(paramView));
      AppMethodBeat.o(249874);
      return;
    }
    OverScroller localOverScroller = this.Ytg;
    if (localOverScroller != null) {}
    int i;
    for (paramArrayOfInt = Boolean.valueOf(localOverScroller.computeScrollOffset());; paramArrayOfInt = null)
    {
      if (localOverScroller != null) {
        localObject1 = Float.valueOf(localOverScroller.getCurrVelocity());
      }
      paramInt2 = j.b((f)this, paramView, this.Yth);
      i = cm(paramView);
      int j = Math.abs(((j)localObject2).c((f)this, paramView));
      if ((localOverScroller != null) && (localOverScroller.computeScrollOffset()) && (Math.abs(localOverScroller.getCurrVelocity()) >= j) && (i < paramInt2)) {
        break label362;
      }
      localObject2 = i.YtH;
      if (i.idO()) {
        new StringBuilder("[stopNestedScroll] when reach edge distanceUnconsumed:").append(paramInt1).append(" computeScrollOffset:").append(paramArrayOfInt).append(" curVelocity:").append(localObject1).append(" minFlingVelocity:").append(j).append(" curOffset:").append(i).append(" maxFlingOffset:").append(paramInt2);
      }
      w.ag(paramView);
      if (localOverScroller == null) {
        break;
      }
      localOverScroller.forceFinished(true);
      AppMethodBeat.o(249874);
      return;
    }
    AppMethodBeat.o(249874);
    return;
    label362:
    h(paramView, paramInt1, i, j.b((f)this, paramView, this.Yth));
    AppMethodBeat.o(249874);
    return;
    label390:
    if (paramInt1 > 0)
    {
      j.b((f)this, paramView);
      if (paramInt2 == 0)
      {
        h(paramView, paramInt1, co(paramView), 0);
        AppMethodBeat.o(249874);
        return;
      }
      paramArrayOfInt = this.Ytg;
      if ((paramArrayOfInt == null) || (!paramArrayOfInt.computeScrollOffset()) || (Math.abs(paramArrayOfInt.getCurrVelocity()) < Math.abs(((j)localObject2).c((f)this, paramView))) || (cm(paramView) <= j.b((f)this, paramView, this.Yti)))
      {
        localObject1 = i.YtH;
        i.idO();
        w.ag(paramView);
        if (paramArrayOfInt != null)
        {
          paramArrayOfInt.forceFinished(true);
          AppMethodBeat.o(249874);
          return;
        }
        AppMethodBeat.o(249874);
        return;
      }
      h(paramView, paramInt1, j.b((f)this, paramView, this.Yti), cm(paramView));
    }
    AppMethodBeat.o(249874);
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(249866);
    kotlin.g.b.p.k(paramView, "target");
    kotlin.g.b.p.k(paramArrayOfInt, "consumed");
    int i = paramArrayOfInt[1];
    int j = b(paramView, paramInt1, paramInt2, paramArrayOfInt, paramInt3);
    paramArrayOfInt[1] = j;
    i locali = i.YtH;
    if (i.idO()) {
      new StringBuilder("[onNestedPreScroll]target:").append(paramView.getClass().getName()).append(", dx:").append(paramInt1).append(", dy:").append(paramInt2).append(", consumed: ").append(e.V(paramArrayOfInt)).append(", type: ").append(paramInt3).append(" comsumedBefore:").append(i).append(" comsumedAfter:").append(j);
    }
    AppMethodBeat.o(249866);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(292985);
    if ((parama != null) && (!this.aado.contains(parama))) {
      this.aado.add(parama);
    }
    AppMethodBeat.o(292985);
  }
  
  public boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249852);
    kotlin.g.b.p.k(paramView1, "child");
    kotlin.g.b.p.k(paramView2, "target");
    i locali = i.YtH;
    if (i.idO()) {
      new StringBuilder("[onStartNestedScroll] target:").append(paramView2.getClass().getName()).append(" enable:").append(this.YsE).append(" axes:").append(paramInt1).append(" type:").append(paramInt2).append(" isAtStart:").append(k.iT(paramView1)).append(" isAtEnd:").append(k.iU(paramView1));
    }
    if (!this.YsE)
    {
      AppMethodBeat.o(249852);
      return false;
    }
    this.lastType = paramInt2;
    this.QUr = false;
    if ((paramInt1 & 0x2) != 0)
    {
      AppMethodBeat.o(249852);
      return true;
    }
    AppMethodBeat.o(249852);
    return false;
  }
  
  protected boolean ayS(int paramInt)
  {
    return true;
  }
  
  protected int b(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    AppMethodBeat.i(249868);
    kotlin.g.b.p.k(paramView, "target");
    kotlin.g.b.p.k(paramArrayOfInt, "consumed");
    if (paramInt2 != 0)
    {
      if (paramInt2 < 0)
      {
        j.b((f)this, (View)this);
        paramInt3 = cm(paramView);
        paramInt1 = 0;
      }
      while (paramInt3 < paramInt1)
      {
        paramInt1 = g(paramView, cm(paramView) - paramInt2, paramInt3, paramInt1);
        AppMethodBeat.o(249868);
        return paramInt1;
        j.b((f)this, (View)this);
        paramInt1 = cm(paramView);
        paramInt3 = 0;
      }
    }
    AppMethodBeat.o(249868);
    return 0;
  }
  
  public final void b(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249858);
    kotlin.g.b.p.k(paramView1, "child");
    kotlin.g.b.p.k(paramView2, "target");
    this.oH.F(paramInt1, paramInt2);
    i locali = i.YtH;
    if (i.idO()) {
      new StringBuilder("[onNestedScrollAccepted] target:").append(paramView2).append(" enable:").append(paramView2.isNestedScrollingEnabled()).append(" axes:").append(paramInt1).append(" type:").append(paramInt2);
    }
    this.YtI = paramView2;
    if (paramInt2 == 0) {
      iS(paramView1);
    }
    if (paramInt2 == 0)
    {
      paramView1 = this.Ytg;
      if (paramView1 != null) {
        paramView1.forceFinished(true);
      }
    }
    if ((paramInt1 & 0x2) != 0)
    {
      this.Yth = 2;
      this.Yti = 1;
      AppMethodBeat.o(249858);
      return;
    }
    this.Yth = 8;
    this.Yti = 4;
    AppMethodBeat.o(249858);
  }
  
  public int cm(View paramView)
  {
    AppMethodBeat.i(249884);
    i locali = i.YtH;
    int i = i.idP().cm(paramView);
    AppMethodBeat.o(249884);
    return i;
  }
  
  public final int cn(View paramView)
  {
    AppMethodBeat.i(249886);
    i locali = i.YtH;
    int i = i.idP().cn(paramView);
    AppMethodBeat.o(249886);
    return i;
  }
  
  public final int co(View paramView)
  {
    AppMethodBeat.i(249888);
    i locali = i.YtH;
    int i = i.idP().co(paramView);
    AppMethodBeat.o(249888);
    return i;
  }
  
  public final int getLastType()
  {
    return this.lastType;
  }
  
  protected final LinkedList<e.a> getMBounceOffsetChangedListeners()
  {
    return this.aado;
  }
  
  public final ScrollView getMCompatScrollViewChild()
  {
    return this.YtK;
  }
  
  protected final boolean getMIsEnabled()
  {
    return this.YsE;
  }
  
  public final j getMOverscrollListener()
  {
    return this.YtJ;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(249876);
    int i = this.oH.getNestedScrollAxes();
    AppMethodBeat.o(249876);
    return i;
  }
  
  public void l(View paramView, int paramInt)
  {
    AppMethodBeat.i(249862);
    kotlin.g.b.p.k(paramView, "target");
    Object localObject = i.YtH;
    if (i.idO()) {
      new StringBuilder("[onStopNestedScroll] target:").append(paramView.getClass().getName()).append('@').append(paramView.hashCode()).append(" type:").append(paramInt).append(" lastType:").append(this.lastType).append(" curOffset:").append(cm(paramView)).append(" isFling:").append(this.QUr).append(' ');
    }
    this.oH.bz(paramInt);
    OverScroller localOverScroller = this.Ytg;
    label203:
    label229:
    int i;
    if (paramInt == 0)
    {
      localObject = i.YtH;
      if (i.idO())
      {
        StringBuilder localStringBuilder = new StringBuilder("[onStopNestedScroll] mOverScroller:");
        if (localOverScroller != null)
        {
          localObject = Boolean.valueOf(localOverScroller.computeScrollOffset());
          localStringBuilder = localStringBuilder.append(localObject).append(' ').append("velocity:");
          if (localOverScroller == null) {
            break label285;
          }
          localObject = Float.valueOf(localOverScroller.getCurrVelocity());
          localObject = localStringBuilder.append(localObject).append(" delta:");
          if (localOverScroller == null) {
            break label291;
          }
          paramInt = localOverScroller.getCurrY();
          if (localOverScroller == null) {
            break label296;
          }
          i = localOverScroller.getStartY();
          label240:
          ((StringBuilder)localObject).append(paramInt - i);
        }
      }
      else
      {
        if (cm(paramView) == 0) {
          break label332;
        }
        if (localOverScroller != null) {
          break label301;
        }
        iR(paramView);
      }
    }
    for (;;)
    {
      this.YtI = null;
      AppMethodBeat.o(249862);
      return;
      localObject = null;
      break;
      label285:
      localObject = null;
      break label203;
      label291:
      paramInt = 0;
      break label229;
      label296:
      i = 0;
      break label240;
      label301:
      if (!localOverScroller.computeScrollOffset())
      {
        iR(paramView);
      }
      else if (this.QUr)
      {
        iR(paramView);
        continue;
        label332:
        if ((this.QUr) && (localOverScroller != null) && (localOverScroller.computeScrollOffset()))
        {
          localObject = i.YtH;
          if (this.YtL == null) {
            this.YtL = new b(localOverScroller, paramView);
          }
          paramView = this.YtL;
          if (paramView != null)
          {
            paramView.amh = paramView.Qi.getCurrY();
            paramView.YtO.postOnAnimation((Runnable)paramView);
            continue;
            if (cm(paramView) != 0) {
              iR(paramView);
            }
          }
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(249848);
    boolean bool2;
    label49:
    Object localObject1;
    boolean bool3;
    label89:
    boolean bool4;
    label101:
    int i;
    if (((this.YtI instanceof AbsListView)) || ((this.YtI instanceof ScrollView)))
    {
      bool1 = true;
      if ((this.YtK == null) || (this.YtI != null)) {
        break label332;
      }
      bool2 = true;
      if ((!this.YsE) || ((!bool1) && (!bool2))) {
        break label834;
      }
      if (!bool1) {
        break label338;
      }
      localObject1 = this.YtI;
      if (localObject1 == null) {
        break label513;
      }
      bool3 = k.iT((View)localObject1);
      if (localObject1 == null) {
        break label519;
      }
      bool4 = k.iU((View)localObject1);
      localObject1 = i.YtH;
      if (i.idO())
      {
        localObject1 = new StringBuilder("[onInterceptTouchEvent] action:");
        if (paramMotionEvent == null) {
          break label525;
        }
        i = paramMotionEvent.getAction();
        label133:
        localObject1 = ((StringBuilder)localObject1).append(MotionEvent.actionToString(i)).append(" isAtStart:").append(bool3).append(" isAtEnd:").append(bool4).append(" isCompactView:").append(bool1).append(" isCompactScrollView:").append(bool2).append(" mCurNestedChild!=null：");
        if (this.YtI == null) {
          break label530;
        }
        bool1 = true;
        label204:
        ((StringBuilder)localObject1).append(bool1);
      }
      if ((!bool3) || (!bool4)) {
        break label834;
      }
      localObject1 = localObject2;
      if (paramMotionEvent != null) {
        localObject1 = Integer.valueOf(paramMotionEvent.getAction());
      }
      if (localObject1 != null) {
        break label536;
      }
      label244:
      if (localObject1 != null) {
        break label584;
      }
      label249:
      if (localObject1 != null) {
        break label777;
      }
      label254:
      if (localObject1 != null) {
        break label808;
      }
      label259:
      paramMotionEvent = i.YtH;
      if (i.idO())
      {
        paramMotionEvent = new StringBuilder("[onInterceptTouchEvent] return mOverScrolling||mOpened :");
        if ((!this.qtA) && (!this.qtB)) {
          break label820;
        }
      }
    }
    label513:
    label519:
    label525:
    label530:
    label536:
    label808:
    label820:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramMotionEvent.append(bool1);
      if ((!this.qtA) && (!this.qtB)) {
        break label826;
      }
      AppMethodBeat.o(249848);
      return true;
      bool1 = false;
      break;
      label332:
      bool2 = false;
      break label49;
      label338:
      localObject1 = this.YtK;
      if (localObject1 != null)
      {
        Object localObject3 = (View)localObject1;
        kotlin.g.b.p.k(localObject3, "$this$contains");
        if (paramMotionEvent != null)
        {
          localObject1 = new Rect();
          ((View)localObject3).getGlobalVisibleRect((Rect)localObject1);
          bool3 = ((Rect)localObject1).contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
          if (bool3)
          {
            localObject3 = i.YtH;
            if (i.idO()) {
              new StringBuilder("contains() called with:actualPosition=").append(localObject1).append(" containRes = ").append(bool3).append(" ev = ").append(paramMotionEvent).append(' ');
            }
            i = 1;
            label462:
            if (i != 1) {
              break label507;
            }
            localObject1 = this.YtK;
            if ((localObject1 == null) || (((ScrollView)localObject1).getVisibility() != 0)) {
              break label507;
            }
          }
        }
      }
      label507:
      for (localObject1 = this.YtK;; localObject1 = null)
      {
        localObject1 = (View)localObject1;
        break;
        i = 0;
        break label462;
      }
      bool3 = false;
      break label89;
      bool4 = false;
      break label101;
      i = -1;
      break label133;
      bool1 = false;
      break label204;
      if (((Integer)localObject1).intValue() != 0) {
        break label244;
      }
      this.qtC = ((int)paramMotionEvent.getX());
      this.qtD = ((int)paramMotionEvent.getY());
      this.asF = ((int)paramMotionEvent.getY());
      this.qtA = false;
      this.qtE = true;
      break label259;
      label584:
      if (((Integer)localObject1).intValue() != 2) {
        break label249;
      }
      if (this.qtA)
      {
        paramMotionEvent = i.YtH;
        AppMethodBeat.o(249848);
        return true;
      }
      if (!this.qtE)
      {
        this.qtC = ((int)paramMotionEvent.getX());
        this.qtD = ((int)paramMotionEvent.getY());
        this.asF = ((int)paramMotionEvent.getY());
        this.qtA = false;
        this.qtE = true;
        AppMethodBeat.o(249848);
        return false;
      }
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      int k = this.qtC;
      int m = j - this.qtD;
      if ((Math.abs(m) > this.mTouchSlop) && (Math.abs(m) > Math.abs(i - k)) && (ayS(m))) {}
      for (bool1 = true;; bool1 = false)
      {
        paramMotionEvent = i.YtH;
        i.idO();
        if (bool1)
        {
          this.qtC = i;
          this.qtD = j;
          this.qtA = true;
          this.qtE = false;
        }
        AppMethodBeat.o(249848);
        return bool1;
      }
      if (((Integer)localObject1).intValue() != 3) {
        break label254;
      }
      for (;;)
      {
        this.qtA = false;
        this.qtE = false;
        paramMotionEvent = i.YtH;
        AppMethodBeat.o(249848);
        return false;
        if (((Integer)localObject1).intValue() != 1) {
          break;
        }
      }
    }
    label777:
    label826:
    AppMethodBeat.o(249848);
    return false;
    label834:
    bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(249848);
    return bool1;
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(249878);
    kotlin.g.b.p.k(paramView, "target");
    i locali = i.YtH;
    if (i.idO()) {
      new StringBuilder("[onNestedFling] velocityX:").append(paramFloat1).append(" velocityY:").append(paramFloat2).append(" consumed:").append(paramBoolean);
    }
    paramBoolean = super.onNestedFling(paramView, paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(249878);
    return paramBoolean;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(249880);
    kotlin.g.b.p.k(paramView, "target");
    Object localObject = i.YtH;
    if (i.idO()) {
      new StringBuilder("[onNestedPreFling] velocityX:").append(paramFloat1).append(" velocityY:").append(paramFloat2).append(" velocityY:").append(paramFloat2);
    }
    if (this.Ytg == null) {
      this.Ytg = new OverScroller(getContext());
    }
    localObject = this.Ytg;
    if (localObject != null) {
      ((OverScroller)localObject).fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
    }
    this.QUr = true;
    boolean bool = super.onNestedPreFling(paramView, paramFloat1, paramFloat2);
    AppMethodBeat.o(249880);
    return bool;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(249875);
    kotlin.g.b.p.k(paramView, "target");
    kotlin.g.b.p.k(paramArrayOfInt, "consumed");
    a(paramView, paramInt1, paramInt2, paramArrayOfInt, 0);
    AppMethodBeat.o(249875);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(249864);
    kotlin.g.b.p.k(paramView, "target");
    a(paramView, paramInt1, paramInt2, paramInt3, paramInt4, 0);
    AppMethodBeat.o(249864);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(249860);
    kotlin.g.b.p.k(paramView1, "child");
    kotlin.g.b.p.k(paramView2, "target");
    b(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(249860);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(249854);
    kotlin.g.b.p.k(paramView1, "child");
    kotlin.g.b.p.k(paramView2, "target");
    boolean bool = a(paramView1, paramView2, paramInt, 0);
    AppMethodBeat.o(249854);
    return bool;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(249863);
    kotlin.g.b.p.k(paramView, "target");
    l(paramView, 0);
    AppMethodBeat.o(249863);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(249849);
    kotlin.g.b.p.k(paramMotionEvent, "event");
    i locali = i.YtH;
    if (i.idO()) {
      new StringBuilder("[onTouchEvent] action:").append(MotionEvent.actionToString(paramMotionEvent.getAction()));
    }
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
    {
      paramMotionEvent = i.YtH;
      AppMethodBeat.o(249849);
      return false;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(249849);
      return bool;
      if ((this.qtA) || (this.qtB))
      {
        if (!this.qtE)
        {
          this.qtD = ((int)paramMotionEvent.getY());
          this.qtC = ((int)paramMotionEvent.getX());
          this.asF = ((int)paramMotionEvent.getY());
          this.qtE = true;
          iS((View)this);
          paramMotionEvent = this.Ytg;
          if (paramMotionEvent != null) {
            paramMotionEvent.forceFinished(true);
          }
          paramMotionEvent = i.YtH;
          AppMethodBeat.o(249849);
          return true;
        }
        int i = this.qtD - (int)paramMotionEvent.getY();
        this.qtD = ((int)paramMotionEvent.getY());
        int j = i - b((View)this, 0, i, new int[2], 0);
        if (j != 0) {
          a((View)this, j, 0, new int[2]);
        }
        paramMotionEvent = i.YtH;
        if (i.idO()) {
          new StringBuilder("[onTouchEvent] real diff:").append(i).append(" left diff:").append(j);
        }
        AppMethodBeat.o(249849);
        return true;
        this.qtE = false;
        this.qtA = false;
        l((View)this, 0);
      }
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(249846);
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    i locali = i.YtH;
    i.idO();
    AppMethodBeat.o(249846);
  }
  
  public final void setBounce(boolean paramBoolean)
  {
    this.YsE = paramBoolean;
  }
  
  public final void setFlinging(boolean paramBoolean)
  {
    this.QUr = paramBoolean;
  }
  
  public final void setLastType(int paramInt)
  {
    this.lastType = paramInt;
  }
  
  public final void setMCompatScrollViewChild(ScrollView paramScrollView)
  {
    this.YtK = paramScrollView;
  }
  
  protected final void setMIsEnabled(boolean paramBoolean)
  {
    this.YsE = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView$FlingRunnable;", "Ljava/lang/Runnable;", "mScroller", "Landroid/widget/OverScroller;", "target", "Landroid/view/View;", "(Lcom/tencent/mm/ui/widget/pulldown/NestedBounceView;Landroid/widget/OverScroller;Landroid/view/View;)V", "mLastFlingY", "", "getMScroller", "()Landroid/widget/OverScroller;", "getTarget", "()Landroid/view/View;", "run", "", "start", "weui-native-android-lib_release"})
  public final class b
    implements Runnable
  {
    final OverScroller Qi;
    private final View YtN;
    int amh;
    
    public b(View paramView)
    {
      AppMethodBeat.i(249719);
      this.Qi = paramView;
      this.YtN = localObject;
      this.amh = this.Qi.getCurrY();
      AppMethodBeat.o(249719);
    }
    
    public final void run()
    {
      AppMethodBeat.i(249718);
      OverScroller localOverScroller = this.Qi;
      boolean bool = localOverScroller.computeScrollOffset();
      int i = localOverScroller.getCurrY();
      int j = i - this.amh;
      if (((this.YtN instanceof AbsListView)) || ((this.YtN instanceof ScrollView)))
      {
        i locali = i.YtH;
        if (i.idO()) {
          new StringBuilder("[fling] hasMore:").append(bool).append(" velocity:").append(localOverScroller.getCurrVelocity()).append(" delta:").append(j).append(" mLastFlingY:").append(this.amh).append(" y:").append(i).append(" isAtStart:").append(k.iT(this.YtN)).append(" isAtEnd:").append(k.iU(this.YtN));
        }
        if (bool)
        {
          if ((j < 0) && (k.iT(this.YtN))) {
            NestedBounceView.this.a(this.YtN, j, 1, new int[2]);
          }
          for (;;)
          {
            this.amh = i;
            NestedBounceView.this.postOnAnimation((Runnable)this);
            AppMethodBeat.o(249718);
            return;
            if ((j > 0) && (k.iU(this.YtN))) {
              NestedBounceView.this.a(this.YtN, j, 1, new int[2]);
            }
          }
        }
        NestedBounceView.this.l(this.YtN, 1);
      }
      AppMethodBeat.o(249718);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.pulldown.NestedBounceView
 * JD-Core Version:    0.7.0.1
 */