package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public abstract class a
  extends RecyclerView.v
{
  protected k QIM;
  
  public a(View paramView, k paramk)
  {
    super(paramView);
    this.QIM = paramk;
  }
  
  public abstract void a(c paramc, int paramInt1, int paramInt2);
  
  public abstract int cRD();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.ui.nativenote.a.a
 * JD-Core Version:    0.7.0.1
 */