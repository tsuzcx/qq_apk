package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.ui.layout.IndicatorLayoutManager;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"})
public final class GalleryHorizontalControlView
  extends FrameLayout
{
  private final com.tencent.mm.plugin.story.ui.a.a FEX;
  private final ArrayList<h> Fsh;
  private final RecyclerView gTW;
  
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
    this.Fsh = new ArrayList();
    View.inflate(paramContext, 2131496596, (ViewGroup)this);
    paramAttributeSet = findViewById(2131308629);
    p.g(paramAttributeSet, "findViewById(R.id.story_gallery_control_recycler)");
    this.gTW = ((RecyclerView)paramAttributeSet);
    this.gTW.setLayoutManager((RecyclerView.LayoutManager)new IndicatorLayoutManager(paramContext));
    this.FEX = new com.tencent.mm.plugin.story.ui.a.a();
    this.gTW.setAdapter((RecyclerView.a)this.FEX);
    this.gTW.setFocusable(false);
    this.gTW.setVisibility(8);
    setPadding(0, 0, 0, au.aD(paramContext));
    AppMethodBeat.o(120347);
  }
  
  public final void hw(List<h> paramList)
  {
    AppMethodBeat.i(120345);
    p.h(paramList, "items");
    this.Fsh.clear();
    this.Fsh.addAll((Collection)paramList);
    paramList = this.FEX;
    List localList = (List)this.Fsh;
    p.h(localList, "items");
    paramList.Fsh.clear();
    paramList.Fsh.addAll((Collection)localList);
    this.FEX.notifyDataSetChanged();
    if (this.Fsh.size() <= 1)
    {
      this.gTW.setVisibility(8);
      AppMethodBeat.o(120345);
      return;
    }
    this.gTW.setVisibility(0);
    AppMethodBeat.o(120345);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(120346);
    Object localObject = this.FEX;
    if (((com.tencent.mm.plugin.story.ui.a.a)localObject).va != paramInt)
    {
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).ci(((com.tencent.mm.plugin.story.ui.a.a)localObject).va);
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).va = paramInt;
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).ci(((com.tencent.mm.plugin.story.ui.a.a)localObject).va);
    }
    localObject = this.gTW;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    ((RecyclerView)localObject).scrollToPosition(((Integer)locala.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(120346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView
 * JD-Core Version:    0.7.0.1
 */