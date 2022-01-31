package com.tencent.mm.plugin.topstory.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$1
  extends RecyclerView.m
{
  boolean amA = false;
  
  e$1(e parame) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.amA = true;
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(2266);
    super.c(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.amA))
    {
      this.amA = false;
      this.tmK.kt();
    }
    AppMethodBeat.o(2266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.e.1
 * JD-Core Version:    0.7.0.1
 */