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
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "playWaitIdle", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "seekSliderReady", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TrackCropView
  extends FrameLayout
{
  private b BOH;
  private int BOK;
  private float BOP;
  private Runnable BOQ;
  private final c BOS;
  private boolean BOX;
  private long BRG;
  private long BRH;
  private long BRI;
  private int BRJ;
  private int BRK;
  private final c BRL;
  private int BRM;
  private int BRN;
  private boolean BUA;
  private SliderSeekBar.a BUB;
  private a BUC;
  private SliderSeekBar BUz;
  private final String TAG;
  private long duration;
  private RecyclerView gmV;
  private long hfU;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  private LinearLayoutManager zCm;
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(196871);
    AppMethodBeat.o(196871);
  }
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(196870);
    this.TAG = "MicroMsg.TrackCropView";
    this.zCm = new LinearLayoutManager(0);
    this.BOH = new b();
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.BOK = 1;
    this.BRI = 1L;
    this.BOP = 1.0F;
    paramContext = c.BUN;
    this.BRL = c.a.euf();
    paramContext = c.BUN;
    this.BOS = c.a.euf();
    AppMethodBeat.o(196870);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(196869);
    Object localObject1 = null;
    Object localObject2 = this.gmV;
    if (localObject2 == null) {
      p.bcb("recyclerView");
    }
    int j = ((RecyclerView)localObject2).getChildCount();
    int i = 0;
    long l;
    if (i < j)
    {
      localObject2 = this.gmV;
      if (localObject2 == null) {
        p.bcb("recyclerView");
      }
      localObject2 = ((RecyclerView)localObject2).getChildAt(i);
      if ((localObject2 instanceof FrameListView))
      {
        if (this.gmV == null) {
          p.bcb("recyclerView");
        }
        int k = RecyclerView.bw((View)localObject2);
        localObject1 = localObject2;
        if (k >= 0)
        {
          localObject1 = localObject2;
          if (k < this.BOH.getItemCount()) {
            l = this.BOH.TK(k).BUL.BGw.startTimeMs;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(196869);
        return 0L;
        i += 1;
        break;
      }
      l = (-((View)localObject2).getLeft() / this.BOP + (float)l);
      AppMethodBeat.o(196869);
      return l;
      l = 0L;
      localObject2 = localObject1;
    }
  }
  
  public final a getCallback()
  {
    return this.BUC;
  }
  
  public final int getCutCnt()
  {
    return this.BRN;
  }
  
  public final int getDragCnt()
  {
    return this.BRM;
  }
  
  public final SliderSeekBar getSeekSlider()
  {
    return this.BUz;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(196865);
    super.onFinishInflate();
    Object localObject = findViewById(2131308041);
    p.g(localObject, "findViewById(R.id.track_crop_thumb_recycler)");
    this.gmV = ((RecyclerView)localObject);
    this.BUz = ((SliderSeekBar)findViewById(2131308040));
    localObject = this.BUz;
    if (localObject != null) {
      ((SliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.BUz;
    if (localObject != null) {
      ((SliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    localObject = this.gmV;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)this.zCm);
    localObject = this.gmV;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.BOH);
    localObject = this.gmV;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((RecyclerView)localObject).setItemAnimator(null);
    localObject = this.gmV;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.m)new b(this));
    localObject = this.gmV;
    if (localObject == null) {
      p.bcb("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.l)new c(this));
    this.BUB = ((SliderSeekBar.a)new d(this));
    localObject = this.BUz;
    if (localObject != null)
    {
      ((SliderSeekBar)localObject).setOnSliderTouchListener(this.BUB);
      AppMethodBeat.o(196865);
      return;
    }
    AppMethodBeat.o(196865);
  }
  
  public final void setCallback(a parama)
  {
    this.BUC = parama;
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
    AppMethodBeat.i(196866);
    if (paramBoolean)
    {
      localSliderSeekBar = this.BUz;
      if (localSliderSeekBar != null)
      {
        localSliderSeekBar.dnM();
        AppMethodBeat.o(196866);
        return;
      }
      AppMethodBeat.o(196866);
      return;
    }
    SliderSeekBar localSliderSeekBar = this.BUz;
    if (localSliderSeekBar != null)
    {
      localSliderSeekBar.dnL();
      AppMethodBeat.o(196866);
      return;
    }
    AppMethodBeat.o(196866);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(196868);
    float f = this.padding / this.BOP;
    SliderSeekBar localSliderSeekBar = this.BUz;
    if (localSliderSeekBar != null)
    {
      localSliderSeekBar.setCursorPos((float)(paramLong - getScrollTime()) / (f * 2.0F + (float)this.BRG));
      AppMethodBeat.o(196868);
      return;
    }
    AppMethodBeat.o(196868);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void at(long paramLong1, long paramLong2);
    
    public abstract void au(long paramLong1, long paramLong2);
    
    public abstract void pause();
    
    public abstract void seekTo(long paramLong);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "dragScroll", "", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-vlog_release"})
  public static final class b
    extends RecyclerView.m
  {
    private boolean BPe;
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196858);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt1);
      localb.mr(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      TrackCropView.b(this.BUD);
      ad.i(TrackCropView.a(this.BUD), "onScroll: range: " + TrackCropView.c(this.BUD) + ", " + TrackCropView.d(this.BUD));
      paramRecyclerView = this.BUD.getCallback();
      if (paramRecyclerView != null) {
        paramRecyclerView.seekTo(TrackCropView.c(this.BUD));
      }
      this.BUD.setProgress(TrackCropView.c(this.BUD));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(196858);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(196857);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
      p.h(paramRecyclerView, "recyclerView");
      ad.i(TrackCropView.a(this.BUD), "onScrollStateChanged: ".concat(String.valueOf(paramInt)));
      super.b(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        TrackCropView.b(this.BUD);
        ad.i(TrackCropView.a(this.BUD), "onScrollStateChanged: " + TrackCropView.c(this.BUD) + ", " + TrackCropView.d(this.BUD));
        paramRecyclerView = this.BUD.getCallback();
        if (paramRecyclerView != null) {
          paramRecyclerView.au(TrackCropView.c(this.BUD), TrackCropView.d(this.BUD));
        }
        TrackCropView.a(this.BUD, false);
        this.BPe = false;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(196857);
        return;
        if (paramInt == 1)
        {
          if (!this.BPe)
          {
            paramRecyclerView = this.BUD;
            paramRecyclerView.setDragCnt(paramRecyclerView.getDragCnt() + 1);
          }
          this.BPe = true;
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$2", "Landroid/support/v7/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-vlog_release"})
  public static final class c
    extends RecyclerView.r
  {
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(196859);
      p.h(paramRecyclerView, "rv");
      p.h(paramMotionEvent, "e");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(196859);
        return false;
        paramRecyclerView = this.BUD.getCallback();
        if (paramRecyclerView != null)
        {
          paramRecyclerView.pause();
          continue;
          if (TrackCropView.e(this.BUD).getScrollState() == 0)
          {
            TrackCropView.b(this.BUD);
            ad.i(TrackCropView.a(this.BUD), "onInterceptTouchEvent crop: " + TrackCropView.c(this.BUD) + ", " + TrackCropView.d(this.BUD));
            paramRecyclerView = this.BUD.getCallback();
            if (paramRecyclerView != null) {
              paramRecyclerView.au(TrackCropView.c(this.BUD), TrackCropView.d(this.BUD));
            }
            TrackCropView.a(this.BUD, false);
          }
          else
          {
            TrackCropView.a(this.BUD, true);
          }
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$3", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
  public static final class d
    implements SliderSeekBar.a
  {
    public final void dnJ()
    {
      AppMethodBeat.i(196860);
      TrackCropView.a locala = this.BUD.getCallback();
      if (locala != null)
      {
        locala.pause();
        AppMethodBeat.o(196860);
        return;
      }
      AppMethodBeat.o(196860);
    }
    
    public final void dnK()
    {
      AppMethodBeat.i(196861);
      Object localObject = this.BUD;
      ((TrackCropView)localObject).setCutCnt(((TrackCropView)localObject).getCutCnt() + 1);
      TrackCropView.b(this.BUD);
      ad.i(TrackCropView.a(this.BUD), "onScrollStateChanged: " + TrackCropView.c(this.BUD) + ", " + TrackCropView.d(this.BUD));
      localObject = this.BUD.getCallback();
      if (localObject != null)
      {
        ((TrackCropView.a)localObject).au(TrackCropView.c(this.BUD), TrackCropView.d(this.BUD));
        AppMethodBeat.o(196861);
        return;
      }
      AppMethodBeat.o(196861);
    }
    
    public final void ov(boolean paramBoolean)
    {
      AppMethodBeat.i(196862);
      TrackCropView.b(this.BUD);
      ad.i(TrackCropView.a(this.BUD), "onMove: " + paramBoolean + ", " + TrackCropView.c(this.BUD) + ", " + TrackCropView.d(this.BUD));
      TrackCropView.a locala = this.BUD.getCallback();
      if (locala != null) {
        locala.at(TrackCropView.c(this.BUD), TrackCropView.d(this.BUD));
      }
      if (paramBoolean)
      {
        locala = this.BUD.getCallback();
        if (locala != null) {
          locala.seekTo(TrackCropView.c(this.BUD));
        }
        this.BUD.setProgress(TrackCropView.c(this.BUD));
        AppMethodBeat.o(196862);
        return;
      }
      locala = this.BUD.getCallback();
      if (locala != null) {
        locala.seekTo(TrackCropView.d(this.BUD));
      }
      this.BUD.setProgress(TrackCropView.d(this.BUD));
      AppMethodBeat.o(196862);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(TrackCropView paramTrackCropView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(196864);
      if (TrackCropView.e(this.BUD).getWidth() <= 0)
      {
        TrackCropView.e(this.BUD).post(TrackCropView.f(this.BUD));
        AppMethodBeat.o(196864);
        return;
      }
      TrackCropView.a(this.BUD, com.tencent.mm.cc.a.fromDPToPix(this.BUD.getContext(), 40));
      float f = TrackCropView.e(this.BUD).getHeight() * 1.0F / TrackCropView.h(this.BUD);
      TrackCropView.b(this.BUD, TrackCropView.e(this.BUD).getWidth() - TrackCropView.g(this.BUD) * 2);
      TrackCropView.a(this.BUD, TrackCropView.i(this.BUD) * 1.0F / (float)TrackCropView.k(this.BUD));
      TrackCropView.c(this.BUD, (int)(TrackCropView.j(this.BUD) * (float)TrackCropView.m(this.BUD)));
      f = TrackCropView.l(this.BUD) / (f * TrackCropView.n(this.BUD));
      Object localObject = ((Iterable)this.BRS).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        localc.BUI = (f / (float)TrackCropView.m(this.BUD) * (float)localc.euc() / localc.BUL.BGw.llC);
        localc.eud();
        ad.d(TrackCropView.a(this.BUD), "build thumbInfo index:" + localc.trackIndex + ", frameCount:" + localc.BUI + ", frameDuration:" + localc.euc() + ", frameWidth:" + (float)localc.euc() * TrackCropView.j(this.BUD));
      }
      TrackCropView.o(this.BUD).gLD = TrackCropView.g(this.BUD);
      TrackCropView.p(this.BUD).gLD = TrackCropView.g(this.BUD);
      final int i = Math.max(0, Math.min((int)((float)TrackCropView.c(this.BUD) * TrackCropView.j(this.BUD)), (int)((float)TrackCropView.d(this.BUD) * TrackCropView.j(this.BUD) - TrackCropView.i(this.BUD))));
      TrackCropView.q(this.BUD).ag(0, -i);
      this.BRS.add(0, TrackCropView.o(this.BUD));
      this.BRS.add(TrackCropView.p(this.BUD));
      TrackCropView.r(this.BUD).gq((List)this.BRS);
      TrackCropView.r(this.BUD).notifyDataSetChanged();
      localObject = this.BUD.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).aj(TrackCropView.e(this.BUD).getWidth() - TrackCropView.g(this.BUD) * 2, (int)((float)this.BRT * TrackCropView.j(this.BUD)), TrackCropView.g(this.BUD));
      }
      localObject = this.BUD.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).setCursorPos(0.0F);
      }
      localObject = this.BUD.getSeekSlider();
      if (localObject != null)
      {
        ((SliderSeekBar)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(196863);
            SliderSeekBar localSliderSeekBar = this.BUE.BUD.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(true, TrackCropView.g(this.BUE.BUD) + (float)TrackCropView.c(this.BUE.BUD) * TrackCropView.j(this.BUE.BUD) - i);
            }
            localSliderSeekBar = this.BUE.BUD.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(false, TrackCropView.g(this.BUE.BUD) + (float)TrackCropView.d(this.BUE.BUD) * TrackCropView.j(this.BUE.BUD) - i);
            }
            TrackCropView.s(this.BUE.BUD);
            AppMethodBeat.o(196863);
          }
        });
        AppMethodBeat.o(196864);
        return;
      }
      AppMethodBeat.o(196864);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView
 * JD-Core Version:    0.7.0.1
 */