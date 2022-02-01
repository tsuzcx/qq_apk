package com.tencent.mm.ui.widget.a;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$4
  extends p
{
  e$4(e parame, Context paramContext)
  {
    super(paramContext);
  }
  
  public final float a(DisplayMetrics paramDisplayMetrics)
  {
    return 1.0F / paramDisplayMetrics.densityDpi;
  }
  
  public final PointF cB(int paramInt)
  {
    AppMethodBeat.i(251379);
    if ((e.c(this.Ynn) != null) && (e.c(this.Ynn).getLayoutManager() != null) && ((e.c(this.Ynn).getLayoutManager() instanceof LinearLayoutManager)))
    {
      localPointF = ((LinearLayoutManager)e.c(this.Ynn).getLayoutManager()).cB(paramInt);
      AppMethodBeat.o(251379);
      return localPointF;
    }
    PointF localPointF = super.cB(paramInt);
    AppMethodBeat.o(251379);
    return localPointF;
  }
  
  public final int kQ()
  {
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e.4
 * JD-Core Version:    0.7.0.1
 */