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
import com.tencent.mm.sdk.platformtools.ae;

public class ScrollableLayout
  extends LinearLayout
{
  private int ARu;
  private int ARv;
  private int AVA;
  private int AVB;
  private ScrollableLayout.a AVC;
  private ScrollableLayout.b AVD;
  public View AVw;
  private int AVx;
  private int AVy;
  private int AVz;
  private int mActivePointerId;
  private boolean mIsBeingDragged;
  protected Scroller mScroller;
  private int mTouchSlop;
  private int naf;
  private int znD;
  
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
    AppMethodBeat.i(220170);
    this.mIsBeingDragged = false;
    this.AVx = 0;
    this.AVy = 0;
    this.AVz = 0;
    this.AVA = 0;
    this.mActivePointerId = -1;
    this.AVB = -2147483648;
    this.naf = 0;
    try
    {
      this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      setOrientation(1);
      this.znD = paramContext.getResources().getDimensionPixelOffset(2131167073);
      AppMethodBeat.o(220170);
      return;
    }
    catch (Throwable paramContext)
    {
      ae.w("ScrollLinearLayout", "the init method has something wrong!");
      AppMethodBeat.o(220170);
    }
  }
  
  private void Sv(int paramInt)
  {
    AppMethodBeat.i(220175);
    ScrollableLayout.b localb;
    if (paramInt != this.naf)
    {
      localb = this.AVD;
      if (localb != null) {
        if (getScrollY() < this.AVy) {
          break label78;
        }
      }
    }
    label78:
    for (boolean bool = true;; bool = false)
    {
      localb.aD(paramInt, bool);
      ae.i("ScrollLinearLayout", "the new state is ".concat(String.valueOf(paramInt)));
      this.naf = paramInt;
      if (paramInt == 0) {
        this.AVB = -2147483648;
      }
      AppMethodBeat.o(220175);
      return;
    }
  }
  
  private boolean x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220174);
    if (paramView == null)
    {
      AppMethodBeat.o(220174);
      return false;
    }
    int i = getScrollY();
    if ((paramInt2 >= paramView.getTop() - i) && (paramInt2 < paramView.getBottom() - i) && (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()))
    {
      AppMethodBeat.o(220174);
      return true;
    }
    AppMethodBeat.o(220174);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(220171);
    super.computeScroll();
    try
    {
      if (this.mScroller.computeScrollOffset())
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        invalidate();
        AppMethodBeat.o(220171);
        return;
      }
      if (this.naf == 2)
      {
        ae.i("ScrollLinearLayout", "compute scroll offset is false the currY is " + this.mScroller.getCurrY() + ", the final Y is " + this.mScroller.getFinalY());
        Sv(0);
      }
      AppMethodBeat.o(220171);
      return;
    }
    catch (Throwable localThrowable)
    {
      ae.w("ScrollLinearLayout", "the compute scroll has something wrong!");
      AppMethodBeat.o(220171);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(220172);
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
            AppMethodBeat.o(220172);
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
          this.AVB = getScrollY();
          if (!x(this.AVw, i, j))
          {
            this.mIsBeingDragged = false;
            ae.i("ScrollLinearLayout", "the onInterceptTouchActionDown is called " + this.mIsBeingDragged);
            bool1 = this.mIsBeingDragged;
            continue;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.ARu = j;
          this.ARv = i;
          this.mScroller.computeScrollOffset();
          bool1 = bool2;
          if (!this.mScroller.isFinished()) {
            bool1 = true;
          }
          this.mIsBeingDragged = bool1;
          if (this.AVx > 0)
          {
            i = this.AVx;
            this.AVz = (this.AVy + i);
            this.AVA = (-i);
            continue;
          }
          i = this.AVy / 3;
        }
      }
      catch (Throwable localThrowable)
      {
        ae.e("ScrollLinearLayout", "the onInterceptTouchEventInner has something wrong");
        bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(220172);
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
          int k = j - this.ARu;
          int m = getScrollY();
          if (Math.abs(k) >= this.mTouchSlop)
          {
            this.ARu = j;
            this.ARv = i;
            if (((k < 0) && (m <= 0)) || ((k > 0) && (m >= this.AVy))) {
              this.mIsBeingDragged = true;
            }
          }
        }
      }
      ae.i("ScrollLinearLayout", "the onInterceptTouchActionMove is called " + this.mIsBeingDragged);
      bool1 = this.mIsBeingDragged;
      continue;
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      ae.i("ScrollLinearLayout", "the onInterceptTouchActionUpOrCancel is called " + this.mIsBeingDragged);
      bool1 = this.mIsBeingDragged;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(220173);
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
          AppMethodBeat.o(220173);
          return true;
        case 0: 
          i = (int)paramMotionEvent.getX();
          j = (int)paramMotionEvent.getY();
          if (!x(this.AVw, i, j)) {
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
          this.ARv = i;
          this.ARu = j;
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          ae.i("ScrollLinearLayout", "the onTouchActionDown is called " + this.mIsBeingDragged);
          bool1 = this.mIsBeingDragged;
          break;
        case 2: 
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i < 0)
          {
            ae.e("ScrollLinearLayout", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
            bool1 = true;
            continue;
          }
          ae.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " mLastEventY = " + this.ARu);
          k = (int)paramMotionEvent.getX(i);
          int m = (int)paramMotionEvent.getY(i);
          j = m - this.ARu;
          ae.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " yOffset = " + j);
          i = j;
          if (!this.mIsBeingDragged)
          {
            i = j;
            if (Math.abs(j) >= this.mTouchSlop)
            {
              ae.i("ScrollLinearLayout", "the onTouchActionMove is called, the mIsBeingDragged is false");
              this.mIsBeingDragged = true;
              if (j <= 0) {
                continue;
              }
              i = j - this.mTouchSlop;
            }
          }
          j = getScrollY() - i;
          if ((this.mIsBeingDragged) && (this.AVA < j) && (this.AVz > j))
          {
            Sv(1);
            scrollBy(0, -i);
            this.ARu = m;
            this.ARv = k;
          }
          ae.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " scroll y = " + getScrollY());
          bool1 = true;
          continue;
          i = j + this.mTouchSlop;
          break;
        }
        i = this.AVB;
        j = getScrollY();
        k = j - i;
        if (k > 0)
        {
          i = this.AVy - j;
          if (k < this.znD) {
            i = -j;
          }
          if (!this.mIsBeingDragged) {
            break label648;
          }
          this.mScroller.startScroll(getScrollX(), j, 0, i, 350);
          invalidate();
          Sv(2);
          bool1 = true;
          this.mIsBeingDragged = false;
          this.mActivePointerId = -1;
          this.ARu = 0;
          this.ARv = 0;
          continue;
        }
        i = -j;
      }
      catch (Throwable localThrowable)
      {
        ae.e("ScrollLinearLayout", "the onTouchEventInner is called " + this.mIsBeingDragged);
        bool1 = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(220173);
        return bool1;
      }
      if (k > -this.znD)
      {
        i = this.AVy - j;
        continue;
        label648:
        Sv(0);
        bool1 = bool3;
      }
    }
  }
  
  public void setDescendantScrollStatusHunter(ScrollableLayout.a parama)
  {
    this.AVC = parama;
  }
  
  public void setMaxOverScrollOffset(int paramInt)
  {
    this.AVx = paramInt;
  }
  
  public void setMaxYScrollOffset(int paramInt)
  {
    this.AVy = paramInt;
  }
  
  public void setOnScrollStatusListener(ScrollableLayout.b paramb)
  {
    this.AVD = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout
 * JD-Core Version:    0.7.0.1
 */