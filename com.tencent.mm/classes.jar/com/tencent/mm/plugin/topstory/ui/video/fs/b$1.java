package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.r.a;
import android.support.v7.widget.RecyclerView.s;
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
  
  public final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 100.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final void a(View paramView, RecyclerView.s params, RecyclerView.r.a parama)
  {
    AppMethodBeat.i(126234);
    paramView = this.yQD.a(this.yQD.akA.getLayoutManager(), paramView);
    int i = paramView[0];
    int j = paramView[1];
    int k = cd(Math.max(Math.abs(i), Math.abs(j)));
    if (k > 0) {
      parama.a(i, j, k, this.SS);
    }
    AppMethodBeat.o(126234);
  }
  
  public final int ce(int paramInt)
  {
    AppMethodBeat.i(126235);
    paramInt = Math.min(100, super.ce(paramInt));
    AppMethodBeat.o(126235);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.fs.b.1
 * JD-Core Version:    0.7.0.1
 */