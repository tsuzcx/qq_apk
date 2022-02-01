package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class MMFlipper
  extends ViewGroup
{
  private int HvK;
  protected int HvM;
  protected int HvN;
  private boolean HvP;
  private c HwA;
  private MMFlipper.a HwB;
  private b HwC;
  private Interpolator HwD;
  int HwE;
  int HwF;
  protected int Hwx;
  private int Hwy;
  private boolean Hwz;
  private float mLastMotionX;
  private float mLastMotionY;
  private Scroller mScroller;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  
  public MMFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(141897);
    init(paramContext);
    AppMethodBeat.o(141897);
  }
  
  public MMFlipper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141898);
    this.Hwy = 0;
    this.HvK = 0;
    this.Hwz = false;
    this.HvP = true;
    this.HwE = -123454321;
    this.HwF = -123454321;
    init(paramContext);
    AppMethodBeat.o(141898);
  }
  
  private void ZT(int paramInt)
  {
    AppMethodBeat.i(141903);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int i = getWidth() * paramInt - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, i, 0, a.ax(getContext(), (int)(Math.abs(i) * 1.3F)));
      if (this.HvM != paramInt)
      {
        this.Hwz = true;
        this.Hwx += paramInt - this.HvM;
      }
      this.HvN = this.HvM;
      this.HvM = paramInt;
      invalidate();
    }
    AppMethodBeat.o(141903);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(141900);
    this.HwD = getInterpolator();
    this.mScroller = new Scroller(paramContext, this.HwD);
    this.HvN = -1;
    int i = this.Hwy;
    this.HvM = i;
    this.Hwx = i;
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(141900);
  }
  
  public final void ZW(int paramInt)
  {
    AppMethodBeat.i(141904);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.Hwz = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    this.HvN = this.HvM;
    this.HvM = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141904);
  }
  
  public final void ZX(int paramInt)
  {
    this.Hwx = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(141907);
    this.mScroller.getCurrX();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
      AppMethodBeat.o(141907);
      return;
    }
    if (this.Hwz)
    {
      this.Hwz = false;
      if (this.HwA != null)
      {
        this.HwA.u(this.HvN, this.Hwx, true);
        AppMethodBeat.o(141907);
      }
    }
    else if ((this.HwB != null) && (this.mLastMotionX == 0.0F) && (this.HvN != this.HvM))
    {
      this.HwB.Xh(this.Hwx);
    }
    AppMethodBeat.o(141907);
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(141906);
    ac.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[] { Integer.valueOf(this.HvM) });
    int i = this.HvM;
    AppMethodBeat.o(141906);
    return i;
  }
  
  protected Interpolator getInterpolator()
  {
    AppMethodBeat.i(141899);
    MMFlipper.d locald = new MMFlipper.d();
    AppMethodBeat.o(141899);
    return locald;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141909);
    boolean bool;
    if (!this.HvP)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141909);
      return bool;
    }
    if (getChildCount() == 1)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141909);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.HvK != 0))
    {
      AppMethodBeat.o(141909);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.HvK != 0)
    {
      AppMethodBeat.o(141909);
      return true;
      i = (int)Math.abs(this.mLastMotionX - f1);
      int j = (int)Math.abs(this.mLastMotionY - f2);
      ac.v("MicroMsg.MMFlipper", "xDif = " + i + ", yDif = " + j);
      if ((i > this.mTouchSlop) && (j < this.mTouchSlop)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label230;
        }
        this.HvK = 1;
        break;
      }
      label230:
      this.HvK = 0;
      continue;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.HvK = i;
        break;
      }
      this.HvK = 0;
    }
    AppMethodBeat.o(141909);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141901);
    long l = bs.Gn();
    int j = 0;
    int m = getChildCount();
    int i = 0;
    while (i < m)
    {
      View localView = getChildAt(i);
      int k = j;
      if (localView.getVisibility() != 8)
      {
        k = localView.getMeasuredWidth();
        ac.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:".concat(String.valueOf(k)));
        localView.layout(j, 0, j + k, localView.getMeasuredHeight());
        k = j + k;
      }
      i += 1;
      j = k;
    }
    ac.v("MicroMsg.MMFlipper", "use " + bs.aO(l) + " ms, flipper onLayout changed:" + paramBoolean + " Left,Top,Right,Bottom:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    AppMethodBeat.o(141901);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141902);
    long l = bs.Gn();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.HwC != null) {
      this.HwC.gZ(j, i);
    }
    this.HwE = j;
    this.HwF = i;
    int k = getChildCount();
    i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    scrollTo(this.HvM * j, 0);
    ac.i("MicroMsg.MMFlipper", "flipper onMeasure:" + j + "," + View.MeasureSpec.getSize(paramInt2) + " childCount:" + k + ", use " + bs.aO(l));
    AppMethodBeat.o(141902);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141908);
    if (getChildCount() == 1)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141908);
      return bool;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    paramMotionEvent.getY();
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(141908);
        return true;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.mLastMotionX = f;
        continue;
        i = (int)(this.mLastMotionX - f);
        this.mLastMotionX = f;
        scrollBy(i, 0);
      }
    }
    paramMotionEvent = this.mVelocityTracker;
    paramMotionEvent.computeCurrentVelocity(1000);
    i = (int)paramMotionEvent.getXVelocity();
    if ((i > 600) && (this.HvM > 0)) {
      ZT(this.HvM - 1);
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.HvK = 0;
      this.mLastMotionX = 0.0F;
      this.mLastMotionY = 0.0F;
      break;
      if ((i < -600) && (this.HvM < getChildCount() - 1))
      {
        ZT(this.HvM + 1);
      }
      else
      {
        i = getWidth();
        ZT((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setOnFlipperViewShowedListener(MMFlipper.a parama)
  {
    this.HwB = parama;
  }
  
  public void setOnMeasureListener(b paramb)
  {
    this.HwC = paramb;
  }
  
  public void setOnScreenChangedListener(c paramc)
  {
    this.HwA = paramc;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.HvP = paramBoolean;
  }
  
  public void setToScreen(int paramInt)
  {
    AppMethodBeat.i(141905);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.Hwz = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    if (this.HwA != null) {
      this.HwA.u(this.HvN, paramInt, false);
    }
    this.HvN = this.HvM;
    this.HvM = paramInt;
    this.Hwx = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141905);
  }
  
  public static abstract interface b
  {
    public abstract void gZ(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract void u(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper
 * JD-Core Version:    0.7.0.1
 */