package com.tencent.mm.plugin.topstory.ui.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r.b;
import android.support.v7.widget.af;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;

public abstract class b
  extends RecyclerView.k
{
  public RecyclerView acI;
  private final RecyclerView.m agv = new b.1(this);
  protected Scroller pIv;
  
  public abstract int a(RecyclerView.i parami, int paramInt1, int paramInt2);
  
  public abstract int[] a(RecyclerView.i parami, View paramView);
  
  public final boolean at(int paramInt1, int paramInt2)
  {
    RecyclerView.i locali = this.acI.getLayoutManager();
    if (locali == null) {}
    for (;;)
    {
      return false;
      if (this.acI.getAdapter() != null)
      {
        int i = this.acI.getMinFlingVelocity();
        if ((Math.abs(paramInt2) > i) || (Math.abs(paramInt1) > i))
        {
          if (!(locali instanceof RecyclerView.r.b)) {
            paramInt1 = 0;
          }
          while (paramInt1 != 0)
          {
            return true;
            af localaf = d(locali);
            if (localaf == null)
            {
              paramInt1 = 0;
            }
            else
            {
              paramInt1 = a(locali, paramInt1, paramInt2);
              if (paramInt1 == -1)
              {
                paramInt1 = 0;
              }
              else
              {
                localaf.ahA = paramInt1;
                locali.a(localaf);
                paramInt1 = 1;
              }
            }
          }
        }
      }
    }
  }
  
  final void bOJ()
  {
    if (this.acI == null) {}
    Object localObject;
    do
    {
      View localView;
      do
      {
        do
        {
          return;
          localObject = this.acI.getLayoutManager();
        } while (localObject == null);
        localView = c((RecyclerView.i)localObject);
      } while (localView == null);
      localObject = a((RecyclerView.i)localObject, localView);
    } while ((localObject[0] == 0) && (localObject[1] == 0));
    this.acI.smoothScrollBy(localObject[0], localObject[1]);
  }
  
  public abstract View c(RecyclerView.i parami);
  
  @Deprecated
  public af d(RecyclerView.i parami)
  {
    if (!(parami instanceof RecyclerView.r.b)) {
      return null;
    }
    return new b.2(this, this.acI.getContext());
  }
  
  public final void f(RecyclerView paramRecyclerView)
  {
    if (this.acI == paramRecyclerView) {}
    do
    {
      return;
      if (this.acI != null)
      {
        this.acI.b(this.agv);
        this.acI.setOnFlingListener(null);
      }
      this.acI = paramRecyclerView;
    } while (this.acI == null);
    if (this.acI.getOnFlingListener() != null) {
      throw new IllegalStateException("An instance of OnFlingListener already set.");
    }
    this.acI.a(this.agv);
    this.acI.setOnFlingListener(this);
    this.pIv = new Scroller(this.acI.getContext(), new DecelerateInterpolator());
    bOJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.b
 * JD-Core Version:    0.7.0.1
 */