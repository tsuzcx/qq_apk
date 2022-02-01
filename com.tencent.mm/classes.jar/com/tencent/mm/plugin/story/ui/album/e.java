package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "()V", "onLoadMore", "", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
public abstract class e
  extends RecyclerView.l
{
  public abstract void onLoadMore();
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt);
    a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
    p.h(paramRecyclerView, "recyclerView");
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null) {
      throw new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    if ((paramInt == 0) && (paramRecyclerView.kv() == paramRecyclerView.getItemCount() - 1)) {
      onLoadMore();
    }
    a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
  }
  
  public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bm(paramRecyclerView);
    localb.pH(paramInt1);
    localb.pH(paramInt2);
    a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.e
 * JD-Core Version:    0.7.0.1
 */