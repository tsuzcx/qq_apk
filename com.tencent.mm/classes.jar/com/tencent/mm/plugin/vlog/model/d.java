package com.tencent.mm.plugin.vlog.model;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.protocal.protobuf.aap;
import com.tencent.mm.protocal.protobuf.aaq;
import com.tencent.mm.protocal.protobuf.aar;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.videocomposition.h.b;
import d.a.j;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "", "()V", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "calculateAba", "progressCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "retryCount", "", "getRetryCount", "()I", "setRetryCount", "(I)V", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "export", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "callback", "reportStartExport", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputPath", "", "setCalculateAdaptiveBitrate", "enable", "setProgressCallback", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final d.a BWu;
  private boolean BWs;
  public d.g.a.b<? super Float, z> BWt;
  public int retryCount = 1;
  public boolean vOG = true;
  private VideoTransPara vZX;
  
  static
  {
    AppMethodBeat.i(191152);
    BWu = new d.a((byte)0);
    AppMethodBeat.o(191152);
  }
  
  private static void a(v paramv, String paramString)
  {
    AppMethodBeat.i(191151);
    paramv = (List)paramv.BXJ;
    Object localObject2 = (Iterable)paramv;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label93:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((w)localObject3).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label93;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((w)((Iterator)localObject2).next()).path);
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.vlog.model.report.a.BZn;
    int i = paramv.size();
    if (((List)localObject1).size() < paramv.size()) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.vlog.model.report.a.aN(i, bool);
      paramv = com.tencent.mm.plugin.vlog.model.report.a.BZn;
      com.tencent.mm.plugin.vlog.model.report.a.q((List)localObject1, paramString);
      AppMethodBeat.o(191151);
      return;
    }
  }
  
  public final float a(final aaq paramaaq, final d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(191150);
    p.h(paramaaq, "compositionInfo");
    p.h(paramb, "callback");
    final aar localaar = paramaaq.BWx;
    v localv = f.a(paramaaq);
    int i;
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (!bu.isNullOrNil(paramaaq.hoZ))
    {
      i = 1;
      localObject1 = localaar.pYH;
      p.g(localObject1, "outputConfig.outputPath");
      a(localv, (String)localObject1);
      if ((!this.BWs) || (this.vZX == null)) {
        break label570;
      }
      localObject1 = e.BWC;
      localObject1 = this.vZX;
      if (localObject1 == null) {
        p.gkB();
      }
      int j = localaar.targetWidth;
      int k = localaar.targetHeight;
      localObject2 = paramaaq.BWy.GrR;
      p.g(localObject2, "compositionInfo.editData.baseItemData");
      if (((Collection)localObject2).isEmpty()) {
        break label473;
      }
      bool = true;
      label142:
      localObject1 = e.a.a(localv, (VideoTransPara)localObject1, j, k, bool);
      localObject2 = e.BWC;
      p.g(localaar, "outputConfig");
      e.a.a((a)localObject1, localaar);
      if ((((a)localObject1).sTT == null) || (((a)localObject1).sTT.length < 28)) {
        break label570;
      }
    }
    label570:
    for (float f = localObject1.sTT[27];; f = 0.0F)
    {
      paramaaq = f.b(paramaaq);
      localv.F((d.g.a.b)paramaaq);
      paramaaq.start();
      if (i != 0)
      {
        ae.i("MicroMsg.VLogCompositionBlendExporter", "export: has music, audio info " + localaar.audioBitrate + ", " + localaar.audioSampleRate + ", " + localaar.audioChannelCount);
        if (localaar.audioBitrate == 0) {
          localaar.audioBitrate = 128000;
        }
        if (localaar.audioSampleRate == 0) {
          localaar.audioSampleRate = 44100;
        }
        if (localaar.audioChannelCount == 0) {
          localaar.audioChannelCount = 1;
        }
      }
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qPl, 1) == 1) {}
      for (bool = true;; bool = false)
      {
        localObject1 = new h.b(new Size(localaar.targetWidth, localaar.targetHeight), localaar.videoBitrate, localaar.fps, localaar.hpl, localaar.audioBitrate, localaar.audioSampleRate, localaar.audioChannelCount, bool);
        localObject2 = localaar.pYH;
        str = o.aZU((String)localObject2);
        if (!o.fB(str)) {
          o.aZI(str);
        }
        if (o.aZV((String)localObject2)) {
          break label485;
        }
        paramb.invoke(Boolean.FALSE);
        AppMethodBeat.o(191150);
        return 0.0F;
        i = 0;
        break;
        label473:
        bool = false;
        break label142;
      }
      label485:
      String str = o.k((String)localObject2, true);
      final long l = bu.HQ();
      localv.is(((h.b)localObject1).audioSampleRate, ((h.b)localObject1).audioChannelCount);
      h localh = localv.getComposition();
      p.g(str, "exportPath");
      h.a(localh, str, (h.b)localObject1, (m)new b(this, paramaaq, (String)localObject2, l, localv, localaar, paramb), this.BWt);
      AppMethodBeat.o(191150);
      return f;
    }
  }
  
  public final void r(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(191149);
    p.h(paramVideoTransPara, "videoTransPara");
    this.BWs = true;
    this.vZX = paramVideoTransPara;
    AppMethodBeat.o(191149);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "success", "", "errCode", "", "invoke"})
  static final class b
    extends q
    implements m<Boolean, Integer, z>
  {
    b(d paramd, c paramc, String paramString, long paramLong, v paramv, aar paramaar, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.d
 * JD-Core Version:    0.7.0.1
 */