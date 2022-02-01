package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.protocal.protobuf.dbj;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h.c;
import com.tencent.mm.view.recyclerview.h.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "liveRoomListener", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "readCount", "buildFakeMsgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "random", "hideNewCommentTip", "", "initFakeData", "isLandscape", "", "onDestroy", "onLongClicked", "songId", "", "commentId", "", "text", "isMyPost", "feedId", "nonceId", "(Ljava/lang/String;JLjava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)V", "onMsgUpdated", "lstConvertData", "onPause", "onResume", "prepareViews", "setMaxWidth", "maxWidth", "setViewEventListener", "listener", "showNewCommentTip", "count", "smoothScrollToLastPosition", "Companion", "MusicCommentConvertData", "MusicCommentConverter", "MusicCommentItemData", "plugin-mv_release"})
public final class MusicMvCommentView
  extends RelativeLayout
{
  private static final int Gou;
  public static final a Gov;
  private com.tencent.mm.plugin.mv.ui.uic.a.a Got;
  private HashMap _$_findViewCache;
  private ArrayList<b> mXB;
  private int readCount;
  private WxRecyclerAdapter<b> xnR;
  
  static
  {
    AppMethodBeat.i(241277);
    Gov = new a((byte)0);
    Gou = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(241277);
  }
  
  public MusicMvCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(241276);
    AppMethodBeat.o(241276);
  }
  
  public MusicMvCommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(241275);
    this.mXB = new ArrayList();
    View.inflate(paramContext, b.f.FZu, (ViewGroup)this);
    this.xnR = new WxRecyclerAdapter((f)new g(this), this.mXB, true);
    paramContext = (WxRecyclerView)_$_findCachedViewById(b.e.FXu);
    if (paramContext != null)
    {
      paramAttributeSet = this.xnR;
      if (paramAttributeSet == null) {
        p.bGy("adapter");
      }
      paramContext.setAdapter((RecyclerView.a)paramAttributeSet);
    }
    paramContext = (WxRecyclerView)_$_findCachedViewById(b.e.FXu);
    if (paramContext != null)
    {
      getContext();
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramContext = (WxRecyclerView)_$_findCachedViewById(b.e.FXu);
    if (paramContext != null) {
      paramContext.b((RecyclerView.h)new h());
    }
    paramContext = this.xnR;
    if (paramContext == null) {
      p.bGy("adapter");
    }
    if (paramContext != null) {
      paramContext.YSn = ((h.c)new i(this));
    }
    paramContext = this.xnR;
    if (paramContext == null) {
      p.bGy("adapter");
    }
    if (paramContext != null) {
      paramContext.YSm = ((h.d)new j(this));
    }
    ((WxRecyclerView)_$_findCachedViewById(b.e.FXu)).a((RecyclerView.l)new k(this));
    ((RelativeLayout)_$_findCachedViewById(b.e.FYC)).setOnClickListener((View.OnClickListener)new l(this));
    setTag(this);
    AppMethodBeat.o(241275);
  }
  
  private final void dsP()
  {
    AppMethodBeat.i(241270);
    Object localObject = this.xnR;
    if (localObject == null) {
      p.bGy("adapter");
    }
    if (localObject != null)
    {
      if (((WxRecyclerAdapter)localObject).getItemCount() > 0)
      {
        WxRecyclerView localWxRecyclerView = (WxRecyclerView)_$_findCachedViewById(b.e.FXu);
        localObject = c.a(((WxRecyclerAdapter)localObject).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        localWxRecyclerView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      AppMethodBeat.o(241270);
      return;
    }
    AppMethodBeat.o(241270);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(241284);
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
    AppMethodBeat.o(241284);
    return localView1;
  }
  
  public final void aL(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(241268);
    p.k(paramArrayList, "lstConvertData");
    if (!((Collection)paramArrayList).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject = this.xnR;
        if (localObject == null) {
          p.bGy("adapter");
        }
        if (localObject != null)
        {
          localObject = (List)((WxRecyclerAdapter)localObject).data;
          if (localObject != null) {
            ((List)localObject).clear();
          }
        }
        localObject = this.xnR;
        if (localObject == null) {
          p.bGy("adapter");
        }
        if (localObject != null)
        {
          localObject = (List)((WxRecyclerAdapter)localObject).data;
          if (localObject != null) {
            ((List)localObject).addAll((Collection)paramArrayList);
          }
        }
        paramArrayList = this.xnR;
        if (paramArrayList == null) {
          p.bGy("adapter");
        }
        if (paramArrayList != null) {
          paramArrayList.notifyDataSetChanged();
        }
        dsP();
      }
      AppMethodBeat.o(241268);
      return;
    }
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(241272);
    if (paramInt > 0)
    {
      Object localObject = (FrameLayout)_$_findCachedViewById(b.e.FXt);
      p.j(localObject, "liveCommentArea");
      localObject = ((FrameLayout)localObject).getLayoutParams();
      if (paramInt > 0) {
        ((ViewGroup.LayoutParams)localObject).width = paramInt;
      }
    }
    AppMethodBeat.o(241272);
  }
  
  public final void setViewEventListener(com.tencent.mm.plugin.mv.ui.uic.a.a parama)
  {
    AppMethodBeat.i(241266);
    p.k(parama, "listener");
    this.Got = parama;
    AppMethodBeat.o(241266);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$Companion;", "", "()V", "MENU_ID_COPY", "", "MENU_ID_EXPOSE", "PADDING_EDGE_HEIGHT", "TAG", "", "plugin-mv_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "commentItemData", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;)V", "getCommentItemData", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "getItemId", "", "getItemType", "", "plugin-mv_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvCommentView.d Gow;
    
    public b(MusicMvCommentView.d paramd)
    {
      AppMethodBeat.i(226291);
      this.Gow = paramd;
      AppMethodBeat.o(226291);
    }
    
    public final int bAQ()
    {
      return 2;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(226290);
      long l = this.Gow.hashCode();
      AppMethodBeat.o(226290);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateNickname", "nickname", "", "referInfoTv", "Landroid/widget/TextView;", "plugin-mv_release"})
  public final class c
    extends e<MusicMvCommentView.b>
  {
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
    {
      AppMethodBeat.i(232116);
      p.k(paramRecyclerView, "recyclerView");
      p.k(parami, "holder");
      AppMethodBeat.o(232116);
    }
    
    public final int getLayoutId()
    {
      return b.f.FZt;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(MusicMvCommentView.c paramc, MusicMvCommentView.b paramb) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(227179);
        Object localObject = new b();
        ((b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        long l = this.Goz.Gow.GoA.TIL;
        localObject = this.Goz.Gow.GoA.jDI;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        p.j(paramView, "item.commentItemData.msgPack.nonce_id ?: \"\"");
        localObject = MusicMvCommentView.b(this.Goy.Gox);
        if (localObject != null) {
          ((com.tencent.mm.plugin.mv.ui.uic.a.a)localObject).J(l, paramView);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(227179);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "", "msgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;)V", "getMsgPack", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "setMsgPack", "plugin-mv_release"})
  public static final class d
  {
    dbj GoA;
    
    public d(dbj paramdbj)
    {
      AppMethodBeat.i(231336);
      this.GoA = paramdbj;
      AppMethodBeat.o(231336);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class e
    implements q.f
  {
    e(MusicMvCommentView paramMusicMvCommentView, boolean paramBoolean) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(234733);
      p.j(paramo, "menu");
      if (paramo.hJO())
      {
        paramo.b(1, (CharSequence)this.Gox.getContext().getString(b.h.music_main_mv_chatting_copy), 0);
        if (!this.GoB) {
          paramo.b(2, (CharSequence)this.Gox.getContext().getString(b.h.music_main_mv_expose), 0);
        }
      }
      AppMethodBeat.o(234733);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class f
    implements q.g
  {
    f(MusicMvCommentView paramMusicMvCommentView, String paramString1, Long paramLong, String paramString2, long paramLong1, String paramString3) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(240940);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      do
      {
        AppMethodBeat.o(240940);
        return;
        ClipboardHelper.setText((CharSequence)this.uXe);
        Toast.makeText(this.Gox.getContext(), b.h.app_copy_ok, 0).show();
        paramMenuItem = MusicMvCommentView.b(this.Gox);
        if (paramMenuItem != null)
        {
          paramMenuItem.a(this.GoC, this.wWl, this.AdA);
          AppMethodBeat.o(240940);
          return;
        }
        AppMethodBeat.o(240940);
        return;
        m.L(this.Gox.getContext(), this.xoA, d.Fw(this.AdA));
        paramMenuItem = MusicMvCommentView.b(this.Gox);
      } while (paramMenuItem == null);
      paramMenuItem.b(this.GoC, this.wWl, this.AdA);
      AppMethodBeat.o(240940);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"})
  public static final class g
    implements f
  {
    public final e<?> yx(int paramInt)
    {
      AppMethodBeat.i(231377);
      Log.i("MicroMsg.MusicMvCommentView", "getItemConvert, type:".concat(String.valueOf(paramInt)));
      e locale = (e)new MusicMvCommentView.c(this.Gox);
      AppMethodBeat.o(231377);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$2", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "plugin-mv_release"})
  public static final class h
    extends RecyclerView.h
  {
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(229080);
      p.k(paramRect, "outRect");
      p.k(paramView, "view");
      p.k(paramRecyclerView, "parent");
      p.k(params, "state");
      int j = RecyclerView.bh(paramView);
      paramView = paramRecyclerView.getAdapter();
      if (paramView != null) {}
      for (int i = paramView.getItemCount(); j < i; i = -1)
      {
        paramRect.top = MusicMvCommentView.fhK();
        AppMethodBeat.o(229080);
        return;
      }
      paramRect.top = 0;
      AppMethodBeat.o(229080);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class i
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class j
    implements h.d<com.tencent.mm.view.recyclerview.i>
  {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-mv_release"})
  public static final class k
    extends RecyclerView.l
  {
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(225896);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(225896);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(225891);
      b localb = new b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      paramRecyclerView = (WxRecyclerView)this.Gox._$_findCachedViewById(b.e.FXu);
      p.j(paramRecyclerView, "liveCommentListRV");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(225891);
        throw paramRecyclerView;
      }
      paramInt1 = ((LinearLayoutManager)paramRecyclerView).kL();
      paramRecyclerView = this.Gox;
      MusicMvCommentView.a(paramRecyclerView, kotlin.k.i.ov(paramInt1, MusicMvCommentView.c(paramRecyclerView)));
      if (paramInt1 == MusicMvCommentView.d(this.Gox).getItemCount() - 1) {}
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          MusicMvCommentView.e(this.Gox);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(225891);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(MusicMvCommentView paramMusicMvCommentView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(234294);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      MusicMvCommentView.e(this.Gox);
      if (MusicMvCommentView.f(this.Gox).size() > 0)
      {
        paramView = (WxRecyclerView)this.Gox._$_findCachedViewById(b.e.FXu);
        localObject = c.a(MusicMvCommentView.f(this.Gox).size() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
        paramView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "onClick", "(Landroid/view/View;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(234294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView
 * JD-Core Version:    0.7.0.1
 */