package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.model.d.g;
import com.tencent.mm.plugin.story.ui.a.a;
import com.tencent.mm.plugin.story.ui.b.c;
import com.tencent.mm.ui.am;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/plugin/story/ui/adapter/ControlAdapter;", "galleryItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "recycler", "Landroid/support/v7/widget/RecyclerView;", "setSelection", "", "position", "update", "items", "", "updateView", "plugin-story_release"})
public final class GalleryHorizontalControlView
  extends FrameLayout
{
  private final RecyclerView euP;
  private final ArrayList<g> sCc;
  private final a sRU;
  
  public GalleryHorizontalControlView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(110723);
    AppMethodBeat.o(110723);
  }
  
  public GalleryHorizontalControlView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(110722);
    this.sCc = new ArrayList();
    View.inflate(paramContext, 2130970953, (ViewGroup)this);
    paramAttributeSet = findViewById(2131828407);
    j.p(paramAttributeSet, "findViewById(R.id.story_gallery_control_recycler)");
    this.euP = ((RecyclerView)paramAttributeSet);
    this.euP.setLayoutManager((RecyclerView.i)new c(paramContext));
    this.sRU = new a();
    this.euP.setAdapter((RecyclerView.a)this.sRU);
    this.euP.setFocusable(false);
    this.euP.setVisibility(8);
    setPadding(0, 0, 0, am.fx(paramContext));
    AppMethodBeat.o(110722);
  }
  
  public final void dH(List<g> paramList)
  {
    AppMethodBeat.i(110720);
    j.q(paramList, "items");
    this.sCc.clear();
    this.sCc.addAll((Collection)paramList);
    paramList = this.sRU;
    List localList = (List)this.sCc;
    j.q(localList, "items");
    paramList.sCc.clear();
    paramList.sCc.addAll((Collection)localList);
    this.sRU.notifyDataSetChanged();
    if (this.sCc.size() <= 1)
    {
      this.euP.setVisibility(8);
      AppMethodBeat.o(110720);
      return;
    }
    this.euP.setVisibility(0);
    AppMethodBeat.o(110720);
  }
  
  public final void setSelection(int paramInt)
  {
    AppMethodBeat.i(110721);
    a locala = this.sRU;
    if (locala.lxQ != paramInt)
    {
      locala.bR(locala.lxQ);
      locala.lxQ = paramInt;
      locala.bR(locala.lxQ);
    }
    this.euP.bJ(paramInt);
    AppMethodBeat.o(110721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.GalleryHorizontalControlView
 * JD-Core Version:    0.7.0.1
 */