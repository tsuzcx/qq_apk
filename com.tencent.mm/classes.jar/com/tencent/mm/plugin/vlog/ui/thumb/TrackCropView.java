package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.r;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "playWaitIdle", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "seekSlider", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "seekSliderReady", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "setEnableLengthEdit", "", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TrackCropView
  extends FrameLayout
{
  private boolean AtG;
  private final b Atw;
  private int Aty;
  private final SliderSeekBar Ave;
  private long Avf;
  private long Avg;
  private long Avh;
  private float Avi;
  private int Avj;
  private int Avk;
  private final d Avl;
  private final d Avm;
  private int Avn;
  private int Avo;
  private Runnable Avp;
  private boolean Avq;
  private final SliderSeekBar.a Avr;
  private a Avs;
  private final String TAG;
  private long duration;
  private final RecyclerView fTr;
  private long gLX;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  private final LinearLayoutManager ylx;
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(207943);
    AppMethodBeat.o(207943);
  }
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(207942);
    this.TAG = "MicroMsg.TrackCropView";
    this.thumbHeight = 112;
    this.thumbWidth = 80;
    this.Aty = 1;
    this.Avh = 1L;
    this.Avi = 1.0F;
    paramAttributeSet = d.AvE;
    this.Avl = d.a.egv();
    paramAttributeSet = d.AvE;
    this.Avm = d.a.egv();
    View.inflate(paramContext, 2131496278, (ViewGroup)this);
    paramContext = findViewById(2131308041);
    k.g(paramContext, "findViewById(R.id.track_crop_thumb_recycler)");
    this.fTr = ((RecyclerView)paramContext);
    paramContext = findViewById(2131308040);
    k.g(paramContext, "findViewById(R.id.track_crop_slider_seek)");
    this.Ave = ((SliderSeekBar)paramContext);
    this.Ave.setMaskColor(1999383596);
    this.Ave.setEnableHapticAtEdge(true);
    this.ylx = new LinearLayoutManager(0);
    this.fTr.setLayoutManager((RecyclerView.i)this.ylx);
    this.Atw = new b();
    this.fTr.setAdapter((RecyclerView.a)this.Atw);
    this.fTr.setItemAnimator(null);
    this.fTr.a((RecyclerView.m)new RecyclerView.m()
    {
      private boolean AtL;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(207931);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt1);
        localb.lS(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.aeE());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        TrackCropView.t(this.Avt);
        ac.i(TrackCropView.s(this.Avt), "onScroll: range: " + TrackCropView.m(this.Avt) + ", " + TrackCropView.n(this.Avt));
        paramAnonymousRecyclerView = this.Avt.getCallback();
        if (paramAnonymousRecyclerView != null) {
          paramAnonymousRecyclerView.seekTo(TrackCropView.m(this.Avt));
        }
        this.Avt.setProgress(TrackCropView.m(this.Avt));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(207931);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(207930);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bb(paramAnonymousRecyclerView);
        localb.lS(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.aeE());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        ac.i(TrackCropView.s(this.Avt), "onScrollStateChanged: ".concat(String.valueOf(paramAnonymousInt)));
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          TrackCropView.t(this.Avt);
          ac.i(TrackCropView.s(this.Avt), "onScrollStateChanged: " + TrackCropView.m(this.Avt) + ", " + TrackCropView.n(this.Avt));
          paramAnonymousRecyclerView = this.Avt.getCallback();
          if (paramAnonymousRecyclerView != null) {
            paramAnonymousRecyclerView.ap(TrackCropView.m(this.Avt), TrackCropView.n(this.Avt));
          }
          TrackCropView.a(this.Avt, false);
          this.AtL = false;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(207930);
          return;
          if (paramAnonymousInt == 1)
          {
            if (!this.AtL)
            {
              paramAnonymousRecyclerView = this.Avt;
              paramAnonymousRecyclerView.setDragCnt(paramAnonymousRecyclerView.getDragCnt() + 1);
            }
            this.AtL = true;
          }
        }
      }
    });
    this.fTr.a((RecyclerView.l)new RecyclerView.r()
    {
      public final boolean a(RecyclerView paramAnonymousRecyclerView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207932);
        k.h(paramAnonymousRecyclerView, "rv");
        k.h(paramAnonymousMotionEvent, "e");
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(207932);
          return false;
          paramAnonymousRecyclerView = this.Avt.getCallback();
          if (paramAnonymousRecyclerView != null)
          {
            paramAnonymousRecyclerView.pause();
            continue;
            if (TrackCropView.a(this.Avt).getScrollState() == 0)
            {
              TrackCropView.t(this.Avt);
              ac.i(TrackCropView.s(this.Avt), "onInterceptTouchEvent crop: " + TrackCropView.m(this.Avt) + ", " + TrackCropView.n(this.Avt));
              paramAnonymousRecyclerView = this.Avt.getCallback();
              if (paramAnonymousRecyclerView != null) {
                paramAnonymousRecyclerView.ap(TrackCropView.m(this.Avt), TrackCropView.n(this.Avt));
              }
              TrackCropView.a(this.Avt, false);
            }
            else
            {
              TrackCropView.a(this.Avt, true);
            }
          }
        }
      }
    });
    this.Avr = ((SliderSeekBar.a)new SliderSeekBar.a()
    {
      public final void del()
      {
        AppMethodBeat.i(207933);
        TrackCropView.a locala = this.Avt.getCallback();
        if (locala != null)
        {
          locala.pause();
          AppMethodBeat.o(207933);
          return;
        }
        AppMethodBeat.o(207933);
      }
      
      public final void dem()
      {
        AppMethodBeat.i(207934);
        Object localObject = this.Avt;
        ((TrackCropView)localObject).setCutCnt(((TrackCropView)localObject).getCutCnt() + 1);
        TrackCropView.t(this.Avt);
        ac.i(TrackCropView.s(this.Avt), "onScrollStateChanged: " + TrackCropView.m(this.Avt) + ", " + TrackCropView.n(this.Avt));
        localObject = this.Avt.getCallback();
        if (localObject != null)
        {
          ((TrackCropView.a)localObject).ap(TrackCropView.m(this.Avt), TrackCropView.n(this.Avt));
          AppMethodBeat.o(207934);
          return;
        }
        AppMethodBeat.o(207934);
      }
      
      public final void ob(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(207935);
        TrackCropView.t(this.Avt);
        ac.i(TrackCropView.s(this.Avt), "onMove: " + paramAnonymousBoolean + ", " + TrackCropView.m(this.Avt) + ", " + TrackCropView.n(this.Avt));
        if (paramAnonymousBoolean)
        {
          locala = this.Avt.getCallback();
          if (locala != null) {
            locala.seekTo(TrackCropView.m(this.Avt));
          }
          this.Avt.setProgress(TrackCropView.m(this.Avt));
          AppMethodBeat.o(207935);
          return;
        }
        TrackCropView.a locala = this.Avt.getCallback();
        if (locala != null) {
          locala.seekTo(TrackCropView.n(this.Avt));
        }
        this.Avt.setProgress(TrackCropView.n(this.Avt));
        AppMethodBeat.o(207935);
      }
    });
    this.Ave.setOnSliderTouchListener(this.Avr);
    AppMethodBeat.o(207942);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(207941);
    Object localObject1 = null;
    int j = this.fTr.getChildCount();
    int i = 0;
    Object localObject2;
    long l;
    if (i < j)
    {
      localObject2 = this.fTr.getChildAt(i);
      if ((localObject2 instanceof FrameListView))
      {
        int k = RecyclerView.bw((View)localObject2);
        localObject1 = localObject2;
        if (k >= 0)
        {
          localObject1 = localObject2;
          if (k < this.Atw.getItemCount()) {
            l = this.Atw.RS(k).AnN.bvf;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(207941);
        return 0L;
        i += 1;
        break;
      }
      l = (((View)localObject2).getLeft() / this.Avi + (float)l);
      AppMethodBeat.o(207941);
      return l;
      l = 0L;
      localObject2 = localObject1;
    }
  }
  
  public final a getCallback()
  {
    return this.Avs;
  }
  
  public final int getCutCnt()
  {
    return this.Avo;
  }
  
  public final int getDragCnt()
  {
    return this.Avn;
  }
  
  public final void setCallback(a parama)
  {
    this.Avs = parama;
  }
  
  public final void setCutCnt(int paramInt)
  {
    this.Avo = paramInt;
  }
  
  public final void setDragCnt(int paramInt)
  {
    this.Avn = paramInt;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(207938);
    if (paramBoolean)
    {
      this.Ave.deo();
      AppMethodBeat.o(207938);
      return;
    }
    this.Ave.den();
    AppMethodBeat.o(207938);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(207940);
    float f = this.padding / this.Avi;
    this.Ave.setCursorPos((float)(getScrollTime() + paramLong) / (f * 2.0F + (float)this.Avf));
    AppMethodBeat.o(207940);
  }
  
  public final void setTrack(r paramr)
  {
    long l = 60000L;
    AppMethodBeat.i(207939);
    k.h(paramr, "composition");
    this.Avn = 0;
    this.Avo = 0;
    final LinkedList localLinkedList = new LinkedList();
    this.Aty = 0;
    this.gLX = 0L;
    this.duration = paramr.efz();
    Object localObject1 = paramr.efA();
    if (this.duration > 60000L) {}
    for (;;)
    {
      this.Avf = l;
      this.Avg = (((CMTimeRange)localObject1).getStartUs() / 1000L);
      this.Avh = (((CMTimeRange)localObject1).getEndUs() / 1000L);
      localObject1 = (Iterable)paramr.AnT;
      paramr = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fOc();
        }
        localObject2 = new d((u)localObject2);
        ((d)localObject2).trackIndex = i;
        ((d)localObject2).height = this.thumbHeight;
        ((d)localObject2).width = this.thumbWidth;
        paramr.add(localObject2);
        i += 1;
      }
      l = this.duration;
    }
    localLinkedList.addAll((Collection)paramr);
    if (localLinkedList.size() == 1) {
      localLinkedList.get(0);
    }
    this.Avq = false;
    this.Avp = ((Runnable)new b(this, localLinkedList));
    paramr = this.Avp;
    if (paramr != null)
    {
      paramr.run();
      AppMethodBeat.o(207939);
      return;
    }
    AppMethodBeat.o(207939);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "", "onCrop", "", "start", "", "end", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void ap(long paramLong1, long paramLong2);
    
    public abstract void pause();
    
    public abstract void seekTo(long paramLong);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(TrackCropView paramTrackCropView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(207937);
      if (TrackCropView.a(this.Avt).getWidth() <= 0)
      {
        TrackCropView.a(this.Avt).post(TrackCropView.b(this.Avt));
        AppMethodBeat.o(207937);
        return;
      }
      TrackCropView.a(this.Avt, com.tencent.mm.cc.a.fromDPToPix(this.Avt.getContext(), 40));
      float f = TrackCropView.a(this.Avt).getHeight() * 1.0F / TrackCropView.d(this.Avt);
      TrackCropView.b(this.Avt, TrackCropView.a(this.Avt).getWidth() - TrackCropView.c(this.Avt) * 2);
      TrackCropView.a(this.Avt, TrackCropView.e(this.Avt) * 1.0F / (float)TrackCropView.g(this.Avt));
      TrackCropView.c(this.Avt, (int)(TrackCropView.f(this.Avt) * (float)TrackCropView.i(this.Avt)));
      f = TrackCropView.h(this.Avt) / (f * TrackCropView.j(this.Avt));
      Iterator localIterator = ((Iterable)localLinkedList).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        locald.AvA = (f / (float)TrackCropView.i(this.Avt) * (float)locald.egs());
        locald.egt();
      }
      TrackCropView.k(this.Avt).grV = TrackCropView.c(this.Avt);
      TrackCropView.l(this.Avt).grV = TrackCropView.c(this.Avt);
      final int i = Math.max(0, Math.min((int)((float)TrackCropView.m(this.Avt) * TrackCropView.f(this.Avt)), (int)((float)TrackCropView.n(this.Avt) * TrackCropView.f(this.Avt) - TrackCropView.e(this.Avt))));
      TrackCropView.o(this.Avt).af(0, -i);
      localLinkedList.add(0, TrackCropView.k(this.Avt));
      localLinkedList.add(TrackCropView.l(this.Avt));
      TrackCropView.p(this.Avt).gf((List)localLinkedList);
      TrackCropView.p(this.Avt).notifyDataSetChanged();
      TrackCropView.q(this.Avt).aj(TrackCropView.a(this.Avt).getWidth() - TrackCropView.c(this.Avt) * 2, (int)((float)this.Avv * TrackCropView.f(this.Avt)), TrackCropView.c(this.Avt));
      TrackCropView.q(this.Avt).setCursorPos(0.0F);
      TrackCropView.q(this.Avt).post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207936);
          TrackCropView.q(this.Avw.Avt).b(true, TrackCropView.c(this.Avw.Avt) + (float)TrackCropView.m(this.Avw.Avt) * TrackCropView.f(this.Avw.Avt) - i);
          TrackCropView.q(this.Avw.Avt).b(false, TrackCropView.c(this.Avw.Avt) + (float)TrackCropView.n(this.Avw.Avt) * TrackCropView.f(this.Avw.Avt) - i);
          TrackCropView.r(this.Avw.Avt);
          AppMethodBeat.o(207936);
        }
      });
      AppMethodBeat.o(207937);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView
 * JD-Core Version:    0.7.0.1
 */