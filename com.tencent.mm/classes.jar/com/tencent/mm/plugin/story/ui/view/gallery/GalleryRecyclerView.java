package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.m;
import a.f.a.q;
import a.f.b.j;
import a.l;
import a.v;
import a.y;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.n;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "Landroid/support/v7/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "childControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "childRecyclerView", "value", "", "isActive", "()Z", "setActive", "(Z)V", "layoutManager", "Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/story/ui/layout/GalleryLayoutManager;", "onRowSelected", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "row", "rowView", "pageControl", "", "getOnRowSelected", "()Lkotlin/jvm/functions/Function3;", "setOnRowSelected", "(Lkotlin/jvm/functions/Function3;)V", "onScrollCallback", "Lkotlin/Function2;", "position", "", "offset", "getOnScrollCallback", "()Lkotlin/jvm/functions/Function2;", "setOnScrollCallback", "(Lkotlin/jvm/functions/Function2;)V", "selectedRow", "child", "Landroid/view/View;", "setScrollEnable", "enabled", "Companion", "VerticalAdapter", "plugin-story_release"})
public final class GalleryRecyclerView
  extends RecyclerView
{
  private static final String TAG = "MicroMsg.GalleryRecyclerView";
  public static final GalleryRecyclerView.a sSb;
  boolean isActive;
  int sBk;
  private final com.tencent.mm.plugin.story.ui.b.b sRX;
  RecyclerView sRY;
  q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, y> sRZ;
  private m<? super Integer, ? super Float, y> sSa;
  
  static
  {
    AppMethodBeat.i(110731);
    sSb = new GalleryRecyclerView.a((byte)0);
    TAG = "MicroMsg.GalleryRecyclerView";
    AppMethodBeat.o(110731);
  }
  
  public GalleryRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110730);
    AppMethodBeat.o(110730);
  }
  
  public GalleryRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110729);
    this.sRX = new com.tencent.mm.plugin.story.ui.b.b(paramContext);
    setLayoutManager((RecyclerView.i)this.sRX);
    this.sRX.lCm = ((m)new GalleryRecyclerView.1(this));
    this.sRX.sKd = ((m)new GalleryRecyclerView.2(this));
    b((RecyclerView.h)new b(1));
    setItemAnimator(null);
    setItemViewCacheSize(0);
    AppMethodBeat.o(110729);
  }
  
  public final com.tencent.mm.plugin.story.ui.b.b getLayoutManager()
  {
    return this.sRX;
  }
  
  public final q<Integer, RecyclerView, GalleryHorizontalControlView, y> getOnRowSelected()
  {
    return this.sRZ;
  }
  
  public final m<Integer, Float, y> getOnScrollCallback()
  {
    return this.sSa;
  }
  
  public final void setActive(boolean paramBoolean)
  {
    AppMethodBeat.i(151307);
    this.isActive = paramBoolean;
    Object localObject = this.sRY;
    if (localObject != null)
    {
      localObject = ((RecyclerView)localObject).getAdapter();
      if (!(localObject instanceof com.tencent.mm.plugin.story.ui.a.g)) {
        break label84;
      }
      localObject = this.sRY;
      if (localObject == null) {
        break label71;
      }
    }
    label71:
    for (localObject = ((RecyclerView)localObject).getAdapter();; localObject = null)
    {
      if (localObject != null) {
        break label76;
      }
      localObject = new v("null cannot be cast to non-null type com.tencent.mm.plugin.story.ui.adapter.StoryGalleryAdapter");
      AppMethodBeat.o(151307);
      throw ((Throwable)localObject);
      localObject = null;
      break;
    }
    label76:
    ((com.tencent.mm.plugin.story.ui.a.g)localObject).isActive = paramBoolean;
    label84:
    AppMethodBeat.o(151307);
  }
  
  public final void setOnRowSelected(q<? super Integer, ? super RecyclerView, ? super GalleryHorizontalControlView, y> paramq)
  {
    this.sRZ = paramq;
  }
  
  public final void setOnScrollCallback(m<? super Integer, ? super Float, y> paramm)
  {
    this.sSa = paramm;
  }
  
  public final void setScrollEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(110728);
    this.sRX.sKe = paramBoolean;
    Object localObject = this.sRY;
    if (localObject != null) {}
    for (localObject = ((RecyclerView)localObject).getLayoutManager();; localObject = null)
    {
      if ((localObject instanceof com.tencent.mm.plugin.story.ui.b.b)) {
        ((com.tencent.mm.plugin.story.ui.b.b)localObject).sKe = paramBoolean;
      }
      AppMethodBeat.o(110728);
      return;
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/view/gallery/VerticalViewHolder;", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;)V", "bindCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getBindCallback", "()Lkotlin/jvm/functions/Function1;", "setBindCallback", "(Lkotlin/jvm/functions/Function1;)V", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "pool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "prePosition", "preRow", "getItemCount", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onViewAttachedToWindow", "update", "items", "", "updateChildRecyclerPosition", "row", "plugin-story_release"})
  public final class b
    extends RecyclerView.a<s>
  {
    private final ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.g>> sCc;
    a.f.a.b<? super Integer, y> sSd;
    int sSe;
    int sSf;
    private final RecyclerView.n sSg;
    
    public b()
    {
      AppMethodBeat.i(151306);
      this.sCc = new ArrayList();
      this.sSe = -1;
      this.sSg = new RecyclerView.n();
      this.sSg.aB(0, 2);
      AppMethodBeat.o(151306);
    }
    
    public final void dH(List<? extends ArrayList<com.tencent.mm.plugin.story.model.d.g>> paramList)
    {
      AppMethodBeat.i(151301);
      j.q(paramList, "items");
      this.sCc.clear();
      this.sCc.addAll((Collection)paramList);
      AppMethodBeat.o(151301);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(151303);
      int i = this.sCc.size();
      AppMethodBeat.o(151303);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView
 * JD-Core Version:    0.7.0.1
 */