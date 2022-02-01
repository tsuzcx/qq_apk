package com.tencent.mm.plugin.sns.ui.widget.ad;

import android.content.Context;
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
  private int lSq;
  private int mActivePointerId;
  private boolean mIsBeingDragged;
  protected Scroller mScroller;
  private int mTouchSlop;
  private int xVd;
  private int xVe;
  public View xYK;
  private int xYL;
  private int xYM;
  private int xYN;
  private int xYO;
  private ScrollableLayout.a xYP;
  private ScrollableLayout.b xYQ;
  
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
    AppMethodBeat.i(187801);
    this.mIsBeingDragged = false;
    this.xYL = 0;
    this.xYM = 0;
    this.xYN = 0;
    this.xYO = 0;
    this.mActivePointerId = -1;
    this.lSq = 0;
    try
    {
      this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      setOrientation(1);
      AppMethodBeat.o(187801);
      return;
    }
    catch (Throwable paramContext)
    {
      ad.w("ScrollLinearLayout", "the init method has something wrong!");
      AppMethodBeat.o(187801);
    }
  }
  
  private void NZ(int paramInt)
  {
    AppMethodBeat.i(187807);
    ScrollableLayout.b localb;
    if (paramInt != this.lSq)
    {
      localb = this.xYQ;
      if (localb != null) {
        if (getScrollY() < this.xYM) {
          break label68;
        }
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      localb.as(paramInt, bool);
      ad.i("ScrollLinearLayout", "the new state is ".concat(String.valueOf(paramInt)));
      this.lSq = paramInt;
      AppMethodBeat.o(187807);
      return;
    }
  }
  
  private boolean dEp()
  {
    AppMethodBeat.i(187806);
    ScrollableLayout.a locala = this.xYP;
    boolean bool = false;
    if (locala != null) {
      bool = locala.eu(this.xYK);
    }
    ad.i("ScrollLinearLayout", "the descendant is scrolled: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(187806);
    return bool;
  }
  
  private boolean x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187805);
    if (paramView == null)
    {
      AppMethodBeat.o(187805);
      return false;
    }
    int i = getScrollY();
    if ((paramInt2 >= paramView.getTop() - i) && (paramInt2 < paramView.getBottom() - i) && (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()))
    {
      AppMethodBeat.o(187805);
      return true;
    }
    AppMethodBeat.o(187805);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(187802);
    super.computeScroll();
    try
    {
      if (this.mScroller.computeScrollOffset())
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        invalidate();
        AppMethodBeat.o(187802);
        return;
      }
      if (this.lSq == 2)
      {
        ad.i("ScrollLinearLayout", "compute scroll offset is false the currY is " + this.mScroller.getCurrY() + ", the final Y is " + this.mScroller.getFinalY());
        NZ(0);
      }
      AppMethodBeat.o(187802);
      return;
    }
    catch (Throwable localThrowable)
    {
      ad.w("ScrollLinearLayout", "the compute scroll has something wrong!");
      AppMethodBeat.o(187802);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(187803);
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
            AppMethodBeat.o(187803);
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
          if (!x(this.xYK, i, j))
          {
            this.mIsBeingDragged = false;
            ad.i("ScrollLinearLayout", "the onInterceptTouchActionDown is called " + this.mIsBeingDragged);
            bool1 = this.mIsBeingDragged;
            continue;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.xVd = j;
          this.xVe = i;
          this.mScroller.computeScrollOffset();
          bool1 = bool2;
          if (!this.mScroller.isFinished()) {
            bool1 = true;
          }
          this.mIsBeingDragged = bool1;
          if (this.xYL > 0)
          {
            i = this.xYL;
            this.xYN = (this.xYM + i);
            this.xYO = (-i);
            continue;
          }
          i = this.xYM / 3;
        }
      }
      catch (Throwable localThrowable)
      {
        ad.e("ScrollLinearLayout", "the onInterceptTouchEventInner has something wrong");
        bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(187803);
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
          int k = j - this.xVd;
          if ((Math.abs(k) >= this.mTouchSlop) && (!dEp()) && (((k < 0) && (getScrollY() < this.xYM)) || ((k > 0) && (getScrollY() >= this.xYL))))
          {
            this.mIsBeingDragged = true;
            this.xVd = j;
            this.xVe = i;
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
    AppMethodBeat.i(187804);
    for (;;)
    {
      try
      {
        int i = paramMotionEvent.getActionMasked();
        switch (i)
        {
        default: 
          if (!bool1) {
            continue;
          }
          AppMethodBeat.o(187804);
          return true;
        case 0: 
          i = (int)paramMotionEvent.getX();
          j = (int)paramMotionEvent.getY();
          if (!x(this.xYK, i, j)) {
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
          this.xVe = i;
          this.xVd = j;
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
          ad.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " mLastEventY = " + this.xVd);
          int k = (int)paramMotionEvent.getX(i);
          int m = (int)paramMotionEvent.getY(i);
          j = m - this.xVd;
          ad.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " yOffset = " + j);
          i = j;
          if (!this.mIsBeingDragged)
          {
            i = j;
            if (Math.abs(j) >= this.mTouchSlop)
            {
              i = j;
              if (!dEp())
              {
                ad.i("ScrollLinearLayout", "the onTouchActionMove is called, the mIsBeingDragged is false");
                this.mIsBeingDragged = true;
                if (j <= 0) {
                  continue;
                }
                i = j - this.mTouchSlop;
              }
            }
          }
          j = getScrollY() - i;
          if ((this.mIsBeingDragged) && (this.xYO < j) && (this.xYN > j))
          {
            NZ(1);
            scrollBy(0, -i);
            this.xVd = m;
            this.xVe = k;
          }
          ad.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " scroll y = " + getScrollY());
          bool1 = true;
          continue;
          i = j + this.mTouchSlop;
          break;
        }
        int j = getScrollY();
        i = this.xYM - j;
        if (j <= this.xYM / 2) {
          i = -j;
        }
        if (this.mIsBeingDragged)
        {
          this.mScroller.startScroll(getScrollX(), j, 0, i, 350);
          invalidate();
          NZ(2);
          bool1 = true;
          this.mIsBeingDragged = false;
          this.mActivePointerId = -1;
          this.xVd = 0;
          this.xVe = 0;
          continue;
        }
        NZ(0);
      }
      catch (Throwable localThrowable)
      {
        ad.e("ScrollLinearLayout", "the onTouchEventInner is called " + this.mIsBeingDragged);
        bool1 = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(187804);
        return bool1;
      }
      bool1 = bool3;
    }
  }
  
  public void setDescendantScrollStatusHunter(ScrollableLayout.a parama)
  {
    this.xYP = parama;
  }
  
  public void setMaxOverScrollOffset(int paramInt)
  {
    this.xYL = paramInt;
  }
  
  public void setMaxYScrollOffset(int paramInt)
  {
    this.xYM = paramInt;
  }
  
  public void setOnScrollStatusListener(ScrollableLayout.b paramb)
  {
    this.xYQ = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout
 * JD-Core Version:    0.7.0.1
 */