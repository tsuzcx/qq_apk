package com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.c;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFiveFragment$ItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/repairer/ui/demo/refresh/fragment/DemoFiveFragment;Landroid/view/View;)V", "ivImageView", "Landroid/widget/ImageView;", "getIvImageView", "()Landroid/widget/ImageView;", "setIvImageView", "(Landroid/widget/ImageView;)V", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
final class DemoFiveFragment$a
  extends RecyclerView.v
{
  ImageView OxZ;
  
  public DemoFiveFragment$a(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(278536);
    paramView = localObject.findViewById(b.c.imageView);
    s.s(paramView, "itemView.findViewById(R.id.imageView)");
    this.OxZ = ((ImageView)paramView);
    AppMethodBeat.o(278536);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.demo.refresh.fragment.DemoFiveFragment.a
 * JD-Core Version:    0.7.0.1
 */