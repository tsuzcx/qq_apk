package com.tencent.mm.plugin.story.ui.album;

import a.f.b.j;
import a.l;
import a.v;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "()V", "onLoadMore", "", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
public abstract class e
  extends RecyclerView.m
{
  public abstract void Kt();
  
  public final void c(RecyclerView paramRecyclerView, int paramInt)
  {
    super.c(paramRecyclerView, paramInt);
    if (paramRecyclerView == null) {
      j.ebi();
    }
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null) {
      throw new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    if ((paramInt == 0) && (paramRecyclerView.iw() == paramRecyclerView.getItemCount() - 1)) {
      Kt();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.e
 * JD-Core Version:    0.7.0.1
 */