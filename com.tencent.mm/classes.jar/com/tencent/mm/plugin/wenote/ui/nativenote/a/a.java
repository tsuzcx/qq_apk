package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public abstract class a
  extends RecyclerView.w
{
  protected k EBf;
  
  public a(View paramView, k paramk)
  {
    super(paramView);
    this.EBf = paramk;
  }
  
  public abstract void a(c paramc, int paramInt1, int paramInt2);
  
  public abstract int cdT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.a
 * JD-Core Version:    0.7.0.1
 */