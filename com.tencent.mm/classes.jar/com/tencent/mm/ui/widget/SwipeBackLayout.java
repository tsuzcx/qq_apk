package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
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
import androidx.core.g.w;
import androidx.core.widget.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.d;
import com.tencent.mm.ah.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.b;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.tools.k.a;

public class SwipeBackLayout
  extends FrameLayout
{
  private float RH;
  private Rect Si;
  public a Ydy;
  public a Ydz;
  private float jRf;
  private int jRg;
  private int jRh;
  private float jRj;
  public Drawable jRk;
  private boolean jRl;
  private boolean jRm;
  public boolean jRn;
  public boolean jRo;
  public boolean jRp;
  private boolean jRq;
  private Drawable jRs;
  private boolean jRt;
  private boolean jRu;
  public View mContentView;
  private boolean mEnable;
  private boolean mInLayout;
  private SwipeBackLayout.b mSwipeBackListener;
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143486);
    this.jRf = 0.3F;
    this.mEnable = true;
    this.Si = new Rect();
    this.jRl = true;
    this.jRm = false;
    this.jRn = false;
    this.jRo = false;
    this.jRp = false;
    this.jRq = false;
    this.jRu = true;
    this.Ydz = null;
    this.jRk = getResources().getDrawable(a.f.shadow_left);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    AppMethodBeat.o(143486);
  }
  
  public final void Hp(boolean paramBoolean)
  {
    AppMethodBeat.i(143488);
    Log.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jRn = paramBoolean;
    AppMethodBeat.o(143488);
  }
  
  public final boolean aEc()
  {
    AppMethodBeat.i(143491);
    if (!this.jRp)
    {
      AppMethodBeat.o(143491);
      return false;
    }
    if (Float.compare(this.mContentView.getLeft(), 0.01F) <= 0)
    {
      this.jRp = false;
      AppMethodBeat.o(143491);
      return false;
    }
    AppMethodBeat.o(143491);
    return true;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(143496);
    this.RH = Math.max(0.0F, 1.0F - this.jRj);
    a locala = this.Ydy;
    if (locala.Rh == 2)
    {
      boolean bool2 = locala.jRY.Qi.computeScrollOffset();
      i = locala.jRY.Qi.getCurrX();
      int j = locala.jRY.Qi.getCurrY();
      int k = i - locala.Rv.getLeft();
      int m = j - locala.Rv.getTop();
      if (k != 0) {
        locala.Rv.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.Rv.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.XLw.df(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == locala.jRY.Qi.getFinalX())
        {
          bool1 = bool2;
          if (j == locala.jRY.Qi.getFinalY())
          {
            locala.jRY.Qi.abortAnimation();
            bool1 = locala.jRY.Qi.isFinished();
          }
        }
      }
      if (!bool1) {
        locala.Rx.post(locala.Ry);
      }
    }
    if (locala.Rh == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        w.G(this);
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
    if ((this.mSwipeBackListener != null) && (this.mSwipeBackListener.fav())) {
      if (this.mSwipeBackListener.fay())
      {
        if (this.mSwipeBackListener.fau() == 1)
        {
          this.mSwipeBackListener.n(paramMotionEvent);
          AppMethodBeat.o(143492);
          return true;
        }
        if (this.mSwipeBackListener.i(paramMotionEvent))
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
      this.jRt = false;
    }
    if (this.jRt)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143492);
      return bool;
    }
    if (aEc())
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
        if (this.Ydy.Rh != 1) {
          break;
        }
        locala = this.Ydy;
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
        paramMotionEvent = locala.Rv;
        if ((paramMotionEvent == null) || (i < paramMotionEvent.getLeft()) || (i >= paramMotionEvent.getRight()) || (k < paramMotionEvent.getTop()) || (k >= paramMotionEvent.getBottom())) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        locala.y(locala.Rv, j);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalArgumentException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
        i = 0;
        continue;
        if (locala.Rh != 1) {
          continue;
        }
        i = paramMotionEvent.findPointerIndex(locala.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        m = (int)(f1 - locala.Rk[locala.mActivePointerId]);
        n = (int)(f2 - locala.Rl[locala.mActivePointerId]);
        k = locala.Rv.getLeft() + m;
        j = locala.Rv.getTop() + n;
        int i2 = locala.Rv.getLeft();
        int i1 = locala.Rv.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = locala.XLw.d(locala.Rv, k);
        locala.Rv.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1601;
        }
        locala.Rv.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1601;
        locala.XLw.df(i, j);
        locala.h(paramMotionEvent);
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
        f3 = f1 - locala.Ri[k];
        locala.b(f3, f2 - locala.Rj[k], k);
        if (locala.Rh == 1) {
          continue;
        }
        localView = locala.K((int)f1, (int)f2);
        if ((!locala.r(localView, f3)) || (!locala.y(localView, k))) {
          break label1614;
        }
        locala.h(paramMotionEvent);
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
      paramMotionEvent = locala.K((int)f1, (int)f2);
      locala.a(f1, f2, i);
      locala.y(paramMotionEvent, i);
      i = locala.Rm[i];
      if ((locala.Rt & i) != 0)
      {
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if (locala.Rh == 0)
        {
          locala.y(locala.K((int)f1, (int)f2), j);
        }
        else
        {
          j = paramMotionEvent.getPointerId(i);
          if ((locala.Rh == 1) && (j == locala.mActivePointerId))
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
            if ((locala.K((int)f1, (int)f2) != locala.Rv) || (!locala.y(locala.Rv, m))) {
              break label1623;
            }
            i = locala.mActivePointerId;
            label1042:
            if (i == -1) {
              locala.hN();
            }
          }
          locala.bP(j);
          continue;
          if (locala.Rh == 1) {
            locala.hN();
          }
          locala.cancel();
          continue;
          if (locala.Rh == 1) {
            locala.e(0.0F, 0.0F);
          }
          locala.cancel();
        }
      }
    }
    a locala = this.Ydy;
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
      if (locala.Rh != 1) {
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
        localView = locala.K((int)f1, (int)f2);
        if ((localView == locala.Rv) && (locala.Rh == 2)) {
          locala.y(localView, i);
        }
        if ((locala.Rm[i] & locala.Rt) == 0) {
          break label1208;
        }
        break label1208;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if ((locala.Rh == 0) || (locala.Rh != 2)) {
          break label1208;
        }
        localView = locala.K((int)f1, (int)f2);
        if (localView != locala.Rv) {
          break label1208;
        }
        locala.y(localView, j);
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
          f3 = f1 - locala.Ri[k];
          locala.b(f3, f2 - locala.Rj[k], k);
          if (locala.Rh != 1)
          {
            localView = locala.K((int)f1, (int)f2);
            if ((localView == null) || (!locala.r(localView, f3)) || (!locala.y(localView, k))) {
              break label1635;
            }
          }
        }
        locala.h(paramMotionEvent);
        break label1208;
        locala.bP(paramMotionEvent.getPointerId(i));
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
      if ((Float.compare(this.RH, 0.0F) > 0) && (i != 0) && (this.Ydy.Rh != 0))
      {
        Rect localRect = this.Si;
        paramView.getHitRect(localRect);
        this.jRk.setBounds(localRect.left - this.jRk.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.jRk.setAlpha((int)(this.RH * 255.0F));
        this.jRk.draw(paramCanvas);
      }
      AppMethodBeat.o(143495);
      return bool;
    }
  }
  
  public final void emh()
  {
    AppMethodBeat.i(188135);
    this.Ydy.b(this.mContentView, 0, 10L);
    AppMethodBeat.o(188135);
  }
  
  public View getTargetContentView()
  {
    return this.mContentView;
  }
  
  public final boolean hlH()
  {
    AppMethodBeat.i(143489);
    aEc();
    boolean bool = this.jRp;
    AppMethodBeat.o(143489);
    return bool;
  }
  
  public final void init()
  {
    AppMethodBeat.i(143487);
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(getContext(), com.tencent.mm.ah.a.a.mm_decelerate_interpolator);
    this.Ydy = a.a(this, new c((byte)0), localInterpolator);
    this.Ydy.Rt = 1;
    float f = getResources().getDisplayMetrics().density;
    this.Ydy.Rr = (100.0F * f);
    this.Ydy.Rq = (f * 300.0F);
    this.jRg = 0;
    this.jRh = 0;
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
      this.mContentView.layout(this.jRg, this.jRh, this.jRg + this.mContentView.getMeasuredWidth(), this.jRh + this.mContentView.getMeasuredHeight());
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
    this.jRu = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.jRl = paramBoolean;
    if (this.jRl) {
      this.jRm = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(143490);
    Log.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jRt = paramBoolean;
    AppMethodBeat.o(143490);
  }
  
  public void setSwipeBackListener(SwipeBackLayout.b paramb)
  {
    this.mSwipeBackListener = paramb;
  }
  
  public void setSwipeGestureDelegate(a parama)
  {
    this.Ydz = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  final class c
    extends com.tencent.mm.ui.mogic.a.a
    implements b.b
  {
    int jRw = 0;
    int jRx = 0;
    int jRy = 0;
    
    private c() {}
    
    public final void G(int paramInt)
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
            ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(a.d.transparent);
          }
        }
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null) {
          SwipeBackLayout.h(SwipeBackLayout.this).onDrag();
        }
        SwipeBackLayout.a(SwipeBackLayout.this, false);
        if (SwipeBackLayout.c(SwipeBackLayout.this)) {
          j.ap(0.0F);
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
        j.ap(1.0F);
      }
      if ((1 == paramInt) && (SwipeBackLayout.n(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.c(SwipeBackLayout.this)) && (!SwipeBackLayout.l(SwipeBackLayout.this)))
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        b.a((Activity)SwipeBackLayout.this.getContext(), this);
      }
      if (2 == paramInt)
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.jRx) });
        if (this.jRx <= 0) {
          break label430;
        }
      }
      label430:
      for (boolean bool = true;; bool = false)
      {
        j.j(bool, this.jRx);
        AppMethodBeat.o(143484);
        return;
      }
    }
    
    public final void XV(int paramInt)
    {
      AppMethodBeat.i(206601);
      if (SwipeBackLayout.b(SwipeBackLayout.this) != null) {
        SwipeBackLayout.b(SwipeBackLayout.this).XV(paramInt);
      }
      AppMethodBeat.o(206601);
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(143482);
      int i = paramView.getWidth();
      this.jRx = 0;
      this.jRy = 0;
      boolean bool;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.f(SwipeBackLayout.this) > SwipeBackLayout.k(SwipeBackLayout.this))))
      {
        i = i + SwipeBackLayout.e(SwipeBackLayout.this).getIntrinsicWidth() + 10;
        this.jRx = i;
        Log.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.jRx), Integer.valueOf(this.jRy), Boolean.valueOf(SwipeBackLayout.c(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.b(SwipeBackLayout.this) != null)
        {
          paramView = SwipeBackLayout.b(SwipeBackLayout.this);
          if (this.jRx == 0) {
            break label270;
          }
          bool = true;
          label170:
          i = paramView.cc(bool);
          Log.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", new Object[] { Integer.valueOf(i) });
          if (i != 2) {
            break label276;
          }
          this.jRx = 0;
        }
      }
      for (;;)
      {
        if (SwipeBackLayout.c(SwipeBackLayout.this))
        {
          paramView = SwipeBackLayout.a(SwipeBackLayout.this);
          i = this.jRx;
          int j = this.jRy;
          if (!paramView.Rw)
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
    
    public final int aEe()
    {
      return 1;
    }
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(143483);
      if (SwipeBackLayout.c(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.jRw, paramInt);
        this.jRw = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        AppMethodBeat.o(143483);
        return paramInt;
      }
      this.jRw = Math.max(this.jRw, paramInt);
      AppMethodBeat.o(143483);
      return 0;
    }
    
    public final void df(int paramInt1, int paramInt2)
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
        SwipeBackLayout.b(SwipeBackLayout.this).bz(SwipeBackLayout.f(SwipeBackLayout.this));
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
        if (SwipeBackLayout.a(SwipeBackLayout.this).Rh == 1) {
          j.ap(SwipeBackLayout.f(SwipeBackLayout.this));
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
    
    public final void eG(final boolean paramBoolean)
    {
      AppMethodBeat.i(143485);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143479);
          Log.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.c.this.jRx) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.c.this.jRx > 0)
            {
              j.ap(0.0F);
              SwipeBackLayout.this.Hp(paramBoolean);
              if ((paramBoolean) && (SwipeBackLayout.m(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.c.this.jRx != 0) {
                  break label184;
                }
                k.a(SwipeBackLayout.d(SwipeBackLayout.this), 200L, 0.0F, new k.a()
                {
                  public final void aEa()
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
            j.ap(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label184:
            k.a(SwipeBackLayout.d(SwipeBackLayout.this), 200L, SwipeBackLayout.c.this.jRx, new k.a()
            {
              public final void aEa()
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
                    j.ap(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(143476);
                  }
                });
                AppMethodBeat.o(143477);
              }
            });
            j.j(true, SwipeBackLayout.c.this.jRx);
          }
        }
      });
      AppMethodBeat.o(143485);
    }
    
    public final boolean rS(int paramInt)
    {
      AppMethodBeat.i(143480);
      a locala = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((locala.Rp & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((locala.Rm[paramInt] & 0x1) != 0); i = 0)
      {
        AppMethodBeat.o(143480);
        return true;
      }
      AppMethodBeat.o(143480);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */