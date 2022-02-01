package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditFooterRecyclerPlugin$initRecyclerView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "offset", "", "getOffset", "()F", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-vlog_release"})
public final class c$e
  extends RecyclerView.h
{
  private final float offset;
  
  c$e()
  {
    AppMethodBeat.i(191201);
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    this.offset = localContext.getResources().getDimension(2131165296);
    AppMethodBeat.o(191201);
  }
  
  public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
  {
    AppMethodBeat.i(191200);
    p.h(paramRect, "outRect");
    p.h(paramView, "view");
    p.h(paramRecyclerView, "parent");
    p.h(params, "state");
    super.a(paramRect, paramView, paramRecyclerView, params);
    paramView = paramRecyclerView.bi(paramView);
    p.g(paramView, "parent.getChildViewHolder(view)");
    int i = paramView.lR();
    paramRect.left = ((int)this.offset);
    if (i + 1 == this.GGE.GGB.size()) {
      paramRect.right = ((int)this.offset);
    }
    AppMethodBeat.o(191200);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c.e
 * JD-Core Version:    0.7.0.1
 */