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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class MMFlipper
  extends ViewGroup
{
  protected int OPT;
  private int OPU;
  private boolean OPV;
  private c OPW;
  private a OPX;
  private b OPY;
  private Interpolator OPZ;
  private int OPg;
  protected int OPi;
  protected int OPj;
  private boolean OPl;
  int OQa;
  int OQb;
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
    this.OPU = 0;
    this.OPg = 0;
    this.OPV = false;
    this.OPl = true;
    this.OQa = -123454321;
    this.OQb = -123454321;
    init(paramContext);
    AppMethodBeat.o(141898);
  }
  
  private void alu(int paramInt)
  {
    AppMethodBeat.i(141903);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int i = getWidth() * paramInt - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, i, 0, a.E(getContext(), (int)(Math.abs(i) * 1.3F)));
      if (this.OPi != paramInt)
      {
        this.OPV = true;
        this.OPT += paramInt - this.OPi;
      }
      this.OPj = this.OPi;
      this.OPi = paramInt;
      invalidate();
    }
    AppMethodBeat.o(141903);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(141900);
    this.OPZ = getInterpolator();
    this.mScroller = new Scroller(paramContext, this.OPZ);
    this.OPj = -1;
    int i = this.OPU;
    this.OPi = i;
    this.OPT = i;
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(141900);
  }
  
  public final void alx(int paramInt)
  {
    AppMethodBeat.i(141904);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.OPV = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    this.OPj = this.OPi;
    this.OPi = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141904);
  }
  
  public final void aly(int paramInt)
  {
    this.OPT = paramInt;
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
    if (this.OPV)
    {
      this.OPV = false;
      if (this.OPW != null)
      {
        this.OPW.z(this.OPj, this.OPT, true);
        AppMethodBeat.o(141907);
      }
    }
    else if ((this.OPX != null) && (this.mLastMotionX == 0.0F) && (this.OPj != this.OPi))
    {
      this.OPX.aiv(this.OPT);
    }
    AppMethodBeat.o(141907);
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(141906);
    Log.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[] { Integer.valueOf(this.OPi) });
    int i = this.OPi;
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
    if (!this.OPl)
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
    if ((i == 2) && (this.OPg != 0))
    {
      AppMethodBeat.o(141909);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.OPg != 0)
    {
      AppMethodBeat.o(141909);
      return true;
      i = (int)Math.abs(this.mLastMotionX - f1);
      int j = (int)Math.abs(this.mLastMotionY - f2);
      Log.v("MicroMsg.MMFlipper", "xDif = " + i + ", yDif = " + j);
      if ((i > this.mTouchSlop) && (j < this.mTouchSlop)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label230;
        }
        this.OPg = 1;
        break;
      }
      label230:
      this.OPg = 0;
      continue;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.OPg = i;
        break;
      }
      this.OPg = 0;
    }
    AppMethodBeat.o(141909);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141901);
    long l = Util.currentTicks();
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
        Log.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:".concat(String.valueOf(k)));
        localView.layout(j, 0, j + k, localView.getMeasuredHeight());
        k = j + k;
      }
      i += 1;
      j = k;
    }
    Log.v("MicroMsg.MMFlipper", "use " + Util.ticksToNow(l) + " ms, flipper onLayout changed:" + paramBoolean + " Left,Top,Right,Bottom:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    AppMethodBeat.o(141901);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141902);
    long l = Util.currentTicks();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.OPY != null) {
      this.OPY.ig(j, i);
    }
    this.OQa = j;
    this.OQb = i;
    int k = getChildCount();
    i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    scrollTo(this.OPi * j, 0);
    Log.i("MicroMsg.MMFlipper", "flipper onMeasure:" + j + "," + View.MeasureSpec.getSize(paramInt2) + " childCount:" + k + ", use " + Util.ticksToNow(l));
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
    if ((i > 600) && (this.OPi > 0)) {
      alu(this.OPi - 1);
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.OPg = 0;
      this.mLastMotionX = 0.0F;
      this.mLastMotionY = 0.0F;
      break;
      if ((i < -600) && (this.OPi < getChildCount() - 1))
      {
        alu(this.OPi + 1);
      }
      else
      {
        i = getWidth();
        alu((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setOnFlipperViewShowedListener(a parama)
  {
    this.OPX = parama;
  }
  
  public void setOnMeasureListener(b paramb)
  {
    this.OPY = paramb;
  }
  
  public void setOnScreenChangedListener(c paramc)
  {
    this.OPW = paramc;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.OPl = paramBoolean;
  }
  
  public void setToScreen(int paramInt)
  {
    AppMethodBeat.i(141905);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.OPV = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    if (this.OPW != null) {
      this.OPW.z(this.OPj, paramInt, false);
    }
    this.OPj = this.OPi;
    this.OPi = paramInt;
    this.OPT = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141905);
  }
  
  public static abstract interface a
  {
    public abstract void aiv(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void ig(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract void z(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper
 * JD-Core Version:    0.7.0.1
 */