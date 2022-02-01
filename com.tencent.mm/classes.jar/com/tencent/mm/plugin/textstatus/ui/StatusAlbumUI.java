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
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.plugin.story.a.g;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.RefreshLoadMoreLayout.d<Ljava.lang.Object;>;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.o;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI;", "Lcom/tencent/mm/ui/MMFragment;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "canContinue", "", "getCanContinue", "()Z", "setCanContinue", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$HistoryItemLoader;", "hasShowStoryEntry", "isInitLoaded", "setInitLoaded", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "getLastLoadContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastLoadContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "longClickListener", "Landroid/view/View$OnLongClickListener;", "getLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "rvSelfHistory", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "dealContentView", "", "v", "Landroid/view/View;", "getCal", "Ljava/util/Calendar;", "timeStamp", "", "getLayoutId", "", "initActionBar", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onVisibilityChanged", "visible", "preData", "supportNavigationSwipeBack", "Companion", "HistoryItemLoader", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StatusAlbumUI
  extends MMFragment
  implements com.tencent.mm.am.h
{
  public static final StatusAlbumUI.a TwB;
  View.OnLongClickListener AkV;
  private WxRecyclerView TwC;
  private StatusAlbumUI.b TwD;
  private boolean TwE;
  private boolean TwF;
  private boolean TwG;
  private ArrayList<com.tencent.mm.view.recyclerview.a> pUj;
  private w psR;
  private RefreshLoadMoreLayout wGX;
  
  static
  {
    AppMethodBeat.i(291568);
    TwB = new StatusAlbumUI.a((byte)0);
    AppMethodBeat.o(291568);
  }
  
  public StatusAlbumUI()
  {
    AppMethodBeat.i(291482);
    this.pUj = new ArrayList();
    this.AkV = new StatusAlbumUI..ExternalSyntheticLambda1(this);
    this.TwG = true;
    AppMethodBeat.o(291482);
  }
  
  private static final void a(StatusAlbumUI paramStatusAlbumUI, Activity paramActivity, String paramString, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(291522);
    kotlin.g.b.s.u(paramStatusAlbumUI, "this$0");
    kotlin.g.b.s.u(paramActivity, "$context");
    kotlin.g.b.s.u(paramString, "$statusId");
    if (paramMenuItem.getItemId() == a.e.TdG)
    {
      paramMenuItem = (Context)paramActivity;
      paramActivity.getResources().getString(a.h.Tgd);
      paramStatusAlbumUI.psR = com.tencent.mm.ui.base.k.a(paramMenuItem, paramActivity.getResources().getString(a.h.Tgd), false, null);
      paramStatusAlbumUI = new com.tencent.mm.plugin.textstatus.h.a(paramString, 2);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramStatusAlbumUI, 0);
      paramStatusAlbumUI = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a((Context)paramActivity, 43L, null, null, 0L, 0L, 0L, 124);
    }
    AppMethodBeat.o(291522);
  }
  
  private static final boolean a(StatusAlbumUI paramStatusAlbumUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291504);
    kotlin.g.b.s.u(paramStatusAlbumUI, "this$0");
    paramStatusAlbumUI = paramStatusAlbumUI.getActivity();
    if (paramStatusAlbumUI != null) {
      paramStatusAlbumUI.finish();
    }
    AppMethodBeat.o(291504);
    return true;
  }
  
  private static final boolean a(StatusAlbumUI paramStatusAlbumUI, View paramView)
  {
    AppMethodBeat.i(291530);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramStatusAlbumUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramStatusAlbumUI, "this$0");
    paramView = paramView.getTag(a.e.TdF);
    if ((paramView instanceof com.tencent.mm.plugin.textstatus.h.a.a)) {}
    for (paramView = (com.tencent.mm.plugin.textstatus.h.a.a)paramView; paramView == null; paramView = null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(291530);
      return true;
    }
    localObject1 = paramStatusAlbumUI.getContext();
    if (localObject1 == null)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(291530);
      return true;
    }
    localObject2 = new l((Context)localObject1);
    ((l)localObject2).Vtg = StatusAlbumUI..ExternalSyntheticLambda2.INSTANCE;
    paramView = paramView.Tnj;
    if (paramView == null) {}
    for (paramView = null; paramView == null; paramView = paramView.field_StatusID)
    {
      com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(291530);
      return true;
    }
    ((l)localObject2).GAC = new StatusAlbumUI..ExternalSyntheticLambda3(paramStatusAlbumUI, (Activity)localObject1, paramView);
    ((l)localObject2).jDd();
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(291530);
    return true;
  }
  
  private final void hIy()
  {
    AppMethodBeat.i(291496);
    Iterator localIterator = this.pUj.iterator();
    int i = 0;
    int j = 0;
    while (localIterator.hasNext())
    {
      com.tencent.mm.view.recyclerview.a locala = (com.tencent.mm.view.recyclerview.a)localIterator.next();
      if ((locala instanceof com.tencent.mm.plugin.textstatus.h.a.a))
      {
        Object localObject = ((com.tencent.mm.plugin.textstatus.h.a.a)locala).Tnj;
        if (localObject != null)
        {
          int n = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_CreateTime;
          long l = n;
          localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          localObject = ((SimpleDateFormat)localObject).parse(((SimpleDateFormat)localObject).format(Long.valueOf(l * 1000L)));
          Calendar localCalendar = Calendar.getInstance();
          localCalendar.setTime((Date)localObject);
          kotlin.g.b.s.s(localCalendar, "cal");
          int m = localCalendar.get(1);
          int k = localCalendar.get(6);
          if (m != j)
          {
            ((com.tencent.mm.plugin.textstatus.h.a.a)locala).Tnk = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(a.h.Thk), n * 1000L).toString();
            j = m;
          }
          for (;;)
          {
            if (k == i) {
              break label244;
            }
            ((com.tencent.mm.plugin.textstatus.h.a.a)locala).Tnl = DateFormat.format((CharSequence)MMApplicationContext.getContext().getString(a.h.TgP), n * 1000L).toString();
            i = k;
            break;
            ((com.tencent.mm.plugin.textstatus.h.a.a)locala).Tnk = "";
          }
          label244:
          ((com.tencent.mm.plugin.textstatus.h.a.a)locala).Tnl = "";
        }
      }
    }
    AppMethodBeat.o(291496);
  }
  
  private static final void u(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(291512);
    params.c(a.e.TdG, (CharSequence)"删除");
    AppMethodBeat.o(291512);
  }
  
  public final void dealContentView(View paramView)
  {
    Object localObject2 = null;
    AppMethodBeat.i(291618);
    kotlin.g.b.s.u(paramView, "v");
    super.dealContentView(paramView);
    Object localObject1 = getActivity();
    Object localObject3;
    if (localObject1 != null)
    {
      localObject3 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.secdata.ui.a)com.tencent.mm.ui.component.k.nq((Context)localObject1).q(com.tencent.mm.plugin.secdata.ui.a.class)).a((com.tencent.mm.plugin.secdata.h)new com.tencent.mm.plugin.secdata.c(com.tencent.mm.plugin.textstatus.proto.p.class, 9, (byte)0));
      localObject3 = com.tencent.mm.plugin.secdata.ui.a.PlI;
      localObject3 = (com.tencent.mm.plugin.textstatus.proto.p)a.a.a((Context)localObject1, 9, com.tencent.mm.plugin.textstatus.proto.p.class);
      if (localObject3 != null)
      {
        localObject1 = com.tencent.mm.plugin.textstatus.i.b.Trt;
        localObject1 = com.tencent.mm.plugin.textstatus.i.b.hHY();
        if (localObject1 != null) {
          break label382;
        }
        localObject1 = null;
        ((com.tencent.mm.plugin.textstatus.proto.p)localObject3).sessionId = ((String)localObject1);
      }
    }
    localObject1 = paramView.findViewById(a.e.recycler_view);
    kotlin.g.b.s.s(localObject1, "v.findViewById(R.id.recycler_view)");
    this.TwC = ((WxRecyclerView)localObject1);
    localObject1 = this.TwC;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("rvSelfHistory");
      localObject1 = null;
      label156:
      getContext();
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      localObject3 = new WxRecyclerAdapter((g)new c(this), this.pUj, true);
      ((WxRecyclerAdapter)localObject3).agOS = ((o)new d((WxRecyclerAdapter)localObject3, this));
      localObject1 = this.TwC;
      if (localObject1 != null) {
        break label393;
      }
      kotlin.g.b.s.bIx("rvSelfHistory");
      localObject1 = null;
      label237:
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject3);
      localObject1 = this.TwC;
      if (localObject1 != null) {
        break label396;
      }
      kotlin.g.b.s.bIx("rvSelfHistory");
      localObject1 = null;
      label263:
      ((RecyclerView)localObject1).a((RecyclerView.h)new e(this));
      paramView = paramView.findViewById(a.e.rl_layout);
      kotlin.g.b.s.s(paramView, "v.findViewById(R.id.rl_layout)");
      this.wGX = ((RefreshLoadMoreLayout)paramView);
      paramView = this.wGX;
      if (paramView != null) {
        break label399;
      }
      kotlin.g.b.s.bIx("mRefreshLayout");
      paramView = null;
      label318:
      paramView.setActionCallback((RefreshLoadMoreLayout.b)new f(this, (WxRecyclerAdapter)localObject3));
      paramView = this.wGX;
      if (paramView != null) {
        break label402;
      }
      kotlin.g.b.s.bIx("mRefreshLayout");
      paramView = localObject2;
    }
    label393:
    label396:
    label399:
    label402:
    for (;;)
    {
      this.TwD = new StatusAlbumUI.b((WxRecyclerAdapter)localObject3, paramView);
      Log.i("MicroMsg.TextStatus.StatusAlbumUI", "init OK");
      AppMethodBeat.o(291618);
      return;
      label382:
      localObject1 = ((com.tencent.mm.plugin.textstatus.proto.p)localObject1).sessionId;
      break;
      break label156;
      break label237;
      break label263;
      break label318;
    }
  }
  
  public final int getLayoutId()
  {
    return a.f.TfK;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291598);
    super.onCreate(paramBundle);
    setMMTitle(a.g.album_title);
    setBackBtn(new StatusAlbumUI..ExternalSyntheticLambda0(this));
    com.tencent.mm.kernel.h.aZW().a(5967, (com.tencent.mm.am.h)this);
    ((com.tencent.mm.plugin.textstatus.a.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.u.class)).hFB();
    ((com.tencent.mm.plugin.textstatus.a.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.u.class)).hFD();
    AppMethodBeat.o(291598);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291602);
    super.onDestroy();
    StatusAlbumUI.b localb2 = this.TwD;
    StatusAlbumUI.b localb1 = localb2;
    if (localb2 == null)
    {
      kotlin.g.b.s.bIx("dataLoader");
      localb1 = null;
    }
    com.tencent.mm.kernel.h.aZW().b(4245, localb1.maV);
    com.tencent.mm.kernel.h.aZW().b(5967, (com.tencent.mm.am.h)this);
    ((com.tencent.mm.plugin.textstatus.a.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.u.class)).hFC();
    ((com.tencent.mm.plugin.textstatus.a.u)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.u.class)).hFE();
    AppMethodBeat.o(291602);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(291633);
    if ((paramp instanceof com.tencent.mm.plugin.textstatus.h.a))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label168;
      }
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        Iterator localIterator = this.pUj.iterator();
        label40:
        while (localIterator.hasNext())
        {
          com.tencent.mm.view.recyclerview.a locala = (com.tencent.mm.view.recyclerview.a)localIterator.next();
          if ((locala instanceof com.tencent.mm.plugin.textstatus.h.a.a))
          {
            paramString = ((com.tencent.mm.plugin.textstatus.h.a.a)locala).Tnj;
            if (paramString != null) {
              break label201;
            }
            paramString = null;
            label85:
            if (!kotlin.g.b.s.p(paramString, ((com.tencent.mm.plugin.textstatus.h.a)paramp).Tly)) {
              break label207;
            }
            this.pUj.remove(locala);
          }
        }
        hIy();
        paramString = this.TwC;
        if (paramString != null) {
          break label209;
        }
        kotlin.g.b.s.bIx("rvSelfHistory");
        paramString = localObject;
      }
    }
    label168:
    label201:
    label207:
    label209:
    for (;;)
    {
      paramString = paramString.getAdapter();
      if (paramString != null) {
        paramString.bZE.notifyChanged();
      }
      paramString = this.psR;
      if (paramString != null) {
        paramString.dismiss();
      }
      AppMethodBeat.o(291633);
      return;
      paramString = getContext();
      if (paramString != null) {
        com.tencent.mm.ui.base.k.c((Context)paramString, paramString.getString(a.h.Tgb), "", true);
      }
      paramInt1 = 0;
      break;
      paramString = paramString.field_StatusID;
      break label85;
      break label40;
    }
  }
  
  public final void onVisibilityChanged(boolean paramBoolean)
  {
    AppMethodBeat.i(291623);
    super.onVisibilityChanged(paramBoolean);
    Log.i("MicroMsg.TextStatus.StatusAlbumUI", "[onVisibilityChanged]" + paramBoolean + ' ' + this.TwF);
    if ((paramBoolean) && (!this.TwF))
    {
      StatusAlbumUI.b localb2 = this.TwD;
      StatusAlbumUI.b localb1 = localb2;
      if (localb2 == null)
      {
        kotlin.g.b.s.bIx("dataLoader");
        localb1 = null;
      }
      localb1.gir();
      this.TwF = true;
    }
    AppMethodBeat.o(291623);
  }
  
  public final boolean supportNavigationSwipeBack()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements g
  {
    c(StatusAlbumUI paramStatusAlbumUI) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(291532);
      if (paramInt == 0)
      {
        localf = (f)new com.tencent.mm.plugin.textstatus.b.a.a(this.TwJ.AkV);
        AppMethodBeat.o(291532);
        return localf;
      }
      f localf = (f)new com.tencent.mm.plugin.textstatus.b.a.a(this.TwJ.AkV);
      AppMethodBeat.o(291532);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements o
  {
    d(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, StatusAlbumUI paramStatusAlbumUI) {}
    
    public final void a(RecyclerView paramRecyclerView, m paramm)
    {
      AppMethodBeat.i(291536);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramm, "data");
      if ((paramm.AOt >= this.BaD.getItemCount() - 1) && (!StatusAlbumUI.a(jdField_this)))
      {
        paramRecyclerView = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(14L, null, null, 0L, null, 30);
        StatusAlbumUI.b(jdField_this);
      }
      AppMethodBeat.o(291536);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends RecyclerView.h
  {
    e(StatusAlbumUI paramStatusAlbumUI) {}
    
    public final void a(Rect paramRect, int paramInt, RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(291575);
      kotlin.g.b.s.u(paramRect, "outRect");
      kotlin.g.b.s.u(paramRecyclerView, "parent");
      WxRecyclerView localWxRecyclerView = StatusAlbumUI.c(this.TwJ);
      paramRecyclerView = localWxRecyclerView;
      if (localWxRecyclerView == null)
      {
        kotlin.g.b.s.bIx("rvSelfHistory");
        paramRecyclerView = null;
      }
      paramRecyclerView = paramRecyclerView.getAdapter();
      if (paramRecyclerView == null) {}
      for (int i = 1; paramInt == i - 1; i = paramRecyclerView.getItemCount())
      {
        paramRect.bottom = com.tencent.mm.cd.a.fromDPToPix((Context)this.TwJ.getContext(), 16);
        AppMethodBeat.o(291575);
        return;
      }
      paramRect.bottom = com.tencent.mm.cd.a.fromDPToPix((Context)this.TwJ.getContext(), 8);
      AppMethodBeat.o(291575);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends RefreshLoadMoreLayout.b
  {
    f(StatusAlbumUI paramStatusAlbumUI, WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter) {}
    
    private static final void b(StatusAlbumUI paramStatusAlbumUI, View paramView)
    {
      AppMethodBeat.i(291581);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramStatusAlbumUI);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      kotlin.g.b.s.u(paramStatusAlbumUI, "this$0");
      localObject2 = new Intent();
      paramView = paramStatusAlbumUI.getActivity();
      if (paramView == null) {
        paramView = null;
      }
      for (;;)
      {
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = new Bundle();
        }
        paramView = ((Intent)localObject2).putExtras((Bundle)localObject1);
        kotlin.g.b.s.s(paramView, "Intent().putExtras(activ…intent?.extras?:Bundle())");
        paramView.putExtra("story_only", true);
        com.tencent.mm.br.c.b((Context)paramStatusAlbumUI.getContext(), "", "com.tencent.mm.ui.AlbumUI", paramView);
        paramStatusAlbumUI = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(15L, null, null, 0L, null, 30);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/StatusAlbumUI$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291581);
        return;
        paramView = paramView.getIntent();
        if (paramView == null) {
          paramView = null;
        } else {
          paramView = paramView.getExtras();
        }
      }
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      Object localObject1 = null;
      AppMethodBeat.i(291597);
      kotlin.g.b.s.u(paramd, "reason");
      Log.i("MicroMsg.TextStatus.StatusAlbumUI", "onLoadMoreEnd");
      Object localObject2 = StatusAlbumUI.d(this.TwJ);
      paramd = (RefreshLoadMoreLayout.d<Object>)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("dataLoader");
        paramd = null;
      }
      if (!paramd.ABD)
      {
        localObject2 = StatusAlbumUI.e(this.TwJ);
        paramd = (RefreshLoadMoreLayout.d<Object>)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("mRefreshLayout");
          paramd = null;
        }
        RefreshLoadMoreLayout.e(paramd);
        if (this.BaD.agOc.size() == 0)
        {
          localObject2 = StatusAlbumUI.c(this.TwJ);
          paramd = (RefreshLoadMoreLayout.d<Object>)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("rvSelfHistory");
            paramd = null;
          }
          LayoutInflater localLayoutInflater = af.mU(paramd.getContext());
          int i = a.f.TfO;
          localObject2 = StatusAlbumUI.c(this.TwJ);
          paramd = (RefreshLoadMoreLayout.d<Object>)localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("rvSelfHistory");
            paramd = null;
          }
          paramd = localLayoutInflater.inflate(i, (ViewGroup)paramd, false);
          localObject2 = (i)this.BaD;
          kotlin.g.b.s.s(paramd, "footer");
          i.b((i)localObject2, paramd, 2147483647);
          paramd.findViewById(a.e.Tdu).setOnClickListener(new StatusAlbumUI.f..ExternalSyntheticLambda0(this.TwJ));
        }
        Log.i("MicroMsg.TextStatus.StatusAlbumUI", "hasMoreData true");
      }
      StatusAlbumUI.f(this.TwJ);
      paramd = StatusAlbumUI.c(this.TwJ);
      if (paramd == null)
      {
        kotlin.g.b.s.bIx("rvSelfHistory");
        paramd = localObject1;
      }
      for (;;)
      {
        paramd = paramd.getAdapter();
        if (paramd != null) {
          paramd.bZE.notifyChanged();
        }
        AppMethodBeat.o(291597);
        return;
      }
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(291589);
      d.uiThread((kotlin.g.a.a)new a(this.TwJ));
      AppMethodBeat.o(291589);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(StatusAlbumUI paramStatusAlbumUI)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI
 * JD-Core Version:    0.7.0.1
 */