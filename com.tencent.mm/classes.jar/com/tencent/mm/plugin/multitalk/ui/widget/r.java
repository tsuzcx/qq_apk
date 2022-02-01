package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.e;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "headerStub", "getHeaderStub", "()Landroid/view/View;", "setHeaderStub", "plugin-multitalk_release"})
public final class r
  extends RecyclerView.v
{
  View FwJ;
  ImageView jiu;
  
  public r(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178985);
    View localView = paramView.findViewById(a.e.avatar);
    p.j(localView, "itemView.findViewById(R.id.avatar)");
    this.jiu = ((ImageView)localView);
    paramView = paramView.findViewById(a.e.header_stub);
    p.j(paramView, "itemView.findViewById(R.id.header_stub)");
    this.FwJ = paramView;
    AppMethodBeat.o(178985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.r
 * JD-Core Version:    0.7.0.1
 */