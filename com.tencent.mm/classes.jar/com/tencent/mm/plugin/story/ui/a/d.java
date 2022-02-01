package com.tencent.mm.plugin.story.ui.a;

import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import d.l;
import java.util.ArrayList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "T", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "()V", "dataList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "getItemCount", "", "removeAt", "", "userIndex", "update", "users", "", "Companion", "plugin-story_release"})
public abstract class d<T extends RecyclerView.w>
  extends RecyclerView.a<T>
{
  public static final a AVw = new a((byte)0);
  public final ArrayList<String> jfg = new ArrayList();
  
  public int getItemCount()
  {
    return this.jfg.size();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter$Companion;", "", "()V", "empty", "", "plugin-story_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.a.d
 * JD-Core Version:    0.7.0.1
 */