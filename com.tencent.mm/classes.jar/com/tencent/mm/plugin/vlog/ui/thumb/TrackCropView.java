package com.tencent.mm.plugin.vlog.ui.thumb;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.n.a;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "maxCropDuration", "padding", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "seekSlider", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "setEnableLengthEdit", "", "enable", "", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"})
public final class TrackCropView
  extends FrameLayout
{
  private final b Lub;
  private int Lud;
  private final d LvA;
  private final d LvB;
  private int LvC;
  private int LvD;
  private Runnable LvE;
  private final n.a LvF;
  private a LvG;
  private final SliderSeekBar Lvt;
  private long Lvu;
  private long Lvv;
  private long Lvw;
  private float Lvx;
  private int Lvy;
  private int Lvz;
  private final String TAG;
  private long duration;
  private final RecyclerView fPw;
  private long glk;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  private final LinearLayoutManager wYJ;
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(201255);
    AppMethodBeat.o(201255);
  }
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(201254);
    this.TAG = "MicroMsg.TrackCropView";
    this.thumbHeight = 112;
    this.thumbWidth = 80;
    this.Lud = 1;
    this.Lvw = 1L;
    this.Lvx = 1.0F;
    paramAttributeSet = d.LvR;
    this.LvA = d.a.fZu();
    paramAttributeSet = d.LvR;
    this.LvB = d.a.fZu();
    View.inflate(paramContext, 2131496271, (ViewGroup)this);
    paramContext = findViewById(2131307901);
    k.g(paramContext, "findViewById(R.id.track_crop_thumb_recycler)");
    this.fPw = ((RecyclerView)paramContext);
    paramContext = findViewById(2131307900);
    k.g(paramContext, "findViewById(R.id.track_crop_slider_seek)");
    this.Lvt = ((SliderSeekBar)paramContext);
    this.Lvt.setMaskColor(1999383596);
    this.Lvt.setEnableHapticAtEdge(true);
    this.wYJ = new LinearLayoutManager(0);
    this.fPw.setLayoutManager((RecyclerView.i)this.wYJ);
    this.Lub = new b();
    this.fPw.setAdapter((RecyclerView.a)this.Lub);
    this.fPw.setItemAnimator(null);
    this.fPw.a((RecyclerView.m)new RecyclerView.m()
    {
      private boolean Lus;
      
      public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(201246);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt1);
        localb.lT(paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ado());
        super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
        AppMethodBeat.o(201246);
      }
      
      public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
      {
        AppMethodBeat.i(201245);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.be(paramAnonymousRecyclerView);
        localb.lT(paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ado());
        k.h(paramAnonymousRecyclerView, "recyclerView");
        ad.i(TrackCropView.r(this.LvH), "onScrollStateChanged: ".concat(String.valueOf(paramAnonymousInt)));
        super.b(paramAnonymousRecyclerView, paramAnonymousInt);
        if (paramAnonymousInt == 0)
        {
          TrackCropView.s(this.LvH);
          ad.i(TrackCropView.r(this.LvH), "onScrollStateChanged: " + TrackCropView.l(this.LvH) + ", " + TrackCropView.k(this.LvH));
          paramAnonymousRecyclerView = this.LvH.getCallback();
          if (paramAnonymousRecyclerView != null) {
            paramAnonymousRecyclerView.aE(TrackCropView.l(this.LvH), TrackCropView.k(this.LvH));
          }
          this.Lus = false;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(201245);
          return;
          if (paramAnonymousInt == 1)
          {
            if (!this.Lus)
            {
              paramAnonymousRecyclerView = this.LvH;
              paramAnonymousRecyclerView.setDragCnt(paramAnonymousRecyclerView.getDragCnt() + 1);
            }
            this.Lus = true;
          }
        }
      }
    });
    this.LvF = ((n.a)new n.a()
    {
      public final void cQD() {}
      
      public final void nj(boolean paramAnonymousBoolean) {}
      
      public final void yW(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(201247);
        Object localObject = this.LvH;
        ((TrackCropView)localObject).setCutCnt(((TrackCropView)localObject).getCutCnt() + 1);
        int j;
        int k;
        int i;
        if (paramAnonymousBoolean)
        {
          j = TrackCropView.q(this.LvH).getLeftSliderBound();
          k = TrackCropView.m(this.LvH).guK;
          TrackCropView.m(this.LvH).guK = TrackCropView.q(this.LvH).getLeftSliderBound();
          int m = TrackCropView.a(this.LvH).getChildCount();
          i = 0;
          if (i >= m) {
            break label337;
          }
          localObject = TrackCropView.a(this.LvH).getChildAt(i);
          TrackCropView.a(this.LvH);
          if (RecyclerView.bw((View)localObject) != 0) {}
        }
        for (;;)
        {
          TrackCropView.p(this.LvH).ck(0);
          if ((localObject != null) && (!(localObject instanceof FrameListView)))
          {
            i = ((View)localObject).getLeft();
            TrackCropView.o(this.LvH).af(0, i - (j - k));
          }
          for (;;)
          {
            TrackCropView.s(this.LvH);
            ad.i(TrackCropView.r(this.LvH), "onScrollStateChanged: " + TrackCropView.l(this.LvH) + ", " + TrackCropView.k(this.LvH));
            localObject = this.LvH.getCallback();
            if (localObject == null) {
              break label331;
            }
            ((TrackCropView.a)localObject).aE(TrackCropView.l(this.LvH), TrackCropView.k(this.LvH));
            AppMethodBeat.o(201247);
            return;
            i += 1;
            break;
            TrackCropView.n(this.LvH).guK = (TrackCropView.e(this.LvH) + TrackCropView.c(this.LvH) * 2 - TrackCropView.q(this.LvH).getRightSliderBound());
            TrackCropView.p(this.LvH).ck(TrackCropView.p(this.LvH).getItemCount() - 1);
          }
          label331:
          AppMethodBeat.o(201247);
          return;
          label337:
          localObject = null;
        }
      }
    });
    this.Lvt.setOnSliderTouchListener(this.LvF);
    AppMethodBeat.o(201254);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(201253);
    Object localObject1 = null;
    int j = this.fPw.getChildCount();
    int i = 0;
    Object localObject2;
    long l;
    if (i < j)
    {
      localObject2 = this.fPw.getChildAt(i);
      if ((localObject2 instanceof FrameListView))
      {
        int k = RecyclerView.bw((View)localObject2);
        localObject1 = localObject2;
        if (k >= 0)
        {
          localObject1 = localObject2;
          if (k < this.Lub.getItemCount()) {
            l = this.Lub.aii(k).LqI.bxw;
          }
        }
      }
    }
    for (;;)
    {
      if (localObject2 == null)
      {
        AppMethodBeat.o(201253);
        return 0L;
        i += 1;
        break;
      }
      l = (((View)localObject2).getLeft() / this.Lvx + (float)l);
      AppMethodBeat.o(201253);
      return l;
      l = 0L;
      localObject2 = localObject1;
    }
  }
  
  public final a getCallback()
  {
    return this.LvG;
  }
  
  public final int getCutCnt()
  {
    return this.LvD;
  }
  
  public final int getDragCnt()
  {
    return this.LvC;
  }
  
  public final void setCallback(a parama)
  {
    this.LvG = parama;
  }
  
  public final void setCutCnt(int paramInt)
  {
    this.LvD = paramInt;
  }
  
  public final void setDragCnt(int paramInt)
  {
    this.LvC = paramInt;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    AppMethodBeat.i(201250);
    if (paramBoolean)
    {
      this.Lvt.fXV();
      AppMethodBeat.o(201250);
      return;
    }
    this.Lvt.fXU();
    AppMethodBeat.o(201250);
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(201252);
    float f = this.padding / this.Lvx;
    this.Lvt.setCursorPos((float)(getScrollTime() + paramLong) / (f * 2.0F + (float)this.Lvu));
    AppMethodBeat.o(201252);
  }
  
  public final void setTrack(v paramv)
  {
    long l = 60000L;
    AppMethodBeat.i(201251);
    k.h(paramv, "composition");
    this.LvC = 0;
    this.LvD = 0;
    final LinkedList localLinkedList = new LinkedList();
    this.Lud = 0;
    this.glk = 0L;
    this.duration = paramv.fYH();
    Object localObject1 = paramv.fYI();
    if (this.duration > 60000L) {}
    for (;;)
    {
      this.Lvu = l;
      this.Lvv = (((CMTimeRange)localObject1).getStartUs() / 1000L);
      this.Lvw = (((CMTimeRange)localObject1).getEndUs() / 1000L);
      localObject1 = (Iterable)paramv.LqL;
      paramv = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fvx();
        }
        localObject2 = new d((y)localObject2);
        ((d)localObject2).trackIndex = i;
        ((d)localObject2).height = this.thumbHeight;
        ((d)localObject2).width = this.thumbWidth;
        paramv.add(localObject2);
        i += 1;
      }
      l = this.duration;
    }
    localLinkedList.addAll((Collection)paramv);
    if (localLinkedList.size() == 1) {
      localLinkedList.get(0);
    }
    this.LvE = ((Runnable)new b(this, localLinkedList));
    paramv = this.LvE;
    if (paramv != null)
    {
      paramv.run();
      AppMethodBeat.o(201251);
      return;
    }
    AppMethodBeat.o(201251);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "", "onCrop", "", "start", "", "end", "plugin-vlog_release"})
  public static abstract interface a
  {
    public abstract void aE(long paramLong1, long paramLong2);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(TrackCropView paramTrackCropView, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(201249);
      if (TrackCropView.a(this.LvH).getWidth() <= 0)
      {
        TrackCropView.a(this.LvH).post(TrackCropView.b(this.LvH));
        AppMethodBeat.o(201249);
        return;
      }
      TrackCropView.a(this.LvH, com.tencent.mm.cd.a.fromDPToPix(this.LvH.getContext(), 40));
      float f = TrackCropView.a(this.LvH).getHeight() * 1.0F / TrackCropView.d(this.LvH);
      TrackCropView.b(this.LvH, TrackCropView.a(this.LvH).getWidth() - TrackCropView.c(this.LvH) * 2);
      TrackCropView.a(this.LvH, TrackCropView.e(this.LvH) * 1.0F / (float)TrackCropView.g(this.LvH));
      TrackCropView.c(this.LvH, (int)(TrackCropView.f(this.LvH) * (float)TrackCropView.i(this.LvH)));
      f = TrackCropView.h(this.LvH) / (f * TrackCropView.j(this.LvH));
      Iterator localIterator = ((Iterable)localLinkedList).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        locald.LvN = (f / (float)TrackCropView.i(this.LvH) * (float)locald.fZr());
        locald.fZs();
      }
      f = (TrackCropView.a(this.LvH).getWidth() / TrackCropView.f(this.LvH) - (float)(TrackCropView.k(this.LvH) - TrackCropView.l(this.LvH))) / 2.0F;
      TrackCropView.m(this.LvH).guK = ((int)(TrackCropView.f(this.LvH) * f));
      TrackCropView.n(this.LvH).guK = ((int)(f * TrackCropView.f(this.LvH)));
      int i = (int)((float)TrackCropView.l(this.LvH) * TrackCropView.f(this.LvH));
      TrackCropView.o(this.LvH).af(0, -i);
      localLinkedList.add(0, TrackCropView.m(this.LvH));
      localLinkedList.add(TrackCropView.n(this.LvH));
      TrackCropView.p(this.LvH).fX((List)localLinkedList);
      TrackCropView.p(this.LvH).notifyDataSetChanged();
      TrackCropView.q(this.LvH).bb(TrackCropView.a(this.LvH).getWidth() - TrackCropView.c(this.LvH) * 2, (int)((float)this.LvJ * TrackCropView.f(this.LvH)), TrackCropView.c(this.LvH));
      TrackCropView.q(this.LvH).setCursorPos(0.0F);
      TrackCropView.q(this.LvH).post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(201248);
          TrackCropView.q(this.LvK.LvH).d(true, TrackCropView.m(this.LvK.LvH).guK);
          TrackCropView.q(this.LvK.LvH).d(false, TrackCropView.c(this.LvK.LvH) * 2 + TrackCropView.e(this.LvK.LvH) - TrackCropView.n(this.LvK.LvH).guK);
          AppMethodBeat.o(201248);
        }
      });
      AppMethodBeat.o(201249);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView
 * JD-Core Version:    0.7.0.1
 */