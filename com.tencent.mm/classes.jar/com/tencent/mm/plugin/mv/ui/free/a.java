package com.tencent.mm.plugin.mv.ui.free;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Range;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.mv.b.c;
import com.tencent.mm.plugin.mv.b.e;
import com.tencent.mm.plugin.mv.b.h;
import com.tencent.mm.plugin.mv.ui.uic.n;
import com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView;
import com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView.a;
import com.tencent.mm.plugin.mv.ui.widget.MvTracksEditView.c;
import com.tencent.mm.plugin.thumbplayer.c.a.e;
import com.tencent.mm.plugin.thumbplayer.view.MultiMediaEffectVideoLayout;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.g;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.bol;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.dtf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentLinkedDeque;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.a.m;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.f;
import kotlin.g.b.u;
import kotlin.r;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "completeButton", "Landroid/widget/Button;", "deleteItemContainer", "Landroid/view/ViewGroup;", "isMoveTrack", "", "isSlidingTrackEdit", "isTrackDelete", "rangeSnapshots", "Ljava/util/HashMap;", "", "Landroid/util/Range;", "", "Lkotlin/collections/HashMap;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "selectButtonsContainer", "slidingIndex", "songDuration", "thumbLoader", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "trackList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderMVTrack;", "tracksEditView", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView;", "enterSelectMode", "", "exitSelectMode", "initBgTrackView", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "isPreviewEdit", "onDestroy", "onPreviewUIBack", "onVideoProgressUpdate", "timeMs", "refreshOffsets", "fillingDuration", "updateTrack", "index", "startTime", "endTime", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
{
  public static final a.a Mbl;
  MvTracksEditView Mbm;
  private ViewGroup Mbn;
  private Button Mbo;
  private ViewGroup Mbp;
  private LinkedList<boq> Mbq;
  private long Mbr;
  private boolean Mbs;
  private boolean Mbt;
  private int Mbu;
  private boolean Mbv;
  private final HashMap<Integer, Range<Long>> Mbw;
  private final com.tencent.mm.plugin.mv.ui.c.b Mbx;
  private final aq scope;
  
  static
  {
    AppMethodBeat.i(286839);
    Mbl = new a.a((byte)0);
    AppMethodBeat.o(286839);
  }
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(286730);
    this.scope = ar.b(ar.kBZ(), (kotlin.d.f)cx.g(null));
    this.Mbu = -1;
    this.Mbw = new HashMap();
    this.Mbx = new com.tencent.mm.plugin.mv.ui.c.b((g)new d(paramAppCompatActivity));
    AppMethodBeat.o(286730);
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(286768);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parama, "this$0");
    paramView = parama.Mbw.keySet();
    kotlin.g.b.s.s(paramView, "rangeSnapshots.keys");
    paramView = ((Collection)paramView).toArray(new Integer[0]);
    if (paramView == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(286768);
      throw parama;
    }
    paramView = Arrays.toString(paramView);
    kotlin.g.b.s.s(paramView, "java.util.Arrays.toString(this)");
    Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", kotlin.g.b.s.X("user clicked cancel button，revert: ", paramView));
    parama.Mbu = -1;
    if (!((Map)parama.Mbw).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramView = parama.Mbw.entrySet();
      kotlin.g.b.s.s(paramView, "rangeSnapshots.entries");
      localObject2 = ((Iterable)paramView).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        localObject1 = parama.Mbm;
        paramView = (View)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("tracksEditView");
          paramView = null;
        }
        localObject1 = localEntry.getKey();
        kotlin.g.b.s.s(localObject1, "entry.key");
        i = ((Number)localObject1).intValue();
        localObject1 = ((Range)localEntry.getValue()).getLower();
        kotlin.g.b.s.s(localObject1, "entry.value.lower");
        long l = ((Number)localObject1).longValue();
        localObject1 = ((Range)localEntry.getValue()).getUpper();
        kotlin.g.b.s.s(localObject1, "entry.value.upper");
        MvTracksEditView.a(paramView, i, l, ((Number)localObject1).longValue());
      }
    }
    parama.gqj();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286768);
  }
  
  private static final void a(a parama, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(286781);
    kotlin.g.b.s.u(parama, "this$0");
    params.c(1, (CharSequence)parama.getContext().getResources().getString(b.h.LWa));
    AppMethodBeat.o(286781);
  }
  
  private static final void a(a parama, com.tencent.mm.ui.widget.a.f paramf, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(286787);
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    if (paramMenuItem.getItemId() == 1)
    {
      parama.getActivity().finish();
      AppMethodBeat.o(286787);
      return;
    }
    paramf.cyW();
    AppMethodBeat.o(286787);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(286775);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    paramView = parama.Mbw.keySet();
    kotlin.g.b.s.s(paramView, "rangeSnapshots.keys");
    paramView = ((Collection)paramView).toArray(new Integer[0]);
    if (paramView == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
      AppMethodBeat.o(286775);
      throw parama;
    }
    paramView = Arrays.toString(paramView);
    kotlin.g.b.s.s(paramView, "java.util.Arrays.toString(this)");
    Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", kotlin.g.b.s.X("user clicked complete button, indexes=", paramView));
    if (parama.Mbu != -1) {
      parama.Mbv = true;
    }
    parama.Mbu = -1;
    parama.gqj();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(286775);
  }
  
  private final void gqj()
  {
    AppMethodBeat.i(286757);
    Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "exitSelectMode");
    Object localObject2 = this.Mbn;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("selectButtonsContainer");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).setVisibility(8);
    localObject2 = this.Mbo;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("completeButton");
      localObject1 = null;
    }
    ((Button)localObject1).setVisibility(0);
    localObject2 = this.Mbm;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("tracksEditView");
      localObject1 = null;
    }
    Log.i("MicroMsg.MvTracksEditView", kotlin.g.b.s.X("stopSelecting: ", Integer.valueOf(((MvTracksEditView)localObject1).getSelectedIndex())));
    if (((MvTracksEditView)localObject1).getSelectedIndex() >= 0)
    {
      ((MvTracksEditView)localObject1).MkU.fV(com.tencent.mm.plugin.mv.ui.widget.c.aep(((MvTracksEditView)localObject1).getSelectedIndex()));
      ((MvTracksEditView)localObject1).setSelectedIndex(-1);
    }
    ((MvTracksEditView)localObject1).MkU.MkG = null;
    ((MvTracksEditView)localObject1).MkT.setVisibility(0);
    ((MvTracksEditView)localObject1).Mlb.rKp = true;
    ((MvTracksEditView)localObject1).mkw.Kp();
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(n.class);
    kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…PreviewBgUIC::class.java)");
    localObject1 = ((n)localObject1).Mci;
    if (localObject1 != null) {
      ((MultiMediaEffectVideoLayout)localObject1).TGY.hKH();
    }
    this.Mbw.clear();
    AppMethodBeat.o(286757);
  }
  
  private final void sJ(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(286744);
    Object localObject3 = this.Mbq;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("trackList");
      localObject1 = null;
    }
    localObject3 = (Iterable)kotlin.k.k.qt(0, ((LinkedList)localObject1).size() - 1);
    localObject1 = this.Mbq;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("trackList");
      localObject1 = null;
    }
    Collection localCollection;
    for (;;)
    {
      localCollection = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        localCollection.add((boq)((LinkedList)localObject1).get(((kotlin.a.ah)localObject3).Zo()));
      }
    }
    localObject1 = ((Iterable)localCollection).iterator();
    for (long l = 0L; ((Iterator)localObject1).hasNext(); l = ((boq)localObject3).ZWY + l)
    {
      localObject3 = (boq)((Iterator)localObject1).next();
      ((boq)localObject3).TBM = l;
    }
    localObject1 = this.Mbq;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("trackList");
      localObject1 = localObject2;
    }
    for (;;)
    {
      localObject1 = (boq)((LinkedList)localObject1).getLast();
      ((boq)localObject1).TBM = l;
      ((boq)localObject1).ZWY = ((int)paramLong);
      AppMethodBeat.o(286744);
      return;
    }
  }
  
  public final void e(dtf paramdtf)
  {
    AppMethodBeat.i(286888);
    kotlin.g.b.s.u(paramdtf, "mvData");
    Object localObject1 = paramdtf.aaYK;
    Object localObject2;
    long l;
    label64:
    Object localObject3;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new LinkedList();
      }
      this.Mbq = ((LinkedList)localObject2);
      localObject1 = paramdtf.aaYM;
      if (localObject1 != null) {
        break label474;
      }
      l = 0L;
      this.Mbr = l;
      localObject1 = getActivity().findViewById(b.e.LSn);
      kotlin.g.b.s.s(localObject1, "activity.findViewById(R.id.crop_thumb_view)");
      this.Mbm = ((MvTracksEditView)localObject1);
      localObject1 = getActivity().findViewById(b.e.complete_btn);
      kotlin.g.b.s.s(localObject1, "activity.findViewById(R.id.complete_btn)");
      this.Mbo = ((Button)localObject1);
      localObject3 = getActivity().findViewById(b.e.LRS);
      kotlin.g.b.s.s(localObject3, "activity.findViewById(R.id.cancel_select_button)");
      localObject4 = getActivity().findViewById(b.e.LSg);
      kotlin.g.b.s.s(localObject4, "activity.findViewById(R.id.complete_select_button)");
      localObject1 = getActivity().findViewById(b.e.LUz);
      kotlin.g.b.s.s(localObject1, "activity.findViewById(R.…select_buttons_container)");
      this.Mbn = ((ViewGroup)localObject1);
      localObject2 = this.Mbm;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("tracksEditView");
        localObject1 = null;
      }
      ((MvTracksEditView)localObject1).setThumbLoader(this.Mbx);
      ((View)localObject3).setOnClickListener(new a..ExternalSyntheticLambda1(this));
      ((View)localObject4).setOnClickListener(new a..ExternalSyntheticLambda0(this));
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      localObject1 = com.tencent.mm.ui.component.k.d(getActivity()).q(n.class);
      kotlin.g.b.s.s(localObject1, "UICProvider.of(activity)…PreviewBgUIC::class.java)");
      localObject2 = (n)localObject1;
      localObject1 = getActivity().findViewById(b.e.LSp);
      kotlin.g.b.s.s(localObject1, "activity.findViewById(R.id.delete_item_container)");
      this.Mbp = ((ViewGroup)localObject1);
      localObject1 = getActivity().findViewById(b.e.deleted_tips_tv);
      kotlin.g.b.s.s(localObject1, "activity.findViewById(R.id.deleted_tips_tv)");
      localObject3 = (TextView)localObject1;
      localObject4 = new ah.a();
      localObject1 = this.Mbm;
      if (localObject1 != null) {
        break label501;
      }
      kotlin.g.b.s.bIx("tracksEditView");
      localObject1 = null;
    }
    label474:
    label501:
    for (;;)
    {
      ((MvTracksEditView)localObject1).setCallback((MvTracksEditView.a)new b((n)localObject2, this, (ah.a)localObject4, (TextView)localObject3));
      kotlinx.coroutines.j.a(this.scope, null, null, (m)new c(paramdtf, this, null), 3);
      AppMethodBeat.o(286888);
      return;
      localObject1 = ((FinderObject)localObject1).objectDesc;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((FinderObjectDesc)localObject1).mvInfo;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bol)localObject1).ZWL;
      break;
      localObject1 = ((bol)localObject1).LWI;
      if (localObject1 == null)
      {
        l = 0L;
        break label64;
      }
      l = ((boo)localObject1).duration;
      break label64;
    }
  }
  
  public final void gqk()
  {
    AppMethodBeat.i(286892);
    int i;
    if ((this.Mbs) || (this.Mbt) || (this.Mbv)) {
      i = 1;
    }
    while (i != 0)
    {
      Object localObject = new com.tencent.mm.ui.widget.a.f((Context)getActivity(), 1, true);
      ((com.tencent.mm.ui.widget.a.f)localObject).NE(true);
      ((com.tencent.mm.ui.widget.a.f)localObject).h((CharSequence)getResources().getString(b.h.LWb), 17, getResources().getDimensionPixelSize(b.c.SmallestTextSize));
      ((com.tencent.mm.ui.widget.a.f)localObject).setBackgroundColor(getContext().getResources().getColor(com.tencent.mm.plugin.mv.b.b.Dark_5));
      ((com.tencent.mm.ui.widget.a.f)localObject).Vtg = new a..ExternalSyntheticLambda2(this);
      ((com.tencent.mm.ui.widget.a.f)localObject).GAC = new a..ExternalSyntheticLambda3(this, (com.tencent.mm.ui.widget.a.f)localObject);
      ((com.tencent.mm.ui.widget.a.f)localObject).dDn();
      AppMethodBeat.o(286892);
      return;
      LinkedList localLinkedList = this.Mbq;
      localObject = localLinkedList;
      if (localLinkedList == null)
      {
        kotlin.g.b.s.bIx("trackList");
        localObject = null;
      }
      localObject = ((Iterable)localObject).iterator();
      for (;;)
      {
        if (((Iterator)localObject).hasNext()) {
          if (((boq)((Iterator)localObject).next()).ZXe != null)
          {
            i = 1;
            break;
          }
        }
      }
      i = 0;
    }
    getActivity().finish();
    AppMethodBeat.o(286892);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(286877);
    super.onDestroy();
    com.tencent.mm.plugin.mv.ui.c.b localb = this.Mbx;
    Log.i("MicroMsg.ThumbCachedLoader", "release");
    Object localObject = localb.cmd.values();
    kotlin.g.b.s.s(localObject, "entries.values");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      com.tencent.mm.plugin.mv.ui.c.b.b localb1 = (com.tencent.mm.plugin.mv.ui.c.b.b)((Iterator)localObject).next();
      ((ab)localb1.Mdk).k(null);
      com.tencent.mm.videocomposition.c localc = localb1.FTn;
      if (localc != null) {
        localc.destroy();
      }
      localb1.FTn = null;
    }
    ar.a(localb.scope, null);
    ar.a(this.scope, null);
    AppMethodBeat.o(286877);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC$initBgTrackView$3", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$Callback;", "dragEndTimeOffset", "", "dragStartIndex", "", "isMoved", "", "previewIndex", "previewJob", "Lkotlinx/coroutines/Job;", "previewTime", "handleDragDelete", "touchY", "", "type", "Lcom/tencent/mm/plugin/mv/ui/widget/MvTracksEditView$DeleteDragType;", "index", "onChooseTransition", "", "onDragEnded", "onDragStarted", "onMove", "fromPosition", "toPosition", "onSeek", "target", "onSelectStarted", "startTime", "endTime", "onTrackEndChanged", "time", "onTrackSlidingStarted", "onTrackSlidingStopped", "onTrackStartChanged", "previewFrame", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements MvTracksEditView.a
  {
    private boolean MbA;
    private int MbB;
    private long MbC;
    private cb MbD;
    private int Mby = -1;
    private long Mbz;
    
    b(n paramn, a parama, ah.a parama1, TextView paramTextView) {}
    
    private final void aO(int paramInt, long paramLong)
    {
      int i = 1;
      AppMethodBeat.i(286782);
      this.MbB = paramInt;
      this.MbC = paramLong;
      cb localcb = this.MbD;
      if ((localcb != null) && (localcb.isActive() == true)) {}
      for (paramInt = i; paramInt != 0; paramInt = 0)
      {
        AppMethodBeat.o(286782);
        return;
      }
      this.MbD = kotlinx.coroutines.j.a((aq)bu.ajwo, (kotlin.d.f)bg.kCh(), null, (m)new e(this.LZP, this, null), 2);
      AppMethodBeat.o(286782);
    }
    
    private static final void is(View paramView)
    {
      AppMethodBeat.i(286788);
      if (paramView != null)
      {
        paramView = (TextView)paramView.findViewById(p.e.toast_text);
        if (paramView != null) {
          paramView.setTextSize(1, 14.0F);
        }
      }
      AppMethodBeat.o(286788);
    }
    
    public final boolean a(float paramFloat, MvTracksEditView.c paramc, int paramInt)
    {
      Object localObject1 = null;
      LinkedList localLinkedList = null;
      AppMethodBeat.i(286894);
      kotlin.g.b.s.u(paramc, "type");
      switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
      {
      default: 
        localObject1 = new StringBuilder("touchY: ").append(paramFloat).append(", deleteItemContainer.top: ");
        paramc = a.f(jdField_this);
        if (paramc == null)
        {
          kotlin.g.b.s.bIx("deleteItemContainer");
          paramc = localLinkedList;
        }
        break;
      }
      for (;;)
      {
        Log.d("MicroMsg.Mv.MusicMvPreviewTrackUIC", paramc.getTop());
        AppMethodBeat.o(286894);
        return false;
        localObject1 = a.f(jdField_this);
        paramc = (MvTracksEditView.c)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("deleteItemContainer");
          paramc = null;
        }
        if (paramFloat >= paramc.getTop())
        {
          this.MbF.aiwY = true;
          this.MbG.setText((CharSequence)com.tencent.mm.cd.a.bt((Context)jdField_this.getActivity(), b.h.LWd));
          break;
        }
        this.MbF.aiwY = false;
        this.MbG.setText((CharSequence)com.tencent.mm.cd.a.bt((Context)jdField_this.getActivity(), b.h.LWc));
        break;
        Object localObject2 = a.f(jdField_this);
        paramc = (MvTracksEditView.c)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("deleteItemContainer");
          paramc = null;
        }
        paramc.setVisibility(8);
        StringBuilder localStringBuilder = new StringBuilder("size：");
        localObject2 = a.a(jdField_this);
        paramc = (MvTracksEditView.c)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("tracksEditView");
          paramc = null;
        }
        Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", paramc.getTracks().size() + "， index: " + paramInt);
        if (!this.MbF.aiwY) {
          break;
        }
        localObject2 = a.a(jdField_this);
        paramc = (MvTracksEditView.c)localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("tracksEditView");
          paramc = null;
        }
        if (paramc.getTracks().size() == 1)
        {
          paramc = com.tencent.mm.cd.a.bt((Context)jdField_this.getActivity(), b.h.LVZ);
          aa.a((Context)jdField_this.getActivity(), paramc, a.b..ExternalSyntheticLambda0.INSTANCE);
          break;
        }
        this.LZP.aej(paramInt);
        localLinkedList = a.b(jdField_this);
        paramc = localLinkedList;
        if (localLinkedList == null)
        {
          kotlin.g.b.s.bIx("trackList");
          paramc = null;
        }
        paramc.remove(paramInt);
        localObject2 = jdField_this;
        localLinkedList = a.b(jdField_this);
        paramc = localLinkedList;
        if (localLinkedList == null)
        {
          kotlin.g.b.s.bIx("trackList");
          paramc = null;
        }
        a.a((a)localObject2, ((boq)paramc.getLast()).ZWY);
        a.g(jdField_this);
        this.LZP.sM(0L);
        com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH(0);
        paramc = a.a(jdField_this);
        if (paramc == null)
        {
          kotlin.g.b.s.bIx("tracksEditView");
          paramc = (MvTracksEditView.c)localObject1;
        }
        for (;;)
        {
          paramc.bq(paramInt, false);
          AppMethodBeat.o(286894);
          return true;
        }
      }
    }
    
    public final void aM(int paramInt, long paramLong)
    {
      AppMethodBeat.i(286841);
      aO(paramInt, paramLong);
      AppMethodBeat.o(286841);
    }
    
    public final void aN(int paramInt, long paramLong)
    {
      AppMethodBeat.i(286848);
      aO(paramInt, paramLong);
      AppMethodBeat.o(286848);
    }
    
    public final void adY(final int paramInt)
    {
      AppMethodBeat.i(286822);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", kotlin.g.b.s.X("onChooseTransition: index=", Integer.valueOf(paramInt)));
      Object localObject1 = com.tencent.mm.plugin.mv.model.a.LWK;
      Object localObject2 = (Iterable)ak.dy((Map)com.tencent.mm.plugin.mv.model.a.gpt());
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Collection)localObject1).add((com.tencent.mm.plugin.mv.model.a)((r)((Iterator)localObject2).next()).bsD);
      }
      List localList = (List)localObject1;
      localObject2 = a.a(jdField_this);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("tracksEditView");
        localObject1 = null;
      }
      long l1 = ((MvTracksEditView)localObject1).getVideoProgress();
      localObject2 = a.a(jdField_this);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("tracksEditView");
        localObject1 = null;
      }
      localObject1 = (Iterable)((MvTracksEditView)localObject1).getTracks().subList(0, paramInt + 1);
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        i = (int)((com.tencent.mm.plugin.vlog.ui.thumb.a)((Iterator)localObject1).next()).hUo() + i;
      }
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      final MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = ((n)com.tencent.mm.ui.component.k.d(jdField_this.getActivity()).q(n.class)).Mci;
      kotlin.g.b.s.checkNotNull(localMultiMediaEffectVideoLayout);
      final long l2 = i - 1000L;
      long l3 = i;
      ah.f localf = new ah.f();
      localMultiMediaEffectVideoLayout.setLoop(false);
      localMultiMediaEffectVideoLayout.bs(l2, l3 + 1500L);
      localMultiMediaEffectVideoLayout.setOnPlayFinishListener((kotlin.g.a.a)new b(l2, localf));
      localObject2 = a.b(jdField_this);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("trackList");
        localObject1 = null;
      }
      localObject2 = (boq)p.ae((List)localObject1, paramInt);
      Context localContext = (Context)jdField_this.getContext();
      if (localObject2 == null) {}
      for (localObject1 = null;; localObject1 = ((boq)localObject2).ZXe)
      {
        localf.aqH = new b(localContext, (String)localObject1, localList, (m)new c(this.LZP, paramInt, localMultiMediaEffectVideoLayout, l2, localList), (kotlin.g.a.b)new d(l1, localMultiMediaEffectVideoLayout, this.LZP, paramInt, jdField_this, (boq)localObject2));
        ((b)localf.aqH).show();
        AppMethodBeat.o(286822);
        return;
      }
    }
    
    public final void adZ(int paramInt)
    {
      AppMethodBeat.i(286881);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", kotlin.g.b.s.X("onDragStarted: ", Integer.valueOf(paramInt)));
      this.Mby = paramInt;
      this.MbA = false;
      ViewGroup localViewGroup2 = a.f(jdField_this);
      ViewGroup localViewGroup1 = localViewGroup2;
      if (localViewGroup2 == null)
      {
        kotlin.g.b.s.bIx("deleteItemContainer");
        localViewGroup1 = null;
      }
      localViewGroup1.setVisibility(0);
      AppMethodBeat.o(286881);
    }
    
    public final void gZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(286875);
      if ((paramInt1 == -1) || (paramInt2 == -1) || (paramInt1 == paramInt2))
      {
        AppMethodBeat.o(286875);
        return;
      }
      Object localObject1 = this.LZP;
      Object localObject2 = ((n)localObject1).vaX.remove(paramInt1);
      kotlin.g.b.s.s(localObject2, "mediaInfoList.removeAt(fromPosition)");
      localObject2 = (com.tencent.mm.plugin.thumbplayer.d.d)localObject2;
      ((n)localObject1).vaX.add(paramInt2, localObject2);
      ((n)localObject1).sJ(((com.tencent.mm.plugin.thumbplayer.d.d)((n)localObject1).vaX.getLast()).TBN);
      localObject2 = ((n)localObject1).Mci;
      Object localObject5;
      if (localObject2 != null)
      {
        localObject4 = (Iterable)((n)localObject1).vaX;
        localObject3 = (Collection)new ArrayList();
        localObject4 = ((Iterable)localObject4).iterator();
        label187:
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = ((Iterator)localObject4).next();
          if (((com.tencent.mm.plugin.thumbplayer.d.d)localObject5).TBN > 0L) {}
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label187;
            }
            ((Collection)localObject3).add(localObject5);
            break;
          }
        }
        ((MultiMediaEffectVideoLayout)localObject2).setMediaList((List)localObject3);
      }
      localObject1 = ((n)localObject1).Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).start();
      }
      localObject2 = a.b(jdField_this);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("trackList");
        localObject1 = null;
      }
      Object localObject3 = (boq)p.ae((List)localObject1, this.Mby);
      localObject2 = a.b(jdField_this);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("trackList");
        localObject1 = null;
      }
      localObject1 = ((LinkedList)localObject1).remove(paramInt1);
      kotlin.g.b.s.s(localObject1, "trackList.removeAt(fromPosition)");
      Object localObject4 = (boq)localObject1;
      localObject2 = a.b(jdField_this);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("trackList");
        localObject1 = null;
      }
      ((LinkedList)localObject1).add(paramInt2, localObject4);
      localObject4 = jdField_this;
      localObject2 = a.b(jdField_this);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("trackList");
        localObject1 = null;
      }
      a.a((a)localObject4, ((boq)((LinkedList)localObject1).getLast()).ZWY);
      long l;
      if (localObject3 == null)
      {
        l = 0L;
        this.Mbz = l;
        this.MbA = true;
        a.e(jdField_this);
        localObject2 = a.b(jdField_this);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("trackList");
          localObject1 = null;
        }
        localObject1 = (Iterable)localObject1;
        localObject3 = jdField_this;
        localObject4 = ((Iterable)localObject1).iterator();
        paramInt1 = 0;
        label472:
        if (!((Iterator)localObject4).hasNext()) {
          break label600;
        }
        localObject1 = ((Iterator)localObject4).next();
        if (paramInt1 < 0) {
          p.kkW();
        }
        localObject5 = (boq)localObject1;
        localObject2 = a.a((a)localObject3);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("tracksEditView");
          localObject1 = null;
        }
        localObject2 = (CharSequence)((boq)localObject5).ZXe;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          break label589;
        }
        paramInt2 = 1;
        label557:
        if (paramInt2 != 0) {
          break label594;
        }
      }
      label589:
      label594:
      for (boolean bool = true;; bool = false)
      {
        ((MvTracksEditView)localObject1).bq(paramInt1, bool);
        paramInt1 += 1;
        break label472;
        l = ((boq)localObject3).TBM;
        break;
        paramInt2 = 0;
        break label557;
      }
      label600:
      AppMethodBeat.o(286875);
    }
    
    public final void gql()
    {
      AppMethodBeat.i(286885);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onDragEnded");
      if (this.MbA)
      {
        this.LZP.sM(this.Mbz);
        com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH((int)this.Mbz);
      }
      this.Mby = -1;
      this.Mbz = 0L;
      AppMethodBeat.o(286885);
    }
    
    public final void q(int paramInt, long paramLong1, long paramLong2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(286829);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onSelectStarted: " + paramInt + ", startTime=" + paramLong1 + ", endTime=" + paramLong2);
      ((Map)a.c(jdField_this)).put(Integer.valueOf(paramInt), new Range((Comparable)Long.valueOf(paramLong1), (Comparable)Long.valueOf(paramLong2)));
      Object localObject3 = a.a(jdField_this);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("tracksEditView");
        localObject1 = null;
      }
      long l = ((com.tencent.mm.plugin.vlog.ui.thumb.a)((MvTracksEditView)localObject1).getTracks().get(paramInt)).UoU;
      localObject1 = this.LZP.Mci;
      if (localObject1 != null) {
        ((MultiMediaEffectVideoLayout)localObject1).bs(l, paramLong2 - paramLong1 + l);
      }
      localObject3 = com.tencent.mm.plugin.music.logic.j.gnw().gnj();
      localObject1 = a.b(jdField_this);
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("trackList");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.music.e.a.d)localObject3).wH((int)((boq)((LinkedList)localObject1).get(paramInt)).TBM);
        a.d(jdField_this);
        AppMethodBeat.o(286829);
        return;
      }
    }
    
    public final void r(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(286835);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onTrackSlidingStarted: index=" + paramInt + ", startTime=" + paramLong1 + ", endTime=" + paramLong2);
      MultiMediaEffectVideoLayout localMultiMediaEffectVideoLayout = this.LZP.Mci;
      if (localMultiMediaEffectVideoLayout != null) {
        localMultiMediaEffectVideoLayout.pause();
      }
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().pause();
      AppMethodBeat.o(286835);
    }
    
    public final void s(int paramInt, long paramLong1, long paramLong2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(286858);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", "onPlayRangeChanged: " + paramInt + ", (" + paramLong1 + ", " + paramLong2 + ')');
      Object localObject1 = this.MbD;
      if (localObject1 != null) {
        ((cb)localObject1).a(null);
      }
      this.MbD = null;
      Object localObject3 = jdField_this;
      MvTracksEditView localMvTracksEditView = a.a(jdField_this);
      localObject1 = localMvTracksEditView;
      if (localMvTracksEditView == null)
      {
        kotlin.g.b.s.bIx("tracksEditView");
        localObject1 = null;
      }
      a.a((a)localObject3, paramInt, paramLong1, paramLong2, ((MvTracksEditView)localObject1).getFillingDuration());
      localObject3 = this.LZP;
      localMvTracksEditView = a.a(jdField_this);
      localObject1 = localMvTracksEditView;
      if (localMvTracksEditView == null)
      {
        kotlin.g.b.s.bIx("tracksEditView");
        localObject1 = null;
      }
      ((n)localObject3).b(paramInt, paramLong1, paramLong2, ((MvTracksEditView)localObject1).getFillingDuration());
      localObject1 = a.a(jdField_this);
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("tracksEditView");
        localObject1 = localObject2;
      }
      for (;;)
      {
        long l = ((com.tencent.mm.plugin.vlog.ui.thumb.a)((MvTracksEditView)localObject1).getTracks().get(paramInt)).UoU;
        localObject1 = this.LZP.Mci;
        if (localObject1 != null) {
          ((MultiMediaEffectVideoLayout)localObject1).bs(l, paramLong2 - paramLong1 + l);
        }
        com.tencent.mm.plugin.music.logic.j.gnw().gnj().resume();
        a.a(jdField_this, paramInt);
        AppMethodBeat.o(286858);
        return;
      }
    }
    
    public final void sK(long paramLong)
    {
      AppMethodBeat.i(286809);
      Log.i("MicroMsg.Mv.MusicMvPreviewTrackUIC", kotlin.g.b.s.X("onSeek: ", Long.valueOf(paramLong)));
      this.LZP.sM(paramLong);
      com.tencent.mm.plugin.music.logic.j.gnw().gnj().wH((int)paramLong);
      AppMethodBeat.o(286809);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<kotlin.ah>
    {
      b(long paramLong, ah.f<b> paramf)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "pagInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;", "replay", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class c
      extends u
      implements m<com.tencent.mm.plugin.mv.model.a, Boolean, kotlin.ah>
    {
      c(n paramn, int paramInt, MultiMediaEffectVideoLayout paramMultiMediaEffectVideoLayout, long paramLong, List<com.tencent.mm.plugin.mv.model.a> paramList)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "pagInfo", "Lcom/tencent/mm/plugin/mv/model/DefaultPagInfo;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class d
      extends u
      implements kotlin.g.a.b<com.tencent.mm.plugin.mv.model.a, kotlin.ah>
    {
      d(long paramLong, MultiMediaEffectVideoLayout paramMultiMediaEffectVideoLayout, n paramn, int paramInt, a parama, boq paramboq)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class e
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
    {
      int label;
      
      e(n paramn, a.b paramb, kotlin.d.d<? super e> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(286798);
        paramObject = (kotlin.d.d)new e(this.LZP, jdField_this, paramd);
        AppMethodBeat.o(286798);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        Object localObject1 = null;
        AppMethodBeat.i(286794);
        Object localObject2 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(286794);
          throw paramObject;
        case 0: 
          ResultKt.throwOnFailure(paramObject);
          paramObject = (kotlin.d.d)this;
          this.label = 1;
          if (bb.e(100L, paramObject) == localObject2)
          {
            AppMethodBeat.o(286794);
            return localObject2;
          }
          break;
        case 1: 
          ResultKt.throwOnFailure(paramObject);
        }
        paramObject = this.LZP.Mci;
        int i;
        long l;
        if (paramObject != null)
        {
          i = a.b.a(jdField_this);
          l = a.b.b(jdField_this);
          localObject2 = paramObject.TGY;
          String str = ((com.tencent.mm.plugin.thumbplayer.c.b)localObject2).TAG;
          StringBuilder localStringBuilder = new StringBuilder("seekToIndexTime, index:").append(i).append(", seekTo:").append(l).append(", renderPts:").append(((com.tencent.mm.plugin.thumbplayer.c.b)localObject2).TCX).append(", playingPlayers.size:").append(((com.tencent.mm.plugin.thumbplayer.c.b)localObject2).TCS.size()).append(", status:").append(((com.tencent.mm.plugin.thumbplayer.c.b)localObject2).TCW).append(", trackList.size:");
          paramObject = ((com.tencent.mm.plugin.thumbplayer.c.b)localObject2).TCV;
          if (paramObject != null) {
            break label311;
          }
          paramObject = null;
          Log.i(str, paramObject);
          paramObject = ((com.tencent.mm.plugin.thumbplayer.c.b)localObject2).TCV;
          if (paramObject != null) {
            break label336;
          }
        }
        label311:
        label336:
        for (paramObject = localObject1;; paramObject = paramObject.TDz)
        {
          if ((paramObject != null) && (i <= paramObject.size()))
          {
            paramObject = paramObject.get(i);
            kotlin.g.b.s.s(paramObject, "trackList[index]");
            paramObject = (com.tencent.mm.plugin.thumbplayer.c.c)paramObject;
            ((com.tencent.mm.plugin.thumbplayer.c.b)localObject2).TDc = (paramObject.startTimeMs + l);
            ((com.tencent.mm.plugin.thumbplayer.c.b)localObject2).a(paramObject, l);
          }
          a.b.c(jdField_this);
          paramObject = kotlin.ah.aiuX;
          AppMethodBeat.o(286794);
          return paramObject;
          paramObject = paramObject.TDz;
          if (paramObject == null)
          {
            paramObject = null;
            break;
          }
          paramObject = Integer.valueOf(paramObject.size());
          break;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super kotlin.ah>, Object>
  {
    int label;
    
    c(dtf paramdtf, a parama, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(286774);
      paramObject = (kotlin.d.d)new c(this.MbN, jdField_this, paramd);
      AppMethodBeat.o(286774);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(286767);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(286767);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.f)bg.kCi();
        localObject1 = (m)new a(jdField_this, null);
        localObject3 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = l.a(paramObject, (m)localObject1, (kotlin.d.d)localObject3);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(286767);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject3 = (List)paramObject;
      paramObject = this.MbN.aaYM;
      if (paramObject == null) {
        paramObject = null;
      }
      while (paramObject == null)
      {
        paramObject = (Throwable)new IllegalStateException("Couldn't get the duration of song".toString());
        AppMethodBeat.o(286767);
        throw paramObject;
        paramObject = paramObject.LWI;
        if (paramObject == null) {
          paramObject = null;
        } else {
          paramObject = kotlin.d.b.a.b.BF(paramObject.duration);
        }
      }
      localObject2 = a.a(jdField_this);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("tracksEditView");
        localObject1 = null;
      }
      long l = paramObject.longValue();
      kotlin.g.b.s.u(localObject3, "tracks");
      Log.i("MicroMsg.MvTracksEditView", "update: " + ((List)localObject3).size() + " tracks, songDuration=" + l + ", thumbDuration=" + ((MvTracksEditView)localObject1).thumbWidth / ((MvTracksEditView)localObject1).getWidthPerMills());
      ((MvTracksEditView)localObject1).MkW = ((List)localObject3);
      ((MvTracksEditView)localObject1).Mbr = l;
      ((MvTracksEditView)localObject1).Mla.MfX = l;
      ((MvTracksEditView)localObject1).gsn();
      ((MvTracksEditView)localObject1).MkC.reset(((MvTracksEditView)localObject1).Mlc);
      ((MvTracksEditView)localObject1).gsm();
      ((MvTracksEditView)localObject1).Mlb.Mly.clear();
      ((MvTracksEditView)localObject1).MkT.setVisibility(0);
      ((MvTracksEditView)localObject1).mkw.Kp();
      ((MvTracksEditView)localObject1).MkU.bZE.notifyChanged();
      paramObject = (Iterable)localObject3;
      localObject3 = jdField_this;
      Iterator localIterator = paramObject.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        localIterator.next();
        if (i < 0) {
          p.kkW();
        }
        paramObject = a.a((a)localObject3);
        label443:
        int j;
        if (paramObject == null)
        {
          kotlin.g.b.s.bIx("tracksEditView");
          paramObject = null;
          localObject2 = a.b((a)localObject3);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            kotlin.g.b.s.bIx("trackList");
            localObject1 = null;
          }
          localObject1 = (CharSequence)((boq)((LinkedList)localObject1).get(i)).ZXe;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label526;
          }
          j = 1;
          label502:
          if (j != 0) {
            break label531;
          }
        }
        label526:
        label531:
        for (boolean bool = true;; bool = false)
        {
          paramObject.bq(i, bool);
          i += 1;
          break;
          break label443;
          j = 0;
          break label502;
        }
      }
      paramObject = kotlin.ah.aiuX;
      AppMethodBeat.o(286767);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.d.b.a.k
      implements m<aq, kotlin.d.d<? super List<? extends com.tencent.mm.plugin.vlog.ui.thumb.a>>, Object>
    {
      int label;
      
      a(a parama, kotlin.d.d<? super a> paramd)
      {
        super(paramd);
      }
      
      public final kotlin.d.d<kotlin.ah> create(Object paramObject, kotlin.d.d<?> paramd)
      {
        AppMethodBeat.i(286770);
        paramObject = (kotlin.d.d)new a(this.MbE, paramd);
        AppMethodBeat.o(286770);
        return paramObject;
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        AppMethodBeat.i(286764);
        Object localObject1 = kotlin.d.a.a.aiwj;
        switch (this.label)
        {
        default: 
          paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(286764);
          throw paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        localObject1 = (Iterable)((n)com.tencent.mm.ui.component.k.d(this.MbE.getActivity()).q(n.class)).grd();
        paramObject = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          if (!((com.tencent.mm.plugin.thumbplayer.d.d)localObject2).TBL) {
            paramObject.add(localObject2);
          }
        }
        paramObject = (Iterable)paramObject;
        localObject1 = this.MbE;
        Object localObject2 = (Collection)new ArrayList(p.a(paramObject, 10));
        Iterator localIterator = paramObject.iterator();
        label401:
        if (localIterator.hasNext())
        {
          com.tencent.mm.plugin.thumbplayer.d.d locald = (com.tencent.mm.plugin.thumbplayer.d.d)localIterator.next();
          int i;
          if ((locald.hJv) || (locald.hLc()))
          {
            paramObject = locald.path;
            kotlin.g.b.s.s(paramObject, "mediaInfo.path");
            if (locald.hLc())
            {
              i = 1;
              label245:
              paramObject = new ad(paramObject, i);
              paramObject.wB(locald.TBO);
              paramObject.wC(locald.TBO + locald.TBN);
              paramObject.setStartTimeMs(locald.TBM);
              paramObject.wA(locald.TBM + locald.TBN);
              if (!locald.hLc()) {
                break label401;
              }
              paramObject = (h)new com.tencent.mm.plugin.mv.ui.c.a(paramObject);
            }
          }
          label323:
          for (paramObject = (com.tencent.mm.plugin.vlog.ui.thumb.a)paramObject;; paramObject = (com.tencent.mm.plugin.vlog.ui.thumb.a)new com.tencent.mm.plugin.finder.video.thumb.c((com.tencent.mm.plugin.thumbplayer.a.b)locald))
          {
            paramObject.UoP = locald.TBO;
            long l = locald.TBO;
            paramObject.UoQ = (locald.TBN + l);
            paramObject.width = ((a)localObject1).getResources().getDimensionPixelSize(b.c.Edge_6A);
            paramObject.height = ((a)localObject1).getResources().getDimensionPixelSize(b.c.Edge_6A);
            ((Collection)localObject2).add(paramObject);
            break;
            i = 2;
            break label245;
            paramObject = new h(paramObject);
            break label323;
          }
        }
        paramObject = (List)localObject2;
        AppMethodBeat.o(286764);
        return paramObject;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/free/MusicMvFlexPreviewTrackUIC$thumbLoader$1", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "compositionFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/CompositionTrackThumbFetcherFactory;", "tpFactory", "Lcom/tencent/mm/plugin/finder/video/thumb/TPThumbFetcherFactory;", "createFromTrackInfo", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "trackInfo", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "extra", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements g
  {
    private final com.tencent.mm.plugin.finder.video.thumb.a MbO;
    private final com.tencent.mm.plugin.vlog.ui.thumb.b MbP;
    
    d(AppCompatActivity paramAppCompatActivity)
    {
      AppMethodBeat.i(286771);
      this.MbO = new com.tencent.mm.plugin.finder.video.thumb.a();
      this.MbP = new com.tencent.mm.plugin.vlog.ui.thumb.b();
      AppMethodBeat.o(286771);
    }
    
    public final com.tencent.mm.videocomposition.c a(com.tencent.mm.plugin.vlog.ui.thumb.a parama, Object paramObject)
    {
      Object localObject2 = null;
      AppMethodBeat.i(286796);
      kotlin.g.b.s.u(parama, "trackInfo");
      com.tencent.mm.plugin.finder.video.thumb.a locala;
      com.tencent.mm.plugin.thumbplayer.a.b localb1;
      com.tencent.mm.plugin.thumbplayer.c.b localb;
      int i;
      Object localObject3;
      label120:
      Object localObject1;
      if ((parama instanceof com.tencent.mm.plugin.finder.video.thumb.c))
      {
        locala = this.MbO;
        paramObject = com.tencent.mm.ui.component.k.aeZF;
        paramObject = ((n)com.tencent.mm.ui.component.k.d(this.Awh).q(n.class)).Mci;
        kotlin.g.b.s.checkNotNull(paramObject);
        localb1 = ((com.tencent.mm.plugin.finder.video.thumb.c)parama).GvR;
        kotlin.g.b.s.u(localb1, "mediaInfo");
        localb = paramObject.TGY;
        kotlin.g.b.s.u(localb1, "mediaInfo");
        if (!((Collection)localb.TCS).isEmpty())
        {
          i = 1;
          if (i == 0) {
            break label689;
          }
          localObject3 = ((Iterable)localb.TCS).iterator();
          if (!((Iterator)localObject3).hasNext()) {
            break label474;
          }
          localObject1 = ((Iterator)localObject3).next();
          paramObject = ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1).TEg;
          if (paramObject != null) {
            break label452;
          }
          paramObject = null;
          label154:
          if (!kotlin.g.b.s.p(paramObject, localb1.mediaId)) {
            break label472;
          }
          paramObject = localObject1;
          label169:
          paramObject = (com.tencent.mm.plugin.thumbplayer.c.a.a)paramObject;
          if ((paramObject == null) || (!(paramObject instanceof e))) {
            break label689;
          }
          Log.i(localb.TAG, kotlin.g.b.s.X("getThumbFetcherExtraData get from playingPlayer mediaId:", localb1.mediaId));
        }
      }
      label261:
      label298:
      label689:
      for (paramObject = ((e)paramObject).GvH.TFd;; paramObject = null)
      {
        localObject1 = paramObject;
        if (paramObject == null)
        {
          if (((Collection)localb.TCT).isEmpty()) {
            break label479;
          }
          i = 1;
          label239:
          localObject1 = paramObject;
          if (i != 0)
          {
            Iterator localIterator = ((Iterable)localb.TCT).iterator();
            if (!localIterator.hasNext()) {
              break label512;
            }
            localObject3 = localIterator.next();
            localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.a.a)localObject3).TEg;
            if (localObject1 != null) {
              break label484;
            }
            localObject1 = null;
            if (!kotlin.g.b.s.p(localObject1, localb1.mediaId)) {
              break label510;
            }
            localObject1 = localObject3;
            label315:
            localObject3 = (com.tencent.mm.plugin.thumbplayer.c.a.a)localObject1;
            localObject1 = paramObject;
            if (localObject3 != null)
            {
              localObject1 = paramObject;
              if ((localObject3 instanceof e))
              {
                Log.i(localb.TAG, kotlin.g.b.s.X("getThumbFetcherExtraData get from pendingPlayer mediaId:", localb1.mediaId));
                localObject1 = ((e)localObject3).GvH.TFd;
              }
            }
          }
        }
        if (localObject1 == null)
        {
          paramObject = ((List)localb.ofu).iterator();
          i = 0;
          if (paramObject.hasNext()) {
            if (kotlin.g.b.s.p(((com.tencent.mm.plugin.thumbplayer.a.b)paramObject.next()).mediaId, localb1.mediaId))
            {
              if (i >= 0) {
                break label530;
              }
              paramObject = localObject2;
            }
          }
          label452:
          label472:
          label474:
          label479:
          label484:
          label510:
          do
          {
            do
            {
              do
              {
                parama = locala.a(parama, paramObject);
                AppMethodBeat.o(286796);
                return parama;
                i = 0;
                break;
                paramObject = paramObject.GvR;
                if (paramObject == null)
                {
                  paramObject = null;
                  break label154;
                }
                paramObject = paramObject.mediaId;
                break label154;
                break label120;
                paramObject = null;
                break label169;
                i = 0;
                break label239;
                localObject1 = ((com.tencent.mm.plugin.thumbplayer.c.c)localObject1).GvR;
                if (localObject1 == null)
                {
                  localObject1 = null;
                  break label298;
                }
                localObject1 = ((com.tencent.mm.plugin.thumbplayer.a.b)localObject1).mediaId;
                break label298;
                break label261;
                localObject1 = null;
                break label315;
                i += 1;
                break label393;
                i = -1;
                break label425;
                localObject3 = localb.TCV;
                paramObject = localObject2;
              } while (localObject3 == null);
              paramObject = localObject2;
            } while (i >= ((com.tencent.mm.plugin.thumbplayer.c.d)localObject3).TDz.size());
            Log.i(localb.TAG, "getThumbFetcherExtraData try create new one index:" + i + ", mediaId:" + localb1.mediaId);
            paramObject = ((com.tencent.mm.plugin.thumbplayer.c.d)localObject3).TDz.get(i);
            kotlin.g.b.s.s(paramObject, "composition.trackList[index]");
            localObject3 = localb.a((com.tencent.mm.plugin.thumbplayer.c.c)paramObject);
            paramObject = localObject2;
          } while (localObject3 == null);
          localb.TCU.add(localObject3);
          if (!(localObject3 instanceof e)) {}
        }
        for (paramObject = ((e)localObject3).GvH.TFd;; paramObject = localObject1)
        {
          break;
          parama = this.MbP.a(parama, paramObject);
          AppMethodBeat.o(286796);
          return parama;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.free.a
 * JD-Core Version:    0.7.0.1
 */