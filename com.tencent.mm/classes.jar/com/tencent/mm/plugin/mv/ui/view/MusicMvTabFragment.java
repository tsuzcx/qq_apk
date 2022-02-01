package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
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
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "emptyLL", "getEmptyLL", "()Landroid/widget/LinearLayout;", "setEmptyLL", "(Landroid/widget/LinearLayout;)V", "feedIdMap", "", "getFeedIdMap", "hasMore", "", "getHasMore", "()Z", "setHasMore", "(Z)V", "keyword", "", "getKeyword", "()Ljava/lang/String;", "setKeyword", "(Ljava/lang/String;)V", "listener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "setListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;)V", "loadingTv", "Landroid/widget/TextView;", "getLoadingTv", "()Landroid/widget/TextView;", "setLoadingTv", "(Landroid/widget/TextView;)V", "music", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "getMusic", "()Lcom/tencent/mm/plugin/music/model/storage/Music;", "setMusic", "(Lcom/tencent/mm/plugin/music/model/storage/Music;)V", "onSceneEndListener", "Lkotlin/Function0;", "", "getOnSceneEndListener", "()Lkotlin/jvm/functions/Function0;", "setOnSceneEndListener", "(Lkotlin/jvm/functions/Function0;)V", "resultListener", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "getResultListener", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "setResultListener", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "screenWidth", "getScreenWidth", "()I", "setScreenWidth", "(I)V", "videoMaxDurationMs", "videoMinDurationMs", "addItemClickedListener", "itemClickedListener", "addResultCountListener", "clear", "getAllDataList", "getFeedFrom", "getType", "initContentView", "onDestroy", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSwitchFixMode", "onSwitchFlexMode", "onlyUpdateUI", "setOnFlingListener", "Landroidx/recyclerview/widget/RecyclerView$OnFlingListener;", "setResultView", "visibility", "setVideoDuration", "videoMinDuration", "syncCheckedStatus", "feedIdList", "syncGetFeeds", "unCheckedItem", "feedId", "Companion", "FragmentItemClickedListener", "FragmentResultListener", "MusicFeedsConvertData", "MusicFeedsConverter", "MusicFeedsItemData", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class MusicMvTabFragment
  extends LinearLayout
  implements h
{
  public static final MusicMvTabFragment.a MjK = new MusicMvTabFragment.a((byte)0);
  protected WxRecyclerAdapter<d> ALE;
  protected RefreshLoadMoreLayout ATx;
  private com.tencent.mm.plugin.music.model.e.a LMB;
  private int MaK = 10001;
  private int MaL = 2147483647;
  private final ArrayList<Long> MjL = new ArrayList();
  private b MjM;
  c MjN;
  private LinearLayout MjO;
  private kotlin.g.a.a<ah> MjP;
  private String hAB;
  private boolean hasMore;
  private final ArrayList<d> pUj = new ArrayList();
  private int sJv;
  private TextView ycE;
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    LayoutInflater.from(getContext()).inflate(b.f.LVI, (ViewGroup)this, true);
    initContentView();
  }
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(getContext()).inflate(b.f.LVI, (ViewGroup)this, true);
    initContentView();
  }
  
  public MusicMvTabFragment(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    LayoutInflater.from(getContext()).inflate(b.f.LVI, (ViewGroup)this, true);
    initContentView();
    this.sJv = paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  private final void initContentView()
  {
    this.MjO = ((LinearLayout)findViewById(b.e.empty_tip_ll));
    this.ycE = ((TextView)findViewById(b.e.loading_tv));
    Object localObject = findViewById(b.e.LUT);
    s.s(localObject, "findViewById(R.id.tab_rl_layout)");
    setRlLayout((RefreshLoadMoreLayout)localObject);
    getRlLayout().setEnablePullDownHeader(false);
    getRlLayout().setEnableRefresh(false);
    getRlLayout().setActionCallback((RefreshLoadMoreLayout.b)new g(this));
    setAdapter(new WxRecyclerAdapter((g)new h(this), this.pUj, true));
    localObject = (WxRecyclerView)findViewById(b.e.LTe);
    if (localObject != null) {
      ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)getAdapter());
    }
    localObject = new FirstRowLayoutManager(getContext(), 3);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)findViewById(b.e.LTe);
    if (localWxRecyclerView != null) {
      localWxRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    }
    localObject = new c.a(getContext()).WM(b.c.music_gallery_item_padding).WL(b.c.music_gallery_item_padding).WK(b.b.gallery_dark_mode_color);
    ((c.a)localObject).HNS = false;
    localObject = ((c.a)localObject).fBB();
    localWxRecyclerView = (WxRecyclerView)findViewById(b.e.LTe);
    if (localWxRecyclerView != null) {
      localWxRecyclerView.a((RecyclerView.h)localObject);
    }
    getAdapter().agOe = ((i.c)new i(this));
  }
  
  public void a(com.tencent.mm.plugin.music.model.e.a parama, String paramString)
  {
    this.LMB = parama;
    this.hAB = paramString;
  }
  
  public final void a(b paramb)
  {
    s.u(paramb, "itemClickedListener");
    this.MjM = paramb;
  }
  
  public final void bi(ArrayList<Long> paramArrayList)
  {
    s.u(paramArrayList, "feedIdList");
    Iterator localIterator = ((Iterable)this.pUj).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject = (d)localObject;
      boolean bool = ((d)localObject).MjQ.tGP;
      if (paramArrayList.contains(Long.valueOf(((d)localObject).MjQ.feedId)))
      {
        if (!bool)
        {
          ((d)localObject).MjQ.tGP = true;
          getAdapter().fV(i);
          i = j;
        }
      }
      else if (bool)
      {
        ((d)localObject).MjQ.tGP = false;
        getAdapter().fV(i);
      }
      i = j;
    }
  }
  
  public final void clear()
  {
    this.pUj.clear();
    getAdapter().bZE.notifyChanged();
  }
  
  protected final WxRecyclerAdapter<d> getAdapter()
  {
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    if (localWxRecyclerAdapter != null) {
      return localWxRecyclerAdapter;
    }
    s.bIx("adapter");
    return null;
  }
  
  public final ArrayList<d> getAllDataList()
  {
    return this.pUj;
  }
  
  protected final ArrayList<d> getDataList()
  {
    return this.pUj;
  }
  
  protected final LinearLayout getEmptyLL()
  {
    return this.MjO;
  }
  
  public int getFeedFrom()
  {
    return 0;
  }
  
  protected final ArrayList<Long> getFeedIdMap()
  {
    return this.MjL;
  }
  
  protected final boolean getHasMore()
  {
    return this.hasMore;
  }
  
  protected final String getKeyword()
  {
    return this.hAB;
  }
  
  protected final b getListener()
  {
    return this.MjM;
  }
  
  protected final TextView getLoadingTv()
  {
    return this.ycE;
  }
  
  protected final com.tencent.mm.plugin.music.model.e.a getMusic()
  {
    return this.LMB;
  }
  
  public final kotlin.g.a.a<ah> getOnSceneEndListener()
  {
    return this.MjP;
  }
  
  protected final c getResultListener()
  {
    return this.MjN;
  }
  
  protected final RefreshLoadMoreLayout getRlLayout()
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.ATx;
    if (localRefreshLoadMoreLayout != null) {
      return localRefreshLoadMoreLayout;
    }
    s.bIx("rlLayout");
    return null;
  }
  
  protected final int getScreenWidth()
  {
    return this.sJv;
  }
  
  public abstract int getType();
  
  public final void gsd()
  {
    getAdapter().bZE.notifyChanged();
  }
  
  public final void gse()
  {
    getAdapter().bZE.notifyChanged();
  }
  
  public void onDestroy() {}
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp) {}
  
  public final void sI(long paramLong)
  {
    Iterator localIterator = ((Iterable)this.pUj).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject = (d)localObject;
      if (((d)localObject).MjQ.feedId == paramLong)
      {
        ((d)localObject).MjQ.tGP = false;
        getAdapter().fV(i);
      }
      i += 1;
    }
  }
  
  protected final void setAdapter(WxRecyclerAdapter<d> paramWxRecyclerAdapter)
  {
    s.u(paramWxRecyclerAdapter, "<set-?>");
    this.ALE = paramWxRecyclerAdapter;
  }
  
  protected final void setEmptyLL(LinearLayout paramLinearLayout)
  {
    this.MjO = paramLinearLayout;
  }
  
  protected final void setHasMore(boolean paramBoolean)
  {
    this.hasMore = paramBoolean;
  }
  
  protected final void setKeyword(String paramString)
  {
    this.hAB = paramString;
  }
  
  protected final void setListener(b paramb)
  {
    this.MjM = paramb;
  }
  
  protected final void setLoadingTv(TextView paramTextView)
  {
    this.ycE = paramTextView;
  }
  
  protected final void setMusic(com.tencent.mm.plugin.music.model.e.a parama)
  {
    this.LMB = parama;
  }
  
  public final void setOnFlingListener(RecyclerView.j paramj)
  {
    getRlLayout().getRecyclerView().setOnFlingListener(paramj);
  }
  
  public final void setOnSceneEndListener(kotlin.g.a.a<ah> parama)
  {
    this.MjP = parama;
  }
  
  protected final void setResultListener(c paramc)
  {
    this.MjN = paramc;
  }
  
  public final void setResultView(int paramInt)
  {
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)findViewById(b.e.LTe);
    if (localWxRecyclerView != null) {
      localWxRecyclerView.setVisibility(paramInt);
    }
  }
  
  protected final void setRlLayout(RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
  {
    s.u(paramRefreshLoadMoreLayout, "<set-?>");
    this.ATx = paramRefreshLoadMoreLayout;
  }
  
  protected final void setScreenWidth(int paramInt)
  {
    this.sJv = paramInt;
  }
  
  public final void setVideoDuration(int paramInt)
  {
    this.MaK = paramInt;
    Iterator localIterator = ((Iterable)getAdapter().data).iterator();
    paramInt = 0;
    while (localIterator.hasNext())
    {
      localIterator.next();
      if (paramInt < 0) {
        kotlin.a.p.kkW();
      }
      getAdapter().t(paramInt, Integer.valueOf(1));
      paramInt += 1;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentItemClickedListener;", "", "onItemChecked", "", "isCheck", "data", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "fragmentType", "", "onItemClicked", "", "errType", "position", "itemView", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(MusicMvTabFragment.f paramf, View paramView, RecyclerView paramRecyclerView, int paramInt);
    
    public abstract boolean b(boolean paramBoolean, MusicMvTabFragment.f paramf, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$FragmentResultListener;", "", "onCountResult", "", "type", "", "cnt", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void kg(int paramInt1, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "itemData", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;)V", "getItemData", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "getItemId", "", "getItemType", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvTabFragment.f MjQ;
    
    public d(MusicMvTabFragment.f paramf)
    {
      AppMethodBeat.i(286854);
      this.MjQ = paramf;
      AppMethodBeat.o(286854);
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(286861);
      long l = this.MjQ.hashCode();
      AppMethodBeat.o(286861);
      return l;
    }
    
    public final int bZB()
    {
      return 3;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment;)V", "MEDIA_MAX_HEIGHT_RATIO", "", "MEDIA_MIN_HEIGHT_RATIO", "calculateStaggeredLayoutParams", "", "mediaObj", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "originWidth", "formatVideoPlayTime", "", "time", "getLayoutId", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends f<MusicMvTabFragment.d>
  {
    private final float MjR;
    private final float MjS;
    
    public e()
    {
      AppMethodBeat.i(286852);
      this.MjR = 1.316667F;
      this.MjS = 0.95F;
      AppMethodBeat.o(286852);
    }
    
    private static final void a(MusicMvTabFragment.d paramd, int paramInt, MusicMvTabFragment paramMusicMvTabFragment, CheckBox paramCheckBox, View paramView)
    {
      AppMethodBeat.i(286867);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramd);
      localb.sc(paramInt);
      localb.cH(paramMusicMvTabFragment);
      localb.cH(paramCheckBox);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramd, "$item");
      s.u(paramMusicMvTabFragment, "this$0");
      boolean bool;
      if (!paramd.MjQ.tGP)
      {
        bool = true;
        paramd.MjQ.tGP = bool;
        paramView = m.LYc;
        m.adR(paramInt);
        paramView = m.LYc;
        m.adS(paramMusicMvTabFragment.getFeedFrom());
        paramView = paramMusicMvTabFragment.getListener();
        if (paramView != null) {
          break label211;
        }
      }
      label211:
      for (paramView = null;; paramView = Boolean.valueOf(paramView.b(paramd.MjQ.tGP, paramd.MjQ, paramMusicMvTabFragment.getType())))
      {
        if ((paramView != null) && (!paramView.booleanValue())) {
          paramd.MjQ.tGP = false;
        }
        paramCheckBox.setChecked(paramd.MjQ.tGP);
        paramMusicMvTabFragment.getAdapter().fV(paramInt);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286867);
        return;
        bool = false;
        break;
      }
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(286884);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramj, "holder");
      paramInt = (this.MjT.getScreenWidth() - com.tencent.mm.cd.a.fromDPToPix(this.MjT.getContext(), 4)) / 3;
      paramj = (RelativeLayout)paramj.UH(b.e.root_container);
      if (paramj == null)
      {
        paramRecyclerView = null;
        if (paramRecyclerView != null) {
          paramRecyclerView.width = paramInt;
        }
        if (paramj != null) {
          break label94;
        }
      }
      label94:
      for (paramRecyclerView = null;; paramRecyclerView = paramj.getLayoutParams())
      {
        if (paramRecyclerView != null) {
          paramRecyclerView.height = paramInt;
        }
        AppMethodBeat.o(286884);
        return;
        paramRecyclerView = paramj.getLayoutParams();
        break;
      }
    }
    
    public final int getLayoutId()
    {
      return b.f.LVs;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$MusicFeedsItemData;", "", "feedId", "", "nonceId", "", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "isCheck", "", "(JLjava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderObject;Z)V", "getFeedId", "()J", "setFeedId", "(J)V", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "()Z", "setCheck", "(Z)V", "getNonceId", "()Ljava/lang/String;", "setNonceId", "(Ljava/lang/String;)V", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
  {
    public long feedId;
    public FinderObject feedObject;
    private String nonceId;
    boolean tGP;
    
    private f(long paramLong, String paramString, FinderObject paramFinderObject)
    {
      this.feedId = paramLong;
      this.nonceId = paramString;
      this.feedObject = paramFinderObject;
      this.tGP = false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "loadMoreType", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RefreshLoadMoreLayout.b
  {
    g(MusicMvTabFragment paramMusicMvTabFragment) {}
    
    public final void ND(int paramInt) {}
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(286828);
      s.u(paramd, "reason");
      if (!this.MjT.getHasMore()) {
        RefreshLoadMoreLayout.e(this.MjT.getRlLayout());
      }
      AppMethodBeat.o(286828);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(286820);
      Log.i("Music.MusicMvTabFragment", "onLoadMoreBegin");
      if (this.MjT.getHasMore())
      {
        this.MjT.a(this.MjT.getMusic(), this.MjT.getKeyword());
        AppMethodBeat.o(286820);
        return;
      }
      this.MjT.getRlLayout().aFW(0);
      AppMethodBeat.o(286820);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$2", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements g
  {
    h(MusicMvTabFragment paramMusicMvTabFragment) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(286812);
      Log.i("Music.MusicMvTabFragment", s.X("getItemConvert, type:", Integer.valueOf(paramInt)));
      f localf = (f)new MusicMvTabFragment.e(this.MjT);
      AppMethodBeat.o(286812);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvTabFragment$initContentView$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements i.c<j>
  {
    i(MusicMvTabFragment paramMusicMvTabFragment) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvTabFragment
 * JD-Core Version:    0.7.0.1
 */