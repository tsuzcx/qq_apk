package com.tencent.mm.plugin.vlog.model;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dxv;
import com.tencent.mm.protocal.protobuf.dxw;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.protocal.protobuf.dya;
import com.tencent.mm.protocal.protobuf.ebe;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"compositionToProto", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "cropInfoToProto", "", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "matrixToProto", "matrix", "Landroid/graphics/Matrix;", "Lcom/tencent/mm/protocal/protobuf/MatrixProto;", "protoToComposition", "protoToCropInfo", "protoToFrameRetriever", "Lcom/tencent/mm/media/mix/FrameSeeker;", "protoToMatrix", "protoToRect", "Lcom/tencent/mm/protocal/protobuf/RectProto;", "rect", "Landroid/graphics/Rect;", "protoToTrack", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "rectToProto", "scriptToTrackList", "", "script", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "sourceTrackList", "trackToProto", "toInputTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "Lcom/tencent/tav/coremedia/TextureInfo;", "plugin-vlog_release"})
public final class m
{
  public static final v a(dxw paramdxw)
  {
    AppMethodBeat.i(200822);
    k.h(paramdxw, "proto");
    Object localObject1 = new LinkedList();
    Object localObject2 = paramdxw.LwS;
    k.g(localObject2, "proto.tracks");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ebw localebw = (ebw)((Iterator)localObject3).next();
      Object localObject4 = localebw.path;
      k.g(localObject4, "it.path");
      localObject4 = new y((String)localObject4, localebw.type);
      k.g(localebw, "it");
      a(localebw, (y)localObject4);
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject1 = new v((List)localObject1, null, 6);
    ((v)localObject1).aD(paramdxw.LwT, paramdxw.LwU);
    if (!bt.isNullOrNil(paramdxw.gtC))
    {
      localObject2 = paramdxw.gtC;
      k.g(localObject2, "proto.musicPath");
      ((v)localObject1).aVU((String)localObject2);
    }
    ((v)localObject1).zd(paramdxw.LqP);
    localObject2 = new Rect();
    localObject3 = paramdxw.Lqd.LwW;
    k.g(localObject3, "proto.outputConfig.originRect");
    a((ebn)localObject3, (Rect)localObject2);
    v.a((v)localObject1, paramdxw.Lqd.vNE, paramdxw.Lqd.vNF, (Rect)localObject2);
    AppMethodBeat.o(200822);
    return localObject1;
  }
  
  public static final dxw a(v paramv, dxx paramdxx)
  {
    AppMethodBeat.i(200821);
    k.h(paramv, "composition");
    k.h(paramdxx, "outputConfig");
    dxw localdxw = new dxw();
    localdxw.LwT = (paramv.fYI().getStartUs() / 1000L);
    localdxw.LwU = (paramv.fYI().getEndUs() / 1000L);
    LinkedList localLinkedList = localdxw.LwS;
    Object localObject = (Iterable)paramv.LqL;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      y localy = (y)((Iterator)localObject).next();
      ebw localebw = new ebw();
      a(localy, localebw);
      localebw.LqD = localy.LqD;
      localCollection.add(localebw);
    }
    localLinkedList.addAll((Collection)localCollection);
    localdxw.LqP = paramv.LqP;
    localdxw.LwV = true;
    localdxw.Lqd = paramdxx;
    localdxw.gtC = paramv.gtC;
    AppMethodBeat.o(200821);
    return localdxw;
  }
  
  public static final List<y> a(h paramh, List<y> paramList)
  {
    AppMethodBeat.i(200816);
    k.h(paramh, "script");
    k.h(paramList, "sourceTrackList");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = ((Iterable)paramh.yZs).iterator();
    label146:
    label163:
    label552:
    while (localIterator1.hasNext())
    {
      d locald = (d)localIterator1.next();
      y localy1;
      long l;
      Iterator localIterator2;
      y localy2;
      int i;
      if ((locald instanceof i))
      {
        localy1 = new y(locald.path, 2);
        localy1.bxw = locald.startTime;
        localy1.gnO = locald.endTime;
        localy1.Lro = ((i)locald).yZx;
        if (((i)locald).yZy <= 0L)
        {
          l = ((i)locald).yZx + localy1.cuR();
          localy1.Lrp = l;
          localIterator2 = ((Iterable)paramList).iterator();
          if (!localIterator2.hasNext()) {
            break label321;
          }
          paramh = localIterator2.next();
          localy2 = (y)paramh;
          if ((localy2.type != 2) || (!k.g(localy2.path, locald.path))) {
            break label316;
          }
          i = 1;
          label214:
          if (i == 0) {
            break label319;
          }
          label218:
          paramh = (y)paramh;
          if (paramh == null) {
            break label326;
          }
          localy1.Lrq = paramh.Lrq;
          localy1.Lrr = paramh.Lrr;
          localy1.Lrs = paramh.Lrs;
          localy1.Lru.oSt.set(paramh.Lru.oSt);
          localy1.Lru.gtE.set(paramh.Lru.gtE);
          paramh = localy1;
        }
      }
      for (;;)
      {
        if (paramh == null) {
          break label552;
        }
        localLinkedList.add(paramh);
        break;
        l = locald.endTime;
        break label146;
        label316:
        i = 0;
        break label214;
        label319:
        break label163;
        label321:
        paramh = null;
        break label218;
        label326:
        paramh = null;
        continue;
        if ((locald instanceof c))
        {
          localy1 = new y(locald.path, 1);
          localy1.bxw = locald.startTime;
          localy1.gnO = locald.endTime;
          localy1.Lro = 0L;
          localy1.Lrp = (locald.endTime - locald.startTime);
          localy1.Lrq = 4000L;
          localIterator2 = ((Iterable)paramList).iterator();
          if (localIterator2.hasNext())
          {
            paramh = localIterator2.next();
            localy2 = (y)paramh;
            if ((localy2.type == 1) && (k.g(localy2.path, locald.path)))
            {
              i = 1;
              label466:
              if (i == 0) {
                break label542;
              }
            }
          }
          for (;;)
          {
            paramh = (y)paramh;
            if (paramh != null)
            {
              localy1.Lrr = paramh.Lrr;
              localy1.Lrs = paramh.Lrs;
              localy1.Lru.oSt.set(paramh.Lru.oSt);
              localy1.Lru.gtE.set(paramh.Lru.gtE);
            }
            paramh = localy1;
            break;
            i = 0;
            break label466;
            break label415;
            paramh = null;
          }
        }
        paramh = null;
      }
    }
    label415:
    paramh = (List)localLinkedList;
    label542:
    AppMethodBeat.o(200816);
    return paramh;
  }
  
  public static final void a(Rect paramRect, ebn paramebn)
  {
    AppMethodBeat.i(200817);
    k.h(paramRect, "rect");
    k.h(paramebn, "proto");
    paramebn.DTM.clear();
    paramebn.DTM.add(Integer.valueOf(paramRect.left));
    paramebn.DTM.add(Integer.valueOf(paramRect.top));
    paramebn.DTM.add(Integer.valueOf(paramRect.right));
    paramebn.DTM.add(Integer.valueOf(paramRect.bottom));
    AppMethodBeat.o(200817);
  }
  
  private static void a(y paramy, ebw paramebw)
  {
    AppMethodBeat.i(200819);
    k.h(paramy, "track");
    k.h(paramebw, "proto");
    paramebw.path = paramy.path;
    paramebw.type = paramy.type;
    paramebw.bxw = paramy.bxw;
    paramebw.gnO = paramy.gnO;
    paramebw.Lro = paramy.Lro;
    paramebw.Lrp = paramy.Lrp;
    paramebw.Lrq = paramy.Lrq;
    paramebw.Lrr = paramy.Lrr;
    paramebw.Lrs = paramy.Lrs;
    paramebw.Lrt = paramy.Lrt;
    paramebw.LAm = new dya();
    paramy = paramy.Lru;
    paramebw = paramebw.LAm;
    k.g(paramebw, "proto.cropInfo");
    k.h(paramy, "cropInfo");
    k.h(paramebw, "proto");
    paramebw.Lxb = new ebe();
    paramebw.Lxe = new ebn();
    paramebw.Lxc = new ebn();
    paramebw.Lxd = new ebn();
    Object localObject1 = paramy.dY;
    Object localObject2 = paramebw.Lxb;
    k.g(localObject2, "proto.matrix");
    k.h(localObject1, "matrix");
    k.h(localObject2, "proto");
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject1).getValues(arrayOfFloat);
    ((ebe)localObject2).DTM.clear();
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      ((ebe)localObject2).DTM.add(Float.valueOf(f));
      i += 1;
    }
    localObject1 = paramy.oSt;
    localObject2 = paramebw.Lxe;
    k.g(localObject2, "proto.contentRect");
    a((Rect)localObject1, (ebn)localObject2);
    localObject1 = paramy.gtE;
    localObject2 = paramebw.Lxc;
    k.g(localObject2, "proto.cropRect");
    a((Rect)localObject1, (ebn)localObject2);
    paramy = paramy.viewRect;
    paramebw = paramebw.Lxd;
    k.g(paramebw, "proto.viewRect");
    a(paramy, paramebw);
    AppMethodBeat.o(200819);
  }
  
  public static final void a(ebn paramebn, Rect paramRect)
  {
    AppMethodBeat.i(200818);
    k.h(paramebn, "proto");
    k.h(paramRect, "rect");
    if (paramebn.DTM.size() == 4)
    {
      Object localObject = paramebn.DTM.get(0);
      k.g(localObject, "proto.values[0]");
      int i = ((Number)localObject).intValue();
      localObject = paramebn.DTM.get(1);
      k.g(localObject, "proto.values[1]");
      int j = ((Number)localObject).intValue();
      localObject = paramebn.DTM.get(2);
      k.g(localObject, "proto.values[2]");
      int k = ((Number)localObject).intValue();
      paramebn = paramebn.DTM.get(3);
      k.g(paramebn, "proto.values[3]");
      paramRect.set(i, j, k, ((Number)paramebn).intValue());
    }
    AppMethodBeat.o(200818);
  }
  
  private static void a(ebw paramebw, y paramy)
  {
    AppMethodBeat.i(200820);
    k.h(paramebw, "proto");
    k.h(paramy, "track");
    paramy.bxw = paramebw.bxw;
    paramy.gnO = paramebw.gnO;
    paramy.Lro = paramebw.Lro;
    paramy.Lrp = paramebw.Lrp;
    paramy.Lrq = paramebw.Lrq;
    paramy.Lrr = paramebw.Lrr;
    paramy.Lrs = paramebw.Lrs;
    paramy.Lrt = paramebw.Lrt;
    paramebw = paramebw.LAm;
    if (paramebw != null)
    {
      paramy = paramy.Lru;
      k.h(paramebw, "proto");
      k.h(paramy, "cropInfo");
      Object localObject2 = paramebw.Lxb;
      if (localObject2 != null)
      {
        localObject1 = paramy.dY;
        k.h(localObject2, "proto");
        k.h(localObject1, "matrix");
        if (((ebe)localObject2).DTM.size() == 9)
        {
          localObject2 = ((ebe)localObject2).DTM;
          k.g(localObject2, "proto.values");
          ((Matrix)localObject1).setValues(j.o((Collection)localObject2));
        }
      }
      Object localObject1 = paramebw.Lxe;
      if (localObject1 != null) {
        a((ebn)localObject1, paramy.oSt);
      }
      localObject1 = paramebw.Lxc;
      if (localObject1 != null) {
        a((ebn)localObject1, paramy.gtE);
      }
      paramebw = paramebw.Lxd;
      if (paramebw != null)
      {
        a(paramebw, paramy.viewRect);
        AppMethodBeat.o(200820);
        return;
      }
      AppMethodBeat.o(200820);
      return;
    }
    AppMethodBeat.o(200820);
  }
  
  public static final com.tencent.mm.media.g.f b(dxw paramdxw)
  {
    AppMethodBeat.i(200823);
    k.h(paramdxw, "proto");
    Object localObject = com.tencent.mm.plugin.recordvideo.background.f.vdH;
    localObject = paramdxw.Lqe.Dde;
    k.g(localObject, "proto.editData.baseItemData");
    Context localContext = aj.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    paramdxw = (com.tencent.mm.media.g.f)new com.tencent.mm.plugin.recordvideo.background.i((List)com.tencent.mm.plugin.recordvideo.background.f.a((LinkedList)localObject, localContext), paramdxw.Lqd.vNE, paramdxw.Lqd.vNF);
    AppMethodBeat.o(200823);
    return paramdxw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.m
 * JD-Core Version:    0.7.0.1
 */