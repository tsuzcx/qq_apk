package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;

public abstract class b
  extends RecyclerView.m
{
  private int vDk;
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    if (Math.abs(paramInt2) > this.vDk)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        if (paramRecyclerView.canScrollVertically(-1)) {
          break label35;
        }
        djV();
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
        djW();
        return;
      }
      if (paramInt2 < 0)
      {
        djT();
        return;
      }
    } while (paramInt2 <= 0);
    djU();
  }
  
  public abstract void djT();
  
  public abstract void djU();
  
  public abstract void djV();
  
  public abstract void djW();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.b
 * JD-Core Version:    0.7.0.1
 */