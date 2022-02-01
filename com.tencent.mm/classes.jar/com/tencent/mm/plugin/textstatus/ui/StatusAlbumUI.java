package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC.a;
import com.tencent.mm.plugin.textstatus.g.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "canContinue", "", "getCanContinue", "()Z", "setCanContinue", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$HistoryItemLoader;", "hasShowStoryEntry", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "getLastLoadContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastLoadContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "longClickListener", "Landroid/view/View$OnLongClickListener;", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "rvSelfHistory", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealContentView", "", "v", "Landroid/view/View;", "getCal", "Ljava/util/Calendar;", "timeStamp", "", "getLayoutId", "", "initActionBar", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "preData", "supportNavigationSwipeBack", "Companion", "HistoryItemLoader", "plugin-textstatus_release"})
public final class StatusAlbumUI
  extends MMFragment
  implements i
{
  public static final StatusAlbumUI.a Gdm;
  private WxRecyclerView Gdj;
  private StatusAlbumUI.b Gdk;
  private boolean Gdl;
  private boolean UsR;
  com.tencent.mm.ui.base.q gut;
  private ArrayList<com.tencent.mm.view.recyclerview.a> kgc;
  private RefreshLoadMoreLayout qgY;
  View.OnLongClickListener tib;
  
  static
  {
    AppMethodBeat.i(216440);
    Gdm = new StatusAlbumUI.a((byte)0);
    AppMethodBeat.o(216440);
  }
  
  public StatusAlbumUI()
  {
    AppMethodBeat.i(216439);
    this.kgc = new ArrayList();
    this.tib = ((View.OnLongClickListener)new g(this));
    this.Gdl = true;
    AppMethodBeat.o(216439);
  }
  
  private final void fwl()
  {
    AppMethodBeat.i(216437);
    Iterator localIterator = this.kgc.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.view.recyclerview.a locala = (com.tencent.mm.view.recyclerview.a)localIterator.next();
      if ((locala instanceof com.tencent.mm.plugin.textstatus.f.a.a))
      {
        Object localObject = ((com.tencent.mm.plugin.textstatus.f.a.a)locala).FZq;
        if (localObject != null)
        {
          int n = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject).field_CreateTime;
          long l = n;
          localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          localObject = ((SimpleDateFormat)localObject).parse(((SimpleDateFormat)localObject).format(Long.valueOf(l * 1000L)));
          Calendar localCalendar = Calendar.getInstance();
          p.g(localCalendar, "cal");
          localCalendar.setTime((Date)localObject);
          int m = localCalendar.get(1);
          int k = localCalendar.get(6);
          if (m != j)
          {
            ((com.tencent.mm.plugin.textstatus.f.a.a)locala).FZr = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(2131766751), n * 1000L).toString();
            j = m;
          }
          for (;;)
          {
            if (k == i) {
              break label241;
            }
            ((com.tencent.mm.plugin.textstatus.f.a.a)locala).FZs = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(2131766727), n * 1000L).toString();
            i = k;
            break;
            ((com.tencent.mm.plugin.textstatus.f.a.a)locala).FZr = "";
          }
          label241:
          ((com.tencent.mm.plugin.textstatus.f.a.a)locala).FZs = "";
        }
      }
    }
    AppMethodBeat.o(216437);
  }
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(216436);
    p.h(paramView, "v");
    super.dealContentView(paramView);
    Object localObject = paramView.findViewById(2131306757);
    p.g(localObject, "v.findViewById(R.id.recycler_view)");
    this.Gdj = ((WxRecyclerView)localObject);
    localObject = this.Gdj;
    if (localObject == null) {
      p.btv("rvSelfHistory");
    }
    if (localObject != null)
    {
      getContext();
      ((WxRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    localObject = new WxRecyclerAdapter((f)new c(this), this.kgc);
    WxRecyclerView localWxRecyclerView = this.Gdj;
    if (localWxRecyclerView == null) {
      p.btv("rvSelfHistory");
    }
    if (localWxRecyclerView != null) {
      localWxRecyclerView.setAdapter((RecyclerView.a)localObject);
    }
    localWxRecyclerView = this.Gdj;
    if (localWxRecyclerView == null) {
      p.btv("rvSelfHistory");
    }
    if (localWxRecyclerView != null) {
      localWxRecyclerView.b((RecyclerView.h)new e(this));
    }
    paramView = paramView.findViewById(2131307118);
    p.g(paramView, "v.findViewById(R.id.rl_layout)");
    this.qgY = ((RefreshLoadMoreLayout)paramView);
    paramView = this.qgY;
    if (paramView == null) {
      p.btv("mRefreshLayout");
    }
    paramView.setActionCallback((RefreshLoadMoreLayout.a)new f(this, (WxRecyclerAdapter)localObject));
    paramView = this.qgY;
    if (paramView == null) {
      p.btv("mRefreshLayout");
    }
    this.Gdk = new StatusAlbumUI.b((WxRecyclerAdapter)localObject, paramView);
    paramView = this.Gdk;
    if (paramView == null) {
      p.btv("dataLoader");
    }
    paramView.epE();
    Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "init OK");
    AppMethodBeat.o(216436);
  }
  
  public final int getLayoutId()
  {
    return 2131496701;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216434);
    super.onCreate(paramBundle);
    setMMTitle(2131755286);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    AppMethodBeat.o(216434);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(216435);
    super.onDestroy();
    StatusAlbumUI.b localb = this.Gdk;
    if (localb == null) {
      p.btv("dataLoader");
    }
    com.tencent.mm.kernel.g.azz().b(4245, localb.gNh);
    com.tencent.mm.kernel.g.azz().b(5967, (i)this);
    AppMethodBeat.o(216435);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216438);
    Iterator localIterator;
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.f.a))
    {
      com.tencent.mm.kernel.g.azz().b(((com.tencent.mm.plugin.textstatus.f.a)paramq).getType(), (i)this);
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label183;
      }
      paramInt1 = 1;
      if (paramInt1 != 0) {
        localIterator = this.kgc.iterator();
      }
    }
    label183:
    label215:
    label218:
    for (;;)
    {
      com.tencent.mm.view.recyclerview.a locala;
      if (localIterator.hasNext())
      {
        locala = (com.tencent.mm.view.recyclerview.a)localIterator.next();
        if (!(locala instanceof com.tencent.mm.plugin.textstatus.f.a.a)) {
          continue;
        }
        paramString = ((com.tencent.mm.plugin.textstatus.f.a.a)locala).FZq;
        if (paramString == null) {
          break label215;
        }
      }
      for (paramString = paramString.field_StatusID;; paramString = null)
      {
        if (!p.j(paramString, ((com.tencent.mm.plugin.textstatus.f.a)paramq).FYf)) {
          break label218;
        }
        this.kgc.remove(locala);
        fwl();
        paramString = this.Gdj;
        if (paramString == null) {
          p.btv("rvSelfHistory");
        }
        if (paramString != null)
        {
          paramString = paramString.getAdapter();
          if (paramString != null) {
            paramString.notifyDataSetChanged();
          }
        }
        paramString = this.gut;
        if (paramString == null) {
          break label220;
        }
        paramString.dismiss();
        AppMethodBeat.o(216438);
        return;
        paramString = getContext();
        if (paramString != null) {
          h.X((Context)paramString, paramString.getString(2131766714), "");
        }
        paramInt1 = 0;
        break;
      }
    }
    label220:
    AppMethodBeat.o(216438);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class c
    implements f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(216421);
      switch (paramInt)
      {
      default: 
        locale = (e)new com.tencent.mm.plugin.textstatus.b.a.a();
        AppMethodBeat.o(216421);
        return locale;
      }
      e locale = (e)new com.tencent.mm.plugin.textstatus.b.a.b(this.Gdq.tib);
      AppMethodBeat.o(216421);
      return locale;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(StatusAlbumUI paramStatusAlbumUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(216422);
      paramMenuItem = this.Gdq.getActivity();
      if (paramMenuItem != null) {
        paramMenuItem.finish();
      }
      AppMethodBeat.o(216422);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
  public static final class e
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(216423);
      p.h(paramRect, "outRect");
      p.h(paramRecyclerView, "parent");
      paramRecyclerView = StatusAlbumUI.a(this.Gdq);
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.getAdapter();
        if (paramRecyclerView == null) {}
      }
      for (int i = paramRecyclerView.getItemCount(); paramInt == i - 1; i = 1)
      {
        paramRect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context)this.Gdq.getContext(), 16);
        AppMethodBeat.o(216423);
        return;
      }
      paramRect.bottom = com.tencent.mm.cb.a.fromDPToPix((Context)this.Gdq.getContext(), 8);
      AppMethodBeat.o(216423);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-textstatus_release"})
  public static final class f
    extends RefreshLoadMoreLayout.a
  {
    f(WxRecyclerAdapter paramWxRecyclerAdapter) {}
    
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(216428);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(216428);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(216427);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      p.h(paramc, "reason");
      Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "onLoadMoreEnd");
      if (!StatusAlbumUI.b(this.Gdq).tuG)
      {
        RefreshLoadMoreLayout.e(StatusAlbumUI.c(this.Gdq));
        if (!StatusAlbumUI.e(this.Gdq))
        {
          paramc = com.tencent.mm.plugin.textstatus.k.a.UsD;
          com.tencent.mm.plugin.textstatus.k.a.Rk(14L);
          StatusAlbumUI.f(this.Gdq);
        }
        if (this.uMv.RqN.size() == 0)
        {
          paramc = aa.jQ(StatusAlbumUI.a(this.Gdq).getContext()).inflate(2131497126, (ViewGroup)StatusAlbumUI.a(this.Gdq), false);
          localObject = this.uMv;
          p.g(paramc, "footer");
          com.tencent.mm.view.recyclerview.g.b((com.tencent.mm.view.recyclerview.g)localObject, paramc, 2147483647);
          paramc.findViewById(2131310693).setOnClickListener((View.OnClickListener)new b(this));
        }
        Log.i("MicroMsg.TxtStatus.StatusAlbumUI", "hasMoreData true");
      }
      StatusAlbumUI.d(this.Gdq);
      paramc = StatusAlbumUI.a(this.Gdq);
      if (paramc != null)
      {
        paramc = paramc.getAdapter();
        if (paramc != null) {
          paramc.notifyDataSetChanged();
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(216427);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(216426);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      d.h((kotlin.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(216426);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(216429);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(216429);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(StatusAlbumUI.f paramf)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(StatusAlbumUI.f paramf) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(216425);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2$onLoadMoreEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Intent localIntent = new Intent();
        paramView = this.Gdr.Gdq.getActivity();
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
        p.g(paramView, "Intent().putExtras(activ…intent?.extras?:Bundle())");
        paramView.putExtra("story_only", true);
        c.b((Context)this.Gdr.Gdq.getContext(), "", "com.tencent.mm.ui.AlbumUI", paramView);
        paramView = com.tencent.mm.plugin.textstatus.k.a.UsD;
        com.tencent.mm.plugin.textstatus.k.a.Rk(15L);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2$onLoadMoreEnd$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(216425);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class g
    implements View.OnLongClickListener
  {
    g(StatusAlbumUI paramStatusAlbumUI) {}
    
    public final boolean onLongClick(final View paramView)
    {
      AppMethodBeat.i(216433);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).axR());
      localObject1 = paramView.getTag(2131303824);
      paramView = (View)localObject1;
      if (!(localObject1 instanceof com.tencent.mm.plugin.textstatus.f.a.a)) {
        paramView = null;
      }
      Object localObject2 = (com.tencent.mm.plugin.textstatus.f.a.a)paramView;
      if (localObject2 == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(216433);
        return true;
      }
      paramView = this.Gdq.getContext();
      if (paramView == null)
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(216433);
        return true;
      }
      p.g(paramView, "context?:return@OnLongClickListener true");
      localObject1 = new com.tencent.mm.ui.tools.l((Context)paramView);
      ((com.tencent.mm.ui.tools.l)localObject1).a((o.f)StatusAlbumUI.g.1.Gds);
      localObject2 = ((com.tencent.mm.plugin.textstatus.f.a.a)localObject2).FZq;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.textstatus.f.f.a)localObject2).field_StatusID;
        if (localObject2 != null) {}
      }
      else
      {
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(216433);
        return true;
      }
      ((com.tencent.mm.ui.tools.l)localObject1).a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(216432);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 2131304610)
          {
            Object localObject = this.Gdt.Gdq;
            Context localContext = (Context)paramView;
            paramAnonymousMenuItem = paramView;
            if (paramAnonymousMenuItem != null)
            {
              paramAnonymousMenuItem = paramAnonymousMenuItem.getResources();
              paramAnonymousMenuItem.getString(2131767880);
              paramAnonymousMenuItem = paramView;
              if (paramAnonymousMenuItem == null) {
                break label183;
              }
            }
            label183:
            for (paramAnonymousMenuItem = paramAnonymousMenuItem.getResources();; paramAnonymousMenuItem = null)
            {
              ((StatusAlbumUI)localObject).gut = h.a(localContext, paramAnonymousMenuItem.getString(2131767880), false, null);
              paramAnonymousMenuItem = new com.tencent.mm.plugin.textstatus.f.a(this.Gdu, 2);
              com.tencent.mm.kernel.g.azz().a(paramAnonymousMenuItem.getType(), (i)this.Gdt.Gdq);
              com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)paramAnonymousMenuItem);
              paramAnonymousMenuItem = SecDataUIC.CWq;
              paramAnonymousMenuItem = (y)SecDataUIC.a.a((Context)paramView, 9, y.class);
              if (paramAnonymousMenuItem == null) {
                break label188;
              }
              localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
              com.tencent.mm.plugin.textstatus.k.a.a(43L, paramAnonymousMenuItem);
              AppMethodBeat.o(216432);
              return;
              paramAnonymousMenuItem = null;
              break;
            }
          }
          label188:
          AppMethodBeat.o(216432);
        }
      });
      ((com.tencent.mm.ui.tools.l)localObject1).gXI();
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$longClickListener$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(216433);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI
 * JD-Core Version:    0.7.0.1
 */