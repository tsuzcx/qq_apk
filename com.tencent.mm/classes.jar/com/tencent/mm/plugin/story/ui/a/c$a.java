package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter$GalleryDateViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter;Landroid/view/View;)V", "arrowIv", "Landroid/widget/ImageView;", "getArrowIv", "()Landroid/widget/ImageView;", "bg", "getBg", "()Landroid/view/View;", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "plugin-story_release"})
public final class c$a
  extends RecyclerView.v
{
  final TextView gpp;
  final View kir;
  final ImageView ofb;
  
  public c$a(View paramView)
  {
    super(localObject);
    AppMethodBeat.i(110097);
    paramView = localObject.findViewById(2131828409);
    j.p(paramView, "itemView.findViewById(R.…y_gallery_header_date_ll)");
    this.kir = paramView;
    paramView = localObject.findViewById(2131822808);
    j.p(paramView, "itemView.findViewById(R.id.date_tv)");
    this.gpp = ((TextView)paramView);
    paramView = localObject.findViewById(2131826332);
    j.p(paramView, "itemView.findViewById(R.id.arrow)");
    this.ofb = ((ImageView)paramView);
    AppMethodBeat.o(110097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.c.a
 * JD-Core Version:    0.7.0.1
 */