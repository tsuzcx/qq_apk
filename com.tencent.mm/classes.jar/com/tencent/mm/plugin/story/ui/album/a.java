package com.tencent.mm.plugin.story.ui.album;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.h.h;
import com.tencent.mm.plugin.story.h.j;
import com.tencent.mm.plugin.story.model.StoryCore;
import com.tencent.mm.plugin.story.model.StoryCore.b;
import com.tencent.mm.plugin.story.model.n.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "()V", "ITEM_TYPE_FAVORITE", "", "ITEM_TYPE_LOADING", "ITEM_TYPE_NOMAL", "LABEL_FAVORITE", "", "LABEL_LOAD_MORE", "mFavList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/storage/StoryInfo;", "Lkotlin/collections/ArrayList;", "mIsAll", "", "mIsSelectFavorite", "getMIsSelectFavorite", "()Z", "setMIsSelectFavorite", "(Z)V", "mItemList", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "mOnFavItemClickListener", "Lkotlin/Function0;", "", "getMOnFavItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setMOnFavItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "mOnGridItemClickListener", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/story/storage/StoryHistoryInfo;", "Lkotlin/ParameterName;", "name", "info", "getMOnGridItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setMOnGridItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "mRawDataCount", "mThisYear", "calculateStoryCount", "findPositionInGallery", "storyInfo", "getFavItemDateList", "getItemCount", "getItemDateList", "getItemViewType", "position", "hasFavStoryChanged", "datas", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onIsAll", "updateDatas", "", "updateFavStory", "Companion", "StoryAlbumFavHolder", "StoryAlbumLoadingHolder", "StoryAlbumNormalHolder", "StoryAlbumViewHolder", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends RecyclerView.a<e>
{
  public static final a.a SuO;
  static final String TAG;
  private final int RHo;
  final String SuP;
  final String SuQ;
  private final int SuR;
  private final int SuS;
  private ArrayList<j> SuT;
  private final int SuU;
  int SuV;
  boolean SuW;
  kotlin.g.a.b<? super h, ah> SuX;
  kotlin.g.a.a<ah> SuY;
  boolean wHe;
  ArrayList<c> xHy;
  
  static
  {
    AppMethodBeat.i(119818);
    SuO = new a.a((byte)0);
    TAG = "MicroMsg.StoryAlbumAdapter";
    AppMethodBeat.o(119818);
  }
  
  public a()
  {
    AppMethodBeat.i(119817);
    this.SuP = "loadingMore";
    this.SuQ = "favorite";
    this.RHo = 1;
    this.SuS = 2;
    this.xHy = new ArrayList();
    this.SuT = new ArrayList();
    com.tencent.mm.plugin.story.e.a.a locala = com.tencent.mm.plugin.story.e.a.Sjk;
    this.SuU = new GregorianCalendar().get(1);
    AppMethodBeat.o(119817);
  }
  
  public final int g(j paramj)
  {
    AppMethodBeat.i(119816);
    s.u(paramj, "storyInfo");
    Log.d(TAG, s.X("storyLocalId=", Integer.valueOf((int)paramj.systemRowid)));
    int m = this.xHy.size() - 1;
    int j;
    int i;
    int k;
    if (m >= 0)
    {
      j = 0;
      i = 0;
      k = j + 1;
      Iterator localIterator = ((c)this.xHy.get(j)).Sve.iterator();
      while (localIterator.hasNext())
      {
        if ((int)((h)localIterator.next()).SnL.systemRowid == (int)paramj.systemRowid)
        {
          Log.d(TAG, "findPositionInGallery index=%s", new Object[] { Integer.valueOf(i) });
          AppMethodBeat.o(119816);
          return i;
        }
        i += 1;
      }
      if (k <= m) {}
    }
    for (;;)
    {
      AppMethodBeat.o(119816);
      return i;
      j = k;
      break;
      i = 0;
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(119814);
    int i = this.xHy.size();
    AppMethodBeat.o(119814);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(119813);
    if (Util.isEqual(((c)this.xHy.get(paramInt)).label, this.SuP))
    {
      paramInt = this.RHo;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    if (Util.isEqual(((c)this.xHy.get(paramInt)).label, this.SuQ))
    {
      paramInt = this.SuS;
      AppMethodBeat.o(119813);
      return paramInt;
    }
    paramInt = this.SuR;
    AppMethodBeat.o(119813);
    return paramInt;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends a.e
  {
    public b()
    {
      super(localObject);
      AppMethodBeat.i(119806);
      AppMethodBeat.o(119806);
    }
    
    private static final void a(a parama, View paramView)
    {
      AppMethodBeat.i(367292);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      parama = parama.SuY;
      if (parama != null) {
        parama.invoke();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumFavHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(367292);
    }
    
    public final void amy(int paramInt)
    {
      AppMethodBeat.i(119805);
      this.caK.setOnClickListener(new a.b..ExternalSyntheticLambda0(a.this));
      AppMethodBeat.o(119805);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumLoadingHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "isAllView", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "setAllView", "(Landroid/widget/ImageView;)V", "loadingView", "Landroid/view/ViewGroup;", "getLoadingView", "()Landroid/view/ViewGroup;", "setLoadingView", "(Landroid/view/ViewGroup;)V", "onBind", "", "position", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends a.e
  {
    private ViewGroup Sva;
    private ImageView Svb;
    
    public c()
    {
      super(localObject);
      AppMethodBeat.i(119808);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.loading_more_state);
      s.s(a.this, "view.findViewById(R.id.loading_more_state)");
      this.Sva = ((ViewGroup)a.this);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.Sdf);
      s.s(a.this, "view.findViewById(R.id.album_is_all_view)");
      this.Svb = ((ImageView)a.this);
      AppMethodBeat.o(119808);
    }
    
    public final void amy(int paramInt)
    {
      AppMethodBeat.i(119807);
      if (a.d(a.this))
      {
        this.Sva.setVisibility(8);
        this.Svb.setVisibility(0);
        AppMethodBeat.o(119807);
        return;
      }
      a.e(a.this);
      Object localObject = StoryCore.SjP;
      if (StoryCore.b.hwa().QwF <= 0)
      {
        localObject = com.tencent.mm.plugin.story.e.b.Sjl;
        localObject = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        String str = com.tencent.mm.plugin.story.e.b.hvn();
        com.tencent.mm.plugin.story.h.a.a locala = com.tencent.mm.plugin.story.h.a.Sry;
        ((SharedPreferences)localObject).getInt(str, com.tencent.mm.plugin.story.h.a.hyy());
      }
      this.Sva.setVisibility(0);
      this.Svb.setVisibility(8);
      AppMethodBeat.o(119807);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumNormalHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "gridAdapter", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "getGridAdapter", "()Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;", "setGridAdapter", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumItemAdapter;)V", "gridView", "Landroidx/recyclerview/widget/RecyclerView;", "getGridView", "()Landroidx/recyclerview/widget/RecyclerView;", "setGridView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "layoutManager", "Landroidx/recyclerview/widget/GridLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/GridLayoutManager;", "setLayoutManager", "(Landroidx/recyclerview/widget/GridLayoutManager;)V", "monTv", "Landroid/widget/TextView;", "getMonTv", "()Landroid/widget/TextView;", "setMonTv", "(Landroid/widget/TextView;)V", "yearTv", "getYearTv", "setYearTv", "handleDate", "", "preStoryAlbumInfo", "Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumInfo;", "storyAlbumInfo", "handleGrid", "handleYearTv", "preHead", "", "head", "yearStr", "", "onBind", "position", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends a.e
  {
    private TextView Rwg;
    private TextView Rwi;
    RecyclerView Svc;
    private d Svd;
    private GridLayoutManager mkZ;
    
    public d()
    {
      super(localObject);
      AppMethodBeat.i(119810);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.Sdk);
      s.s(a.this, "view.findViewById(R.id.a…_item_decoration_year_tv)");
      this.Rwi = ((TextView)a.this);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.Sdj);
      s.s(a.this, "view.findViewById(R.id.a…item_decoration_month_tv)");
      this.Rwg = ((TextView)a.this);
      this$1 = localObject.findViewById(com.tencent.mm.plugin.story.a.d.Sdi);
      s.s(a.this, "view.findViewById(R.id.a…tem_decoration_grid_view)");
      this.Svc = ((RecyclerView)a.this);
      this.Svd = new d();
      localObject.getContext();
      this.mkZ = new GridLayoutManager(4);
      AppMethodBeat.o(119810);
    }
    
    public final void amy(int paramInt)
    {
      AppMethodBeat.i(119809);
      Object localObject1 = a.a(a.this).get(paramInt);
      s.s(localObject1, "mItemList[position]");
      Object localObject2 = (c)localObject1;
      Object localObject3;
      if ((paramInt > 0) && (!Util.isEqual(((c)a.a(a.this).get(paramInt - 1)).label, a.b(a.this))))
      {
        localObject1 = (c)a.a(a.this).get(paramInt - 1);
        if (!a.this.SuW)
        {
          this.Rwg.setVisibility(0);
          localObject3 = ((c)localObject2).label;
          if (n.a((CharSequence)localObject3, ":", 0, false, 6) == -1) {
            break label414;
          }
          localObject3 = n.a((CharSequence)localObject3, new String[] { ":" });
          if (((List)localObject3).size() == 2)
          {
            this.Rwg.setText((CharSequence)((List)localObject3).get(1));
            if ((localObject1 != null) && (!((c)localObject1).Sve.isEmpty())) {
              break label379;
            }
            paramInt = 0;
            label191:
            int i = ((h)((c)localObject2).Sve.get(0)).SnL.date;
            localObject1 = (String)((List)localObject3).get(0);
            paramInt /= 10000;
            i /= 10000;
            if (((paramInt != 0) || (i == a.c(a.this))) && ((paramInt == 0) || (i == paramInt))) {
              break label402;
            }
            this.Rwi.setVisibility(0);
            this.Rwi.setText((CharSequence)localObject1);
          }
        }
      }
      for (;;)
      {
        this.Svc.setLayoutManager((RecyclerView.LayoutManager)this.mkZ);
        this.Svc.setAdapter((RecyclerView.a)this.Svd);
        this.Svd.SuX = a.this.SuX;
        localObject1 = this.Svd;
        localObject2 = ((c)localObject2).Sve;
        s.u(localObject2, "datas");
        ((d)localObject1).Svg.clear();
        ((d)localObject1).Svg.addAll((Collection)localObject2);
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
        AppMethodBeat.o(119809);
        return;
        localObject1 = null;
        break;
        label379:
        paramInt = ((h)((c)localObject1).Sve.get(0)).SnL.date;
        break label191;
        label402:
        this.Rwi.setVisibility(8);
        continue;
        label414:
        this.Rwg.setText((CharSequence)localObject3);
        this.Rwi.setVisibility(8);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter$StoryAlbumViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/album/StoryAlbumAdapter;Landroid/view/View;)V", "onBind", "", "position", "", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public abstract class e
    extends RecyclerView.v
  {
    public e()
    {
      super();
    }
    
    public abstract void amy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.album.a
 * JD-Core Version:    0.7.0.1
 */