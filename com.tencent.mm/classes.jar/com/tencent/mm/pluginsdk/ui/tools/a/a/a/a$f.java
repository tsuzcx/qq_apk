package com.tencent.mm.pluginsdk.ui.tools.a.a.a;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$TimeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "timeTv", "Landroid/widget/TextView;", "getTimeTv", "()Landroid/widget/TextView;", "setTimeTv", "(Landroid/widget/TextView;)V", "app_release"})
public final class a$f
  extends RecyclerView.v
{
  TextView timeTv;
  
  public a$f(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(235226);
    paramView = paramView.findViewById(R.h.item_title);
    p.j(paramView, "itemView.findViewById(R.id.item_title)");
    this.timeTv = ((TextView)paramView);
    AppMethodBeat.o(235226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.a.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */