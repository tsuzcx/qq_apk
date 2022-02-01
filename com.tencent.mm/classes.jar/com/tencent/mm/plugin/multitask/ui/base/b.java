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
import android.support.v4.view.i;
import android.support.v4.view.u;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.animation.c.a.c;
import com.tencent.mm.plugin.multitask.animation.c.a.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DEFAULT_CLIP_PANEL_FLAG", "", "DEFAULT_FADE_COLOR", "", "DEFAULT_OVERLAY_FLAG", "mAnchorPoint", "", "mCanSlide", "mClipPanel", "mCoveredFadeColor", "", "mCoveredFadePaint", "Landroid/graphics/Paint;", "mCoveredRoundPath", "Landroid/graphics/Path;", "mCurItemIndex", "mDragHelper", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "getMDragHelper", "()Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;", "setMDragHelper", "(Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper;)V", "mDragView", "Landroid/view/View;", "mExtraSlideRange", "mFadeOnClickListener", "Landroid/view/View$OnClickListener;", "mFirstLayout", "mInitialMotionX", "mInitialMotionY", "mIsSlidingLeft", "mIsUnableToDrag", "mLastItemIndex", "mLastNotDraggingSlideState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "mMainView", "mOverlayContent", "mPanelExpose", "mPanelSlideListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "mPanelWidth", "mParallaxOffset", "mPlaySound", "mPrevMotionX", "mPrevMotionY", "mShadowWidth", "mSlideOffset", "mSlideRange", "mSlideState", "mSlideableView", "mTmpRect", "Landroid/graphics/Rect;", "mVibrator", "Landroid/os/Vibrator;", "addPanelSlideListener", "", "listener", "applyParallaxForCurrentSlideOffset", "attachViewWrapper", "multTaskView", "launchView", "checkExpand", "computePanelLeftPosition", "slideOffset", "computeScroll", "computeSlideOffset", "leftPosition", "dispatchOnPanelItemSelected", "panel", "position", "dispatchOnPanelSizeChanged", "width", "height", "dispatchOnPanelSlide", "dispatchOnPanelStateChanged", "previousState", "newState", "dispatchOnPlaySound", "dispatchTouchEnd", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "dispatchTouchSlide", "dispatchTouchStart", "drawChild", "canvas", "Landroid/graphics/Canvas;", "child", "drawingTime", "getCanSlide", "getCurItem", "getCurrentParallaxOffset", "getPanelState", "getPanelWidth", "getShadowWidth", "hasOpaqueBackground", "v", "isViewUnder", "view", "x", "y", "onAttachedToWindow", "onDetachedFromWindow", "onInterceptTouchEvent", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPanelDragged", "newLeft", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "removePanelSlideListener", "setAllChildrenVisible", "setCanSlide", "enable", "setCoveredFadeColor", "color", "setCurrentItem", "item", "smoothScroll", "setDragView", "dragView", "setExtraSlideRange", "val", "setFadeOnClickListener", "setOverlayed", "overlayed", "setPanelExpose", "setPanelState", "state", "withNoAnim", "setPanelStateInternal", "setPanelWidth", "setParallaxOffset", "setShadowWidth", "setSlideLeft", "isSlideLeft", "smoothSlideTo", "velocity", "duration", "smoothToBottom", "updateObscuredViewVisibility", "Companion", "PanelSlideListener", "PanelState", "ViewDragCallback", "plugin-multitask_release"})
public final class b
  extends FrameLayout
{
  private static final int Ade;
  private static final int Adf;
  public static final b.a Adg;
  private static final float[] zZR;
  public c AaG;
  private boolean AcG;
  private View.OnClickListener AcH;
  public CopyOnWriteArrayList<b> AcI;
  private int AcJ;
  private int AcK;
  private final boolean AcL;
  private final long AcM;
  private final boolean AcN;
  private boolean AcO;
  private boolean AcP;
  private final boolean AcQ;
  private final Paint AcR;
  private final Path AcS;
  private float AcT;
  private float AcU;
  private int AcV;
  private int AcW;
  private View AcX;
  private int AcY;
  private final float AcZ;
  private int Ada;
  private int Adb;
  private c Adc;
  private c Add;
  private final Rect Ui;
  private int Vh;
  private View Vl;
  private float Vm;
  private int Vo;
  private boolean mCanSlide;
  private boolean mFirstLayout;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private boolean mIsUnableToDrag;
  public Vibrator ooM;
  private View rhx;
  
  static
  {
    AppMethodBeat.i(200748);
    Adg = new b.a((byte)0);
    Ade = at.fromDPToPix(MMApplicationContext.getContext(), 36);
    Adf = at.fromDPToPix(MMApplicationContext.getContext(), 16);
    zZR = new float[] { Adf, Adf, 0.0F, 0.0F, 0.0F, 0.0F, Adf, Adf };
    AppMethodBeat.o(200748);
  }
  
  public b(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200747);
    this.mCanSlide = true;
    this.AcI = new CopyOnWriteArrayList();
    this.AcJ = -1;
    this.AcK = -1;
    this.AcM = 2566914048L;
    this.AcN = true;
    this.AcP = this.AcL;
    this.AcQ = this.AcN;
    this.Vh = ((int)this.AcM);
    this.AcR = new Paint();
    this.AcS = new Path();
    this.Ui = new Rect();
    this.mFirstLayout = true;
    this.AcV = -1;
    this.AcW = -1;
    this.AcZ = 1.0F;
    this.Ada = -1;
    this.Adb = -1;
    this.Adc = c.Adi;
    this.Add = c.Adh;
    AppMethodBeat.o(200747);
  }
  
  private final float RP(int paramInt)
  {
    AppMethodBeat.i(200743);
    int i = bA(0.0F);
    if (this.AcO)
    {
      f = (i - paramInt) / this.Vo;
      AppMethodBeat.o(200743);
      return f;
    }
    float f = (paramInt - i) / this.Vo;
    AppMethodBeat.o(200743);
    return f;
  }
  
  private void a(c paramc, boolean paramBoolean)
  {
    AppMethodBeat.i(200722);
    Object localObject = this.AaG;
    if ((localObject != null) && (((c)localObject).Aas == 2))
    {
      Log.d("MicroMsg.MultiTaskViewGroup", "View is settling. Aborting animation.");
      localObject = this.AaG;
      if (localObject != null) {
        ((c)localObject).abort();
      }
    }
    if ((paramc != null) && (paramc != c.Adl)) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramc = (Throwable)new IllegalArgumentException("Panel state cannot be null or DRAGGING.".toString());
      AppMethodBeat.o(200722);
      throw paramc;
    }
    if ((!isEnabled()) || ((!this.mFirstLayout) && (this.Vl == null)) || (paramc == this.Adc) || (this.Adc == c.Adl))
    {
      AppMethodBeat.o(200722);
      return;
    }
    if (this.mFirstLayout)
    {
      setPanelStateInternal(paramc);
      AppMethodBeat.o(200722);
      return;
    }
    if (this.Adc == c.Adk)
    {
      localObject = this.Vl;
      if (localObject != null) {
        ((View)localObject).setVisibility(0);
      }
      requestLayout();
    }
    if (paramc == null)
    {
      AppMethodBeat.o(200722);
      return;
    }
    switch (c.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(200722);
      return;
    case 1: 
      a(this.AcZ, 0L, paramBoolean);
      AppMethodBeat.o(200722);
      return;
    case 2: 
      a(0.0F, 250L, paramBoolean);
      AppMethodBeat.o(200722);
      return;
    case 3: 
      a(1.0F, 0L, paramBoolean);
      AppMethodBeat.o(200722);
      return;
    }
    int j = bA(0.0F);
    if (this.AcO) {}
    for (i = this.AcW + this.AcY;; i = -(this.AcW + this.AcY))
    {
      a(RP(i + j), 0L, paramBoolean);
      break;
    }
  }
  
  private boolean a(float paramFloat, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(200728);
    if ((!isEnabled()) || (this.Vl == null))
    {
      AppMethodBeat.o(200728);
      return false;
    }
    int j = bA(paramFloat);
    c localc = this.AaG;
    if (localc != null)
    {
      View localView = this.Vl;
      if (localView != null) {}
      for (int i = localView.getTop(); localc.a(localView, j, i, paramLong, paramBoolean) == true; i = 0)
      {
        gf();
        u.X((View)this);
        AppMethodBeat.o(200728);
        return true;
      }
    }
    AppMethodBeat.o(200728);
    return false;
  }
  
  private final int bA(float paramFloat)
  {
    AppMethodBeat.i(200742);
    View localView = this.Vl;
    if (localView != null) {}
    int j;
    for (int i = localView.getMeasuredWidth();; i = 0)
    {
      j = (int)(this.Vo * paramFloat);
      if (!this.AcO) {
        break;
      }
      i = getMeasuredWidth();
      k = getPaddingRight();
      m = this.AcW;
      n = this.AcY;
      AppMethodBeat.o(200742);
      return i - k - (m + n) - j;
    }
    int k = getPaddingLeft();
    int m = this.AcW;
    int n = this.AcY;
    AppMethodBeat.o(200742);
    return k - i + (m + n) + j;
  }
  
  private final boolean ern()
  {
    AppMethodBeat.i(200740);
    synchronized (this.AcI)
    {
      Object localObject1 = this.AcI.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        boolean bool = ((b)((Iterator)localObject1).next()).eru();
        if (!bool)
        {
          AppMethodBeat.o(200740);
          return false;
        }
      }
      localObject1 = x.SXb;
      AppMethodBeat.o(200740);
      return true;
    }
  }
  
  @SuppressLint({"NewApi"})
  private final void ero()
  {
    AppMethodBeat.i(200741);
    if (this.Adb > 0)
    {
      int i = getCurrentParallaxOffset();
      u.e(this.rhx, i);
    }
    AppMethodBeat.o(200741);
  }
  
  private static boolean ew(View paramView)
  {
    AppMethodBeat.i(200746);
    if (paramView != null) {}
    for (paramView = paramView.getBackground(); (paramView != null) && (paramView.getOpacity() == -1); paramView = null)
    {
      AppMethodBeat.o(200746);
      return true;
    }
    AppMethodBeat.o(200746);
    return false;
  }
  
  private final c getPanelState()
  {
    return this.Adc;
  }
  
  private boolean i(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200726);
    if (paramView == null)
    {
      AppMethodBeat.o(200726);
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
      AppMethodBeat.o(200726);
      return true;
    }
    AppMethodBeat.o(200726);
    return false;
  }
  
  private final void setPanelStateInternal(c paramc)
  {
    AppMethodBeat.i(200738);
    if (this.Adc == paramc)
    {
      AppMethodBeat.o(200738);
      return;
    }
    c localc = this.Adc;
    this.Adc = paramc;
    if (paramc == c.Adh)
    {
      this.AcJ = 0;
      Log.i("MicroMsg.MultiTaskViewGroup", "setPanelStateInternal, EXPANDED!");
    }
    Object localObject;
    while (this.AcJ != this.AcK)
    {
      this.AcK = this.AcJ;
      int i = this.AcJ;
      synchronized (this.AcI)
      {
        localObject = this.AcI.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label159;
        }
        ((b)((Iterator)localObject).next()).RQ(i);
      }
      if (paramc == c.Adi)
      {
        this.AcJ = 1;
        Log.i("MicroMsg.MultiTaskViewGroup", "setPanelStateInternal, COLLAPSED!");
        continue;
        label159:
        localObject = x.SXb;
      }
    }
    synchronized (this.AcI)
    {
      localObject = this.AcI.iterator();
      if (((Iterator)localObject).hasNext()) {
        ((b)((Iterator)localObject).next()).a(localc, paramc);
      }
    }
    paramc = x.SXb;
    sendAccessibilityEvent(32);
    AppMethodBeat.o(200738);
  }
  
  public final void computeScroll()
  {
    boolean bool2 = false;
    AppMethodBeat.i(200729);
    Boolean localBoolean;
    Object localObject;
    boolean bool1;
    int i;
    if (this.AaG != null)
    {
      localBoolean = Boolean.TRUE;
      localObject = this.AaG;
      if (localObject != null) {
        if (((c)localObject).Aas == 2)
        {
          bool1 = ((c)localObject).UD.computeScrollOffset();
          int j = ((c)localObject).UD.getCurrX();
          int k = ((c)localObject).UD.getCurrY();
          View localView = ((c)localObject).Aax;
          if (localView == null) {
            break label316;
          }
          i = localView.getLeft();
          int m = j - i;
          localView = ((c)localObject).Aax;
          if (localView == null) {
            break label321;
          }
          i = localView.getTop();
          label110:
          i = k - i;
          if (m != 0)
          {
            localView = ((c)localObject).Aax;
            if (localView != null) {
              localView.offsetLeftAndRight(m);
            }
          }
          if (i != 0)
          {
            localView = ((c)localObject).Aax;
            if (localView != null) {
              localView.offsetTopAndBottom(i);
            }
          }
          if ((m != 0) || (i != 0)) {
            ((c)localObject).Aaw.l(((c)localObject).Aax, j, k, m, i);
          }
          if ((!bool1) || (j != ((c)localObject).UD.getFinalX()) || (k != ((c)localObject).UD.getFinalY())) {
            break label353;
          }
          ((c)localObject).UD.abortAnimation();
          bool1 = ((c)localObject).UD.isFinished();
        }
      }
    }
    label316:
    label321:
    label353:
    for (;;)
    {
      if (!bool1) {
        ((c)localObject).WN.post(((c)localObject).WO);
      }
      bool1 = bool2;
      if (((c)localObject).Aas == 2) {
        bool1 = true;
      }
      localObject = Boolean.valueOf(bool1);
      for (;;)
      {
        if (p.j(localBoolean, localObject))
        {
          if (!isEnabled())
          {
            localObject = this.AaG;
            if (localObject != null)
            {
              ((c)localObject).abort();
              AppMethodBeat.o(200729);
              return;
              i = 0;
              break;
              i = 0;
              break label110;
              localObject = null;
              continue;
            }
            AppMethodBeat.o(200729);
            return;
          }
          u.X((View)this);
        }
      }
      AppMethodBeat.o(200729);
      return;
    }
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200735);
    p.h(paramMotionEvent, "ev");
    int i = i.e(paramMotionEvent);
    if (!this.mCanSlide)
    {
      localc = this.AaG;
      if ((localc != null) && (localc.UD.isFinished() == true)) {}
    }
    else
    {
      if ((!this.mIsUnableToDrag) || (i == 0)) {
        break label93;
      }
    }
    c localc = this.AaG;
    if (localc != null) {
      localc.abort();
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200735);
    return bool;
    label93:
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    if (i == 0)
    {
      this.AcT = f1;
      this.AcU = f2;
    }
    while (i != 2)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(200735);
      return bool;
    }
    float f3 = this.AcT;
    float f4 = this.AcU;
    this.AcT = f1;
    this.AcU = f2;
    if (Math.abs(f2 - f4) > Math.abs(f1 - f3))
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(200735);
      return bool;
    }
    bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(200735);
    return bool;
  }
  
  protected final boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int j = 0;
    AppMethodBeat.i(200734);
    p.h(paramCanvas, "canvas");
    p.h(paramView, "child");
    int k = paramCanvas.save();
    Object localObject;
    View localView;
    int i;
    boolean bool;
    if ((this.Vl != null) && (p.j(this.Vl, paramView)))
    {
      paramCanvas.getClipBounds(this.Ui);
      if (!this.AcP)
      {
        if (this.AcO)
        {
          localObject = this.Ui;
          j = this.Ui.right;
          localView = this.Vl;
          if (localView != null) {}
          for (i = localView.getRight();; i = this.Ui.right)
          {
            ((Rect)localObject).right = Math.min(j, i);
            if (this.AcQ) {
              paramCanvas.clipRect(this.Ui);
            }
            bool = super.drawChild(paramCanvas, paramView, paramLong);
            paramCanvas.restoreToCount(k);
            AppMethodBeat.o(200734);
            return bool;
          }
        }
        localObject = this.Ui;
        j = this.Ui.left;
        localView = this.Vl;
        if (localView != null) {}
        for (i = localView.getLeft();; i = this.Ui.left)
        {
          ((Rect)localObject).left = Math.max(j, i);
          break;
        }
      }
      if (this.AcO)
      {
        localObject = this.Ui;
        j = this.Ui.right;
        localView = this.Vl;
        if (localView != null) {}
        for (i = localView.getRight();; i = this.Ui.right)
        {
          ((Rect)localObject).right = Math.max(j, i);
          this.Ui.left -= getWidth();
          break;
        }
      }
      localObject = this.Ui;
      j = this.Ui.left;
      localView = this.Vl;
      if (localView != null) {}
      for (i = localView.getLeft();; i = this.Ui.left)
      {
        ((Rect)localObject).left = Math.min(j, i);
        this.Ui.right = (this.Ui.left + getWidth());
        break;
      }
    }
    paramCanvas.getClipBounds(this.Ui);
    int m;
    label448:
    float f1;
    float f2;
    if (!this.AcP) {
      if (this.AcO)
      {
        localObject = this.Ui;
        m = this.Ui.left;
        localView = this.rhx;
        if (localView != null)
        {
          i = localView.getTop();
          ((Rect)localObject).right = Math.max(m, i);
          if ((!this.AcQ) || (this.Vm <= 0.0F)) {
            break label977;
          }
          f1 = 0.5F - Ade / getWidth();
          if (this.Vm < f1) {
            break label977;
          }
          float f3 = (this.Vm - f1) / (1.0F - f1);
          f2 = Adf * f3;
          if (f2 >= 0.0F) {
            break label935;
          }
          f1 = 0.0F;
          label534:
          zZR[0] = f1;
          zZR[1] = f1;
          zZR[6] = f1;
          zZR[7] = f1;
          i = (int)(255.0F * f3);
          if (i >= 0) {
            break label958;
          }
          i = j;
          label582:
          this.AcS.reset();
          localObject = new RectF(this.Ui);
          ((RectF)localObject).left = (this.Vm * this.Vo);
          this.AcS.addRoundRect((RectF)localObject, zZR, Path.Direction.CW);
          this.AcS.close();
          paramCanvas.clipPath(this.AcS);
        }
      }
    }
    for (j = 1;; j = 0)
    {
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((this.Vh != 0) && (this.Vm > 0.0F) && (j != 0))
      {
        j = this.Vh;
        this.AcR.setColor(i << 24 | j & 0xFFFFFF);
        paramView = new Rect(this.Ui);
        paramView.left = ((int)(this.Vm * this.Vo));
        paramCanvas.drawRect(paramView, this.AcR);
      }
      break;
      i = 0;
      break label448;
      localObject = this.Ui;
      m = this.Ui.left;
      localView = this.rhx;
      if (localView != null) {}
      for (i = localView.getBottom();; i = getHeight())
      {
        ((Rect)localObject).left = Math.min(m, i);
        break;
      }
      if (this.AcO)
      {
        localObject = this.Ui;
        m = this.Ui.right;
        localView = this.rhx;
        if (localView != null) {}
        for (i = localView.getRight();; i = this.Ui.right)
        {
          ((Rect)localObject).right = Math.min(m, i);
          break;
        }
      }
      localObject = this.Ui;
      m = this.Ui.left;
      localView = this.rhx;
      if (localView != null) {}
      for (i = localView.getLeft();; i = this.Ui.left)
      {
        ((Rect)localObject).left = Math.max(m, i);
        break;
      }
      label935:
      f1 = f2;
      if (f2 <= Adf) {
        break label534;
      }
      f1 = Adf;
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
  
  public final void erm()
  {
    AppMethodBeat.i(200739);
    synchronized (this.AcI)
    {
      Iterator localIterator = this.AcI.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).ers();
      }
    }
    x localx = x.SXb;
    AppMethodBeat.o(200739);
  }
  
  public final void erp()
  {
    int i1 = 0;
    AppMethodBeat.i(200745);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(200745);
      return;
    }
    int i6 = getPaddingLeft();
    int i3 = getWidth();
    int i4 = getPaddingRight();
    int i5 = getPaddingTop();
    int n = getHeight();
    int i2 = getPaddingBottom();
    View localView = this.Vl;
    int m;
    int k;
    int j;
    int i;
    if (localView != null) {
      if (ew(this.Vl))
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
      p.g(localView, "child");
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
      AppMethodBeat.o(200745);
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
    return this.AcJ;
  }
  
  public final int getCurrentParallaxOffset()
  {
    AppMethodBeat.i(200724);
    int i = (int)(this.Adb * Math.max(this.Vm, 0.0F));
    if (this.AcO)
    {
      i = -i;
      AppMethodBeat.o(200724);
      return i;
    }
    AppMethodBeat.o(200724);
    return i;
  }
  
  protected final c getMDragHelper()
  {
    return this.AaG;
  }
  
  public final int getPanelWidth()
  {
    return this.AcV;
  }
  
  public final int getShadowWidth()
  {
    return this.Ada;
  }
  
  public final void gf()
  {
    AppMethodBeat.i(200744);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      p.g(localView, "child");
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
    AppMethodBeat.o(200744);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(200730);
    super.onAttachedToWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(200730);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(200731);
    super.onDetachedFromWindow();
    this.mFirstLayout = true;
    AppMethodBeat.o(200731);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200736);
    p.h(paramMotionEvent, "ev");
    c localc;
    if (!this.mCanSlide)
    {
      localc = this.AaG;
      if ((localc != null) && (localc.UD.isFinished() == true))
      {
        paramMotionEvent = this.AaG;
        if (paramMotionEvent != null) {
          paramMotionEvent.abort();
        }
        AppMethodBeat.o(200736);
        return false;
      }
    }
    int i = i.e(paramMotionEvent);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    float f3 = Math.abs(f1 - this.mInitialMotionX);
    float f4 = Math.abs(f2 - this.mInitialMotionY);
    switch (i)
    {
    }
    for (;;)
    {
      localc = this.AaG;
      if (localc == null) {
        break;
      }
      boolean bool = localc.j(paramMotionEvent);
      AppMethodBeat.o(200736);
      return bool;
      this.mIsUnableToDrag = false;
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.AcT = f1;
      this.AcU = f2;
      if (!i(this.AcX, (int)f1, (int)f2))
      {
        paramMotionEvent = this.AaG;
        if (paramMotionEvent != null) {
          paramMotionEvent.cancel();
        }
        this.mIsUnableToDrag = true;
        AppMethodBeat.o(200736);
        return false;
      }
      if ((this.AcJ == 0) && (i(this.rhx, (int)f1, (int)f2)))
      {
        AppMethodBeat.o(200736);
        return true;
        float f5 = f1 - this.AcT;
        float f6 = this.AcU;
        this.AcT = f1;
        this.AcU = f2;
        if ((f4 > f3) || (Math.abs(f2 - f6) > Math.abs(f5)))
        {
          if ((this.AcJ == 0) && (i(this.rhx, (int)f1, (int)f2)))
          {
            AppMethodBeat.o(200736);
            return true;
          }
          paramMotionEvent = this.AaG;
          if (paramMotionEvent != null) {
            paramMotionEvent.cancel();
          }
          this.mIsUnableToDrag = true;
          AppMethodBeat.o(200736);
          return false;
        }
        if ((this.AcJ == 1) && (i(this.rhx, (int)f1, (int)f2)) && (f5 < 0.0F))
        {
          paramMotionEvent = this.AaG;
          if (paramMotionEvent != null) {
            paramMotionEvent.cancel();
          }
          this.mIsUnableToDrag = true;
          AppMethodBeat.o(200736);
          return false;
          localc = this.AaG;
          if (localc != null)
          {
            if (localc.Aas == 1) {}
            for (i = 1; i == 1; i = 0)
            {
              localc = this.AaG;
              if (localc != null) {
                localc.k(paramMotionEvent);
              }
              AppMethodBeat.o(200736);
              return true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(200736);
    return false;
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200733);
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    int i = getChildCount();
    Object localObject1;
    if (this.mFirstLayout) {
      localObject1 = this.Adc;
    }
    float f;
    switch (c.haE[localObject1.ordinal()])
    {
    default: 
      f = 0.0F;
      this.Vm = f;
      paramInt1 = 0;
    }
    Object localObject2;
    int j;
    for (;;)
    {
      if (paramInt1 < i)
      {
        localObject1 = getChildAt(paramInt1);
        p.g(localObject1, "child");
        localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 == null)
        {
          localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(200733);
          throw ((Throwable)localObject1);
          f = 1.0F;
          break;
          f = this.AcZ;
          break;
          paramInt2 = bA(0.0F);
          if (this.AcO) {}
          for (paramInt1 = this.AcW + this.AcY;; paramInt1 = -(this.AcW + this.AcY))
          {
            f = RP(paramInt1 + paramInt2);
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
          if (!p.j(localObject1, this.Vl)) {
            break label324;
          }
        }
      }
    }
    label324:
    for (paramInt2 = bA(this.Vm);; paramInt2 = paramInt3)
    {
      int k = ((FrameLayout.LayoutParams)localObject2).topMargin + paramInt4;
      ((View)localObject1).layout(paramInt2, k, j + paramInt2, ((View)localObject1).getMeasuredHeight() + k);
      break;
      if (this.mFirstLayout) {
        erp();
      }
      ero();
      this.mFirstLayout = false;
      AppMethodBeat.o(200733);
      return;
    }
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200732);
    View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getMode(paramInt2);
    int m = View.MeasureSpec.getSize(paramInt2);
    this.rhx = getChildAt(0);
    this.Vl = getChildAt(1);
    if (this.AcX == null) {
      setDragView(this.Vl);
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
      p.g(localObject1, "child");
      localObject2 = ((View)localObject1).getLayoutParams();
      if (localObject2 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(200732);
        throw ((Throwable)localObject1);
      }
      localObject2 = (FrameLayout.LayoutParams)localObject2;
      if ((((View)localObject1).getVisibility() != 8) || (j != 0))
      {
        if (!p.j(localObject1, this.rhx)) {
          break label317;
        }
        if ((this.AcP) || (this.Adc == c.Adk)) {
          break label427;
        }
      }
    }
    label422:
    label427:
    for (paramInt1 = i - this.AcV;; paramInt1 = i)
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
          if (p.j(localObject1, this.Vl))
          {
            this.Vo = (((View)localObject1).getMeasuredWidth() - (this.AcW + this.AcY));
            this.Adb = this.Vo;
          }
          j += 1;
          break;
          label317:
          if (!p.j(localObject1, this.Vl)) {
            break label422;
          }
          paramInt1 = i - ((FrameLayout.LayoutParams)localObject2).leftMargin + this.AcY;
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
        AppMethodBeat.o(200732);
        return;
        paramInt1 = i;
      }
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200727);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 != paramInt4)
    {
      this.mFirstLayout = true;
      synchronized (this.AcI)
      {
        Iterator localIterator = this.AcI.iterator();
        if (localIterator.hasNext()) {
          ((b)localIterator.next()).hm(paramInt1, paramInt2);
        }
      }
      x localx = x.SXb;
      AppMethodBeat.o(200727);
      return;
    }
    AppMethodBeat.o(200727);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200737);
    p.h(paramMotionEvent, "ev");
    if (!this.mCanSlide)
    {
      localObject = this.AaG;
      if ((localObject != null) && (((c)localObject).UD.isFinished() == true))
      {
        localObject = this.AaG;
        if (localObject != null) {
          ((c)localObject).abort();
        }
        boolean bool = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(200737);
        return bool;
      }
    }
    for (;;)
    {
      try
      {
        i = i.e(paramMotionEvent);
        if ((i != 3) && (i != 1)) {
          break;
        }
        float f2 = paramMotionEvent.getX();
        float f1 = paramMotionEvent.getY();
        f2 = Math.abs(f2 - this.mInitialMotionX);
        f1 = Math.abs(f1 - this.mInitialMotionY);
        localObject = this.AaG;
        if (localObject != null)
        {
          i = ((c)localObject).rZ;
          if ((f1 > i) || (f2 > i) || (this.AcJ != 0) || (this.Vm <= 0.0F) || (!i(this.rhx, (int)this.mInitialMotionX, (int)this.mInitialMotionY)) || (this.AcH == null) || (getPanelState() == c.Adl)) {
            break;
          }
          paramMotionEvent = this.AcH;
          if (paramMotionEvent != null) {
            paramMotionEvent.onClick((View)this);
          }
          AppMethodBeat.o(200737);
          return true;
        }
      }
      catch (Exception paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.MultiTaskViewGroup", (Throwable)paramMotionEvent, "get a Exception", new Object[0]);
        AppMethodBeat.o(200737);
        return false;
      }
      localObject = ViewConfiguration.get(getContext());
      p.g(localObject, "ViewConfiguration.get(context)");
      int i = ((ViewConfiguration)localObject).getScaledTouchSlop();
    }
    Object localObject = this.AaG;
    if (localObject != null) {
      ((c)localObject).k(paramMotionEvent);
    }
    AppMethodBeat.o(200737);
    return true;
  }
  
  public final void setCanSlide(boolean paramBoolean)
  {
    this.mCanSlide = paramBoolean;
  }
  
  public final void setCoveredFadeColor(int paramInt)
  {
    AppMethodBeat.i(200720);
    this.Vh = paramInt;
    requestLayout();
    AppMethodBeat.o(200720);
  }
  
  public final void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(200719);
    if (paramInt == 0) {
      if (paramBoolean) {
        a(c.Adh, false);
      }
    }
    for (;;)
    {
      if (!paramBoolean) {
        this.AcJ = paramInt;
      }
      AppMethodBeat.o(200719);
      return;
      a(c.Adh, true);
      continue;
      if (paramBoolean) {
        a(c.Adi, false);
      } else {
        a(c.Adi, true);
      }
    }
  }
  
  public final void setDragView(View paramView)
  {
    this.AcX = paramView;
  }
  
  public final void setExtraSlideRange(int paramInt)
  {
    this.AcY = paramInt;
  }
  
  public final void setFadeOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(200718);
    p.h(paramOnClickListener, "listener");
    this.AcH = paramOnClickListener;
    AppMethodBeat.o(200718);
  }
  
  protected final void setMDragHelper(c paramc)
  {
    this.AaG = paramc;
  }
  
  public final void setOverlayed(boolean paramBoolean)
  {
    this.AcP = paramBoolean;
  }
  
  public final void setPanelExpose(int paramInt)
  {
    this.AcW = paramInt;
  }
  
  public final void setPanelWidth(int paramInt)
  {
    AppMethodBeat.i(200721);
    if (getPanelWidth() == paramInt)
    {
      AppMethodBeat.o(200721);
      return;
    }
    this.AcV = paramInt;
    if (!this.mFirstLayout) {
      requestLayout();
    }
    if (getPanelState() == c.Adi)
    {
      a(0.0F, 0L, false);
      invalidate();
      AppMethodBeat.o(200721);
      return;
    }
    AppMethodBeat.o(200721);
  }
  
  public final void setParallaxOffset(int paramInt)
  {
    AppMethodBeat.i(200725);
    this.Adb = paramInt;
    if (!this.mFirstLayout) {
      requestLayout();
    }
    AppMethodBeat.o(200725);
  }
  
  public final void setShadowWidth(int paramInt)
  {
    AppMethodBeat.i(200723);
    this.Ada = paramInt;
    if (!this.mFirstLayout) {
      invalidate();
    }
    AppMethodBeat.o(200723);
  }
  
  public final void setSlideLeft(boolean paramBoolean)
  {
    this.AcO = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelSlideListener;", "", "enableExpand", "", "onPanelItemSelected", "", "panel", "Landroid/view/View;", "position", "", "onPanelSizeChanged", "screenSizeW", "screenSizeH", "onPanelSlide", "slideOffset", "", "onPanelStateChanged", "previousState", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "newState", "onPanelTouchEnd", "onPanelTouchSlide", "onPanelTouchStart", "onPlaySound", "plugin-multitask_release"})
  public static abstract interface b
  {
    public abstract void RQ(int paramInt);
    
    public abstract void a(b.c paramc1, b.c paramc2);
    
    public abstract void bB(float paramFloat);
    
    public abstract void bC(float paramFloat);
    
    public abstract void err();
    
    public abstract void ers();
    
    public abstract void ert();
    
    public abstract boolean eru();
    
    public abstract void hm(int paramInt1, int paramInt2);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$PanelState;", "", "(Ljava/lang/String;I)V", "EXPANDED", "COLLAPSED", "ANCHORED", "HIDDEN", "DRAGGING", "plugin-multitask_release"})
  public static enum c
  {
    static
    {
      AppMethodBeat.i(200705);
      c localc1 = new c("EXPANDED", 0);
      Adh = localc1;
      c localc2 = new c("COLLAPSED", 1);
      Adi = localc2;
      c localc3 = new c("ANCHORED", 2);
      Adj = localc3;
      c localc4 = new c("HIDDEN", 3);
      Adk = localc4;
      c localc5 = new c("DRAGGING", 4);
      Adl = localc5;
      Adm = new c[] { localc1, localc2, localc3, localc4, localc5 };
      AppMethodBeat.o(200705);
    }
    
    private c() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout$ViewDragCallback;", "Lcom/tencent/mm/plugin/multitask/animation/swipeback/base/MultiTaskSwipeDragHelper$Callback;", "Lcom/tencent/mm/ui/base/ActivityUtil$IConvertActivityTranslucentCallback;", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskPanelLayout;)V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "getViewHorizontalDragRange", "onComplete", "", "drawComplete", "", "onViewCaptured", "capturedChild", "activePointerId", "onViewDragStateChanged", "state", "onViewPositionChanged", "changedView", "top", "dy", "onViewReleased", "releasedChild", "xvel", "", "yvel", "onViewTouchPositionChanged", "touchX", "touchY", "adx", "ady", "tryCaptureView", "pointerId", "plugin-multitask_release"})
  public final class d
    extends c.a
    implements com.tencent.mm.ui.base.b.b
  {
    public final void L(int paramInt)
    {
      AppMethodBeat.i(200713);
      Log.d("MicroMsg.MultiTaskViewGroup", "onViewDragStateChanged, state:".concat(String.valueOf(paramInt)));
      if (this.Adn.getMDragHelper() != null)
      {
        Object localObject = this.Adn.getMDragHelper();
        b localb;
        View localView;
        if (localObject != null)
        {
          if (((c)localObject).Aas != 0) {
            break label236;
          }
          localObject = this.Adn;
          localb = this.Adn;
          localView = b.j(this.Adn);
          if (localView == null) {
            break label135;
          }
        }
        label135:
        for (paramInt = localView.getLeft();; paramInt = 0)
        {
          b.a((b)localObject, b.b(localb, paramInt));
          b.k(this.Adn);
          if (b.h(this.Adn) != 1.0F) {
            break;
          }
          this.Adn.erp();
          b.a(this.Adn, b.c.Adh);
          AppMethodBeat.o(200713);
          return;
          AppMethodBeat.o(200713);
          return;
        }
        if (b.h(this.Adn) == 0.0F)
        {
          b.a(this.Adn, b.c.Adi);
          AppMethodBeat.o(200713);
          return;
        }
        if (b.h(this.Adn) < 0.0F)
        {
          b.a(this.Adn, b.c.Adk);
          localObject = b.j(this.Adn);
          if (localObject != null)
          {
            ((View)localObject).setVisibility(4);
            AppMethodBeat.o(200713);
            return;
          }
          AppMethodBeat.o(200713);
          return;
        }
        this.Adn.erp();
        b.a(this.Adn, b.c.Adj);
      }
      label236:
      AppMethodBeat.o(200713);
    }
    
    public final int RI(int paramInt)
    {
      AppMethodBeat.i(200712);
      int i = b.b(this.Adn, 0.0F);
      int j = b.b(this.Adn, 1.0F);
      if (b.e(this.Adn))
      {
        paramInt = Math.min(Math.max(paramInt, j), i);
        AppMethodBeat.o(200712);
        return paramInt;
      }
      paramInt = Math.min(Math.max(paramInt, i), j);
      AppMethodBeat.o(200712);
      return paramInt;
    }
    
    public final void a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(200716);
      Log.d("MicroMsg.MultiTaskViewGroup", "touchX: %f, touchY: %f, dx: %d, dy: %d, adx: %d, ady: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      if (b.f(this.Adn) == 1)
      {
        if (b.h(this.Adn) <= 0.1F) {
          b.a(this.Adn, false);
        }
        if (!b.c(this.Adn))
        {
          paramFloat1 = this.Adn.getWidth();
          if (paramInt3 > paramFloat1 * 0.5F)
          {
            ??? = b.l(this.Adn);
            if (??? != null) {
              ((Vibrator)???).vibrate(10L);
            }
            b.a(this.Adn, true);
            Object localObject2 = this.Adn;
            synchronized (((b)localObject2).AcI)
            {
              localObject2 = ((b)localObject2).AcI.iterator();
              if (((Iterator)localObject2).hasNext()) {
                ((b.b)((Iterator)localObject2).next()).ert();
              }
            }
            localObject4 = x.SXb;
          }
        }
      }
      Object localObject4 = this.Adn;
      paramFloat1 = b.h(this.Adn);
      synchronized (((b)localObject4).AcI)
      {
        localObject4 = ((b)localObject4).AcI.iterator();
        if (((Iterator)localObject4).hasNext()) {
          ((b.b)((Iterator)localObject4).next()).bC(paramFloat1);
        }
      }
      x localx = x.SXb;
      AppMethodBeat.o(200716);
    }
    
    public final int awM()
    {
      AppMethodBeat.i(200709);
      int i = b.d(this.Adn);
      AppMethodBeat.o(200709);
      return i;
    }
    
    public final void b(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(200711);
      Log.d("MicroMsg.MultiTaskViewGroup", "onViewReleased, xvel: %f, yvel: %f, dx: %f, dy: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Float.valueOf(paramFloat4) });
      b.a(this.Adn, false);
      label104:
      c localc;
      label145:
      int i;
      if (b.e(this.Adn))
      {
        paramFloat2 = -paramFloat1;
        if (this.Adn.getWidth() <= 0) {
          break label604;
        }
        float f = this.Adn.getWidth();
        if (b.f(this.Adn) != 0) {
          break label300;
        }
        paramFloat4 = 0.25F;
        if (Math.abs(paramFloat3) >= paramFloat4 * f) {
          break label313;
        }
        f = Math.abs(paramFloat1);
        localc = this.Adn.getMDragHelper();
        if (localc == null) {
          break label307;
        }
        paramFloat4 = localc.Aat;
        if (f > paramFloat4 * 0.95F) {
          break label313;
        }
        if (b.f(this.Adn) != 1) {
          break label612;
        }
        paramFloat1 = 0.0F;
        i = 0;
      }
      for (;;)
      {
        label173:
        if (!b.g(this.Adn))
        {
          paramFloat1 = 0.0F;
          i = 0;
        }
        if ((paramFloat1 > 0.0F) && (b.h(this.Adn) <= b.i(this.Adn))) {
          i = b.b(this.Adn, b.i(this.Adn));
        }
        for (;;)
        {
          if ((this.Adn.getMDragHelper() != null) && (paramView != null))
          {
            localc = this.Adn.getMDragHelper();
            if (localc != null)
            {
              int j = paramView.getTop();
              if (!localc.WM)
              {
                paramView = (Throwable)new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased".toString());
                AppMethodBeat.o(200711);
                throw paramView;
                paramFloat2 = paramFloat1;
                break;
                label300:
                paramFloat4 = 0.5F;
                break label104;
                label307:
                paramFloat4 = 0.0F;
                break label145;
                label313:
                if (paramFloat1 != 0.0F) {
                  break label604;
                }
                paramFloat1 = paramFloat3;
                if (b.e(this.Adn)) {
                  paramFloat1 = -paramFloat3;
                }
                i = 1;
                break label173;
                if ((paramFloat1 > 0.0F) && (b.h(this.Adn) > b.i(this.Adn)))
                {
                  i = b.b(this.Adn, 1.0F);
                  continue;
                }
                if ((paramFloat1 < 0.0F) && (b.h(this.Adn) >= b.i(this.Adn)))
                {
                  i = b.b(this.Adn, b.i(this.Adn));
                  continue;
                }
                if ((paramFloat1 >= 0.0F) || (b.h(this.Adn) >= b.i(this.Adn)))
                {
                  if ((b.h(this.Adn) >= (b.i(this.Adn) + 1.0F) / 2.0F) && (i != 0))
                  {
                    i = b.b(this.Adn, 1.0F);
                    continue;
                  }
                  if ((b.h(this.Adn) >= b.i(this.Adn) / 2.0F) && (i != 0))
                  {
                    i = b.b(this.Adn, b.i(this.Adn));
                    continue;
                  }
                }
                i = b.b(this.Adn, 0.0F);
                continue;
              }
              localc.a(i, j, (int)android.support.v4.view.t.a(localc.mVelocityTracker, localc.om), (int)android.support.v4.view.t.b(localc.mVelocityTracker, localc.om), 0L, false);
            }
          }
        }
        this.Adn.erm();
        this.Adn.invalidate();
        AppMethodBeat.o(200711);
        return;
        label604:
        i = 1;
        paramFloat1 = paramFloat2;
        continue;
        label612:
        paramFloat1 = 0.0F;
        i = 1;
      }
    }
    
    public final boolean c(View arg1, int paramInt)
    {
      AppMethodBeat.i(200708);
      if (??? != null) {}
      for (??? = ???.toString();; ??? = null)
      {
        Log.d("MicroMsg.MultiTaskViewGroup", "tryCaptureView, child: %s", new Object[] { ??? });
        Object localObject1 = this.Adn;
        synchronized (((b)localObject1).AcI)
        {
          localObject1 = ((b)localObject1).AcI.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          ((b.b)((Iterator)localObject1).next()).err();
        }
      }
      x localx = x.SXb;
      boolean bool;
      if (b.a(this.Adn) == b.c.Adi)
      {
        if (!b.b(this.Adn))
        {
          ??? = this.Adn.getMDragHelper();
          if (??? != null) {}
          for (bool = ???.hl(8, paramInt); bool; bool = false)
          {
            AppMethodBeat.o(200708);
            return true;
          }
        }
        AppMethodBeat.o(200708);
        return false;
      }
      if (b.a(this.Adn) == b.c.Adh)
      {
        if (!b.b(this.Adn))
        {
          ??? = this.Adn.getMDragHelper();
          if (??? != null) {}
          for (bool = ???.hl(4, paramInt); bool; bool = false)
          {
            AppMethodBeat.o(200708);
            return true;
          }
        }
        AppMethodBeat.o(200708);
        return false;
      }
      if (b.a(this.Adn) == b.c.Adl)
      {
        AppMethodBeat.o(200708);
        return true;
      }
      b.a(this.Adn, false);
      AppMethodBeat.o(200708);
      return false;
    }
    
    public final void ei(boolean paramBoolean)
    {
      AppMethodBeat.i(200714);
      Log.d("MicroMsg.MultiTaskViewGroup", "onComplete");
      AppMethodBeat.o(200714);
    }
    
    public final void eqJ()
    {
      AppMethodBeat.i(200715);
      Log.i("MicroMsg.MultiTaskViewGroup", "onViewCaptured");
      this.Adn.gf();
      AppMethodBeat.o(200715);
    }
    
    public final void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(200710);
      if (paramView != null) {}
      for (paramView = paramView.toString();; paramView = null)
      {
        Log.d("MicroMsg.MultiTaskViewGroup", "changedView: %s, left: %d, top: %d, dx: %d, dy: %d", new Object[] { paramView, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
        b.a(this.Adn, paramInt1);
        this.Adn.invalidate();
        AppMethodBeat.o(200710);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.ui.base.b
 * JD-Core Version:    0.7.0.1
 */