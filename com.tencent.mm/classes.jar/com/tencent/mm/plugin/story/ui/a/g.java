package com.tencent.mm.plugin.story.ui.a;

import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryViewHolder;", "width", "", "height", "(II)V", "flipItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "getHeight", "()I", "isActive", "", "()Z", "setActive", "(Z)V", "onItemLongClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "position", "item", "", "getOnItemLongClickListener", "()Lkotlin/jvm/functions/Function2;", "setOnItemLongClickListener", "(Lkotlin/jvm/functions/Function2;)V", "getWidth", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends RecyclerView.a<i>
{
  private final ArrayList<h> Suw;
  private final int height;
  public boolean isActive;
  private final int width;
  
  public g(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(119771);
    this.width = paramInt1;
    this.height = paramInt2;
    this.Suw = new ArrayList();
    AppMethodBeat.o(119771);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119767);
    int i = this.Suw.size();
    AppMethodBeat.o(119767);
    return i;
  }
  
  public final void hM(List<h> paramList)
  {
    AppMethodBeat.i(119766);
    s.u(paramList, "items");
    this.Suw.clear();
    this.Suw.addAll((Collection)paramList);
    AppMethodBeat.o(119766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.g
 * JD-Core Version:    0.7.0.1
 */