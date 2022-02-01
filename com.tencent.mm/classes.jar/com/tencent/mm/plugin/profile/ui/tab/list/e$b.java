package com.tencent.mm.plugin.profile.ui.tab.list;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/list/BizProfileTabVideoAdapter$BizProfileTabNoMoreVH;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "footerText", "Landroid/widget/TextView;", "getFooterText", "()Landroid/widget/TextView;", "app_release"})
public final class e$b
  extends RecyclerView.v
{
  final TextView Bnq;
  
  public e$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(230824);
    paramView = paramView.findViewById(2131297467);
    p.g(paramView, "itemView.findViewById(R.…rofile_list_no_more_text)");
    this.Bnq = ((TextView)paramView);
    AppMethodBeat.o(230824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.list.e.b
 * JD-Core Version:    0.7.0.1
 */