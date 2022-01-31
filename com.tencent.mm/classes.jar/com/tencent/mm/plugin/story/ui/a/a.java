package com.tencent.mm.plugin.story.ui.a;

import a.l;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.g;
import java.util.ArrayList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter$ControlViewHolder;", "()V", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelected", "update", "items", "", "ControlViewHolder", "plugin-story_release"})
public final class a
  extends RecyclerView.a<a.a>
{
  public int lxQ;
  public final ArrayList<g> sCc;
  
  public a()
  {
    AppMethodBeat.i(110091);
    this.sCc = new ArrayList();
    AppMethodBeat.o(110091);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(110089);
    int i = this.sCc.size();
    AppMethodBeat.o(110089);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.a
 * JD-Core Version:    0.7.0.1
 */