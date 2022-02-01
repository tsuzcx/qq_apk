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
import com.tencent.mm.ui.ar;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"})
public final class GalleryHorizontalControlView
  extends FrameLayout
{
  private final ArrayList<h> APS;
  private final com.tencent.mm.plugin.story.ui.a.a BcM;
  private final RecyclerView ghz;
  
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
    this.APS = new ArrayList();
    View.inflate(paramContext, 2131495691, (ViewGroup)this);
    paramAttributeSet = findViewById(2131305423);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_control_recycler)");
    this.ghz = ((RecyclerView)paramAttributeSet);
    this.ghz.setLayoutManager((RecyclerView.i)new IndicatorLayoutManager(paramContext));
    this.BcM = new com.tencent.mm.plugin.story.ui.a.a();
    this.ghz.setAdapter((RecyclerView.a)this.BcM);
    this.ghz.setFocusable(false);
    this.ghz.setVisibility(8);
    setPadding(0, 0, 0, ar.ej(paramContext));
    AppMethodBeat.o(120347);
  }
  
  public final void gq(List<h> paramList)
  {
    AppMethodBeat.i(120345);
    p.h(paramList, "items");
    this.APS.clear();
    this.APS.addAll((Collection)paramList);
    paramList = this.BcM;
    List localList = (List)this.APS;
    p.h(localList, "items");
    paramList.APS.clear();
    paramList.APS.addAll((Collection)localList);
    this.BcM.notifyDataSetChanged();
    if (this.APS.size() <= 1)
    {
      this.ghz.setVisibility(8);
      AppMethodBeat.o(120345);
      return;
    }
    this.ghz.setVisibility(0);
    AppMethodBeat.o(120345);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(120346);
    Object localObject = this.BcM;
    if (((com.tencent.mm.plugin.story.ui.a.a)localObject).uT != paramInt)
    {
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).cj(((com.tencent.mm.plugin.story.ui.a.a)localObject).uT);
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).uT = paramInt;
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).cj(((com.tencent.mm.plugin.story.ui.a.a)localObject).uT);
    }
    localObject = this.ghz;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    ((RecyclerView)localObject).ca(((Integer)locala.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(120346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView
 * JD-Core Version:    0.7.0.1
 */