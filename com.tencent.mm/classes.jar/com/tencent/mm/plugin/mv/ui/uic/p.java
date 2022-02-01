package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.gallery.ui.SpeedyLinearLayoutManager;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.f;
import com.tencent.mm.plugin.thumbplayer.d.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "currentSelectIndex", "", "getCurrentSelectIndex", "()I", "setCurrentSelectIndex", "(I)V", "edge_6A", "layoutManager", "Lcom/tencent/mm/plugin/gallery/ui/SpeedyLinearLayoutManager;", "getLayoutManager", "()Lcom/tencent/mm/plugin/gallery/ui/SpeedyLinearLayoutManager;", "layoutManager$delegate", "mediaInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaSEInfo;", "getMediaInfoList", "()Ljava/util/LinkedList;", "setMediaInfoList", "(Ljava/util/LinkedList;)V", "mediaSelectListener", "getMediaSelectListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "setMediaSelectListener", "(Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;)V", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "trackDataList", "Ljava/util/ArrayList;", "getTrackDataList", "()Ljava/util/ArrayList;", "setTrackDataList", "(Ljava/util/ArrayList;)V", "trackRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getTrackRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setTrackRV", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "attachThumb", "", "item", "thumbView", "Landroid/widget/ImageView;", "position", "initBgTrackView", "onVideoProgressUpdate", "timeMs", "", "videoDuration", "select", "index", "selectMedia", "Companion", "TrackDataConvert", "TrackItemConvert", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
  extends UIComponent
  implements v
{
  public static final p.a MgB;
  private static final String TAG;
  public final kotlin.j EKZ;
  public dtf LZM;
  public ArrayList<b> MgC;
  public WxRecyclerView MgD;
  public int MgE;
  private final int MgF;
  public v MgG;
  LinkedList<d> vaX;
  private final kotlin.j xZP;
  
  static
  {
    AppMethodBeat.i(287745);
    MgB = new p.a((byte)0);
    TAG = "MicroMsg.Mv.MusicMvPreviewTrackUIC";
    AppMethodBeat.o(287745);
  }
  
  public p(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(287697);
    this.MgC = new ArrayList();
    this.vaX = new LinkedList();
    this.MgE = -1;
    this.MgF = com.tencent.mm.cd.a.bs((Context)paramAppCompatActivity, b.c.Edge_6A);
    this.xZP = k.cm((kotlin.g.a.a)new d(this));
    this.EKZ = k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    AppMethodBeat.o(287697);
  }
  
  private static final void a(p paramp, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(287706);
    s.u(paramp, "this$0");
    b localb = (b)kotlin.a.p.ae((List)paramp.MgC, paramp.MgE);
    if (localb != null)
    {
      if (localb.MgH != null) {
        paramp.getAdapter().t(paramp.MgE + paramp.getAdapter().agOb.size(), Integer.valueOf(2));
      }
      localb.progress = ((float)paramLong1 / (float)paramLong2);
      paramp.getAdapter().t(paramp.MgE + paramp.getAdapter().agOb.size(), Integer.valueOf(2));
    }
    AppMethodBeat.o(287706);
  }
  
  public final void aV(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(287781);
    h.ahAA.bk(new p..ExternalSyntheticLambda0(this, paramLong1, paramLong2));
    AppMethodBeat.o(287781);
  }
  
  public final void aek(int paramInt)
  {
    AppMethodBeat.i(287763);
    Object localObject = (b)kotlin.a.p.ae((List)this.MgC, this.MgE);
    if (localObject != null)
    {
      ((b)localObject).wwJ = false;
      getAdapter().t(this.MgE + getAdapter().agOb.size(), Integer.valueOf(1));
    }
    localObject = (b)kotlin.a.p.ae((List)this.MgC, paramInt);
    if (localObject != null)
    {
      ((b)localObject).progress = 0.0F;
      ((b)localObject).wwJ = true;
      getAdapter().t(getAdapter().agOb.size() + paramInt, Integer.valueOf(1));
    }
    localObject = this.MgD;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = c.a(getAdapter().agOb.size() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC", "selectMedia", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((WxRecyclerView)localObject).smoothScrollToPosition(((Integer)locala.sb(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC", "selectMedia", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    this.MgE = paramInt;
    AppMethodBeat.o(287763);
  }
  
  public final WxRecyclerAdapter<b> getAdapter()
  {
    AppMethodBeat.i(287769);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.xZP.getValue();
    AppMethodBeat.o(287769);
    return localWxRecyclerAdapter;
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(287774);
    aek(paramInt);
    v localv = this.MgG;
    if (localv != null) {
      localv.select(paramInt);
    }
    AppMethodBeat.o(287774);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "type", "", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;JI)V", "getId", "()J", "isDefault", "", "()Z", "setDefault", "(Z)V", "isLocal", "setLocal", "isSelect", "setSelect", "progress", "", "getProgress", "()F", "setProgress", "(F)V", "trackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "getTrackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "setTrackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;)V", "trackObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTrackObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setTrackObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getType", "()I", "getItemId", "getItemType", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public boq MgH;
    public FinderObject MgI;
    public boolean hJv;
    private final long id;
    public boolean oBZ;
    float progress;
    private final int type;
    public boolean wwJ;
    
    public b()
    {
      AppMethodBeat.i(287987);
      Object localObject;
      this.id = localObject;
      this.type = 0;
      this.progress = 1.0F;
      AppMethodBeat.o(287987);
    }
    
    public final long bZA()
    {
      return this.id;
    }
    
    public final int bZB()
    {
      return this.type;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;", "listener", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;)V", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends f<p.b>
  {
    private final v MgK;
    
    public c()
    {
      AppMethodBeat.i(287981);
      Object localObject;
      this.MgK = localObject;
      AppMethodBeat.o(287981);
    }
    
    private static final void a(c paramc, int paramInt, View paramView)
    {
      AppMethodBeat.i(287986);
      Object localObject = new Object();
      b localb = new b();
      localb.cH(paramc);
      localb.sc(paramInt);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(paramc, "this$0");
      paramc = paramc.MgK;
      if (paramc != null) {
        paramc.select(paramInt);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287986);
    }
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
    {
      AppMethodBeat.i(288003);
      s.u(paramRecyclerView, "recyclerView");
      s.u(paramj, "holder");
      AppMethodBeat.o(288003);
    }
    
    public final int getLayoutId()
    {
      return b.f.LVD;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<WxRecyclerAdapter<p.b>>
  {
    d(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/gallery/ui/SpeedyLinearLayoutManager;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<SpeedyLinearLayoutManager>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.p
 * JD-Core Version:    0.7.0.1
 */