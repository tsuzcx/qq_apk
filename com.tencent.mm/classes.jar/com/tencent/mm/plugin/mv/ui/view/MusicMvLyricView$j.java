package com.tencent.mm.plugin.mv.ui.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvLyricView$prepareViews$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-mv_release"})
public final class MusicMvLyricView$j
  extends RecyclerView.h
{
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(231819);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    int j = RecyclerView.bh(paramView);
    paramView = paramRecyclerView.getAdapter();
    if (paramView != null) {}
    for (int i = paramView.getItemCount(); j == 0; i = 0)
    {
      paramRect.top = MusicMvLyricView.fhM();
      AppMethodBeat.o(231819);
      return;
    }
    if (j == i - 1)
    {
      paramRect.top = MusicMvLyricView.fhK();
      paramRect.bottom = MusicMvLyricView.fhM();
      AppMethodBeat.o(231819);
      return;
    }
    paramRect.top = MusicMvLyricView.fhK();
    AppMethodBeat.o(231819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView.j
 * JD-Core Version:    0.7.0.1
 */