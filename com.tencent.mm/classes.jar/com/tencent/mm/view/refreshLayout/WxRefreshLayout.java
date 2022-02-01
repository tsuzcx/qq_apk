package com.tencent.mm.view.refreshLayout;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.g.k;
import androidx.core.g.n;
import androidx.core.g.o;
import androidx.core.g.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.view.refreshLayout.b.f;
import com.tencent.mm.view.refreshLayout.b.g;
import com.tencent.mm.view.refreshLayout.e.a.a;
import com.tencent.mm.view.refreshLayout.g.b.a;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/refreshLayout/WxRefreshLayout;", "Landroid/view/ViewGroup;", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshLayout;", "Landroidx/core/view/NestedScrollingParent;", "Landroidx/core/view/NestedScrollingChild;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animHelper", "Lcom/tencent/mm/view/refreshLayout/widget/RefreshAnimationHelper;", "baseKernel", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshKernel;", "cValues", "Lcom/tencent/mm/view/refreshLayout/config/CommonValue;", "commonConfig", "Lcom/tencent/mm/view/refreshLayout/config/CommonConfig;", "getCommonConfig", "()Lcom/tencent/mm/view/refreshLayout/config/CommonConfig;", "setCommonConfig", "(Lcom/tencent/mm/view/refreshLayout/config/CommonConfig;)V", "contentPlugin", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshContentPlugin;", "defaultMarginLP", "Landroid/view/ViewGroup$MarginLayoutParams;", "falsifyEvent", "Landroid/view/MotionEvent;", "footerConfig", "Lcom/tencent/mm/view/refreshLayout/config/FooterConfig;", "getFooterConfig", "()Lcom/tencent/mm/view/refreshLayout/config/FooterConfig;", "setFooterConfig", "(Lcom/tencent/mm/view/refreshLayout/config/FooterConfig;)V", "footerPlugin", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshPlugin;", "headerConfig", "Lcom/tencent/mm/view/refreshLayout/config/HeaderConfig;", "getHeaderConfig", "()Lcom/tencent/mm/view/refreshLayout/config/HeaderConfig;", "setHeaderConfig", "(Lcom/tencent/mm/view/refreshLayout/config/HeaderConfig;)V", "headerPlugin", "mainHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "nestedChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "nestedInProgress", "", "nestedParentHelper", "Landroidx/core/view/NestedScrollingParentHelper;", "onMultiAction", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshMultiAction;", "getOnMultiAction", "()Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshMultiAction;", "setOnMultiAction", "(Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshMultiAction;)V", "onSimpleAction", "Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "getOnSimpleAction", "()Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;", "setOnSimpleAction", "(Lcom/tencent/mm/view/refreshLayout/listener/OnRefreshAction;)V", "parentOffsetInWindow", "", "reboundInterpolator", "Landroid/view/animation/Interpolator;", "scrollBoundaryDecider", "Lcom/tencent/mm/view/refreshLayout/interfaces/IScrollBoundaryDecider;", "scroller", "Landroid/widget/Scroller;", "spinnerHelper", "Lcom/tencent/mm/view/refreshLayout/widget/RefreshSpinnerHelper;", "stateCenter", "Lcom/tencent/mm/view/refreshLayout/widget/LayoutStateCenter;", "totalUnconsumed", "velocityTracker", "Landroid/view/VelocityTracker;", "animSpinner", "Landroid/animation/ValueAnimator;", "endSpinner", "autoRefresh", "delayed", "duration", "dragRate", "", "computeScroll", "", "dispatchNestedFling", "velocityX", "velocityY", "consumed", "dispatchNestedPreFling", "dispatchNestedPreScroll", "dx", "dy", "offsetInWindow", "dispatchNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "dispatchTouchEvent", "event", "finishLoadMore", "success", "noMoreData", "finishLoadMoreWithNoMoreData", "finishRefresh", "finishRefreshWithNoMoreData", "getAnimHelper", "getContentView", "getInterpolator", "getLayout", "getLoadMoreFooter", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshFooter;", "getMainHandler", "getNestedScrollAxes", "getRefreshHeader", "Lcom/tencent/mm/view/refreshLayout/interfaces/IRefreshHeader;", "getState", "Lcom/tencent/mm/view/refreshLayout/status/RefreshState;", "hasNestedScrollingParent", "init", "isEnableRefreshOrLoadMore", "enable", "isEnableTranslationContent", "internal", "isNestedScrollingEnabled", "moveSpinner", "spinner", "isDragging", "moveSpinnerInfinitely", "outSpinner", "notifyOnLoadMore", "notifyRefreshFinish", "notifyRefreshStart", "isAuto", "notifyStateChanged", "state", "onAttachedToWindow", "onDetachedFromWindow", "onFinishInflate", "onLayout", "changed", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onNestedFling", "target", "Landroid/view/View;", "onNestedPreFling", "onNestedPreScroll", "onNestedScroll", "onNestedScrollAccepted", "child", "axes", "onStartNestedScroll", "nestedScrollAxes", "onStopNestedScroll", "requestDisallowInterceptTouchEvent", "disallowIntercept", "setContentView", "content", "setDirectLoadingState", "triggerLoadMoreEvent", "setEnableLoadMoreWhenContentNotFull", "enabled", "setEnableNestedScroll", "setFooterHeight", "height", "setFooterMaxDragRate", "rate", "setHeaderHeight", "setHeaderMaxDragRate", "setLoadMoreFooter", "footer", "setLoadingState", "setNestedScrollingEnabled", "setNoMoreData", "setReboundInterpolator", "interpolator", "setRefreshHeader", "header", "setRefreshingState", "setScrollBoundaryDecider", "boundary", "startFlingIfNeed", "flingVelocity", "startNestedScroll", "stopNestedScroll", "Companion", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public class WxRefreshLayout
  extends ViewGroup
  implements k, o, com.tencent.mm.view.refreshLayout.b.e
{
  public static final WxRefreshLayout.a agPe;
  private int[] EHE;
  private Scroller MiR;
  private f agPf;
  public f agPg;
  private com.tencent.mm.view.refreshLayout.b.a agPh;
  public final com.tencent.mm.view.refreshLayout.b.d agPi;
  private final com.tencent.mm.view.refreshLayout.g.a agPj;
  public com.tencent.mm.view.refreshLayout.a.a agPk;
  public com.tencent.mm.view.refreshLayout.a.d agPl;
  public com.tencent.mm.view.refreshLayout.a.c agPm;
  public com.tencent.mm.view.refreshLayout.a.b agPn;
  private com.tencent.mm.view.refreshLayout.d.b agPo;
  private com.tencent.mm.view.refreshLayout.d.c agPp;
  private Interpolator agPq;
  private g agPr;
  public final ViewGroup.MarginLayoutParams agPs;
  private MotionEvent agPt;
  private final com.tencent.mm.view.refreshLayout.g.e agPu;
  private final com.tencent.mm.view.refreshLayout.g.b agPv;
  private int agPw;
  private boolean agPx;
  private n agPy;
  private r agPz;
  private VelocityTracker doL;
  private final MMHandler mainHandler;
  
  static
  {
    AppMethodBeat.i(235201);
    agPe = new WxRefreshLayout.a((byte)0);
    AppMethodBeat.o(235201);
  }
  
  public WxRefreshLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235099);
    this.agPi = ((com.tencent.mm.view.refreshLayout.b.d)new com.tencent.mm.view.refreshLayout.g.d(this));
    this.agPj = new com.tencent.mm.view.refreshLayout.g.a(this);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.agPs = new ViewGroup.MarginLayoutParams(-1, -2);
    this.agPu = new com.tencent.mm.view.refreshLayout.g.e(this, this.agPj, this.agPs);
    this.agPv = new com.tencent.mm.view.refreshLayout.g.b(this, this.agPj);
    this.EHE = new int[2];
    this.agPy = new n((View)this);
    this.agPz = new r();
    f(paramAttributeSet);
    AppMethodBeat.o(235099);
  }
  
  public WxRefreshLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235105);
    this.agPi = ((com.tencent.mm.view.refreshLayout.b.d)new com.tencent.mm.view.refreshLayout.g.d(this));
    this.agPj = new com.tencent.mm.view.refreshLayout.g.a(this);
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.agPs = new ViewGroup.MarginLayoutParams(-1, -2);
    this.agPu = new com.tencent.mm.view.refreshLayout.g.e(this, this.agPj, this.agPs);
    this.agPv = new com.tencent.mm.view.refreshLayout.g.b(this, this.agPj);
    this.EHE = new int[2];
    this.agPy = new n((View)this);
    this.agPz = new r();
    f(paramAttributeSet);
    AppMethodBeat.o(235105);
  }
  
  private static final void a(WxRefreshLayout paramWxRefreshLayout, float paramFloat, int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235162);
    s.u(paramWxRefreshLayout, "this$0");
    if (!paramWxRefreshLayout.agPj.jNT())
    {
      AppMethodBeat.o(235162);
      return;
    }
    paramWxRefreshLayout.agPv.jNU();
    View localView = (View)paramWxRefreshLayout;
    Object localObject3 = paramWxRefreshLayout.agPn;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj = (localView.getMeasuredWidth() / 2.0F);
    paramWxRefreshLayout.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQQ);
    float f1;
    float f2;
    if (paramWxRefreshLayout.getHeaderConfig().headerHeight == 0)
    {
      f1 = paramWxRefreshLayout.getHeaderConfig().agQo;
      f2 = paramFloat;
      if (paramFloat < 10.0F) {
        f2 = paramFloat * f1;
      }
      localObject3 = paramWxRefreshLayout.agPv;
      localObject1 = paramWxRefreshLayout.agPn;
      if (localObject1 != null) {
        break label263;
      }
      s.bIx("cValues");
      localObject1 = localObject2;
    }
    label263:
    for (;;)
    {
      localObject1 = ValueAnimator.ofInt(new int[] { ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU, (int)f2 });
      ((ValueAnimator)localObject1).setDuration(paramInt);
      ((ValueAnimator)localObject1).setInterpolator((TimeInterpolator)new com.tencent.mm.view.refreshLayout.c.a());
      ((ValueAnimator)localObject1).addUpdateListener(new WxRefreshLayout..ExternalSyntheticLambda0(paramWxRefreshLayout));
      ((ValueAnimator)localObject1).addListener((Animator.AnimatorListener)new b(paramWxRefreshLayout));
      ((ValueAnimator)localObject1).start();
      paramWxRefreshLayout = ah.aiuX;
      ((com.tencent.mm.view.refreshLayout.g.b)localObject3).agRm = ((ValueAnimator)localObject1);
      AppMethodBeat.o(235162);
      return;
      f1 = paramWxRefreshLayout.getHeaderConfig().headerHeight;
      break;
    }
  }
  
  private static final void a(WxRefreshLayout paramWxRefreshLayout, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(235153);
    s.u(paramWxRefreshLayout, "this$0");
    if ((paramWxRefreshLayout.agPv.agRm != null) && (paramWxRefreshLayout.agPf != null))
    {
      paramWxRefreshLayout = paramWxRefreshLayout.agPu;
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramWxRefreshLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(235153);
        throw paramWxRefreshLayout;
      }
      paramWxRefreshLayout.y(((Integer)paramValueAnimator).intValue(), true, true);
    }
    AppMethodBeat.o(235153);
  }
  
  private final boolean ey(float paramFloat)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235124);
    float f;
    if (paramFloat == 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        localObject3 = this.agPn;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        paramFloat = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQd;
      }
      f = paramFloat;
      if (Build.VERSION.SDK_INT > 27)
      {
        localObject1 = this.agPh;
        f = paramFloat;
        if (localObject1 != null)
        {
          if (getScaleY() != -1.0F) {
            break label304;
          }
          i = 1;
          label88:
          f = paramFloat;
          if (i != 0) {
            if (((com.tencent.mm.view.refreshLayout.b.a)localObject1).getView().getScaleY() != -1.0F) {
              break label309;
            }
          }
        }
      }
    }
    label304:
    label309:
    for (int i = 1;; i = 0)
    {
      f = paramFloat;
      if (i != 0) {
        f = -paramFloat;
      }
      paramFloat = Math.abs(f);
      localObject3 = this.agPn;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("cValues");
        localObject1 = null;
      }
      if (paramFloat <= ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPV) {
        break label619;
      }
      localObject3 = this.agPn;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("cValues");
        localObject1 = null;
      }
      if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU * f >= 0.0F) {
        break label335;
      }
      if ((!this.agPj.jME()) && (!this.agPj.isLoading()))
      {
        localObject3 = this.agPn;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU >= 0) {
          break label314;
        }
        localObject3 = this.agPn;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (!((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQh) {
          break label314;
        }
      }
      this.agPv.eB(f);
      AppMethodBeat.o(235124);
      return true;
      i = 0;
      break;
      i = 0;
      break label88;
    }
    label314:
    if (this.agPj.agRi.agQK)
    {
      AppMethodBeat.o(235124);
      return true;
    }
    label335:
    if (f < 0.0F)
    {
      if ((!getCommonConfig().agPM) || ((!getCommonConfig().Jcx) && (!getCommonConfig().agPN))) {
        if (this.agPj.isLoading())
        {
          localObject3 = this.agPn;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU >= 0) {}
        }
        else if ((getCommonConfig().agPF) && (Oc(getCommonConfig().Jcx))) {}
      }
    }
    else
    {
      if (f <= 0.0F) {
        break label619;
      }
      if (((!getCommonConfig().agPM) || (!getCommonConfig().agJq)) && (!getCommonConfig().agPN))
      {
        if (!this.agPj.jME()) {
          break label619;
        }
        localObject3 = this.agPn;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU > 0) {
          break label619;
        }
      }
    }
    Object localObject3 = this.agPn;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQe = false;
    localObject3 = this.MiR;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("scroller");
      localObject1 = null;
    }
    ((Scroller)localObject1).fling(0, 0, 0, (int)-f, 0, 0, -2147483647, 2147483647);
    localObject1 = this.MiR;
    if (localObject1 == null)
    {
      s.bIx("scroller");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((Scroller)localObject1).computeScrollOffset();
      invalidate();
      label619:
      AppMethodBeat.o(235124);
      return false;
    }
  }
  
  private final void f(AttributeSet paramAttributeSet)
  {
    Object localObject2 = null;
    AppMethodBeat.i(235113);
    this.MiR = new Scroller(getContext());
    Object localObject1 = VelocityTracker.obtain();
    s.s(localObject1, "obtain()");
    this.doL = ((VelocityTracker)localObject1);
    this.agPq = ((Interpolator)new com.tencent.mm.view.refreshLayout.c.a());
    localObject1 = new com.tencent.mm.view.refreshLayout.a.b();
    Object localObject3 = getContext();
    s.s(localObject3, "context");
    this.agPn = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).nP((Context)localObject3);
    Object localObject4 = this.agPj;
    localObject3 = this.agPn;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    ((com.tencent.mm.view.refreshLayout.g.a)localObject4).a((com.tencent.mm.view.refreshLayout.a.b)localObject1);
    localObject4 = this.agPv;
    localObject3 = this.agPn;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    ((com.tencent.mm.view.refreshLayout.g.b)localObject4).a((com.tencent.mm.view.refreshLayout.a.b)localObject1);
    localObject3 = this.agPu;
    localObject1 = this.agPn;
    if (localObject1 == null)
    {
      s.bIx("cValues");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((com.tencent.mm.view.refreshLayout.g.e)localObject3).a((com.tencent.mm.view.refreshLayout.a.b)localObject1);
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, a.m.WxRefreshLayout);
      s.s(paramAttributeSet, "context.obtainStyledAttr…tyleable.WxRefreshLayout)");
      if (!paramAttributeSet.hasValue(a.m.WxRefreshLayout_android_clipToPadding)) {
        super.setClipToPadding(false);
      }
      if (!paramAttributeSet.hasValue(a.m.WxRefreshLayout_android_clipChildren)) {
        super.setClipChildren(false);
      }
      setCommonConfig(new com.tencent.mm.view.refreshLayout.a.a().e(paramAttributeSet));
      setHeaderConfig(new com.tencent.mm.view.refreshLayout.a.d().g(paramAttributeSet));
      setFooterConfig(new com.tencent.mm.view.refreshLayout.a.c().f(paramAttributeSet));
      this.agPy.setNestedScrollingEnabled(getCommonConfig().agPP);
      paramAttributeSet.recycle();
      AppMethodBeat.o(235113);
      return;
    }
  }
  
  private final boolean j(int paramInt1, int paramInt2, float paramFloat)
  {
    AppMethodBeat.i(235142);
    if ((this.agPj.jNI()) && (Oc(getCommonConfig().agJq)))
    {
      WxRefreshLayout..ExternalSyntheticLambda1 localExternalSyntheticLambda1 = new WxRefreshLayout..ExternalSyntheticLambda1(this, paramFloat, paramInt2);
      this.agPj.d(com.tencent.mm.view.refreshLayout.e.b.agQV);
      if (paramInt1 > 0) {
        this.mainHandler.postDelayed(localExternalSyntheticLambda1, paramInt1);
      }
      for (;;)
      {
        AppMethodBeat.o(235142);
        return true;
        localExternalSyntheticLambda1.run();
      }
    }
    AppMethodBeat.o(235142);
    return false;
  }
  
  private final com.tencent.mm.view.refreshLayout.b.e w(int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(235129);
    int i = paramInt << 16 >> 16;
    Object localObject = (Runnable)new d(this, paramInt >> 16, paramBoolean2, paramBoolean1);
    if (i > 0) {
      this.mainHandler.postDelayed((Runnable)localObject, i);
    }
    for (;;)
    {
      localObject = (com.tencent.mm.view.refreshLayout.b.e)this;
      AppMethodBeat.o(235129);
      return localObject;
      ((Runnable)localObject).run();
    }
  }
  
  private final com.tencent.mm.view.refreshLayout.b.e x(int paramInt, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(235137);
    int i = paramInt << 16 >> 16;
    Object localObject = (Runnable)new c(this, paramInt >> 16, paramBoolean2, paramBoolean1);
    if (i > 0) {
      this.mainHandler.postDelayed((Runnable)localObject, i);
    }
    for (;;)
    {
      localObject = (com.tencent.mm.view.refreshLayout.b.e)this;
      AppMethodBeat.o(235137);
      return localObject;
      ((Runnable)localObject).run();
    }
  }
  
  public final boolean Oc(boolean paramBoolean)
  {
    AppMethodBeat.i(235303);
    if ((paramBoolean) && (!getCommonConfig().agPO))
    {
      AppMethodBeat.o(235303);
      return true;
    }
    AppMethodBeat.o(235303);
    return false;
  }
  
  public final com.tencent.mm.view.refreshLayout.b.e Od(boolean paramBoolean)
  {
    AppMethodBeat.i(235338);
    if (paramBoolean)
    {
      long l = System.currentTimeMillis();
      com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
      localObject = localb;
      if (localb == null)
      {
        s.bIx("cValues");
        localObject = null;
      }
      localObject = w(Math.min(Math.max(0, 300 - (int)(l - ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQf)), 300) << 16, true, false);
      AppMethodBeat.o(235338);
      return localObject;
    }
    Object localObject = w(0, false, false);
    AppMethodBeat.o(235338);
    return localObject;
  }
  
  public final com.tencent.mm.view.refreshLayout.b.e Oe(boolean paramBoolean)
  {
    AppMethodBeat.i(235348);
    long l1 = System.currentTimeMillis();
    com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
    Object localObject = localb;
    if (localb == null)
    {
      s.bIx("cValues");
      localObject = null;
    }
    long l2 = ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQf;
    if (paramBoolean) {}
    for (int i = Math.min(Math.max(0, 300 - (int)(l1 - l2)), 300) << 16;; i = 0)
    {
      localObject = x(i, paramBoolean, false);
      AppMethodBeat.o(235348);
      return localObject;
    }
  }
  
  public final com.tencent.mm.view.refreshLayout.b.e Of(boolean paramBoolean)
  {
    com.tencent.mm.view.refreshLayout.a.b localb2 = null;
    com.tencent.mm.view.refreshLayout.a.b localb1 = null;
    AppMethodBeat.i(235362);
    if ((this.agPj.jME()) && (paramBoolean)) {
      jNx();
    }
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              localObject = (com.tencent.mm.view.refreshLayout.b.e)this;
              AppMethodBeat.o(235362);
              return localObject;
              if ((!this.agPj.isLoading()) || (!paramBoolean)) {
                break;
              }
              jNy();
            }
            localb3 = this.agPn;
            localObject = localb3;
            if (localb3 == null)
            {
              s.bIx("cValues");
              localObject = null;
            }
          } while (((com.tencent.mm.view.refreshLayout.a.b)localObject).agQh == paramBoolean);
          com.tencent.mm.view.refreshLayout.a.b localb3 = this.agPn;
          localObject = localb3;
          if (localb3 == null)
          {
            s.bIx("cValues");
            localObject = null;
          }
          ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQh = paramBoolean;
        } while (!(this.agPg instanceof com.tencent.mm.view.refreshLayout.b.b));
        localObject = this.agPg;
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.refreshLayout.interfaces.IRefreshFooter");
          AppMethodBeat.o(235362);
          throw ((Throwable)localObject);
        }
        if (!((com.tencent.mm.view.refreshLayout.b.b)localObject).tk(paramBoolean)) {
          break;
        }
        localb2 = this.agPn;
        localObject = localb2;
        if (localb2 == null)
        {
          s.bIx("cValues");
          localObject = null;
        }
        ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQi = true;
        localb2 = this.agPn;
        localObject = localb2;
        if (localb2 == null)
        {
          s.bIx("cValues");
          localObject = null;
        }
      } while ((!((com.tencent.mm.view.refreshLayout.a.b)localObject).agQh) || (!getCommonConfig().agPI));
      localb2 = this.agPn;
      localObject = localb2;
      if (localb2 == null)
      {
        s.bIx("cValues");
        localObject = null;
      }
    } while (((com.tencent.mm.view.refreshLayout.a.b)localObject).agPU <= 0);
    Object localObject = this.agPg;
    if (localObject == null)
    {
      localObject = null;
      label279:
      if ((localObject != com.tencent.mm.view.refreshLayout.e.c.agRc) || (!Oc(getCommonConfig().Jcx)) || (!a(getCommonConfig().agJq, this.agPf))) {
        break label370;
      }
      localObject = this.agPg;
      if (localObject != null) {
        break label372;
      }
      localObject = null;
      label329:
      if (localObject == null) {
        break label380;
      }
      localb2 = this.agPn;
      if (localb2 != null) {
        break label382;
      }
      s.bIx("cValues");
    }
    for (;;)
    {
      ((View)localObject).setTranslationY(localb1.agPU);
      break;
      localObject = ((f)localObject).getSpinnerStyle();
      break label279;
      label370:
      break;
      label372:
      localObject = ((f)localObject).getView();
      break label329;
      label380:
      break;
      label382:
      localb1 = localb2;
    }
    localObject = this.agPn;
    if (localObject == null)
    {
      s.bIx("cValues");
      localObject = localb2;
    }
    for (;;)
    {
      ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQi = false;
      break;
    }
  }
  
  public final com.tencent.mm.view.refreshLayout.b.e a(com.tencent.mm.view.refreshLayout.b.b paramb)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235321);
    s.u(paramb, "footer");
    Object localObject2 = this.agPg;
    if (localObject2 != null) {
      super.removeView(((f)localObject2).getView());
    }
    this.agPg = ((f)paramb);
    localObject2 = this.agPn;
    paramb = (com.tencent.mm.view.refreshLayout.b.b)localObject2;
    if (localObject2 == null)
    {
      s.bIx("cValues");
      paramb = null;
    }
    paramb.agPX = false;
    paramb = this.agPn;
    if (paramb == null)
    {
      s.bIx("cValues");
      paramb = (com.tencent.mm.view.refreshLayout.b.b)localObject1;
      paramb.agQi = false;
      paramb = getFooterConfig();
      localObject1 = com.tencent.mm.view.refreshLayout.e.a.agQt;
      paramb.a(com.tencent.mm.view.refreshLayout.e.a.jNC());
      getCommonConfig().Jcx = true;
      paramb = new ViewGroup.MarginLayoutParams(-1, -2);
      localObject1 = this.agPg;
      if (localObject1 != null)
      {
        if (!((f)localObject1).getSpinnerStyle().agRa) {
          break label178;
        }
        super.addView(((f)localObject1).getView(), getChildCount(), (ViewGroup.LayoutParams)paramb);
      }
    }
    for (;;)
    {
      paramb = (com.tencent.mm.view.refreshLayout.b.e)this;
      AppMethodBeat.o(235321);
      return paramb;
      break;
      label178:
      super.addView(((f)localObject1).getView(), 0, (ViewGroup.LayoutParams)paramb);
    }
  }
  
  public final com.tencent.mm.view.refreshLayout.b.e a(com.tencent.mm.view.refreshLayout.b.c paramc)
  {
    AppMethodBeat.i(235313);
    s.u(paramc, "header");
    Object localObject = this.agPf;
    if (localObject != null) {
      super.removeView(((f)localObject).getView());
    }
    this.agPf = ((f)paramc);
    getCommonConfig().agJq = true;
    paramc = getHeaderConfig();
    localObject = com.tencent.mm.view.refreshLayout.e.a.agQt;
    paramc.b(com.tencent.mm.view.refreshLayout.e.a.jNC());
    paramc = new ViewGroup.MarginLayoutParams(-1, -2);
    localObject = this.agPf;
    if (localObject != null)
    {
      if (!((f)localObject).getSpinnerStyle().agRa) {
        break label127;
      }
      super.addView(((f)localObject).getView(), getChildCount(), (ViewGroup.LayoutParams)paramc);
    }
    for (;;)
    {
      paramc = (com.tencent.mm.view.refreshLayout.b.e)this;
      AppMethodBeat.o(235313);
      return paramc;
      label127:
      super.addView(((f)localObject).getView(), 0, (ViewGroup.LayoutParams)paramc);
    }
  }
  
  public final void a(com.tencent.mm.view.refreshLayout.e.b paramb)
  {
    AppMethodBeat.i(235297);
    s.u(paramb, "state");
    Object localObject = this.agPf;
    if (localObject != null) {
      ((f)localObject).a((com.tencent.mm.view.refreshLayout.b.e)this, this.agPj.agRi, paramb);
    }
    localObject = this.agPg;
    if (localObject != null) {
      ((f)localObject).a((com.tencent.mm.view.refreshLayout.b.e)this, this.agPj.agRi, paramb);
    }
    if (paramb == com.tencent.mm.view.refreshLayout.e.b.agQL)
    {
      localObject = this.agPn;
      paramb = (com.tencent.mm.view.refreshLayout.e.b)localObject;
      if (localObject == null)
      {
        s.bIx("cValues");
        paramb = null;
      }
      paramb.agPX = false;
    }
    AppMethodBeat.o(235297);
  }
  
  public final boolean a(boolean paramBoolean, f paramf)
  {
    AppMethodBeat.i(235302);
    if ((paramBoolean) || (getCommonConfig().agPO) || (paramf == null) || (paramf.getSpinnerStyle() == com.tencent.mm.view.refreshLayout.e.c.agRd))
    {
      AppMethodBeat.o(235302);
      return true;
    }
    AppMethodBeat.o(235302);
    return false;
  }
  
  public final ValueAnimator aGm(int paramInt)
  {
    AppMethodBeat.i(235306);
    com.tencent.mm.view.refreshLayout.g.b localb = this.agPv;
    Interpolator localInterpolator = this.agPq;
    Object localObject = localInterpolator;
    if (localInterpolator == null)
    {
      s.bIx("reboundInterpolator");
      localObject = null;
    }
    localObject = localb.a(paramInt, 0, (Interpolator)localObject, getCommonConfig().reboundDuration);
    AppMethodBeat.o(235306);
    return localObject;
  }
  
  public final boolean autoRefresh()
  {
    AppMethodBeat.i(235368);
    com.tencent.mm.view.refreshLayout.a.b localb2 = this.agPn;
    com.tencent.mm.view.refreshLayout.a.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("cValues");
      localb1 = null;
    }
    if (localb1.agQg) {}
    for (int i = 0;; i = 400)
    {
      boolean bool = j(i, getCommonConfig().reboundDuration, (getHeaderConfig().agQn + getHeaderConfig().agQo) / 2.0F);
      AppMethodBeat.o(235368);
      return bool;
    }
  }
  
  public void computeScroll()
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(235250);
    Object localObject4 = this.MiR;
    Object localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("scroller");
      localObject1 = null;
    }
    if (((Scroller)localObject1).computeScrollOffset())
    {
      localObject4 = this.MiR;
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        s.bIx("scroller");
        localObject1 = null;
      }
      int i = ((Scroller)localObject1).getFinalY();
      localObject1 = this.agPh;
      boolean bool1;
      boolean bool2;
      label101:
      float f;
      if (localObject1 == null)
      {
        bool1 = false;
        localObject1 = this.agPh;
        if (localObject1 != null) {
          break label330;
        }
        bool2 = false;
        if (((i >= 0) || ((!getCommonConfig().agJq) && (!getCommonConfig().agPN)) || (!bool1)) && ((i <= 0) || ((!getCommonConfig().Jcx) && (!getCommonConfig().agPN)) || (!bool2))) {
          break label679;
        }
        localObject3 = this.agPn;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQe)
        {
          if (i <= 0) {
            break label342;
          }
          localObject3 = this.MiR;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("scroller");
            localObject1 = null;
          }
          f = -((Scroller)localObject1).getCurrVelocity();
          label225:
          localObject4 = this.agPv;
          if (((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRm == null)
          {
            if ((f <= 0.0F) || (!((com.tencent.mm.view.refreshLayout.g.b)localObject4).agPj.jME())) {
              break label375;
            }
            ((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRl = ((Runnable)new b.a((com.tencent.mm.view.refreshLayout.g.b)localObject4, f, ((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.getHeaderConfig().headerHeight));
          }
        }
        label285:
        localObject1 = this.MiR;
        if (localObject1 != null) {
          break label676;
        }
        s.bIx("scroller");
        localObject1 = localObject2;
      }
      label676:
      for (;;)
      {
        ((Scroller)localObject1).forceFinished(true);
        AppMethodBeat.o(235250);
        return;
        bool1 = ((com.tencent.mm.view.refreshLayout.b.a)localObject1).jNA();
        break;
        label330:
        bool2 = ((com.tencent.mm.view.refreshLayout.b.a)localObject1).egB();
        break label101;
        label342:
        localObject3 = this.MiR;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("scroller");
          localObject1 = null;
        }
        f = ((Scroller)localObject1).getCurrVelocity();
        break label225;
        label375:
        if (f < 0.0F)
        {
          if (!((com.tencent.mm.view.refreshLayout.g.b)localObject4).agPj.isLoading())
          {
            if (((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.getCommonConfig().agPI)
            {
              localObject3 = ((com.tencent.mm.view.refreshLayout.g.b)localObject4).agPn;
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQh)
              {
                localObject3 = ((com.tencent.mm.view.refreshLayout.g.b)localObject4).agPn;
                localObject1 = localObject3;
                if (localObject3 == null)
                {
                  s.bIx("cValues");
                  localObject1 = null;
                }
                if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQi) && (((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.Oc(((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.getCommonConfig().Jcx))) {
                  break label574;
                }
              }
            }
            if (!((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.getCommonConfig().agPF) {
              break label607;
            }
            localObject3 = ((com.tencent.mm.view.refreshLayout.g.b)localObject4).agPn;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQh) || (!((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.Oc(((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.getCommonConfig().Jcx)) || (((com.tencent.mm.view.refreshLayout.g.b)localObject4).agPj.jME())) {
              break label607;
            }
          }
          ((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRl = ((Runnable)new b.a((com.tencent.mm.view.refreshLayout.g.b)localObject4, f, -((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.getFooterConfig().footerHeight));
          break label285;
        }
        label574:
        label607:
        localObject3 = ((com.tencent.mm.view.refreshLayout.g.b)localObject4).agPn;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU != 0) || (!((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRh.getCommonConfig().agPM)) {
          break label285;
        }
        ((com.tencent.mm.view.refreshLayout.g.b)localObject4).agRl = ((Runnable)new b.a((com.tencent.mm.view.refreshLayout.g.b)localObject4, f, 0));
        break label285;
      }
      label679:
      localObject1 = this.agPn;
      if (localObject1 != null) {
        break label717;
      }
      s.bIx("cValues");
      localObject1 = localObject3;
    }
    label717:
    for (;;)
    {
      ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQe = true;
      invalidate();
      AppMethodBeat.o(235250);
      return;
    }
  }
  
  public final void dUn()
  {
    AppMethodBeat.i(235300);
    AnimatorListenerAdapter localAnimatorListenerAdapter = (AnimatorListenerAdapter)new e(this);
    this.agPj.a(com.tencent.mm.view.refreshLayout.e.b.agQM);
    ValueAnimator localValueAnimator = aGm(-getFooterConfig().footerHeight);
    if (localValueAnimator != null) {
      localValueAnimator.addListener((Animator.AnimatorListener)localAnimatorListenerAdapter);
    }
    f localf = this.agPg;
    if (localf != null)
    {
      if (getFooterConfig().agQk >= 10.0F) {
        break label121;
      }
      getFooterConfig();
      getFooterConfig();
    }
    for (;;)
    {
      com.tencent.mm.view.refreshLayout.b.e locale = (com.tencent.mm.view.refreshLayout.b.e)this;
      getFooterConfig();
      localf.a(locale);
      if (localValueAnimator == null) {
        localAnimatorListenerAdapter.onAnimationEnd(null);
      }
      AppMethodBeat.o(235300);
      return;
      label121:
      getFooterConfig();
    }
  }
  
  public final void db(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(235305);
    this.agPu.y(paramInt, paramBoolean, false);
    AppMethodBeat.o(235305);
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(235294);
    paramBoolean = this.agPy.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(235294);
    return paramBoolean;
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(235295);
    boolean bool = this.agPy.dispatchNestedPreFling(paramFloat1, paramFloat2);
    AppMethodBeat.o(235295);
    return bool;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(235292);
    boolean bool = this.agPy.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(235292);
    return bool;
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(235291);
    boolean bool = this.agPy.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
    AppMethodBeat.o(235291);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235255);
    s.u(paramMotionEvent, "event");
    int i1 = paramMotionEvent.getActionMasked();
    int i;
    int j;
    label40:
    float f2;
    float f4;
    float f1;
    float f3;
    int m;
    int k;
    if (i1 == 6)
    {
      i = 1;
      if (i == 0) {
        break label337;
      }
      j = paramMotionEvent.getActionIndex();
      f2 = 0.0F;
      f4 = 0.0F;
      f1 = 0.0F;
      f3 = 0.0F;
      m = paramMotionEvent.getPointerCount();
      k = 0;
      if (m <= 0) {}
    }
    for (;;)
    {
      int n = k + 1;
      f1 = f3;
      f2 = f4;
      if (j != k)
      {
        f2 = f4 + paramMotionEvent.getX(k);
        f1 = f3 + paramMotionEvent.getY(k);
      }
      label1557:
      label2850:
      if (n >= m)
      {
        if (i != 0) {}
        Object localObject2;
        Object localObject1;
        Object localObject3;
        boolean bool;
        for (i = m - 1;; i = m)
        {
          f3 = f2 / i;
          f2 = f1 / i;
          if ((i1 == 6) || (i1 == 5))
          {
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH)
            {
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              f1 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn;
              localObject3 = this.agPn;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("cValues");
                localObject2 = null;
              }
              ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn = (f2 - ((com.tencent.mm.view.refreshLayout.a.b)localObject2).Mlk + f1);
            }
          }
          localObject2 = this.agPn;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj = f3;
          localObject2 = this.agPn;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk = f2;
          if (!this.agPx) {
            break label350;
          }
          bool = super.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(235255);
          return bool;
          i = 0;
          break;
          label337:
          j = -1;
          break label40;
        }
        label350:
        if ((!isEnabled()) || ((!getCommonConfig().agJq) && (!getCommonConfig().Jcx) && (!getCommonConfig().agPN)))
        {
          bool = super.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(235255);
          return bool;
        }
        if ((this.agPv.aGp(i1)) || (this.agPj.agRi.isFinishing) || ((this.agPj.isLoading()) && (getCommonConfig().agPR)) || ((this.agPj.jME()) && (getCommonConfig().agPQ)))
        {
          AppMethodBeat.o(235255);
          return false;
        }
        com.tencent.mm.view.refreshLayout.b.a locala;
        switch (i1)
        {
        default: 
        case 0: 
        case 2: 
          do
          {
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(235255);
            return bool;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQd = 0;
            localObject2 = this.doL;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("velocityTracker");
              localObject1 = null;
            }
            ((VelocityTracker)localObject1).addMovement(paramMotionEvent);
            localObject2 = this.MiR;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("scroller");
              localObject1 = null;
            }
            ((Scroller)localObject1).forceFinished(true);
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkm = f3;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn = f2;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPY = 0;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            localObject3 = this.agPn;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cValues");
              localObject2 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPZ = ((com.tencent.mm.view.refreshLayout.a.b)localObject2).agPU;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH = false;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQc = false;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQb = super.dispatchTouchEvent(paramMotionEvent);
            localObject1 = this.agPh;
            if (localObject1 != null)
            {
              ((com.tencent.mm.view.refreshLayout.b.a)localObject1).aN(paramMotionEvent);
              paramMotionEvent = ah.aiuX;
            }
            AppMethodBeat.o(235255);
            return true;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            f3 -= ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkm;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            f1 = f2 - ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn;
            localObject2 = this.doL;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("velocityTracker");
              localObject1 = null;
            }
            ((VelocityTracker)localObject1).addMovement(paramMotionEvent);
            locala = this.agPh;
          } while (locala == null);
          localObject2 = this.agPn;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (!((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH)
          {
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if (!((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQc)
            {
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQa != 1)
              {
                localObject2 = this.agPn;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("cValues");
                  localObject1 = null;
                }
                if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQa != 2)
                {
                  f4 = Math.abs(f1);
                  localObject2 = this.agPn;
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    s.bIx("cValues");
                    localObject1 = null;
                  }
                  if ((f4 < ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doK) || (Math.abs(f3) >= Math.abs(f1))) {}
                }
                else
                {
                  localObject2 = this.agPn;
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    s.bIx("cValues");
                    localObject1 = null;
                  }
                  ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQa = 2;
                  if (f1 > 0.0F)
                  {
                    localObject2 = this.agPn;
                    localObject1 = localObject2;
                    if (localObject2 == null)
                    {
                      s.bIx("cValues");
                      localObject1 = null;
                    }
                    if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU < 0) || (((getCommonConfig().agPN) || (getCommonConfig().agJq)) && (locala.jNA())))
                    {
                      localObject2 = this.agPn;
                      localObject1 = localObject2;
                      if (localObject2 == null)
                      {
                        s.bIx("cValues");
                        localObject1 = null;
                      }
                      ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH = true;
                      localObject2 = this.agPn;
                      localObject1 = localObject2;
                      if (localObject2 == null)
                      {
                        s.bIx("cValues");
                        localObject1 = null;
                      }
                      localObject3 = this.agPn;
                      localObject2 = localObject3;
                      if (localObject3 == null)
                      {
                        s.bIx("cValues");
                        localObject2 = null;
                      }
                      ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn = (f2 - ((com.tencent.mm.view.refreshLayout.a.b)localObject2).doK);
                      label1369:
                      localObject2 = this.agPn;
                      localObject1 = localObject2;
                      if (localObject2 == null)
                      {
                        s.bIx("cValues");
                        localObject1 = null;
                      }
                      if (!((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH) {
                        break label2653;
                      }
                      localObject2 = this.agPn;
                      localObject1 = localObject2;
                      if (localObject2 == null)
                      {
                        s.bIx("cValues");
                        localObject1 = null;
                      }
                      f1 = f2 - ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn;
                      localObject2 = this.agPn;
                      localObject1 = localObject2;
                      if (localObject2 == null)
                      {
                        s.bIx("cValues");
                        localObject1 = null;
                      }
                      if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQb)
                      {
                        paramMotionEvent.setAction(3);
                        super.dispatchTouchEvent(paramMotionEvent);
                      }
                      localObject3 = this.agPj;
                      localObject2 = this.agPn;
                      localObject1 = localObject2;
                      if (localObject2 == null)
                      {
                        s.bIx("cValues");
                        localObject1 = null;
                      }
                      if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU <= 0)
                      {
                        localObject2 = this.agPn;
                        localObject1 = localObject2;
                        if (localObject2 == null)
                        {
                          s.bIx("cValues");
                          localObject1 = null;
                        }
                        if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU != 0) || (f1 <= 0.0F)) {
                          break label2526;
                        }
                      }
                      localObject1 = com.tencent.mm.view.refreshLayout.e.b.agQQ;
                      ((com.tencent.mm.view.refreshLayout.g.a)localObject3).c((com.tencent.mm.view.refreshLayout.e.b)localObject1);
                      localObject1 = getParent();
                      if (!(localObject1 instanceof ViewGroup)) {
                        break label3586;
                      }
                      ((ViewParent)localObject1).requestDisallowInterceptTouchEvent(true);
                    }
                  }
                }
              }
            }
          }
          break;
        }
        label1586:
        label2653:
        for (;;)
        {
          localObject2 = this.agPn;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          long l;
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH)
          {
            i = (int)f1;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            i += ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPZ;
            if (this.agPj.agRj.agQI)
            {
              if (i >= 0)
              {
                localObject2 = this.agPn;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("cValues");
                  localObject1 = null;
                }
                if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPY < 0) {}
              }
            }
            else
            {
              j = i;
              if (!this.agPj.agRj.agQJ) {
                break label2850;
              }
              if (i <= 0)
              {
                localObject2 = this.agPn;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("cValues");
                  localObject1 = null;
                }
                j = i;
                if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPY <= 0) {
                  break label2850;
                }
              }
            }
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPY = i;
            l = paramMotionEvent.getEventTime();
            if (this.agPt == null)
            {
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              f4 = paramMotionEvent.mkm;
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              this.agPt = MotionEvent.obtain(l, l, 0, f4 + f3, paramMotionEvent.mkn, 0);
              super.dispatchTouchEvent(this.agPt);
            }
            localObject1 = this.agPn;
            paramMotionEvent = (MotionEvent)localObject1;
            if (localObject1 == null)
            {
              s.bIx("cValues");
              paramMotionEvent = null;
            }
            f4 = paramMotionEvent.mkm;
            localObject1 = this.agPn;
            paramMotionEvent = (MotionEvent)localObject1;
            if (localObject1 == null)
            {
              s.bIx("cValues");
              paramMotionEvent = null;
            }
            localObject3 = MotionEvent.obtain(l, l, 2, f4 + f3, paramMotionEvent.mkn + i, 0);
            super.dispatchTouchEvent((MotionEvent)localObject3);
            localObject1 = this.agPn;
            paramMotionEvent = (MotionEvent)localObject1;
            if (localObject1 == null)
            {
              s.bIx("cValues");
              paramMotionEvent = null;
            }
            if (paramMotionEvent.agPX)
            {
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              if (f1 > paramMotionEvent.doK)
              {
                localObject1 = this.agPn;
                paramMotionEvent = (MotionEvent)localObject1;
                if (localObject1 == null)
                {
                  s.bIx("cValues");
                  paramMotionEvent = null;
                }
                if (paramMotionEvent.agPU < 0)
                {
                  localObject1 = this.agPn;
                  paramMotionEvent = (MotionEvent)localObject1;
                  if (localObject1 == null)
                  {
                    s.bIx("cValues");
                    paramMotionEvent = null;
                  }
                  paramMotionEvent.agPX = false;
                }
              }
            }
            if ((i > 0) && ((getCommonConfig().agPN) || (getCommonConfig().agJq)) && (locala.jNA()))
            {
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              paramMotionEvent.Mlk = f2;
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              paramMotionEvent.mkn = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk;
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              paramMotionEvent.agPZ = 0;
              this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQQ);
              i = 0;
            }
          }
          label2526:
          label3583:
          for (;;)
          {
            if (((this.agPj.agRj.agQI) && (i < 0)) || ((this.agPj.agRj.agQJ) && (i > 0)))
            {
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              if (paramMotionEvent.agPU != 0) {
                ez(0.0F);
              }
              AppMethodBeat.o(235255);
              return true;
              if (f1 >= 0.0F) {
                break label1369;
              }
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU <= 0)
              {
                if ((!getCommonConfig().agPN) && (!getCommonConfig().Jcx)) {
                  break label1369;
                }
                if (this.agPj.isLoading())
                {
                  localObject2 = this.agPn;
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    s.bIx("cValues");
                    localObject1 = null;
                  }
                  if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPX) {}
                }
                else
                {
                  if (!locala.egB()) {
                    break label1369;
                  }
                }
              }
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH = true;
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              localObject3 = this.agPn;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("cValues");
                localObject2 = null;
              }
              ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn = (((com.tencent.mm.view.refreshLayout.a.b)localObject2).doK + f2);
              break label1369;
              localObject1 = com.tencent.mm.view.refreshLayout.e.b.agQS;
              break label1557;
              f4 = Math.abs(f3);
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              if ((f4 >= ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doK) && (Math.abs(f3) > Math.abs(f1)))
              {
                localObject2 = this.agPn;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("cValues");
                  localObject1 = null;
                }
                if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQa != 2)
                {
                  localObject2 = this.agPn;
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    s.bIx("cValues");
                    localObject1 = null;
                  }
                  ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQa = 1;
                }
              }
              break label1586;
              if ((i >= 0) || ((!getCommonConfig().agPN) && (!getCommonConfig().Jcx)) || (!locala.egB())) {
                break label3583;
              }
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              paramMotionEvent.Mlk = f2;
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              paramMotionEvent.mkn = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk;
              localObject1 = this.agPn;
              paramMotionEvent = (MotionEvent)localObject1;
              if (localObject1 == null)
              {
                s.bIx("cValues");
                paramMotionEvent = null;
              }
              paramMotionEvent.agPZ = 0;
              this.agPj.c(com.tencent.mm.view.refreshLayout.e.b.agQS);
              i = 0;
              continue;
            }
            if (this.agPt != null)
            {
              this.agPt = null;
              ((MotionEvent)localObject3).setAction(3);
              super.dispatchTouchEvent((MotionEvent)localObject3);
            }
            ((MotionEvent)localObject3).recycle();
            j = i;
            ez(j);
            AppMethodBeat.o(235255);
            return true;
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPX)
            {
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              if (f1 > ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doK)
              {
                localObject2 = this.agPn;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  s.bIx("cValues");
                  localObject1 = null;
                }
                if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU < 0)
                {
                  localObject2 = this.agPn;
                  localObject1 = localObject2;
                  if (localObject2 == null)
                  {
                    s.bIx("cValues");
                    localObject1 = null;
                  }
                  ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPX = false;
                }
              }
            }
            localObject1 = ah.aiuX;
            localObject1 = ah.aiuX;
            break;
            localObject2 = this.doL;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("velocityTracker");
              localObject1 = null;
            }
            ((VelocityTracker)localObject1).addMovement(paramMotionEvent);
            localObject2 = this.doL;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("velocityTracker");
              localObject1 = null;
            }
            localObject3 = this.agPn;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cValues");
              localObject2 = null;
            }
            ((VelocityTracker)localObject1).computeCurrentVelocity(1000, ((com.tencent.mm.view.refreshLayout.a.b)localObject2).agPW);
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            localObject3 = this.doL;
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("velocityTracker");
              localObject2 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQd = ((int)((VelocityTracker)localObject2).getYVelocity());
            ey(0.0F);
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQa = 0;
            localObject1 = this.agPt;
            if (localObject1 != null)
            {
              ((MotionEvent)localObject1).recycle();
              this.agPt = null;
              l = paramMotionEvent.getEventTime();
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              localObject1 = MotionEvent.obtain(l, l, i1, ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkm, f2, 0);
              super.dispatchTouchEvent((MotionEvent)localObject1);
              ((MotionEvent)localObject1).recycle();
              localObject1 = ah.aiuX;
              localObject1 = ah.aiuX;
            }
            this.agPu.jNW();
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if (!((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH) {
              break;
            }
            localObject1 = this.agPn;
            paramMotionEvent = (MotionEvent)localObject1;
            if (localObject1 == null)
            {
              s.bIx("cValues");
              paramMotionEvent = null;
            }
            paramMotionEvent.doH = false;
            AppMethodBeat.o(235255);
            return true;
            localObject2 = this.doL;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("velocityTracker");
              localObject1 = null;
            }
            ((VelocityTracker)localObject1).clear();
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQa = 0;
            localObject1 = this.agPt;
            if (localObject1 != null)
            {
              ((MotionEvent)localObject1).recycle();
              this.agPt = null;
              l = paramMotionEvent.getEventTime();
              localObject2 = this.agPn;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              localObject1 = MotionEvent.obtain(l, l, i1, ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkm, f2, 0);
              super.dispatchTouchEvent((MotionEvent)localObject1);
              ((MotionEvent)localObject1).recycle();
              localObject1 = ah.aiuX;
              localObject1 = ah.aiuX;
            }
            this.agPu.jNW();
            localObject2 = this.agPn;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if (!((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH) {
              break;
            }
            localObject1 = this.agPn;
            paramMotionEvent = (MotionEvent)localObject1;
            if (localObject1 == null)
            {
              s.bIx("cValues");
              paramMotionEvent = null;
            }
            paramMotionEvent.doH = false;
            AppMethodBeat.o(235255);
            return true;
          }
        }
      }
      label3586:
      k = n;
      f3 = f1;
      f4 = f2;
    }
  }
  
  public final void ez(float paramFloat)
  {
    AppMethodBeat.i(235308);
    this.agPu.g(paramFloat, this.agPx);
    AppMethodBeat.o(235308);
  }
  
  public void flf() {}
  
  public final com.tencent.mm.view.refreshLayout.g.b getAnimHelper()
  {
    return this.agPv;
  }
  
  public final com.tencent.mm.view.refreshLayout.a.a getCommonConfig()
  {
    AppMethodBeat.i(235210);
    com.tencent.mm.view.refreshLayout.a.a locala = this.agPk;
    if (locala != null)
    {
      AppMethodBeat.o(235210);
      return locala;
    }
    s.bIx("commonConfig");
    AppMethodBeat.o(235210);
    return null;
  }
  
  public final com.tencent.mm.view.refreshLayout.b.a getContentView()
  {
    return this.agPh;
  }
  
  public final com.tencent.mm.view.refreshLayout.a.c getFooterConfig()
  {
    AppMethodBeat.i(235220);
    com.tencent.mm.view.refreshLayout.a.c localc = this.agPm;
    if (localc != null)
    {
      AppMethodBeat.o(235220);
      return localc;
    }
    s.bIx("footerConfig");
    AppMethodBeat.o(235220);
    return null;
  }
  
  public final com.tencent.mm.view.refreshLayout.a.d getHeaderConfig()
  {
    AppMethodBeat.i(235214);
    com.tencent.mm.view.refreshLayout.a.d locald = this.agPl;
    if (locald != null)
    {
      AppMethodBeat.o(235214);
      return locald;
    }
    s.bIx("headerConfig");
    AppMethodBeat.o(235214);
    return null;
  }
  
  public final Interpolator getInterpolator()
  {
    AppMethodBeat.i(235296);
    Interpolator localInterpolator = this.agPq;
    if (localInterpolator == null)
    {
      s.bIx("reboundInterpolator");
      AppMethodBeat.o(235296);
      return null;
    }
    AppMethodBeat.o(235296);
    return localInterpolator;
  }
  
  public ViewGroup getLayout()
  {
    return (ViewGroup)this;
  }
  
  public com.tencent.mm.view.refreshLayout.b.b getLoadMoreFooter()
  {
    if ((this.agPg instanceof com.tencent.mm.view.refreshLayout.b.b)) {
      return (com.tencent.mm.view.refreshLayout.b.b)this.agPg;
    }
    return null;
  }
  
  public final MMHandler getMainHandler()
  {
    return this.mainHandler;
  }
  
  public int getNestedScrollAxes()
  {
    AppMethodBeat.i(235258);
    int i = this.agPz.getNestedScrollAxes();
    AppMethodBeat.o(235258);
    return i;
  }
  
  public final com.tencent.mm.view.refreshLayout.d.c getOnMultiAction()
  {
    return this.agPp;
  }
  
  public final com.tencent.mm.view.refreshLayout.d.b getOnSimpleAction()
  {
    return this.agPo;
  }
  
  public com.tencent.mm.view.refreshLayout.b.c getRefreshHeader()
  {
    if ((this.agPf instanceof com.tencent.mm.view.refreshLayout.b.c)) {
      return (com.tencent.mm.view.refreshLayout.b.c)this.agPf;
    }
    return null;
  }
  
  public com.tencent.mm.view.refreshLayout.e.b getState()
  {
    return this.agPj.agRi;
  }
  
  public boolean hasNestedScrollingParent()
  {
    AppMethodBeat.i(235290);
    boolean bool = this.agPy.en(0);
    AppMethodBeat.o(235290);
    return bool;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    AppMethodBeat.i(235287);
    if ((getCommonConfig().agPP) && ((getCommonConfig().agPN) || (getCommonConfig().agJq) || (getCommonConfig().Jcx)))
    {
      AppMethodBeat.o(235287);
      return true;
    }
    AppMethodBeat.o(235287);
    return false;
  }
  
  public final void jNu()
  {
    AppMethodBeat.i(235298);
    com.tencent.mm.view.refreshLayout.d.b localb = this.agPo;
    if (localb != null) {
      localb.onLoadMore();
    }
    AppMethodBeat.o(235298);
  }
  
  public final void jNv()
  {
    AppMethodBeat.i(235301);
    AnimatorListenerAdapter localAnimatorListenerAdapter = (AnimatorListenerAdapter)new f(this);
    this.agPj.a(com.tencent.mm.view.refreshLayout.e.b.agQU);
    ValueAnimator localValueAnimator = aGm(getHeaderConfig().headerHeight);
    if (localValueAnimator != null) {
      localValueAnimator.addListener((Animator.AnimatorListener)localAnimatorListenerAdapter);
    }
    f localf = this.agPf;
    if (localf != null)
    {
      if (getHeaderConfig().agQn >= 10.0F) {
        break label120;
      }
      getHeaderConfig();
      getHeaderConfig();
    }
    for (;;)
    {
      com.tencent.mm.view.refreshLayout.b.e locale = (com.tencent.mm.view.refreshLayout.b.e)this;
      getHeaderConfig();
      localf.a(locale);
      if (localValueAnimator == null) {
        localAnimatorListenerAdapter.onAnimationEnd(null);
      }
      AppMethodBeat.o(235301);
      return;
      label120:
      getHeaderConfig();
    }
  }
  
  public final com.tencent.mm.view.refreshLayout.b.e jNw()
  {
    AppMethodBeat.i(235332);
    setNestedScrollingEnabled(false);
    com.tencent.mm.view.refreshLayout.b.e locale = (com.tencent.mm.view.refreshLayout.b.e)this;
    AppMethodBeat.o(235332);
    return locale;
  }
  
  public final com.tencent.mm.view.refreshLayout.b.e jNx()
  {
    AppMethodBeat.i(235344);
    long l = System.currentTimeMillis();
    com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
    Object localObject = localb;
    if (localb == null)
    {
      s.bIx("cValues");
      localObject = null;
    }
    localObject = w(Math.min(Math.max(0, 300 - (int)(l - ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQf)), 300) << 16, true, true);
    AppMethodBeat.o(235344);
    return localObject;
  }
  
  public final com.tencent.mm.view.refreshLayout.b.e jNy()
  {
    AppMethodBeat.i(235352);
    long l = System.currentTimeMillis();
    com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
    Object localObject = localb;
    if (localb == null)
    {
      s.bIx("cValues");
      localObject = null;
    }
    localObject = x(Math.min(Math.max(0, 300 - (int)(l - ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQf)), 300) << 16, true, true);
    AppMethodBeat.o(235352);
    return localObject;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(235234);
    super.onAttachedToWindow();
    Log.i("WxRefreshLayout", "onAttachedToWindow");
    com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
    Object localObject = localb;
    if (localb == null)
    {
      s.bIx("cValues");
      localObject = null;
    }
    ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQg = true;
    if (!isInEditMode())
    {
      if ((this.agPf == null) && (getCommonConfig().agJq)) {
        getCommonConfig().agJq = false;
      }
      if ((this.agPg == null) && (getCommonConfig().Jcx)) {
        getCommonConfig().Jcx = false;
      }
      if (this.agPh == null)
      {
        localObject = new RuntimeException("You should add a content view");
        AppMethodBeat.o(235234);
        throw ((Throwable)localObject);
      }
      localObject = this.agPh;
      if (localObject != null)
      {
        ((com.tencent.mm.view.refreshLayout.b.a)localObject).Og(getCommonConfig().agPJ);
        ((com.tencent.mm.view.refreshLayout.b.a)localObject).c((com.tencent.mm.view.refreshLayout.b.e)this);
      }
    }
    localObject = this.agPh;
    if (localObject != null) {
      bringChildToFront(((com.tencent.mm.view.refreshLayout.b.a)localObject).getView());
    }
    localObject = this.agPf;
    if ((localObject != null) && (((f)localObject).getSpinnerStyle().agRa)) {
      bringChildToFront(((f)localObject).getView());
    }
    localObject = this.agPg;
    if ((localObject != null) && (((f)localObject).getSpinnerStyle().agRa)) {
      bringChildToFront(((f)localObject).getView());
    }
    AppMethodBeat.o(235234);
  }
  
  protected void onDetachedFromWindow()
  {
    Object localObject2 = null;
    AppMethodBeat.i(235245);
    super.onDetachedFromWindow();
    Object localObject3 = this.agPn;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agQg = false;
    localObject1 = this.agPv;
    ((com.tencent.mm.view.refreshLayout.g.b)localObject1).agRl = null;
    localObject3 = ((com.tencent.mm.view.refreshLayout.g.b)localObject1).agRm;
    if (localObject3 != null)
    {
      ((ValueAnimator)localObject3).removeAllListeners();
      ((ValueAnimator)localObject3).removeAllUpdateListeners();
      ((ValueAnimator)localObject3).cancel();
    }
    ((com.tencent.mm.view.refreshLayout.g.b)localObject1).agRm = null;
    if (this.agPj.jME())
    {
      localObject1 = this.agPf;
      if (localObject1 != null) {
        ((f)localObject1).a((com.tencent.mm.view.refreshLayout.b.e)this, false);
      }
    }
    if (this.agPj.isLoading())
    {
      localObject1 = this.agPg;
      if (localObject1 != null) {
        ((f)localObject1).a((com.tencent.mm.view.refreshLayout.b.e)this, false);
      }
    }
    localObject3 = this.agPn;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("cValues");
      localObject1 = null;
    }
    if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU != 0) {
      db(0, true);
    }
    if (!this.agPj.jNI()) {
      this.agPj.a(com.tencent.mm.view.refreshLayout.e.b.agQO);
    }
    this.mainHandler.removeCallbacksAndMessages(null);
    localObject1 = this.agPn;
    if (localObject1 == null)
    {
      s.bIx("cValues");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPX = false;
      AppMethodBeat.o(235245);
      return;
    }
  }
  
  protected void onFinishInflate()
  {
    int k = 0;
    AppMethodBeat.i(235230);
    super.onFinishInflate();
    Log.i("WxRefreshLayout", "onFinishInflate");
    int n = getChildCount();
    Object localObject;
    if (n > 3)
    {
      localObject = new RuntimeException("Most only support three sub view");
      AppMethodBeat.o(235230);
      throw ((Throwable)localObject);
    }
    int i;
    int j;
    int m;
    if (n > 0)
    {
      i = 0;
      j = -1;
      m = i + 1;
      localObject = getChildAt(i);
      com.tencent.mm.view.refreshLayout.f.a locala = com.tencent.mm.view.refreshLayout.f.a.agRg;
      if (com.tencent.mm.view.refreshLayout.f.a.aU((View)localObject)) {
        j = i;
      }
      if (m < n) {}
    }
    for (;;)
    {
      if (j >= 0)
      {
        localObject = getChildAt(j);
        s.s(localObject, "getChildAt(indexContent)");
        this.agPh = ((com.tencent.mm.view.refreshLayout.b.a)new com.tencent.mm.view.refreshLayout.h.a((View)localObject));
        if (j == 1)
        {
          if (n != 3) {
            break label280;
          }
          i = 2;
          j = 0;
        }
      }
      for (;;)
      {
        if (n > 0) {}
        for (;;)
        {
          m = k + 1;
          localObject = getChildAt(k);
          if ((k == j) || ((k != i) && (j == -1) && (this.agPf == null))) {
            if ((localObject instanceof com.tencent.mm.view.refreshLayout.b.c)) {
              this.agPf = ((f)localObject);
            }
          }
          for (;;)
          {
            if (m < n) {
              break label267;
            }
            AppMethodBeat.o(235230);
            return;
            if (n != 2) {
              break label273;
            }
            i = 1;
            j = -1;
            break;
            if (((k == i) || ((i == -1) && (this.agPg == null))) && ((localObject instanceof com.tencent.mm.view.refreshLayout.b.b))) {
              this.agPg = ((f)localObject);
            }
          }
          label267:
          k = m;
        }
        label273:
        i = -1;
        j = -1;
        continue;
        label280:
        i = -1;
        j = 0;
      }
      i = m;
      break;
      j = -1;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235243);
    int j = getPaddingLeft();
    int k = getPaddingTop();
    paramInt1 = 0;
    int m = getChildCount();
    Object localObject2;
    Object localObject1;
    View localView;
    label200:
    label340:
    com.tencent.mm.view.refreshLayout.e.c localc;
    if (m > 0)
    {
      paramInt3 = paramInt1 + 1;
      localObject2 = getChildAt(paramInt1);
      if (((View)localObject2).getVisibility() != 8)
      {
        localObject1 = this.agPh;
        if ((localObject1 != null) && (((com.tencent.mm.view.refreshLayout.b.a)localObject1).getView() == localObject2))
        {
          localObject3 = ((com.tencent.mm.view.refreshLayout.b.a)localObject1).getView();
          localObject1 = ((View)localObject3).getLayoutParams();
          if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
            break label577;
          }
          localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
          paramInt1 = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin + j;
          paramInt2 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin + k;
          ((View)localObject3).layout(paramInt1, paramInt2, ((View)localObject3).getMeasuredWidth() + paramInt1, ((View)localObject3).getMeasuredHeight() + paramInt2);
        }
        Object localObject3 = this.agPf;
        if ((localObject3 != null) && (((f)localObject3).getView() == localObject2))
        {
          localView = ((f)localObject3).getView();
          localObject1 = localView.getLayoutParams();
          if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
            break label586;
          }
          localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
          int n = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
          int i = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
          int i1 = localView.getMeasuredWidth();
          paramInt4 = localView.getMeasuredHeight() + i;
          paramInt2 = paramInt4;
          paramInt1 = i;
          if (((f)localObject3).getSpinnerStyle() == com.tencent.mm.view.refreshLayout.e.c.agRc)
          {
            paramInt1 = i - getHeaderConfig().headerHeight;
            paramInt2 = paramInt4 - getHeaderConfig().headerHeight;
          }
          localView.layout(n, paramInt1, n + i1, paramInt2);
        }
        f localf = this.agPg;
        if ((localf != null) && (localf.getView() == localObject2))
        {
          localView = localf.getView();
          localObject1 = localView.getLayoutParams();
          if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
            break label595;
          }
          localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
          localc = localf.getSpinnerStyle();
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject1).leftMargin;
          paramInt1 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
          paramInt2 = getMeasuredHeight();
          com.tencent.mm.view.refreshLayout.b.a locala = this.agPh;
          if (locala == null) {
            break label749;
          }
          localObject3 = this.agPn;
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("cValues");
            localObject2 = null;
          }
          if (!((com.tencent.mm.view.refreshLayout.a.b)localObject2).agQh) {
            break label749;
          }
          localObject3 = this.agPn;
          localObject2 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("cValues");
            localObject2 = null;
          }
          if ((!((com.tencent.mm.view.refreshLayout.a.b)localObject2).agQi) || (!getCommonConfig().agPI) || (localf.getSpinnerStyle() != com.tencent.mm.view.refreshLayout.e.c.agRc) || (!Oc(getCommonConfig().Jcx))) {
            break label749;
          }
          localObject2 = locala.getView();
          localObject3 = ((View)localObject2).getLayoutParams();
          if (!(localObject3 instanceof ViewGroup.MarginLayoutParams)) {
            break label604;
          }
          paramInt1 = ((ViewGroup.MarginLayoutParams)localObject3).topMargin;
          label512:
          paramInt2 = paramInt1 + (k + k) + ((View)localObject2).getMeasuredHeight();
        }
      }
    }
    for (;;)
    {
      if (localc == com.tencent.mm.view.refreshLayout.e.c.agRf) {
        paramInt1 = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
      }
      label577:
      label586:
      label595:
      label604:
      label638:
      do
      {
        do
        {
          for (;;)
          {
            localView.layout(paramInt4, paramInt1, localView.getMeasuredWidth() + paramInt4, localView.getMeasuredHeight() + paramInt1);
            if (paramInt3 < m) {
              break label743;
            }
            AppMethodBeat.o(235243);
            return;
            localObject1 = this.agPs;
            break;
            localObject1 = this.agPs;
            break label200;
            localObject1 = this.agPs;
            break label340;
            paramInt1 = 0;
            break label512;
            if ((localc != com.tencent.mm.view.refreshLayout.e.c.agRe) && (localc != com.tencent.mm.view.refreshLayout.e.c.agRd)) {
              break label638;
            }
            paramInt1 = paramInt2 - getFooterConfig().footerHeight;
          }
          paramInt1 = paramInt2;
        } while (!localc.agRb);
        localObject2 = this.agPn;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        paramInt1 = paramInt2;
      } while (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU >= 0);
      if (Oc(getCommonConfig().Jcx))
      {
        localObject2 = this.agPn;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
      }
      for (paramInt1 = -((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU;; paramInt1 = 0)
      {
        paramInt1 = paramInt2 - Math.max(paramInt1, 0);
        break;
      }
      label743:
      paramInt1 = paramInt3;
      break;
      label749:
      paramInt2 += paramInt1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(235240);
    int j = 0;
    int i = 0;
    int i1 = getChildCount();
    int k;
    int n;
    f localf;
    View localView2;
    Object localObject2;
    Object localObject1;
    label104:
    int i2;
    int m;
    int i3;
    Object localObject3;
    if (i1 > 0)
    {
      j = 0;
      k = 0;
      n = i + 1;
      View localView1 = getChildAt(i);
      if (localView1.getVisibility() != 8)
      {
        localf = this.agPf;
        a.a locala;
        if ((localf != null) && (localf.getView() == localView1))
        {
          localView2 = localf.getView();
          localObject2 = localView2.getLayoutParams();
          if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
            break label1021;
          }
          localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
          i2 = ViewGroup.getChildMeasureSpec(paramInt1, ((ViewGroup.MarginLayoutParams)localObject1).leftMargin + ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.LayoutParams)localObject2).width);
          m = getHeaderConfig().headerHeight;
          i3 = getHeaderConfig().agQm.agQu;
          localObject3 = com.tencent.mm.view.refreshLayout.e.a.agQt;
          i = m;
          if (i3 >= com.tencent.mm.view.refreshLayout.e.a.jNF().agQu) {
            break label1595;
          }
          if (((ViewGroup.LayoutParams)localObject2).height <= 0) {
            break label1030;
          }
          m = ((ViewGroup.LayoutParams)localObject2).height + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin + ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
          localObject3 = getHeaderConfig().agQm;
          locala = com.tencent.mm.view.refreshLayout.e.a.agQt;
          i = m;
          if (!((com.tencent.mm.view.refreshLayout.e.a)localObject3).c(com.tencent.mm.view.refreshLayout.e.a.jNE())) {
            break label1595;
          }
          getHeaderConfig().headerHeight = (((ViewGroup.LayoutParams)localObject2).height + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin + ((ViewGroup.MarginLayoutParams)localObject1).topMargin);
          localObject2 = getHeaderConfig();
          localObject3 = com.tencent.mm.view.refreshLayout.e.a.agQt;
          ((com.tencent.mm.view.refreshLayout.a.d)localObject2).b(com.tencent.mm.view.refreshLayout.e.a.jNE());
          i = m;
          label267:
          if (localf.getSpinnerStyle() != com.tencent.mm.view.refreshLayout.e.c.agRf) {
            break label1211;
          }
          i = View.MeasureSpec.getSize(paramInt2);
          label285:
          if (i != -1) {
            localView2.measure(i2, View.MeasureSpec.makeMeasureSpec(Math.max(i - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject1).topMargin, 0), 1073741824));
          }
          if (!getHeaderConfig().agQm.Mwc)
          {
            if (getHeaderConfig().agQn >= 10.0F) {
              break label1282;
            }
            getHeaderConfig();
            getHeaderConfig();
            label357:
            getHeaderConfig().b(getHeaderConfig().agQm.jNB());
            localObject1 = this.agPi;
            getHeaderConfig();
            localf.a((com.tencent.mm.view.refreshLayout.b.d)localObject1);
          }
        }
        localf = this.agPg;
        if ((localf != null) && (localf.getView() == localView1))
        {
          localView2 = localf.getView();
          localObject2 = localView2.getLayoutParams();
          if (!(localObject2 instanceof ViewGroup.MarginLayoutParams)) {
            break label1290;
          }
          localObject1 = (ViewGroup.MarginLayoutParams)localObject2;
          label448:
          i2 = ViewGroup.getChildMeasureSpec(paramInt1, ((ViewGroup.MarginLayoutParams)localObject1).leftMargin + ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.LayoutParams)localObject2).width);
          m = getFooterConfig().footerHeight;
          i3 = getFooterConfig().agQj.agQu;
          localObject3 = com.tencent.mm.view.refreshLayout.e.a.agQt;
          i = m;
          if (i3 >= com.tencent.mm.view.refreshLayout.e.a.jNF().agQu) {
            break label1592;
          }
          if (((ViewGroup.LayoutParams)localObject2).height <= 0) {
            break label1299;
          }
          m = ((ViewGroup.LayoutParams)localObject2).height + ((ViewGroup.MarginLayoutParams)localObject1).topMargin + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin;
          localObject3 = getFooterConfig().agQj;
          locala = com.tencent.mm.view.refreshLayout.e.a.agQt;
          i = m;
          if (!((com.tencent.mm.view.refreshLayout.e.a)localObject3).c(com.tencent.mm.view.refreshLayout.e.a.jNE())) {
            break label1592;
          }
          getFooterConfig().footerHeight = (((ViewGroup.LayoutParams)localObject2).height + ((ViewGroup.MarginLayoutParams)localObject1).topMargin + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
          localObject2 = getFooterConfig();
          localObject3 = com.tencent.mm.view.refreshLayout.e.a.agQt;
          ((com.tencent.mm.view.refreshLayout.a.c)localObject2).a(com.tencent.mm.view.refreshLayout.e.a.jNE());
          i = m;
          label611:
          if (localf.getSpinnerStyle() != com.tencent.mm.view.refreshLayout.e.c.agRf) {
            break label1480;
          }
          i = View.MeasureSpec.getSize(paramInt2);
          label629:
          if (i != -1) {
            localView2.measure(i2, View.MeasureSpec.makeMeasureSpec(Math.max(i - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject1).topMargin, 0), 1073741824));
          }
          if (!getFooterConfig().agQj.Mwc)
          {
            if (getFooterConfig().agQk >= 10.0F) {
              break label1552;
            }
            getFooterConfig();
            getFooterConfig();
            label701:
            getFooterConfig().a(getFooterConfig().agQj.jNB());
            localObject1 = this.agPi;
            getFooterConfig();
            localf.a((com.tencent.mm.view.refreshLayout.b.d)localObject1);
          }
        }
        localObject1 = this.agPh;
        if ((localObject1 != null) && (((com.tencent.mm.view.refreshLayout.b.a)localObject1).getView() == localView1))
        {
          localObject2 = ((com.tencent.mm.view.refreshLayout.b.a)localObject1).getView();
          localObject3 = ((View)localObject2).getLayoutParams();
          if ((localObject3 instanceof ViewGroup.MarginLayoutParams))
          {
            localObject1 = (ViewGroup.MarginLayoutParams)localObject3;
            label792:
            ((View)localObject2).measure(ViewGroup.getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams)localObject1).leftMargin + ((ViewGroup.MarginLayoutParams)localObject1).rightMargin, ((ViewGroup.LayoutParams)localObject3).width), ViewGroup.getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams)localObject1).topMargin + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin, ((ViewGroup.LayoutParams)localObject3).height));
            k += ((View)localObject2).getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject1).leftMargin + ((ViewGroup.MarginLayoutParams)localObject1).rightMargin;
            i = ((View)localObject2).getMeasuredHeight();
            m = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
            i = j + (((ViewGroup.MarginLayoutParams)localObject1).bottomMargin + (i + m));
            label906:
            if (n < i1) {
              break label1569;
            }
          }
        }
      }
    }
    for (;;)
    {
      j = getPaddingLeft();
      m = getPaddingRight();
      n = getPaddingTop();
      i1 = getPaddingBottom();
      super.setMeasuredDimension(ViewGroup.resolveSize(Math.max(j + m + k, super.getSuggestedMinimumWidth()), paramInt1), ViewGroup.resolveSize(Math.max(i + (n + i1), super.getSuggestedMinimumHeight()), paramInt2));
      localObject2 = this.agPn;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("cValues");
        localObject1 = null;
      }
      ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj = (getMeasuredWidth() / 2.0F);
      AppMethodBeat.o(235240);
      return;
      label1021:
      localObject1 = this.agPs;
      break label104;
      label1030:
      i = m;
      if (((ViewGroup.LayoutParams)localObject2).height == -2) {
        if (localf.getSpinnerStyle() == com.tencent.mm.view.refreshLayout.e.c.agRf)
        {
          i = m;
          if (getHeaderConfig().agQm.Mwc) {}
        }
        else
        {
          i3 = Math.max(View.MeasureSpec.getSize(paramInt2) - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject1).topMargin, 0);
          localView2.measure(i2, View.MeasureSpec.makeMeasureSpec(i3, -2147483648));
          int i4 = localView2.getMeasuredHeight();
          i = m;
          if (i4 > 0)
          {
            m = -1;
            i = m;
            if (i4 == i3) {
              break label267;
            }
            localObject2 = getHeaderConfig().agQm;
            localObject3 = com.tencent.mm.view.refreshLayout.e.a.agQt;
            i = m;
            if (!((com.tencent.mm.view.refreshLayout.e.a)localObject2).c(com.tencent.mm.view.refreshLayout.e.a.jND())) {
              break label267;
            }
            getHeaderConfig().headerHeight = (((ViewGroup.MarginLayoutParams)localObject1).bottomMargin + i4 + ((ViewGroup.MarginLayoutParams)localObject1).topMargin);
            localObject2 = getHeaderConfig();
            localObject3 = com.tencent.mm.view.refreshLayout.e.a.agQt;
            ((com.tencent.mm.view.refreshLayout.a.d)localObject2).b(com.tencent.mm.view.refreshLayout.e.a.jND());
            i = m;
            break label267;
            label1211:
            if (!localf.getSpinnerStyle().agRb) {
              break label285;
            }
            if (Oc(getCommonConfig().agJq))
            {
              localObject3 = this.agPn;
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("cValues");
                localObject2 = null;
              }
            }
            for (i = ((com.tencent.mm.view.refreshLayout.a.b)localObject2).agPU;; i = 0)
            {
              i = Math.max(0, i);
              break;
            }
            label1282:
            getHeaderConfig();
            break label357;
            label1290:
            localObject1 = this.agPs;
            break label448;
            label1299:
            i = m;
            if (((ViewGroup.LayoutParams)localObject2).height == -2) {
              if (localf.getSpinnerStyle() == com.tencent.mm.view.refreshLayout.e.c.agRf)
              {
                i = m;
                if (getFooterConfig().agQj.Mwc) {}
              }
              else
              {
                i3 = Math.max(View.MeasureSpec.getSize(paramInt2) - ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin - ((ViewGroup.MarginLayoutParams)localObject1).topMargin, 0);
                localView2.measure(i2, View.MeasureSpec.makeMeasureSpec(i3, -2147483648));
                i4 = localView2.getMeasuredHeight();
                i = m;
                if (i4 > 0)
                {
                  m = -1;
                  i = m;
                  if (i4 == i3) {
                    break label611;
                  }
                  localObject2 = getFooterConfig().agQj;
                  localObject3 = com.tencent.mm.view.refreshLayout.e.a.agQt;
                  i = m;
                  if (!((com.tencent.mm.view.refreshLayout.e.a)localObject2).c(com.tencent.mm.view.refreshLayout.e.a.jND())) {
                    break label611;
                  }
                  getFooterConfig().footerHeight = (((ViewGroup.MarginLayoutParams)localObject1).topMargin + i4 + ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin);
                  localObject2 = getFooterConfig();
                  localObject3 = com.tencent.mm.view.refreshLayout.e.a.agQt;
                  ((com.tencent.mm.view.refreshLayout.a.c)localObject2).a(com.tencent.mm.view.refreshLayout.e.a.jND());
                  i = m;
                  break label611;
                  label1480:
                  if (!localf.getSpinnerStyle().agRb) {
                    break label629;
                  }
                  if (Oc(getCommonConfig().Jcx))
                  {
                    localObject3 = this.agPn;
                    localObject2 = localObject3;
                    if (localObject3 == null)
                    {
                      s.bIx("cValues");
                      localObject2 = null;
                    }
                  }
                  for (i = -((com.tencent.mm.view.refreshLayout.a.b)localObject2).agPU;; i = 0)
                  {
                    i = Math.max(0, i);
                    break;
                  }
                  label1552:
                  getFooterConfig();
                  break label701;
                  localObject1 = this.agPs;
                  break label792;
                  label1569:
                  j = n;
                  m = i;
                  i = j;
                  j = m;
                  break;
                  i = j;
                  break label906;
                }
              }
            }
            label1592:
            break label611;
          }
        }
      }
      label1595:
      break label267;
      k = 0;
      i = j;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(235280);
    s.u(paramView, "target");
    paramBoolean = this.agPy.dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
    AppMethodBeat.o(235280);
    return paramBoolean;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(235278);
    s.u(paramView, "target");
    com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
    paramView = localb;
    if (localb == null)
    {
      s.bIx("cValues");
      paramView = null;
    }
    if (((paramView.agPX) && (paramFloat2 > 0.0F)) || (ey(-paramFloat2)) || (this.agPy.dispatchNestedPreFling(paramFloat1, paramFloat2)))
    {
      AppMethodBeat.o(235278);
      return true;
    }
    AppMethodBeat.o(235278);
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(235267);
    s.u(paramView, "target");
    s.u(paramArrayOfInt, "consumed");
    int i;
    if (this.agPw * paramInt2 > 0) {
      if (Math.abs(paramInt2) > Math.abs(this.agPw))
      {
        i = this.agPw;
        this.agPw = 0;
        ez(this.agPw);
      }
    }
    for (;;)
    {
      this.agPy.dispatchNestedPreScroll(paramInt1, paramInt2 - i, paramArrayOfInt, null);
      paramArrayOfInt[1] = (i + paramArrayOfInt[1]);
      AppMethodBeat.o(235267);
      return;
      this.agPw -= paramInt2;
      i = paramInt2;
      break;
      if (paramInt2 > 0)
      {
        com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
        paramView = localb;
        if (localb == null)
        {
          s.bIx("cValues");
          paramView = null;
        }
        if (paramView.agPX)
        {
          this.agPw -= paramInt2;
          ez(this.agPw);
          i = paramInt2;
          continue;
        }
      }
      i = 0;
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235275);
    s.u(paramView, "target");
    boolean bool = this.agPy.dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.EHE);
    paramInt3 = paramInt4 + this.EHE[1];
    Object localObject2;
    if ((paramInt3 < 0) && ((getCommonConfig().agJq) || (getCommonConfig().agPN)))
    {
      if ((this.agPw == 0) && (this.agPr != null))
      {
        localObject2 = this.agPr;
        if (localObject2 == null) {
          break label371;
        }
        paramView = this.agPh;
        if (paramView != null) {
          break label361;
        }
        paramView = null;
        if (((g)localObject2).mD(paramView) != true) {
          break label371;
        }
        paramInt1 = 1;
        label121:
        if (paramInt1 != 0) {}
      }
    }
    else
    {
      if ((paramInt3 <= 0) || ((!getCommonConfig().Jcx) && (!getCommonConfig().agPN))) {
        break label298;
      }
      if ((this.agPw == 0) && (this.agPr != null))
      {
        localObject2 = this.agPr;
        if (localObject2 == null) {
          break label386;
        }
        paramView = this.agPh;
        if (paramView != null) {
          break label376;
        }
        paramView = null;
        label186:
        if (((g)localObject2).mE(paramView) != true) {
          break label386;
        }
        paramInt1 = 1;
        label200:
        if (paramInt1 == 0) {
          break label298;
        }
      }
    }
    if (this.agPj.agRj == com.tencent.mm.view.refreshLayout.e.b.agQO)
    {
      paramInt1 = 1;
      label219:
      if ((paramInt1 != 0) || (this.agPj.agRj.LWA))
      {
        localObject2 = this.agPj;
        if (paramInt3 <= 0) {
          break label396;
        }
        paramView = com.tencent.mm.view.refreshLayout.e.b.agQS;
        label251:
        ((com.tencent.mm.view.refreshLayout.g.a)localObject2).c(paramView);
        if (!bool)
        {
          paramView = getParent();
          if (paramView != null) {
            paramView.requestDisallowInterceptTouchEvent(true);
          }
        }
      }
      this.agPw -= paramInt3;
      ez(this.agPw);
      label298:
      localObject2 = this.agPn;
      paramView = (View)localObject2;
      if (localObject2 == null)
      {
        s.bIx("cValues");
        paramView = null;
      }
      if ((paramView.agPX) && (paramInt2 < 0))
      {
        paramView = this.agPn;
        if (paramView != null) {
          break label403;
        }
        s.bIx("cValues");
        paramView = localObject1;
      }
    }
    label386:
    label396:
    label403:
    for (;;)
    {
      paramView.agPX = false;
      AppMethodBeat.o(235275);
      return;
      label361:
      paramView = paramView.getView();
      break;
      label371:
      paramInt1 = 0;
      break label121;
      label376:
      paramView = paramView.getView();
      break label186;
      paramInt1 = 0;
      break label200;
      paramInt1 = 0;
      break label219;
      paramView = com.tencent.mm.view.refreshLayout.e.b.agQQ;
      break label251;
    }
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(235262);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    this.agPz.aA(paramInt, 0);
    this.agPy.az(paramInt & 0x2, 0);
    paramView2 = this.agPn;
    paramView1 = paramView2;
    if (paramView2 == null)
    {
      s.bIx("cValues");
      paramView1 = null;
    }
    this.agPw = paramView1.agPU;
    this.agPx = true;
    this.agPv.aGp(0);
    AppMethodBeat.o(235262);
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    AppMethodBeat.i(235260);
    s.u(paramView1, "child");
    s.u(paramView2, "target");
    if ((isEnabled()) && (isNestedScrollingEnabled()) && ((paramInt & 0x2) != 0) && ((getCommonConfig().agPN) || (getCommonConfig().agJq) || (getCommonConfig().Jcx)))
    {
      AppMethodBeat.o(235260);
      return true;
    }
    AppMethodBeat.o(235260);
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    AppMethodBeat.i(235285);
    s.u(paramView, "target");
    this.agPz.eq(0);
    this.agPx = false;
    this.agPw = 0;
    this.agPu.jNW();
    this.agPy.em(0);
    AppMethodBeat.o(235285);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(235256);
    com.tencent.mm.view.refreshLayout.a.b localb2 = this.agPn;
    com.tencent.mm.view.refreshLayout.a.b localb1 = localb2;
    if (localb2 == null)
    {
      s.bIx("cValues");
      localb1 = null;
    }
    localb1.agQc = paramBoolean;
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    AppMethodBeat.o(235256);
  }
  
  public final void setCommonConfig(com.tencent.mm.view.refreshLayout.a.a parama)
  {
    AppMethodBeat.i(235212);
    s.u(parama, "<set-?>");
    this.agPk = parama;
    AppMethodBeat.o(235212);
  }
  
  public final void setDirectLoadingState(boolean paramBoolean)
  {
    com.tencent.mm.view.refreshLayout.b.e locale = null;
    AppMethodBeat.i(235299);
    Object localObject;
    if (!this.agPj.isLoading())
    {
      com.tencent.mm.view.refreshLayout.a.b localb = this.agPn;
      localObject = localb;
      if (localb == null)
      {
        s.bIx("cValues");
        localObject = null;
      }
      ((com.tencent.mm.view.refreshLayout.a.b)localObject).agQf = System.currentTimeMillis();
      localObject = this.agPn;
      if (localObject != null) {
        break label155;
      }
      s.bIx("cValues");
      localObject = locale;
      ((com.tencent.mm.view.refreshLayout.a.b)localObject).agPX = true;
      this.agPj.a(com.tencent.mm.view.refreshLayout.e.b.agQN);
      if (paramBoolean)
      {
        localObject = this.agPo;
        if (localObject != null) {
          ((com.tencent.mm.view.refreshLayout.d.b)localObject).onLoadMore();
        }
      }
      localObject = this.agPg;
      if (localObject != null)
      {
        if (getFooterConfig().agQk >= 10.0F) {
          break label158;
        }
        getFooterConfig();
        getFooterConfig();
      }
    }
    for (;;)
    {
      locale = (com.tencent.mm.view.refreshLayout.b.e)this;
      getFooterConfig();
      ((f)localObject).b(locale);
      AppMethodBeat.o(235299);
      return;
      label155:
      break;
      label158:
      getFooterConfig();
    }
  }
  
  public final void setFooterConfig(com.tencent.mm.view.refreshLayout.a.c paramc)
  {
    AppMethodBeat.i(235223);
    s.u(paramc, "<set-?>");
    this.agPm = paramc;
    AppMethodBeat.o(235223);
  }
  
  public final void setHeaderConfig(com.tencent.mm.view.refreshLayout.a.d paramd)
  {
    AppMethodBeat.i(235217);
    s.u(paramd, "<set-?>");
    this.agPl = paramd;
    AppMethodBeat.o(235217);
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(235286);
    getCommonConfig().agPP = paramBoolean;
    this.agPy.setNestedScrollingEnabled(paramBoolean);
    AppMethodBeat.o(235286);
  }
  
  public final void setOnMultiAction(com.tencent.mm.view.refreshLayout.d.c paramc)
  {
    this.agPp = paramc;
  }
  
  public final void setOnSimpleAction(com.tencent.mm.view.refreshLayout.d.b paramb)
  {
    this.agPo = paramb;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    AppMethodBeat.i(235288);
    boolean bool = this.agPy.az(paramInt, 0);
    AppMethodBeat.o(235288);
    return bool;
  }
  
  public void stopNestedScroll()
  {
    AppMethodBeat.i(235289);
    this.agPy.em(0);
    AppMethodBeat.o(235289);
  }
  
  public void uZ(boolean paramBoolean) {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/refreshLayout/WxRefreshLayout$autoRefresh$runnable$1$1$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends AnimatorListenerAdapter
  {
    b(WxRefreshLayout paramWxRefreshLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(235087);
      if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(235087);
        return;
      }
      WxRefreshLayout.g(this.agPA).agRm = null;
      if (WxRefreshLayout.f(this.agPA) != null)
      {
        if (!WxRefreshLayout.e(this.agPA).jNR()) {
          WxRefreshLayout.e(this.agPA).c(com.tencent.mm.view.refreshLayout.e.b.agQX);
        }
        this.agPA.jNv();
        this.agPA.uZ(true);
        AppMethodBeat.o(235087);
        return;
      }
      WxRefreshLayout.e(this.agPA).c(com.tencent.mm.view.refreshLayout.e.b.agQO);
      AppMethodBeat.o(235087);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/refreshLayout/WxRefreshLayout$finishLoadMore$runnable$1", "Ljava/lang/Runnable;", "count", "", "getCount", "()I", "setCount", "(I)V", "run", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Runnable
  {
    private int count;
    
    c(WxRefreshLayout paramWxRefreshLayout, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
    
    private static final void a(WxRefreshLayout paramWxRefreshLayout, int paramInt, final boolean paramBoolean)
    {
      AppMethodBeat.i(235086);
      s.u(paramWxRefreshLayout, "this$0");
      Object localObject3;
      Object localObject1;
      if ((paramWxRefreshLayout.getCommonConfig().agPK) && (paramInt < 0))
      {
        localObject3 = WxRefreshLayout.h(paramWxRefreshLayout);
        if (localObject3 == null)
        {
          localObject1 = null;
          if (localObject1 != null) {
            ((ValueAnimator.AnimatorUpdateListener)localObject1).onAnimationUpdate(ValueAnimator.ofInt(new int[] { 0, 0 }));
          }
        }
      }
      for (;;)
      {
        AnimatorListenerAdapter localAnimatorListenerAdapter = (AnimatorListenerAdapter)new a(paramWxRefreshLayout, paramBoolean);
        localObject3 = WxRefreshLayout.d(paramWxRefreshLayout);
        Object localObject2 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("cValues");
          localObject2 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject2).agPU <= 0) {
          if (localObject1 == null)
          {
            localObject2 = WxRefreshLayout.d(paramWxRefreshLayout);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU != 0) {}
          }
          else
          {
            WxRefreshLayout.g(paramWxRefreshLayout).jNU();
            paramWxRefreshLayout.db(0, false);
            WxRefreshLayout.e(paramWxRefreshLayout).c(com.tencent.mm.view.refreshLayout.e.b.agQO);
            paramWxRefreshLayout = null;
          }
        }
        for (;;)
        {
          if (paramWxRefreshLayout == null) {
            break label309;
          }
          paramWxRefreshLayout.addListener((Animator.AnimatorListener)localAnimatorListenerAdapter);
          AppMethodBeat.o(235086);
          return;
          localObject2 = WxRefreshLayout.d(paramWxRefreshLayout);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          localObject1 = ((com.tencent.mm.view.refreshLayout.b.a)localObject3).aGo(((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU);
          break;
          if ((paramBoolean) && (paramWxRefreshLayout.getCommonConfig().agPI))
          {
            localObject2 = WxRefreshLayout.d(paramWxRefreshLayout);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU >= -paramWxRefreshLayout.getFooterConfig().footerHeight)
            {
              WxRefreshLayout.e(paramWxRefreshLayout).a(com.tencent.mm.view.refreshLayout.e.b.agQO);
              paramWxRefreshLayout = null;
            }
            else
            {
              paramWxRefreshLayout = paramWxRefreshLayout.aGm(-paramWxRefreshLayout.getFooterConfig().footerHeight);
            }
          }
          else
          {
            paramWxRefreshLayout = paramWxRefreshLayout.aGm(0);
          }
        }
        label309:
        localAnimatorListenerAdapter.onAnimationEnd(null);
        AppMethodBeat.o(235086);
        return;
        localObject1 = null;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(235103);
      int i;
      if (this.count == 0)
      {
        if (WxRefreshLayout.e(this.agPA).jNI()) {
          if (WxRefreshLayout.e(this.agPA).agRj == com.tencent.mm.view.refreshLayout.e.b.agQN)
          {
            i = 1;
            if (i == 0) {
              break label90;
            }
            WxRefreshLayout.e(this.agPA).b(com.tencent.mm.view.refreshLayout.e.b.agQO);
          }
        }
        label90:
        do
        {
          for (;;)
          {
            if (!paramBoolean2) {
              break label1168;
            }
            this.agPA.Of(true);
            AppMethodBeat.o(235103);
            return;
            i = 0;
            break;
            if ((WxRefreshLayout.g(this.agPA).agRm == null) || ((!WxRefreshLayout.e(this.agPA).agRi.mlX) && (!WxRefreshLayout.e(this.agPA).jNK())) || (!WxRefreshLayout.e(this.agPA).agRi.agQJ)) {
              break label201;
            }
            WxRefreshLayout.g(this.agPA).jNU();
            if (this.agPA.aGm(0) == null) {
              WxRefreshLayout.e(this.agPA).a(com.tencent.mm.view.refreshLayout.e.b.agQO);
            } else {
              WxRefreshLayout.e(this.agPA).a(com.tencent.mm.view.refreshLayout.e.b.agQR);
            }
          }
        } while ((!WxRefreshLayout.e(this.agPA).isLoading()) || (WxRefreshLayout.n(this.agPA) == null) || (WxRefreshLayout.h(this.agPA) == null));
        label201:
        this.count += 1;
        WxRefreshLayout.i(this.agPA).postDelayed((Runnable)this, this.agPB);
        WxRefreshLayout.e(this.agPA).a(com.tencent.mm.view.refreshLayout.e.b.agQL);
        AppMethodBeat.o(235103);
        return;
      }
      Object localObject1 = WxRefreshLayout.n(this.agPA);
      boolean bool;
      label324:
      int j;
      label386:
      label471:
      Object localObject3;
      label737:
      WxRefreshLayout.c..ExternalSyntheticLambda0 localExternalSyntheticLambda0;
      if (localObject1 == null)
      {
        i = 0;
        if (i < 2147483647)
        {
          localObject1 = WxRefreshLayout.h(this.agPA);
          if (localObject1 != null) {
            break label1197;
          }
          bool = false;
          if ((!paramBoolean2) || (!this.agPA.getCommonConfig().agPI)) {
            break label1209;
          }
          Object localObject2 = WxRefreshLayout.d(this.agPA);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU >= 0) || (!bool)) {
            break label1209;
          }
          j = 1;
          localObject2 = WxRefreshLayout.d(this.agPA);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          int k = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU;
          if (j == 0) {
            break label1215;
          }
          localObject2 = WxRefreshLayout.d(this.agPA);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          j = Math.max(((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU, -this.agPA.getFooterConfig().footerHeight);
          k -= j;
          localObject2 = WxRefreshLayout.d(this.agPA);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH) || (WxRefreshLayout.j(this.agPA)))
          {
            long l = System.currentTimeMillis();
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            float f1;
            if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH)
            {
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              localObject3 = WxRefreshLayout.d(this.agPA);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("cValues");
                localObject2 = null;
              }
              ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn = ((com.tencent.mm.view.refreshLayout.a.b)localObject2).Mlk;
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              localObject3 = WxRefreshLayout.d(this.agPA);
              localObject2 = localObject3;
              if (localObject3 == null)
              {
                s.bIx("cValues");
                localObject2 = null;
              }
              ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPZ = (((com.tencent.mm.view.refreshLayout.a.b)localObject2).agPU - k);
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH = false;
              if (!this.agPA.getCommonConfig().agPH) {
                break label1221;
              }
              j = k;
              localObject3 = this.agPA;
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              f1 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj;
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              float f2 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk;
              float f3 = j;
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              WxRefreshLayout.a((WxRefreshLayout)localObject3, MotionEvent.obtain(l, l, 0, f1, f3 + f2 + ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doK * 2, 0));
              localObject3 = this.agPA;
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              f1 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj;
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              WxRefreshLayout.a((WxRefreshLayout)localObject3, MotionEvent.obtain(l, l, 2, f1, ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk + j, 0));
            }
            if (WxRefreshLayout.j(this.agPA))
            {
              WxRefreshLayout.k(this.agPA);
              localObject3 = this.agPA;
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              f1 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj;
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              WxRefreshLayout.a((WxRefreshLayout)localObject3, MotionEvent.obtain(l, l, 1, f1, ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk, 0));
              WxRefreshLayout.l(this.agPA);
              localObject2 = WxRefreshLayout.d(this.agPA);
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cValues");
                localObject1 = null;
              }
              ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPZ = 0;
            }
          }
          localObject3 = WxRefreshLayout.i(this.agPA);
          localExternalSyntheticLambda0 = new WxRefreshLayout.c..ExternalSyntheticLambda0(this.agPA, k, paramBoolean2);
          localObject2 = WxRefreshLayout.d(this.agPA);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU >= 0) {
            break label1227;
          }
        }
      }
      for (;;)
      {
        ((MMHandler)localObject3).postDelayed(localExternalSyntheticLambda0, i);
        label1168:
        AppMethodBeat.o(235103);
        return;
        i = ((f)localObject1).a((com.tencent.mm.view.refreshLayout.b.e)this.agPA, paramBoolean1);
        break;
        label1197:
        bool = ((com.tencent.mm.view.refreshLayout.b.a)localObject1).egB();
        break label324;
        label1209:
        j = 0;
        break label386;
        label1215:
        j = 0;
        break label471;
        label1221:
        j = 0;
        break label737;
        label1227:
        i = 0;
      }
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/view/refreshLayout/WxRefreshLayout$finishLoadMore$runnable$1$run$1$listenerAdapter$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(WxRefreshLayout paramWxRefreshLayout, boolean paramBoolean) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(235141);
        if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(235141);
          return;
        }
        com.tencent.mm.view.refreshLayout.a.b localb = WxRefreshLayout.d(this.agPA);
        paramAnimator = localb;
        if (localb == null)
        {
          s.bIx("cValues");
          paramAnimator = null;
        }
        paramAnimator.agPX = false;
        if (paramBoolean) {
          this.agPA.Of(true);
        }
        if (WxRefreshLayout.e(this.agPA).jNO()) {
          WxRefreshLayout.e(this.agPA).a(com.tencent.mm.view.refreshLayout.e.b.agQO);
        }
        AppMethodBeat.o(235141);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/refreshLayout/WxRefreshLayout$finishRefresh$runnable$1", "Ljava/lang/Runnable;", "count", "", "getCount", "()I", "setCount", "(I)V", "run", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Runnable
  {
    private int count;
    
    d(WxRefreshLayout paramWxRefreshLayout, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
    
    public final void run()
    {
      AppMethodBeat.i(235092);
      Object localObject2;
      if (this.count == 0)
      {
        if ((WxRefreshLayout.e(this.agPA).jNI()) && (WxRefreshLayout.e(this.agPA).jNT())) {
          WxRefreshLayout.e(this.agPA).b(com.tencent.mm.view.refreshLayout.e.b.agQO);
        }
        while (paramBoolean2)
        {
          this.agPA.Of(true);
          AppMethodBeat.o(235092);
          return;
          if ((WxRefreshLayout.g(this.agPA).agRm != null) && (WxRefreshLayout.e(this.agPA).agRi.agQI) && ((WxRefreshLayout.e(this.agPA).agRi.mlX) || (WxRefreshLayout.e(this.agPA).jNJ())))
          {
            WxRefreshLayout.g(this.agPA).jNU();
            if (this.agPA.aGm(0) == null) {
              WxRefreshLayout.e(this.agPA).a(com.tencent.mm.view.refreshLayout.e.b.agQO);
            } else {
              WxRefreshLayout.e(this.agPA).a(com.tencent.mm.view.refreshLayout.e.b.agQP);
            }
          }
          else if ((WxRefreshLayout.e(this.agPA).jME()) && (WxRefreshLayout.f(this.agPA) != null) && (WxRefreshLayout.h(this.agPA) != null))
          {
            this.count += 1;
            WxRefreshLayout.i(this.agPA).postDelayed((Runnable)this, this.agPB);
            WxRefreshLayout.e(this.agPA).a(com.tencent.mm.view.refreshLayout.e.b.agQT);
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agJm = false;
            if (!paramBoolean2) {
              this.agPA.Of(false);
            }
          }
        }
      }
      Object localObject1 = WxRefreshLayout.f(this.agPA);
      int i;
      Object localObject3;
      com.tencent.mm.view.refreshLayout.b.a locala;
      if (localObject1 == null)
      {
        i = 0;
        this.agPA.flf();
        if (i >= 2147483647) {
          break label1297;
        }
        localObject2 = WxRefreshLayout.d(this.agPA);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if ((((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH) || (WxRefreshLayout.j(this.agPA)))
        {
          long l = System.currentTimeMillis();
          localObject2 = WxRefreshLayout.d(this.agPA);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          float f1;
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH)
          {
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            localObject3 = WxRefreshLayout.d(this.agPA);
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              s.bIx("cValues");
              localObject2 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).mkn = ((com.tencent.mm.view.refreshLayout.a.b)localObject2).Mlk;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPZ = 0;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doH = false;
            localObject3 = this.agPA;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            f1 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            float f2 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            float f3 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            WxRefreshLayout.a((WxRefreshLayout)localObject3, MotionEvent.obtain(l, l, 0, f1, f2 + f3 - ((com.tencent.mm.view.refreshLayout.a.b)localObject1).doK * 2, 0));
            localObject3 = this.agPA;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            f1 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            f2 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            WxRefreshLayout.a((WxRefreshLayout)localObject3, MotionEvent.obtain(l, l, 2, f1, f2 + ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU, 0));
          }
          if (WxRefreshLayout.j(this.agPA))
          {
            WxRefreshLayout.k(this.agPA);
            localObject3 = this.agPA;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            f1 = ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlj;
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            WxRefreshLayout.a((WxRefreshLayout)localObject3, MotionEvent.obtain(l, l, 1, f1, ((com.tencent.mm.view.refreshLayout.a.b)localObject1).Mlk, 0));
            WxRefreshLayout.l(this.agPA);
            localObject2 = WxRefreshLayout.d(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cValues");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPZ = 0;
          }
        }
        localObject2 = WxRefreshLayout.d(this.agPA);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("cValues");
          localObject1 = null;
        }
        if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU <= 0) {
          break label1179;
        }
        localObject3 = WxRefreshLayout.g(this.agPA);
        localObject2 = WxRefreshLayout.m(this.agPA);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("reboundInterpolator");
          localObject1 = null;
        }
        localObject3 = ((com.tencent.mm.view.refreshLayout.g.b)localObject3).a(0, i, (Interpolator)localObject1, this.agPA.getCommonConfig().reboundDuration);
        if (!this.agPA.getCommonConfig().agPL) {
          break label1303;
        }
        locala = WxRefreshLayout.h(this.agPA);
        if (locala != null) {
          break label1136;
        }
        localObject1 = null;
      }
      for (;;)
      {
        if ((localObject3 != null) && (localObject1 != null))
        {
          ((ValueAnimator)localObject3).addUpdateListener((ValueAnimator.AnimatorUpdateListener)localObject1);
          AppMethodBeat.o(235092);
          return;
          i = ((f)localObject1).a((com.tencent.mm.view.refreshLayout.b.e)this.agPA, paramBoolean1);
          break;
          label1136:
          localObject2 = WxRefreshLayout.d(this.agPA);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          localObject1 = locala.aGo(((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU);
          continue;
          label1179:
          localObject2 = WxRefreshLayout.d(this.agPA);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("cValues");
            localObject1 = null;
          }
          if (((com.tencent.mm.view.refreshLayout.a.b)localObject1).agPU < 0)
          {
            localObject3 = WxRefreshLayout.g(this.agPA);
            localObject2 = WxRefreshLayout.m(this.agPA);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("reboundInterpolator");
              localObject1 = null;
            }
            ((com.tencent.mm.view.refreshLayout.g.b)localObject3).a(0, i, (Interpolator)localObject1, this.agPA.getCommonConfig().reboundDuration);
            AppMethodBeat.o(235092);
            return;
          }
          this.agPA.db(0, false);
          WxRefreshLayout.e(this.agPA).c(com.tencent.mm.view.refreshLayout.e.b.agQO);
        }
        label1297:
        AppMethodBeat.o(235092);
        return;
        label1303:
        localObject1 = null;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/refreshLayout/WxRefreshLayout$setLoadingState$listener$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends AnimatorListenerAdapter
  {
    e(WxRefreshLayout paramWxRefreshLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(235085);
      if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(235085);
        return;
      }
      this.agPA.setDirectLoadingState(true);
      AppMethodBeat.o(235085);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/view/refreshLayout/WxRefreshLayout$setRefreshingState$listener$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends AnimatorListenerAdapter
  {
    f(WxRefreshLayout paramWxRefreshLayout) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(235081);
      if ((paramAnimator != null) && (paramAnimator.getDuration() == 0L)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(235081);
        return;
      }
      Object localObject = WxRefreshLayout.d(this.agPA);
      paramAnimator = (Animator)localObject;
      if (localObject == null)
      {
        s.bIx("cValues");
        paramAnimator = null;
      }
      paramAnimator.agQf = System.currentTimeMillis();
      WxRefreshLayout.e(this.agPA).a(com.tencent.mm.view.refreshLayout.e.b.agQV);
      paramAnimator = this.agPA.getOnSimpleAction();
      if (paramAnimator != null) {
        paramAnimator.onRefresh();
      }
      paramAnimator = WxRefreshLayout.f(this.agPA);
      if (paramAnimator != null)
      {
        localObject = this.agPA;
        if (((WxRefreshLayout)localObject).getHeaderConfig().agQn >= 10.0F) {
          break label159;
        }
        ((WxRefreshLayout)localObject).getHeaderConfig();
        ((WxRefreshLayout)localObject).getHeaderConfig();
      }
      for (;;)
      {
        com.tencent.mm.view.refreshLayout.b.e locale = (com.tencent.mm.view.refreshLayout.b.e)localObject;
        ((WxRefreshLayout)localObject).getHeaderConfig();
        paramAnimator.b(locale);
        AppMethodBeat.o(235081);
        return;
        label159:
        ((WxRefreshLayout)localObject).getHeaderConfig();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.view.refreshLayout.WxRefreshLayout
 * JD-Core Version:    0.7.0.1
 */