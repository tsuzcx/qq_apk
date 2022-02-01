package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.ui.c.a;
import com.tencent.mm.plugin.mv.b.b;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.model.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "emptyLL", "getEmptyLL", "()Landroid/widget/LinearLayout;", "setEmptyLL", "(Landroid/widget/LinearLayout;)V", "feedIdMap", "", "getFeedIdMap", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "listener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "setListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;)V", "loadingTv", "Landroid/widget/TextView;", "getLoadingTv", "()Landroid/widget/TextView;", "setLoadingTv", "(Landroid/widget/TextView;)V", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "onSceneEndListener", "Lkotlin/Function0;", "", "getOnSceneEndListener", "()Lkotlin/jvm/functions/Function0;", "setOnSceneEndListener", "(Lkotlin/jvm/functions/Function0;)V", "resultListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "getResultListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "setResultListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "screenWidth", "getScreenWidth", "()I", "setScreenWidth", "(I)V", "videoMaxDurationMs", "videoMinDurationMs", "addItemClickedListener", "itemClickedListener", "addResultCountListener", "clear", "getAllDataList", "getFeedFrom", "getType", "initContentView", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSwitchFixMode", "onSwitchFlexMode", "onlyUpdateUI", "setOnFlingListener", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "setResultView", "visibility", "setVideoDuration", "videoMinDuration", "syncCheckedStatus", "feedIdList", "syncGetFeeds", "unCheckedItem", "feedId", "Companion", "FragmentItemClickedListener", "FragmentResultListener", "MusicFeedsConvertData", "MusicFeedsConverter", "MusicFeedsItemData", "plugin-mv_release"})
public abstract class MusicMvTabFragment
  extends LinearLayout
  implements com.tencent.mm.an.i
{
  public static final MusicMvTabFragment.a GpL = new MusicMvTabFragment.a((byte)0);
  private com.tencent.mm.plugin.music.model.e.a FRG;
  private int Gfq = 10001;
  private int Gfr = 2147483647;
  private final ArrayList<Long> GpF = new ArrayList();
  private b GpG;
  public c GpH;
  private LinearLayout GpI;
  private TextView GpJ;
  private kotlin.g.a.a<x> GpK;
  private HashMap _$_findViewCache;
  private String fwe;
  private boolean hasMore;
  private final ArrayList<d> mXB = new ArrayList();
  private int pEj;
  protected WxRecyclerAdapter<d> xnR;
  protected RefreshLoadMoreLayout xvJ;
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(b.f.FZL, (ViewGroup)this, true);
    initContentView();
  }
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(b.f.FZL, (ViewGroup)this, true);
    initContentView();
  }
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    LayoutInflater.from(getContext()).inflate(b.f.FZL, (ViewGroup)this, true);
    initContentView();
    paramContext = paramContext.getResources();
    p.j(paramContext, "context.resources");
    this.pEj = paramContext.getDisplayMetrics().widthPixels;
  }
  
  private final void initContentView()
  {
    this.GpI = ((LinearLayout)findViewById(b.e.empty_tip_ll));
    this.GpJ = ((TextView)findViewById(b.e.loading_tv));
    Object localObject1 = findViewById(b.e.FZf);
    p.j(localObject1, "findViewById(R.id.tab_rl_layout)");
    this.xvJ = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.xvJ;
    if (localObject1 == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnablePullDownHeader(false);
    localObject1 = this.xvJ;
    if (localObject1 == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.xvJ;
    if (localObject1 == null) {
      p.bGy("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    this.xnR = new WxRecyclerAdapter((f)new h(this), this.mXB, true);
    localObject1 = (WxRecyclerView)_$_findCachedViewById(b.e.FXF);
    if (localObject1 != null)
    {
      localObject2 = this.xnR;
      if (localObject2 == null) {
        p.bGy("adapter");
      }
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    }
    localObject1 = new FirstRowLayoutManager(getContext(), 3);
    Object localObject2 = (WxRecyclerView)_$_findCachedViewById(b.e.FXF);
    if (localObject2 != null) {
      ((WxRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
    }
    localObject1 = new c.a(getContext()).Te(b.c.music_gallery_item_padding).Td(b.c.music_gallery_item_padding).Tc(b.b.gallery_dark_mode_color).euF().euG();
    localObject2 = (WxRecyclerView)_$_findCachedViewById(b.e.FXF);
    if (localObject2 != null) {
      ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    }
    localObject1 = this.xnR;
    if (localObject1 == null) {
      p.bGy("adapter");
    }
    ((h)localObject1).YSn = ((h.c)new i(this));
  }
  
  public final void OK(long paramLong)
  {
    Iterator localIterator = ((Iterable)this.mXB).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject = (d)localObject;
      if (((d)localObject).GpM.feedId == paramLong)
      {
        ((d)localObject).GpM.qBK = false;
        localObject = this.xnR;
        if (localObject == null) {
          p.bGy("adapter");
        }
        ((WxRecyclerAdapter)localObject).cL(i);
      }
      i += 1;
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    this.FRG = parama;
    this.fwe = paramString;
  }
  
  public final void a(b paramb)
  {
    p.k(paramb, "itemClickedListener");
    this.GpG = paramb;
  }
  
  public final void aM(ArrayList<Long> paramArrayList)
  {
    p.k(paramArrayList, "feedIdList");
    Iterator localIterator = ((Iterable)this.mXB).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      localObject = (d)localObject;
      boolean bool = ((d)localObject).GpM.qBK;
      if (paramArrayList.contains(Long.valueOf(((d)localObject).GpM.feedId)))
      {
        if (!bool)
        {
          ((d)localObject).GpM.qBK = true;
          localObject = this.xnR;
          if (localObject == null) {
            p.bGy("adapter");
          }
          ((WxRecyclerAdapter)localObject).cL(i);
          i = j;
        }
      }
      else if (bool)
      {
        ((d)localObject).GpM.qBK = false;
        localObject = this.xnR;
        if (localObject == null) {
          p.bGy("adapter");
        }
        ((WxRecyclerAdapter)localObject).cL(i);
      }
      i = j;
    }
  }
  
  public final void clear()
  {
    this.mXB.clear();
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    localWxRecyclerAdapter.notifyDataSetChanged();
  }
  
  public final void fid()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    localWxRecyclerAdapter.notifyDataSetChanged();
  }
  
  public final void fie()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    localWxRecyclerAdapter.notifyDataSetChanged();
  }
  
  protected final WxRecyclerAdapter<d> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
    if (localWxRecyclerAdapter == null) {
      p.bGy("adapter");
    }
    return localWxRecyclerAdapter;
  }
  
  public final ArrayList<d> getAllDataList()
  {
    return this.mXB;
  }
  
  protected final ArrayList<d> getDataList()
  {
    return this.mXB;
  }
  
  protected final LinearLayout getEmptyLL()
  {
    return this.GpI;
  }
  
  public int getFeedFrom()
  {
    return 0;
  }
  
  protected final ArrayList<Long> getFeedIdMap()
  {
    return this.GpF;
  }
  
  protected final boolean getHasMore()
  {
    return this.hasMore;
  }
  
  protected final String getKeyword()
  {
    return this.fwe;
  }
  
  protected final b getListener()
  {
    return this.GpG;
  }
  
  protected final TextView getLoadingTv()
  {
    return this.GpJ;
  }
  
  protected final com.tencent.mm.plugin.music.model.e.a getMusic()
  {
    return this.FRG;
  }
  
  public final kotlin.g.a.a<x> getOnSceneEndListener()
  {
    return this.GpK;
  }
  
  protected final c getResultListener()
  {
    return this.GpH;
  }
  
  protected final RefreshLoadMoreLayout getRlLayout()
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
    if (localRefreshLoadMoreLayout == null) {
      p.bGy("rlLayout");
    }
    return localRefreshLoadMoreLayout;
  }
  
  protected final int getScreenWidth()
  {
    return this.pEj;
  }
  
  public abstract int getType();
  
  public void onDestroy() {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  protected final void setAdapter(WxRecyclerAdapter<d> paramWxRecyclerAdapter)
  {
    p.k(paramWxRecyclerAdapter, "<set-?>");
    this.xnR = paramWxRecyclerAdapter;
  }
  
  protected final void setEmptyLL(LinearLayout paramLinearLayout)
  {
    this.GpI = paramLinearLayout;
  }
  
  protected final void setHasMore(boolean paramBoolean)
  {
    this.hasMore = paramBoolean;
  }
  
  protected final void setKeyword(String paramString)
  {
    this.fwe = paramString;
  }
  
  protected final void setListener(b paramb)
  {
    this.GpG = paramb;
  }
  
  protected final void setLoadingTv(TextView paramTextView)
  {
    this.GpJ = paramTextView;
  }
  
  protected final void setMusic(com.tencent.mm.plugin.music.model.e.a parama)
  {
    this.FRG = parama;
  }
  
  public final void setOnFlingListener(RecyclerView.j paramj)
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.xvJ;
    if (localRefreshLoadMoreLayout == null) {
      p.bGy("rlLayout");
    }
    localRefreshLoadMoreLayout.getRecyclerView().setOnFlingListener(paramj);
  }
  
  public final void setOnSceneEndListener(kotlin.g.a.a<x> parama)
  {
    this.GpK = parama;
  }
  
  protected final void setResultListener(c paramc)
  {
    this.GpH = paramc;
  }
  
  public final void setResultView(int paramInt)
  {
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)_$_findCachedViewById(b.e.FXF);
    if (localWxRecyclerView != null) {
      localWxRecyclerView.setVisibility(paramInt);
    }
  }
  
  protected final void setRlLayout(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    p.k(paramRefreshLoadMoreLayout, "<set-?>");
    this.xvJ = paramRefreshLoadMoreLayout;
  }
  
  protected final void setScreenWidth(int paramInt)
  {
    this.pEj = paramInt;
  }
  
  public final void setVideoDuration(int paramInt)
  {
    this.Gfq = paramInt;
    Object localObject = this.xnR;
    if (localObject == null) {
      p.bGy("adapter");
    }
    localObject = ((Iterable)((WxRecyclerAdapter)localObject).data).iterator();
    paramInt = 0;
    while (((Iterator)localObject).hasNext())
    {
      ((Iterator)localObject).next();
      if (paramInt < 0) {
        j.iBO();
      }
      WxRecyclerAdapter localWxRecyclerAdapter = this.xnR;
      if (localWxRecyclerAdapter == null) {
        p.bGy("adapter");
      }
      localWxRecyclerAdapter.d(paramInt, Integer.valueOf(1));
      paramInt += 1;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "", "onItemChecked", "", "isCheck", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "fragmentType", "", "onItemClicked", "", "errType", "position", "itemView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void a(MusicMvTabFragment.f paramf, View paramView, RecyclerView paramRecyclerView, int paramInt);
    
    public abstract boolean b(boolean paramBoolean, MusicMvTabFragment.f paramf, int paramInt);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "", "onCountResult", "", "type", "", "cnt", "plugin-mv_release"})
  public static abstract interface c
  {
    public abstract void iC(int paramInt1, int paramInt2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "itemData", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;)V", "getItemData", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "getItemId", "", "getItemType", "", "plugin-mv_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvTabFragment.f GpM;
    
    public d(MusicMvTabFragment.f paramf)
    {
      AppMethodBeat.i(225183);
      this.GpM = paramf;
      AppMethodBeat.o(225183);
    }
    
    public final int bAQ()
    {
      return 3;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(225179);
      long l = this.GpM.hashCode();
      AppMethodBeat.o(225179);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;)V", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "calculateStaggeredLayoutParams", "", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "originWidth", "formatVideoPlayTime", "", "time", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"})
  public final class e
    extends e<MusicMvTabFragment.d>
  {
    private final float GpN = 1.316667F;
    private final float GpO = 0.95F;
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
    {
      AppMethodBeat.i(225503);
      p.k(paramRecyclerView, "recyclerView");
      p.k(parami, "holder");
      paramInt = (this.GpP.getScreenWidth() - com.tencent.mm.ci.a.fromDPToPix(this.GpP.getContext(), 4)) / 3;
      paramRecyclerView = (RelativeLayout)parami.RD(b.e.root_container);
      if (paramRecyclerView != null)
      {
        parami = paramRecyclerView.getLayoutParams();
        if (parami != null) {
          parami.width = paramInt;
        }
      }
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getLayoutParams();
        if (paramRecyclerView != null)
        {
          paramRecyclerView.height = paramInt;
          AppMethodBeat.o(225503);
          return;
        }
      }
      AppMethodBeat.o(225503);
    }
    
    public final int getLayoutId()
    {
      return b.f.FZv;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter$onBindViewHolder$3$1"})
    static final class a
      implements View.OnClickListener
    {
      a(CheckBox paramCheckBox, MusicMvTabFragment.e parame, com.tencent.mm.view.recyclerview.i parami, MusicMvTabFragment.d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(225467);
        b localb = new b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        boolean bool;
        if (!this.GpS.GpM.qBK)
        {
          bool = true;
          this.GpS.GpM.qBK = bool;
          paramView = m.GcA;
          m.ZE(this.rgL);
          paramView = m.GcA;
          m.ZF(this.GpR.GpP.getFeedFrom());
          paramView = this.GpR.GpP.getListener();
          if (paramView == null) {
            break label219;
          }
        }
        label219:
        for (paramView = Boolean.valueOf(paramView.b(this.GpS.GpM.qBK, this.GpS.GpM, this.GpR.GpP.getType()));; paramView = null)
        {
          if ((paramView != null) && (!paramView.booleanValue())) {
            this.GpS.GpM.qBK = false;
          }
          this.GpQ.setChecked(this.GpS.GpM.qBK);
          this.GpR.GpP.getAdapter().cL(this.rgL);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(225467);
          return;
          bool = false;
          break;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "", "feedId", "", "nonceId", "", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isCheck", "", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;Z)V", "getFeedId", "()J", "setFeedId", "(J)V", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "()Z", "setCheck", "(Z)V", "getNonceId", "()Ljava/lang/String;", "setNonceId", "(Ljava/lang/String;)V", "plugin-mv_release"})
  public static final class f
  {
    public long feedId;
    public FinderObject feedObject;
    private String nonceId;
    boolean qBK;
    
    private f(long paramLong, String paramString, FinderObject paramFinderObject)
    {
      this.feedId = paramLong;
      this.nonceId = paramString;
      this.feedObject = paramFinderObject;
      this.qBK = false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-mv_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(226029);
      b localb = new b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(226029);
    }
    
    public final void Mw(int paramInt) {}
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(226027);
      b localb = new b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      if (!this.GpP.getHasMore()) {
        RefreshLoadMoreLayout.e(this.GpP.getRlLayout());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(226027);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(226025);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.i("Music.MusicMvTabFragment", "onLoadMoreBegin");
      if (this.GpP.getHasMore()) {
        this.GpP.a(this.GpP.getMusic(), this.GpP.getKeyword());
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(226025);
        return;
        this.GpP.getRlLayout().azs(0);
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(226030);
      b localb = new b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(226030);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class h
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(226522);
      Log.i("Music.MusicMvTabFragment", "getItemConvert, type:".concat(String.valueOf(paramInt)));
      e locale = (e)new MusicMvTabFragment.e(this.GpP);
      AppMethodBeat.o(226522);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class i
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
 * JD-Core Version:    0.7.0.1
 */