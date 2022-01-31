package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DragSortListView$k
  extends DragSortListView.m
{
  private float AMA;
  private float AMB;
  private float AMC;
  private int AMD = -1;
  private int AME = -1;
  private int AMF;
  private int eiY;
  
  private DragSortListView$k(DragSortListView paramDragSortListView, int paramInt)
  {
    super(paramDragSortListView, paramInt, (byte)0);
  }
  
  public final void bB(float paramFloat)
  {
    AppMethodBeat.i(113056);
    paramFloat = 1.0F - paramFloat;
    int j = this.AMh.getFirstVisiblePosition();
    View localView = this.AMh.getChildAt(this.eiY - j);
    Object localObject;
    int i;
    if (DragSortListView.n(this.AMh))
    {
      float f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / 1000.0F;
      if (f1 == 0.0F)
      {
        AppMethodBeat.o(113056);
        return;
      }
      float f2 = DragSortListView.o(this.AMh);
      int k = this.AMh.getWidth();
      localObject = this.AMh;
      float f3 = DragSortListView.o(this.AMh);
      if (DragSortListView.o(this.AMh) > 0.0F) {}
      for (i = 1;; i = -1)
      {
        DragSortListView.a((DragSortListView)localObject, i * f1 * k + f3);
        this.AMA += f2 * f1;
        DragSortListView.d(this.AMh).x = ((int)this.AMA);
        if ((this.AMA >= k) || (this.AMA <= -k)) {
          break;
        }
        this.mStartTime = SystemClock.uptimeMillis();
        DragSortListView.f(this.AMh);
        AppMethodBeat.o(113056);
        return;
      }
    }
    if (localView != null)
    {
      if (this.AMD == -1)
      {
        this.AMD = DragSortListView.b(this.AMh, this.eiY, localView);
        this.AMB = (localView.getHeight() - this.AMD);
      }
      i = Math.max((int)(this.AMB * paramFloat), 1);
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (i + this.AMD);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (this.AMF != this.eiY)
    {
      localView = this.AMh.getChildAt(this.AMF - j);
      if (localView != null)
      {
        if (this.AME == -1)
        {
          this.AME = DragSortListView.b(this.AMh, this.AMF, localView);
          this.AMC = (localView.getHeight() - this.AME);
        }
        i = Math.max((int)(this.AMC * paramFloat), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (i + this.AME);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    AppMethodBeat.o(113056);
  }
  
  public final void onStart()
  {
    int i = -1;
    AppMethodBeat.i(113055);
    this.AMD = -1;
    this.AME = -1;
    this.eiY = DragSortListView.l(this.AMh);
    this.AMF = DragSortListView.m(this.AMh);
    DragSortListView.a(this.AMh, 1);
    this.AMA = DragSortListView.d(this.AMh).x;
    if (DragSortListView.n(this.AMh))
    {
      float f = this.AMh.getWidth() * 2.0F;
      if (DragSortListView.o(this.AMh) == 0.0F)
      {
        DragSortListView localDragSortListView = this.AMh;
        if (this.AMA < 0.0F) {}
        for (;;)
        {
          DragSortListView.a(localDragSortListView, i * f);
          AppMethodBeat.o(113055);
          return;
          i = 1;
        }
      }
      f *= 2.0F;
      if ((DragSortListView.o(this.AMh) < 0.0F) && (DragSortListView.o(this.AMh) > -f))
      {
        DragSortListView.a(this.AMh, -f);
        AppMethodBeat.o(113055);
        return;
      }
      if ((DragSortListView.o(this.AMh) > 0.0F) && (DragSortListView.o(this.AMh) < f)) {
        DragSortListView.a(this.AMh, f);
      }
      AppMethodBeat.o(113055);
      return;
    }
    DragSortListView.p(this.AMh);
    AppMethodBeat.o(113055);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(113057);
    DragSortListView.q(this.AMh);
    AppMethodBeat.o(113057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.k
 * JD-Core Version:    0.7.0.1
 */