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
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.aje;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.protocal.protobuf.cuw;
import com.tencent.mm.protocal.protobuf.cvn;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.emz;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.protocal.protobuf.eus;
import com.tencent.mm.protocal.protobuf.fbj;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.g;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.mm.xeffect.effect.EffectManager.a;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.af;
import com.tencent.mm.xeffect.effect.h;
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
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"TAG", "", "externalStickerEffectList", "", "Lcom/tencent/mm/protocal/protobuf/StickerEffectProto;", "clearStickerEffectList", "", "compositionToProto", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "cropInfoToProto", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "matrixToProto", "matrix", "Landroid/graphics/Matrix;", "Lcom/tencent/mm/protocal/protobuf/MatrixProto;", "protoToComposition", "effectMgr", "Lcom/tencent/mm/xeffect/effect/EffectManager;", "protoToCropInfo", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "protoToFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "protoToImageEnhancementEffect", "protoToMagic", "protoToMatrix", "protoToPagSticker", "protoToRect", "Lcom/tencent/mm/protocal/protobuf/RectProto;", "rect", "Landroid/graphics/Rect;", "protoToSticker", "protoToTrack", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "protoToTransitionInfo", "Lcom/tencent/mm/protocal/protobuf/TransitionInfoProto;", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "protoToVLogEffectMgr", "protoToVideoTemplate", "rectToProto", "saveStickerEffectList", "stickers", "", "scriptToTrackList", "", "script", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "sourceTrackList", "selectCompositionOutputFpsByTrackList", "", "trackList", "targetFps", "trackToProto", "transitionInfoToProto", "videoTemplateToProto", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "videoTemplate", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "fileName", "getTrackByTimeMs", "timeMs", "", "toInputTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "Lcom/tencent/tav/coremedia/TextureInfo;", "plugin-vlog_release"})
public final class i
{
  private static final List<emz> Nlo;
  private static final String TAG = "MicroMsg.Converter";
  
  static
  {
    AppMethodBeat.i(224868);
    TAG = "MicroMsg.Converter";
    Nlo = (List)new ArrayList();
    AppMethodBeat.o(224868);
  }
  
  public static final ad a(ac paramac, long paramLong)
  {
    AppMethodBeat.i(224865);
    kotlin.g.b.p.k(paramac, "$this$getTrackByTimeMs");
    Iterator localIterator = ((Iterable)paramac.MQY).iterator();
    int i;
    if (localIterator.hasNext())
    {
      paramac = localIterator.next();
      ad localad = (ad)paramac;
      if ((localad.Nng.startTimeMs <= paramLong) && (localad.Nng.endTimeMs > paramLong))
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
      AppMethodBeat.o(224865);
      return paramac;
      i = 0;
      break label80;
      label99:
      break;
      paramac = null;
    }
  }
  
  public static final acu a(ac paramac, acv paramacv)
  {
    AppMethodBeat.i(224813);
    kotlin.g.b.p.k(paramac, "composition");
    kotlin.g.b.p.k(paramacv, "outputConfig");
    acu localacu = new acu();
    localacu.Sov = (paramac.NmT.igH().getStartUs() / 1000L);
    localacu.Sow = (paramac.NmT.igH().getEndUs() / 1000L);
    Object localObject1 = localacu.Sou;
    Object localObject3 = (Iterable)paramac.MQY;
    Object localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ad localad = (ad)((Iterator)localObject3).next();
      eth localeth = new eth();
      a(localad, localeth);
      localeth.NmG = localad.NmG;
      ((Collection)localObject2).add(localeth);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localacu.NmU = paramac.NmU;
    localacu.Sox = true;
    localacu.NkX = paramacv;
    localacu.kXi = paramac.kXi;
    localacu.NmV = paramac.NmV;
    localacu.SoA = new LinkedList();
    paramac = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    paramac = ((Map)com.tencent.mm.plugin.vlog.model.local.a.gtP()).entrySet().iterator();
    while (paramac.hasNext())
    {
      localObject1 = (Map.Entry)paramac.next();
      paramacv = new acw();
      paramacv.path = ((String)((Map.Entry)localObject1).getKey());
      localObject2 = ((Pair)((Map.Entry)localObject1).getValue()).first;
      kotlin.g.b.p.j(localObject2, "it.value.first");
      paramacv.label = ((Number)localObject2).intValue();
      localObject1 = ((Pair)((Map.Entry)localObject1).getValue()).second;
      kotlin.g.b.p.j(localObject1, "it.value.second");
      paramacv.SoL = ((Number)localObject1).longValue();
      localacu.SoA.add(paramacv);
    }
    AppMethodBeat.o(224813);
    return localacu;
  }
  
  public static final void a(Rect paramRect, duz paramduz)
  {
    AppMethodBeat.i(224744);
    kotlin.g.b.p.k(paramRect, "rect");
    kotlin.g.b.p.k(paramduz, "proto");
    paramduz.TDA.clear();
    paramduz.TDA.add(Integer.valueOf(paramRect.left));
    paramduz.TDA.add(Integer.valueOf(paramRect.top));
    paramduz.TDA.add(Integer.valueOf(paramRect.right));
    paramduz.TDA.add(Integer.valueOf(paramRect.bottom));
    AppMethodBeat.o(224744);
  }
  
  private static final void a(ac paramac, acu paramacu, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(224835);
    HashMap localHashMap = new HashMap();
    paramacu = paramacu.SoA;
    kotlin.g.b.p.j(paramacu, "proto.trackLabelInfoList");
    paramacu = ((Iterable)paramacu).iterator();
    while (paramacu.hasNext())
    {
      localObject = (acw)paramacu.next();
      Map localMap = (Map)localHashMap;
      String str = ((acw)localObject).path;
      kotlin.g.b.p.j(str, "it.path");
      localMap.put(str, Integer.valueOf(((acw)localObject).label));
    }
    Object localObject = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.YZM);
    paramacu = (acu)localObject;
    if (!(localObject instanceof com.tencent.mm.xeffect.effect.n)) {
      paramacu = null;
    }
    paramacu = (com.tencent.mm.xeffect.effect.n)paramacu;
    if (paramacu != null) {
      paramacu.aZ(paramac.NmT.getPlayStart(), paramac.NmT.gtw());
    }
    paramEffectManager.b((af)paramacu);
    if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", 0) == 1) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (paramacu != null)) {
        paramacu.Im(true);
      }
      paramEffectManager = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf;
      com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.a(paramacu);
      paramac.a((com.tencent.mm.videocomposition.b.e)new ai(paramac, localHashMap, paramacu));
      AppMethodBeat.o(224835);
      return;
    }
  }
  
  private static void a(ac paramac, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(224769);
    kotlin.g.b.p.k(paramac, "composition");
    kotlin.g.b.p.k(paramEffectManager, "effectMgr");
    Iterator localIterator = ((Iterable)paramac.MQY).iterator();
    while (localIterator.hasNext())
    {
      ad localad = (ad)localIterator.next();
      if (localad.gtD())
      {
        Object localObject2;
        if (kotlin.n.n.M(localad.gtE(), "assets://", false))
        {
          localObject1 = com.tencent.mm.xeffect.effect.j.YZB;
          localObject2 = MMApplicationContext.getContext();
          kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
          localObject2 = ((Context)localObject2).getAssets();
          kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext().assets");
        }
        for (Object localObject1 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, localad.gtE());; localObject1 = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.YZB, localad.gtE()))
        {
          localad.Nng.MQX.NnT = ((af)localObject1);
          paramEffectManager.b((af)localObject1);
          break;
        }
      }
    }
    paramac.a(paramEffectManager);
    AppMethodBeat.o(224769);
  }
  
  private static void a(ad paramad, eth parameth)
  {
    AppMethodBeat.i(224762);
    kotlin.g.b.p.k(paramad, "track");
    kotlin.g.b.p.k(parameth, "proto");
    parameth.path = paramad.path;
    parameth.type = paramad.type;
    parameth.startTimeMs = paramad.Nng.startTimeMs;
    parameth.endTimeMs = paramad.Nng.endTimeMs;
    parameth.MQV = paramad.Nng.MQV;
    parameth.MQW = paramad.Nng.MQW;
    parameth.NwS = paramad.Nng.NwS;
    parameth.Nna = paramad.Nna;
    parameth.Nnb = paramad.Nnb;
    parameth.Nnc = paramad.Nnc;
    parameth.volume = paramad.Nng.volume;
    parameth.Uvu = new aex();
    Object localObject1 = parameth.Uvu;
    kotlin.g.b.p.j(localObject1, "proto.cropInfo");
    kotlin.g.b.p.k(paramad, "track");
    kotlin.g.b.p.k(localObject1, "proto");
    ((aex)localObject1).Srn = new cvn();
    ((aex)localObject1).Srq = new duz();
    ((aex)localObject1).Sro = new duz();
    ((aex)localObject1).Srp = new duz();
    ((aex)localObject1).Srr = new duz();
    Object localObject2 = paramad.Nnd.aHZ;
    Object localObject3 = ((aex)localObject1).Srn;
    kotlin.g.b.p.j(localObject3, "proto.matrix");
    kotlin.g.b.p.k(localObject2, "matrix");
    kotlin.g.b.p.k(localObject3, "proto");
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    ((cvn)localObject3).TDA.clear();
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      ((cvn)localObject3).TDA.add(Float.valueOf(f));
      i += 1;
    }
    localObject2 = paramad.Nnd.vcr;
    localObject3 = ((aex)localObject1).Srq;
    kotlin.g.b.p.j(localObject3, "proto.contentRect");
    a((Rect)localObject2, (duz)localObject3);
    localObject2 = paramad.Nnd.kXj;
    localObject3 = ((aex)localObject1).Sro;
    kotlin.g.b.p.j(localObject3, "proto.cropRect");
    a((Rect)localObject2, (duz)localObject3);
    localObject2 = paramad.Nnd.viewRect;
    localObject3 = ((aex)localObject1).Srp;
    kotlin.g.b.p.j(localObject3, "proto.viewRect");
    a((Rect)localObject2, (duz)localObject3);
    localObject2 = paramad.Nng.YHS;
    localObject1 = ((aex)localObject1).Srr;
    kotlin.g.b.p.j(localObject1, "proto.trackCropRect");
    a((Rect)localObject2, (duz)localObject1);
    parameth.Uvv = new eus();
    paramad = paramad.Nng.MQX;
    parameth = parameth.Uvv;
    kotlin.g.b.p.j(parameth, "proto.transitionInfo");
    a(paramad, parameth);
    AppMethodBeat.o(224762);
  }
  
  private static void a(acu paramacu, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(224784);
    kotlin.g.b.p.k(paramacu, "proto");
    kotlin.g.b.p.k(paramEffectManager, "effectMgr");
    paramacu = paramacu.SoC;
    kotlin.g.b.p.j(paramacu, "proto.stickerEffectList");
    Iterator localIterator = ((Iterable)kotlin.a.j.b((Collection)paramacu, (Iterable)Nlo)).iterator();
    if (localIterator.hasNext())
    {
      emz localemz = (emz)localIterator.next();
      paramacu = (CharSequence)localemz.path;
      int i;
      label101:
      Object localObject1;
      if ((paramacu == null) || (paramacu.length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label286;
        }
        paramacu = com.tencent.mm.xeffect.effect.j.YZQ;
        localObject1 = localemz.path;
        kotlin.g.b.p.j(localObject1, "effectProto.path");
        paramacu = paramEffectManager.a(paramacu, (String)localObject1);
      }
      for (;;)
      {
        localObject1 = paramacu;
        if (!(paramacu instanceof com.tencent.mm.xeffect.effect.ac)) {
          localObject1 = null;
        }
        paramacu = (com.tencent.mm.xeffect.effect.ac)localObject1;
        if (paramacu == null) {
          break;
        }
        localObject1 = localemz.UpL;
        Object localObject2 = localemz.UpM;
        paramacu.aZ(((ajf)localObject1).startTimeMs, ((ajf)localObject1).endTimeMs);
        localObject1 = new com.tencent.mm.xeffect.effect.f(((aje)localObject2).centerX, ((aje)localObject2).centerY, ((aje)localObject2).scale, ((aje)localObject2).oYk);
        kotlin.g.b.p.k(localObject1, "layoutInfo");
        paramacu.YZw.a((com.tencent.mm.xeffect.effect.f)localObject1);
        if ((localemz.width != 0) && (localemz.height != 0))
        {
          i = localemz.width;
          int j = localemz.height;
          VLogEffectJNI.INSTANCE.setStickerSize$renderlib_release(paramacu.ptr, i, j);
        }
        paramEffectManager.b((af)paramacu);
        break;
        i = 0;
        break label101;
        label286:
        if (localemz.UpK != null)
        {
          localObject1 = com.tencent.mm.xeffect.effect.j.YZQ;
          paramacu = localemz.UpK;
          kotlin.g.b.p.j(paramacu, "effectProto.bytes");
          localObject2 = paramacu.UH;
          kotlin.g.b.p.j(localObject2, "effectProto.bytes.bytes");
          kotlin.g.b.p.k(localObject1, "type");
          kotlin.g.b.p.k(localObject2, "bytes");
          long l = paramEffectManager.nCreateEffectBinary(paramEffectManager.NmO, ((com.tencent.mm.xeffect.effect.j)localObject1).ordinal(), (byte[])localObject2, localObject2.length);
          paramacu = EffectManager.YZy;
          paramacu = EffectManager.a.a(l, (com.tencent.mm.xeffect.effect.j)localObject1);
          XEffectLog.i(EffectManager.TAG, "create effect binary ptr:" + l + ", type:" + localObject1 + ", " + localObject2.length, new Object[0]);
        }
        else
        {
          paramacu = null;
        }
      }
    }
    AppMethodBeat.o(224784);
  }
  
  private static void a(acu paramacu, EffectManager paramEffectManager, ac paramac)
  {
    AppMethodBeat.i(224861);
    kotlin.g.b.p.k(paramacu, "proto");
    kotlin.g.b.p.k(paramEffectManager, "effectMgr");
    kotlin.g.b.p.k(paramac, "composition");
    Object localObject1;
    Object localObject3;
    if (paramacu.Soz != null)
    {
      localObject1 = paramacu.Soz.PzO;
      kotlin.g.b.p.j(localObject1, "proto.videoTemplate.templatePath");
      if (kotlin.n.n.M((String)localObject1, "assets://", false))
      {
        localObject1 = com.tencent.mm.xeffect.effect.j.YZE;
        localObject2 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getAssets();
        kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext().assets");
        localObject3 = paramacu.Soz.PzO;
        kotlin.g.b.p.j(localObject3, "proto.videoTemplate.templatePath");
        localObject1 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, (String)localObject3);
        paramEffectManager.b((af)localObject1);
        if ((localObject1 instanceof w)) {
          break label437;
        }
      }
    }
    label417:
    label437:
    for (Object localObject2 = null;; localObject2 = localObject1)
    {
      localObject2 = (w)localObject2;
      if (localObject2 != null)
      {
        localObject3 = ((t)localObject2).GbH;
        localObject2 = localObject3;
        if (localObject3 != null) {}
      }
      else
      {
        localObject2 = new Size(0, 0);
      }
      if (!(localObject1 instanceof w)) {}
      for (localObject3 = null;; localObject3 = localObject1)
      {
        localObject3 = (w)localObject3;
        int i;
        if (localObject3 != null)
        {
          i = ((t)localObject3).ZaD;
          label210:
          localObject3 = paramacu.Soz.PzO;
          kotlin.g.b.p.j(localObject3, "proto.videoTemplate.templatePath");
          String str = paramacu.Soz.kXi;
          kotlin.g.b.p.j(str, "proto.videoTemplate.musicPath");
          localObject2 = new a.c((String)localObject3, str, (Size)localObject2, paramacu.Soz.duration, i, paramacu.Soz.Nop);
          paramEffectManager.ike();
          if (localObject1 != null) {
            ((af)localObject1).aZ(0L, ((a.c)localObject2).duration);
          }
          if (localObject1 == null) {
            break label417;
          }
        }
        for (long l = ((af)localObject1).id;; l = 0L)
        {
          ((a.c)localObject2).Noq = l;
          paramacu = paramacu.Soz.kXi;
          kotlin.g.b.p.j(paramacu, "proto.videoTemplate.musicPath");
          ac.a(paramac, paramacu);
          paramacu = ((Iterable)paramac.MQY).iterator();
          while (paramacu.hasNext()) {
            ((ad)paramacu.next()).Nng.YHT = false;
          }
          localObject1 = com.tencent.mm.xeffect.effect.j.YZE;
          localObject2 = paramacu.Soz.PzO;
          kotlin.g.b.p.j(localObject2, "proto.videoTemplate.templatePath");
          localObject1 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (String)localObject2);
          break;
          i = 0;
          break label210;
        }
        AppMethodBeat.o(224861);
        return;
      }
    }
  }
  
  public static final void a(duz paramduz, Rect paramRect)
  {
    AppMethodBeat.i(224746);
    kotlin.g.b.p.k(paramduz, "proto");
    kotlin.g.b.p.k(paramRect, "rect");
    if (paramduz.TDA.size() == 4)
    {
      Object localObject = paramduz.TDA.get(0);
      kotlin.g.b.p.j(localObject, "proto.values[0]");
      int i = ((Number)localObject).intValue();
      localObject = paramduz.TDA.get(1);
      kotlin.g.b.p.j(localObject, "proto.values[1]");
      int j = ((Number)localObject).intValue();
      localObject = paramduz.TDA.get(2);
      kotlin.g.b.p.j(localObject, "proto.values[2]");
      int k = ((Number)localObject).intValue();
      paramduz = paramduz.TDA.get(3);
      kotlin.g.b.p.j(paramduz, "proto.values[3]");
      paramRect.set(i, j, k, ((Number)paramduz).intValue());
    }
    AppMethodBeat.o(224746);
  }
  
  public static final void a(g paramg, eus parameus)
  {
    AppMethodBeat.i(224748);
    kotlin.g.b.p.k(paramg, "transition");
    kotlin.g.b.p.k(parameus, "proto");
    parameus.path = paramg.path;
    parameus.duration = paramg.duration;
    AppMethodBeat.o(224748);
  }
  
  public static final fbj b(a.c paramc)
  {
    AppMethodBeat.i(224857);
    kotlin.g.b.p.k(paramc, "videoTemplate");
    fbj localfbj = new fbj();
    localfbj.PzO = paramc.path;
    String str = com.tencent.mm.loader.j.b.aSD() + System.currentTimeMillis() + ".mp3";
    u.on(paramc.kXi, str);
    localfbj.kXi = str;
    localfbj.duration = paramc.duration;
    localfbj.Nop = paramc.Nop;
    AppMethodBeat.o(224857);
    return localfbj;
  }
  
  private static void b(acu paramacu, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(224795);
    kotlin.g.b.p.k(paramacu, "proto");
    kotlin.g.b.p.k(paramEffectManager, "effectMgr");
    Object localObject1 = paramacu.NkY.Sor;
    kotlin.g.b.p.j(localObject1, "proto.editData.baseItemData");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label123:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((jc)localObject3).dataType == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.IbN.value) {}
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
    com.tencent.mm.plugin.recordvideo.ui.editor.item.p localp;
    if (localIterator.hasNext())
    {
      localObject1 = (jc)localIterator.next();
      kotlin.g.b.p.j(localObject1, "it");
      localp = new com.tencent.mm.plugin.recordvideo.ui.editor.item.p((jc)localObject1);
      if (kotlin.n.n.M(localp.GaM, "assets://", false))
      {
        localObject1 = com.tencent.mm.xeffect.effect.j.YZD;
        localObject2 = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
        localObject2 = ((Context)localObject2).getAssets();
        kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext().assets");
        localObject1 = paramEffectManager.a((com.tencent.mm.xeffect.effect.j)localObject1, (AssetManager)localObject2, localp.GaM);
        label244:
        paramEffectManager.b((af)localObject1);
        if ((localObject1 instanceof x)) {
          break label528;
        }
      }
    }
    label528:
    for (localObject2 = null;; localObject2 = localObject1)
    {
      localObject2 = (x)localObject2;
      if (localObject2 != null)
      {
        ((x)localObject2).aZ(localp.Ibr.getStart(), localp.Ibr.getEnd());
        ((x)localObject2).a(new com.tencent.mm.xeffect.effect.f((int)localp.aGt, (int)localp.aGu, localp.scale, localp.oYk));
        ((x)localObject2).a(new h(localp.text, null, 30));
      }
      if (!(localObject1 instanceof t)) {}
      for (localObject2 = null;; localObject2 = localObject1)
      {
        localObject2 = (t)localObject2;
        if (localObject2 != null)
        {
          localObject3 = ((t)localObject2).GbH;
          localObject2 = localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          localObject2 = new Size(0, 0);
        }
        localp.width = ((Size)localObject2).getWidth();
        localp.height = ((Size)localObject2).getHeight();
        localObject2 = new Rect();
        localObject3 = paramacu.NkY.Soq;
        kotlin.g.b.p.j(localObject3, "proto.editData.drawingRect");
        a((duz)localObject3, (Rect)localObject2);
        localp.IcR.set((Rect)localObject2);
        localp.g(localp.aHZ);
        if (localObject1 != null) {}
        for (long l = ((af)localObject1).id;; l = 0L)
        {
          localp.IcQ = l;
          break;
          localObject1 = paramEffectManager.a(com.tencent.mm.xeffect.effect.j.YZD, localp.GaM);
          break label244;
        }
        AppMethodBeat.o(224795);
        return;
      }
    }
  }
  
  public static final String bfr(String paramString)
  {
    AppMethodBeat.i(224742);
    kotlin.g.b.p.k(paramString, "$this$fileName");
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
      kotlin.g.b.p.j(paramString, "(this as java.lang.String).substring(startIndex)");
      AppMethodBeat.o(224742);
      return paramString;
      j = 0;
      break label45;
      label77:
      i -= 1;
      break;
      i = -1;
    }
  }
  
  public static final c c(acu paramacu)
  {
    AppMethodBeat.i(224848);
    kotlin.g.b.p.k(paramacu, "proto");
    Object localObject1 = com.tencent.mm.plugin.recordvideo.background.e.HGz;
    localObject1 = paramacu.NkY.Sor;
    kotlin.g.b.p.j(localObject1, "proto.editData.baseItemData");
    Object localObject2 = MMApplicationContext.getContext();
    kotlin.g.b.p.j(localObject2, "MMApplicationContext.getContext()");
    localObject1 = com.tencent.mm.plugin.recordvideo.background.e.b((LinkedList)localObject1, (Context)localObject2);
    localObject2 = paramacu.NkY.Soq.TDA;
    kotlin.g.b.p.j(localObject2, "proto.editData.drawingRect.values");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Float.valueOf(((Integer)((Iterator)localObject3).next()).intValue()));
    }
    localObject2 = kotlin.a.j.r((Collection)localObject2);
    localObject3 = paramacu.NkY.Sot;
    if (localObject3 != null)
    {
      localObject3 = ((duz)localObject3).TDA;
      kotlin.g.b.p.j(localObject3, "rectProto.values");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Float.valueOf(((Integer)((Iterator)localObject4).next()).intValue()));
      }
      kotlin.a.j.r((Collection)localObject3);
    }
    int i;
    if (paramacu.NkX.SoI == null) {
      i = paramacu.NkX.BXA;
    }
    for (int j = paramacu.NkX.BXB;; j = ((Rect)localObject3).height())
    {
      paramacu = (c)new com.tencent.mm.plugin.recordvideo.ui.editor.b.f((float[])localObject2, (List)localObject1, i, j);
      AppMethodBeat.o(224848);
      return paramacu;
      localObject3 = new Rect();
      paramacu = paramacu.NkX.SoI;
      kotlin.g.b.p.j(paramacu, "proto.outputConfig.previewRect");
      a(paramacu, (Rect)localObject3);
      i = ((Rect)localObject3).width();
    }
  }
  
  private static void c(acu paramacu, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(224801);
    kotlin.g.b.p.k(paramacu, "proto");
    kotlin.g.b.p.k(paramEffectManager, "effectMgr");
    paramacu = paramacu.Soy;
    kotlin.g.b.p.j(paramacu, "proto.magicInfoList");
    Iterator localIterator = ((Iterable)paramacu).iterator();
    if (localIterator.hasNext())
    {
      cuw localcuw = (cuw)localIterator.next();
      paramacu = localcuw.path;
      kotlin.g.b.p.j(paramacu, "it.path");
      Object localObject;
      String str;
      if (kotlin.n.n.M(paramacu, "assets://", false))
      {
        paramacu = com.tencent.mm.xeffect.effect.j.YZF;
        localObject = MMApplicationContext.getContext();
        kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getAssets();
        kotlin.g.b.p.j(localObject, "MMApplicationContext.getContext().assets");
        str = localcuw.path;
        kotlin.g.b.p.j(str, "it.path");
      }
      for (paramacu = paramEffectManager.a(paramacu, (AssetManager)localObject, str);; paramacu = paramEffectManager.a(paramacu, (String)localObject))
      {
        if (paramacu != null) {
          paramacu.aZ(localcuw.start, localcuw.aYz);
        }
        paramEffectManager.b(paramacu);
        break;
        paramacu = com.tencent.mm.xeffect.effect.j.YZF;
        localObject = localcuw.path;
        kotlin.g.b.p.j(localObject, "it.path");
      }
    }
    AppMethodBeat.o(224801);
  }
  
  public static final ac d(acu paramacu, EffectManager paramEffectManager)
  {
    AppMethodBeat.i(224825);
    kotlin.g.b.p.k(paramacu, "proto");
    kotlin.g.b.p.k(paramEffectManager, "effectMgr");
    Object localObject1 = new LinkedList();
    Object localObject2 = paramacu.Sou;
    kotlin.g.b.p.j(localObject2, "proto.tracks");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject5 = (eth)((Iterator)localObject3).next();
      Object localObject4 = ((eth)localObject5).path;
      kotlin.g.b.p.j(localObject4, "it.path");
      localObject4 = new ad((String)localObject4, ((eth)localObject5).type);
      kotlin.g.b.p.j(localObject5, "it");
      kotlin.g.b.p.k(localObject5, "proto");
      kotlin.g.b.p.k(localObject4, "track");
      ((ad)localObject4).Sl(((eth)localObject5).startTimeMs);
      ((ad)localObject4).Sm(((eth)localObject5).endTimeMs);
      ((ad)localObject4).Sn(((eth)localObject5).MQV);
      ((ad)localObject4).So(((eth)localObject5).MQW);
      ((ad)localObject4).Nna = ((eth)localObject5).Nna;
      ((ad)localObject4).Nnb = ((eth)localObject5).Nnb;
      ((ad)localObject4).Nnc = ((eth)localObject5).Nnc;
      ((ad)localObject4).setVolume(((eth)localObject5).volume);
      Object localObject6 = ((eth)localObject5).Uvu.Sro;
      kotlin.g.b.p.j(localObject6, "proto.cropInfo.cropRect");
      a((duz)localObject6, ((ad)localObject4).Nng.kXj);
      localObject6 = ((eth)localObject5).Uvu.Srr;
      kotlin.g.b.p.j(localObject6, "proto.cropInfo.trackCropRect");
      a((duz)localObject6, ((ad)localObject4).Nng.YHS);
      localObject5 = ((eth)localObject5).Uvv;
      if (localObject5 != null)
      {
        localObject6 = ((ad)localObject4).Nng.MQX;
        kotlin.g.b.p.k(localObject5, "proto");
        kotlin.g.b.p.k(localObject6, "transition");
        String str = ((eus)localObject5).path;
        kotlin.g.b.p.j(str, "proto.path");
        ((g)localObject6).setPath(str);
        ((g)localObject6).duration = ((eus)localObject5).duration;
      }
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject1 = new ac((List)localObject1);
    int j;
    if (paramacu.NkX.SoI != null)
    {
      localObject2 = new Rect();
      localObject3 = paramacu.NkX.SoI;
      kotlin.g.b.p.j(localObject3, "proto.outputConfig.previewRect");
      a((duz)localObject3, (Rect)localObject2);
      j = ((Rect)localObject2).width();
    }
    for (int i = ((Rect)localObject2).height();; i = paramacu.NkX.BXB)
    {
      ((ac)localObject1).getComposition().nn(j, i);
      ((ac)localObject1).aG(paramacu.Sov, paramacu.Sow);
      if (!Util.isNullOrNil(paramacu.kXi))
      {
        localObject2 = paramacu.kXi;
        kotlin.g.b.p.j(localObject2, "proto.musicPath");
        ((ac)localObject1).cP((String)localObject2, true);
      }
      ((ac)localObject1).Ap(paramacu.NmU);
      if (paramacu.NkX.SoD == null) {
        break;
      }
      localObject2 = new Rect();
      localObject3 = paramacu.NkX.SoD;
      kotlin.g.b.p.j(localObject3, "proto.outputConfig.originRect");
      a((duz)localObject3, (Rect)localObject2);
      ((ac)localObject1).x((Rect)localObject2);
      a((ac)localObject1, paramEffectManager);
      a(paramacu, paramEffectManager);
      b(paramacu, paramEffectManager);
      c(paramacu, paramEffectManager);
      a(paramacu, paramEffectManager, (ac)localObject1);
      ((ac)localObject1).NmV = paramacu.NmV;
      if (((ac)localObject1).NmV) {
        a((ac)localObject1, paramacu, paramEffectManager);
      }
      AppMethodBeat.o(224825);
      return localObject1;
      j = paramacu.NkX.BXA;
    }
    localObject2 = new Rect();
    if (paramacu.NkX.SoJ != null)
    {
      localObject3 = paramacu.NkX.SoJ.Sro;
      kotlin.g.b.p.j(localObject3, "proto.outputConfig.fullScreenConfig.cropRect");
      a((duz)localObject3, (Rect)localObject2);
    }
    for (;;)
    {
      ((ac)localObject1).x((Rect)localObject2);
      break;
      localObject3 = paramacu.NkX.SoK.Sro;
      kotlin.g.b.p.j(localObject3, "proto.outputConfig.cropConfig.cropRect");
      a((duz)localObject3, (Rect)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.i
 * JD-Core Version:    0.7.0.1
 */