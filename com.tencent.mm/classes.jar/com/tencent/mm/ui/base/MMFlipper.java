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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class MMFlipper
  extends ViewGroup
{
  private int JEo;
  protected int JEq;
  protected int JEr;
  private boolean JEt;
  protected int JFb;
  private int JFc;
  private boolean JFd;
  private MMFlipper.c JFe;
  private MMFlipper.a JFf;
  private b JFg;
  private Interpolator JFh;
  int JFi;
  int JFj;
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
    this.JFc = 0;
    this.JEo = 0;
    this.JFd = false;
    this.JEt = true;
    this.JFi = -123454321;
    this.JFj = -123454321;
    init(paramContext);
    AppMethodBeat.o(141898);
  }
  
  private void acK(int paramInt)
  {
    AppMethodBeat.i(141903);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int i = getWidth() * paramInt - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, i, 0, a.aA(getContext(), (int)(Math.abs(i) * 1.3F)));
      if (this.JEq != paramInt)
      {
        this.JFd = true;
        this.JFb += paramInt - this.JEq;
      }
      this.JEr = this.JEq;
      this.JEq = paramInt;
      invalidate();
    }
    AppMethodBeat.o(141903);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(141900);
    this.JFh = getInterpolator();
    this.mScroller = new Scroller(paramContext, this.JFh);
    this.JEr = -1;
    int i = this.JFc;
    this.JEq = i;
    this.JFb = i;
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(141900);
  }
  
  public final void acN(int paramInt)
  {
    AppMethodBeat.i(141904);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.JFd = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    this.JEr = this.JEq;
    this.JEq = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141904);
  }
  
  public final void acO(int paramInt)
  {
    this.JFb = paramInt;
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
    if (this.JFd)
    {
      this.JFd = false;
      if (this.JFe != null)
      {
        this.JFe.u(this.JEr, this.JFb, true);
        AppMethodBeat.o(141907);
      }
    }
    else if ((this.JFf != null) && (this.mLastMotionX == 0.0F) && (this.JEr != this.JEq))
    {
      this.JFf.ZJ(this.JFb);
    }
    AppMethodBeat.o(141907);
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(141906);
    ae.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[] { Integer.valueOf(this.JEq) });
    int i = this.JEq;
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
    if (!this.JEt)
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
    if ((i == 2) && (this.JEo != 0))
    {
      AppMethodBeat.o(141909);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.JEo != 0)
    {
      AppMethodBeat.o(141909);
      return true;
      i = (int)Math.abs(this.mLastMotionX - f1);
      int j = (int)Math.abs(this.mLastMotionY - f2);
      ae.v("MicroMsg.MMFlipper", "xDif = " + i + ", yDif = " + j);
      if ((i > this.mTouchSlop) && (j < this.mTouchSlop)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label230;
        }
        this.JEo = 1;
        break;
      }
      label230:
      this.JEo = 0;
      continue;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.JEo = i;
        break;
      }
      this.JEo = 0;
    }
    AppMethodBeat.o(141909);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141901);
    long l = bu.HQ();
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
        ae.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:".concat(String.valueOf(k)));
        localView.layout(j, 0, j + k, localView.getMeasuredHeight());
        k = j + k;
      }
      i += 1;
      j = k;
    }
    ae.v("MicroMsg.MMFlipper", "use " + bu.aO(l) + " ms, flipper onLayout changed:" + paramBoolean + " Left,Top,Right,Bottom:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    AppMethodBeat.o(141901);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141902);
    long l = bu.HQ();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.JFg != null) {
      this.JFg.hs(j, i);
    }
    this.JFi = j;
    this.JFj = i;
    int k = getChildCount();
    i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    scrollTo(this.JEq * j, 0);
    ae.i("MicroMsg.MMFlipper", "flipper onMeasure:" + j + "," + View.MeasureSpec.getSize(paramInt2) + " childCount:" + k + ", use " + bu.aO(l));
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
    if ((i > 600) && (this.JEq > 0)) {
      acK(this.JEq - 1);
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.JEo = 0;
      this.mLastMotionX = 0.0F;
      this.mLastMotionY = 0.0F;
      break;
      if ((i < -600) && (this.JEq < getChildCount() - 1))
      {
        acK(this.JEq + 1);
      }
      else
      {
        i = getWidth();
        acK((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setOnFlipperViewShowedListener(MMFlipper.a parama)
  {
    this.JFf = parama;
  }
  
  public void setOnMeasureListener(b paramb)
  {
    this.JFg = paramb;
  }
  
  public void setOnScreenChangedListener(MMFlipper.c paramc)
  {
    this.JFe = paramc;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.JEt = paramBoolean;
  }
  
  public void setToScreen(int paramInt)
  {
    AppMethodBeat.i(141905);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.JFd = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    if (this.JFe != null) {
      this.JFe.u(this.JEr, paramInt, false);
    }
    this.JEr = this.JEq;
    this.JEq = paramInt;
    this.JFb = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(141905);
  }
  
  public static abstract interface b
  {
    public abstract void hs(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper
 * JD-Core Version:    0.7.0.1
 */