package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Point;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g.b;
import com.tencent.mm.view.recyclerview.g.c;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "currentPlayingMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "feedIdList", "", "", "getFeedIdList", "()Ljava/util/List;", "setFeedIdList", "(Ljava/util/List;)V", "footerInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "footerView", "Landroid/view/View;", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "mvListData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mvListHalfDialog", "Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog;", "mvListRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "titleTv", "Landroid/widget/TextView;", "hide", "", "isShow", "", "onDataSetChanged", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "updateData", "currentMusicMv", "dataList", "", "Companion", "MusicMVItemConvertData", "MusicMVListItemConverter", "plugin-mv_release"})
public final class e
  implements i
{
  private static final int AxZ;
  public static final c Aya;
  private final kotlin.f AtV;
  private WxRecyclerView AxT;
  private final ArrayList<d> AxU;
  public final com.tencent.mm.plugin.music.ui.view.a AxV;
  private List<Long> AxW;
  private com.tencent.mm.plugin.mv.a.e AxX;
  private g.b AxY;
  final Context context;
  private final View psf;
  private TextView titleTv;
  private final kotlin.f vat;
  
  static
  {
    AppMethodBeat.i(257545);
    Aya = new c((byte)0);
    AxZ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(257545);
  }
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(257544);
    this.context = paramContext;
    this.AxU = new ArrayList();
    this.AxV = new com.tencent.mm.plugin.music.ui.view.a(this.context);
    this.AtV = kotlin.g.ah((kotlin.g.a.a)new f(this));
    paramContext = Collections.synchronizedList((List)new ArrayList());
    p.g(paramContext, "Collections.synchronizedList(ArrayList())");
    this.AxW = paramContext;
    this.vat = kotlin.g.ah((kotlin.g.a.a)new g(this));
    com.tencent.mm.plugin.music.ui.view.a locala = this.AxV;
    paramContext = locala.lJI;
    if (paramContext == null) {
      p.hyc();
    }
    paramContext = paramContext.findViewById(2131297695);
    p.g(paramContext, "rootView!!.findViewById(…ttom_sheet_custom_layout)");
    paramContext = (LinearLayout)paramContext;
    View localView = locala.lJI;
    if (localView == null) {
      p.hyc();
    }
    LayoutInflater.from(localView.getContext()).inflate(2131495769, (ViewGroup)paramContext, true);
    paramContext = locala.lJI;
    if (paramContext != null)
    {
      paramContext = paramContext.getLayoutParams();
      if (paramContext != null) {
        paramContext.height = (au.az(this.context).y / 2);
      }
    }
    paramContext = locala.lJI;
    if (paramContext != null)
    {
      paramContext = paramContext.findViewById(2131298770);
      if (paramContext != null) {
        paramContext.setOnClickListener((View.OnClickListener)new a(this));
      }
      paramContext = locala.lJI;
      if (paramContext == null) {
        break label401;
      }
      paramContext = (TextView)paramContext.findViewById(2131309249);
      label260:
      this.titleTv = paramContext;
      paramContext = locala.lJI;
      if (paramContext == null) {
        break label406;
      }
    }
    label401:
    label406:
    for (paramContext = (WxRecyclerView)paramContext.findViewById(2131305163);; paramContext = null)
    {
      this.AxT = paramContext;
      paramContext = this.AxT;
      if (paramContext != null) {
        paramContext.setLayoutManager((RecyclerView.LayoutManager)this.vat.getValue());
      }
      paramContext = this.AxT;
      if (paramContext != null) {
        paramContext.setAdapter((RecyclerView.a)getAdapter());
      }
      getAdapter().RqP = ((g.c)new b(this));
      paramContext = LayoutInflater.from(this.context).inflate(2131495775, (ViewGroup)this.AxT, false);
      p.g(paramContext, "LayoutInflater.from(cont…_footer, mvListRV, false)");
      this.psf = paramContext;
      AppMethodBeat.o(257544);
      return;
      paramContext = null;
      break;
      paramContext = null;
      break label260;
    }
  }
  
  private final WxRecyclerAdapter<d> getAdapter()
  {
    AppMethodBeat.i(257540);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.AtV.getValue();
    AppMethodBeat.o(257540);
    return localWxRecyclerAdapter;
  }
  
  public final void a(com.tencent.mm.plugin.mv.a.e parame, List<com.tencent.mm.plugin.mv.a.e> paramList)
  {
    AppMethodBeat.i(257541);
    p.h(parame, "currentMusicMv");
    p.h(paramList, "dataList");
    this.AxU.clear();
    this.AxX = parame;
    parame = ((Iterable)paramList).iterator();
    int i = 0;
    while (parame.hasNext())
    {
      paramList = parame.next();
      if (i < 0) {
        j.hxH();
      }
      paramList = (com.tencent.mm.plugin.mv.a.e)paramList;
      com.tencent.mm.plugin.mv.a.e.a locala = com.tencent.mm.plugin.mv.a.e.ApR;
      if (com.tencent.mm.plugin.mv.a.e.a.b(paramList)) {
        this.AxU.add(new d(i, paramList));
      }
      i += 1;
    }
    if (this.AxU.isEmpty()) {
      this.AxY = com.tencent.mm.view.recyclerview.g.b(getAdapter(), this.psf, -2);
    }
    for (;;)
    {
      parame = this.titleTv;
      if (parame != null) {
        parame.setText((CharSequence)this.context.getString(2131763419, new Object[] { Integer.valueOf(this.AxU.size()) }));
      }
      getAdapter().notifyDataSetChanged();
      AppMethodBeat.o(257541);
      return;
      parame = this.AxY;
      if (parame != null) {
        getAdapter().U(parame.lT(), false);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(257543);
    Log.i("Music.Mv.MusicMvListDialog", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scene:" + paramq);
    AppMethodBeat.o(257543);
  }
  
  public final void show()
  {
    AppMethodBeat.i(257542);
    if (!this.AxV.isShowing()) {
      this.AxV.dGm();
    }
    AppMethodBeat.o(257542);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$1$1"})
  static final class a
    implements View.OnClickListener
  {
    a(e parame) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(257532);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      e.c(this.Ayb).bMo();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(257532);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$1$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"})
  public static final class b
    implements g.c<h>
  {
    b(e parame) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$Companion;", "", "()V", "TAG", "", "dp4", "", "plugin-mv_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(JLcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getId", "()J", "getMusicMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getItemId", "getItemType", "", "plugin-mv_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.a
  {
    final com.tencent.mm.plugin.mv.a.e Ayc;
    private final long id;
    
    public d(long paramLong, com.tencent.mm.plugin.mv.a.e parame)
    {
      AppMethodBeat.i(257534);
      this.id = paramLong;
      this.Ayc = parame;
      AppMethodBeat.o(257534);
    }
    
    public final int cxn()
    {
      return 5;
    }
    
    public final long lT()
    {
      return this.id;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVListItemConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "updateLikeStatus", "likeIt", "likeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "likeCntTv", "Landroid/widget/TextView;", "likeCnt", "plugin-mv_release"})
  public final class e
    extends com.tencent.mm.view.recyclerview.e<e.d>
  {
    public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
    {
      AppMethodBeat.i(257535);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      AppMethodBeat.o(257535);
    }
    
    public final int getLayoutId()
    {
      return 2131495774;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.a<WxRecyclerAdapter<e.d>>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    g(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.e
 * JD-Core Version:    0.7.0.1
 */