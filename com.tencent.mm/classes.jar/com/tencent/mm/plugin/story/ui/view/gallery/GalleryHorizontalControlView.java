package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.f.d.h;
import com.tencent.mm.plugin.story.ui.layout.IndicatorLayoutManager;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"})
public final class GalleryHorizontalControlView
  extends FrameLayout
{
  private final ArrayList<h> LMk;
  private final com.tencent.mm.plugin.story.ui.a.a LYY;
  private final RecyclerView jEA;
  
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
    this.LMk = new ArrayList();
    View.inflate(paramContext, a.e.LCV, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.LBB);
    p.j(paramAttributeSet, "findViewById(R.id.story_gallery_control_recycler)");
    this.jEA = ((RecyclerView)paramAttributeSet);
    this.jEA.setLayoutManager((RecyclerView.LayoutManager)new IndicatorLayoutManager(paramContext));
    this.LYY = new com.tencent.mm.plugin.story.ui.a.a();
    this.jEA.setAdapter((RecyclerView.a)this.LYY);
    this.jEA.setFocusable(false);
    this.jEA.setVisibility(8);
    setPadding(0, 0, 0, ax.aB(paramContext));
    AppMethodBeat.o(120347);
  }
  
  public final void gg(List<h> paramList)
  {
    AppMethodBeat.i(120345);
    p.k(paramList, "items");
    this.LMk.clear();
    this.LMk.addAll((Collection)paramList);
    paramList = this.LYY;
    List localList = (List)this.LMk;
    p.k(localList, "items");
    paramList.LMk.clear();
    paramList.LMk.addAll((Collection)localList);
    this.LYY.notifyDataSetChanged();
    if (this.LMk.size() <= 1)
    {
      this.jEA.setVisibility(8);
      AppMethodBeat.o(120345);
      return;
    }
    this.jEA.setVisibility(0);
    AppMethodBeat.o(120345);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(120346);
    Object localObject = this.LYY;
    if (((com.tencent.mm.plugin.story.ui.a.a)localObject).bFx != paramInt)
    {
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).cL(((com.tencent.mm.plugin.story.ui.a.a)localObject).bFx);
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).bFx = paramInt;
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).cL(((com.tencent.mm.plugin.story.ui.a.a)localObject).bFx);
    }
    localObject = this.jEA;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sf(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(120346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView
 * JD-Core Version:    0.7.0.1
 */