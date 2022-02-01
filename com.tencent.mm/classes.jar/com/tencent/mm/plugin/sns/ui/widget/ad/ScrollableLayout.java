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
import com.tencent.mm.plugin.sns.b.d;
import com.tencent.mm.sdk.platformtools.Log;

public class ScrollableLayout
  extends LinearLayout
{
  private int PQn;
  private int RTt;
  private int RTu;
  public View RYj;
  private int RYk;
  private int RYl;
  private int RYm;
  private int RYn;
  private int RYo;
  private int RYp;
  private ScrollableLayout.a RYq;
  private ScrollableLayout.b RYr;
  private int mActivePointerId;
  private boolean mIsBeingDragged;
  protected Scroller mScroller;
  private int mTouchSlop;
  
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
    AppMethodBeat.i(309282);
    this.mIsBeingDragged = false;
    this.RYk = 0;
    this.RYl = 0;
    this.RYm = 0;
    this.RYn = 0;
    this.mActivePointerId = -1;
    this.RYo = 0;
    this.RYp = 0;
    try
    {
      this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      setOrientation(1);
      this.PQn = paramContext.getResources().getDimensionPixelOffset(b.d.sns_ad_float_web_view_slide_threshold);
      AppMethodBeat.o(309282);
      return;
    }
    finally
    {
      Log.w("ScrollLinearLayout", "the init method has something wrong!");
      AppMethodBeat.o(309282);
    }
  }
  
  private boolean E(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(309284);
    if (paramView == null)
    {
      AppMethodBeat.o(309284);
      return false;
    }
    int i = getScrollY();
    if ((paramInt2 >= paramView.getTop() - i) && (paramInt2 < paramView.getBottom() - i) && (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()))
    {
      AppMethodBeat.o(309284);
      return true;
    }
    AppMethodBeat.o(309284);
    return false;
  }
  
  private void amM(int paramInt)
  {
    AppMethodBeat.i(309289);
    ScrollableLayout.b localb;
    if (paramInt != this.RYp)
    {
      localb = this.RYr;
      if (localb != null) {
        if (getScrollY() < this.RYl) {
          break label68;
        }
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      localb.bI(paramInt, bool);
      Log.i("ScrollLinearLayout", "the new state is ".concat(String.valueOf(paramInt)));
      this.RYp = paramInt;
      AppMethodBeat.o(309289);
      return;
    }
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(309292);
    super.computeScroll();
    try
    {
      if (this.mScroller.computeScrollOffset())
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        invalidate();
        AppMethodBeat.o(309292);
        return;
      }
      if (this.RYp == 2)
      {
        Log.i("ScrollLinearLayout", "compute scroll offset is false the currY is " + this.mScroller.getCurrY() + ", the final Y is " + this.mScroller.getFinalY());
        amM(0);
      }
      AppMethodBeat.o(309292);
      return;
    }
    finally
    {
      Log.w("ScrollLinearLayout", "the compute scroll has something wrong!");
      AppMethodBeat.o(309292);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(309307);
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
            AppMethodBeat.o(309307);
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
          this.RYo = getScrollY();
          if (!E(this.RYj, i, j))
          {
            this.mIsBeingDragged = false;
            Log.i("ScrollLinearLayout", "the onInterceptTouchActionDown is called " + this.mIsBeingDragged + ", mScrollYWhenTouchDown = " + this.RYo);
            bool1 = this.mIsBeingDragged;
            continue;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.RTt = j;
          this.RTu = i;
          bool1 = bool2;
          if (!this.mScroller.isFinished()) {
            bool1 = true;
          }
          this.mIsBeingDragged = bool1;
          if (this.RYk > 0)
          {
            i = this.RYk;
            this.RYm = (this.RYl + i);
            this.RYn = (-i);
            continue;
          }
          i = this.RYl / 3;
        }
      }
      finally
      {
        Log.e("ScrollLinearLayout", "the onInterceptTouchEventInner has something wrong");
        bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(309307);
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
          int k = j - this.RTt;
          int m = getScrollY();
          if (Math.abs(k) >= this.mTouchSlop)
          {
            this.RTt = j;
            this.RTu = i;
            if (((k < 0) && (m <= 0)) || ((k > 0) && (m >= this.RYl))) {
              this.mIsBeingDragged = true;
            }
          }
        }
      }
      Log.i("ScrollLinearLayout", "the onInterceptTouchActionMove is called " + this.mIsBeingDragged);
      bool1 = this.mIsBeingDragged;
      continue;
      this.mIsBeingDragged = false;
      this.mActivePointerId = -1;
      Log.i("ScrollLinearLayout", "the onInterceptTouchActionUpOrCancel is called " + this.mIsBeingDragged);
      bool1 = this.mIsBeingDragged;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    AppMethodBeat.i(309314);
    for (;;)
    {
      try
      {
        i = paramMotionEvent.getActionMasked();
        switch (i)
        {
        default: 
          if (!bool1) {
            continue;
          }
          AppMethodBeat.o(309314);
          return true;
        }
      }
      finally
      {
        Log.e("ScrollLinearLayout", "the onTouchEventInner is called " + this.mIsBeingDragged);
        bool1 = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(309314);
        return bool1;
      }
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (E(this.RYj, i, j))
      {
        bool1 = bool2;
        if (!this.mScroller.isFinished()) {
          bool1 = true;
        }
        this.mIsBeingDragged = bool1;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.RTu = i;
        this.RTt = j;
        this.mActivePointerId = paramMotionEvent.getPointerId(0);
        Log.i("ScrollLinearLayout", "the onTouchActionDown is called " + this.mIsBeingDragged);
        bool1 = this.mIsBeingDragged;
        continue;
        i = paramMotionEvent.findPointerIndex(this.mActivePointerId);
        if (i < 0)
        {
          Log.e("ScrollLinearLayout", "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
        }
        else
        {
          int k = (int)paramMotionEvent.getX(i);
          int m = (int)paramMotionEvent.getY(i);
          j = m - this.RTt;
          i = j;
          if (!this.mIsBeingDragged)
          {
            i = j;
            if (Math.abs(j) >= this.mTouchSlop)
            {
              this.mIsBeingDragged = true;
              if (j <= 0) {
                break label392;
              }
              i = j - this.mTouchSlop;
            }
          }
          j = getScrollY() - i;
          if ((this.mIsBeingDragged) && (this.RYn < j) && (this.RYm > j))
          {
            amM(1);
            scrollBy(0, -i);
            this.RTt = m;
            this.RTu = k;
            break label585;
            label392:
            i = j + this.mTouchSlop;
            continue;
            j = this.RYo;
            k = getScrollY();
            m = k - j;
            if (m > 0)
            {
              i = this.RYl - k;
              if (m < this.PQn) {
                i = -k;
              }
              label445:
              Log.i("ScrollLinearLayout", "the onTouchActionUpOrCancel is called, mScrollYWhenTouchDown = " + j + ", currentScrollY = " + k + ", yDistance = " + i);
              if (!this.mIsBeingDragged) {
                break label573;
              }
              this.mScroller.startScroll(getScrollX(), k, 0, i, 350);
              invalidate();
              amM(2);
            }
            for (bool1 = true;; bool1 = bool3)
            {
              this.mIsBeingDragged = false;
              this.mActivePointerId = -1;
              this.RTt = 0;
              this.RTu = 0;
              break;
              i = -k;
              if (m <= -this.PQn) {
                break label445;
              }
              i = this.RYl - k;
              break label445;
              label573:
              amM(0);
            }
          }
        }
        label585:
        bool1 = true;
      }
    }
  }
  
  public void setDescendantScrollStatusHunter(ScrollableLayout.a parama)
  {
    this.RYq = parama;
  }
  
  public void setMaxOverScrollOffset(int paramInt)
  {
    this.RYk = paramInt;
  }
  
  public void setMaxYScrollOffset(int paramInt)
  {
    this.RYl = paramInt;
  }
  
  public void setOnScrollStatusListener(ScrollableLayout.b paramb)
  {
    this.RYr = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout
 * JD-Core Version:    0.7.0.1
 */