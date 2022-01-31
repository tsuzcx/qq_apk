package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

final class DragSortListView$k
  extends DragSortListView.m
{
  private int drq;
  private float wrW;
  private float wrX;
  private float wrY;
  private int wrZ = -1;
  private int wsa = -1;
  private int wsb;
  
  private DragSortListView$k(DragSortListView paramDragSortListView, int paramInt)
  {
    super(paramDragSortListView, paramInt, (byte)0);
  }
  
  public final void aQ(float paramFloat)
  {
    paramFloat = 1.0F - paramFloat;
    int j = this.wrD.getFirstVisiblePosition();
    View localView = this.wrD.getChildAt(this.drq - j);
    float f1;
    if (DragSortListView.n(this.wrD))
    {
      f1 = (float)(SystemClock.uptimeMillis() - this.mStartTime) / 1000.0F;
      if (f1 != 0.0F) {}
    }
    do
    {
      do
      {
        return;
        float f2 = DragSortListView.o(this.wrD);
        int k = this.wrD.getWidth();
        localObject = this.wrD;
        float f3 = DragSortListView.o(this.wrD);
        if (DragSortListView.o(this.wrD) > 0.0F) {}
        for (i = 1;; i = -1)
        {
          DragSortListView.a((DragSortListView)localObject, i * f1 * k + f3);
          this.wrW += f2 * f1;
          DragSortListView.d(this.wrD).x = ((int)this.wrW);
          if ((this.wrW >= k) || (this.wrW <= -k)) {
            break;
          }
          this.mStartTime = SystemClock.uptimeMillis();
          DragSortListView.f(this.wrD);
          return;
        }
        if (localView != null)
        {
          if (this.wrZ == -1)
          {
            this.wrZ = DragSortListView.b(this.wrD, this.drq, localView);
            this.wrX = (localView.getHeight() - this.wrZ);
          }
          i = Math.max((int)(this.wrX * paramFloat), 1);
          localObject = localView.getLayoutParams();
          ((ViewGroup.LayoutParams)localObject).height = (i + this.wrZ);
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      } while (this.wsb == this.drq);
      localView = this.wrD.getChildAt(this.wsb - j);
    } while (localView == null);
    if (this.wsa == -1)
    {
      this.wsa = DragSortListView.b(this.wrD, this.wsb, localView);
      this.wrY = (localView.getHeight() - this.wsa);
    }
    int i = Math.max((int)(this.wrY * paramFloat), 1);
    Object localObject = localView.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = (i + this.wsa);
    localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public final void onStart()
  {
    int i = -1;
    this.wrZ = -1;
    this.wsa = -1;
    this.drq = DragSortListView.l(this.wrD);
    this.wsb = DragSortListView.m(this.wrD);
    DragSortListView.a(this.wrD, 1);
    this.wrW = DragSortListView.d(this.wrD).x;
    if (DragSortListView.n(this.wrD))
    {
      float f = this.wrD.getWidth() * 2.0F;
      if (DragSortListView.o(this.wrD) == 0.0F)
      {
        DragSortListView localDragSortListView = this.wrD;
        if (this.wrW < 0.0F) {
          DragSortListView.a(localDragSortListView, i * f);
        }
      }
      do
      {
        return;
        i = 1;
        break;
        f *= 2.0F;
        if ((DragSortListView.o(this.wrD) < 0.0F) && (DragSortListView.o(this.wrD) > -f))
        {
          DragSortListView.a(this.wrD, -f);
          return;
        }
      } while ((DragSortListView.o(this.wrD) <= 0.0F) || (DragSortListView.o(this.wrD) >= f));
      DragSortListView.a(this.wrD, f);
      return;
    }
    DragSortListView.p(this.wrD);
  }
  
  public final void onStop()
  {
    DragSortListView.q(this.wrD);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.k
 * JD-Core Version:    0.7.0.1
 */