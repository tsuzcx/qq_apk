package com.tencent.mm.plugin.vlog.ui.plugin.timecrop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
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
import com.tencent.mm.videocomposition.j;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "maxCropDuration", "padding", "realTimeCallback", "getRealTimeCallback", "setRealTimeCallback", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "onLayout", "changed", "", "left", "top", "right", "bottom", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TimeCropViewGroup
  extends FrameLayout
{
  private LinearLayoutManager AJH;
  private int Bdl;
  private float MfY;
  private final String TAG;
  private f UmE;
  private TimeCropSliderSeekBar UmF;
  private long UmG;
  private long UmH;
  private long UmI;
  private int UmJ;
  private int UmK;
  private final h UmL;
  private final h UmM;
  private int UmN;
  private int UmO;
  private Runnable UmP;
  private TimeCropSliderSeekBar.a UmQ;
  private a UmR;
  private a UmS;
  private long duration;
  private long mJI;
  private RecyclerView mkw;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(282964);
    AppMethodBeat.o(282964);
  }
  
  public TimeCropViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(282957);
    this.TAG = "MicroMsg.TrackCropView";
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.Bdl = 1;
    this.UmI = 1L;
    this.MfY = 1.0F;
    paramContext = h.Uqf;
    this.UmL = h.a.hUs();
    paramContext = h.Uqf;
    this.UmM = h.a.hUs();
    AppMethodBeat.o(282957);
  }
  
  private static final void a(TimeCropViewGroup paramTimeCropViewGroup, LinkedList paramLinkedList, long paramLong)
  {
    AppMethodBeat.i(282991);
    s.u(paramTimeCropViewGroup, "this$0");
    s.u(paramLinkedList, "$trackList");
    RecyclerView localRecyclerView = paramTimeCropViewGroup.mkw;
    if (localRecyclerView != null)
    {
      if (localRecyclerView.getWidth() <= 0)
      {
        localRecyclerView.post(paramTimeCropViewGroup.UmP);
        AppMethodBeat.o(282991);
        return;
      }
      paramTimeCropViewGroup.padding = com.tencent.mm.cd.a.fromDPToPix(paramTimeCropViewGroup.getContext(), 40);
      float f = localRecyclerView.getHeight() * 1.0F / paramTimeCropViewGroup.thumbHeight;
      paramTimeCropViewGroup.UmJ = (localRecyclerView.getWidth() - paramTimeCropViewGroup.padding * 2);
      paramTimeCropViewGroup.MfY = (paramTimeCropViewGroup.UmJ * 1.0F / (float)paramTimeCropViewGroup.UmG);
      paramTimeCropViewGroup.UmK = ((int)(paramTimeCropViewGroup.MfY * (float)paramTimeCropViewGroup.duration));
      f = paramTimeCropViewGroup.UmK / (f * paramTimeCropViewGroup.thumbWidth);
      Object localObject = ((Iterable)paramLinkedList).iterator();
      while (((Iterator)localObject).hasNext())
      {
        h localh = (h)((Iterator)localObject).next();
        localh.UoR = (f / (float)paramTimeCropViewGroup.duration * (float)localh.hUo() / localh.Uqg.UaI.sAn);
        localh.hUp();
      }
      paramTimeCropViewGroup.UmL.mWn = paramTimeCropViewGroup.padding;
      paramTimeCropViewGroup.UmM.mWn = paramTimeCropViewGroup.padding;
      paramLinkedList.add(0, paramTimeCropViewGroup.UmL);
      paramLinkedList.add(paramTimeCropViewGroup.UmM);
      localObject = paramTimeCropViewGroup.UmE;
      if (localObject != null) {
        ((f)localObject).hM((List)paramLinkedList);
      }
      paramLinkedList = paramTimeCropViewGroup.UmE;
      if (paramLinkedList != null) {
        paramLinkedList.bZE.notifyChanged();
      }
      paramLinkedList = paramTimeCropViewGroup.getSeekSlider();
      if (paramLinkedList != null)
      {
        int i = localRecyclerView.getWidth();
        int j = paramTimeCropViewGroup.padding;
        int k = (int)((float)paramLong * paramTimeCropViewGroup.MfY);
        paramLinkedList.post(new TimeCropSliderSeekBar.1(paramLinkedList, i - j * 2, paramTimeCropViewGroup.padding, k));
      }
      paramLinkedList = paramTimeCropViewGroup.getSeekSlider();
      if (paramLinkedList != null) {
        paramLinkedList.setCursorPos(0.0F);
      }
      paramLinkedList = paramTimeCropViewGroup.getSeekSlider();
      if (paramLinkedList != null) {
        paramLinkedList.post(new TimeCropViewGroup..ExternalSyntheticLambda0(paramTimeCropViewGroup));
      }
    }
    AppMethodBeat.o(282991);
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(282969);
    RecyclerView localRecyclerView = this.mkw;
    int i;
    int k;
    Object localObject;
    int j;
    View localView;
    long l;
    if (localRecyclerView != null)
    {
      i = 0;
      k = localRecyclerView.getChildCount();
      if (k > 0)
      {
        localObject = null;
        j = i + 1;
        localView = localRecyclerView.getChildAt(i);
        if ((localView instanceof FrameListView))
        {
          i = RecyclerView.bA(localView);
          if (i >= 0)
          {
            localObject = this.UmE;
            s.checkNotNull(localObject);
            if (i < ((f)localObject).getItemCount())
            {
              localObject = this.UmE;
              s.checkNotNull(localObject);
              l = ((f)localObject).apO(i).getStartTimeMs();
              localObject = localView;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(282969);
        return 0L;
        localObject = localView;
        if (j >= k) {
          l = 0L;
        }
      }
      else
      {
        l = (((View)localObject).getLeft() / this.MfY + (float)l);
        AppMethodBeat.o(282969);
        return l;
      }
      i = j;
      break;
      l = 0L;
      localObject = null;
    }
  }
  
  private static final void setTrack$lambda-4$lambda-3$lambda-2(TimeCropViewGroup paramTimeCropViewGroup)
  {
    AppMethodBeat.i(282977);
    s.u(paramTimeCropViewGroup, "this$0");
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = paramTimeCropViewGroup.getSeekSlider();
    if (localTimeCropSliderSeekBar != null) {
      localTimeCropSliderSeekBar.b(true, paramTimeCropViewGroup.padding + (float)paramTimeCropViewGroup.UmH * paramTimeCropViewGroup.MfY);
    }
    localTimeCropSliderSeekBar = paramTimeCropViewGroup.getSeekSlider();
    if (localTimeCropSliderSeekBar != null) {
      localTimeCropSliderSeekBar.b(false, paramTimeCropViewGroup.padding + (float)paramTimeCropViewGroup.UmI * paramTimeCropViewGroup.MfY);
    }
    AppMethodBeat.o(282977);
  }
  
  public final void a(ac paramac, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(283086);
    s.u(paramac, "composition");
    this.UmN = 0;
    this.UmO = 0;
    LinkedList localLinkedList = new LinkedList();
    this.Bdl = 0;
    this.mJI = 0L;
    this.duration = paramac.getDurationMs();
    Object localObject1 = paramac.Uaw.jLV();
    this.UmG = paramac.getDurationMs();
    this.UmH = paramLong1;
    this.UmI = paramLong2;
    if ((paramLong1 < 0L) || (paramLong2 < 0L))
    {
      this.UmH = (((CMTimeRange)localObject1).getStartUs() / 1000L);
      this.UmI = (((CMTimeRange)localObject1).getEndUs() / 1000L);
    }
    localObject1 = (Iterable)paramac.hRb();
    paramac = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
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
    this.UmP = new TimeCropViewGroup..ExternalSyntheticLambda1(this, localLinkedList, 1000L);
    paramac = this.UmP;
    if (paramac != null) {
      paramac.run();
    }
    AppMethodBeat.o(283086);
  }
  
  public final a getCallback()
  {
    return this.UmR;
  }
  
  public final int getCutCnt()
  {
    return this.UmO;
  }
  
  public final int getDragCnt()
  {
    return this.UmN;
  }
  
  public final a getRealTimeCallback()
  {
    return this.UmS;
  }
  
  public final TimeCropSliderSeekBar getSeekSlider()
  {
    return this.UmF;
  }
  
  protected final void onFinishInflate()
  {
    AppMethodBeat.i(283058);
    super.onFinishInflate();
    this.mkw = ((RecyclerView)findViewById(a.f.track_crop_thumb_recycler));
    this.UmF = ((TimeCropSliderSeekBar)findViewById(a.f.track_crop_slider_seek));
    Object localObject = this.UmF;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setMaskColor(1999383596);
    }
    localObject = this.UmF;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setEnableHapticAtEdge(true);
    }
    getContext();
    this.AJH = new LinearLayoutManager(0, false);
    localObject = this.mkw;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)this.AJH);
    }
    this.UmE = new f();
    localObject = this.UmE;
    if (localObject != null) {
      ((f)localObject).UpA = true;
    }
    localObject = this.mkw;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)this.UmE);
    }
    localObject = this.mkw;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemAnimator(null);
    }
    this.UmQ = ((TimeCropSliderSeekBar.a)new b(this));
    localObject = this.UmF;
    if (localObject != null) {
      ((TimeCropSliderSeekBar)localObject).setOnSliderTouchListener(this.UmQ);
    }
    AppMethodBeat.o(283058);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    AppMethodBeat.i(283070);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Log.i(this.TAG, "onLayout");
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.UmF;
    RecyclerView localRecyclerView;
    if (localTimeCropSliderSeekBar != null)
    {
      localRecyclerView = this.mkw;
      if (localRecyclerView == null)
      {
        paramInt1 = 0;
        localTimeCropSliderSeekBar.setContentTop(paramInt1);
      }
    }
    else
    {
      localTimeCropSliderSeekBar = this.UmF;
      if (localTimeCropSliderSeekBar != null)
      {
        localRecyclerView = this.mkw;
        if (localRecyclerView != null) {
          break label107;
        }
      }
    }
    label107:
    for (paramInt1 = i;; paramInt1 = localRecyclerView.getMeasuredHeight())
    {
      localTimeCropSliderSeekBar.setContentHeight(paramInt1);
      AppMethodBeat.o(283070);
      return;
      paramInt1 = localRecyclerView.getTop();
      break;
    }
  }
  
  public final void setCallback(a parama)
  {
    this.UmR = parama;
  }
  
  public final void setCutCnt(int paramInt)
  {
    this.UmO = paramInt;
  }
  
  public final void setDragCnt(int paramInt)
  {
    this.UmN = paramInt;
  }
  
  public final void setEnableLengthEdit(boolean paramBoolean)
  {
    TimeCropSliderSeekBar localTimeCropSliderSeekBar;
    if (paramBoolean)
    {
      localTimeCropSliderSeekBar = this.UmF;
      if (localTimeCropSliderSeekBar != null) {
        localTimeCropSliderSeekBar.KYv = false;
      }
    }
    do
    {
      return;
      localTimeCropSliderSeekBar = this.UmF;
    } while (localTimeCropSliderSeekBar == null);
    localTimeCropSliderSeekBar.KYv = true;
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(283095);
    float f = this.padding / this.MfY;
    TimeCropSliderSeekBar localTimeCropSliderSeekBar = this.UmF;
    if (localTimeCropSliderSeekBar != null) {
      localTimeCropSliderSeekBar.setCursorPos((float)(getScrollTime() + paramLong) / (f * 2.0F + (float)this.UmG));
    }
    AppMethodBeat.o(283095);
  }
  
  public final void setRealTimeCallback(a parama)
  {
    this.UmS = parama;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUp", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void d(long paramLong1, long paramLong2, boolean paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropViewGroup$onFinishInflate$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/timecrop/TimeCropSliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TimeCropSliderSeekBar.a
  {
    b(TimeCropViewGroup paramTimeCropViewGroup) {}
    
    public final void hTW()
    {
      AppMethodBeat.i(282934);
      TimeCropViewGroup.a(this.UmT);
      TimeCropViewGroup.a locala = this.UmT.getCallback();
      if (locala != null) {
        locala.d(TimeCropViewGroup.b(this.UmT), TimeCropViewGroup.c(this.UmT), true);
      }
      AppMethodBeat.o(282934);
    }
    
    public final void hTX()
    {
      AppMethodBeat.i(282941);
      TimeCropViewGroup.a(this.UmT);
      TimeCropViewGroup.a locala = this.UmT.getRealTimeCallback();
      if (locala != null) {
        locala.d(TimeCropViewGroup.b(this.UmT), TimeCropViewGroup.c(this.UmT), false);
      }
      AppMethodBeat.o(282941);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.timecrop.TimeCropViewGroup
 * JD-Core Version:    0.7.0.1
 */