package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.c;
import com.tencent.mm.plugin.vlog.ui.thumb.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "realTimeCallback", "getRealTimeCallback", "setRealTimeCallback", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TimeCropViewGroup
  extends FrameLayout
{
  private com.tencent.mm.plugin.vlog.ui.thumb.b Cgg;
  private int Cgj;
  private float Cgo;
  private Runnable Cgp;
  private final c Cgr;
  private TimeCropSliderSeekBar Cjf;
  private long Cjg;
  private long Cjh;
  private long Cji;
  private int Cjj;
  private int Cjk;
  private final c Cjl;
  private int Cjm;
  private int Cjn;
  private TimeCropSliderSeekBar.a Cjo;
  private a Cjp;
  private a Cjq;
  private final String TAG;
  private long duration;
  private RecyclerView gpr;
  private long hiI;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  private LinearLayoutManager zTo;
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192098);
    AppMethodBeat.o(192098);
  }
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192097);
    this.TAG = "MicroMsg.TrackCropView";
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.Cgj = 1;
    this.Cji = 1L;
    this.Cgo = 1.0F;
    paramContext = c.Cmo;
    this.Cjl = c.a.exL();
    paramContext = c.Cmo;
    this.Cgr = c.a.exL();
    AppMethodBeat.o(192097);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(192096);
    Object localObject = null;
    RecyclerView localRecyclerView = this.gpr;
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
            com.tencent.mm.plugin.vlog.ui.thumb.b localb = this.Cgg;
            if (localb == null) {
              p.gkB();
            }
            localObject = localView;
            if (k < localb.getItemCount())
            {
              localObject = this.Cgg;
              if (localObject == null) {
                p.gkB();
              }
              l = ((com.tencent.mm.plugin.vlog.ui.thumb.b)localObject).Ur(k).Cmm.BXV.startTimeMs;
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
      AppMethodBeat.o(192096);
      return 0L;
      i += 1;
      break;
      l = 0L;
      continue;
      l = 0L;
    }
    label160:
    if (localObject == null) {
      p.gkB();
    }
    long l = (((View)localObject).getLeft() / this.Cgo + (float)l);
    AppMethodBeat.o(192096);
    return l;
  }
  
  public final void a(v paramv, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(192094);
    p.h(paramv, "composition");
    this.Cjm = 0;
    this.Cjn = 0;
    final LinkedList localLinkedList = new LinkedList();
    this.Cgj = 0;
    this.hiI = 0L;
    this.duration = paramv.getDurationMs();
    Object localObject1 = paramv.evI();
    this.Cjg = paramv.getDurationMs();
    this.Cjh = paramLong1;
    this.Cji = paramLong2;
    if ((paramLong1 < 0L) || (paramLong2 < 0L))
    {
      this.Cjh = (((CMTimeRange)localObject1).getStartUs() / 1000L);
      this.Cji = (((CMTimeRange)localObject1).getEndUs() / 1000L);
    }
    localObject1 = (Iterable)paramv.evN();
    paramv = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gkd();
      }
      localObject2 = new c((w)localObject2);
      ((c)localObject2).trackIndex = i;
      ((c)localObject2).height = this.thumbHeight;
      ((c)localObject2).width = this.thumbWidth;
      paramv.add(localObject2);
      i += 1;
    }
    localLinkedList.addAll((Collection)paramv);
    if (localLinkedList.size() == 1) {
      localLinkedList.get(0);
    }
    this.Cgp = ((Runnable)new c(this, localLinkedList));
    paramv = this.Cgp;
    if (paramv != null)
    {
      paramv.run();
      AppMethodBeat.o(192094);
      return;
    }
    AppMethodBeat.o(192094);
  }
  
  public final a getCallback()
  {
    return this.Cjp;
  }
  
  public final int getCutCnt()
  {
    return this.Cjn;
  }
  
  public final int getDragCnt()
  {
    return this.Cjm;
  }
  
  public final a getRealTimeCallback()
  {
    return this.Cjq;
  }
  
  public final TimeCropSliderSeekBar getSeekSlider()
  {
    return this.Cjf;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(192091);
    super.onFinishInflate();
    this.gpr = ((RecyclerView)findViewById(2131308041));
    this.Cjf = ((TimeCropSliderSeekBar)findViewById(2131308040));
    Object localObject = this.Cjf;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.Cjf;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    getContext();
    this.zTo = new LinearLayoutManager(0);
    localObject = this.gpr;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)this.zTo);
    }
    this.Cgg = new com.tencent.mm.plugin.vlog.ui.thumb.b();
    localObject = this.Cgg;
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.thumb.b)localObject).ClC = true;
    }
    localObject = this.gpr;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.Cgg);
    }
    localObject = this.gpr;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemAnimator(null);
    }
    this.Cjo = ((TimeCropSliderSeekBar.a)new b(this));
    localObject = this.Cjf;
    if (localObject != null)
    {
      ((TimeCropSliderSeekBar)localObject).setOnSliderTouchListener(this.Cjo);
      AppMethodBeat.o(192091);
      return;
    }
    AppMethodBeat.o(192091);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(192092);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ae.i(this.TAG, "onLayout");
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.Cjf;
    RecyclerView localRecyclerView;
    if (localTimeCropSliderSeekBar != null)
    {
      localRecyclerView = this.gpr;
      if (localRecyclerView == null) {
        break label108;
      }
    }
    label108:
    for (paramInt1 = localRecyclerView.getTop();; paramInt1 = 0)
    {
      localTimeCropSliderSeekBar.setContentTop(paramInt1);
      localTimeCropSliderSeekBar = this.Cjf;
      if (localTimeCropSliderSeekBar == null) {
        break;
      }
      localRecyclerView = this.gpr;
      paramInt1 = i;
      if (localRecyclerView != null) {
        paramInt1 = localRecyclerView.getMeasuredHeight();
      }
      localTimeCropSliderSeekBar.setContentHeight(paramInt1);
      AppMethodBeat.o(192092);
      return;
    }
    AppMethodBeat.o(192092);
  }
  
  public final void setCallback(a parama)
  {
    this.Cjp = parama;
  }
  
  public final void setCutCnt(int paramInt)
  {
    this.Cjn = paramInt;
  }
  
  public final void setDragCnt(int paramInt)
  {
    this.Cjm = paramInt;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(192093);
    if (paramBoolean)
    {
      localTimeCropSliderSeekBar = this.Cjf;
      if (localTimeCropSliderSeekBar != null)
      {
        localTimeCropSliderSeekBar.dqK();
        AppMethodBeat.o(192093);
        return;
      }
      AppMethodBeat.o(192093);
      return;
    }
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.Cjf;
    if (localTimeCropSliderSeekBar != null)
    {
      localTimeCropSliderSeekBar.dqJ();
      AppMethodBeat.o(192093);
      return;
    }
    AppMethodBeat.o(192093);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(192095);
    float f = this.padding / this.Cgo;
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.Cjf;
    if (localTimeCropSliderSeekBar != null)
    {
      localTimeCropSliderSeekBar.setCursorPos((float)(getScrollTime() + paramLong) / (f * 2.0F + (float)this.Cjg));
      AppMethodBeat.o(192095);
      return;
    }
    AppMethodBeat.o(192095);
  }
  
  public final void setRealTimeCallback(a parama)
  {
    this.Cjq = parama;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void f(long paramLong1, long paramLong2, boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$onFinishInflate$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
  public static final class b
    implements TimeCropSliderSeekBar.a
  {
    public final void dqI()
    {
      AppMethodBeat.i(192087);
      TimeCropViewGroup.a(this.Cjr);
      TimeCropViewGroup.a locala = this.Cjr.getCallback();
      if (locala != null)
      {
        locala.f(TimeCropViewGroup.b(this.Cjr), TimeCropViewGroup.c(this.Cjr), true);
        AppMethodBeat.o(192087);
        return;
      }
      AppMethodBeat.o(192087);
    }
    
    public final void exw()
    {
      AppMethodBeat.i(192088);
      TimeCropViewGroup.a(this.Cjr);
      TimeCropViewGroup.a locala = this.Cjr.getRealTimeCallback();
      if (locala != null)
      {
        locala.f(TimeCropViewGroup.b(this.Cjr), TimeCropViewGroup.c(this.Cjr), false);
        AppMethodBeat.o(192088);
        return;
      }
      AppMethodBeat.o(192088);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(TimeCropViewGroup paramTimeCropViewGroup, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(192090);
      Object localObject1 = TimeCropViewGroup.d(this.Cjr);
      if (localObject1 != null)
      {
        if (((RecyclerView)localObject1).getWidth() <= 0)
        {
          ((RecyclerView)localObject1).post(TimeCropViewGroup.e(this.Cjr));
          AppMethodBeat.o(192090);
          return;
        }
        TimeCropViewGroup.a(this.Cjr, a.fromDPToPix(this.Cjr.getContext(), 40));
        float f = ((RecyclerView)localObject1).getHeight() * 1.0F / TimeCropViewGroup.g(this.Cjr);
        TimeCropViewGroup.b(this.Cjr, ((RecyclerView)localObject1).getWidth() - TimeCropViewGroup.f(this.Cjr) * 2);
        TimeCropViewGroup.a(this.Cjr, TimeCropViewGroup.h(this.Cjr) * 1.0F / (float)TimeCropViewGroup.j(this.Cjr));
        TimeCropViewGroup.c(this.Cjr, (int)(TimeCropViewGroup.i(this.Cjr) * (float)TimeCropViewGroup.l(this.Cjr)));
        f = TimeCropViewGroup.k(this.Cjr) / (f * TimeCropViewGroup.m(this.Cjr));
        Object localObject2 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          c localc = (c)((Iterator)localObject2).next();
          localc.Cmj = (f / (float)TimeCropViewGroup.l(this.Cjr) * (float)localc.exI() / localc.Cmm.BXV.lqb);
          localc.exJ();
        }
        TimeCropViewGroup.n(this.Cjr).gOm = TimeCropViewGroup.f(this.Cjr);
        TimeCropViewGroup.o(this.Cjr).gOm = TimeCropViewGroup.f(this.Cjr);
        localLinkedList.add(0, TimeCropViewGroup.n(this.Cjr));
        localLinkedList.add(TimeCropViewGroup.o(this.Cjr));
        localObject2 = TimeCropViewGroup.p(this.Cjr);
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.vlog.ui.thumb.b)localObject2).gz((List)localLinkedList);
        }
        localObject2 = TimeCropViewGroup.p(this.Cjr);
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.vlog.ui.thumb.b)localObject2).notifyDataSetChanged();
        }
        localObject2 = this.Cjr.getSeekSlider();
        if (localObject2 != null) {
          ((TimeCropSliderSeekBar)localObject2).aj(((RecyclerView)localObject1).getWidth() - TimeCropViewGroup.f(this.Cjr) * 2, (int)((float)this.Cjt * TimeCropViewGroup.i(this.Cjr)), TimeCropViewGroup.f(this.Cjr));
        }
        localObject1 = this.Cjr.getSeekSlider();
        if (localObject1 != null) {
          ((TimeCropSliderSeekBar)localObject1).setCursorPos(0.0F);
        }
        localObject1 = this.Cjr.getSeekSlider();
        if (localObject1 != null)
        {
          ((TimeCropSliderSeekBar)localObject1).post((Runnable)new a(this));
          AppMethodBeat.o(192090);
          return;
        }
        AppMethodBeat.o(192090);
        return;
      }
      AppMethodBeat.o(192090);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$setTrack$2$1$2"})
    static final class a
      implements Runnable
    {
      a(TimeCropViewGroup.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(192089);
        TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.Cju.Cjr.getSeekSlider();
        if (localTimeCropSliderSeekBar != null) {
          localTimeCropSliderSeekBar.b(true, TimeCropViewGroup.f(this.Cju.Cjr) + (float)TimeCropViewGroup.b(this.Cju.Cjr) * TimeCropViewGroup.i(this.Cju.Cjr));
        }
        localTimeCropSliderSeekBar = this.Cju.Cjr.getSeekSlider();
        if (localTimeCropSliderSeekBar != null)
        {
          localTimeCropSliderSeekBar.b(false, TimeCropViewGroup.f(this.Cju.Cjr) + (float)TimeCropViewGroup.c(this.Cju.Cjr) * TimeCropViewGroup.i(this.Cju.Cjr));
          AppMethodBeat.o(192089);
          return;
        }
        AppMethodBeat.o(192089);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup
 * JD-Core Version:    0.7.0.1
 */