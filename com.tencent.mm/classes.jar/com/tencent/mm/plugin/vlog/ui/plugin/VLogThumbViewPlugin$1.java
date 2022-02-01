package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$1", "Landroid/support/v7/widget/LinearLayoutManager;", "scrollHorizontallyBy", "", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
public final class VLogThumbViewPlugin$1
  extends LinearLayoutManager
{
  VLogThumbViewPlugin$1(Context paramContext)
  {
    super(0, false);
  }
  
  public final int scrollHorizontallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(191526);
    int i = ah.p(this.GJt) + paramInt;
    if ((ah.t(this.GJt) >= 0) && (ah.u(this.GJt)))
    {
      o localo = ah.v(this.GJt);
      if ((i <= ((Number)localo.second).floatValue()) && (i >= ((Number)localo.first).floatValue())) {}
      for (i = 1; i != 0; i = 0)
      {
        paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
        AppMethodBeat.o(191526);
        return paramInt;
      }
      AppMethodBeat.o(191526);
      return 0;
    }
    paramInt = super.scrollHorizontallyBy(paramInt, paramn, params);
    AppMethodBeat.o(191526);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.VLogThumbViewPlugin.1
 * JD-Core Version:    0.7.0.1
 */