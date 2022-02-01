package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.ui.c.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "emptyLL", "getEmptyLL", "()Landroid/widget/LinearLayout;", "setEmptyLL", "(Landroid/widget/LinearLayout;)V", "feedIdMap", "", "getFeedIdMap", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "listener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "setListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;)V", "loadingTv", "Landroid/widget/TextView;", "getLoadingTv", "()Landroid/widget/TextView;", "setLoadingTv", "(Landroid/widget/TextView;)V", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "resultListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "getResultListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "setResultListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "screenWidth", "getScreenWidth", "()I", "setScreenWidth", "(I)V", "videoMaxDurationMs", "videoMinDurationMs", "addItemClickedListener", "", "itemClickedListener", "addResultCountListener", "clear", "getFeedFrom", "initContentView", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setOnFlingListener", "Landroid/support/v7/widget/RecyclerView$OnFlingListener;", "setResultView", "visibility", "setVideoDuration", "videoMinDuration", "syncGetFeeds", "Companion", "FragmentItemClickedListener", "FragmentResultListener", "MusicFeedsConvertData", "MusicFeedsConverter", "MusicFeedsItemData", "plugin-mv_release"})
public class MusicMvTabFragment
  extends LinearLayout
  implements i
{
  public static final a Azh;
  private com.tencent.mm.plugin.music.model.e.a AkC;
  private int ArJ;
  private int ArK;
  private final ArrayList<Long> Azd;
  private b Aze;
  public c Azf;
  private LinearLayout Azg;
  private TextView Urr;
  private HashMap _$_findViewCache;
  private String dDv;
  private boolean hasMore;
  private final ArrayList<d> kgc;
  private int mEX;
  protected WxRecyclerAdapter<d> tFp;
  protected RefreshLoadMoreLayout tLS;
  
  static
  {
    AppMethodBeat.i(257682);
    Azh = new a((byte)0);
    AppMethodBeat.o(257682);
  }
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(257679);
    this.kgc = new ArrayList();
    this.Azd = new ArrayList();
    this.ArK = 2147483647;
    this.ArJ = 10001;
    LayoutInflater.from(getContext()).inflate(2131495797, (ViewGroup)this, true);
    initContentView();
    AppMethodBeat.o(257679);
  }
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(257680);
    this.kgc = new ArrayList();
    this.Azd = new ArrayList();
    this.ArK = 2147483647;
    this.ArJ = 10001;
    LayoutInflater.from(getContext()).inflate(2131495797, (ViewGroup)this, true);
    initContentView();
    AppMethodBeat.o(257680);
  }
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(257681);
    this.kgc = new ArrayList();
    this.Azd = new ArrayList();
    this.ArK = 2147483647;
    this.ArJ = 10001;
    LayoutInflater.from(getContext()).inflate(2131495797, (ViewGroup)this, true);
    initContentView();
    paramContext = paramContext.getResources();
    p.g(paramContext, "context.resources");
    this.mEX = paramContext.getDisplayMetrics().widthPixels;
    AppMethodBeat.o(257681);
  }
  
  private final void initContentView()
  {
    AppMethodBeat.i(257677);
    this.Azg = ((LinearLayout)findViewById(2131300103));
    this.Urr = ((TextView)findViewById(2131303717));
    Object localObject1 = findViewById(2131308842);
    p.g(localObject1, "findViewById(R.id.tab_rl_layout)");
    this.tLS = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.tLS;
    if (localObject1 == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnablePullDownHeader(false);
    localObject1 = this.tLS;
    if (localObject1 == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.tLS;
    if (localObject1 == null) {
      p.btv("rlLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    this.tFp = new WxRecyclerAdapter((f)new h(this), this.kgc, true);
    localObject1 = (WxRecyclerView)ewN();
    if (localObject1 != null)
    {
      localObject2 = this.tFp;
      if (localObject2 == null) {
        p.btv("adapter");
      }
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    }
    localObject1 = new FirstRowLayoutManager(getContext(), 3);
    Object localObject2 = (WxRecyclerView)ewN();
    if (localObject2 != null) {
      ((WxRecyclerView)localObject2).setLayoutManager((RecyclerView.LayoutManager)localObject1);
    }
    localObject1 = new c.a(getContext()).NP(2131166771).NO(2131166771).dSd().dSe().dSf();
    localObject2 = (WxRecyclerView)ewN();
    if (localObject2 != null) {
      ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    }
    localObject1 = this.tFp;
    if (localObject1 == null) {
      p.btv("adapter");
    }
    ((g)localObject1).RqP = ((g.c)new i(this));
    AppMethodBeat.o(257677);
  }
  
  public void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    this.AkC = parama;
    this.dDv = paramString;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(257673);
    p.h(paramb, "itemClickedListener");
    this.Aze = paramb;
    AppMethodBeat.o(257673);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(257675);
    this.kgc.clear();
    WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
    if (localWxRecyclerAdapter == null) {
      p.btv("adapter");
    }
    localWxRecyclerAdapter.notifyDataSetChanged();
    AppMethodBeat.o(257675);
  }
  
  public View ewN()
  {
    AppMethodBeat.i(257683);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(2131305082));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(2131305082);
      this._$_findViewCache.put(Integer.valueOf(2131305082), localView1);
    }
    AppMethodBeat.o(257683);
    return localView1;
  }
  
  protected final WxRecyclerAdapter<d> getAdapter()
  {
    AppMethodBeat.i(257669);
    WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
    if (localWxRecyclerAdapter == null) {
      p.btv("adapter");
    }
    AppMethodBeat.o(257669);
    return localWxRecyclerAdapter;
  }
  
  protected final ArrayList<d> getDataList()
  {
    return this.kgc;
  }
  
  protected final LinearLayout getEmptyLL()
  {
    return this.Azg;
  }
  
  public int getFeedFrom()
  {
    return 0;
  }
  
  protected final ArrayList<Long> getFeedIdMap()
  {
    return this.Azd;
  }
  
  protected final boolean getHasMore()
  {
    return this.hasMore;
  }
  
  protected final String getKeyword()
  {
    return this.dDv;
  }
  
  protected final b getListener()
  {
    return this.Aze;
  }
  
  protected final TextView getLoadingTv()
  {
    return this.Urr;
  }
  
  protected final com.tencent.mm.plugin.music.model.e.a getMusic()
  {
    return this.AkC;
  }
  
  protected final c getResultListener()
  {
    return this.Azf;
  }
  
  protected final RefreshLoadMoreLayout getRlLayout()
  {
    AppMethodBeat.i(257671);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
    if (localRefreshLoadMoreLayout == null) {
      p.btv("rlLayout");
    }
    AppMethodBeat.o(257671);
    return localRefreshLoadMoreLayout;
  }
  
  protected final int getScreenWidth()
  {
    return this.mEX;
  }
  
  public void onDestroy() {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq) {}
  
  protected final void setAdapter(WxRecyclerAdapter<d> paramWxRecyclerAdapter)
  {
    AppMethodBeat.i(257670);
    p.h(paramWxRecyclerAdapter, "<set-?>");
    this.tFp = paramWxRecyclerAdapter;
    AppMethodBeat.o(257670);
  }
  
  protected final void setEmptyLL(LinearLayout paramLinearLayout)
  {
    this.Azg = paramLinearLayout;
  }
  
  protected final void setHasMore(boolean paramBoolean)
  {
    this.hasMore = paramBoolean;
  }
  
  protected final void setKeyword(String paramString)
  {
    this.dDv = paramString;
  }
  
  protected final void setListener(b paramb)
  {
    this.Aze = paramb;
  }
  
  protected final void setLoadingTv(TextView paramTextView)
  {
    this.Urr = paramTextView;
  }
  
  protected final void setMusic(com.tencent.mm.plugin.music.model.e.a parama)
  {
    this.AkC = parama;
  }
  
  public final void setOnFlingListener(RecyclerView.j paramj)
  {
    AppMethodBeat.i(257678);
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tLS;
    if (localRefreshLoadMoreLayout == null) {
      p.btv("rlLayout");
    }
    localRefreshLoadMoreLayout.getRecyclerView().setOnFlingListener(paramj);
    AppMethodBeat.o(257678);
  }
  
  protected final void setResultListener(c paramc)
  {
    this.Azf = paramc;
  }
  
  public final void setResultView(int paramInt)
  {
    AppMethodBeat.i(257676);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)ewN();
    if (localWxRecyclerView != null)
    {
      localWxRecyclerView.setVisibility(paramInt);
      AppMethodBeat.o(257676);
      return;
    }
    AppMethodBeat.o(257676);
  }
  
  protected final void setRlLayout(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    AppMethodBeat.i(257672);
    p.h(paramRefreshLoadMoreLayout, "<set-?>");
    this.tLS = paramRefreshLoadMoreLayout;
    AppMethodBeat.o(257672);
  }
  
  protected final void setScreenWidth(int paramInt)
  {
    this.mEX = paramInt;
  }
  
  public final void setVideoDuration(int paramInt)
  {
    AppMethodBeat.i(257674);
    this.ArJ = paramInt;
    WxRecyclerAdapter localWxRecyclerAdapter = this.tFp;
    if (localWxRecyclerAdapter == null) {
      p.btv("adapter");
    }
    localWxRecyclerAdapter.notifyDataSetChanged();
    AppMethodBeat.o(257674);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$Companion;", "", "()V", "SPAN_COUNT", "", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "", "onItemClicked", "", "errType", "", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "position", "itemView", "Landroid/view/View;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-mv_release"})
  public static abstract interface b
  {
    public abstract void a(MusicMvTabFragment.f paramf, View paramView, RecyclerView paramRecyclerView);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "", "onCountResult", "", "type", "", "cnt", "plugin-mv_release"})
  public static abstract interface c
  {
    public abstract void hx(int paramInt1, int paramInt2);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "itemData", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;)V", "getItemData", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "getItemId", "", "getItemType", "", "plugin-mv_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvTabFragment.f Azi;
    
    public d(MusicMvTabFragment.f paramf)
    {
      AppMethodBeat.i(257660);
      this.Azi = paramf;
      AppMethodBeat.o(257660);
    }
    
    public final int cxn()
    {
      return 3;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(257659);
      long l = this.Azi.hashCode();
      AppMethodBeat.o(257659);
      return l;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;)V", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "calculateStaggeredLayoutParams", "", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "originWidth", "formatVideoPlayTime", "", "time", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-mv_release"})
  public final class e
    extends e<MusicMvTabFragment.d>
  {
    private final float Azj = 1.316667F;
    private final float Azk = 0.95F;
    
    public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
    {
      AppMethodBeat.i(257661);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      paramInt = (this.Azl.getScreenWidth() - com.tencent.mm.cb.a.fromDPToPix(this.Azl.getContext(), 4)) / 3;
      paramRecyclerView = (RelativeLayout)paramh.Mn(2131307160);
      if (paramRecyclerView != null)
      {
        paramh = paramRecyclerView.getLayoutParams();
        if (paramh != null) {
          paramh.width = paramInt;
        }
      }
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getLayoutParams();
        if (paramRecyclerView != null)
        {
          paramRecyclerView.height = paramInt;
          AppMethodBeat.o(257661);
          return;
        }
      }
      AppMethodBeat.o(257661);
    }
    
    public final int getLayoutId()
    {
      return 2131495784;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "", "feedId", "", "nonceId", "", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFeedId", "()J", "setFeedId", "(J)V", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getNonceId", "()Ljava/lang/String;", "setNonceId", "(Ljava/lang/String;)V", "plugin-mv_release"})
  public static final class f
  {
    long feedId;
    public FinderObject feedObject;
    private String hwg;
    
    public f(long paramLong, String paramString, FinderObject paramFinderObject)
    {
      this.feedId = paramLong;
      this.hwg = paramString;
      this.feedObject = paramFinderObject;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-mv_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(257665);
      b localb = new b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(257665);
    }
    
    public final void IF(int paramInt) {}
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(257664);
      b localb = new b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      if (!this.Azl.getHasMore()) {
        RefreshLoadMoreLayout.e(this.Azl.getRlLayout());
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(257664);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(257663);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.i("Music.MusicMvTabFragment", "onLoadMoreBegin");
      if (this.Azl.getHasMore()) {
        this.Azl.a(this.Azl.getMusic(), this.Azl.getKeyword());
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
        AppMethodBeat.o(257663);
        return;
        this.Azl.getRlLayout().apT(0);
      }
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(257666);
      b localb = new b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(257666);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class h
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(257667);
      Log.i("Music.MusicMvTabFragment", "getItemConvert, type:".concat(String.valueOf(paramInt)));
      e locale = (e)new MusicMvTabFragment.e(this.Azl);
      AppMethodBeat.o(257667);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class i
    implements g.c<h>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
 * JD-Core Version:    0.7.0.1
 */