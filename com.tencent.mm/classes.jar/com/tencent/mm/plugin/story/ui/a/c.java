package com.tencent.mm.plugin.story.ui.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter$GalleryDateViewHolder;", "()V", "onDateClick", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "date", "", "getOnDateClick", "()Lkotlin/jvm/functions/Function1;", "setOnDateClick", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GalleryDateViewHolder", "plugin-story_release"})
public final class c
  extends d<a>
{
  public final int getItemCount()
  {
    AppMethodBeat.i(119725);
    int i = this.mXB.size();
    AppMethodBeat.o(119725);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter$GalleryDateViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryDateAdapter;Landroid/view/View;)V", "arrowIv", "Landroid/widget/ImageView;", "getArrowIv", "()Landroid/widget/ImageView;", "bg", "getBg", "()Landroid/view/View;", "dateTv", "Landroid/widget/TextView;", "getDateTv", "()Landroid/widget/TextView;", "plugin-story_release"})
  public final class a
    extends RecyclerView.v
  {
    final ImageView EoF;
    final View LRK;
    final TextView mMb;
    
    public a()
    {
      super();
      AppMethodBeat.i(119724);
      this$1 = localObject.findViewById(a.d.LBC);
      p.j(c.this, "itemView.findViewById(R.…y_gallery_header_date_ll)");
      this.LRK = c.this;
      this$1 = localObject.findViewById(a.d.date_tv);
      p.j(c.this, "itemView.findViewById(R.id.date_tv)");
      this.mMb = ((TextView)c.this);
      this$1 = localObject.findViewById(a.d.arrow);
      p.j(c.this, "itemView.findViewById(R.id.arrow)");
      this.EoF = ((ImageView)c.this);
      AppMethodBeat.o(119724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.c
 * JD-Core Version:    0.7.0.1
 */