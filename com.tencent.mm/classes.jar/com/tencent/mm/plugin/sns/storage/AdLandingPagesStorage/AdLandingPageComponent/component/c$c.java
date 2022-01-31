package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

final class c$c
  extends RecyclerView.m
{
  RecyclerView heQ;
  private LinearLayoutManager oFh;
  int oFi = 2147483647;
  private int oFj = -1;
  private int oFk = -1;
  private long oFl = 0L;
  Runnable oFm = new c.c.1(this);
  
  public c$c(c paramc, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
  {
    this.heQ = paramRecyclerView;
    this.oFh = paramLinearLayoutManager;
  }
  
  private void bFi()
  {
    this.heQ.getHandler().removeCallbacks(this.oFm);
  }
  
  private void h(int paramInt1, int paramInt2, long paramLong)
  {
    int i = 1;
    y.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    c localc = this.oFe;
    if (paramInt1 > paramInt2)
    {
      y.e("AdLandingCarouselComp", "wtf start > end");
      return;
    }
    localc.dO(paramInt1, paramInt2);
    if (paramInt2 == paramInt1) {}
    for (;;)
    {
      paramLong /= i;
      while (paramInt1 <= paramInt2)
      {
        c.a locala = (c.a)localc.oFa.get(Integer.valueOf(paramInt1));
        if ((locala != null) && (locala.isVisible))
        {
          locala.isVisible = false;
          locala.oFd = 0L;
          locala.time += paramLong;
        }
        paramInt1 += 1;
      }
      break;
      i = paramInt2 - paramInt1 + 1;
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
      y.d("AdLandingCarouselComp", "state " + paramInt);
      return;
      c.a(this.oFe);
      if (this.oFi == 2)
      {
        int i = this.oFh.gY();
        int j = this.oFh.ha();
        if (j < this.oFj)
        {
          h(j, this.oFj, System.currentTimeMillis() - this.oFl);
        }
        else if (i > this.oFk)
        {
          h(this.oFk, i, System.currentTimeMillis() - this.oFl);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.c.c
 * JD-Core Version:    0.7.0.1
 */