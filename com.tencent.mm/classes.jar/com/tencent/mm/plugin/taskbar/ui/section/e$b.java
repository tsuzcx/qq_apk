package com.tencent.mm.plugin.taskbar.ui.section;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/taskbar/ui/section/TaskBarSectionListView$BaseViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "defaultImage", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "getDefaultImage", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "image", "Landroid/widget/ImageView;", "getImage", "()Landroid/widget/ImageView;", "subTitle", "Landroid/widget/TextView;", "getSubTitle", "()Landroid/widget/TextView;", "title", "getTitle", "plugin-taskbar_release"})
public final class e$b
  extends RecyclerView.v
{
  public final WeImageView FVD;
  public final TextView hbb;
  public final ImageView image;
  public final TextView orb;
  
  public e$b(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(238509);
    this.FVD = ((WeImageView)paramView.findViewById(2131299444));
    this.image = ((ImageView)paramView.findViewById(2131302526));
    this.hbb = ((TextView)paramView.findViewById(2131309195));
    this.orb = ((TextView)paramView.findViewById(2131308717));
    AppMethodBeat.o(238509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.section.e.b
 * JD-Core Version:    0.7.0.1
 */