package com.tencent.mm.plugin.multitalk.ui.widget;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/SmallAvatarHolderInContactUI;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "headerStub", "getHeaderStub", "()Landroid/view/View;", "setHeaderStub", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends RecyclerView.v
{
  View LsV;
  ImageView lKK;
  
  public r(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(178985);
    View localView = paramView.findViewById(a.e.avatar);
    s.s(localView, "itemView.findViewById(R.id.avatar)");
    this.lKK = ((ImageView)localView);
    paramView = paramView.findViewById(a.e.header_stub);
    s.s(paramView, "itemView.findViewById(R.id.header_stub)");
    this.LsV = paramView;
    AppMethodBeat.o(178985);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.r
 * JD-Core Version:    0.7.0.1
 */