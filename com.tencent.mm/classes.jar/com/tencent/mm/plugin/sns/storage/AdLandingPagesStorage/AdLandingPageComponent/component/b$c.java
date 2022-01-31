package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class b$c
  extends RecyclerView.m
{
  RecyclerView iQe;
  private LinearLayoutManager ruI;
  int ruJ;
  private int ruK;
  private int ruL;
  private long ruM;
  Runnable ruN;
  
  public b$c(b paramb, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(37019);
    this.ruJ = 2147483647;
    this.ruK = -1;
    this.ruL = -1;
    this.ruM = 0L;
    this.ruN = new b.c.1(this);
    this.iQe = paramRecyclerView;
    this.ruI = paramLinearLayoutManager;
    AppMethodBeat.o(37019);
  }
  
  private void cqO()
  {
    AppMethodBeat.i(37020);
    this.iQe.getHandler().removeCallbacks(this.ruN);
    AppMethodBeat.o(37020);
  }
  
  private void i(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(37023);
    ab.d("AdLandingCarouselComp", "flyingItems start %d, end %d, timeExposure %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    b.a(this.ruF, paramInt1, paramInt2, paramLong);
    AppMethodBeat.o(37023);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37022);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    AppMethodBeat.o(37022);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(37021);
    super.c(paramRecyclerView, paramInt);
    if (paramInt != this.ruJ)
    {
      if (paramInt != 1) {
        cqO();
      }
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.ruJ = paramInt;
      ab.d("AdLandingCarouselComp", "state ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(37021);
      return;
      b.a(this.ruF);
      if (this.ruJ == 2)
      {
        int i = this.ruI.it();
        int j = this.ruI.iv();
        if (j < this.ruK)
        {
          i(j, this.ruK, System.currentTimeMillis() - this.ruM);
        }
        else if (i > this.ruL)
        {
          i(this.ruL, i, System.currentTimeMillis() - this.ruM);
          continue;
          cqO();
          this.iQe.postDelayed(this.ruN, 100L);
          continue;
          this.ruK = this.ruI.it();
          this.ruL = this.ruI.iv();
          this.ruM = System.currentTimeMillis();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.b.c
 * JD-Core Version:    0.7.0.1
 */