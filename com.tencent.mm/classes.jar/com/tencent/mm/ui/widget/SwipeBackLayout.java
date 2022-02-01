package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.support.v4.widget.p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.b;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.mogic.a.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.tools.j.a;

public class SwipeBackLayout
  extends FrameLayout
{
  public a QFb;
  public a QFc;
  private float TH;
  private Rect Ui;
  private Drawable hfA;
  private boolean hfB;
  private boolean hfC;
  private float hfn;
  private int hfo;
  private int hfp;
  private float hfr;
  public Drawable hfs;
  private boolean hft;
  private boolean hfu;
  public boolean hfv;
  public boolean hfw;
  public boolean hfx;
  private boolean hfy;
  public View mContentView;
  private boolean mEnable;
  private boolean mInLayout;
  private b mSwipeBackListener;
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143486);
    this.hfn = 0.3F;
    this.mEnable = true;
    this.Ui = new Rect();
    this.hft = true;
    this.hfu = false;
    this.hfv = false;
    this.hfw = false;
    this.hfx = false;
    this.hfy = false;
    this.hfC = true;
    this.QFc = null;
    this.hfs = getResources().getDrawable(2131234799);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    AppMethodBeat.o(143486);
  }
  
  public final void CV(boolean paramBoolean)
  {
    AppMethodBeat.i(143488);
    Log.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.hfv = paramBoolean;
    AppMethodBeat.o(143488);
  }
  
  public final boolean awK()
  {
    AppMethodBeat.i(143491);
    if (!this.hfx)
    {
      AppMethodBeat.o(143491);
      return false;
    }
    if (Float.compare(this.mContentView.getLeft(), 0.01F) <= 0)
    {
      this.hfx = false;
      AppMethodBeat.o(143491);
      return false;
    }
    AppMethodBeat.o(143491);
    return true;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(143496);
    this.TH = Math.max(0.0F, 1.0F - this.hfr);
    a locala = this.QFb;
    if (locala.Wx == 2)
    {
      boolean bool2 = locala.hgg.UD.computeScrollOffset();
      i = locala.hgg.UD.getCurrX();
      int j = locala.hgg.UD.getCurrY();
      int k = i - locala.WL.getLeft();
      int m = j - locala.WL.getTop();
      if (k != 0) {
        locala.WL.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.WL.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.Qnx.cL(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == locala.hgg.UD.getFinalX())
        {
          bool1 = bool2;
          if (j == locala.hgg.UD.getFinalY())
          {
            locala.hgg.UD.abortAnimation();
            bool1 = locala.hgg.UD.isFinished();
          }
        }
      }
      if (!bool1) {
        locala.WN.post(locala.WO);
      }
    }
    if (locala.Wx == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        u.X(this);
      }
      AppMethodBeat.o(143496);
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(143492);
    boolean bool;
    if (!this.mEnable)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143492);
      return bool;
    }
    if ((this.mSwipeBackListener != null) && (this.mSwipeBackListener.eqF())) {
      if (this.mSwipeBackListener.eqH())
      {
        if (this.mSwipeBackListener.eqE() == 1)
        {
          this.mSwipeBackListener.n(paramMotionEvent);
          AppMethodBeat.o(143492);
          return true;
        }
        if (this.mSwipeBackListener.j(paramMotionEvent))
        {
          paramMotionEvent.setAction(3);
          super.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(143492);
          return true;
        }
      }
      else
      {
        this.mSwipeBackListener.n(paramMotionEvent);
      }
    }
    if (paramMotionEvent.getAction() == 0) {
      this.hfB = false;
    }
    if (this.hfB)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143492);
      return bool;
    }
    if (awK())
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143492);
      return bool;
    }
    float f1;
    float f2;
    int k;
    int m;
    int n;
    label750:
    float f3;
    label790:
    View localView;
    for (;;)
    {
      try
      {
        if (this.QFb.Wx != 1) {
          break;
        }
        locala = this.QFb;
        j = paramMotionEvent.getActionMasked();
        i = paramMotionEvent.getActionIndex();
        if (j == 0) {
          locala.cancel();
        }
        if (locala.mVelocityTracker == null) {
          locala.mVelocityTracker = VelocityTracker.obtain();
        }
        locala.mVelocityTracker.addMovement(paramMotionEvent);
        switch (j)
        {
        }
      }
      catch (NullPointerException paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an NullPointerException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
        i = (int)f1;
        k = (int)f2;
        paramMotionEvent = locala.WL;
        if ((paramMotionEvent == null) || (i < paramMotionEvent.getLeft()) || (i >= paramMotionEvent.getRight()) || (k < paramMotionEvent.getTop()) || (k >= paramMotionEvent.getBottom())) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        locala.z(locala.WL, j);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalArgumentException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
        i = 0;
        continue;
        if (locala.Wx != 1) {
          continue;
        }
        i = paramMotionEvent.findPointerIndex(locala.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        m = (int)(f1 - locala.WA[locala.mActivePointerId]);
        n = (int)(f2 - locala.WB[locala.mActivePointerId]);
        k = locala.WL.getLeft() + m;
        j = locala.WL.getTop() + n;
        int i2 = locala.WL.getLeft();
        int i1 = locala.WL.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = locala.Qnx.e(locala.WL, k);
        locala.WL.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1601;
        }
        locala.WL.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1601;
        locala.Qnx.cL(i, j);
        locala.i(paramMotionEvent);
        continue;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an ArrayIndexOutOfBoundsException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
        j = paramMotionEvent.getPointerCount();
        i = 0;
        if (i >= j) {
          continue;
        }
        k = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        f3 = f1 - locala.Wy[k];
        locala.b(f3, f2 - locala.Wz[k], k);
        if (locala.Wx == 1) {
          continue;
        }
        localView = locala.J((int)f1, (int)f2);
        if ((!locala.r(localView, f3)) || (!locala.z(localView, k))) {
          break label1614;
        }
        locala.i(paramMotionEvent);
        continue;
      }
      catch (IllegalStateException paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalStateException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
      }
      AppMethodBeat.o(143492);
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      paramMotionEvent = locala.J((int)f1, (int)f2);
      locala.a(f1, f2, i);
      locala.z(paramMotionEvent, i);
      i = locala.WC[i];
      if ((locala.WJ & i) != 0)
      {
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if (locala.Wx == 0)
        {
          locala.z(locala.J((int)f1, (int)f2), j);
        }
        else
        {
          j = paramMotionEvent.getPointerId(i);
          if ((locala.Wx == 1) && (j == locala.mActivePointerId))
          {
            k = paramMotionEvent.getPointerCount();
            i = 0;
            label964:
            if (i >= k) {
              break label1595;
            }
            m = paramMotionEvent.getPointerId(i);
            if (m == locala.mActivePointerId) {
              break label1623;
            }
            f1 = paramMotionEvent.getX(i);
            f2 = paramMotionEvent.getY(i);
            if ((locala.J((int)f1, (int)f2) != locala.WL) || (!locala.z(locala.WL, m))) {
              break label1623;
            }
            i = locala.mActivePointerId;
            label1042:
            if (i == -1) {
              locala.gq();
            }
          }
          locala.bd(j);
          continue;
          if (locala.Wx == 1) {
            locala.gq();
          }
          locala.cancel();
          continue;
          if (locala.Wx == 1) {
            locala.l(0.0F, 0.0F);
          }
          locala.cancel();
        }
      }
    }
    a locala = this.QFb;
    int j = paramMotionEvent.getActionMasked();
    int i = paramMotionEvent.getActionIndex();
    if (j == 0) {
      locala.cancel();
    }
    if (locala.mVelocityTracker == null) {
      locala.mVelocityTracker = VelocityTracker.obtain();
    }
    locala.mVelocityTracker.addMovement(paramMotionEvent);
    switch (j)
    {
    case 4: 
      label1208:
      if (locala.Wx != 1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        Log.i("changelcai", "shouldInterceptTouchEvent %s", new Object[] { paramMotionEvent });
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(143492);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = paramMotionEvent.getPointerId(0);
        locala.a(f1, f2, i);
        localView = locala.J((int)f1, (int)f2);
        if ((localView == locala.WL) && (locala.Wx == 2)) {
          locala.z(localView, i);
        }
        if ((locala.WC[i] & locala.WJ) == 0) {
          break label1208;
        }
        break label1208;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if ((locala.Wx == 0) || (locala.Wx != 2)) {
          break label1208;
        }
        localView = locala.J((int)f1, (int)f2);
        if (localView != locala.WL) {
          break label1208;
        }
        locala.z(localView, j);
        break label1208;
        j = paramMotionEvent.getPointerCount();
        i = 0;
      }
      for (;;)
      {
        if (i < j)
        {
          k = paramMotionEvent.getPointerId(i);
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          f3 = f1 - locala.Wy[k];
          locala.b(f3, f2 - locala.Wz[k], k);
          if (locala.Wx != 1)
          {
            localView = locala.J((int)f1, (int)f2);
            if ((localView == null) || (!locala.r(localView, f3)) || (!locala.z(localView, k))) {
              break label1635;
            }
          }
        }
        locala.i(paramMotionEvent);
        break label1208;
        locala.bd(paramMotionEvent.getPointerId(i));
        break label1208;
        locala.cancel();
        break label1208;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(143492);
        return true;
        label1595:
        i = -1;
        break label1042;
        label1601:
        if (m != 0) {
          break;
        }
        if (n == 0) {
          break label750;
        }
        break;
        label1614:
        i += 1;
        break label790;
        label1623:
        i += 1;
        break label964;
        break label1208;
        label1635:
        i += 1;
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(143495);
    if (paramView == this.mContentView) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((Float.compare(this.TH, 0.0F) > 0) && (i != 0) && (this.QFb.Wx != 0))
      {
        Rect localRect = this.Ui;
        paramView.getHitRect(localRect);
        this.hfs.setBounds(localRect.left - this.hfs.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.hfs.setAlpha((int)(this.TH * 255.0F));
        this.hfs.draw(paramCanvas);
      }
      AppMethodBeat.o(143495);
      return bool;
    }
  }
  
  public View getTargetContentView()
  {
    return this.mContentView;
  }
  
  public final boolean gqI()
  {
    AppMethodBeat.i(143489);
    awK();
    boolean bool = this.hfx;
    AppMethodBeat.o(143489);
    return bool;
  }
  
  public final void init()
  {
    AppMethodBeat.i(143487);
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(getContext(), 2130772093);
    this.QFb = a.a(this, new c((byte)0), localInterpolator);
    this.QFb.WJ = 1;
    float f = getResources().getDisplayMetrics().density;
    this.QFb.WH = (100.0F * f);
    this.QFb.WG = (f * 300.0F);
    this.hfo = 0;
    this.hfp = 0;
    AppMethodBeat.o(143487);
  }
  
  public void onFinishInflate()
  {
    this.mContentView = this;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(143493);
    this.mInLayout = true;
    if (this.mContentView != null) {
      this.mContentView.layout(this.hfo, this.hfp, this.hfo + this.mContentView.getMeasuredWidth(), this.hfp + this.mContentView.getMeasuredHeight());
    }
    this.mInLayout = false;
    AppMethodBeat.o(143493);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(143494);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(143494);
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setNeedChangeWindowBackground(boolean paramBoolean)
  {
    this.hfC = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.hft = paramBoolean;
    if (this.hft) {
      this.hfu = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(143490);
    Log.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.hfB = paramBoolean;
    AppMethodBeat.o(143490);
  }
  
  public void setSwipeBackListener(b paramb)
  {
    this.mSwipeBackListener = paramb;
  }
  
  public void setSwipeGestureDelegate(a parama)
  {
    this.QFc = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  public static abstract interface b
  {
    public abstract void RF(int paramInt);
    
    public abstract int bS(boolean paramBoolean);
    
    public abstract void bw(float paramFloat);
    
    public abstract int eqE();
    
    public abstract boolean eqF();
    
    public abstract boolean eqH();
    
    public abstract boolean j(MotionEvent paramMotionEvent);
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
  
  final class c
    extends a.a
    implements b.b
  {
    int hfE = 0;
    int hfF = 0;
    int hfG = 0;
    
    private c() {}
    
    public final void L(int paramInt)
    {
      AppMethodBeat.i(143484);
      Log.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(SwipeBackLayout.l(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.m(SwipeBackLayout.this)) });
      if (1 == paramInt)
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
        if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) == null))
        {
          SwipeBackLayout.a(SwipeBackLayout.this, ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground());
          if (SwipeBackLayout.j(SwipeBackLayout.this)) {
            ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(2131101287);
          }
        }
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null) {
          SwipeBackLayout.h(SwipeBackLayout.this).onDrag();
        }
        SwipeBackLayout.a(SwipeBackLayout.this, false);
        if (SwipeBackLayout.c(SwipeBackLayout.this)) {
          h.aq(0.0F);
        }
      }
      if ((paramInt == 0) && (!SwipeBackLayout.m(SwipeBackLayout.this)))
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
        {
          if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) != null))
          {
            if (SwipeBackLayout.j(SwipeBackLayout.this)) {
              ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.i(SwipeBackLayout.this));
            }
            SwipeBackLayout.a(SwipeBackLayout.this, null);
          }
          SwipeBackLayout.h(SwipeBackLayout.this).onCancel();
        }
        h.aq(1.0F);
      }
      if ((1 == paramInt) && (SwipeBackLayout.n(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.c(SwipeBackLayout.this)) && (!SwipeBackLayout.l(SwipeBackLayout.this)))
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        b.a((Activity)SwipeBackLayout.this.getContext(), this);
      }
      if (2 == paramInt)
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.hfF) });
        if (this.hfF <= 0) {
          break label429;
        }
      }
      label429:
      for (boolean bool = true;; bool = false)
      {
        h.h(bool, this.hfF);
        AppMethodBeat.o(143484);
        return;
      }
    }
    
    public final void RF(int paramInt)
    {
      AppMethodBeat.i(205444);
      if (SwipeBackLayout.b(SwipeBackLayout.this) != null) {
        SwipeBackLayout.b(SwipeBackLayout.this).RF(paramInt);
      }
      AppMethodBeat.o(205444);
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(143482);
      int i = paramView.getWidth();
      this.hfF = 0;
      this.hfG = 0;
      boolean bool;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.f(SwipeBackLayout.this) > SwipeBackLayout.k(SwipeBackLayout.this))))
      {
        i = i + SwipeBackLayout.e(SwipeBackLayout.this).getIntrinsicWidth() + 10;
        this.hfF = i;
        Log.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.hfF), Integer.valueOf(this.hfG), Boolean.valueOf(SwipeBackLayout.c(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.b(SwipeBackLayout.this) != null)
        {
          paramView = SwipeBackLayout.b(SwipeBackLayout.this);
          if (this.hfF == 0) {
            break label270;
          }
          bool = true;
          label170:
          i = paramView.bS(bool);
          Log.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", new Object[] { Integer.valueOf(i) });
          if (i != 2) {
            break label276;
          }
          this.hfF = 0;
        }
      }
      for (;;)
      {
        if (SwipeBackLayout.c(SwipeBackLayout.this))
        {
          paramView = SwipeBackLayout.a(SwipeBackLayout.this);
          i = this.hfF;
          int j = this.hfG;
          if (!paramView.WM)
          {
            paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
            AppMethodBeat.o(143482);
            throw paramView;
            i = 0;
            break;
            label270:
            bool = false;
            break label170;
            label276:
            if (i != 3) {
              continue;
            }
            AppMethodBeat.o(143482);
            return;
          }
          paramView.b(i, j, (int)paramView.mVelocityTracker.getXVelocity(paramView.mActivePointerId), (int)paramView.mVelocityTracker.getYVelocity(paramView.mActivePointerId), 0L);
          SwipeBackLayout.this.invalidate();
          AppMethodBeat.o(143482);
          return;
        }
      }
      SwipeBackLayout.c(SwipeBackLayout.this, true);
      AppMethodBeat.o(143482);
    }
    
    public final int awM()
    {
      return 1;
    }
    
    public final void cL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(143481);
      if (!SwipeBackLayout.c(SwipeBackLayout.this))
      {
        Log.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false");
        AppMethodBeat.o(143481);
        return;
      }
      SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.d(SwipeBackLayout.this).getWidth() + SwipeBackLayout.e(SwipeBackLayout.this).getIntrinsicWidth())));
      SwipeBackLayout.a(SwipeBackLayout.this, paramInt1);
      SwipeBackLayout.b(SwipeBackLayout.this, paramInt2);
      SwipeBackLayout.this.invalidate();
      if (SwipeBackLayout.b(SwipeBackLayout.this) != null) {
        SwipeBackLayout.b(SwipeBackLayout.this).bw(SwipeBackLayout.f(SwipeBackLayout.this));
      }
      if ((Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 1.0F) >= 0) && (!SwipeBackLayout.g(SwipeBackLayout.this)))
      {
        SwipeBackLayout.a(SwipeBackLayout.this, true);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143473);
            if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
            {
              Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
              if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) != null))
              {
                if (SwipeBackLayout.j(SwipeBackLayout.this)) {
                  ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.i(SwipeBackLayout.this));
                }
                SwipeBackLayout.a(SwipeBackLayout.this, null);
              }
              SwipeBackLayout.h(SwipeBackLayout.this).onSwipeBack();
            }
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            AppMethodBeat.o(143473);
          }
        });
      }
      for (;;)
      {
        if (SwipeBackLayout.a(SwipeBackLayout.this).Wx == 1) {
          h.aq(SwipeBackLayout.f(SwipeBackLayout.this));
        }
        AppMethodBeat.o(143481);
        return;
        if (Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 0.01F) <= 0)
        {
          SwipeBackLayout.b(SwipeBackLayout.this, false);
          Log.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", new Object[] { Float.valueOf(SwipeBackLayout.f(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.g(SwipeBackLayout.this)) });
        }
      }
    }
    
    public final int e(View paramView, int paramInt)
    {
      AppMethodBeat.i(143483);
      if (SwipeBackLayout.c(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.hfE, paramInt);
        this.hfE = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        AppMethodBeat.o(143483);
        return paramInt;
      }
      this.hfE = Math.max(this.hfE, paramInt);
      AppMethodBeat.o(143483);
      return 0;
    }
    
    public final void ei(final boolean paramBoolean)
    {
      AppMethodBeat.i(143485);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143479);
          Log.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.c.this.hfF) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.c.this.hfF > 0)
            {
              h.aq(0.0F);
              SwipeBackLayout.this.CV(paramBoolean);
              if ((paramBoolean) && (SwipeBackLayout.m(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.c.this.hfF != 0) {
                  break label184;
                }
                j.a(SwipeBackLayout.d(SwipeBackLayout.this), 200L, 0.0F, new j.a()
                {
                  public final void awJ()
                  {
                    AppMethodBeat.i(143475);
                    onAnimationEnd();
                    AppMethodBeat.o(143475);
                  }
                  
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(143474);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(143474);
                  }
                });
              }
            }
          }
          for (;;)
          {
            SwipeBackLayout.c(SwipeBackLayout.this, false);
            AppMethodBeat.o(143479);
            return;
            h.aq(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label184:
            j.a(SwipeBackLayout.d(SwipeBackLayout.this), 200L, SwipeBackLayout.c.this.hfF, new j.a()
            {
              public final void awJ()
              {
                AppMethodBeat.i(143478);
                onAnimationEnd();
                AppMethodBeat.o(143478);
              }
              
              public final void onAnimationEnd()
              {
                AppMethodBeat.i(143477);
                SwipeBackLayout.a(SwipeBackLayout.this, true);
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(143476);
                    if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
                    {
                      if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) != null))
                      {
                        if (SwipeBackLayout.j(SwipeBackLayout.this)) {
                          ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.i(SwipeBackLayout.this));
                        }
                        SwipeBackLayout.a(SwipeBackLayout.this, null);
                      }
                      SwipeBackLayout.h(SwipeBackLayout.this).onSwipeBack();
                      Log.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                    }
                    h.aq(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(143476);
                  }
                });
                AppMethodBeat.o(143477);
              }
            });
            h.h(true, SwipeBackLayout.c.this.hfF);
          }
        }
      });
      AppMethodBeat.o(143485);
    }
    
    public final boolean pv(int paramInt)
    {
      AppMethodBeat.i(143480);
      a locala = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((locala.WF & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((locala.WC[paramInt] & 0x1) != 0); i = 0)
      {
        AppMethodBeat.o(143480);
        return true;
      }
      AppMethodBeat.o(143480);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */