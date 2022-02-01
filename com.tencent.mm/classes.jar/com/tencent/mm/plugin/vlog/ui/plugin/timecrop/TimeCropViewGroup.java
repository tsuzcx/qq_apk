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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.c;
import com.tencent.mm.plugin.vlog.ui.thumb.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "realTimeCallback", "getRealTimeCallback", "setRealTimeCallback", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TimeCropViewGroup
  extends FrameLayout
{
  private com.tencent.mm.plugin.vlog.ui.thumb.b BOH;
  private int BOK;
  private float BOP;
  private Runnable BOQ;
  private final c BOS;
  private TimeCropSliderSeekBar BRF;
  private long BRG;
  private long BRH;
  private long BRI;
  private int BRJ;
  private int BRK;
  private final c BRL;
  private int BRM;
  private int BRN;
  private TimeCropSliderSeekBar.a BRO;
  private TimeCropViewGroup.a BRP;
  private TimeCropViewGroup.a BRQ;
  private final String TAG;
  private long duration;
  private RecyclerView gmV;
  private long hfU;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  private LinearLayoutManager zCm;
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(196637);
    AppMethodBeat.o(196637);
  }
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196636);
    this.TAG = "MicroMsg.TrackCropView";
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.BOK = 1;
    this.BRI = 1L;
    this.BOP = 1.0F;
    paramContext = c.BUN;
    this.BRL = c.a.euf();
    paramContext = c.BUN;
    this.BOS = c.a.euf();
    AppMethodBeat.o(196636);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(196635);
    Object localObject = null;
    RecyclerView localRecyclerView = this.gmV;
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
            com.tencent.mm.plugin.vlog.ui.thumb.b localb = this.BOH;
            if (localb == null) {
              p.gfZ();
            }
            localObject = localView;
            if (k < localb.getItemCount())
            {
              localObject = this.BOH;
              if (localObject == null) {
                p.gfZ();
              }
              l = ((com.tencent.mm.plugin.vlog.ui.thumb.b)localObject).TK(k).BUL.BGw.startTimeMs;
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
      AppMethodBeat.o(196635);
      return 0L;
      i += 1;
      break;
      l = 0L;
      continue;
      l = 0L;
    }
    label160:
    if (localObject == null) {
      p.gfZ();
    }
    long l = (((View)localObject).getLeft() / this.BOP + (float)l);
    AppMethodBeat.o(196635);
    return l;
  }
  
  public final void a(v paramv, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(196633);
    p.h(paramv, "composition");
    this.BRM = 0;
    this.BRN = 0;
    final LinkedList localLinkedList = new LinkedList();
    this.BOK = 0;
    this.hfU = 0L;
    this.duration = paramv.getDurationMs();
    Object localObject1 = paramv.esb();
    this.BRG = paramv.getDurationMs();
    this.BRH = paramLong1;
    this.BRI = paramLong2;
    if ((paramLong1 < 0L) || (paramLong2 < 0L))
    {
      this.BRH = (((CMTimeRange)localObject1).getStartUs() / 1000L);
      this.BRI = (((CMTimeRange)localObject1).getEndUs() / 1000L);
    }
    localObject1 = (Iterable)paramv.esg();
    paramv = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.gfB();
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
    this.BOQ = ((Runnable)new c(this, localLinkedList));
    paramv = this.BOQ;
    if (paramv != null)
    {
      paramv.run();
      AppMethodBeat.o(196633);
      return;
    }
    AppMethodBeat.o(196633);
  }
  
  public final TimeCropViewGroup.a getCallback()
  {
    return this.BRP;
  }
  
  public final int getCutCnt()
  {
    return this.BRN;
  }
  
  public final int getDragCnt()
  {
    return this.BRM;
  }
  
  public final TimeCropViewGroup.a getRealTimeCallback()
  {
    return this.BRQ;
  }
  
  public final TimeCropSliderSeekBar getSeekSlider()
  {
    return this.BRF;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(196630);
    super.onFinishInflate();
    this.gmV = ((RecyclerView)findViewById(2131308041));
    this.BRF = ((TimeCropSliderSeekBar)findViewById(2131308040));
    Object localObject = this.BRF;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.BRF;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    getContext();
    this.zCm = new LinearLayoutManager(0);
    localObject = this.gmV;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)this.zCm);
    }
    this.BOH = new com.tencent.mm.plugin.vlog.ui.thumb.b();
    localObject = this.BOH;
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.ui.thumb.b)localObject).BUb = true;
    }
    localObject = this.gmV;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.BOH);
    }
    localObject = this.gmV;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemAnimator(null);
    }
    this.BRO = ((TimeCropSliderSeekBar.a)new b(this));
    localObject = this.BRF;
    if (localObject != null)
    {
      ((TimeCropSliderSeekBar)localObject).setOnSliderTouchListener(this.BRO);
      AppMethodBeat.o(196630);
      return;
    }
    AppMethodBeat.o(196630);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(196631);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ad.i(this.TAG, "onLayout");
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.BRF;
    RecyclerView localRecyclerView;
    if (localTimeCropSliderSeekBar != null)
    {
      localRecyclerView = this.gmV;
      if (localRecyclerView == null) {
        break label108;
      }
    }
    label108:
    for (paramInt1 = localRecyclerView.getTop();; paramInt1 = 0)
    {
      localTimeCropSliderSeekBar.setContentTop(paramInt1);
      localTimeCropSliderSeekBar = this.BRF;
      if (localTimeCropSliderSeekBar == null) {
        break;
      }
      localRecyclerView = this.gmV;
      paramInt1 = i;
      if (localRecyclerView != null) {
        paramInt1 = localRecyclerView.getMeasuredHeight();
      }
      localTimeCropSliderSeekBar.setContentHeight(paramInt1);
      AppMethodBeat.o(196631);
      return;
    }
    AppMethodBeat.o(196631);
  }
  
  public final void setCallback(TimeCropViewGroup.a parama)
  {
    this.BRP = parama;
  }
  
  public final void setCutCnt(int paramInt)
  {
    this.BRN = paramInt;
  }
  
  public final void setDragCnt(int paramInt)
  {
    this.BRM = paramInt;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(196632);
    if (paramBoolean)
    {
      localTimeCropSliderSeekBar = this.BRF;
      if (localTimeCropSliderSeekBar != null)
      {
        localTimeCropSliderSeekBar.dnM();
        AppMethodBeat.o(196632);
        return;
      }
      AppMethodBeat.o(196632);
      return;
    }
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.BRF;
    if (localTimeCropSliderSeekBar != null)
    {
      localTimeCropSliderSeekBar.dnL();
      AppMethodBeat.o(196632);
      return;
    }
    AppMethodBeat.o(196632);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(196634);
    float f = this.padding / this.BOP;
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.BRF;
    if (localTimeCropSliderSeekBar != null)
    {
      localTimeCropSliderSeekBar.setCursorPos((float)(getScrollTime() + paramLong) / (f * 2.0F + (float)this.BRG));
      AppMethodBeat.o(196634);
      return;
    }
    AppMethodBeat.o(196634);
  }
  
  public final void setRealTimeCallback(TimeCropViewGroup.a parama)
  {
    this.BRQ = parama;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$onFinishInflate$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
  public static final class b
    implements TimeCropSliderSeekBar.a
  {
    public final void dnK()
    {
      AppMethodBeat.i(196626);
      TimeCropViewGroup.a(this.BRR);
      TimeCropViewGroup.a locala = this.BRR.getCallback();
      if (locala != null)
      {
        locala.f(TimeCropViewGroup.b(this.BRR), TimeCropViewGroup.c(this.BRR), true);
        AppMethodBeat.o(196626);
        return;
      }
      AppMethodBeat.o(196626);
    }
    
    public final void etP()
    {
      AppMethodBeat.i(196627);
      TimeCropViewGroup.a(this.BRR);
      TimeCropViewGroup.a locala = this.BRR.getRealTimeCallback();
      if (locala != null)
      {
        locala.f(TimeCropViewGroup.b(this.BRR), TimeCropViewGroup.c(this.BRR), false);
        AppMethodBeat.o(196627);
        return;
      }
      AppMethodBeat.o(196627);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(TimeCropViewGroup paramTimeCropViewGroup, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(196629);
      Object localObject1 = TimeCropViewGroup.d(this.BRR);
      if (localObject1 != null)
      {
        if (((RecyclerView)localObject1).getWidth() <= 0)
        {
          ((RecyclerView)localObject1).post(TimeCropViewGroup.e(this.BRR));
          AppMethodBeat.o(196629);
          return;
        }
        TimeCropViewGroup.a(this.BRR, a.fromDPToPix(this.BRR.getContext(), 40));
        float f = ((RecyclerView)localObject1).getHeight() * 1.0F / TimeCropViewGroup.g(this.BRR);
        TimeCropViewGroup.b(this.BRR, ((RecyclerView)localObject1).getWidth() - TimeCropViewGroup.f(this.BRR) * 2);
        TimeCropViewGroup.a(this.BRR, TimeCropViewGroup.h(this.BRR) * 1.0F / (float)TimeCropViewGroup.j(this.BRR));
        TimeCropViewGroup.c(this.BRR, (int)(TimeCropViewGroup.i(this.BRR) * (float)TimeCropViewGroup.l(this.BRR)));
        f = TimeCropViewGroup.k(this.BRR) / (f * TimeCropViewGroup.m(this.BRR));
        Object localObject2 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          c localc = (c)((Iterator)localObject2).next();
          localc.BUI = (f / (float)TimeCropViewGroup.l(this.BRR) * (float)localc.euc() / localc.BUL.BGw.llC);
          localc.eud();
        }
        TimeCropViewGroup.n(this.BRR).gLD = TimeCropViewGroup.f(this.BRR);
        TimeCropViewGroup.o(this.BRR).gLD = TimeCropViewGroup.f(this.BRR);
        localLinkedList.add(0, TimeCropViewGroup.n(this.BRR));
        localLinkedList.add(TimeCropViewGroup.o(this.BRR));
        localObject2 = TimeCropViewGroup.p(this.BRR);
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.vlog.ui.thumb.b)localObject2).gq((List)localLinkedList);
        }
        localObject2 = TimeCropViewGroup.p(this.BRR);
        if (localObject2 != null) {
          ((com.tencent.mm.plugin.vlog.ui.thumb.b)localObject2).notifyDataSetChanged();
        }
        localObject2 = this.BRR.getSeekSlider();
        if (localObject2 != null) {
          ((TimeCropSliderSeekBar)localObject2).aj(((RecyclerView)localObject1).getWidth() - TimeCropViewGroup.f(this.BRR) * 2, (int)((float)this.BRT * TimeCropViewGroup.i(this.BRR)), TimeCropViewGroup.f(this.BRR));
        }
        localObject1 = this.BRR.getSeekSlider();
        if (localObject1 != null) {
          ((TimeCropSliderSeekBar)localObject1).setCursorPos(0.0F);
        }
        localObject1 = this.BRR.getSeekSlider();
        if (localObject1 != null)
        {
          ((TimeCropSliderSeekBar)localObject1).post((Runnable)new a(this));
          AppMethodBeat.o(196629);
          return;
        }
        AppMethodBeat.o(196629);
        return;
      }
      AppMethodBeat.o(196629);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$setTrack$2$1$2"})
    static final class a
      implements Runnable
    {
      a(TimeCropViewGroup.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(196628);
        TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.BRU.BRR.getSeekSlider();
        if (localTimeCropSliderSeekBar != null) {
          localTimeCropSliderSeekBar.b(true, TimeCropViewGroup.f(this.BRU.BRR) + (float)TimeCropViewGroup.b(this.BRU.BRR) * TimeCropViewGroup.i(this.BRU.BRR));
        }
        localTimeCropSliderSeekBar = this.BRU.BRR.getSeekSlider();
        if (localTimeCropSliderSeekBar != null)
        {
          localTimeCropSliderSeekBar.b(false, TimeCropViewGroup.f(this.BRU.BRR) + (float)TimeCropViewGroup.c(this.BRU.BRR) * TimeCropViewGroup.i(this.BRU.BRR));
          AppMethodBeat.o(196628);
          return;
        }
        AppMethodBeat.o(196628);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup
 * JD-Core Version:    0.7.0.1
 */