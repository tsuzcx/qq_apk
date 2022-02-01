package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.l;
import d.n.n;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"})
public final class a
  extends RecyclerView.a<e>
{
  static final String TAG = "MicroMsg.StoryAlbumAdapter";
  public static final a yry;
  ArrayList<c> mItemList;
  boolean nGq;
  private final int xNk;
  private final String yro;
  private final String yrp;
  private final int yrq;
  private final int yrr;
  private ArrayList<com.tencent.mm.plugin.story.i.j> yrs;
  private final int yrt;
  private int yru;
  boolean yrv;
  d.g.a.b<? super h, y> yrw;
  d.g.a.a<y> yrx;
  
  static
  {
    AppMethodBeat.i(119818);
    yry = new a((byte)0);
    TAG = "MicroMsg.StoryAlbumAdapter";
    AppMethodBeat.o(119818);
  }
  
  public a()
  {
    AppMethodBeat.i(119817);
    this.yro = "loadingMore";
    this.yrp = "favorite";
    this.xNk = 1;
    this.yrr = 2;
    this.mItemList = new ArrayList();
    this.yrs = new ArrayList();
    com.tencent.mm.plugin.story.e.a.a locala = com.tencent.mm.plugin.story.e.a.yef;
    this.yrt = new GregorianCalendar().get(1);
    AppMethodBeat.o(119817);
  }
  
  public final int g(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119816);
    k.h(paramj, "storyInfo");
    ad.d(TAG, "storyLocalId=" + (int)paramj.systemRowid);
    int k = ((Collection)this.mItemList).size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Iterator localIterator = ((c)this.mItemList.get(i)).yrF.iterator();
      while (localIterator.hasNext())
      {
        if ((int)((h)localIterator.next()).yje.systemRowid == (int)paramj.systemRowid)
        {
          ad.d(TAG, "findPositionInGallery index=%s", new Object[] { Integer.valueOf(j) });
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
  
  public final void ga(List<c> paramList)
  {
    AppMethodBeat.i(119815);
    k.h(paramList, "datas");
    ad.i(TAG, "updateDatas");
    this.mItemList.clear();
    if ((com.tencent.mm.plugin.story.c.a.a.ydB.dGf()) && (!this.yrv))
    {
      this.mItemList.add(new c(this.yrp, null, 2));
      ad.i(TAG, "updateDatas add fav");
    }
    this.mItemList.addAll((Collection)paramList);
    Iterator localIterator = ((Iterable)this.mItemList).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = this.yru;
      this.yru = (localc.yrF.size() + i);
    }
    if (!paramList.isEmpty()) {
      this.mItemList.add(new c(this.yro, null, 2));
    }
    notifyDataSetChanged();
    AppMethodBeat.o(119815);
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
    if (bt.kU(((c)this.mItemList.get(paramInt)).label, this.yro))
    {
      paramInt = this.xNk;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    if (bt.kU(((c)this.mItemList.get(paramInt)).label, this.yrp))
    {
      paramInt = this.yrr;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    paramInt = this.yrq;
    AppMethodBeat.o(119813);
    return paramInt;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
  public final class b
    extends a.e
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(119806);
      AppMethodBeat.o(119806);
    }
    
    public final void OK(int paramInt)
    {
      AppMethodBeat.i(119805);
      this.arI.setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(119805);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(a.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119804);
        paramView = this.yrA.yrz.yrx;
        if (paramView != null)
        {
          paramView.invoke();
          AppMethodBeat.o(119804);
          return;
        }
        AppMethodBeat.o(119804);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"})
  public final class c
    extends a.e
  {
    private ViewGroup yrB;
    private ImageView yrC;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119808);
      this$1 = localObject.findViewById(2131301504);
      k.g(a.this, "view.findViewById(R.id.loading_more_state)");
      this.yrB = ((ViewGroup)a.this);
      this$1 = localObject.findViewById(2131296584);
      k.g(a.this, "view.findViewById(R.id.album_is_all_view)");
      this.yrC = ((ImageView)a.this);
      AppMethodBeat.o(119808);
    }
    
    public final void OK(int paramInt)
    {
      AppMethodBeat.i(119807);
      if (a.d(a.this))
      {
        this.yrB.setVisibility(8);
        this.yrC.setVisibility(0);
        AppMethodBeat.o(119807);
        return;
      }
      a.e(a.this);
      Object localObject = com.tencent.mm.plugin.story.f.j.yfh;
      if (j.b.dHm().wIP <= 0)
      {
        localObject = com.tencent.mm.plugin.story.e.b.yej;
        localObject = aj.getContext().getSharedPreferences(aj.eFD(), 0);
        String str = com.tencent.mm.plugin.story.e.b.dGD();
        com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.yor;
        ((SharedPreferences)localObject).getInt(str, com.tencent.mm.plugin.story.i.a.dJL());
      }
      this.yrB.setVisibility(0);
      this.yrC.setVisibility(8);
      AppMethodBeat.o(119807);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroid/support/v7/widget/RecyclerView;", "getGridView", "()Landroid/support/v7/widget/RecyclerView;", "setGridView", "(Landroid/support/v7/widget/RecyclerView;)V", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"})
  public final class d
    extends a.e
  {
    private GridLayoutManager fQe;
    private TextView xDt;
    private TextView xDv;
    RecyclerView yrD;
    private d yrE;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119810);
      this$1 = localObject.findViewById(2131296613);
      k.g(a.this, "view.findViewById(R.id.a…_item_decoration_year_tv)");
      this.xDv = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296612);
      k.g(a.this, "view.findViewById(R.id.a…item_decoration_month_tv)");
      this.xDt = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296610);
      k.g(a.this, "view.findViewById(R.id.a…tem_decoration_grid_view)");
      this.yrD = ((RecyclerView)a.this);
      this.yrE = new d();
      localObject.getContext();
      this.fQe = new GridLayoutManager(4);
      AppMethodBeat.o(119810);
    }
    
    public final void OK(int paramInt)
    {
      AppMethodBeat.i(119809);
      Object localObject1 = a.a(a.this).get(paramInt);
      k.g(localObject1, "mItemList[position]");
      Object localObject2 = (c)localObject1;
      Object localObject3;
      if ((paramInt > 0) && (!bt.kU(((c)a.a(a.this).get(paramInt - 1)).label, a.b(a.this))))
      {
        localObject1 = (c)a.a(a.this).get(paramInt - 1);
        if (!a.this.yrv)
        {
          this.xDt.setVisibility(0);
          localObject3 = ((c)localObject2).label;
          if (n.a((CharSequence)localObject3, ":", 0, false, 6) == -1) {
            break label410;
          }
          localObject3 = n.a((CharSequence)localObject3, new String[] { ":" });
          if (((List)localObject3).size() == 2)
          {
            this.xDt.setText((CharSequence)((List)localObject3).get(1));
            if ((localObject1 != null) && (!((c)localObject1).yrF.isEmpty())) {
              break label375;
            }
            paramInt = 0;
            label191:
            int i = ((h)((c)localObject2).yrF.get(0)).yje.ypd;
            localObject1 = (String)((List)localObject3).get(0);
            paramInt /= 10000;
            i /= 10000;
            if (((paramInt != 0) || (i == a.c(a.this))) && ((paramInt == 0) || (i == paramInt))) {
              break label398;
            }
            this.xDv.setVisibility(0);
            this.xDv.setText((CharSequence)localObject1);
          }
        }
      }
      for (;;)
      {
        this.yrD.setLayoutManager((RecyclerView.i)this.fQe);
        this.yrD.setAdapter((RecyclerView.a)this.yrE);
        this.yrE.yrw = a.this.yrw;
        localObject1 = this.yrE;
        localObject2 = ((c)localObject2).yrF;
        k.h(localObject2, "datas");
        ((d)localObject1).yrG.clear();
        ((d)localObject1).yrG.addAll((Collection)localObject2);
        ((d)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(119809);
        return;
        localObject1 = null;
        break;
        label375:
        paramInt = ((h)((c)localObject1).yrF.get(0)).yje.ypd;
        break label191;
        label398:
        this.xDv.setVisibility(8);
        continue;
        label410:
        this.xDt.setText((CharSequence)localObject3);
        this.xDv.setVisibility(8);
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
  public abstract class e
    extends RecyclerView.v
  {
    public e()
    {
      super();
    }
    
    public abstract void OK(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a
 * JD-Core Version:    0.7.0.1
 */