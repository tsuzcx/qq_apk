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
import androidx.core.g.z;
import androidx.core.widget.i;
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
  public a afVp;
  private a afVq;
  private boolean afVr;
  public b afVs;
  private float bxY;
  private Rect byy;
  public View mContentView;
  private boolean mEnable;
  private boolean mInLayout;
  private c mSwipeBackListener;
  private boolean mqA;
  private Drawable mqC;
  private boolean mqE;
  private float mqp;
  private int mqq;
  private int mqr;
  private float mqt;
  public Drawable mqu;
  private boolean mqv;
  private boolean mqw;
  public boolean mqx;
  public boolean mqy;
  public boolean mqz;
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(143486);
    this.mqp = 0.3F;
    this.mEnable = true;
    this.byy = new Rect();
    this.mqv = true;
    this.mqw = false;
    this.mqx = false;
    this.mqy = false;
    this.mqz = false;
    this.mqA = false;
    this.mqE = true;
    this.afVs = null;
    this.mqu = getResources().getDrawable(a.f.shadow_left);
    setFocusable(true);
    setDescendantFocusability(262144);
    init();
    AppMethodBeat.o(143486);
  }
  
  public final void Nl(boolean paramBoolean)
  {
    AppMethodBeat.i(143488);
    Log.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mqx = paramBoolean;
    AppMethodBeat.o(143488);
  }
  
  public final boolean aXg()
  {
    AppMethodBeat.i(143491);
    if (!this.mqz)
    {
      AppMethodBeat.o(143491);
      return false;
    }
    if (Float.compare(this.mContentView.getLeft(), 1.0E-005F) <= 0)
    {
      this.mqz = false;
      AppMethodBeat.o(143491);
      return false;
    }
    AppMethodBeat.o(143491);
    return true;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(143496);
    this.bxY = Math.max(0.0F, 1.0F - this.mqt);
    a locala = this.afVp;
    if (locala.bxy == 2)
    {
      boolean bool2 = locala.mri.bwz.computeScrollOffset();
      i = locala.mri.bwz.getCurrX();
      int j = locala.mri.bwz.getCurrY();
      int k = i - locala.bxM.getLeft();
      int m = j - locala.bxM.getTop();
      if (k != 0) {
        locala.bxM.offsetLeftAndRight(k);
      }
      if (m != 0) {
        locala.bxM.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        locala.afAl.dS(i, j);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i == locala.mri.bwz.getFinalX())
        {
          bool1 = bool2;
          if (j == locala.mri.bwz.getFinalY())
          {
            locala.mri.bwz.abortAnimation();
            bool1 = locala.mri.bwz.isFinished();
          }
        }
      }
      if (!bool1) {
        locala.bxO.post(locala.bxP);
      }
    }
    if (locala.bxy == 2) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        z.Q(this);
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
    if ((this.mSwipeBackListener != null) && (this.mSwipeBackListener.gjA())) {
      if (this.mSwipeBackListener.gjD())
      {
        if (this.mSwipeBackListener.gjz() == 1)
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
      this.afVr = false;
    }
    if (this.afVr)
    {
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(143492);
      return bool;
    }
    if (aXg())
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
        if (this.afVp.bxy != 1) {
          break;
        }
        locala = this.afVp;
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
        paramMotionEvent = locala.bxM;
        if ((paramMotionEvent == null) || (i < paramMotionEvent.getLeft()) || (i >= paramMotionEvent.getRight()) || (k < paramMotionEvent.getTop()) || (k >= paramMotionEvent.getBottom())) {
          continue;
        }
        i = 1;
        if (i == 0) {
          continue;
        }
        locala.C(locala.bxM, j);
        continue;
      }
      catch (IllegalArgumentException paramMotionEvent)
      {
        Log.printErrStackTrace("MicroMsg.SwipeBackLayout", paramMotionEvent, "got an IllegalArgumentException", new Object[0]);
        AppMethodBeat.o(143492);
        return false;
        i = 0;
        continue;
        if (locala.bxy != 1) {
          continue;
        }
        i = paramMotionEvent.findPointerIndex(locala.mActivePointerId);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        m = (int)(f1 - locala.bxB[locala.mActivePointerId]);
        n = (int)(f2 - locala.bxC[locala.mActivePointerId]);
        k = locala.bxM.getLeft() + m;
        j = locala.bxM.getTop() + n;
        int i2 = locala.bxM.getLeft();
        int i1 = locala.bxM.getTop();
        i = k;
        if (m == 0) {
          continue;
        }
        i = locala.afAl.d(locala.bxM, k);
        locala.bxM.offsetLeftAndRight(i - i2);
        if (n == 0) {
          break label1609;
        }
        locala.bxM.offsetTopAndBottom(0 - i1);
        j = 0;
        break label1609;
        locala.afAl.dS(i, j);
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
        f3 = f1 - locala.bxz[k];
        locala.b(f3, f2 - locala.bxA[k], k);
        if (locala.bxy == 1) {
          continue;
        }
        localView = locala.aF((int)f1, (int)f2);
        if ((!locala.s(localView, f3)) || (!locala.C(localView, k))) {
          break label1622;
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
      paramMotionEvent = locala.aF((int)f1, (int)f2);
      locala.a(f1, f2, i);
      locala.C(paramMotionEvent, i);
      i = locala.bxD[i];
      if ((locala.bxK & i) != 0)
      {
        continue;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if (locala.bxy == 0)
        {
          locala.C(locala.aF((int)f1, (int)f2), j);
        }
        else
        {
          j = paramMotionEvent.getPointerId(i);
          if ((locala.bxy == 1) && (j == locala.mActivePointerId))
          {
            k = paramMotionEvent.getPointerCount();
            i = 0;
            label964:
            if (i >= k) {
              break label1603;
            }
            m = paramMotionEvent.getPointerId(i);
            if (m == locala.mActivePointerId) {
              break label1631;
            }
            f1 = paramMotionEvent.getX(i);
            f2 = paramMotionEvent.getY(i);
            if ((locala.aF((int)f1, (int)f2) != locala.bxM) || (!locala.C(locala.bxM, m))) {
              break label1631;
            }
            i = locala.mActivePointerId;
            label1042:
            if (i == -1) {
              locala.Fy();
            }
          }
          locala.eK(j);
          continue;
          if (locala.bxy == 1) {
            locala.Fy();
          }
          locala.cancel();
          continue;
          if (locala.bxy == 1) {
            locala.N(0.0F, 0.0F);
          }
          locala.cancel();
        }
      }
    }
    a locala = this.afVp;
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
      if (locala.bxy != 1) {
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
        localView = locala.aF((int)f1, (int)f2);
        if ((localView == locala.bxM) && (locala.bxy == 2)) {
          locala.C(localView, i);
        }
        if ((locala.bxD[i] & locala.bxK) == 0) {
          break label1208;
        }
        break label1208;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        locala.a(f1, f2, j);
        if ((locala.bxy == 0) || (locala.bxy != 2)) {
          break label1208;
        }
        localView = locala.aF((int)f1, (int)f2);
        if (localView != locala.bxM) {
          break label1208;
        }
        locala.C(localView, j);
        break label1208;
        if (locala.bxz == null) {
          break label1208;
        }
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
          f3 = f1 - locala.bxz[k];
          locala.b(f3, f2 - locala.bxA[k], k);
          if (locala.bxy != 1)
          {
            localView = locala.aF((int)f1, (int)f2);
            if ((localView == null) || (!locala.s(localView, f3)) || (!locala.C(localView, k))) {
              break label1643;
            }
          }
        }
        locala.h(paramMotionEvent);
        break label1208;
        locala.eK(paramMotionEvent.getPointerId(i));
        break label1208;
        locala.cancel();
        break label1208;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(143492);
        return true;
        label1603:
        i = -1;
        break label1042;
        label1609:
        if (m != 0) {
          break;
        }
        if (n == 0) {
          break label750;
        }
        break;
        label1622:
        i += 1;
        break label790;
        label1631:
        i += 1;
        break label964;
        break label1208;
        label1643:
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
      if ((Float.compare(this.bxY, 0.0F) > 0) && (i != 0) && (this.afVp.bxy != 0))
      {
        Rect localRect = this.byy;
        paramView.getHitRect(localRect);
        this.mqu.setBounds(localRect.left - this.mqu.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
        this.mqu.setAlpha((int)(this.bxY * 255.0F));
        this.mqu.draw(paramCanvas);
      }
      AppMethodBeat.o(143495);
      return bool;
    }
  }
  
  public View getTargetContentView()
  {
    return this.mContentView;
  }
  
  public final boolean iMy()
  {
    AppMethodBeat.i(143489);
    aXg();
    boolean bool = this.mqz;
    AppMethodBeat.o(143489);
    return bool;
  }
  
  public final void init()
  {
    AppMethodBeat.i(143487);
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(getContext(), com.tencent.mm.ah.a.a.mm_decelerate_interpolator);
    this.afVp = a.a(this, new d((byte)0), localInterpolator);
    this.afVp.bxK = 1;
    float f = getResources().getDisplayMetrics().density;
    this.afVp.bxI = (100.0F * f);
    this.afVp.bxH = (f * 300.0F);
    this.mqq = 0;
    this.mqr = 0;
    AppMethodBeat.o(143487);
  }
  
  public final void jFd()
  {
    AppMethodBeat.i(252096);
    this.afVp.b(this.mContentView, 0, 10L);
    AppMethodBeat.o(252096);
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
      this.mContentView.layout(this.mqq, this.mqr, this.mqq + this.mContentView.getMeasuredWidth(), this.mqr + this.mContentView.getMeasuredHeight());
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
  
  public void setDragListener(a parama)
  {
    this.afVq = parama;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setNeedChangeWindowBackground(boolean paramBoolean)
  {
    this.mqE = paramBoolean;
  }
  
  public void setNeedRequestActivityTranslucent(boolean paramBoolean)
  {
    this.mqv = paramBoolean;
    if (this.mqv) {
      this.mqw = false;
    }
  }
  
  public void setOnceDisEnableGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(143490);
    Log.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.afVr = paramBoolean;
    AppMethodBeat.o(143490);
  }
  
  public void setSwipeBackListener(c paramc)
  {
    this.mSwipeBackListener = paramc;
  }
  
  public void setSwipeGestureDelegate(b paramb)
  {
    this.afVs = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void TJ(int paramInt);
    
    public abstract void fck();
  }
  
  public static abstract interface b
  {
    public abstract void onCancel();
    
    public abstract void onDrag();
    
    public abstract void onSwipeBack();
  }
  
  public static abstract interface c
  {
    public abstract void aG(int paramInt1, int paramInt2);
    
    public abstract void cD(float paramFloat);
    
    public abstract int cI(boolean paramBoolean);
    
    public abstract boolean gjA();
    
    public abstract boolean gjD();
    
    public abstract int gjz();
    
    public abstract boolean i(MotionEvent paramMotionEvent);
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
  
  final class d
    extends com.tencent.mm.ui.mogic.a.a
    implements b.b
  {
    int afVt = 0;
    int mqG = 0;
    int mqH = 0;
    int mqI = 0;
    
    private d() {}
    
    public final void F(int paramInt)
    {
      AppMethodBeat.i(143484);
      Log.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(SwipeBackLayout.m(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.n(SwipeBackLayout.this)) });
      this.afVt = paramInt;
      if (1 == paramInt)
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
        if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.j(SwipeBackLayout.this) == null))
        {
          SwipeBackLayout.a(SwipeBackLayout.this, ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground());
          if (SwipeBackLayout.k(SwipeBackLayout.this)) {
            ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(a.d.transparent);
          }
        }
        if (SwipeBackLayout.i(SwipeBackLayout.this) != null) {
          SwipeBackLayout.i(SwipeBackLayout.this).onDrag();
        }
        SwipeBackLayout.a(SwipeBackLayout.this, false);
        if (SwipeBackLayout.d(SwipeBackLayout.this)) {
          l.bk(0.0F);
        }
      }
      if ((paramInt == 0) && (!SwipeBackLayout.n(SwipeBackLayout.this)))
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
        if (SwipeBackLayout.i(SwipeBackLayout.this) != null)
        {
          if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.j(SwipeBackLayout.this) != null))
          {
            if (SwipeBackLayout.k(SwipeBackLayout.this)) {
              ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.j(SwipeBackLayout.this));
            }
            SwipeBackLayout.a(SwipeBackLayout.this, null);
          }
          SwipeBackLayout.i(SwipeBackLayout.this).onCancel();
        }
        l.bk(1.0F);
      }
      if ((1 == paramInt) && (SwipeBackLayout.o(SwipeBackLayout.this)) && ((SwipeBackLayout.this.getContext() instanceof Activity)) && (!SwipeBackLayout.d(SwipeBackLayout.this)) && (!SwipeBackLayout.m(SwipeBackLayout.this)))
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
        SwipeBackLayout.d(SwipeBackLayout.this, true);
        b.a((Activity)SwipeBackLayout.this.getContext(), this);
      }
      if (2 == paramInt)
      {
        Log.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", new Object[] { Integer.valueOf(this.mqH) });
        if (this.mqH <= 0) {
          break label435;
        }
      }
      label435:
      for (boolean bool = true;; bool = false)
      {
        l.g(bool, this.mqH);
        AppMethodBeat.o(143484);
        return;
      }
    }
    
    public final void aG(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(251670);
      if (SwipeBackLayout.b(SwipeBackLayout.this) != null) {
        SwipeBackLayout.b(SwipeBackLayout.this).aG(paramInt1, paramInt2);
      }
      if (SwipeBackLayout.c(SwipeBackLayout.this) != null) {
        SwipeBackLayout.c(SwipeBackLayout.this).TJ(paramInt1);
      }
      AppMethodBeat.o(251670);
    }
    
    public final int aXi()
    {
      return 1;
    }
    
    public final void b(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(143482);
      int i = paramView.getWidth();
      this.mqH = 0;
      this.mqI = 0;
      boolean bool;
      if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.g(SwipeBackLayout.this) > SwipeBackLayout.l(SwipeBackLayout.this))))
      {
        i = i + SwipeBackLayout.f(SwipeBackLayout.this).getIntrinsicWidth() + 10;
        this.mqH = i;
        Log.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(this.mqH), Integer.valueOf(this.mqI), Boolean.valueOf(SwipeBackLayout.d(SwipeBackLayout.this)) });
        SwipeBackLayout.b(SwipeBackLayout.this, true);
        if (SwipeBackLayout.b(SwipeBackLayout.this) != null)
        {
          paramView = SwipeBackLayout.b(SwipeBackLayout.this);
          if (this.mqH == 0) {
            break label270;
          }
          bool = true;
          label170:
          i = paramView.cI(bool);
          Log.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased, result:%s", new Object[] { Integer.valueOf(i) });
          if (i != 2) {
            break label276;
          }
          this.mqH = 0;
        }
      }
      for (;;)
      {
        if (SwipeBackLayout.d(SwipeBackLayout.this))
        {
          paramView = SwipeBackLayout.a(SwipeBackLayout.this);
          i = this.mqH;
          int j = this.mqI;
          if (!paramView.bxN)
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
    
    public final int d(View paramView, int paramInt)
    {
      AppMethodBeat.i(143483);
      if (SwipeBackLayout.d(SwipeBackLayout.this))
      {
        paramInt = Math.max(this.mqG, paramInt);
        this.mqG = 0;
        paramInt = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
        AppMethodBeat.o(143483);
        return paramInt;
      }
      this.mqG = Math.max(this.mqG, paramInt);
      AppMethodBeat.o(143483);
      return 0;
    }
    
    public final void dS(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(143481);
      if (!SwipeBackLayout.d(SwipeBackLayout.this))
      {
        Log.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false");
        AppMethodBeat.o(143481);
        return;
      }
      SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.e(SwipeBackLayout.this).getWidth() + SwipeBackLayout.f(SwipeBackLayout.this).getIntrinsicWidth())));
      SwipeBackLayout.a(SwipeBackLayout.this, paramInt1);
      SwipeBackLayout.b(SwipeBackLayout.this, paramInt2);
      SwipeBackLayout.this.invalidate();
      if (SwipeBackLayout.b(SwipeBackLayout.this) != null) {
        SwipeBackLayout.b(SwipeBackLayout.this).cD(SwipeBackLayout.g(SwipeBackLayout.this));
      }
      if ((Float.compare(SwipeBackLayout.g(SwipeBackLayout.this), 1.0F) >= 0) && (!SwipeBackLayout.h(SwipeBackLayout.this)))
      {
        SwipeBackLayout.a(SwipeBackLayout.this, true);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(143473);
            if (SwipeBackLayout.i(SwipeBackLayout.this) != null)
            {
              Log.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
              if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.j(SwipeBackLayout.this) != null))
              {
                if (SwipeBackLayout.k(SwipeBackLayout.this)) {
                  ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.j(SwipeBackLayout.this));
                }
                SwipeBackLayout.a(SwipeBackLayout.this, null);
              }
              SwipeBackLayout.i(SwipeBackLayout.this).onSwipeBack();
            }
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            AppMethodBeat.o(143473);
          }
        });
      }
      for (;;)
      {
        if (SwipeBackLayout.a(SwipeBackLayout.this).bxy == 1) {
          l.bk(SwipeBackLayout.g(SwipeBackLayout.this));
        }
        AppMethodBeat.o(143481);
        return;
        if (Float.compare(SwipeBackLayout.g(SwipeBackLayout.this), 1.0E-005F) <= 0)
        {
          SwipeBackLayout.b(SwipeBackLayout.this, false);
          if ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (this.afVt != 1)) {
            SwipeBackLayout.c(SwipeBackLayout.this).fck();
          }
          Log.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s currentDragState:%s", new Object[] { Float.valueOf(SwipeBackLayout.g(SwipeBackLayout.this)), Boolean.valueOf(SwipeBackLayout.h(SwipeBackLayout.this)), Integer.valueOf(this.afVt) });
        }
      }
    }
    
    public final void onComplete(final boolean paramBoolean)
    {
      AppMethodBeat.i(143485);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(143479);
          Log.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(SwipeBackLayout.d.this.mqH) });
          SwipeBackLayout.d(SwipeBackLayout.this, paramBoolean);
          if (paramBoolean) {
            if (SwipeBackLayout.d.this.mqH > 0)
            {
              l.bk(0.0F);
              SwipeBackLayout.this.Nl(paramBoolean);
              if ((paramBoolean) && (SwipeBackLayout.n(SwipeBackLayout.this)))
              {
                if (SwipeBackLayout.d.this.mqH != 0) {
                  break label184;
                }
                k.a(SwipeBackLayout.e(SwipeBackLayout.this), 200L, 0.0F, new k.a()
                {
                  public final void aXe()
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
            l.bk(1.0F);
            break;
            SwipeBackLayout.b(SwipeBackLayout.this, false);
            break;
            label184:
            k.a(SwipeBackLayout.e(SwipeBackLayout.this), 200L, SwipeBackLayout.d.this.mqH, new k.a()
            {
              public final void aXe()
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
                    if (SwipeBackLayout.i(SwipeBackLayout.this) != null)
                    {
                      if (((SwipeBackLayout.this.getContext() instanceof Activity)) && (SwipeBackLayout.j(SwipeBackLayout.this) != null))
                      {
                        if (SwipeBackLayout.k(SwipeBackLayout.this)) {
                          ((Activity)SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.j(SwipeBackLayout.this));
                        }
                        SwipeBackLayout.a(SwipeBackLayout.this, null);
                      }
                      SwipeBackLayout.i(SwipeBackLayout.this).onSwipeBack();
                      Log.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                    }
                    l.bk(1.0F);
                    SwipeBackLayout.b(SwipeBackLayout.this, false);
                    AppMethodBeat.o(143476);
                  }
                });
                AppMethodBeat.o(143477);
              }
            });
            l.g(true, SwipeBackLayout.d.this.mqH);
          }
        }
      });
      AppMethodBeat.o(143485);
    }
    
    public final boolean rT(int paramInt)
    {
      AppMethodBeat.i(143480);
      a locala = SwipeBackLayout.a(SwipeBackLayout.this);
      if ((locala.bxG & 1 << paramInt) != 0) {}
      for (int i = 1; (i != 0) && ((locala.bxD[paramInt] & 0x1) != 0); i = 0)
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