package com.tencent.mm.plugin.vlog.model;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.e;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dix;
import com.tencent.mm.protocal.protobuf.yn;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.protocal.protobuf.yp;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"compositionToProto", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "cropInfoToProto", "", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "matrixToProto", "matrix", "Landroid/graphics/Matrix;", "Lcom/tencent/mm/protocal/protobuf/MatrixProto;", "protoToComposition", "protoToCropInfo", "protoToFrameRetriever", "Lcom/tencent/mm/media/mix/FrameSeeker;", "protoToMatrix", "protoToRect", "Lcom/tencent/mm/protocal/protobuf/RectProto;", "rect", "Landroid/graphics/Rect;", "protoToTrack", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "rectToProto", "scriptToTrackList", "", "script", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "sourceTrackList", "trackToProto", "toInputTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "Lcom/tencent/tav/coremedia/TextureInfo;", "plugin-vlog_release"})
public final class c
{
  public static final r a(yo paramyo)
  {
    AppMethodBeat.i(207509);
    k.h(paramyo, "proto");
    Object localObject1 = new LinkedList();
    Object localObject2 = paramyo.Esk;
    k.g(localObject2, "proto.tracks");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      dix localdix = (dix)((Iterator)localObject3).next();
      Object localObject4 = localdix.path;
      k.g(localObject4, "it.path");
      localObject4 = new u((String)localObject4, localdix.type);
      k.g(localdix, "it");
      a(localdix, (u)localObject4);
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject1 = new r((List)localObject1, null, 6);
    ((r)localObject1).an(paramyo.Esl, paramyo.Esm);
    if (!bs.isNullOrNil(paramyo.gUk))
    {
      localObject2 = paramyo.gUk;
      k.g(localObject2, "proto.musicPath");
      ((r)localObject1).ayj((String)localObject2);
    }
    ((r)localObject1).sj(paramyo.AnX);
    localObject2 = new Rect();
    localObject3 = paramyo.AmP.Eso;
    k.g(localObject3, "proto.outputConfig.originRect");
    a((cnb)localObject3, (Rect)localObject2);
    r.a((r)localObject1, paramyo.AmP.wXZ, paramyo.AmP.wYa, (Rect)localObject2);
    AppMethodBeat.o(207509);
    return localObject1;
  }
  
  public static final yo a(r paramr, yp paramyp)
  {
    AppMethodBeat.i(207508);
    k.h(paramr, "composition");
    k.h(paramyp, "outputConfig");
    yo localyo = new yo();
    localyo.Esl = (paramr.efA().getStartUs() / 1000L);
    localyo.Esm = (paramr.efA().getEndUs() / 1000L);
    LinkedList localLinkedList = localyo.Esk;
    Object localObject = (Iterable)paramr.AnT;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      u localu = (u)((Iterator)localObject).next();
      dix localdix = new dix();
      a(localu, localdix);
      localdix.AnI = localu.AnI;
      localCollection.add(localdix);
    }
    localLinkedList.addAll((Collection)localCollection);
    localyo.AnX = paramr.AnX;
    localyo.Esn = true;
    localyo.AmP = paramyp;
    localyo.gUk = paramr.gUk;
    AppMethodBeat.o(207508);
    return localyo;
  }
  
  public static final List<u> a(y paramy, List<u> paramList)
  {
    AppMethodBeat.i(207503);
    k.h(paramy, "script");
    k.h(paramList, "sourceTrackList");
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator1 = ((Iterable)paramy.AoV).iterator();
    label146:
    label163:
    label552:
    while (localIterator1.hasNext())
    {
      i locali = (i)localIterator1.next();
      u localu1;
      long l;
      Iterator localIterator2;
      u localu2;
      int i;
      if ((locali instanceof z))
      {
        localu1 = new u(locali.path, 2);
        localu1.bvf = locali.startTime;
        localu1.gOz = locali.endTime;
        localu1.Aox = ((z)locali).Apa;
        if (((z)locali).Apb <= 0L)
        {
          l = ((z)locali).Apa + localu1.getDurationMs();
          localu1.Aoy = l;
          localIterator2 = ((Iterable)paramList).iterator();
          if (!localIterator2.hasNext()) {
            break label321;
          }
          paramy = localIterator2.next();
          localu2 = (u)paramy;
          if ((localu2.type != 2) || (!k.g(localu2.path, locali.path))) {
            break label316;
          }
          i = 1;
          label214:
          if (i == 0) {
            break label319;
          }
          label218:
          paramy = (u)paramy;
          if (paramy == null) {
            break label326;
          }
          localu1.Aoz = paramy.Aoz;
          localu1.AoA = paramy.AoA;
          localu1.AoB = paramy.AoB;
          localu1.AoD.pvE.set(paramy.AoD.pvE);
          localu1.AoD.gUl.set(paramy.AoD.gUl);
          paramy = localu1;
        }
      }
      for (;;)
      {
        if (paramy == null) {
          break label552;
        }
        localLinkedList.add(paramy);
        break;
        l = locali.endTime;
        break label146;
        label316:
        i = 0;
        break label214;
        label319:
        break label163;
        label321:
        paramy = null;
        break label218;
        label326:
        paramy = null;
        continue;
        if ((locali instanceof g))
        {
          localu1 = new u(locali.path, 1);
          localu1.bvf = locali.startTime;
          localu1.gOz = locali.endTime;
          localu1.Aox = 0L;
          localu1.Aoy = (locali.endTime - locali.startTime);
          localu1.Aoz = 4000L;
          localIterator2 = ((Iterable)paramList).iterator();
          if (localIterator2.hasNext())
          {
            paramy = localIterator2.next();
            localu2 = (u)paramy;
            if ((localu2.type == 1) && (k.g(localu2.path, locali.path)))
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
            paramy = (u)paramy;
            if (paramy != null)
            {
              localu1.AoA = paramy.AoA;
              localu1.AoB = paramy.AoB;
              localu1.AoD.pvE.set(paramy.AoD.pvE);
              localu1.AoD.gUl.set(paramy.AoD.gUl);
            }
            paramy = localu1;
            break;
            i = 0;
            break label466;
            break label415;
            paramy = null;
          }
        }
        paramy = null;
      }
    }
    label415:
    paramy = (List)localLinkedList;
    label542:
    AppMethodBeat.o(207503);
    return paramy;
  }
  
  public static final void a(Rect paramRect, cnb paramcnb)
  {
    AppMethodBeat.i(207504);
    k.h(paramRect, "rect");
    k.h(paramcnb, "proto");
    paramcnb.Fjc.clear();
    paramcnb.Fjc.add(Integer.valueOf(paramRect.left));
    paramcnb.Fjc.add(Integer.valueOf(paramRect.top));
    paramcnb.Fjc.add(Integer.valueOf(paramRect.right));
    paramcnb.Fjc.add(Integer.valueOf(paramRect.bottom));
    AppMethodBeat.o(207504);
  }
  
  private static void a(u paramu, dix paramdix)
  {
    AppMethodBeat.i(207506);
    k.h(paramu, "track");
    k.h(paramdix, "proto");
    paramdix.path = paramu.path;
    paramdix.type = paramu.type;
    paramdix.bvf = paramu.bvf;
    paramdix.gOz = paramu.gOz;
    paramdix.Aox = paramu.Aox;
    paramdix.Aoy = paramu.Aoy;
    paramdix.Aoz = paramu.Aoz;
    paramdix.AoA = paramu.AoA;
    paramdix.AoB = paramu.AoB;
    paramdix.AoC = paramu.AoC;
    paramdix.FSo = new aad();
    paramu = paramu.AoD;
    paramdix = paramdix.FSo;
    k.g(paramdix, "proto.cropInfo");
    k.h(paramu, "cropInfo");
    k.h(paramdix, "proto");
    paramdix.Euo = new btt();
    paramdix.Eur = new cnb();
    paramdix.Eup = new cnb();
    paramdix.Euq = new cnb();
    Object localObject1 = paramu.eY;
    Object localObject2 = paramdix.Euo;
    k.g(localObject2, "proto.matrix");
    k.h(localObject1, "matrix");
    k.h(localObject2, "proto");
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject1).getValues(arrayOfFloat);
    ((btt)localObject2).Fjc.clear();
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      ((btt)localObject2).Fjc.add(Float.valueOf(f));
      i += 1;
    }
    localObject1 = paramu.pvE;
    localObject2 = paramdix.Eur;
    k.g(localObject2, "proto.contentRect");
    a((Rect)localObject1, (cnb)localObject2);
    localObject1 = paramu.gUl;
    localObject2 = paramdix.Eup;
    k.g(localObject2, "proto.cropRect");
    a((Rect)localObject1, (cnb)localObject2);
    paramu = paramu.viewRect;
    paramdix = paramdix.Euq;
    k.g(paramdix, "proto.viewRect");
    a(paramu, paramdix);
    AppMethodBeat.o(207506);
  }
  
  public static final void a(cnb paramcnb, Rect paramRect)
  {
    AppMethodBeat.i(207505);
    k.h(paramcnb, "proto");
    k.h(paramRect, "rect");
    if (paramcnb.Fjc.size() == 4)
    {
      Object localObject = paramcnb.Fjc.get(0);
      k.g(localObject, "proto.values[0]");
      int i = ((Number)localObject).intValue();
      localObject = paramcnb.Fjc.get(1);
      k.g(localObject, "proto.values[1]");
      int j = ((Number)localObject).intValue();
      localObject = paramcnb.Fjc.get(2);
      k.g(localObject, "proto.values[2]");
      int k = ((Number)localObject).intValue();
      paramcnb = paramcnb.Fjc.get(3);
      k.g(paramcnb, "proto.values[3]");
      paramRect.set(i, j, k, ((Number)paramcnb).intValue());
    }
    AppMethodBeat.o(207505);
  }
  
  private static void a(dix paramdix, u paramu)
  {
    AppMethodBeat.i(207507);
    k.h(paramdix, "proto");
    k.h(paramu, "track");
    paramu.bvf = paramdix.bvf;
    paramu.gOz = paramdix.gOz;
    paramu.Aox = paramdix.Aox;
    paramu.Aoy = paramdix.Aoy;
    paramu.Aoz = paramdix.Aoz;
    paramu.AoA = paramdix.AoA;
    paramu.AoB = paramdix.AoB;
    paramu.AoC = paramdix.AoC;
    paramdix = paramdix.FSo;
    if (paramdix != null)
    {
      paramu = paramu.AoD;
      k.h(paramdix, "proto");
      k.h(paramu, "cropInfo");
      Object localObject2 = paramdix.Euo;
      if (localObject2 != null)
      {
        localObject1 = paramu.eY;
        k.h(localObject2, "proto");
        k.h(localObject1, "matrix");
        if (((btt)localObject2).Fjc.size() == 9)
        {
          localObject2 = ((btt)localObject2).Fjc;
          k.g(localObject2, "proto.values");
          ((Matrix)localObject1).setValues(j.p((Collection)localObject2));
        }
      }
      Object localObject1 = paramdix.Eur;
      if (localObject1 != null) {
        a((cnb)localObject1, paramu.pvE);
      }
      localObject1 = paramdix.Eup;
      if (localObject1 != null) {
        a((cnb)localObject1, paramu.gUl);
      }
      paramdix = paramdix.Euq;
      if (paramdix != null)
      {
        a(paramdix, paramu.viewRect);
        AppMethodBeat.o(207507);
        return;
      }
      AppMethodBeat.o(207507);
      return;
    }
    AppMethodBeat.o(207507);
  }
  
  public static final e b(yo paramyo)
  {
    AppMethodBeat.i(207510);
    k.h(paramyo, "proto");
    Object localObject = com.tencent.mm.plugin.recordvideo.background.g.wmx;
    localObject = paramyo.AmQ.Esi;
    k.g(localObject, "proto.editData.baseItemData");
    Context localContext = ai.getContext();
    k.g(localContext, "MMApplicationContext.getContext()");
    paramyo = (e)new com.tencent.mm.plugin.recordvideo.background.c((List)com.tencent.mm.plugin.recordvideo.background.g.a((LinkedList)localObject, localContext), paramyo.AmP.wXZ, paramyo.AmP.wYa);
    AppMethodBeat.o(207510);
    return paramyo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.c
 * JD-Core Version:    0.7.0.1
 */