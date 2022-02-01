package com.tencent.mm.plugin.profile.ui.tab.list;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabMsgAdapter$BizDateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "dateTextView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getDateTextView", "()Landroid/widget/TextView;", "app_release"})
public final class a$a
  extends RecyclerView.v
{
  final TextView Hhr;
  
  public a$a(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(246565);
    this.Hhr = ((TextView)paramView.findViewById(R.h.dtW));
    AppMethodBeat.o(246565);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.a.a
 * JD-Core Version:    0.7.0.1
 */