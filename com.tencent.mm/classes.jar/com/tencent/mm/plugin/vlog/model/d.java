package com.tencent.mm.plugin.vlog.model;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "", "()V", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "calculateAba", "progressCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "retryCount", "", "getRetryCount", "()I", "setRetryCount", "(I)V", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "export", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "callback", "reportStartExport", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputPath", "", "setCalculateAdaptiveBitrate", "enable", "setProgressCallback", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final a BEW;
  private boolean BEU;
  public d.g.a.b<? super Float, z> BEV;
  public int retryCount = 1;
  public boolean vCC = true;
  private VideoTransPara vNU;
  
  static
  {
    AppMethodBeat.i(195695);
    BEW = new a((byte)0);
    AppMethodBeat.o(195695);
  }
  
  private static void a(v paramv, String paramString)
  {
    AppMethodBeat.i(195694);
    paramv = (List)paramv.BGl;
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
    localObject2 = com.tencent.mm.plugin.vlog.model.report.a.BHO;
    int i = paramv.size();
    if (((List)localObject1).size() < paramv.size()) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.vlog.model.report.a.aK(i, bool);
      paramv = com.tencent.mm.plugin.vlog.model.report.a.BHO;
      com.tencent.mm.plugin.vlog.model.report.a.q((List)localObject1, paramString);
      AppMethodBeat.o(195694);
      return;
    }
  }
  
  public final float a(final aan paramaan, final d.g.a.b<? super Boolean, z> paramb)
  {
    AppMethodBeat.i(195693);
    p.h(paramaan, "compositionInfo");
    p.h(paramb, "callback");
    final aao localaao = paramaan.BEZ;
    v localv = f.a(paramaan);
    Object localObject1 = localaao.pSc;
    p.g(localObject1, "outputConfig.outputPath");
    a(localv, (String)localObject1);
    Object localObject2;
    if ((this.BEU) && (this.vNU != null))
    {
      localObject1 = e.BFe;
      localObject1 = this.vNU;
      if (localObject1 == null) {
        p.gfZ();
      }
      localObject1 = e.a.a(localv, (VideoTransPara)localObject1, localaao.targetWidth, localaao.targetHeight);
      localObject2 = e.BFe;
      p.g(localaao, "outputConfig");
      e.a.a((a)localObject1, localaao);
      if ((((a)localObject1).sIH == null) || (((a)localObject1).sIH.length < 28)) {}
    }
    for (float f = localObject1.sIH[27];; f = 0.0F)
    {
      paramaan = f.b(paramaan);
      localv.E((d.g.a.b)paramaan);
      paramaan.start();
      if (((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qHF, 1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localObject1 = new h.b(new Size(localaao.targetWidth, localaao.targetHeight), localaao.videoBitrate, localaao.fps, localaao.hmx, localaao.audioBitrate, localaao.audioSampleRate, localaao.audioChannelCount, bool);
        localObject2 = localaao.pSc;
        str = i.aYr((String)localObject2);
        if (!i.fv(str)) {
          i.aYg(str);
        }
        if (i.aYs((String)localObject2)) {
          break;
        }
        paramb.invoke(Boolean.FALSE);
        AppMethodBeat.o(195693);
        return 0.0F;
      }
      String str = i.k((String)localObject2, true);
      final long l = bt.HI();
      localv.lF(((h.b)localObject1).audioSampleRate, ((h.b)localObject1).audioChannelCount);
      h localh = localv.getComposition();
      p.g(str, "exportPath");
      h.a(localh, str, (h.b)localObject1, (m)new b(this, paramaan, (String)localObject2, l, localv, localaao, paramb), this.BEV);
      AppMethodBeat.o(195693);
      return f;
    }
  }
  
  public final void r(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(195692);
    p.h(paramVideoTransPara, "videoTransPara");
    this.BEU = true;
    this.vNU = paramVideoTransPara;
    AppMethodBeat.o(195692);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "success", "", "errCode", "", "invoke"})
  static final class b
    extends q
    implements m<Boolean, Integer, z>
  {
    b(d paramd, c paramc, String paramString, long paramLong, v paramv, aao paramaao, d.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.d
 * JD-Core Version:    0.7.0.1
 */