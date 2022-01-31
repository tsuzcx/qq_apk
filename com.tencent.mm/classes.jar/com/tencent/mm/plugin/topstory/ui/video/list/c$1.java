package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c$1
  extends ae
{
  c$1(c paramc, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(View paramView, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(2013);
    paramView = this.tlk.a(this.tlk.adt.getLayoutManager(), paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = bL(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      parama.a(i, j, k, this.LP);
    }
    AppMethodBeat.o(2013);
  }
  
  public final int bM(int paramInt)
  {
    AppMethodBeat.i(2014);
    paramInt = Math.min(100, super.bM(paramInt));
    AppMethodBeat.o(2014);
    return paramInt;
  }
  
  public final float c(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.c.1
 * JD-Core Version:    0.7.0.1
 */