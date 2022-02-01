package com.tencent.mm.plugin.multitalk.ui.widget;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "headerStub", "getHeaderStub", "()Landroid/view/View;", "setHeaderStub", "plugin-multitalk_release"})
public final class r
  extends RecyclerView.v
{
  ImageView gyr;
  View zRg;
  
  public r(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178985);
    View localView = paramView.findViewById(2131297119);
    p.g(localView, "itemView.findViewById(R.id.avatar)");
    this.gyr = ((ImageView)localView);
    paramView = paramView.findViewById(2131302308);
    p.g(paramView, "itemView.findViewById(R.id.header_stub)");
    this.zRg = paramView;
    AppMethodBeat.o(178985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.r
 * JD-Core Version:    0.7.0.1
 */