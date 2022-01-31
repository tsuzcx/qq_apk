package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.support.v4.widget.n;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.tencent.mm.ac.a.d;
import com.tencent.mm.ac.a.f;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.mogic.a.a;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.h.a;

public class SwipeBackLayout
  extends FrameLayout
{
  private float Kf;
  public View QR;
  private Rect hc = new Rect();
  private boolean mEnable = true;
  private boolean mInLayout;
  private float wkX = 0.3F;
  private int wkY;
  private int wkZ;
  public a wla;
  private float wlb;
  public Drawable wlc = getResources().getDrawable(a.f.shadow_left);
  private boolean wld = true;
  private boolean wle = false;
  public boolean wlf = false;
  public boolean wlg = false;
  public boolean wlh = false;
  private boolean wli = false;
  private b wlj;
  private boolean wlk;
  public a wll = null;
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
  }
  
  public final boolean cKa()
  {
    if (!this.wlh) {
      return false;
    }
    if (Float.compare(this.QR.getLeft(), 0.01F) <= 0)
    {
      this.wlh = false;
      return false;
    }
    return true;
  }
  
  public final boolean cnC()
  {
    cKa();
    return this.wlh;
  }
  
  public void computeScroll()
  {
    this.Kf = Math.max(0.0F, 1.0F - this.wlb);
    a locala = this.wla;
    if (locala.MI == 2)
    {
      boolean bool2 = locala.hBk.iY.computeScrollOffset();
      i = locala.hBk.iY.getCurrX();
      int j = locala.hBk.iY.getCurrY();
      int k = i - locala.MW.getLeft();
      int m = j - locala.MW.getTop();
      if (k != 0) {
        locala.MW.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.MW.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.vXk.fC(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == locala.hBk.iY.getFinalX())
        {
          bool1 = bool2;
          if (j == locala.hBk.iY.getFinalY())
          {
            locala.hBk.iY.abortAnimation();
            bool1 = locala.hBk.iY.isFinished();
          }
        }
      }
      if (!bool1) {
        locala.MY.post(locala.MZ);
      }
    }
    if (locala.MI == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        q.O(this);
      }
      return;
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    if (!this.mEnable) {
      bool = super.dispatchTouchEvent(paramMotionEvent);
    }
    float f1;
    float f2;
    int k;
    int m;
    int n;
    for (;;)
    {
      return bool;
      if (this.wlj != null) {
        this.wlj.l(paramMotionEvent);
      }
      if (paramMotionEvent.getAction() == 0) {
        this.wlk = false;
      }
      if (this.wlk) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      if (cKa()) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      try
      {
        if (this.wla.MI != 1) {
          break label940;
        }
        locala = this.wla;
        j = paramMotionEvent.getActionMasked();
        i = paramMotionEvent.getActionIndex();
        if (j == 0) {
          locala.cancel();
        }
        if (locala.fB == null) {
          locala.fB = VelocityTracker.obtain();
        }
        locala.fB.addMovement(paramMotionEvent);
        switch (j)
        {
        case 0: 
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          i = paramMotionEvent.getPointerId(0);
          paramMotionEvent = locala.y((int)f1, (int)f2);
          locala.a(f1, f2, i);
          locala.u(paramMotionEvent, i);
          i = locala.MN[i];
          if ((locala.MU & i) != 0) {
            return true;
          }
          break;
        case 5: 
          j = paramMotionEvent.getPointerId(i);
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          locala.a(f1, f2, j);
          if (locala.MI == 0)
          {
            locala.u(locala.y((int)f1, (int)f2), j);
            return true;
          }
          break;
        }
      }
      catch (NullPointerException paramMotionEvent)
      {
        y.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an NullPointerException", new Object[0]);
        return false;
        i = (int)f1;
        k = (int)f2;
        paramMotionEvent = locala.MW;
        if ((paramMotionEvent != null) && (i >= paramMotionEvent.getLeft()) && (i < paramMotionEvent.getRight()) && (k >= paramMotionEvent.getTop()) && (k < paramMotionEvent.getBottom()))
        {
          i = 1;
          if (i == 0) {
            continue;
          }
          locala.u(locala.MW, j);
          return true;
        }
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalArgumentException", new Object[0]);
          return false;
          i = 0;
        }
        if (locala.MI == 1)
        {
          i = paramMotionEvent.findPointerIndex(locala.fC);
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          m = (int)(f1 - locala.ML[locala.fC]);
          n = (int)(f2 - locala.MM[locala.fC]);
          k = locala.MW.getLeft() + m;
          j = locala.MW.getTop() + n;
          int i2 = locala.MW.getLeft();
          int i1 = locala.MW.getTop();
          i = k;
          if (m != 0)
          {
            i = locala.vXk.d(locala.MW, k);
            locala.MW.offsetLeftAndRight(i - i2);
          }
          if (n == 0) {
            break label1419;
          }
          locala.MW.offsetTopAndBottom(0 - i1);
          j = 0;
          break label1419;
          locala.vXk.fC(i, j);
          locala.e(paramMotionEvent);
          return true;
        }
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        label613:
        y.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an ArrayIndexOutOfBoundsException", new Object[0]);
        return false;
      }
    }
    int j = paramMotionEvent.getPointerCount();
    int i = 0;
    label647:
    float f3;
    View localView;
    if (i < j)
    {
      k = paramMotionEvent.getPointerId(i);
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      f3 = f1 - locala.MJ[k];
      locala.b(f3, f2 - locala.MK[k], k);
      if (locala.MI != 1)
      {
        localView = locala.y((int)f1, (int)f2);
        if ((!locala.o(localView, f3)) || (!locala.u(localView, k))) {
          break label1432;
        }
      }
    }
    locala.e(paramMotionEvent);
    return true;
    j = paramMotionEvent.getPointerId(i);
    if ((locala.MI == 1) && (j == locala.fC))
    {
      k = paramMotionEvent.getPointerCount();
      i = 0;
      label798:
      if (i >= k) {
        break label1411;
      }
      m = paramMotionEvent.getPointerId(i);
      if (m == locala.fC) {
        break label1441;
      }
      f1 = paramMotionEvent.getX(i);
      f2 = paramMotionEvent.getY(i);
      if ((locala.y((int)f1, (int)f2) != locala.MW) || (!locala.u(locala.MW, m))) {
        break label1441;
      }
      i = locala.fC;
      label876:
      if (i == -1) {
        locala.dX();
      }
    }
    locala.aN(j);
    return true;
    if (locala.MI == 1) {
      locala.dX();
    }
    locala.cancel();
    return true;
    if (locala.MI == 1) {
      locala.v(0.0F, 0.0F);
    }
    locala.cancel();
    return true;
    label940:
    a locala = this.wla;
    j = paramMotionEvent.getActionMasked();
    i = paramMotionEvent.getActionIndex();
    if (j == 0) {
      locala.cancel();
    }
    if (locala.fB == null) {
      locala.fB = VelocityTracker.obtain();
    }
    locala.fB.addMovement(paramMotionEvent);
    switch (j)
    {
    case 4: 
      label1036:
      if (locala.MI != 1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        y.i("changelcai", "shouldInterceptTouchEvent %s", new Object[] { paramMotionEvent });
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = paramMotionEvent.getPointerId(0);
        locala.a(f1, f2, i);
        localView = locala.y((int)f1, (int)f2);
        if ((localView == locala.MW) && (locala.MI == 2)) {
          locala.u(localView, i);
        }
        if ((locala.MN[i] & locala.MU) == 0) {
          break label1036;
        }
        break label1036;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if ((locala.MI == 0) || (locala.MI != 2)) {
          break label1036;
        }
        localView = locala.y((int)f1, (int)f2);
        if (localView != locala.MW) {
          break label1036;
        }
        locala.u(localView, j);
        break label1036;
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
          f3 = f1 - locala.MJ[k];
          locala.b(f3, f2 - locala.MK[k], k);
          if (locala.MI != 1)
          {
            localView = locala.y((int)f1, (int)f2);
            if ((localView == null) || (!locala.o(localView, f3)) || (!locala.u(localView, k))) {
              break label1453;
            }
          }
        }
        locala.e(paramMotionEvent);
        break label1036;
        locala.aN(paramMotionEvent.getPointerId(i));
        break label1036;
        locala.cancel();
        break label1036;
        super.dispatchTouchEvent(paramMotionEvent);
        return true;
        label1411:
        i = -1;
        break label876;
        return true;
        label1419:
        if (m != 0) {
          break;
        }
        if (n == 0) {
          break label613;
        }
        break;
        label1432:
        i += 1;
        break label647;
        label1441:
        i += 1;
        break label798;
        break label1036;
        label1453:
        i += 1;
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    if (paramView == this.QR) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((Float.compare(this.Kf, 0.0F) > 0) && (i != 0) && (this.wla.MI != 0))
      {
        Rect localRect = this.hc;
        paramView.getHitRect(localRect);
        this.wlc.setBounds(localRect.left - this.wlc.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.wlc.setAlpha((int)(this.Kf * 255.0F));
        this.wlc.draw(paramCanvas);
      }
      return bool;
    }
  }
  
  public View getTargetContentView()
  {
    return this.QR;
  }
  
  public final void init()
  {
    this.wla = a.a(this, new c((byte)0));
    this.wla.MU = 1;
    float f = getResources().getDisplayMetrics().density;
    this.wla.MS = (100.0F * f);
    this.wla.MR = (f * 300.0F);
    this.wkY = 0;
    this.wkZ = 0;
  }
  
  public final void nR(boolean paramBoolean)
  {
    y.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wlf = paramBoolean;
  }
  
  public void onFinishInflate()
  {
    this.QR = this;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mInLayout = true;
    if (this.QR != null) {
      this.QR.layout(this.wkY, this.wkZ, this.wkY + this.QR.getMeasuredWidth(), this.wkZ + this.QR.getMeasuredHeight());
    }
    this.mInLayout = false;
  }
  
  public void requestLayout()
  {
    if (!this.mInLayout) {
      super.requestLayout();
    }
  }
  
  public void setContentView(View paramView)
  {
    this.QR = paramView;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.wld = paramBoolean;
    if (this.wld) {
      this.wle = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    y.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wlk = paramBoolean;
  }
  
  public void setSwipeBackListener(b paramb)
  {
    this.wlj = paramb;
  }
  
  public void setSwipeGestureDelegate(a parama)
  {
    this.wll = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  public static abstract interface b
  {
    public abstract void aH(float paramFloat);
    
    public abstract boolean aK(boolean paramBoolean);
    
    public abstract void l(MotionEvent paramMotionEvent);
  }
  
  private final class c
    extends a.a
    implements b.a
  {
    int wlm = 0;
    int wln = 0;
    int wlo = 0;
    
    private c() {}
    
    public final boolean Ia(int paramInt)
    {
      a locala = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((locala.MQ & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((locala.MN[paramInt] & 0x1) != 0); i = 0) {
        return true;
      }
      return false;
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      boolean bool = false;
      int i = paramView.getWidth();
      this.wln = 0;
      this.wlo = 0;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.f(SwipeBackLayout.this) > SwipeBackLayout.i(SwipeBackLayout.this)))) {}
      for (i = i + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth() + 10;; i = 0)
      {
        this.wln = i;
        y.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.wln), Integer.valueOf(this.wlo), Boolean.valueOf(SwipeBackLayout.b(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.e(SwipeBackLayout.this) == null) {
          break;
        }
        paramView = SwipeBackLayout.e(SwipeBackLayout.this);
        if (this.wln != 0) {
          bool = true;
        }
        if (!paramView.aK(bool)) {
          break;
        }
        y.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased");
        return;
      }
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramView = SwipeBackLayout.a(SwipeBackLayout.this);
        i = this.wln;
        int j = this.wlo;
        if (!paramView.MX) {
          throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        paramView.h(i, j, (int)paramView.fB.getXVelocity(paramView.fC), (int)paramView.fB.getYVelocity(paramView.fC));
        SwipeBackLayout.this.invalidate();
        return;
      }
      SwipeBackLayout.c(SwipeBackLayout.this, true);
    }
    
    public final int cIF()
    {
      return 1;
    }
    
    public final int d(View paramView, int paramInt)
    {
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.wlm, paramInt);
        this.wlm = 0;
        return Math.min(paramView.getWidth(), Math.max(paramInt, 0));
      }
      this.wlm = Math.max(this.wlm, paramInt);
      return 0;
    }
    
    public final void fC(int paramInt1, int paramInt2)
    {
      if (!SwipeBackLayout.b(SwipeBackLayout.this)) {
        y.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false");
      }
      for (;;)
      {
        return;
        SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.c(SwipeBackLayout.this).getWidth() + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth())));
        SwipeBackLayout.a(SwipeBackLayout.this, paramInt1);
        SwipeBackLayout.b(SwipeBackLayout.this, paramInt2);
        SwipeBackLayout.this.invalidate();
        if (SwipeBackLayout.e(SwipeBackLayout.this) != null) {
          SwipeBackLayout.e(SwipeBackLayout.this).aH(SwipeBackLayout.f(SwipeBackLayout.this));
        }
        if ((Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 1.0F) >= 0) && (!SwipeBackLayout.g(SwipeBackLayout.this)))
        {
          SwipeBackLayout.a(SwipeBackLayout.this, true);
          ai.d(new Runnable()
          {
            public final void run()
            {
              if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
              {
                y.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                SwipeBackLayout.h(SwipeBackLayout.this).onSwipeBack();
              }
              SwipeBackLayout.b(SwipeBackLayout.this, false);
            }
          });
        }
        while (SwipeBackLayout.a(SwipeBackLayout.this).MI == 1)
        {
          g.aN(SwipeBackLayout.f(SwipeBackLayout.this));
          return;
          if (Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 0.01F) <= 0)
          {
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            y.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", new Object[] { Float.valueOf(SwipeBackLayout.f(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.g(SwipeBackLayout.this)) });
          }
        }
      }
    }
    
    public final void ld(final boolean paramBoolean)
    {
      ai.d(new Runnable()
      {
        public final void run()
        {
          y.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.c.this.wln) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.c.this.wln > 0)
            {
              g.aN(0.0F);
              SwipeBackLayout.this.nR(paramBoolean);
              if ((paramBoolean) && (SwipeBackLayout.k(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.c.this.wln != 0) {
                  break label174;
                }
                h.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, 0.0F, new h.a()
                {
                  public final void ceX()
                  {
                    onAnimationEnd();
                  }
                  
                  public final void onAnimationEnd()
                  {
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                  }
                });
              }
            }
          }
          for (;;)
          {
            SwipeBackLayout.c(SwipeBackLayout.this, false);
            return;
            g.aN(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label174:
            h.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, SwipeBackLayout.c.this.wln, new h.a()
            {
              public final void ceX()
              {
                onAnimationEnd();
              }
              
              public final void onAnimationEnd()
              {
                SwipeBackLayout.a(SwipeBackLayout.this, true);
                ai.d(new Runnable()
                {
                  public final void run()
                  {
                    if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
                    {
                      SwipeBackLayout.h(SwipeBackLayout.this).onSwipeBack();
                      y.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                    }
                    g.aN(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                  }
                });
              }
            });
            g.C(true, SwipeBackLayout.c.this.wln);
          }
        }
      });
    }
    
    public final void x(int paramInt)
    {
      y.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(SwipeBackLayout.j(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.k(SwipeBackLayout.this)) });
      if (1 == paramInt)
      {
        y.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
        if ((SwipeBackLayout.this.getContext() instanceof Activity)) {
          ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(a.d.transparent);
        }
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null) {
          SwipeBackLayout.h(SwipeBackLayout.this).onDrag();
        }
        SwipeBackLayout.a(SwipeBackLayout.this, false);
        if (SwipeBackLayout.b(SwipeBackLayout.this)) {
          g.aN(0.0F);
        }
      }
      if ((paramInt == 0) && (!SwipeBackLayout.k(SwipeBackLayout.this)))
      {
        y.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null) {
          SwipeBackLayout.h(SwipeBackLayout.this).onCancel();
        }
        g.aN(1.0F);
      }
      if ((1 == paramInt) && (SwipeBackLayout.l(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.b(SwipeBackLayout.this)) && (!SwipeBackLayout.j(SwipeBackLayout.this)))
      {
        y.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        b.a((Activity)SwipeBackLayout.this.getContext(), this);
      }
      if (2 == paramInt)
      {
        y.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.wln) });
        if (this.wln <= 0) {
          break label308;
        }
      }
      label308:
      for (boolean bool = true;; bool = false)
      {
        g.C(bool, this.wln);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */