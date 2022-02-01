package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.g.d;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "liveRoomListener", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "msgIdList", "", "", "readCount", "buildFakeMsgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "random", "hideNewCommentTip", "", "initFakeData", "isLandscape", "", "onDestroy", "onLongClicked", "feedId", "commentId", "text", "", "onMsgUpdated", "lstConvertData", "onPause", "onResume", "prepareViews", "setMaxWidth", "maxWidth", "setViewEventListener", "listener", "showNewCommentTip", "count", "smoothScrollToLastPosition", "Companion", "MusicCommentConvertData", "MusicCommentConverter", "MusicCommentItemData", "plugin-mv_release"})
public final class MusicMvCommentView
  extends RelativeLayout
{
  private static final int AxL;
  public static final a AxM;
  private com.tencent.mm.plugin.mv.ui.uic.a.a AxK;
  private HashMap _$_findViewCache;
  private ArrayList<b> kgc;
  private int readCount;
  private WxRecyclerAdapter<b> tFp;
  private final List<Long> xEG;
  
  static
  {
    AppMethodBeat.i(257520);
    AxM = new a((byte)0);
    AxL = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(257520);
  }
  
  public MusicMvCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(257519);
    AppMethodBeat.o(257519);
  }
  
  public MusicMvCommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(257518);
    this.kgc = new ArrayList();
    paramAttributeSet = Collections.synchronizedList((List)new ArrayList());
    p.g(paramAttributeSet, "Collections.synchronizedList(ArrayList())");
    this.xEG = paramAttributeSet;
    View.inflate(paramContext, 2131495783, (ViewGroup)this);
    this.tFp = new WxRecyclerAdapter((f)new g(this), this.kgc, true);
    paramContext = (WxRecyclerView)_$_findCachedViewById(2131303245);
    if (paramContext != null)
    {
      paramAttributeSet = this.tFp;
      if (paramAttributeSet == null) {
        p.btv("adapter");
      }
      paramContext.setAdapter((RecyclerView.a)paramAttributeSet);
    }
    paramContext = (WxRecyclerView)_$_findCachedViewById(2131303245);
    if (paramContext != null)
    {
      getContext();
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramContext = (WxRecyclerView)_$_findCachedViewById(2131303245);
    if (paramContext != null) {
      paramContext.b((RecyclerView.h)new h());
    }
    paramContext = this.tFp;
    if (paramContext == null) {
      p.btv("adapter");
    }
    if (paramContext != null) {
      paramContext.RqP = ((g.c)new i(this));
    }
    paramContext = this.tFp;
    if (paramContext == null) {
      p.btv("adapter");
    }
    if (paramContext != null) {
      paramContext.RqO = ((g.d)new j(this));
    }
    ((WxRecyclerView)_$_findCachedViewById(2131303245)).a((RecyclerView.l)new k(this));
    ((RelativeLayout)_$_findCachedViewById(2131305278)).setOnClickListener((View.OnClickListener)new l(this));
    setTag(this);
    AppMethodBeat.o(257518);
  }
  
  private final void dcz()
  {
    AppMethodBeat.i(257516);
    Object localObject = this.tFp;
    if (localObject == null) {
      p.btv("adapter");
    }
    if (localObject != null)
    {
      if (((WxRecyclerAdapter)localObject).getItemCount() > 0)
      {
        WxRecyclerView localWxRecyclerView = (WxRecyclerView)_$_findCachedViewById(2131303245);
        localObject = c.a(((WxRecyclerAdapter)localObject).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localWxRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        localWxRecyclerView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      AppMethodBeat.o(257516);
      return;
    }
    AppMethodBeat.o(257516);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(257523);
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
    AppMethodBeat.o(257523);
    return localView1;
  }
  
  public final void aE(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(257515);
    p.h(paramArrayList, "lstConvertData");
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramArrayList.iterator();
    if (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      List localList = this.xEG;
      paramArrayList = localb.AxN;
      if (paramArrayList != null)
      {
        paramArrayList = paramArrayList.AxR;
        if (paramArrayList != null)
        {
          paramArrayList = Long.valueOf(paramArrayList.dFm);
          label82:
          if (localList.contains(paramArrayList)) {
            break label148;
          }
          localList = this.xEG;
          paramArrayList = localb.AxN;
          if (paramArrayList == null) {
            break label150;
          }
          paramArrayList = paramArrayList.AxR;
          if (paramArrayList == null) {
            break label150;
          }
        }
      }
      label148:
      label150:
      for (paramArrayList = Long.valueOf(paramArrayList.dFm);; paramArrayList = null)
      {
        localList.add(paramArrayList);
        localArrayList.add(localb);
        break;
        paramArrayList = null;
        break label82;
        break;
      }
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramArrayList = this.tFp;
        if (paramArrayList == null) {
          p.btv("adapter");
        }
        if (paramArrayList != null)
        {
          paramArrayList = (List)paramArrayList.data;
          if (paramArrayList != null) {
            paramArrayList.addAll((Collection)localArrayList);
          }
        }
        paramArrayList = this.tFp;
        if (paramArrayList == null) {
          p.btv("adapter");
        }
        if (paramArrayList != null) {
          paramArrayList.notifyDataSetChanged();
        }
        dcz();
      }
      AppMethodBeat.o(257515);
      return;
    }
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(257517);
    if (paramInt > 0)
    {
      Object localObject = (FrameLayout)_$_findCachedViewById(2131303244);
      p.g(localObject, "liveCommentArea");
      localObject = ((FrameLayout)localObject).getLayoutParams();
      if (paramInt > 0) {
        ((ViewGroup.LayoutParams)localObject).width = paramInt;
      }
    }
    AppMethodBeat.o(257517);
  }
  
  public final void setViewEventListener(com.tencent.mm.plugin.mv.ui.uic.a.a parama)
  {
    AppMethodBeat.i(257514);
    p.h(parama, "listener");
    this.AxK = parama;
    AppMethodBeat.o(257514);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$Companion;", "", "()V", "MENU_ID_COPY", "", "MENU_ID_EXPOSE", "PADDING_EDGE_HEIGHT", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "commentItemData", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;)V", "getCommentItemData", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "getItemId", "", "getItemType", "", "plugin-mv_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvCommentView.d AxN;
    
    public b(MusicMvCommentView.d paramd)
    {
      AppMethodBeat.i(257500);
      this.AxN = paramd;
      AppMethodBeat.o(257500);
    }
    
    public final int cxn()
    {
      return 2;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(257499);
      long l = this.AxN.hashCode();
      AppMethodBeat.o(257499);
      return l;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "updateNickname", "nickname", "", "referInfoTv", "Landroid/widget/TextView;", "plugin-mv_release"})
  public final class c
    extends e<MusicMvCommentView.b>
  {
    public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
    {
      AppMethodBeat.i(257502);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      AppMethodBeat.o(257502);
    }
    
    public final int getLayoutId()
    {
      return 2131495782;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(MusicMvCommentView.c paramc, MusicMvCommentView.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(257501);
        Object localObject = new b();
        ((b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
        long l = this.AxQ.AxN.AxR.Mxv;
        paramView = this.AxQ.AxN.AxR.LGs;
        localObject = MusicMvCommentView.a(this.AxP.AxO);
        if (localObject != null)
        {
          p.g(paramView, "nonceId");
          ((com.tencent.mm.plugin.mv.ui.uic.a.a)localObject).B(l, paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257501);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "", "msgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;)V", "getMsgPack", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "setMsgPack", "plugin-mv_release"})
  public static final class d
  {
    csk AxR;
    
    public d(csk paramcsk)
    {
      AppMethodBeat.i(257504);
      this.AxR = paramcsk;
      AppMethodBeat.o(257504);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements o.f
  {
    e(MusicMvCommentView paramMusicMvCommentView) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(257505);
      p.g(paramm, "menu");
      if (paramm.gKQ())
      {
        paramm.b(1, (CharSequence)this.AxO.getContext().getString(2131763360), 0);
        paramm.b(2, (CharSequence)this.AxO.getContext().getString(2131763362), 0);
      }
      AppMethodBeat.o(257505);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements o.g
  {
    f(MusicMvCommentView paramMusicMvCommentView, String paramString, long paramLong1, long paramLong2) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(257506);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(257506);
        return;
        ClipboardHelper.setText((CharSequence)this.rry);
        Toast.makeText(this.AxO.getContext(), 2131755773, 0).show();
        AppMethodBeat.o(257506);
        return;
        com.tencent.mm.plugin.music.model.m.F(this.AxO.getContext(), d.zs(this.txv), d.zs(this.vwa));
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class g
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(257507);
      Log.i("MicroMsg.MusicMvCommentView", "getItemConvert, type:".concat(String.valueOf(paramInt)));
      e locale = (e)new MusicMvCommentView.c(this.AxO);
      AppMethodBeat.o(257507);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$2", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-mv_release"})
  public static final class h
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(257508);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      int j = RecyclerView.bw(paramView);
      paramView = paramRecyclerView.getAdapter();
      if (paramView != null) {}
      for (int i = paramView.getItemCount(); j < i; i = -1)
      {
        paramRect.top = MusicMvCommentView.ewr();
        AppMethodBeat.o(257508);
        return;
      }
      paramRect.top = 0;
      AppMethodBeat.o(257508);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class i
    implements g.c<h>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class j
    implements g.d<h>
  {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-mv_release"})
  public static final class k
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(257512);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(257512);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(257511);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      paramRecyclerView = (WxRecyclerView)this.AxO._$_findCachedViewById(2131303245);
      p.g(paramRecyclerView, "liveCommentListRV");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(257511);
        throw paramRecyclerView;
      }
      paramInt1 = ((LinearLayoutManager)paramRecyclerView).ku();
      paramRecyclerView = this.AxO;
      MusicMvCommentView.a(paramRecyclerView, j.mZ(paramInt1, MusicMvCommentView.b(paramRecyclerView)));
      if (paramInt1 == MusicMvCommentView.c(this.AxO).getItemCount() - 1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          MusicMvCommentView.d(this.AxO);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(257511);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(MusicMvCommentView paramMusicMvCommentView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257513);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      MusicMvCommentView.d(this.AxO);
      if (MusicMvCommentView.e(this.AxO).size() > 0)
      {
        paramView = (WxRecyclerView)this.AxO._$_findCachedViewById(2131303245);
        localObject = c.a(MusicMvCommentView.e(this.AxO).size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257513);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView
 * JD-Core Version:    0.7.0.1
 */