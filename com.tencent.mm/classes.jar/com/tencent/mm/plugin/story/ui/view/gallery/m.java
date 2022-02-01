package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.ui.a.g;
import com.tencent.mm.plugin.story.ui.layout.GalleryLayoutManager;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "width", "", "height", "(Landroid/view/View;II)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "getAdapter", "()Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "horizontalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "getHorizontalControlView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends RecyclerView.v
{
  private final GalleryLayoutManager SAz;
  final g SDG;
  final GalleryHorizontalControlView SDH;
  final RecyclerView mkw;
  
  public m(View paramView, int paramInt1, int paramInt2)
  {
    super(paramView);
    AppMethodBeat.i(120669);
    Object localObject = paramView.findViewById(a.d.Sft);
    s.s(localObject, "itemView.findViewById(R.…lery_horizontal_recycler)");
    this.mkw = ((RecyclerView)localObject);
    this.SDG = new g(paramInt1, paramInt2);
    localObject = paramView.getContext();
    s.s(localObject, "itemView.context");
    this.SAz = new GalleryLayoutManager((Context)localObject, 0, (byte)0);
    paramView = paramView.findViewById(a.d.Sfx);
    s.s(paramView, "itemView.findViewById(R.…ory_gallery_page_control)");
    this.SDH = ((GalleryHorizontalControlView)paramView);
    this.mkw.setAdapter((RecyclerView.a)this.SDG);
    this.mkw.setLayoutManager((RecyclerView.LayoutManager)this.SAz);
    this.mkw.setFocusable(false);
    this.mkw.a((RecyclerView.h)new b(0));
    paramView = this.mkw.getItemAnimator();
    if ((paramView instanceof w)) {}
    for (paramView = (w)paramView;; paramView = null)
    {
      if (paramView != null) {
        paramView.cbd = false;
      }
      this.mkw.setItemViewCacheSize(0);
      AppMethodBeat.o(120669);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.m
 * JD-Core Version:    0.7.0.1
 */