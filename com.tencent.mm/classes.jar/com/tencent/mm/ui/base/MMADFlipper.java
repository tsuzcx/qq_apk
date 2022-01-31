package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.ab;

public class MMADFlipper
  extends ViewGroup
{
  private View Ww;
  private View llk;
  private Context mContext;
  private float mLastMotionX;
  private float mLastMotionY;
  private Scroller mScroller;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private int zis;
  private Interpolator zit;
  private int ziu;
  private int ziv;
  private boolean ziw;
  private boolean zix;
  private MMADFlipper.a ziy;
  
  public MMADFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMADFlipper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(106388);
    this.zis = 0;
    this.ziw = false;
    this.zix = true;
    this.mContext = paramContext;
    this.zit = getInterpolator();
    this.mScroller = new Scroller(this.mContext, this.zit);
    this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
    AppMethodBeat.o(106388);
  }
  
  private void OB(int paramInt)
  {
    AppMethodBeat.i(106398);
    OC(paramInt);
    ab.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", new Object[] { Integer.valueOf(this.ziu), Integer.valueOf(this.ziv), Integer.valueOf(paramInt) });
    this.ziv = paramInt;
    AppMethodBeat.o(106398);
  }
  
  private void OC(int paramInt)
  {
    AppMethodBeat.i(106399);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      paramInt = paramInt * getWidth() - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, paramInt, 0, a.ar(getContext(), Math.abs(paramInt) * 2));
      invalidate();
    }
    AppMethodBeat.o(106399);
  }
  
  private boolean dDL()
  {
    AppMethodBeat.i(106395);
    if (getChildCount() > 1)
    {
      AppMethodBeat.o(106395);
      return true;
    }
    AppMethodBeat.o(106395);
    return false;
  }
  
  private Interpolator getInterpolator()
  {
    AppMethodBeat.i(106394);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    AppMethodBeat.o(106394);
    return localLinearInterpolator;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(106400);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
      AppMethodBeat.o(106400);
      return;
    }
    if (this.ziw)
    {
      this.ziw = false;
      if (this.ziu <= 0)
      {
        this.ziu = getRealChildCount();
        setScrollXOffest(this.ziu * getWidth());
        AppMethodBeat.o(106400);
        return;
      }
      if (this.ziu >= getChildCount() - 1)
      {
        this.ziu = 1;
        setScrollXOffest(this.ziu * getWidth());
      }
    }
    AppMethodBeat.o(106400);
  }
  
  public int getCurScreen()
  {
    return this.ziu;
  }
  
  public int getRealChildCount()
  {
    AppMethodBeat.i(106396);
    if (getChildCount() > 1)
    {
      i = getChildCount();
      AppMethodBeat.o(106396);
      return i - 2;
    }
    int i = getChildCount();
    AppMethodBeat.o(106396);
    return i;
  }
  
  public int getRealCurScreen()
  {
    AppMethodBeat.i(106397);
    if (getChildCount() > 1)
    {
      i = this.ziu;
      AppMethodBeat.o(106397);
      return i - 1;
    }
    int i = this.ziu;
    AppMethodBeat.o(106397);
    return i;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(106389);
    super.onFinishInflate();
    AppMethodBeat.o(106389);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106392);
    boolean bool;
    if (!this.zix)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106392);
      return bool;
    }
    if (getChildCount() == 1)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106392);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.zis != 0))
    {
      AppMethodBeat.o(106392);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.zis != 0)
    {
      AppMethodBeat.o(106392);
      return true;
      i = (int)Math.abs(this.mLastMotionX - f1);
      int j = (int)Math.abs(this.mLastMotionY - f2);
      if ((i > this.mTouchSlop) && (j < this.mTouchSlop)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label198;
        }
        this.zis = 1;
        break;
      }
      label198:
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
    AppMethodBeat.o(106392);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(106390);
    paramInt4 = getChildCount();
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < paramInt4; paramInt2 = paramInt3)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        paramInt3 = localView.getMeasuredWidth();
        localView.layout(paramInt2, 0, paramInt2 + paramInt3, localView.getMeasuredHeight());
        paramInt3 = paramInt2 + paramInt3;
      }
      paramInt1 += 1;
    }
    AppMethodBeat.o(106390);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106391);
    super.onMeasure(paramInt1, paramInt2);
    View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      getChildAt(i).measure(paramInt1, paramInt2);
      i += 1;
    }
    AppMethodBeat.o(106391);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(106393);
    if (getChildCount() == 1)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(106393);
      return bool;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (i)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        AppMethodBeat.o(106393);
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
    if (i > 600)
    {
      if (dDL())
      {
        this.ziu -= 1;
        OB(this.ziu);
      }
      this.ziw = true;
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
      if (i < -600)
      {
        if (dDL())
        {
          this.ziu += 1;
          OB(this.ziu);
        }
        this.ziw = true;
      }
      else
      {
        i = getWidth();
        OB((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setFooterView(View paramView)
  {
    this.llk = paramView;
  }
  
  public void setHeaderView(View paramView)
  {
    this.Ww = paramView;
  }
  
  public void setOnScreenChangedListener(MMADFlipper.a parama)
  {
    this.ziy = parama;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.zix = paramBoolean;
  }
  
  @TargetApi(14)
  public void setScrollXOffest(int paramInt)
  {
    AppMethodBeat.i(106401);
    if (Build.VERSION.SDK_INT >= 14)
    {
      setScrollX(paramInt);
      AppMethodBeat.o(106401);
      return;
    }
    if (this.mScroller != null) {
      this.mScroller.setFinalX(paramInt);
    }
    AppMethodBeat.o(106401);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMADFlipper
 * JD-Core Version:    0.7.0.1
 */