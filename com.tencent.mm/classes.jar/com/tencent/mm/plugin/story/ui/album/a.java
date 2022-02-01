package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"})
public final class a
  extends RecyclerView.a<e>
{
  public static final a FyI;
  static final String TAG = "MicroMsg.StoryAlbumAdapter";
  private final int ESY;
  private final int FyA;
  private final int FyB;
  private ArrayList<com.tencent.mm.plugin.story.i.j> FyC;
  private final int FyD;
  private int FyE;
  boolean FyF;
  kotlin.g.a.b<? super h, x> FyG;
  kotlin.g.a.a<x> FyH;
  private final String Fyy;
  private final String Fyz;
  ArrayList<c> mItemList;
  boolean qhf;
  
  static
  {
    AppMethodBeat.i(119818);
    FyI = new a((byte)0);
    TAG = "MicroMsg.StoryAlbumAdapter";
    AppMethodBeat.o(119818);
  }
  
  public a()
  {
    AppMethodBeat.i(119817);
    this.Fyy = "loadingMore";
    this.Fyz = "favorite";
    this.ESY = 1;
    this.FyB = 2;
    this.mItemList = new ArrayList();
    this.FyC = new ArrayList();
    com.tencent.mm.plugin.story.e.a.a locala = com.tencent.mm.plugin.story.e.a.Flw;
    this.FyD = new GregorianCalendar().get(1);
    AppMethodBeat.o(119817);
  }
  
  public final int g(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119816);
    kotlin.g.b.p.h(paramj, "storyInfo");
    Log.d(TAG, "storyLocalId=" + (int)paramj.systemRowid);
    int k = ((Collection)this.mItemList).size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Iterator localIterator = ((c)this.mItemList.get(i)).FyP.iterator();
      while (localIterator.hasNext())
      {
        if ((int)((h)localIterator.next()).Fqr.systemRowid == (int)paramj.systemRowid)
        {
          Log.d(TAG, "findPositionInGallery index=%s", new Object[] { Integer.valueOf(j) });
          AppMethodBeat.o(119816);
          return j;
        }
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(119816);
    return j;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119814);
    int i = this.mItemList.size();
    AppMethodBeat.o(119814);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119813);
    if (Util.isEqual(((c)this.mItemList.get(paramInt)).label, this.Fyy))
    {
      paramInt = this.ESY;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    if (Util.isEqual(((c)this.mItemList.get(paramInt)).label, this.Fyz))
    {
      paramInt = this.FyB;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    paramInt = this.FyA;
    AppMethodBeat.o(119813);
    return paramInt;
  }
  
  public final void hy(List<c> paramList)
  {
    AppMethodBeat.i(119815);
    kotlin.g.b.p.h(paramList, "datas");
    Log.i(TAG, "updateDatas");
    this.mItemList.clear();
    if (com.tencent.mm.plugin.textstatus.a.p.fvC()) {}
    for (boolean bool = com.tencent.mm.plugin.story.c.a.a.FkW.gIi();; bool = com.tencent.mm.plugin.story.c.a.a.FkW.fnd())
    {
      if ((bool) && (!this.FyF))
      {
        this.mItemList.add(new c(this.Fyz, null, 2));
        Log.i(TAG, "updateDatas add fav");
      }
      this.mItemList.addAll((Collection)paramList);
      Iterator localIterator = ((Iterable)this.mItemList).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        int i = this.FyE;
        this.FyE = (localc.FyP.size() + i);
      }
    }
    if (!paramList.isEmpty()) {
      this.mItemList.add(new c(this.Fyy, null, 2));
    }
    notifyDataSetChanged();
    AppMethodBeat.o(119815);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
  public final class b
    extends a.e
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(119806);
      AppMethodBeat.o(119806);
    }
    
    public final void abc(int paramInt)
    {
      AppMethodBeat.i(119805);
      this.aus.setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(119805);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(a.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119804);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = this.FyK.FyJ.FyH;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119804);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"})
  public final class c
    extends a.e
  {
    private ViewGroup FyL;
    private ImageView FyM;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119808);
      this$1 = localObject.findViewById(2131303707);
      kotlin.g.b.p.g(a.this, "view.findViewById(R.id.loading_more_state)");
      this.FyL = ((ViewGroup)a.this);
      this$1 = localObject.findViewById(2131296661);
      kotlin.g.b.p.g(a.this, "view.findViewById(R.id.album_is_all_view)");
      this.FyM = ((ImageView)a.this);
      AppMethodBeat.o(119808);
    }
    
    public final void abc(int paramInt)
    {
      AppMethodBeat.i(119807);
      if (a.d(a.this))
      {
        this.FyL.setVisibility(8);
        this.FyM.setVisibility(0);
        AppMethodBeat.o(119807);
        return;
      }
      a.e(a.this);
      Object localObject = com.tencent.mm.plugin.story.f.j.Fmy;
      if (j.b.fol().DMv <= 0)
      {
        localObject = com.tencent.mm.plugin.story.e.b.FlA;
        localObject = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        String str = com.tencent.mm.plugin.story.e.b.fnC();
        com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.FvD;
        ((SharedPreferences)localObject).getInt(str, com.tencent.mm.plugin.story.i.a.fqK());
      }
      this.FyL.setVisibility(0);
      this.FyM.setVisibility(8);
      AppMethodBeat.o(119807);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroid/support/v7/widget/RecyclerView;", "getGridView", "()Landroid/support/v7/widget/RecyclerView;", "setGridView", "(Landroid/support/v7/widget/RecyclerView;)V", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"})
  public final class d
    extends a.e
  {
    private TextView EIh;
    private TextView EIj;
    RecyclerView FyN;
    private d FyO;
    private GridLayoutManager haU;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119810);
      this$1 = localObject.findViewById(2131296690);
      kotlin.g.b.p.g(a.this, "view.findViewById(R.id.a…_item_decoration_year_tv)");
      this.EIj = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296689);
      kotlin.g.b.p.g(a.this, "view.findViewById(R.id.a…item_decoration_month_tv)");
      this.EIh = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296687);
      kotlin.g.b.p.g(a.this, "view.findViewById(R.id.a…tem_decoration_grid_view)");
      this.FyN = ((RecyclerView)a.this);
      this.FyO = new d();
      localObject.getContext();
      this.haU = new GridLayoutManager(4);
      AppMethodBeat.o(119810);
    }
    
    public final void abc(int paramInt)
    {
      AppMethodBeat.i(119809);
      Object localObject1 = a.a(a.this).get(paramInt);
      kotlin.g.b.p.g(localObject1, "mItemList[position]");
      Object localObject2 = (c)localObject1;
      Object localObject3;
      if ((paramInt > 0) && (!Util.isEqual(((c)a.a(a.this).get(paramInt - 1)).label, a.b(a.this))))
      {
        localObject1 = (c)a.a(a.this).get(paramInt - 1);
        if (!a.this.FyF)
        {
          this.EIh.setVisibility(0);
          localObject3 = ((c)localObject2).label;
          if (n.a((CharSequence)localObject3, ":", 0, false, 6) == -1) {
            break label410;
          }
          localObject3 = n.a((CharSequence)localObject3, new String[] { ":" });
          if (((List)localObject3).size() == 2)
          {
            this.EIh.setText((CharSequence)((List)localObject3).get(1));
            if ((localObject1 != null) && (!((c)localObject1).FyP.isEmpty())) {
              break label375;
            }
            paramInt = 0;
            label191:
            int i = ((h)((c)localObject2).FyP.get(0)).Fqr.Fwp;
            localObject1 = (String)((List)localObject3).get(0);
            paramInt /= 10000;
            i /= 10000;
            if (((paramInt != 0) || (i == a.c(a.this))) && ((paramInt == 0) || (i == paramInt))) {
              break label398;
            }
            this.EIj.setVisibility(0);
            this.EIj.setText((CharSequence)localObject1);
          }
        }
      }
      for (;;)
      {
        this.FyN.setLayoutManager((RecyclerView.LayoutManager)this.haU);
        this.FyN.setAdapter((RecyclerView.a)this.FyO);
        this.FyO.FyG = a.this.FyG;
        localObject1 = this.FyO;
        localObject2 = ((c)localObject2).FyP;
        kotlin.g.b.p.h(localObject2, "datas");
        ((d)localObject1).FyQ.clear();
        ((d)localObject1).FyQ.addAll((Collection)localObject2);
        ((d)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(119809);
        return;
        localObject1 = null;
        break;
        label375:
        paramInt = ((h)((c)localObject1).FyP.get(0)).Fqr.Fwp;
        break label191;
        label398:
        this.EIj.setVisibility(8);
        continue;
        label410:
        this.EIh.setText((CharSequence)localObject3);
        this.EIj.setVisibility(8);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
  public abstract class e
    extends RecyclerView.v
  {
    public e()
    {
      super();
    }
    
    public abstract void abc(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a
 * JD-Core Version:    0.7.0.1
 */