package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter$GalleryDateViewHolder;", "()V", "onDateClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "date", "", "getOnDateClick", "()Lkotlin/jvm/functions/Function1;", "setOnDateClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GalleryDateViewHolder", "plugin-story_release"})
public final class c
  extends d<a>
{
  public final int getItemCount()
  {
    AppMethodBeat.i(119725);
    int i = this.jfg.size();
    AppMethodBeat.o(119725);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter$GalleryDateViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter;Landroid/view/View;)V", "arrowIv", "Landroid/widget/ImageView;", "getArrowIv", "()Landroid/widget/ImageView;", "bg", "getBg", "()Landroid/view/View;", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "plugin-story_release"})
  public final class a
    extends RecyclerView.w
  {
    final View AVu;
    final TextView iUW;
    final ImageView veM;
    
    public a()
    {
      super();
      AppMethodBeat.i(119724);
      this$1 = localObject.findViewById(2131305425);
      p.g(c.this, "itemView.findViewById(R.…y_gallery_header_date_ll)");
      this.AVu = c.this;
      this$1 = localObject.findViewById(2131298933);
      p.g(c.this, "itemView.findViewById(R.id.date_tv)");
      this.iUW = ((TextView)c.this);
      this$1 = localObject.findViewById(2131296937);
      p.g(c.this, "itemView.findViewById(R.id.arrow)");
      this.veM = ((ImageView)c.this);
      AppMethodBeat.o(119724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.c
 * JD-Core Version:    0.7.0.1
 */