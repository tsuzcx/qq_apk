package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentWidth", "", "getContext", "()Landroid/content/Context;", "setContext", "itemPadding", "itemWidth", "applyWidthSize", "", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-multitalk_release"})
public final class e
  extends RecyclerView.h
{
  private Context context;
  private int itemPadding;
  public int qmd;
  public int zYO;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(240082);
    this.context = paramContext;
    this.itemPadding = (f.wfQ / 2);
    AppMethodBeat.o(240082);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(240081);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    int j = RecyclerView.bw(paramView);
    paramView = paramRecyclerView.getAdapter();
    if (paramView != null) {}
    for (int i = paramView.getItemCount(); j == 0; i = 0)
    {
      paramRect.set((paramRecyclerView.getWidth() - this.qmd) / 2, 0, this.itemPadding, 0);
      AppMethodBeat.o(240081);
      return;
    }
    if (j == i - 1)
    {
      i = (paramRecyclerView.getWidth() - this.qmd) / 2;
      paramRect.set(this.itemPadding, 0, i, 0);
      AppMethodBeat.o(240081);
      return;
    }
    paramRect.set(this.itemPadding, 0, this.itemPadding, 0);
    AppMethodBeat.o(240081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */