package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.f.j.b;
import com.tencent.mm.plugin.story.f.o.a;
import com.tencent.mm.plugin.story.i.h;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"})
public final class a
  extends RecyclerView.a<e>
{
  public static final a LSK;
  static final String TAG = "MicroMsg.StoryAlbumAdapter";
  private final String LSA;
  private final String LSB;
  private final int LSC;
  private final int LSD;
  private ArrayList<com.tencent.mm.plugin.story.i.j> LSE;
  private final int LSF;
  private int LSG;
  boolean LSH;
  kotlin.g.a.b<? super h, x> LSI;
  kotlin.g.a.a<x> LSJ;
  private final int LgZ;
  ArrayList<c> mItemList;
  boolean tDb;
  
  static
  {
    AppMethodBeat.i(119818);
    LSK = new a((byte)0);
    TAG = "MicroMsg.StoryAlbumAdapter";
    AppMethodBeat.o(119818);
  }
  
  public a()
  {
    AppMethodBeat.i(119817);
    this.LSA = "loadingMore";
    this.LSB = "favorite";
    this.LgZ = 1;
    this.LSD = 2;
    this.mItemList = new ArrayList();
    this.LSE = new ArrayList();
    com.tencent.mm.plugin.story.e.a.a locala = com.tencent.mm.plugin.story.e.a.LFy;
    this.LSF = new GregorianCalendar().get(1);
    AppMethodBeat.o(119817);
  }
  
  public final int g(com.tencent.mm.plugin.story.i.j paramj)
  {
    AppMethodBeat.i(119816);
    p.k(paramj, "storyInfo");
    Log.d(TAG, "storyLocalId=" + (int)paramj.systemRowid);
    int k = ((Collection)this.mItemList).size();
    int i = 0;
    int j = 0;
    while (i < k)
    {
      Iterator localIterator = ((c)this.mItemList.get(i)).LSR.iterator();
      while (localIterator.hasNext())
      {
        if ((int)((h)localIterator.next()).LKu.systemRowid == (int)paramj.systemRowid)
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
    if (Util.isEqual(((c)this.mItemList.get(paramInt)).label, this.LSA))
    {
      paramInt = this.LgZ;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    if (Util.isEqual(((c)this.mItemList.get(paramInt)).label, this.LSB))
    {
      paramInt = this.LSD;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    paramInt = this.LSC;
    AppMethodBeat.o(119813);
    return paramInt;
  }
  
  public final void ig(List<c> paramList)
  {
    AppMethodBeat.i(119815);
    p.k(paramList, "datas");
    Log.i(TAG, "updateDatas");
    this.mItemList.clear();
    if (t.gkZ()) {}
    for (boolean bool = com.tencent.mm.plugin.story.c.a.a.LEY.gbN();; bool = com.tencent.mm.plugin.story.c.a.a.LEY.gbw())
    {
      if ((bool) && (!this.LSH))
      {
        this.mItemList.add(new c(this.LSB, null, 2));
        Log.i(TAG, "updateDatas add fav");
      }
      this.mItemList.addAll((Collection)paramList);
      Iterator localIterator = ((Iterable)this.mItemList).iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        int i = this.LSG;
        this.LSG = (localc.LSR.size() + i);
      }
    }
    if (!paramList.isEmpty()) {
      this.mItemList.add(new c(this.LSA, null, 2));
    }
    notifyDataSetChanged();
    AppMethodBeat.o(119815);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-story_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
  public final class b
    extends a.e
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(119806);
      AppMethodBeat.o(119806);
    }
    
    public final void aix(int paramInt)
    {
      AppMethodBeat.i(119805);
      this.amk.setOnClickListener((View.OnClickListener)new a(this));
      AppMethodBeat.o(119805);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(a.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(119804);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = this.LSM.LSL.LSJ;
        if (paramView != null) {
          paramView.invoke();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder$onBind$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(119804);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"})
  public final class c
    extends a.e
  {
    private ViewGroup LSN;
    private ImageView LSO;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119808);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.loading_more_state);
      p.j(a.this, "view.findViewById(R.id.loading_more_state)");
      this.LSN = ((ViewGroup)a.this);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.Lzs);
      p.j(a.this, "view.findViewById(R.id.album_is_all_view)");
      this.LSO = ((ImageView)a.this);
      AppMethodBeat.o(119808);
    }
    
    public final void aix(int paramInt)
    {
      AppMethodBeat.i(119807);
      if (a.d(a.this))
      {
        this.LSN.setVisibility(8);
        this.LSO.setVisibility(0);
        AppMethodBeat.o(119807);
        return;
      }
      a.e(a.this);
      Object localObject = com.tencent.mm.plugin.story.f.j.LGA;
      if (j.b.gcF().JZx <= 0)
      {
        localObject = com.tencent.mm.plugin.story.e.b.LFC;
        localObject = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        String str = com.tencent.mm.plugin.story.e.b.gbW();
        com.tencent.mm.plugin.story.i.a.a locala = com.tencent.mm.plugin.story.i.a.LPG;
        ((SharedPreferences)localObject).getInt(str, com.tencent.mm.plugin.story.i.a.gfg());
      }
      this.LSN.setVisibility(0);
      this.LSO.setVisibility(8);
      AppMethodBeat.o(119807);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroidx/recyclerview/widget/RecyclerView;", "getGridView", "()Landroidx/recyclerview/widget/RecyclerView;", "setGridView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"})
  public final class d
    extends a.e
  {
    private TextView KWj;
    private TextView KWl;
    RecyclerView LSP;
    private d LSQ;
    private GridLayoutManager jLZ;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119810);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.Lzx);
      p.j(a.this, "view.findViewById(R.id.a…_item_decoration_year_tv)");
      this.KWl = ((TextView)a.this);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.Lzw);
      p.j(a.this, "view.findViewById(R.id.a…item_decoration_month_tv)");
      this.KWj = ((TextView)a.this);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.Lzv);
      p.j(a.this, "view.findViewById(R.id.a…tem_decoration_grid_view)");
      this.LSP = ((RecyclerView)a.this);
      this.LSQ = new d();
      localObject.getContext();
      this.jLZ = new GridLayoutManager(4);
      AppMethodBeat.o(119810);
    }
    
    public final void aix(int paramInt)
    {
      AppMethodBeat.i(119809);
      Object localObject1 = a.a(a.this).get(paramInt);
      p.j(localObject1, "mItemList[position]");
      Object localObject2 = (c)localObject1;
      Object localObject3;
      if ((paramInt > 0) && (!Util.isEqual(((c)a.a(a.this).get(paramInt - 1)).label, a.b(a.this))))
      {
        localObject1 = (c)a.a(a.this).get(paramInt - 1);
        if (!a.this.LSH)
        {
          this.KWj.setVisibility(0);
          localObject3 = ((c)localObject2).label;
          if (n.a((CharSequence)localObject3, ":", 0, false, 6) == -1) {
            break label410;
          }
          localObject3 = n.a((CharSequence)localObject3, new String[] { ":" });
          if (((List)localObject3).size() == 2)
          {
            this.KWj.setText((CharSequence)((List)localObject3).get(1));
            if ((localObject1 != null) && (!((c)localObject1).LSR.isEmpty())) {
              break label375;
            }
            paramInt = 0;
            label191:
            int i = ((h)((c)localObject2).LSR.get(0)).LKu.date;
            localObject1 = (String)((List)localObject3).get(0);
            paramInt /= 10000;
            i /= 10000;
            if (((paramInt != 0) || (i == a.c(a.this))) && ((paramInt == 0) || (i == paramInt))) {
              break label398;
            }
            this.KWl.setVisibility(0);
            this.KWl.setText((CharSequence)localObject1);
          }
        }
      }
      for (;;)
      {
        this.LSP.setLayoutManager((RecyclerView.LayoutManager)this.jLZ);
        this.LSP.setAdapter((RecyclerView.a)this.LSQ);
        this.LSQ.LSI = a.this.LSI;
        localObject1 = this.LSQ;
        localObject2 = ((c)localObject2).LSR;
        p.k(localObject2, "datas");
        ((d)localObject1).LSS.clear();
        ((d)localObject1).LSS.addAll((Collection)localObject2);
        ((d)localObject1).notifyDataSetChanged();
        AppMethodBeat.o(119809);
        return;
        localObject1 = null;
        break;
        label375:
        paramInt = ((h)((c)localObject1).LSR.get(0)).LKu.date;
        break label191;
        label398:
        this.KWl.setVisibility(8);
        continue;
        label410:
        this.KWj.setText((CharSequence)localObject3);
        this.KWl.setVisibility(8);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"})
  public abstract class e
    extends RecyclerView.v
  {
    public e()
    {
      super();
    }
    
    public abstract void aix(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a
 * JD-Core Version:    0.7.0.1
 */