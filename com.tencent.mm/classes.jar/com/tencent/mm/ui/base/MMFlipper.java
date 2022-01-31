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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class MMFlipper
  extends ViewGroup
{
  private Interpolator fO;
  private float mLastMotionX;
  private float mLastMotionY;
  private Scroller mScroller;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private int zis;
  protected int ziu;
  protected int ziv;
  private boolean zix;
  protected int zjf;
  private int zjg;
  private boolean zjh;
  private MMFlipper.b zji;
  private MMFlipper.a zjj;
  int zjk;
  int zjl;
  
  public MMFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(106543);
    init(paramContext);
    AppMethodBeat.o(106543);
  }
  
  public MMFlipper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106544);
    this.zjg = 0;
    this.zis = 0;
    this.zjh = false;
    this.zix = true;
    this.zjk = -123454321;
    this.zjl = -123454321;
    init(paramContext);
    AppMethodBeat.o(106544);
  }
  
  private void OC(int paramInt)
  {
    AppMethodBeat.i(106549);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      int i = getWidth() * paramInt - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, i, 0, a.ar(getContext(), (int)(Math.abs(i) * 1.3F)));
      if (this.ziu != paramInt)
      {
        this.zjh = true;
        this.zjf += paramInt - this.ziu;
      }
      this.ziv = this.ziu;
      this.ziu = paramInt;
      invalidate();
    }
    AppMethodBeat.o(106549);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(106546);
    this.fO = getInterpolator();
    this.mScroller = new Scroller(paramContext, this.fO);
    this.ziv = -1;
    int i = this.zjg;
    this.ziu = i;
    this.zjf = i;
    this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    AppMethodBeat.o(106546);
  }
  
  public final void OF(int paramInt)
  {
    AppMethodBeat.i(106550);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.zjh = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    this.ziv = this.ziu;
    this.ziu = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(106550);
  }
  
  public final void OG(int paramInt)
  {
    this.zjf = paramInt;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(106553);
    this.mScroller.getCurrX();
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
      AppMethodBeat.o(106553);
      return;
    }
    if (this.zjh)
    {
      this.zjh = false;
      if (this.zji != null) {
        this.zji.CK(this.zjf);
      }
    }
    AppMethodBeat.o(106553);
  }
  
  public int getCurScreen()
  {
    AppMethodBeat.i(106552);
    ab.d("MicroMsg.MMFlipper", "cur screen is %d", new Object[] { Integer.valueOf(this.ziu) });
    int i = this.ziu;
    AppMethodBeat.o(106552);
    return i;
  }
  
  protected Interpolator getInterpolator()
  {
    AppMethodBeat.i(106545);
    c localc = new c();
    AppMethodBeat.o(106545);
    return localc;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106555);
    boolean bool;
    if (!this.zix)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106555);
      return bool;
    }
    if (getChildCount() == 1)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106555);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.zis != 0))
    {
      AppMethodBeat.o(106555);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.zis != 0)
    {
      AppMethodBeat.o(106555);
      return true;
      i = (int)Math.abs(this.mLastMotionX - f1);
      int j = (int)Math.abs(this.mLastMotionY - f2);
      ab.v("MicroMsg.MMFlipper", "xDif = " + i + ", yDif = " + j);
      if ((i > this.mTouchSlop) && (j < this.mTouchSlop)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label230;
        }
        this.zis = 1;
        break;
      }
      label230:
      this.zis = 0;
      continue;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.zis = i;
        break;
      }
      this.zis = 0;
    }
    AppMethodBeat.o(106555);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106547);
    long l = bo.yB();
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
        ab.v("MicroMsg.MMFlipper", "flipper onLayout childWidth:".concat(String.valueOf(k)));
        localView.layout(j, 0, j + k, localView.getMeasuredHeight());
        k = j + k;
      }
      i += 1;
      j = k;
    }
    ab.v("MicroMsg.MMFlipper", "use " + bo.av(l) + " ms, flipper onLayout changed:" + paramBoolean + " Left,Top,Right,Bottom:" + paramInt1 + "," + paramInt2 + "," + paramInt3 + "," + paramInt4);
    AppMethodBeat.o(106547);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106548);
    long l = bo.yB();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (this.zjj != null) {
      this.zjj.fp(j, i);
    }
    this.zjk = j;
    this.zjl = i;
    int k = getChildCount();
    i = 0;
    while (i < k)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    scrollTo(this.ziu * j, 0);
    ab.i("MicroMsg.MMFlipper", "flipper onMeasure:" + j + "," + View.MeasureSpec.getSize(paramInt2) + " childCount:" + k + ", use " + bo.av(l));
    AppMethodBeat.o(106548);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106554);
    if (getChildCount() == 1)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106554);
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
        AppMethodBeat.o(106554);
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
    if ((i > 600) && (this.ziu > 0)) {
      OC(this.ziu - 1);
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.zis = 0;
      this.mLastMotionX = 0.0F;
      this.mLastMotionY = 0.0F;
      break;
      if ((i < -600) && (this.ziu < getChildCount() - 1))
      {
        OC(this.ziu + 1);
      }
      else
      {
        i = getWidth();
        OC((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setOnMeasureListener(MMFlipper.a parama)
  {
    this.zjj = parama;
  }
  
  public void setOnScreenChangedListener(MMFlipper.b paramb)
  {
    this.zji = paramb;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.zix = paramBoolean;
  }
  
  public void setToScreen(int paramInt)
  {
    AppMethodBeat.i(106551);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    this.zjh = false;
    if (!this.mScroller.isFinished()) {
      this.mScroller.abortAnimation();
    }
    if (this.zji != null) {
      this.zji.CK(paramInt);
    }
    this.ziv = this.ziu;
    this.ziu = paramInt;
    this.zjf = paramInt;
    scrollTo(paramInt * getWidth(), 0);
    AppMethodBeat.o(106551);
  }
  
  static final class c
    implements Interpolator
  {
    private float pRM = 1.3F;
    
    public final float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return paramFloat * (paramFloat * paramFloat) + 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMFlipper
 * JD-Core Version:    0.7.0.1
 */