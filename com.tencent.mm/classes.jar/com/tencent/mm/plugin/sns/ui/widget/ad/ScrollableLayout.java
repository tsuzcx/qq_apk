package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class ScrollableLayout
  extends LinearLayout
{
  private int ADS;
  public View ADT;
  private int ADU;
  private int ADV;
  private int ADW;
  private int ADX;
  private int ADY;
  private ScrollableLayout.a ADZ;
  private ScrollableLayout.b AEa;
  private int AzY;
  private int AzZ;
  private int mActivePointerId;
  private boolean mIsBeingDragged;
  protected Scroller mScroller;
  private int mTouchSlop;
  private int mUZ;
  
  public ScrollableLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollableLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private ScrollableLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(198621);
    this.mIsBeingDragged = false;
    this.ADU = 0;
    this.ADV = 0;
    this.ADW = 0;
    this.ADX = 0;
    this.mActivePointerId = -1;
    this.ADY = -2147483648;
    this.mUZ = 0;
    try
    {
      this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      setOrientation(1);
      this.ADS = paramContext.getResources().getDimensionPixelOffset(2131167073);
      AppMethodBeat.o(198621);
      return;
    }
    catch (Throwable paramContext)
    {
      ad.w("ScrollLinearLayout", "the init method has something wrong!");
      AppMethodBeat.o(198621);
    }
  }
  
  private void RO(int paramInt)
  {
    AppMethodBeat.i(198626);
    ScrollableLayout.b localb;
    if (paramInt != this.mUZ)
    {
      localb = this.AEa;
      if (localb != null) {
        if (getScrollY() < this.ADV) {
          break label78;
        }
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localb.aA(paramInt, bool);
      ad.i("ScrollLinearLayout", "the new state is ".concat(String.valueOf(paramInt)));
      this.mUZ = paramInt;
      if (paramInt == 0) {
        this.ADY = -2147483648;
      }
      AppMethodBeat.o(198626);
      return;
    }
  }
  
  private boolean y(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198625);
    if (paramView == null)
    {
      AppMethodBeat.o(198625);
      return false;
    }
    int i = getScrollY();
    if ((paramInt2 >= paramView.getTop() - i) && (paramInt2 < paramView.getBottom() - i) && (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()))
    {
      AppMethodBeat.o(198625);
      return true;
    }
    AppMethodBeat.o(198625);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(198622);
    super.computeScroll();
    try
    {
      if (this.mScroller.computeScrollOffset())
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        invalidate();
        AppMethodBeat.o(198622);
        return;
      }
      if (this.mUZ == 2)
      {
        ad.i("ScrollLinearLayout", "compute scroll offset is false the currY is " + this.mScroller.getCurrY() + ", the final Y is " + this.mScroller.getFinalY());
        RO(0);
      }
      AppMethodBeat.o(198622);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.w("ScrollLinearLayout", "the compute scroll has something wrong!");
      AppMethodBeat.o(198622);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(198623);
    for (;;)
    {
      int j;
      try
      {
        i = paramMotionEvent.getAction();
        if (i == 2)
        {
          boolean bool3 = this.mIsBeingDragged;
          if (bool3)
          {
            bool1 = true;
            if (!bool1) {
              continue;
            }
            AppMethodBeat.o(198623);
            return true;
          }
        }
        switch (i & 0xFF)
        {
        default: 
          break;
        case 0: 
          i = (int)paramMotionEvent.getX();
          j = (int)paramMotionEvent.getY();
          this.ADY = getScrollY();
          if (!y(this.ADT, i, j))
          {
            this.mIsBeingDragged = false;
            ad.i("ScrollLinearLayout", "the onInterceptTouchActionDown is called " + this.mIsBeingDragged);
            bool1 = this.mIsBeingDragged;
            continue;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.AzY = j;
          this.AzZ = i;
          this.mScroller.computeScrollOffset();
          bool1 = bool2;
          if (!this.mScroller.isFinished()) {
            bool1 = true;
          }
          this.mIsBeingDragged = bool1;
          if (this.ADU > 0)
          {
            i = this.ADU;
            this.ADW = (this.ADV + i);
            this.ADX = (-i);
            continue;
          }
          i = this.ADV / 3;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.e("ScrollLinearLayout", "the onInterceptTouchEventInner has something wrong");
        bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(198623);
        return bool1;
      }
      continue;
      int i = this.mActivePointerId;
      if (i != -1)
      {
        j = paramMotionEvent.findPointerIndex(i);
        if (j >= 0)
        {
          i = (int)paramMotionEvent.getX(j);
          j = (int)paramMotionEvent.getY(j);
          int k = j - this.AzY;
          int m = getScrollY();
          if (Math.abs(k) >= this.mTouchSlop)
          {
            this.AzY = j;
            this.AzZ = i;
            if (((k < 0) && (m <= 0)) || ((k > 0) && (m >= this.ADV))) {
              this.mIsBeingDragged = true;
            }
          }
        }
      }
      ad.i("ScrollLinearLayout", "the onInterceptTouchActionMove is called " + this.mIsBeingDragged);
      bool1 = this.mIsBeingDragged;
      continue;
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      ad.i("ScrollLinearLayout", "the onInterceptTouchActionUpOrCancel is called " + this.mIsBeingDragged);
      bool1 = this.mIsBeingDragged;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(198624);
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        i = paramMotionEvent.getActionMasked();
        switch (i)
        {
        default: 
          if (!bool1) {
            continue;
          }
          AppMethodBeat.o(198624);
          return true;
        case 0: 
          i = (int)paramMotionEvent.getX();
          j = (int)paramMotionEvent.getY();
          if (!y(this.ADT, i, j)) {
            continue;
          }
          bool1 = bool2;
          if (!this.mScroller.isFinished()) {
            bool1 = true;
          }
          this.mIsBeingDragged = bool1;
          if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
          }
          this.AzZ = i;
          this.AzY = j;
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          ad.i("ScrollLinearLayout", "the onTouchActionDown is called " + this.mIsBeingDragged);
          bool1 = this.mIsBeingDragged;
          break;
        case 2: 
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i < 0)
          {
            ad.e("ScrollLinearLayout", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
            bool1 = true;
            continue;
          }
          ad.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " mLastEventY = " + this.AzY);
          k = (int)paramMotionEvent.getX(i);
          int m = (int)paramMotionEvent.getY(i);
          j = m - this.AzY;
          ad.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " yOffset = " + j);
          i = j;
          if (!this.mIsBeingDragged)
          {
            i = j;
            if (Math.abs(j) >= this.mTouchSlop)
            {
              ad.i("ScrollLinearLayout", "the onTouchActionMove is called, the mIsBeingDragged is false");
              this.mIsBeingDragged = true;
              if (j <= 0) {
                continue;
              }
              i = j - this.mTouchSlop;
            }
          }
          j = getScrollY() - i;
          if ((this.mIsBeingDragged) && (this.ADX < j) && (this.ADW > j))
          {
            RO(1);
            scrollBy(0, -i);
            this.AzY = m;
            this.AzZ = k;
          }
          ad.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " scroll y = " + getScrollY());
          bool1 = true;
          continue;
          i = j + this.mTouchSlop;
          break;
        }
        i = this.ADY;
        j = getScrollY();
        k = j - i;
        if (k > 0)
        {
          i = this.ADV - j;
          if (k < this.ADS) {
            i = -j;
          }
          if (!this.mIsBeingDragged) {
            break label648;
          }
          this.mScroller.startScroll(getScrollX(), j, 0, i, 350);
          invalidate();
          RO(2);
          bool1 = true;
          this.mIsBeingDragged = false;
          this.mActivePointerId = -1;
          this.AzY = 0;
          this.AzZ = 0;
          continue;
        }
        i = -j;
      }
      catch (Throwable localThrowable)
      {
        ad.e("ScrollLinearLayout", "the onTouchEventInner is called " + this.mIsBeingDragged);
        bool1 = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(198624);
        return bool1;
      }
      if (k > -this.ADS)
      {
        i = this.ADV - j;
        continue;
        label648:
        RO(0);
        bool1 = bool3;
      }
    }
  }
  
  public void setDescendantScrollStatusHunter(ScrollableLayout.a parama)
  {
    this.ADZ = parama;
  }
  
  public void setMaxOverScrollOffset(int paramInt)
  {
    this.ADU = paramInt;
  }
  
  public void setMaxYScrollOffset(int paramInt)
  {
    this.ADV = paramInt;
  }
  
  public void setOnScrollStatusListener(ScrollableLayout.b paramb)
  {
    this.AEa = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout
 * JD-Core Version:    0.7.0.1
 */