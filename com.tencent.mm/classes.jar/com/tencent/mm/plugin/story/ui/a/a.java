package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.d.h;
import d.l;
import java.util.ArrayList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter$ControlViewHolder;", "()V", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "selectedPosition", "", "getItemCount", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelected", "update", "items", "", "ControlViewHolder", "plugin-story_release"})
public final class a
  extends RecyclerView.a<a.a>
{
  public int ta;
  public final ArrayList<h> zxT;
  
  public a()
  {
    AppMethodBeat.i(119718);
    this.zxT = new ArrayList();
    AppMethodBeat.o(119718);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119716);
    int i = this.zxT.size();
    AppMethodBeat.o(119716);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.a
 * JD-Core Version:    0.7.0.1
 */