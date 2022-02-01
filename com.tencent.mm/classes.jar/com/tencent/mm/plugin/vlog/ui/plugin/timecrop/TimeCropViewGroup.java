package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.f;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.plugin.vlog.ui.thumb.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.b;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "maxCropDuration", "padding", "realTimeCallback", "getRealTimeCallback", "setRealTimeCallback", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TimeCropViewGroup
  extends FrameLayout
{
  private LinearLayoutManager Arh;
  private float Gly;
  private f NzK;
  private TimeCropSliderSeekBar NzL;
  private int NzM;
  private long NzN;
  private long NzO;
  private long NzP;
  private int NzQ;
  private int NzR;
  private final h NzS;
  private final h NzT;
  private int NzU;
  private int NzV;
  private Runnable NzW;
  private TimeCropSliderSeekBar.a NzX;
  private TimeCropViewGroup.a NzY;
  private TimeCropViewGroup.a NzZ;
  private final String TAG;
  private long duration;
  private RecyclerView jLl;
  private long kje;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(224335);
    AppMethodBeat.o(224335);
  }
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(224331);
    this.TAG = "MicroMsg.TrackCropView";
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.NzM = 1;
    this.NzP = 1L;
    this.Gly = 1.0F;
    paramContext = h.NDK;
    this.NzS = h.a.gwz();
    paramContext = h.NDK;
    this.NzT = h.a.gwz();
    AppMethodBeat.o(224331);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(224321);
    Object localObject = null;
    RecyclerView localRecyclerView = this.jLl;
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
          int k = RecyclerView.bh(localView);
          localObject = localView;
          if (k >= 0)
          {
            f localf = this.NzK;
            if (localf == null) {
              p.iCn();
            }
            localObject = localView;
            if (k < localf.getItemCount())
            {
              localObject = this.NzK;
              if (localObject == null) {
                p.iCn();
              }
              l = ((f)localObject).akt(k).getStartTimeMs();
              localObject = localView;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject != null) {
        break label154;
      }
      AppMethodBeat.o(224321);
      return 0L;
      i += 1;
      break;
      l = 0L;
      continue;
      l = 0L;
    }
    label154:
    if (localObject == null) {
      p.iCn();
    }
    long l = (((View)localObject).getLeft() / this.Gly + (float)l);
    AppMethodBeat.o(224321);
    return l;
  }
  
  public final void a(ac paramac, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(224307);
    p.k(paramac, "composition");
    this.NzU = 0;
    this.NzV = 0;
    final LinkedList localLinkedList = new LinkedList();
    this.NzM = 0;
    this.kje = 0L;
    this.duration = paramac.getDurationMs();
    Object localObject1 = paramac.NmT.igH();
    this.NzN = paramac.getDurationMs();
    this.NzO = paramLong1;
    this.NzP = paramLong2;
    if ((paramLong1 < 0L) || (paramLong2 < 0L))
    {
      this.NzO = (((CMTimeRange)localObject1).getStartUs() / 1000L);
      this.NzP = (((CMTimeRange)localObject1).getEndUs() / 1000L);
    }
    localObject1 = (Iterable)paramac.gtA();
    paramac = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = new h((ad)localObject2);
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject2).trackIndex = i;
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject2).height = this.thumbHeight;
      ((com.tencent.mm.plugin.vlog.ui.thumb.a)localObject2).width = this.thumbWidth;
      paramac.add(localObject2);
      i += 1;
    }
    localLinkedList.addAll((Collection)paramac);
    if (localLinkedList.size() == 1) {
      localLinkedList.get(0);
    }
    this.NzW = ((Runnable)new c(this, localLinkedList));
    paramac = this.NzW;
    if (paramac != null)
    {
      paramac.run();
      AppMethodBeat.o(224307);
      return;
    }
    AppMethodBeat.o(224307);
  }
  
  public final TimeCropViewGroup.a getCallback()
  {
    return this.NzY;
  }
  
  public final int getCutCnt()
  {
    return this.NzV;
  }
  
  public final int getDragCnt()
  {
    return this.NzU;
  }
  
  public final TimeCropViewGroup.a getRealTimeCallback()
  {
    return this.NzZ;
  }
  
  public final TimeCropSliderSeekBar getSeekSlider()
  {
    return this.NzL;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(224292);
    super.onFinishInflate();
    this.jLl = ((RecyclerView)findViewById(a.f.track_crop_thumb_recycler));
    this.NzL = ((TimeCropSliderSeekBar)findViewById(a.f.track_crop_slider_seek));
    Object localObject = this.NzL;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.NzL;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    getContext();
    this.Arh = new LinearLayoutManager(0, false);
    localObject = this.jLl;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)this.Arh);
    }
    this.NzK = new f();
    localObject = this.NzK;
    if (localObject != null) {
      ((f)localObject).NCV = true;
    }
    localObject = this.jLl;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.NzK);
    }
    localObject = this.jLl;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemAnimator(null);
    }
    this.NzX = ((TimeCropSliderSeekBar.a)new b(this));
    localObject = this.NzL;
    if (localObject != null)
    {
      ((TimeCropSliderSeekBar)localObject).setOnSliderTouchListener(this.NzX);
      AppMethodBeat.o(224292);
      return;
    }
    AppMethodBeat.o(224292);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(224299);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i(this.TAG, "onLayout");
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.NzL;
    RecyclerView localRecyclerView;
    if (localTimeCropSliderSeekBar != null)
    {
      localRecyclerView = this.jLl;
      if (localRecyclerView == null) {
        break label108;
      }
    }
    label108:
    for (paramInt1 = localRecyclerView.getTop();; paramInt1 = 0)
    {
      localTimeCropSliderSeekBar.setContentTop(paramInt1);
      localTimeCropSliderSeekBar = this.NzL;
      if (localTimeCropSliderSeekBar == null) {
        break;
      }
      localRecyclerView = this.jLl;
      paramInt1 = i;
      if (localRecyclerView != null) {
        paramInt1 = localRecyclerView.getMeasuredHeight();
      }
      localTimeCropSliderSeekBar.setContentHeight(paramInt1);
      AppMethodBeat.o(224299);
      return;
    }
    AppMethodBeat.o(224299);
  }
  
  public final void setCallback(TimeCropViewGroup.a parama)
  {
    this.NzY = parama;
  }
  
  public final void setCutCnt(int paramInt)
  {
    this.NzV = paramInt;
  }
  
  public final void setDragCnt(int paramInt)
  {
    this.NzU = paramInt;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(224301);
    if (paramBoolean)
    {
      localTimeCropSliderSeekBar = this.NzL;
      if (localTimeCropSliderSeekBar != null)
      {
        localTimeCropSliderSeekBar.eUj();
        AppMethodBeat.o(224301);
        return;
      }
      AppMethodBeat.o(224301);
      return;
    }
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.NzL;
    if (localTimeCropSliderSeekBar != null)
    {
      localTimeCropSliderSeekBar.eUi();
      AppMethodBeat.o(224301);
      return;
    }
    AppMethodBeat.o(224301);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(224313);
    float f = this.padding / this.Gly;
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.NzL;
    if (localTimeCropSliderSeekBar != null)
    {
      localTimeCropSliderSeekBar.setCursorPos((float)(getScrollTime() + paramLong) / (f * 2.0F + (float)this.NzN));
      AppMethodBeat.o(224313);
      return;
    }
    AppMethodBeat.o(224313);
  }
  
  public final void setRealTimeCallback(TimeCropViewGroup.a parama)
  {
    this.NzZ = parama;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$onFinishInflate$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
  public static final class b
    implements TimeCropSliderSeekBar.a
  {
    public final void eUh()
    {
      AppMethodBeat.i(225576);
      TimeCropViewGroup.a(this.NAa);
      TimeCropViewGroup.a locala = this.NAa.getCallback();
      if (locala != null)
      {
        locala.d(TimeCropViewGroup.b(this.NAa), TimeCropViewGroup.c(this.NAa), true);
        AppMethodBeat.o(225576);
        return;
      }
      AppMethodBeat.o(225576);
    }
    
    public final void gwh()
    {
      AppMethodBeat.i(225579);
      TimeCropViewGroup.a(this.NAa);
      TimeCropViewGroup.a locala = this.NAa.getRealTimeCallback();
      if (locala != null)
      {
        locala.d(TimeCropViewGroup.b(this.NAa), TimeCropViewGroup.c(this.NAa), false);
        AppMethodBeat.o(225579);
        return;
      }
      AppMethodBeat.o(225579);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(TimeCropViewGroup paramTimeCropViewGroup, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(227659);
      Object localObject1 = TimeCropViewGroup.d(this.NAa);
      if (localObject1 != null)
      {
        if (((RecyclerView)localObject1).getWidth() <= 0)
        {
          ((RecyclerView)localObject1).post(TimeCropViewGroup.e(this.NAa));
          AppMethodBeat.o(227659);
          return;
        }
        TimeCropViewGroup.a(this.NAa, com.tencent.mm.ci.a.fromDPToPix(this.NAa.getContext(), 40));
        float f = ((RecyclerView)localObject1).getHeight() * 1.0F / TimeCropViewGroup.g(this.NAa);
        TimeCropViewGroup.b(this.NAa, ((RecyclerView)localObject1).getWidth() - TimeCropViewGroup.f(this.NAa) * 2);
        TimeCropViewGroup.a(this.NAa, TimeCropViewGroup.h(this.NAa) * 1.0F / (float)TimeCropViewGroup.j(this.NAa));
        TimeCropViewGroup.c(this.NAa, (int)(TimeCropViewGroup.i(this.NAa) * (float)TimeCropViewGroup.l(this.NAa)));
        f = TimeCropViewGroup.k(this.NAa) / (f * TimeCropViewGroup.m(this.NAa));
        Object localObject2 = ((Iterable)localLinkedList).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          h localh = (h)((Iterator)localObject2).next();
          localh.NCl = (f / (float)TimeCropViewGroup.l(this.NAa) * (float)localh.gwv() / localh.NDI.Nng.pvh);
          localh.gww();
        }
        TimeCropViewGroup.n(this.NAa).ksu = TimeCropViewGroup.f(this.NAa);
        TimeCropViewGroup.o(this.NAa).ksu = TimeCropViewGroup.f(this.NAa);
        localLinkedList.add(0, TimeCropViewGroup.n(this.NAa));
        localLinkedList.add(TimeCropViewGroup.o(this.NAa));
        localObject2 = TimeCropViewGroup.p(this.NAa);
        if (localObject2 != null) {
          ((f)localObject2).gg((List)localLinkedList);
        }
        localObject2 = TimeCropViewGroup.p(this.NAa);
        if (localObject2 != null) {
          ((f)localObject2).notifyDataSetChanged();
        }
        localObject2 = this.NAa.getSeekSlider();
        if (localObject2 != null) {
          ((TimeCropSliderSeekBar)localObject2).at(((RecyclerView)localObject1).getWidth() - TimeCropViewGroup.f(this.NAa) * 2, (int)((float)this.NAc * TimeCropViewGroup.i(this.NAa)), TimeCropViewGroup.f(this.NAa));
        }
        localObject1 = this.NAa.getSeekSlider();
        if (localObject1 != null) {
          ((TimeCropSliderSeekBar)localObject1).setCursorPos(0.0F);
        }
        localObject1 = this.NAa.getSeekSlider();
        if (localObject1 != null)
        {
          ((TimeCropSliderSeekBar)localObject1).post((Runnable)new a(this));
          AppMethodBeat.o(227659);
          return;
        }
        AppMethodBeat.o(227659);
        return;
      }
      AppMethodBeat.o(227659);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$setTrack$2$1$2"})
    static final class a
      implements Runnable
    {
      a(TimeCropViewGroup.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(235617);
        TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.NAd.NAa.getSeekSlider();
        if (localTimeCropSliderSeekBar != null) {
          localTimeCropSliderSeekBar.b(true, TimeCropViewGroup.f(this.NAd.NAa) + (float)TimeCropViewGroup.b(this.NAd.NAa) * TimeCropViewGroup.i(this.NAd.NAa));
        }
        localTimeCropSliderSeekBar = this.NAd.NAa.getSeekSlider();
        if (localTimeCropSliderSeekBar != null)
        {
          localTimeCropSliderSeekBar.b(false, TimeCropViewGroup.f(this.NAd.NAa) + (float)TimeCropViewGroup.c(this.NAd.NAa) * TimeCropViewGroup.i(this.NAd.NAa));
          AppMethodBeat.o(235617);
          return;
        }
        AppMethodBeat.o(235617);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup
 * JD-Core Version:    0.7.0.1
 */