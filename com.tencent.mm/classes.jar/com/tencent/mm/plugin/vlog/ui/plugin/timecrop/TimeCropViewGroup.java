package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.f;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.plugin.vlog.ui.thumb.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.d;
import com.tencent.mm.videocomposition.n;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "realTimeCallback", "getRealTimeCallback", "setRealTimeCallback", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TimeCropViewGroup
  extends FrameLayout
{
  private float Avf;
  private f GIX;
  private int GJa;
  private Runnable GJd;
  private final h GJf;
  private TimeCropSliderSeekBar GMg;
  private long GMh;
  private long GMi;
  private long GMj;
  private int GMk;
  private int GMl;
  private final h GMm;
  private int GMn;
  private int GMo;
  private TimeCropSliderSeekBar.a GMp;
  private a GMq;
  private a GMr;
  private final String TAG;
  private long duration;
  private RecyclerView hak;
  private long hwQ;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  private LinearLayoutManager vKp;
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(191823);
    AppMethodBeat.o(191823);
  }
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(191822);
    this.TAG = "MicroMsg.TrackCropView";
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.GJa = 1;
    this.GMj = 1L;
    this.Avf = 1.0F;
    paramContext = h.GQe;
    this.GMm = h.a.fEy();
    paramContext = h.GQe;
    this.GJf = h.a.fEy();
    AppMethodBeat.o(191822);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(191821);
    Object localObject = null;
    RecyclerView localRecyclerView = this.hak;
    int i;
    if (localRecyclerView != null)
    {
      i = 0;
      int j = localRecyclerView.getChildCount();
      localObject = null;
      if (i < j)
      {
        View localView = localRecyclerView.getChildAt(i);
        if ((localView instanceof FrameListView))
        {
          int k = RecyclerView.bw(localView);
          localObject = localView;
          if (k >= 0)
          {
            f localf = this.GIX;
            if (localf == null) {
              p.hyc();
            }
            localObject = localView;
            if (k < localf.getItemCount())
            {
              localObject = this.GIX;
              if (localObject == null) {
                p.hyc();
              }
              l = ((f)localObject).acK(k).GQc.GzA.startTimeMs;
              localObject = localView;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label160;
      }
      AppMethodBeat.o(191821);
      return 0L;
      i += 1;
      break;
      l = 0L;
      continue;
      l = 0L;
    }
    label160:
    if (localObject == null) {
      p.hyc();
    }
    long l = (((View)localObject).getLeft() / this.Avf + (float)l);
    AppMethodBeat.o(191821);
    return l;
  }
  
  public final void a(ac paramac, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191819);
    p.h(paramac, "composition");
    this.GMn = 0;
    this.GMo = 0;
    final LinkedList localLinkedList = new LinkedList();
    this.GJa = 0;
    this.hwQ = 0L;
    this.duration = paramac.getDurationMs();
    Object localObject1 = paramac.Gez.hfo();
    this.GMh = paramac.getDurationMs();
    this.GMi = paramLong1;
    this.GMj = paramLong2;
    if ((paramLong1 < 0L) || (paramLong2 < 0L))
    {
      this.GMi = (((CMTimeRange)localObject1).getStartUs() / 1000L);
      this.GMj = (((CMTimeRange)localObject1).getEndUs() / 1000L);
    }
    localObject1 = (Iterable)paramac.fBD();
    paramac = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.hxH();
      }
      localObject2 = new h((ad)localObject2);
      ((h)localObject2).trackIndex = i;
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject2).height = this.thumbHeight;
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject2).width = this.thumbWidth;
      paramac.add(localObject2);
      i += 1;
    }
    localLinkedList.addAll((Collection)paramac);
    if (localLinkedList.size() == 1) {
      localLinkedList.get(0);
    }
    this.GJd = ((Runnable)new c(this, localLinkedList));
    paramac = this.GJd;
    if (paramac != null)
    {
      paramac.run();
      AppMethodBeat.o(191819);
      return;
    }
    AppMethodBeat.o(191819);
  }
  
  public final a getCallback()
  {
    return this.GMq;
  }
  
  public final int getCutCnt()
  {
    return this.GMo;
  }
  
  public final int getDragCnt()
  {
    return this.GMn;
  }
  
  public final a getRealTimeCallback()
  {
    return this.GMr;
  }
  
  public final TimeCropSliderSeekBar getSeekSlider()
  {
    return this.GMg;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(191816);
    super.onFinishInflate();
    this.hak = ((RecyclerView)findViewById(2131309378));
    this.GMg = ((TimeCropSliderSeekBar)findViewById(2131309377));
    Object localObject = this.GMg;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.GMg;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    getContext();
    this.vKp = new LinearLayoutManager(0, false);
    localObject = this.hak;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)this.vKp);
    }
    this.GIX = new f();
    localObject = this.GIX;
    if (localObject != null) {
      ((f)localObject).GPp = true;
    }
    localObject = this.hak;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.GIX);
    }
    localObject = this.hak;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemAnimator(null);
    }
    this.GMp = ((TimeCropSliderSeekBar.a)new b(this));
    localObject = this.GMg;
    if (localObject != null)
    {
      ((TimeCropSliderSeekBar)localObject).setOnSliderTouchListener(this.GMp);
      AppMethodBeat.o(191816);
      return;
    }
    AppMethodBeat.o(191816);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(191817);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i(this.TAG, "onLayout");
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.GMg;
    RecyclerView localRecyclerView;
    if (localTimeCropSliderSeekBar != null)
    {
      localRecyclerView = this.hak;
      if (localRecyclerView == null) {
        break label108;
      }
    }
    label108:
    for (paramInt1 = localRecyclerView.getTop();; paramInt1 = 0)
    {
      localTimeCropSliderSeekBar.setContentTop(paramInt1);
      localTimeCropSliderSeekBar = this.GMg;
      if (localTimeCropSliderSeekBar == null) {
        break;
      }
      localRecyclerView = this.hak;
      paramInt1 = i;
      if (localRecyclerView != null) {
        paramInt1 = localRecyclerView.getMeasuredHeight();
      }
      localTimeCropSliderSeekBar.setContentHeight(paramInt1);
      AppMethodBeat.o(191817);
      return;
    }
    AppMethodBeat.o(191817);
  }
  
  public final void setCallback(a parama)
  {
    this.GMq = parama;
  }
  
  public final void setCutCnt(int paramInt)
  {
    this.GMo = paramInt;
  }
  
  public final void setDragCnt(int paramInt)
  {
    this.GMn = paramInt;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(191818);
    if (paramBoolean)
    {
      localTimeCropSliderSeekBar = this.GMg;
      if (localTimeCropSliderSeekBar != null)
      {
        localTimeCropSliderSeekBar.ekB();
        AppMethodBeat.o(191818);
        return;
      }
      AppMethodBeat.o(191818);
      return;
    }
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.GMg;
    if (localTimeCropSliderSeekBar != null)
    {
      localTimeCropSliderSeekBar.ekA();
      AppMethodBeat.o(191818);
      return;
    }
    AppMethodBeat.o(191818);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(191820);
    float f = this.padding / this.Avf;
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.GMg;
    if (localTimeCropSliderSeekBar != null)
    {
      localTimeCropSliderSeekBar.setCursorPos((float)(getScrollTime() + paramLong) / (f * 2.0F + (float)this.GMh));
      AppMethodBeat.o(191820);
      return;
    }
    AppMethodBeat.o(191820);
  }
  
  public final void setRealTimeCallback(a parama)
  {
    this.GMr = parama;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void d(long paramLong1, long paramLong2, boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$onFinishInflate$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
  public static final class b
    implements TimeCropSliderSeekBar.a
  {
    public final void ekz()
    {
      AppMethodBeat.i(191812);
      TimeCropViewGroup.a(this.GMs);
      TimeCropViewGroup.a locala = this.GMs.getCallback();
      if (locala != null)
      {
        locala.d(TimeCropViewGroup.b(this.GMs), TimeCropViewGroup.c(this.GMs), true);
        AppMethodBeat.o(191812);
        return;
      }
      AppMethodBeat.o(191812);
    }
    
    public final void fEi()
    {
      AppMethodBeat.i(191813);
      TimeCropViewGroup.a(this.GMs);
      TimeCropViewGroup.a locala = this.GMs.getRealTimeCallback();
      if (locala != null)
      {
        locala.d(TimeCropViewGroup.b(this.GMs), TimeCropViewGroup.c(this.GMs), false);
        AppMethodBeat.o(191813);
        return;
      }
      AppMethodBeat.o(191813);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(TimeCropViewGroup paramTimeCropViewGroup, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(191815);
      Object localObject1 = TimeCropViewGroup.d(this.GMs);
      if (localObject1 != null)
      {
        if (((RecyclerView)localObject1).getWidth() <= 0)
        {
          ((RecyclerView)localObject1).post(TimeCropViewGroup.e(this.GMs));
          AppMethodBeat.o(191815);
          return;
        }
        TimeCropViewGroup.a(this.GMs, com.tencent.mm.cb.a.fromDPToPix(this.GMs.getContext(), 40));
        float f = ((RecyclerView)localObject1).getHeight() * 1.0F / TimeCropViewGroup.g(this.GMs);
        TimeCropViewGroup.b(this.GMs, ((RecyclerView)localObject1).getWidth() - TimeCropViewGroup.f(this.GMs) * 2);
        TimeCropViewGroup.a(this.GMs, TimeCropViewGroup.h(this.GMs) * 1.0F / (float)TimeCropViewGroup.j(this.GMs));
        TimeCropViewGroup.c(this.GMs, (int)(TimeCropViewGroup.i(this.GMs) * (float)TimeCropViewGroup.l(this.GMs)));
        f = TimeCropViewGroup.k(this.GMs) / (f * TimeCropViewGroup.m(this.GMs));
        Object localObject2 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          h localh = (h)((Iterator)localObject2).next();
          localh.GOF = (f / (float)TimeCropViewGroup.l(this.GMs) * (float)localh.fEu() / localh.GQc.GzA.mwH);
          localh.fEv();
        }
        TimeCropViewGroup.n(this.GMs).hEp = TimeCropViewGroup.f(this.GMs);
        TimeCropViewGroup.o(this.GMs).hEp = TimeCropViewGroup.f(this.GMs);
        localLinkedList.add(0, TimeCropViewGroup.n(this.GMs));
        localLinkedList.add(TimeCropViewGroup.o(this.GMs));
        localObject2 = TimeCropViewGroup.p(this.GMs);
        if (localObject2 != null) {
          ((f)localObject2).hw((List)localLinkedList);
        }
        localObject2 = TimeCropViewGroup.p(this.GMs);
        if (localObject2 != null) {
          ((f)localObject2).notifyDataSetChanged();
        }
        localObject2 = this.GMs.getSeekSlider();
        if (localObject2 != null) {
          ((TimeCropSliderSeekBar)localObject2).ao(((RecyclerView)localObject1).getWidth() - TimeCropViewGroup.f(this.GMs) * 2, (int)((float)this.GMu * TimeCropViewGroup.i(this.GMs)), TimeCropViewGroup.f(this.GMs));
        }
        localObject1 = this.GMs.getSeekSlider();
        if (localObject1 != null) {
          ((TimeCropSliderSeekBar)localObject1).setCursorPos(0.0F);
        }
        localObject1 = this.GMs.getSeekSlider();
        if (localObject1 != null)
        {
          ((TimeCropSliderSeekBar)localObject1).post((Runnable)new a(this));
          AppMethodBeat.o(191815);
          return;
        }
        AppMethodBeat.o(191815);
        return;
      }
      AppMethodBeat.o(191815);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$setTrack$2$1$2"})
    static final class a
      implements Runnable
    {
      a(TimeCropViewGroup.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(191814);
        TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.GMv.GMs.getSeekSlider();
        if (localTimeCropSliderSeekBar != null) {
          localTimeCropSliderSeekBar.b(true, TimeCropViewGroup.f(this.GMv.GMs) + (float)TimeCropViewGroup.b(this.GMv.GMs) * TimeCropViewGroup.i(this.GMv.GMs));
        }
        localTimeCropSliderSeekBar = this.GMv.GMs.getSeekSlider();
        if (localTimeCropSliderSeekBar != null)
        {
          localTimeCropSliderSeekBar.b(false, TimeCropViewGroup.f(this.GMv.GMs) + (float)TimeCropViewGroup.c(this.GMv.GMs) * TimeCropViewGroup.i(this.GMv.GMs));
          AppMethodBeat.o(191814);
          return;
        }
        AppMethodBeat.o(191814);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup
 * JD-Core Version:    0.7.0.1
 */