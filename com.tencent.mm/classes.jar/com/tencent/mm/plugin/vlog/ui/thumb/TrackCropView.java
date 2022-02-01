package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "maxCropDuration", "padding", "playWaitIdle", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "seekSliderReady", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "Lcom/tencent/mm/videocomposition/VideoComposition;", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TrackCropView
  extends FrameLayout
{
  private LinearLayoutManager Arh;
  private float Gly;
  private boolean NDA;
  private SliderSeekBar.a NDB;
  private a NDC;
  private boolean NDk;
  private SliderSeekBar NDz;
  private f NzK;
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
  private final String TAG;
  private long duration;
  private RecyclerView jLl;
  private long kje;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(227465);
    AppMethodBeat.o(227465);
  }
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(227463);
    this.TAG = "MicroMsg.TrackCropView";
    this.Arh = new LinearLayoutManager(0, false);
    this.NzK = new f();
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.NzM = 1;
    this.NzP = 1L;
    this.Gly = 1.0F;
    paramContext = h.NDK;
    this.NzS = h.a.gwz();
    paramContext = h.NDK;
    this.NzT = h.a.gwz();
    AppMethodBeat.o(227463);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(227460);
    Object localObject1 = null;
    Object localObject2 = this.jLl;
    if (localObject2 == null) {
      p.bGy("recyclerView");
    }
    int j = ((RecyclerView)localObject2).getChildCount();
    int i = 0;
    long l;
    if (i < j)
    {
      localObject2 = this.jLl;
      if (localObject2 == null) {
        p.bGy("recyclerView");
      }
      localObject2 = ((RecyclerView)localObject2).getChildAt(i);
      if ((localObject2 instanceof FrameListView))
      {
        if (this.jLl == null) {
          p.bGy("recyclerView");
        }
        int k = RecyclerView.bh((View)localObject2);
        localObject1 = localObject2;
        if (k >= 0)
        {
          localObject1 = localObject2;
          if (k < this.NzK.getItemCount()) {
            l = this.NzK.akt(k).getStartTimeMs();
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(227460);
        return 0L;
        i += 1;
        break;
      }
      l = (-((View)localObject2).getLeft() / this.Gly + (float)l);
      AppMethodBeat.o(227460);
      return l;
      l = 0L;
      localObject2 = localObject1;
    }
  }
  
  public final a getCallback()
  {
    return this.NDC;
  }
  
  public final int getCutCnt()
  {
    return this.NzV;
  }
  
  public final int getDragCnt()
  {
    return this.NzU;
  }
  
  public final SliderSeekBar getSeekSlider()
  {
    return this.NDz;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(227433);
    super.onFinishInflate();
    Object localObject = findViewById(a.f.track_crop_thumb_recycler);
    p.j(localObject, "findViewById(R.id.track_crop_thumb_recycler)");
    this.jLl = ((RecyclerView)localObject);
    this.NDz = ((SliderSeekBar)findViewById(a.f.track_crop_slider_seek));
    localObject = this.NDz;
    if (localObject != null) {
      ((SliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.NDz;
    if (localObject != null) {
      ((SliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)this.Arh);
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.NzK);
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).setItemAnimator(null);
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.l)new b(this));
    localObject = this.jLl;
    if (localObject == null) {
      p.bGy("recyclerView");
    }
    ((RecyclerView)localObject).a((RecyclerView.k)new c(this));
    this.NDB = ((SliderSeekBar.a)new d(this));
    localObject = this.NDz;
    if (localObject != null)
    {
      ((SliderSeekBar)localObject).setOnSliderTouchListener(this.NDB);
      AppMethodBeat.o(227433);
      return;
    }
    AppMethodBeat.o(227433);
  }
  
  public final void setCallback(a parama)
  {
    this.NDC = parama;
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
    AppMethodBeat.i(227434);
    if (paramBoolean)
    {
      localSliderSeekBar = this.NDz;
      if (localSliderSeekBar != null)
      {
        localSliderSeekBar.eUj();
        AppMethodBeat.o(227434);
        return;
      }
      AppMethodBeat.o(227434);
      return;
    }
    SliderSeekBar localSliderSeekBar = this.NDz;
    if (localSliderSeekBar != null)
    {
      localSliderSeekBar.eUi();
      AppMethodBeat.o(227434);
      return;
    }
    AppMethodBeat.o(227434);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(227456);
    float f = this.padding / this.Gly;
    SliderSeekBar localSliderSeekBar = this.NDz;
    if (localSliderSeekBar != null)
    {
      localSliderSeekBar.setCursorPos((float)(paramLong - getScrollTime()) / (f * 2.0F + (float)this.NzN));
      AppMethodBeat.o(227456);
      return;
    }
    AppMethodBeat.o(227456);
  }
  
  public final void setTrack(com.tencent.mm.videocomposition.j paramj)
  {
    AppMethodBeat.i(227440);
    p.k(paramj, "composition");
    this.NzU = 0;
    this.NzV = 0;
    final LinkedList localLinkedList = new LinkedList();
    this.NzM = 0;
    this.kje = 0L;
    long l2 = ((com.tencent.mm.videocomposition.b)kotlin.a.j.lo((List)paramj.MQY)).MQV;
    long l3 = paramj.getSourceDuration();
    this.duration = (((com.tencent.mm.videocomposition.b)kotlin.a.j.lq((List)paramj.MQY)).NwS - ((com.tencent.mm.videocomposition.b)kotlin.a.j.lq((List)paramj.MQY)).MQW + (paramj.getSourceDuration() + l2));
    long l1;
    Collection localCollection;
    int i;
    label187:
    Object localObject2;
    boolean bool1;
    if (this.duration > 60000L)
    {
      l1 = 60000L;
      this.NzN = l1;
      this.NzO = l2;
      this.NzP = (l2 + l3);
      Object localObject1 = (Iterable)paramj.MQY;
      localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label324;
      }
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (com.tencent.mm.videocomposition.b)localObject2;
      if (i != 0) {
        break label312;
      }
      bool1 = true;
      label227:
      if (i != ((List)paramj.MQY).size() - 1) {
        break label318;
      }
    }
    label312:
    label318:
    for (boolean bool2 = true;; bool2 = false)
    {
      localObject2 = new h((com.tencent.mm.videocomposition.b)localObject2, bool1, bool2);
      ((a)localObject2).trackIndex = i;
      ((a)localObject2).height = this.thumbHeight;
      ((a)localObject2).width = this.thumbWidth;
      localCollection.add(localObject2);
      i += 1;
      break label187;
      l1 = this.duration;
      break;
      bool1 = false;
      break label227;
    }
    label324:
    localLinkedList.addAll((Collection)localCollection);
    if (localLinkedList.size() == 1) {
      localLinkedList.get(0);
    }
    this.NDA = false;
    this.NzW = ((Runnable)new e(this, localLinkedList));
    paramj = this.NzW;
    if (paramj != null)
    {
      paramj.run();
      AppMethodBeat.o(227440);
      return;
    }
    AppMethodBeat.o(227440);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void aN(long paramLong1, long paramLong2);
    
    public abstract void aO(long paramLong1, long paramLong2);
    
    public abstract void pause();
    
    public abstract void seekTo(long paramLong);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "dragScroll", "", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-vlog_release"})
  public static final class b
    extends RecyclerView.l
  {
    private boolean NDD;
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(225680);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      Log.i(TrackCropView.a(this.NDE), "onScrollStateChanged: ".concat(String.valueOf(paramInt)));
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0)
      {
        TrackCropView.b(this.NDE);
        Log.i(TrackCropView.a(this.NDE), "onScrollStateChanged: " + TrackCropView.c(this.NDE) + ", " + TrackCropView.d(this.NDE));
        paramRecyclerView = this.NDE.getCallback();
        if (paramRecyclerView != null) {
          paramRecyclerView.aN(TrackCropView.c(this.NDE), TrackCropView.d(this.NDE));
        }
        TrackCropView.a(this.NDE, false);
        this.NDD = false;
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(225680);
        return;
        if (paramInt == 1)
        {
          if (!this.NDD)
          {
            paramRecyclerView = this.NDE;
            paramRecyclerView.setDragCnt(paramRecyclerView.getDragCnt() + 1);
          }
          this.NDD = true;
        }
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(225682);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      p.k(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      TrackCropView.b(this.NDE);
      Log.i(TrackCropView.a(this.NDE), "onScroll: range: " + TrackCropView.c(this.NDE) + ", " + TrackCropView.d(this.NDE));
      paramRecyclerView = this.NDE.getCallback();
      if (paramRecyclerView != null) {
        paramRecyclerView.seekTo(TrackCropView.c(this.NDE));
      }
      this.NDE.setProgress(TrackCropView.c(this.NDE));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(225682);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$2", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-vlog_release"})
  public static final class c
    extends RecyclerView.q
  {
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(244108);
      p.k(paramRecyclerView, "rv");
      p.k(paramMotionEvent, "e");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(244108);
        return false;
        paramRecyclerView = this.NDE.getCallback();
        if (paramRecyclerView != null)
        {
          paramRecyclerView.pause();
          continue;
          if (TrackCropView.e(this.NDE).getScrollState() == 0)
          {
            TrackCropView.b(this.NDE);
            Log.i(TrackCropView.a(this.NDE), "onInterceptTouchEvent crop: " + TrackCropView.c(this.NDE) + ", " + TrackCropView.d(this.NDE));
            paramRecyclerView = this.NDE.getCallback();
            if (paramRecyclerView != null) {
              paramRecyclerView.aN(TrackCropView.c(this.NDE), TrackCropView.d(this.NDE));
            }
            TrackCropView.a(this.NDE, false);
          }
          else
          {
            TrackCropView.a(this.NDE, true);
          }
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$3", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"})
  public static final class d
    implements SliderSeekBar.a
  {
    public final void eUg()
    {
      AppMethodBeat.i(234443);
      TrackCropView.a locala = this.NDE.getCallback();
      if (locala != null)
      {
        locala.pause();
        AppMethodBeat.o(234443);
        return;
      }
      AppMethodBeat.o(234443);
    }
    
    public final void eUh()
    {
      AppMethodBeat.i(234445);
      Object localObject = this.NDE;
      ((TrackCropView)localObject).setCutCnt(((TrackCropView)localObject).getCutCnt() + 1);
      TrackCropView.b(this.NDE);
      Log.i(TrackCropView.a(this.NDE), "onScrollStateChanged: " + TrackCropView.c(this.NDE) + ", " + TrackCropView.d(this.NDE));
      localObject = this.NDE.getCallback();
      if (localObject != null)
      {
        ((TrackCropView.a)localObject).aN(TrackCropView.c(this.NDE), TrackCropView.d(this.NDE));
        AppMethodBeat.o(234445);
        return;
      }
      AppMethodBeat.o(234445);
    }
    
    public final void un(boolean paramBoolean)
    {
      AppMethodBeat.i(234447);
      TrackCropView.b(this.NDE);
      Log.i(TrackCropView.a(this.NDE), "onMove: " + paramBoolean + ", " + TrackCropView.c(this.NDE) + ", " + TrackCropView.d(this.NDE));
      TrackCropView.a locala = this.NDE.getCallback();
      if (locala != null) {
        locala.aO(TrackCropView.c(this.NDE), TrackCropView.d(this.NDE));
      }
      if (paramBoolean)
      {
        locala = this.NDE.getCallback();
        if (locala != null) {
          locala.seekTo(TrackCropView.c(this.NDE));
        }
        this.NDE.setProgress(TrackCropView.c(this.NDE));
        AppMethodBeat.o(234447);
        return;
      }
      locala = this.NDE.getCallback();
      if (locala != null) {
        locala.seekTo(TrackCropView.d(this.NDE));
      }
      this.NDE.setProgress(TrackCropView.d(this.NDE));
      AppMethodBeat.o(234447);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(TrackCropView paramTrackCropView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(228256);
      if (TrackCropView.e(this.NDE).getWidth() <= 0)
      {
        TrackCropView.e(this.NDE).post(TrackCropView.f(this.NDE));
        AppMethodBeat.o(228256);
        return;
      }
      TrackCropView.a(this.NDE, com.tencent.mm.ci.a.fromDPToPix(this.NDE.getContext(), 40));
      float f = TrackCropView.e(this.NDE).getHeight() * 1.0F / TrackCropView.h(this.NDE);
      TrackCropView.b(this.NDE, TrackCropView.e(this.NDE).getWidth() - TrackCropView.g(this.NDE) * 2);
      TrackCropView.a(this.NDE, TrackCropView.i(this.NDE) * 1.0F / (float)TrackCropView.k(this.NDE));
      TrackCropView.c(this.NDE, (int)(TrackCropView.j(this.NDE) * (float)TrackCropView.m(this.NDE)));
      f = TrackCropView.l(this.NDE) / (f * TrackCropView.n(this.NDE));
      Object localObject = ((Iterable)localLinkedList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((Iterator)localObject).next();
        localh.NCl = (f / (float)TrackCropView.m(this.NDE) * (float)localh.gwv() / localh.NDI.Nng.pvh);
        localh.gww();
        Log.d(TrackCropView.a(this.NDE), "build thumbInfo index:" + localh.trackIndex + ", frameCount:" + localh.NCl + ", frameDuration:" + localh.gwv() + ", frameWidth:" + (float)localh.gwv() * TrackCropView.j(this.NDE));
      }
      TrackCropView.o(this.NDE).ksu = TrackCropView.g(this.NDE);
      TrackCropView.p(this.NDE).ksu = TrackCropView.g(this.NDE);
      final int i = Math.max(0, Math.min((int)((float)TrackCropView.c(this.NDE) * TrackCropView.j(this.NDE)), (int)((float)TrackCropView.d(this.NDE) * TrackCropView.j(this.NDE) - TrackCropView.i(this.NDE))));
      TrackCropView.q(this.NDE).au(0, -i);
      localLinkedList.add(0, TrackCropView.o(this.NDE));
      localLinkedList.add(TrackCropView.p(this.NDE));
      TrackCropView.r(this.NDE).gg((List)localLinkedList);
      TrackCropView.r(this.NDE).notifyDataSetChanged();
      localObject = this.NDE.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).at(TrackCropView.e(this.NDE).getWidth() - TrackCropView.g(this.NDE) * 2, (int)((float)this.NAc * TrackCropView.j(this.NDE)), TrackCropView.g(this.NDE));
      }
      localObject = this.NDE.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).setCursorPos(0.0F);
      }
      localObject = this.NDE.getSeekSlider();
      if (localObject != null)
      {
        ((SliderSeekBar)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(229073);
            SliderSeekBar localSliderSeekBar = this.NDF.NDE.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(true, TrackCropView.g(this.NDF.NDE) + (float)TrackCropView.c(this.NDF.NDE) * TrackCropView.j(this.NDF.NDE) - i);
            }
            localSliderSeekBar = this.NDF.NDE.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(false, TrackCropView.g(this.NDF.NDE) + (float)TrackCropView.d(this.NDF.NDE) * TrackCropView.j(this.NDF.NDE) - i);
            }
            TrackCropView.s(this.NDF.NDE);
            AppMethodBeat.o(229073);
          }
        });
        AppMethodBeat.o(228256);
        return;
      }
      AppMethodBeat.o(228256);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(TrackCropView paramTrackCropView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(228204);
      if (TrackCropView.e(this.NDE).getWidth() <= 0)
      {
        TrackCropView.e(this.NDE).post(TrackCropView.f(this.NDE));
        AppMethodBeat.o(228204);
        return;
      }
      TrackCropView.a(this.NDE, com.tencent.mm.ci.a.fromDPToPix(this.NDE.getContext(), 40));
      float f = TrackCropView.e(this.NDE).getHeight() * 1.0F / TrackCropView.h(this.NDE);
      TrackCropView.b(this.NDE, TrackCropView.e(this.NDE).getWidth() - TrackCropView.g(this.NDE) * 2);
      TrackCropView.a(this.NDE, TrackCropView.i(this.NDE) * 1.0F / (float)TrackCropView.k(this.NDE));
      TrackCropView.c(this.NDE, (int)(TrackCropView.j(this.NDE) * (float)TrackCropView.m(this.NDE)));
      f = TrackCropView.l(this.NDE) / (f * TrackCropView.n(this.NDE));
      Object localObject = ((Iterable)this.NAb).iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((Iterator)localObject).next();
        localh.NCl = (f / (float)TrackCropView.m(this.NDE) * (float)localh.gwv() / localh.NDI.Nng.pvh);
        localh.gww();
        Log.d(TrackCropView.a(this.NDE), "build thumbInfo index:" + localh.trackIndex + ", frameCount:" + localh.NCl + ", frameDuration:" + localh.gwv() + ", frameWidth:" + (float)localh.gwv() * TrackCropView.j(this.NDE));
      }
      TrackCropView.o(this.NDE).ksu = TrackCropView.g(this.NDE);
      TrackCropView.p(this.NDE).ksu = TrackCropView.g(this.NDE);
      final int i = Math.max(0, Math.min((int)((float)TrackCropView.c(this.NDE) * TrackCropView.j(this.NDE)), (int)((float)TrackCropView.d(this.NDE) * TrackCropView.j(this.NDE) - TrackCropView.i(this.NDE))));
      TrackCropView.q(this.NDE).au(0, -i);
      this.NAb.add(0, TrackCropView.o(this.NDE));
      this.NAb.add(TrackCropView.p(this.NDE));
      TrackCropView.r(this.NDE).gg((List)this.NAb);
      TrackCropView.r(this.NDE).notifyDataSetChanged();
      localObject = this.NDE.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).at(TrackCropView.e(this.NDE).getWidth() - TrackCropView.g(this.NDE) * 2, (int)((float)this.NAc * TrackCropView.j(this.NDE)), TrackCropView.g(this.NDE));
      }
      localObject = this.NDE.getSeekSlider();
      if (localObject != null) {
        ((SliderSeekBar)localObject).setCursorPos(0.0F);
      }
      localObject = this.NDE.getSeekSlider();
      if (localObject != null)
      {
        ((SliderSeekBar)localObject).post((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(233282);
            SliderSeekBar localSliderSeekBar = this.NDH.NDE.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(true, TrackCropView.g(this.NDH.NDE) + (float)TrackCropView.c(this.NDH.NDE) * TrackCropView.j(this.NDH.NDE) - i);
            }
            localSliderSeekBar = this.NDH.NDE.getSeekSlider();
            if (localSliderSeekBar != null) {
              localSliderSeekBar.b(false, TrackCropView.g(this.NDH.NDE) + (float)TrackCropView.d(this.NDH.NDE) * TrackCropView.j(this.NDH.NDE) - i);
            }
            TrackCropView.s(this.NDH.NDE);
            AppMethodBeat.o(233282);
          }
        });
        AppMethodBeat.o(228204);
        return;
      }
      AppMethodBeat.o(228204);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView
 * JD-Core Version:    0.7.0.1
 */