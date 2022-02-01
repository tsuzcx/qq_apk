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
  private int LdA;
  private int LdB;
  private int LdC;
  private boolean LdD;
  private float LdE;
  private int LdF;
  private int LdG;
  private int LdH;
  private boolean LdI;
  private DragSortListView LdJ;
  private int LdK;
  private GestureDetector.OnGestureListener LdL;
  private int Ldt;
  boolean Ldu;
  boolean Ldv;
  private boolean Ldw;
  private GestureDetector Ldx;
  private int Ldy;
  private int Ldz;
  private GestureDetector PC;
  private int lpj;
  private int lpk;
  private int mTouchSlop;
  private int pLw;
  
  public a(DragSortListView paramDragSortListView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    super(paramDragSortListView);
    AppMethodBeat.i(159739);
    this.Ldt = 0;
    this.Ldu = true;
    this.Ldv = false;
    this.Ldw = false;
    this.Ldy = -1;
    this.Ldz = -1;
    this.LdA = -1;
    this.AM = new int[2];
    this.LdD = false;
    this.LdE = 500.0F;
    this.LdL = new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(192810);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(192810);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(192809);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(192809);
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
            a.c(a.this).ca(paramAnonymousFloat1);
          }
        }
        for (;;)
        {
          a.f(a.this);
          AppMethodBeat.o(159738);
          return false;
          label91:
          if ((paramAnonymousFloat1 < -a.d(a.this)) && (a.e(a.this) < i)) {
            a.c(a.this).ca(paramAnonymousFloat1);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(192808);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(192808);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(192807);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/widget/sortlist/DragSortController$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(192807);
        return bool;
      }
    };
    this.LdJ = paramDragSortListView;
    this.PC = new GestureDetector(paramDragSortListView.getContext(), this);
    this.Ldx = new GestureDetector(paramDragSortListView.getContext(), this.LdL);
    this.Ldx.setIsLongpressEnabled(false);
    this.mTouchSlop = ViewConfiguration.get(paramDragSortListView.getContext()).getScaledTouchSlop();
    this.LdF = paramInt1;
    this.LdG = paramInt4;
    this.LdH = paramInt5;
    this.pLw = paramInt3;
    this.Ldt = paramInt2;
    AppMethodBeat.o(159739);
  }
  
  private boolean aT(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    AppMethodBeat.i(159740);
    if ((this.Ldu) && (!this.Ldw)) {}
    for (int i = 12;; i = 0)
    {
      if ((this.Ldv) && (this.Ldw)) {
        i = i | 0x1 | 0x2;
      }
      for (;;)
      {
        DragSortListView localDragSortListView = this.LdJ;
        paramInt1 -= this.LdJ.getHeaderViewsCount();
        boolean bool1 = bool2;
        if (localDragSortListView.Lex)
        {
          if (localDragSortListView.Ley != null) {
            break label108;
          }
          bool1 = bool2;
        }
        for (;;)
        {
          this.LdD = bool1;
          bool1 = this.LdD;
          AppMethodBeat.o(159740);
          return bool1;
          label108:
          View localView = localDragSortListView.Ley.afN(paramInt1);
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
    i = this.LdJ.pointToPosition(i, j);
    j = this.LdJ.getHeaderViewsCount();
    int k = this.LdJ.getFooterViewsCount();
    int m = this.LdJ.getCount();
    if ((i != -1) && (i >= j) && (i < m - k))
    {
      Object localObject = this.LdJ;
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
        this.LdB = ((View)localObject).getLeft();
        this.LdC = ((View)localObject).getTop();
        AppMethodBeat.o(159742);
        return i;
      }
    }
    AppMethodBeat.o(159742);
    return -1;
  }
  
  public final void j(Point paramPoint)
  {
    if ((this.Ldv) && (this.Ldw)) {
      this.LdK = paramPoint.x;
    }
  }
  
  public final boolean onDown(MotionEvent paramMotionEvent)
  {
    int i = -1;
    AppMethodBeat.i(159743);
    if ((this.Ldv) && (this.pLw == 0)) {
      this.LdA = f(paramMotionEvent, this.LdG);
    }
    this.Ldy = f(paramMotionEvent, this.LdF);
    if ((this.Ldy != -1) && (this.Ldt == 0)) {
      aT(this.Ldy, (int)paramMotionEvent.getX() - this.LdB, (int)paramMotionEvent.getY() - this.LdC);
    }
    this.Ldw = false;
    this.LdI = true;
    this.LdK = 0;
    if (this.pLw == 1) {
      i = f(paramMotionEvent, this.LdH);
    }
    this.Ldz = i;
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
    if ((this.Ldy != -1) && (this.Ldt == 2))
    {
      this.LdJ.performHapticFeedback(0);
      aT(this.Ldy, this.lpj - this.LdB, this.lpk - this.LdC);
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
    int n = k - this.LdB;
    int i1 = m - this.LdC;
    if ((this.LdI) && (!this.LdD) && ((this.Ldy != -1) || (this.Ldz != -1)))
    {
      if (this.Ldy == -1) {
        break label191;
      }
      if ((this.Ldt != 1) || (Math.abs(m - j) <= this.mTouchSlop) || (!this.Ldu)) {
        break label141;
      }
      aT(this.Ldy, n, i1);
    }
    for (;;)
    {
      AppMethodBeat.o(159744);
      return false;
      label141:
      if ((this.Ldt != 0) && (Math.abs(k - i) > this.mTouchSlop) && (this.Ldv))
      {
        this.Ldw = true;
        aT(this.Ldz, n, i1);
        continue;
        label191:
        if (this.Ldz != -1) {
          if ((Math.abs(k - i) > this.mTouchSlop) && (this.Ldv))
          {
            this.Ldw = true;
            aT(this.Ldz, n, i1);
          }
          else if (Math.abs(m - j) > this.mTouchSlop)
          {
            this.LdI = false;
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
    if ((this.Ldv) && (this.pLw == 0) && (this.LdA != -1)) {
      this.LdJ.removeItem(this.LdA - this.LdJ.getHeaderViewsCount());
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject).ahq());
    if ((!this.LdJ.Led) || (this.LdJ.LeN))
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(159741);
      return false;
    }
    paramView = this.PC;
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    if ((this.Ldv) && (this.LdD) && (this.pLw == 1))
    {
      paramView = this.Ldx;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      com.tencent.mm.hellhoundlib.a.a.a(paramView, paramView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)), "com/tencent/mm/ui/widget/sortlist/DragSortController", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    }
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/sortlist/DragSortController", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(159741);
      return false;
      this.lpj = ((int)paramMotionEvent.getX());
      this.lpk = ((int)paramMotionEvent.getY());
      continue;
      if ((this.Ldv) && (this.Ldw))
      {
        if (this.LdK >= 0) {}
        for (int i = this.LdK; i > this.LdJ.getWidth() / 2; i = -this.LdK)
        {
          this.LdJ.ca(0.0F);
          break;
        }
        this.Ldw = false;
        this.LdD = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.a
 * JD-Core Version:    0.7.0.1
 */