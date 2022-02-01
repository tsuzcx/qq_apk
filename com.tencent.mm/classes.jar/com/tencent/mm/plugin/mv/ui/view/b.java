package com.tencent.mm.plugin.mv.ui.view;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.plugin.music.a.e;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.model.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i;
import com.tencent.mm.view.recyclerview.i.b;
import com.tencent.mm.view.recyclerview.i.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "currentPlayingMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "feedIdList", "", "", "getFeedIdList", "()Ljava/util/List;", "setFeedIdList", "(Ljava/util/List;)V", "footerInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "footerView", "Landroid/view/View;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager$delegate", "mvListData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mvListHalfDialog", "Lcom/tencent/mm/plugin/music/ui/view/MusicHalfDialog;", "mvListRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "titleTv", "Landroid/widget/TextView;", "hide", "", "isShow", "", "onDataSetChanged", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "show", "updateData", "currentMusicMv", "dataList", "", "Companion", "MusicMVItemConvertData", "MusicMVListItemConverter", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements h
{
  private static final int MiA;
  public static final b.b Miu;
  private List<Long> Ayl;
  private final kotlin.j EKZ;
  private WxRecyclerView Miv;
  private final ArrayList<c> Miw;
  public final com.tencent.mm.plugin.music.ui.view.a Mix;
  private com.tencent.mm.plugin.mv.model.f Miy;
  private i.b Miz;
  final Context context;
  private TextView titleTv;
  private final View uiE;
  private final kotlin.j xZP;
  
  static
  {
    AppMethodBeat.i(286941);
    Miu = new b.b((byte)0);
    MiA = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 4);
    AppMethodBeat.o(286941);
  }
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(286898);
    this.context = paramContext;
    this.Miw = new ArrayList();
    this.Mix = new com.tencent.mm.plugin.music.ui.view.a(this.context);
    this.xZP = k.cm((kotlin.g.a.a)new e(this));
    paramContext = Collections.synchronizedList((List)new ArrayList());
    s.s(paramContext, "synchronizedList(ArrayList())");
    this.Ayl = paramContext;
    this.EKZ = k.cm((kotlin.g.a.a)new f(this));
    com.tencent.mm.plugin.music.ui.view.a locala = this.Mix;
    int i = com.tencent.mm.plugin.mv.b.f.LVf;
    paramContext = locala.rootView;
    s.checkNotNull(paramContext);
    paramContext = paramContext.findViewById(a.e.bottom_sheet_custom_layout);
    s.s(paramContext, "rootView!!.findViewById(…ttom_sheet_custom_layout)");
    paramContext = (LinearLayout)paramContext;
    View localView = locala.rootView;
    s.checkNotNull(localView);
    LayoutInflater.from(localView.getContext()).inflate(i, (ViewGroup)paramContext, true);
    paramContext = locala.rootView;
    if (paramContext == null)
    {
      paramContext = null;
      if (paramContext != null) {
        paramContext.height = (bf.bf(this.context).y / 2);
      }
      paramContext = locala.rootView;
      if (paramContext != null) {
        break label386;
      }
      paramContext = null;
      label222:
      if (paramContext != null) {
        paramContext.setOnClickListener(new b..ExternalSyntheticLambda0(this));
      }
      paramContext = locala.rootView;
      if (paramContext != null) {
        break label397;
      }
      paramContext = null;
      label250:
      this.titleTv = paramContext;
      paramContext = locala.rootView;
      if (paramContext != null) {
        break label411;
      }
    }
    label386:
    label397:
    label411:
    for (paramContext = localObject;; paramContext = (WxRecyclerView)paramContext.findViewById(com.tencent.mm.plugin.mv.b.e.LTO))
    {
      this.Miv = paramContext;
      paramContext = this.Miv;
      if (paramContext != null) {
        paramContext.setLayoutManager((RecyclerView.LayoutManager)this.EKZ.getValue());
      }
      paramContext = this.Miv;
      if (paramContext != null) {
        paramContext.setAdapter((RecyclerView.a)getAdapter());
      }
      getAdapter().agOe = ((i.c)new a(this));
      paramContext = LayoutInflater.from(this.context).inflate(com.tencent.mm.plugin.mv.b.f.LVi, (ViewGroup)this.Miv, false);
      s.s(paramContext, "from(context).inflate(R.…_footer, mvListRV, false)");
      this.uiE = paramContext;
      AppMethodBeat.o(286898);
      return;
      paramContext = paramContext.getLayoutParams();
      break;
      paramContext = paramContext.findViewById(com.tencent.mm.plugin.mv.b.e.close_btn);
      break label222;
      paramContext = (TextView)paramContext.findViewById(com.tencent.mm.plugin.mv.b.e.title_tv);
      break label250;
    }
  }
  
  private static final void a(b paramb, View paramView)
  {
    AppMethodBeat.i(286915);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "this$0");
    paramb.Mix.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286915);
  }
  
  private final WxRecyclerAdapter<c> getAdapter()
  {
    AppMethodBeat.i(286906);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.xZP.getValue();
    AppMethodBeat.o(286906);
    return localWxRecyclerAdapter;
  }
  
  public final void a(com.tencent.mm.plugin.mv.model.f paramf, List<com.tencent.mm.plugin.mv.model.f> paramList)
  {
    AppMethodBeat.i(286955);
    s.u(paramf, "currentMusicMv");
    s.u(paramList, "dataList");
    this.Miw.clear();
    this.Miy = paramf;
    paramf = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramf.hasNext())
    {
      paramList = paramf.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      paramList = (com.tencent.mm.plugin.mv.model.f)paramList;
      f.a locala = com.tencent.mm.plugin.mv.model.f.LXf;
      if (f.a.c(paramList)) {
        this.Miw.add(new c(i, paramList));
      }
      i += 1;
    }
    if (this.Miw.isEmpty()) {
      this.Miz = i.b((i)getAdapter(), this.uiE, -2);
    }
    for (;;)
    {
      paramf = this.titleTv;
      if (paramf != null) {
        paramf.setText((CharSequence)this.context.getString(b.h.LWf, new Object[] { Integer.valueOf(this.Miw.size()) }));
      }
      getAdapter().bZE.notifyChanged();
      AppMethodBeat.o(286955);
      return;
      paramf = this.Miz;
      if (paramf != null) {
        getAdapter().af(paramf.bZA(), false);
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(286963);
    Log.i("Music.Mv.MusicMvListDialog", "onSceneEnd errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scene:" + paramp);
    AppMethodBeat.o(286963);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$1$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    a(b paramb) {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "(JLcom/tencent/mm/plugin/mv/model/MusicMv;)V", "getId", "()J", "getMusicMv", "()Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getItemId", "getItemType", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    final com.tencent.mm.plugin.mv.model.f Mcj;
    private final long id;
    
    public c(long paramLong, com.tencent.mm.plugin.mv.model.f paramf)
    {
      AppMethodBeat.i(287220);
      this.id = paramLong;
      this.Mcj = paramf;
      AppMethodBeat.o(287220);
    }
    
    public final long bZA()
    {
      return this.id;
    }
    
    public final int bZB()
    {
      return 5;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVListItemConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;", "(Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "updateLikeStatus", "likeIt", "likeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "likeCntTv", "Landroid/widget/TextView;", "likeCnt", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class d
    extends com.tencent.mm.view.recyclerview.f<b.c>
  {
    public d()
    {
      AppMethodBeat.i(287232);
      AppMethodBeat.o(287232);
    }
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
    {
      AppMethodBeat.i(287239);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramj, "holder");
      AppMethodBeat.o(287239);
    }
    
    public final int getLayoutId()
    {
      return com.tencent.mm.plugin.mv.b.f.LVh;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvListDialog$MusicMVItemConvertData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<WxRecyclerAdapter<b.c>>
  {
    e(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/recyclerview/widget/LinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    f(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.view.b
 * JD-Core Version:    0.7.0.1
 */