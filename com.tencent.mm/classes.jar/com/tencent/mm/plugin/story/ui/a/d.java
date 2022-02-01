package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import d.l;
import java.util.ArrayList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "T", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "getItemCount", "", "removeAt", "", "userIndex", "update", "users", "", "Companion", "plugin-story_release"})
public abstract class d<T extends RecyclerView.v>
  extends RecyclerView.a<T>
{
  public static final a yqz = new a((byte)0);
  public final ArrayList<String> dataList = new ArrayList();
  
  public int getItemCount()
  {
    return this.dataList.size();
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter$Companion;", "", "()V", "empty", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.d
 * JD-Core Version:    0.7.0.1
 */