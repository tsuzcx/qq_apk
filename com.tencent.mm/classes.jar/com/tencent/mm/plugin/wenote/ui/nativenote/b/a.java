package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public abstract class a
  extends RecyclerView.v
{
  protected k vBM;
  
  public a(View paramView, k paramk)
  {
    super(paramView);
    this.vBM = paramk;
  }
  
  public abstract void a(c paramc, int paramInt1, int paramInt2);
  
  public abstract int djX();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.b.a
 * JD-Core Version:    0.7.0.1
 */