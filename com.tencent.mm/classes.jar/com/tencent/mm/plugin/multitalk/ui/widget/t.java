package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarLayoutHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarLayout", "Landroid/widget/RelativeLayout;", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class t
  extends RecyclerView.v
{
  public RelativeLayout LwU;
  
  public t(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178992);
    paramView = paramView.findViewById(a.e.small_invite_avatar);
    if (paramView == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(178992);
      throw paramView;
    }
    this.LwU = ((RelativeLayout)paramView);
    AppMethodBeat.o(178992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.t
 * JD-Core Version:    0.7.0.1
 */