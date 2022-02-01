package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public final class a
  extends d
  implements GestureDetector.OnGestureListener, View.OnTouchListener
{
  private int agay;
  private int agmN;
  boolean agmO;
  boolean agmP;
  private boolean agmQ;
  private GestureDetector agmR;
  private int agmS;
  private int agmT;
  private int agmU;
  private int agmV;
  private int agmW;
  private boolean agmX;
  private float agmY;
  private int agmZ;
  private int agna;
  private int agnb;
  private boolean agnc;
  private DragSortListView agnd;
  private GestureDetector.OnGestureListener agne;
  private GestureDetector bth;
  private int[] cfd;
  private int mTouchSlop;
  private int sDH;
  private int sDI;
  private int xUM;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    AppMethodBeat.i(159739);
    this.agmN = 0;
    this.agmO = true;
    this.agmP = false;
    this.agmQ = false;
    this.agmS = -1;
    this.agmT = -1;
    this.agmU = -1;
    this.cfd = new int[2];
    this.agmX = false;
    this.agmY = 500.0F;
    this.agne = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(252727);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(252727);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(252725);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(252725);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(159738);
        int i;
        if ((a.a(a.this)) && (a.b(a.this)))
        {
          i = a.c(a.this).getWidth() / 5;
          if (paramAnonymousFloat1 <= a.d(a.this)) {
            break label91;
          }
          if (a.e(a.this) > -i) {
            a.c(a.this).el(paramAnonymousFloat1);
          }
        }
        for (;;)
        {
          a.f(a.this);
          AppMethodBeat.o(159738);
          return false;
          label91:
          if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i)) {
            a.c(a.this).el(paramAnonymousFloat1);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(252723);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(252723);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(252721);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(252721);
        return bool;
      }
    };
    this.agnd = paramDragSortListView;
    this.bth = new GestureDetector(paramDragSortListView.getContext(), this);
    this.agmR = new GestureDetector(paramDragSortListView.getContext(), this.agne);
    this.agmR.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.agmZ = paramInt1;
    this.agna = paramInt4;
    this.agnb = paramInt5;
    this.xUM = paramInt3;
    this.agmN = paramInt2;
    AppMethodBeat.o(159739);
  }
  
  private boolean bG(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(159740);
    if ((this.agmO) && (!this.agmQ)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.agmP) && (this.agmQ)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.agnd;
        paramInt1 -= this.agnd.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.agnP)
        {
          if (localDragSortListView.agnQ != null) {
            break label108;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.agmX = bool1;
          bool1 = this.agmX;
          AppMethodBeat.o(159740);
          return bool1;
          label108:
          View localView = localDragSortListView.agnQ.aFC(paramInt1);
          bool1 = bool2;
          if (localView != null) {
            bool1 = localDragSortListView.a(paramInt1, localView, i, paramInt2, paramInt3);
          }
        }
      }
    }
  }
  
  private int m(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(159742);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.agnd.pointToPosition(i, j);
    j = this.agnd.getHeaderViewsCount();
    int k = this.agnd.getFooterViewsCount();
    int m = this.agnd.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      Object localObject = this.agnd;
      localObject = ((DragSortListView)localObject).getChildAt(i - ((DragSortListView)localObject).getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = (MotionEvent)localObject; paramMotionEvent != null; paramMotionEvent = ((View)localObject).findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.cfd);
        if ((k <= this.cfd[0]) || (j <= this.cfd[1]) || (k >= this.cfd[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.cfd[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.agmV = ((View)localObject).getLeft();
        this.agmW = ((View)localObject).getTop();
        AppMethodBeat.o(159742);
        return i;
      }
    }
    AppMethodBeat.o(159742);
    return -1;
  }
  
  public final void o(Point paramPoint)
  {
    if ((this.agmP) && (this.agmQ)) {
      this.agay = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    AppMethodBeat.i(159743);
    if ((this.agmP) && (this.xUM == 0)) {
      this.agmU = m(paramMotionEvent, this.agna);
    }
    this.agmS = m(paramMotionEvent, this.agmZ);
    if ((this.agmS != -1) && (this.agmN == 0)) {
      bG(this.agmS, (int)paramMotionEvent.getX() - this.agmV, (int)paramMotionEvent.getY() - this.agmW);
    }
    this.agmQ = false;
    this.agnc = true;
    this.agay = 0;
    if (this.xUM == 1) {
      i = m(paramMotionEvent, this.agnb);
    }
    this.agmT = i;
    AppMethodBeat.o(159743);
    return true;
  }
  
  public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public final void onLongPress(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159745);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
    if ((this.agmS != -1) && (this.agmN == 2))
    {
      this.agnd.performHapticFeedback(0);
      bG(this.agmS, this.sDH - this.agmV, this.sDI - this.agmW);
    }
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
    AppMethodBeat.o(159745);
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(159744);
    int i = (int)paramMotionEvent1.getX();
    int j = (int)paramMotionEvent1.getY();
    int k = (int)paramMotionEvent2.getX();
    int m = (int)paramMotionEvent2.getY();
    int n = k - this.agmV;
    int i1 = m - this.agmW;
    if ((this.agnc) && (!this.agmX) && ((this.agmS != -1) || (this.agmT != -1)))
    {
      if (this.agmS == -1) {
        break label191;
      }
      if ((this.agmN != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.agmO)) {
        break label141;
      }
      bG(this.agmS, n, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(159744);
      return false;
      label141:
      if ((this.agmN != 0) && (Math.abs(k - i) > this.mTouchSlop) && (this.agmP))
      {
        this.agmQ = true;
        bG(this.agmT, n, i1);
        continue;
        label191:
        if (this.agmT != -1) {
          if ((Math.abs(k - i) > this.mTouchSlop) && (this.agmP))
          {
            this.agmQ = true;
            bG(this.agmT, n, i1);
          }
          else if (Math.abs(m - j) > this.mTouchSlop)
          {
            this.agnc = false;
          }
        }
      }
    }
  }
  
  public final void onShowPress(MotionEvent paramMotionEvent) {}
  
  public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159746);
    b localb = new b();
    localb.cH(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
    if ((this.agmP) && (this.xUM == 0) && (this.agmU != -1)) {
      this.agnd.removeItem(this.agmU - this.agnd.getHeaderViewsCount());
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(159746);
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159741);
    if ((!this.agnd.agnv) || (this.agnd.agof))
    {
      AppMethodBeat.o(159741);
      return false;
    }
    paramView = this.bth;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((this.agmP) && (this.agmX) && (this.xUM == 1))
    {
      paramView = this.agmR;
      locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aYi(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(159741);
      return false;
      this.sDH = ((int)paramMotionEvent.getX());
      this.sDI = ((int)paramMotionEvent.getY());
      continue;
      if ((this.agmP) && (this.agmQ))
      {
        if (this.agay >= 0) {}
        for (int i = this.agay; i > this.agnd.getWidth() / 2; i = -this.agay)
        {
          this.agnd.el(0.0F);
          break;
        }
        this.agmQ = false;
        this.agmX = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */