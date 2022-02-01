package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.textstatus.f.f.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "canContinue", "", "getCanContinue", "()Z", "setCanContinue", "(Z)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "getLastLoadContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastLoadContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rvLikeList", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "scene", "", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "AllMsgLoader", "Companion", "DataLoader", "HistoryItemLoader", "NotificationMsgLoader", "plugin-textstatus_release"})
public final class TextStatusLikeListActivity
  extends MMActivity
{
  public static final b Gfx;
  private boolean Gdl;
  private WxRecyclerView Gfv;
  private c Gfw;
  private ArrayList<com.tencent.mm.view.recyclerview.a> kgc;
  private RefreshLoadMoreLayout qgY;
  private int scene;
  
  static
  {
    AppMethodBeat.i(216648);
    Gfx = new b((byte)0);
    AppMethodBeat.o(216648);
  }
  
  public TextStatusLikeListActivity()
  {
    AppMethodBeat.i(216647);
    this.kgc = new ArrayList();
    this.Gdl = true;
    AppMethodBeat.o(216647);
  }
  
  public final int getLayoutId()
  {
    return 2131496688;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(216644);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("scene", 0);
    int i;
    Object localObject;
    if (this.scene == 0)
    {
      i = 2131766724;
      setMMTitle(i);
      setBackBtn((MenuItem.OnMenuItemClickListener)new g(this));
      paramBundle = findViewById(2131307118);
      p.g(paramBundle, "findViewById(R.id.rl_layout)");
      this.qgY = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.qgY;
      if (paramBundle == null) {
        p.btv("mRefreshLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new h(this));
      paramBundle = findViewById(2131306757);
      p.g(paramBundle, "findViewById(R.id.recycler_view)");
      this.Gfv = ((WxRecyclerView)paramBundle);
      paramBundle = this.Gfv;
      if (paramBundle == null) {
        p.btv("rvLikeList");
      }
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      paramBundle = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new f(), this.kgc);
      localObject = this.Gfv;
      if (localObject == null) {
        p.btv("rvLikeList");
      }
      ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle);
      switch (this.scene)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(216644);
      return;
      i = 2131766728;
      break;
      localObject = getIntent().getStringExtra("status_id");
      p.g(localObject, "statusId");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.qgY;
      if (localRefreshLoadMoreLayout == null) {
        p.btv("mRefreshLayout");
      }
      this.Gfw = ((c)new TextStatusLikeListActivity.d((String)localObject, paramBundle, localRefreshLoadMoreLayout));
      paramBundle = this.Gfw;
      if (paramBundle == null) {
        p.btv("dataLoader");
      }
      paramBundle.epE();
      AppMethodBeat.o(216644);
      return;
      localObject = this.qgY;
      if (localObject == null) {
        p.btv("mRefreshLayout");
      }
      this.Gfw = ((c)new e(paramBundle, (RefreshLoadMoreLayout)localObject));
      paramBundle = this.Gfw;
      if (paramBundle == null) {
        p.btv("dataLoader");
      }
      paramBundle.epE();
      paramBundle = this.qgY;
      if (paramBundle == null) {
        p.btv("mRefreshLayout");
      }
      paramBundle.setEnableRefresh(false);
      AppMethodBeat.o(216644);
      return;
      localObject = this.qgY;
      if (localObject == null) {
        p.btv("mRefreshLayout");
      }
      this.Gfw = ((c)new a(paramBundle, (RefreshLoadMoreLayout)localObject));
      paramBundle = this.Gfw;
      if (paramBundle == null) {
        p.btv("dataLoader");
      }
      paramBundle.epE();
      paramBundle = this.qgY;
      if (paramBundle == null) {
        p.btv("mRefreshLayout");
      }
      paramBundle.setEnableRefresh(false);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(216646);
    super.onDestroy();
    c localc = this.Gfw;
    if (localc == null) {
      p.btv("dataLoader");
    }
    localc.release();
    AppMethodBeat.o(216646);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(216645);
    super.onPause();
    Object localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    localObject = com.tencent.mm.plugin.textstatus.b.f.fvN();
    String str = "update " + c.TABLE + " set Read = 1 where Read != 1 ";
    ((c)localObject).db.execSQL(c.TABLE, str);
    AppMethodBeat.o(216645);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$AllMsgLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "cursor", "Landroid/database/Cursor;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "hasMoreData", "", "loadNextPage", "", "release", "plugin-textstatus_release"})
  static final class a
    extends TextStatusLikeListActivity.c
  {
    private final RefreshLoadMoreLayout Gdo;
    private Cursor dIU;
    
    public a(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
      AppMethodBeat.i(216624);
      this.Gdo = paramRefreshLoadMoreLayout;
      paramWxRecyclerAdapter = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.fvN();
      paramWxRecyclerAdapter = "select rowid, * from " + c.TABLE + " where HashUserName != ? order by CreateTime DESC ";
      paramRefreshLoadMoreLayout = paramRefreshLoadMoreLayout.db;
      String str = com.tencent.mm.plugin.auth.a.a.ceA();
      p.g(str, "Account.username()");
      paramWxRecyclerAdapter = paramRefreshLoadMoreLayout.rawQuery(paramWxRecyclerAdapter, new String[] { str });
      p.g(paramWxRecyclerAdapter, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.dIU = paramWxRecyclerAdapter;
      AppMethodBeat.o(216624);
    }
    
    public final void epE()
    {
      AppMethodBeat.i(216621);
      Object localObject = this.dIU;
      if (localObject == null) {
        p.btv("cursor");
      }
      if (localObject != null)
      {
        int i = 0;
        while (i < 10)
        {
          localObject = this.dIU;
          if (localObject == null) {
            p.btv("cursor");
          }
          if (!((Cursor)localObject).moveToNext()) {
            break;
          }
          localObject = new com.tencent.mm.plugin.textstatus.f.f.b();
          Cursor localCursor = this.dIU;
          if (localCursor == null) {
            p.btv("cursor");
          }
          ((com.tencent.mm.plugin.textstatus.f.f.b)localObject).convertFrom(localCursor);
          ((List)this.tFp.data).add(new com.tencent.mm.plugin.textstatus.f.c.b((com.tencent.mm.plugin.textstatus.f.f.b)localObject));
          i += 1;
        }
      }
      this.Gdo.apT(0);
      this.tFp.notifyDataSetChanged();
      AppMethodBeat.o(216621);
    }
    
    public final boolean fwE()
    {
      AppMethodBeat.i(216622);
      Object localObject = this.dIU;
      if (localObject == null) {
        p.btv("cursor");
      }
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((Cursor)localObject).isAfterLast()); !((Boolean)localObject).booleanValue(); localObject = null)
      {
        AppMethodBeat.o(216622);
        return true;
      }
      AppMethodBeat.o(216622);
      return false;
    }
    
    public final void release()
    {
      AppMethodBeat.i(216623);
      Cursor localCursor = this.dIU;
      if (localCursor == null) {
        p.btv("cursor");
      }
      if (localCursor != null)
      {
        localCursor.close();
        AppMethodBeat.o(216623);
        return;
      }
      AppMethodBeat.o(216623);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion;", "", "()V", "KEY_SCENE", "", "KEY_STATUS_ID", "SCENE_HISTORY", "", "SCENE_SELF_ALL_HISTORY", "SCENE_UNREAD", "TAG", "startForHistory", "", "context", "Landroid/content/Context;", "statusId", "startForSelfAllHistory", "startForUnRead", "plugin-textstatus_release"})
  public static final class b
  {
    public static void hs(Context paramContext)
    {
      AppMethodBeat.i(216626);
      p.h(paramContext, "context");
      Object localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      if (com.tencent.mm.plugin.textstatus.b.f.fvN().ctM() <= 0)
      {
        AppMethodBeat.o(216626);
        return;
      }
      localObject = new Intent(paramContext, TextStatusLikeListActivity.class);
      ((Intent)localObject).putExtra("scene", 1);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForUnRead", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForUnRead", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(216626);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "hasMoreData", "", "loadNextPage", "", "release", "Companion", "plugin-textstatus_release"})
  static abstract class c
  {
    public static final TextStatusLikeListActivity.c.a Gfy = new TextStatusLikeListActivity.c.a((byte)0);
    WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> tFp;
    
    public c(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter)
    {
      this.tFp = paramWxRecyclerAdapter;
    }
    
    public abstract void epE();
    
    public abstract boolean fwE();
    
    public abstract void release();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "cursor", "Landroid/database/Cursor;", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "hasMoreData", "", "loadNextPage", "", "reInit", "release", "plugin-textstatus_release"})
  static final class e
    extends TextStatusLikeListActivity.c
  {
    private final RefreshLoadMoreLayout Gdo;
    private Cursor dIU;
    
    public e(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
      AppMethodBeat.i(216635);
      this.Gdo = paramRefreshLoadMoreLayout;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      Object localObject = com.tencent.mm.plugin.textstatus.b.f.fvN();
      paramRefreshLoadMoreLayout = "select rowid, * from " + c.TABLE + " where Read != 1 and HashUserName != ? order by CreateTime DESC ";
      localObject = ((c)localObject).db;
      String str = com.tencent.mm.plugin.auth.a.a.ceA();
      p.g(str, "Account.username()");
      paramRefreshLoadMoreLayout = ((ISQLiteDatabase)localObject).rawQuery(paramRefreshLoadMoreLayout, new String[] { str });
      p.g(paramRefreshLoadMoreLayout, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.dIU = paramRefreshLoadMoreLayout;
      paramRefreshLoadMoreLayout = aa.jQ(paramWxRecyclerAdapter.getRecyclerView().getContext()).inflate(2131496689, (ViewGroup)paramWxRecyclerAdapter.getRecyclerView(), false);
      ((TextView)paramRefreshLoadMoreLayout.findViewById(2131301667)).setText(2131761446);
      p.g(paramRefreshLoadMoreLayout, "footer");
      paramRefreshLoadMoreLayout.setOnClickListener((View.OnClickListener)new TextStatusLikeListActivity.e.1(this, paramWxRecyclerAdapter, g.b(paramWxRecyclerAdapter, paramRefreshLoadMoreLayout, 2147483647)));
      AppMethodBeat.o(216635);
    }
    
    public final void epE()
    {
      AppMethodBeat.i(216632);
      Object localObject = this.dIU;
      if (localObject == null) {
        p.btv("cursor");
      }
      if (localObject != null)
      {
        int i = 0;
        while (i < 10)
        {
          localObject = this.dIU;
          if (localObject == null) {
            p.btv("cursor");
          }
          if (!((Cursor)localObject).moveToNext()) {
            break;
          }
          localObject = new com.tencent.mm.plugin.textstatus.f.f.b();
          Cursor localCursor = this.dIU;
          if (localCursor == null) {
            p.btv("cursor");
          }
          ((com.tencent.mm.plugin.textstatus.f.f.b)localObject).convertFrom(localCursor);
          ((List)this.tFp.data).add(new com.tencent.mm.plugin.textstatus.f.c.b((com.tencent.mm.plugin.textstatus.f.f.b)localObject));
          i += 1;
        }
      }
      this.Gdo.apT(0);
      this.tFp.notifyDataSetChanged();
      AppMethodBeat.o(216632);
    }
    
    public final boolean fwE()
    {
      AppMethodBeat.i(216633);
      Object localObject = this.dIU;
      if (localObject == null) {
        p.btv("cursor");
      }
      if (localObject != null) {}
      for (localObject = Boolean.valueOf(((Cursor)localObject).isAfterLast()); !((Boolean)localObject).booleanValue(); localObject = null)
      {
        AppMethodBeat.o(216633);
        return true;
      }
      AppMethodBeat.o(216633);
      return false;
    }
    
    public final void release()
    {
      AppMethodBeat.i(216634);
      Cursor localCursor = this.dIU;
      if (localCursor == null) {
        p.btv("cursor");
      }
      if (localCursor != null)
      {
        localCursor.close();
        AppMethodBeat.o(216634);
        return;
      }
      AppMethodBeat.o(216634);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.f
  {
    public final e<?> EC(int paramInt)
    {
      AppMethodBeat.i(216637);
      switch (paramInt)
      {
      default: 
        locale = (e)new com.tencent.mm.plugin.textstatus.b.b.b();
        AppMethodBeat.o(216637);
        return locale;
      }
      e locale = (e)new com.tencent.mm.plugin.textstatus.b.b.a();
      AppMethodBeat.o(216637);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(TextStatusLikeListActivity paramTextStatusLikeListActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(216638);
      this.GfD.onBackPressed();
      AppMethodBeat.o(216638);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-textstatus_release"})
  public static final class h
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(216642);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(216642);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(216641);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      if (!TextStatusLikeListActivity.a(this.GfD).fwE()) {
        RefreshLoadMoreLayout.e(TextStatusLikeListActivity.b(this.GfD));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(216641);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(216640);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      d.h((kotlin.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(216640);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(216643);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(216643);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(TextStatusLikeListActivity.h paramh)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity
 * JD-Core Version:    0.7.0.1
 */