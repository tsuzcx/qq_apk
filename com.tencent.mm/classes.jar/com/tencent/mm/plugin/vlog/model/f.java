package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.b.c;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acv;
import com.tencent.mm.protocal.protobuf.dhd;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.eth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.j.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.c;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "", "()V", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "calculateAba", "progressCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "reportScene", "", "getReportScene", "()I", "setReportScene", "(I)V", "retryCount", "getRetryCount", "setRetryCount", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "checkFallbackSize", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "checkTargetSize", "export", "callback", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "getMediaInfoJson", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "performanceReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "key", "reportStartExport", "outputPath", "softEncode", "resize2Even", "value", "setCalculateAdaptiveBitrate", "enable", "setProgressCallback", "setupOutputConfig", "config", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "getReportKey", "Companion", "plugin-vlog_release"})
public final class f
{
  public static final a NkO;
  private VideoTransPara EZB;
  public boolean NkL = true;
  private boolean NkM;
  private kotlin.g.a.b<? super Float, x> NkN;
  public int retryCount = 1;
  public int wwk;
  
  static
  {
    AppMethodBeat.i(229059);
    NkO = new a((byte)0);
    AppMethodBeat.o(229059);
  }
  
  private static int QC(int paramInt)
  {
    int i = paramInt;
    if (paramInt % 2 != 0) {
      i = paramInt - 1;
    }
    return i;
  }
  
  public static String a(acu paramacu)
  {
    AppMethodBeat.i(229057);
    p.k(paramacu, "$this$getReportKey");
    String str2 = paramacu.editId;
    String str1 = str2;
    if (str2 == null)
    {
      str1 = paramacu.NkX.uVk;
      p.j(str1, "outputConfig.outputPath");
    }
    AppMethodBeat.o(229057);
    return str1;
  }
  
  private static void a(ac paramac, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(229055);
    paramac = (List)paramac.MQY;
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
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).path);
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
    int i = paramac.size();
    if (((List)localObject1).size() < paramac.size()) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.vlog.model.report.a.bq(i, bool);
      paramac = com.tencent.mm.plugin.vlog.model.report.a.NoJ;
      com.tencent.mm.plugin.vlog.model.report.a.c((List)localObject1, paramString, paramBoolean);
      AppMethodBeat.o(229055);
      return;
    }
  }
  
  public final void Z(kotlin.g.a.b<? super Float, x> paramb)
  {
    AppMethodBeat.i(228970);
    p.k(paramb, "callback");
    this.NkN = paramb;
    AppMethodBeat.o(228970);
  }
  
  public final float a(final acu paramacu, final kotlin.g.a.b<? super l, x> paramb)
  {
    AppMethodBeat.i(229048);
    p.k(paramacu, "compositionInfo");
    p.k(paramb, "callback");
    Log.i("MicroMsg.VLogCompositionBlendExporter", "start export, retryCount:" + this.retryCount);
    final l locall = new l((byte)0);
    final acv localacv = paramacu.NkX;
    p.j(localacv, "outputConfig");
    if (localacv.SoJ != null)
    {
      localacv.targetWidth = localacv.SoJ.targetWidth;
      localacv.targetHeight = localacv.SoJ.targetHeight;
    }
    final EffectManager localEffectManager;
    final ac localac;
    for (;;)
    {
      localEffectManager = new EffectManager();
      localac = i.d(paramacu, localEffectManager);
      Log.i("MicroMsg.VLogCompositionBlendExporter", "outputScale: " + localacv.SoE + ", enableExport1080WidescreenVideo: " + w.gtu());
      if ((localacv.SoE <= 1.0F) || (!w.gtu())) {
        break label633;
      }
      Log.i("MicroMsg.VLogCompositionBlendExporter", "ready to enlarge resolution");
      localacv.targetWidth = QC((int)(localacv.targetWidth * localacv.SoE));
      localacv.targetHeight = QC((int)(localacv.targetHeight * localacv.SoE));
      localObject1 = ((Iterable)localac.MQY).iterator();
      while (((Iterator)localObject1).hasNext()) {
        com.tencent.mm.videocomposition.h.b(((ad)((Iterator)localObject1).next()).Nng.kXj, localacv.SoE);
      }
      if (localacv.SoK != null)
      {
        localacv.targetWidth = localacv.SoK.targetWidth;
        localacv.targetHeight = localacv.SoK.targetHeight;
      }
    }
    Object localObject1 = localac.NmT.igI();
    localac.kH((int)(((Size)localObject1).getWidth() * localacv.SoE), (int)(((Size)localObject1).getHeight() * localacv.SoE));
    localObject1 = localacv.SoK;
    Object localObject2;
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((dhd)localObject1).Sro;
      if (localObject1 != null)
      {
        localObject2 = ((duz)localObject1).TDA.get(0);
        p.j(localObject2, "cropRectProto.values[0]");
        i = ((Number)localObject2).intValue();
        localObject2 = ((duz)localObject1).TDA.get(1);
        p.j(localObject2, "cropRectProto.values[1]");
        j = ((Number)localObject2).intValue();
        localObject2 = ((duz)localObject1).TDA.get(2);
        p.j(localObject2, "cropRectProto.values[2]");
        k = ((Number)localObject2).intValue();
        localObject1 = ((duz)localObject1).TDA.get(3);
        p.j(localObject1, "cropRectProto.values[3]");
        localObject1 = new Rect(i, j, k, ((Number)localObject1).intValue());
        com.tencent.mm.videocomposition.h.b((Rect)localObject1, localacv.SoE);
        localac.x((Rect)localObject1);
        Log.i("MicroMsg.VLogCompositionBlendExporter", "enlarge cropRect:".concat(String.valueOf(localObject1)));
        localObject1 = x.aazN;
      }
    }
    localacv.SoE = 1.0F;
    Log.i("MicroMsg.VLogCompositionBlendExporter", "enlarge done, targetWidth:" + localacv.targetWidth + ", targetHeight:" + localacv.targetHeight + ", renderSize:" + localac.NmT.igI() + ", outputSize:" + localac.NmT.igJ());
    label633:
    boolean bool2;
    label695:
    label834:
    final aa.c localc;
    label812:
    label821:
    Object localObject3;
    label915:
    label922:
    label1086:
    label1272:
    Object localObject4;
    if (!Util.isNullOrNil(paramacu.kXi))
    {
      i = 1;
      localObject2 = new aa.a();
      ((aa.a)localObject2).aaBx = false;
      if (this.retryCount >= 2)
      {
        localObject1 = n.NlN;
        if (!n.gsU()) {
          break label1815;
        }
        localObject1 = n.NlN;
        if (n.gsY() != 1) {
          break label1809;
        }
        bool1 = true;
        Log.i("MicroMsg.VLogCompositionBlendExporter", "retryCount:" + this.retryCount + ", enable try use softEncode: " + bool1);
        ((aa.a)localObject2).aaBx = bool1;
      }
      if ((this.wwk != 1) && (this.wwk != 2)) {
        break label1918;
      }
      l1 = localac.NmT.getDurationMs();
      localObject1 = com.tencent.mm.modelcontrol.e.bkp();
      p.j(localObject1, "SubCoreVideoControl.getCore()");
      j = ((com.tencent.mm.modelcontrol.e)localObject1).bkv().duration * 1000;
      if (!localacv.mfh) {
        break label1900;
      }
      if (l1 <= j) {
        break label1894;
      }
      bool1 = true;
      bool1 = w.p(bool1, l1);
      if (!localacv.mfh) {
        break label1906;
      }
      bool2 = w.gtq();
      Log.i("MicroMsg.VLogCompositionBlendExporter", "enableHevcSoft:" + bool1 + ", enableHevcHard:" + bool2 + ", durationMs:" + l1 + ", longVideoDurationLimit:" + j);
      if ((!((aa.a)localObject2).aaBx) && ((!localacv.mfh) || (!bool1))) {
        break label1912;
      }
      bool1 = true;
      ((aa.a)localObject2).aaBx = bool1;
      localObject1 = localacv.uVk;
      p.j(localObject1, "outputConfig.outputPath");
      a(localac, (String)localObject1, ((aa.a)localObject2).aaBx);
      localc = new aa.c();
      localc.aaBz = 0.0F;
      if ((this.NkM) && (this.EZB != null))
      {
        if ((((aa.a)localObject2).aaBx) && (localacv.mfh == true))
        {
          Log.i("MicroMsg.VLogCompositionBlendExporter", "start calculate aba set hevc encode");
          localObject1 = this.EZB;
          if (localObject1 != null) {
            ((VideoTransPara)localObject1).lJF = 1;
          }
        }
        localObject1 = g.Nlc;
        localObject1 = this.EZB;
        if (localObject1 == null) {
          p.iCn();
        }
        j = localacv.targetWidth;
        k = localacv.targetHeight;
        localObject3 = paramacu.NkY.Sor;
        p.j(localObject3, "compositionInfo.editData.baseItemData");
        if (((Collection)localObject3).isEmpty()) {
          break label1994;
        }
        bool1 = true;
        localObject1 = g.a.a(localac, (VideoTransPara)localObject1, j, k, bool1);
        localObject3 = g.Nlc;
        g.a.a((a)localObject1, localacv);
        if ((((a)localObject1).Azu != null) && (((a)localObject1).Azu.length >= 28))
        {
          localc.aaBz = localObject1.Azu[27];
          Log.i("MicroMsg.VLogCompositionBlendExporter", "export videoQuality: " + localc.aaBz);
        }
      }
      localObject1 = k.Nlr;
      j = k.gsT();
      Log.i("MicroMsg.VLogCompositionBlendExporter", "checkTargetSize: origin " + paramacu.NkX.targetWidth + ", " + paramacu.NkX.targetHeight + ", type " + j);
      paramacu.NkX.SoH = j;
      switch (j)
      {
      default: 
        Log.i("MicroMsg.VLogCompositionBlendExporter", "export: size " + localacv.targetWidth + ' ' + localacv.targetHeight);
        localObject3 = new aa.f();
        ((aa.f)localObject3).aaBC = null;
        localObject1 = paramacu.NkY;
        if (localObject1 != null)
        {
          localObject1 = ((act)localObject1).Soq;
          label1345:
          if (localObject1 != null)
          {
            localObject1 = paramacu.NkY;
            if (localObject1 == null) {
              break label2191;
            }
            localObject1 = ((act)localObject1).Sot;
            label1368:
            if (localObject1 != null)
            {
              ((aa.f)localObject3).aaBC = i.c(paramacu);
              localac.aa((kotlin.g.a.b)((aa.f)localObject3).aaBC);
              ((c)((aa.f)localObject3).aaBC).start();
            }
          }
          localObject1 = paramacu.Sou;
          p.j(localObject1, "compositionInfo.tracks");
          localObject4 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject4).hasNext())
            {
              localObject1 = ((Iterator)localObject4).next();
              if (((eth)localObject1).type == 3)
              {
                j = 1;
                label1471:
                if (j == 0) {
                  continue;
                }
                label1476:
                if (localObject1 == null) {
                  break label2209;
                }
                j = 1;
                label1484:
                if ((i != 0) || (j != 0))
                {
                  Log.i("MicroMsg.VLogCompositionBlendExporter", "export: has music, audio info " + localacv.audioBitrate + ", " + localacv.audioSampleRate + ", " + localacv.audioChannelCount);
                  if (localacv.audioBitrate == 0) {
                    localacv.audioBitrate = 128000;
                  }
                  if (localacv.audioSampleRate == 0) {
                    localacv.audioSampleRate = 44100;
                  }
                  if (localacv.audioChannelCount == 0) {
                    localacv.audioChannelCount = 1;
                  }
                }
                if (((aa.a)localObject2).aaBx)
                {
                  localObject1 = h.Nlm;
                  localObject1 = h.a.a(new Size(localacv.targetWidth, localacv.targetHeight));
                  localacv.targetWidth = ((Size)localObject1).getWidth();
                  localacv.targetHeight = ((Size)localObject1).getHeight();
                }
                if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vXp, 1) != 1) {
                  break label2215;
                }
              }
            }
          }
        }
        break;
      }
    }
    final String str2;
    label1809:
    label1815:
    label2209:
    label2215:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject4 = new j.b(new Size(localacv.targetWidth, localacv.targetHeight), localacv.videoBitrate, localacv.fps, localacv.kXt, localacv.audioBitrate, localacv.audioSampleRate, localacv.audioChannelCount, bool1, localacv.mfh);
      str2 = localacv.uVk;
      localObject1 = u.bBT(str2);
      if (!u.agG((String)localObject1)) {
        u.bBD((String)localObject1);
      }
      if (u.bBV(str2)) {
        break label2221;
      }
      locall.success = false;
      locall.uTW = false;
      paramb.invoke(locall);
      AppMethodBeat.o(229048);
      return 0.0F;
      i = 0;
      break;
      bool1 = false;
      break label695;
      if (MultiProcessMMKV.getMMKV("FINDER_CONFIG_USER_KEY").getInt("USERINFO_FINDER_ENABLE_SOFT_ENCODE_FALLBACK_INT_SYNC", 0) == 1)
      {
        j = 1;
        label1835:
        if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.wav, 0) != 1) {
          break label1882;
        }
      }
      label1882:
      for (k = 1;; k = 0)
      {
        if ((j == 0) && (k == 0)) {
          break label1888;
        }
        bool1 = true;
        break;
        j = 0;
        break label1835;
      }
      label1888:
      bool1 = false;
      break label695;
      label1894:
      bool1 = false;
      break label812;
      label1900:
      bool1 = false;
      break label821;
      label1906:
      bool2 = false;
      break label834;
      label1912:
      bool1 = false;
      break label915;
      label1918:
      if ((!localacv.mfh) || (this.wwk != 4)) {
        break label922;
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.b.e.HJM;
      bool2 = com.tencent.mm.plugin.recordvideo.b.e.wv(true);
      if ((((aa.a)localObject2).aaBx) || (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        ((aa.a)localObject2).aaBx = bool1;
        Log.i("MicroMsg.VLogCompositionBlendExporter", "enableHevcSoft:".concat(String.valueOf(bool2)));
        break;
      }
      label1994:
      bool1 = false;
      break label1086;
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKB, 1920);
      if (paramacu.NkX.targetHeight <= j) {
        break label1272;
      }
      k = d.WV((int)(j * 1.0F / paramacu.NkX.targetHeight * paramacu.NkX.targetWidth));
      paramacu.NkX.targetWidth = k;
      paramacu.NkX.targetHeight = j;
      break label1272;
      j = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vKA, 720);
      Log.i("MicroMsg.VLogCompositionBlendExporter", "checkTargetSize: config ".concat(String.valueOf(j)));
      if (paramacu.NkX.targetWidth <= j) {
        break label1272;
      }
      k = d.WV((int)(j * 1.0F / paramacu.NkX.targetWidth * paramacu.NkX.targetHeight));
      paramacu.NkX.targetWidth = j;
      paramacu.NkX.targetHeight = k;
      break label1272;
      localObject1 = null;
      break label1345;
      localObject1 = null;
      break label1368;
      j = 0;
      break label1471;
      localObject1 = null;
      break label1476;
      j = 0;
      break label1484;
    }
    label2191:
    label2221:
    final String str1 = u.n(str2, true);
    if (str1 == null) {
      p.iCn();
    }
    p.j(str1, "VFSFileOp.exportExternalPath(path, true)!!");
    final long l1 = Util.currentTicks();
    int i = ((j.b)localObject4).audioSampleRate;
    int j = ((j.b)localObject4).audioChannelCount;
    localac.audioSampleRate = i;
    localac.audioChannelCount = j;
    if (localac.NmV)
    {
      Log.i("MicroMsg.VLogCompositionBlendExporter", "enable video enhancement");
      localObject1 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
      com.tencent.mm.plugin.vlog.model.local.a.gtW();
    }
    com.tencent.mm.videocomposition.j localj = localac.getComposition();
    long l2 = Util.ticksToNow(l1);
    Object localObject5 = (Iterable)localj.MQY;
    localObject1 = (Collection)new ArrayList();
    localObject5 = ((Iterable)localObject5).iterator();
    label2407:
    while (((Iterator)localObject5).hasNext())
    {
      Object localObject6 = ((Iterator)localObject5).next();
      if (((com.tencent.mm.videocomposition.b)localObject6).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label2407;
        }
        ((Collection)localObject1).add(localObject6);
        break;
      }
    }
    label2570:
    label2575:
    if (((List)localObject1).size() == 1)
    {
      localObject1 = (Iterable)localj.MQY;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
        break label2786;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label2786;
      }
      if (((com.tencent.mm.videocomposition.b)((Iterator)localObject1).next()).type != 1) {
        break label2780;
      }
      i = 1;
      label2496:
      if (i == 0) {
        break label2784;
      }
      i = 0;
      label2504:
      if (i != 0)
      {
        Log.i("MicroMsg.VLogCompositionBlendExporter", "export only one video, check colorSpace");
        localObject5 = ((Iterable)localj.MQY).iterator();
        label2536:
        if (!((Iterator)localObject5).hasNext()) {
          break label2798;
        }
        localObject1 = ((Iterator)localObject5).next();
        if (((com.tencent.mm.videocomposition.b)localObject1).type != 2) {
          break label2792;
        }
        i = 1;
        if (i == 0) {
          break label2796;
        }
        localObject1 = (com.tencent.mm.videocomposition.b)localObject1;
        if (localObject1 != null)
        {
          localObject5 = com.tencent.mm.plugin.vlog.remux.f.NqU;
          com.tencent.mm.plugin.vlog.remux.f.a(((com.tencent.mm.videocomposition.b)localObject1).path, (j.b)localObject4);
          localObject1 = x.aazN;
        }
      }
    }
    paramb = (m)new b(this, paramacu, l1, l2, localac, (j.b)localObject4, localEffectManager, localacv, (aa.a)localObject2, str1, localc, (aa.f)localObject3, str2, locall, paramb);
    paramacu = paramacu.Sou;
    p.j(paramacu, "compositionInfo.tracks");
    paramacu = (Iterable)paramacu;
    if ((!(paramacu instanceof Collection)) || (!((Collection)paramacu).isEmpty()))
    {
      paramacu = paramacu.iterator();
      label2688:
      if (paramacu.hasNext())
      {
        localObject1 = (eth)paramacu.next();
        if (u.agG(((eth)localObject1).path))
        {
          i = 1;
          label2722:
          if (i != 0) {
            break label2835;
          }
        }
      }
    }
    float f;
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        break label2843;
      }
      Log.w("MicroMsg.VLogCompositionBlendExporter", "failed due to file deleted");
      locall.uTW = false;
      paramb.invoke(Boolean.FALSE, Integer.valueOf(10001));
      f = localc.aaBz;
      AppMethodBeat.o(229048);
      return f;
      label2780:
      i = 0;
      break label2496;
      label2784:
      break;
      label2786:
      i = 1;
      break label2504;
      label2792:
      i = 0;
      break label2570;
      label2796:
      break label2536;
      label2798:
      localObject1 = null;
      break label2575;
      Log.i("MicroMsg.VLogCompositionBlendExporter", "file deleted " + ((eth)localObject1).path);
      i = 0;
      break label2722;
      label2835:
      break label2688;
    }
    label2843:
    if (((aa.a)localObject2).aaBx) {
      localj.b(str1, (j.b)localObject4, (AssetWriterVideoEncoder)new h(), paramb, this.NkN);
    }
    for (;;)
    {
      f = localc.aaBz;
      AppMethodBeat.o(229048);
      return f;
      localj.a(str1, (j.b)localObject4, paramb, this.NkN);
    }
  }
  
  public final void a(boolean paramBoolean, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(228968);
    p.k(paramVideoTransPara, "videoTransPara");
    this.NkM = paramBoolean;
    this.EZB = paramVideoTransPara;
    AppMethodBeat.o(228968);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter$Companion;", "", "()V", "ErrCodeInputFileInvalid", "", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "invoke"})
  static final class b
    extends q
    implements m<Boolean, Integer, x>
  {
    b(f paramf, acu paramacu, long paramLong1, long paramLong2, ac paramac, j.b paramb, EffectManager paramEffectManager, acv paramacv, aa.a parama, String paramString1, aa.c paramc, aa.f paramf1, String paramString2, l paraml, kotlin.g.a.b paramb1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.f
 * JD-Core Version:    0.7.0.1
 */