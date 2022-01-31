package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;

public abstract class b
  extends RecyclerView.m
{
  private int rMG;
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (Math.abs(paramInt2) > this.rMG)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (paramRecyclerView.canScrollVertically(-1)) {
          break label35;
        }
        cjt();
      }
    }
    label35:
    do
    {
      return;
      paramInt1 = 0;
      break;
      if (!paramRecyclerView.canScrollVertically(1))
      {
        cju();
        return;
      }
      if (paramInt2 < 0)
      {
        cjr();
        return;
      }
    } while (paramInt2 <= 0);
    cjs();
  }
  
  public abstract void cjr();
  
  public abstract void cjs();
  
  public abstract void cjt();
  
  public abstract void cju();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.b
 * JD-Core Version:    0.7.0.1
 */