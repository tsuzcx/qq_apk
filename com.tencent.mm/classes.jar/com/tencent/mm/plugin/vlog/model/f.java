package com.tencent.mm.plugin.vlog.model;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a;
import com.tencent.mm.plugin.vlog.model.local.a.c;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.protocal.protobuf.csy;
import com.tencent.mm.protocal.protobuf.dpj;
import com.tencent.mm.protocal.protobuf.dqr;
import com.tencent.mm.protocal.protobuf.dws;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.xeffect.VLogEffectMgr;
import com.tencent.mm.xeffect.VLogEffectMgr.a;
import com.tencent.mm.xeffect.VLogEffectMgr.b;
import com.tencent.tav.coremedia.CMTimeRange;
import d.a.ae;
import d.a.j;
import d.g.b.p;
import d.l;
import d.n.n;
import d.u;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"TAG", "", "compositionToProto", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "cropInfoToProto", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "matrixToProto", "matrix", "Landroid/graphics/Matrix;", "Lcom/tencent/mm/protocal/protobuf/MatrixProto;", "protoToComposition", "protoToCropInfo", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "protoToFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "protoToMagic", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/VLogEffectMgr;", "protoToMatrix", "protoToPagSticker", "protoToRect", "Lcom/tencent/mm/protocal/protobuf/RectProto;", "rect", "Landroid/graphics/Rect;", "protoToTrack", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "protoToTransitionInfo", "Lcom/tencent/mm/protocal/protobuf/TransitionInfoProto;", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "protoToVLogEffectMgr", "protoToVideoTemplate", "rectToProto", "scriptToTrackList", "", "script", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "sourceTrackList", "selectCompositionOutputFpsByTrackList", "", "trackList", "targetFps", "trackToProto", "transitionInfoToProto", "videoTemplateToProto", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "videoTemplate", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "fileName", "toInputTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "Lcom/tencent/tav/coremedia/TextureInfo;", "plugin-vlog_release"})
public final class f
{
  private static final String TAG = "MicroMsg.Converter";
  
  public static final v a(aaq paramaaq)
  {
    AppMethodBeat.i(191169);
    p.h(paramaaq, "proto");
    Object localObject1 = new LinkedList();
    Object localObject2 = paramaaq.GrU;
    p.g(localObject2, "proto.tracks");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      dpj localdpj = (dpj)((Iterator)localObject3).next();
      Object localObject4 = localdpj.path;
      p.g(localObject4, "it.path");
      localObject4 = new w((String)localObject4, localdpj.type);
      p.g(localdpj, "it");
      a(localdpj, (w)localObject4);
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject1 = new v((List)localObject1);
    ((v)localObject1).getComposition().kz(paramaaq.BWx.tTU, paramaaq.BWx.tTV);
    ((v)localObject1).aq(paramaaq.GrV, paramaaq.GrW);
    if (!bu.isNullOrNil(paramaaq.hoZ))
    {
      localObject2 = paramaaq.hoZ;
      p.g(localObject2, "proto.musicPath");
      ((v)localObject1).aEI((String)localObject2);
    }
    ((v)localObject1).sX(paramaaq.BXK);
    localObject2 = new Rect();
    localObject3 = paramaaq.BWx.Gsa;
    p.g(localObject3, "proto.outputConfig.originRect");
    a((csy)localObject3, (Rect)localObject2);
    ((v)localObject1).o((Rect)localObject2);
    localObject2 = a((v)localObject1);
    a(paramaaq, (VLogEffectMgr)localObject2);
    b(paramaaq, (VLogEffectMgr)localObject2);
    a(paramaaq, (VLogEffectMgr)localObject2, (v)localObject1);
    ((v)localObject1).BXL = paramaaq.BXL;
    if (((v)localObject1).BXL)
    {
      long l = ((VLogEffectMgr)localObject2).a(VLogEffectMgr.a.LYy);
      ((VLogEffectMgr)localObject2).a(((v)localObject1).BXI.getPlayStart(), ((v)localObject1).BXI.evH(), l, new long[0]);
    }
    AppMethodBeat.o(191169);
    return localObject1;
  }
  
  public static final aaq a(v paramv, aar paramaar)
  {
    AppMethodBeat.i(191168);
    p.h(paramv, "composition");
    p.h(paramaar, "outputConfig");
    aaq localaaq = new aaq();
    localaaq.GrV = (paramv.BXI.evI().getStartUs() / 1000L);
    localaaq.GrW = (paramv.BXI.evI().getEndUs() / 1000L);
    LinkedList localLinkedList = localaaq.GrU;
    Object localObject = (Iterable)paramv.BXJ;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      dpj localdpj = new dpj();
      a(localw, localdpj);
      localdpj.BXz = localw.BXz;
      localCollection.add(localdpj);
    }
    localLinkedList.addAll((Collection)localCollection);
    localaaq.BXK = paramv.BXK;
    localaaq.GrX = true;
    localaaq.BWx = paramaar;
    localaaq.hoZ = paramv.hoZ;
    localaaq.BXL = paramv.BXL;
    AppMethodBeat.o(191168);
    return localaaq;
  }
  
  public static final dws a(a.c paramc)
  {
    AppMethodBeat.i(191171);
    p.h(paramc, "videoTemplate");
    dws localdws = new dws();
    localdws.DUB = paramc.path;
    String str = com.tencent.mm.loader.j.b.asb() + System.currentTimeMillis() + ".mp3";
    com.tencent.mm.vfs.o.mF(paramc.hoZ, str);
    localdws.hoZ = str;
    localdws.duration = paramc.duration;
    localdws.BYY = paramc.BYY;
    AppMethodBeat.o(191171);
    return localdws;
  }
  
  private static VLogEffectMgr a(v paramv)
  {
    AppMethodBeat.i(191165);
    p.h(paramv, "composition");
    Map localMap = (Map)new LinkedHashMap();
    Object localObject1 = (Set)new LinkedHashSet();
    VLogEffectMgr localVLogEffectMgr = new VLogEffectMgr();
    Object localObject2 = ((Iterable)paramv.BXJ).iterator();
    Object localObject3;
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (w)((Iterator)localObject2).next();
      if ((((w)localObject3).evS()) && (!((Set)localObject1).contains(((w)localObject3).evT())))
      {
        VLogEffectMgr.a locala;
        Context localContext;
        if (n.nF(((w)localObject3).evT(), "assets://"))
        {
          locala = VLogEffectMgr.a.LYm;
          localContext = ak.getContext();
          p.g(localContext, "MMApplicationContext.getContext()");
        }
        for (l = localVLogEffectMgr.a(locala, localContext.getAssets(), ((w)localObject3).evT());; l = localVLogEffectMgr.a(VLogEffectMgr.a.LYm, ((w)localObject3).evT()))
        {
          localMap.put(Long.valueOf(((w)localObject3).evU()), Long.valueOf(l));
          ((Set)localObject1).add(((w)localObject3).evT());
          break;
        }
      }
    }
    localObject1 = ((Iterable)paramv.BXJ).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (w)((Iterator)localObject1).next();
      p.h(localMap, "effectMap");
      if (((w)localObject2).evS())
      {
        localObject3 = (Long)localMap.get(Long.valueOf(((w)localObject2).BXV.LJl.yeZ));
        if (localObject3 != null)
        {
          l = ((Number)localObject3).longValue();
          ((w)localObject2).BXV.LJl.yeZ = l;
        }
      }
    }
    paramv.a(localVLogEffectMgr);
    AppMethodBeat.o(191165);
    return localVLogEffectMgr;
  }
  
  public static final void a(Rect paramRect, csy paramcsy)
  {
    AppMethodBeat.i(191161);
    p.h(paramRect, "rect");
    p.h(paramcsy, "proto");
    paramcsy.Hme.clear();
    paramcsy.Hme.add(Integer.valueOf(paramRect.left));
    paramcsy.Hme.add(Integer.valueOf(paramRect.top));
    paramcsy.Hme.add(Integer.valueOf(paramRect.right));
    paramcsy.Hme.add(Integer.valueOf(paramRect.bottom));
    AppMethodBeat.o(191161);
  }
  
  private static void a(w paramw, dpj paramdpj)
  {
    AppMethodBeat.i(191163);
    p.h(paramw, "track");
    p.h(paramdpj, "proto");
    paramdpj.path = paramw.path;
    paramdpj.type = paramw.type;
    paramdpj.startTimeMs = paramw.BXV.startTimeMs;
    paramdpj.hlm = paramw.BXV.hlm;
    paramdpj.HWH = paramw.BXV.HWH;
    paramdpj.HWI = paramw.BXV.HWI;
    paramdpj.Cec = paramw.BXV.Cec;
    paramdpj.BXQ = paramw.BXQ;
    paramdpj.BXR = paramw.BXR;
    paramdpj.BXS = paramw.BXS;
    paramdpj.volume = paramw.BXV.volume;
    paramdpj.HWJ = new acm();
    Object localObject1 = paramdpj.HWJ;
    p.g(localObject1, "proto.cropInfo");
    p.h(paramw, "track");
    p.h(localObject1, "proto");
    ((acm)localObject1).Guo = new bzb();
    ((acm)localObject1).Gur = new csy();
    ((acm)localObject1).Gup = new csy();
    ((acm)localObject1).Guq = new csy();
    ((acm)localObject1).Gus = new csy();
    Object localObject2 = paramw.BXT.gR;
    Object localObject3 = ((acm)localObject1).Guo;
    p.g(localObject3, "proto.matrix");
    p.h(localObject2, "matrix");
    p.h(localObject3, "proto");
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    ((bzb)localObject3).Hme.clear();
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      ((bzb)localObject3).Hme.add(Float.valueOf(f));
      i += 1;
    }
    localObject2 = paramw.BXT.qfO;
    localObject3 = ((acm)localObject1).Gur;
    p.g(localObject3, "proto.contentRect");
    a((Rect)localObject2, (csy)localObject3);
    localObject2 = paramw.BXT.hpa;
    localObject3 = ((acm)localObject1).Gup;
    p.g(localObject3, "proto.cropRect");
    a((Rect)localObject2, (csy)localObject3);
    localObject2 = paramw.BXT.viewRect;
    localObject3 = ((acm)localObject1).Guq;
    p.g(localObject3, "proto.viewRect");
    a((Rect)localObject2, (csy)localObject3);
    localObject2 = paramw.BXV.LJj;
    localObject1 = ((acm)localObject1).Gus;
    p.g(localObject1, "proto.trackCropRect");
    a((Rect)localObject2, (csy)localObject1);
    paramdpj.HWK = new dqr();
    paramw = paramw.BXV.LJl;
    paramdpj = paramdpj.HWK;
    p.g(paramdpj, "proto.transitionInfo");
    p.h(paramw, "transition");
    p.h(paramdpj, "proto");
    paramdpj.path = paramw.path;
    paramdpj.yeZ = paramw.yeZ;
    paramdpj.duration = paramw.duration;
    AppMethodBeat.o(191163);
  }
  
  private static void a(aaq paramaaq, VLogEffectMgr paramVLogEffectMgr)
  {
    AppMethodBeat.i(191166);
    p.h(paramaaq, "proto");
    p.h(paramVLogEffectMgr, "vLogEffectMgr");
    Object localObject1 = paramaaq.BWy.GrR;
    p.g(localObject1, "proto.editData.baseItemData");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label122:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((ja)localObject3).dataType == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.ydP.value) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label122;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject1 = ((Iterable)localObject1).iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ja)((Iterator)localObject1).next();
      p.g(localObject2, "it");
      localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.o((ja)localObject2);
      Object localObject4;
      if (n.nF(((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).yeY, "assets://"))
      {
        localObject3 = VLogEffectMgr.a.LYo;
        localObject4 = ak.getContext();
        p.g(localObject4, "MMApplicationContext.getContext()");
      }
      for (long l = paramVLogEffectMgr.a((VLogEffectMgr.a)localObject3, ((Context)localObject4).getAssets(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).yeY);; l = paramVLogEffectMgr.a(VLogEffectMgr.a.LYo, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).yeY))
      {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).yeZ = l;
        localObject3 = paramVLogEffectMgr.Fp(((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).yeZ);
        p.g(localObject3, "size");
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).width = ((Size)localObject3).getWidth();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).height = ((Size)localObject3).getHeight();
        localObject3 = new Rect();
        localObject4 = paramaaq.BWy.GrQ;
        p.g(localObject4, "proto.editData.drawingRect");
        a((csy)localObject4, (Rect)localObject3);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).yfb.set((Rect)localObject3);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).g(((a)localObject2).gR);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).yfa = paramVLogEffectMgr.a(((a)localObject2).ydt.getStart(), ((a)localObject2).ydt.getEnd(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).yeZ, new com.tencent.mm.xeffect.b((int)((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).centerX, (int)((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).centerY, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).scale, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).kVl), new com.tencent.mm.xeffect.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).text, null, 30));
        break;
      }
    }
    AppMethodBeat.o(191166);
  }
  
  private static void a(aaq paramaaq, VLogEffectMgr paramVLogEffectMgr, v paramv)
  {
    AppMethodBeat.i(191172);
    p.h(paramaaq, "proto");
    p.h(paramVLogEffectMgr, "vLogEffectMgr");
    p.h(paramv, "composition");
    if (paramaaq.GrZ != null)
    {
      Object localObject1 = paramaaq.GrZ.DUB;
      p.g(localObject1, "proto.videoTemplate.templatePath");
      Object localObject2;
      if (n.nF((String)localObject1, "assets://"))
      {
        localObject1 = VLogEffectMgr.a.LYr;
        localObject2 = ak.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
      }
      for (long l = paramVLogEffectMgr.a((VLogEffectMgr.a)localObject1, ((Context)localObject2).getAssets(), paramaaq.GrZ.DUB);; l = paramVLogEffectMgr.a(VLogEffectMgr.a.LYr, paramaaq.GrZ.DUB))
      {
        localObject2 = paramVLogEffectMgr.Fp(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Size(0, 0);
        }
        int i = paramVLogEffectMgr.Fo(l);
        localObject2 = paramaaq.GrZ.DUB;
        p.g(localObject2, "proto.videoTemplate.templatePath");
        String str = paramaaq.GrZ.hoZ;
        p.g(str, "proto.videoTemplate.musicPath");
        localObject1 = new a.c((String)localObject2, str, (Size)localObject1, paramaaq.GrZ.duration, i, l, paramaaq.GrZ.BYY, null, null, 0L, null, 1920);
        paramVLogEffectMgr.fWP();
        ((a.c)localObject1).BYZ = paramVLogEffectMgr.a(0L, ((a.c)localObject1).duration, ((a.c)localObject1).yeZ, new long[0]);
        paramVLogEffectMgr.b(((a.c)localObject1).BYZ, ae.c(new d.o[] { u.R(Integer.valueOf(VLogEffectMgr.b.LYB.ordinal()), Float.valueOf(1.0F)) }));
        paramaaq = paramaaq.GrZ.hoZ;
        p.g(paramaaq, "proto.videoTemplate.musicPath");
        paramv.aEI(paramaaq);
        paramaaq = ((Iterable)paramv.BXJ).iterator();
        while (paramaaq.hasNext()) {
          ((w)paramaaq.next()).BXV.LJk = false;
        }
      }
    }
    AppMethodBeat.o(191172);
  }
  
  public static final void a(csy paramcsy, Rect paramRect)
  {
    AppMethodBeat.i(191162);
    p.h(paramcsy, "proto");
    p.h(paramRect, "rect");
    if (paramcsy.Hme.size() == 4)
    {
      Object localObject = paramcsy.Hme.get(0);
      p.g(localObject, "proto.values[0]");
      int i = ((Number)localObject).intValue();
      localObject = paramcsy.Hme.get(1);
      p.g(localObject, "proto.values[1]");
      int j = ((Number)localObject).intValue();
      localObject = paramcsy.Hme.get(2);
      p.g(localObject, "proto.values[2]");
      int k = ((Number)localObject).intValue();
      paramcsy = paramcsy.Hme.get(3);
      p.g(paramcsy, "proto.values[3]");
      paramRect.set(i, j, k, ((Number)paramcsy).intValue());
    }
    AppMethodBeat.o(191162);
  }
  
  private static void a(dpj paramdpj, w paramw)
  {
    AppMethodBeat.i(191164);
    p.h(paramdpj, "proto");
    p.h(paramw, "track");
    paramw.BG(paramdpj.startTimeMs);
    paramw.BH(paramdpj.hlm);
    paramw.BI(paramdpj.HWH);
    paramw.BJ(paramdpj.HWI);
    paramw.BXQ = paramdpj.BXQ;
    paramw.BXR = paramdpj.BXR;
    paramw.BXS = paramdpj.BXS;
    paramw.setVolume(paramdpj.volume);
    Object localObject2 = paramdpj.HWJ;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject1 = paramw.BXT;
      p.h(localObject2, "proto");
      p.h(localObject1, "cropInfo");
      Object localObject4 = ((acm)localObject2).Guo;
      if (localObject4 != null)
      {
        localObject3 = ((g)localObject1).gR;
        p.h(localObject4, "proto");
        p.h(localObject3, "matrix");
        if (((bzb)localObject4).Hme.size() == 9)
        {
          localObject4 = ((bzb)localObject4).Hme;
          p.g(localObject4, "proto.values");
          ((Matrix)localObject3).setValues(j.q((Collection)localObject4));
        }
      }
      localObject3 = ((acm)localObject2).Gur;
      if (localObject3 != null) {
        a((csy)localObject3, ((g)localObject1).qfO);
      }
      localObject3 = ((acm)localObject2).Gup;
      if (localObject3 != null) {
        a((csy)localObject3, ((g)localObject1).hpa);
      }
      localObject2 = ((acm)localObject2).Guq;
      if (localObject2 != null) {
        a((csy)localObject2, ((g)localObject1).viewRect);
      }
    }
    paramw.BXV.hpa.set(paramw.BXT.qfO);
    Object localObject1 = paramdpj.HWK;
    if (localObject1 != null)
    {
      localObject2 = paramw.BXV.LJl;
      p.h(localObject1, "proto");
      p.h(localObject2, "transition");
      localObject3 = ((dqr)localObject1).path;
      p.g(localObject3, "proto.path");
      ((com.tencent.mm.videocomposition.g)localObject2).setPath((String)localObject3);
      ((com.tencent.mm.videocomposition.g)localObject2).yeZ = ((dqr)localObject1).yeZ;
      ((com.tencent.mm.videocomposition.g)localObject2).duration = ((dqr)localObject1).duration;
    }
    paramdpj = paramdpj.HWJ;
    if (paramdpj != null)
    {
      paramdpj = paramdpj.Gus;
      p.g(paramdpj, "it.trackCropRect");
      a(paramdpj, paramw.BXV.LJj);
      AppMethodBeat.o(191164);
      return;
    }
    AppMethodBeat.o(191164);
  }
  
  public static final String aEC(String paramString)
  {
    AppMethodBeat.i(191160);
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
      AppMethodBeat.o(191160);
      return paramString;
      j = 0;
      break label45;
      label77:
      i -= 1;
      break;
      i = -1;
    }
  }
  
  public static final com.tencent.mm.plugin.recordvideo.ui.editor.b.c b(aaq paramaaq)
  {
    AppMethodBeat.i(191170);
    p.h(paramaaq, "proto");
    Object localObject1 = e.xKl;
    localObject1 = paramaaq.BWy.GrR;
    p.g(localObject1, "proto.editData.baseItemData");
    Object localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject1 = e.a((LinkedList)localObject1, (Context)localObject2);
    localObject2 = paramaaq.BWy.GrQ.Hme;
    p.g(localObject2, "proto.editData.drawingRect.values");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Float.valueOf(((Integer)((Iterator)localObject3).next()).intValue()));
    }
    localObject2 = j.q((Collection)localObject2);
    localObject3 = paramaaq.BWy.GrT;
    if (localObject3 != null)
    {
      localObject3 = ((csy)localObject3).Hme;
      p.g(localObject3, "rectProto.values");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Float.valueOf(((Integer)((Iterator)localObject4).next()).intValue()));
      }
      j.q((Collection)localObject3);
    }
    paramaaq = (com.tencent.mm.plugin.recordvideo.ui.editor.b.c)new com.tencent.mm.plugin.recordvideo.ui.editor.b.f((float[])localObject2, (List)localObject1, paramaaq.BWx.tTU, paramaaq.BWx.tTV);
    AppMethodBeat.o(191170);
    return paramaaq;
  }
  
  private static void b(aaq paramaaq, VLogEffectMgr paramVLogEffectMgr)
  {
    AppMethodBeat.i(191167);
    p.h(paramaaq, "proto");
    p.h(paramVLogEffectMgr, "vLogEffectMgr");
    paramaaq = paramaaq.GrY;
    p.g(paramaaq, "proto.magicInfoList");
    paramaaq = ((Iterable)paramaaq).iterator();
    if (paramaaq.hasNext())
    {
      byh localbyh = (byh)paramaaq.next();
      Object localObject = localbyh.path;
      p.g(localObject, "it.path");
      Context localContext;
      if (n.nF((String)localObject, "assets://"))
      {
        localObject = VLogEffectMgr.a.LYp;
        localContext = ak.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
      }
      for (long l = paramVLogEffectMgr.a((VLogEffectMgr.a)localObject, localContext.getAssets(), localbyh.path);; l = paramVLogEffectMgr.a(VLogEffectMgr.a.LYp, localbyh.path))
      {
        paramVLogEffectMgr.s(localbyh.start, localbyh.bpc, l);
        break;
      }
    }
    AppMethodBeat.o(191167);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.f
 * JD-Core Version:    0.7.0.1
 */