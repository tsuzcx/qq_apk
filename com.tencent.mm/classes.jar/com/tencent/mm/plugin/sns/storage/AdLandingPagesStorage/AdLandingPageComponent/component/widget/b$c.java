package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import java.util.Map;

final class b$c
  extends RecyclerView.m
{
  RecyclerView heQ;
  private LinearLayoutManager oFh;
  int oFi = 2147483647;
  private int oFj = -1;
  private int oFk = -1;
  private long oFl = 0L;
  Runnable oFm = new b.c.1(this);
  
  public b$c(b paramb, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
  {
    this.heQ = paramRecyclerView;
    this.oFh = paramLinearLayoutManager;
  }
  
  private void bFi()
  {
    this.heQ.getHandler().removeCallbacks(this.oFm);
  }
  
  private void dP(int paramInt1, int paramInt2)
  {
    b localb = this.oIO;
    if (paramInt1 <= paramInt2)
    {
      localb.dO(paramInt1, paramInt2);
      while (paramInt1 <= paramInt2)
      {
        b.a locala = (b.a)localb.oFa.get(Integer.valueOf(paramInt1));
        if ((locala != null) && (locala.oCc))
        {
          localb.oIM.yj(paramInt1);
          locala.bFh();
        }
        paramInt1 += 1;
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.a(paramRecyclerView, paramInt1, paramInt2);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    if (paramInt != this.oFi)
    {
      if (paramInt != 1) {
        bFi();
      }
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.oFi = paramInt;
      return;
      this.oIO.bFH();
      if (this.oFi == 2)
      {
        int i = this.oFh.gY();
        int j = this.oFh.ha();
        if (j < this.oFj)
        {
          dP(j, this.oFj);
        }
        else if (i > this.oFk)
        {
          dP(this.oFk, i);
          continue;
          bFi();
          this.heQ.postDelayed(this.oFm, 100L);
          continue;
          this.oFj = this.oFh.gY();
          this.oFk = this.oFh.ha();
          this.oFl = System.currentTimeMillis();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.b.c
 * JD-Core Version:    0.7.0.1
 */