package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import d.g.b.p;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter$ControlViewHolder;", "()V", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelected", "update", "items", "", "ControlViewHolder", "plugin-story_release"})
public final class a
  extends RecyclerView.a<a>
{
  public final ArrayList<h> APS;
  public int uT;
  
  public a()
  {
    AppMethodBeat.i(119718);
    this.APS = new ArrayList();
    AppMethodBeat.o(119718);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119716);
    int i = this.APS.size();
    AppMethodBeat.o(119716);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter$ControlViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;Landroid/view/View;)V", "view", "getView", "()Landroid/view/View;", "plugin-story_release"})
  public final class a
    extends RecyclerView.w
  {
    final View view;
    
    public a()
    {
      super();
      AppMethodBeat.i(119714);
      this$1 = localObject.findViewById(2131305334);
      p.g(a.this, "itemView.findViewById(R.…y_control_page_indicator)");
      this.view = a.this;
      AppMethodBeat.o(119714);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.a
 * JD-Core Version:    0.7.0.1
 */