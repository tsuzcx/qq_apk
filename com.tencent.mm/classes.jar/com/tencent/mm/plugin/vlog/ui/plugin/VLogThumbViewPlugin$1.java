package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import d.o;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$1", "Landroid/support/v7/widget/LinearLayoutManager;", "scrollHorizontallyBy", "", "dx", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
public final class VLogThumbViewPlugin$1
  extends LinearLayoutManager
{
  VLogThumbViewPlugin$1(Context paramContext)
  {
    super(0);
  }
  
  public final int a(int paramInt, RecyclerView.o paramo, RecyclerView.t paramt)
  {
    AppMethodBeat.i(191855);
    int i = ad.p(this.CgG) + paramInt;
    if ((ad.t(this.CgG) >= 0) && (ad.u(this.CgG)))
    {
      o localo = ad.v(this.CgG);
      if ((i <= ((Number)localo.second).floatValue()) && (i >= ((Number)localo.first).floatValue())) {}
      for (i = 1; i != 0; i = 0)
      {
        paramInt = super.a(paramInt, paramo, paramt);
        AppMethodBeat.o(191855);
        return paramInt;
      }
      AppMethodBeat.o(191855);
      return 0;
    }
    paramInt = super.a(paramInt, paramo, paramt);
    AppMethodBeat.o(191855);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.VLogThumbViewPlugin.1
 * JD-Core Version:    0.7.0.1
 */