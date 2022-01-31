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
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.y;

public class MMADFlipper
  extends ViewGroup
{
  private Scroller GB;
  private float GS;
  private float GT;
  private View VH;
  private VelocityTracker fB;
  private int jb;
  private View jcy;
  private Context mContext;
  private int uTR = 0;
  private Interpolator uTS;
  private int uTT;
  private int uTU;
  private boolean uTV = false;
  private boolean uTW = true;
  private MMADFlipper.a uTX;
  
  public MMADFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMADFlipper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.uTS = getInterpolator();
    this.GB = new Scroller(this.mContext, this.uTS);
    this.jb = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
  }
  
  private void Gl(int paramInt)
  {
    int i = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * i)
    {
      i = i * getWidth() - getScrollX();
      this.GB.startScroll(getScrollX(), 0, i, 0, a.ad(getContext(), Math.abs(i) * 2));
      invalidate();
    }
    y.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", new Object[] { Integer.valueOf(this.uTT), Integer.valueOf(this.uTU), Integer.valueOf(paramInt) });
    this.uTU = paramInt;
  }
  
  private boolean cAA()
  {
    return getChildCount() > 1;
  }
  
  private Interpolator getInterpolator()
  {
    return new LinearInterpolator();
  }
  
  public void computeScroll()
  {
    if (this.GB.computeScrollOffset())
    {
      scrollTo(this.GB.getCurrX(), this.GB.getCurrY());
      postInvalidate();
    }
    do
    {
      do
      {
        return;
      } while (!this.uTV);
      this.uTV = false;
      if (this.uTT <= 0)
      {
        this.uTT = getRealChildCount();
        setScrollXOffest(this.uTT * getWidth());
        return;
      }
    } while (this.uTT < getChildCount() - 1);
    this.uTT = 1;
    setScrollXOffest(this.uTT * getWidth());
  }
  
  public int getCurScreen()
  {
    return this.uTT;
  }
  
  public int getRealChildCount()
  {
    if (getChildCount() > 1) {
      return getChildCount() - 2;
    }
    return getChildCount();
  }
  
  public int getRealCurScreen()
  {
    if (getChildCount() > 1) {
      return this.uTT - 1;
    }
    return this.uTT;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.uTW) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    int i;
    do
    {
      return bool1;
      if (getChildCount() == 1) {
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      i = paramMotionEvent.getAction();
      if (i != 2) {
        break;
      }
      bool1 = bool2;
    } while (this.uTR != 0);
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      bool1 = bool2;
      if (this.uTR != 0) {
        break;
      }
      return false;
      i = (int)Math.abs(this.GS - f1);
      int j = (int)Math.abs(this.GT - f2);
      if ((i > this.jb) && (j < this.jb)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label177;
        }
        this.uTR = 1;
        break;
      }
      label177:
      this.uTR = 0;
      continue;
      this.GS = f1;
      this.GT = f2;
      if (this.GB.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.uTR = i;
        break;
      }
      this.uTR = 0;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
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
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
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
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (getChildCount() == 1) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.fB == null) {
      this.fB = VelocityTracker.obtain();
    }
    this.fB.addMovement(paramMotionEvent);
    int i = paramMotionEvent.getAction();
    float f = paramMotionEvent.getX();
    switch (i)
    {
    default: 
      return true;
    case 0: 
      if (!this.GB.isFinished()) {
        this.GB.abortAnimation();
      }
      this.GS = f;
      return true;
    case 2: 
      i = (int)(this.GS - f);
      this.GS = f;
      scrollBy(i, 0);
      return true;
    }
    paramMotionEvent = this.fB;
    paramMotionEvent.computeCurrentVelocity(1000);
    i = (int)paramMotionEvent.getXVelocity();
    if (i > 600)
    {
      if (cAA())
      {
        this.uTT -= 1;
        Gl(this.uTT);
      }
      this.uTV = true;
    }
    for (;;)
    {
      if (this.fB != null)
      {
        this.fB.recycle();
        this.fB = null;
      }
      this.uTR = 0;
      this.GS = 0.0F;
      this.GT = 0.0F;
      return true;
      if (i < -600)
      {
        if (cAA())
        {
          this.uTT += 1;
          Gl(this.uTT);
        }
        this.uTV = true;
      }
      else
      {
        i = getWidth();
        Gl((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setFooterView(View paramView)
  {
    this.jcy = paramView;
  }
  
  public void setHeaderView(View paramView)
  {
    this.VH = paramView;
  }
  
  public void setOnScreenChangedListener(MMADFlipper.a parama)
  {
    this.uTX = parama;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.uTW = paramBoolean;
  }
  
  @TargetApi(14)
  public void setScrollXOffest(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      setScrollX(paramInt);
    }
    while (this.GB == null) {
      return;
    }
    this.GB.setFinalX(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMADFlipper
 * JD-Core Version:    0.7.0.1
 */