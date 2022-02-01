package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "width", "", "height", "(II)V", "flipItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "getHeight", "()I", "isActive", "", "()Z", "setActive", "(Z)V", "onItemLongClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getWidth", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "plugin-story_release"})
public final class g
  extends RecyclerView.a<i>
{
  private final int height;
  public boolean isActive;
  private final int width;
  private final ArrayList<h> zEr;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119771);
    this.width = paramInt1;
    this.height = paramInt2;
    this.zEr = new ArrayList();
    AppMethodBeat.o(119771);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119767);
    int i = this.zEr.size();
    AppMethodBeat.o(119767);
    return i;
  }
  
  public final void gf(List<h> paramList)
  {
    AppMethodBeat.i(119766);
    k.h(paramList, "items");
    this.zEr.clear();
    this.zEr.addAll((Collection)paramList);
    AppMethodBeat.o(119766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.g
 * JD-Core Version:    0.7.0.1
 */