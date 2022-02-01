package com.tencent.mm.plugin.textstatus.ui;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.c;
import androidx.recyclerview.widget.RecyclerView.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.h;
import com.tencent.mm.plugin.textstatus.h.f.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentFragment;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ad;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment;", "Lcom/tencent/mm/ui/component/UIComponentFragment;", "Lcom/tencent/mm/sdk/storage/MStorage$IOnStorageChange;", "()V", "canContinue", "", "getCanContinue", "()Z", "setCanContinue", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$DataLoader;", "emptyTip", "Landroid/view/View;", "getEmptyTip", "()Landroid/view/View;", "emptyTip$delegate", "Lkotlin/Lazy;", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "getLastLoadContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastLoadContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "longClickCallback", "Lkotlin/Function3;", "", "", "getLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "longClickPos", "getLongClickPos", "()I", "setLongClickPos", "(I)V", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "rvLikeList", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "scene", "touchloc", "", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkEmpty", "", "getLayoutId", "handleDeleteOrClear", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initData", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDestroy", "onNotifyChange", "event", "", "eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onPause", "onResume", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "AllMsgLoader", "Companion", "DataLoader", "HistoryItemLoader", "NotificationMsgLoader", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusLikeListFragment
  extends UIComponentFragment
  implements MStorage.IOnStorageChange
{
  public static final b Tzq;
  private final int[] AgN;
  final q<View, Integer, Long, Boolean> Tkk;
  private boolean TwG;
  private WxRecyclerView Tzr;
  private TextStatusLikeListFragment.c Tzs;
  private final j Tzt;
  ArrayList<com.tencent.mm.view.recyclerview.a> pUj;
  private int scene;
  int vGT;
  private final u.i vzr;
  private RefreshLoadMoreLayout wGX;
  
  static
  {
    AppMethodBeat.i(291855);
    Tzq = new b((byte)0);
    AppMethodBeat.o(291855);
  }
  
  public TextStatusLikeListFragment()
  {
    AppMethodBeat.i(291795);
    this.pUj = new ArrayList();
    this.AgN = new int[2];
    this.Tzt = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.vGT = -1;
    this.Tkk = ((q)new j(this));
    this.vzr = new TextStatusLikeListFragment..ExternalSyntheticLambda2(this);
    this.TwG = true;
    AppMethodBeat.o(291795);
  }
  
  private static final void a(TextStatusLikeListFragment paramTextStatusLikeListFragment, DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = null;
    AppMethodBeat.i(291822);
    s.u(paramTextStatusLikeListFragment, "this$0");
    com.tencent.mm.plugin.textstatus.i.b localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
    com.tencent.mm.plugin.textstatus.i.b.a(24L, null, null, 0L, b.hJU(), 14);
    paramTextStatusLikeListFragment.pUj.clear();
    paramTextStatusLikeListFragment = paramTextStatusLikeListFragment.Tzr;
    if (paramTextStatusLikeListFragment == null)
    {
      s.bIx("rvLikeList");
      paramTextStatusLikeListFragment = paramDialogInterface;
    }
    for (;;)
    {
      paramTextStatusLikeListFragment = paramTextStatusLikeListFragment.getAdapter();
      if (paramTextStatusLikeListFragment != null) {
        paramTextStatusLikeListFragment.bZE.notifyChanged();
      }
      paramTextStatusLikeListFragment = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      paramTextStatusLikeListFragment = com.tencent.mm.plugin.textstatus.b.f.hGI();
      paramDialogInterface = "update " + com.tencent.mm.plugin.textstatus.h.f.d.ptT + " set DeleteInMsgList = 1 where DeleteInMsgList != 1";
      paramTextStatusLikeListFragment.db.execSQL(com.tencent.mm.plugin.textstatus.h.f.d.ptT, paramDialogInterface);
      paramTextStatusLikeListFragment = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      paramTextStatusLikeListFragment = com.tencent.mm.plugin.textstatus.b.f.hGJ();
      paramDialogInterface = "update " + com.tencent.mm.plugin.textstatus.h.f.f.ptT + " set DeleteInMsgList = 1 where DeleteInMsgList != 1";
      paramTextStatusLikeListFragment.db.execSQL(com.tencent.mm.plugin.textstatus.h.f.f.ptT, paramDialogInterface);
      AppMethodBeat.o(291822);
      return;
    }
  }
  
  private static final void a(TextStatusLikeListFragment paramTextStatusLikeListFragment, MenuItem paramMenuItem, int paramInt)
  {
    Object localObject = null;
    AppMethodBeat.i(291835);
    s.u(paramTextStatusLikeListFragment, "this$0");
    if (paramMenuItem.getItemId() == 0)
    {
      paramMenuItem = com.tencent.mm.plugin.textstatus.i.b.Trt;
      com.tencent.mm.plugin.textstatus.i.b.a(23L, null, null, 0L, b.hJU(), 14);
      paramMenuItem = paramTextStatusLikeListFragment.pUj.get(paramTextStatusLikeListFragment.vGT);
      s.s(paramMenuItem, "dataList[longClickPos]");
      com.tencent.mm.view.recyclerview.a locala = (com.tencent.mm.view.recyclerview.a)paramMenuItem;
      paramTextStatusLikeListFragment.pUj.remove(paramTextStatusLikeListFragment.vGT);
      paramMenuItem = paramTextStatusLikeListFragment.Tzr;
      if (paramMenuItem == null)
      {
        s.bIx("rvLikeList");
        paramMenuItem = localObject;
      }
      for (;;)
      {
        paramMenuItem = paramMenuItem.getAdapter();
        if (paramMenuItem != null) {
          paramMenuItem.fX(paramTextStatusLikeListFragment.vGT);
        }
        if (!(locala instanceof com.tencent.mm.plugin.textstatus.h.d.b)) {
          break;
        }
        ((com.tencent.mm.plugin.textstatus.h.d.b)locala).Tnx.field_DeleteInMsgList = 1;
        paramTextStatusLikeListFragment = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        com.tencent.mm.plugin.textstatus.b.f.hGI().a(((com.tencent.mm.plugin.textstatus.h.d.b)locala).Tnx, new String[0]);
        AppMethodBeat.o(291835);
        return;
      }
      if ((locala instanceof com.tencent.mm.plugin.textstatus.h.d.d))
      {
        ((com.tencent.mm.plugin.textstatus.h.d.d)locala).Tnz.field_DeleteInMsgList = 1;
        paramTextStatusLikeListFragment = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        com.tencent.mm.plugin.textstatus.b.f.hGJ().b(((com.tencent.mm.plugin.textstatus.h.d.d)locala).Tnz, new String[0]);
      }
    }
    AppMethodBeat.o(291835);
  }
  
  private static final boolean a(TextStatusLikeListFragment paramTextStatusLikeListFragment, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(291829);
    s.u(paramTextStatusLikeListFragment, "this$0");
    com.tencent.mm.ui.base.k.a(paramTextStatusLikeListFragment.getContext(), paramTextStatusLikeListFragment.getString(a.h.sns_msg_clear_mgslist), "", new TextStatusLikeListFragment..ExternalSyntheticLambda0(paramTextStatusLikeListFragment), null);
    AppMethodBeat.o(291829);
    return true;
  }
  
  private void aNi()
  {
    Object localObject2 = null;
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = null;
    Object localObject3 = null;
    AppMethodBeat.i(291807);
    this.pUj.clear();
    WxRecyclerAdapter localWxRecyclerAdapter = new WxRecyclerAdapter(hIE(), this.pUj);
    Object localObject1 = this.Tzr;
    if (localObject1 == null)
    {
      s.bIx("rvLikeList");
      localObject1 = null;
    }
    for (;;)
    {
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localWxRecyclerAdapter);
      localWxRecyclerAdapter.a((RecyclerView.c)new i(this));
      switch (this.scene)
      {
      default: 
        AppMethodBeat.o(291807);
        return;
      }
    }
    localObject1 = getArguments();
    if (localObject1 == null)
    {
      localObject1 = "";
      localRefreshLoadMoreLayout = this.wGX;
      localObject2 = localRefreshLoadMoreLayout;
      if (localRefreshLoadMoreLayout == null)
      {
        s.bIx("mRefreshLayout");
        localObject2 = null;
      }
      this.Tzs = ((TextStatusLikeListFragment.c)new TextStatusLikeListFragment.d((String)localObject1, localWxRecyclerAdapter, (RefreshLoadMoreLayout)localObject2));
      localObject1 = this.Tzs;
      if (localObject1 != null) {
        break label225;
      }
      s.bIx("dataLoader");
      localObject1 = localObject3;
    }
    label225:
    for (;;)
    {
      ((TextStatusLikeListFragment.c)localObject1).gir();
      AppMethodBeat.o(291807);
      return;
      localObject1 = ((Bundle)localObject1).getString("status_id");
      if (localObject1 == null)
      {
        localObject1 = "";
        break;
      }
      break;
    }
    localObject3 = this.wGX;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("mRefreshLayout");
      localObject1 = null;
    }
    this.Tzs = ((TextStatusLikeListFragment.c)new e(localWxRecyclerAdapter, (RefreshLoadMoreLayout)localObject1));
    localObject3 = this.Tzs;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("dataLoader");
      localObject1 = null;
    }
    ((TextStatusLikeListFragment.c)localObject1).gir();
    localObject1 = this.wGX;
    if (localObject1 == null)
    {
      s.bIx("mRefreshLayout");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
      AppMethodBeat.o(291807);
      return;
    }
    localObject2 = this.wGX;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("mRefreshLayout");
      localObject1 = null;
    }
    this.Tzs = ((TextStatusLikeListFragment.c)new a(localWxRecyclerAdapter, (RefreshLoadMoreLayout)localObject1));
    localObject2 = this.Tzs;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("dataLoader");
      localObject1 = null;
    }
    ((TextStatusLikeListFragment.c)localObject1).gir();
    localObject1 = this.wGX;
    if (localObject1 == null)
    {
      s.bIx("mRefreshLayout");
      localObject1 = localRefreshLoadMoreLayout;
    }
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
      break;
    }
  }
  
  private final com.tencent.mm.view.recyclerview.g hIE()
  {
    AppMethodBeat.i(291816);
    if (this.scene == 0) {}
    for (long l = 4L;; l = 3L)
    {
      com.tencent.mm.view.recyclerview.g localg = (com.tencent.mm.view.recyclerview.g)new f(l, this);
      AppMethodBeat.o(291816);
      return localg;
    }
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfw;
  }
  
  public final View hJR()
  {
    AppMethodBeat.i(291889);
    Object localObject = this.Tzt.getValue();
    s.s(localObject, "<get-emptyTip>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(291889);
    return localObject;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    return (Set)ad.aivA;
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(291902);
    s.u(paramContextMenu, "menu");
    s.u(paramView, "v");
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
    paramContextMenu.add(0, 0, 0, (CharSequence)getString(a.h.app_delete));
    AppMethodBeat.o(291902);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291908);
    super.onDestroy();
    TextStatusLikeListFragment.c localc2 = this.Tzs;
    TextStatusLikeListFragment.c localc1 = localc2;
    if (localc2 == null)
    {
      s.bIx("dataLoader");
      localc1 = null;
    }
    localc1.release();
    AppMethodBeat.o(291908);
  }
  
  public final void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(291911);
    Log.d("MicroMsg.TextStatus.TextStatusLikeListActivity", "onNotifyChange() called with: event = " + paramString + ", eventData = " + paramMStorageEventData);
    aNi();
    AppMethodBeat.o(291911);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(291906);
    super.onPause();
    Object localObject1 = getArguments();
    Object localObject2;
    Object localObject3;
    int i;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.hGI();
      localObject3 = (CharSequence)localObject1;
      if ((localObject3 != null) && (!n.bp((CharSequence)localObject3))) {
        break label161;
      }
      i = 1;
      label52:
      if (i == 0) {
        break label166;
      }
      localObject3 = "update " + com.tencent.mm.plugin.textstatus.h.f.d.ptT + " set Read = 1 where Read != 1 ";
      ((com.tencent.mm.plugin.textstatus.h.f.d)localObject2).db.execSQL(com.tencent.mm.plugin.textstatus.h.f.d.ptT, (String)localObject3);
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGJ().bdW((String)localObject1);
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      com.tencent.mm.plugin.textstatus.b.f.hGI().remove((MStorage.IOnStorageChange)this);
      com.tencent.mm.plugin.textstatus.b.f.hGJ().remove((MStorage.IOnStorageChange)this);
      AppMethodBeat.o(291906);
      return;
      localObject2 = ((Bundle)localObject1).getString("status_id");
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label161:
      i = 0;
      break label52;
      label166:
      localObject3 = "update " + com.tencent.mm.plugin.textstatus.h.f.d.ptT + " set Read = 1 where Read != 1 and TextStatusId = '" + localObject1 + '\'';
      ((com.tencent.mm.plugin.textstatus.h.f.d)localObject2).db.execSQL(com.tencent.mm.plugin.textstatus.h.f.d.ptT, (String)localObject3);
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(291900);
    super.onResume();
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGI().add((MStorage.IOnStorageChange)this);
    com.tencent.mm.plugin.textstatus.b.f.hGJ().add((MStorage.IOnStorageChange)this);
    AppMethodBeat.o(291900);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(291897);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramBundle = getArguments();
    int i;
    if (paramBundle == null)
    {
      i = 0;
      label33:
      this.scene = i;
      paramBundle = paramView.findViewById(a.e.rl_layout);
      s.s(paramBundle, "view.findViewById(R.id.rl_layout)");
      this.wGX = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.wGX;
      if (paramBundle != null) {
        break label207;
      }
      s.bIx("mRefreshLayout");
      paramBundle = null;
      label78:
      paramBundle.setActionCallback((RefreshLoadMoreLayout.b)new k(this));
      paramView = paramView.findViewById(a.e.recycler_view);
      s.s(paramView, "view.findViewById(R.id.recycler_view)");
      this.Tzr = ((WxRecyclerView)paramView);
      paramView = this.Tzr;
      if (paramView != null) {
        break label210;
      }
      s.bIx("rvLikeList");
      paramView = null;
    }
    label207:
    label210:
    for (;;)
    {
      getContext();
      paramView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      aNi();
      switch (this.scene)
      {
      default: 
        AppMethodBeat.o(291897);
        return;
        i = paramBundle.getInt("scene", 0);
        break label33;
        break label78;
      }
    }
    if (this.pUj.size() > 0)
    {
      paramView = getContext();
      if (!(paramView instanceof MMActivity)) {
        break label299;
      }
      paramView = (MMActivity)paramView;
      label240:
      if (paramView != null) {
        paramView.addTextOptionMenu(0, getString(a.h.app_clear), new TextStatusLikeListFragment..ExternalSyntheticLambda1(this));
      }
    }
    paramView = this.Tzr;
    if (paramView == null)
    {
      s.bIx("rvLikeList");
      paramView = localObject;
    }
    for (;;)
    {
      paramView.a((RecyclerView.k)new TextStatusLikeListFragment.h(this));
      break;
      label299:
      paramView = null;
      break label240;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$AllMsgLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$DataLoader;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "cursorLike", "Landroid/database/Cursor;", "cursorRef", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "tmpLike", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "getTmpLike", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "setTmpLike", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;)V", "tmpRef", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "getTmpRef", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "setTmpRef", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;)V", "hasMoreData", "", "loadNextPage", "", "release", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends TextStatusLikeListFragment.c
  {
    private final RefreshLoadMoreLayout TwH;
    private Cursor Tzu;
    private Cursor Tzv;
    private c Tzw;
    private com.tencent.mm.plugin.textstatus.h.f.e Tzx;
    
    public a(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
      AppMethodBeat.i(291429);
      this.TwH = paramRefreshLoadMoreLayout;
      paramWxRecyclerAdapter = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.hGI();
      paramWxRecyclerAdapter = "select rowid, * from " + com.tencent.mm.plugin.textstatus.h.f.d.ptT + " where HashUserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      paramRefreshLoadMoreLayout = paramRefreshLoadMoreLayout.db;
      String str = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(str, "username()");
      paramWxRecyclerAdapter = paramRefreshLoadMoreLayout.rawQuery(paramWxRecyclerAdapter, new String[] { str });
      s.s(paramWxRecyclerAdapter, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.Tzu = paramWxRecyclerAdapter;
      paramWxRecyclerAdapter = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.hGJ();
      paramWxRecyclerAdapter = "select rowid, * from " + com.tencent.mm.plugin.textstatus.h.f.f.ptT + " where UserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      paramRefreshLoadMoreLayout = paramRefreshLoadMoreLayout.db;
      str = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(str, "username()");
      paramWxRecyclerAdapter = paramRefreshLoadMoreLayout.rawQuery(paramWxRecyclerAdapter, new String[] { str });
      s.s(paramWxRecyclerAdapter, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.Tzv = paramWxRecyclerAdapter;
      AppMethodBeat.o(291429);
    }
    
    public final void gir()
    {
      AppMethodBeat.i(291445);
      if (this.Tzu == null) {
        s.bIx("cursorLike");
      }
      int i;
      Object localObject2;
      Object localObject1;
      if (this.Tzv != null)
      {
        i = 0;
        if (i < 10)
        {
          if (this.Tzw == null)
          {
            localObject2 = this.Tzu;
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              s.bIx("cursorLike");
              localObject1 = null;
            }
            if (((Cursor)localObject1).moveToNext())
            {
              c localc = new c();
              localObject2 = this.Tzu;
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                s.bIx("cursorLike");
                localObject1 = null;
              }
              localc.convertFrom((Cursor)localObject1);
              this.Tzw = localc;
            }
          }
          if ((this.Tzx == null) && (this.Tzv.moveToNext()))
          {
            localObject1 = new com.tencent.mm.plugin.textstatus.h.f.e();
            ((com.tencent.mm.plugin.textstatus.h.f.e)localObject1).convertFrom(this.Tzv);
            this.Tzx = ((com.tencent.mm.plugin.textstatus.h.f.e)localObject1);
          }
          localObject1 = this.Tzx;
          localObject2 = this.Tzw;
          if ((localObject2 != null) && (localObject1 != null)) {
            if (((c)localObject2).field_CreateTime > ((com.tencent.mm.plugin.textstatus.h.f.e)localObject1).field_CreateTime)
            {
              this.Tzw = null;
              localObject1 = localObject2;
            }
          }
        }
      }
      for (;;)
      {
        label181:
        if (localObject1 != null)
        {
          if ((localObject1 instanceof c)) {
            ((List)getAdapter().data).add(new com.tencent.mm.plugin.textstatus.h.d.b((c)localObject1));
          }
          for (;;)
          {
            i += 1;
            break;
            this.Tzx = null;
            break label181;
            if ((localObject2 != null) && (localObject1 == null))
            {
              this.Tzw = null;
              localObject1 = localObject2;
              break label181;
            }
            if ((localObject2 != null) || (localObject1 == null)) {
              break label329;
            }
            this.Tzx = null;
            break label181;
            if (!(localObject1 instanceof com.tencent.mm.plugin.textstatus.h.f.e)) {
              break label305;
            }
            ((List)getAdapter().data).add(new com.tencent.mm.plugin.textstatus.h.d.d((com.tencent.mm.plugin.textstatus.h.f.e)localObject1));
          }
        }
        label305:
        this.TwH.aFW(0);
        getAdapter().bZE.notifyChanged();
        AppMethodBeat.o(291445);
        return;
        label329:
        localObject1 = null;
      }
    }
    
    public final boolean hJS()
    {
      AppMethodBeat.i(291450);
      Cursor localCursor2 = this.Tzu;
      Cursor localCursor1 = localCursor2;
      if (localCursor2 == null)
      {
        s.bIx("cursorLike");
        localCursor1 = null;
      }
      if (!localCursor1.isAfterLast())
      {
        i = 1;
        if (i == 0) {
          if (this.Tzv.isAfterLast()) {
            break label68;
          }
        }
      }
      label68:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label73;
        }
        AppMethodBeat.o(291450);
        return true;
        i = 0;
        break;
      }
      label73:
      AppMethodBeat.o(291450);
      return false;
    }
    
    public final void release()
    {
      AppMethodBeat.i(291455);
      Cursor localCursor2 = this.Tzu;
      Cursor localCursor1 = localCursor2;
      if (localCursor2 == null)
      {
        s.bIx("cursorLike");
        localCursor1 = null;
      }
      localCursor1.close();
      localCursor1 = this.Tzv;
      if (localCursor1 != null) {
        localCursor1.close();
      }
      AppMethodBeat.o(291455);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$Companion;", "", "()V", "KEY_REPORT_ENTER_SCENE", "", "KEY_SCENE", "KEY_STATUS_ID", "MENU_DEL", "", "SCENE_SELF_ALL_HISTORY", "SCENE_SELF_MSG", "SCENE_SINGLE_STATUS_HISTORY", "SCENE_UNREAD", "TAG", "getMyCurInfo", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "getMyCurStatusId", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static com.tencent.mm.plugin.textstatus.h.f.b hJT()
    {
      AppMethodBeat.i(291469);
      Object localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject = com.tencent.mm.plugin.textstatus.b.f.hGH().bdY(com.tencent.mm.plugin.auth.a.a.cUx());
      AppMethodBeat.o(291469);
      return localObject;
    }
    
    public static String hJU()
    {
      AppMethodBeat.i(291481);
      Object localObject = hJT();
      if (localObject == null)
      {
        AppMethodBeat.o(291481);
        return "";
      }
      localObject = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject).field_StatusID;
      if (localObject == null)
      {
        AppMethodBeat.o(291481);
        return "";
      }
      AppMethodBeat.o(291481);
      return localObject;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$NotificationMsgLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$DataLoader;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "cursorLike", "Landroid/database/Cursor;", "cursorRef", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "tmpLike", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "getTmpLike", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "setTmpLike", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;)V", "tmpRef", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "getTmpRef", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "setTmpRef", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;)V", "hasMoreData", "", "loadNextPage", "", "reInit", "release", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class e
    extends TextStatusLikeListFragment.c
  {
    private final RefreshLoadMoreLayout TwH;
    private Cursor Tzu;
    private Cursor Tzv;
    private c Tzw;
    private com.tencent.mm.plugin.textstatus.h.f.e Tzx;
    
    public e(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
      AppMethodBeat.i(291468);
      this.TwH = paramRefreshLoadMoreLayout;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.hGI();
      paramRefreshLoadMoreLayout = "select rowid, * from " + com.tencent.mm.plugin.textstatus.h.f.d.ptT + " where Read != 1 and HashUserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.d)localObject1).db;
      Object localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(localObject2, "username()");
      paramRefreshLoadMoreLayout = ((ISQLiteDatabase)localObject1).rawQuery(paramRefreshLoadMoreLayout, new String[] { localObject2 });
      s.s(paramRefreshLoadMoreLayout, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.Tzu = paramRefreshLoadMoreLayout;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.hGJ();
      paramRefreshLoadMoreLayout = "select rowid, * from " + com.tencent.mm.plugin.textstatus.h.f.f.ptT + " where Read != 1 and UserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.f)localObject1).db;
      localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(localObject2, "username()");
      paramRefreshLoadMoreLayout = ((ISQLiteDatabase)localObject1).rawQuery(paramRefreshLoadMoreLayout, new String[] { localObject2 });
      s.s(paramRefreshLoadMoreLayout, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.Tzv = paramRefreshLoadMoreLayout;
      paramRefreshLoadMoreLayout = af.mU(paramWxRecyclerAdapter.getRecyclerView().getContext()).inflate(a.f.Tfx, (ViewGroup)paramWxRecyclerAdapter.getRecyclerView(), false);
      ((TextView)paramRefreshLoadMoreLayout.findViewById(a.e.Tcp)).setText(a.h.get_old_msg);
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.hGI();
      localObject1 = "select count(rowid) from " + com.tencent.mm.plugin.textstatus.h.f.d.ptT + " where Read = 1 and HashUserName != ? ";
      localObject2 = ((com.tencent.mm.plugin.textstatus.h.f.d)localObject2).db;
      String str = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(str, "username()");
      localObject1 = ((ISQLiteDatabase)localObject2).rawQuery((String)localObject1, new String[] { str });
      s.s(localObject1, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      if (((Cursor)localObject1).moveToFirst()) {}
      for (int i = ((Cursor)localObject1).getInt(0);; i = 0)
      {
        ((Cursor)localObject1).close();
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.hGJ();
        localObject1 = "select count(rowid) from " + com.tencent.mm.plugin.textstatus.h.f.f.ptT + " where Read = 1 and UserName != ? ";
        localObject2 = ((com.tencent.mm.plugin.textstatus.h.f.f)localObject2).db;
        str = com.tencent.mm.plugin.auth.a.a.cUx();
        s.s(str, "username()");
        localObject1 = ((ISQLiteDatabase)localObject2).rawQuery((String)localObject1, new String[] { str });
        s.s(localObject1, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
        if (((Cursor)localObject1).moveToFirst()) {
          j = ((Cursor)localObject1).getInt(0);
        }
        ((Cursor)localObject1).close();
        if (i + j > 0)
        {
          localObject1 = (i)paramWxRecyclerAdapter;
          s.s(paramRefreshLoadMoreLayout, "footer");
          paramRefreshLoadMoreLayout.setOnClickListener(new TextStatusLikeListFragment.e..ExternalSyntheticLambda0(this, paramWxRecyclerAdapter, i.b((i)localObject1, paramRefreshLoadMoreLayout, 2147483647)));
        }
        AppMethodBeat.o(291468);
        return;
      }
    }
    
    private static final void a(e parame, WxRecyclerAdapter paramWxRecyclerAdapter, i.b paramb, View paramView)
    {
      AppMethodBeat.i(291483);
      Object localObject1 = new Object();
      Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parame);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramWxRecyclerAdapter);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramb);
      ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$NotificationMsgLoader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
      s.u(parame, "this$0");
      s.u(paramWxRecyclerAdapter, "$adapter");
      s.u(paramb, "$footerWrapper");
      parame.Tzu.close();
      paramView = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.hGI();
      paramView = "select rowid, * from " + com.tencent.mm.plugin.textstatus.h.f.d.ptT + " where Read = 1 and HashUserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.d)localObject1).db;
      localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(localObject2, "username()");
      paramView = ((ISQLiteDatabase)localObject1).rawQuery(paramView, new String[] { localObject2 });
      s.s(paramView, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      parame.Tzu = paramView;
      parame.Tzv.close();
      paramView = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.hGJ();
      paramView = "select rowid, * from " + com.tencent.mm.plugin.textstatus.h.f.f.ptT + " where Read = 1 and UserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.f)localObject1).db;
      localObject2 = com.tencent.mm.plugin.auth.a.a.cUx();
      s.s(localObject2, "username()");
      paramView = ((ISQLiteDatabase)localObject1).rawQuery(paramView, new String[] { localObject2 });
      s.s(paramView, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      parame.Tzv = paramView;
      parame.Tzw = null;
      parame.Tzx = null;
      i.b((i)paramWxRecyclerAdapter, paramb.bZA());
      parame.gir();
      parame = com.tencent.mm.plugin.textstatus.i.b.Trt;
      parame = TextStatusLikeListFragment.Tzq;
      parame = TextStatusLikeListFragment.b.hJT();
      if (parame == null) {
        parame = "";
      }
      for (;;)
      {
        com.tencent.mm.plugin.textstatus.i.b.a(11L, null, null, 0L, parame, 14);
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$NotificationMsgLoader", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291483);
        return;
        paramWxRecyclerAdapter = parame.field_StatusID;
        parame = paramWxRecyclerAdapter;
        if (paramWxRecyclerAdapter == null) {
          parame = "";
        }
      }
    }
    
    public final void gir()
    {
      AppMethodBeat.i(291506);
      int i;
      Object localObject;
      c localc;
      if ((this.Tzu != null) && (this.Tzv != null))
      {
        i = 0;
        if (i < 10)
        {
          if ((this.Tzw == null) && (this.Tzu.moveToNext()))
          {
            localObject = new c();
            ((c)localObject).convertFrom(this.Tzu);
            this.Tzw = ((c)localObject);
          }
          if ((this.Tzx == null) && (this.Tzv.moveToNext()))
          {
            localObject = new com.tencent.mm.plugin.textstatus.h.f.e();
            ((com.tencent.mm.plugin.textstatus.h.f.e)localObject).convertFrom(this.Tzv);
            this.Tzx = ((com.tencent.mm.plugin.textstatus.h.f.e)localObject);
          }
          localObject = this.Tzx;
          localc = this.Tzw;
          if ((localc != null) && (localObject != null)) {
            if (localc.field_CreateTime > ((com.tencent.mm.plugin.textstatus.h.f.e)localObject).field_CreateTime)
            {
              this.Tzw = null;
              localObject = localc;
            }
          }
        }
      }
      for (;;)
      {
        label144:
        if (localObject != null)
        {
          if ((localObject instanceof c)) {
            ((List)getAdapter().data).add(new com.tencent.mm.plugin.textstatus.h.d.b((c)localObject));
          }
          for (;;)
          {
            i += 1;
            break;
            this.Tzx = null;
            break label144;
            if ((localc != null) && (localObject == null))
            {
              this.Tzw = null;
              localObject = localc;
              break label144;
            }
            if ((localc != null) || (localObject == null)) {
              break label293;
            }
            this.Tzx = null;
            break label144;
            if (!(localObject instanceof com.tencent.mm.plugin.textstatus.h.f.e)) {
              break label268;
            }
            ((List)getAdapter().data).add(new com.tencent.mm.plugin.textstatus.h.d.d((com.tencent.mm.plugin.textstatus.h.f.e)localObject));
          }
        }
        label268:
        this.TwH.aFW(0);
        getAdapter().bZE.notifyChanged();
        AppMethodBeat.o(291506);
        return;
        label293:
        localObject = null;
      }
    }
    
    public final boolean hJS()
    {
      AppMethodBeat.i(291513);
      Object localObject = this.Tzu;
      if (localObject == null)
      {
        localObject = null;
        if (((Boolean)localObject).booleanValue()) {
          break label69;
        }
        i = 1;
        label26:
        if (i == 0) {
          if (this.Tzv.isAfterLast()) {
            break label74;
          }
        }
      }
      label69:
      label74:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label79;
        }
        AppMethodBeat.o(291513);
        return true;
        localObject = Boolean.valueOf(((Cursor)localObject).isAfterLast());
        break;
        i = 0;
        break label26;
      }
      label79:
      AppMethodBeat.o(291513);
      return false;
    }
    
    public final void release()
    {
      AppMethodBeat.i(291520);
      Cursor localCursor = this.Tzu;
      if (localCursor != null) {
        localCursor.close();
      }
      localCursor = this.Tzv;
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(291520);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements com.tencent.mm.view.recyclerview.g
  {
    f(long paramLong, TextStatusLikeListFragment paramTextStatusLikeListFragment) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(291465);
      switch (paramInt)
      {
      default: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.b.e(this.TzA, this.TzB.Tkk);
        AppMethodBeat.o(291465);
        return localf;
      case 0: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.b.a();
        AppMethodBeat.o(291465);
        return localf;
      case 1: 
        localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.b.d();
        AppMethodBeat.o(291465);
        return localf;
      }
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.textstatus.b.b.b(this.TzA, this.TzB.Tkk);
      AppMethodBeat.o(291465);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<TextView>
  {
    g(TextStatusLikeListFragment paramTextStatusLikeListFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$initData$1", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends RecyclerView.c
  {
    i(TextStatusLikeListFragment paramTextStatusLikeListFragment) {}
    
    public final void onChanged()
    {
      AppMethodBeat.i(291409);
      super.onChanged();
      Object localObject = this.TzB;
      if (((TextStatusLikeListFragment)localObject).pUj.isEmpty())
      {
        ((TextStatusLikeListFragment)localObject).hJR().setVisibility(0);
        localObject = ((TextStatusLikeListFragment)localObject).getContext();
        if ((localObject instanceof MMActivity)) {}
        for (localObject = (MMActivity)localObject; localObject != null; localObject = null)
        {
          ((MMActivity)localObject).enableOptionMenu(false);
          AppMethodBeat.o(291409);
          return;
        }
      }
      ((TextStatusLikeListFragment)localObject).hJR().setVisibility(8);
      localObject = ((TextStatusLikeListFragment)localObject).getContext();
      if ((localObject instanceof MMActivity)) {}
      for (localObject = (MMActivity)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((MMActivity)localObject).enableOptionMenu(true);
        }
        AppMethodBeat.o(291409);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "id", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements q<View, Integer, Long, Boolean>
  {
    j(TextStatusLikeListFragment paramTextStatusLikeListFragment)
    {
      super();
    }
    
    private static final void e(TextStatusLikeListFragment paramTextStatusLikeListFragment)
    {
      AppMethodBeat.i(291412);
      s.u(paramTextStatusLikeListFragment, "this$0");
      paramTextStatusLikeListFragment.vGT = -1;
      AppMethodBeat.o(291412);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListFragment$onViewCreated$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends RefreshLoadMoreLayout.b
  {
    k(TextStatusLikeListFragment paramTextStatusLikeListFragment) {}
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      Object localObject = null;
      AppMethodBeat.i(291430);
      s.u(paramd, "reason");
      TextStatusLikeListFragment.c localc = TextStatusLikeListFragment.a(this.TzB);
      paramd = localc;
      if (localc == null)
      {
        s.bIx("dataLoader");
        paramd = null;
      }
      if (!paramd.hJS())
      {
        paramd = TextStatusLikeListFragment.b(this.TzB);
        if (paramd != null) {
          break label70;
        }
        s.bIx("mRefreshLayout");
        paramd = localObject;
      }
      label70:
      for (;;)
      {
        RefreshLoadMoreLayout.e(paramd);
        AppMethodBeat.o(291430);
        return;
      }
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(291418);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.TzB));
      AppMethodBeat.o(291418);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(TextStatusLikeListFragment paramTextStatusLikeListFragment)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListFragment
 * JD-Core Version:    0.7.0.1
 */