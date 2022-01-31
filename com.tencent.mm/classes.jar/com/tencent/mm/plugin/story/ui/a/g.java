package com.tencent.mm.plugin.story.ui.a;

import a.f.b.j;
import a.l;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "width", "", "height", "(II)V", "flipItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "getHeight", "()I", "isActive", "", "()Z", "setActive", "(Z)V", "onItemLongClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getWidth", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "plugin-story_release"})
public final class g
  extends RecyclerView.a<i>
{
  private final int height;
  public boolean isActive;
  private final ArrayList<com.tencent.mm.plugin.story.model.d.g> sIG;
  private final int width;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(110136);
    this.width = paramInt1;
    this.height = paramInt2;
    this.sIG = new ArrayList();
    AppMethodBeat.o(110136);
  }
  
  public final void dH(List<com.tencent.mm.plugin.story.model.d.g> paramList)
  {
    AppMethodBeat.i(110131);
    j.q(paramList, "items");
    this.sIG.clear();
    this.sIG.addAll((Collection)paramList);
    AppMethodBeat.o(110131);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(110132);
    int i = this.sIG.size();
    AppMethodBeat.o(110132);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.g
 * JD-Core Version:    0.7.0.1
 */