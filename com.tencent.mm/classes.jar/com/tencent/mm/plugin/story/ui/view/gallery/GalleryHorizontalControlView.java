package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.plugin.story.model.d.h;
import com.tencent.mm.plugin.story.ui.layout.IndicatorLayoutManager;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GalleryHorizontalControlView
  extends FrameLayout
{
  private final com.tencent.mm.plugin.story.ui.a.a SAv;
  private final ArrayList<h> Spr;
  private final RecyclerView mex;
  
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
    this.Spr = new ArrayList();
    View.inflate(paramContext, a.e.SgG, (ViewGroup)this);
    paramAttributeSet = findViewById(a.d.Sfm);
    s.s(paramAttributeSet, "findViewById(R.id.story_gallery_control_recycler)");
    this.mex = ((RecyclerView)paramAttributeSet);
    this.mex.setLayoutManager((RecyclerView.LayoutManager)new IndicatorLayoutManager(paramContext));
    this.SAv = new com.tencent.mm.plugin.story.ui.a.a();
    this.mex.setAdapter((RecyclerView.a)this.SAv);
    this.mex.setFocusable(false);
    this.mex.setVisibility(8);
    setPadding(0, 0, 0, bf.bk(paramContext));
    AppMethodBeat.o(120347);
  }
  
  public final void hM(List<h> paramList)
  {
    AppMethodBeat.i(120345);
    s.u(paramList, "items");
    this.Spr.clear();
    this.Spr.addAll((Collection)paramList);
    paramList = this.SAv;
    List localList = (List)this.Spr;
    s.u(localList, "items");
    paramList.Spr.clear();
    paramList.Spr.addAll((Collection)localList);
    this.SAv.bZE.notifyChanged();
    if (this.Spr.size() <= 1)
    {
      this.mex.setVisibility(8);
      AppMethodBeat.o(120345);
      return;
    }
    this.mex.setVisibility(0);
    AppMethodBeat.o(120345);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(120346);
    Object localObject = this.SAv;
    if (((com.tencent.mm.plugin.story.ui.a.a)localObject).dyx != paramInt)
    {
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).fV(((com.tencent.mm.plugin.story.ui.a.a)localObject).dyx);
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).dyx = paramInt;
      ((com.tencent.mm.plugin.story.ui.a.a)localObject).fV(((com.tencent.mm.plugin.story.ui.a.a)localObject).dyx);
    }
    localObject = this.mex;
    com.tencent.mm.hellhoundlib.b.a locala = c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    ((RecyclerView)localObject).scrollToPosition(((Integer)locala.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView", "setSelection", "(I)V", "Undefined", "scrollToPosition", "(I)V");
    AppMethodBeat.o(120346);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView
 * JD-Core Version:    0.7.0.1
 */