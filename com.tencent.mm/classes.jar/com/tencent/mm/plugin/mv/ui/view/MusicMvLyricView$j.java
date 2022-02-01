package com.tencent.mm.plugin.mv.ui.view;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-mv_release"})
public final class MusicMvLyricView$j
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(257560);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    int j = RecyclerView.bw(paramView);
    paramView = paramRecyclerView.getAdapter();
    if (paramView != null) {}
    for (int i = paramView.getItemCount(); j == 0; i = 0)
    {
      paramRect.top = MusicMvLyricView.ewt();
      AppMethodBeat.o(257560);
      return;
    }
    if (j == i - 1)
    {
      paramRect.top = MusicMvLyricView.ewr();
      paramRect.bottom = MusicMvLyricView.ewt();
      AppMethodBeat.o(257560);
      return;
    }
    paramRect.top = MusicMvLyricView.ewr();
    AppMethodBeat.o(257560);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.j
 * JD-Core Version:    0.7.0.1
 */