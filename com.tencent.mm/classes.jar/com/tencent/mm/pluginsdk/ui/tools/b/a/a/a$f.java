package com.tencent.mm.pluginsdk.ui.tools.b.a.a;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/pluginsdk/ui/tools/fs/album/adapter/AlbumFileAdapter$TimeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "timeTv", "Landroid/widget/TextView;", "getTimeTv", "()Landroid/widget/TextView;", "setTimeTv", "(Landroid/widget/TextView;)V", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$f
  extends RecyclerView.v
{
  TextView timeTv;
  
  public a$f(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(245827);
    paramView = paramView.findViewById(R.h.item_title);
    s.s(paramView, "itemView.findViewById(R.id.item_title)");
    this.timeTv = ((TextView)paramView);
    AppMethodBeat.o(245827);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b.a.a.a.f
 * JD-Core Version:    0.7.0.1
 */