package com.tencent.mm.plugin.vlog.ui.plugin;

import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.transition.e;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.plugin.vlog.ui.widget.VLogThumbView;
import com.tencent.mm.plugin.vlog.ui.widget.VLogThumbView.b;
import com.tencent.mm.plugin.vlog.ui.widget.VLogThumbView.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.b;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "lastLogProgressTime", "", "getLayout", "()Landroid/view/View;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "thumbHeight", "", "thumbView", "Lcom/tencent/mm/plugin/vlog/ui/widget/VLogThumbView;", "getThumbView", "()Lcom/tencent/mm/plugin/vlog/ui/widget/VLogThumbView;", "thumbViewRoot", "thumbWidth", "clearFocus", "", "enableTrackTouchMove", "enable", "", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOriginPosition", "release", "reset", "selectTrack", "index", "startTime", "endTime", "setVisibility", "visibility", "showTransitionMark", "visible", "stopScroll", "updateTransMarkStatus", "list", "", "Companion", "plugin-vlog_release"})
public final class ag
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c, d.d
{
  public static final a NwO;
  final com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  private final View NwL;
  public final VLogThumbView NwM;
  private long NwN;
  private final View bvK;
  private final int thumbHeight;
  private final int thumbWidth;
  
  static
  {
    AppMethodBeat.i(250757);
    NwO = new a((byte)0);
    AppMethodBeat.o(250757);
  }
  
  public ag(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(250755);
    this.bvK = paramView;
    this.APl = paramd;
    paramView = this.bvK.findViewById(a.f.vlog_editor_thumb_view);
    p.j(paramView, "layout.findViewById(R.id.vlog_editor_thumb_view)");
    this.NwL = paramView;
    paramView = this.bvK.findViewById(a.f.vlog_thumb_recycler);
    p.j(paramView, "layout.findViewById(R.id.vlog_thumb_recycler)");
    this.NwM = ((VLogThumbView)paramView);
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.NwM.setOnSelectCallback((VLogThumbView.b)new VLogThumbView.b()
    {
      public final void akl(int paramAnonymousInt)
      {
        AppMethodBeat.i(230127);
        com.tencent.mm.plugin.recordvideo.plugin.parent.d locald = this.NwP.APl;
        com.tencent.mm.plugin.recordvideo.plugin.parent.d.c localc = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTn;
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_SELECT_TRANSITION_INDEX", paramAnonymousInt);
        locald.a(localc, localBundle);
        AppMethodBeat.o(230127);
      }
      
      public final void akm(int paramAnonymousInt)
      {
        AppMethodBeat.i(230130);
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_VLOG_SELECT_TRACK", paramAnonymousInt);
        this.NwP.APl.a(com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSQ, localBundle);
        AppMethodBeat.o(230130);
      }
    });
    this.NwN = -1L;
    AppMethodBeat.o(250755);
  }
  
  public final void Ax(boolean paramBoolean)
  {
    AppMethodBeat.i(250753);
    this.NwM.Ax(paramBoolean);
    AppMethodBeat.o(250753);
  }
  
  public final void LX(final long paramLong)
  {
    AppMethodBeat.i(250742);
    if ((this.NwN <= 0L) || (Util.ticksToNow(this.NwN) >= 1000L))
    {
      Log.d("MicroMsg.VLogThumbViewPlugin", "onProgress: " + paramLong + ", enableAutoScroll:" + this.NwM + ".enableAutoScroll");
      this.NwN = Util.currentTicks();
    }
    if (!this.NwL.isShown())
    {
      Log.d("MicroMsg.VLogThumbViewPlugin", "onProgress thumbViewRoot not visible ignore");
      AppMethodBeat.o(250742);
      return;
    }
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this, paramLong));
    AppMethodBeat.o(250742);
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(250739);
    if (this.NwL.getVisibility() != 0)
    {
      Log.i("MicroMsg.VLogThumbViewPlugin", "thumbViewRoot not visible ignore update");
      AppMethodBeat.o(250739);
      return;
    }
    if (paramac != null)
    {
      CMTimeRange localCMTimeRange = paramac.NmT.igH();
      long l1 = localCMTimeRange.getStartUs() / 1000L;
      long l2 = localCMTimeRange.getEndUs() / 1000L;
      VLogThumbView localVLogThumbView = this.NwM;
      long l3 = paramac.NmT.getDurationMs();
      paramac = (Iterable)paramac.gtA();
      Collection localCollection = (Collection)new ArrayList();
      int i = 0;
      Iterator localIterator = paramac.iterator();
      while (localIterator.hasNext())
      {
        paramac = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        paramac = (ad)paramac;
        if ((paramac.Nng.endTimeMs < l1) || (paramac.Nng.startTimeMs > l2)) {
          paramac = null;
        }
        for (;;)
        {
          if (paramac == null) {
            break label342;
          }
          localCollection.add(paramac);
          i = j;
          break;
          paramac = new h(paramac);
          paramac.trackIndex = i;
          if (paramac.NDI.Nng.startTimeMs < l1) {
            paramac.NCj = (paramac.NDI.Nng.MQV + ((float)(l1 - paramac.NDI.Nng.startTimeMs) * paramac.NDI.Nng.pvh));
          }
          if (paramac.NDI.Nng.endTimeMs > l2) {
            paramac.NCk = (paramac.NDI.Nng.MQW - ((float)(paramac.NDI.Nng.endTimeMs - l2) * paramac.NDI.Nng.pvh));
          }
          paramac.height = this.thumbHeight;
          paramac.width = this.thumbWidth;
        }
        label342:
        i = j;
      }
      paramac = (List)localCollection;
      p.k(localCMTimeRange, "playRange");
      p.k(paramac, "tracks");
      localVLogThumbView.NGq.setVisibility(0);
      localVLogThumbView.NGz.clear();
      localVLogThumbView.NGz.addAll((Collection)paramac);
      localVLogThumbView.NzM = 0;
      localVLogThumbView.kje = 0L;
      localVLogThumbView.Glx = l3;
      localVLogThumbView.AJV = (localCMTimeRange.getStartUs() / 1000L);
      localVLogThumbView.MSZ = (localCMTimeRange.getEndUs() / 1000L);
      l1 = localVLogThumbView.MSZ;
      l2 = localVLogThumbView.AJV;
      Log.i("MicroMsg.VLogThumbView", "onUpdate, duration:" + (localVLogThumbView.MSZ - localVLogThumbView.AJV) + ", visibility:" + localVLogThumbView.isShown() + " seekTo:" + paramLong + " seekToOrigin:" + paramBoolean);
      localVLogThumbView.jLl.removeCallbacks(localVLogThumbView.NzW);
      localVLogThumbView.NzW = ((Runnable)new VLogThumbView.d(localVLogThumbView, l1 - l2, paramLong, paramBoolean));
      localVLogThumbView.NGy = false;
      localVLogThumbView.NDj = false;
      localVLogThumbView.NGs = localVLogThumbView.NDe;
      localVLogThumbView.NDe = 0;
      localVLogThumbView.Arh.au(0, 0);
      paramac = localVLogThumbView.NzW;
      if (paramac != null)
      {
        paramac.run();
        AppMethodBeat.o(250739);
        return;
      }
    }
    AppMethodBeat.o(250739);
  }
  
  public final void a(d.e parame)
  {
    AppMethodBeat.i(250741);
    VLogThumbView localVLogThumbView = this.NwM;
    localVLogThumbView.NuG = parame;
    Log.i("MicroMsg.VLogThumbView", "onStart: ");
    if (!localVLogThumbView.isShown())
    {
      Log.i("MicroMsg.VLogThumbView", "onStart thumbViewRoot not visible ignore");
      AppMethodBeat.o(250741);
      return;
    }
    localVLogThumbView.NDj = true;
    localVLogThumbView.canScroll = true;
    AppMethodBeat.o(250741);
  }
  
  public final void gvP()
  {
    this.NwM.NGA = false;
  }
  
  public final void iH(List<Boolean> paramList)
  {
    AppMethodBeat.i(250751);
    p.k(paramList, "list");
    this.NwM.iH(paramList);
    AppMethodBeat.o(250751);
  }
  
  public final void release()
  {
    AppMethodBeat.i(250748);
    super.release();
    Object localObject2 = this.NwM;
    Object localObject1 = (Iterable)i.ou(0, ((VLogThumbView)localObject2).jLl.getChildCount());
    localObject2 = ((VLogThumbView)localObject2).jLl;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localCollection.add(((RecyclerView)localObject2).getChildAt(((ab)localObject1).zD()));
    }
    localObject1 = ((Iterable)kotlin.a.j.a((Iterable)localCollection, FrameListView.class)).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((FrameListView)((Iterator)localObject1).next()).release();
    }
    localObject1 = com.tencent.mm.videocomposition.a.YHM;
    com.tencent.mm.videocomposition.a.fgL().evictAll();
    AppMethodBeat.o(250748);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(250745);
    super.reset();
    VLogThumbView localVLogThumbView = this.NwM;
    localVLogThumbView.NGr.NBK.clear();
    localVLogThumbView.x(-1, 0L, 0L);
    AppMethodBeat.o(250745);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(250737);
    this.NwL.setVisibility(paramInt);
    VLogThumbView localVLogThumbView = this.NwM;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localVLogThumbView.NGA = bool;
      this.NwM.NGq.setVisibility(paramInt);
      AppMethodBeat.o(250737);
      return;
    }
  }
  
  public final void x(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(250743);
    Log.i("MicroMsg.VLogThumbViewPlugin", "selectTrack:".concat(String.valueOf(paramInt)));
    this.NwM.x(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(250743);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin$Companion;", "", "()V", "TAG", "", "ThumbHeight", "", "ThumbWidth", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(ag paramag, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.ag
 * JD-Core Version:    0.7.0.1
 */