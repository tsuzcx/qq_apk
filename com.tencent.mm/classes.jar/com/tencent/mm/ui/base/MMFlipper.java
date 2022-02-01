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
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public class MMFlipper
  extends ViewGroup
{
  private int FVW;
  protected int FVY;
  protected int FVZ;
  protected int FWJ;
  private int FWK;
  private boolean FWL;
  private b FWM;
  private a FWN;
  private Interpolator FWO;
  int FWP;
  int FWQ;
  private boolean FWb;
  private MMFlipper.d LCP;
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
    this.FWK = 0;
    this.FVW = 0;
    this.FWL = false;
    this.FWb = true;
    this.FWP = -123454321;
    this.FWQ = -123454321;
    init(paramContext);
    AppMethodBeat.o(141898);
  }
  
  private void XI(int paramInt)
  {
    AppMethodBeat.i(141903);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int i = getWidth() * paramInt - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, i, 0, a.ar(getContext(), (int)(Math.abs(i) * 1.3F)));
      if (this.FVY != paramInt)
      {
        this.FWL = true;
        this.FWJ += paramInt - this.FVY;
      }
      this.FVZ = this.FVY;
      this.FVY = paramInt;
      invalidate();
    }
    AppMethodBeat.o(141903);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(141900);
    this.FWO = getInterpolator();
    this.mScroller = new Scroller(paramContext, this.FWO);
    this.FVZ = -1;
    int i = this.FWK;
    this.FVY = i;
    this.FWJ = i;
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(141900);
  }
  
  public final void XL(int paramInt)
  {
    AppMethodBeat.i(141904);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.FWL = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    this.FVZ = this.FVY;
    this.FVY = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141904);
  }
  
  public final void XM(int paramInt)
  {
    this.FWJ = paramInt;
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
    if (this.FWL)
    {
      this.FWL = false;
      if (this.FWM != null)
      {
        this.FWM.u(this.FVZ, this.FWJ, true);
        AppMethodBeat.o(141907);
      }
    }
    else if ((this.LCP != null) && (this.mLastMotionX == 0.0F))
    {
      this.LCP.aik(this.FWJ);
    }
    AppMethodBeat.o(141907);
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(141906);
    ad.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[] { Integer.valueOf(this.FVY) });
    int i = this.FVY;
    AppMethodBeat.o(141906);
    return i;
  }
  
  protected Interpolator getInterpolator()
  {
    AppMethodBeat.i(141899);
    c localc = new c();
    AppMethodBeat.o(141899);
    return localc;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141909);
    boolean bool;
    if (!this.FWb)
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
    if ((i == 2) && (this.FVW != 0))
    {
      AppMethodBeat.o(141909);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.FVW != 0)
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
        this.FVW = 1;
        break;
      }
      label230:
      this.FVW = 0;
      continue;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.FVW = i;
        break;
      }
      this.FVW = 0;
    }
    AppMethodBeat.o(141909);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141901);
    long l = bt.GC();
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
    ad.v("MicroMsg.MMFlipper", "use " + bt.aS(l) + " ms, flipper onLayout changed:" + paramBoolean + " Left,Top,Right,Bottom:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    AppMethodBeat.o(141901);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141902);
    long l = bt.GC();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.FWN != null) {
      this.FWN.gQ(j, i);
    }
    this.FWP = j;
    this.FWQ = i;
    int k = getChildCount();
    i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    scrollTo(this.FVY * j, 0);
    ad.i("MicroMsg.MMFlipper", "flipper onMeasure:" + j + "," + View.MeasureSpec.getSize(paramInt2) + " childCount:" + k + ", use " + bt.aS(l));
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
    if ((i > 600) && (this.FVY > 0)) {
      XI(this.FVY - 1);
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.FVW = 0;
      this.mLastMotionX = 0.0F;
      this.mLastMotionY = 0.0F;
      break;
      if ((i < -600) && (this.FVY < getChildCount() - 1))
      {
        XI(this.FVY + 1);
      }
      else
      {
        i = getWidth();
        XI((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setOnFlipperViewShowedListener(MMFlipper.d paramd)
  {
    this.LCP = paramd;
  }
  
  public void setOnMeasureListener(a parama)
  {
    this.FWN = parama;
  }
  
  public void setOnScreenChangedListener(b paramb)
  {
    this.FWM = paramb;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.FWb = paramBoolean;
  }
  
  public void setToScreen(int paramInt)
  {
    AppMethodBeat.i(141905);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.FWL = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    if (this.FWM != null) {
      this.FWM.u(this.FVZ, paramInt, false);
    }
    this.FVZ = this.FVY;
    this.FVY = paramInt;
    this.FWJ = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141905);
  }
  
  public static abstract interface a
  {
    public abstract void gQ(int paramInt1, int paramInt2);
  }
  
  public static abstract interface b
  {
    public abstract void u(int paramInt1, int paramInt2, boolean paramBoolean);
  }
  
  static final class c
    implements Interpolator
  {
    private float uTI = 1.3F;
    
    public final float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return paramFloat * (paramFloat * paramFloat) + 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper
 * JD-Core Version:    0.7.0.1
 */