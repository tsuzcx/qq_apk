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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;
import com.tencent.mm.ui.mogic.a;
import com.tencent.mm.ui.mogic.a.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.tools.j.a;

public class SwipeBackLayout
  extends FrameLayout
{
  private float AEP;
  private int AEQ;
  private int AER;
  public a AES;
  private float AET;
  public Drawable AEU;
  private boolean AEV;
  private boolean AEW;
  public boolean AEX;
  public boolean AEY;
  public boolean AEZ;
  private boolean AFa;
  private b AFb;
  private Drawable AFc;
  private boolean AFd;
  private boolean AFe;
  public a AFf;
  private float JL;
  public View Qz;
  private Rect hV;
  private boolean mEnable;
  private boolean mInLayout;
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107991);
    this.AEP = 0.3F;
    this.mEnable = true;
    this.hV = new Rect();
    this.AEV = true;
    this.AEW = false;
    this.AEX = false;
    this.AEY = false;
    this.AEZ = false;
    this.AFa = false;
    this.AFe = true;
    this.AFf = null;
    this.AEU = getResources().getDrawable(2130840252);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    AppMethodBeat.o(107991);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(108001);
    this.JL = Math.max(0.0F, 1.0F - this.AET);
    a locala = this.AES;
    if (locala.Mw == 2)
    {
      boolean bool2 = locala.jtz.jR.computeScrollOffset();
      i = locala.jtz.jR.getCurrX();
      int j = locala.jtz.jR.getCurrY();
      int k = i - locala.MM.getLeft();
      int m = j - locala.MM.getTop();
      if (k != 0) {
        locala.MM.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.MM.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.Apv.hL(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == locala.jtz.jR.getFinalX())
        {
          bool1 = bool2;
          if (j == locala.jtz.jR.getFinalY())
          {
            locala.jtz.jR.abortAnimation();
            bool1 = locala.jtz.jR.isFinished();
          }
        }
      }
      if (!bool1) {
        locala.MO.post(locala.MP);
      }
    }
    if (locala.Mw == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        t.R(this);
      }
      AppMethodBeat.o(108001);
      return;
    }
  }
  
  public final boolean dOU()
  {
    AppMethodBeat.i(107996);
    if (!this.AEZ)
    {
      AppMethodBeat.o(107996);
      return false;
    }
    if (Float.compare(this.Qz.getLeft(), 0.01F) <= 0)
    {
      this.AEZ = false;
      AppMethodBeat.o(107996);
      return false;
    }
    AppMethodBeat.o(107996);
    return true;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(107997);
    boolean bool;
    if (!this.mEnable)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(107997);
      return bool;
    }
    if (this.AFb != null) {
      this.AFb.l(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0) {
      this.AFd = false;
    }
    if (this.AFd)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(107997);
      return bool;
    }
    if (dOU())
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(107997);
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
        if (this.AES.Mw != 1) {
          break;
        }
        locala = this.AES;
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
        ab.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an NullPointerException", new Object[0]);
        AppMethodBeat.o(107997);
        return false;
        i = (int)f1;
        k = (int)f2;
        paramMotionEvent = locala.MM;
        if ((paramMotionEvent == null) || (i < paramMotionEvent.getLeft()) || (i >= paramMotionEvent.getRight()) || (k < paramMotionEvent.getTop()) || (k >= paramMotionEvent.getBottom())) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        locala.x(locala.MM, j);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        ab.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalArgumentException", new Object[0]);
        AppMethodBeat.o(107997);
        return false;
        i = 0;
        continue;
        if (locala.Mw != 1) {
          continue;
        }
        i = paramMotionEvent.findPointerIndex(locala.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        m = (int)(f1 - locala.Mz[locala.mActivePointerId]);
        n = (int)(f2 - locala.MA[locala.mActivePointerId]);
        k = locala.MM.getLeft() + m;
        j = locala.MM.getTop() + n;
        int i2 = locala.MM.getLeft();
        int i1 = locala.MM.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = locala.Apv.d(locala.MM, k);
        locala.MM.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1517;
        }
        locala.MM.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1517;
        locala.Apv.hL(i, j);
        locala.e(paramMotionEvent);
        continue;
      }
      catch (ArrayIndexOutOfBoundsException paramMotionEvent)
      {
        ab.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an ArrayIndexOutOfBoundsException", new Object[0]);
        AppMethodBeat.o(107997);
        return false;
        j = paramMotionEvent.getPointerCount();
        i = 0;
        if (i >= j) {
          continue;
        }
        k = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        f3 = f1 - locala.Mx[k];
        locala.b(f3, f2 - locala.My[k], k);
        if (locala.Mw == 1) {
          continue;
        }
        localView = locala.A((int)f1, (int)f2);
        if ((!locala.r(localView, f3)) || (!locala.x(localView, k))) {
          break label1530;
        }
        locala.e(paramMotionEvent);
        continue;
      }
      catch (IllegalStateException paramMotionEvent)
      {
        ab.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalStateException", new Object[0]);
        AppMethodBeat.o(107997);
        return false;
      }
      AppMethodBeat.o(107997);
      return true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i = paramMotionEvent.getPointerId(0);
      paramMotionEvent = locala.A((int)f1, (int)f2);
      locala.a(f1, f2, i);
      locala.x(paramMotionEvent, i);
      i = locala.MC[i];
      if ((locala.MK & i) != 0)
      {
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if (locala.Mw == 0)
        {
          locala.x(locala.A((int)f1, (int)f2), j);
        }
        else
        {
          j = paramMotionEvent.getPointerId(i);
          if ((locala.Mw == 1) && (j == locala.mActivePointerId))
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
            if ((locala.A((int)f1, (int)f2) != locala.MM) || (!locala.x(locala.MM, m))) {
              break label1539;
            }
            i = locala.mActivePointerId;
            label958:
            if (i == -1) {
              locala.er();
            }
          }
          locala.aJ(j);
          continue;
          if (locala.Mw == 1) {
            locala.er();
          }
          locala.cancel();
          continue;
          if (locala.Mw == 1) {
            locala.u(0.0F, 0.0F);
          }
          locala.cancel();
        }
      }
    }
    a locala = this.AES;
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
      if (locala.Mw != 1) {
        break;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        ab.i("changelcai", "shouldInterceptTouchEvent %s", new Object[] { paramMotionEvent });
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(107997);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = paramMotionEvent.getPointerId(0);
        locala.a(f1, f2, i);
        localView = locala.A((int)f1, (int)f2);
        if ((localView == locala.MM) && (locala.Mw == 2)) {
          locala.x(localView, i);
        }
        if ((locala.MC[i] & locala.MK) == 0) {
          break label1124;
        }
        break label1124;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if ((locala.Mw == 0) || (locala.Mw != 2)) {
          break label1124;
        }
        localView = locala.A((int)f1, (int)f2);
        if (localView != locala.MM) {
          break label1124;
        }
        locala.x(localView, j);
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
          f3 = f1 - locala.Mx[k];
          locala.b(f3, f2 - locala.My[k], k);
          if (locala.Mw != 1)
          {
            localView = locala.A((int)f1, (int)f2);
            if ((localView == null) || (!locala.r(localView, f3)) || (!locala.x(localView, k))) {
              break label1551;
            }
          }
        }
        locala.e(paramMotionEvent);
        break label1124;
        locala.aJ(paramMotionEvent.getPointerId(i));
        break label1124;
        locala.cancel();
        break label1124;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(107997);
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
  
  public final boolean doA()
  {
    AppMethodBeat.i(107994);
    dOU();
    boolean bool = this.AEZ;
    AppMethodBeat.o(107994);
    return bool;
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(108000);
    if (paramView == this.Qz) {}
    for (int i = 1;; i = 0)
    {
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((Float.compare(this.JL, 0.0F) > 0) && (i != 0) && (this.AES.Mw != 0))
      {
        Rect localRect = this.hV;
        paramView.getHitRect(localRect);
        this.AEU.setBounds(localRect.left - this.AEU.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.AEU.setAlpha((int)(this.JL * 255.0F));
        this.AEU.draw(paramCanvas);
      }
      AppMethodBeat.o(108000);
      return bool;
    }
  }
  
  public View getTargetContentView()
  {
    return this.Qz;
  }
  
  public final void init()
  {
    AppMethodBeat.i(107992);
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(getContext(), 2131034200);
    this.AES = a.a(this, new c((byte)0), localInterpolator);
    this.AES.MK = 1;
    float f = getResources().getDisplayMetrics().density;
    this.AES.MI = (100.0F * f);
    this.AES.MH = (f * 300.0F);
    this.AEQ = 0;
    this.AER = 0;
    AppMethodBeat.o(107992);
  }
  
  public void onFinishInflate()
  {
    this.Qz = this;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(107998);
    this.mInLayout = true;
    if (this.Qz != null) {
      this.Qz.layout(this.AEQ, this.AER, this.AEQ + this.Qz.getMeasuredWidth(), this.AER + this.Qz.getMeasuredHeight());
    }
    this.mInLayout = false;
    AppMethodBeat.o(107998);
  }
  
  public final void rB(boolean paramBoolean)
  {
    AppMethodBeat.i(107993);
    ab.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.AEX = paramBoolean;
    AppMethodBeat.o(107993);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(107999);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(107999);
  }
  
  public void setContentView(View paramView)
  {
    this.Qz = paramView;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setNeedChangeWindowBackground(boolean paramBoolean)
  {
    this.AFe = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.AEV = paramBoolean;
    if (this.AEV) {
      this.AEW = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(107995);
    ab.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.AFd = paramBoolean;
    AppMethodBeat.o(107995);
  }
  
  public void setSwipeBackListener(b paramb)
  {
    this.AFb = paramb;
  }
  
  public void setSwipeGestureDelegate(a parama)
  {
    this.AFf = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  public static abstract interface b
  {
    public abstract boolean aZ(boolean paramBoolean);
    
    public abstract void bk(float paramFloat);
    
    public abstract void l(MotionEvent paramMotionEvent);
  }
  
  final class c
    extends a.a
    implements b.a
  {
    int AFg = 0;
    int AFh = 0;
    int AFi = 0;
    
    private c() {}
    
    public final boolean QM(int paramInt)
    {
      AppMethodBeat.i(107985);
      a locala = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((locala.MG & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((locala.MC[paramInt] & 0x1) != 0); i = 0)
      {
        AppMethodBeat.o(107985);
        return true;
      }
      AppMethodBeat.o(107985);
      return false;
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      boolean bool = false;
      AppMethodBeat.i(107987);
      int i = paramView.getWidth();
      this.AFh = 0;
      this.AFi = 0;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.f(SwipeBackLayout.this) > SwipeBackLayout.k(SwipeBackLayout.this)))) {}
      for (i = i + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth() + 10;; i = 0)
      {
        this.AFh = i;
        ab.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.AFh), Integer.valueOf(this.AFi), Boolean.valueOf(SwipeBackLayout.b(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.e(SwipeBackLayout.this) == null) {
          break;
        }
        paramView = SwipeBackLayout.e(SwipeBackLayout.this);
        if (this.AFh != 0) {
          bool = true;
        }
        if (!paramView.aZ(bool)) {
          break;
        }
        ab.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased");
        AppMethodBeat.o(107987);
        return;
      }
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramView = SwipeBackLayout.a(SwipeBackLayout.this);
        i = this.AFh;
        int j = this.AFi;
        if (!paramView.MN)
        {
          paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
          AppMethodBeat.o(107987);
          throw paramView;
        }
        paramView.b(i, j, (int)paramView.mVelocityTracker.getXVelocity(paramView.mActivePointerId), (int)paramView.mVelocityTracker.getYVelocity(paramView.mActivePointerId), 0L);
        SwipeBackLayout.this.invalidate();
        AppMethodBeat.o(107987);
        return;
      }
      SwipeBackLayout.c(SwipeBackLayout.this, true);
      AppMethodBeat.o(107987);
    }
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(107988);
      if (SwipeBackLayout.b(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.AFg, paramInt);
        this.AFg = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        AppMethodBeat.o(107988);
        return paramInt;
      }
      this.AFg = Math.max(this.AFg, paramInt);
      AppMethodBeat.o(107988);
      return 0;
    }
    
    public final int dNq()
    {
      return 1;
    }
    
    public final void hL(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(107986);
      if (!SwipeBackLayout.b(SwipeBackLayout.this))
      {
        ab.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false");
        AppMethodBeat.o(107986);
        return;
      }
      SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.c(SwipeBackLayout.this).getWidth() + SwipeBackLayout.d(SwipeBackLayout.this).getIntrinsicWidth())));
      SwipeBackLayout.a(SwipeBackLayout.this, paramInt1);
      SwipeBackLayout.b(SwipeBackLayout.this, paramInt2);
      SwipeBackLayout.this.invalidate();
      if (SwipeBackLayout.e(SwipeBackLayout.this) != null) {
        SwipeBackLayout.e(SwipeBackLayout.this).bk(SwipeBackLayout.f(SwipeBackLayout.this));
      }
      if ((Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 1.0F) >= 0) && (!SwipeBackLayout.g(SwipeBackLayout.this)))
      {
        SwipeBackLayout.a(SwipeBackLayout.this, true);
        al.d(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107978);
            if (SwipeBackLayout.h(SwipeBackLayout.this) != null)
            {
              ab.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
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
            AppMethodBeat.o(107978);
          }
        });
      }
      for (;;)
      {
        if (SwipeBackLayout.a(SwipeBackLayout.this).Mw == 1) {
          h.by(SwipeBackLayout.f(SwipeBackLayout.this));
        }
        AppMethodBeat.o(107986);
        return;
        if (Float.compare(SwipeBackLayout.f(SwipeBackLayout.this), 0.01F) <= 0)
        {
          SwipeBackLayout.b(SwipeBackLayout.this, false);
          ab.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", new Object[] { Float.valueOf(SwipeBackLayout.f(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.g(SwipeBackLayout.this)) });
        }
      }
    }
    
    public final void iX(final boolean paramBoolean)
    {
      AppMethodBeat.i(107990);
      al.d(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107984);
          ab.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.c.this.AFh) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.c.this.AFh > 0)
            {
              h.by(0.0F);
              SwipeBackLayout.this.rB(paramBoolean);
              if ((paramBoolean) && (SwipeBackLayout.m(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.c.this.AFh != 0) {
                  break label184;
                }
                j.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, 0.0F, new j.a()
                {
                  public final void dfe()
                  {
                    AppMethodBeat.i(107980);
                    onAnimationEnd();
                    AppMethodBeat.o(107980);
                  }
                  
                  public final void onAnimationEnd()
                  {
                    AppMethodBeat.i(107979);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(107979);
                  }
                });
              }
            }
          }
          for (;;)
          {
            SwipeBackLayout.c(SwipeBackLayout.this, false);
            AppMethodBeat.o(107984);
            return;
            h.by(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label184:
            j.a(SwipeBackLayout.c(SwipeBackLayout.this), 200L, SwipeBackLayout.c.this.AFh, new j.a()
            {
              public final void dfe()
              {
                AppMethodBeat.i(107983);
                onAnimationEnd();
                AppMethodBeat.o(107983);
              }
              
              public final void onAnimationEnd()
              {
                AppMethodBeat.i(107982);
                SwipeBackLayout.a(SwipeBackLayout.this, true);
                al.d(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(107981);
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
                      ab.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                    }
                    h.by(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(107981);
                  }
                });
                AppMethodBeat.o(107982);
              }
            });
            h.K(true, SwipeBackLayout.c.this.AFh);
          }
        }
      });
      AppMethodBeat.o(107990);
    }
    
    public final void w(int paramInt)
    {
      AppMethodBeat.i(107989);
      ab.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(SwipeBackLayout.l(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.m(SwipeBackLayout.this)) });
      if (1 == paramInt)
      {
        ab.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
        if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.i(SwipeBackLayout.this) == null))
        {
          SwipeBackLayout.a(SwipeBackLayout.this, ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground());
          if (SwipeBackLayout.j(SwipeBackLayout.this)) {
            ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(2131690605);
          }
        }
        if (SwipeBackLayout.h(SwipeBackLayout.this) != null) {
          SwipeBackLayout.h(SwipeBackLayout.this).onDrag();
        }
        SwipeBackLayout.a(SwipeBackLayout.this, false);
        if (SwipeBackLayout.b(SwipeBackLayout.this)) {
          h.by(0.0F);
        }
      }
      if ((paramInt == 0) && (!SwipeBackLayout.m(SwipeBackLayout.this)))
      {
        ab.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
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
        h.by(1.0F);
      }
      if ((1 == paramInt) && (SwipeBackLayout.n(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.b(SwipeBackLayout.this)) && (!SwipeBackLayout.l(SwipeBackLayout.this)))
      {
        ab.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        b.a((Activity)SwipeBackLayout.this.getContext(), this);
      }
      if (2 == paramInt)
      {
        ab.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.AFh) });
        if (this.AFh <= 0) {
          break label434;
        }
      }
      label434:
      for (boolean bool = true;; bool = false)
      {
        h.K(bool, this.AFh);
        AppMethodBeat.o(107989);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.widget.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */