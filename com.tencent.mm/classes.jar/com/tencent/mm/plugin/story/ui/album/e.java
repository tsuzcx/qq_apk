package com.tencent.mm.plugin.story.ui.album;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import d.g.b.p;
import d.l;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener;", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "()V", "onLoadMore", "", "onScrollStateChanged", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-story_release"})
public abstract class e
  extends RecyclerView.m
{
  public abstract void Zt();
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt1);
    localb.mr(paramInt2);
    a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mr(paramInt);
    a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
    p.h(paramRecyclerView, "recyclerView");
    super.b(paramRecyclerView, paramInt);
    paramRecyclerView = paramRecyclerView.getLayoutManager();
    if (paramRecyclerView == null) {
      throw new v("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    }
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
    if ((paramInt == 0) && (paramRecyclerView.kp() == paramRecyclerView.getItemCount() - 1)) {
      Zt();
    }
    a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.e
 * JD-Core Version:    0.7.0.1
 */