package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.ui.layout.IndicatorLayoutManager;
import com.tencent.mm.ui.ap;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"})
public final class GalleryHorizontalControlView
  extends FrameLayout
{
  private final RecyclerView fKt;
  private final ArrayList<h> ykU;
  private final com.tencent.mm.plugin.story.ui.a.a yxW;
  
  public GalleryHorizontalControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(120348);
    AppMethodBeat.o(120348);
  }
  
  public GalleryHorizontalControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(120347);
    this.ykU = new ArrayList();
    View.inflate(paramContext, 2131495691, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305423);
    k.g(paramAttributeSet, "findViewById(R.id.story_gallery_control_recycler)");
    this.fKt = ((RecyclerView)paramAttributeSet);
    this.fKt.setLayoutManager((RecyclerView.i)new IndicatorLayoutManager(paramContext));
    this.yxW = new com.tencent.mm.plugin.story.ui.a.a();
    this.fKt.setAdapter((RecyclerView.a)this.yxW);
    this.fKt.setFocusable(false);
    this.fKt.setVisibility(8);
    setPadding(0, 0, 0, ap.eb(paramContext));
    AppMethodBeat.o(120347);
  }
  
  public final void fX(List<h> paramList)
  {
    AppMethodBeat.i(120345);
    k.h(paramList, "items");
    this.ykU.clear();
    this.ykU.addAll((Collection)paramList);
    paramList = this.yxW;
    List localList = (List)this.ykU;
    k.h(localList, "items");
    paramList.ykU.clear();
    paramList.ykU.addAll((Collection)localList);
    this.yxW.notifyDataSetChanged();
    if (this.ykU.size() <= 1)
    {
      this.fKt.setVisibility(8);
      AppMethodBeat.o(120345);
      return;
    }
    this.fKt.setVisibility(0);
    AppMethodBeat.o(120345);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(120346);
    Object localObject = this.yxW;
    if (((com.tencent.mm.plugin.story.ui.a.a)localObject).rZ != paramInt)
    {
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).ck(((com.tencent.mm.plugin.story.ui.a.a)localObject).rZ);
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).rZ = paramInt;
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).ck(((com.tencent.mm.plugin.story.ui.a.a)localObject).rZ);
    }
    localObject = this.fKt;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    ((RecyclerView)localObject).ca(((Integer)locala.lS(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(120346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView
 * JD-Core Version:    0.7.0.1
 */