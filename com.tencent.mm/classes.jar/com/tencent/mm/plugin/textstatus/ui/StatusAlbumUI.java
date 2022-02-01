package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.component.g;
import com.tencent.mm.ui.component.g.a;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.k;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "canContinue", "", "getCanContinue", "()Z", "setCanContinue", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$HistoryItemLoader;", "hasShowStoryEntry", "isInitLoaded", "setInitLoaded", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "getLastLoadContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastLoadContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "longClickListener", "Landroid/view/View$OnLongClickListener;", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "rvSelfHistory", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealContentView", "", "v", "Landroid/view/View;", "getCal", "Ljava/util/Calendar;", "timeStamp", "", "getLayoutId", "", "initActionBar", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onVisibilityChanged", "visible", "preData", "supportNavigationSwipeBack", "Companion", "HistoryItemLoader", "plugin-textstatus_release"})
public final class StatusAlbumUI
  extends MMFragment
  implements i
{
  public static final StatusAlbumUI.a MKw;
  private WxRecyclerView MKr;
  private StatusAlbumUI.b MKs;
  private boolean MKt;
  private boolean MKu;
  private boolean MKv;
  s iYE;
  private ArrayList<com.tencent.mm.view.recyclerview.a> mXB;
  private RefreshLoadMoreLayout tCU;
  View.OnLongClickListener wOt;
  
  static
  {
    AppMethodBeat.i(238099);
    MKw = new StatusAlbumUI.a((byte)0);
    AppMethodBeat.o(238099);
  }
  
  public StatusAlbumUI()
  {
    AppMethodBeat.i(238097);
    this.mXB = new ArrayList();
    this.wOt = ((View.OnLongClickListener)new h(this));
    this.MKv = true;
    AppMethodBeat.o(238097);
  }
  
  private final void gmB()
  {
    AppMethodBeat.i(238091);
    Iterator localIterator = this.mXB.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.view.recyclerview.a locala = (com.tencent.mm.view.recyclerview.a)localIterator.next();
      if ((locala instanceof com.tencent.mm.plugin.textstatus.g.a.a))
      {
        Object localObject = ((com.tencent.mm.plugin.textstatus.g.a.a)locala).MDH;
        if (localObject != null)
        {
          int n = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject).field_CreateTime;
          long l = n;
          localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          localObject = ((SimpleDateFormat)localObject).parse(((SimpleDateFormat)localObject).format(Long.valueOf(l * 1000L)));
          Calendar localCalendar = Calendar.getInstance();
          p.j(localCalendar, "cal");
          localCalendar.setTime((Date)localObject);
          int m = localCalendar.get(1);
          int k = localCalendar.get(6);
          if (m != j)
          {
            ((com.tencent.mm.plugin.textstatus.g.a.a)locala).MDI = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(b.h.Mzk), n * 1000L).toString();
            j = m;
          }
          for (;;)
          {
            if (k == i) {
              break label241;
            }
            ((com.tencent.mm.plugin.textstatus.g.a.a)locala).MDJ = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(b.h.MyW), n * 1000L).toString();
            i = k;
            break;
            ((com.tencent.mm.plugin.textstatus.g.a.a)locala).MDI = "";
          }
          label241:
          ((com.tencent.mm.plugin.textstatus.g.a.a)locala).MDJ = "";
        }
      }
    }
    AppMethodBeat.o(238091);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(238086);
    p.k(paramView, "v");
    super.dealContentView(paramView);
    Object localObject1 = getActivity();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = g.Xox;
      p.j(localObject1, "it");
      ((com.tencent.mm.plugin.secdata.ui.a)g.lm((Context)localObject1).i(com.tencent.mm.plugin.secdata.ui.a.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.proto.f.class, 9, (byte)0));
      localObject2 = com.tencent.mm.plugin.secdata.ui.a.JbV;
      localObject2 = (com.tencent.mm.plugin.textstatus.proto.f)a.a.a((Context)localObject1, 9, com.tencent.mm.plugin.textstatus.proto.f.class);
      if (localObject2 != null)
      {
        localObject1 = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        localObject1 = com.tencent.mm.plugin.textstatus.h.a.gmn();
        if (localObject1 == null) {
          break label376;
        }
      }
    }
    label376:
    for (localObject1 = ((com.tencent.mm.plugin.textstatus.proto.f)localObject1).sessionId;; localObject1 = null)
    {
      ((com.tencent.mm.plugin.textstatus.proto.f)localObject2).sessionId = ((String)localObject1);
      localObject1 = paramView.findViewById(b.e.recycler_view);
      p.j(localObject1, "v.findViewById(R.id.recycler_view)");
      this.MKr = ((WxRecyclerView)localObject1);
      localObject1 = this.MKr;
      if (localObject1 == null) {
        p.bGy("rvSelfHistory");
      }
      if (localObject1 != null)
      {
        getContext();
        ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      }
      localObject1 = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new c(this), this.mXB, true);
      ((WxRecyclerAdapter)localObject1).YTa = ((com.tencent.mm.view.recyclerview.m)new e(this, (WxRecyclerAdapter)localObject1));
      localObject2 = this.MKr;
      if (localObject2 == null) {
        p.bGy("rvSelfHistory");
      }
      if (localObject2 != null) {
        ((WxRecyclerView)localObject2).setAdapter((RecyclerView.a)localObject1);
      }
      localObject2 = this.MKr;
      if (localObject2 == null) {
        p.bGy("rvSelfHistory");
      }
      if (localObject2 != null) {
        ((WxRecyclerView)localObject2).b((RecyclerView.h)new f(this));
      }
      paramView = paramView.findViewById(b.e.rl_layout);
      p.j(paramView, "v.findViewById(R.id.rl_layout)");
      this.tCU = ((RefreshLoadMoreLayout)paramView);
      paramView = this.tCU;
      if (paramView == null) {
        p.bGy("mRefreshLayout");
      }
      paramView.setActionCallback((RefreshLoadMoreLayout.a)new g(this, (WxRecyclerAdapter)localObject1));
      paramView = this.tCU;
      if (paramView == null) {
        p.bGy("mRefreshLayout");
      }
      this.MKs = new StatusAlbumUI.b((WxRecyclerAdapter)localObject1, paramView);
      Log.i("MicroMsg.TextStatus.StatusAlbumUI", "init OK");
      AppMethodBeat.o(238086);
      return;
    }
  }
  
  public final int getLayoutId()
  {
    return b.f.Myg;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(238080);
    super.onCreate(paramBundle);
    setMMTitle(a.g.album_title);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    com.tencent.mm.kernel.h.aGY().a(5967, (i)this);
    AppMethodBeat.o(238080);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(238082);
    super.onDestroy();
    StatusAlbumUI.b localb = this.MKs;
    if (localb == null) {
      p.bGy("dataLoader");
    }
    com.tencent.mm.kernel.h.aGY().b(4245, localb.jxB);
    com.tencent.mm.kernel.h.aGY().b(5967, (i)this);
    AppMethodBeat.o(238082);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(238096);
    Iterator localIterator;
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label165;
      }
      paramInt1 = 1;
      if (paramInt1 != 0) {
        localIterator = this.mXB.iterator();
      }
    }
    label165:
    label197:
    label200:
    for (;;)
    {
      com.tencent.mm.view.recyclerview.a locala;
      if (localIterator.hasNext())
      {
        locala = (com.tencent.mm.view.recyclerview.a)localIterator.next();
        if (!(locala instanceof com.tencent.mm.plugin.textstatus.g.a.a)) {
          continue;
        }
        paramString = ((com.tencent.mm.plugin.textstatus.g.a.a)locala).MDH;
        if (paramString == null) {
          break label197;
        }
      }
      for (paramString = paramString.field_StatusID;; paramString = null)
      {
        if (!p.h(paramString, ((com.tencent.mm.plugin.textstatus.g.a)paramq).MBU)) {
          break label200;
        }
        this.mXB.remove(locala);
        gmB();
        paramString = this.MKr;
        if (paramString == null) {
          p.bGy("rvSelfHistory");
        }
        if (paramString != null)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.notifyDataSetChanged();
          }
        }
        paramString = this.iYE;
        if (paramString == null) {
          break label202;
        }
        paramString.dismiss();
        AppMethodBeat.o(238096);
        return;
        paramString = getContext();
        if (paramString != null) {
          com.tencent.mm.ui.base.h.af((Context)paramString, paramString.getString(b.h.Myu), "");
        }
        paramInt1 = 0;
        break;
      }
    }
    label202:
    AppMethodBeat.o(238096);
  }
  
  public final void onVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(238087);
    super.onVisibilityChanged(paramBoolean);
    Log.i("MicroMsg.TextStatus.StatusAlbumUI", "[onVisibilityChanged]" + paramBoolean + ' ' + this.MKu);
    if ((paramBoolean) && (!this.MKu))
    {
      StatusAlbumUI.b localb = this.MKs;
      if (localb == null) {
        p.bGy("dataLoader");
      }
      localb.eZs();
      this.MKu = true;
    }
    AppMethodBeat.o(238087);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class c
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(237999);
      switch (paramInt)
      {
      default: 
        locale = (e)new com.tencent.mm.plugin.textstatus.b.a.a();
        AppMethodBeat.o(237999);
        return locale;
      }
      e locale = (e)new com.tencent.mm.plugin.textstatus.b.a.b(this.MKA.wOt);
      AppMethodBeat.o(237999);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(StatusAlbumUI paramStatusAlbumUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(233080);
      paramMenuItem = this.MKA.getActivity();
      if (paramMenuItem != null) {
        paramMenuItem.finish();
      }
      AppMethodBeat.o(233080);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-textstatus_release"})
  public static final class e
    implements com.tencent.mm.view.recyclerview.m
  {
    e(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void a(RecyclerView paramRecyclerView, k paramk)
    {
      AppMethodBeat.i(238609);
      p.k(paramRecyclerView, "recyclerView");
      p.k(paramk, "data");
      if ((paramk.xrj >= this.xjD.getItemCount() - 1) && (!StatusAlbumUI.a(this.MKA)))
      {
        paramRecyclerView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(14L, null, null, 0L, 14);
        StatusAlbumUI.b(this.MKA);
      }
      AppMethodBeat.o(238609);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class f
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(238890);
      p.k(paramRect, "outRect");
      p.k(paramRecyclerView, "parent");
      paramRecyclerView = StatusAlbumUI.c(this.MKA);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {}
      }
      for (int i = paramRecyclerView.getItemCount(); paramInt == i - 1; i = 1)
      {
        paramRect.bottom = com.tencent.mm.ci.a.fromDPToPix((Context)this.MKA.getContext(), 16);
        AppMethodBeat.o(238890);
        return;
      }
      paramRect.bottom = com.tencent.mm.ci.a.fromDPToPix((Context)this.MKA.getContext(), 8);
      AppMethodBeat.o(238890);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-textstatus_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    g(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(237295);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(237295);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(237293);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      p.k(paramc, "reason");
      Log.i("MicroMsg.TextStatus.StatusAlbumUI", "onLoadMoreEnd");
      if (!StatusAlbumUI.d(this.MKA).xcp)
      {
        RefreshLoadMoreLayout.e(StatusAlbumUI.e(this.MKA));
        if (this.xjD.YSl.size() == 0)
        {
          paramc = ad.kS(StatusAlbumUI.c(this.MKA).getContext()).inflate(b.f.Myl, (ViewGroup)StatusAlbumUI.c(this.MKA), false);
          localObject = this.xjD;
          p.j(paramc, "footer");
          com.tencent.mm.view.recyclerview.h.b((com.tencent.mm.view.recyclerview.h)localObject, paramc, 2147483647);
          paramc.findViewById(b.e.Mwg).setOnClickListener((View.OnClickListener)new b(this));
        }
        Log.i("MicroMsg.TextStatus.StatusAlbumUI", "hasMoreData true");
      }
      StatusAlbumUI.f(this.MKA);
      paramc = StatusAlbumUI.c(this.MKA);
      if (paramc != null)
      {
        paramc = paramc.getAdapter();
        if (paramc != null) {
          paramc.notifyDataSetChanged();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(237293);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(237290);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      d.uiThread((kotlin.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(237290);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(237297);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(237297);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(StatusAlbumUI.g paramg)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(StatusAlbumUI.g paramg) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(235685);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3$onLoadMoreEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Intent localIntent = new Intent();
        paramView = this.MKB.MKA.getActivity();
        if (paramView != null)
        {
          paramView = paramView.getIntent();
          if (paramView != null)
          {
            localObject = paramView.getExtras();
            paramView = (View)localObject;
            if (localObject != null) {
              break label85;
            }
          }
        }
        paramView = new Bundle();
        label85:
        paramView = localIntent.putExtras(paramView);
        p.j(paramView, "Intent().putExtras(activ…intent?.extras?:Bundle())");
        paramView.putExtra("story_only", true);
        com.tencent.mm.by.c.b((Context)this.MKB.MKA.getContext(), "", "com.tencent.mm.ui.AlbumUI", paramView);
        paramView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
        com.tencent.mm.plugin.textstatus.h.a.a(15L, null, null, 0L, 14);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3$onLoadMoreEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(235685);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class h
    implements View.OnLongClickListener
  {
    h(StatusAlbumUI paramStatusAlbumUI) {}
    
    public final boolean onLongClick(final View paramView)
    {
      AppMethodBeat.i(233675);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      localObject1 = paramView.getTag(b.e.Mwo);
      paramView = (View)localObject1;
      if (!(localObject1 instanceof com.tencent.mm.plugin.textstatus.g.a.a)) {
        paramView = null;
      }
      Object localObject2 = (com.tencent.mm.plugin.textstatus.g.a.a)paramView;
      if (localObject2 == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(233675);
        return true;
      }
      paramView = this.MKA.getContext();
      if (paramView == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(233675);
        return true;
      }
      p.j(paramView, "context?:return@OnLongClickListener true");
      localObject1 = new com.tencent.mm.ui.tools.m((Context)paramView);
      ((com.tencent.mm.ui.tools.m)localObject1).a((q.f)1.MKC);
      localObject2 = ((com.tencent.mm.plugin.textstatus.g.a.a)localObject2).MDH;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_StatusID;
        if (localObject2 != null) {}
      }
      else
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(233675);
        return true;
      }
      ((com.tencent.mm.ui.tools.m)localObject1).a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(237971);
          p.j(paramAnonymousMenuItem, "menuItem");
          StatusAlbumUI localStatusAlbumUI;
          Context localContext;
          if (paramAnonymousMenuItem.getItemId() == b.e.Mwp)
          {
            localStatusAlbumUI = this.MKD.MKA;
            localContext = (Context)paramView;
            paramAnonymousMenuItem = paramView;
            if (paramAnonymousMenuItem == null) {
              break label145;
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.getResources();
            paramAnonymousMenuItem.getString(b.h.Myw);
            paramAnonymousMenuItem = paramView;
            if (paramAnonymousMenuItem == null) {
              break label150;
            }
          }
          label145:
          label150:
          for (paramAnonymousMenuItem = paramAnonymousMenuItem.getResources();; paramAnonymousMenuItem = null)
          {
            localStatusAlbumUI.iYE = com.tencent.mm.ui.base.h.a(localContext, paramAnonymousMenuItem.getString(b.h.Myw), false, null);
            paramAnonymousMenuItem = new com.tencent.mm.plugin.textstatus.g.a(this.MCL, 2);
            com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)paramAnonymousMenuItem);
            paramAnonymousMenuItem = com.tencent.mm.plugin.textstatus.h.a.MGJ;
            com.tencent.mm.plugin.textstatus.h.a.a((Context)paramView, 43L, null, null, 12);
            AppMethodBeat.o(237971);
            return;
            paramAnonymousMenuItem = null;
            break;
          }
        }
      });
      ((com.tencent.mm.ui.tools.m)localObject1).hYu();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(233675);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI
 * JD-Core Version:    0.7.0.1
 */