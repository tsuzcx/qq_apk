package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "headerStub", "getHeaderStub", "()Landroid/view/View;", "setHeaderStub", "plugin-multitalk_release"})
public final class l
  extends RecyclerView.w
{
  ImageView fTj;
  View wum;
  
  public l(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178985);
    View localView = paramView.findViewById(2131296996);
    p.g(localView, "itemView.findViewById(R.id.avatar)");
    this.fTj = ((ImageView)localView);
    paramView = paramView.findViewById(2131300727);
    p.g(paramView, "itemView.findViewById(R.id.header_stub)");
    this.wum = paramView;
    AppMethodBeat.o(178985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.l
 * JD-Core Version:    0.7.0.1
 */