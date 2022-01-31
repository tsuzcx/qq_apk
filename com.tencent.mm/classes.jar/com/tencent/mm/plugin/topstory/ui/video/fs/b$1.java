package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  extends ae
{
  b$1(b paramb, Context paramContext)
  {
    super(paramContext);
  }
  
  public final void a(View paramView, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(1860);
    paramView = this.tkd.a(this.tkd.adt.getLayoutManager(), paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = bL(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      parama.a(i, j, k, this.LP);
    }
    AppMethodBeat.o(1860);
  }
  
  public final int bM(int paramInt)
  {
    AppMethodBeat.i(1861);
    paramInt = Math.min(100, super.bM(paramInt));
    AppMethodBeat.o(1861);
    return paramInt;
  }
  
  public final float c(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b.1
 * JD-Core Version:    0.7.0.1
 */