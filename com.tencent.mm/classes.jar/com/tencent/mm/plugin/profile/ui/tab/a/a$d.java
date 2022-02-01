package com.tencent.mm.plugin.profile.ui.tab.a;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/profile/ui/tab/menu/BizProfileMenuAdapter$MenuSingleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "titleView", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "app_release"})
public final class a$d
  extends RecyclerView.v
{
  final TextView titleView;
  
  public a$d(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(230856);
    paramView = paramView.findViewById(2131297477);
    p.g(paramView, "itemView.findViewById(R.id.biz_profile_menu_title)");
    this.titleView = ((TextView)paramView);
    AppMethodBeat.o(230856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.tab.a.a.d
 * JD-Core Version:    0.7.0.1
 */