package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.ui.a.g;
import com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "width", "", "height", "(Landroid/view/View;II)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "horizontalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "getHorizontalControlView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "plugin-story_release"})
public final class p
  extends RecyclerView.v
{
  private final GalleryLayoutManager LZb;
  final g Mcq;
  final GalleryHorizontalControlView Mcr;
  final RecyclerView jLl;
  
  public p(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView);
    AppMethodBeat.i(120669);
    Object localObject = paramView.findViewById(a.d.LBI);
    kotlin.g.b.p.j(localObject, "itemView.findViewById(R.…lery_horizontal_recycler)");
    this.jLl = ((RecyclerView)localObject);
    this.Mcq = new g(paramInt1, paramInt2);
    localObject = paramView.getContext();
    kotlin.g.b.p.j(localObject, "itemView.context");
    this.LZb = new GalleryLayoutManager((Context)localObject, 0, (byte)0);
    paramView = paramView.findViewById(a.d.LBM);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.…ory_gallery_page_control)");
    this.Mcr = ((GalleryHorizontalControlView)paramView);
    this.jLl.setAdapter((RecyclerView.a)this.Mcq);
    this.jLl.setLayoutManager((RecyclerView.LayoutManager)this.LZb);
    this.jLl.setFocusable(false);
    this.jLl.b((RecyclerView.h)new b(0));
    localObject = this.jLl.getItemAnimator();
    paramView = (View)localObject;
    if (!(localObject instanceof y)) {
      paramView = null;
    }
    paramView = (y)paramView;
    if (paramView != null) {
      paramView.mu();
    }
    this.jLl.setItemViewCacheSize(0);
    AppMethodBeat.o(120669);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.p
 * JD-Core Version:    0.7.0.1
 */