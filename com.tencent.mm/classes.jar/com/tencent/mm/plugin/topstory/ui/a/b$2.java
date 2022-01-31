package com.tencent.mm.plugin.topstory.ui.a;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;
import android.view.View;

final class b$2
  extends af
{
  b$2(b paramb, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(View paramView, RecyclerView.r.a parama)
  {
    if (this.pIw.acI == null) {}
    int i;
    int j;
    int k;
    do
    {
      return;
      paramView = this.pIw.a(this.pIw.acI.getLayoutManager(), paramView);
      i = paramView[0];
      j = paramView[1];
      k = bG(Math.max(Math.abs(i), Math.abs(j)));
    } while (k <= 0);
    parama.a(i, j, k, this.Mh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.a.b.2
 * JD-Core Version:    0.7.0.1
 */