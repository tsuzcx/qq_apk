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
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.sdk.platformtools.Log;

public class ScrollableLayout
  extends LinearLayout
{
  private int JAF;
  private int LqA;
  private int Lqz;
  public View LuI;
  private int LuJ;
  private int LuK;
  private int LuL;
  private int LuM;
  private int LuN;
  private int LuO;
  private ScrollableLayout.a LuP;
  private ScrollableLayout.b LuQ;
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
    AppMethodBeat.i(253743);
    this.mIsBeingDragged = false;
    this.LuJ = 0;
    this.LuK = 0;
    this.LuL = 0;
    this.LuM = 0;
    this.mActivePointerId = -1;
    this.LuN = 0;
    this.LuO = 0;
    try
    {
      this.mScroller = new Scroller(paramContext, new DecelerateInterpolator());
      this.mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      setOrientation(1);
      this.JAF = paramContext.getResources().getDimensionPixelOffset(i.d.sns_ad_float_web_view_slide_threshold);
      AppMethodBeat.o(253743);
      return;
    }
    catch (Throwable paramContext)
    {
      Log.w("ScrollLinearLayout", "the init method has something wrong!");
      AppMethodBeat.o(253743);
    }
  }
  
  private void ahL(int paramInt)
  {
    AppMethodBeat.i(253753);
    ScrollableLayout.b localb;
    if (paramInt != this.LuO)
    {
      localb = this.LuQ;
      if (localb != null) {
        if (getScrollY() < this.LuK) {
          break label68;
        }
      }
    }
    label68:
    for (boolean bool = true;; bool = false)
    {
      localb.bb(paramInt, bool);
      Log.i("ScrollLinearLayout", "the new state is ".concat(String.valueOf(paramInt)));
      this.LuO = paramInt;
      AppMethodBeat.o(253753);
      return;
    }
  }
  
  private boolean z(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253752);
    if (paramView == null)
    {
      AppMethodBeat.o(253752);
      return false;
    }
    int i = getScrollY();
    if ((paramInt2 >= paramView.getTop() - i) && (paramInt2 < paramView.getBottom() - i) && (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()))
    {
      AppMethodBeat.o(253752);
      return true;
    }
    AppMethodBeat.o(253752);
    return false;
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(253744);
    super.computeScroll();
    try
    {
      if (this.mScroller.computeScrollOffset())
      {
        scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
        invalidate();
        AppMethodBeat.o(253744);
        return;
      }
      if (this.LuO == 2)
      {
        Log.i("ScrollLinearLayout", "compute scroll offset is false the currY is " + this.mScroller.getCurrY() + ", the final Y is " + this.mScroller.getFinalY());
        ahL(0);
      }
      AppMethodBeat.o(253744);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.w("ScrollLinearLayout", "the compute scroll has something wrong!");
      AppMethodBeat.o(253744);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    AppMethodBeat.i(253748);
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
            AppMethodBeat.o(253748);
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
          this.LuN = getScrollY();
          if (!z(this.LuI, i, j))
          {
            this.mIsBeingDragged = false;
            Log.i("ScrollLinearLayout", "the onInterceptTouchActionDown is called " + this.mIsBeingDragged + ", mScrollYWhenTouchDown = " + this.LuN);
            bool1 = this.mIsBeingDragged;
            continue;
          }
          this.mActivePointerId = paramMotionEvent.getPointerId(0);
          this.Lqz = j;
          this.LqA = i;
          bool1 = bool2;
          if (!this.mScroller.isFinished()) {
            bool1 = true;
          }
          this.mIsBeingDragged = bool1;
          if (this.LuJ > 0)
          {
            i = this.LuJ;
            this.LuL = (this.LuK + i);
            this.LuM = (-i);
            continue;
          }
          i = this.LuK / 3;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("ScrollLinearLayout", "the onInterceptTouchEventInner has something wrong");
        bool1 = super.onInterceptTouchEvent(paramMotionEvent);
        AppMethodBeat.o(253748);
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
          int k = j - this.Lqz;
          int m = getScrollY();
          if (Math.abs(k) >= this.mTouchSlop)
          {
            this.Lqz = j;
            this.LqA = i;
            if (((k < 0) && (m <= 0)) || ((k > 0) && (m >= this.LuK))) {
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
    AppMethodBeat.i(253750);
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
          AppMethodBeat.o(253750);
          return true;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("ScrollLinearLayout", "the onTouchEventInner is called " + this.mIsBeingDragged);
        bool1 = super.onTouchEvent(paramMotionEvent);
        AppMethodBeat.o(253750);
        return bool1;
      }
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if (z(this.LuI, i, j))
      {
        bool1 = bool2;
        if (!this.mScroller.isFinished()) {
          bool1 = true;
        }
        this.mIsBeingDragged = bool1;
        if (!this.mScroller.isFinished()) {
          this.mScroller.abortAnimation();
        }
        this.LqA = i;
        this.Lqz = j;
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
          j = m - this.Lqz;
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
          if ((this.mIsBeingDragged) && (this.LuM < j) && (this.LuL > j))
          {
            ahL(1);
            scrollBy(0, -i);
            this.Lqz = m;
            this.LqA = k;
            break label585;
            label392:
            i = j + this.mTouchSlop;
            continue;
            j = this.LuN;
            k = getScrollY();
            m = k - j;
            if (m > 0)
            {
              i = this.LuK - k;
              if (m < this.JAF) {
                i = -k;
              }
              label445:
              Log.i("ScrollLinearLayout", "the onTouchActionUpOrCancel is called, mScrollYWhenTouchDown = " + j + ", currentScrollY = " + k + ", yDistance = " + i);
              if (!this.mIsBeingDragged) {
                break label573;
              }
              this.mScroller.startScroll(getScrollX(), k, 0, i, 350);
              invalidate();
              ahL(2);
            }
            for (bool1 = true;; bool1 = bool3)
            {
              this.mIsBeingDragged = false;
              this.mActivePointerId = -1;
              this.Lqz = 0;
              this.LqA = 0;
              break;
              i = -k;
              if (m <= -this.JAF) {
                break label445;
              }
              i = this.LuK - k;
              break label445;
              label573:
              ahL(0);
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
    this.LuP = parama;
  }
  
  public void setMaxOverScrollOffset(int paramInt)
  {
    this.LuJ = paramInt;
  }
  
  public void setMaxYScrollOffset(int paramInt)
  {
    this.LuK = paramInt;
  }
  
  public void setOnScrollStatusListener(ScrollableLayout.b paramb)
  {
    this.LuQ = paramb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.widget.ad.ScrollableLayout
 * JD-Core Version:    0.7.0.1
 */