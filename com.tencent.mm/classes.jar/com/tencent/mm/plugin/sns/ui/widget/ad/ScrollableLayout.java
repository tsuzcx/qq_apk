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
import com.tencent.mm.sdk.platformtools.ac;

public class ScrollableLayout
  extends LinearLayout
{
  private int mActivePointerId;
  private boolean mIsBeingDragged;
  protected Scroller mScroller;
  private int mTouchSlop;
  private int mus;
  private int zhZ;
  private int zia;
  public View zlH;
  private int zlI;
  private int zlJ;
  private int zlK;
  private int zlL;
  private ScrollableLayout.a zlM;
  private ScrollableLayout.b zlN;
  
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
    AppMethodBeat.i(200678);
    this.mIsBeingDragged = false;
    this.zlI = 0;
    this.zlJ = 0;
    this.zlK = 0;
    this.zlL = 0;
    this.mActivePointerId = -1;
    this.mus = 0;
    try
    {
      this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      setOrientation(1);
      AppMethodBeat.o(200678);
      return;
    }
    catch (Throwable paramContext)
    {
      ac.w("ScrollLinearLayout", "the init method has something wrong!");
      AppMethodBeat.o(200678);
    }
  }
  
  private void Qd(int paramInt)
  {
    AppMethodBeat.i(200684);
    ScrollableLayout.b localb;
    if (paramInt != this.mus)
    {
      localb = this.zlN;
      if (localb != null) {
        if (getScrollY() < this.zlJ) {
          break label68;
        }
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      localb.av(paramInt, bool);
      ac.i("ScrollLinearLayout", "the new state is ".concat(String.valueOf(paramInt)));
      this.mus = paramInt;
      AppMethodBeat.o(200684);
      return;
    }
  }
  
  private boolean dSN()
  {
    AppMethodBeat.i(200683);
    ScrollableLayout.a locala = this.zlM;
    boolean bool = false;
    if (locala != null) {
      bool = locala.eH(this.zlH);
    }
    ac.i("ScrollLinearLayout", "the descendant is scrolled: ".concat(String.valueOf(bool)));
    AppMethodBeat.o(200683);
    return bool;
  }
  
  private boolean x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200682);
    if (paramView == null)
    {
      AppMethodBeat.o(200682);
      return false;
    }
    int i = getScrollY();
    if ((paramInt2 >= paramView.getTop() - i) && (paramInt2 < paramView.getBottom() - i) && (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()))
    {
      AppMethodBeat.o(200682);
      return true;
    }
    AppMethodBeat.o(200682);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(200679);
    super.computeScroll();
    try
    {
      if (this.mScroller.computeScrollOffset())
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        invalidate();
        AppMethodBeat.o(200679);
        return;
      }
      if (this.mus == 2)
      {
        ac.i("ScrollLinearLayout", "compute scroll offset is false the currY is " + this.mScroller.getCurrY() + ", the final Y is " + this.mScroller.getFinalY());
        Qd(0);
      }
      AppMethodBeat.o(200679);
      return;
    }
    catch (Throwable localThrowable)
    {
      ac.w("ScrollLinearLayout", "the compute scroll has something wrong!");
      AppMethodBeat.o(200679);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(200680);
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
            AppMethodBeat.o(200680);
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
          if (!x(this.zlH, i, j))
          {
            this.mIsBeingDragged = false;
            ac.i("ScrollLinearLayout", "the onInterceptTouchActionDown is called " + this.mIsBeingDragged);
            bool1 = this.mIsBeingDragged;
            continue;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.zhZ = j;
          this.zia = i;
          this.mScroller.computeScrollOffset();
          bool1 = bool2;
          if (!this.mScroller.isFinished()) {
            bool1 = true;
          }
          this.mIsBeingDragged = bool1;
          if (this.zlI > 0)
          {
            i = this.zlI;
            this.zlK = (this.zlJ + i);
            this.zlL = (-i);
            continue;
          }
          i = this.zlJ / 3;
        }
      }
      catch (Throwable localThrowable)
      {
        ac.e("ScrollLinearLayout", "the onInterceptTouchEventInner has something wrong");
        bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(200680);
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
          int k = j - this.zhZ;
          if ((Math.abs(k) >= this.mTouchSlop) && (!dSN()) && (((k < 0) && (getScrollY() < this.zlJ)) || ((k > 0) && (getScrollY() >= this.zlI))))
          {
            this.mIsBeingDragged = true;
            this.zhZ = j;
            this.zia = i;
          }
        }
      }
      ac.i("ScrollLinearLayout", "the onInterceptTouchActionMove is called " + this.mIsBeingDragged);
      bool1 = this.mIsBeingDragged;
      continue;
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      ac.i("ScrollLinearLayout", "the onInterceptTouchActionUpOrCancel is called " + this.mIsBeingDragged);
      bool1 = this.mIsBeingDragged;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(200681);
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
          AppMethodBeat.o(200681);
          return true;
        case 0: 
          i = (int)paramMotionEvent.getX();
          j = (int)paramMotionEvent.getY();
          if (!x(this.zlH, i, j)) {
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
          this.zia = i;
          this.zhZ = j;
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          ac.i("ScrollLinearLayout", "the onTouchActionDown is called " + this.mIsBeingDragged);
          bool1 = this.mIsBeingDragged;
          break;
        case 2: 
          i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
          if (i < 0)
          {
            ac.e("ScrollLinearLayout", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
            bool1 = true;
            continue;
          }
          ac.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " mLastEventY = " + this.zhZ);
          int k = (int)paramMotionEvent.getX(i);
          int m = (int)paramMotionEvent.getY(i);
          j = m - this.zhZ;
          ac.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " yOffset = " + j);
          i = j;
          if (!this.mIsBeingDragged)
          {
            i = j;
            if (Math.abs(j) >= this.mTouchSlop)
            {
              i = j;
              if (!dSN())
              {
                ac.i("ScrollLinearLayout", "the onTouchActionMove is called, the mIsBeingDragged is false");
                this.mIsBeingDragged = true;
                if (j <= 0) {
                  continue;
                }
                i = j - this.mTouchSlop;
              }
            }
          }
          j = getScrollY() - i;
          if ((this.mIsBeingDragged) && (this.zlL < j) && (this.zlK > j))
          {
            Qd(1);
            scrollBy(0, -i);
            this.zhZ = m;
            this.zia = k;
          }
          ac.i("ScrollLinearLayout", "the onTouchActionMove is called " + this.mIsBeingDragged + " scroll y = " + getScrollY());
          bool1 = true;
          continue;
          i = j + this.mTouchSlop;
          break;
        }
        int j = getScrollY();
        i = this.zlJ - j;
        if (j <= this.zlJ / 2) {
          i = -j;
        }
        if (this.mIsBeingDragged)
        {
          this.mScroller.startScroll(getScrollX(), j, 0, i, 350);
          invalidate();
          Qd(2);
          bool1 = true;
          this.mIsBeingDragged = false;
          this.mActivePointerId = -1;
          this.zhZ = 0;
          this.zia = 0;
          continue;
        }
        Qd(0);
      }
      catch (Throwable localThrowable)
      {
        ac.e("ScrollLinearLayout", "the onTouchEventInner is called " + this.mIsBeingDragged);
        bool1 = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(200681);
        return bool1;
      }
      bool1 = bool3;
    }
  }
  
  public void setDescendantScrollStatusHunter(ScrollableLayout.a parama)
  {
    this.zlM = parama;
  }
  
  public void setMaxOverScrollOffset(int paramInt)
  {
    this.zlI = paramInt;
  }
  
  public void setMaxYScrollOffset(int paramInt)
  {
    this.zlJ = paramInt;
  }
  
  public void setOnScrollStatusListener(ScrollableLayout.b paramb)
  {
    this.zlN = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout
 * JD-Core Version:    0.7.0.1
 */