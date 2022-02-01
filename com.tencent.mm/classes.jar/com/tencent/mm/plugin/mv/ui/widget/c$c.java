package com.tencent.mm.plugin.mv.ui.widget;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksAdapter$FillingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bind", "", "width", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$c
  extends RecyclerView.v
{
  final ViewGroup parent;
  
  public c$c(ViewGroup paramViewGroup)
  {
    super(new View(paramViewGroup.getContext()));
    AppMethodBeat.i(286623);
    this.parent = paramViewGroup;
    paramViewGroup = this.caK;
    Drawable localDrawable = a.m(this.caK.getContext(), b.d.LRK);
    s.checkNotNull(localDrawable);
    paramViewGroup.setBackground(localDrawable);
    AppMethodBeat.o(286623);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.c.c
 * JD-Core Version:    0.7.0.1
 */