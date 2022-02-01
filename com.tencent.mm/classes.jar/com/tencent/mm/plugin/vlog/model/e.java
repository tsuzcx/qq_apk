package com.tencent.mm.plugin.vlog.model;

import android.graphics.Rect;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.VideoCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.vlog.parallel.TAVKitParallelHardwareMuxer;
import com.tencent.mm.protocal.protobuf.afa;
import com.tencent.mm.protocal.protobuf.afb;
import com.tencent.mm.protocal.protobuf.afc;
import com.tencent.mm.protocal.protobuf.dzm;
import com.tencent.mm.protocal.protobuf.enx;
import com.tencent.mm.protocal.protobuf.fos;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.j.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.codec.DefaultMediaFactory;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.codec.IMediaFactory;
import com.tencent.tav.codec.MediaCodecAnalyse;
import com.tencent.tav.codec.MediaCodecAnalyse.Companion;
import com.tencent.tav.core.AssetExportSession;
import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.decoder.DecoderUtils;
import com.tencent.tav.decoder.IEncoderFactory;
import com.tencent.tav.extractor.AssetExtractor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.c;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/CompositionExporter;", "", "()V", "background", "", "getBackground", "()Z", "setBackground", "(Z)V", "calculateAba", "decodeFactory", "Lcom/tencent/mm/plugin/vlog/decoder/SoftDecodeFactory;", "getDecodeFactory", "()Lcom/tencent/mm/plugin/vlog/decoder/SoftDecodeFactory;", "encodeFactory", "Lcom/tencent/mm/plugin/vlog/encoder/SoftEncoderFactory;", "getEncodeFactory", "()Lcom/tencent/mm/plugin/vlog/encoder/SoftEncoderFactory;", "exportingComposition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "lastOutputCode", "", "progressCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "progress", "", "reportScene", "getReportScene", "()I", "setReportScene", "(I)V", "resultCallback", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;", "retryCount", "getRetryCount", "setRetryCount", "retryOutputResult", "Ljava/util/LinkedList;", "tryParallel", "getTryParallel", "setTryParallel", "videoTransPara", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "cancel", "callback", "Lkotlin/Function0;", "checkAudioInfo", "outputConfig", "Lcom/tencent/mm/protocal/protobuf/CompositionOutputConfig;", "checkAudioSoftDecode", "audioTrySoft", "checkFallbackConfig", "lastResult", "checkFallbackSize", "compositionInfo", "Lcom/tencent/mm/protocal/protobuf/CompositionInfo;", "checkTargetSize", "export", "longVideo", "exportImpl", "getMediaInfoJson", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "packageMediaCodecCapabilities", "Lorg/json/JSONArray;", "packageSingleMediaCodecInfo", "Lorg/json/JSONObject;", "info", "Landroid/media/MediaCodecInfo;", "mime", "width", "height", "performanceReporter", "Lcom/tencent/mm/autogen/mmdata/rpt/VideoCompositionPerformanceStruct;", "key", "reportStartExport", "outputPath", "softEncode", "resize2Even", "value", "resizeToMultipleOfX", "x", "setCalculateAdaptiveBitrate", "enable", "setProgressCallback", "setupConfig", "setupOutputConfig", "config", "getReportKey", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final e.a TXZ;
  private static final LinkedList<String> TYk;
  private VideoTransPara KVn;
  public boolean TYa;
  boolean TYb;
  final com.tencent.mm.plugin.vlog.decoder.d TYc;
  final com.tencent.mm.plugin.vlog.encoder.b TYd;
  private int TYe;
  private final LinkedList<Integer> TYf;
  private boolean TYg;
  private kotlin.g.a.b<? super Float, ah> TYh;
  private kotlin.g.a.b<? super k, ah> TYi;
  private com.tencent.mm.videocomposition.j TYj;
  public int retryCount;
  public int ybL;
  
  static
  {
    AppMethodBeat.i(283606);
    TXZ = new e.a((byte)0);
    TYk = new LinkedList();
    AppMethodBeat.o(283606);
  }
  
  public e()
  {
    AppMethodBeat.i(283424);
    this.retryCount = 1;
    this.TYa = true;
    this.TYb = true;
    this.TYc = new com.tencent.mm.plugin.vlog.decoder.d((byte)0);
    this.TYd = new com.tencent.mm.plugin.vlog.encoder.b();
    this.TYf = new LinkedList();
    AppMethodBeat.o(283424);
  }
  
  static boolean FM(boolean paramBoolean)
  {
    AppMethodBeat.i(283451);
    boolean bool = false;
    if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztV, true))
    {
      Log.i("MicroMsg.CompositionExporter", "exportImpl: audio soft enable");
      bool = true;
    }
    if ((!bool) && (paramBoolean) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.ztW, true))) {
      Log.i("MicroMsg.CompositionExporter", "exportImpl: audio soft fallback");
    }
    for (paramBoolean = true;; paramBoolean = bool)
    {
      AppMethodBeat.o(283451);
      return paramBoolean;
    }
  }
  
  private static void a(ac paramac, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(283492);
    paramac = (List)paramac.TDz;
    Object localObject2 = (Iterable)paramac;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label94:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((ad)localObject3).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label94;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(((ad)((Iterator)localObject2).next()).path);
    }
    localObject1 = (List)localObject1;
    localObject2 = com.tencent.mm.plugin.vlog.model.report.a.Uch;
    int i = paramac.size();
    if (((List)localObject1).size() < paramac.size()) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.plugin.vlog.model.report.a.bY(i, bool);
      paramac = com.tencent.mm.plugin.vlog.model.report.a.Uch;
      com.tencent.mm.plugin.vlog.model.report.a.c((List)localObject1, paramString, paramBoolean);
      AppMethodBeat.o(283492);
      return;
    }
  }
  
  private static void a(afb paramafb)
  {
    AppMethodBeat.i(283477);
    j localj = j.TYR;
    int i = j.hQp();
    Log.i("MicroMsg.CompositionExporter", "checkTargetSize: origin " + paramafb.TYB.nxO + ", " + paramafb.TYB.nxP + ", type " + i);
    paramafb.TYB.Znt = i;
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(283477);
      return;
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zaV, 1920);
      if (paramafb.TYB.nxP > i)
      {
        int j = com.tencent.mm.plugin.mmsight.d.aaX((int)(i * 1.0F / paramafb.TYB.nxP * paramafb.TYB.nxO));
        paramafb.TYB.nxO = j;
        paramafb.TYB.nxP = i;
        AppMethodBeat.o(283477);
        return;
        i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zaU, 720);
        Log.i("MicroMsg.CompositionExporter", s.X("checkTargetSize: config ", Integer.valueOf(i)));
        if (paramafb.TYB.nxO > i)
        {
          j = com.tencent.mm.plugin.mmsight.d.aaX((int)(i * 1.0F / paramafb.TYB.nxO * paramafb.TYB.nxP));
          paramafb.TYB.nxO = i;
          paramafb.TYB.nxP = j;
        }
      }
    }
  }
  
  private static void a(afc paramafc)
  {
    if (paramafc.Znv != null)
    {
      paramafc.nxO = paramafc.Znv.nxO;
      paramafc.nxP = paramafc.Znv.nxP;
    }
    while (paramafc.Znw == null) {
      return;
    }
    paramafc.nxO = paramafc.Znw.nxO;
    paramafc.nxP = paramafc.Znw.nxP;
  }
  
  public static String b(afb paramafb)
  {
    AppMethodBeat.i(283504);
    s.u(paramafb, "<this>");
    String str = paramafb.editId;
    if (str == null)
    {
      paramafb = paramafb.TYB.outputPath;
      s.s(paramafb, "outputConfig.outputPath");
      AppMethodBeat.o(283504);
      return paramafb;
    }
    AppMethodBeat.o(283504);
    return str;
  }
  
  private static void b(afc paramafc)
  {
    AppMethodBeat.i(283458);
    Log.i("MicroMsg.CompositionExporter", "export: has music, audio info " + paramafc.audioBitrate + ", " + paramafc.audioSampleRate + ", " + paramafc.audioChannelCount);
    if (paramafc.audioBitrate == 0) {
      paramafc.audioBitrate = 128000;
    }
    if (paramafc.audioSampleRate < 44100) {
      paramafc.audioSampleRate = 44100;
    }
    if (paramafc.audioChannelCount == 0) {
      paramafc.audioChannelCount = 1;
    }
    AppMethodBeat.o(283458);
  }
  
  public static JSONArray c(afb paramafb)
  {
    AppMethodBeat.i(283519);
    s.u(paramafb, "compositionInfo");
    String str = ((fos)paramafb.Zng.get(0)).path;
    paramafb = new JSONArray();
    if (!y.ZC(str))
    {
      AppMethodBeat.o(283519);
      return paramafb;
    }
    Object localObject1 = new AssetExtractor();
    ((AssetExtractor)localObject1).setDataSource(str);
    int i = DecoderUtils.getFirstTrackIndex((AssetExtractor)localObject1, "video/");
    if (i < 0)
    {
      AppMethodBeat.o(283519);
      return paramafb;
    }
    ((AssetExtractor)localObject1).selectTrack(i);
    localObject1 = ((AssetExtractor)localObject1).getTrackFormat(i);
    s.s(localObject1, "extractor.getTrackFormat(trackIndex)");
    str = ((MediaFormat)localObject1).getString("mime");
    if (((MediaFormat)localObject1).containsKey("width"))
    {
      i = ((MediaFormat)localObject1).getInteger("width");
      if (!((MediaFormat)localObject1).containsKey("height")) {
        break label185;
      }
    }
    label185:
    for (int j = ((MediaFormat)localObject1).getInteger("height");; j = 0)
    {
      if (!TextUtils.isEmpty((CharSequence)str)) {
        break label190;
      }
      AppMethodBeat.o(283519);
      return paramafb;
      i = 0;
      break;
    }
    label190:
    int i1 = MediaCodecList.getCodecCount();
    if (i1 > 0) {}
    int m;
    for (int k = 0;; k = m)
    {
      m = k + 1;
      Object localObject2 = MediaCodecList.getCodecInfoAt(k);
      localObject1 = ((MediaCodecInfo)localObject2).getSupportedTypes();
      int i2 = localObject1.length - 1;
      if (i2 >= 0) {}
      int n;
      for (k = 0;; k = n)
      {
        n = k + 1;
        if (n.T(localObject1[k], str, true))
        {
          s.s(localObject2, "codecInfo");
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("encode", ((MediaCodecInfo)localObject2).isEncoder());
          localObject2 = ((MediaCodecInfo)localObject2).getCapabilitiesForType(str);
          if (Build.VERSION.SDK_INT >= 23) {
            ((JSONObject)localObject1).put("maxSupportedInstances", ((MediaCodecInfo.CodecCapabilities)localObject2).getMaxSupportedInstances());
          }
          localObject2 = ((MediaCodecInfo.CodecCapabilities)localObject2).getVideoCapabilities();
          ((JSONObject)localObject1).put("bitRange", ((MediaCodecInfo.VideoCapabilities)localObject2).getBitrateRange().toString());
          ((JSONObject)localObject1).put("frameRange", ((MediaCodecInfo.VideoCapabilities)localObject2).getSupportedFrameRates().toString());
          if (((MediaCodecInfo.VideoCapabilities)localObject2).isSizeSupported(i, j))
          {
            ((JSONObject)localObject1).put("sizeFrame", ((MediaCodecInfo.VideoCapabilities)localObject2).getSupportedFrameRatesFor(i, j));
            paramafb.put(localObject1);
          }
        }
        while (n > i2) {
          while (m >= i1)
          {
            AppMethodBeat.o(283519);
            return paramafb;
            ((JSONObject)localObject1).put("sizeSupported", false);
          }
        }
      }
    }
  }
  
  private static int er(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283435);
    if (paramInt1 <= paramInt2)
    {
      AppMethodBeat.o(283435);
      return paramInt2;
    }
    Integer localInteger = Integer.valueOf(paramInt2 - 1 & paramInt1);
    if (((Number)localInteger).intValue() != 0)
    {
      i = 1;
      if (i == 0) {
        break label61;
      }
    }
    for (;;)
    {
      if (localInteger != null) {
        break label66;
      }
      AppMethodBeat.o(283435);
      return paramInt1;
      i = 0;
      break;
      label61:
      localInteger = null;
    }
    label66:
    int i = ((Number)localInteger).intValue();
    if (i * 2 > paramInt2)
    {
      AppMethodBeat.o(283435);
      return paramInt2 + (paramInt1 - i);
    }
    AppMethodBeat.o(283435);
    return paramInt1 - i;
  }
  
  public final float a(final afb paramafb, final kotlin.g.a.b<? super k, ah> paramb)
  {
    AppMethodBeat.i(283657);
    s.u(paramafb, "compositionInfo");
    s.u(paramb, "callback");
    Log.i("MicroMsg.CompositionExporter", s.X("start export, retryCount:", Integer.valueOf(this.retryCount)));
    final k localk = new k(false, false, false, 127);
    Object localObject3 = paramafb.TYB;
    s.s(localObject3, "outputConfig");
    a((afc)localObject3);
    Object localObject4 = new EffectManager();
    Object localObject2 = h.d(paramafb, (EffectManager)localObject4);
    Log.i("MicroMsg.CompositionExporter", "outputScale: " + ((afc)localObject3).Znq + ", enableExport1080WidescreenVideo: " + w.hQU());
    Object localObject5;
    int j;
    int k;
    if ((((afc)localObject3).Znq > 1.0F) && (w.hQU()))
    {
      Log.i("MicroMsg.CompositionExporter", "ready to enlarge resolution");
      ((afc)localObject3).nxO = er((int)(((afc)localObject3).nxO * ((afc)localObject3).Znq), 16);
      ((afc)localObject3).nxP = er((int)(((afc)localObject3).nxP * ((afc)localObject3).Znq), 4);
      localObject1 = ((Iterable)((ac)localObject2).TDz).iterator();
      while (((Iterator)localObject1).hasNext()) {
        com.tencent.mm.videocomposition.h.b(((ad)((Iterator)localObject1).next()).UaI.Gl, ((afc)localObject3).Znq);
      }
      localObject1 = ((ac)localObject2).Uaw.jLW();
      ((ac)localObject2).mu((int)(((Size)localObject1).getWidth() * ((afc)localObject3).Znq), (int)(((Size)localObject1).getHeight() * ((afc)localObject3).Znq));
      localObject1 = ((afc)localObject3).Znw;
      if (localObject1 != null)
      {
        localObject1 = ((dzm)localObject1).Zqq;
        if (localObject1 != null)
        {
          localObject5 = ((enx)localObject1).aaTg.get(0);
          s.s(localObject5, "cropRectProto.values[0]");
          i = ((Number)localObject5).intValue();
          localObject5 = ((enx)localObject1).aaTg.get(1);
          s.s(localObject5, "cropRectProto.values[1]");
          j = ((Number)localObject5).intValue();
          localObject5 = ((enx)localObject1).aaTg.get(2);
          s.s(localObject5, "cropRectProto.values[2]");
          k = ((Number)localObject5).intValue();
          localObject1 = ((enx)localObject1).aaTg.get(3);
          s.s(localObject1, "cropRectProto.values[3]");
          localObject1 = new Rect(i, j, k, ((Number)localObject1).intValue());
          com.tencent.mm.videocomposition.h.b((Rect)localObject1, ((afc)localObject3).Znq);
          ((ac)localObject2).F((Rect)localObject1);
          Log.i("MicroMsg.CompositionExporter", s.X("enlarge cropRect:", localObject1));
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
      }
      ((afc)localObject3).Znq = 1.0F;
      Log.i("MicroMsg.CompositionExporter", "enlarge done, targetWidth:" + ((afc)localObject3).nxO + ", targetHeight:" + ((afc)localObject3).nxP + ", renderSize:" + ((ac)localObject2).Uaw.jLW() + ", outputSize:" + ((ac)localObject2).Uaw.jLX());
    }
    label636:
    boolean bool2;
    label645:
    label658:
    label746:
    label753:
    Object localObject6;
    label827:
    label857:
    final ah.f localf;
    if (!Util.isNullOrNil(paramafb.nBT))
    {
      i = 1;
      if ((this.ybL != 1) && (this.ybL != 2)) {
        break label1423;
      }
      l1 = ((ac)localObject2).Uaw.getDurationMs();
      j = com.tencent.mm.modelcontrol.e.bIg().bIn().duration * 1000;
      if (!((afc)localObject3).oYa) {
        break label1405;
      }
      if (l1 <= j) {
        break label1399;
      }
      bool1 = true;
      bool1 = w.t(bool1, l1);
      if (!((afc)localObject3).oYa) {
        break label1411;
      }
      bool2 = w.hQP();
      Log.i("MicroMsg.CompositionExporter", "enableHevcSoft:" + bool1 + ", enableHevcHard:" + bool2 + ", durationMs:" + l1 + ", longVideoDurationLimit:" + j);
      localObject1 = this.TYd;
      if ((!this.TYd.TXC) && ((!((afc)localObject3).oYa) || (!bool1))) {
        break label1417;
      }
      bool1 = true;
      ((com.tencent.mm.plugin.vlog.encoder.b)localObject1).TXC = bool1;
      localObject1 = ((afc)localObject3).outputPath;
      s.s(localObject1, "outputConfig.outputPath");
      a((ac)localObject2, (String)localObject1, this.TYd.TXC);
      localObject5 = new ah.c();
      if ((this.TYg) && (this.KVn != null))
      {
        if (!this.TYd.TXC) {
          break label1512;
        }
        if (((afc)localObject3).oYa != true) {
          break label1506;
        }
        j = 1;
        if (j == 0) {
          break label1512;
        }
        Log.i("MicroMsg.CompositionExporter", "start calculate aba set soft hevc encode");
        localObject1 = this.KVn;
        if (localObject1 != null) {
          ((VideoTransPara)localObject1).oCh = 1;
        }
        localObject1 = f.TYz;
        localObject1 = this.KVn;
        s.checkNotNull(localObject1);
        j = ((afc)localObject3).nxO;
        k = ((afc)localObject3).nxP;
        localObject6 = paramafb.TYC.Znd;
        s.s(localObject6, "compositionInfo.editData.baseItemData");
        if (((Collection)localObject6).isEmpty()) {
          break label1559;
        }
        bool1 = true;
        label920:
        localObject1 = f.a.a((ac)localObject2, (VideoTransPara)localObject1, j, k, bool1);
        localObject6 = f.TYz;
        f.a.a((a)localObject1, (afc)localObject3);
        if (((a)localObject1).Gbz != null)
        {
          ((ah.c)localObject5).aixa = ((a)localObject1).Gbz.qualityLevel;
          Log.i("MicroMsg.CompositionExporter", s.X("export videoQuality: ", Float.valueOf(((ah.c)localObject5).aixa)));
        }
      }
      a(paramafb);
      Log.i("MicroMsg.CompositionExporter", "export: size " + ((afc)localObject3).nxO + ' ' + ((afc)localObject3).nxP);
      localf = new ah.f();
      localObject1 = paramafb.TYC;
      if (localObject1 != null) {
        break label1565;
      }
      localObject1 = null;
      label1054:
      if (localObject1 != null)
      {
        localObject1 = paramafb.TYC;
        if (localObject1 != null) {
          break label1575;
        }
        localObject1 = null;
        label1073:
        if (localObject1 != null)
        {
          localf.aqH = h.e(paramafb);
          ((ac)localObject2).aK((kotlin.g.a.b)localf.aqH);
          ((com.tencent.mm.plugin.recordvideo.ui.editor.b.c)localf.aqH).start();
        }
      }
      localObject1 = paramafb.Zng;
      s.s(localObject1, "compositionInfo.tracks");
      localObject6 = ((Iterable)localObject1).iterator();
      label1139:
      if (!((Iterator)localObject6).hasNext()) {
        break label1591;
      }
      localObject1 = ((Iterator)localObject6).next();
      if (((fos)localObject1).type != 3) {
        break label1585;
      }
      j = 1;
      label1173:
      if (j == 0) {
        break label1589;
      }
      label1178:
      if (localObject1 == null) {
        break label1597;
      }
      j = 1;
      label1186:
      if ((i != 0) || (j != 0)) {
        b((afc)localObject3);
      }
      if (this.TYd.TXC)
      {
        ((afc)localObject3).nxO = er(((afc)localObject3).nxO, 16);
        ((afc)localObject3).nxP = er(((afc)localObject3).nxP, 4);
      }
      if (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zpW, 1) != 1) {
        break label1603;
      }
    }
    final String str2;
    label1411:
    label1417:
    label1423:
    label1559:
    label1565:
    label1575:
    label1585:
    label1589:
    label1591:
    label1597:
    label1603:
    for (final boolean bool1 = true;; bool1 = false)
    {
      localObject6 = new j.b(new Size(((afc)localObject3).nxO, ((afc)localObject3).nxP), ((afc)localObject3).videoBitrate, ((afc)localObject3).fps, ((afc)localObject3).nCd, ((afc)localObject3).audioBitrate, ((afc)localObject3).audioSampleRate, ((afc)localObject3).audioChannelCount, bool1, ((afc)localObject3).oYa, (byte)0);
      str2 = ((afc)localObject3).outputPath;
      localObject1 = y.bEo(str2);
      if (!y.ZC((String)localObject1)) {
        y.bDX((String)localObject1);
      }
      if (y.bEp(str2)) {
        break label1609;
      }
      localk.success = false;
      localk.ygJ = false;
      paramb.invoke(localk);
      AppMethodBeat.o(283657);
      return 0.0F;
      i = 0;
      break;
      label1399:
      bool1 = false;
      break label636;
      label1405:
      bool1 = false;
      break label645;
      bool2 = false;
      break label658;
      bool1 = false;
      break label746;
      if ((!((afc)localObject3).oYa) || (this.ybL != 4)) {
        break label753;
      }
      localObject1 = com.tencent.mm.plugin.recordvideo.c.e.NGK;
      bool2 = com.tencent.mm.plugin.recordvideo.c.e.AU(true);
      localObject1 = this.TYd;
      if ((this.TYd.TXC) || (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        ((com.tencent.mm.plugin.vlog.encoder.b)localObject1).TXC = bool1;
        Log.i("MicroMsg.CompositionExporter", s.X("enableHevcSoft:", Boolean.valueOf(bool2)));
        break;
      }
      label1506:
      j = 0;
      break label827;
      label1512:
      if ((this.TYd.TXC) || (((afc)localObject3).oYa != true)) {
        break label857;
      }
      Log.i("MicroMsg.CompositionExporter", "start calculate aba set hevc hard encode");
      localObject1 = this.KVn;
      if (localObject1 == null) {
        break label857;
      }
      ((VideoTransPara)localObject1).oCh = 2;
      break label857;
      bool1 = false;
      break label920;
      localObject1 = ((afa)localObject1).Znc;
      break label1054;
      localObject1 = ((afa)localObject1).Znf;
      break label1073;
      j = 0;
      break label1173;
      break label1139;
      localObject1 = null;
      break label1178;
      j = 0;
      break label1186;
    }
    label1609:
    String str1 = y.n(str2, true);
    s.checkNotNull(str1);
    s.s(str1, "exportExternalPath(path, true)!!");
    final long l1 = Util.currentTicks();
    ((ac)localObject2).mv(((j.b)localObject6).audioSampleRate, ((j.b)localObject6).audioChannelCount);
    if (((ac)localObject2).Uay)
    {
      Log.i("MicroMsg.CompositionExporter", "enable video enhancement");
      localObject1 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
      com.tencent.mm.plugin.vlog.model.local.a.hRE();
    }
    com.tencent.mm.videocomposition.j localj = ((ac)localObject2).getComposition();
    this.TYj = localj;
    final long l2 = Util.ticksToNow(l1);
    Object localObject7 = (Iterable)localj.TDz;
    Object localObject1 = (Collection)new ArrayList();
    localObject7 = ((Iterable)localObject7).iterator();
    label1784:
    while (((Iterator)localObject7).hasNext())
    {
      localObject8 = ((Iterator)localObject7).next();
      if (((com.tencent.mm.videocomposition.b)localObject8).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1784;
        }
        ((Collection)localObject1).add(localObject8);
        break;
      }
    }
    label1946:
    label1951:
    if (((List)localObject1).size() == 1)
    {
      localObject1 = (Iterable)localj.TDz;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
        break label2319;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label2319;
      }
      if (((com.tencent.mm.videocomposition.b)((Iterator)localObject1).next()).type != 1) {
        break label2313;
      }
      i = 1;
      label1873:
      if (i == 0) {
        break label2317;
      }
      i = 0;
      label1881:
      if (i != 0)
      {
        Log.i("MicroMsg.CompositionExporter", "export only one video, check colorSpace");
        localObject7 = ((Iterable)localj.TDz).iterator();
        label1912:
        if (!((Iterator)localObject7).hasNext()) {
          break label2331;
        }
        localObject1 = ((Iterator)localObject7).next();
        if (((com.tencent.mm.videocomposition.b)localObject1).type != 2) {
          break label2325;
        }
        i = 1;
        if (i == 0) {
          break label2329;
        }
        localObject1 = (com.tencent.mm.videocomposition.b)localObject1;
        if (localObject1 != null)
        {
          localObject7 = com.tencent.mm.util.j.agtw;
          com.tencent.mm.util.j.a(((com.tencent.mm.videocomposition.b)localObject1).path, (j.b)localObject6);
          localObject1 = ah.aiuX;
          localObject1 = ah.aiuX;
        }
      }
    }
    final ah.d locald1 = new ah.d();
    locald1.aixb = 1;
    int i = MediaCodecAnalyse.Companion.instanceCount();
    final ah.d locald2 = new ah.d();
    localObject7 = new ah.f();
    Object localObject8 = new ah.f();
    localObject1 = (kotlin.g.a.b)new f((ah.f)localObject7, this, locald1, locald2);
    this.TYi = paramb;
    if (!this.TYb)
    {
      paramb = new r(Boolean.FALSE, Integer.valueOf(1));
      label2084:
      com.tencent.mm.plugin.vlog.model.config.a locala = com.tencent.mm.plugin.vlog.model.config.a.Ubv;
      bool1 = com.tencent.mm.plugin.vlog.model.config.a.g(paramafb);
      Log.i("MicroMsg.CompositionExporter", "checkEnableParallelExport:" + paramb + " isEdited:" + bool1);
      localObject3 = (q)new e(str1, locald1, l1, this, localk, paramafb, l2, (ac)localObject2, i, locald2, bool1, (ah.f)localObject7, (ah.f)localObject8, (j.b)localObject6, (EffectManager)localObject4, (afc)localObject3, localf, str2, paramb, (ah.c)localObject5);
      paramafb = paramafb.Zng;
      s.s(paramafb, "compositionInfo.tracks");
      paramafb = (Iterable)paramafb;
      if (((paramafb instanceof Collection)) && (((Collection)paramafb).isEmpty())) {
        break label2371;
      }
      paramafb = paramafb.iterator();
      label2220:
      if (!paramafb.hasNext()) {
        break label2371;
      }
      localObject4 = (fos)paramafb.next();
      if (!y.ZC(((fos)localObject4).path)) {
        break label2349;
      }
      i = 1;
      label2254:
      if (i != 0) {
        break label2369;
      }
    }
    float f;
    label2313:
    label2317:
    label2319:
    label2325:
    label2329:
    label2331:
    label2349:
    label2369:
    label2371:
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        break label2377;
      }
      Log.w("MicroMsg.CompositionExporter", "failed due to file deleted");
      localk.ygJ = false;
      ((q)localObject3).invoke(Boolean.FALSE, Integer.valueOf(10001), null);
      f = ((ah.c)localObject5).aixa;
      AppMethodBeat.o(283657);
      return f;
      i = 0;
      break label1873;
      break;
      i = 1;
      break label1881;
      i = 0;
      break label1946;
      break label1912;
      localObject1 = null;
      break label1951;
      paramb = com.tencent.mm.plugin.vlog.model.config.a.Ubv;
      paramb = com.tencent.mm.plugin.vlog.model.config.a.f(paramafb);
      break label2084;
      Log.i("MicroMsg.CompositionExporter", s.X("file deleted ", ((fos)localObject4).path));
      i = 0;
      break label2254;
      break label2220;
    }
    label2377:
    localObject2 = (Iterable)((ac)localObject2).TDz;
    paramafb = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label2465:
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      if (((ad)localObject4).type == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label2465;
        }
        paramafb.add(localObject4);
        break;
      }
    }
    paramafb = (Iterable)paramafb;
    if (!((Collection)paramafb).isEmpty())
    {
      paramafb = paramafb.iterator();
      if (paramafb.hasNext())
      {
        localObject2 = (ad)paramafb.next();
        localObject4 = MultiMediaVideoChecker.ObB.cI(((ad)localObject2).path, true);
        if ((localObject4 != null) && (((MultiMediaVideoChecker.a)localObject4).gLk()))
        {
          i = 1;
          label2544:
          if (i != 0) {
            break label2623;
          }
        }
      }
    }
    for (i = 0;; i = 1)
    {
      if (i != 0) {
        break label2631;
      }
      Log.w("MicroMsg.CompositionExporter", "failed due to video invalid");
      localk.ygJ = false;
      ((q)localObject3).invoke(Boolean.FALSE, Integer.valueOf(10002), null);
      f = ((ah.c)localObject5).aixa;
      AppMethodBeat.o(283657);
      return f;
      Log.i("MicroMsg.CompositionExporter", s.X("video invalid ", ((ad)localObject2).path));
      i = 0;
      break label2544;
      label2623:
      break;
    }
    label2631:
    Log.i("MicroMsg.CompositionExporter", "select parallel export result:" + ((Boolean)paramb.bsC).booleanValue() + " size:" + ((Number)paramb.bsD).intValue() + " retry count:" + this.retryCount + " videoSoftEncode:" + this.TYd.TXC);
    if ((!this.TYd.TXC) && (((Boolean)paramb.bsC).booleanValue()) && (this.retryCount <= 1))
    {
      Log.i("MicroMsg.CompositionExporter", "select parallel export");
      paramafb = TAVKitParallelHardwareMuxer.UcN;
      TAVKitParallelHardwareMuxer.setup();
      ((j.b)localObject6).suggestParallelCount = ((Number)paramb.bsD).intValue();
      ((j.b)localObject6).oYa = false;
      localj.mediaFactory = ((IMediaFactory)new DefaultMediaFactory((IEncoderFactory)this.TYd, (IDecoderFactory)this.TYc));
    }
    for (((ah.f)localObject7).aqH = localj.a(str1, (j.b)localObject6, (q)localObject3, (kotlin.g.a.b)localObject1);; ((ah.f)localObject8).aqH = localj.b(str1, (j.b)localObject6, bool1, (m)new e.d((q)localObject3), (kotlin.g.a.b)localObject1))
    {
      f = ((ah.c)localObject5).aixa;
      AppMethodBeat.o(283657);
      return f;
      Log.i("MicroMsg.CompositionExporter", "select single export");
      paramafb = TAVKitMuxer.Uam;
      TAVKitMuxer.setup();
      localj.mediaFactory = ((IMediaFactory)new DefaultMediaFactory((IEncoderFactory)this.TYd, (IDecoderFactory)this.TYc));
    }
  }
  
  public final void a(boolean paramBoolean, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(283612);
    s.u(paramVideoTransPara, "videoTransPara");
    this.TYg = paramBoolean;
    this.KVn = paramVideoTransPara;
    AppMethodBeat.o(283612);
  }
  
  public final void aJ(kotlin.g.a.b<? super Float, ah> paramb)
  {
    AppMethodBeat.i(283616);
    s.u(paramb, "callback");
    this.TYh = paramb;
    AppMethodBeat.o(283616);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/vlog/model/ExportResult;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<k, ah>
  {
    c(e parame, afb paramafb, kotlin.g.a.b<? super k, ah> paramb, ah.f<kotlin.g.a.b<k, ah>> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", "", "list", "Ljava/util/ArrayList;", "Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements q<Boolean, Integer, ArrayList<PipelineIndicatorInfo>, ah>
  {
    e(String paramString1, ah.d paramd1, long paramLong1, e parame, k paramk, afb paramafb, long paramLong2, ac paramac, int paramInt, ah.d paramd2, boolean paramBoolean, ah.f<AssetParallelExportSession> paramf, ah.f<AssetExportSession> paramf1, j.b paramb, EffectManager paramEffectManager, afc paramafc, ah.f<com.tencent.mm.plugin.recordvideo.ui.editor.b.c> paramf2, String paramString2, r<Boolean, Integer> paramr, ah.c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "progress", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    f(ah.f<AssetParallelExportSession> paramf, e parame, ah.d paramd1, ah.d paramd2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.e
 * JD-Core Version:    0.7.0.1
 */