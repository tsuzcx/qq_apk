package com.tencent.mm.plugin.vlog.model;

import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.n.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.a;
import kotlin.g.b.z.c;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "", "()V", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "calculateAba", "progressCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "retryCount", "", "getRetryCount", "()I", "setRetryCount", "(I)V", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "align4", "value", "checkFallbackSize", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "checkTargetSize", "export", "callback", "performanceReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "key", "", "reportStartExport", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "outputPath", "softEncode", "setCalculateAdaptiveBitrate", "enable", "setProgressCallback", "getReportKey", "Companion", "plugin-vlog_release"})
public final class f
{
  public static final a Gxm;
  public boolean Gxj = true;
  private boolean Gxk;
  private kotlin.g.a.b<? super Float, x> Gxl;
  public int retryCount = 1;
  private VideoTransPara zua;
  
  static
  {
    AppMethodBeat.i(190498);
    Gxm = new a((byte)0);
    AppMethodBeat.o(190498);
  }
  
  private static void a(ac paramac, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(190496);
    paramac = (List)paramac.Gzn;
    Object localObject2 = (Iterable)paramac;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label93:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((ad)localObject3).type == 2) {}
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
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).path);
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.vlog.model.report.a.GBa;
    int i = paramac.size();
    if (((List)localObject1).size() < paramac.size()) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.vlog.model.report.a.bd(i, bool);
      paramac = com.tencent.mm.plugin.vlog.model.report.a.GBa;
      com.tencent.mm.plugin.vlog.model.report.a.c((List)localObject1, paramString, paramBoolean);
      AppMethodBeat.o(190496);
      return;
    }
  }
  
  private static void a(acn paramacn)
  {
    AppMethodBeat.i(190495);
    k localk = k.GxP;
    int i = k.fAT();
    Log.i("MicroMsg.VLogCompositionBlendExporter", "checkTargetSize: origin " + paramacn.Gxw.targetWidth + ", " + paramacn.Gxw.targetHeight + ", type " + i);
    paramacn.Gxw.Lnq = i;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(190495);
      return;
      i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scq, 1920);
      if (paramacn.Gxw.targetHeight > i)
      {
        int j = d.QH((int)(i * 1.0F / paramacn.Gxw.targetHeight * paramacn.Gxw.targetWidth));
        paramacn.Gxw.targetWidth = j;
        paramacn.Gxw.targetHeight = i;
        AppMethodBeat.o(190495);
        return;
        i = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.scp, 720);
        Log.i("MicroMsg.VLogCompositionBlendExporter", "checkTargetSize: config ".concat(String.valueOf(i)));
        if (paramacn.Gxw.targetWidth > i)
        {
          j = d.QH((int)(i * 1.0F / paramacn.Gxw.targetWidth * paramacn.Gxw.targetHeight));
          paramacn.Gxw.targetWidth = i;
          paramacn.Gxw.targetHeight = j;
        }
      }
    }
  }
  
  private static int acw(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 4 == 0) {
      return paramInt;
    }
    for (;;)
    {
      paramInt = i;
      if (i % 4 == 0) {
        break;
      }
      i += 1;
    }
  }
  
  public static String b(acn paramacn)
  {
    AppMethodBeat.i(190497);
    p.h(paramacn, "$this$getReportKey");
    String str2 = paramacn.editId;
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramacn.Gxw.rpE;
      p.g(str1, "outputConfig.outputPath");
    }
    AppMethodBeat.o(190497);
    return str1;
  }
  
  public final void N(kotlin.g.a.b<? super Float, x> paramb)
  {
    AppMethodBeat.i(190493);
    p.h(paramb, "callback");
    this.Gxl = paramb;
    AppMethodBeat.o(190493);
  }
  
  public final float a(final acn paramacn, final kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(190494);
    p.h(paramacn, "compositionInfo");
    p.h(paramb, "callback");
    Log.i("MicroMsg.VLogCompositionBlendExporter", "start export, retryCount:" + this.retryCount);
    final aco localaco = paramacn.Gxw;
    final EffectManager localEffectManager = new EffectManager();
    ac localac = i.d(paramacn, localEffectManager);
    int i;
    final z.a locala;
    label169:
    Object localObject1;
    final z.c localc;
    Object localObject2;
    if (!Util.isNullOrNil(paramacn.iiv))
    {
      i = 1;
      locala = new z.a();
      locala.SYB = false;
      if (this.retryCount >= 2)
      {
        bool1 = w.fBw();
        Log.i("MicroMsg.VLogCompositionBlendExporter", "retryCount:" + this.retryCount + ", enable try use softEncode: " + bool1);
        locala.SYB = bool1;
      }
      if ((!locala.SYB) && (!w.fBu())) {
        break label817;
      }
      bool1 = true;
      locala.SYB = bool1;
      localObject1 = localaco.rpE;
      p.g(localObject1, "outputConfig.outputPath");
      a(localac, (String)localObject1, locala.SYB);
      localc = new z.c();
      localc.SYD = 0.0F;
      if ((this.Gxk) && (this.zua != null))
      {
        localObject1 = g.GxB;
        localObject1 = this.zua;
        if (localObject1 == null) {
          p.hyc();
        }
        int j = localaco.targetWidth;
        int k = localaco.targetHeight;
        localObject2 = paramacn.Gxx.Lna;
        p.g(localObject2, "compositionInfo.editData.baseItemData");
        if (((Collection)localObject2).isEmpty()) {
          break label823;
        }
        bool1 = true;
        label298:
        localObject1 = g.a.a(localac, (VideoTransPara)localObject1, j, k, bool1);
        localObject2 = g.GxB;
        p.g(localaco, "outputConfig");
        g.a.a((a)localObject1, localaco);
        if ((((a)localObject1).vRR != null) && (((a)localObject1).vRR.length >= 28))
        {
          localc.SYD = localObject1.vRR[27];
          Log.i("MicroMsg.VLogCompositionBlendExporter", "export videoQuality: " + localc.SYD);
        }
      }
      a(paramacn);
      Log.i("MicroMsg.VLogCompositionBlendExporter", "export: size " + localaco.targetWidth + ' ' + localaco.targetHeight);
      localObject2 = new z.f();
      ((z.f)localObject2).SYG = null;
      localObject1 = paramacn.Gxx;
      if (localObject1 == null) {
        break label829;
      }
      localObject1 = ((acm)localObject1).LmZ;
      label468:
      if (localObject1 != null)
      {
        localObject1 = paramacn.Gxx;
        if (localObject1 == null) {
          break label835;
        }
        localObject1 = ((acm)localObject1).Lnc;
        label491:
        if (localObject1 != null)
        {
          ((z.f)localObject2).SYG = i.d(paramacn);
          localac.O((kotlin.g.a.b)((z.f)localObject2).SYG);
          ((c)((z.f)localObject2).SYG).start();
        }
      }
      if (i != 0)
      {
        Log.i("MicroMsg.VLogCompositionBlendExporter", "export: has music, audio info " + localaco.audioBitrate + ", " + localaco.audioSampleRate + ", " + localaco.audioChannelCount);
        if (localaco.audioBitrate == 0) {
          localaco.audioBitrate = 128000;
        }
        if (localaco.audioSampleRate == 0) {
          localaco.audioSampleRate = 44100;
        }
        if (localaco.audioChannelCount == 0) {
          localaco.audioChannelCount = 1;
        }
      }
      if (w.fBu())
      {
        localaco.targetWidth = acw(localaco.targetWidth);
        localaco.targetHeight = acw(localaco.targetHeight);
      }
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.smu, 1) != 1) {
        break label841;
      }
    }
    final String str1;
    label817:
    label823:
    label829:
    label835:
    label841:
    for (final boolean bool1 = true;; bool1 = false)
    {
      localObject1 = new n.b(new Size(localaco.targetWidth, localaco.targetHeight), localaco.videoBitrate, localaco.fps, localaco.iiH, localaco.audioBitrate, localaco.audioSampleRate, localaco.audioChannelCount, bool1, false, localaco.Lnr);
      str1 = localaco.rpE;
      str2 = s.boZ(str1);
      if (!s.YS(str2)) {
        s.boN(str2);
      }
      if (s.bpa(str1)) {
        break label847;
      }
      paramb.invoke(Boolean.FALSE);
      AppMethodBeat.o(190494);
      return 0.0F;
      i = 0;
      break;
      bool1 = false;
      break label169;
      bool1 = false;
      break label298;
      localObject1 = null;
      break label468;
      localObject1 = null;
      break label491;
    }
    label847:
    final String str2 = s.k(str1, true);
    if (str2 == null) {
      p.hyc();
    }
    p.g(str2, "VFSFileOp.exportExternalPath(path, true)!!");
    final long l1 = Util.currentTicks();
    localac.ju(((n.b)localObject1).audioSampleRate, ((n.b)localObject1).audioChannelCount);
    if (localac.Gzp)
    {
      Log.i("MicroMsg.VLogCompositionBlendExporter", "enable video enhancement");
      localObject3 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
      com.tencent.mm.plugin.vlog.model.local.a.fBY();
    }
    Object localObject3 = localac.getComposition();
    long l2 = Util.ticksToNow(l1);
    bool1 = w.fBu();
    final boolean bool2 = w.fBv();
    Log.i("MicroMsg.VLogCompositionBlendExporter", "enableHevcSoft:" + bool1 + ", enableHevcHard:" + bool2);
    paramacn = (m)new b(this, paramacn, l1, l2, localEffectManager, localac, bool1, bool2, locala, str2, localc, (z.f)localObject2, str1, localaco, paramb);
    if ((w.fBu()) || (locala.SYB)) {
      ((n)localObject3).b(str2, (n.b)localObject1, (AssetWriterVideoEncoder)new h(), paramacn, this.Gxl);
    }
    for (;;)
    {
      float f = localc.SYD;
      AppMethodBeat.o(190494);
      return f;
      ((n)localObject3).a(str2, (n.b)localObject1, paramacn, this.Gxl);
    }
  }
  
  public final void r(VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(190492);
    p.h(paramVideoTransPara, "videoTransPara");
    this.Gxk = true;
    this.zua = paramVideoTransPara;
    AppMethodBeat.o(190492);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "errCode", "", "invoke"})
  static final class b
    extends q
    implements m<Boolean, Integer, x>
  {
    b(f paramf, acn paramacn, long paramLong1, long paramLong2, EffectManager paramEffectManager, ac paramac, boolean paramBoolean1, boolean paramBoolean2, z.a parama, String paramString1, z.c paramc, z.f paramf1, String paramString2, aco paramaco, kotlin.g.a.b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.f
 * JD-Core Version:    0.7.0.1
 */