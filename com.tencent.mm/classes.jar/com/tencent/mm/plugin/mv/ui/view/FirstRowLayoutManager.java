package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FirstRowLayoutManager
  extends GridLayoutManager
{
  public FirstRowLayoutManager(Context paramContext, int paramInt)
  {
    super(paramInt);
  }
  
  public void smoothScrollToPosition(RecyclerView paramRecyclerView, RecyclerView.s params, int paramInt)
  {
    AppMethodBeat.i(256706);
    paramRecyclerView = new a(paramRecyclerView.getContext());
    paramRecyclerView.atO = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(256706);
  }
  
  static final class a
    extends ae
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final float a(DisplayMetrics paramDisplayMetrics)
    {
      return 50.0F / paramDisplayMetrics.densityDpi;
    }
    
    public final int f(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return paramInt3 - paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.FirstRowLayoutManager
 * JD-Core Version:    0.7.0.1
 */