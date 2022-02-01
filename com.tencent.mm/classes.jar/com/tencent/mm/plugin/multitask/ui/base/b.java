package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bd;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_CLIP_PANEL_FLAG", "", "DEFAULT_FADE_COLOR", "", "DEFAULT_OVERLAY_FLAG", "mAnchorPoint", "", "mCanSlide", "mClipPanel", "mCoveredFadeColor", "", "mCoveredFadePaint", "Landroid/graphics/Paint;", "mCoveredRoundPath", "Landroid/graphics/Path;", "mCurItemIndex", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mDragView", "Landroid/view/View;", "mExtraSlideRange", "mFadeOnClickListener", "Landroid/view/View$OnClickListener;", "mFirstLayout", "mInitialMotionX", "mInitialMotionY", "mIsSlidingLeft", "mIsUnableToDrag", "mLastItemIndex", "mLastNotDraggingSlideState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "mMainView", "mNeedAnchor", "mOverlayContent", "mPanelExpose", "mPanelSlideListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "mPanelWidth", "mParallaxOffset", "mPlaySound", "mPrevMotionX", "mPrevMotionY", "mShadowWidth", "mSlideOffset", "mSlideRange", "mSlideState", "mSlideableView", "mTmpRect", "Landroid/graphics/Rect;", "mVibrator", "Landroid/os/Vibrator;", "addPanelSlideListener", "", "listener", "applyParallaxForCurrentSlideOffset", "attachViewWrapper", "multTaskView", "launchView", "checkExpand", "computePanelLeftPosition", "slideOffset", "computeScroll", "computeSlideOffset", "leftPosition", "dispatchOnPanelItemSelected", "panel", "position", "dispatchOnPanelSizeChanged", "width", "height", "dispatchOnPanelSlide", "dispatchOnPanelStateChanged", "previousState", "newState", "dispatchOnPlaySound", "dispatchTouchEnd", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchTouchSlide", "dispatchTouchStart", "drawChild", "canvas", "Landroid/graphics/Canvas;", "child", "drawingTime", "getCanSlide", "getCurItem", "getCurrentParallaxOffset", "getPanelState", "getPanelWidth", "getShadowWidth", "hasOpaqueBackground", "v", "isAnchored", "isCollapsed", "isDragging", "isViewUnder", "view", "x", "y", "onAttachedToWindow", "onDetachedFromWindow", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPanelDragged", "newLeft", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "removePanelSlideListener", "resetAnchor", "setAllChildrenVisible", "setAnchorPoint", "anchorPoint", "setCanSlide", "enable", "setCoveredFadeColor", "color", "setCurrentItem", "item", "smoothScroll", "setDragView", "dragView", "setExtraSlideRange", "val", "setFadeOnClickListener", "setNeedAnchor", "needAnchor", "setOverlayed", "overlayed", "setPanelExpose", "setPanelState", "state", "withNoAnim", "duration", "setPanelStateInternal", "setPanelWidth", "setParallaxOffset", "setShadowWidth", "setSlideLeft", "isSlideLeft", "smoothSlideTo", "velocity", "smoothToBottom", "updateObscuredViewVisibility", "Companion", "PanelSlideListener", "PanelState", "ViewDragCallback", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends FrameLayout
{
  private static final float[] LBE;
  public static final b.a LEA;
  private static final int LFa;
  private static final int LFb;
  public com.tencent.mm.plugin.multitask.animation.c.a.b LCo;
  private boolean LEB;
  private boolean LEC;
  private View.OnClickListener LED;
  public CopyOnWriteArrayList<b> LEE;
  private int LEF;
  private int LEG;
  private final boolean LEH;
  private final long LEI;
  private final boolean LEJ;
  private boolean LEK;
  private boolean LEL;
  private final boolean LEM;
  private final Paint LEN;
  private final Path LEO;
  private float LEP;
  private float LEQ;
  private int LER;
  private int LES;
  private View LET;
  private int LEU;
  private float LEV;
  private int LEW;
  private int LEX;
  private c LEY;
  private c LEZ;
  private final Rect byy;
  private int ccl;
  private View ccp;
  private float ccq;
  private int ccs;
  public Vibrator cqQ;
  private boolean mCanSlide;
  private boolean mFirstLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsUnableToDrag;
  private View xTc;
  
  static
  {
    AppMethodBeat.i(304742);
    LEA = new b.a((byte)0);
    LFa = bd.fromDPToPix(MMApplicationContext.getContext(), 36);
    LFb = bd.fromDPToPix(MMApplicationContext.getContext(), 16);
    LBE = new float[] { LFb, LFb, 0.0F, 0.0F, 0.0F, 0.0F, LFb, LFb };
    AppMethodBeat.o(304742);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(304615);
    this.mCanSlide = true;
    this.LEE = new CopyOnWriteArrayList();
    this.LEF = 1;
    this.LEG = 1;
    this.LEI = 2566914048L;
    this.LEJ = true;
    this.LEL = this.LEH;
    this.LEM = this.LEJ;
    this.ccl = ((int)this.LEI);
    this.LEN = new Paint();
    this.LEO = new Path();
    this.byy = new Rect();
    this.mFirstLayout = true;
    this.LER = -1;
    this.LES = -1;
    this.LEV = 1.0F;
    this.LEW = -1;
    this.LEX = -1;
    this.LEY = c.LFd;
    this.LEZ = c.LFc;
    AppMethodBeat.o(304615);
  }
  
  private boolean a(float paramFloat, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(304622);
    if ((!isEnabled()) || (this.ccp == null))
    {
      AppMethodBeat.o(304622);
      return false;
    }
    int j = cH(paramFloat);
    com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.LCo;
    View localView;
    if (localb != null)
    {
      localView = this.ccp;
      if (localView == null)
      {
        i = 0;
        if (localb.a(localView, j, i, paramLong, paramBoolean) != true) {
          break label115;
        }
      }
    }
    label115:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label121;
      }
      Lu();
      z.Q((View)this);
      AppMethodBeat.o(304622);
      return true;
      i = localView.getTop();
      break;
    }
    label121:
    AppMethodBeat.o(304622);
    return false;
  }
  
  private final float act(int paramInt)
  {
    AppMethodBeat.i(304647);
    int i = cH(0.0F);
    if (this.LEK)
    {
      f = (i - paramInt) / this.ccs;
      AppMethodBeat.o(304647);
      return f;
    }
    float f = (paramInt - i) / this.ccs;
    AppMethodBeat.o(304647);
    return f;
  }
  
  private final int cH(float paramFloat)
  {
    AppMethodBeat.i(304640);
    View localView = this.ccp;
    if (localView == null) {}
    int j;
    for (int i = 0;; i = localView.getMeasuredWidth())
    {
      j = (int)(this.ccs * paramFloat);
      if (!this.LEK) {
        break;
      }
      i = getMeasuredWidth();
      k = getPaddingRight();
      m = this.LES;
      n = this.LEU;
      AppMethodBeat.o(304640);
      return i - k - (m + n) - j;
    }
    int k = getPaddingLeft();
    int m = this.LES;
    int n = this.LEU;
    AppMethodBeat.o(304640);
    return k - i + (m + n) + j;
  }
  
  private boolean g(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304619);
    if (paramView == null)
    {
      AppMethodBeat.o(304619);
      return false;
    }
    int[] arrayOfInt1 = new int[2];
    paramView.getLocationOnScreen(arrayOfInt1);
    int[] arrayOfInt2 = new int[2];
    getLocationOnScreen(arrayOfInt2);
    paramInt1 = arrayOfInt2[0] + paramInt1;
    paramInt2 = arrayOfInt2[1] + paramInt2;
    if ((paramInt1 >= arrayOfInt1[0]) && (paramInt1 < arrayOfInt1[0] + paramView.getWidth()) && (paramInt2 >= arrayOfInt1[1]) && (paramInt2 < arrayOfInt1[1] + paramView.getHeight()))
    {
      AppMethodBeat.o(304619);
      return true;
    }
    AppMethodBeat.o(304619);
    return false;
  }
  
  private final boolean gkw()
  {
    AppMethodBeat.i(304631);
    synchronized (this.LEE)
    {
      Object localObject1 = this.LEE.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        boolean bool = ((b)((Iterator)localObject1).next()).gkD();
        if (!bool)
        {
          AppMethodBeat.o(304631);
          return false;
        }
      }
      localObject1 = ah.aiuX;
      AppMethodBeat.o(304631);
      return true;
    }
  }
  
  private final void gkx()
  {
    AppMethodBeat.i(304635);
    if (this.LEX > 0)
    {
      int i = getCurrentParallaxOffset();
      z.d(this.xTc, i);
    }
    AppMethodBeat.o(304635);
  }
  
  private static boolean ii(View paramView)
  {
    AppMethodBeat.i(304653);
    if (paramView == null) {}
    for (paramView = null; (paramView != null) && (paramView.getOpacity() == -1); paramView = paramView.getBackground())
    {
      AppMethodBeat.o(304653);
      return true;
    }
    AppMethodBeat.o(304653);
    return false;
  }
  
  private final void setPanelStateInternal(c paramc)
  {
    AppMethodBeat.i(304628);
    if (this.LEY == paramc)
    {
      AppMethodBeat.o(304628);
      return;
    }
    c localc = this.LEY;
    this.LEY = paramc;
    if (paramc == c.LFc)
    {
      this.LEF = 0;
      Log.i("MicroMsg.MultiTaskViewGroup", "setPanelStateInternal, EXPANDED!");
    }
    Object localObject;
    while (this.LEF != this.LEG)
    {
      this.LEG = this.LEF;
      int i = this.LEF;
      synchronized (this.LEE)
      {
        localObject = this.LEE.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label159;
        }
        ((b)((Iterator)localObject).next()).acu(i);
      }
      if (paramc == c.LFd)
      {
        this.LEF = 1;
        Log.i("MicroMsg.MultiTaskViewGroup", "setPanelStateInternal, COLLAPSED!");
        continue;
        label159:
        localObject = ah.aiuX;
      }
    }
    synchronized (this.LEE)
    {
      localObject = this.LEE.iterator();
      if (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).a(localc, paramc);
      }
    }
    paramc = ah.aiuX;
    sendAccessibilityEvent(32);
    AppMethodBeat.o(304628);
  }
  
  public final void Lu()
  {
    AppMethodBeat.i(304816);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
    AppMethodBeat.o(304816);
  }
  
  public final void a(c paramc, long paramLong, boolean paramBoolean)
  {
    int j = 1;
    AppMethodBeat.i(304775);
    if ((paramc != null) && (paramc != c.LFg)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramc = (Throwable)new IllegalArgumentException("Panel state cannot be null or DRAGGING.".toString());
      AppMethodBeat.o(304775);
      throw paramc;
    }
    if ((!isEnabled()) || ((!this.mFirstLayout) && (this.ccp == null)) || (paramc == this.LEY) || (this.LEY == c.LFg))
    {
      AppMethodBeat.o(304775);
      return;
    }
    Object localObject = this.LCo;
    if ((localObject != null) && (((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).LCe == 2)) {}
    for (i = j;; i = 0)
    {
      if (i != 0)
      {
        Log.d("MicroMsg.MultiTaskViewGroup", "View is settling. Aborting animation.");
        localObject = this.LCo;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Fw();
        }
      }
      if (!this.mFirstLayout) {
        break;
      }
      setPanelStateInternal(paramc);
      AppMethodBeat.o(304775);
      return;
    }
    if (this.LEY == c.LFf)
    {
      localObject = this.ccp;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      requestLayout();
    }
    switch (e.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(304775);
      return;
    case 1: 
      a(this.LEV, paramLong, paramBoolean);
      AppMethodBeat.o(304775);
      return;
    case 2: 
      a(0.0F, 250L, paramBoolean);
      AppMethodBeat.o(304775);
      return;
    case 3: 
      a(1.0F, paramLong, paramBoolean);
      AppMethodBeat.o(304775);
      return;
    }
    j = cH(0.0F);
    if (this.LEK) {}
    for (i = this.LES + this.LEU;; i = -(this.LES + this.LEU))
    {
      a(act(i + j), paramLong, paramBoolean);
      break;
    }
  }
  
  public final void computeScroll()
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(304793);
    com.tencent.mm.plugin.multitask.animation.c.a.b localb;
    Boolean localBoolean;
    View localView;
    int i;
    if (this.LCo != null)
    {
      localb = this.LCo;
      if (localb == null)
      {
        if (!bool1) {
          break label339;
        }
        if (!isEnabled())
        {
          localb = this.LCo;
          if (localb != null) {
            localb.Fw();
          }
          AppMethodBeat.o(304793);
        }
      }
      else
      {
        localBoolean = Boolean.TRUE;
        if (localb.LCe == 2)
        {
          bool1 = localb.bwz.computeScrollOffset();
          int j = localb.bwz.getCurrX();
          int k = localb.bwz.getCurrY();
          localView = localb.LCi;
          if (localView != null) {
            break label314;
          }
          i = 0;
          label121:
          int m = j - i;
          localView = localb.LCi;
          if (localView != null) {
            break label323;
          }
          i = 0;
          label140:
          i = k - i;
          if (m != 0)
          {
            localView = localb.LCi;
            if (localView != null) {
              localView.offsetLeftAndRight(m);
            }
          }
          if (i != 0)
          {
            localView = localb.LCi;
            if (localView != null) {
              localView.offsetTopAndBottom(i);
            }
          }
          if ((m != 0) || (i != 0)) {
            localb.LCh.m(localb.LCi, j, k, m, i);
          }
          if ((!bool1) || (j != localb.bwz.getFinalX()) || (k != localb.bwz.getFinalY())) {
            break label346;
          }
          localb.bwz.abortAnimation();
          bool1 = localb.bwz.isFinished();
        }
      }
    }
    label314:
    label323:
    label339:
    label346:
    for (;;)
    {
      if (!bool1) {
        localb.bxO.post(localb.bxP);
      }
      bool1 = bool2;
      if (localb.LCe == 2) {
        bool1 = true;
      }
      bool1 = s.p(localBoolean, Boolean.valueOf(bool1));
      break;
      i = localView.getLeft();
      break label121;
      i = localView.getTop();
      break label140;
      z.Q((View)this);
      AppMethodBeat.o(304793);
      return;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    AppMethodBeat.i(304806);
    s.u(paramMotionEvent, "ev");
    int j = paramMotionEvent.getActionMasked();
    com.tencent.mm.plugin.multitask.animation.c.a.b localb;
    if (!this.mCanSlide)
    {
      localb = this.LCo;
      if ((localb == null) || (localb.bwz.isFinished() != true)) {
        break label101;
      }
    }
    for (;;)
    {
      if (i == 0) {
        if ((!this.mIsUnableToDrag) || (j == 0)) {
          break;
        }
      }
      localb = this.LCo;
      if (localb != null) {
        localb.Fw();
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(304806);
      return bool;
      label101:
      i = 0;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (j)
    {
    case 1: 
    default: 
    case 0: 
      for (;;)
      {
        bool = super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(304806);
        return bool;
        this.LEP = f1;
        this.LEQ = f2;
      }
    }
    float f3 = this.LEP;
    float f4 = this.LEQ;
    this.LEP = f1;
    this.LEQ = f2;
    if (Math.abs(f2 - f4) > Math.abs(f1 - f3))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(304806);
      return bool;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(304806);
    return bool;
  }
  
  protected final boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int j = 0;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject1 = null;
    AppMethodBeat.i(304804);
    s.u(paramCanvas, "canvas");
    s.u(paramView, "child");
    int k = paramCanvas.save();
    int i;
    boolean bool;
    if ((this.ccp != null) && (s.p(this.ccp, paramView)))
    {
      paramCanvas.getClipBounds(this.byy);
      if (!this.LEL)
      {
        if (this.LEK)
        {
          localObject2 = this.byy;
          j = this.byy.right;
          localObject3 = this.ccp;
          if (localObject3 == null) {
            if (localObject1 != null) {
              break label196;
            }
          }
          label196:
          for (i = this.byy.right;; i = ((Integer)localObject1).intValue())
          {
            ((Rect)localObject2).right = Math.min(j, i);
            if (this.LEM) {
              paramCanvas.clipRect(this.byy);
            }
            bool = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restoreToCount(k);
            AppMethodBeat.o(304804);
            return bool;
            localObject1 = Integer.valueOf(((View)localObject3).getRight());
            break;
          }
        }
        localObject3 = this.byy;
        j = this.byy.left;
        localObject1 = this.ccp;
        if (localObject1 == null)
        {
          localObject1 = localObject2;
          label236:
          if (localObject1 != null) {
            break label278;
          }
        }
        label278:
        for (i = this.byy.left;; i = ((Integer)localObject1).intValue())
        {
          ((Rect)localObject3).left = Math.max(j, i);
          break;
          localObject1 = Integer.valueOf(((View)localObject1).getLeft());
          break label236;
        }
      }
      if (this.LEK)
      {
        localObject2 = this.byy;
        j = this.byy.right;
        localObject1 = this.ccp;
        if (localObject1 == null)
        {
          localObject1 = localObject3;
          label325:
          if (localObject1 != null) {
            break label386;
          }
        }
        label386:
        for (i = this.byy.right;; i = ((Integer)localObject1).intValue())
        {
          ((Rect)localObject2).right = Math.max(j, i);
          this.byy.left -= getWidth();
          break;
          localObject1 = Integer.valueOf(((View)localObject1).getRight());
          break label325;
        }
      }
      localObject2 = this.byy;
      j = this.byy.left;
      localObject1 = this.ccp;
      if (localObject1 == null)
      {
        localObject1 = localObject4;
        label426:
        if (localObject1 != null) {
          break label487;
        }
      }
      label487:
      for (i = this.byy.left;; i = ((Integer)localObject1).intValue())
      {
        ((Rect)localObject2).left = Math.min(j, i);
        this.byy.right = (this.byy.left + getWidth());
        break;
        localObject1 = Integer.valueOf(((View)localObject1).getLeft());
        break label426;
      }
    }
    paramCanvas.getClipBounds(this.byy);
    int m;
    label549:
    float f1;
    float f2;
    if (!this.LEL) {
      if (this.LEK)
      {
        localObject1 = this.byy;
        m = this.byy.left;
        localObject2 = this.xTc;
        if (localObject2 == null)
        {
          i = 0;
          ((Rect)localObject1).right = Math.max(m, i);
          if ((!this.LEM) || (this.ccq <= 0.0F)) {
            break label1148;
          }
          f1 = 0.5F - LFa / getWidth();
          if (this.ccq < f1) {
            break label1148;
          }
          float f3 = (this.ccq - f1) / (1.0F - f1);
          f2 = LFb * f3;
          if (f2 >= 0.0F) {
            break label1106;
          }
          f1 = 0.0F;
          label635:
          LBE[0] = f1;
          LBE[1] = f1;
          LBE[6] = f1;
          LBE[7] = f1;
          i = (int)(255.0F * f3);
          if (i >= 0) {
            break label1129;
          }
          i = j;
          label683:
          this.LEO.reset();
          localObject1 = new RectF(this.byy);
          ((RectF)localObject1).left = (this.ccq * this.ccs);
          this.LEO.addRoundRect((RectF)localObject1, LBE, Path.Direction.CW);
          this.LEO.close();
          paramCanvas.clipPath(this.LEO);
          j = 1;
        }
      }
    }
    for (;;)
    {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((this.ccl != 0) && (this.ccq > 0.0F) && (j != 0))
      {
        j = this.ccl;
        this.LEN.setColor(i << 24 | j & 0xFFFFFF);
        paramView = new Rect(this.byy);
        paramView.left = ((int)(this.ccq * this.ccs));
        paramCanvas.drawRect(paramView, this.LEN);
      }
      break;
      i = ((View)localObject2).getTop();
      break label549;
      localObject2 = this.byy;
      m = this.byy.left;
      localObject1 = this.xTc;
      if (localObject1 == null)
      {
        localObject1 = localObject5;
        label886:
        if (localObject1 != null) {
          break label925;
        }
      }
      label925:
      for (i = getHeight();; i = ((Integer)localObject1).intValue())
      {
        ((Rect)localObject2).left = Math.min(m, i);
        break;
        localObject1 = Integer.valueOf(((View)localObject1).getBottom());
        break label886;
      }
      if (this.LEK)
      {
        localObject2 = this.byy;
        m = this.byy.right;
        localObject1 = this.xTc;
        if (localObject1 == null)
        {
          localObject1 = localObject6;
          label972:
          if (localObject1 != null) {
            break label1014;
          }
        }
        label1014:
        for (i = this.byy.right;; i = ((Integer)localObject1).intValue())
        {
          ((Rect)localObject2).right = Math.min(m, i);
          break;
          localObject1 = Integer.valueOf(((View)localObject1).getRight());
          break label972;
        }
      }
      localObject2 = this.byy;
      m = this.byy.left;
      localObject1 = this.xTc;
      if (localObject1 == null)
      {
        localObject1 = localObject7;
        label1054:
        if (localObject1 != null) {
          break label1096;
        }
      }
      label1096:
      for (i = this.byy.left;; i = ((Integer)localObject1).intValue())
      {
        ((Rect)localObject2).left = Math.max(m, i);
        break;
        localObject1 = Integer.valueOf(((View)localObject1).getLeft());
        break label1054;
      }
      label1106:
      f1 = f2;
      if (f2 <= LFb) {
        break label635;
      }
      f1 = LFb;
      break label635;
      label1129:
      if (i > 216)
      {
        i = 216;
        break label683;
      }
      break label683;
      label1148:
      j = 0;
      i = 0;
    }
  }
  
  public final boolean getCanSlide()
  {
    return this.mCanSlide;
  }
  
  public final int getCurItem()
  {
    return this.LEF;
  }
  
  public final int getCurrentParallaxOffset()
  {
    AppMethodBeat.i(304779);
    int i = (int)(this.LEX * Math.max(this.ccq, 0.0F));
    if (this.LEK)
    {
      i = -i;
      AppMethodBeat.o(304779);
      return i;
    }
    AppMethodBeat.o(304779);
    return i;
  }
  
  protected final com.tencent.mm.plugin.multitask.animation.c.a.b getMDragHelper()
  {
    return this.LCo;
  }
  
  public final c getPanelState()
  {
    return this.LEY;
  }
  
  public final int getPanelWidth()
  {
    return this.LER;
  }
  
  public final int getShadowWidth()
  {
    return this.LEW;
  }
  
  public final void gkt()
  {
    this.LEV = 1.0F;
    this.LEC = false;
  }
  
  public final boolean gku()
  {
    AppMethodBeat.i(304767);
    if (getPanelState() == c.LFe)
    {
      AppMethodBeat.o(304767);
      return true;
    }
    AppMethodBeat.o(304767);
    return false;
  }
  
  public final void gkv()
  {
    AppMethodBeat.i(304814);
    synchronized (this.LEE)
    {
      Iterator localIterator = this.LEE.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).gkB();
      }
    }
    ah localah = ah.aiuX;
    AppMethodBeat.o(304814);
  }
  
  public final void gky()
  {
    int i1 = 0;
    AppMethodBeat.i(304819);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(304819);
      return;
    }
    int i6 = getPaddingLeft();
    int i3 = getWidth();
    int i4 = getPaddingRight();
    int i5 = getPaddingTop();
    int n = getHeight();
    int i2 = getPaddingBottom();
    Object localObject = this.ccp;
    int m;
    int k;
    int j;
    int i;
    if (localObject == null)
    {
      localObject = null;
      m = 0;
      k = 0;
      j = 0;
      i = 0;
      if (localObject == null)
      {
        m = 0;
        k = 0;
        j = 0;
        i = 0;
      }
      localObject = getChildAt(0);
      i6 = Math.max(i6, ((View)localObject).getLeft());
      i5 = Math.max(i5, ((View)localObject).getTop());
      i3 = Math.min(i3 - i4, ((View)localObject).getRight());
      i2 = Math.min(n - i2, ((View)localObject).getBottom());
      n = i1;
      if (i6 >= i)
      {
        n = i1;
        if (i5 >= k)
        {
          n = i1;
          if (i3 <= j)
          {
            n = i1;
            if (i2 <= m) {
              n = 4;
            }
          }
        }
      }
      ((View)localObject).setVisibility(n);
      AppMethodBeat.o(304819);
      return;
    }
    if (ii(this.ccp))
    {
      i = ((View)localObject).getLeft();
      j = ((View)localObject).getRight();
      k = ((View)localObject).getTop();
      m = ((View)localObject).getBottom();
    }
    for (;;)
    {
      localObject = ah.aiuX;
      break;
      m = 0;
      k = 0;
      j = 0;
      i = 0;
    }
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(304795);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(304795);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(304796);
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(304796);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(304809);
    s.u(paramMotionEvent, "ev");
    com.tencent.mm.plugin.multitask.animation.c.a.b localb;
    if (!this.mCanSlide)
    {
      localb = this.LCo;
      if ((localb != null) && (localb.bwz.isFinished() == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        paramMotionEvent = this.LCo;
        if (paramMotionEvent != null) {
          paramMotionEvent.Fw();
        }
        AppMethodBeat.o(304809);
        return false;
      }
    }
    int i = paramMotionEvent.getActionMasked();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.mInitialMotionX);
    float f4 = Math.abs(f2 - this.mInitialMotionY);
    switch (i)
    {
    }
    label514:
    label518:
    for (;;)
    {
      localb = this.LCo;
      if (localb != null) {
        break;
      }
      AppMethodBeat.o(304809);
      return false;
      this.LEB = false;
      this.mIsUnableToDrag = false;
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.LEP = f1;
      this.LEQ = f2;
      if (!g(this.LET, (int)f1, (int)f2))
      {
        paramMotionEvent = this.LCo;
        if (paramMotionEvent != null) {
          paramMotionEvent.cancel();
        }
        this.mIsUnableToDrag = true;
        AppMethodBeat.o(304809);
        return false;
      }
      if ((this.LEF == 0) && (g(this.xTc, (int)f1, (int)f2)))
      {
        AppMethodBeat.o(304809);
        return true;
      }
      if (this.LEY == c.LFe)
      {
        AppMethodBeat.o(304809);
        return true;
        float f5 = f1 - this.LEP;
        float f6 = this.LEQ;
        this.LEP = f1;
        this.LEQ = f2;
        if ((f4 > f3) || (Math.abs(f2 - f6) > Math.abs(f5)))
        {
          if ((this.LEF == 0) && (g(this.xTc, (int)f1, (int)f2)))
          {
            AppMethodBeat.o(304809);
            return true;
          }
          paramMotionEvent = this.LCo;
          if (paramMotionEvent != null) {
            paramMotionEvent.cancel();
          }
          this.mIsUnableToDrag = true;
          AppMethodBeat.o(304809);
          return false;
        }
        if ((this.LEF == 1) && (g(this.xTc, (int)f1, (int)f2)) && (f5 < 0.0F))
        {
          paramMotionEvent = this.LCo;
          if (paramMotionEvent != null) {
            paramMotionEvent.cancel();
          }
          this.mIsUnableToDrag = true;
          AppMethodBeat.o(304809);
          return false;
          localb = this.LCo;
          if (localb != null) {
            if (localb.LCe == 1)
            {
              i = 1;
              if (i != 1) {
                break label514;
              }
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label518;
            }
            localb = this.LCo;
            if (localb != null) {
              localb.j(paramMotionEvent);
            }
            AppMethodBeat.o(304809);
            return true;
            i = 0;
            break;
          }
        }
      }
    }
    boolean bool = localb.i(paramMotionEvent);
    AppMethodBeat.o(304809);
    return bool;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304800);
    paramInt2 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    int i = getChildCount();
    Object localObject1;
    if (this.mFirstLayout) {
      localObject1 = this.LEY;
    }
    float f;
    switch (e.$EnumSwitchMapping$0[localObject1.ordinal()])
    {
    case 2: 
    default: 
      f = 0.0F;
    case 3: 
    case 1: 
      for (;;)
      {
        this.ccq = f;
        if (i <= 0) {
          break label238;
        }
        paramInt1 = 0;
        paramInt3 = paramInt1 + 1;
        localObject1 = getChildAt(paramInt1);
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(304800);
        throw ((Throwable)localObject1);
        f = 1.0F;
        continue;
        f = this.LEV;
      }
    }
    paramInt3 = cH(0.0F);
    if (this.LEK) {}
    for (paramInt1 = this.LES + this.LEU;; paramInt1 = -(this.LES + this.LEU))
    {
      f = act(paramInt1 + paramInt3);
      break;
    }
    Object localObject2 = (FrameLayout.LayoutParams)localObject2;
    label231:
    label238:
    int j;
    if ((((View)localObject1).getVisibility() == 8) && ((paramInt1 == 0) || (this.mFirstLayout)))
    {
      if (paramInt3 >= i)
      {
        if (this.mFirstLayout) {
          gky();
        }
        gkx();
        this.mFirstLayout = false;
        AppMethodBeat.o(304800);
      }
    }
    else
    {
      j = ((View)localObject1).getMeasuredWidth();
      if (!s.p(localObject1, this.ccp)) {
        break label332;
      }
    }
    label332:
    for (paramInt1 = cH(this.ccq);; paramInt1 = paramInt2)
    {
      int k = ((FrameLayout.LayoutParams)localObject2).topMargin + paramInt4;
      ((View)localObject1).layout(paramInt1, k, j + paramInt1, ((View)localObject1).getMeasuredHeight() + k);
      break label231;
      paramInt1 = paramInt3;
      break;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(304797);
    View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    this.xTc = getChildAt(0);
    this.ccp = getChildAt(1);
    if (this.LET == null) {
      setDragView(this.ccp);
    }
    int n = m - getPaddingTop() - getPaddingBottom();
    int i = k - getPaddingLeft() - getPaddingRight();
    int i1 = getChildCount();
    int j;
    Object localObject1;
    Object localObject2;
    if (i1 > 0)
    {
      paramInt1 = 0;
      j = paramInt1 + 1;
      localObject1 = getChildAt(paramInt1);
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(304797);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      if ((((View)localObject1).getVisibility() != 8) || (paramInt1 != 0))
      {
        if (!s.p(localObject1, this.xTc)) {
          break label322;
        }
        if ((this.LEL) || (this.LEY == c.LFf)) {
          break label423;
        }
      }
    }
    label386:
    label412:
    label418:
    label423:
    for (paramInt1 = i - this.LER;; paramInt1 = i)
    {
      paramInt1 -= ((FrameLayout.LayoutParams)localObject2).leftMargin + ((FrameLayout.LayoutParams)localObject2).rightMargin;
      for (;;)
      {
        if (((FrameLayout.LayoutParams)localObject2).height == -2)
        {
          paramInt2 = View.MeasureSpec.makeMeasureSpec(n, -2147483648);
          label236:
          if (((FrameLayout.LayoutParams)localObject2).width != -2) {
            break label386;
          }
        }
        for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648);; paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824))
        {
          ((View)localObject1).measure(paramInt1, paramInt2);
          if (s.p(localObject1, this.ccp))
          {
            this.ccs = (((View)localObject1).getMeasuredWidth() - (this.LES + this.LEU));
            this.LEX = this.ccs;
          }
          if (j < i1) {
            break label412;
          }
          setMeasuredDimension(k, m);
          AppMethodBeat.o(304797);
          return;
          label322:
          if (!s.p(localObject1, this.ccp)) {
            break label418;
          }
          paramInt1 = i - ((FrameLayout.LayoutParams)localObject2).leftMargin + this.LEU;
          break;
          if (((FrameLayout.LayoutParams)localObject2).height == -1)
          {
            paramInt2 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
            break label236;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(((FrameLayout.LayoutParams)localObject2).height, 1073741824);
          break label236;
          if (((FrameLayout.LayoutParams)localObject2).width != -1) {
            paramInt1 = ((FrameLayout.LayoutParams)localObject2).width;
          }
        }
        paramInt1 = j;
        break;
        paramInt1 = i;
      }
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(304786);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt2 != paramInt4) || (paramInt1 != paramInt3))
    {
      this.mFirstLayout = true;
      synchronized (this.LEE)
      {
        Iterator localIterator = this.LEE.iterator();
        if (localIterator.hasNext()) {
          ((b)localIterator.next()).jV(paramInt1, paramInt2);
        }
      }
      ah localah = ah.aiuX;
      AppMethodBeat.o(304786);
      return;
    }
    AppMethodBeat.o(304786);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(304812);
    s.u(paramMotionEvent, "ev");
    Object localObject;
    int i;
    if (!this.mCanSlide)
    {
      localObject = this.LCo;
      if ((localObject != null) && (((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).bwz.isFinished() == true)) {}
      for (i = 1; i != 0; i = 0)
      {
        localObject = this.LCo;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Fw();
        }
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(304812);
        return bool;
      }
    }
    for (;;)
    {
      try
      {
        switch (paramMotionEvent.getActionMasked())
        {
        case 2: 
          localObject = this.LCo;
          if (localObject != null) {
            ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).j(paramMotionEvent);
          }
          AppMethodBeat.o(304812);
          return true;
        }
      }
      catch (Exception paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.MultiTaskViewGroup", (Throwable)paramMotionEvent, "get a Exception", new Object[0]);
        AppMethodBeat.o(304812);
        return false;
      }
      float f2 = paramMotionEvent.getX();
      float f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.mInitialMotionX);
      f1 = Math.abs(f1 - this.mInitialMotionY);
      localObject = this.LCo;
      if (localObject == null)
      {
        localObject = null;
        if (localObject != null) {
          break label342;
        }
      }
      label342:
      for (i = ViewConfiguration.get(getContext()).getScaledTouchSlop();; i = ((Integer)localObject).intValue())
      {
        if ((f1 > i) || (f2 > i) || (this.LEF != 0) || (this.ccq <= 0.0F) || (!g(this.xTc, (int)this.mInitialMotionX, (int)this.mInitialMotionY)) || (this.LED == null) || (getPanelState() == c.LFg)) {
          break label352;
        }
        paramMotionEvent = this.LED;
        if (paramMotionEvent != null) {
          paramMotionEvent.onClick((View)this);
        }
        AppMethodBeat.o(304812);
        return true;
        localObject = Integer.valueOf(((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).doK);
        break;
      }
      label352:
      if ((f1 <= i) && (f2 <= i) && (this.ccq > 0.0F) && (this.LEY == c.LFe))
      {
        paramMotionEvent = this.LED;
        if (paramMotionEvent != null) {
          paramMotionEvent.onClick((View)this);
        }
        AppMethodBeat.o(304812);
        return true;
      }
    }
  }
  
  public final void setAnchorPoint(float paramFloat)
  {
    this.LEV = paramFloat;
    this.LEC = true;
  }
  
  public final void setCanSlide(boolean paramBoolean)
  {
    this.mCanSlide = paramBoolean;
  }
  
  public final void setCoveredFadeColor(int paramInt)
  {
    AppMethodBeat.i(304764);
    this.ccl = paramInt;
    requestLayout();
    AppMethodBeat.o(304764);
  }
  
  public final void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(304758);
    gkt();
    if (paramInt == 0) {
      if (paramBoolean) {
        a(c.LFc, 0L, false);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        this.LEF = paramInt;
      }
      AppMethodBeat.o(304758);
      return;
      a(c.LFc, 0L, true);
      continue;
      if (paramBoolean) {
        a(c.LFd, 0L, false);
      } else {
        a(c.LFd, 0L, true);
      }
    }
  }
  
  public final void setDragView(View paramView)
  {
    this.LET = paramView;
  }
  
  public final void setExtraSlideRange(int paramInt)
  {
    this.LEU = paramInt;
  }
  
  public final void setFadeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(304747);
    s.u(paramOnClickListener, "listener");
    this.LED = paramOnClickListener;
    AppMethodBeat.o(304747);
  }
  
  protected final void setMDragHelper(com.tencent.mm.plugin.multitask.animation.c.a.b paramb)
  {
    this.LCo = paramb;
  }
  
  public final void setNeedAnchor(boolean paramBoolean)
  {
    this.LEC = paramBoolean;
  }
  
  public final void setOverlayed(boolean paramBoolean)
  {
    this.LEL = paramBoolean;
  }
  
  public final void setPanelExpose(int paramInt)
  {
    this.LES = paramInt;
  }
  
  public final void setPanelWidth(int paramInt)
  {
    AppMethodBeat.i(304766);
    if (getPanelWidth() == paramInt)
    {
      AppMethodBeat.o(304766);
      return;
    }
    this.LER = paramInt;
    if (!this.mFirstLayout) {
      requestLayout();
    }
    if (getPanelState() == c.LFd)
    {
      a(0.0F, 0L, false);
      invalidate();
      AppMethodBeat.o(304766);
      return;
    }
    AppMethodBeat.o(304766);
  }
  
  public final void setParallaxOffset(int paramInt)
  {
    AppMethodBeat.i(304783);
    this.LEX = paramInt;
    if (!this.mFirstLayout) {
      requestLayout();
    }
    AppMethodBeat.o(304783);
  }
  
  public final void setShadowWidth(int paramInt)
  {
    AppMethodBeat.i(304777);
    this.LEW = paramInt;
    if (!this.mFirstLayout) {
      invalidate();
    }
    AppMethodBeat.o(304777);
  }
  
  public final void setSlideLeft(boolean paramBoolean)
  {
    this.LEK = paramBoolean;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "", "enableExpand", "", "onPanelItemSelected", "", "panel", "Landroid/view/View;", "position", "", "onPanelSizeChanged", "screenSizeW", "screenSizeH", "onPanelSlide", "slideOffset", "", "onPanelStateChanged", "previousState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "newState", "onPanelTouchEnd", "onPanelTouchSlide", "onPanelTouchStart", "onPlaySound", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(b.c paramc1, b.c paramc2);
    
    public abstract void acu(int paramInt);
    
    public abstract void cI(float paramFloat);
    
    public abstract void cJ(float paramFloat);
    
    public abstract void gkA();
    
    public abstract void gkB();
    
    public abstract void gkC();
    
    public abstract boolean gkD();
    
    public abstract void jV(int paramInt1, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "ANCHORED", "HIDDEN", "DRAGGING", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum c
  {
    static
    {
      AppMethodBeat.i(304594);
      LFc = new c("EXPANDED", 0);
      LFd = new c("COLLAPSED", 1);
      LFe = new c("ANCHORED", 2);
      LFf = new c("HIDDEN", 3);
      LFg = new c("DRAGGING", 4);
      LFh = new c[] { LFc, LFd, LFe, LFf, LFg };
      AppMethodBeat.o(304594);
    }
    
    private c() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;)V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "pointerId", "plugin-multitask_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends com.tencent.mm.plugin.multitask.animation.c.a.b.a
    implements com.tencent.mm.ui.base.b.b
  {
    public d()
    {
      AppMethodBeat.i(304557);
      AppMethodBeat.o(304557);
    }
    
    public final void F(int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(304609);
      Log.d("MicroMsg.MultiTaskViewGroup", s.X("onViewDragStateChanged, state:", Integer.valueOf(paramInt)));
      Object localObject;
      View localView;
      if (this.LFi.getMDragHelper() != null)
      {
        localObject = this.LFi.getMDragHelper();
        if ((localObject == null) || (((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).LCe != 0)) {
          break label141;
        }
        paramInt = 1;
        if (paramInt != 0)
        {
          localObject = this.LFi;
          b localb = this.LFi;
          localView = b.j(this.LFi);
          if (localView != null) {
            break label146;
          }
          paramInt = 0;
          label83:
          b.b((b)localObject, b.b(localb, paramInt));
          b.k(this.LFi);
          if (b.h(this.LFi) != 1.0F) {
            break label155;
          }
          paramInt = 1;
          label114:
          if (paramInt == 0) {
            break label160;
          }
          this.LFi.gky();
        }
      }
      label141:
      label146:
      label155:
      label160:
      label241:
      do
      {
        b.a(this.LFi, b.c.LFc);
        do
        {
          AppMethodBeat.o(304609);
          return;
          paramInt = 0;
          break;
          paramInt = localView.getLeft();
          break label83;
          paramInt = 0;
          break label114;
          paramInt = i;
          if (b.h(this.LFi) == 0.0F) {
            paramInt = 1;
          }
          if (paramInt != 0)
          {
            b.a(this.LFi, b.c.LFd);
            AppMethodBeat.o(304609);
            return;
          }
          if (b.h(this.LFi) >= 0.0F) {
            break label241;
          }
          b.a(this.LFi, b.c.LFf);
          localObject = b.j(this.LFi);
        } while (localObject == null);
        ((View)localObject).setVisibility(4);
        AppMethodBeat.o(304609);
        return;
        this.LFi.gky();
        if (b.l(this.LFi))
        {
          b.a(this.LFi, b.c.LFe);
          AppMethodBeat.o(304609);
          return;
        }
      } while (b.h(this.LFi) > 0.3F);
      b.a(this.LFi, b.c.LFd);
      AppMethodBeat.o(304609);
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(304618);
      Log.d("MicroMsg.MultiTaskViewGroup", "touchX: %f, touchY: %f, dx: %d, dy: %d, adx: %d, ady: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      Object localObject1 = this.LFi;
      paramFloat1 = b.h(this.LFi);
      synchronized (((b)localObject1).LEE)
      {
        localObject1 = ((b)localObject1).LEE.iterator();
        if (((Iterator)localObject1).hasNext()) {
          ((b.b)((Iterator)localObject1).next()).cJ(paramFloat1);
        }
      }
      ah localah = ah.aiuX;
      AppMethodBeat.o(304618);
    }
    
    public final int aXi()
    {
      AppMethodBeat.i(304577);
      int i = b.d(this.LFi);
      AppMethodBeat.o(304577);
      return i;
    }
    
    public final int acl(int paramInt)
    {
      AppMethodBeat.i(304604);
      int i = b.a(this.LFi, 0.0F);
      int j = b.a(this.LFi, 1.0F);
      if (b.e(this.LFi))
      {
        paramInt = Math.min(Math.max(paramInt, j), i);
        AppMethodBeat.o(304604);
        return paramInt;
      }
      paramInt = Math.min(Math.max(paramInt, i), j);
      AppMethodBeat.o(304604);
      return paramInt;
    }
    
    public final boolean b(View arg1, int paramInt)
    {
      AppMethodBeat.i(304568);
      if (??? == null) {}
      for (??? = null;; ??? = ???.toString())
      {
        Log.d("MicroMsg.MultiTaskViewGroup", "tryCaptureView, child: %s", new Object[] { ??? });
        Object localObject1 = this.LFi;
        synchronized (((b)localObject1).LEE)
        {
          localObject1 = ((b)localObject1).LEE.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((b.b)((Iterator)localObject1).next()).gkA();
        }
      }
      ah localah = ah.aiuX;
      boolean bool;
      if (b.a(this.LFi) == b.c.LFd)
      {
        if (!b.b(this.LFi))
        {
          ??? = this.LFi.getMDragHelper();
          if (??? == null) {}
          for (bool = false; bool; bool = ???.jU(8, paramInt))
          {
            AppMethodBeat.o(304568);
            return true;
          }
        }
        AppMethodBeat.o(304568);
        return false;
      }
      if (b.a(this.LFi) == b.c.LFc)
      {
        if (!b.b(this.LFi))
        {
          ??? = this.LFi.getMDragHelper();
          if (??? == null) {}
          for (bool = false; bool; bool = ???.jU(4, paramInt))
          {
            AppMethodBeat.o(304568);
            return true;
          }
        }
        AppMethodBeat.o(304568);
        return false;
      }
      if (b.a(this.LFi) == b.c.LFg)
      {
        AppMethodBeat.o(304568);
        return true;
      }
      if (b.a(this.LFi) == b.c.LFe)
      {
        int i;
        if (!b.b(this.LFi))
        {
          ??? = this.LFi.getMDragHelper();
          if (??? == null)
          {
            bool = false;
            if (!bool) {
              break label366;
            }
            i = 1;
            label307:
            if (b.b(this.LFi)) {
              break label382;
            }
            ??? = this.LFi.getMDragHelper();
            if (??? != null) {
              break label371;
            }
            bool = false;
            label332:
            if (!bool) {
              break label382;
            }
          }
        }
        label366:
        label371:
        label382:
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt == 0) && (i == 0)) {
            break label387;
          }
          AppMethodBeat.o(304568);
          return true;
          bool = ???.jU(8, paramInt);
          break;
          i = 0;
          break label307;
          bool = ???.jU(4, paramInt);
          break label332;
        }
        label387:
        AppMethodBeat.o(304568);
        return false;
      }
      b.c(this.LFi);
      AppMethodBeat.o(304568);
      return false;
    }
    
    public final void d(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(304600);
      Log.d("MicroMsg.MultiTaskViewGroup", "onViewReleased, xvel: %f, yvel: %f, dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
      label96:
      com.tencent.mm.plugin.multitask.animation.c.a.b localb;
      label133:
      int i;
      if (b.e(this.LFi))
      {
        paramFloat2 = -paramFloat1;
        if (this.LFi.getWidth() <= 0) {
          break label611;
        }
        float f = this.LFi.getWidth();
        if (b.f(this.LFi) != 0) {
          break label288;
        }
        paramFloat4 = 0.25F;
        if (Math.abs(paramFloat3) >= paramFloat4 * f) {
          break label306;
        }
        f = Math.abs(paramFloat1);
        localb = this.LFi.getMDragHelper();
        if (localb != null) {
          break label296;
        }
        paramFloat4 = 0.0F;
        if (f > paramFloat4 * 0.95F) {
          break label306;
        }
        if (b.f(this.LFi) != 1) {
          break label619;
        }
        i = 0;
        paramFloat1 = 0.0F;
      }
      for (;;)
      {
        if (!b.g(this.LFi))
        {
          i = 0;
          paramFloat1 = 0.0F;
        }
        if ((paramFloat1 > 0.0F) && (b.h(this.LFi) <= b.i(this.LFi))) {
          i = b.a(this.LFi, b.i(this.LFi));
        }
        for (;;)
        {
          if ((this.LFi.getMDragHelper() != null) && (paramView != null))
          {
            localb = this.LFi.getMDragHelper();
            if (localb != null)
            {
              int j = paramView.getTop();
              if (!localb.bxN)
              {
                paramView = (Throwable)new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased".toString());
                AppMethodBeat.o(304600);
                throw paramView;
                paramFloat2 = paramFloat1;
                break;
                label288:
                paramFloat4 = 0.5F;
                break label96;
                label296:
                paramFloat4 = localb.uDV;
                break label133;
                label306:
                if (paramFloat1 == 0.0F) {}
                for (i = 1;; i = 0)
                {
                  if (i == 0) {
                    break label611;
                  }
                  paramFloat1 = paramFloat3;
                  if (b.e(this.LFi)) {
                    paramFloat1 = -paramFloat3;
                  }
                  i = 1;
                  break;
                }
                if ((paramFloat1 > 0.0F) && (b.h(this.LFi) > b.i(this.LFi)))
                {
                  i = b.a(this.LFi, 1.0F);
                  continue;
                }
                if ((paramFloat1 < 0.0F) && (b.h(this.LFi) >= b.i(this.LFi)))
                {
                  i = b.a(this.LFi, b.i(this.LFi));
                  continue;
                }
                if ((paramFloat1 >= 0.0F) || (b.h(this.LFi) >= b.i(this.LFi)))
                {
                  if ((b.h(this.LFi) >= (b.i(this.LFi) + 1.0F) / 2.0F) && (i != 0))
                  {
                    i = b.a(this.LFi, 1.0F);
                    continue;
                  }
                  if ((b.h(this.LFi) >= b.i(this.LFi) / 2.0F) && (i != 0))
                  {
                    i = b.a(this.LFi, b.i(this.LFi));
                    continue;
                  }
                }
                i = b.a(this.LFi, 0.0F);
                continue;
              }
              localb.a(i, j, (int)localb.mVelocityTracker.getXVelocity(localb.doI), (int)localb.mVelocityTracker.getYVelocity(localb.doI), 0L, false);
            }
          }
        }
        this.LFi.gkv();
        this.LFi.invalidate();
        AppMethodBeat.o(304600);
        return;
        label611:
        i = 1;
        paramFloat1 = paramFloat2;
        continue;
        label619:
        i = 1;
        paramFloat1 = 0.0F;
      }
    }
    
    public final void gjF()
    {
      AppMethodBeat.i(304616);
      Log.i("MicroMsg.MultiTaskViewGroup", "onViewCaptured");
      this.LFi.Lu();
      AppMethodBeat.o(304616);
    }
    
    public final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(304587);
      if (paramView == null) {}
      for (paramView = null;; paramView = paramView.toString())
      {
        Log.d("MicroMsg.MultiTaskViewGroup", "changedView: %s, left: %d, top: %d, dx: %d, dy: %d", new Object[] { paramView, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        b.a(this.LFi, paramInt1);
        this.LFi.invalidate();
        AppMethodBeat.o(304587);
        return;
      }
    }
    
    public final void onComplete(boolean paramBoolean)
    {
      AppMethodBeat.i(304611);
      Log.d("MicroMsg.MultiTaskViewGroup", "onComplete");
      AppMethodBeat.o(304611);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.b
 * JD-Core Version:    0.7.0.1
 */