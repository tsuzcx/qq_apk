package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarLayout", "Landroid/widget/RelativeLayout;", "plugin-multitalk_release"})
public final class t
  extends RecyclerView.v
{
  public RelativeLayout zVi;
  
  public t(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178992);
    paramView = paramView.findViewById(2131307941);
    if (paramView == null)
    {
      paramView = new kotlin.t("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(178992);
      throw paramView;
    }
    this.zVi = ((RelativeLayout)paramView);
    AppMethodBeat.o(178992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.t
 * JD-Core Version:    0.7.0.1
 */