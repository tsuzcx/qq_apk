package com.tencent.mm.plugin.topstory.ui.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;

final class b$1
  extends RecyclerView.m
{
  boolean hwf = false;
  
  b$1(b paramb) {}
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      this.hwf = true;
    }
  }
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    if ((paramInt == 0) && (this.hwf))
    {
      this.hwf = false;
      this.pIw.bOJ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.b.1
 * JD-Core Version:    0.7.0.1
 */