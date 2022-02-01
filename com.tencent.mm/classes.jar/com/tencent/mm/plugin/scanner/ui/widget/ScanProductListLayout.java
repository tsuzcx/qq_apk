package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.bd;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductListLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adjustPaddingBottom", "", "getAdjustPaddingBottom", "()Z", "setAdjustPaddingBottom", "(Z)V", "adjustPaddingTop", "getAdjustPaddingTop", "setAdjustPaddingTop", "closeExpandThreshold", "closeStateTopMargin", "getCloseStateTopMargin", "()I", "configuration", "Landroid/view/ViewConfiguration;", "disallowIntercept", "downY", "", "expandStatusPaddingTop", "extraHeaderHeight", "hasRecyclerViewScrollBy", "isAnimating", "setAnimating", "isChildCanScrollVertical", "isListExpandStatus", "isOverScrollBottom", "isOverScrollTop", "isVerticalMove", "lastY", "listCloseHeight", "listItemHeight", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "productListCallBack", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductListLayout$ProductListCallBack;", "getProductListCallBack", "()Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductListLayout$ProductListCallBack;", "setProductListCallBack", "(Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductListLayout$ProductListCallBack;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewItemCount", "getRecyclerViewItemCount", "totalMoveDeltaY", "canChildScrollDown", "canChildScrollUp", "canScrollRecyclerView", "checkMoveDirection", "", "currentY", "doRecyclerViewScrollBy", "deltaY", "getBottomFadingEdgeStrength", "getDealt", "dealt", "getRecyclerViewMarginLayoutParams", "Landroid/view/ViewGroup$MarginLayoutParams;", "getTopFadingEdgeStrength", "init", "isBottomOverScroll", "isTopOverScroll", "onBackPressed", "onFinishInflate", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "resetVertical", "event", "setDisallowInterceptTouchEvent", "setRecyclerViewMarginTop", "topMargin", "setRecyclerViewMarginTopAndBottom", "bottomMargin", "setRecyclerViewOriginalStatus", "height", "smoothBackToClosePosition", "smoothBackToExpandPosition", "smoothScrollTo", "startTopMargin", "endTopMargin", "adjustBottomMargin", "animationCallBack", "Lkotlin/Function1;", "smoothScrollToCloseStatus", "smoothScrollToExpandStatus", "updateRecyclerViewExpandStatusPaddingTop", "Companion", "ProductListCallBack", "ProductListState", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanProductListLayout
  extends RelativeLayout
{
  public static final ScanProductListLayout.a Pgl;
  private int PgA;
  private b Pgm;
  private ViewConfiguration Pgn;
  private int Pgo;
  private boolean Pgp;
  private boolean Pgq;
  private boolean Pgr;
  private boolean Pgs;
  private boolean Pgt;
  private int Pgu;
  private int Pgv;
  private int Pgw;
  private int Pgx;
  private boolean Pgy;
  private boolean Pgz;
  private boolean aLC;
  private float cxN;
  private float fig;
  private boolean isAnimating;
  private RecyclerView mkw;
  private float puQ;
  private float puR;
  private VelocityTracker puS;
  
  static
  {
    AppMethodBeat.i(314821);
    Pgl = new ScanProductListLayout.a((byte)0);
    AppMethodBeat.o(314821);
  }
  
  public ScanProductListLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(314731);
    init();
    AppMethodBeat.o(314731);
  }
  
  public ScanProductListLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(314734);
    init();
    AppMethodBeat.o(314734);
  }
  
  private final boolean LF()
  {
    AppMethodBeat.i(314746);
    if (this.mkw == null)
    {
      AppMethodBeat.o(314746);
      return false;
    }
    RecyclerView localRecyclerView = this.mkw;
    s.checkNotNull(localRecyclerView);
    boolean bool = localRecyclerView.canScrollVertically(-1);
    Log.i("MicroMsg.ScanProductListLayout", s.X("canChildScrollUp:", Boolean.valueOf(bool)));
    AppMethodBeat.o(314746);
    return bool;
  }
  
  private static final void a(int paramInt1, int paramInt2, boolean paramBoolean, ScanProductListLayout paramScanProductListLayout, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314796);
    s.u(paramScanProductListLayout, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanProductListLayout = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(314796);
      throw paramScanProductListLayout;
    }
    int j = ((Integer)paramValueAnimator).intValue();
    int i = paramInt2;
    if (paramBoolean) {
      i = paramInt2 - (j - paramInt1);
    }
    Log.i("MicroMsg.ScanProductListLayout", "smoothScrollTo  onAnimationUpdate  value:" + j + ", currentPaddingBottom:" + i);
    paramScanProductListLayout.kV(j, i);
    AppMethodBeat.o(314796);
  }
  
  private final void a(final int paramInt1, final int paramInt2, final boolean paramBoolean, final b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(314791);
    if (this.mkw == null)
    {
      AppMethodBeat.o(314791);
      return;
    }
    if (this.isAnimating)
    {
      Log.e("MicroMsg.ScanProductListLayout", "smoothScrollTo  startY:" + paramInt1 + ", endY:" + paramInt2 + "   isAnimating");
      AppMethodBeat.o(314791);
      return;
    }
    Log.i("MicroMsg.ScanProductListLayout", "smoothScrollTo  startY:" + paramInt1 + ", endY:" + paramInt2 + ",  adjustPaddingBottom:" + paramBoolean);
    paramb.invoke(Integer.valueOf(0));
    if (paramInt1 == paramInt2)
    {
      Log.w("MicroMsg.ScanProductListLayout", "smoothScrollTo  startPaddingTop == endPaddingTop");
      paramb.invoke(Integer.valueOf(1));
      AppMethodBeat.o(314791);
      return;
    }
    this.isAnimating = true;
    Object localObject = getRecyclerViewMarginLayoutParams();
    if (localObject == null)
    {
      AppMethodBeat.o(314791);
      return;
    }
    final int i = ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    localObject = ValueAnimator.ofInt(new int[] { paramInt1, paramInt2 });
    ((ValueAnimator)localObject).setDuration(250L);
    ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new e(this, paramInt2, paramInt1, i, paramBoolean, paramb));
    ((ValueAnimator)localObject).addUpdateListener(new ScanProductListLayout..ExternalSyntheticLambda0(paramInt1, i, paramBoolean, this));
    ((ValueAnimator)localObject).start();
    AppMethodBeat.o(314791);
  }
  
  private final boolean gTs()
  {
    AppMethodBeat.i(314749);
    if (this.mkw == null)
    {
      AppMethodBeat.o(314749);
      return false;
    }
    RecyclerView localRecyclerView = this.mkw;
    s.checkNotNull(localRecyclerView);
    boolean bool = localRecyclerView.canScrollVertically(1);
    Log.i("MicroMsg.ScanProductListLayout", s.X("canChildScrollDown:", Boolean.valueOf(bool)));
    AppMethodBeat.o(314749);
    return bool;
  }
  
  private final void gTt()
  {
    AppMethodBeat.i(314753);
    int i = getRecyclerViewItemCount();
    int j = getHeight();
    if (i < 4) {
      this.PgA = (j - this.Pgv);
    }
    for (;;)
    {
      Log.i("MicroMsg.ScanProductListLayout", s.X("updateRecyclerViewExpandStatusPaddingTop:", Integer.valueOf(this.PgA)));
      AppMethodBeat.o(314753);
      return;
      this.PgA = (j - i * this.Pgw + this.Pgw);
      if (this.PgA < 0) {
        this.PgA = 0;
      }
    }
  }
  
  private final void gTu()
  {
    AppMethodBeat.i(314782);
    Log.w("MicroMsg.ScanProductListLayout", "smoothScrollToCloseStatus");
    ViewGroup.MarginLayoutParams localMarginLayoutParams = getRecyclerViewMarginLayoutParams();
    if (localMarginLayoutParams == null)
    {
      AppMethodBeat.o(314782);
      return;
    }
    a(localMarginLayoutParams.topMargin, getCloseStateTopMargin(), false, (b)new f(this));
    AppMethodBeat.o(314782);
  }
  
  private final int getCloseStateTopMargin()
  {
    AppMethodBeat.i(314778);
    int i = getHeight();
    int j = this.Pgv;
    AppMethodBeat.o(314778);
    return i - j;
  }
  
  private final int getRecyclerViewItemCount()
  {
    AppMethodBeat.i(314741);
    if (this.mkw == null)
    {
      AppMethodBeat.o(314741);
      return 0;
    }
    Object localObject = this.mkw;
    s.checkNotNull(localObject);
    localObject = ((RecyclerView)localObject).getAdapter();
    if (localObject == null)
    {
      AppMethodBeat.o(314741);
      return 0;
    }
    int i = ((RecyclerView.a)localObject).getItemCount();
    AppMethodBeat.o(314741);
    return i;
  }
  
  private final ViewGroup.MarginLayoutParams getRecyclerViewMarginLayoutParams()
  {
    AppMethodBeat.i(314770);
    if (this.mkw == null)
    {
      AppMethodBeat.o(314770);
      return null;
    }
    Object localObject = this.mkw;
    s.checkNotNull(localObject);
    localObject = ((RecyclerView)localObject).getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(314770);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    AppMethodBeat.o(314770);
    return localObject;
  }
  
  private final void init()
  {
    AppMethodBeat.i(314737);
    this.Pgn = ViewConfiguration.get(getContext());
    this.Pgv = a.fromDPToPix(getContext(), 112);
    this.Pgw = a.fromDPToPix(getContext(), 56);
    this.Pgu = bd.fromDPToPix(getContext(), 20);
    AppMethodBeat.o(314737);
  }
  
  private final void kV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(314759);
    Log.d("MicroMsg.ScanProductListLayout", "setRecyclerViewMarginTopAndBottom  topMargin:" + paramInt1 + ", bottomMargin:" + paramInt2 + "  height:" + getHeight() + "  listCloseHeight:" + this.Pgw + ",  extraHeaderHeight:" + this.Pgx);
    if (this.mkw == null)
    {
      AppMethodBeat.o(314759);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = getRecyclerViewMarginLayoutParams();
    if (localMarginLayoutParams == null)
    {
      AppMethodBeat.o(314759);
      return;
    }
    localMarginLayoutParams.topMargin = paramInt1;
    localMarginLayoutParams.bottomMargin = paramInt2;
    RecyclerView localRecyclerView = this.mkw;
    s.checkNotNull(localRecyclerView);
    localRecyclerView.setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
    AppMethodBeat.o(314759);
  }
  
  private final void o(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(314775);
    if (this.isAnimating)
    {
      Log.e("MicroMsg.ScanProductListLayout", "doRecyclerViewScrollBy isAnimating, return");
      AppMethodBeat.o(314775);
      return;
    }
    this.Pgs = true;
    ViewGroup.MarginLayoutParams localMarginLayoutParams = getRecyclerViewMarginLayoutParams();
    if (localMarginLayoutParams == null)
    {
      AppMethodBeat.o(314775);
      return;
    }
    int j = localMarginLayoutParams.topMargin;
    int k = localMarginLayoutParams.bottomMargin;
    int i = j;
    if (paramBoolean1) {
      i = j + paramInt;
    }
    j = k;
    if (paramBoolean2) {
      j = k + -paramInt;
    }
    Log.e("MicroMsg.ScanProductListLayout", "doRecyclerViewScrollBy deltaY:" + paramInt + ", currentPaddingTop:" + i + ", currentPaddingBottom:" + j + ", adjustPaddingTop:" + paramBoolean1 + ", adjustPaddingBottom:" + paramBoolean2);
    kV(i, j);
    AppMethodBeat.o(314775);
  }
  
  private final void setRecyclerViewMarginTop(int paramInt)
  {
    AppMethodBeat.i(314763);
    Log.d("MicroMsg.ScanProductListLayout", "setRecyclerViewMarginTop  topMargin:" + paramInt + "   height:" + getHeight() + "  listCloseHeight:" + this.Pgw + ",  extraHeaderHeight:" + this.Pgx);
    if (this.mkw == null)
    {
      AppMethodBeat.o(314763);
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = getRecyclerViewMarginLayoutParams();
    if (localMarginLayoutParams == null)
    {
      AppMethodBeat.o(314763);
      return;
    }
    localMarginLayoutParams.topMargin = paramInt;
    RecyclerView localRecyclerView = this.mkw;
    s.checkNotNull(localRecyclerView);
    localRecyclerView.setLayoutParams((ViewGroup.LayoutParams)localMarginLayoutParams);
    AppMethodBeat.o(314763);
  }
  
  private final void setRecyclerViewOriginalStatus(int paramInt)
  {
    AppMethodBeat.i(314743);
    this.Pgt = false;
    kV(paramInt - this.Pgv - this.Pgx, 0);
    AppMethodBeat.o(314743);
  }
  
  public final boolean getAdjustPaddingBottom()
  {
    return this.Pgz;
  }
  
  public final boolean getAdjustPaddingTop()
  {
    return this.Pgy;
  }
  
  protected final float getBottomFadingEdgeStrength()
  {
    return 1.0F;
  }
  
  public final b getProductListCallBack()
  {
    return this.Pgm;
  }
  
  protected final float getTopFadingEdgeStrength()
  {
    return 1.0F;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(314832);
    if (this.Pgt)
    {
      gTu();
      this.Pgt = false;
      AppMethodBeat.o(314832);
      return true;
    }
    AppMethodBeat.o(314832);
    return false;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(314837);
    int j = getChildCount();
    if (j <= 1) {}
    Object localObject;
    for (int i = 1; i == 0; i = 0)
    {
      localObject = (Throwable)new IllegalStateException("ScanProductListLayout only can host a RecyclerView element".toString());
      AppMethodBeat.o(314837);
      throw ((Throwable)localObject);
    }
    if (j == 1)
    {
      localObject = getChildAt(0);
      if (!(localObject instanceof RecyclerView))
      {
        localObject = (Throwable)new IllegalStateException("ScanProductListLayout only can host a RecyclerView element".toString());
        AppMethodBeat.o(314837);
        throw ((Throwable)localObject);
      }
      s.s(localObject, "child");
      this.mkw = ((RecyclerView)localObject);
      localObject = this.mkw;
      s.checkNotNull(localObject);
      ((RecyclerView)localObject).setOverScrollMode(2);
    }
    super.onFinishInflate();
    AppMethodBeat.o(314837);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(314861);
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    if (bool)
    {
      AppMethodBeat.o(314861);
      return bool;
    }
    if (paramMotionEvent == null)
    {
      AppMethodBeat.o(314861);
      return false;
    }
    if (this.puS == null) {
      this.puS = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.puS;
    s.checkNotNull(localVelocityTracker);
    localVelocityTracker.addMovement(paramMotionEvent);
    localVelocityTracker = this.puS;
    s.checkNotNull(localVelocityTracker);
    localVelocityTracker.computeCurrentVelocity(1000);
    localVelocityTracker = this.puS;
    s.checkNotNull(localVelocityTracker);
    int i = (int)localVelocityTracker.getXVelocity();
    localVelocityTracker = this.puS;
    s.checkNotNull(localVelocityTracker);
    int j = (int)localVelocityTracker.getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 3: 
    case 4: 
    default: 
      bool = false;
    }
    for (;;)
    {
      Log.v("MicroMsg.ScanProductListLayout", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool) });
      AppMethodBeat.o(314861);
      return bool;
      Log.v("MicroMsg.ScanProductListLayout", "onInterceptTouchEvent pointer down");
      bool = false;
      continue;
      Log.v("MicroMsg.ScanProductListLayout", "onInterceptTouchEvent down");
      this.puQ = paramMotionEvent.getRawX();
      this.puR = paramMotionEvent.getRawY();
      this.fig = paramMotionEvent.getRawY();
      this.cxN = 0.0F;
      this.Pgo = 0;
      this.Pgp = false;
      this.Pgy = false;
      this.Pgz = false;
      this.Pgq = false;
      this.Pgr = false;
      this.Pgs = false;
      gTt();
      bool = false;
      continue;
      float f1 = paramMotionEvent.getRawX() - this.puQ;
      float f2 = paramMotionEvent.getRawY() - this.puR;
      Log.v("MicroMsg.ScanProductListLayout", "onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((Math.abs(f2) < 5.0F) || (Math.abs(f1) > 250.0F) || (Math.abs(j) <= Math.abs(i)) || (Math.abs(j) <= 0) || (Math.abs(f2) <= Math.abs(f1))) {
        break;
      }
      Log.i("MicroMsg.ScanProductListLayout", "onInterceptTouchEvent scroll vertical, scrollDown: %s, scrollUp: %s, ty: %s", new Object[] { Boolean.valueOf(gTs()), Boolean.valueOf(LF()), Float.valueOf(f2) });
      if ((f2 > 0.0F) && (!LF())) {
        bool = true;
      } else if ((f2 < 0.0F) && (!gTs())) {
        bool = true;
      } else if (!this.Pgt) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(314849);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i("MicroMsg.ScanProductListLayout", s.X("onSizeChanged:", Integer.valueOf(paramInt2)));
    setRecyclerViewOriginalStatus(paramInt2);
    AppMethodBeat.o(314849);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    AppMethodBeat.i(314903);
    boolean bool1;
    if (paramMotionEvent == null)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(314903);
      return bool1;
    }
    if (!this.aLC) {
      if (getRecyclerViewItemCount() <= 3) {
        break label68;
      }
    }
    label68:
    for (int i = 1; i == 0; i = 0)
    {
      bool1 = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(314903);
      return bool1;
    }
    i = paramMotionEvent.getAction() & 0xFF;
    Log.d("MicroMsg.ScanProductListLayout", s.X("onTouchEvent action:", Integer.valueOf(i)));
    switch (i)
    {
    }
    label892:
    do
    {
      for (;;)
      {
        bool1 = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(314903);
        return bool1;
        this.cxN = 0.0F;
        continue;
        this.fig = paramMotionEvent.getRawY();
        this.cxN = 0.0F;
        this.Pgo = 0;
        this.Pgp = false;
        this.Pgy = false;
        this.Pgz = false;
        this.Pgq = false;
        this.Pgr = false;
        this.Pgs = false;
        gTt();
        continue;
        Log.i("MicroMsg.ScanProductListLayout", "ACTION_MOVE  isOverScrollTop:" + this.Pgq + ", isOverScrollBottom:" + this.Pgr + ", hasRecyclerViewScrollBy: " + this.Pgs);
        Object localObject;
        if ((this.Pgq) || (this.Pgr) || (!this.Pgt))
        {
          f1 = paramMotionEvent.getRawY();
          if (this.cxN == 0.0F) {}
          for (i = 1; i != 0; i = 0)
          {
            this.cxN = f1;
            Log.w("MicroMsg.ScanProductListLayout", "ACTION_MOVE  oldY == 0");
            AppMethodBeat.o(314903);
            return true;
          }
          i = this.Pgo;
          this.Pgo += (int)((f1 - this.cxN) / 2.0F);
          i = this.Pgo - i;
          Log.i("MicroMsg.ScanProductListLayout", "ACTION_MOVE------totalMoveDeltaY:" + this.Pgo + ", delta:" + i + ", currentY: " + f1 + ", lastY: " + this.cxN);
          this.cxN = f1;
          if ((this.Pgq) && (this.Pgo < 0))
          {
            this.Pgo = 0;
            Log.i("MicroMsg.ScanProductListLayout", "ACTION_MOVE  isOverScrollTop------totalMoveDeltaY = 0");
          }
          if ((this.Pgr) && (this.Pgo > 0))
          {
            this.Pgo = 0;
            Log.i("MicroMsg.ScanProductListLayout", "ACTION_MOVE  isOverScrollBottom------totalMoveDeltaY = 0");
          }
          if (!this.Pgt)
          {
            this.Pgy = true;
            this.Pgz = false;
            if (!this.Pgs)
            {
              setRecyclerViewMarginTop(getCloseStateTopMargin());
              paramMotionEvent = this.Pgm;
              if (paramMotionEvent != null) {
                paramMotionEvent.aix(2);
              }
            }
            o(i, this.Pgy, this.Pgz);
          }
          do
          {
            AppMethodBeat.o(314903);
            return true;
            this.Pgy = true;
            this.Pgz = this.Pgr;
            if (!this.Pgs)
            {
              localObject = this.Pgm;
              if (localObject != null) {
                ((b)localObject).aix(5);
              }
            }
            o(i, this.Pgy, this.Pgz);
          } while (((!this.Pgq) || (this.Pgo != 0) || (this.Pgr)) && ((!this.Pgr) || (this.Pgo != 0) || (this.Pgq)));
          Log.w("MicroMsg.ScanProductListLayout", "ACTION_MOVE  由越界效果恢复到列表滚动");
          this.cxN = 0.0F;
          this.Pgq = false;
          this.Pgr = false;
          if ((gTs()) || (LF())) {}
          for (bool1 = true;; bool1 = false)
          {
            Log.i("MicroMsg.ScanProductListLayout", s.X("isChildCanScrollVertical :", Boolean.valueOf(bool1)));
            if (bool1) {
              break;
            }
            AppMethodBeat.o(314903);
            return true;
          }
          this.cxN = 0.0F;
          this.Pgo = 0;
          Log.i("MicroMsg.ScanProductListLayout", "resetVertical------totalMoveDeltaY = 0");
          paramMotionEvent.setAction(0);
          super.onTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(2);
          bool1 = super.onTouchEvent(paramMotionEvent);
          AppMethodBeat.o(314903);
          return bool1;
        }
        float f1 = paramMotionEvent.getRawY();
        if (!this.Pgp)
        {
          float f2 = Math.abs(f1 - this.fig);
          localObject = this.Pgn;
          s.checkNotNull(localObject);
          if (f2 >= ((ViewConfiguration)localObject).getScaledTouchSlop())
          {
            bool1 = true;
            this.Pgp = bool1;
          }
        }
        else
        {
          if (this.cxN != 0.0F) {
            break label892;
          }
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label898;
          }
          this.cxN = f1;
          Log.w("MicroMsg.ScanProductListLayout", s.X("ACTION_MOVE  oldY = currentY = ", Float.valueOf(this.cxN)));
          AppMethodBeat.o(314903);
          return true;
          bool1 = false;
          break;
        }
        if (this.Pgq) {
          bool1 = true;
        }
        for (;;)
        {
          Log.w("MicroMsg.ScanProductListLayout", s.X("ACTION_MOVE  tempOverScrollTop = ", Boolean.valueOf(bool1)));
          if ((this.Pgq) || (!bool1)) {
            break;
          }
          Log.w("MicroMsg.ScanProductListLayout", "ACTION_MOVE  !isOverScrollTop setAction ACTION_CANCEL");
          this.cxN = f1;
          this.Pgq = true;
          paramMotionEvent.setAction(3);
          super.onTouchEvent(paramMotionEvent);
          AppMethodBeat.o(314903);
          return true;
          if ((this.Pgp) && (this.cxN - f1 < 0.0F) && (!LF())) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
        this.Pgq = bool1;
        if (this.Pgr) {
          bool1 = true;
        }
        for (;;)
        {
          Log.w("MicroMsg.ScanProductListLayout", s.X("ACTION_MOVE  tempOverScrollBottom = ", Boolean.valueOf(bool1)));
          if ((this.Pgr) || (!bool1)) {
            break;
          }
          Log.w("MicroMsg.ScanProductListLayout", "ACTION_MOVE  !isOverScrollBottom setAction ACTION_CANCEL");
          this.cxN = f1;
          this.Pgr = true;
          paramMotionEvent.setAction(3);
          super.onTouchEvent(paramMotionEvent);
          AppMethodBeat.o(314903);
          return true;
          bool1 = bool2;
          if (this.Pgp)
          {
            bool1 = bool2;
            if (this.cxN - f1 > 0.0F)
            {
              bool1 = bool2;
              if (!gTs()) {
                bool1 = true;
              }
            }
          }
        }
        this.Pgr = bool1;
        this.cxN = f1;
        continue;
        this.cxN = 0.0F;
      }
      Log.i("MicroMsg.ScanProductListLayout", "ACTION_UP  isListExpandStatus:" + this.Pgt + ", totalMoveDeltaY:" + this.Pgo + ", hasRecyclerViewScrollBy:" + this.Pgs);
    } while (!this.Pgs);
    label898:
    if (this.Pgt) {
      if (this.Pgo > this.Pgu)
      {
        gTu();
        this.Pgt = false;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(314903);
      return true;
      bool1 = this.Pgz;
      Log.w("MicroMsg.ScanProductListLayout", s.X("smoothBackToExpandPosition  adjustPaddingBottom:", Boolean.valueOf(bool1)));
      paramMotionEvent = getRecyclerViewMarginLayoutParams();
      if (paramMotionEvent != null)
      {
        a(paramMotionEvent.topMargin, this.PgA, bool1, (b)new d(this));
        continue;
        if (-this.Pgo < this.Pgu)
        {
          Log.w("MicroMsg.ScanProductListLayout", "smoothBackToClosePosition");
          paramMotionEvent = getRecyclerViewMarginLayoutParams();
          if (paramMotionEvent != null) {
            a(paramMotionEvent.topMargin, getCloseStateTopMargin(), false, (b)new c(this));
          }
        }
        else
        {
          Log.w("MicroMsg.ScanProductListLayout", "smoothScrollToExpandStatus");
          paramMotionEvent = getRecyclerViewMarginLayoutParams();
          if (paramMotionEvent != null) {
            a(paramMotionEvent.topMargin, this.PgA, false, (b)new g(this));
          }
          this.Pgt = true;
        }
      }
    }
  }
  
  public final void setAdjustPaddingBottom(boolean paramBoolean)
  {
    this.Pgz = paramBoolean;
  }
  
  public final void setAdjustPaddingTop(boolean paramBoolean)
  {
    this.Pgy = paramBoolean;
  }
  
  public final void setAnimating(boolean paramBoolean)
  {
    this.isAnimating = paramBoolean;
  }
  
  public final void setDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    this.aLC = paramBoolean;
  }
  
  public final void setProductListCallBack(b paramb)
  {
    this.Pgm = paramb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanProductListLayout$ProductListCallBack;", "", "onProductListScrollStateChange", "", "state", "", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void aix(int paramInt);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<Integer, ah>
  {
    c(ScanProductListLayout paramScanProductListLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<Integer, ah>
  {
    d(ScanProductListLayout paramScanProductListLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanProductListLayout$smoothScrollTo$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(ScanProductListLayout paramScanProductListLayout, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, b<? super Integer, ah> paramb) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(314697);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(314697);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314695);
      s.u(paramAnimator, "animation");
      this.PgB.setAnimating(false);
      int k = paramInt2;
      int m = paramInt1;
      int j = i;
      int i = j;
      if (paramBoolean) {
        i = j - (k - m);
      }
      ScanProductListLayout.a(this.PgB, paramInt2, i);
      paramb.invoke(Integer.valueOf(1));
      Log.e("MicroMsg.ScanProductListLayout", "onAnimationEnd");
      AppMethodBeat.o(314695);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator)
    {
      AppMethodBeat.i(314701);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(314701);
    }
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(314690);
      s.u(paramAnimator, "animation");
      AppMethodBeat.o(314690);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements b<Integer, ah>
  {
    f(ScanProductListLayout paramScanProductListLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<Integer, ah>
  {
    g(ScanProductListLayout paramScanProductListLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanProductListLayout
 * JD-Core Version:    0.7.0.1
 */