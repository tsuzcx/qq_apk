package com.tencent.mm.plugin.mv.ui.free;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.util.Range;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.ui.c.g.b;
import com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView;
import com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView.a;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.dbo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.g.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.a.ae;
import kotlin.g.a.m;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.by;
import kotlinx.coroutines.ct;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "completeButton", "Landroid/widget/Button;", "rangeSnapshots", "Ljava/util/HashMap;", "", "Landroid/util/Range;", "", "Lkotlin/collections/HashMap;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "selectButtonsContainer", "Landroid/view/ViewGroup;", "songDuration", "thumbLoader", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "trackList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "tracksEditView", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView;", "enterSelectMode", "", "exitSelectMode", "initBgTrackView", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "onDestroy", "onVideoProgressUpdate", "timeMs", "refreshOffsets", "fillingDuration", "updateTrack", "index", "startTime", "endTime", "Companion", "plugin-mv_release"})
@SuppressLint({"StaticFieldLeak"})
public final class a
  extends UIComponent
{
  public static final a.a Ggj;
  MvTracksEditView Ggc;
  ViewGroup Ggd;
  Button Gge;
  LinkedList<bdt> Ggf;
  long Ggg;
  private final HashMap<Integer, Range<Long>> Ggh;
  final com.tencent.mm.plugin.mv.ui.c.g Ggi;
  final ak rcY;
  
  static
  {
    AppMethodBeat.i(226209);
    Ggj = new a.a((byte)0);
    AppMethodBeat.o(226209);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(226208);
    this.rcY = al.b(al.iRe(), (kotlin.d.f)ct.iRW());
    this.Ggh = new HashMap();
    this.Ggi = new com.tencent.mm.plugin.mv.ui.c.g((com.tencent.mm.plugin.vlog.ui.thumb.g)new f(paramAppCompatActivity));
    AppMethodBeat.o(226208);
  }
  
  private final void OL(long paramLong)
  {
    AppMethodBeat.i(226204);
    Object localObject1 = this.Ggf;
    if (localObject1 == null) {
      p.bGy("trackList");
    }
    Object localObject3 = (Iterable)kotlin.k.i.ou(0, ((LinkedList)localObject1).size() - 1);
    localObject1 = this.Ggf;
    if (localObject1 == null) {
      p.bGy("trackList");
    }
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add((bdt)((LinkedList)localObject1).get(((ab)localObject3).zD()));
    }
    localObject1 = ((Iterable)localObject2).iterator();
    for (long l = 0L; ((Iterator)localObject1).hasNext(); l = ((bdt)localObject2).SOR + l)
    {
      localObject2 = (bdt)((Iterator)localObject1).next();
      ((bdt)localObject2).MSE = l;
    }
    localObject1 = this.Ggf;
    if (localObject1 == null) {
      p.bGy("trackList");
    }
    localObject1 = (bdt)((LinkedList)localObject1).getLast();
    ((bdt)localObject1).MSE = l;
    ((bdt)localObject1).SOR = ((int)paramLong);
    AppMethodBeat.o(226204);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(226198);
    super.onDestroy();
    com.tencent.mm.plugin.mv.ui.c.g localg = this.Ggi;
    Log.i("MicroMsg.ThumbCachedLoader", "release");
    Object localObject = localg.GhT.values();
    p.j(localObject, "entries.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      g.b localb = (g.b)((Iterator)localObject).next();
      localb.Gia.I(null);
      com.tencent.mm.videocomposition.c localc = localb.Aub;
      if (localc != null) {
        localc.destroy();
      }
      localb.Aub = null;
    }
    al.a(localg.rcY, null);
    al.a(this.rcY, null);
    AppMethodBeat.o(226198);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(231234);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC$initBgTrackView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = new StringBuilder("user clicked cancel button，revert: ");
      localObject1 = a.a(this.Ggk).keySet();
      p.j(localObject1, "rangeSnapshots.keys");
      localObject1 = ((Collection)localObject1).toArray(new Integer[0]);
      if (localObject1 == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(231234);
        throw paramView;
      }
      localObject1 = Arrays.toString((Object[])localObject1);
      p.j(localObject1, "java.util.Arrays.toString(this)");
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", (String)localObject1);
      if (!((Map)a.a(this.Ggk)).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramView = a.a(this.Ggk).entrySet();
        p.j(paramView, "rangeSnapshots.entries");
        paramView = ((Iterable)paramView).iterator();
        while (paramView.hasNext())
        {
          Object localObject2 = (Map.Entry)paramView.next();
          localObject1 = a.b(this.Ggk);
          Object localObject3 = ((Map.Entry)localObject2).getKey();
          p.j(localObject3, "entry.key");
          i = ((Number)localObject3).intValue();
          localObject3 = ((Map.Entry)localObject2).getValue();
          p.j(localObject3, "entry.value");
          localObject3 = ((Range)localObject3).getLower();
          p.j(localObject3, "entry.value.lower");
          long l = ((Number)localObject3).longValue();
          localObject2 = ((Map.Entry)localObject2).getValue();
          p.j(localObject2, "entry.value");
          localObject2 = ((Range)localObject2).getUpper();
          p.j(localObject2, "entry.value.upper");
          MvTracksEditView.a((MvTracksEditView)localObject1, i, l, ((Number)localObject2).longValue());
        }
      }
      a.c(this.Ggk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC$initBgTrackView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(231234);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(a parama) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(230747);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC$initBgTrackView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = new StringBuilder("user clicked complete button, indexes=");
      localObject = a.a(this.Ggk).keySet();
      p.j(localObject, "rangeSnapshots.keys");
      localObject = ((Collection)localObject).toArray(new Integer[0]);
      if (localObject == null)
      {
        paramView = new t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(230747);
        throw paramView;
      }
      localObject = Arrays.toString((Object[])localObject);
      p.j(localObject, "java.util.Arrays.toString(this)");
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", (String)localObject);
      a.c(this.Ggk);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC$initBgTrackView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(230747);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC$initBgTrackView$3", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;", "dragEndTimeOffset", "", "dragStartIndex", "", "isMoved", "", "previewIndex", "previewJob", "Lkotlinx/coroutines/Job;", "previewTime", "onChooseTransition", "", "index", "onDragEnded", "onDragStarted", "onMove", "moveList", "", "Lkotlin/Pair;", "onSeek", "target", "onSelectStarted", "startTime", "endTime", "onTrackEndChanged", "time", "onTrackSlidingStarted", "onTrackSlidingStopped", "onTrackStartChanged", "previewFrame", "plugin-mv_release"})
  public static final class d
    implements MvTracksEditView.a
  {
    private int Ggl = -1;
    private long Ggm;
    private boolean Ggn;
    private int Ggo;
    private long Ggp;
    private by Ggq;
    
    d(com.tencent.mm.plugin.mv.ui.uic.q paramq) {}
    
    private final void aH(int paramInt, long paramLong)
    {
      AppMethodBeat.i(226708);
      this.Ggo = paramInt;
      this.Ggp = paramLong;
      by localby = this.Ggq;
      if ((localby != null) && (localby.isActive() == true))
      {
        AppMethodBeat.o(226708);
        return;
      }
      this.Ggq = kotlinx.coroutines.g.b((ak)br.abxo, (kotlin.d.f)bc.iRr(), (m)new d(this, null), 2);
      AppMethodBeat.o(226708);
    }
    
    public final void OM(long paramLong)
    {
      AppMethodBeat.i(226689);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onSeek: ".concat(String.valueOf(paramLong)));
      this.Gek.OP(paramLong);
      k localk = k.fet();
      p.j(localk, "MusicPlayerManager.Instance()");
      localk.feg().wG((int)paramLong);
      AppMethodBeat.o(226689);
    }
    
    public final void ZL(final int paramInt)
    {
      AppMethodBeat.i(226696);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onChooseTransition: index=".concat(String.valueOf(paramInt)));
      Object localObject1 = com.tencent.mm.plugin.mv.model.a.GaP;
      Object localObject2 = (Iterable)ae.cC((Map)com.tencent.mm.plugin.mv.model.a.ffQ());
      localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add((com.tencent.mm.plugin.mv.model.a)((o)((Iterator)localObject2).next()).My);
      }
      localObject2 = (List)localObject1;
      final long l1 = a.b(this.Ggk).getVideoProgress();
      localObject1 = (Iterable)a.b(this.Ggk).getTracks().subList(0, paramInt + 1);
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        i = (int)((com.tencent.mm.plugin.vlog.ui.thumb.a)((Iterator)localObject1).next()).gwv() + i;
      }
      localObject1 = com.tencent.mm.ui.component.g.Xox;
      final MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = ((com.tencent.mm.plugin.mv.ui.uic.q)com.tencent.mm.ui.component.g.b(this.Ggk.getActivity()).i(com.tencent.mm.plugin.mv.ui.uic.q.class)).GgY;
      if (localMultiMediaEffectVideoLayout == null) {
        p.iCn();
      }
      final long l2 = i - 1000L;
      long l3 = i;
      aa.f localf = new aa.f();
      localf.aaBC = null;
      localMultiMediaEffectVideoLayout.setLoop(false);
      localMultiMediaEffectVideoLayout.aG(l2, l3 + 1500L);
      localMultiMediaEffectVideoLayout.setOnPlayFinishListener((kotlin.g.a.a)new a(l2, localf));
      final bdt localbdt = (bdt)kotlin.a.j.M((List)a.d(this.Ggk), paramInt);
      Context localContext = (Context)this.Ggk.getContext();
      if (localbdt != null) {}
      for (localObject1 = localbdt.SOX;; localObject1 = null)
      {
        localf.aaBC = new b(localContext, (String)localObject1, (List)localObject2, (m)new b(this, paramInt, localMultiMediaEffectVideoLayout, l2, (List)localObject2), (kotlin.g.a.b)new c(this, l1, localMultiMediaEffectVideoLayout, paramInt, localbdt));
        ((b)localf.aaBC).show();
        AppMethodBeat.o(226696);
        return;
      }
    }
    
    public final void ZM(int paramInt)
    {
      AppMethodBeat.i(226719);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onDragStarted: ".concat(String.valueOf(paramInt)));
      this.Ggl = paramInt;
      this.Ggn = false;
      AppMethodBeat.o(226719);
    }
    
    public final void aF(int paramInt, long paramLong)
    {
      AppMethodBeat.i(226704);
      aH(paramInt, paramLong);
      AppMethodBeat.o(226704);
    }
    
    public final void aG(int paramInt, long paramLong)
    {
      AppMethodBeat.i(226706);
      aH(paramInt, paramLong);
      AppMethodBeat.o(226706);
    }
    
    public final void fgF()
    {
      AppMethodBeat.i(226721);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onDragEnded");
      if (this.Ggn)
      {
        this.Gek.OP(this.Ggm);
        k localk = k.fet();
        p.j(localk, "MusicPlayerManager.Instance()");
        localk.feg().wG((int)this.Ggm);
      }
      this.Ggl = -1;
      this.Ggm = 0L;
      AppMethodBeat.o(226721);
    }
    
    public final void gh(List<o<Integer, Integer>> paramList)
    {
      AppMethodBeat.i(226716);
      p.k(paramList, "moveList");
      if (paramList.isEmpty())
      {
        AppMethodBeat.o(226716);
        return;
      }
      Object localObject1 = this.Gek;
      p.k(paramList, "moveList");
      Object localObject2;
      int i;
      if (!paramList.isEmpty())
      {
        localObject2 = ((Iterable)paramList).iterator();
        Object localObject3;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (o)((Iterator)localObject2).next();
          Collections.swap((List)((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).rPI, ((Number)((o)localObject3).Mx).intValue(), ((Number)((o)localObject3).My).intValue());
        }
        ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).OL(((com.tencent.mm.plugin.thumbplayer.e.e)((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).rPI.getLast()).MSF);
        localObject2 = ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).GgY;
        if (localObject2 != null)
        {
          Object localObject4 = (Iterable)((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).rPI;
          localObject3 = (Collection)new ArrayList();
          localObject4 = ((Iterable)localObject4).iterator();
          label236:
          while (((Iterator)localObject4).hasNext())
          {
            Object localObject5 = ((Iterator)localObject4).next();
            if (((com.tencent.mm.plugin.thumbplayer.e.e)localObject5).MSF > 0L) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label236;
              }
              ((Collection)localObject3).add(localObject5);
              break;
            }
          }
          ((MultiMediaEffectVideoLayout)localObject2).setMediaList((List)localObject3);
        }
        localObject1 = ((com.tencent.mm.plugin.mv.ui.uic.q)localObject1).GgY;
        if (localObject1 != null) {
          ((MultiMediaEffectVideoLayout)localObject1).start();
        }
      }
      localObject1 = (bdt)kotlin.a.j.M((List)a.d(this.Ggk), this.Ggl);
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        localObject2 = (o)paramList.next();
        Collections.swap((List)a.d(this.Ggk), ((Number)((o)localObject2).Mx).intValue(), ((Number)((o)localObject2).My).intValue());
      }
      a.a(this.Ggk, ((bdt)a.d(this.Ggk).getLast()).SOR);
      long l;
      label420:
      int j;
      if (localObject1 != null)
      {
        l = ((bdt)localObject1).MSE;
        this.Ggm = l;
        this.Ggn = true;
        paramList = ((Iterable)a.d(this.Ggk)).iterator();
        i = 0;
        if (!paramList.hasNext()) {
          break label526;
        }
        localObject1 = paramList.next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject2 = (bdt)localObject1;
        localObject1 = a.b(this.Ggk);
        localObject2 = (CharSequence)((bdt)localObject2).SOX;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label515;
        }
        j = 1;
        label487:
        if (j != 0) {
          break label520;
        }
      }
      label515:
      label520:
      for (boolean bool = true;; bool = false)
      {
        ((MvTracksEditView)localObject1).aP(i, bool);
        i += 1;
        break label420;
        l = 0L;
        break;
        j = 0;
        break label487;
      }
      label526:
      AppMethodBeat.o(226716);
    }
    
    public final void r(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(226701);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onSelectStarted: " + paramInt + ", startTime=" + paramLong1 + ", endTime=" + paramLong2);
      ((Map)a.a(this.Ggk)).put(Integer.valueOf(paramInt), new Range((Comparable)Long.valueOf(paramLong1), (Comparable)Long.valueOf(paramLong2)));
      long l = ((com.tencent.mm.plugin.vlog.ui.thumb.a)a.b(this.Ggk).getTracks().get(paramInt)).NCo;
      Object localObject = this.Gek.GgY;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).aG(l, paramLong2 - paramLong1 + l);
      }
      localObject = k.fet();
      p.j(localObject, "MusicPlayerManager.Instance()");
      ((k)localObject).feg().wG((int)((bdt)a.d(this.Ggk).get(paramInt)).MSE);
      a.e(this.Ggk);
      AppMethodBeat.o(226701);
    }
    
    public final void s(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(226703);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onTrackSlidingStarted: index=" + paramInt + ", startTime=" + paramLong1 + ", endTime=" + paramLong2);
      Object localObject = this.Gek.GgY;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).pause();
      }
      localObject = k.fet();
      p.j(localObject, "MusicPlayerManager.Instance()");
      ((k)localObject).feg().pause();
      AppMethodBeat.o(226703);
    }
    
    public final void t(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(226710);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onPlayRangeChanged: " + paramInt + ", (" + paramLong1 + ", " + paramLong2 + ')');
      Object localObject = this.Ggq;
      if (localObject != null) {
        ((by)localObject).a(null);
      }
      this.Ggq = null;
      a.a(this.Ggk, paramInt, paramLong1, paramLong2, a.b(this.Ggk).getFillingDuration());
      this.Gek.b(paramInt, paramLong1, paramLong2, a.b(this.Ggk).getFillingDuration());
      long l = ((com.tencent.mm.plugin.vlog.ui.thumb.a)a.b(this.Ggk).getTracks().get(paramInt)).NCo;
      localObject = this.Gek.GgY;
      if (localObject != null) {
        ((MultiMediaEffectVideoLayout)localObject).aG(l, paramLong2 - paramLong1 + l);
      }
      localObject = k.fet();
      p.j(localObject, "MusicPlayerManager.Instance()");
      ((k)localObject).feg().resume();
      AppMethodBeat.o(226710);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<kotlin.x>
    {
      a(long paramLong, aa.f paramf)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pagInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "replay", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements m<com.tencent.mm.plugin.mv.model.a, Boolean, kotlin.x>
    {
      b(a.d paramd, int paramInt, MultiMediaEffectVideoLayout paramMultiMediaEffectVideoLayout, long paramLong, List paramList)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pagInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "invoke"})
    static final class c
      extends kotlin.g.b.q
      implements kotlin.g.a.b<com.tencent.mm.plugin.mv.model.a, kotlin.x>
    {
      c(a.d paramd, long paramLong, MultiMediaEffectVideoLayout paramMultiMediaEffectVideoLayout, int paramInt, bdt parambdt)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class d
      extends kotlin.d.b.a.j
      implements m<ak, kotlin.d.d<? super kotlin.x>, Object>
    {
      Object L$0;
      int label;
      private ak p$;
      
      d(a.d paramd, kotlin.d.d paramd1)
      {
        super(paramd1);
      }
      
      public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(227940);
        p.k(paramd, "completion");
        paramd = new d(this.Ggs, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(227940);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(227941);
        paramObject1 = ((d)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
        AppMethodBeat.o(227941);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(227938);
        Object localObject = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(227938);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          this.L$0 = this.p$;
          this.label = 1;
          if (aw.a(100L, this) == localObject)
          {
            AppMethodBeat.o(227938);
            return localObject;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = this.Ggs.Gek.GgY;
        int i;
        long l;
        if (paramObject != null)
        {
          i = a.d.a(this.Ggs);
          l = a.d.b(this.Ggs);
          localObject = paramObject.MUy;
          String str = ((com.tencent.mm.plugin.thumbplayer.d.c)localObject).TAG;
          StringBuilder localStringBuilder = new StringBuilder("seekToIndexTime, index:").append(i).append(", seekTo:").append(l).append(", renderPts:").append(((com.tencent.mm.plugin.thumbplayer.d.c)localObject).MQt).append(", playingPlayers.size:").append(((com.tencent.mm.plugin.thumbplayer.d.c)localObject).MQo.size()).append(", status:").append(((com.tencent.mm.plugin.thumbplayer.d.c)localObject).MQs).append(", trackList.size:");
          paramObject = ((com.tencent.mm.plugin.thumbplayer.d.c)localObject).MQr;
          if (paramObject == null) {
            break label287;
          }
          paramObject = paramObject.MQY;
          if (paramObject == null) {
            break label287;
          }
          paramObject = Integer.valueOf(paramObject.size());
          Log.i(str, paramObject);
          paramObject = ((com.tencent.mm.plugin.thumbplayer.d.c)localObject).MQr;
          if (paramObject != null)
          {
            paramObject = paramObject.MQY;
            if (paramObject != null) {
              break label292;
            }
          }
        }
        for (;;)
        {
          a.d.c(this.Ggs);
          paramObject = kotlin.x.aazN;
          AppMethodBeat.o(227938);
          return paramObject;
          label287:
          paramObject = null;
          break;
          label292:
          if (i <= paramObject.size())
          {
            paramObject = paramObject.get(i);
            p.j(paramObject, "trackList[index]");
            paramObject = (com.tencent.mm.plugin.thumbplayer.d.e)paramObject;
            ((com.tencent.mm.plugin.thumbplayer.d.c)localObject).MQy = (paramObject.startTimeMs + l);
            ((com.tencent.mm.plugin.thumbplayer.d.c)localObject).a(paramObject, l);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class e
    extends kotlin.d.b.a.j
    implements m<ak, kotlin.d.d<? super kotlin.x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    
    e(a parama, dbo paramdbo, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(226455);
      p.k(paramd, "completion");
      paramd = new e(this.Ggk, this.Ggx, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(226455);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(226457);
      paramObject1 = ((e)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
      AppMethodBeat.o(226457);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(226451);
      Object localObject2 = kotlin.d.a.a.aaAA;
      Object localObject3;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(226451);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        localObject1 = (kotlin.d.f)bc.iRs();
        localObject3 = (m)new a(this, null);
        this.L$0 = paramObject;
        this.label = 1;
        localObject1 = kotlinx.coroutines.i.a((kotlin.d.f)localObject1, (m)localObject3, this);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(226451);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject1 = (List)paramObject;
      paramObject = this.Ggx.TIX;
      if (paramObject != null)
      {
        paramObject = paramObject.GaB;
        if (paramObject == null) {}
      }
      for (paramObject = kotlin.d.b.a.b.Xu(paramObject.duration); paramObject == null; paramObject = null)
      {
        paramObject = (Throwable)new IllegalStateException("Couldn't get the duration of song".toString());
        AppMethodBeat.o(226451);
        throw paramObject;
      }
      localObject2 = a.b(this.Ggk);
      long l = paramObject.longValue();
      p.k(localObject1, "tracks");
      Log.i("MicroMsg.MvTracksEditView", "update: " + ((List)localObject1).size() + " tracks, songDuration=" + l + ", thumbDuration=" + ((MvTracksEditView)localObject2).thumbWidth / ((MvTracksEditView)localObject2).getWidthPerMills());
      ((MvTracksEditView)localObject2).GqT = ((List)localObject1);
      ((MvTracksEditView)localObject2).Ggg = l;
      ((MvTracksEditView)localObject2).GqW.Glx = l;
      ((MvTracksEditView)localObject2).fik();
      paramObject = ((MvTracksEditView)localObject2).GqA;
      l = ((MvTracksEditView)localObject2).GqY;
      int i;
      float f;
      label374:
      int k;
      label433:
      int j;
      if (l < 120000L)
      {
        i = 2;
        paramObject.Gqn = i;
        localObject3 = com.tencent.mm.plugin.mv.ui.widget.a.Gqt;
        paramObject.Gqo = com.tencent.mm.plugin.mv.ui.widget.a.a.ZU(paramObject.Gqn);
        i = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
        if (l >= 120000L) {
          break label547;
        }
        f = i * 2.0F / 1000.0F;
        paramObject.Gqp = f;
        ((MvTracksEditView)localObject2).fij();
        ((MvTracksEditView)localObject2).GqX.Gru.clear();
        ((MvTracksEditView)localObject2).GqQ.setVisibility(0);
        ((MvTracksEditView)localObject2).jLl.lF();
        ((MvTracksEditView)localObject2).GqR.notifyDataSetChanged();
        paramObject = ((Iterable)localObject1).iterator();
        i = 0;
        if (!paramObject.hasNext()) {
          break label594;
        }
        paramObject.next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        k = ((Number)Integer.valueOf(i)).intValue();
        localObject1 = a.b(this.Ggk);
        localObject2 = (CharSequence)((bdt)a.d(this.Ggk).get(k)).SOX;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label582;
        }
        j = 1;
        label518:
        if (j != 0) {
          break label588;
        }
      }
      label547:
      label582:
      label588:
      for (boolean bool = true;; bool = false)
      {
        ((MvTracksEditView)localObject1).aP(k, bool);
        i += 1;
        break label433;
        i = 3;
        break;
        if (l < 240000L)
        {
          f = i * 1.5F / 1000.0F;
          break label374;
        }
        f = i * 1.0F / 1000.0F;
        break label374;
        j = 0;
        break label518;
      }
      label594:
      paramObject = kotlin.x.aazN;
      AppMethodBeat.o(226451);
      return paramObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class a
      extends kotlin.d.b.a.j
      implements m<ak, kotlin.d.d<? super List<? extends com.tencent.mm.plugin.vlog.ui.thumb.a>>, Object>
    {
      int label;
      private ak p$;
      
      a(a.e parame, kotlin.d.d paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.x> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(226184);
        p.k(paramd, "completion");
        paramd = new a(this.Ggy, paramd);
        paramd.p$ = ((ak)paramObject);
        AppMethodBeat.o(226184);
        return paramd;
      }
      
      public final Object invoke(Object paramObject1, Object paramObject2)
      {
        AppMethodBeat.i(226186);
        paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(kotlin.x.aazN);
        AppMethodBeat.o(226186);
        return paramObject1;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(226183);
        Object localObject1 = kotlin.d.a.a.aaAA;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(226183);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.ui.component.g.Xox;
        localObject1 = (Iterable)((com.tencent.mm.plugin.mv.ui.uic.q)com.tencent.mm.ui.component.g.b(this.Ggy.Ggk.getActivity()).i(com.tencent.mm.plugin.mv.ui.uic.q.class)).fhs();
        paramObject = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (!((com.tencent.mm.plugin.thumbplayer.e.e)localObject2).MSD) {
            paramObject.add(localObject2);
          }
        }
        paramObject = (Iterable)paramObject;
        localObject1 = (Collection)new ArrayList(kotlin.a.j.a(paramObject, 10));
        Object localObject2 = paramObject.iterator();
        label393:
        if (((Iterator)localObject2).hasNext())
        {
          com.tencent.mm.plugin.thumbplayer.e.e locale = (com.tencent.mm.plugin.thumbplayer.e.e)((Iterator)localObject2).next();
          int i;
          if ((locale.fEF) || (locale.gop()))
          {
            paramObject = locale.path;
            if (locale.gop())
            {
              i = 1;
              label230:
              paramObject = new ad(paramObject, i);
              paramObject.Sn(locale.MSG);
              paramObject.So(locale.MSG + locale.MSF);
              paramObject.Sl(locale.MSE);
              paramObject.Sm(locale.MSE + locale.MSF);
              if (!locale.gop()) {
                break label393;
              }
              paramObject = (h)new com.tencent.mm.plugin.mv.ui.c.a(paramObject);
            }
          }
          label308:
          for (paramObject = (com.tencent.mm.plugin.vlog.ui.thumb.a)paramObject;; paramObject = (com.tencent.mm.plugin.vlog.ui.thumb.a)new com.tencent.mm.plugin.mv.ui.c.d((com.tencent.mm.plugin.thumbplayer.e.d)locale))
          {
            paramObject.NCj = locale.MSG;
            paramObject.NCk = (locale.MSG + locale.MSF);
            paramObject.width = this.Ggy.Ggk.getResources().getDimensionPixelSize(b.c.Edge_6A);
            paramObject.height = this.Ggy.Ggk.getResources().getDimensionPixelSize(b.c.Edge_6A);
            ((Collection)localObject1).add(paramObject);
            break;
            i = 2;
            break label230;
            paramObject = new h(paramObject);
            break label308;
          }
        }
        paramObject = (List)localObject1;
        AppMethodBeat.o(226183);
        return paramObject;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC$thumbLoader$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "compositionFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/CompositionTrackThumbFetcherFactory;", "tpFactory", "Lcom/tencent/mm/plugin/mv/ui/thumb/TPThumbFetcherFactory;", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "plugin-mv_release"})
  public static final class f
    implements com.tencent.mm.plugin.vlog.ui.thumb.g
  {
    private final com.tencent.mm.plugin.vlog.ui.thumb.b GgA;
    private final com.tencent.mm.plugin.mv.ui.c.b Ggz;
    
    f(AppCompatActivity paramAppCompatActivity)
    {
      AppMethodBeat.i(226308);
      this.Ggz = new com.tencent.mm.plugin.mv.ui.c.b();
      this.GgA = new com.tencent.mm.plugin.vlog.ui.thumb.b();
      AppMethodBeat.o(226308);
    }
    
    public final com.tencent.mm.videocomposition.c a(com.tencent.mm.plugin.vlog.ui.thumb.a parama, Object paramObject)
    {
      Object localObject2 = null;
      AppMethodBeat.i(226307);
      p.k(parama, "trackInfo");
      com.tencent.mm.plugin.mv.ui.c.b localb;
      com.tencent.mm.plugin.thumbplayer.e.d locald;
      com.tencent.mm.plugin.thumbplayer.d.c localc;
      int i;
      Object localObject3;
      label123:
      Object localObject1;
      if ((parama instanceof com.tencent.mm.plugin.mv.ui.c.d))
      {
        localb = this.Ggz;
        paramObject = com.tencent.mm.ui.component.g.Xox;
        paramObject = ((com.tencent.mm.plugin.mv.ui.uic.q)com.tencent.mm.ui.component.g.b(this.wYZ).i(com.tencent.mm.plugin.mv.ui.uic.q.class)).GgY;
        if (paramObject == null) {
          p.iCn();
        }
        locald = ((com.tencent.mm.plugin.mv.ui.c.d)parama).GhE;
        p.k(locald, "mediaInfo");
        localc = paramObject.MUy;
        p.k(locald, "mediaInfo");
        if (!((Collection)localc.MQo).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label701;
          }
          localObject3 = ((Iterable)localc.MQo).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label508;
          }
          localObject1 = ((Iterator)localObject3).next();
          paramObject = ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1).MRJ;
          if (paramObject == null) {
            break label503;
          }
          paramObject = paramObject.GhE;
          if (paramObject == null) {
            break label503;
          }
          paramObject = paramObject.mediaId;
          label169:
          if (!p.h(paramObject, locald.mediaId)) {
            break label506;
          }
          paramObject = localObject1;
          label184:
          paramObject = (com.tencent.mm.plugin.thumbplayer.d.a.a)paramObject;
          if ((paramObject == null) || (!(paramObject instanceof com.tencent.mm.plugin.thumbplayer.d.a.e))) {
            break label701;
          }
          Log.i(localc.TAG, "getThumbFetcherExtraData get from playingPlayer mediaId:" + locald.mediaId);
        }
      }
      label264:
      label286:
      label444:
      label701:
      for (paramObject = ((com.tencent.mm.plugin.thumbplayer.d.a.e)paramObject).Ght.MSQ;; paramObject = null)
      {
        localObject1 = paramObject;
        if (paramObject == null)
        {
          if (((Collection)localc.MQp).isEmpty()) {
            break label513;
          }
          i = 1;
          localObject1 = paramObject;
          if (i != 0)
          {
            Iterator localIterator = ((Iterable)localc.MQp).iterator();
            if (!localIterator.hasNext()) {
              break label524;
            }
            localObject3 = localIterator.next();
            localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.a.a)localObject3).MRJ;
            if (localObject1 == null) {
              break label518;
            }
            localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.e)localObject1).GhE;
            if (localObject1 == null) {
              break label518;
            }
            localObject1 = ((com.tencent.mm.plugin.thumbplayer.e.d)localObject1).mediaId;
            label339:
            if (!p.h(localObject1, locald.mediaId)) {
              break label522;
            }
            localObject1 = localObject3;
            label356:
            localObject3 = (com.tencent.mm.plugin.thumbplayer.d.a.a)localObject1;
            localObject1 = paramObject;
            if (localObject3 != null)
            {
              localObject1 = paramObject;
              if ((localObject3 instanceof com.tencent.mm.plugin.thumbplayer.d.a.e))
              {
                Log.i(localc.TAG, "getThumbFetcherExtraData get from pendingPlayer mediaId:" + locald.mediaId);
                localObject1 = ((com.tencent.mm.plugin.thumbplayer.d.a.e)localObject3).Ght.MSQ;
              }
            }
          }
        }
        if (localObject1 == null)
        {
          paramObject = ((List)localc.xoX).iterator();
          i = 0;
          if (paramObject.hasNext()) {
            if (p.h(((com.tencent.mm.plugin.thumbplayer.e.d)paramObject.next()).mediaId, locald.mediaId))
            {
              label476:
              if (i >= 0) {
                break label542;
              }
              paramObject = localObject2;
            }
          }
          label503:
          label506:
          label508:
          do
          {
            do
            {
              do
              {
                parama = localb.a(parama, paramObject);
                AppMethodBeat.o(226307);
                return parama;
                i = 0;
                break;
                paramObject = null;
                break label169;
                break label123;
                paramObject = null;
                break label184;
                i = 0;
                break label264;
                localObject1 = null;
                break label339;
                break label286;
                localObject1 = null;
                break label356;
                i += 1;
                break label444;
                i = -1;
                break label476;
                localObject3 = localc.MQr;
                paramObject = localObject2;
              } while (localObject3 == null);
              paramObject = localObject2;
            } while (i >= ((com.tencent.mm.plugin.thumbplayer.d.f)localObject3).MQY.size());
            Log.i(localc.TAG, "getThumbFetcherExtraData try create new one index:" + i + ", mediaId:" + locald.mediaId);
            paramObject = ((com.tencent.mm.plugin.thumbplayer.d.f)localObject3).MQY.get(i);
            p.j(paramObject, "composition.trackList[index]");
            localObject3 = localc.a((com.tencent.mm.plugin.thumbplayer.d.e)paramObject);
            paramObject = localObject2;
          } while (localObject3 == null);
          localc.MQq.add(localObject3);
          if (!(localObject3 instanceof com.tencent.mm.plugin.thumbplayer.d.a.e)) {}
        }
        for (paramObject = ((com.tencent.mm.plugin.thumbplayer.d.a.e)localObject3).Ght.MSQ;; paramObject = localObject1)
        {
          break;
          parama = this.GgA.a(parama, paramObject);
          AppMethodBeat.o(226307);
          return parama;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.free.a
 * JD-Core Version:    0.7.0.1
 */