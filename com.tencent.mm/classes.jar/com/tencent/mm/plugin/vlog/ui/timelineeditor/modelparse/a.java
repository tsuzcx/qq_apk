package com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse;

import android.graphics.Rect;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.fos;
import com.tencent.mm.protocal.protobuf.fqf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.b;
import com.tencent.mm.videocomposition.g;
import com.tencent.mm.videocomposition.j;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TimeCost", "", "cropInfoToProto", "", "track", "Lcom/tencent/mm/videocomposition/CompositionTrack;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "makeChain", "trackList", "", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "trackToProto", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "videoComposition2CompositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "videoComposition2VLogComposition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "videoComposition", "plugin-vlog_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  private static String UqN = "TimeCost";
  
  public static final afb a(j paramj, afc paramafc)
  {
    AppMethodBeat.i(282106);
    s.u(paramj, "composition");
    s.u(paramafc, "outputConfig");
    afb localafb = new afb();
    localafb.Znh = (paramj.jLV().getStartUs() / 1000L);
    localafb.Zni = (paramj.jLV().getEndUs() / 1000L);
    Object localObject1 = localafb.Zng;
    Object localObject3 = (Iterable)paramj.TDz;
    Object localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (b)((Iterator)localObject3).next();
      fos localfos = new fos();
      s.u(localObject4, "track");
      s.u(localfos, "proto");
      localfos.path = ((b)localObject4).path;
      localfos.type = ((b)localObject4).type;
      localfos.startTimeMs = ((b)localObject4).startTimeMs;
      localfos.endTimeMs = ((b)localObject4).endTimeMs;
      localfos.TDw = ((b)localObject4).TDw;
      localfos.TDx = ((b)localObject4).TDx;
      localfos.UjZ = ((b)localObject4).UjZ;
      localfos.UaC = ((b)localObject4).UaC;
      localfos.UaD = ((b)localObject4).UaD;
      localfos.volume = ((b)localObject4).volume;
      localfos.abOZ = new ahj();
      Object localObject5 = localfos.abOZ;
      s.s(localObject5, "proto.cropInfo");
      s.u(localObject4, "track");
      s.u(localObject5, "proto");
      ((ahj)localObject5).Zqq = new enx();
      ((ahj)localObject5).Zqt = new enx();
      ((ahj)localObject5).Zqs = new enx();
      Rect localRect = ((b)localObject4).Gl;
      enx localenx = ((ahj)localObject5).Zqq;
      s.s(localenx, "proto.cropRect");
      h.a(localRect, localenx);
      localRect = ((b)localObject4).agDz;
      localenx = ((ahj)localObject5).Zqt;
      s.s(localenx, "proto.trackCropRect");
      h.a(localRect, localenx);
      localRect = ((b)localObject4).Gl;
      localObject5 = ((ahj)localObject5).Zqs;
      s.s(localObject5, "proto.contentRect");
      h.a(localRect, (enx)localObject5);
      localfos.abPa = new fqf();
      localObject4 = ((b)localObject4).TDy;
      localObject5 = localfos.abPa;
      s.s(localObject5, "proto.transitionInfo");
      h.a((g)localObject4, (fqf)localObject5);
      ((Collection)localObject2).add(localfos);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localafb.Uax = paramj.Uax;
    localafb.Znj = true;
    localafb.TYB = paramafc;
    localafb.Znm = new LinkedList();
    paramj = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    paramj = ((Map)com.tencent.mm.plugin.vlog.model.local.a.hRx()).entrySet().iterator();
    while (paramj.hasNext())
    {
      localObject1 = (Map.Entry)paramj.next();
      paramafc = new afd();
      paramafc.path = ((String)((Map.Entry)localObject1).getKey());
      localObject2 = ((Pair)((Map.Entry)localObject1).getValue()).first;
      s.s(localObject2, "it.value.first");
      paramafc.label = ((Number)localObject2).intValue();
      localObject1 = ((Pair)((Map.Entry)localObject1).getValue()).second;
      s.s(localObject1, "it.value.second");
      paramafc.Znx = ((Number)localObject1).longValue();
      localafb.Znm.add(paramafc);
    }
    AppMethodBeat.o(282106);
    return localafb;
  }
  
  public static final ac d(j paramj)
  {
    AppMethodBeat.i(282083);
    s.u(paramj, "videoComposition");
    long l = System.currentTimeMillis();
    Object localObject = (Iterable)paramj.TDz;
    paramj = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      b localb = (b)((Iterator)localObject).next();
      ad localad = new ad(localb.path, localb.type, 0);
      localad.setStartTimeMs(localb.startTimeMs);
      localad.wA(localb.endTimeMs);
      localad.wB(localb.TDw);
      localad.wC(localb.TDx);
      localad.setPlayRate(localb.sAn);
      localad.UaI.Gl.set(localb.Gl);
      localad.UaI.agDz.set(localb.agDz);
      Log.d(UqN, s.X("videoComposition2VLogComposition cost1:", Long.valueOf(System.currentTimeMillis() - l)));
      paramj.add(localad);
    }
    paramj = new ac((List)paramj);
    lS((List)paramj.TDz);
    Log.d(UqN, s.X("videoComposition2VLogComposition cost4:", Long.valueOf(System.currentTimeMillis() - l)));
    Log.d(UqN, s.X("videoComposition2VLogComposition cost2:", Long.valueOf(System.currentTimeMillis() - l)));
    AppMethodBeat.o(282083);
    return paramj;
  }
  
  private static final void lS(List<ad> paramList)
  {
    AppMethodBeat.i(282088);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(282088);
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
      long l4 = ((float)(localad.UaI.TDx - localad.UaI.TDw) / localad.UaI.sAn);
      long l3;
      if (localad.UaI.TDy.isValid())
      {
        l3 = localad.UaI.TDy.duration;
        label124:
        l2 = Math.min(l3, Math.min(l2, l4));
        if (localObject != null) {
          break label225;
        }
      }
      label225:
      for (localObject = null;; localObject = ((ad)localObject).UaI)
      {
        if (localObject != null) {
          ((b)localObject).agDC = (l1 - l2 / 2L);
        }
        localad.UaI.agDB = (l1 - l2 / 2L);
        localad.setStartTimeMs(l1 - l2);
        localad.wA(localad.UaI.startTimeMs + l4);
        l1 = localad.UaI.endTimeMs;
        localObject = localad;
        l2 = l4;
        break;
        l3 = 0L;
        break label124;
      }
    }
    paramList = (ad)p.oM(paramList);
    paramList.UaI.agDC = paramList.UaI.endTimeMs;
    Log.d(UqN, s.X("videoComposition2VLogComposition cost3:", Long.valueOf(System.currentTimeMillis() - l5)));
    AppMethodBeat.o(282088);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.modelparse.a
 * JD-Core Version:    0.7.0.1
 */