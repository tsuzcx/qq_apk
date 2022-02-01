package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "currentSelectIndex", "", "getCurrentSelectIndex", "()I", "setCurrentSelectIndex", "(I)V", "edge_6A", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "getLayoutManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "layoutManager$delegate", "mediaInfoList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/thumbplayer/model/TPMediaInfo;", "getMediaInfoList", "()Ljava/util/LinkedList;", "setMediaInfoList", "(Ljava/util/LinkedList;)V", "mediaSelectListener", "getMediaSelectListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "setMediaSelectListener", "(Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;)V", "trackData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getTrackData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setTrackData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "trackDataList", "Ljava/util/ArrayList;", "getTrackDataList", "()Ljava/util/ArrayList;", "setTrackDataList", "(Ljava/util/ArrayList;)V", "trackRV", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getTrackRV", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setTrackRV", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "attachThumb", "", "item", "thumbView", "Landroid/widget/ImageView;", "position", "initBgTrackView", "onVideoProgressUpdate", "timeMs", "", "videoDuration", "select", "index", "selectMedia", "Companion", "TrackDataConvert", "TrackItemConvert", "plugin-mv_release"})
public final class MusicMvPreviewTrackUIC
  extends UIComponent
  implements b
{
  public static final a AvK;
  private static final String TAG = "MicroMsg.Mv.MusicMvPreviewTrackUIC";
  public csp AqY;
  private final kotlin.f AtV;
  ArrayList<b> AvF;
  private WxRecyclerView AvG;
  int AvH;
  private final int AvI;
  public b AvJ;
  LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> oNM;
  private final kotlin.f vat;
  
  static
  {
    AppMethodBeat.i(257343);
    AvK = new a((byte)0);
    TAG = "MicroMsg.Mv.MusicMvPreviewTrackUIC";
    AppMethodBeat.o(257343);
  }
  
  public MusicMvPreviewTrackUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(257342);
    this.AvF = new ArrayList();
    this.oNM = new LinkedList();
    this.AvH = -1;
    this.AvI = com.tencent.mm.cb.a.aH((Context)paramAppCompatActivity, 2131165308);
    this.AtV = kotlin.g.ah((kotlin.g.a.a)new d(this));
    this.vat = kotlin.g.ah((kotlin.g.a.a)new e(paramAppCompatActivity));
    AppMethodBeat.o(257342);
  }
  
  public final void Tr(int paramInt)
  {
    AppMethodBeat.i(257339);
    Object localObject = (b)j.L((List)this.AvF, this.AvH);
    if (localObject != null)
    {
      ((b)localObject).pWp = false;
      getAdapter().b(this.AvH + getAdapter().RqM.size(), Integer.valueOf(1));
    }
    localObject = (b)j.L((List)this.AvF, paramInt);
    if (localObject != null)
    {
      ((b)localObject).progress = 0.0F;
      ((b)localObject).pWp = true;
      getAdapter().b(getAdapter().RqM.size() + paramInt, Integer.valueOf(1));
    }
    localObject = this.AvG;
    if (localObject != null)
    {
      com.tencent.mm.hellhoundlib.b.a locala = c.a(getAdapter().RqM.size() + paramInt, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC", "selectMedia", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
      ((WxRecyclerView)localObject).smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC", "selectMedia", "(I)V", "Undefined", "smoothScrollToPosition", "(I)V");
    }
    this.AvH = paramInt;
    AppMethodBeat.o(257339);
  }
  
  public final void ewi()
  {
    AppMethodBeat.i(257338);
    Object localObject1 = this.AqY;
    if (localObject1 != null)
    {
      localObject1 = ((csp)localObject1).MxE;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObject)localObject1).objectDesc;
        if (localObject1 != null)
        {
          localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
          if (localObject1 != null)
          {
            localObject1 = ((axw)localObject1).LId;
            if (localObject1 != null)
            {
              localObject1 = (Iterable)localObject1;
              int i = 0;
              localObject1 = ((Iterable)localObject1).iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = ((Iterator)localObject1).next();
                int j = i + 1;
                if (i < 0) {
                  j.hxH();
                }
                localObject2 = (axz)localObject2;
                Object localObject3;
                if (((axz)localObject2).refObjectId != 0L)
                {
                  localObject3 = this.AqY;
                  if (localObject3 != null)
                  {
                    localObject3 = ((csp)localObject3).LDi;
                    if (localObject3 != null)
                    {
                      localObject3 = (Iterable)localObject3;
                      i = 0;
                      localObject3 = ((Iterable)localObject3).iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        Object localObject4 = ((Iterator)localObject3).next();
                        if (i < 0) {
                          j.hxH();
                        }
                        localObject4 = (FinderObject)localObject4;
                        if (((FinderObject)localObject4).id == ((axz)localObject2).refObjectId)
                        {
                          b localb = new b(i);
                          localb.AvL = ((axz)localObject2);
                          localb.AvM = ((FinderObject)localObject4);
                          this.AvF.add(localb);
                        }
                        i += 1;
                      }
                      i = j;
                      continue;
                    }
                  }
                  i = j;
                }
                else
                {
                  localObject3 = new b(i);
                  ((b)localObject3).AvL = ((axz)localObject2);
                  ((b)localObject3).dLQ = true;
                  this.AvF.add(localObject3);
                  i = j;
                }
              }
            }
          }
        }
      }
    }
    localObject1 = (b)j.kt((List)this.AvF);
    if (localObject1 != null) {
      ((b)localObject1).pWp = true;
    }
    this.AvH = 0;
    kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new MusicMvPreviewTrackUIC.g(this, null), 2);
    this.AvG = ((WxRecyclerView)getActivity().findViewById(2131298758));
    localObject1 = new View((Context)getActivity());
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(com.tencent.mm.cb.a.fromDPToPix((Context)getActivity(), 24), com.tencent.mm.cb.a.fromDPToPix((Context)getActivity(), 64)));
    com.tencent.mm.view.recyclerview.g.a(getAdapter(), (View)localObject1, -1);
    localObject1 = new View((Context)getActivity());
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new RecyclerView.LayoutParams(com.tencent.mm.cb.a.fromDPToPix((Context)getActivity(), 24), com.tencent.mm.cb.a.fromDPToPix((Context)getActivity(), 64)));
    com.tencent.mm.view.recyclerview.g.b(getAdapter(), (View)localObject1, -2);
    localObject1 = this.AvG;
    if (localObject1 != null) {
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)this.vat.getValue());
    }
    localObject1 = this.AvG;
    if (localObject1 != null)
    {
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)getAdapter());
      AppMethodBeat.o(257338);
      return;
    }
    AppMethodBeat.o(257338);
  }
  
  public final WxRecyclerAdapter<b> getAdapter()
  {
    AppMethodBeat.i(257340);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.AtV.getValue();
    AppMethodBeat.o(257340);
    return localWxRecyclerAdapter;
  }
  
  public final void select(int paramInt)
  {
    AppMethodBeat.i(257341);
    Tr(paramInt);
    b localb = this.AvJ;
    if (localb != null)
    {
      localb.select(paramInt);
      AppMethodBeat.o(257341);
      return;
    }
    AppMethodBeat.o(257341);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$Companion;", "", "()V", "PAYLOAD_PROGRESS", "", "PAYLOAD_SELECTED", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-mv_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "type", "", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;JI)V", "getId", "()J", "isLocal", "", "()Z", "setLocal", "(Z)V", "isSelect", "setSelect", "progress", "", "getProgress", "()F", "setProgress", "(F)V", "trackInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "getTrackInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "setTrackInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;)V", "trackObj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getTrackObj", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setTrackObj", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getType", "()I", "getItemId", "getItemType", "plugin-mv_release"})
  public final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    axz AvL;
    FinderObject AvM;
    boolean dLQ;
    private final long id;
    boolean pWp;
    float progress;
    private final int type;
    
    public b(int paramInt)
    {
      this.id = ???;
      this.type = 0;
      this.progress = 1.0F;
    }
    
    public final int cxn()
    {
      return this.type;
    }
    
    public final long lT()
    {
      return this.id;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;", "listener", "Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "(Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;)V", "getListener", "()Lcom/tencent/mm/plugin/mv/ui/uic/OnMediaSelectListener;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-mv_release"})
  public final class c
    extends e<MusicMvPreviewTrackUIC.b>
  {
    final b AvO;
    
    public c()
    {
      Object localObject;
      this.AvO = localObject;
    }
    
    public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
    {
      AppMethodBeat.i(257332);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      AppMethodBeat.o(257332);
    }
    
    public final int getLayoutId()
    {
      return 2131495791;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(MusicMvPreviewTrackUIC.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(257331);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = this.AvP.AvO;
        if (paramView != null) {
          paramView.select(this.gUj);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackItemConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(257331);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC$TrackDataConvert;", "Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvPreviewTrackUIC;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<WxRecyclerAdapter<MusicMvPreviewTrackUIC.b>>
  {
    d(MusicMvPreviewTrackUIC paramMusicMvPreviewTrackUIC)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Landroid/support/v7/widget/LinearLayoutManager;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<LinearLayoutManager>
  {
    e(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(MusicMvPreviewTrackUIC paramMusicMvPreviewTrackUIC, long paramLong1, long paramLong2) {}
    
    public final void run()
    {
      AppMethodBeat.i(257337);
      MusicMvPreviewTrackUIC.b localb = (MusicMvPreviewTrackUIC.b)j.L((List)this.AvN.AvF, this.AvN.AvH);
      if (localb != null)
      {
        float f = 0.0F;
        axz localaxz = localb.AvL;
        Object localObject;
        int i;
        if (localaxz != null)
        {
          localObject = (CharSequence)localaxz.LIm;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label217;
          }
          i = 1;
          if ((i == 0) && (localaxz.refObjectId != 0L)) {
            break label222;
          }
          localObject = k.euj();
          p.g(localObject, "MusicPlayerManager.Instance()");
          localObject = ((k)localObject).etW();
          p.g(localObject, "MusicPlayerManager.Instance().musicPlayer");
        }
        label217:
        label222:
        for (f = (((d)localObject).etn() - (float)localaxz.Ghu) / localaxz.LIl;; f = (float)this.wfK / (float)this.AvR)
        {
          this.AvN.getAdapter().b(this.AvN.AvH + this.AvN.getAdapter().RqM.size(), Integer.valueOf(2));
          localb.progress = f;
          this.AvN.getAdapter().b(this.AvN.AvH + this.AvN.getAdapter().RqM.size(), Integer.valueOf(2));
          AppMethodBeat.o(257337);
          return;
          i = 0;
          break;
        }
      }
      AppMethodBeat.o(257337);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.uic.MusicMvPreviewTrackUIC
 * JD-Core Version:    0.7.0.1
 */