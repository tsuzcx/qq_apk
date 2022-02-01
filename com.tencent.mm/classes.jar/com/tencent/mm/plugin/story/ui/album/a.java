package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.n;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"})
public final class a
  extends RecyclerView.a<e>
{
  public static final a.a BnS;
  static final String TAG = "MicroMsg.StoryAlbumAdapter";
  private final int AJf;
  private final String BnI;
  private final String BnJ;
  private final int BnK;
  private final int BnL;
  private ArrayList<com.tencent.mm.plugin.story.i.j> BnM;
  private final int BnN;
  private int BnO;
  boolean BnP;
  d.g.a.b<? super h, z> BnQ;
  d.g.a.a<z> BnR;
  ArrayList<c> mItemList;
  boolean oTp;
  
  static
  {
    AppMethodBeat.i(119818);
    BnS = new a.a((byte)0);
    TAG = "MicroMsg.StoryAlbumAdapter";
    AppMethodBeat.o(119818);
  }
  
  public a()
  {
    AppMethodBeat.i(119817);
    this.BnI = "loadingMore";
    this.BnJ = "favorite";
    this.AJf = 1;
    this.BnL = 2;
    this.mItemList = new ArrayList();
    this.BnM = new ArrayList();
    com.tencent.mm.plugin.story.e.a.a locala = com.tencent.mm.plugin.story.e.a.BaC;
    this.BnN = new GregorianCalendar().get(1);
    AppMethodBeat.o(119817);
  }
  
  public final int g(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119816);
    p.h(paramj, "storyInfo");
    ae.d(TAG, "storyLocalId=" + (int)paramj.systemRowid);
    int k = ((Collection)this.mItemList).size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Iterator localIterator = ((c)this.mItemList.get(i)).BnZ.iterator();
      while (localIterator.hasNext())
      {
        if ((int)((h)localIterator.next()).BfA.systemRowid == (int)paramj.systemRowid)
        {
          ae.d(TAG, "findPositionInGallery index=%s", new Object[] { Integer.valueOf(j) });
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
  
  public final void gB(List<c> paramList)
  {
    AppMethodBeat.i(119815);
    p.h(paramList, "datas");
    ae.i(TAG, "updateDatas");
    this.mItemList.clear();
    if ((com.tencent.mm.plugin.story.c.a.a.AZY.ekC()) && (!this.BnP))
    {
      this.mItemList.add(new c(this.BnJ, null, 2));
      ae.i(TAG, "updateDatas add fav");
    }
    this.mItemList.addAll((Collection)paramList);
    Iterator localIterator = ((Iterable)this.mItemList).iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      int i = this.BnO;
      this.BnO = (localc.BnZ.size() + i);
    }
    if (!paramList.isEmpty()) {
      this.mItemList.add(new c(this.BnI, null, 2));
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
    if (bu.lX(((c)this.mItemList.get(paramInt)).label, this.BnI))
    {
      paramInt = this.AJf;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    if (bu.lX(((c)this.mItemList.get(paramInt)).label, this.BnJ))
    {
      paramInt = this.BnL;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    paramInt = this.BnK;
    AppMethodBeat.o(119813);
    return paramInt;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
  public final class b
    extends a.e
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(119806);
      AppMethodBeat.o(119806);
    }
    
    public final void Tg(int paramInt)
    {
      AppMethodBeat.i(119805);
      this.auu.setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(119805);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(a.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119804);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = this.BnU.BnT.BnR;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119804);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"})
  public final class c
    extends a.e
  {
    private ViewGroup BnV;
    private ImageView BnW;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119808);
      this$1 = localObject.findViewById(2131301504);
      p.g(a.this, "view.findViewById(R.id.loading_more_state)");
      this.BnV = ((ViewGroup)a.this);
      this$1 = localObject.findViewById(2131296584);
      p.g(a.this, "view.findViewById(R.id.album_is_all_view)");
      this.BnW = ((ImageView)a.this);
      AppMethodBeat.o(119808);
    }
    
    public final void Tg(int paramInt)
    {
      AppMethodBeat.i(119807);
      if (a.d(a.this))
      {
        this.BnV.setVisibility(8);
        this.BnW.setVisibility(0);
        AppMethodBeat.o(119807);
        return;
      }
      a.e(a.this);
      Object localObject = com.tencent.mm.plugin.story.f.j.BbE;
      if (j.b.elK().zCv <= 0)
      {
        localObject = com.tencent.mm.plugin.story.e.b.BaG;
        localObject = ak.getContext().getSharedPreferences(ak.fow(), 0);
        String str = com.tencent.mm.plugin.story.e.b.elb();
        com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.BkN;
        ((SharedPreferences)localObject).getInt(str, com.tencent.mm.plugin.story.i.a.eok());
      }
      this.BnV.setVisibility(0);
      this.BnW.setVisibility(8);
      AppMethodBeat.o(119807);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroid/support/v7/widget/RecyclerView;", "getGridView", "()Landroid/support/v7/widget/RecyclerView;", "setGridView", "(Landroid/support/v7/widget/RecyclerView;)V", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/GridLayoutManager;", "setLayoutManager", "(Landroid/support/v7/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"})
  public final class d
    extends a.e
  {
    private TextView AyP;
    private TextView AyR;
    RecyclerView BnX;
    private d BnY;
    private GridLayoutManager gpZ;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119810);
      this$1 = localObject.findViewById(2131296613);
      p.g(a.this, "view.findViewById(R.id.a…_item_decoration_year_tv)");
      this.AyR = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296612);
      p.g(a.this, "view.findViewById(R.id.a…item_decoration_month_tv)");
      this.AyP = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296610);
      p.g(a.this, "view.findViewById(R.id.a…tem_decoration_grid_view)");
      this.BnX = ((RecyclerView)a.this);
      this.BnY = new d();
      localObject.getContext();
      this.gpZ = new GridLayoutManager(4);
      AppMethodBeat.o(119810);
    }
    
    public final void Tg(int paramInt)
    {
      AppMethodBeat.i(119809);
      Object localObject1 = a.a(a.this).get(paramInt);
      p.g(localObject1, "mItemList[position]");
      Object localObject2 = (c)localObject1;
      Object localObject3;
      if ((paramInt > 0) && (!bu.lX(((c)a.a(a.this).get(paramInt - 1)).label, a.b(a.this))))
      {
        localObject1 = (c)a.a(a.this).get(paramInt - 1);
        if (!a.this.BnP)
        {
          this.AyP.setVisibility(0);
          localObject3 = ((c)localObject2).label;
          if (n.a((CharSequence)localObject3, ":", 0, false, 6) == -1) {
            break label410;
          }
          localObject3 = n.a((CharSequence)localObject3, new String[] { ":" });
          if (((List)localObject3).size() == 2)
          {
            this.AyP.setText((CharSequence)((List)localObject3).get(1));
            if ((localObject1 != null) && (!((c)localObject1).BnZ.isEmpty())) {
              break label375;
            }
            paramInt = 0;
            label191:
            int i = ((h)((c)localObject2).BnZ.get(0)).BfA.Blz;
            localObject1 = (String)((List)localObject3).get(0);
            paramInt /= 10000;
            i /= 10000;
            if (((paramInt != 0) || (i == a.c(a.this))) && ((paramInt == 0) || (i == paramInt))) {
              break label398;
            }
            this.AyR.setVisibility(0);
            this.AyR.setText((CharSequence)localObject1);
          }
        }
      }
      for (;;)
      {
        this.BnX.setLayoutManager((RecyclerView.i)this.gpZ);
        this.BnX.setAdapter((RecyclerView.a)this.BnY);
        this.BnY.BnQ = a.this.BnQ;
        localObject1 = this.BnY;
        localObject2 = ((c)localObject2).BnZ;
        p.h(localObject2, "datas");
        ((d)localObject1).Boa.clear();
        ((d)localObject1).Boa.addAll((Collection)localObject2);
        ((d)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(119809);
        return;
        localObject1 = null;
        break;
        label375:
        paramInt = ((h)((c)localObject1).BnZ.get(0)).BfA.Blz;
        break label191;
        label398:
        this.AyR.setVisibility(8);
        continue;
        label410:
        this.AyP.setText((CharSequence)localObject3);
        this.AyR.setVisibility(8);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
  public abstract class e
    extends RecyclerView.w
  {
    public e()
    {
      super();
    }
    
    public abstract void Tg(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a
 * JD-Core Version:    0.7.0.1
 */