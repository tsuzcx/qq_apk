package com.tencent.mm.plugin.story.ui.a;

import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "()V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "getItemCount", "", "removeAt", "", "userIndex", "update", "users", "", "Companion", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d<T extends RecyclerView.v>
  extends RecyclerView.a<T>
{
  public static final a Suh = new a((byte)0);
  public final ArrayList<String> pUj = new ArrayList();
  
  public int getItemCount()
  {
    return this.pUj.size();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter$Companion;", "", "()V", "empty", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.d
 * JD-Core Version:    0.7.0.1
 */