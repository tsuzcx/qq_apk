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
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "playWaitIdle", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "seekSliderReady", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TrackCropView
  extends FrameLayout
{
  private b Cgg;
  private int Cgj;
  private float Cgo;
  private Runnable Cgp;
  private final c Cgr;
  private boolean Cgw;
  private long Cjg;
  private long Cjh;
  private long Cji;
  private int Cjj;
  private int Cjk;
  private final c Cjl;
  private int Cjm;
  private int Cjn;
  private SliderSeekBar Cma;
  private boolean Cmb;
  private SliderSeekBar.a Cmc;
  private a Cmd;
  private final String TAG;
  private long duration;
  private RecyclerView gpr;
  private long hiI;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  private LinearLayoutManager zTo;
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192334);
    AppMethodBeat.o(192334);
  }
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192333);
    this.TAG = "MicroMsg.TrackCropView";
    this.zTo = new LinearLayoutManager(0);
    this.Cgg = new b();
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.Cgj = 1;
    this.Cji = 1L;
    this.Cgo = 1.0F;
    paramContext = c.Cmo;
    this.Cjl = c.a.exL();
    paramContext = c.Cmo;
    this.Cgr = c.a.exL();
    AppMethodBeat.o(192333);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(192332);
    Object localObject1 = null;
    Object localObject2 = this.gpr;
    if (localObject2 == null) {
      p.bdF("recyclerView");
    }
    int j = ((RecyclerView)localObject2).getChildCount();
    int i = 0;
    long l;
    if (i < j)
    {
      localObject2 = this.gpr;
      if (localObject2 == null) {
        p.bdF("recyclerView");
      }
      localObject2 = ((RecyclerView)localObject2).getChildAt(i);
      if ((localObject2 instanceof FrameListView))
      {
        if (this.gpr == null) {
          p.bdF("recyclerView");
        }
        int k = RecyclerView.bw((View)localObject2);
        localObject1 = localObject2;
        if (k >= 0)
        {
          localObject1 = localObject2;
          if (k < this.Cgg.getItemCount()) {
            l = this.Cgg.Ur(k).Cmm.BXV.startTimeMs;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(192332);
        return 0L;
        i += 1;
        break;
      }
      l = (-((View)localObject2).getLeft() / this.Cgo + (float)l);
      AppMethodBeat.o(192332);
      return l;
      l = 0L;
      localObject2 = localObject1;
    }
  }
  
  public final a getCallback()
  {
    return this.Cmd;
  }
  
  public final int getCutCnt()
  {
    return this.Cjn;
  }
  
  public final int getDragCnt()
  {
    return this.Cjm;
  }
  
  public final SliderSeekBar getSeekSlider()
  {
    return this.Cma;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(192328);
    super.onFinishInflate();
    Object localObject = findViewById(2131308041);
    p.g(localObject, "findViewById(R.id.track_crop_thumb_recycler)");
    this.gpr = ((RecyclerView)localObject);
    this.Cma = ((SliderSeekBar)findViewById(2131308040));
    localObject = this.Cma;
    if (localObject != null) {
      ((SliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.Cma;
    if (localObject != null) {
      ((SliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    localObject = this.gpr;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)this.zTo);
    localObject = this.gpr;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.Cgg);
    localObject = this.gpr;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject).setItemAnimator(null);
    localObject = this.gpr;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.m)new b(this));
    localObject = this.gpr;
    if (localObject == null) {
      p.bdF("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.l)new c(this));
    this.Cmc = ((SliderSeekBar.a)new d(this));
    localObject = this.Cma;
    if (localObject != null)
    {
      ((SliderSeekBar)localObject).setOnSliderTouchListener(this.Cmc);
      AppMethodBeat.o(192328);
      return;
    }
    AppMethodBeat.o(192328);
  }
  
  public final void setCallback(a parama)
  {
    this.Cmd = parama;
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
    AppMethodBeat.i(192329);
    if (paramBoolean)
    {
      localSliderSeekBar = this.Cma;
      if (localSliderSeekBar != null)
      {
        localSliderSeekBar.dqK();
        AppMethodBeat.o(192329);
        return;
      }
      AppMethodBeat.o(192329);
      return;
    }
    SliderSeekBar localSliderSeekBar = this.Cma;
    if (localSliderSeekBar != null)
    {
      localSliderSeekBar.dqJ();
      AppMethodBeat.o(192329);
      return;
    }
    AppMethodBeat.o(192329);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(192331);
    float f = this.padding / this.Cgo;
    SliderSeekBar localSliderSeekBar = this.Cma;
    if (localSliderSeekBar != null)
    {
      localSliderSeekBar.setCursorPos((float)(paramLong - getScrollTime()) / (f * 2.0F + (float)this.Cjg));
      AppMethodBeat.o(192331);
      return;
    }
    AppMethodBeat.o(192331);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void as(long paramLong1, long paramLong2);
    
    public abstract void at(long paramLong1, long paramLong2);
    
    public abstract void pause();
    
    public abstract void seekTo(long paramLong);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "dragScroll", "", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-vlog_release"})
  public static final class b
    extends RecyclerView.m
  {
    private boolean CgD;
    
    public final void a(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192321);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt1);
      localb.mu(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      super.a(paramRecyclerView, paramInt1, paramInt2);
      TrackCropView.b(this.Cme);
      ae.i(TrackCropView.a(this.Cme), "onScroll: range: " + TrackCropView.c(this.Cme) + ", " + TrackCropView.d(this.Cme));
      paramRecyclerView = this.Cme.getCallback();
      if (paramRecyclerView != null) {
        paramRecyclerView.seekTo(TrackCropView.c(this.Cme));
      }
      this.Cme.setProgress(TrackCropView.c(this.Cme));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(192321);
    }
    
    public final void b(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(192320);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramRecyclerView);
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
      p.h(paramRecyclerView, "recyclerView");
      ae.i(TrackCropView.a(this.Cme), "onScrollStateChanged: ".concat(String.valueOf(paramInt)));
      super.b(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        TrackCropView.b(this.Cme);
        ae.i(TrackCropView.a(this.Cme), "onScrollStateChanged: " + TrackCropView.c(this.Cme) + ", " + TrackCropView.d(this.Cme));
        paramRecyclerView = this.Cme.getCallback();
        if (paramRecyclerView != null) {
          paramRecyclerView.at(TrackCropView.c(this.Cme), TrackCropView.d(this.Cme));
        }
        TrackCropView.a(this.Cme, false);
        this.CgD = false;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(192320);
        return;
        if (paramInt == 1)
        {
          if (!this.CgD)
          {
            paramRecyclerView = this.Cme;
            paramRecyclerView.setDragCnt(paramRecyclerView.getDragCnt() + 1);
          }
          this.CgD = true;
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$2", "Landroid/support/v7/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-vlog_release"})
  public static final class c
    extends RecyclerView.r
  {
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(192322);
      p.h(paramRecyclerView, "rv");
      p.h(paramMotionEvent, "e");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(192322);
        return false;
        paramRecyclerView = this.Cme.getCallback();
        if (paramRecyclerView != null)
        {
          paramRecyclerView.pause();
          continue;
          if (TrackCropView.e(this.Cme).getScrollState() == 0)
          {
            TrackCropView.b(this.Cme);
            ae.i(TrackCropView.a(this.Cme), "onInterceptTouchEvent crop: " + TrackCropView.c(this.Cme) + ", " + TrackCropView.d(this.Cme));
            paramRecyclerView = this.Cme.getCallback();
            if (paramRecyclerView != null) {
              paramRecyclerView.at(TrackCropView.c(this.Cme), TrackCropView.d(this.Cme));
            }
            TrackCropView.a(this.Cme, false);
          }
          else
          {
            TrackCropView.a(this.Cme, true);
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$3", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
  public static final class d
    implements SliderSeekBar.a
  {
    public final void dqH()
    {
      AppMethodBeat.i(192323);
      TrackCropView.a locala = this.Cme.getCallback();
      if (locala != null)
      {
        locala.pause();
        AppMethodBeat.o(192323);
        return;
      }
      AppMethodBeat.o(192323);
    }
    
    public final void dqI()
    {
      AppMethodBeat.i(192324);
      Object localObject = this.Cme;
      ((TrackCropView)localObject).setCutCnt(((TrackCropView)localObject).getCutCnt() + 1);
      TrackCropView.b(this.Cme);
      ae.i(TrackCropView.a(this.Cme), "onScrollStateChanged: " + TrackCropView.c(this.Cme) + ", " + TrackCropView.d(this.Cme));
      localObject = this.Cme.getCallback();
      if (localObject != null)
      {
        ((TrackCropView.a)localObject).at(TrackCropView.c(this.Cme), TrackCropView.d(this.Cme));
        AppMethodBeat.o(192324);
        return;
      }
      AppMethodBeat.o(192324);
    }
    
    public final void oA(boolean paramBoolean)
    {
      AppMethodBeat.i(192325);
      TrackCropView.b(this.Cme);
      ae.i(TrackCropView.a(this.Cme), "onMove: " + paramBoolean + ", " + TrackCropView.c(this.Cme) + ", " + TrackCropView.d(this.Cme));
      TrackCropView.a locala = this.Cme.getCallback();
      if (locala != null) {
        locala.as(TrackCropView.c(this.Cme), TrackCropView.d(this.Cme));
      }
      if (paramBoolean)
      {
        locala = this.Cme.getCallback();
        if (locala != null) {
          locala.seekTo(TrackCropView.c(this.Cme));
        }
        this.Cme.setProgress(TrackCropView.c(this.Cme));
        AppMethodBeat.o(192325);
        return;
      }
      locala = this.Cme.getCallback();
      if (locala != null) {
        locala.seekTo(TrackCropView.d(this.Cme));
      }
      this.Cme.setProgress(TrackCropView.d(this.Cme));
      AppMethodBeat.o(192325);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(TrackCropView paramTrackCropView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(192327);
      if (TrackCropView.e(this.Cme).getWidth() <= 0)
      {
        TrackCropView.e(this.Cme).post(TrackCropView.f(this.Cme));
        AppMethodBeat.o(192327);
        return;
      }
      TrackCropView.a(this.Cme, com.tencent.mm.cb.a.fromDPToPix(this.Cme.getContext(), 40));
      float f = TrackCropView.e(this.Cme).getHeight() * 1.0F / TrackCropView.h(this.Cme);
      TrackCropView.b(this.Cme, TrackCropView.e(this.Cme).getWidth() - TrackCropView.g(this.Cme) * 2);
      TrackCropView.a(this.Cme, TrackCropView.i(this.Cme) * 1.0F / (float)TrackCropView.k(this.Cme));
      TrackCropView.c(this.Cme, (int)(TrackCropView.j(this.Cme) * (float)TrackCropView.m(this.Cme)));
      f = TrackCropView.l(this.Cme) / (f * TrackCropView.n(this.Cme));
      Object localObject = ((Iterable)this.Cjs).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c localc = (c)((Iterator)localObject).next();
        localc.Cmj = (f / (float)TrackCropView.m(this.Cme) * (float)localc.exI() / localc.Cmm.BXV.lqb);
        localc.exJ();
        ae.d(TrackCropView.a(this.Cme), "build thumbInfo index:" + localc.trackIndex + ", frameCount:" + localc.Cmj + ", frameDuration:" + localc.exI() + ", frameWidth:" + (float)localc.exI() * TrackCropView.j(this.Cme));
      }
      TrackCropView.o(this.Cme).gOm = TrackCropView.g(this.Cme);
      TrackCropView.p(this.Cme).gOm = TrackCropView.g(this.Cme);
      final int i = Math.max(0, Math.min((int)((float)TrackCropView.c(this.Cme) * TrackCropView.j(this.Cme)), (int)((float)TrackCropView.d(this.Cme) * TrackCropView.j(this.Cme) - TrackCropView.i(this.Cme))));
      TrackCropView.q(this.Cme).ag(0, -i);
      this.Cjs.add(0, TrackCropView.o(this.Cme));
      this.Cjs.add(TrackCropView.p(this.Cme));
      TrackCropView.r(this.Cme).gz((List)this.Cjs);
      TrackCropView.r(this.Cme).notifyDataSetChanged();
      localObject = this.Cme.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).aj(TrackCropView.e(this.Cme).getWidth() - TrackCropView.g(this.Cme) * 2, (int)((float)this.Cjt * TrackCropView.j(this.Cme)), TrackCropView.g(this.Cme));
      }
      localObject = this.Cme.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).setCursorPos(0.0F);
      }
      localObject = this.Cme.getSeekSlider();
      if (localObject != null)
      {
        ((SliderSeekBar)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192326);
            SliderSeekBar localSliderSeekBar = this.Cmf.Cme.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(true, TrackCropView.g(this.Cmf.Cme) + (float)TrackCropView.c(this.Cmf.Cme) * TrackCropView.j(this.Cmf.Cme) - i);
            }
            localSliderSeekBar = this.Cmf.Cme.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(false, TrackCropView.g(this.Cmf.Cme) + (float)TrackCropView.d(this.Cmf.Cme) * TrackCropView.j(this.Cmf.Cme) - i);
            }
            TrackCropView.s(this.Cmf.Cme);
            AppMethodBeat.o(192326);
          }
        });
        AppMethodBeat.o(192327);
        return;
      }
      AppMethodBeat.o(192327);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView
 * JD-Core Version:    0.7.0.1
 */