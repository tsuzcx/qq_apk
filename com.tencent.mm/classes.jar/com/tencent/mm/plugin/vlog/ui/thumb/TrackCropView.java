package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.q;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "playWaitIdle", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "seekSliderReady", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TrackCropView
  extends FrameLayout
{
  private float Avf;
  private f GIX;
  private int GJa;
  private Runnable GJd;
  private final h GJf;
  private boolean GJk;
  private long GMh;
  private long GMi;
  private long GMj;
  private int GMk;
  private int GMl;
  private final h GMm;
  private int GMn;
  private int GMo;
  private SliderSeekBar GPR;
  private boolean GPT;
  private SliderSeekBar.a GPU;
  private a GPV;
  private final String TAG;
  private long duration;
  private RecyclerView hak;
  private long hwQ;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  private LinearLayoutManager vKp;
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(192157);
    AppMethodBeat.o(192157);
  }
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(192156);
    this.TAG = "MicroMsg.TrackCropView";
    this.vKp = new LinearLayoutManager(0, false);
    this.GIX = new f();
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.GJa = 1;
    this.GMj = 1L;
    this.Avf = 1.0F;
    paramContext = h.GQe;
    this.GMm = h.a.fEy();
    paramContext = h.GQe;
    this.GJf = h.a.fEy();
    AppMethodBeat.o(192156);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(192155);
    Object localObject1 = null;
    Object localObject2 = this.hak;
    if (localObject2 == null) {
      p.btv("recyclerView");
    }
    int j = ((RecyclerView)localObject2).getChildCount();
    int i = 0;
    long l;
    if (i < j)
    {
      localObject2 = this.hak;
      if (localObject2 == null) {
        p.btv("recyclerView");
      }
      localObject2 = ((RecyclerView)localObject2).getChildAt(i);
      if ((localObject2 instanceof FrameListView))
      {
        if (this.hak == null) {
          p.btv("recyclerView");
        }
        int k = RecyclerView.bw((View)localObject2);
        localObject1 = localObject2;
        if (k >= 0)
        {
          localObject1 = localObject2;
          if (k < this.GIX.getItemCount()) {
            l = this.GIX.acK(k).GQc.GzA.startTimeMs;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(192155);
        return 0L;
        i += 1;
        break;
      }
      l = (-((View)localObject2).getLeft() / this.Avf + (float)l);
      AppMethodBeat.o(192155);
      return l;
      l = 0L;
      localObject2 = localObject1;
    }
  }
  
  public final a getCallback()
  {
    return this.GPV;
  }
  
  public final int getCutCnt()
  {
    return this.GMo;
  }
  
  public final int getDragCnt()
  {
    return this.GMn;
  }
  
  public final SliderSeekBar getSeekSlider()
  {
    return this.GPR;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(192151);
    super.onFinishInflate();
    Object localObject = findViewById(2131309378);
    p.g(localObject, "findViewById(R.id.track_crop_thumb_recycler)");
    this.hak = ((RecyclerView)localObject);
    this.GPR = ((SliderSeekBar)findViewById(2131309377));
    localObject = this.GPR;
    if (localObject != null) {
      ((SliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.GPR;
    if (localObject != null) {
      ((SliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)this.vKp);
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.GIX);
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).setItemAnimator(null);
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.l)new b(this));
    localObject = this.hak;
    if (localObject == null) {
      p.btv("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.k)new c(this));
    this.GPU = ((SliderSeekBar.a)new d(this));
    localObject = this.GPR;
    if (localObject != null)
    {
      ((SliderSeekBar)localObject).setOnSliderTouchListener(this.GPU);
      AppMethodBeat.o(192151);
      return;
    }
    AppMethodBeat.o(192151);
  }
  
  public final void setCallback(a parama)
  {
    this.GPV = parama;
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
    AppMethodBeat.i(192152);
    if (paramBoolean)
    {
      localSliderSeekBar = this.GPR;
      if (localSliderSeekBar != null)
      {
        localSliderSeekBar.ekB();
        AppMethodBeat.o(192152);
        return;
      }
      AppMethodBeat.o(192152);
      return;
    }
    SliderSeekBar localSliderSeekBar = this.GPR;
    if (localSliderSeekBar != null)
    {
      localSliderSeekBar.ekA();
      AppMethodBeat.o(192152);
      return;
    }
    AppMethodBeat.o(192152);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(192154);
    float f = this.padding / this.Avf;
    SliderSeekBar localSliderSeekBar = this.GPR;
    if (localSliderSeekBar != null)
    {
      localSliderSeekBar.setCursorPos((float)(paramLong - getScrollTime()) / (f * 2.0F + (float)this.GMh));
      AppMethodBeat.o(192154);
      return;
    }
    AppMethodBeat.o(192154);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void ay(long paramLong1, long paramLong2);
    
    public abstract void az(long paramLong1, long paramLong2);
    
    public abstract void pause();
    
    public abstract void seekTo(long paramLong);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "dragScroll", "", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-vlog_release"})
  public static final class b
    extends RecyclerView.l
  {
    private boolean GJq;
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(192143);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      Log.i(TrackCropView.a(this.GPW), "onScrollStateChanged: ".concat(String.valueOf(paramInt)));
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        TrackCropView.b(this.GPW);
        Log.i(TrackCropView.a(this.GPW), "onScrollStateChanged: " + TrackCropView.c(this.GPW) + ", " + TrackCropView.d(this.GPW));
        paramRecyclerView = this.GPW.getCallback();
        if (paramRecyclerView != null) {
          paramRecyclerView.ay(TrackCropView.c(this.GPW), TrackCropView.d(this.GPW));
        }
        TrackCropView.a(this.GPW, false);
        this.GJq = false;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
        AppMethodBeat.o(192143);
        return;
        if (paramInt == 1)
        {
          if (!this.GJq)
          {
            paramRecyclerView = this.GPW;
            paramRecyclerView.setDragCnt(paramRecyclerView.getDragCnt() + 1);
          }
          this.GJq = true;
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(192144);
      b localb = new b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      TrackCropView.b(this.GPW);
      Log.i(TrackCropView.a(this.GPW), "onScroll: range: " + TrackCropView.c(this.GPW) + ", " + TrackCropView.d(this.GPW));
      paramRecyclerView = this.GPW.getCallback();
      if (paramRecyclerView != null) {
        paramRecyclerView.seekTo(TrackCropView.c(this.GPW));
      }
      this.GPW.setProgress(TrackCropView.c(this.GPW));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(192144);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$2", "Landroid/support/v7/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-vlog_release"})
  public static final class c
    extends RecyclerView.q
  {
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(192145);
      p.h(paramRecyclerView, "rv");
      p.h(paramMotionEvent, "e");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(192145);
        return false;
        paramRecyclerView = this.GPW.getCallback();
        if (paramRecyclerView != null)
        {
          paramRecyclerView.pause();
          continue;
          if (TrackCropView.e(this.GPW).getScrollState() == 0)
          {
            TrackCropView.b(this.GPW);
            Log.i(TrackCropView.a(this.GPW), "onInterceptTouchEvent crop: " + TrackCropView.c(this.GPW) + ", " + TrackCropView.d(this.GPW));
            paramRecyclerView = this.GPW.getCallback();
            if (paramRecyclerView != null) {
              paramRecyclerView.ay(TrackCropView.c(this.GPW), TrackCropView.d(this.GPW));
            }
            TrackCropView.a(this.GPW, false);
          }
          else
          {
            TrackCropView.a(this.GPW, true);
          }
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$3", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
  public static final class d
    implements SliderSeekBar.a
  {
    public final void eky()
    {
      AppMethodBeat.i(192146);
      TrackCropView.a locala = this.GPW.getCallback();
      if (locala != null)
      {
        locala.pause();
        AppMethodBeat.o(192146);
        return;
      }
      AppMethodBeat.o(192146);
    }
    
    public final void ekz()
    {
      AppMethodBeat.i(192147);
      Object localObject = this.GPW;
      ((TrackCropView)localObject).setCutCnt(((TrackCropView)localObject).getCutCnt() + 1);
      TrackCropView.b(this.GPW);
      Log.i(TrackCropView.a(this.GPW), "onScrollStateChanged: " + TrackCropView.c(this.GPW) + ", " + TrackCropView.d(this.GPW));
      localObject = this.GPW.getCallback();
      if (localObject != null)
      {
        ((TrackCropView.a)localObject).ay(TrackCropView.c(this.GPW), TrackCropView.d(this.GPW));
        AppMethodBeat.o(192147);
        return;
      }
      AppMethodBeat.o(192147);
    }
    
    public final void rj(boolean paramBoolean)
    {
      AppMethodBeat.i(192148);
      TrackCropView.b(this.GPW);
      Log.i(TrackCropView.a(this.GPW), "onMove: " + paramBoolean + ", " + TrackCropView.c(this.GPW) + ", " + TrackCropView.d(this.GPW));
      TrackCropView.a locala = this.GPW.getCallback();
      if (locala != null) {
        locala.az(TrackCropView.c(this.GPW), TrackCropView.d(this.GPW));
      }
      if (paramBoolean)
      {
        locala = this.GPW.getCallback();
        if (locala != null) {
          locala.seekTo(TrackCropView.c(this.GPW));
        }
        this.GPW.setProgress(TrackCropView.c(this.GPW));
        AppMethodBeat.o(192148);
        return;
      }
      locala = this.GPW.getCallback();
      if (locala != null) {
        locala.seekTo(TrackCropView.d(this.GPW));
      }
      this.GPW.setProgress(TrackCropView.d(this.GPW));
      AppMethodBeat.o(192148);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(TrackCropView paramTrackCropView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(192150);
      if (TrackCropView.e(this.GPW).getWidth() <= 0)
      {
        TrackCropView.e(this.GPW).post(TrackCropView.f(this.GPW));
        AppMethodBeat.o(192150);
        return;
      }
      TrackCropView.a(this.GPW, com.tencent.mm.cb.a.fromDPToPix(this.GPW.getContext(), 40));
      float f = TrackCropView.e(this.GPW).getHeight() * 1.0F / TrackCropView.h(this.GPW);
      TrackCropView.b(this.GPW, TrackCropView.e(this.GPW).getWidth() - TrackCropView.g(this.GPW) * 2);
      TrackCropView.a(this.GPW, TrackCropView.i(this.GPW) * 1.0F / (float)TrackCropView.k(this.GPW));
      TrackCropView.c(this.GPW, (int)(TrackCropView.j(this.GPW) * (float)TrackCropView.m(this.GPW)));
      f = TrackCropView.l(this.GPW) / (f * TrackCropView.n(this.GPW));
      Object localObject = ((Iterable)this.GMt).iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((Iterator)localObject).next();
        localh.GOF = (f / (float)TrackCropView.m(this.GPW) * (float)localh.fEu() / localh.GQc.GzA.mwH);
        localh.fEv();
        Log.d(TrackCropView.a(this.GPW), "build thumbInfo index:" + localh.trackIndex + ", frameCount:" + localh.GOF + ", frameDuration:" + localh.fEu() + ", frameWidth:" + (float)localh.fEu() * TrackCropView.j(this.GPW));
      }
      TrackCropView.o(this.GPW).hEp = TrackCropView.g(this.GPW);
      TrackCropView.p(this.GPW).hEp = TrackCropView.g(this.GPW);
      final int i = Math.max(0, Math.min((int)((float)TrackCropView.c(this.GPW) * TrackCropView.j(this.GPW)), (int)((float)TrackCropView.d(this.GPW) * TrackCropView.j(this.GPW) - TrackCropView.i(this.GPW))));
      TrackCropView.q(this.GPW).ah(0, -i);
      this.GMt.add(0, TrackCropView.o(this.GPW));
      this.GMt.add(TrackCropView.p(this.GPW));
      TrackCropView.r(this.GPW).hw((List)this.GMt);
      TrackCropView.r(this.GPW).notifyDataSetChanged();
      localObject = this.GPW.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).ao(TrackCropView.e(this.GPW).getWidth() - TrackCropView.g(this.GPW) * 2, (int)((float)this.GMu * TrackCropView.j(this.GPW)), TrackCropView.g(this.GPW));
      }
      localObject = this.GPW.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).setCursorPos(0.0F);
      }
      localObject = this.GPW.getSeekSlider();
      if (localObject != null)
      {
        ((SliderSeekBar)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192149);
            SliderSeekBar localSliderSeekBar = this.GPX.GPW.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(true, TrackCropView.g(this.GPX.GPW) + (float)TrackCropView.c(this.GPX.GPW) * TrackCropView.j(this.GPX.GPW) - i);
            }
            localSliderSeekBar = this.GPX.GPW.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(false, TrackCropView.g(this.GPX.GPW) + (float)TrackCropView.d(this.GPX.GPW) * TrackCropView.j(this.GPX.GPW) - i);
            }
            TrackCropView.s(this.GPX.GPW);
            AppMethodBeat.o(192149);
          }
        });
        AppMethodBeat.o(192150);
        return;
      }
      AppMethodBeat.o(192150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView
 * JD-Core Version:    0.7.0.1
 */