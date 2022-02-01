package com.tencent.mm.plugin.vlog.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.amk;
import com.tencent.mm.protocal.protobuf.dmc;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.fhx;
import com.tencent.mm.protocal.protobuf.fos;
import com.tencent.mm.protocal.protobuf.fqf;
import com.tencent.mm.protocal.protobuf.fxt;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.g;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.EffectManager.a;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.p.a;
import com.tencent.mm.xeffect.effect.t;
import com.tencent.mm.xeffect.effect.w;
import com.tencent.mm.xeffect.effect.x;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"TAG", "", "externalStickerEffectList", "", "Lcom/tencent/mm/protocal/protobuf/StickerEffectProto;", "clearStickerEffectList", "", "compositionToProto", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "cropInfoToProto", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "matrixToProto", "matrix", "Landroid/graphics/Matrix;", "Lcom/tencent/mm/protocal/protobuf/MatrixProto;", "protoToComposition", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "protoToCropInfo", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "protoToFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "protoToImageEnhancementEffect", "protoToMagic", "protoToMatrix", "protoToPagSticker", "protoToRect", "Lcom/tencent/mm/protocal/protobuf/RectProto;", "rect", "Landroid/graphics/Rect;", "protoToSticker", "protoToTrack", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "protoToTransitionInfo", "Lcom/tencent/mm/protocal/protobuf/TransitionInfoProto;", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "protoToVLogEffectMgr", "protoToVideoTemplate", "rectToProto", "saveStickerEffectList", "stickers", "", "scriptToTrackList", "", "script", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "sourceTrackList", "selectCompositionOutputFpsByTrackList", "", "trackList", "targetFps", "trackToProto", "transitionInfoToProto", "videoTemplateToProto", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "videoTemplate", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "fileName", "getTrackByTimeMs", "timeMs", "", "toInputTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "Lcom/tencent/tav/coremedia/TextureInfo;", "plugin-vlog_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final String TAG;
  private static final List<fhx> TYQ;
  
  static
  {
    AppMethodBeat.i(283610);
    TAG = "MicroMsg.Converter";
    TYQ = (List)new ArrayList();
    AppMethodBeat.o(283610);
  }
  
  public static final ad a(ac paramac, long paramLong)
  {
    AppMethodBeat.i(283604);
    s.u(paramac, "<this>");
    Iterator localIterator = ((Iterable)paramac.TDz).iterator();
    int i;
    if (localIterator.hasNext())
    {
      paramac = localIterator.next();
      ad localad = (ad)paramac;
      if ((localad.UaI.startTimeMs <= paramLong) && (localad.UaI.endTimeMs > paramLong))
      {
        i = 1;
        label80:
        if (i == 0) {
          break label99;
        }
      }
    }
    for (;;)
    {
      paramac = (ad)paramac;
      AppMethodBeat.o(283604);
      return paramac;
      i = 0;
      break label80;
      label99:
      break;
      paramac = null;
    }
  }
  
  public static final afb a(ac paramac, afc paramafc)
  {
    AppMethodBeat.i(283531);
    s.u(paramac, "composition");
    s.u(paramafc, "outputConfig");
    afb localafb = new afb();
    localafb.Znh = (paramac.Uaw.jLV().getStartUs() / 1000L);
    localafb.Zni = (paramac.Uaw.jLV().getEndUs() / 1000L);
    Object localObject1 = localafb.Zng;
    Object localObject3 = (Iterable)paramac.TDz;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ad localad = (ad)((Iterator)localObject3).next();
      fos localfos = new fos();
      a(localad, localfos);
      localfos.Uaj = localad.Uaj;
      ((Collection)localObject2).add(localfos);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localafb.Uax = paramac.Uax;
    localafb.Znj = true;
    localafb.TYB = paramafc;
    localafb.nBT = paramac.nBT;
    localafb.Uay = paramac.Uay;
    localafb.Znm = new LinkedList();
    paramac = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    paramac = ((Map)com.tencent.mm.plugin.vlog.model.local.a.hRx()).entrySet().iterator();
    while (paramac.hasNext())
    {
      localObject1 = (Map.Entry)paramac.next();
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
    AppMethodBeat.o(283531);
    return localafb;
  }
  
  public static final void a(Rect paramRect, enx paramenx)
  {
    AppMethodBeat.i(283400);
    s.u(paramRect, "rect");
    s.u(paramenx, "proto");
    paramenx.aaTg.clear();
    paramenx.aaTg.add(Integer.valueOf(paramRect.left));
    paramenx.aaTg.add(Integer.valueOf(paramRect.top));
    paramenx.aaTg.add(Integer.valueOf(paramRect.right));
    paramenx.aaTg.add(Integer.valueOf(paramRect.bottom));
    AppMethodBeat.o(283400);
  }
  
  private static final void a(ac paramac, afb paramafb, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(283565);
    HashMap localHashMap = new HashMap();
    paramafb = paramafb.Znm;
    s.s(paramafb, "proto.trackLabelInfoList");
    paramafb = ((Iterable)paramafb).iterator();
    while (paramafb.hasNext())
    {
      afd localafd = (afd)paramafb.next();
      Map localMap = (Map)localHashMap;
      String str = localafd.path;
      s.s(str, "it.path");
      localMap.put(str, Integer.valueOf(localafd.label));
    }
    paramafb = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.agXY);
    if ((paramafb instanceof com.tencent.mm.xeffect.effect.n))
    {
      paramafb = (com.tencent.mm.xeffect.effect.n)paramafb;
      if (paramafb != null) {
        paramafb.bL(paramac.Uaw.getPlayStart(), paramac.Uaw.hQW());
      }
      paramEffectManager.b((af)paramafb);
      if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", 0) != 1) {
        break label221;
      }
    }
    label221:
    for (boolean bool = true;; bool = false)
    {
      if ((bool) && (paramafb != null)) {
        paramafb.Oo(bool);
      }
      paramEffectManager = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.UlR;
      com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.a(paramafb);
      paramac.a((com.tencent.mm.videocomposition.c.e)new ai(paramac, localHashMap, paramafb));
      AppMethodBeat.o(283565);
      return;
      paramafb = null;
      break;
    }
  }
  
  private static void a(ac paramac, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(283439);
    s.u(paramac, "composition");
    s.u(paramEffectManager, "effectMgr");
    Iterator localIterator = ((Iterable)paramac.TDz).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (localad.hRe())
      {
        AssetManager localAssetManager;
        if (kotlin.n.n.U(localad.hRf(), "assets://", false))
        {
          localObject = com.tencent.mm.xeffect.effect.j.agXN;
          localAssetManager = MMApplicationContext.getContext().getAssets();
          s.s(localAssetManager, "getContext().assets");
        }
        for (Object localObject = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject, localAssetManager, localad.hRf());; localObject = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.agXN, localad.hRf()))
        {
          localad.UaI.TDy.Uby = ((af)localObject);
          paramEffectManager.b((af)localObject);
          break;
        }
      }
    }
    paramac.a(paramEffectManager);
    AppMethodBeat.o(283439);
  }
  
  private static void a(ad paramad, fos paramfos)
  {
    AppMethodBeat.i(283429);
    s.u(paramad, "track");
    s.u(paramfos, "proto");
    paramfos.path = paramad.path;
    paramfos.type = paramad.type;
    paramfos.startTimeMs = paramad.UaI.startTimeMs;
    paramfos.endTimeMs = paramad.UaI.endTimeMs;
    paramfos.TDw = paramad.UaI.TDw;
    paramfos.TDx = paramad.UaI.TDx;
    paramfos.UjZ = paramad.UaI.UjZ;
    paramfos.UaC = paramad.UaC;
    paramfos.UaD = paramad.UaD;
    paramfos.UaE = paramad.UaE;
    paramfos.volume = paramad.UaI.volume;
    paramfos.abOZ = new ahj();
    Object localObject1 = paramfos.abOZ;
    s.s(localObject1, "proto.cropInfo");
    s.u(paramad, "track");
    s.u(localObject1, "proto");
    ((ahj)localObject1).Zqp = new dmt();
    ((ahj)localObject1).Zqs = new enx();
    ((ahj)localObject1).Zqq = new enx();
    ((ahj)localObject1).Zqr = new enx();
    ((ahj)localObject1).Zqt = new enx();
    Object localObject2 = paramad.UaF.matrix;
    Object localObject3 = ((ahj)localObject1).Zqp;
    s.s(localObject3, "proto.matrix");
    s.u(localObject2, "matrix");
    s.u(localObject3, "proto");
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    ((dmt)localObject3).aaTg.clear();
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      ((dmt)localObject3).aaTg.add(Float.valueOf(f));
      i += 1;
    }
    localObject2 = paramad.UaF.yok;
    localObject3 = ((ahj)localObject1).Zqs;
    s.s(localObject3, "proto.contentRect");
    a((Rect)localObject2, (enx)localObject3);
    localObject2 = paramad.UaF.Gl;
    localObject3 = ((ahj)localObject1).Zqq;
    s.s(localObject3, "proto.cropRect");
    a((Rect)localObject2, (enx)localObject3);
    localObject2 = paramad.UaF.viewRect;
    localObject3 = ((ahj)localObject1).Zqr;
    s.s(localObject3, "proto.viewRect");
    a((Rect)localObject2, (enx)localObject3);
    localObject2 = paramad.UaI.agDz;
    localObject1 = ((ahj)localObject1).Zqt;
    s.s(localObject1, "proto.trackCropRect");
    a((Rect)localObject2, (enx)localObject1);
    paramfos.abPa = new fqf();
    paramad = paramad.UaI.TDy;
    paramfos = paramfos.abPa;
    s.s(paramfos, "proto.transitionInfo");
    a(paramad, paramfos);
    AppMethodBeat.o(283429);
  }
  
  private static void a(afb paramafb, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(283481);
    s.u(paramafb, "proto");
    s.u(paramEffectManager, "effectMgr");
    paramafb = paramafb.Zno;
    s.s(paramafb, "proto.stickerEffectList");
    Iterator localIterator = ((Iterable)kotlin.a.p.b((Collection)paramafb, (Iterable)TYQ)).iterator();
    label132:
    label279:
    label418:
    label421:
    while (localIterator.hasNext())
    {
      fhx localfhx = (fhx)localIterator.next();
      paramafb = (CharSequence)localfhx.path;
      int i;
      label101:
      Object localObject1;
      if ((paramafb == null) || (paramafb.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label279;
        }
        paramafb = com.tencent.mm.xeffect.effect.j.agYc;
        localObject1 = localfhx.path;
        s.s(localObject1, "effectProto.path");
        paramafb = paramEffectManager.a(paramafb, (String)localObject1);
        if (!(paramafb instanceof com.tencent.mm.xeffect.effect.ac)) {
          break label418;
        }
      }
      for (paramafb = (com.tencent.mm.xeffect.effect.ac)paramafb;; paramafb = null)
      {
        if (paramafb == null) {
          break label421;
        }
        localObject1 = localfhx.abIK;
        Object localObject2 = localfhx.abIL;
        paramafb.bL(((amk)localObject1).startTimeMs, ((amk)localObject1).endTimeMs);
        localObject1 = new com.tencent.mm.xeffect.effect.f(((amj)localObject2).centerX, ((amj)localObject2).centerY, ((amj)localObject2).scale, ((amj)localObject2).aBi);
        s.t(localObject1, "layoutInfo");
        paramafb.agXI.a((com.tencent.mm.xeffect.effect.f)localObject1);
        if ((localfhx.width != 0) && (localfhx.height != 0))
        {
          i = localfhx.width;
          int j = localfhx.height;
          VLogEffectJNI.INSTANCE.setStickerSize$renderlib_release(paramafb.ptr, i, j);
        }
        paramEffectManager.b((af)paramafb);
        break;
        i = 0;
        break label101;
        if (localfhx.abIJ != null)
        {
          localObject1 = com.tencent.mm.xeffect.effect.j.agYc;
          localObject2 = localfhx.abIJ.Op;
          s.s(localObject2, "effectProto.bytes.bytes");
          s.t(localObject1, "type");
          s.t(localObject2, "bytes");
          long l = paramEffectManager.nCreateEffectBinary(paramEffectManager.nNg, ((com.tencent.mm.xeffect.effect.j)localObject1).ordinal(), (byte[])localObject2, localObject2.length);
          paramafb = EffectManager.agXK;
          paramafb = EffectManager.a.a(l, (com.tencent.mm.xeffect.effect.j)localObject1);
          XEffectLog.i(EffectManager.TAG, "create effect binary ptr:" + l + ", type:" + localObject1 + ", " + localObject2.length, new Object[0]);
          break label132;
        }
        paramafb = null;
        break label132;
      }
    }
    AppMethodBeat.o(283481);
  }
  
  private static void a(afb paramafb, EffectManager paramEffectManager, ac paramac)
  {
    AppMethodBeat.i(283599);
    s.u(paramafb, "proto");
    s.u(paramEffectManager, "effectMgr");
    s.u(paramac, "composition");
    if (paramafb.Znl != null)
    {
      Object localObject1 = paramafb.Znl.Wqc;
      s.s(localObject1, "proto.videoTemplate.templatePath");
      Object localObject2;
      label134:
      label142:
      label177:
      int i;
      if (kotlin.n.n.U((String)localObject1, "assets://", false))
      {
        localObject1 = com.tencent.mm.xeffect.effect.j.agXQ;
        localObject2 = MMApplicationContext.getContext().getAssets();
        s.s(localObject2, "getContext().assets");
        Object localObject3 = paramafb.Znl.Wqc;
        s.s(localObject3, "proto.videoTemplate.templatePath");
        localObject2 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, (String)localObject3);
        paramEffectManager.b((af)localObject2);
        if (!(localObject2 instanceof w)) {
          break label389;
        }
        localObject1 = (w)localObject2;
        if (localObject1 != null) {
          break label395;
        }
        localObject1 = null;
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Size(0, 0);
        }
        if (!(localObject2 instanceof w)) {
          break label405;
        }
        localObject1 = (w)localObject2;
        if (localObject1 != null) {
          break label411;
        }
        i = 0;
        label184:
        localObject1 = paramafb.Znl.Wqc;
        s.s(localObject1, "proto.videoTemplate.templatePath");
        String str = paramafb.Znl.nBT;
        s.s(str, "proto.videoTemplate.musicPath");
        localObject1 = new a.c((String)localObject1, str, (Size)localObject3, paramafb.Znl.duration, i, paramafb.Znl.UbT, null, null, 0L, null, 1920);
        paramEffectManager.jQl();
        if (localObject2 != null) {
          ((af)localObject2).bL(0L, ((a.c)localObject1).duration);
        }
        if (localObject2 != null) {
          break label420;
        }
      }
      label389:
      label395:
      label405:
      label411:
      label420:
      for (long l = 0L;; l = ((af)localObject2).id)
      {
        ((a.c)localObject1).UbU = l;
        paramafb = paramafb.Znl.nBT;
        s.s(paramafb, "proto.videoTemplate.musicPath");
        ac.a(paramac, paramafb);
        paramafb = ((Iterable)paramac.TDz).iterator();
        while (paramafb.hasNext()) {
          ((ad)paramafb.next()).UaI.agDA = false;
        }
        localObject1 = com.tencent.mm.xeffect.effect.j.agXQ;
        localObject2 = paramafb.Znl.Wqc;
        s.s(localObject2, "proto.videoTemplate.templatePath");
        localObject2 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (String)localObject2);
        break;
        localObject1 = null;
        break label134;
        localObject1 = ((t)localObject1).Kz;
        break label142;
        localObject1 = null;
        break label177;
        i = ((t)localObject1).agYP;
        break label184;
      }
    }
    AppMethodBeat.o(283599);
  }
  
  public static final void a(enx paramenx, Rect paramRect)
  {
    AppMethodBeat.i(283411);
    s.u(paramRect, "rect");
    if (paramenx == null)
    {
      AppMethodBeat.o(283411);
      return;
    }
    if (paramenx.aaTg.size() == 4)
    {
      Object localObject = paramenx.aaTg.get(0);
      s.s(localObject, "proto.values[0]");
      int i = ((Number)localObject).intValue();
      localObject = paramenx.aaTg.get(1);
      s.s(localObject, "proto.values[1]");
      int j = ((Number)localObject).intValue();
      localObject = paramenx.aaTg.get(2);
      s.s(localObject, "proto.values[2]");
      int k = ((Number)localObject).intValue();
      paramenx = paramenx.aaTg.get(3);
      s.s(paramenx, "proto.values[3]");
      paramRect.set(i, j, k, ((Number)paramenx).intValue());
    }
    AppMethodBeat.o(283411);
  }
  
  public static final void a(g paramg, fqf paramfqf)
  {
    AppMethodBeat.i(283420);
    s.u(paramg, "transition");
    s.u(paramfqf, "proto");
    paramfqf.path = paramg.path;
    paramfqf.duration = paramg.duration;
    AppMethodBeat.o(283420);
  }
  
  public static final fxt b(a.c paramc)
  {
    AppMethodBeat.i(283588);
    s.u(paramc, "videoTemplate");
    fxt localfxt = new fxt();
    localfxt.Wqc = paramc.path;
    String str = com.tencent.mm.loader.i.b.bmr() + System.currentTimeMillis() + ".mp3";
    y.O(paramc.nBT, str, false);
    localfxt.nBT = str;
    localfxt.duration = paramc.duration;
    localfxt.UbT = paramc.UbT;
    AppMethodBeat.o(283588);
    return localfxt;
  }
  
  private static void b(afb paramafb, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(283505);
    s.u(paramafb, "proto");
    s.u(paramEffectManager, "effectMgr");
    Object localObject1 = paramafb.TYC.Znd;
    s.s(localObject1, "proto.editData.baseItemData");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label123:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((jy)localObject3).dataType == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYk.value) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label123;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    Iterator localIterator = ((Iterable)localObject1).iterator();
    if (localIterator.hasNext())
    {
      localObject1 = (jy)localIterator.next();
      s.s(localObject1, "it");
      com.tencent.mm.plugin.recordvideo.ui.editor.item.p localp = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p((jy)localObject1);
      if (kotlin.n.n.U(localp.LWN, "assets://", false))
      {
        localObject1 = com.tencent.mm.xeffect.effect.j.agXP;
        localObject2 = MMApplicationContext.getContext().getAssets();
        s.s(localObject2, "getContext().assets");
        localObject2 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, localp.LWN);
        label232:
        paramEffectManager.b((af)localObject2);
        if (!(localObject2 instanceof x)) {
          break label471;
        }
        localObject1 = (x)localObject2;
        label254:
        if (localObject1 != null)
        {
          ((x)localObject1).bL(localp.NXR.getStart(), localp.NXR.getEnd());
          ((x)localObject1).a(new com.tencent.mm.xeffect.effect.f((int)localp.centerX, (int)localp.centerY, localp.scale, localp.aBi));
          ((x)localObject1).a(new com.tencent.mm.xeffect.effect.h(localp.text, null, 30));
        }
        if (!(localObject2 instanceof t)) {
          break label477;
        }
        localObject1 = (t)localObject2;
        label349:
        if (localObject1 != null) {
          break label483;
        }
        localObject1 = null;
        label357:
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = new Size(0, 0);
        }
        localp.width = ((Size)localObject3).getWidth();
        localp.height = ((Size)localObject3).getHeight();
        localObject1 = new Rect();
        a(paramafb.TYC.Znc, (Rect)localObject1);
        localp.NZn.set((Rect)localObject1);
        localp.i(localp.matrix);
        if (localObject2 != null) {
          break label493;
        }
      }
      label471:
      label477:
      label483:
      label493:
      for (long l = 0L;; l = ((af)localObject2).id)
      {
        localp.NZm = l;
        break;
        localObject2 = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.agXP, localp.LWN);
        break label232;
        localObject1 = null;
        break label254;
        localObject1 = null;
        break label349;
        localObject1 = ((t)localObject1).Kz;
        break label357;
      }
    }
    AppMethodBeat.o(283505);
  }
  
  public static final String beZ(String paramString)
  {
    AppMethodBeat.i(283392);
    s.u(paramString, "<this>");
    CharSequence localCharSequence = (CharSequence)paramString;
    int i = localCharSequence.length() - 1;
    int j;
    if (i >= 0) {
      if (localCharSequence.charAt(i) == '/')
      {
        j = 1;
        label44:
        if (j == 0) {
          break label76;
        }
      }
    }
    for (;;)
    {
      paramString = paramString.substring(i + 1);
      s.s(paramString, "(this as java.lang.String).substring(startIndex)");
      AppMethodBeat.o(283392);
      return paramString;
      j = 0;
      break label44;
      label76:
      i -= 1;
      break;
      i = -1;
    }
  }
  
  private static void c(afb paramafb, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(283517);
    s.u(paramafb, "proto");
    s.u(paramEffectManager, "effectMgr");
    paramafb = paramafb.Znk;
    s.s(paramafb, "proto.magicInfoList");
    Iterator localIterator = ((Iterable)paramafb).iterator();
    if (localIterator.hasNext())
    {
      dmc localdmc = (dmc)localIterator.next();
      paramafb = localdmc.path;
      s.s(paramafb, "it.path");
      Object localObject;
      String str;
      if (kotlin.n.n.U(paramafb, "assets://", false))
      {
        paramafb = com.tencent.mm.xeffect.effect.j.agXR;
        localObject = MMApplicationContext.getContext().getAssets();
        s.s(localObject, "getContext().assets");
        str = localdmc.path;
        s.s(str, "it.path");
      }
      for (paramafb = paramEffectManager.a(paramafb, (AssetManager)localObject, str);; paramafb = paramEffectManager.a(paramafb, (String)localObject))
      {
        if (paramafb != null) {
          paramafb.bL(localdmc.start, localdmc.axI);
        }
        paramEffectManager.b(paramafb);
        break;
        paramafb = com.tencent.mm.xeffect.effect.j.agXR;
        localObject = localdmc.path;
        s.s(localObject, "it.path");
      }
    }
    AppMethodBeat.o(283517);
  }
  
  public static final ac d(afb paramafb, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(283553);
    s.u(paramafb, "proto");
    s.u(paramEffectManager, "effectMgr");
    Object localObject1 = new LinkedList();
    Object localObject2 = paramafb.Zng;
    s.s(localObject2, "proto.tracks");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (fos)((Iterator)localObject3).next();
      Object localObject4 = ((fos)localObject5).path;
      s.s(localObject4, "it.path");
      localObject4 = new ad((String)localObject4, ((fos)localObject5).type);
      s.s(localObject5, "it");
      s.u(localObject5, "proto");
      s.u(localObject4, "track");
      ((ad)localObject4).setStartTimeMs(((fos)localObject5).startTimeMs);
      ((ad)localObject4).wA(((fos)localObject5).endTimeMs);
      ((ad)localObject4).wB(((fos)localObject5).TDw);
      ((ad)localObject4).wC(((fos)localObject5).TDx);
      ((ad)localObject4).UaC = ((fos)localObject5).UaC;
      ((ad)localObject4).UaD = ((fos)localObject5).UaD;
      ((ad)localObject4).UaE = ((fos)localObject5).UaE;
      ((ad)localObject4).setVolume(((fos)localObject5).volume);
      a(((fos)localObject5).abOZ.Zqq, ((ad)localObject4).UaI.Gl);
      a(((fos)localObject5).abOZ.Zqt, ((ad)localObject4).UaI.agDz);
      localObject5 = ((fos)localObject5).abPa;
      if (localObject5 != null)
      {
        g localg = ((ad)localObject4).UaI.TDy;
        s.u(localObject5, "proto");
        s.u(localg, "transition");
        String str = ((fqf)localObject5).path;
        s.s(str, "proto.path");
        localg.setPath(str);
        localg.duration = ((fqf)localObject5).duration;
      }
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject1 = new ac((List)localObject1);
    int j;
    if (paramafb.TYB.Znu != null)
    {
      localObject2 = new Rect();
      a(paramafb.TYB.Znu, (Rect)localObject2);
      j = ((Rect)localObject2).width();
    }
    for (int i = ((Rect)localObject2).height();; i = paramafb.TYB.HJO)
    {
      ((ac)localObject1).getComposition().pk(j, i);
      ((ac)localObject1).bs(paramafb.Znh, paramafb.Zni);
      if (!Util.isNullOrNil(paramafb.nBT))
      {
        localObject2 = paramafb.nBT;
        s.s(localObject2, "proto.musicPath");
        ((ac)localObject1).dv((String)localObject2, true);
      }
      ((ac)localObject1).FO(paramafb.Uax);
      if (paramafb.TYB.Znp == null) {
        break;
      }
      localObject2 = new Rect();
      a(paramafb.TYB.Znp, (Rect)localObject2);
      ((ac)localObject1).F((Rect)localObject2);
      a((ac)localObject1, paramEffectManager);
      a(paramafb, paramEffectManager);
      b(paramafb, paramEffectManager);
      c(paramafb, paramEffectManager);
      a(paramafb, paramEffectManager, (ac)localObject1);
      ((ac)localObject1).Uay = paramafb.Uay;
      if (((ac)localObject1).Uay) {
        a((ac)localObject1, paramafb, paramEffectManager);
      }
      AppMethodBeat.o(283553);
      return localObject1;
      j = paramafb.TYB.HJN;
    }
    localObject2 = new Rect();
    if (paramafb.TYB.Znv != null) {
      a(paramafb.TYB.Znv.Zqq, (Rect)localObject2);
    }
    for (;;)
    {
      ((ac)localObject1).F((Rect)localObject2);
      break;
      a(paramafb.TYB.Znw.Zqq, (Rect)localObject2);
    }
  }
  
  public static final c e(afb paramafb)
  {
    AppMethodBeat.i(283577);
    s.u(paramafb, "proto");
    Object localObject1 = com.tencent.mm.plugin.recordvideo.background.e.NDU;
    localObject1 = paramafb.TYC.Znd;
    s.s(localObject1, "proto.editData.baseItemData");
    Object localObject2 = MMApplicationContext.getContext();
    s.s(localObject2, "getContext()");
    localObject1 = com.tencent.mm.plugin.recordvideo.background.e.b((LinkedList)localObject1, (Context)localObject2);
    localObject2 = paramafb.TYC.Znc.aaTg;
    s.s(localObject2, "proto.editData.drawingRect.values");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Float.valueOf(((Integer)((Iterator)localObject3).next()).intValue()));
    }
    localObject2 = kotlin.a.p.H((Collection)localObject2);
    localObject3 = paramafb.TYC.Znf;
    if (localObject3 != null)
    {
      localObject3 = ((enx)localObject3).aaTg;
      s.s(localObject3, "rectProto.values");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Float.valueOf(((Integer)((Iterator)localObject4).next()).intValue()));
      }
      kotlin.a.p.H((Collection)localObject3);
    }
    int i;
    if (paramafb.TYB.Znu == null) {
      i = paramafb.TYB.HJN;
    }
    for (int j = paramafb.TYB.HJO;; j = ((Rect)localObject3).height())
    {
      paramafb = (c)new com.tencent.mm.plugin.recordvideo.ui.editor.b.f((float[])localObject2, (List)localObject1, i, j);
      AppMethodBeat.o(283577);
      return paramafb;
      localObject3 = new Rect();
      a(paramafb.TYB.Znu, (Rect)localObject3);
      i = ((Rect)localObject3).width();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.h
 * JD-Core Version:    0.7.0.1
 */