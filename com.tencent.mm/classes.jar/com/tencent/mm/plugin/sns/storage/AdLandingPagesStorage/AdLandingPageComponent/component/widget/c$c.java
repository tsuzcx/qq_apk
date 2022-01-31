package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$c
  extends RecyclerView.m
{
  RecyclerView iQe;
  private LinearLayoutManager ruI;
  int ruJ;
  private int ruK;
  private int ruL;
  private long ruM;
  Runnable ruN;
  
  public c$c(c paramc, RecyclerView paramRecyclerView, LinearLayoutManager paramLinearLayoutManager)
  {
    AppMethodBeat.i(37481);
    this.ruJ = 2147483647;
    this.ruK = -1;
    this.ruL = -1;
    this.ruM = 0L;
    this.ruN = new c.c.1(this);
    this.iQe = paramRecyclerView;
    this.ruI = paramLinearLayoutManager;
    AppMethodBeat.o(37481);
  }
  
  private void cqO()
  {
    AppMethodBeat.i(37482);
    this.iQe.getHandler().removeCallbacks(this.ruN);
    AppMethodBeat.o(37482);
  }
  
  private void fy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37485);
    c.a(this.ryL, paramInt1, paramInt2);
    AppMethodBeat.o(37485);
  }
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(37484);
    super.a(paramRecyclerView, paramInt1, paramInt2);
    AppMethodBeat.o(37484);
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(37483);
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
      ab.d("RecyclerViewExposureMgr", "state ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(37483);
      return;
      this.ryL.crD();
      if (this.ruJ == 2)
      {
        int i = this.ruI.it();
        int j = this.ruI.iv();
        if (j < this.ruK)
        {
          fy(j, this.ruK);
        }
        else if (i > this.ruL)
        {
          fy(this.ruL, i);
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
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.c.c
 * JD-Core Version:    0.7.0.1
 */