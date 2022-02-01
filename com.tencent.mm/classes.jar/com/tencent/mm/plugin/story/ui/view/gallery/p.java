package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.as;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.ui.a.g;
import com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "width", "", "height", "(Landroid/view/View;II)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "horizontalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "getHorizontalControlView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "plugin-story_release"})
public final class p
  extends RecyclerView.v
{
  final RecyclerView fPw;
  final g yBu;
  final GalleryHorizontalControlView yBv;
  private final GalleryLayoutManager yxZ;
  
  public p(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView);
    AppMethodBeat.i(120669);
    Object localObject = paramView.findViewById(2131305432);
    k.g(localObject, "itemView.findViewById(R.…lery_horizontal_recycler)");
    this.fPw = ((RecyclerView)localObject);
    this.yBu = new g(paramInt1, paramInt2);
    localObject = paramView.getContext();
    k.g(localObject, "itemView.context");
    this.yxZ = new GalleryLayoutManager((Context)localObject, 0, (byte)0);
    paramView = paramView.findViewById(2131305436);
    k.g(paramView, "itemView.findViewById(R.…ory_gallery_page_control)");
    this.yBv = ((GalleryHorizontalControlView)paramView);
    this.fPw.setAdapter((RecyclerView.a)this.yBu);
    this.fPw.setLayoutManager((RecyclerView.i)this.yxZ);
    this.fPw.setFocusable(false);
    this.fPw.b((RecyclerView.h)new b(0));
    localObject = this.fPw.getItemAnimator();
    paramView = (View)localObject;
    if (!(localObject instanceof as)) {
      paramView = null;
    }
    paramView = (as)paramView;
    if (paramView != null) {
      paramView.lT();
    }
    this.fPw.setItemViewCacheSize(0);
    AppMethodBeat.o(120669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.p
 * JD-Core Version:    0.7.0.1
 */