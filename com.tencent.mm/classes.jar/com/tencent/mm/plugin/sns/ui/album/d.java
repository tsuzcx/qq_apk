package com.tencent.mm.plugin.sns.ui.album;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.m;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class d
  extends RecyclerView.m
{
  public abstract void ZC();
  
  public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mu(paramInt1);
    localb.mu(paramInt2);
    a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
    super.a(paramRecyclerView, paramInt1, paramInt2);
    a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
  }
  
  public final void b(RecyclerView paramRecyclerView, int paramInt)
  {
    b localb = new b();
    localb.bd(paramRecyclerView);
    localb.mu(paramInt);
    a.b("com/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
    super.b(paramRecyclerView, paramInt);
    paramRecyclerView = (LinearLayoutManager)paramRecyclerView.getLayoutManager();
    if ((paramInt == 0) && (paramRecyclerView.kp() == paramRecyclerView.getItemCount() - 1)) {
      ZC();
    }
    a.a(this, "com/tencent/mm/plugin/sns/ui/album/SnsAlbumScrollListener", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.album.d
 * JD-Core Version:    0.7.0.1
 */