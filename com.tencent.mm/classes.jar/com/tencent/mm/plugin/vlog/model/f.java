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
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.protocal.protobuf.acd;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.protocal.protobuf.byh;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.dom;
import com.tencent.mm.protocal.protobuf.dpu;
import com.tencent.mm.protocal.protobuf.dvx;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"TAG", "", "compositionToProto", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "cropInfoToProto", "", "track", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "proto", "Lcom/tencent/mm/protocal/protobuf/CropInfoProto;", "matrixToProto", "matrix", "Landroid/graphics/Matrix;", "Lcom/tencent/mm/protocal/protobuf/MatrixProto;", "protoToComposition", "protoToCropInfo", "cropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "protoToFrameRetriever", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/FrameSeeker;", "protoToMagic", "vLogEffectMgr", "Lcom/tencent/mm/xeffect/VLogEffectMgr;", "protoToMatrix", "protoToPagSticker", "protoToRect", "Lcom/tencent/mm/protocal/protobuf/RectProto;", "rect", "Landroid/graphics/Rect;", "protoToTrack", "Lcom/tencent/mm/protocal/protobuf/TrackInfoProto;", "protoToTransitionInfo", "Lcom/tencent/mm/protocal/protobuf/TransitionInfoProto;", "transition", "Lcom/tencent/mm/videocomposition/TrackTransition;", "protoToVLogEffectMgr", "protoToVideoTemplate", "rectToProto", "scriptToTrackList", "", "script", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "sourceTrackList", "selectCompositionOutputFpsByTrackList", "", "trackList", "targetFps", "trackToProto", "transitionInfoToProto", "videoTemplateToProto", "Lcom/tencent/mm/protocal/protobuf/VideoTemplateInfoProto;", "videoTemplate", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$VideoTemplateInfo;", "fileName", "toInputTexture", "Lcom/tencent/mm/xeffect/InputTexture;", "Lcom/tencent/tav/coremedia/TextureInfo;", "plugin-vlog_release"})
public final class f
{
  private static final String TAG = "MicroMsg.Converter";
  
  public static final v a(aan paramaan)
  {
    AppMethodBeat.i(195712);
    p.h(paramaan, "proto");
    Object localObject1 = new LinkedList();
    Object localObject2 = paramaan.FZu;
    p.g(localObject2, "proto.tracks");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      dom localdom = (dom)((Iterator)localObject3).next();
      Object localObject4 = localdom.path;
      p.g(localObject4, "it.path");
      localObject4 = new w((String)localObject4, localdom.type);
      p.g(localdom, "it");
      a(localdom, (w)localObject4);
      ((Collection)localObject2).add(localObject4);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    localObject1 = new v((List)localObject1);
    ((v)localObject1).getComposition().ks(paramaan.BEZ.tJd, paramaan.BEZ.tJe);
    ((v)localObject1).ar(paramaan.FZv, paramaan.FZw);
    if (!bt.isNullOrNil(paramaan.hml))
    {
      localObject2 = paramaan.hml;
      p.g(localObject2, "proto.musicPath");
      ((v)localObject1).aDp((String)localObject2);
    }
    ((v)localObject1).sQ(paramaan.BGm);
    localObject2 = new Rect();
    localObject3 = paramaan.BEZ.FZA;
    p.g(localObject3, "proto.outputConfig.originRect");
    a((cse)localObject3, (Rect)localObject2);
    ((v)localObject1).o((Rect)localObject2);
    localObject2 = a((v)localObject1);
    a(paramaan, (VLogEffectMgr)localObject2);
    b(paramaan, (VLogEffectMgr)localObject2);
    a(paramaan, (VLogEffectMgr)localObject2, (v)localObject1);
    ((v)localObject1).BGn = paramaan.BGn;
    if (((v)localObject1).BGn)
    {
      long l = ((VLogEffectMgr)localObject2).a(VLogEffectMgr.a.LBy);
      ((VLogEffectMgr)localObject2).a(((v)localObject1).BGk.getPlayStart(), ((v)localObject1).BGk.esa(), l, new long[0]);
    }
    AppMethodBeat.o(195712);
    return localObject1;
  }
  
  public static final aan a(v paramv, aao paramaao)
  {
    AppMethodBeat.i(195711);
    p.h(paramv, "composition");
    p.h(paramaao, "outputConfig");
    aan localaan = new aan();
    localaan.FZv = (paramv.BGk.esb().getStartUs() / 1000L);
    localaan.FZw = (paramv.BGk.esb().getEndUs() / 1000L);
    LinkedList localLinkedList = localaan.FZu;
    Object localObject = (Iterable)paramv.BGl;
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      w localw = (w)((Iterator)localObject).next();
      dom localdom = new dom();
      a(localw, localdom);
      localdom.BGb = localw.BGb;
      localCollection.add(localdom);
    }
    localLinkedList.addAll((Collection)localCollection);
    localaan.BGm = paramv.BGm;
    localaan.FZx = true;
    localaan.BEZ = paramaao;
    localaan.hml = paramv.hml;
    localaan.BGn = paramv.BGn;
    AppMethodBeat.o(195711);
    return localaan;
  }
  
  public static final dvx a(a.c paramc)
  {
    AppMethodBeat.i(195714);
    p.h(paramc, "videoTemplate");
    dvx localdvx = new dvx();
    localdvx.DCE = paramc.path;
    String str = com.tencent.mm.loader.j.b.arM() + System.currentTimeMillis() + ".mp3";
    i.mz(paramc.hml, str);
    localdvx.hml = str;
    localdvx.duration = paramc.duration;
    localdvx.BHz = paramc.BHz;
    AppMethodBeat.o(195714);
    return localdvx;
  }
  
  private static VLogEffectMgr a(v paramv)
  {
    AppMethodBeat.i(195708);
    p.h(paramv, "composition");
    Map localMap = (Map)new LinkedHashMap();
    Object localObject1 = (Set)new LinkedHashSet();
    VLogEffectMgr localVLogEffectMgr = new VLogEffectMgr();
    Object localObject2 = ((Iterable)paramv.BGl).iterator();
    Object localObject3;
    long l;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (w)((Iterator)localObject2).next();
      if ((((w)localObject3).esl()) && (!((Set)localObject1).contains(((w)localObject3).esm())))
      {
        VLogEffectMgr.a locala;
        Context localContext;
        if (n.nz(((w)localObject3).esm(), "assets://"))
        {
          locala = VLogEffectMgr.a.LBm;
          localContext = aj.getContext();
          p.g(localContext, "MMApplicationContext.getContext()");
        }
        for (l = localVLogEffectMgr.a(locala, localContext.getAssets(), ((w)localObject3).esm());; l = localVLogEffectMgr.a(VLogEffectMgr.a.LBm, ((w)localObject3).esm()))
        {
          localMap.put(Long.valueOf(((w)localObject3).esn()), Long.valueOf(l));
          ((Set)localObject1).add(((w)localObject3).esm());
          break;
        }
      }
    }
    localObject1 = ((Iterable)paramv.BGl).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (w)((Iterator)localObject1).next();
      p.h(localMap, "effectMap");
      if (((w)localObject2).esl())
      {
        localObject3 = (Long)localMap.get(Long.valueOf(((w)localObject2).BGw.LmB.xPg));
        if (localObject3 != null)
        {
          l = ((Number)localObject3).longValue();
          ((w)localObject2).BGw.LmB.xPg = l;
        }
      }
    }
    paramv.a(localVLogEffectMgr);
    AppMethodBeat.o(195708);
    return localVLogEffectMgr;
  }
  
  public static final void a(Rect paramRect, cse paramcse)
  {
    AppMethodBeat.i(195704);
    p.h(paramRect, "rect");
    p.h(paramcse, "proto");
    paramcse.GSD.clear();
    paramcse.GSD.add(Integer.valueOf(paramRect.left));
    paramcse.GSD.add(Integer.valueOf(paramRect.top));
    paramcse.GSD.add(Integer.valueOf(paramRect.right));
    paramcse.GSD.add(Integer.valueOf(paramRect.bottom));
    AppMethodBeat.o(195704);
  }
  
  private static void a(w paramw, dom paramdom)
  {
    AppMethodBeat.i(195706);
    p.h(paramw, "track");
    p.h(paramdom, "proto");
    paramdom.path = paramw.path;
    paramdom.type = paramw.type;
    paramdom.startTimeMs = paramw.BGw.startTimeMs;
    paramdom.hiy = paramw.BGw.hiy;
    paramdom.HCU = paramw.BGw.HCU;
    paramdom.HCV = paramw.BGw.HCV;
    paramdom.BMD = paramw.BGw.BMD;
    paramdom.BGr = paramw.BGr;
    paramdom.BGs = paramw.BGs;
    paramdom.BGt = paramw.BGt;
    paramdom.volume = paramw.BGw.volume;
    paramdom.HCW = new acd();
    Object localObject1 = paramdom.HCW;
    p.g(localObject1, "proto.cropInfo");
    p.h(paramw, "track");
    p.h(localObject1, "proto");
    ((acd)localObject1).GbH = new byh();
    ((acd)localObject1).GbK = new cse();
    ((acd)localObject1).GbI = new cse();
    ((acd)localObject1).GbJ = new cse();
    ((acd)localObject1).GbL = new cse();
    Object localObject2 = paramw.BGu.gR;
    Object localObject3 = ((acd)localObject1).GbH;
    p.g(localObject3, "proto.matrix");
    p.h(localObject2, "matrix");
    p.h(localObject3, "proto");
    float[] arrayOfFloat = new float[9];
    ((Matrix)localObject2).getValues(arrayOfFloat);
    ((byh)localObject3).GSD.clear();
    int i = 0;
    while (i < 9)
    {
      float f = arrayOfFloat[i];
      ((byh)localObject3).GSD.add(Float.valueOf(f));
      i += 1;
    }
    localObject2 = paramw.BGu.pZj;
    localObject3 = ((acd)localObject1).GbK;
    p.g(localObject3, "proto.contentRect");
    a((Rect)localObject2, (cse)localObject3);
    localObject2 = paramw.BGu.hmm;
    localObject3 = ((acd)localObject1).GbI;
    p.g(localObject3, "proto.cropRect");
    a((Rect)localObject2, (cse)localObject3);
    localObject2 = paramw.BGu.viewRect;
    localObject3 = ((acd)localObject1).GbJ;
    p.g(localObject3, "proto.viewRect");
    a((Rect)localObject2, (cse)localObject3);
    localObject2 = paramw.BGw.Lmz;
    localObject1 = ((acd)localObject1).GbL;
    p.g(localObject1, "proto.trackCropRect");
    a((Rect)localObject2, (cse)localObject1);
    paramdom.HCX = new dpu();
    paramw = paramw.BGw.LmB;
    paramdom = paramdom.HCX;
    p.g(paramdom, "proto.transitionInfo");
    p.h(paramw, "transition");
    p.h(paramdom, "proto");
    paramdom.path = paramw.path;
    paramdom.xPg = paramw.xPg;
    paramdom.duration = paramw.duration;
    AppMethodBeat.o(195706);
  }
  
  private static void a(aan paramaan, VLogEffectMgr paramVLogEffectMgr)
  {
    AppMethodBeat.i(195709);
    p.h(paramaan, "proto");
    p.h(paramVLogEffectMgr, "vLogEffectMgr");
    Object localObject1 = paramaan.BFa.FZr;
    p.g(localObject1, "proto.editData.baseItemData");
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    label122:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (((ja)localObject3).dataType == com.tencent.mm.plugin.recordvideo.ui.editor.item.d.xNW.value) {}
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
      if (n.nz(((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).xPf, "assets://"))
      {
        localObject3 = VLogEffectMgr.a.LBo;
        localObject4 = aj.getContext();
        p.g(localObject4, "MMApplicationContext.getContext()");
      }
      for (long l = paramVLogEffectMgr.a((VLogEffectMgr.a)localObject3, ((Context)localObject4).getAssets(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).xPf);; l = paramVLogEffectMgr.a(VLogEffectMgr.a.LBo, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).xPf))
      {
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).xPg = l;
        localObject3 = paramVLogEffectMgr.EN(((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).xPg);
        p.g(localObject3, "size");
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).width = ((Size)localObject3).getWidth();
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).height = ((Size)localObject3).getHeight();
        localObject3 = new Rect();
        localObject4 = paramaan.BFa.FZq;
        p.g(localObject4, "proto.editData.drawingRect");
        a((cse)localObject4, (Rect)localObject3);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).xPi.set((Rect)localObject3);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).g(((a)localObject2).gR);
        ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).xPh = paramVLogEffectMgr.a(((a)localObject2).xNA.getStart(), ((a)localObject2).xNA.getEnd(), ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).xPg, new com.tencent.mm.xeffect.b((int)((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).centerX, (int)((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).centerY, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).scale, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).kRD), new com.tencent.mm.xeffect.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.o)localObject2).text, null, 30));
        break;
      }
    }
    AppMethodBeat.o(195709);
  }
  
  private static void a(aan paramaan, VLogEffectMgr paramVLogEffectMgr, v paramv)
  {
    AppMethodBeat.i(195715);
    p.h(paramaan, "proto");
    p.h(paramVLogEffectMgr, "vLogEffectMgr");
    p.h(paramv, "composition");
    if (paramaan.FZz != null)
    {
      Object localObject1 = paramaan.FZz.DCE;
      p.g(localObject1, "proto.videoTemplate.templatePath");
      Object localObject2;
      if (n.nz((String)localObject1, "assets://"))
      {
        localObject1 = VLogEffectMgr.a.LBr;
        localObject2 = aj.getContext();
        p.g(localObject2, "MMApplicationContext.getContext()");
      }
      for (long l = paramVLogEffectMgr.a((VLogEffectMgr.a)localObject1, ((Context)localObject2).getAssets(), paramaan.FZz.DCE);; l = paramVLogEffectMgr.a(VLogEffectMgr.a.LBr, paramaan.FZz.DCE))
      {
        localObject2 = paramVLogEffectMgr.EN(l);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Size(0, 0);
        }
        int i = paramVLogEffectMgr.EM(l);
        localObject2 = paramaan.FZz.DCE;
        p.g(localObject2, "proto.videoTemplate.templatePath");
        String str = paramaan.FZz.hml;
        p.g(str, "proto.videoTemplate.musicPath");
        localObject1 = new a.c((String)localObject2, str, (Size)localObject1, paramaan.FZz.duration, i, l, paramaan.FZz.BHz, null, null, 0L, null, 1920);
        paramVLogEffectMgr.fSq();
        ((a.c)localObject1).BHA = paramVLogEffectMgr.a(0L, ((a.c)localObject1).duration, ((a.c)localObject1).xPg, new long[0]);
        paramVLogEffectMgr.b(((a.c)localObject1).BHA, ae.c(new d.o[] { u.S(Integer.valueOf(VLogEffectMgr.b.LBB.ordinal()), Float.valueOf(1.0F)) }));
        paramaan = paramaan.FZz.hml;
        p.g(paramaan, "proto.videoTemplate.musicPath");
        paramv.aDp(paramaan);
        paramaan = ((Iterable)paramv.BGl).iterator();
        while (paramaan.hasNext()) {
          ((w)paramaan.next()).BGw.LmA = false;
        }
      }
    }
    AppMethodBeat.o(195715);
  }
  
  public static final void a(cse paramcse, Rect paramRect)
  {
    AppMethodBeat.i(195705);
    p.h(paramcse, "proto");
    p.h(paramRect, "rect");
    if (paramcse.GSD.size() == 4)
    {
      Object localObject = paramcse.GSD.get(0);
      p.g(localObject, "proto.values[0]");
      int i = ((Number)localObject).intValue();
      localObject = paramcse.GSD.get(1);
      p.g(localObject, "proto.values[1]");
      int j = ((Number)localObject).intValue();
      localObject = paramcse.GSD.get(2);
      p.g(localObject, "proto.values[2]");
      int k = ((Number)localObject).intValue();
      paramcse = paramcse.GSD.get(3);
      p.g(paramcse, "proto.values[3]");
      paramRect.set(i, j, k, ((Number)paramcse).intValue());
    }
    AppMethodBeat.o(195705);
  }
  
  private static void a(dom paramdom, w paramw)
  {
    AppMethodBeat.i(195707);
    p.h(paramdom, "proto");
    p.h(paramw, "track");
    paramw.Bi(paramdom.startTimeMs);
    paramw.Bj(paramdom.hiy);
    paramw.Bk(paramdom.HCU);
    paramw.Bl(paramdom.HCV);
    paramw.BGr = paramdom.BGr;
    paramw.BGs = paramdom.BGs;
    paramw.BGt = paramdom.BGt;
    paramw.setVolume(paramdom.volume);
    Object localObject2 = paramdom.HCW;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject1 = paramw.BGu;
      p.h(localObject2, "proto");
      p.h(localObject1, "cropInfo");
      Object localObject4 = ((acd)localObject2).GbH;
      if (localObject4 != null)
      {
        localObject3 = ((g)localObject1).gR;
        p.h(localObject4, "proto");
        p.h(localObject3, "matrix");
        if (((byh)localObject4).GSD.size() == 9)
        {
          localObject4 = ((byh)localObject4).GSD;
          p.g(localObject4, "proto.values");
          ((Matrix)localObject3).setValues(j.q((Collection)localObject4));
        }
      }
      localObject3 = ((acd)localObject2).GbK;
      if (localObject3 != null) {
        a((cse)localObject3, ((g)localObject1).pZj);
      }
      localObject3 = ((acd)localObject2).GbI;
      if (localObject3 != null) {
        a((cse)localObject3, ((g)localObject1).hmm);
      }
      localObject2 = ((acd)localObject2).GbJ;
      if (localObject2 != null) {
        a((cse)localObject2, ((g)localObject1).viewRect);
      }
    }
    paramw.BGw.hmm.set(paramw.BGu.pZj);
    Object localObject1 = paramdom.HCX;
    if (localObject1 != null)
    {
      localObject2 = paramw.BGw.LmB;
      p.h(localObject1, "proto");
      p.h(localObject2, "transition");
      localObject3 = ((dpu)localObject1).path;
      p.g(localObject3, "proto.path");
      ((com.tencent.mm.videocomposition.g)localObject2).setPath((String)localObject3);
      ((com.tencent.mm.videocomposition.g)localObject2).xPg = ((dpu)localObject1).xPg;
      ((com.tencent.mm.videocomposition.g)localObject2).duration = ((dpu)localObject1).duration;
    }
    paramdom = paramdom.HCW;
    if (paramdom != null)
    {
      paramdom = paramdom.GbL;
      p.g(paramdom, "it.trackCropRect");
      a(paramdom, paramw.BGw.Lmz);
      AppMethodBeat.o(195707);
      return;
    }
    AppMethodBeat.o(195707);
  }
  
  public static final String aDj(String paramString)
  {
    AppMethodBeat.i(195703);
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
      AppMethodBeat.o(195703);
      return paramString;
      j = 0;
      break label45;
      label77:
      i -= 1;
      break;
      i = -1;
    }
  }
  
  public static final com.tencent.mm.plugin.recordvideo.ui.editor.b.c b(aan paramaan)
  {
    AppMethodBeat.i(195713);
    p.h(paramaan, "proto");
    Object localObject1 = e.xuo;
    localObject1 = paramaan.BFa.FZr;
    p.g(localObject1, "proto.editData.baseItemData");
    Object localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    localObject1 = e.a((LinkedList)localObject1, (Context)localObject2);
    localObject2 = paramaan.BFa.FZq.GSD;
    p.g(localObject2, "proto.editData.drawingRect.values");
    Object localObject3 = (Iterable)localObject2;
    localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext()) {
      ((Collection)localObject2).add(Float.valueOf(((Integer)((Iterator)localObject3).next()).intValue()));
    }
    localObject2 = j.q((Collection)localObject2);
    localObject3 = paramaan.BFa.FZt;
    if (localObject3 != null)
    {
      localObject3 = ((cse)localObject3).GSD;
      p.g(localObject3, "rectProto.values");
      Object localObject4 = (Iterable)localObject3;
      localObject3 = (Collection)new ArrayList(j.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((Collection)localObject3).add(Float.valueOf(((Integer)((Iterator)localObject4).next()).intValue()));
      }
      j.q((Collection)localObject3);
    }
    paramaan = (com.tencent.mm.plugin.recordvideo.ui.editor.b.c)new com.tencent.mm.plugin.recordvideo.ui.editor.b.f((float[])localObject2, (List)localObject1, paramaan.BEZ.tJd, paramaan.BEZ.tJe);
    AppMethodBeat.o(195713);
    return paramaan;
  }
  
  private static void b(aan paramaan, VLogEffectMgr paramVLogEffectMgr)
  {
    AppMethodBeat.i(195710);
    p.h(paramaan, "proto");
    p.h(paramVLogEffectMgr, "vLogEffectMgr");
    paramaan = paramaan.FZy;
    p.g(paramaan, "proto.magicInfoList");
    paramaan = ((Iterable)paramaan).iterator();
    if (paramaan.hasNext())
    {
      bxn localbxn = (bxn)paramaan.next();
      Object localObject = localbxn.path;
      p.g(localObject, "it.path");
      Context localContext;
      if (n.nz((String)localObject, "assets://"))
      {
        localObject = VLogEffectMgr.a.LBp;
        localContext = aj.getContext();
        p.g(localContext, "MMApplicationContext.getContext()");
      }
      for (long l = paramVLogEffectMgr.a((VLogEffectMgr.a)localObject, localContext.getAssets(), localbxn.path);; l = paramVLogEffectMgr.a(VLogEffectMgr.a.LBp, localbxn.path))
      {
        paramVLogEffectMgr.s(localbxn.start, localbxn.bpc, l);
        break;
      }
    }
    AppMethodBeat.o(195710);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.f
 * JD-Core Version:    0.7.0.1
 */