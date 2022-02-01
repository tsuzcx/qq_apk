package com.tencent.mm.plugin.multitask.ui.base;

import android.annotation.SuppressLint;
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
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import androidx.core.g.j;
import androidx.core.g.v;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_CLIP_PANEL_FLAG", "", "DEFAULT_FADE_COLOR", "", "DEFAULT_OVERLAY_FLAG", "mAnchorPoint", "", "mCanSlide", "mClipPanel", "mCoveredFadeColor", "", "mCoveredFadePaint", "Landroid/graphics/Paint;", "mCoveredRoundPath", "Landroid/graphics/Path;", "mCurItemIndex", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mDragView", "Landroid/view/View;", "mExtraSlideRange", "mFadeOnClickListener", "Landroid/view/View$OnClickListener;", "mFirstLayout", "mInitialMotionX", "mInitialMotionY", "mIsSlidingLeft", "mIsUnableToDrag", "mLastItemIndex", "mLastNotDraggingSlideState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "mMainView", "mNeedAnchor", "mOverlayContent", "mPanelExpose", "mPanelSlideListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "mPanelWidth", "mParallaxOffset", "mPlaySound", "mPrevMotionX", "mPrevMotionY", "mShadowWidth", "mSlideOffset", "mSlideRange", "mSlideState", "mSlideableView", "mTmpRect", "Landroid/graphics/Rect;", "mVibrator", "Landroid/os/Vibrator;", "addPanelSlideListener", "", "listener", "applyParallaxForCurrentSlideOffset", "attachViewWrapper", "multTaskView", "launchView", "checkExpand", "computePanelLeftPosition", "slideOffset", "computeScroll", "computeSlideOffset", "leftPosition", "dispatchOnPanelItemSelected", "panel", "position", "dispatchOnPanelSizeChanged", "width", "height", "dispatchOnPanelSlide", "dispatchOnPanelStateChanged", "previousState", "newState", "dispatchOnPlaySound", "dispatchTouchEnd", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchTouchSlide", "dispatchTouchStart", "drawChild", "canvas", "Landroid/graphics/Canvas;", "child", "drawingTime", "getCanSlide", "getCurItem", "getCurrentParallaxOffset", "getPanelState", "getPanelWidth", "getShadowWidth", "hasOpaqueBackground", "v", "isAnchored", "isCollapsed", "isDragging", "isViewUnder", "view", "x", "y", "onAttachedToWindow", "onDetachedFromWindow", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPanelDragged", "newLeft", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "removePanelSlideListener", "resetAnchor", "setAllChildrenVisible", "setAnchorPoint", "anchorPoint", "setCanSlide", "enable", "setCoveredFadeColor", "color", "setCurrentItem", "item", "smoothScroll", "setDragView", "dragView", "setExtraSlideRange", "val", "setFadeOnClickListener", "setNeedAnchor", "needAnchor", "setOverlayed", "overlayed", "setPanelExpose", "setPanelState", "state", "withNoAnim", "duration", "setPanelStateInternal", "setPanelWidth", "setParallaxOffset", "setShadowWidth", "setSlideLeft", "isSlideLeft", "smoothSlideTo", "velocity", "smoothToBottom", "updateObscuredViewVisibility", "Companion", "PanelSlideListener", "PanelState", "ViewDragCallback", "plugin-multitask_release"})
public final class b
  extends FrameLayout
{
  private static final float[] FFH;
  private static final int FJJ;
  private static final int FJK;
  public static final b.a FJL;
  public com.tencent.mm.plugin.multitask.animation.c.a.b FGv;
  private int FJA;
  private int FJB;
  private View FJC;
  private int FJD;
  private float FJE;
  private int FJF;
  private int FJG;
  private c FJH;
  private c FJI;
  private boolean FJk;
  private boolean FJl;
  private View.OnClickListener FJm;
  public CopyOnWriteArrayList<b> FJn;
  private int FJo;
  private int FJp;
  private final boolean FJq;
  private final long FJr;
  private final boolean FJs;
  private boolean FJt;
  private boolean FJu;
  private final boolean FJv;
  private final Paint FJw;
  private final Path FJx;
  private float FJy;
  private float FJz;
  private final Rect Si;
  private int anF;
  private View anJ;
  private float anK;
  private int anM;
  private boolean mCanSlide;
  private boolean mFirstLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsUnableToDrag;
  public Vibrator rqy;
  private View uKG;
  
  static
  {
    AppMethodBeat.i(248111);
    FJL = new b.a((byte)0);
    FJJ = aw.fromDPToPix(MMApplicationContext.getContext(), 36);
    FJK = aw.fromDPToPix(MMApplicationContext.getContext(), 16);
    FFH = new float[] { FJK, FJK, 0.0F, 0.0F, 0.0F, 0.0F, FJK, FJK };
    AppMethodBeat.o(248111);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(248109);
    this.mCanSlide = true;
    this.FJn = new CopyOnWriteArrayList();
    this.FJo = 1;
    this.FJp = 1;
    this.FJr = 2566914048L;
    this.FJs = true;
    this.FJu = this.FJq;
    this.FJv = this.FJs;
    this.anF = ((int)this.FJr);
    this.FJw = new Paint();
    this.FJx = new Path();
    this.Si = new Rect();
    this.mFirstLayout = true;
    this.FJA = -1;
    this.FJB = -1;
    this.FJE = 1.0F;
    this.FJF = -1;
    this.FJG = -1;
    this.FJH = c.FJN;
    this.FJI = c.FJM;
    AppMethodBeat.o(248109);
  }
  
  private final float Yh(int paramInt)
  {
    AppMethodBeat.i(248105);
    int i = bD(0.0F);
    if (this.FJt)
    {
      f = (i - paramInt) / this.anM;
      AppMethodBeat.o(248105);
      return f;
    }
    float f = (paramInt - i) / this.anM;
    AppMethodBeat.o(248105);
    return f;
  }
  
  private boolean a(float paramFloat, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(248085);
    if ((!isEnabled()) || (this.anJ == null))
    {
      AppMethodBeat.o(248085);
      return false;
    }
    int j = bD(paramFloat);
    com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.FGv;
    if (localb != null)
    {
      View localView = this.anJ;
      if (localView != null) {}
      for (int i = localView.getTop(); localb.a(localView, j, i, paramLong, paramBoolean) == true; i = 0)
      {
        mS();
        w.G((View)this);
        AppMethodBeat.o(248085);
        return true;
      }
    }
    AppMethodBeat.o(248085);
    return false;
  }
  
  private final int bD(float paramFloat)
  {
    AppMethodBeat.i(248104);
    View localView = this.anJ;
    if (localView != null) {}
    int j;
    for (int i = localView.getMeasuredWidth();; i = 0)
    {
      j = (int)(this.anM * paramFloat);
      if (!this.FJt) {
        break;
      }
      i = getMeasuredWidth();
      k = getPaddingRight();
      m = this.FJB;
      n = this.FJD;
      AppMethodBeat.o(248104);
      return i - k - (m + n) - j;
    }
    int k = getPaddingLeft();
    int m = this.FJB;
    int n = this.FJD;
    AppMethodBeat.o(248104);
    return k - i + (m + n) + j;
  }
  
  private final boolean fbs()
  {
    AppMethodBeat.i(248101);
    synchronized (this.FJn)
    {
      Object localObject1 = this.FJn.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        boolean bool = ((b)((Iterator)localObject1).next()).fbz();
        if (!bool)
        {
          AppMethodBeat.o(248101);
          return false;
        }
      }
      localObject1 = x.aazN;
      AppMethodBeat.o(248101);
      return true;
    }
  }
  
  @SuppressLint({"NewApi"})
  private final void fbt()
  {
    AppMethodBeat.i(248103);
    if (this.FJG > 0)
    {
      int i = getCurrentParallaxOffset();
      w.c(this.uKG, i);
    }
    AppMethodBeat.o(248103);
  }
  
  private static boolean fw(View paramView)
  {
    AppMethodBeat.i(248108);
    if (paramView != null) {}
    for (paramView = paramView.getBackground(); (paramView != null) && (paramView.getOpacity() == -1); paramView = null)
    {
      AppMethodBeat.o(248108);
      return true;
    }
    AppMethodBeat.o(248108);
    return false;
  }
  
  private boolean g(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248083);
    if (paramView == null)
    {
      AppMethodBeat.o(248083);
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
      AppMethodBeat.o(248083);
      return true;
    }
    AppMethodBeat.o(248083);
    return false;
  }
  
  private final void setPanelStateInternal(c paramc)
  {
    AppMethodBeat.i(248098);
    if (this.FJH == paramc)
    {
      AppMethodBeat.o(248098);
      return;
    }
    c localc = this.FJH;
    this.FJH = paramc;
    if (paramc == c.FJM)
    {
      this.FJo = 0;
      Log.i("MicroMsg.MultiTaskViewGroup", "setPanelStateInternal, EXPANDED!");
    }
    Object localObject;
    while (this.FJo != this.FJp)
    {
      this.FJp = this.FJo;
      int i = this.FJo;
      synchronized (this.FJn)
      {
        localObject = this.FJn.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label159;
        }
        ((b)((Iterator)localObject).next()).Yi(i);
      }
      if (paramc == c.FJN)
      {
        this.FJo = 1;
        Log.i("MicroMsg.MultiTaskViewGroup", "setPanelStateInternal, COLLAPSED!");
        continue;
        label159:
        localObject = x.aazN;
      }
    }
    synchronized (this.FJn)
    {
      localObject = this.FJn.iterator();
      if (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).a(localc, paramc);
      }
    }
    paramc = x.aazN;
    sendAccessibilityEvent(32);
    AppMethodBeat.o(248098);
  }
  
  public final void a(c paramc, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(248078);
    if ((paramc != null) && (paramc != c.FJQ)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramc = (Throwable)new IllegalArgumentException("Panel state cannot be null or DRAGGING.".toString());
      AppMethodBeat.o(248078);
      throw paramc;
    }
    if ((!isEnabled()) || ((!this.mFirstLayout) && (this.anJ == null)) || (paramc == this.FJH) || (this.FJH == c.FJQ))
    {
      AppMethodBeat.o(248078);
      return;
    }
    Object localObject = this.FGv;
    if ((localObject != null) && (((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGj == 2))
    {
      Log.d("MicroMsg.MultiTaskViewGroup", "View is settling. Aborting animation.");
      localObject = this.FGv;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).hL();
      }
    }
    if (this.mFirstLayout)
    {
      setPanelStateInternal(paramc);
      AppMethodBeat.o(248078);
      return;
    }
    if (this.FJH == c.FJP)
    {
      localObject = this.anJ;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      requestLayout();
    }
    if (paramc == null)
    {
      AppMethodBeat.o(248078);
      return;
    }
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(248078);
      return;
    case 1: 
      a(this.FJE, paramLong, paramBoolean);
      AppMethodBeat.o(248078);
      return;
    case 2: 
      a(0.0F, 250L, paramBoolean);
      AppMethodBeat.o(248078);
      return;
    case 3: 
      a(1.0F, paramLong, paramBoolean);
      AppMethodBeat.o(248078);
      return;
    }
    int j = bD(0.0F);
    if (this.FJt) {}
    for (i = this.FJB + this.FJD;; i = -(this.FJB + this.FJD))
    {
      a(Yh(i + j), paramLong, paramBoolean);
      break;
    }
  }
  
  public final void computeScroll()
  {
    boolean bool2 = false;
    AppMethodBeat.i(248086);
    Boolean localBoolean;
    Object localObject;
    boolean bool1;
    int i;
    if (this.FGv != null)
    {
      localBoolean = Boolean.TRUE;
      localObject = this.FGv;
      if (localObject != null) {
        if (((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGj == 2)
        {
          bool1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Qi.computeScrollOffset();
          int j = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Qi.getCurrX();
          int k = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Qi.getCurrY();
          View localView = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGn;
          if (localView == null) {
            break label316;
          }
          i = localView.getLeft();
          int m = j - i;
          localView = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGn;
          if (localView == null) {
            break label321;
          }
          i = localView.getTop();
          label110:
          i = k - i;
          if (m != 0)
          {
            localView = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGn;
            if (localView != null) {
              localView.offsetLeftAndRight(m);
            }
          }
          if (i != 0)
          {
            localView = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGn;
            if (localView != null) {
              localView.offsetTopAndBottom(i);
            }
          }
          if ((m != 0) || (i != 0)) {
            ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGm.l(((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGn, j, k, m, i);
          }
          if ((!bool1) || (j != ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Qi.getFinalX()) || (k != ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Qi.getFinalY())) {
            break label353;
          }
          ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Qi.abortAnimation();
          bool1 = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Qi.isFinished();
        }
      }
    }
    label316:
    label321:
    label353:
    for (;;)
    {
      if (!bool1) {
        ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Rx.post(((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Ry);
      }
      bool1 = bool2;
      if (((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGj == 2) {
        bool1 = true;
      }
      localObject = Boolean.valueOf(bool1);
      for (;;)
      {
        if (p.h(localBoolean, localObject))
        {
          if (!isEnabled())
          {
            localObject = this.FGv;
            if (localObject != null)
            {
              ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).hL();
              AppMethodBeat.o(248086);
              return;
              i = 0;
              break;
              i = 0;
              break label110;
              localObject = null;
              continue;
            }
            AppMethodBeat.o(248086);
            return;
          }
          w.G((View)this);
        }
      }
      AppMethodBeat.o(248086);
      return;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(248095);
    p.k(paramMotionEvent, "ev");
    int i = j.d(paramMotionEvent);
    if (!this.mCanSlide)
    {
      localb = this.FGv;
      if ((localb != null) && (localb.Qi.isFinished() == true)) {}
    }
    else
    {
      if ((!this.mIsUnableToDrag) || (i == 0)) {
        break label93;
      }
    }
    com.tencent.mm.plugin.multitask.animation.c.a.b localb = this.FGv;
    if (localb != null) {
      localb.hL();
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(248095);
    return bool;
    label93:
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i == 0)
    {
      this.FJy = f1;
      this.FJz = f2;
    }
    while (i != 2)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(248095);
      return bool;
    }
    float f3 = this.FJy;
    float f4 = this.FJz;
    this.FJy = f1;
    this.FJz = f2;
    if (Math.abs(f2 - f4) > Math.abs(f1 - f3))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(248095);
      return bool;
    }
    bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(248095);
    return bool;
  }
  
  protected final boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(248094);
    p.k(paramCanvas, "canvas");
    p.k(paramView, "child");
    int k = paramCanvas.save();
    Object localObject;
    View localView;
    int i;
    boolean bool;
    if ((this.anJ != null) && (p.h(this.anJ, paramView)))
    {
      paramCanvas.getClipBounds(this.Si);
      if (!this.FJu)
      {
        if (this.FJt)
        {
          localObject = this.Si;
          j = this.Si.right;
          localView = this.anJ;
          if (localView != null) {}
          for (i = localView.getRight();; i = this.Si.right)
          {
            ((Rect)localObject).right = Math.min(j, i);
            if (this.FJv) {
              paramCanvas.clipRect(this.Si);
            }
            bool = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restoreToCount(k);
            AppMethodBeat.o(248094);
            return bool;
          }
        }
        localObject = this.Si;
        j = this.Si.left;
        localView = this.anJ;
        if (localView != null) {}
        for (i = localView.getLeft();; i = this.Si.left)
        {
          ((Rect)localObject).left = Math.max(j, i);
          break;
        }
      }
      if (this.FJt)
      {
        localObject = this.Si;
        j = this.Si.right;
        localView = this.anJ;
        if (localView != null) {}
        for (i = localView.getRight();; i = this.Si.right)
        {
          ((Rect)localObject).right = Math.max(j, i);
          this.Si.left -= getWidth();
          break;
        }
      }
      localObject = this.Si;
      j = this.Si.left;
      localView = this.anJ;
      if (localView != null) {}
      for (i = localView.getLeft();; i = this.Si.left)
      {
        ((Rect)localObject).left = Math.min(j, i);
        this.Si.right = (this.Si.left + getWidth());
        break;
      }
    }
    paramCanvas.getClipBounds(this.Si);
    int m;
    label448:
    float f1;
    float f2;
    if (!this.FJu) {
      if (this.FJt)
      {
        localObject = this.Si;
        m = this.Si.left;
        localView = this.uKG;
        if (localView != null)
        {
          i = localView.getTop();
          ((Rect)localObject).right = Math.max(m, i);
          if ((!this.FJv) || (this.anK <= 0.0F)) {
            break label977;
          }
          f1 = 0.5F - FJJ / getWidth();
          if (this.anK < f1) {
            break label977;
          }
          float f3 = (this.anK - f1) / (1.0F - f1);
          f2 = FJK * f3;
          if (f2 >= 0.0F) {
            break label935;
          }
          f1 = 0.0F;
          label534:
          FFH[0] = f1;
          FFH[1] = f1;
          FFH[6] = f1;
          FFH[7] = f1;
          i = (int)(255.0F * f3);
          if (i >= 0) {
            break label958;
          }
          i = j;
          label582:
          this.FJx.reset();
          localObject = new RectF(this.Si);
          ((RectF)localObject).left = (this.anK * this.anM);
          this.FJx.addRoundRect((RectF)localObject, FFH, Path.Direction.CW);
          this.FJx.close();
          paramCanvas.clipPath(this.FJx);
        }
      }
    }
    for (j = 1;; j = 0)
    {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((this.anF != 0) && (this.anK > 0.0F) && (j != 0))
      {
        j = this.anF;
        this.FJw.setColor(i << 24 | j & 0xFFFFFF);
        paramView = new Rect(this.Si);
        paramView.left = ((int)(this.anK * this.anM));
        paramCanvas.drawRect(paramView, this.FJw);
      }
      break;
      i = 0;
      break label448;
      localObject = this.Si;
      m = this.Si.left;
      localView = this.uKG;
      if (localView != null) {}
      for (i = localView.getBottom();; i = getHeight())
      {
        ((Rect)localObject).left = Math.min(m, i);
        break;
      }
      if (this.FJt)
      {
        localObject = this.Si;
        m = this.Si.right;
        localView = this.uKG;
        if (localView != null) {}
        for (i = localView.getRight();; i = this.Si.right)
        {
          ((Rect)localObject).right = Math.min(m, i);
          break;
        }
      }
      localObject = this.Si;
      m = this.Si.left;
      localView = this.uKG;
      if (localView != null) {}
      for (i = localView.getLeft();; i = this.Si.left)
      {
        ((Rect)localObject).left = Math.max(m, i);
        break;
      }
      label935:
      f1 = f2;
      if (f2 <= FJK) {
        break label534;
      }
      f1 = FJK;
      break label534;
      label958:
      if (i > 216)
      {
        i = 216;
        break label582;
      }
      break label582;
      label977:
      i = 0;
    }
  }
  
  public final void fbp()
  {
    this.FJE = 1.0F;
    this.FJl = false;
  }
  
  public final boolean fbq()
  {
    AppMethodBeat.i(248076);
    if (getPanelState() == c.FJO)
    {
      AppMethodBeat.o(248076);
      return true;
    }
    AppMethodBeat.o(248076);
    return false;
  }
  
  public final void fbr()
  {
    AppMethodBeat.i(248100);
    synchronized (this.FJn)
    {
      Iterator localIterator = this.FJn.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).fbx();
      }
    }
    x localx = x.aazN;
    AppMethodBeat.o(248100);
  }
  
  public final void fbu()
  {
    int i1 = 0;
    AppMethodBeat.i(248107);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(248107);
      return;
    }
    int i6 = getPaddingLeft();
    int i3 = getWidth();
    int i4 = getPaddingRight();
    int i5 = getPaddingTop();
    int n = getHeight();
    int i2 = getPaddingBottom();
    View localView = this.anJ;
    int m;
    int k;
    int j;
    int i;
    if (localView != null) {
      if (fw(this.anJ))
      {
        m = localView.getLeft();
        k = localView.getRight();
        j = localView.getTop();
        i = localView.getBottom();
      }
    }
    for (;;)
    {
      localView = getChildAt(0);
      p.j(localView, "child");
      i6 = Math.max(i6, localView.getLeft());
      i5 = Math.max(i5, localView.getTop());
      i3 = Math.min(i3 - i4, localView.getRight());
      i2 = Math.min(n - i2, localView.getBottom());
      n = i1;
      if (i6 >= m)
      {
        n = i1;
        if (i5 >= j)
        {
          n = i1;
          if (i3 <= k)
          {
            n = i1;
            if (i2 <= i) {
              n = 4;
            }
          }
        }
      }
      localView.setVisibility(n);
      AppMethodBeat.o(248107);
      return;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
      continue;
      i = 0;
      j = 0;
      k = 0;
      m = 0;
    }
  }
  
  public final boolean getCanSlide()
  {
    return this.mCanSlide;
  }
  
  public final int getCurItem()
  {
    return this.FJo;
  }
  
  public final int getCurrentParallaxOffset()
  {
    AppMethodBeat.i(248080);
    int i = (int)(this.FJG * Math.max(this.anK, 0.0F));
    if (this.FJt)
    {
      i = -i;
      AppMethodBeat.o(248080);
      return i;
    }
    AppMethodBeat.o(248080);
    return i;
  }
  
  protected final com.tencent.mm.plugin.multitask.animation.c.a.b getMDragHelper()
  {
    return this.FGv;
  }
  
  public final c getPanelState()
  {
    return this.FJH;
  }
  
  public final int getPanelWidth()
  {
    return this.FJA;
  }
  
  public final int getShadowWidth()
  {
    return this.FJF;
  }
  
  public final void mS()
  {
    AppMethodBeat.i(248106);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      p.j(localView, "child");
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
    AppMethodBeat.o(248106);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(248088);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(248088);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(248089);
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(248089);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(248096);
    p.k(paramMotionEvent, "ev");
    com.tencent.mm.plugin.multitask.animation.c.a.b localb;
    if (!this.mCanSlide)
    {
      localb = this.FGv;
      if ((localb != null) && (localb.Qi.isFinished() == true))
      {
        paramMotionEvent = this.FGv;
        if (paramMotionEvent != null) {
          paramMotionEvent.hL();
        }
        AppMethodBeat.o(248096);
        return false;
      }
    }
    int i = j.d(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.mInitialMotionX);
    float f4 = Math.abs(f2 - this.mInitialMotionY);
    switch (i)
    {
    }
    for (;;)
    {
      localb = this.FGv;
      if (localb == null) {
        break;
      }
      boolean bool = localb.i(paramMotionEvent);
      AppMethodBeat.o(248096);
      return bool;
      this.FJk = false;
      this.mIsUnableToDrag = false;
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.FJy = f1;
      this.FJz = f2;
      if (!g(this.FJC, (int)f1, (int)f2))
      {
        paramMotionEvent = this.FGv;
        if (paramMotionEvent != null) {
          paramMotionEvent.cancel();
        }
        this.mIsUnableToDrag = true;
        AppMethodBeat.o(248096);
        return false;
      }
      if ((this.FJo == 0) && (g(this.uKG, (int)f1, (int)f2)))
      {
        AppMethodBeat.o(248096);
        return true;
      }
      if (this.FJH == c.FJO)
      {
        AppMethodBeat.o(248096);
        return true;
        float f5 = f1 - this.FJy;
        float f6 = this.FJz;
        this.FJy = f1;
        this.FJz = f2;
        if ((f4 > f3) || (Math.abs(f2 - f6) > Math.abs(f5)))
        {
          if ((this.FJo == 0) && (g(this.uKG, (int)f1, (int)f2)))
          {
            AppMethodBeat.o(248096);
            return true;
          }
          paramMotionEvent = this.FGv;
          if (paramMotionEvent != null) {
            paramMotionEvent.cancel();
          }
          this.mIsUnableToDrag = true;
          AppMethodBeat.o(248096);
          return false;
        }
        if ((this.FJo == 1) && (g(this.uKG, (int)f1, (int)f2)) && (f5 < 0.0F))
        {
          paramMotionEvent = this.FGv;
          if (paramMotionEvent != null) {
            paramMotionEvent.cancel();
          }
          this.mIsUnableToDrag = true;
          AppMethodBeat.o(248096);
          return false;
          localb = this.FGv;
          if (localb != null)
          {
            if (localb.FGj == 1) {}
            for (i = 1; i == 1; i = 0)
            {
              localb = this.FGv;
              if (localb != null) {
                localb.j(paramMotionEvent);
              }
              AppMethodBeat.o(248096);
              return true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(248096);
    return false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(248093);
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    int i = getChildCount();
    Object localObject1;
    if (this.mFirstLayout) {
      localObject1 = this.FJH;
    }
    float f;
    switch (c.jLJ[localObject1.ordinal()])
    {
    default: 
      f = 0.0F;
      this.anK = f;
      paramInt1 = 0;
    }
    Object localObject2;
    int j;
    for (;;)
    {
      if (paramInt1 < i)
      {
        localObject1 = getChildAt(paramInt1);
        p.j(localObject1, "child");
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(248093);
          throw ((Throwable)localObject1);
          f = 1.0F;
          break;
          f = this.FJE;
          break;
          paramInt2 = bD(0.0F);
          if (this.FJt) {}
          for (paramInt1 = this.FJB + this.FJD;; paramInt1 = -(this.FJB + this.FJD))
          {
            f = Yh(paramInt1 + paramInt2);
            break;
          }
        }
        localObject2 = (FrameLayout.LayoutParams)localObject2;
        if ((((View)localObject1).getVisibility() == 8) && ((paramInt1 == 0) || (this.mFirstLayout)))
        {
          paramInt1 += 1;
        }
        else
        {
          j = ((View)localObject1).getMeasuredWidth();
          if (!p.h(localObject1, this.anJ)) {
            break label324;
          }
        }
      }
    }
    label324:
    for (paramInt2 = bD(this.anK);; paramInt2 = paramInt3)
    {
      int k = ((FrameLayout.LayoutParams)localObject2).topMargin + paramInt4;
      ((View)localObject1).layout(paramInt2, k, j + paramInt2, ((View)localObject1).getMeasuredHeight() + k);
      break;
      if (this.mFirstLayout) {
        fbu();
      }
      fbt();
      this.mFirstLayout = false;
      AppMethodBeat.o(248093);
      return;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(248092);
    View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    this.uKG = getChildAt(0);
    this.anJ = getChildAt(1);
    if (this.FJC == null) {
      setDragView(this.anJ);
    }
    int n = m - getPaddingTop() - getPaddingBottom();
    int i = k - getPaddingLeft() - getPaddingRight();
    int i1 = getChildCount();
    int j = 0;
    Object localObject1;
    Object localObject2;
    if (j < i1)
    {
      localObject1 = getChildAt(j);
      p.j(localObject1, "child");
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(248092);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      if ((((View)localObject1).getVisibility() != 8) || (j != 0))
      {
        if (!p.h(localObject1, this.uKG)) {
          break label317;
        }
        if ((this.FJu) || (this.FJH == c.FJP)) {
          break label427;
        }
      }
    }
    label422:
    label427:
    for (paramInt1 = i - this.FJA;; paramInt1 = i)
    {
      paramInt1 -= ((FrameLayout.LayoutParams)localObject2).leftMargin + ((FrameLayout.LayoutParams)localObject2).rightMargin;
      for (;;)
      {
        label225:
        if (((FrameLayout.LayoutParams)localObject2).height == -2)
        {
          paramInt2 = View.MeasureSpec.makeMeasureSpec(n, -2147483648);
          label244:
          if (((FrameLayout.LayoutParams)localObject2).width != -2) {
            break label381;
          }
        }
        for (paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, -2147483648);; paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824))
        {
          ((View)localObject1).measure(paramInt1, paramInt2);
          if (p.h(localObject1, this.anJ))
          {
            this.anM = (((View)localObject1).getMeasuredWidth() - (this.FJB + this.FJD));
            this.FJG = this.anM;
          }
          j += 1;
          break;
          label317:
          if (!p.h(localObject1, this.anJ)) {
            break label422;
          }
          paramInt1 = i - ((FrameLayout.LayoutParams)localObject2).leftMargin + this.FJD;
          break label225;
          if (((FrameLayout.LayoutParams)localObject2).height == -1)
          {
            paramInt2 = View.MeasureSpec.makeMeasureSpec(n, 1073741824);
            break label244;
          }
          paramInt2 = View.MeasureSpec.makeMeasureSpec(((FrameLayout.LayoutParams)localObject2).height, 1073741824);
          break label244;
          label381:
          if (((FrameLayout.LayoutParams)localObject2).width != -1) {
            paramInt1 = ((FrameLayout.LayoutParams)localObject2).width;
          }
        }
        setMeasuredDimension(k, m);
        AppMethodBeat.o(248092);
        return;
        paramInt1 = i;
      }
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(248084);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt2 != paramInt4) || (paramInt1 != paramInt3))
    {
      this.mFirstLayout = true;
      synchronized (this.FJn)
      {
        Iterator localIterator = this.FJn.iterator();
        if (localIterator.hasNext()) {
          ((b)localIterator.next()).ir(paramInt1, paramInt2);
        }
      }
      x localx = x.aazN;
      AppMethodBeat.o(248084);
      return;
    }
    AppMethodBeat.o(248084);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(248097);
    p.k(paramMotionEvent, "ev");
    if (!this.mCanSlide)
    {
      localObject = this.FGv;
      if ((localObject != null) && (((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).Qi.isFinished() == true))
      {
        localObject = this.FGv;
        if (localObject != null) {
          ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).hL();
        }
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(248097);
        return bool;
      }
    }
    int i;
    float f2;
    float f1;
    for (;;)
    {
      try
      {
        i = j.d(paramMotionEvent);
        if ((i != 3) && (i != 1)) {
          break label353;
        }
        f2 = paramMotionEvent.getX();
        f1 = paramMotionEvent.getY();
        f2 = Math.abs(f2 - this.mInitialMotionX);
        f1 = Math.abs(f1 - this.mInitialMotionY);
        localObject = this.FGv;
        if (localObject != null)
        {
          i = ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).bvH;
          if ((f1 > i) || (f2 > i) || (this.FJo != 0) || (this.anK <= 0.0F) || (!g(this.uKG, (int)this.mInitialMotionX, (int)this.mInitialMotionY)) || (this.FJm == null) || (getPanelState() == c.FJQ)) {
            break;
          }
          paramMotionEvent = this.FJm;
          if (paramMotionEvent != null) {
            paramMotionEvent.onClick((View)this);
          }
          AppMethodBeat.o(248097);
          return true;
        }
      }
      catch (Exception paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.MultiTaskViewGroup", (Throwable)paramMotionEvent, "get a Exception", new Object[0]);
        AppMethodBeat.o(248097);
        return false;
      }
      localObject = ViewConfiguration.get(getContext());
      p.j(localObject, "ViewConfiguration.get(context)");
      i = ((ViewConfiguration)localObject).getScaledTouchSlop();
    }
    if ((f1 <= i) && (f2 <= i) && (this.anK > 0.0F) && (this.FJH == c.FJO))
    {
      paramMotionEvent = this.FJm;
      if (paramMotionEvent != null) {
        paramMotionEvent.onClick((View)this);
      }
      AppMethodBeat.o(248097);
      return true;
    }
    label353:
    Object localObject = this.FGv;
    if (localObject != null) {
      ((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).j(paramMotionEvent);
    }
    AppMethodBeat.o(248097);
    return true;
  }
  
  public final void setAnchorPoint(float paramFloat)
  {
    this.FJE = paramFloat;
    this.FJl = true;
  }
  
  public final void setCanSlide(boolean paramBoolean)
  {
    this.mCanSlide = paramBoolean;
  }
  
  public final void setCoveredFadeColor(int paramInt)
  {
    AppMethodBeat.i(248072);
    this.anF = paramInt;
    requestLayout();
    AppMethodBeat.o(248072);
  }
  
  public final void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248070);
    fbp();
    if (paramInt == 0) {
      if (paramBoolean) {
        a(c.FJM, 0L, false);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        this.FJo = paramInt;
      }
      AppMethodBeat.o(248070);
      return;
      a(c.FJM, 0L, true);
      continue;
      if (paramBoolean) {
        a(c.FJN, 0L, false);
      } else {
        a(c.FJN, 0L, true);
      }
    }
  }
  
  public final void setDragView(View paramView)
  {
    this.FJC = paramView;
  }
  
  public final void setExtraSlideRange(int paramInt)
  {
    this.FJD = paramInt;
  }
  
  public final void setFadeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(248062);
    p.k(paramOnClickListener, "listener");
    this.FJm = paramOnClickListener;
    AppMethodBeat.o(248062);
  }
  
  protected final void setMDragHelper(com.tencent.mm.plugin.multitask.animation.c.a.b paramb)
  {
    this.FGv = paramb;
  }
  
  public final void setNeedAnchor(boolean paramBoolean)
  {
    this.FJl = paramBoolean;
  }
  
  public final void setOverlayed(boolean paramBoolean)
  {
    this.FJu = paramBoolean;
  }
  
  public final void setPanelExpose(int paramInt)
  {
    this.FJB = paramInt;
  }
  
  public final void setPanelWidth(int paramInt)
  {
    AppMethodBeat.i(248075);
    if (getPanelWidth() == paramInt)
    {
      AppMethodBeat.o(248075);
      return;
    }
    this.FJA = paramInt;
    if (!this.mFirstLayout) {
      requestLayout();
    }
    if (getPanelState() == c.FJN)
    {
      a(0.0F, 0L, false);
      invalidate();
      AppMethodBeat.o(248075);
      return;
    }
    AppMethodBeat.o(248075);
  }
  
  public final void setParallaxOffset(int paramInt)
  {
    AppMethodBeat.i(248081);
    this.FJG = paramInt;
    if (!this.mFirstLayout) {
      requestLayout();
    }
    AppMethodBeat.o(248081);
  }
  
  public final void setShadowWidth(int paramInt)
  {
    AppMethodBeat.i(248079);
    this.FJF = paramInt;
    if (!this.mFirstLayout) {
      invalidate();
    }
    AppMethodBeat.o(248079);
  }
  
  public final void setSlideLeft(boolean paramBoolean)
  {
    this.FJt = paramBoolean;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "", "enableExpand", "", "onPanelItemSelected", "", "panel", "Landroid/view/View;", "position", "", "onPanelSizeChanged", "screenSizeW", "screenSizeH", "onPanelSlide", "slideOffset", "", "onPanelStateChanged", "previousState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "newState", "onPanelTouchEnd", "onPanelTouchSlide", "onPanelTouchStart", "onPlaySound", "plugin-multitask_release"})
  public static abstract interface b
  {
    public abstract void Yi(int paramInt);
    
    public abstract void a(b.c paramc1, b.c paramc2);
    
    public abstract void bE(float paramFloat);
    
    public abstract void bF(float paramFloat);
    
    public abstract void fbw();
    
    public abstract void fbx();
    
    public abstract void fby();
    
    public abstract boolean fbz();
    
    public abstract void ir(int paramInt1, int paramInt2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "ANCHORED", "HIDDEN", "DRAGGING", "plugin-multitask_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(247679);
      c localc1 = new c("EXPANDED", 0);
      FJM = localc1;
      c localc2 = new c("COLLAPSED", 1);
      FJN = localc2;
      c localc3 = new c("ANCHORED", 2);
      FJO = localc3;
      c localc4 = new c("HIDDEN", 3);
      FJP = localc4;
      c localc5 = new c("DRAGGING", 4);
      FJQ = localc5;
      FJR = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(247679);
    }
    
    private c() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;)V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "pointerId", "plugin-multitask_release"})
  public final class d
    extends com.tencent.mm.plugin.multitask.animation.c.a.b.a
    implements com.tencent.mm.ui.base.b.b
  {
    public final void G(int paramInt)
    {
      AppMethodBeat.i(248995);
      Log.d("MicroMsg.MultiTaskViewGroup", "onViewDragStateChanged, state:".concat(String.valueOf(paramInt)));
      Object localObject;
      if (this.FJS.getMDragHelper() != null)
      {
        localObject = this.FJS.getMDragHelper();
        if (localObject == null) {
          break label129;
        }
        if (((com.tencent.mm.plugin.multitask.animation.c.a.b)localObject).FGj == 0)
        {
          localObject = this.FJS;
          b localb = this.FJS;
          View localView = b.j(this.FJS);
          if (localView == null) {
            break label135;
          }
          paramInt = localView.getLeft();
          b.a((b)localObject, b.b(localb, paramInt));
          b.k(this.FJS);
          if (b.h(this.FJS) != 1.0F) {
            break label140;
          }
          this.FJS.fbu();
        }
      }
      label129:
      label135:
      label140:
      do
      {
        b.a(this.FJS, b.c.FJM);
        AppMethodBeat.o(248995);
        return;
        AppMethodBeat.o(248995);
        return;
        paramInt = 0;
        break;
        if (b.h(this.FJS) == 0.0F)
        {
          b.a(this.FJS, b.c.FJN);
          AppMethodBeat.o(248995);
          return;
        }
        if (b.h(this.FJS) < 0.0F)
        {
          b.a(this.FJS, b.c.FJP);
          localObject = b.j(this.FJS);
          if (localObject != null)
          {
            ((View)localObject).setVisibility(4);
            AppMethodBeat.o(248995);
            return;
          }
          AppMethodBeat.o(248995);
          return;
        }
        this.FJS.fbu();
        if (b.l(this.FJS))
        {
          b.a(this.FJS, b.c.FJO);
          AppMethodBeat.o(248995);
          return;
        }
      } while (b.h(this.FJS) > 0.3F);
      b.a(this.FJS, b.c.FJN);
      AppMethodBeat.o(248995);
    }
    
    public final int XY(int paramInt)
    {
      AppMethodBeat.i(248994);
      int i = b.b(this.FJS, 0.0F);
      int j = b.b(this.FJS, 1.0F);
      if (b.e(this.FJS))
      {
        paramInt = Math.min(Math.max(paramInt, j), i);
        AppMethodBeat.o(248994);
        return paramInt;
      }
      paramInt = Math.min(Math.max(paramInt, i), j);
      AppMethodBeat.o(248994);
      return paramInt;
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(248998);
      Log.d("MicroMsg.MultiTaskViewGroup", "touchX: %f, touchY: %f, dx: %d, dy: %d, adx: %d, ady: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      Object localObject1 = this.FJS;
      paramFloat1 = b.h(this.FJS);
      synchronized (((b)localObject1).FJn)
      {
        localObject1 = ((b)localObject1).FJn.iterator();
        if (((Iterator)localObject1).hasNext()) {
          ((b.b)((Iterator)localObject1).next()).bF(paramFloat1);
        }
      }
      x localx = x.aazN;
      AppMethodBeat.o(248998);
    }
    
    public final int aEe()
    {
      AppMethodBeat.i(248991);
      int i = b.d(this.FJS);
      AppMethodBeat.o(248991);
      return i;
    }
    
    public final boolean b(View arg1, int paramInt)
    {
      AppMethodBeat.i(248989);
      if (??? != null) {}
      for (??? = ???.toString();; ??? = null)
      {
        Log.d("MicroMsg.MultiTaskViewGroup", "tryCaptureView, child: %s", new Object[] { ??? });
        Object localObject1 = this.FJS;
        synchronized (((b)localObject1).FJn)
        {
          localObject1 = ((b)localObject1).FJn.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((b.b)((Iterator)localObject1).next()).fbw();
        }
      }
      x localx = x.aazN;
      boolean bool;
      if (b.a(this.FJS) == b.c.FJN)
      {
        if (!b.b(this.FJS))
        {
          ??? = this.FJS.getMDragHelper();
          if (??? != null) {}
          for (bool = ???.iq(8, paramInt); bool; bool = false)
          {
            AppMethodBeat.o(248989);
            return true;
          }
        }
        AppMethodBeat.o(248989);
        return false;
      }
      if (b.a(this.FJS) == b.c.FJM)
      {
        if (!b.b(this.FJS))
        {
          ??? = this.FJS.getMDragHelper();
          if (??? != null) {}
          for (bool = ???.iq(4, paramInt); bool; bool = false)
          {
            AppMethodBeat.o(248989);
            return true;
          }
        }
        AppMethodBeat.o(248989);
        return false;
      }
      if (b.a(this.FJS) == b.c.FJQ)
      {
        AppMethodBeat.o(248989);
        return true;
      }
      if (b.a(this.FJS) == b.c.FJO)
      {
        int i;
        if (!b.b(this.FJS))
        {
          ??? = this.FJS.getMDragHelper();
          if (??? != null)
          {
            bool = ???.iq(8, paramInt);
            if (!bool) {
              break label371;
            }
            i = 1;
            label313:
            if (b.b(this.FJS)) {
              break label382;
            }
            ??? = this.FJS.getMDragHelper();
            if (??? == null) {
              break label376;
            }
            bool = ???.iq(4, paramInt);
            label343:
            if (!bool) {
              break label382;
            }
          }
        }
        label371:
        label376:
        label382:
        for (paramInt = 1;; paramInt = 0)
        {
          if ((paramInt == 0) && (i == 0)) {
            break label387;
          }
          AppMethodBeat.o(248989);
          return true;
          bool = false;
          break;
          i = 0;
          break label313;
          bool = false;
          break label343;
        }
        label387:
        AppMethodBeat.o(248989);
        return false;
      }
      b.c(this.FJS);
      AppMethodBeat.o(248989);
      return false;
    }
    
    public final void c(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(248993);
      Log.d("MicroMsg.MultiTaskViewGroup", "onViewReleased, xvel: %f, yvel: %f, dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
      label96:
      com.tencent.mm.plugin.multitask.animation.c.a.b localb;
      label137:
      int i;
      if (b.e(this.FJS))
      {
        paramFloat2 = -paramFloat1;
        if (this.FJS.getWidth() <= 0) {
          break label597;
        }
        float f = this.FJS.getWidth();
        if (b.f(this.FJS) != 0) {
          break label292;
        }
        paramFloat4 = 0.25F;
        if (Math.abs(paramFloat3) >= paramFloat4 * f) {
          break label306;
        }
        f = Math.abs(paramFloat1);
        localb = this.FJS.getMDragHelper();
        if (localb == null) {
          break label300;
        }
        paramFloat4 = localb.rti;
        if (f > paramFloat4 * 0.95F) {
          break label306;
        }
        if (b.f(this.FJS) != 1) {
          break label605;
        }
        paramFloat1 = 0.0F;
        i = 0;
      }
      for (;;)
      {
        label165:
        if (!b.g(this.FJS))
        {
          paramFloat1 = 0.0F;
          i = 0;
        }
        if ((paramFloat1 > 0.0F) && (b.h(this.FJS) <= b.i(this.FJS))) {
          i = b.b(this.FJS, b.i(this.FJS));
        }
        for (;;)
        {
          if ((this.FJS.getMDragHelper() != null) && (paramView != null))
          {
            localb = this.FJS.getMDragHelper();
            if (localb != null)
            {
              int j = paramView.getTop();
              if (!localb.Rw)
              {
                paramView = (Throwable)new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased".toString());
                AppMethodBeat.o(248993);
                throw paramView;
                paramFloat2 = paramFloat1;
                break;
                label292:
                paramFloat4 = 0.5F;
                break label96;
                label300:
                paramFloat4 = 0.0F;
                break label137;
                label306:
                if (paramFloat1 != 0.0F) {
                  break label597;
                }
                paramFloat1 = paramFloat3;
                if (b.e(this.FJS)) {
                  paramFloat1 = -paramFloat3;
                }
                i = 1;
                break label165;
                if ((paramFloat1 > 0.0F) && (b.h(this.FJS) > b.i(this.FJS)))
                {
                  i = b.b(this.FJS, 1.0F);
                  continue;
                }
                if ((paramFloat1 < 0.0F) && (b.h(this.FJS) >= b.i(this.FJS)))
                {
                  i = b.b(this.FJS, b.i(this.FJS));
                  continue;
                }
                if ((paramFloat1 >= 0.0F) || (b.h(this.FJS) >= b.i(this.FJS)))
                {
                  if ((b.h(this.FJS) >= (b.i(this.FJS) + 1.0F) / 2.0F) && (i != 0))
                  {
                    i = b.b(this.FJS, 1.0F);
                    continue;
                  }
                  if ((b.h(this.FJS) >= b.i(this.FJS) / 2.0F) && (i != 0))
                  {
                    i = b.b(this.FJS, b.i(this.FJS));
                    continue;
                  }
                }
                i = b.b(this.FJS, 0.0F);
                continue;
              }
              localb.a(i, j, (int)v.a(localb.mVelocityTracker, localb.bvF), (int)v.b(localb.mVelocityTracker, localb.bvF), 0L, false);
            }
          }
        }
        this.FJS.fbr();
        this.FJS.invalidate();
        AppMethodBeat.o(248993);
        return;
        label597:
        i = 1;
        paramFloat1 = paramFloat2;
        continue;
        label605:
        paramFloat1 = 0.0F;
        i = 1;
      }
    }
    
    public final void eG(boolean paramBoolean)
    {
      AppMethodBeat.i(248996);
      Log.d("MicroMsg.MultiTaskViewGroup", "onComplete");
      AppMethodBeat.o(248996);
    }
    
    public final void faA()
    {
      AppMethodBeat.i(248997);
      Log.i("MicroMsg.MultiTaskViewGroup", "onViewCaptured");
      this.FJS.mS();
      AppMethodBeat.o(248997);
    }
    
    public final void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(248992);
      if (paramView != null) {}
      for (paramView = paramView.toString();; paramView = null)
      {
        Log.d("MicroMsg.MultiTaskViewGroup", "changedView: %s, left: %d, top: %d, dx: %d, dy: %d", new Object[] { paramView, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        b.a(this.FJS, paramInt1);
        this.FJS.invalidate();
        AppMethodBeat.o(248992);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.b
 * JD-Core Version:    0.7.0.1
 */