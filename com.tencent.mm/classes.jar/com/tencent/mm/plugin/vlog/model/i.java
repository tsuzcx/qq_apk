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
import com.tencent.mm.plugin.recordvideo.ui.editor.item.o;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.aeo;
import com.tencent.mm.protocal.protobuf.aip;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.clz;
import com.tencent.mm.protocal.protobuf.cmv;
import com.tencent.mm.protocal.protobuf.dlh;
import com.tencent.mm.protocal.protobuf.ecy;
import com.tencent.mm.protocal.protobuf.ejf;
import com.tencent.mm.protocal.protobuf.ekn;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.jn;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.k;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.aa;
import com.tencent.mm.xeffect.effect.h;
import com.tencent.mm.xeffect.effect.r;
import com.tencent.mm.xeffect.effect.u;
import com.tencent.mm.xeffect.effect.v;
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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"TAG", "", "externalStickerEffectList", "", "Lcom/tencent/mm/protocal/protobuf/StickerEffectProto;", "clearStickerEffectList", "", "compositionToProto", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "cropInfoToProto", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "matrixToProto", "matrix", "Landroid/graphics/Matrix;", "Lcom/tencent/mm/protocal/protobuf/MatrixProto;", "protoToComposition", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "protoToCropInfo", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "protoToFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "protoToImageEnhancementEffect", "protoToMagic", "protoToMatrix", "protoToPagSticker", "protoToRect", "Lcom/tencent/mm/protocal/protobuf/RectProto;", "rect", "Landroid/graphics/Rect;", "protoToSticker", "protoToTrack", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "protoToTransitionInfo", "Lcom/tencent/mm/protocal/protobuf/TransitionInfoProto;", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "protoToVLogEffectMgr", "protoToVideoTemplate", "rectToProto", "saveStickerEffectList", "stickers", "", "scriptToTrackList", "", "script", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "sourceTrackList", "selectCompositionOutputFpsByTrackList", "", "trackList", "targetFps", "trackToProto", "transitionInfoToProto", "videoTemplateToProto", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "videoTemplate", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "fileName", "getTrackByTimeMs", "timeMs", "", "toInputTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "Lcom/tencent/tav/coremedia/TextureInfo;", "plugin-vlog_release"})
public final class i
{
  private static final List<ecy> GxM;
  private static final String TAG = "MicroMsg.Converter";
  
  static
  {
    AppMethodBeat.i(190560);
    TAG = "MicroMsg.Converter";
    GxM = (List)new ArrayList();
    AppMethodBeat.o(190560);
  }
  
  public static final ad a(ac paramac, long paramLong)
  {
    AppMethodBeat.i(190559);
    p.h(paramac, "$this$getTrackByTimeMs");
    Iterator localIterator = ((Iterable)paramac.Gzn).iterator();
    int i;
    if (localIterator.hasNext())
    {
      paramac = localIterator.next();
      ad localad = (ad)paramac;
      if ((localad.GzA.startTimeMs <= paramLong) && (localad.GzA.endTimeMs > paramLong))
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
      AppMethodBeat.o(190559);
      return paramac;
      i = 0;
      break label80;
      label99:
      break;
      paramac = null;
    }
  }
  
  public static final acn a(ac paramac, aco paramaco)
  {
    AppMethodBeat.i(190553);
    p.h(paramac, "composition");
    p.h(paramaco, "outputConfig");
    acn localacn = new acn();
    localacn.Lne = (paramac.Gez.hfo().getStartUs() / 1000L);
    localacn.Lnf = (paramac.Gez.hfo().getEndUs() / 1000L);
    Object localObject1 = localacn.Lnd;
    Object localObject3 = (Iterable)paramac.Gzn;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ad localad = (ad)((Iterator)localObject3).next();
      ejf localejf = new ejf();
      a(localad, localejf);
      localejf.Gze = localad.Gze;
      ((Collection)localObject2).add(localejf);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localacn.Gzo = paramac.Gzo;
    localacn.Lng = true;
    localacn.Gxw = paramaco;
    localacn.iiv = paramac.iiv;
    localacn.Gzp = paramac.Gzp;
    localacn.Lnj = new LinkedList();
    paramac = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    paramac = ((Map)com.tencent.mm.plugin.vlog.model.local.a.fBS()).entrySet().iterator();
    while (paramac.hasNext())
    {
      localObject1 = (Map.Entry)paramac.next();
      paramaco = new acp();
      paramaco.path = ((String)((Map.Entry)localObject1).getKey());
      localObject2 = ((Pair)((Map.Entry)localObject1).getValue()).first;
      p.g(localObject2, "it.value.first");
      paramaco.label = ((Number)localObject2).intValue();
      localObject1 = ((Pair)((Map.Entry)localObject1).getValue()).second;
      p.g(localObject1, "it.value.second");
      paramaco.Lns = ((Number)localObject1).longValue();
      localacn.Lnj.add(paramaco);
    }
    AppMethodBeat.o(190553);
    return localacn;
  }
  
  public static final void a(Rect paramRect, dlh paramdlh)
  {
    AppMethodBeat.i(190545);
    p.h(paramRect, "rect");
    p.h(paramdlh, "proto");
    paramdlh.Msu.clear();
    paramdlh.Msu.add(Integer.valueOf(paramRect.left));
    paramdlh.Msu.add(Integer.valueOf(paramRect.top));
    paramdlh.Msu.add(Integer.valueOf(paramRect.right));
    paramdlh.Msu.add(Integer.valueOf(paramRect.bottom));
    AppMethodBeat.o(190545);
  }
  
  private static final void a(ac paramac, acn paramacn, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(190555);
    HashMap localHashMap = new HashMap();
    paramacn = paramacn.Lnj;
    p.g(paramacn, "proto.trackLabelInfoList");
    paramacn = ((Iterable)paramacn).iterator();
    while (paramacn.hasNext())
    {
      localObject = (acp)paramacn.next();
      Map localMap = (Map)localHashMap;
      String str = ((acp)localObject).path;
      p.g(str, "it.path");
      localMap.put(str, Integer.valueOf(((acp)localObject).label));
    }
    Object localObject = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.Ryg);
    paramacn = (acn)localObject;
    if (!(localObject instanceof com.tencent.mm.xeffect.effect.n)) {
      paramacn = null;
    }
    paramacn = (com.tencent.mm.xeffect.effect.n)paramacn;
    if (paramacn != null) {
      paramacn.aH(paramac.Gez.getPlayStart(), paramac.Gez.fBz());
    }
    paramEffectManager.a((com.tencent.mm.xeffect.effect.ad)paramacn);
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (paramacn != null)) {
        paramacn.DL(true);
      }
      paramEffectManager = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
      com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.a(paramacn);
      paramac.a((com.tencent.mm.videocomposition.b.e)new ai(paramac, localHashMap, paramacn));
      AppMethodBeat.o(190555);
      return;
    }
  }
  
  private static void a(ac paramac, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(190549);
    p.h(paramac, "composition");
    p.h(paramEffectManager, "effectMgr");
    Iterator localIterator = ((Iterable)paramac.Gzn).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (localad.fBG())
      {
        Object localObject2;
        if (kotlin.n.n.J(localad.fBH(), "assets://", false))
        {
          localObject1 = com.tencent.mm.xeffect.effect.j.RxV;
          localObject2 = MMApplicationContext.getContext();
          p.g(localObject2, "MMApplicationContext.getContext()");
          localObject2 = ((Context)localObject2).getAssets();
          p.g(localObject2, "MMApplicationContext.getContext().assets");
        }
        for (Object localObject1 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, localad.fBH());; localObject1 = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.RxV, localad.fBH()))
        {
          localad.GzA.Rhc.GAn = ((com.tencent.mm.xeffect.effect.ad)localObject1);
          paramEffectManager.a((com.tencent.mm.xeffect.effect.ad)localObject1);
          break;
        }
      }
    }
    paramac.a(paramEffectManager);
    AppMethodBeat.o(190549);
  }
  
  private static void a(ad paramad, ejf paramejf)
  {
    AppMethodBeat.i(190547);
    p.h(paramad, "track");
    p.h(paramejf, "proto");
    paramejf.path = paramad.path;
    paramejf.type = paramad.type;
    paramejf.startTimeMs = paramad.GzA.startTimeMs;
    paramejf.endTimeMs = paramad.GzA.endTimeMs;
    paramejf.GGz = paramad.GzA.GGz;
    paramejf.GGA = paramad.GzA.GGA;
    paramejf.GJB = paramad.GzA.GJB;
    paramejf.Gzu = paramad.Gzu;
    paramejf.Gzv = paramad.Gzv;
    paramejf.Gzw = paramad.Gzw;
    paramejf.volume = paramad.GzA.volume;
    paramejf.NiP = new aeo();
    Object localObject1 = paramejf.NiP;
    p.g(localObject1, "proto.cropInfo");
    p.h(paramad, "track");
    p.h(localObject1, "proto");
    ((aeo)localObject1).LpQ = new cmv();
    ((aeo)localObject1).LpT = new dlh();
    ((aeo)localObject1).LpR = new dlh();
    ((aeo)localObject1).LpS = new dlh();
    ((aeo)localObject1).LpU = new dlh();
    Object localObject2 = paramad.Gzx.gT;
    Object localObject3 = ((aeo)localObject1).LpQ;
    p.g(localObject3, "proto.matrix");
    p.h(localObject2, "matrix");
    p.h(localObject3, "proto");
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    ((cmv)localObject3).Msu.clear();
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      ((cmv)localObject3).Msu.add(Float.valueOf(f));
      i += 1;
    }
    localObject2 = paramad.Gzx.rwL;
    localObject3 = ((aeo)localObject1).LpT;
    p.g(localObject3, "proto.contentRect");
    a((Rect)localObject2, (dlh)localObject3);
    localObject2 = paramad.Gzx.iiw;
    localObject3 = ((aeo)localObject1).LpR;
    p.g(localObject3, "proto.cropRect");
    a((Rect)localObject2, (dlh)localObject3);
    localObject2 = paramad.Gzx.viewRect;
    localObject3 = ((aeo)localObject1).LpS;
    p.g(localObject3, "proto.viewRect");
    a((Rect)localObject2, (dlh)localObject3);
    localObject2 = paramad.GzA.Rha;
    localObject1 = ((aeo)localObject1).LpU;
    p.g(localObject1, "proto.trackCropRect");
    a((Rect)localObject2, (dlh)localObject1);
    paramejf.NiQ = new ekn();
    paramad = paramad.GzA.Rhc;
    paramejf = paramejf.NiQ;
    p.g(paramejf, "proto.transitionInfo");
    p.h(paramad, "transition");
    p.h(paramejf, "proto");
    paramejf.path = paramad.path;
    paramejf.duration = paramad.duration;
    AppMethodBeat.o(190547);
  }
  
  private static void a(acn paramacn, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(190550);
    p.h(paramacn, "proto");
    p.h(paramEffectManager, "effectMgr");
    paramacn = paramacn.Lnl;
    p.g(paramacn, "proto.stickerEffectList");
    Iterator localIterator = ((Iterable)kotlin.a.j.b((Collection)paramacn, (Iterable)GxM)).iterator();
    if (localIterator.hasNext())
    {
      ecy localecy = (ecy)localIterator.next();
      paramacn = (CharSequence)localecy.path;
      int i;
      label101:
      Object localObject;
      if ((paramacn == null) || (paramacn.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label252;
        }
        paramacn = com.tencent.mm.xeffect.effect.j.Ryk;
        localObject = localecy.path;
        p.g(localObject, "effectProto.path");
        paramacn = paramEffectManager.a(paramacn, (String)localObject);
      }
      for (;;)
      {
        localObject = paramacn;
        if (!(paramacn instanceof aa)) {
          localObject = null;
        }
        paramacn = (aa)localObject;
        if (paramacn == null) {
          break;
        }
        localObject = localecy.Ndo;
        aip localaip = localecy.Ndp;
        paramacn.aH(((aiq)localObject).startTimeMs, ((aiq)localObject).endTimeMs);
        paramacn.a(new com.tencent.mm.xeffect.effect.f(localaip.centerX, localaip.centerY, localaip.scale, localaip.mat));
        if ((localecy.width != 0) && (localecy.height != 0)) {
          paramacn.setSize(localecy.width, localecy.height);
        }
        paramEffectManager.a((com.tencent.mm.xeffect.effect.ad)paramacn);
        break;
        i = 0;
        break label101;
        label252:
        if (localecy.Ndn != null)
        {
          paramacn = com.tencent.mm.xeffect.effect.j.Ryk;
          localObject = localecy.Ndn;
          p.g(localObject, "effectProto.bytes");
          localObject = ((com.tencent.mm.bw.b)localObject).zy;
          p.g(localObject, "effectProto.bytes.bytes");
          paramacn = paramEffectManager.a(paramacn, (byte[])localObject);
        }
        else
        {
          paramacn = null;
        }
      }
    }
    AppMethodBeat.o(190550);
  }
  
  private static void a(acn paramacn, EffectManager paramEffectManager, ac paramac)
  {
    AppMethodBeat.i(190558);
    p.h(paramacn, "proto");
    p.h(paramEffectManager, "effectMgr");
    p.h(paramac, "composition");
    Object localObject1;
    Object localObject3;
    if (paramacn.Lni != null)
    {
      localObject1 = paramacn.Lni.IFw;
      p.g(localObject1, "proto.videoTemplate.templatePath");
      if (kotlin.n.n.J((String)localObject1, "assets://", false))
      {
        localObject1 = com.tencent.mm.xeffect.effect.j.RxY;
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getAssets();
        p.g(localObject2, "MMApplicationContext.getContext().assets");
        localObject3 = paramacn.Lni.IFw;
        p.g(localObject3, "proto.videoTemplate.templatePath");
        localObject1 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, (String)localObject3);
        paramEffectManager.a((com.tencent.mm.xeffect.effect.ad)localObject1);
        if ((localObject1 instanceof u)) {
          break label437;
        }
      }
    }
    label417:
    label437:
    for (Object localObject2 = null;; localObject2 = localObject1)
    {
      localObject2 = (u)localObject2;
      if (localObject2 != null)
      {
        localObject3 = ((r)localObject2).ApT;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = new Size(0, 0);
      }
      if (!(localObject1 instanceof u)) {}
      for (localObject3 = null;; localObject3 = localObject1)
      {
        localObject3 = (u)localObject3;
        int i;
        if (localObject3 != null)
        {
          i = ((r)localObject3).RyV;
          label210:
          localObject3 = paramacn.Lni.IFw;
          p.g(localObject3, "proto.videoTemplate.templatePath");
          String str = paramacn.Lni.iiv;
          p.g(str, "proto.videoTemplate.musicPath");
          localObject2 = new a.c((String)localObject3, str, (Size)localObject2, paramacn.Lni.duration, i, paramacn.Lni.GAH);
          paramEffectManager.hiv();
          if (localObject1 != null) {
            ((com.tencent.mm.xeffect.effect.ad)localObject1).aH(0L, ((a.c)localObject2).duration);
          }
          if (localObject1 == null) {
            break label417;
          }
        }
        for (long l = ((com.tencent.mm.xeffect.effect.ad)localObject1).id;; l = 0L)
        {
          ((a.c)localObject2).GAI = l;
          paramacn = paramacn.Lni.iiv;
          p.g(paramacn, "proto.videoTemplate.musicPath");
          ac.a(paramac, paramacn);
          paramacn = ((Iterable)paramac.Gzn).iterator();
          while (paramacn.hasNext()) {
            ((ad)paramacn.next()).GzA.Rhb = false;
          }
          localObject1 = com.tencent.mm.xeffect.effect.j.RxY;
          localObject2 = paramacn.Lni.IFw;
          p.g(localObject2, "proto.videoTemplate.templatePath");
          localObject1 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (String)localObject2);
          break;
          i = 0;
          break label210;
        }
        AppMethodBeat.o(190558);
        return;
      }
    }
  }
  
  public static final void a(dlh paramdlh, Rect paramRect)
  {
    AppMethodBeat.i(190546);
    p.h(paramdlh, "proto");
    p.h(paramRect, "rect");
    if (paramdlh.Msu.size() == 4)
    {
      Object localObject = paramdlh.Msu.get(0);
      p.g(localObject, "proto.values[0]");
      int i = ((Number)localObject).intValue();
      localObject = paramdlh.Msu.get(1);
      p.g(localObject, "proto.values[1]");
      int j = ((Number)localObject).intValue();
      localObject = paramdlh.Msu.get(2);
      p.g(localObject, "proto.values[2]");
      int k = ((Number)localObject).intValue();
      paramdlh = paramdlh.Msu.get(3);
      p.g(paramdlh, "proto.values[3]");
      paramRect.set(i, j, k, ((Number)paramdlh).intValue());
    }
    AppMethodBeat.o(190546);
  }
  
  private static void a(ejf paramejf, ad paramad)
  {
    AppMethodBeat.i(190548);
    p.h(paramejf, "proto");
    p.h(paramad, "track");
    paramad.KO(paramejf.startTimeMs);
    paramad.KP(paramejf.endTimeMs);
    paramad.KQ(paramejf.GGz);
    paramad.KR(paramejf.GGA);
    paramad.Gzu = paramejf.Gzu;
    paramad.Gzv = paramejf.Gzv;
    paramad.Gzw = paramejf.Gzw;
    paramad.setVolume(paramejf.volume);
    Object localObject2 = paramejf.NiP;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject1 = paramad.Gzx;
      p.h(localObject2, "proto");
      p.h(localObject1, "cropInfo");
      Object localObject4 = ((aeo)localObject2).LpQ;
      if (localObject4 != null)
      {
        localObject3 = ((j)localObject1).gT;
        p.h(localObject4, "proto");
        p.h(localObject3, "matrix");
        if (((cmv)localObject4).Msu.size() == 9)
        {
          localObject4 = ((cmv)localObject4).Msu;
          p.g(localObject4, "proto.values");
          ((Matrix)localObject3).setValues(kotlin.a.j.t((Collection)localObject4));
        }
      }
      localObject3 = ((aeo)localObject2).LpT;
      if (localObject3 != null) {
        a((dlh)localObject3, ((j)localObject1).rwL);
      }
      localObject3 = ((aeo)localObject2).LpR;
      if (localObject3 != null) {
        a((dlh)localObject3, ((j)localObject1).iiw);
      }
      localObject2 = ((aeo)localObject2).LpS;
      if (localObject2 != null) {
        a((dlh)localObject2, ((j)localObject1).viewRect);
      }
    }
    paramad.GzA.iiw.set(paramad.Gzx.rwL);
    Object localObject1 = paramejf.NiQ;
    if (localObject1 != null)
    {
      localObject2 = paramad.GzA.Rhc;
      p.h(localObject1, "proto");
      p.h(localObject2, "transition");
      localObject3 = ((ekn)localObject1).path;
      p.g(localObject3, "proto.path");
      ((k)localObject2).setPath((String)localObject3);
      ((k)localObject2).duration = ((ekn)localObject1).duration;
    }
    paramejf = paramejf.NiP;
    if (paramejf != null)
    {
      paramejf = paramejf.LpU;
      p.g(paramejf, "it.trackCropRect");
      a(paramejf, paramad.GzA.Rha);
      AppMethodBeat.o(190548);
      return;
    }
    AppMethodBeat.o(190548);
  }
  
  public static final String aTT(String paramString)
  {
    AppMethodBeat.i(190543);
    p.h(paramString, "$this$fileName");
    CharSequence localCharSequence = (CharSequence)paramString;
    int i = localCharSequence.length() - 1;
    int j;
    if (i >= 0) {
      if (localCharSequence.charAt(i) == '/')
      {
        j = 1;
        label45:
        if (j == 0) {
          break label77;
        }
      }
    }
    for (;;)
    {
      paramString = paramString.substring(i + 1);
      p.g(paramString, "(this as java.lang.String).substring(startIndex)");
      AppMethodBeat.o(190543);
      return paramString;
      j = 0;
      break label45;
      label77:
      i -= 1;
      break;
      i = -1;
    }
  }
  
  public static final eqy b(a.c paramc)
  {
    AppMethodBeat.i(190557);
    p.h(paramc, "videoTemplate");
    eqy localeqy = new eqy();
    localeqy.IFw = paramc.path;
    String str = com.tencent.mm.loader.j.b.aKB() + System.currentTimeMillis() + ".mp3";
    s.nw(paramc.iiv, str);
    localeqy.iiv = str;
    localeqy.duration = paramc.duration;
    localeqy.GAH = paramc.GAH;
    AppMethodBeat.o(190557);
    return localeqy;
  }
  
  private static void b(acn paramacn, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(190551);
    p.h(paramacn, "proto");
    p.h(paramEffectManager, "effectMgr");
    Object localObject1 = paramacn.Gxx.Lna;
    p.g(localObject1, "proto.editData.baseItemData");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label123:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((jn)localObject3).dataType == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.CeR.value) {}
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
    o localo;
    if (localIterator.hasNext())
    {
      localObject1 = (jn)localIterator.next();
      p.g(localObject1, "it");
      localo = new o((jn)localObject1);
      if (kotlin.n.n.J(localo.Cga, "assets://", false))
      {
        localObject1 = com.tencent.mm.xeffect.effect.j.RxX;
        localObject2 = MMApplicationContext.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getAssets();
        p.g(localObject2, "MMApplicationContext.getContext().assets");
        localObject1 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, localo.Cga);
        label244:
        paramEffectManager.a((com.tencent.mm.xeffect.effect.ad)localObject1);
        if ((localObject1 instanceof v)) {
          break label528;
        }
      }
    }
    label528:
    for (localObject2 = null;; localObject2 = localObject1)
    {
      localObject2 = (v)localObject2;
      if (localObject2 != null)
      {
        ((v)localObject2).aH(localo.Cev.getStart(), localo.Cev.getEnd());
        ((v)localObject2).a(new com.tencent.mm.xeffect.effect.f((int)localo.centerX, (int)localo.centerY, localo.scale, localo.mat));
        ((v)localObject2).a(new h(localo.text, null, 30));
      }
      if (!(localObject1 instanceof r)) {}
      for (localObject2 = null;; localObject2 = localObject1)
      {
        localObject2 = (r)localObject2;
        if (localObject2 != null)
        {
          localObject3 = ((r)localObject2).ApT;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = new Size(0, 0);
        }
        localo.width = ((Size)localObject2).getWidth();
        localo.height = ((Size)localObject2).getHeight();
        localObject2 = new Rect();
        localObject3 = paramacn.Gxx.LmZ;
        p.g(localObject3, "proto.editData.drawingRect");
        a((dlh)localObject3, (Rect)localObject2);
        localo.Cgb.set((Rect)localObject2);
        localo.g(localo.gT);
        if (localObject1 != null) {}
        for (long l = ((com.tencent.mm.xeffect.effect.ad)localObject1).id;; l = 0L)
        {
          localo.wKD = l;
          break;
          localObject1 = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.RxX, localo.Cga);
          break label244;
        }
        AppMethodBeat.o(190551);
        return;
      }
    }
  }
  
  private static void c(acn paramacn, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(190552);
    p.h(paramacn, "proto");
    p.h(paramEffectManager, "effectMgr");
    paramacn = paramacn.Lnh;
    p.g(paramacn, "proto.magicInfoList");
    Iterator localIterator = ((Iterable)paramacn).iterator();
    if (localIterator.hasNext())
    {
      clz localclz = (clz)localIterator.next();
      paramacn = localclz.path;
      p.g(paramacn, "it.path");
      Object localObject;
      String str;
      if (kotlin.n.n.J(paramacn, "assets://", false))
      {
        paramacn = com.tencent.mm.xeffect.effect.j.RxZ;
        localObject = MMApplicationContext.getContext();
        p.g(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getAssets();
        p.g(localObject, "MMApplicationContext.getContext().assets");
        str = localclz.path;
        p.g(str, "it.path");
      }
      for (paramacn = paramEffectManager.a(paramacn, (AssetManager)localObject, str);; paramacn = paramEffectManager.a(paramacn, (String)localObject))
      {
        if (paramacn != null) {
          paramacn.aH(localclz.start, localclz.boX);
        }
        paramEffectManager.a(paramacn);
        break;
        paramacn = com.tencent.mm.xeffect.effect.j.RxZ;
        localObject = localclz.path;
        p.g(localObject, "it.path");
      }
    }
    AppMethodBeat.o(190552);
  }
  
  public static final c d(acn paramacn)
  {
    AppMethodBeat.i(190556);
    p.h(paramacn, "proto");
    Object localObject1 = com.tencent.mm.plugin.recordvideo.background.e.BKp;
    localObject1 = paramacn.Gxx.Lna;
    p.g(localObject1, "proto.editData.baseItemData");
    Object localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject1 = com.tencent.mm.plugin.recordvideo.background.e.a((LinkedList)localObject1, (Context)localObject2);
    localObject2 = paramacn.Gxx.LmZ.Msu;
    p.g(localObject2, "proto.editData.drawingRect.values");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Float.valueOf(((Integer)((Iterator)localObject3).next()).intValue()));
    }
    localObject2 = kotlin.a.j.t((Collection)localObject2);
    localObject3 = paramacn.Gxx.Lnc;
    if (localObject3 != null)
    {
      localObject3 = ((dlh)localObject3).Msu;
      p.g(localObject3, "rectProto.values");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Float.valueOf(((Integer)((Iterator)localObject4).next()).intValue()));
      }
      kotlin.a.j.t((Collection)localObject3);
    }
    paramacn = (c)new com.tencent.mm.plugin.recordvideo.ui.editor.b.f((float[])localObject2, (List)localObject1, paramacn.Gxw.xlg, paramacn.Gxw.xlh);
    AppMethodBeat.o(190556);
    return paramacn;
  }
  
  public static final ac d(acn paramacn, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(190554);
    p.h(paramacn, "proto");
    p.h(paramEffectManager, "effectMgr");
    Object localObject1 = new LinkedList();
    Object localObject2 = paramacn.Lnd;
    p.g(localObject2, "proto.tracks");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ejf localejf = (ejf)((Iterator)localObject3).next();
      Object localObject4 = localejf.path;
      p.g(localObject4, "it.path");
      localObject4 = new ad((String)localObject4, localejf.type);
      p.g(localejf, "it");
      a(localejf, (ad)localObject4);
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject1 = new ac((List)localObject1);
    ((ac)localObject1).getComposition().lW(paramacn.Gxw.xlg, paramacn.Gxw.xlh);
    ((ac)localObject1).at(paramacn.Lne, paramacn.Lnf);
    if (!Util.isNullOrNil(paramacn.iiv))
    {
      localObject2 = paramacn.iiv;
      p.g(localObject2, "proto.musicPath");
      ((ac)localObject1).cB((String)localObject2, true);
    }
    ((ac)localObject1).wB(paramacn.Gzo);
    localObject2 = new Rect();
    localObject3 = paramacn.Gxw.Lnm;
    p.g(localObject3, "proto.outputConfig.originRect");
    a((dlh)localObject3, (Rect)localObject2);
    ((ac)localObject1).q((Rect)localObject2);
    a((ac)localObject1, paramEffectManager);
    a(paramacn, paramEffectManager);
    b(paramacn, paramEffectManager);
    c(paramacn, paramEffectManager);
    a(paramacn, paramEffectManager, (ac)localObject1);
    ((ac)localObject1).Gzp = paramacn.Gzp;
    if (((ac)localObject1).Gzp) {
      a((ac)localObject1, paramacn, paramEffectManager);
    }
    AppMethodBeat.o(190554);
    return localObject1;
  }
  
  public static final void p(Collection<? extends ecy> paramCollection)
  {
    AppMethodBeat.i(190544);
    p.h(paramCollection, "stickers");
    GxM.clear();
    GxM.addAll(paramCollection);
    AppMethodBeat.o(190544);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.i
 * JD-Core Version:    0.7.0.1
 */