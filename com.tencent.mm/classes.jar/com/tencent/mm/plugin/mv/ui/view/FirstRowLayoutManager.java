package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.o;
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
    AppMethodBeat.i(286897);
    paramRecyclerView = new a(paramRecyclerView.getContext());
    paramRecyclerView.cag = paramInt;
    startSmoothScroll(paramRecyclerView);
    AppMethodBeat.o(286897);
  }
  
  static final class a
    extends o
  {
    a(Context paramContext)
    {
      super();
    }
    
    public final float c(DisplayMetrics paramDisplayMetrics)
    {
      return 50.0F / paramDisplayMetrics.densityDpi;
    }
    
    public final int g(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      return paramInt3 - paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.FirstRowLayoutManager
 * JD-Core Version:    0.7.0.1
 */