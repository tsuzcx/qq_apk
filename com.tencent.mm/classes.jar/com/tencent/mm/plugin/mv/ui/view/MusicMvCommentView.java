package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.protocal.protobuf.dta;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.am;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "liveRoomListener", "Lcom/tencent/mm/plugin/mv/ui/uic/callback/OnChattingViewEventListener;", "readCount", "buildFakeMsgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "random", "commentScrollToEnd", "", "isSmooth", "", "(Ljava/lang/Boolean;)V", "hideNewCommentTip", "ifReachLast", "initFakeData", "isLandscape", "onDestroy", "onLongClicked", "songId", "", "commentId", "", "text", "isMyPost", "feedId", "nonceId", "(Ljava/lang/String;JLjava/lang/String;ZLjava/lang/Long;Ljava/lang/String;)V", "onMsgUpdated", "lstConvertData", "onPause", "onResume", "prepareViews", "setMaxWidth", "maxWidth", "setViewEventListener", "listener", "showNewCommentTip", "count", "smoothScrollToLastPosition", "updateCommentListImpl", "newList", "updateComments", "Companion", "MusicCommentConvertData", "MusicCommentConverter", "MusicCommentItemData", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MusicMvCommentView
  extends RelativeLayout
{
  public static final MusicMvCommentView.a Mim;
  private static final int Mio;
  private WxRecyclerAdapter<b> ALE;
  private com.tencent.mm.plugin.mv.ui.uic.a.a Min;
  private ArrayList<b> pUj;
  private int readCount;
  
  static
  {
    AppMethodBeat.i(287203);
    Mim = new MusicMvCommentView.a((byte)0);
    Mio = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(287203);
  }
  
  public MusicMvCommentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(287078);
    AppMethodBeat.o(287078);
  }
  
  public MusicMvCommentView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(287072);
    this.pUj = new ArrayList();
    View.inflate(paramContext, b.f.LVr, (ViewGroup)this);
    this.ALE = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new e(this), this.pUj, true);
    WxRecyclerView localWxRecyclerView = (WxRecyclerView)findViewById(b.e.LSU);
    if (localWxRecyclerView != null)
    {
      paramAttributeSet = this.ALE;
      paramContext = paramAttributeSet;
      if (paramAttributeSet == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramContext = null;
      }
      localWxRecyclerView.setAdapter((RecyclerView.a)paramContext);
    }
    paramContext = (WxRecyclerView)findViewById(b.e.LSU);
    if (paramContext != null)
    {
      getContext();
      paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    }
    paramContext = (WxRecyclerView)findViewById(b.e.LSU);
    if (paramContext != null) {
      paramContext.a((RecyclerView.h)new MusicMvCommentView.f());
    }
    paramContext = this.ALE;
    if (paramContext == null)
    {
      kotlin.g.b.s.bIx("adapter");
      paramContext = null;
      paramContext.agOe = ((i.c)new g(this));
      paramContext = this.ALE;
      if (paramContext != null) {
        break label302;
      }
      kotlin.g.b.s.bIx("adapter");
      paramContext = localObject;
    }
    label302:
    for (;;)
    {
      paramContext.agOd = ((i.d)new h(this));
      ((WxRecyclerView)findViewById(b.e.LSU)).a((RecyclerView.l)new i(this));
      ((RelativeLayout)findViewById(b.e.LUg)).setOnClickListener(new MusicMvCommentView..ExternalSyntheticLambda0(this));
      setTag(this);
      AppMethodBeat.o(287072);
      return;
      break;
    }
  }
  
  private static final void a(MusicMvCommentView paramMusicMvCommentView, View paramView)
  {
    AppMethodBeat.i(287161);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramMusicMvCommentView);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramMusicMvCommentView, "this$0");
    paramMusicMvCommentView.bjj();
    if (paramMusicMvCommentView.pUj.size() > 0) {
      paramMusicMvCommentView.t(Boolean.TRUE);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287161);
  }
  
  private static final void a(MusicMvCommentView paramMusicMvCommentView, boolean paramBoolean, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(287135);
    kotlin.g.b.s.u(paramMusicMvCommentView, "this$0");
    if (params.jmw())
    {
      params.a(1, (CharSequence)paramMusicMvCommentView.getContext().getString(b.h.music_main_mv_chatting_copy), 0);
      if (!paramBoolean) {
        params.a(2, (CharSequence)paramMusicMvCommentView.getContext().getString(b.h.music_main_mv_expose), 0);
      }
    }
    AppMethodBeat.o(287135);
  }
  
  private static final void a(String paramString1, MusicMvCommentView paramMusicMvCommentView, Long paramLong, String paramString2, long paramLong1, String paramString3, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(287154);
    kotlin.g.b.s.u(paramString1, "$text");
    kotlin.g.b.s.u(paramMusicMvCommentView, "this$0");
    kotlin.g.b.s.u(paramString3, "$songId");
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287154);
      return;
      ClipboardHelper.setText((CharSequence)paramString1);
      Toast.makeText(paramMusicMvCommentView.getContext(), b.h.app_copy_ok, 0).show();
      paramString1 = paramMusicMvCommentView.Min;
      if (paramString1 != null)
      {
        paramString1.a(paramLong, paramString2, paramLong1);
        AppMethodBeat.o(287154);
        return;
        m.M(paramMusicMvCommentView.getContext(), paramString3, d.hF(paramLong1));
        paramString1 = paramMusicMvCommentView.Min;
        if (paramString1 != null) {
          paramString1.b(paramLong, paramString2, paramLong1);
        }
      }
    }
  }
  
  private final void aem(int paramInt)
  {
    AppMethodBeat.i(287093);
    if (paramInt > 0)
    {
      ((RelativeLayout)findViewById(b.e.LUg)).setVisibility(0);
      TextView localTextView = (TextView)findViewById(b.e.LUh);
      Object localObject = am.aixg;
      localObject = getContext().getResources().getString(b.h.music_live_new_comment_tip);
      kotlin.g.b.s.s(localObject, "context.resources.getStr…sic_live_new_comment_tip)");
      localObject = String.format((String)localObject, Arrays.copyOf(new Object[] { Integer.valueOf(paramInt) }, 1));
      kotlin.g.b.s.s(localObject, "java.lang.String.format(format, *args)");
      localTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(287093);
      return;
    }
    bjj();
    AppMethodBeat.o(287093);
  }
  
  private static final void b(MusicMvCommentView paramMusicMvCommentView)
  {
    AppMethodBeat.i(287165);
    kotlin.g.b.s.u(paramMusicMvCommentView, "this$0");
    paramMusicMvCommentView.t(Boolean.TRUE);
    AppMethodBeat.o(287165);
  }
  
  private final void bg(ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(287105);
    boolean bool = epP();
    int i = paramArrayList.size() - this.readCount;
    int j = this.pUj.size();
    bh(paramArrayList);
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    paramArrayList = localWxRecyclerAdapter;
    if (localWxRecyclerAdapter == null)
    {
      kotlin.g.b.s.bIx("adapter");
      paramArrayList = null;
    }
    if (paramArrayList.getItemCount() > 0)
    {
      if ((!bool) && (j != 0)) {
        break label114;
      }
      ((WxRecyclerView)findViewById(b.e.LSU)).post(new MusicMvCommentView..ExternalSyntheticLambda3(this));
    }
    for (;;)
    {
      if ((i <= 0) || (bool)) {
        bjj();
      }
      AppMethodBeat.o(287105);
      return;
      label114:
      if (i > 0) {
        aem(i);
      }
    }
  }
  
  private final void bh(final ArrayList<b> paramArrayList)
  {
    AppMethodBeat.i(287129);
    if (!((WxRecyclerView)findViewById(b.e.LSU)).isShown())
    {
      Log.i("MicroMsg.MusicMvCommentView", "[updateComments] liveCommentListRV is invisible, return");
      AppMethodBeat.o(287129);
      return;
    }
    Log.i("MicroMsg.MusicMvCommentView", "updateComments  before size:" + this.pUj.size() + " afterSize:" + paramArrayList.size());
    g.b localb = androidx.recyclerview.widget.g.a((g.a)new k(this, paramArrayList), false);
    kotlin.g.b.s.s(localb, "private fun updateCommen…       }\n        })\n    }");
    localb.a((q)new j(this, paramArrayList));
    AppMethodBeat.o(287129);
  }
  
  private final void bjj()
  {
    AppMethodBeat.i(287099);
    ((RelativeLayout)findViewById(b.e.LUg)).setVisibility(8);
    AppMethodBeat.o(287099);
  }
  
  private final void ebR()
  {
    AppMethodBeat.i(287089);
    Object localObject = this.ALE;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("adapter");
      localObject = null;
    }
    for (;;)
    {
      if (((WxRecyclerAdapter)localObject).getItemCount() > 0)
      {
        WxRecyclerView localWxRecyclerView = (WxRecyclerView)findViewById(b.e.LSU);
        localObject = c.a(((WxRecyclerAdapter)localObject).getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
        localWxRecyclerView.smoothScrollToPosition(((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "smoothScrollToLastPosition", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      AppMethodBeat.o(287089);
      return;
    }
  }
  
  private final boolean epP()
  {
    Object localObject2 = null;
    AppMethodBeat.i(287120);
    WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
    Object localObject1 = localWxRecyclerAdapter;
    if (localWxRecyclerAdapter == null)
    {
      kotlin.g.b.s.bIx("adapter");
      localObject1 = null;
    }
    if (((WxRecyclerAdapter)localObject1).getItemCount() != 0)
    {
      localObject1 = ((WxRecyclerView)findViewById(b.e.LSU)).getLayoutManager();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(287120);
        throw ((Throwable)localObject1);
      }
      int i = ((LinearLayoutManager)localObject1).Jw();
      localObject1 = this.ALE;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = localObject2;
      }
      while (i == ((WxRecyclerAdapter)localObject1).getItemCount() - 1)
      {
        AppMethodBeat.o(287120);
        return true;
      }
    }
    AppMethodBeat.o(287120);
    return false;
  }
  
  private final void t(Boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(287111);
    WxRecyclerView localWxRecyclerView;
    WxRecyclerAdapter localWxRecyclerAdapter;
    if (kotlin.g.b.s.p(paramBoolean, Boolean.TRUE))
    {
      localWxRecyclerView = (WxRecyclerView)findViewById(b.e.LSU);
      localWxRecyclerAdapter = this.ALE;
      paramBoolean = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramBoolean = null;
      }
      paramBoolean = c.a(k.qu(paramBoolean.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, paramBoolean.aYi(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "commentScrollToEnd", "(Ljava/lang/Boolean;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      localWxRecyclerView.smoothScrollToPosition(((Integer)paramBoolean.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "commentScrollToEnd", "(Ljava/lang/Boolean;)V", "Undefined", "smoothScrollToPosition", "(I)V");
      paramBoolean = this.ALE;
      if (paramBoolean != null) {
        break label294;
      }
      kotlin.g.b.s.bIx("adapter");
      paramBoolean = localObject;
    }
    label294:
    for (;;)
    {
      this.readCount = ((List)paramBoolean.data).size();
      AppMethodBeat.o(287111);
      return;
      localWxRecyclerView = (WxRecyclerView)findViewById(b.e.LSU);
      localWxRecyclerAdapter = this.ALE;
      paramBoolean = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramBoolean = null;
      }
      paramBoolean = c.a(k.qu(paramBoolean.getItemCount() - 1, 0), new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localWxRecyclerView, paramBoolean.aYi(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "commentScrollToEnd", "(Ljava/lang/Boolean;)V", "Undefined", "scrollToPosition", "(I)V");
      localWxRecyclerView.scrollToPosition(((Integer)paramBoolean.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localWxRecyclerView, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView", "commentScrollToEnd", "(Ljava/lang/Boolean;)V", "Undefined", "scrollToPosition", "(I)V");
      break;
    }
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, boolean paramBoolean, Long paramLong1, String paramString3)
  {
    AppMethodBeat.i(287254);
    kotlin.g.b.s.u(paramString1, "songId");
    kotlin.g.b.s.u(paramString2, "text");
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f(getContext(), 1, false);
    localf.Vtg = new MusicMvCommentView..ExternalSyntheticLambda1(this, paramBoolean);
    localf.GAC = new MusicMvCommentView..ExternalSyntheticLambda2(paramString2, this, paramLong1, paramString3, paramLong, paramString1);
    localf.dDn();
    AppMethodBeat.o(287254);
  }
  
  public final void bf(ArrayList<b> paramArrayList)
  {
    Object localObject2 = null;
    AppMethodBeat.i(287235);
    kotlin.g.b.s.u(paramArrayList, "lstConvertData");
    if (paramArrayList.isEmpty())
    {
      WxRecyclerAdapter localWxRecyclerAdapter = this.ALE;
      Object localObject1 = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
      if (localObject1 != null) {
        ((List)localObject1).clear();
      }
      localWxRecyclerAdapter = this.ALE;
      localObject1 = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      localObject1 = (List)((WxRecyclerAdapter)localObject1).data;
      if (localObject1 != null) {
        ((List)localObject1).addAll((Collection)paramArrayList);
      }
      paramArrayList = this.ALE;
      if (paramArrayList == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramArrayList = localObject2;
      }
      for (;;)
      {
        paramArrayList.bZE.notifyChanged();
        ebR();
        this.readCount = 0;
        bjj();
        AppMethodBeat.o(287235);
        return;
      }
    }
    bg(paramArrayList);
    AppMethodBeat.o(287235);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(287241);
    if (paramInt > 0)
    {
      ViewGroup.LayoutParams localLayoutParams = ((FrameLayout)findViewById(b.e.LST)).getLayoutParams();
      if (paramInt > 0) {
        localLayoutParams.width = paramInt;
      }
    }
    AppMethodBeat.o(287241);
  }
  
  public final void setViewEventListener(com.tencent.mm.plugin.mv.ui.uic.a.a parama)
  {
    AppMethodBeat.i(287226);
    kotlin.g.b.s.u(parama, "listener");
    this.Min = parama;
    AppMethodBeat.o(287226);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "commentItemData", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;)V", "getCommentItemData", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "getItemId", "", "getItemType", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    final MusicMvCommentView.d Mip;
    
    public b(MusicMvCommentView.d paramd)
    {
      AppMethodBeat.i(286931);
      this.Mip = paramd;
      AppMethodBeat.o(286931);
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(286933);
      long l = this.Mip.hashCode();
      AppMethodBeat.o(286933);
      return l;
    }
    
    public final int bZB()
    {
      return 2;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateNickname", "nickname", "", "referInfoTv", "Landroid/widget/TextView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends com.tencent.mm.view.recyclerview.f<MusicMvCommentView.b>
  {
    public c()
    {
      AppMethodBeat.i(286935);
      AppMethodBeat.o(286935);
    }
    
    private static final void a(MusicMvCommentView.b paramb, MusicMvCommentView paramMusicMvCommentView, View paramView)
    {
      AppMethodBeat.i(286947);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramb);
      localb.cH(paramMusicMvCommentView);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramb, "$item");
      kotlin.g.b.s.u(paramMusicMvCommentView, "this$0");
      long l = paramb.Mip.Mir.aaYB;
      paramView = paramb.Mip.Mir.mdD;
      paramb = paramView;
      if (paramView == null) {
        paramb = "";
      }
      paramMusicMvCommentView = MusicMvCommentView.c(paramMusicMvCommentView);
      if (paramMusicMvCommentView != null) {
        paramMusicMvCommentView.X(l, paramb);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286947);
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(286962);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramj, "holder");
      AppMethodBeat.o(286962);
    }
    
    public final int getLayoutId()
    {
      return b.f.LVq;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$MusicCommentItemData;", "", "msgPack", "Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "(Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;)V", "getMsgPack", "()Lcom/tencent/mm/protocal/protobuf/MusicLiveMsgPack;", "setMsgPack", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    dta Mir;
    
    public d(dta paramdta)
    {
      AppMethodBeat.i(286948);
      this.Mir = paramdta;
      AppMethodBeat.o(286948);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.view.recyclerview.g
  {
    e(MusicMvCommentView paramMusicMvCommentView) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(286945);
      Log.i("MicroMsg.MusicMvCommentView", kotlin.g.b.s.X("getItemConvert, type:", Integer.valueOf(paramInt)));
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new MusicMvCommentView.c(this.Miq);
      AppMethodBeat.o(286945);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements i.c<j>
  {
    g(MusicMvCommentView paramMusicMvCommentView) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$4", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements i.d<j>
  {
    h(MusicMvCommentView paramMusicMvCommentView) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "", "dy", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    extends RecyclerView.l
  {
    i(MusicMvCommentView paramMusicMvCommentView) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(286930);
      b localb = new b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(286930);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      Object localObject1 = null;
      AppMethodBeat.i(286922);
      Object localObject2 = new b();
      ((b)localObject2).cH(paramRecyclerView);
      ((b)localObject2).sc(paramInt1);
      ((b)localObject2).sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, ((b)localObject2).aYj());
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      paramRecyclerView = ((WxRecyclerView)this.Miq.findViewById(b.e.LSU)).getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(286922);
        throw paramRecyclerView;
      }
      paramInt1 = ((LinearLayoutManager)paramRecyclerView).Jw();
      paramRecyclerView = this.Miq;
      MusicMvCommentView.a(paramRecyclerView, k.qu(paramInt1, MusicMvCommentView.d(paramRecyclerView)));
      localObject2 = MusicMvCommentView.e(this.Miq);
      paramRecyclerView = (RecyclerView)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramRecyclerView = null;
      }
      if (paramInt1 == paramRecyclerView.getItemCount() - 1)
      {
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label229;
        }
        MusicMvCommentView.f(this.Miq);
        localObject2 = this.Miq;
        paramRecyclerView = MusicMvCommentView.e(this.Miq);
        if (paramRecyclerView != null) {
          break label226;
        }
        kotlin.g.b.s.bIx("adapter");
        paramRecyclerView = localObject1;
        label194:
        MusicMvCommentView.a((MusicMvCommentView)localObject2, paramRecyclerView.getItemCount());
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$prepareViews$5", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
        AppMethodBeat.o(286922);
        return;
        paramInt1 = 0;
        break;
        label226:
        break label194;
        label229:
        paramInt1 = MusicMvCommentView.g(this.Miq).size();
        paramInt2 = MusicMvCommentView.d(this.Miq);
        MusicMvCommentView.b(this.Miq, paramInt1 - paramInt2);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$updateComments$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements q
  {
    j(MusicMvCommentView paramMusicMvCommentView, ArrayList<MusicMvCommentView.b> paramArrayList) {}
    
    public final void aR(int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(286968);
      WxRecyclerAdapter localWxRecyclerAdapter = MusicMvCommentView.e(this.Miq);
      Object localObject1 = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      ((List)((WxRecyclerAdapter)localObject1).data).clear();
      localWxRecyclerAdapter = MusicMvCommentView.e(this.Miq);
      localObject1 = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      ((List)((WxRecyclerAdapter)localObject1).data).addAll((Collection)paramArrayList);
      localObject1 = MusicMvCommentView.e(this.Miq);
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((WxRecyclerAdapter)localObject1).bA(paramInt1, paramInt2);
        AppMethodBeat.o(286968);
        return;
      }
    }
    
    public final void aS(int paramInt1, int paramInt2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(286977);
      WxRecyclerAdapter localWxRecyclerAdapter = MusicMvCommentView.e(this.Miq);
      Object localObject1 = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      ((List)((WxRecyclerAdapter)localObject1).data).clear();
      localWxRecyclerAdapter = MusicMvCommentView.e(this.Miq);
      localObject1 = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = null;
      }
      ((List)((WxRecyclerAdapter)localObject1).data).addAll((Collection)paramArrayList);
      localObject1 = MusicMvCommentView.e(this.Miq);
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((WxRecyclerAdapter)localObject1).bB(paramInt1, paramInt2);
        AppMethodBeat.o(286977);
        return;
      }
    }
    
    public final void aW(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286958);
      WxRecyclerAdapter localWxRecyclerAdapter2 = MusicMvCommentView.e(this.Miq);
      WxRecyclerAdapter localWxRecyclerAdapter1 = localWxRecyclerAdapter2;
      if (localWxRecyclerAdapter2 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localWxRecyclerAdapter1 = null;
      }
      localWxRecyclerAdapter1.bz(paramInt1, paramInt2);
      AppMethodBeat.o(286958);
    }
    
    public final void c(int paramInt1, int paramInt2, Object paramObject)
    {
      Object localObject = null;
      AppMethodBeat.i(286950);
      WxRecyclerAdapter localWxRecyclerAdapter = MusicMvCommentView.e(this.Miq);
      paramObject = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramObject = null;
      }
      ((List)paramObject.data).clear();
      localWxRecyclerAdapter = MusicMvCommentView.e(this.Miq);
      paramObject = localWxRecyclerAdapter;
      if (localWxRecyclerAdapter == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramObject = null;
      }
      ((List)paramObject.data).addAll((Collection)paramArrayList);
      paramObject = MusicMvCommentView.e(this.Miq);
      if (paramObject == null)
      {
        kotlin.g.b.s.bIx("adapter");
        paramObject = localObject;
      }
      for (;;)
      {
        paramObject.by(paramInt1, paramInt2);
        AppMethodBeat.o(286950);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvCommentView$updateComments$result$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    extends g.a
  {
    k(MusicMvCommentView paramMusicMvCommentView, ArrayList<MusicMvCommentView.b> paramArrayList) {}
    
    public final int If()
    {
      AppMethodBeat.i(286827);
      WxRecyclerAdapter localWxRecyclerAdapter2 = MusicMvCommentView.e(this.Miq);
      WxRecyclerAdapter localWxRecyclerAdapter1 = localWxRecyclerAdapter2;
      if (localWxRecyclerAdapter2 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localWxRecyclerAdapter1 = null;
      }
      int i = ((List)localWxRecyclerAdapter1.data).size();
      AppMethodBeat.o(286827);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(286831);
      int i = paramArrayList.size();
      AppMethodBeat.o(286831);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286837);
      WxRecyclerAdapter localWxRecyclerAdapter2 = MusicMvCommentView.e(this.Miq);
      WxRecyclerAdapter localWxRecyclerAdapter1 = localWxRecyclerAdapter2;
      if (localWxRecyclerAdapter2 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localWxRecyclerAdapter1 = null;
      }
      boolean bool = kotlin.g.b.s.p(p.ae((List)localWxRecyclerAdapter1.data, paramInt1), p.ae((List)paramArrayList, paramInt2));
      AppMethodBeat.o(286837);
      return bool;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286843);
      WxRecyclerAdapter localWxRecyclerAdapter2 = MusicMvCommentView.e(this.Miq);
      WxRecyclerAdapter localWxRecyclerAdapter1 = localWxRecyclerAdapter2;
      if (localWxRecyclerAdapter2 == null)
      {
        kotlin.g.b.s.bIx("adapter");
        localWxRecyclerAdapter1 = null;
      }
      boolean bool = kotlin.g.b.s.p(p.ae((List)localWxRecyclerAdapter1.data, paramInt1), p.ae((List)paramArrayList, paramInt2));
      AppMethodBeat.o(286843);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.MusicMvCommentView
 * JD-Core Version:    0.7.0.1
 */