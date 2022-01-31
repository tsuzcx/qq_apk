package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$2
  extends ae
{
  e$2(e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(View paramView, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(2267);
    if (this.tmK.adt == null)
    {
      AppMethodBeat.o(2267);
      return;
    }
    paramView = this.tmK.a(this.tmK.adt.getLayoutManager(), paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = bL(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      parama.a(i, j, k, this.LP);
    }
    AppMethodBeat.o(2267);
  }
  
  public final float c(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.widget.e.2
 * JD-Core Version:    0.7.0.1
 */