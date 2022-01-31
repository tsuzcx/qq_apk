package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.af;
import android.util.DisplayMetrics;
import android.view.View;

final class b$1
  extends af
{
  b$1(b paramb, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  protected final void a(View paramView, RecyclerView.r.a parama)
  {
    paramView = this.pGL.a(this.pGL.acI.getLayoutManager(), paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = bG(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      parama.a(i, j, k, this.Mh);
    }
  }
  
  protected final int bH(int paramInt)
  {
    return Math.min(100, super.bH(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b.1
 * JD-Core Version:    0.7.0.1
 */