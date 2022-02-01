package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.mogic.a.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.tools.j.a;

public class SwipeBackLayout
  extends FrameLayout
{
  private float HBO;
  private int HBP;
  private int HBQ;
  public a HBR;
  private float HBS;
  public Drawable HBT;
  private boolean HBU;
  private boolean HBV;
  public boolean HBW;
  public boolean HBX;
  public boolean HBY;
  private boolean HBZ;
  private b HCa;
  private Drawable HCb;
  private boolean HCc;
  private boolean HCd;
  public a HCe;
  private float QL;
  private Rect Rm;
  public View mContentView;
  private boolean mEnable;
  private boolean mInLayout;
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143486);
    this.HBO = 0.3F;
    this.mEnable = true;
    this.Rm = new Rect();
    this.HBU = true;
    this.HBV = false;
    this.HBW = false;
    this.HBX = false;
    this.HBY = false;
    this.HBZ = false;
    this.HCd = true;
    this.HCe = null;
    this.HBT = getResources().getDrawable(2131233962);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    AppMethodBeat.o(143486);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(143496);
    this.QL = Math.max(0.0F, 1.0F - this.HBS);
    a locala = this.HBR;
    if (locala.Tz == 2)
    {
      boolean bool2 = locala.mjD.RH.computeScrollOffset();
      i = locala.mjD.RH.getCurrX();
      int j = locala.mjD.RH.getCurrY();
      int k = i - locala.TN.getLeft();
      int m = j - locala.TN.getTop();
      if (k != 0) {
        locala.TN.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.TN.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.HkJ.jy(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == locala.mjD.RH.getFinalX())
        {
          bool1 = bool2;
          if (j == locala.mjD.RH.getFinalY())
          {
            locala.mjD.RH.abortAnimation();
            bool1 = locala.mjD.RH.isFinished();
          }
        }
      }
      if (!bool1) {
        locala.TP.post(locala.TQ);
      }
    }
    if (locala.Tz == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        t.W(this);
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
    if (this.HCa != null) {
      this.HCa.m(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0) {
      this.HCc = false;
    }
    if (this.HCc)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143492);
      return bool;
    }
    if (ffa())
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
    label664:
    label705:
    float f3;
    View localView;
    for (;;)
    {
      try
      {
        if (this.HBR.Tz != 1) {
          break;
        }
        locala = this.HBR;
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
        ad.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an NullPointerException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
        i = (int)f1;
        k = (int)f2;
        paramMotionEvent = locala.TN;
        if ((paramMotionEvent == null) || (i < paramMotionEvent.getLeft()) || (i >= paramMotionEvent.getRight()) || (k < paramMotionEvent.getTop()) || (k >= paramMotionEvent.getBottom())) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        locala.z(locala.TN, j);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        ad.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalArgumentException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
        i = 0;
        continue;
        if (locala.Tz != 1) {
          continue;
        }
        i = paramMotionEvent.findPointerIndex(locala.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        m = (int)(f1 - locala.TC[locala.mActivePointerId]);
        n = (int)(f2 - locala.TD[locala.mActivePointerId]);
        k = locala.TN.getLeft() + m;
        j = locala.TN.getTop() + n;
        int i2 = locala.TN.getLeft();
        int i1 = locala.TN.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = locala.HkJ.e(locala.TN, k);
        locala.TN.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1517;
        }
        locala.TN.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1517;
        locala.HkJ.jy(i, j);
        locala.f(paramMotionEvent);
        continue;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        ad.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an ArrayIndexOutOfBoundsException", new Object[0]);
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
        f3 = f1 - locala.TA[k];
        locala.b(f3, f2 - locala.TB[k], k);
        if (locala.Tz == 1) {
          continue;
        }
        localView = locala.C((int)f1, (int)f2);
        if ((!locala.v(localView, f3)) || (!locala.z(localView, k))) {
          break label1530;
        }
        locala.f(paramMotionEvent);
        continue;
      }
      catch (IllegalStateException paramMotionEvent)
      {
        ad.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalStateException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
      }
      AppMethodBeat.o(143492);
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      paramMotionEvent = locala.C((int)f1, (int)f2);
      locala.a(f1, f2, i);
      locala.z(paramMotionEvent, i);
      i = locala.TE[i];
      if ((locala.TL & i) != 0)
      {
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if (locala.Tz == 0)
        {
          locala.z(locala.C((int)f1, (int)f2), j);
        }
        else
        {
          j = paramMotionEvent.getPointerId(i);
          if ((locala.Tz == 1) && (j == locala.mActivePointerId))
          {
            k = paramMotionEvent.getPointerCount();
            i = 0;
            label880:
            if (i >= k) {
              break label1511;
            }
            m = paramMotionEvent.getPointerId(i);
            if (m == locala.mActivePointerId) {
              break label1539;
            }
            f1 = paramMotionEvent.getX(i);
            f2 = paramMotionEvent.getY(i);
            if ((locala.C((int)f1, (int)f2) != locala.TN) || (!locala.z(locala.TN, m))) {
              break label1539;
            }
            i = locala.mActivePointerId;
            label958:
            if (i == -1) {
              locala.fJ();
            }
          }
          locala.bc(j);
          continue;
          if (locala.Tz == 1) {
            locala.fJ();
          }
          locala.cancel();
          continue;
          if (locala.Tz == 1) {
            locala.l(0.0F, 0.0F);
          }
          locala.cancel();
        }
      }
    }
    a locala = this.HBR;
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
      label1124:
      if (locala.Tz != 1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("changelcai", "shouldInterceptTouchEvent %s", new Object[] { paramMotionEvent });
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(143492);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = paramMotionEvent.getPointerId(0);
        locala.a(f1, f2, i);
        localView = locala.C((int)f1, (int)f2);
        if ((localView == locala.TN) && (locala.Tz == 2)) {
          locala.z(localView, i);
        }
        if ((locala.TE[i] & locala.TL) == 0) {
          break label1124;
        }
        break label1124;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if ((locala.Tz == 0) || (locala.Tz != 2)) {
          break label1124;
        }
        localView = locala.C((int)f1, (int)f2);
        if (localView != locala.TN) {
          break label1124;
        }
        locala.z(localView, j);
        break label1124;
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
          f3 = f1 - locala.TA[k];
          locala.b(f3, f2 - locala.TB[k], k);
          if (locala.Tz != 1)
          {
            localView = locala.C((int)f1, (int)f2);
            if ((localView == null) || (!locala.v(localView, f3)) || (!locala.z(localView, k))) {
              break label1551;
            }
          }
        }
        locala.f(paramMotionEvent);
        break label1124;
        locala.bc(paramMotionEvent.getPointerId(i));
        break label1124;
        locala.cancel();
        break label1124;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(143492);
        return true;
        label1511:
        i = -1;
        break label958;
        label1517:
        if (m != 0) {
          break;
        }
        if (n == 0) {
          break label664;
        }
        break;
        label1530:
        i += 1;
        break label705;
        label1539:
        i += 1;
        break label880;
        break label1124;
        label1551:
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
      if ((Float.compare(this.QL, 0.0F) > 0) && (i != 0) && (this.HBR.Tz != 0))
      {
        Rect localRect = this.Rm;
        paramView.getHitRect(localRect);
        this.HBT.setBounds(localRect.left - this.HBT.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.HBT.setAlpha((int)(this.QL * 255.0F));
        this.HBT.draw(paramCanvas);
      }
      AppMethodBeat.o(143495);
      return bool;
    }
  }
  
  public final boolean ezp()
  {
    AppMethodBeat.i(143489);
    ffa();
    boolean bool = this.HBY;
    AppMethodBeat.o(143489);
    return bool;
  }
  
  public final boolean ffa()
  {
    AppMethodBeat.i(143491);
    if (!this.HBY)
    {
      AppMethodBeat.o(143491);
      return false;
    }
    if (Float.compare(this.mContentView.getLeft(), 0.01F) <= 0)
    {
      this.HBY = false;
      AppMethodBeat.o(143491);
      return false;
    }
    AppMethodBeat.o(143491);
    return true;
  }
  
  public View getTargetContentView()
  {
    return this.mContentView;
  }
  
  public final void init()
  {
    AppMethodBeat.i(143487);
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(getContext(), 2130772074);
    this.HBR = a.a(this, new c((byte)0), localInterpolator);
    this.HBR.TL = 1;
    float f = getResources().getDisplayMetrics().density;
    this.HBR.TJ = (100.0F * f);
    this.HBR.TI = (f * 300.0F);
    this.HBP = 0;
    this.HBQ = 0;
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
      this.mContentView.layout(this.HBP, this.HBQ, this.HBP + this.mContentView.getMeasuredWidth(), this.HBQ + this.mContentView.getMeasuredHeight());
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
    this.HCd = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.HBU = paramBoolean;
    if (this.HBU) {
      this.HBV = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(143490);
    ad.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.HCc = paramBoolean;
    AppMethodBeat.o(143490);
  }
  
  public void setSwipeBackListener(b paramb)
  {
    this.HCa = paramb;
  }
  
  public void setSwipeGestureDelegate(a parama)
  {
    this.HCe = parama;
  }
  
  public final void wQ(boolean paramBoolean)
  {
    AppMethodBeat.i(143488);
    ad.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.HBW = paramBoolean;
    AppMethodBeat.o(143488);
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  public static abstract interface b
  {
    public abstract void aJ(float paramFloat);
    
    public abstract int bq(boolean paramBoolean);
    
    public abstract void m(MotionEvent paramMotionEvent);
  }
  
  final class c
    extends a.a
    implements b.a
  {
    int HCf = 0;
    int HCg = 0;
    int HCh = 0;
    
    private c() {}
    
    public final void M(int paramInt)
    {
      AppMethodBeat.i(143484);
      ad.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(SwipeBackLayout.l(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.m(SwipeBackLayout.this)) });
      if (1 == paramInt)
      {
        ad.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
        if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) == null))
        {
          SwipeBackLayout.a(SwipeBackLayout.this, ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground());
          if (SwipeBackLayout.j(SwipeBackLayout.this)) {
            ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(2131101053);
          }
        }
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null) {
          SwipeBackLayout.h(SwipeBackLayout.this).onDrag();
        }
        SwipeBackLayout.a(SwipeBackLayout.this, false);
        if (SwipeBackLayout.b(SwipeBackLayout.this)) {
          h.bK(0.0F);
        }
      }
      if ((paramInt == 0) && (!SwipeBackLayout.m(SwipeBackLayout.this)))
      {
        ad.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
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
        h.bK(1.0F);
      }
      if ((1 == paramInt) && (SwipeBackLayout.n(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.b(SwipeBackLayout.this)) && (!SwipeBackLayout.l(SwipeBackLayout.this)))
      {
        ad.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        b.a((Activity)SwipeBackLayout.this.getContext(), this);
      }
      if (2 == paramInt)
      {
        ad.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.HCg) });
        if (this.HCg <= 0) {
          break label429;
        }
      }
      label429:
      for (boolean bool = true;; bool = false)
      {
        h.V(bool, this.HCg);
        AppMethodBeat.o(143484);
        return;
      }
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(143482);
      int i = paramView.getWidth();
      this.HCg = 0;
      this.HCh = 0;
      boolean bool;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.f(SwipeBackLayout.this) > SwipeBackLayout.k(SwipeBackLayout.this))))
      {
        i = i + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth() + 10;
        this.HCg = i;
        ad.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.HCg), Integer.valueOf(this.HCh), Boolean.valueOf(SwipeBackLayout.b(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.e(SwipeBackLayout.this) != null)
        {
          paramView = SwipeBackLayout.e(SwipeBackLayout.this);
          if (this.HCg == 0) {
            break label270;
          }
          bool = true;
          label170:
          i = paramView.bq(bool);
          ad.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", new Object[] { Integer.valueOf(i) });
          if (i != 2) {
            break label276;
          }
          this.HCg = 0;
        }
      }
      for (;;)
      {
        if (SwipeBackLayout.b(SwipeBackLayout.this))
        {
          paramView = SwipeBackLayout.a(SwipeBackLayout.this);
          i = this.HCg;
          int j = this.HCh;
          if (!paramView.TO)
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
    
    public final boolean aaf(int paramInt)
    {
      AppMethodBeat.i(143480);
      a locala = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((locala.TH & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((locala.TE[paramInt] & 0x1) != 0); i = 0)
      {
        AppMethodBeat.o(143480);
        return true;
      }
      AppMethodBeat.o(143480);
      return false;
    }
    
    public final int e(View paramView, int paramInt)
    {
      AppMethodBeat.i(143483);
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.HCf, paramInt);
        this.HCf = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        AppMethodBeat.o(143483);
        return paramInt;
      }
      this.HCf = Math.max(this.HCf, paramInt);
      AppMethodBeat.o(143483);
      return 0;
    }
    
    public final int fdh()
    {
      return 1;
    }
    
    public final void ib(final boolean paramBoolean)
    {
      AppMethodBeat.i(143485);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143479);
          ad.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.c.this.HCg) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.c.this.HCg > 0)
            {
              h.bK(0.0F);
              SwipeBackLayout.this.wQ(paramBoolean);
              if ((paramBoolean) && (SwipeBackLayout.m(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.c.this.HCg != 0) {
                  break label184;
                }
                j.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, 0.0F, new j.a()
                {
                  public final void aWf()
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
            h.bK(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label184:
            j.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, SwipeBackLayout.c.this.HCg, new j.a()
            {
              public final void aWf()
              {
                AppMethodBeat.i(143478);
                onAnimationEnd();
                AppMethodBeat.o(143478);
              }
              
              public final void onAnimationEnd()
              {
                AppMethodBeat.i(143477);
                SwipeBackLayout.a(SwipeBackLayout.this, true);
                aq.f(new Runnable()
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
                      ad.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                    }
                    h.bK(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(143476);
                  }
                });
                AppMethodBeat.o(143477);
              }
            });
            h.V(true, SwipeBackLayout.c.this.HCg);
          }
        }
      });
      AppMethodBeat.o(143485);
    }
    
    public final void jy(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(143481);
      if (!SwipeBackLayout.b(SwipeBackLayout.this))
      {
        ad.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false");
        AppMethodBeat.o(143481);
        return;
      }
      SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.c(SwipeBackLayout.this).getWidth() + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth())));
      SwipeBackLayout.a(SwipeBackLayout.this, paramInt1);
      SwipeBackLayout.b(SwipeBackLayout.this, paramInt2);
      SwipeBackLayout.this.invalidate();
      if (SwipeBackLayout.e(SwipeBackLayout.this) != null) {
        SwipeBackLayout.e(SwipeBackLayout.this).aJ(SwipeBackLayout.f(SwipeBackLayout.this));
      }
      if ((Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 1.0F) >= 0) && (!SwipeBackLayout.g(SwipeBackLayout.this)))
      {
        SwipeBackLayout.a(SwipeBackLayout.this, true);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143473);
            if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
            {
              ad.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
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
        if (SwipeBackLayout.a(SwipeBackLayout.this).Tz == 1) {
          h.bK(SwipeBackLayout.f(SwipeBackLayout.this));
        }
        AppMethodBeat.o(143481);
        return;
        if (Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 0.01F) <= 0)
        {
          SwipeBackLayout.b(SwipeBackLayout.this, false);
          ad.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", new Object[] { Float.valueOf(SwipeBackLayout.f(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.g(SwipeBackLayout.this)) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */