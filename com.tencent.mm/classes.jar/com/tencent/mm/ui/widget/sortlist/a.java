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
  private GestureDetector Nf;
  private int Yiy;
  private int YuA;
  private int YuB;
  private int YuC;
  private int YuD;
  private boolean YuE;
  private float YuF;
  private int YuG;
  private int YuH;
  private int YuI;
  private boolean YuJ;
  private DragSortListView YuK;
  private GestureDetector.OnGestureListener YuL;
  private int Yuu;
  boolean Yuv;
  boolean Yuw;
  private boolean Yux;
  private GestureDetector Yuy;
  private int Yuz;
  private int[] aqv;
  private int mTouchSlop;
  private int pyC;
  private int pyD;
  private int uMk;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    AppMethodBeat.i(159739);
    this.Yuu = 0;
    this.Yuv = true;
    this.Yuw = false;
    this.Yux = false;
    this.Yuz = -1;
    this.YuA = -1;
    this.YuB = -1;
    this.aqv = new int[2];
    this.YuE = false;
    this.YuF = 500.0F;
    this.YuL = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250090);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(250090);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250088);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(250088);
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
            a.c(a.this).cX(paramAnonymousFloat1);
          }
        }
        for (;;)
        {
          a.f(a.this);
          AppMethodBeat.o(159738);
          return false;
          label91:
          if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i)) {
            a.c(a.this).cX(paramAnonymousFloat1);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250087);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(250087);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(250085);
        b localb = new b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(250085);
        return bool;
      }
    };
    this.YuK = paramDragSortListView;
    this.Nf = new GestureDetector(paramDragSortListView.getContext(), this);
    this.Yuy = new GestureDetector(paramDragSortListView.getContext(), this.YuL);
    this.Yuy.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.YuG = paramInt1;
    this.YuH = paramInt4;
    this.YuI = paramInt5;
    this.uMk = paramInt3;
    this.Yuu = paramInt2;
    AppMethodBeat.o(159739);
  }
  
  private boolean bf(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(159740);
    if ((this.Yuv) && (!this.Yux)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.Yuw) && (this.Yux)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.YuK;
        paramInt1 -= this.YuK.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.Yvx)
        {
          if (localDragSortListView.Yvy != null) {
            break label108;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.YuE = bool1;
          bool1 = this.YuE;
          AppMethodBeat.o(159740);
          return bool1;
          label108:
          View localView = localDragSortListView.Yvy.ayX(paramInt1);
          bool1 = bool2;
          if (localView != null) {
            bool1 = localDragSortListView.a(paramInt1, localView, i, paramInt2, paramInt3);
          }
        }
      }
    }
  }
  
  private int l(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(159742);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.YuK.pointToPosition(i, j);
    j = this.YuK.getHeaderViewsCount();
    int k = this.YuK.getFooterViewsCount();
    int m = this.YuK.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      Object localObject = this.YuK;
      localObject = ((DragSortListView)localObject).getChildAt(i - ((DragSortListView)localObject).getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = (MotionEvent)localObject; paramMotionEvent != null; paramMotionEvent = ((View)localObject).findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.aqv);
        if ((k <= this.aqv[0]) || (j <= this.aqv[1]) || (k >= this.aqv[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.aqv[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.YuC = ((View)localObject).getLeft();
        this.YuD = ((View)localObject).getTop();
        AppMethodBeat.o(159742);
        return i;
      }
    }
    AppMethodBeat.o(159742);
    return -1;
  }
  
  public final void m(Point paramPoint)
  {
    if ((this.Yuw) && (this.Yux)) {
      this.Yiy = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    AppMethodBeat.i(159743);
    if ((this.Yuw) && (this.uMk == 0)) {
      this.YuB = l(paramMotionEvent, this.YuH);
    }
    this.Yuz = l(paramMotionEvent, this.YuG);
    if ((this.Yuz != -1) && (this.Yuu == 0)) {
      bf(this.Yuz, (int)paramMotionEvent.getX() - this.YuC, (int)paramMotionEvent.getY() - this.YuD);
    }
    this.Yux = false;
    this.YuJ = true;
    this.Yiy = 0;
    if (this.uMk == 1) {
      i = l(paramMotionEvent, this.YuI);
    }
    this.YuA = i;
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
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
    if ((this.Yuz != -1) && (this.Yuu == 2))
    {
      this.YuK.performHapticFeedback(0);
      bf(this.Yuz, this.pyC - this.YuC, this.pyD - this.YuD);
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
    int n = k - this.YuC;
    int i1 = m - this.YuD;
    if ((this.YuJ) && (!this.YuE) && ((this.Yuz != -1) || (this.YuA != -1)))
    {
      if (this.Yuz == -1) {
        break label191;
      }
      if ((this.Yuu != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.Yuv)) {
        break label141;
      }
      bf(this.Yuz, n, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(159744);
      return false;
      label141:
      if ((this.Yuu != 0) && (Math.abs(k - i) > this.mTouchSlop) && (this.Yuw))
      {
        this.Yux = true;
        bf(this.YuA, n, i1);
        continue;
        label191:
        if (this.YuA != -1) {
          if ((Math.abs(k - i) > this.mTouchSlop) && (this.Yuw))
          {
            this.Yux = true;
            bf(this.YuA, n, i1);
          }
          else if (Math.abs(m - j) > this.mTouchSlop)
          {
            this.YuJ = false;
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
    localb.bn(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
    if ((this.Yuw) && (this.uMk == 0) && (this.YuB != -1)) {
      this.YuK.removeItem(this.YuB - this.YuK.getHeaderViewsCount());
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(159746);
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159741);
    if ((!this.YuK.Yvd) || (this.YuK.YvN))
    {
      AppMethodBeat.o(159741);
      return false;
    }
    paramView = this.Nf;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aFh(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((this.Yuw) && (this.YuE) && (this.uMk == 1))
    {
      paramView = this.Yuy;
      locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b(paramView, locala.aFh(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(159741);
      return false;
      this.pyC = ((int)paramMotionEvent.getX());
      this.pyD = ((int)paramMotionEvent.getY());
      continue;
      if ((this.Yuw) && (this.Yux))
      {
        if (this.Yiy >= 0) {}
        for (int i = this.Yiy; i > this.YuK.getWidth() / 2; i = -this.Yiy)
        {
          this.YuK.cX(0.0F);
          break;
        }
        this.Yux = false;
        this.YuE = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */