package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ax;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import com.tencent.mm.view.recyclerview.h.b;
import com.tencent.mm.view.recyclerview.h.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "currentPlayingMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "feedIdList", "", "", "getFeedIdList", "()Ljava/util/List;", "setFeedIdList", "(Ljava/util/List;)V", "footerInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "footerView", "Landroid/view/View;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "mvListData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mvListHalfDialog", "Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog;", "mvListRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "titleTv", "Landroid/widget/TextView;", "hide", "", "isShow", "", "onDataSetChanged", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "updateData", "currentMusicMv", "dataList", "", "Companion", "MusicMVItemConvertData", "MusicMVListItemConverter", "plugin-mv_release"})
public final class c
  implements com.tencent.mm.an.i
{
  private static final int GoK;
  public static final c.c GoL;
  private final kotlin.f BiY;
  private WxRecyclerView GoE;
  private final ArrayList<d> GoF;
  public final com.tencent.mm.plugin.music.ui.view.a GoG;
  private List<Long> GoH;
  private com.tencent.mm.plugin.mv.model.f GoI;
  private h.b GoJ;
  final Context context;
  private final View sBm;
  private TextView titleTv;
  private final kotlin.f zQC;
  
  static
  {
    AppMethodBeat.i(228555);
    GoL = new c.c((byte)0);
    GoK = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(228555);
  }
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(228554);
    this.context = paramContext;
    this.GoF = new ArrayList();
    this.GoG = new com.tencent.mm.plugin.music.ui.view.a(this.context);
    this.BiY = g.ar((kotlin.g.a.a)new f(this));
    paramContext = Collections.synchronizedList((List)new ArrayList());
    p.j(paramContext, "Collections.synchronizedList(ArrayList())");
    this.GoH = paramContext;
    this.zQC = g.ar((kotlin.g.a.a)new g(this));
    com.tencent.mm.plugin.music.ui.view.a locala = this.GoG;
    int i = b.f.FZk;
    paramContext = locala.oFW;
    if (paramContext == null) {
      p.iCn();
    }
    paramContext = paramContext.findViewById(a.e.bottom_sheet_custom_layout);
    p.j(paramContext, "rootView!!.findViewById(…ttom_sheet_custom_layout)");
    paramContext = (LinearLayout)paramContext;
    View localView = locala.oFW;
    if (localView == null) {
      p.iCn();
    }
    LayoutInflater.from(localView.getContext()).inflate(i, (ViewGroup)paramContext, true);
    paramContext = locala.oFW;
    if (paramContext != null)
    {
      paramContext = paramContext.getLayoutParams();
      if (paramContext != null) {
        paramContext.height = (ax.au(this.context).y / 2);
      }
    }
    paramContext = locala.oFW;
    if (paramContext != null)
    {
      paramContext = paramContext.findViewById(b.e.close_btn);
      if (paramContext != null) {
        paramContext.setOnClickListener((View.OnClickListener)new a(this));
      }
      paramContext = locala.oFW;
      if (paramContext == null) {
        break label410;
      }
      paramContext = (TextView)paramContext.findViewById(b.e.title_tv);
      label269:
      this.titleTv = paramContext;
      paramContext = locala.oFW;
      if (paramContext == null) {
        break label415;
      }
    }
    label410:
    label415:
    for (paramContext = (WxRecyclerView)paramContext.findViewById(b.e.FYm);; paramContext = null)
    {
      this.GoE = paramContext;
      paramContext = this.GoE;
      if (paramContext != null) {
        paramContext.setLayoutManager((RecyclerView.LayoutManager)this.zQC.getValue());
      }
      paramContext = this.GoE;
      if (paramContext != null) {
        paramContext.setAdapter((RecyclerView.a)getAdapter());
      }
      getAdapter().YSn = ((h.c)new b(this));
      paramContext = LayoutInflater.from(this.context).inflate(b.f.FZm, (ViewGroup)this.GoE, false);
      p.j(paramContext, "LayoutInflater.from(cont…_footer, mvListRV, false)");
      this.sBm = paramContext;
      AppMethodBeat.o(228554);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label269;
    }
  }
  
  private final WxRecyclerAdapter<d> getAdapter()
  {
    AppMethodBeat.i(228529);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.BiY.getValue();
    AppMethodBeat.o(228529);
    return localWxRecyclerAdapter;
  }
  
  public final void a(com.tencent.mm.plugin.mv.model.f paramf, List<com.tencent.mm.plugin.mv.model.f> paramList)
  {
    AppMethodBeat.i(228534);
    p.k(paramf, "currentMusicMv");
    p.k(paramList, "dataList");
    this.GoF.clear();
    this.GoI = paramf;
    paramf = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramf.hasNext())
    {
      paramList = paramf.next();
      if (i < 0) {
        j.iBO();
      }
      paramList = (com.tencent.mm.plugin.mv.model.f)paramList;
      f.a locala = com.tencent.mm.plugin.mv.model.f.GbD;
      if (f.a.c(paramList)) {
        this.GoF.add(new d(i, paramList));
      }
      i += 1;
    }
    if (this.GoF.isEmpty()) {
      this.GoJ = h.b(getAdapter(), this.sBm, -2);
    }
    for (;;)
    {
      paramf = this.titleTv;
      if (paramf != null) {
        paramf.setText((CharSequence)this.context.getString(b.h.FZZ, new Object[] { Integer.valueOf(this.GoF.size()) }));
      }
      getAdapter().notifyDataSetChanged();
      AppMethodBeat.o(228534);
      return;
      paramf = this.GoJ;
      if (paramf != null) {
        getAdapter().U(paramf.mf(), false);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(228537);
    Log.i("Music.Mv.MusicMvListDialog", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scene:" + paramq);
    AppMethodBeat.o(228537);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(238544);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      c.c(this.GoM).bYF();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(238544);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$1$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class b
    implements h.c<com.tencent.mm.view.recyclerview.i>
  {
    b(c paramc) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(JLcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getId", "()J", "getMusicMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getItemId", "getItemType", "", "plugin-mv_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    final com.tencent.mm.plugin.mv.model.f GgZ;
    private final long id;
    
    public d(long paramLong, com.tencent.mm.plugin.mv.model.f paramf)
    {
      AppMethodBeat.i(227216);
      this.id = paramLong;
      this.GgZ = paramf;
      AppMethodBeat.o(227216);
    }
    
    public final int bAQ()
    {
      return 5;
    }
    
    public final long mf()
    {
      return this.id;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVListItemConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateLikeStatus", "likeIt", "likeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "likeCntTv", "Landroid/widget/TextView;", "likeCnt", "plugin-mv_release"})
  public final class e
    extends e<c.d>
  {
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
    {
      AppMethodBeat.i(229709);
      p.k(paramRecyclerView, "recyclerView");
      p.k(parami, "holder");
      AppMethodBeat.o(229709);
    }
    
    public final int getLayoutId()
    {
      return b.f.FZl;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WxRecyclerAdapter<c.d>>
  {
    f(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroidx/recyclerview/widget/LinearLayoutManager;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    g(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.c
 * JD-Core Version:    0.7.0.1
 */