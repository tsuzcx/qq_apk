package com.tencent.mm.plugin.story.ui.album;

import a.l;
import a.l.m;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroid/support/v7/widget/RecyclerView;", "getGridView", "()Landroid/support/v7/widget/RecyclerView;", "setGridView", "(Landroid/support/v7/widget/RecyclerView;)V", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"})
public final class a$d
  extends a.e
{
  private TextView rUI;
  private TextView rUK;
  RecyclerView sJa;
  private d sJb;
  private GridLayoutManager sJc;
  
  public a$d(View paramView)
  {
    super(paramView, localObject);
    AppMethodBeat.i(110146);
    paramView = localObject.findViewById(2131828241);
    a.f.b.j.p(paramView, "view.findViewById(R.id.a…_item_decoration_year_tv)");
    this.rUK = ((TextView)paramView);
    paramView = localObject.findViewById(2131828243);
    a.f.b.j.p(paramView, "view.findViewById(R.id.a…item_decoration_month_tv)");
    this.rUI = ((TextView)paramView);
    paramView = localObject.findViewById(2131828245);
    a.f.b.j.p(paramView, "view.findViewById(R.id.a…tem_decoration_grid_view)");
    this.sJa = ((RecyclerView)paramView);
    this.sJb = new d();
    localObject.getContext();
    this.sJc = new GridLayoutManager(4);
    AppMethodBeat.o(110146);
  }
  
  public final void Ge(int paramInt)
  {
    AppMethodBeat.i(110145);
    Object localObject1 = a.a(this.sIW).get(paramInt);
    a.f.b.j.p(localObject1, "mItemList[position]");
    Object localObject2 = (c)localObject1;
    Object localObject3;
    if ((paramInt > 0) && (!bo.isEqual(((c)a.a(this.sIW).get(paramInt - 1)).label, a.b(this.sIW))))
    {
      localObject1 = (c)a.a(this.sIW).get(paramInt - 1);
      if (!this.sIW.sIS)
      {
        this.rUI.setVisibility(0);
        localObject3 = ((c)localObject2).label;
        if (m.a((CharSequence)localObject3, ":", 0, false, 6) == -1) {
          break label410;
        }
        localObject3 = m.a((CharSequence)localObject3, new String[] { ":" });
        if (((List)localObject3).size() == 2)
        {
          this.rUI.setText((CharSequence)((List)localObject3).get(1));
          if ((localObject1 != null) && (!((c)localObject1).sJd.isEmpty())) {
            break label375;
          }
          paramInt = 0;
          label191:
          int i = ((h)((c)localObject2).sJd.get(0)).szQ.sGK;
          localObject1 = (String)((List)localObject3).get(0);
          paramInt /= 10000;
          i /= 10000;
          if (((paramInt != 0) || (i == a.c(this.sIW))) && ((paramInt == 0) || (i == paramInt))) {
            break label398;
          }
          this.rUK.setVisibility(0);
          this.rUK.setText((CharSequence)localObject1);
        }
      }
    }
    for (;;)
    {
      this.sJa.setLayoutManager((RecyclerView.i)this.sJc);
      this.sJa.setAdapter((RecyclerView.a)this.sJb);
      this.sJb.sIT = this.sIW.sIT;
      localObject1 = this.sJb;
      localObject2 = ((c)localObject2).sJd;
      a.f.b.j.q(localObject2, "datas");
      ((d)localObject1).sJe.clear();
      ((d)localObject1).sJe.addAll((Collection)localObject2);
      ((d)localObject1).notifyDataSetChanged();
      AppMethodBeat.o(110145);
      return;
      localObject1 = null;
      break;
      label375:
      paramInt = ((h)((c)localObject1).sJd.get(0)).szQ.sGK;
      break label191;
      label398:
      this.rUK.setVisibility(8);
      continue;
      label410:
      this.rUI.setText((CharSequence)localObject3);
      this.rUK.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a.d
 * JD-Core Version:    0.7.0.1
 */