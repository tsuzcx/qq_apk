package com.tencent.mm.plugin.profile.ui.tab.list;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabNoMoreVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "footerText", "Landroid/widget/TextView;", "getFooterText", "()Landroid/widget/TextView;", "app_release"})
public final class d$b
  extends RecyclerView.v
{
  final TextView HhM;
  
  public d$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(243906);
    paramView = paramView.findViewById(R.h.dtH);
    p.j(paramView, "itemView.findViewById(R.…rofile_list_no_more_text)");
    this.HhM = ((TextView)paramView);
    AppMethodBeat.o(243906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.d.b
 * JD-Core Version:    0.7.0.1
 */