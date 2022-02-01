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
  private int[] AM;
  private int LAa;
  private int LAb;
  private int LAc;
  private int LAd;
  private boolean LAe;
  private float LAf;
  private int LAg;
  private int LAh;
  private int LAi;
  private boolean LAj;
  private DragSortListView LAk;
  private int LAl;
  private GestureDetector.OnGestureListener LAm;
  private int LzU;
  boolean LzV;
  boolean LzW;
  private boolean LzX;
  private GestureDetector LzY;
  private int LzZ;
  private GestureDetector PC;
  private int ltG;
  private int ltH;
  private int mTouchSlop;
  private int pSb;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    AppMethodBeat.i(159739);
    this.LzU = 0;
    this.LzV = true;
    this.LzW = false;
    this.LzX = false;
    this.LzZ = -1;
    this.LAa = -1;
    this.LAb = -1;
    this.AM = new int[2];
    this.LAe = false;
    this.LAf = 500.0F;
    this.LAm = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(200583);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(200583);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(200582);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(200582);
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
            a.c(a.this).bY(paramAnonymousFloat1);
          }
        }
        for (;;)
        {
          a.f(a.this);
          AppMethodBeat.o(159738);
          return false;
          label91:
          if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i)) {
            a.c(a.this).bY(paramAnonymousFloat1);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(200581);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(200581);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(200580);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(200580);
        return bool;
      }
    };
    this.LAk = paramDragSortListView;
    this.PC = new GestureDetector(paramDragSortListView.getContext(), this);
    this.LzY = new GestureDetector(paramDragSortListView.getContext(), this.LAm);
    this.LzY.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.LAg = paramInt1;
    this.LAh = paramInt4;
    this.LAi = paramInt5;
    this.pSb = paramInt3;
    this.LzU = paramInt2;
    AppMethodBeat.o(159739);
  }
  
  private boolean aU(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(159740);
    if ((this.LzV) && (!this.LzX)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.LzW) && (this.LzX)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.LAk;
        paramInt1 -= this.LAk.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.LAZ)
        {
          if (localDragSortListView.LBa != null) {
            break label108;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.LAe = bool1;
          bool1 = this.LAe;
          AppMethodBeat.o(159740);
          return bool1;
          label108:
          View localView = localDragSortListView.LBa.agw(paramInt1);
          bool1 = bool2;
          if (localView != null) {
            bool1 = localDragSortListView.a(paramInt1, localView, i, paramInt2, paramInt3);
          }
        }
      }
    }
  }
  
  private int f(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(159742);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    i = this.LAk.pointToPosition(i, j);
    j = this.LAk.getHeaderViewsCount();
    int k = this.LAk.getFooterViewsCount();
    int m = this.LAk.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      Object localObject = this.LAk;
      localObject = ((DragSortListView)localObject).getChildAt(i - ((DragSortListView)localObject).getFirstVisiblePosition());
      k = (int)paramMotionEvent.getRawX();
      j = (int)paramMotionEvent.getRawY();
      if (paramInt == 0) {}
      for (paramMotionEvent = (MotionEvent)localObject; paramMotionEvent != null; paramMotionEvent = ((View)localObject).findViewById(paramInt))
      {
        paramMotionEvent.getLocationOnScreen(this.AM);
        if ((k <= this.AM[0]) || (j <= this.AM[1]) || (k >= this.AM[0] + paramMotionEvent.getWidth())) {
          break;
        }
        paramInt = this.AM[1];
        if (j >= paramMotionEvent.getHeight() + paramInt) {
          break;
        }
        this.LAc = ((View)localObject).getLeft();
        this.LAd = ((View)localObject).getTop();
        AppMethodBeat.o(159742);
        return i;
      }
    }
    AppMethodBeat.o(159742);
    return -1;
  }
  
  public final void k(Point paramPoint)
  {
    if ((this.LzW) && (this.LzX)) {
      this.LAl = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    AppMethodBeat.i(159743);
    if ((this.LzW) && (this.pSb == 0)) {
      this.LAb = f(paramMotionEvent, this.LAh);
    }
    this.LzZ = f(paramMotionEvent, this.LAg);
    if ((this.LzZ != -1) && (this.LzU == 0)) {
      aU(this.LzZ, (int)paramMotionEvent.getX() - this.LAc, (int)paramMotionEvent.getY() - this.LAd);
    }
    this.LzX = false;
    this.LAj = true;
    this.LAl = 0;
    if (this.pSb == 1) {
      i = f(paramMotionEvent, this.LAi);
    }
    this.LAa = i;
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
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
    if ((this.LzZ != -1) && (this.LzU == 2))
    {
      this.LAk.performHapticFeedback(0);
      aU(this.LzZ, this.ltG - this.LAc, this.ltH - this.LAd);
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
    int n = k - this.LAc;
    int i1 = m - this.LAd;
    if ((this.LAj) && (!this.LAe) && ((this.LzZ != -1) || (this.LAa != -1)))
    {
      if (this.LzZ == -1) {
        break label191;
      }
      if ((this.LzU != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.LzV)) {
        break label141;
      }
      aU(this.LzZ, n, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(159744);
      return false;
      label141:
      if ((this.LzU != 0) && (Math.abs(k - i) > this.mTouchSlop) && (this.LzW))
      {
        this.LzX = true;
        aU(this.LAa, n, i1);
        continue;
        label191:
        if (this.LAa != -1) {
          if ((Math.abs(k - i) > this.mTouchSlop) && (this.LzW))
          {
            this.LzX = true;
            aU(this.LAa, n, i1);
          }
          else if (Math.abs(m - j) > this.mTouchSlop)
          {
            this.LAj = false;
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
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
    if ((this.LzW) && (this.pSb == 0) && (this.LAb != -1)) {
      this.LAk.removeItem(this.LAb - this.LAk.getHeaderViewsCount());
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(159746);
    return true;
  }
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(159741);
    Object localObject = new b();
    ((b)localObject).bd(paramView);
    ((b)localObject).bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject).ahF());
    if ((!this.LAk.LAE) || (this.LAk.LBp))
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(159741);
      return false;
    }
    paramView = this.PC;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((this.LzW) && (this.LAe) && (this.pSb == 1))
    {
      paramView = this.LzY;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(159741);
      return false;
      this.ltG = ((int)paramMotionEvent.getX());
      this.ltH = ((int)paramMotionEvent.getY());
      continue;
      if ((this.LzW) && (this.LzX))
      {
        if (this.LAl >= 0) {}
        for (int i = this.LAl; i > this.LAk.getWidth() / 2; i = -this.LAl)
        {
          this.LAk.bY(0.0F);
          break;
        }
        this.LzX = false;
        this.LAe = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */