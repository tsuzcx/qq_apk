package com.tencent.mm.plugin.vlog.ui.plugin;

import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.ui.plugin.transition.e;
import com.tencent.mm.plugin.vlog.ui.thumb.FrameListView;
import com.tencent.mm.plugin.vlog.ui.thumb.h;
import com.tencent.mm.plugin.vlog.ui.widget.VLogThumbView;
import com.tencent.mm.plugin.vlog.ui.widget.VLogThumbView.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.j;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogThumbViewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "layout", "Landroid/view/View;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Landroid/view/View;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "lastLogProgressTime", "", "getLayout", "()Landroid/view/View;", "thumbHeight", "", "thumbView", "Lcom/tencent/mm/plugin/vlog/ui/widget/VLogThumbView;", "getThumbView", "()Lcom/tencent/mm/plugin/vlog/ui/widget/VLogThumbView;", "thumbViewRoot", "thumbWidth", "clearFocus", "", "enableTrackTouchMove", "enable", "", "onFinish", "onProgress", "timeMs", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "onUpdate", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "seekToOriginPosition", "release", "reset", "selectTrack", "index", "startTime", "endTime", "setVisibility", "visibility", "showTransitionMark", "visible", "stopScroll", "updateTransMarkStatus", "list", "", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements d.c, d.d
{
  public static final af.a UjS;
  private final View UjT;
  public final VLogThumbView UjU;
  private long UjV;
  private final View doN;
  private final int thumbHeight;
  private final int thumbWidth;
  
  static
  {
    AppMethodBeat.i(282683);
    UjS = new af.a((byte)0);
    AppMethodBeat.o(282683);
  }
  
  public af(View paramView, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282677);
    this.doN = paramView;
    paramView = this.doN.findViewById(a.f.vlog_editor_thumb_view);
    s.s(paramView, "layout.findViewById(R.id.vlog_editor_thumb_view)");
    this.UjT = paramView;
    paramView = this.doN.findViewById(a.f.vlog_thumb_recycler);
    s.s(paramView, "layout.findViewById(R.id.vlog_thumb_recycler)");
    this.UjU = ((VLogThumbView)paramView);
    this.thumbHeight = 112;
    this.thumbWidth = 63;
    this.UjU.setOnSelectCallback((VLogThumbView.b)new VLogThumbView.b()
    {
      public final void apE(int paramAnonymousInt)
      {
        AppMethodBeat.i(282317);
        com.tencent.mm.plugin.recordvideo.plugin.parent.a locala = this.NJL;
        a.c localc = a.c.NPT;
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_SELECT_TRANSITION_INDEX", paramAnonymousInt);
        kotlin.ah localah = kotlin.ah.aiuX;
        locala.a(localc, localBundle);
        AppMethodBeat.o(282317);
      }
      
      public final void apF(int paramAnonymousInt)
      {
        AppMethodBeat.i(282326);
        Bundle localBundle = new Bundle();
        localBundle.putInt("EDIT_VLOG_SELECT_TRACK", paramAnonymousInt);
        this.NJL.a(a.c.NPw, localBundle);
        AppMethodBeat.o(282326);
      }
    });
    this.UjV = -1L;
    AppMethodBeat.o(282677);
  }
  
  public final void FW(boolean paramBoolean)
  {
    AppMethodBeat.i(282779);
    this.UjU.FW(paramBoolean);
    AppMethodBeat.o(282779);
  }
  
  public final void a(ac paramac, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(282710);
    if (this.UjT.getVisibility() != 0)
    {
      Log.i("MicroMsg.VLogThumbViewPlugin", "thumbViewRoot not visible ignore update");
      AppMethodBeat.o(282710);
      return;
    }
    if (paramac != null)
    {
      CMTimeRange localCMTimeRange = paramac.Uaw.jLV();
      long l1 = localCMTimeRange.getStartUs() / 1000L;
      long l2 = localCMTimeRange.getEndUs() / 1000L;
      VLogThumbView localVLogThumbView = this.UjU;
      long l3 = paramac.Uaw.getDurationMs();
      paramac = (Iterable)paramac.hRb();
      Collection localCollection = (Collection)new ArrayList();
      int i = 0;
      Iterator localIterator = paramac.iterator();
      while (localIterator.hasNext())
      {
        paramac = localIterator.next();
        int j = i + 1;
        if (i < 0) {
          p.kkW();
        }
        paramac = (ad)paramac;
        if ((paramac.UaI.endTimeMs < l1) || (paramac.UaI.startTimeMs > l2)) {
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
          if (paramac.Uqg.UaI.startTimeMs < l1) {
            paramac.UoP = (paramac.Uqg.UaI.TDw + ((float)(l1 - paramac.Uqg.UaI.startTimeMs) * paramac.Uqg.UaI.sAn));
          }
          if (paramac.Uqg.UaI.endTimeMs > l2) {
            paramac.UoQ = (paramac.Uqg.UaI.TDx - ((float)(paramac.Uqg.UaI.endTimeMs - l2) * paramac.Uqg.UaI.sAn));
          }
          paramac.height = this.thumbHeight;
          paramac.width = this.thumbWidth;
        }
        label342:
        i = j;
      }
      localVLogThumbView.a(l3, localCMTimeRange, paramLong, paramBoolean, (List)localCollection);
    }
    AppMethodBeat.o(282710);
  }
  
  public final void a(d.e parame)
  {
    AppMethodBeat.i(282721);
    VLogThumbView localVLogThumbView = this.UjU;
    localVLogThumbView.Uia = parame;
    Log.i("MicroMsg.VLogThumbView", "onStart: ");
    if (!localVLogThumbView.isShown())
    {
      Log.i("MicroMsg.VLogThumbView", "onStart thumbViewRoot not visible ignore");
      AppMethodBeat.o(282721);
      return;
    }
    localVLogThumbView.UpN = true;
    localVLogThumbView.uAS = true;
    AppMethodBeat.o(282721);
  }
  
  public final void hTE()
  {
    this.UjU.UsG = false;
  }
  
  public final void lP(List<Boolean> paramList)
  {
    AppMethodBeat.i(282772);
    s.u(paramList, "list");
    this.UjU.lP(paramList);
    AppMethodBeat.o(282772);
  }
  
  public final void qU(final long paramLong)
  {
    AppMethodBeat.i(282732);
    if ((this.UjV <= 0L) || (Util.ticksToNow(this.UjV) >= 1000L))
    {
      Log.d("MicroMsg.VLogThumbViewPlugin", "onProgress: " + paramLong + ", enableAutoScroll:" + this.UjU + ".enableAutoScroll");
      this.UjV = Util.currentTicks();
    }
    if (!this.UjT.isShown())
    {
      Log.d("MicroMsg.VLogThumbViewPlugin", "onProgress thumbViewRoot not visible ignore");
      AppMethodBeat.o(282732);
      return;
    }
    d.uiThread((kotlin.g.a.a)new b(this, paramLong));
    AppMethodBeat.o(282732);
  }
  
  public final void release()
  {
    AppMethodBeat.i(282760);
    super.release();
    Object localObject2 = this.UjU;
    Object localObject1 = (Iterable)k.qt(0, ((VLogThumbView)localObject2).mkw.getChildCount());
    localObject2 = ((VLogThumbView)localObject2).mkw;
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext()) {
      localCollection.add(((RecyclerView)localObject2).getChildAt(((kotlin.a.ah)localObject1).Zo()));
    }
    localObject1 = ((Iterable)p.a((Iterable)localCollection, FrameListView.class)).iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((FrameListView)((Iterator)localObject1).next()).release();
    }
    localObject1 = com.tencent.mm.videocomposition.a.agDr;
    com.tencent.mm.videocomposition.a.fka().evictAll();
    AppMethodBeat.o(282760);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282749);
    super.reset();
    VLogThumbView localVLogThumbView = this.UjU;
    localVLogThumbView.Usx.Uos.clear();
    localVLogThumbView.w(-1, 0L, 0L);
    AppMethodBeat.o(282749);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(282693);
    this.UjT.setVisibility(paramInt);
    VLogThumbView localVLogThumbView = this.UjU;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localVLogThumbView.UsG = bool;
      this.UjU.Usw.setVisibility(paramInt);
      AppMethodBeat.o(282693);
      return;
    }
  }
  
  public final void w(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(282741);
    Log.i("MicroMsg.VLogThumbViewPlugin", s.X("selectTrack:", Integer.valueOf(paramInt)));
    this.UjU.w(paramInt, paramLong1, paramLong2);
    AppMethodBeat.o(282741);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(af paramaf, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.af
 * JD-Core Version:    0.7.0.1
 */