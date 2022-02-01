package com.tencent.mm.plugin.textstatus.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.e;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.b.h;
import com.tencent.mm.plugin.textstatus.g.e.c;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.h.b;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "canContinue", "", "getCanContinue", "()Z", "setCanContinue", "(Z)V", "curLongClickPos", "", "getCurLongClickPos", "()I", "setCurLongClickPos", "(I)V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "dataLoader", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "lastLoadContext", "Lcom/tencent/mm/protobuf/ByteString;", "getLastLoadContext", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastLoadContext", "(Lcom/tencent/mm/protobuf/ByteString;)V", "longClickCallback", "Lkotlin/Function3;", "Landroid/view/View;", "", "getLongClickCallback", "()Lkotlin/jvm/functions/Function3;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "rvLikeList", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "scene", "touchloc", "", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "handleDeleteOrClear", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateContextMenu", "menu", "Landroid/view/ContextMenu;", "v", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onDestroy", "onPause", "AllMsgLoader", "Companion", "DataLoader", "HistoryItemLoader", "NotificationMsgLoader", "plugin-textstatus_release"})
public final class TextStatusLikeListActivity
  extends MMActivity
{
  public static final b MNs;
  final kotlin.g.a.q<View, Integer, Long, Boolean> MAw;
  private boolean MKv;
  private WxRecyclerView MNp;
  private c MNq;
  int MNr;
  private ArrayList<com.tencent.mm.view.recyclerview.a> mXB;
  private int scene;
  private final q.g snt;
  private RefreshLoadMoreLayout tCU;
  private final int[] wKq;
  
  static
  {
    AppMethodBeat.i(236199);
    MNs = new b((byte)0);
    AppMethodBeat.o(236199);
  }
  
  public TextStatusLikeListActivity()
  {
    AppMethodBeat.i(236198);
    this.mXB = new ArrayList();
    this.wKq = new int[2];
    this.MNr = -1;
    this.MAw = ((kotlin.g.a.q)new i(this));
    this.snt = ((q.g)new l(this));
    this.MKv = true;
    AppMethodBeat.o(236198);
  }
  
  public final int getLayoutId()
  {
    return b.f.MxQ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(236191);
    super.onCreate(paramBundle);
    this.scene = getIntent().getIntExtra("scene", 0);
    int i;
    final long l;
    label170:
    Object localObject;
    if (this.scene == 0)
    {
      i = b.h.MyU;
      setMMTitle(i);
      setBackBtn((MenuItem.OnMenuItemClickListener)new TextStatusLikeListActivity.j(this));
      paramBundle = findViewById(b.e.rl_layout);
      p.j(paramBundle, "findViewById(R.id.rl_layout)");
      this.tCU = ((RefreshLoadMoreLayout)paramBundle);
      paramBundle = this.tCU;
      if (paramBundle == null) {
        p.bGy("mRefreshLayout");
      }
      paramBundle.setActionCallback((RefreshLoadMoreLayout.a)new k(this));
      paramBundle = findViewById(b.e.recycler_view);
      p.j(paramBundle, "findViewById(R.id.recycler_view)");
      this.MNp = ((WxRecyclerView)paramBundle);
      paramBundle = this.MNp;
      if (paramBundle == null) {
        p.bGy("rvLikeList");
      }
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      if (this.scene != 0) {
        break label289;
      }
      l = 4L;
      paramBundle = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new f(this, l), this.mXB);
      localObject = this.MNp;
      if (localObject == null) {
        p.bGy("rvLikeList");
      }
      ((WxRecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle);
      switch (this.scene)
      {
      default: 
        label248:
        switch (this.scene)
        {
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(236191);
      return;
      i = b.h.MyX;
      break;
      label289:
      l = 3L;
      break label170;
      localObject = getIntent().getStringExtra("status_id");
      p.j(localObject, "statusId");
      RefreshLoadMoreLayout localRefreshLoadMoreLayout = this.tCU;
      if (localRefreshLoadMoreLayout == null) {
        p.bGy("mRefreshLayout");
      }
      this.MNq = ((c)new TextStatusLikeListActivity.d((String)localObject, paramBundle, localRefreshLoadMoreLayout));
      paramBundle = this.MNq;
      if (paramBundle == null) {
        p.bGy("dataLoader");
      }
      paramBundle.eZs();
      break label248;
      localObject = this.tCU;
      if (localObject == null) {
        p.bGy("mRefreshLayout");
      }
      this.MNq = ((c)new e(paramBundle, (RefreshLoadMoreLayout)localObject));
      paramBundle = this.MNq;
      if (paramBundle == null) {
        p.bGy("dataLoader");
      }
      paramBundle.eZs();
      paramBundle = this.tCU;
      if (paramBundle == null) {
        p.bGy("mRefreshLayout");
      }
      paramBundle.setEnableRefresh(false);
      break label248;
      localObject = this.tCU;
      if (localObject == null) {
        p.bGy("mRefreshLayout");
      }
      this.MNq = ((c)new a(paramBundle, (RefreshLoadMoreLayout)localObject));
      paramBundle = this.MNq;
      if (paramBundle == null) {
        p.bGy("dataLoader");
      }
      paramBundle.eZs();
      paramBundle = this.tCU;
      if (paramBundle == null) {
        p.bGy("mRefreshLayout");
      }
      paramBundle.setEnableRefresh(false);
      break label248;
      if (this.mXB.size() > 0) {
        addTextOptionMenu(0, getString(b.h.app_clear), (MenuItem.OnMenuItemClickListener)new g(this));
      }
      paramBundle = this.MNp;
      if (paramBundle == null) {
        p.bGy("rvLikeList");
      }
      paramBundle.setOnTouchListener((View.OnTouchListener)new TextStatusLikeListActivity.h(this));
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(236192);
    if (paramContextMenu != null)
    {
      paramContextMenu.add(0, 0, 0, (CharSequence)getString(b.h.app_delete));
      AppMethodBeat.o(236192);
      return;
    }
    AppMethodBeat.o(236192);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(236196);
    super.onDestroy();
    c localc = this.MNq;
    if (localc == null) {
      p.bGy("dataLoader");
    }
    localc.release();
    AppMethodBeat.o(236196);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(236194);
    super.onPause();
    String str = getIntent().getStringExtra("status_id");
    Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.glz();
    Object localObject2 = (CharSequence)str;
    int i;
    if ((localObject2 == null) || (n.ba((CharSequence)localObject2)))
    {
      i = 1;
      if (i == 0) {
        break label119;
      }
      localObject2 = "update " + c.Alf + " set Read = 1 where Read != 1 ";
      ((c)localObject1).db.execSQL(c.Alf, (String)localObject2);
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      com.tencent.mm.plugin.textstatus.b.f.glB().bew(str);
      AppMethodBeat.o(236194);
      return;
      i = 0;
      break;
      label119:
      localObject2 = "update " + c.Alf + " set Read = 1 where Read != 1 and TextStatusId = '" + str + '\'';
      ((c)localObject1).db.execSQL(c.Alf, (String)localObject2);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$AllMsgLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "cursorLike", "Landroid/database/Cursor;", "cursorRef", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "tmpLike", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "getTmpLike", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "setTmpLike", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;)V", "tmpRef", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "getTmpRef", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "setTmpRef", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;)V", "hasMoreData", "", "loadNextPage", "", "release", "plugin-textstatus_release"})
  static final class a
    extends TextStatusLikeListActivity.c
  {
    private final RefreshLoadMoreLayout MKy;
    private Cursor MNt;
    private Cursor MNu;
    private com.tencent.mm.plugin.textstatus.g.e.b MNv;
    private com.tencent.mm.plugin.textstatus.g.e.d MNw;
    
    public a(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
      AppMethodBeat.i(232892);
      this.MKy = paramRefreshLoadMoreLayout;
      paramWxRecyclerAdapter = com.tencent.mm.plugin.textstatus.b.f.MAm;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.glz();
      paramWxRecyclerAdapter = "select rowid, * from " + c.Alf + " where HashUserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      paramRefreshLoadMoreLayout = paramRefreshLoadMoreLayout.db;
      String str = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(str, "Account.username()");
      paramWxRecyclerAdapter = paramRefreshLoadMoreLayout.rawQuery(paramWxRecyclerAdapter, new String[] { str });
      p.j(paramWxRecyclerAdapter, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.MNt = paramWxRecyclerAdapter;
      paramWxRecyclerAdapter = com.tencent.mm.plugin.textstatus.b.f.MAm;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.glB();
      paramWxRecyclerAdapter = "select rowid, * from " + com.tencent.mm.plugin.textstatus.g.e.e.Alf + " where UserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      paramRefreshLoadMoreLayout = paramRefreshLoadMoreLayout.db;
      str = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(str, "Account.username()");
      paramWxRecyclerAdapter = paramRefreshLoadMoreLayout.rawQuery(paramWxRecyclerAdapter, new String[] { str });
      p.j(paramWxRecyclerAdapter, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.MNu = paramWxRecyclerAdapter;
      AppMethodBeat.o(232892);
    }
    
    public final void eZs()
    {
      AppMethodBeat.i(232884);
      Object localObject1 = this.MNt;
      if (localObject1 == null) {
        p.bGy("cursorLike");
      }
      int i;
      Object localObject2;
      if ((localObject1 != null) && (this.MNu != null))
      {
        i = 0;
        if (i < 10)
        {
          if (this.MNv == null)
          {
            localObject1 = this.MNt;
            if (localObject1 == null) {
              p.bGy("cursorLike");
            }
            if (((Cursor)localObject1).moveToNext())
            {
              localObject1 = new com.tencent.mm.plugin.textstatus.g.e.b();
              localObject2 = this.MNt;
              if (localObject2 == null) {
                p.bGy("cursorLike");
              }
              ((com.tencent.mm.plugin.textstatus.g.e.b)localObject1).convertFrom((Cursor)localObject2);
              this.MNv = ((com.tencent.mm.plugin.textstatus.g.e.b)localObject1);
            }
          }
          if ((this.MNw == null) && (this.MNu.moveToNext()))
          {
            localObject1 = new com.tencent.mm.plugin.textstatus.g.e.d();
            ((com.tencent.mm.plugin.textstatus.g.e.d)localObject1).convertFrom(this.MNu);
            this.MNw = ((com.tencent.mm.plugin.textstatus.g.e.d)localObject1);
          }
          localObject1 = this.MNw;
          localObject2 = this.MNv;
          if ((localObject2 != null) && (localObject1 != null)) {
            if (((com.tencent.mm.plugin.textstatus.g.e.b)localObject2).field_CreateTime > ((com.tencent.mm.plugin.textstatus.g.e.d)localObject1).field_CreateTime)
            {
              this.MNv = null;
              localObject1 = localObject2;
            }
          }
        }
      }
      for (;;)
      {
        label176:
        if (localObject1 != null)
        {
          if ((localObject1 instanceof com.tencent.mm.plugin.textstatus.g.e.b)) {
            ((List)getAdapter().data).add(new com.tencent.mm.plugin.textstatus.g.b.b((com.tencent.mm.plugin.textstatus.g.e.b)localObject1));
          }
          for (;;)
          {
            i += 1;
            break;
            this.MNw = null;
            break label176;
            if ((localObject2 != null) && (localObject1 == null))
            {
              this.MNv = null;
              localObject1 = localObject2;
              break label176;
            }
            if ((localObject2 != null) || (localObject1 == null)) {
              break label321;
            }
            this.MNw = null;
            break label176;
            if (!(localObject1 instanceof com.tencent.mm.plugin.textstatus.g.e.d)) {
              break label300;
            }
            ((List)getAdapter().data).add(new com.tencent.mm.plugin.textstatus.g.b.d((com.tencent.mm.plugin.textstatus.g.e.d)localObject1));
          }
        }
        label300:
        this.MKy.azs(0);
        getAdapter().notifyDataSetChanged();
        AppMethodBeat.o(232884);
        return;
        label321:
        localObject1 = null;
      }
    }
    
    public final boolean gnv()
    {
      AppMethodBeat.i(232886);
      Object localObject = this.MNt;
      if (localObject == null) {
        p.bGy("cursorLike");
      }
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((Cursor)localObject).isAfterLast());
        if (((Boolean)localObject).booleanValue()) {
          break label76;
        }
        i = 1;
        label42:
        if (i == 0) {
          if (this.MNu.isAfterLast()) {
            break label81;
          }
        }
      }
      label76:
      label81:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label86;
        }
        AppMethodBeat.o(232886);
        return true;
        localObject = null;
        break;
        i = 0;
        break label42;
      }
      label86:
      AppMethodBeat.o(232886);
      return false;
    }
    
    public final void release()
    {
      AppMethodBeat.i(232888);
      Cursor localCursor = this.MNt;
      if (localCursor == null) {
        p.bGy("cursorLike");
      }
      if (localCursor != null) {
        localCursor.close();
      }
      localCursor = this.MNu;
      if (localCursor != null)
      {
        localCursor.close();
        AppMethodBeat.o(232888);
        return;
      }
      AppMethodBeat.o(232888);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion;", "", "()V", "KEY_SCENE", "", "KEY_STATUS_ID", "MENU_DEL", "", "SCENE_HISTORY", "SCENE_SELF_ALL_HISTORY", "SCENE_UNREAD", "TAG", "startForHistory", "", "context", "Landroid/content/Context;", "statusId", "startForSelfAllHistory", "startForUnRead", "plugin-textstatus_release"})
  public static final class b
  {
    public static void ix(Context paramContext)
    {
      AppMethodBeat.i(236641);
      p.k(paramContext, "context");
      Object localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
      int i = com.tencent.mm.plugin.textstatus.b.f.glz().cHo();
      localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
      if (i + com.tencent.mm.plugin.textstatus.b.f.glB().cHo() <= 0)
      {
        AppMethodBeat.o(236641);
        return;
      }
      localObject = new Intent(paramContext, TextStatusLikeListActivity.class);
      ((Intent)localObject).putExtra("scene", 1);
      localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForUnRead", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForUnRead", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(236641);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "hasMoreData", "", "loadNextPage", "", "release", "Companion", "plugin-textstatus_release"})
  static abstract class c
  {
    public static final TextStatusLikeListActivity.c.a MNx = new TextStatusLikeListActivity.c.a((byte)0);
    private WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> xnR;
    
    public c(WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter)
    {
      this.xnR = paramWxRecyclerAdapter;
    }
    
    public abstract void eZs();
    
    public final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> getAdapter()
    {
      return this.xnR;
    }
    
    public abstract boolean gnv();
    
    public abstract void release();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$DataLoader;", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "refreahLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "cursorLike", "Landroid/database/Cursor;", "cursorRef", "getRefreahLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "tmpLike", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "getTmpLike", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;", "setTmpLike", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusLike;)V", "tmpRef", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "getTmpRef", "()Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;", "setTmpRef", "(Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusReference;)V", "hasMoreData", "", "loadNextPage", "", "reInit", "release", "plugin-textstatus_release"})
  static final class e
    extends TextStatusLikeListActivity.c
  {
    private final RefreshLoadMoreLayout MKy;
    private Cursor MNt;
    private Cursor MNu;
    private com.tencent.mm.plugin.textstatus.g.e.b MNv;
    private com.tencent.mm.plugin.textstatus.g.e.d MNw;
    
    public e(final WxRecyclerAdapter<com.tencent.mm.view.recyclerview.a> paramWxRecyclerAdapter, RefreshLoadMoreLayout paramRefreshLoadMoreLayout)
    {
      super();
      AppMethodBeat.i(236944);
      this.MKy = paramRefreshLoadMoreLayout;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.MAm;
      Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.glz();
      paramRefreshLoadMoreLayout = "select rowid, * from " + c.Alf + " where Read != 1 and HashUserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      localObject1 = ((c)localObject1).db;
      Object localObject2 = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(localObject2, "Account.username()");
      paramRefreshLoadMoreLayout = ((ISQLiteDatabase)localObject1).rawQuery(paramRefreshLoadMoreLayout, new String[] { localObject2 });
      p.j(paramRefreshLoadMoreLayout, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.MNt = paramRefreshLoadMoreLayout;
      paramRefreshLoadMoreLayout = com.tencent.mm.plugin.textstatus.b.f.MAm;
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.glB();
      paramRefreshLoadMoreLayout = "select rowid, * from " + com.tencent.mm.plugin.textstatus.g.e.e.Alf + " where Read != 1 and UserName != ? and DeleteInMsgList != 1 order by CreateTime DESC ";
      localObject1 = ((com.tencent.mm.plugin.textstatus.g.e.e)localObject1).db;
      localObject2 = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(localObject2, "Account.username()");
      paramRefreshLoadMoreLayout = ((ISQLiteDatabase)localObject1).rawQuery(paramRefreshLoadMoreLayout, new String[] { localObject2 });
      p.j(paramRefreshLoadMoreLayout, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      this.MNu = paramRefreshLoadMoreLayout;
      paramRefreshLoadMoreLayout = ad.kS(paramWxRecyclerAdapter.getRecyclerView().getContext()).inflate(b.f.MxR, (ViewGroup)paramWxRecyclerAdapter.getRecyclerView(), false);
      ((TextView)paramRefreshLoadMoreLayout.findViewById(b.e.Mvc)).setText(b.h.get_old_msg);
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
      localObject2 = com.tencent.mm.plugin.textstatus.b.f.glz();
      localObject1 = "select count(rowid) from " + c.Alf + " where Read = 1 and HashUserName != ? ";
      localObject2 = ((c)localObject2).db;
      String str = com.tencent.mm.plugin.auth.a.a.crN();
      p.j(str, "Account.username()");
      localObject1 = ((ISQLiteDatabase)localObject2).rawQuery((String)localObject1, new String[] { str });
      p.j(localObject1, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
      int i;
      if (localObject1 != null) {
        if (((Cursor)localObject1).moveToFirst())
        {
          i = ((Cursor)localObject1).getInt(0);
          ((Cursor)localObject1).close();
        }
      }
      for (int j = i;; j = 0)
      {
        localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.glB();
        localObject1 = "select count(rowid) from " + com.tencent.mm.plugin.textstatus.g.e.e.Alf + " where Read = 1 and UserName != ? ";
        localObject2 = ((com.tencent.mm.plugin.textstatus.g.e.e)localObject2).db;
        str = com.tencent.mm.plugin.auth.a.a.crN();
        p.j(str, "Account.username()");
        localObject1 = ((ISQLiteDatabase)localObject2).rawQuery((String)localObject1, new String[] { str });
        p.j(localObject1, "db.rawQuery(sql, arrayOf…ing>(Account.username()))");
        i = m;
        if (localObject1 != null)
        {
          i = k;
          if (((Cursor)localObject1).moveToFirst()) {
            i = ((Cursor)localObject1).getInt(0);
          }
          ((Cursor)localObject1).close();
        }
        if (j + i > 0)
        {
          p.j(paramRefreshLoadMoreLayout, "footer");
          paramRefreshLoadMoreLayout.setOnClickListener((View.OnClickListener)new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(232292);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              TextStatusLikeListActivity.e.a(this.MNA);
              com.tencent.mm.view.recyclerview.h.b(paramWxRecyclerAdapter, this.MNB.mf());
              this.MNA.eZs();
              paramAnonymousView = com.tencent.mm.plugin.textstatus.h.a.MGJ;
              com.tencent.mm.plugin.textstatus.h.a.a(11L, null, null, 0L, 14);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$NotificationMsgLoader$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(232292);
            }
          });
        }
        AppMethodBeat.o(236944);
        return;
        i = 0;
        break;
      }
    }
    
    public final void eZs()
    {
      AppMethodBeat.i(236941);
      int i;
      Object localObject;
      com.tencent.mm.plugin.textstatus.g.e.b localb;
      if ((this.MNt != null) && (this.MNu != null))
      {
        i = 0;
        if (i < 10)
        {
          if ((this.MNv == null) && (this.MNt.moveToNext()))
          {
            localObject = new com.tencent.mm.plugin.textstatus.g.e.b();
            ((com.tencent.mm.plugin.textstatus.g.e.b)localObject).convertFrom(this.MNt);
            this.MNv = ((com.tencent.mm.plugin.textstatus.g.e.b)localObject);
          }
          if ((this.MNw == null) && (this.MNu.moveToNext()))
          {
            localObject = new com.tencent.mm.plugin.textstatus.g.e.d();
            ((com.tencent.mm.plugin.textstatus.g.e.d)localObject).convertFrom(this.MNu);
            this.MNw = ((com.tencent.mm.plugin.textstatus.g.e.d)localObject);
          }
          localObject = this.MNw;
          localb = this.MNv;
          if ((localb != null) && (localObject != null)) {
            if (localb.field_CreateTime > ((com.tencent.mm.plugin.textstatus.g.e.d)localObject).field_CreateTime)
            {
              this.MNv = null;
              localObject = localb;
            }
          }
        }
      }
      for (;;)
      {
        label144:
        if (localObject != null)
        {
          if ((localObject instanceof com.tencent.mm.plugin.textstatus.g.e.b)) {
            ((List)getAdapter().data).add(new com.tencent.mm.plugin.textstatus.g.b.b((com.tencent.mm.plugin.textstatus.g.e.b)localObject));
          }
          for (;;)
          {
            i += 1;
            break;
            this.MNw = null;
            break label144;
            if ((localb != null) && (localObject == null))
            {
              this.MNv = null;
              localObject = localb;
              break label144;
            }
            if ((localb != null) || (localObject == null)) {
              break label290;
            }
            this.MNw = null;
            break label144;
            if (!(localObject instanceof com.tencent.mm.plugin.textstatus.g.e.d)) {
              break label268;
            }
            ((List)getAdapter().data).add(new com.tencent.mm.plugin.textstatus.g.b.d((com.tencent.mm.plugin.textstatus.g.e.d)localObject));
          }
        }
        label268:
        this.MKy.azs(0);
        getAdapter().notifyDataSetChanged();
        AppMethodBeat.o(236941);
        return;
        label290:
        localObject = null;
      }
    }
    
    public final boolean gnv()
    {
      AppMethodBeat.i(236942);
      Object localObject = this.MNt;
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((Cursor)localObject).isAfterLast());
        if (((Boolean)localObject).booleanValue()) {
          break label69;
        }
        i = 1;
        label34:
        if (i == 0) {
          if (this.MNu.isAfterLast()) {
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
        AppMethodBeat.o(236942);
        return true;
        localObject = null;
        break;
        i = 0;
        break label34;
      }
      label79:
      AppMethodBeat.o(236942);
      return false;
    }
    
    public final void release()
    {
      AppMethodBeat.i(236943);
      Cursor localCursor = this.MNt;
      if (localCursor != null) {
        localCursor.close();
      }
      localCursor = this.MNu;
      if (localCursor != null)
      {
        localCursor.close();
        AppMethodBeat.o(236943);
        return;
      }
      AppMethodBeat.o(236943);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.f
  {
    f(long paramLong) {}
    
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(232604);
      switch (paramInt)
      {
      default: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.textstatus.b.b.e(l, this.MNC.MAw);
        AppMethodBeat.o(232604);
        return locale;
      case 0: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.textstatus.b.b.a();
        AppMethodBeat.o(232604);
        return locale;
      case 1: 
        locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.textstatus.b.b.d();
        AppMethodBeat.o(232604);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new com.tencent.mm.plugin.textstatus.b.b.b(l, this.MNC.MAw);
      AppMethodBeat.o(232604);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class g
    implements MenuItem.OnMenuItemClickListener
  {
    g(TextStatusLikeListActivity paramTextStatusLikeListActivity) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(233772);
      com.tencent.mm.ui.base.h.a((Context)this.MNC.getContext(), this.MNC.getString(b.h.sns_msg_clear_mgslist), "", (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(236955);
          TextStatusLikeListActivity.c(this.MNE.MNC).clear();
          paramAnonymousDialogInterface = TextStatusLikeListActivity.d(this.MNE.MNC).getAdapter();
          if (paramAnonymousDialogInterface != null) {
            paramAnonymousDialogInterface.notifyDataSetChanged();
          }
          this.MNE.MNC.enableOptionMenu(false);
          paramAnonymousDialogInterface = com.tencent.mm.plugin.textstatus.b.f.MAm;
          paramAnonymousDialogInterface = com.tencent.mm.plugin.textstatus.b.f.glz();
          String str = "update " + c.Alf + " set DeleteInMsgList = 1 where DeleteInMsgList != 1";
          paramAnonymousDialogInterface.db.execSQL(c.Alf, str);
          paramAnonymousDialogInterface = com.tencent.mm.plugin.textstatus.b.f.MAm;
          paramAnonymousDialogInterface = com.tencent.mm.plugin.textstatus.b.f.glB();
          str = "update " + com.tencent.mm.plugin.textstatus.g.e.e.Alf + " set DeleteInMsgList = 1 where DeleteInMsgList != 1";
          paramAnonymousDialogInterface.db.execSQL(com.tencent.mm.plugin.textstatus.g.e.e.Alf, str);
          AppMethodBeat.o(236955);
        }
      }, null);
      AppMethodBeat.o(233772);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "position", "", "id", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.q<View, Integer, Long, Boolean>
  {
    i(TextStatusLikeListActivity paramTextStatusLikeListActivity)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-textstatus_release"})
  public static final class k
    extends RefreshLoadMoreLayout.a
  {
    public final void Ie(int paramInt)
    {
      AppMethodBeat.i(234915);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aFi());
      super.Ie(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(234915);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(234914);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      p.k(paramc, "reason");
      if (!TextStatusLikeListActivity.a(this.MNC).gnv()) {
        RefreshLoadMoreLayout.e(TextStatusLikeListActivity.b(this.MNC));
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(234914);
    }
    
    public final void cKQ()
    {
      AppMethodBeat.i(234912);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(234912);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(234916);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramc);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aFi());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$onCreate$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(234916);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(TextStatusLikeListActivity.k paramk)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "item", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements q.g
  {
    l(TextStatusLikeListActivity paramTextStatusLikeListActivity) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(237639);
      p.j(paramMenuItem, "item");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(237639);
        return;
        System.out.println();
        paramMenuItem = TextStatusLikeListActivity.c(this.MNC).get(this.MNC.MNr);
        p.j(paramMenuItem, "dataList[curLongClickPos]");
        paramMenuItem = (com.tencent.mm.view.recyclerview.a)paramMenuItem;
        TextStatusLikeListActivity.c(this.MNC).remove(this.MNC.MNr);
        Object localObject = TextStatusLikeListActivity.d(this.MNC).getAdapter();
        if (localObject != null) {
          ((RecyclerView.a)localObject).cN(this.MNC.MNr);
        }
        if ((paramMenuItem instanceof com.tencent.mm.plugin.textstatus.g.b.b))
        {
          ((com.tencent.mm.plugin.textstatus.g.b.b)paramMenuItem).MDM.field_DeleteInMsgList = 1;
          localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
          com.tencent.mm.plugin.textstatus.b.f.glz().a(((com.tencent.mm.plugin.textstatus.g.b.b)paramMenuItem).MDM, new String[0]);
          AppMethodBeat.o(237639);
          return;
        }
        if ((paramMenuItem instanceof com.tencent.mm.plugin.textstatus.g.b.d))
        {
          ((com.tencent.mm.plugin.textstatus.g.b.d)paramMenuItem).MDO.field_DeleteInMsgList = 1;
          localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
          com.tencent.mm.plugin.textstatus.b.f.glB().b(((com.tencent.mm.plugin.textstatus.g.b.d)paramMenuItem).MDO, new String[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity
 * JD-Core Version:    0.7.0.1
 */