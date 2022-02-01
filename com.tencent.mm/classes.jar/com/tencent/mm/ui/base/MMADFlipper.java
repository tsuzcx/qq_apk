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
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.Log;

public class MMADFlipper
  extends ViewGroup
{
  private int Win;
  private Interpolator Wio;
  private int Wip;
  private int Wiq;
  private boolean Wir;
  private boolean Wis;
  private a Wit;
  private Context mContext;
  private View mL;
  private float mLastMotionX;
  private float mLastMotionY;
  private Scroller mScroller;
  private int mTouchSlop;
  private VelocityTracker mVelocityTracker;
  private View uIP;
  
  public MMADFlipper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MMADFlipper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(141755);
    this.Win = 0;
    this.Wir = false;
    this.Wis = true;
    this.mContext = paramContext;
    this.Wio = getInterpolator();
    this.mScroller = new Scroller(this.mContext, this.Wio);
    this.mTouchSlop = ViewConfiguration.get(this.mContext).getScaledDoubleTapSlop();
    AppMethodBeat.o(141755);
  }
  
  private void aur(int paramInt)
  {
    AppMethodBeat.i(141765);
    aus(paramInt);
    Log.d("MicroMsg.MMFlipper", "mCurScreen:%d, mLastScreen:%d, whichScreen:%d", new Object[] { Integer.valueOf(this.Wip), Integer.valueOf(this.Wiq), Integer.valueOf(paramInt) });
    this.Wiq = paramInt;
    AppMethodBeat.o(141765);
  }
  
  private void aus(int paramInt)
  {
    AppMethodBeat.i(141766);
    paramInt = Math.max(0, Math.min(paramInt, getChildCount() - 1));
    if (getScrollX() != getWidth() * paramInt)
    {
      paramInt = paramInt * getWidth() - getScrollX();
      this.mScroller.startScroll(getScrollX(), 0, paramInt, 0, a.H(getContext(), Math.abs(paramInt) * 2));
      invalidate();
    }
    AppMethodBeat.o(141766);
  }
  
  private Interpolator getInterpolator()
  {
    AppMethodBeat.i(141761);
    LinearInterpolator localLinearInterpolator = new LinearInterpolator();
    AppMethodBeat.o(141761);
    return localLinearInterpolator;
  }
  
  private boolean hJB()
  {
    AppMethodBeat.i(141762);
    if (getChildCount() > 1)
    {
      AppMethodBeat.o(141762);
      return true;
    }
    AppMethodBeat.o(141762);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(141767);
    if (this.mScroller.computeScrollOffset())
    {
      scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
      postInvalidate();
      AppMethodBeat.o(141767);
      return;
    }
    if (this.Wir)
    {
      this.Wir = false;
      if (this.Wip <= 0)
      {
        this.Wip = getRealChildCount();
        setScrollXOffest(this.Wip * getWidth());
        AppMethodBeat.o(141767);
        return;
      }
      if (this.Wip >= getChildCount() - 1)
      {
        this.Wip = 1;
        setScrollXOffest(this.Wip * getWidth());
      }
    }
    AppMethodBeat.o(141767);
  }
  
  public int getCurScreen()
  {
    return this.Wip;
  }
  
  public int getRealChildCount()
  {
    AppMethodBeat.i(141763);
    if (getChildCount() > 1)
    {
      i = getChildCount();
      AppMethodBeat.o(141763);
      return i - 2;
    }
    int i = getChildCount();
    AppMethodBeat.o(141763);
    return i;
  }
  
  public int getRealCurScreen()
  {
    AppMethodBeat.i(141764);
    if (getChildCount() > 1)
    {
      i = this.Wip;
      AppMethodBeat.o(141764);
      return i - 1;
    }
    int i = this.Wip;
    AppMethodBeat.o(141764);
    return i;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(141756);
    super.onFinishInflate();
    AppMethodBeat.o(141756);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141759);
    boolean bool;
    if (!this.Wis)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141759);
      return bool;
    }
    if (getChildCount() == 1)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141759);
      return bool;
    }
    int i = paramMotionEvent.getAction();
    if ((i == 2) && (this.Win != 0))
    {
      AppMethodBeat.o(141759);
      return true;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    while (this.Win != 0)
    {
      AppMethodBeat.o(141759);
      return true;
      i = (int)Math.abs(this.mLastMotionX - f1);
      int j = (int)Math.abs(this.mLastMotionY - f2);
      if ((i > this.mTouchSlop) && (j < this.mTouchSlop)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label198;
        }
        this.Win = 1;
        break;
      }
      label198:
      this.Win = 0;
      continue;
      this.mLastMotionX = f1;
      this.mLastMotionY = f2;
      if (this.mScroller.isFinished()) {}
      for (i = 0;; i = 1)
      {
        this.Win = i;
        break;
      }
      this.Win = 0;
    }
    AppMethodBeat.o(141759);
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(141757);
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
    AppMethodBeat.o(141757);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141758);
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
    AppMethodBeat.o(141758);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(141760);
    if (getChildCount() == 1)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(141760);
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
        AppMethodBeat.o(141760);
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
      if (hJB())
      {
        this.Wip -= 1;
        aur(this.Wip);
      }
      this.Wir = true;
    }
    for (;;)
    {
      if (this.mVelocityTracker != null)
      {
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
      }
      this.Win = 0;
      this.mLastMotionX = 0.0F;
      this.mLastMotionY = 0.0F;
      break;
      if (i < -600)
      {
        if (hJB())
        {
          this.Wip += 1;
          aur(this.Wip);
        }
        this.Wir = true;
      }
      else
      {
        i = getWidth();
        aur((getScrollX() + i / 2) / i);
      }
    }
  }
  
  public void setFooterView(View paramView)
  {
    this.uIP = paramView;
  }
  
  public void setHeaderView(View paramView)
  {
    this.mL = paramView;
  }
  
  public void setOnScreenChangedListener(a parama)
  {
    this.Wit = parama;
  }
  
  public void setScrollEnable(boolean paramBoolean)
  {
    this.Wis = paramBoolean;
  }
  
  @TargetApi(14)
  public void setScrollXOffest(int paramInt)
  {
    AppMethodBeat.i(141768);
    if (Build.VERSION.SDK_INT >= 14)
    {
      setScrollX(paramInt);
      AppMethodBeat.o(141768);
      return;
    }
    if (this.mScroller != null) {
      this.mScroller.setFinalX(paramInt);
    }
    AppMethodBeat.o(141768);
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMADFlipper
 * JD-Core Version:    0.7.0.1
 */