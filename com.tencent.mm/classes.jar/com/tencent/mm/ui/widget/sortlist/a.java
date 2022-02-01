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
  private int[] AS;
  private GestureDetector PO;
  private int QJI;
  private int QVK;
  boolean QVL;
  boolean QVM;
  private boolean QVN;
  private GestureDetector QVO;
  private int QVP;
  private int QVQ;
  private int QVR;
  private int QVS;
  private int QVT;
  private boolean QVU;
  private float QVV;
  private int QVW;
  private int QVX;
  private int QVY;
  private boolean QVZ;
  private DragSortListView QWa;
  private GestureDetector.OnGestureListener QWb;
  private int mAh;
  private int mAi;
  private int mTouchSlop;
  private int rjb;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    AppMethodBeat.i(159739);
    this.QVK = 0;
    this.QVL = true;
    this.QVM = false;
    this.QVN = false;
    this.QVP = -1;
    this.QVQ = -1;
    this.QVR = -1;
    this.AS = new int[2];
    this.QVU = false;
    this.QVV = 500.0F;
    this.QWb = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198541);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198541);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198540);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198540);
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
            a.c(a.this).cC(paramAnonymousFloat1);
          }
        }
        for (;;)
        {
          a.f(a.this);
          AppMethodBeat.o(159738);
          return false;
          label91:
          if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i)) {
            a.c(a.this).cC(paramAnonymousFloat1);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198539);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(198539);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198538);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(198538);
        return bool;
      }
    };
    this.QWa = paramDragSortListView;
    this.PO = new GestureDetector(paramDragSortListView.getContext(), this);
    this.QVO = new GestureDetector(paramDragSortListView.getContext(), this.QWb);
    this.QVO.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.QVW = paramInt1;
    this.QVX = paramInt4;
    this.QVY = paramInt5;
    this.rjb = paramInt3;
    this.QVK = paramInt2;
    AppMethodBeat.o(159739);
  }
  
  private boolean bb(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(159740);
    if ((this.QVL) && (!this.QVN)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.QVM) && (this.QVN)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.QWa;
        paramInt1 -= this.QWa.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.QWN)
        {
          if (localDragSortListView.QWO != null) {
            break label108;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.QVU = bool1;
          bool1 = this.QVU;
          AppMethodBeat.o(159740);
          return bool1;
          label108:
          View localView = localDragSortListView.QWO.apz(paramInt1);
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
    i = this.QWa.pointToPosition(i, j);
    j = this.QWa.getHeaderViewsCount();
    int k = this.QWa.getFooterViewsCount();
    int m = this.QWa.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      Object localObject = this.QWa;
      localObject = ((DragSortListView)localObject).getChildAt(i - ((DragSortListView)localObject).getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = (MotionEvent)localObject; paramMotionEvent != null; paramMotionEvent = ((View)localObject).findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.AS);
        if ((k <= this.AS[0]) || (j <= this.AS[1]) || (k >= this.AS[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.AS[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.QVS = ((View)localObject).getLeft();
        this.QVT = ((View)localObject).getTop();
        AppMethodBeat.o(159742);
        return i;
      }
    }
    AppMethodBeat.o(159742);
    return -1;
  }
  
  public final void n(Point paramPoint)
  {
    if ((this.QVM) && (this.QVN)) {
      this.QJI = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    AppMethodBeat.i(159743);
    if ((this.QVM) && (this.rjb == 0)) {
      this.QVR = l(paramMotionEvent, this.QVX);
    }
    this.QVP = l(paramMotionEvent, this.QVW);
    if ((this.QVP != -1) && (this.QVK == 0)) {
      bb(this.QVP, (int)paramMotionEvent.getX() - this.QVS, (int)paramMotionEvent.getY() - this.QVT);
    }
    this.QVN = false;
    this.QVZ = true;
    this.QJI = 0;
    if (this.rjb == 1) {
      i = l(paramMotionEvent, this.QVY);
    }
    this.QVQ = i;
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
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
    if ((this.QVP != -1) && (this.QVK == 2))
    {
      this.QWa.performHapticFeedback(0);
      bb(this.QVP, this.mAh - this.QVS, this.mAi - this.QVT);
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
    int n = k - this.QVS;
    int i1 = m - this.QVT;
    if ((this.QVZ) && (!this.QVU) && ((this.QVP != -1) || (this.QVQ != -1)))
    {
      if (this.QVP == -1) {
        break label191;
      }
      if ((this.QVK != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.QVL)) {
        break label141;
      }
      bb(this.QVP, n, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(159744);
      return false;
      label141:
      if ((this.QVK != 0) && (Math.abs(k - i) > this.mTouchSlop) && (this.QVM))
      {
        this.QVN = true;
        bb(this.QVQ, n, i1);
        continue;
        label191:
        if (this.QVQ != -1) {
          if ((Math.abs(k - i) > this.mTouchSlop) && (this.QVM))
          {
            this.QVN = true;
            bb(this.QVQ, n, i1);
          }
          else if (Math.abs(m - j) > this.mTouchSlop)
          {
            this.QVZ = false;
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
    localb.bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
    if ((this.QVM) && (this.rjb == 0) && (this.QVR != -1)) {
      this.QWa.removeItem(this.QVR - this.QWa.getHeaderViewsCount());
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(159746);
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159741);
    if ((!this.QWa.QWt) || (this.QWa.QXd))
    {
      AppMethodBeat.o(159741);
      return false;
    }
    paramView = this.PO;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, locala.axQ(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((this.QVM) && (this.QVU) && (this.rjb == 1))
    {
      paramView = this.QVO;
      locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, locala.axQ(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(159741);
      return false;
      this.mAh = ((int)paramMotionEvent.getX());
      this.mAi = ((int)paramMotionEvent.getY());
      continue;
      if ((this.QVM) && (this.QVN))
      {
        if (this.QJI >= 0) {}
        for (int i = this.QJI; i > this.QWa.getWidth() / 2; i = -this.QJI)
        {
          this.QWa.cC(0.0F);
          break;
        }
        this.QVN = false;
        this.QVU = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */