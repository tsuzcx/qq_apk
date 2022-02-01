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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class MMFlipper
  extends ViewGroup
{
  private int JjA;
  protected int JjC;
  protected int JjD;
  private boolean JjF;
  protected int Jkn;
  private int Jko;
  private boolean Jkp;
  private c Jkq;
  private a Jkr;
  private b Jks;
  private Interpolator Jkt;
  int Jku;
  int Jkv;
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
    this.Jko = 0;
    this.JjA = 0;
    this.Jkp = false;
    this.JjF = true;
    this.Jku = -123454321;
    this.Jkv = -123454321;
    init(paramContext);
    AppMethodBeat.o(141898);
  }
  
  private void acd(int paramInt)
  {
    AppMethodBeat.i(141903);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int i = getWidth() * paramInt - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, i, 0, a.aA(getContext(), (int)(Math.abs(i) * 1.3F)));
      if (this.JjC != paramInt)
      {
        this.Jkp = true;
        this.Jkn += paramInt - this.JjC;
      }
      this.JjD = this.JjC;
      this.JjC = paramInt;
      invalidate();
    }
    AppMethodBeat.o(141903);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(141900);
    this.Jkt = getInterpolator();
    this.mScroller = new Scroller(paramContext, this.Jkt);
    this.JjD = -1;
    int i = this.Jko;
    this.JjC = i;
    this.Jkn = i;
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(141900);
  }
  
  public final void acg(int paramInt)
  {
    AppMethodBeat.i(141904);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.Jkp = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    this.JjD = this.JjC;
    this.JjC = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141904);
  }
  
  public final void ach(int paramInt)
  {
    this.Jkn = paramInt;
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
    if (this.Jkp)
    {
      this.Jkp = false;
      if (this.Jkq != null)
      {
        this.Jkq.u(this.JjD, this.Jkn, true);
        AppMethodBeat.o(141907);
      }
    }
    else if ((this.Jkr != null) && (this.mLastMotionX == 0.0F) && (this.JjD != this.JjC))
    {
      this.Jkr.Zd(this.Jkn);
    }
    AppMethodBeat.o(141907);
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(141906);
    ad.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[] { Integer.valueOf(this.JjC) });
    int i = this.JjC;
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
    if (!this.JjF)
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
    if ((i == 2) && (this.JjA != 0))
    {
      AppMethodBeat.o(141909);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.JjA != 0)
    {
      AppMethodBeat.o(141909);
      return true;
      i = (int)Math.abs(this.mLastMotionX - f1);
      int j = (int)Math.abs(this.mLastMotionY - f2);
      ad.v("MicroMsg.MMFlipper", "xDif = " + i + ", yDif = " + j);
      if ((i > this.mTouchSlop) && (j < this.mTouchSlop)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label230;
        }
        this.JjA = 1;
        break;
      }
      label230:
      this.JjA = 0;
      continue;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.JjA = i;
        break;
      }
      this.JjA = 0;
    }
    AppMethodBeat.o(141909);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141901);
    long l = bt.HI();
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
        ad.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:".concat(String.valueOf(k)));
        localView.layout(j, 0, j + k, localView.getMeasuredHeight());
        k = j + k;
      }
      i += 1;
      j = k;
    }
    ad.v("MicroMsg.MMFlipper", "use " + bt.aO(l) + " ms, flipper onLayout changed:" + paramBoolean + " Left,Top,Right,Bottom:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    AppMethodBeat.o(141901);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141902);
    long l = bt.HI();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.Jks != null) {
      this.Jks.hq(j, i);
    }
    this.Jku = j;
    this.Jkv = i;
    int k = getChildCount();
    i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    scrollTo(this.JjC * j, 0);
    ad.i("MicroMsg.MMFlipper", "flipper onMeasure:" + j + "," + View.MeasureSpec.getSize(paramInt2) + " childCount:" + k + ", use " + bt.aO(l));
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
    if ((i > 600) && (this.JjC > 0)) {
      acd(this.JjC - 1);
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.JjA = 0;
      this.mLastMotionX = 0.0F;
      this.mLastMotionY = 0.0F;
      break;
      if ((i < -600) && (this.JjC < getChildCount() - 1))
      {
        acd(this.JjC + 1);
      }
      else
      {
        i = getWidth();
        acd((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setOnFlipperViewShowedListener(a parama)
  {
    this.Jkr = parama;
  }
  
  public void setOnMeasureListener(b paramb)
  {
    this.Jks = paramb;
  }
  
  public void setOnScreenChangedListener(c paramc)
  {
    this.Jkq = paramc;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.JjF = paramBoolean;
  }
  
  public void setToScreen(int paramInt)
  {
    AppMethodBeat.i(141905);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.Jkp = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    if (this.Jkq != null) {
      this.Jkq.u(this.JjD, paramInt, false);
    }
    this.JjD = this.JjC;
    this.JjC = paramInt;
    this.Jkn = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141905);
  }
  
  public static abstract interface a
  {
    public abstract void Zd(int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract void hq(int paramInt1, int paramInt2);
  }
  
  public static abstract interface c
  {
    public abstract void u(int paramInt1, int paramInt2, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper
 * JD-Core Version:    0.7.0.1
 */