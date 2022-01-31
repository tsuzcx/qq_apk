package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
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

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "width", "", "height", "(Landroid/view/View;II)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "horizontalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "getHorizontalControlView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "plugin-story_release"})
public final class s
  extends RecyclerView.v
{
  final RecyclerView iQe;
  private final com.tencent.mm.plugin.story.ui.b.b sRX;
  final g sVK;
  final GalleryHorizontalControlView sVL;
  
  public s(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView);
    AppMethodBeat.i(111013);
    Object localObject = paramView.findViewById(2131828415);
    j.p(localObject, "itemView.findViewById(R.…lery_horizontal_recycler)");
    this.iQe = ((RecyclerView)localObject);
    this.sVK = new g(paramInt1, paramInt2);
    localObject = paramView.getContext();
    j.p(localObject, "itemView.context");
    this.sRX = new com.tencent.mm.plugin.story.ui.b.b((Context)localObject, 0, (byte)0);
    paramView = paramView.findViewById(2131828416);
    j.p(paramView, "itemView.findViewById(R.…ory_gallery_page_control)");
    this.sVL = ((GalleryHorizontalControlView)paramView);
    this.iQe.setAdapter((RecyclerView.a)this.sVK);
    this.iQe.setLayoutManager((RecyclerView.i)this.sRX);
    this.iQe.setFocusable(false);
    this.iQe.b((RecyclerView.h)new b(0));
    localObject = this.iQe.getItemAnimator();
    paramView = (View)localObject;
    if (!(localObject instanceof as)) {
      paramView = null;
    }
    paramView = (as)paramView;
    if (paramView != null) {
      paramView.ks();
    }
    this.iQe.setItemViewCacheSize(0);
    AppMethodBeat.o(111013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.s
 * JD-Core Version:    0.7.0.1
 */