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
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar;
import com.tencent.mm.plugin.mmsight.segment.SliderSeekBar.a;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "callback", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "getCallback", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "setCallback", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;)V", "cutCnt", "getCutCnt", "()I", "setCutCnt", "(I)V", "dragCnt", "getDragCnt", "setDragCnt", "duration", "", "endEmptyTrack", "Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackThumbInfo;", "endInTrack", "frameAdapter", "Lcom/tencent/mm/plugin/vlog/ui/thumb/FrameListAdapter;", "lastTime", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "maxCropDuration", "padding", "playWaitIdle", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "runOnSize", "Ljava/lang/Runnable;", "<set-?>", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSlider", "getSeekSlider", "()Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar;", "seekSliderListener", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "seekSliderReady", "sizePerTime", "", "startEmptyTrack", "startInTrack", "thumbCropMaxWidth", "thumbDisplayWidth", "thumbHeight", "thumbWidth", "totalWidth", "getScrollTime", "onFinishInflate", "", "setEnableLengthEdit", "enable", "setProgress", "timeMs", "setTrack", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "initStart", "initEnd", "Lcom/tencent/mm/videocomposition/VideoComposition;", "updateTrackCrop", "OnCropCallback", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TrackCropView
  extends FrameLayout
{
  private LinearLayoutManager AJH;
  private int Bdl;
  private float MfY;
  private final String TAG;
  private f UmE;
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
  private boolean UpO;
  private SliderSeekBar UpZ;
  private boolean Uqa;
  private SliderSeekBar.a Uqb;
  private a Uqc;
  private long duration;
  private long mJI;
  private RecyclerView mkw;
  private int padding;
  private int thumbHeight;
  private int thumbWidth;
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(281629);
    AppMethodBeat.o(281629);
  }
  
  public TrackCropView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(281619);
    this.TAG = "MicroMsg.TrackCropView";
    this.AJH = new LinearLayoutManager(0, false);
    this.UmE = new f();
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.Bdl = 1;
    this.UmI = 1L;
    this.MfY = 1.0F;
    paramContext = h.Uqf;
    this.UmL = h.a.hUs();
    paramContext = h.Uqf;
    this.UmM = h.a.hUs();
    AppMethodBeat.o(281619);
  }
  
  private static final void a(TrackCropView paramTrackCropView, int paramInt)
  {
    AppMethodBeat.i(281678);
    s.u(paramTrackCropView, "this$0");
    SliderSeekBar localSliderSeekBar = paramTrackCropView.getSeekSlider();
    if (localSliderSeekBar != null) {
      localSliderSeekBar.b(true, paramTrackCropView.padding + (float)paramTrackCropView.UmH * paramTrackCropView.MfY - paramInt);
    }
    localSliderSeekBar = paramTrackCropView.getSeekSlider();
    if (localSliderSeekBar != null) {
      localSliderSeekBar.b(false, paramTrackCropView.padding + (float)paramTrackCropView.UmI * paramTrackCropView.MfY - paramInt);
    }
    paramTrackCropView.Uqa = true;
    AppMethodBeat.o(281678);
  }
  
  private static final void a(TrackCropView paramTrackCropView, LinkedList paramLinkedList, long paramLong)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(281698);
    s.u(paramTrackCropView, "this$0");
    s.u(paramLinkedList, "$trackList");
    RecyclerView localRecyclerView = paramTrackCropView.mkw;
    Object localObject1 = localRecyclerView;
    if (localRecyclerView == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
    }
    if (((RecyclerView)localObject1).getWidth() <= 0)
    {
      paramLinkedList = paramTrackCropView.mkw;
      if (paramLinkedList == null)
      {
        s.bIx("recyclerView");
        paramLinkedList = (LinkedList)localObject3;
      }
      for (;;)
      {
        paramLinkedList.post(paramTrackCropView.UmP);
        AppMethodBeat.o(281698);
        return;
      }
    }
    paramTrackCropView.padding = com.tencent.mm.cd.a.fromDPToPix(paramTrackCropView.getContext(), 40);
    localObject3 = paramTrackCropView.mkw;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
    }
    float f = ((RecyclerView)localObject1).getHeight() * 1.0F / paramTrackCropView.thumbHeight;
    localObject3 = paramTrackCropView.mkw;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
    }
    paramTrackCropView.UmJ = (((RecyclerView)localObject1).getWidth() - paramTrackCropView.padding * 2);
    paramTrackCropView.MfY = (paramTrackCropView.UmJ * 1.0F / (float)paramTrackCropView.UmG);
    paramTrackCropView.UmK = ((int)(paramTrackCropView.MfY * (float)paramTrackCropView.duration));
    f = paramTrackCropView.UmK / (f * paramTrackCropView.thumbWidth);
    localObject1 = ((Iterable)paramLinkedList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (h)((Iterator)localObject1).next();
      ((a)localObject3).UoR = (f / (float)paramTrackCropView.duration * (float)((h)localObject3).hUo() / ((h)localObject3).Uqg.UaI.sAn);
      ((h)localObject3).hUp();
      Log.d(paramTrackCropView.TAG, "build thumbInfo index:" + ((a)localObject3).trackIndex + ", frameCount:" + ((a)localObject3).UoR + ", frameDuration:" + ((h)localObject3).hUo() + ", frameWidth:" + (float)((h)localObject3).hUo() * paramTrackCropView.MfY);
    }
    paramTrackCropView.UmL.mWn = paramTrackCropView.padding;
    paramTrackCropView.UmM.mWn = paramTrackCropView.padding;
    int i = Math.max(0, Math.min((int)((float)paramTrackCropView.UmH * paramTrackCropView.MfY), (int)((float)paramTrackCropView.UmI * paramTrackCropView.MfY - paramTrackCropView.UmJ)));
    paramTrackCropView.AJH.bo(0, -i);
    paramLinkedList.add(0, paramTrackCropView.UmL);
    paramLinkedList.add(paramTrackCropView.UmM);
    paramTrackCropView.UmE.hM((List)paramLinkedList);
    paramTrackCropView.UmE.bZE.notifyChanged();
    localObject1 = paramTrackCropView.getSeekSlider();
    if (localObject1 != null)
    {
      paramLinkedList = paramTrackCropView.mkw;
      if (paramLinkedList != null) {
        break label595;
      }
      s.bIx("recyclerView");
      paramLinkedList = localObject2;
    }
    label595:
    for (;;)
    {
      ((SliderSeekBar)localObject1).aR(paramLinkedList.getWidth() - paramTrackCropView.padding * 2, (int)((float)paramLong * paramTrackCropView.MfY), paramTrackCropView.padding);
      paramLinkedList = paramTrackCropView.getSeekSlider();
      if (paramLinkedList != null) {
        paramLinkedList.setCursorPos(0.0F);
      }
      paramLinkedList = paramTrackCropView.getSeekSlider();
      if (paramLinkedList != null) {
        paramLinkedList.post(new TrackCropView..ExternalSyntheticLambda0(paramTrackCropView, i));
      }
      AppMethodBeat.o(281698);
      return;
    }
  }
  
  private static final void b(TrackCropView paramTrackCropView, int paramInt)
  {
    AppMethodBeat.i(281709);
    s.u(paramTrackCropView, "this$0");
    SliderSeekBar localSliderSeekBar = paramTrackCropView.getSeekSlider();
    if (localSliderSeekBar != null) {
      localSliderSeekBar.b(true, paramTrackCropView.padding + (float)paramTrackCropView.UmH * paramTrackCropView.MfY - paramInt);
    }
    localSliderSeekBar = paramTrackCropView.getSeekSlider();
    if (localSliderSeekBar != null) {
      localSliderSeekBar.b(false, paramTrackCropView.padding + (float)paramTrackCropView.UmI * paramTrackCropView.MfY - paramInt);
    }
    paramTrackCropView.Uqa = true;
    AppMethodBeat.o(281709);
  }
  
  private static final void b(TrackCropView paramTrackCropView, LinkedList paramLinkedList, long paramLong)
  {
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(281729);
    s.u(paramTrackCropView, "this$0");
    s.u(paramLinkedList, "$trackList");
    RecyclerView localRecyclerView = paramTrackCropView.mkw;
    Object localObject1 = localRecyclerView;
    if (localRecyclerView == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
    }
    if (((RecyclerView)localObject1).getWidth() <= 0)
    {
      paramLinkedList = paramTrackCropView.mkw;
      if (paramLinkedList == null)
      {
        s.bIx("recyclerView");
        paramLinkedList = (LinkedList)localObject3;
      }
      for (;;)
      {
        paramLinkedList.post(paramTrackCropView.UmP);
        AppMethodBeat.o(281729);
        return;
      }
    }
    paramTrackCropView.padding = com.tencent.mm.cd.a.fromDPToPix(paramTrackCropView.getContext(), 40);
    localObject3 = paramTrackCropView.mkw;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
    }
    float f = ((RecyclerView)localObject1).getHeight() * 1.0F / paramTrackCropView.thumbHeight;
    localObject3 = paramTrackCropView.mkw;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
    }
    paramTrackCropView.UmJ = (((RecyclerView)localObject1).getWidth() - paramTrackCropView.padding * 2);
    paramTrackCropView.MfY = (paramTrackCropView.UmJ * 1.0F / (float)paramTrackCropView.UmG);
    paramTrackCropView.UmK = ((int)(paramTrackCropView.MfY * (float)paramTrackCropView.duration));
    f = paramTrackCropView.UmK / (f * paramTrackCropView.thumbWidth);
    localObject1 = ((Iterable)paramLinkedList).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (h)((Iterator)localObject1).next();
      ((a)localObject3).UoR = (f / (float)paramTrackCropView.duration * (float)((h)localObject3).hUo() / ((h)localObject3).Uqg.UaI.sAn);
      ((h)localObject3).hUp();
      Log.d(paramTrackCropView.TAG, "build thumbInfo index:" + ((a)localObject3).trackIndex + ", frameCount:" + ((a)localObject3).UoR + ", frameDuration:" + ((h)localObject3).hUo() + ", frameWidth:" + (float)((h)localObject3).hUo() * paramTrackCropView.MfY);
    }
    paramTrackCropView.UmL.mWn = paramTrackCropView.padding;
    paramTrackCropView.UmM.mWn = paramTrackCropView.padding;
    int i = Math.max(0, Math.min((int)((float)paramTrackCropView.UmH * paramTrackCropView.MfY), (int)((float)paramTrackCropView.UmI * paramTrackCropView.MfY - paramTrackCropView.UmJ)));
    paramTrackCropView.AJH.bo(0, -i);
    paramLinkedList.add(0, paramTrackCropView.UmL);
    paramLinkedList.add(paramTrackCropView.UmM);
    paramTrackCropView.UmE.hM((List)paramLinkedList);
    paramTrackCropView.UmE.bZE.notifyChanged();
    localObject1 = paramTrackCropView.getSeekSlider();
    if (localObject1 != null)
    {
      paramLinkedList = paramTrackCropView.mkw;
      if (paramLinkedList != null) {
        break label595;
      }
      s.bIx("recyclerView");
      paramLinkedList = localObject2;
    }
    label595:
    for (;;)
    {
      ((SliderSeekBar)localObject1).aR(paramLinkedList.getWidth() - paramTrackCropView.padding * 2, (int)((float)paramLong * paramTrackCropView.MfY), paramTrackCropView.padding);
      paramLinkedList = paramTrackCropView.getSeekSlider();
      if (paramLinkedList != null) {
        paramLinkedList.setCursorPos(0.0F);
      }
      paramLinkedList = paramTrackCropView.getSeekSlider();
      if (paramLinkedList != null) {
        paramLinkedList.post(new TrackCropView..ExternalSyntheticLambda1(paramTrackCropView, i));
      }
      AppMethodBeat.o(281729);
      return;
    }
  }
  
  private final long getScrollTime()
  {
    AppMethodBeat.i(281667);
    Object localObject2 = this.mkw;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
    }
    int k = localObject1.getChildCount();
    int i;
    int j;
    long l;
    if (k > 0)
    {
      i = 0;
      localObject1 = null;
      j = i + 1;
      RecyclerView localRecyclerView = this.mkw;
      localObject2 = localRecyclerView;
      if (localRecyclerView == null)
      {
        s.bIx("recyclerView");
        localObject2 = null;
      }
      localObject2 = ((RecyclerView)localObject2).getChildAt(i);
      if ((localObject2 instanceof FrameListView))
      {
        if (this.mkw == null) {
          s.bIx("recyclerView");
        }
        i = RecyclerView.bA((View)localObject2);
        if ((i >= 0) && (i < this.UmE.getItemCount()))
        {
          l = this.UmE.apO(i).getStartTimeMs();
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(281667);
        return 0L;
        localObject1 = localObject2;
        if (j >= k) {
          l = 0L;
        }
      }
      else
      {
        l = (-localObject1.getLeft() / this.MfY + (float)l);
        AppMethodBeat.o(281667);
        return l;
      }
      i = j;
      break;
      l = 0L;
      localObject1 = null;
    }
  }
  
  public final a getCallback()
  {
    return this.Uqc;
  }
  
  public final int getCutCnt()
  {
    return this.UmO;
  }
  
  public final int getDragCnt()
  {
    return this.UmN;
  }
  
  public final SliderSeekBar getSeekSlider()
  {
    return this.UpZ;
  }
  
  protected final void onFinishInflate()
  {
    Object localObject2 = null;
    AppMethodBeat.i(281908);
    super.onFinishInflate();
    Object localObject1 = findViewById(a.f.track_crop_thumb_recycler);
    s.s(localObject1, "findViewById(R.id.track_crop_thumb_recycler)");
    this.mkw = ((RecyclerView)localObject1);
    this.UpZ = ((SliderSeekBar)findViewById(a.f.track_crop_slider_seek));
    localObject1 = this.UpZ;
    if (localObject1 != null) {
      ((SliderSeekBar)localObject1).setMaskColor(1999383596);
    }
    localObject1 = this.UpZ;
    if (localObject1 != null) {
      ((SliderSeekBar)localObject1).setEnableHapticAtEdge(true);
    }
    localObject1 = this.mkw;
    if (localObject1 == null)
    {
      s.bIx("recyclerView");
      localObject1 = null;
      ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)this.AJH);
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label265;
      }
      s.bIx("recyclerView");
      localObject1 = null;
      label124:
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.UmE);
      RecyclerView localRecyclerView = this.mkw;
      localObject1 = localRecyclerView;
      if (localRecyclerView == null)
      {
        s.bIx("recyclerView");
        localObject1 = null;
      }
      ((RecyclerView)localObject1).setItemAnimator(null);
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label268;
      }
      s.bIx("recyclerView");
      localObject1 = null;
      label176:
      ((RecyclerView)localObject1).a((RecyclerView.l)new b(this));
      localObject1 = this.mkw;
      if (localObject1 != null) {
        break label271;
      }
      s.bIx("recyclerView");
      localObject1 = localObject2;
    }
    label265:
    label268:
    label271:
    for (;;)
    {
      ((RecyclerView)localObject1).a((RecyclerView.k)new c(this));
      this.Uqb = ((SliderSeekBar.a)new d(this));
      localObject1 = this.UpZ;
      if (localObject1 != null) {
        ((SliderSeekBar)localObject1).setOnSliderTouchListener(this.Uqb);
      }
      AppMethodBeat.o(281908);
      return;
      break;
      break label124;
      break label176;
    }
  }
  
  public final void setCallback(a parama)
  {
    this.Uqc = parama;
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
    SliderSeekBar localSliderSeekBar;
    if (paramBoolean)
    {
      localSliderSeekBar = this.UpZ;
      if (localSliderSeekBar != null) {
        localSliderSeekBar.KYv = false;
      }
    }
    do
    {
      return;
      localSliderSeekBar = this.UpZ;
    } while (localSliderSeekBar == null);
    localSliderSeekBar.KYv = true;
  }
  
  public final void setProgress(long paramLong)
  {
    AppMethodBeat.i(281947);
    float f = this.padding / this.MfY;
    SliderSeekBar localSliderSeekBar = this.UpZ;
    if (localSliderSeekBar != null) {
      localSliderSeekBar.setCursorPos((float)(paramLong - getScrollTime()) / (f * 2.0F + (float)this.UmG));
    }
    AppMethodBeat.o(281947);
  }
  
  public final void setTrack(j paramj)
  {
    AppMethodBeat.i(281938);
    s.u(paramj, "composition");
    this.UmN = 0;
    this.UmO = 0;
    LinkedList localLinkedList = new LinkedList();
    this.Bdl = 0;
    this.mJI = 0L;
    long l2 = ((com.tencent.mm.videocomposition.b)p.oK((List)paramj.TDz)).TDw;
    long l3 = paramj.getSourceDuration();
    this.duration = (((com.tencent.mm.videocomposition.b)p.oM((List)paramj.TDz)).UjZ - ((com.tencent.mm.videocomposition.b)p.oM((List)paramj.TDz)).TDx + (paramj.getSourceDuration() + l2));
    long l1;
    Collection localCollection;
    int i;
    label187:
    Object localObject2;
    boolean bool1;
    if (this.duration > 60000L)
    {
      l1 = 60000L;
      this.UmG = l1;
      this.UmH = l2;
      this.UmI = (l2 + l3);
      Object localObject1 = (Iterable)paramj.TDz;
      localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      if (!((Iterator)localObject1).hasNext()) {
        break label324;
      }
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (com.tencent.mm.videocomposition.b)localObject2;
      if (i != 0) {
        break label312;
      }
      bool1 = true;
      label227:
      if (i != ((List)paramj.TDz).size() - 1) {
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
    this.Uqa = false;
    this.UmP = new TrackCropView..ExternalSyntheticLambda2(this, localLinkedList, 1000L);
    paramj = this.UmP;
    if (paramj != null) {
      paramj.run();
    }
    AppMethodBeat.o(281938);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$OnCropCallback;", "", "onCrop", "", "start", "", "end", "onUpdate", "pause", "seekTo", "time", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void bA(long paramLong1, long paramLong2);
    
    public abstract void bz(long paramLong1, long paramLong2);
    
    public abstract void pause();
    
    public abstract void seekTo(long paramLong);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "dragScroll", "", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "onScrolled", "dx", "dy", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends RecyclerView.l
  {
    private boolean Uqd;
    
    b(TrackCropView paramTrackCropView) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(281638);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      Log.i(TrackCropView.a(this.Uqe), s.X("onScrollStateChanged: ", Integer.valueOf(paramInt)));
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      switch (paramInt)
      {
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
        AppMethodBeat.o(281638);
        return;
        TrackCropView.b(this.Uqe);
        Log.i(TrackCropView.a(this.Uqe), "onScrollStateChanged: " + TrackCropView.c(this.Uqe) + ", " + TrackCropView.d(this.Uqe));
        paramRecyclerView = this.Uqe.getCallback();
        if (paramRecyclerView != null) {
          paramRecyclerView.bz(TrackCropView.c(this.Uqe), TrackCropView.d(this.Uqe));
        }
        TrackCropView.a(this.Uqe, false);
        this.Uqd = false;
        continue;
        if (!this.Uqd)
        {
          paramRecyclerView = this.Uqe;
          paramRecyclerView.setDragCnt(paramRecyclerView.getDragCnt() + 1);
        }
        this.Uqd = true;
      }
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(281644);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      TrackCropView.b(this.Uqe);
      Log.i(TrackCropView.a(this.Uqe), "onScroll: range: " + TrackCropView.c(this.Uqe) + ", " + TrackCropView.d(this.Uqe));
      paramRecyclerView = this.Uqe.getCallback();
      if (paramRecyclerView != null) {
        paramRecyclerView.seekTo(TrackCropView.c(this.Uqe));
      }
      this.Uqe.setProgress(TrackCropView.c(this.Uqe));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(281644);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$2", "Landroidx/recyclerview/widget/RecyclerView$SimpleOnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroid/view/MotionEvent;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends RecyclerView.q
  {
    c(TrackCropView paramTrackCropView) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(281630);
      s.u(paramRecyclerView, "rv");
      s.u(paramMotionEvent, "e");
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(281630);
        return false;
        paramRecyclerView = this.Uqe.getCallback();
        if (paramRecyclerView != null)
        {
          paramRecyclerView.pause();
          continue;
          paramMotionEvent = TrackCropView.e(this.Uqe);
          paramRecyclerView = paramMotionEvent;
          if (paramMotionEvent == null)
          {
            s.bIx("recyclerView");
            paramRecyclerView = null;
          }
          if (paramRecyclerView.getScrollState() == 0)
          {
            TrackCropView.b(this.Uqe);
            Log.i(TrackCropView.a(this.Uqe), "onInterceptTouchEvent crop: " + TrackCropView.c(this.Uqe) + ", " + TrackCropView.d(this.Uqe));
            paramRecyclerView = this.Uqe.getCallback();
            if (paramRecyclerView != null) {
              paramRecyclerView.bz(TrackCropView.c(this.Uqe), TrackCropView.d(this.Uqe));
            }
            TrackCropView.a(this.Uqe, false);
          }
          else
          {
            TrackCropView.a(this.Uqe, true);
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/thumb/TrackCropView$onFinishInflate$3", "Lcom/tencent/mm/plugin/mmsight/segment/SliderSeekBar$OnSliderTouchListener;", "onDown", "", "left", "", "onMove", "onUp", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements SliderSeekBar.a
  {
    d(TrackCropView paramTrackCropView) {}
    
    public final void yA(boolean paramBoolean)
    {
      AppMethodBeat.i(281648);
      TrackCropView.b(this.Uqe);
      Log.i(TrackCropView.a(this.Uqe), "onMove: " + paramBoolean + ", " + TrackCropView.c(this.Uqe) + ", " + TrackCropView.d(this.Uqe));
      TrackCropView.a locala = this.Uqe.getCallback();
      if (locala != null) {
        locala.bA(TrackCropView.c(this.Uqe), TrackCropView.d(this.Uqe));
      }
      if (paramBoolean)
      {
        locala = this.Uqe.getCallback();
        if (locala != null) {
          locala.seekTo(TrackCropView.c(this.Uqe));
        }
        this.Uqe.setProgress(TrackCropView.c(this.Uqe));
        AppMethodBeat.o(281648);
        return;
      }
      locala = this.Uqe.getCallback();
      if (locala != null) {
        locala.seekTo(TrackCropView.d(this.Uqe));
      }
      this.Uqe.setProgress(TrackCropView.d(this.Uqe));
      AppMethodBeat.o(281648);
    }
    
    public final void yx(boolean paramBoolean)
    {
      AppMethodBeat.i(281631);
      TrackCropView.a locala = this.Uqe.getCallback();
      if (locala != null) {
        locala.pause();
      }
      AppMethodBeat.o(281631);
    }
    
    public final void yy(boolean paramBoolean)
    {
      AppMethodBeat.i(281640);
      Object localObject = this.Uqe;
      ((TrackCropView)localObject).setCutCnt(((TrackCropView)localObject).getCutCnt() + 1);
      TrackCropView.b(this.Uqe);
      Log.i(TrackCropView.a(this.Uqe), "onScrollStateChanged: " + TrackCropView.c(this.Uqe) + ", " + TrackCropView.d(this.Uqe));
      localObject = this.Uqe.getCallback();
      if (localObject != null) {
        ((TrackCropView.a)localObject).bz(TrackCropView.c(this.Uqe), TrackCropView.d(this.Uqe));
      }
      AppMethodBeat.o(281640);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.thumb.TrackCropView
 * JD-Core Version:    0.7.0.1
 */