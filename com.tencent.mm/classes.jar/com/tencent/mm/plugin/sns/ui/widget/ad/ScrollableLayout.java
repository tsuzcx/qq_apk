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
import com.tencent.mm.sdk.platformtools.Log;

public class ScrollableLayout
  extends LinearLayout
{
  private int DtN;
  private int Fcb;
  private int Fcc;
  public View Fgd;
  private int Fge;
  private int Fgf;
  private int Fgg;
  private int Fgh;
  private int Fgi;
  private int Fgj;
  private ScrollableLayout.a Fgk;
  private ScrollableLayout.b Fgl;
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
    AppMethodBeat.i(204024);
    this.mIsBeingDragged = false;
    this.Fge = 0;
    this.Fgf = 0;
    this.Fgg = 0;
    this.Fgh = 0;
    this.mActivePointerId = -1;
    this.Fgi = 0;
    this.Fgj = 0;
    try
    {
      this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      setOrientation(1);
      this.DtN = paramContext.getResources().getDimensionPixelOffset(2131166952);
      AppMethodBeat.o(204024);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.w("ScrollLinearLayout", "the init method has something wrong!");
      AppMethodBeat.o(204024);
    }
  }
  
  private void aar(int paramInt)
  {
    AppMethodBeat.i(204029);
    ScrollableLayout.b localb;
    if (paramInt != this.Fgj)
    {
      localb = this.Fgl;
      if (localb != null) {
        if (getScrollY() < this.Fgf) {
          break label68;
        }
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      localb.aS(paramInt, bool);
      Log.i("ScrollLinearLayout", "the new state is ".concat(String.valueOf(paramInt)));
      this.Fgj = paramInt;
      AppMethodBeat.o(204029);
      return;
    }
  }
  
  private boolean x(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204028);
    if (paramView == null)
    {
      AppMethodBeat.o(204028);
      return false;
    }
    int i = getScrollY();
    if ((paramInt2 >= paramView.getTop() - i) && (paramInt2 < paramView.getBottom() - i) && (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()))
    {
      AppMethodBeat.o(204028);
      return true;
    }
    AppMethodBeat.o(204028);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(204025);
    super.computeScroll();
    try
    {
      if (this.mScroller.computeScrollOffset())
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        invalidate();
        AppMethodBeat.o(204025);
        return;
      }
      if (this.Fgj == 2)
      {
        Log.i("ScrollLinearLayout", "compute scroll offset is false the currY is " + this.mScroller.getCurrY() + ", the final Y is " + this.mScroller.getFinalY());
        aar(0);
      }
      AppMethodBeat.o(204025);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("ScrollLinearLayout", "the compute scroll has something wrong!");
      AppMethodBeat.o(204025);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(204026);
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
            AppMethodBeat.o(204026);
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
          this.Fgi = getScrollY();
          if (!x(this.Fgd, i, j))
          {
            this.mIsBeingDragged = false;
            Log.i("ScrollLinearLayout", "the onInterceptTouchActionDown is called " + this.mIsBeingDragged + ", mScrollYWhenTouchDown = " + this.Fgi);
            bool1 = this.mIsBeingDragged;
            continue;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.Fcb = j;
          this.Fcc = i;
          bool1 = bool2;
          if (!this.mScroller.isFinished()) {
            bool1 = true;
          }
          this.mIsBeingDragged = bool1;
          if (this.Fge > 0)
          {
            i = this.Fge;
            this.Fgg = (this.Fgf + i);
            this.Fgh = (-i);
            continue;
          }
          i = this.Fgf / 3;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("ScrollLinearLayout", "the onInterceptTouchEventInner has something wrong");
        bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(204026);
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
          int k = j - this.Fcb;
          int m = getScrollY();
          if (Math.abs(k) >= this.mTouchSlop)
          {
            this.Fcb = j;
            this.Fcc = i;
            if (((k < 0) && (m <= 0)) || ((k > 0) && (m >= this.Fgf))) {
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
    AppMethodBeat.i(204027);
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
          AppMethodBeat.o(204027);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("ScrollLinearLayout", "the onTouchEventInner is called " + this.mIsBeingDragged);
        bool1 = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(204027);
        return bool1;
      }
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (x(this.Fgd, i, j))
      {
        bool1 = bool2;
        if (!this.mScroller.isFinished()) {
          bool1 = true;
        }
        this.mIsBeingDragged = bool1;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.Fcc = i;
        this.Fcb = j;
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
          j = m - this.Fcb;
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
          if ((this.mIsBeingDragged) && (this.Fgh < j) && (this.Fgg > j))
          {
            aar(1);
            scrollBy(0, -i);
            this.Fcb = m;
            this.Fcc = k;
            break label585;
            label392:
            i = j + this.mTouchSlop;
            continue;
            j = this.Fgi;
            k = getScrollY();
            m = k - j;
            if (m > 0)
            {
              i = this.Fgf - k;
              if (m < this.DtN) {
                i = -k;
              }
              label445:
              Log.i("ScrollLinearLayout", "the onTouchActionUpOrCancel is called, mScrollYWhenTouchDown = " + j + ", currentScrollY = " + k + ", yDistance = " + i);
              if (!this.mIsBeingDragged) {
                break label573;
              }
              this.mScroller.startScroll(getScrollX(), k, 0, i, 350);
              invalidate();
              aar(2);
            }
            for (bool1 = true;; bool1 = bool3)
            {
              this.mIsBeingDragged = false;
              this.mActivePointerId = -1;
              this.Fcb = 0;
              this.Fcc = 0;
              break;
              i = -k;
              if (m <= -this.DtN) {
                break label445;
              }
              i = this.Fgf - k;
              break label445;
              label573:
              aar(0);
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
    this.Fgk = parama;
  }
  
  public void setMaxOverScrollOffset(int paramInt)
  {
    this.Fge = paramInt;
  }
  
  public void setMaxYScrollOffset(int paramInt)
  {
    this.Fgf = paramInt;
  }
  
  public void setOnScrollStatusListener(ScrollableLayout.b paramb)
  {
    this.Fgl = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout
 * JD-Core Version:    0.7.0.1
 */