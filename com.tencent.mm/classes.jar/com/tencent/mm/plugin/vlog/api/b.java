package com.tencent.mm.plugin.vlog.api;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.sight.base.ABAPrams;
import com.tencent.mm.plugin.vlog.model.TAVKitMuxer;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ac.a;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.plugin.vlog.model.g.a;
import com.tencent.mm.plugin.vlog.parallel.TAVKitParallelHardwareMuxer;
import com.tencent.mm.plugin.vlog.parallel.TAVKitParallelSoftEncodeMuxer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.mm.videocomposition.c.e;
import com.tencent.mm.videocomposition.j.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.codec.DefaultMediaFactory;
import com.tencent.tav.codec.IDecoderFactory;
import com.tencent.tav.codec.IMediaFactory;
import com.tencent.tav.core.AssetParallelExportSession;
import com.tencent.tav.core.parallel.info.PipelineIndicatorInfo;
import com.tencent.tav.decoder.IEncoderFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.ah.a;
import kotlin.g.b.ah.c;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/api/CompositionVideoTranscoderImpl;", "Lcom/tencent/mm/modelvideo/CompositionVideoTranscoder;", "()V", "TAG", "", "alignN", "", "value", "align", "checkFixVideoParam", "", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "mediaInfo", "Lcom/tencent/mm/plugin/recordvideo/util/MultiMediaVideoChecker$VideoInfo;", "doExportReport", "errCode", "videoQuality", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "params", "Lcom/tencent/mm/modelvideo/CompositionVideoTranscodeParam;", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "exportCostTime", "", "outputPath", "maxParallelSize", "getMediaInfoJson", "transcodeVideo", "", "sourcePath", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelvideo/CompositionVideoTranscodeParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outputCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "succ", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.modelvideo.c
{
  final String TAG;
  
  public b()
  {
    AppMethodBeat.i(281177);
    this.TAG = s.X("MicroMsg.CompositionVideoTranscoderImpl@", Integer.valueOf(hashCode()));
    ac.a locala = ac.Uav;
    AppMethodBeat.o(281177);
  }
  
  public final boolean a(final String paramString1, final String paramString2, final com.tencent.mm.modelvideo.b paramb, final kotlin.g.a.b<? super Boolean, ah> paramb1)
  {
    AppMethodBeat.i(281201);
    s.u(paramString1, "sourcePath");
    s.u(paramString2, "outputPath");
    s.u(paramb, "params");
    s.u(paramb1, "outputCallback");
    Log.i(this.TAG, "transcodeVideo source:" + paramString1 + ", outputPath:" + paramString2 + ", params:" + paramb.oXZ + " parallel:" + paramb.oYd + ", softEncode:" + paramb.softEncode + ", outputHevc:" + paramb.oYa);
    if (!y.ZC(paramString1))
    {
      Log.i(this.TAG, "transcodeVideo source video not exist");
      AppMethodBeat.o(281201);
      return false;
    }
    if ((paramb.oXZ.videoBitrate <= 0) || (paramb.oXZ.width <= 0) || (paramb.oXZ.height <= 0))
    {
      Log.i(this.TAG, "transcodeVideo error videoParam");
      AppMethodBeat.o(281201);
      return false;
    }
    Object localObject1 = MultiMediaVideoChecker.ObB.cI(paramString1, true);
    Log.i(this.TAG, s.X("transcodeVideo source video info:", localObject1));
    if ((localObject1 == null) || (((MultiMediaVideoChecker.a)localObject1).width <= 0) || (((MultiMediaVideoChecker.a)localObject1).height <= 0))
    {
      Log.i(this.TAG, "transcodeVideo source video info not valid");
      AppMethodBeat.o(281201);
      return false;
    }
    Object localObject2 = paramb.oXZ;
    if (((VideoTransPara)localObject2).nCd <= 0) {
      ((VideoTransPara)localObject2).nCd = 1;
    }
    if (((VideoTransPara)localObject2).fps <= 0) {
      ((VideoTransPara)localObject2).fps = ((int)((MultiMediaVideoChecker.a)localObject1).eGw);
    }
    if (((VideoTransPara)localObject2).audioBitrate <= 0) {
      ((VideoTransPara)localObject2).audioBitrate = ((MultiMediaVideoChecker.a)localObject1).audioBitrate;
    }
    if (((VideoTransPara)localObject2).audioSampleRate <= 0) {
      ((VideoTransPara)localObject2).audioSampleRate = ((MultiMediaVideoChecker.a)localObject1).audioSampleRate;
    }
    if (((VideoTransPara)localObject2).audioChannelCount <= 0) {
      ((VideoTransPara)localObject2).audioChannelCount = ((MultiMediaVideoChecker.a)localObject1).audioChannelCount;
    }
    Log.i(this.TAG, s.X("after fix videoParam:", paramb.oXZ));
    localObject2 = new com.tencent.mm.videocomposition.b(paramString1, 2);
    ((com.tencent.mm.videocomposition.b)localObject2).setVolume(1.0F);
    label472:
    Object localObject3;
    int i;
    label583:
    int j;
    label609:
    Object localObject5;
    if ((paramb.startTimeMs >= 0L) && (paramb.endTimeMs > 0L))
    {
      ((com.tencent.mm.videocomposition.b)localObject2).wB(paramb.startTimeMs);
      ((com.tencent.mm.videocomposition.b)localObject2).wC(paramb.endTimeMs);
      localObject2 = new com.tencent.mm.videocomposition.j(p.listOf(localObject2));
      if ((((MultiMediaVideoChecker.a)localObject1).audioBitrate > 0) && (((MultiMediaVideoChecker.a)localObject1).audioChannelCount > 0) && (((MultiMediaVideoChecker.a)localObject1).audioSampleRate > 0) && (!paramb.nLP)) {
        break label796;
      }
      ((com.tencent.mm.videocomposition.j)localObject2).FO(false);
      ((com.tencent.mm.videocomposition.j)localObject2).agDT = ((com.tencent.mm.videocomposition.a.b)new com.tencent.mm.videocomposition.a.a((com.tencent.mm.videocomposition.a.c)new com.tencent.mm.ca.a.a(paramb.oXZ.audioSampleRate, paramb.oXZ.audioChannelCount)));
      localObject3 = paramb.nBp;
      if (localObject3 != null)
      {
        localObject4 = new EffectManager();
        ((com.tencent.mm.videocomposition.j)localObject2).UbK = ((EffectManager)localObject4);
        ((com.tencent.mm.videocomposition.j)localObject2).a((e)new com.tencent.mm.plugin.vlog.model.d((kotlin.g.a.b)localObject3, (EffectManager)localObject4));
      }
      if ((((MultiMediaVideoChecker.a)localObject1).hYK != 0) && (((MultiMediaVideoChecker.a)localObject1).hYK != 180)) {
        break label805;
      }
      i = ((MultiMediaVideoChecker.a)localObject1).width;
      if ((((MultiMediaVideoChecker.a)localObject1).hYK != 0) && (((MultiMediaVideoChecker.a)localObject1).hYK != 180)) {
        break label815;
      }
      j = ((MultiMediaVideoChecker.a)localObject1).height;
      ((com.tencent.mm.videocomposition.j)localObject2).pk(i, j);
      ((com.tencent.mm.videocomposition.j)localObject2).L(new Rect(0, 0, i, j));
      j = paramb.oXZ.width;
      i = paramb.oXZ.height;
      localObject3 = new ah.c();
      if (!paramb.oYb) {
        break label978;
      }
      localObject1 = (Iterable)((com.tencent.mm.videocomposition.j)localObject2).TDz;
      localObject4 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject1).iterator();
    }
    label796:
    label805:
    label815:
    label829:
    for (;;)
    {
      label704:
      if (!((Iterator)localObject5).hasNext()) {
        break label831;
      }
      localObject1 = (com.tencent.mm.videocomposition.b)((Iterator)localObject5).next();
      if (((com.tencent.mm.videocomposition.b)localObject1).type == 2) {}
      for (localObject1 = new com.tencent.mm.plugin.vlog.model.b(((com.tencent.mm.videocomposition.b)localObject1).path, ((com.tencent.mm.videocomposition.b)localObject1).TDw, ((com.tencent.mm.videocomposition.b)localObject1).TDx);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label829;
        }
        ((Collection)localObject4).add(localObject1);
        break label704;
        ((com.tencent.mm.videocomposition.b)localObject2).wB(0L);
        ((com.tencent.mm.videocomposition.b)localObject2).wC(((com.tencent.mm.videocomposition.b)localObject2).UjZ);
        break;
        ((com.tencent.mm.videocomposition.j)localObject2).FO(true);
        break label472;
        i = ((MultiMediaVideoChecker.a)localObject1).height;
        break label583;
        j = ((MultiMediaVideoChecker.a)localObject1).width;
        break label609;
      }
    }
    label831:
    localObject1 = (List)localObject4;
    Object localObject4 = com.tencent.mm.plugin.vlog.model.c.TXW;
    localObject1 = com.tencent.mm.plugin.vlog.model.c.a((List)localObject1, paramb.oXZ, paramb.oXZ.width, paramb.oXZ.height, false, paramb.oYc);
    paramb.oXZ.width = ((com.tencent.mm.plugin.vlog.model.a)localObject1).width;
    paramb.oXZ.height = ((com.tencent.mm.plugin.vlog.model.a)localObject1).height;
    Log.i(this.TAG, "transcodeVideo abaResult:" + localObject1 + ", scene:" + paramb.oYc);
    if (((com.tencent.mm.plugin.vlog.model.a)localObject1).Gbz != null)
    {
      ((ah.c)localObject3).aixa = ((com.tencent.mm.plugin.vlog.model.a)localObject1).Gbz.qualityLevel;
      Log.i(this.TAG, s.X("export videoQuality: ", Float.valueOf(((ah.c)localObject3).aixa)));
    }
    label978:
    int k;
    if (paramb.softEncode)
    {
      localObject1 = g.TYF;
      localObject1 = new Size(j, i);
      s.u(localObject1, "size");
      k = g.a.apx(((Size)localObject1).getWidth());
      j = ((Size)localObject1).getHeight();
      i = j;
      if (j % 2 != 0) {
        i = j + 1;
      }
      localObject1 = new Size(k, i);
      j = ((Size)localObject1).getWidth();
      i = ((Size)localObject1).getHeight();
    }
    for (;;)
    {
      Log.i(this.TAG, "after process, output size:[" + j + ',' + i + "] parallel:" + paramb.oYd.oZL + " soft:" + paramb.softEncode);
      localObject1 = y.n(paramString2, true);
      if (localObject1 != null) {
        if (((CharSequence)localObject1).length() != 0) {
          break label1177;
        }
      }
      label1177:
      for (k = 1; k != 0; k = 0)
      {
        AppMethodBeat.o(281201);
        return false;
      }
      localObject4 = new j.b(new Size(j, i), paramb.oXZ.videoBitrate, paramb.oXZ.fps, paramb.oXZ.nCd, paramb.oXZ.audioBitrate, paramb.oXZ.audioSampleRate, paramb.oXZ.audioChannelCount, true, paramb.oYa, (byte)0);
      if (paramb.softEncode)
      {
        Log.i(this.TAG, "softEncode, not need correct size");
        ((j.b)localObject4).correctSizeByCodecCapabilities = false;
      }
      ((j.b)localObject4).agDX = false;
      localObject5 = com.tencent.mm.util.j.agtw;
      com.tencent.mm.util.j.a(paramString1, (j.b)localObject4);
      long l = Util.currentTicks();
      localObject5 = new ah.a();
      paramString1 = new ah.d();
      paramString1.aixb = -1;
      paramString2 = (m)new c(l, this, (ah.a)localObject5, (com.tencent.mm.videocomposition.j)localObject2, (ah.c)localObject3, paramb, (j.b)localObject4, paramString2, paramString1, paramb1);
      if (paramb.oYd.oZL) {
        if (paramb.softEncode)
        {
          ((com.tencent.mm.videocomposition.j)localObject2).mediaFactory = ((IMediaFactory)new DefaultMediaFactory((IEncoderFactory)new com.tencent.mm.plugin.vlog.encoder.b(true, true), (IDecoderFactory)new com.tencent.mm.plugin.vlog.decoder.d((byte)0)));
          paramb1 = TAVKitParallelSoftEncodeMuxer.UcP;
          TAVKitParallelSoftEncodeMuxer.setup();
          ((j.b)localObject4).suggestParallelCount = paramb.oYd.oZM;
          paramb = new ah.f();
          paramb.aqH = ((com.tencent.mm.videocomposition.j)localObject2).a((String)localObject1, (j.b)localObject4, (q)new a(paramString2), (kotlin.g.a.b)new b(paramb, paramString1));
        }
      }
      for (;;)
      {
        AppMethodBeat.o(281201);
        return true;
        paramb1 = TAVKitParallelHardwareMuxer.UcN;
        TAVKitParallelHardwareMuxer.setup();
        break;
        if (paramb.softEncode)
        {
          paramString1 = TAVKitMuxer.Uam;
          TAVKitMuxer.setup();
          ((com.tencent.mm.videocomposition.j)localObject2).mediaFactory = ((IMediaFactory)new DefaultMediaFactory((IEncoderFactory)new com.tencent.mm.plugin.vlog.encoder.b(true, true), (IDecoderFactory)new com.tencent.mm.plugin.vlog.decoder.d((byte)0)));
          com.tencent.mm.videocomposition.j.b((com.tencent.mm.videocomposition.j)localObject2, (String)localObject1, (j.b)localObject4, paramString2);
        }
        else
        {
          paramString1 = TAVKitMuxer.Uam;
          TAVKitMuxer.setup();
          com.tencent.mm.videocomposition.j.a((com.tencent.mm.videocomposition.j)localObject2, (String)localObject1, (j.b)localObject4, paramString2);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "result", "", "errCode", "", "<anonymous parameter 2>", "Ljava/util/ArrayList;", "Lcom/tencent/tav/core/parallel/info/PipelineIndicatorInfo;", "Lkotlin/collections/ArrayList;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements q<Boolean, Integer, ArrayList<PipelineIndicatorInfo>, ah>
  {
    a(m<? super Boolean, ? super Integer, ah> paramm)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<Float, ah>
  {
    b(ah.f<AssetParallelExportSession> paramf, ah.d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errCode", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Boolean, Integer, ah>
  {
    c(long paramLong, b paramb, ah.a parama, com.tencent.mm.videocomposition.j paramj, ah.c paramc, com.tencent.mm.modelvideo.b paramb1, j.b paramb2, String paramString, ah.d paramd, kotlin.g.a.b<? super Boolean, ah> paramb3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.api.b
 * JD-Core Version:    0.7.0.1
 */