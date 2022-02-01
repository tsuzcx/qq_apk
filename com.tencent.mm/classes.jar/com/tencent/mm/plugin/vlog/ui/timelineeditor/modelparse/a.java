package com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse;

import android.graphics.Rect;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.protocal.protobuf.eus;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.g;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TimeCost", "", "cropInfoToProto", "", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "makeChain", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trackToProto", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "videoComposition2CompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "videoComposition2VLogComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "videoComposition", "plugin-vlog_release"})
public final class a
{
  private static String NEC = "TimeCost";
  
  public static final acu a(com.tencent.mm.videocomposition.j paramj, acv paramacv)
  {
    AppMethodBeat.i(234012);
    p.k(paramj, "composition");
    p.k(paramacv, "outputConfig");
    acu localacu = new acu();
    localacu.Sov = (paramj.igH().getStartUs() / 1000L);
    localacu.Sow = (paramj.igH().getEndUs() / 1000L);
    Object localObject1 = localacu.Sou;
    Object localObject3 = (Iterable)paramj.MQY;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (b)((Iterator)localObject3).next();
      eth localeth = new eth();
      p.k(localObject4, "track");
      p.k(localeth, "proto");
      localeth.path = ((b)localObject4).path;
      localeth.type = ((b)localObject4).type;
      localeth.startTimeMs = ((b)localObject4).startTimeMs;
      localeth.endTimeMs = ((b)localObject4).endTimeMs;
      localeth.MQV = ((b)localObject4).MQV;
      localeth.MQW = ((b)localObject4).MQW;
      localeth.NwS = ((b)localObject4).NwS;
      localeth.Nna = ((b)localObject4).Nna;
      localeth.Nnb = ((b)localObject4).Nnb;
      localeth.volume = ((b)localObject4).volume;
      localeth.Uvu = new aex();
      Object localObject5 = localeth.Uvu;
      p.j(localObject5, "proto.cropInfo");
      p.k(localObject4, "track");
      p.k(localObject5, "proto");
      ((aex)localObject5).Sro = new duz();
      ((aex)localObject5).Srr = new duz();
      ((aex)localObject5).Srq = new duz();
      Rect localRect = ((b)localObject4).kXj;
      duz localduz = ((aex)localObject5).Sro;
      p.j(localduz, "proto.cropRect");
      i.a(localRect, localduz);
      localRect = ((b)localObject4).YHS;
      localduz = ((aex)localObject5).Srr;
      p.j(localduz, "proto.trackCropRect");
      i.a(localRect, localduz);
      localRect = ((b)localObject4).kXj;
      localObject5 = ((aex)localObject5).Srq;
      p.j(localObject5, "proto.contentRect");
      i.a(localRect, (duz)localObject5);
      localeth.Uvv = new eus();
      localObject4 = ((b)localObject4).MQX;
      localObject5 = localeth.Uvv;
      p.j(localObject5, "proto.transitionInfo");
      i.a((g)localObject4, (eus)localObject5);
      ((Collection)localObject2).add(localeth);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localacu.NmU = paramj.NmU;
    localacu.Sox = true;
    localacu.NkX = paramacv;
    localacu.SoA = new LinkedList();
    paramj = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    paramj = ((Map)com.tencent.mm.plugin.vlog.model.local.a.gtP()).entrySet().iterator();
    while (paramj.hasNext())
    {
      localObject1 = (Map.Entry)paramj.next();
      paramacv = new acw();
      paramacv.path = ((String)((Map.Entry)localObject1).getKey());
      localObject2 = ((Pair)((Map.Entry)localObject1).getValue()).first;
      p.j(localObject2, "it.value.first");
      paramacv.label = ((Number)localObject2).intValue();
      localObject1 = ((Pair)((Map.Entry)localObject1).getValue()).second;
      p.j(localObject1, "it.value.second");
      paramacv.SoL = ((Number)localObject1).longValue();
      localacu.SoA.add(paramacv);
    }
    AppMethodBeat.o(234012);
    return localacu;
  }
  
  public static final ac d(com.tencent.mm.videocomposition.j paramj)
  {
    AppMethodBeat.i(234003);
    p.k(paramj, "videoComposition");
    long l = System.currentTimeMillis();
    Object localObject = (Iterable)paramj.MQY;
    paramj = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      ad localad = new ad(localb.path, localb.type, 0);
      localad.Sl(localb.startTimeMs);
      localad.Sm(localb.endTimeMs);
      localad.Sn(localb.MQV);
      localad.So(localb.MQW);
      localad.setPlayRate(localb.pvh);
      localad.Nng.kXj.set(localb.kXj);
      localad.Nng.YHS.set(localb.YHS);
      Log.d(NEC, "videoComposition2VLogComposition cost1:" + (System.currentTimeMillis() - l));
      paramj.add(localad);
    }
    paramj = new ac((List)paramj);
    iK((List)paramj.MQY);
    Log.d(NEC, "videoComposition2VLogComposition cost4:" + (System.currentTimeMillis() - l));
    Log.d(NEC, "videoComposition2VLogComposition cost2:" + (System.currentTimeMillis() - l));
    AppMethodBeat.o(234003);
    return paramj;
  }
  
  private static final void iK(List<ad> paramList)
  {
    AppMethodBeat.i(234006);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(234006);
      return;
    }
    long l5 = System.currentTimeMillis();
    long l2 = 0L;
    Object localObject = null;
    Iterator localIterator = ((Iterable)paramList).iterator();
    long l1 = 0L;
    if (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      long l4 = ((float)(localad.Nng.MQW - localad.Nng.MQV) / localad.Nng.pvh);
      if (localad.Nng.MQX.isValid()) {}
      for (long l3 = localad.Nng.MQX.duration;; l3 = 0L)
      {
        l2 = Math.min(l3, Math.min(l2, l4));
        if (localObject != null)
        {
          localObject = ((ad)localObject).Nng;
          if (localObject != null) {
            ((b)localObject).YHV = (l1 - l2 / 2L);
          }
        }
        localad.Nng.YHU = (l1 - l2 / 2L);
        localad.Sl(l1 - l2);
        localad.Sm(localad.Nng.startTimeMs + l4);
        l1 = localad.Nng.endTimeMs;
        localObject = localad;
        l2 = l4;
        break;
      }
    }
    paramList = (ad)kotlin.a.j.lq(paramList);
    paramList.Nng.YHV = paramList.Nng.endTimeMs;
    Log.d(NEC, "videoComposition2VLogComposition cost3:" + (System.currentTimeMillis() - l5));
    AppMethodBeat.o(234006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a
 * JD-Core Version:    0.7.0.1
 */