package com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.widget.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/recyclerview/ScreenThumbLayoutItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentWidth", "", "getContext", "()Landroid/content/Context;", "setContext", "itemPadding", "itemWidth", "applyWidthSize", "", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-multitalk_release"})
public final class e
  extends RecyclerView.h
{
  public int contentWidth;
  private Context context;
  private int itemPadding;
  public int tHY;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(199656);
    this.context = paramContext;
    this.itemPadding = (f.AOJ / 2);
    AppMethodBeat.o(199656);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(199655);
    p.k(paramRect, "outRect");
    p.k(paramView, "view");
    p.k(paramRecyclerView, "parent");
    p.k(params, "state");
    int j = RecyclerView.bh(paramView);
    paramView = paramRecyclerView.getAdapter();
    if (paramView != null) {}
    for (int i = paramView.getItemCount(); j == 0; i = 0)
    {
      paramRect.set((paramRecyclerView.getWidth() - this.tHY) / 2, 0, this.itemPadding, 0);
      AppMethodBeat.o(199655);
      return;
    }
    if (j == i - 1)
    {
      i = (paramRecyclerView.getWidth() - this.tHY) / 2;
      paramRect.set(this.itemPadding, 0, i, 0);
      AppMethodBeat.o(199655);
      return;
    }
    paramRect.set(this.itemPadding, 0, this.itemPadding, 0);
    AppMethodBeat.o(199655);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.recyclerview.e
 * JD-Core Version:    0.7.0.1
 */