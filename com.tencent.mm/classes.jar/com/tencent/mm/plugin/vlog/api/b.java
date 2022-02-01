package com.tencent.mm.plugin.vlog.api;

import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ac.a;
import com.tencent.mm.plugin.vlog.model.d;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.plugin.vlog.model.h.a;
import com.tencent.mm.plugin.vlog.remux.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import com.tencent.mm.videocomposition.j.b;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tav.decoder.AssetWriterVideoEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.c;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/api/CompositionVideoTranscoderImpl;", "Lcom/tencent/mm/modelvideo/CompositionVideoTranscoder;", "()V", "TAG", "", "alignN", "", "value", "align", "checkFixVideoParam", "", "videoParam", "Lcom/tencent/mm/modelcontrol/VideoTransPara;", "mediaInfo", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaVideoChecker$VideoInfo;", "doExportReport", "errCode", "videoQuality", "", "composition", "Lcom/tencent/mm/videocomposition/VideoComposition;", "params", "Lcom/tencent/mm/modelvideo/CompositionVideoTranscodeParam;", "config", "Lcom/tencent/mm/videocomposition/VideoComposition$VideoOutputConfig;", "exportCostTime", "", "outputPath", "getMediaInfoJson", "transcodeVideo", "", "sourcePath", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/modelvideo/CompositionVideoTranscodeParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "outputCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "succ", "plugin-vlog_release"})
public final class b
  implements com.tencent.mm.modelvideo.c
{
  final String TAG;
  
  public b()
  {
    AppMethodBeat.i(228935);
    this.TAG = ("MicroMsg.CompositionVideoTranscoderImpl@" + hashCode());
    ac.a locala = ac.NmY;
    AppMethodBeat.o(228935);
  }
  
  public final boolean a(String paramString1, final String paramString2, final com.tencent.mm.modelvideo.b paramb, final kotlin.g.a.b<? super Boolean, x> paramb1)
  {
    AppMethodBeat.i(228934);
    p.k(paramString1, "sourcePath");
    p.k(paramString2, "outputPath");
    p.k(paramb, "params");
    p.k(paramb1, "outputCallback");
    Log.i(this.TAG, "transcodeVideo source:" + paramString1 + ", outputPath:" + paramString2 + ", params:" + paramb.mfk + ", softEncode:" + paramb.softEncode + ", outputHevc:" + paramb.mfh);
    if (!u.agG(paramString1))
    {
      Log.i(this.TAG, "transcodeVideo source video not exist");
      AppMethodBeat.o(228934);
      return false;
    }
    if ((paramb.mfk.videoBitrate <= 0) || (paramb.mfk.width <= 0) || (paramb.mfk.height <= 0))
    {
      Log.i(this.TAG, "transcodeVideo error videoParam");
      AppMethodBeat.o(228934);
      return false;
    }
    Object localObject1 = MultiMediaVideoChecker.NmA.cO(paramString1, true);
    Log.i(this.TAG, "transcodeVideo source video info:".concat(String.valueOf(localObject1)));
    if ((localObject1 == null) || (((MultiMediaVideoChecker.a)localObject1).width <= 0) || (((MultiMediaVideoChecker.a)localObject1).height <= 0))
    {
      Log.i(this.TAG, "transcodeVideo source video info not valid");
      AppMethodBeat.o(228934);
      return false;
    }
    Object localObject2 = paramb.mfk;
    if (((VideoTransPara)localObject2).kXt <= 0) {
      ((VideoTransPara)localObject2).kXt = 1;
    }
    if (((VideoTransPara)localObject2).fps <= 0) {
      ((VideoTransPara)localObject2).fps = ((int)((MultiMediaVideoChecker.a)localObject1).cLa);
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
    Log.i(this.TAG, "after fix videoParam:" + paramb.mfk);
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
      ((com.tencent.mm.videocomposition.b)localObject2).Sn(paramb.startTimeMs);
      ((com.tencent.mm.videocomposition.b)localObject2).So(paramb.endTimeMs);
      localObject2 = new com.tencent.mm.videocomposition.j(kotlin.a.j.listOf(localObject2));
      if ((((MultiMediaVideoChecker.a)localObject1).audioBitrate > 0) && (((MultiMediaVideoChecker.a)localObject1).audioChannelCount > 0) && (((MultiMediaVideoChecker.a)localObject1).audioSampleRate > 0) && (!paramb.lhf)) {
        break label802;
      }
      ((com.tencent.mm.videocomposition.j)localObject2).Ap(false);
      ((com.tencent.mm.videocomposition.j)localObject2).YIm = ((com.tencent.mm.videocomposition.a.b)new com.tencent.mm.videocomposition.a.a((com.tencent.mm.videocomposition.a.c)new d(paramb.mfk.audioSampleRate, paramb.mfk.audioChannelCount)));
      localObject3 = paramb.kVT;
      if (localObject3 != null)
      {
        localObject4 = new EffectManager();
        ((com.tencent.mm.videocomposition.j)localObject2).Noe = ((EffectManager)localObject4);
        ((com.tencent.mm.videocomposition.j)localObject2).a((com.tencent.mm.videocomposition.b.e)new com.tencent.mm.plugin.vlog.model.e((kotlin.g.a.b)localObject3, (EffectManager)localObject4));
      }
      if ((((MultiMediaVideoChecker.a)localObject1).fSM != 0) && (((MultiMediaVideoChecker.a)localObject1).fSM != 180)) {
        break label811;
      }
      i = ((MultiMediaVideoChecker.a)localObject1).width;
      if ((((MultiMediaVideoChecker.a)localObject1).fSM != 0) && (((MultiMediaVideoChecker.a)localObject1).fSM != 180)) {
        break label821;
      }
      j = ((MultiMediaVideoChecker.a)localObject1).height;
      ((com.tencent.mm.videocomposition.j)localObject2).nn(i, j);
      ((com.tencent.mm.videocomposition.j)localObject2).D(new Rect(0, 0, i, j));
      j = paramb.mfk.width;
      i = paramb.mfk.height;
      localObject3 = new aa.c();
      ((aa.c)localObject3).aaBz = 0.0F;
      if (!paramb.mfi) {
        break label1002;
      }
      localObject1 = (Iterable)((com.tencent.mm.videocomposition.j)localObject2).MQY;
      localObject4 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject1).iterator();
    }
    label802:
    label811:
    label821:
    label835:
    for (;;)
    {
      label710:
      if (!((Iterator)localObject5).hasNext()) {
        break label837;
      }
      localObject1 = (com.tencent.mm.videocomposition.b)((Iterator)localObject5).next();
      if (((com.tencent.mm.videocomposition.b)localObject1).type == 2) {}
      for (localObject1 = new com.tencent.mm.plugin.vlog.model.b(((com.tencent.mm.videocomposition.b)localObject1).path, ((com.tencent.mm.videocomposition.b)localObject1).MQV, ((com.tencent.mm.videocomposition.b)localObject1).MQW);; localObject1 = null)
      {
        if (localObject1 == null) {
          break label835;
        }
        ((Collection)localObject4).add(localObject1);
        break label710;
        ((com.tencent.mm.videocomposition.b)localObject2).Sn(0L);
        ((com.tencent.mm.videocomposition.b)localObject2).So(((com.tencent.mm.videocomposition.b)localObject2).NwS);
        break;
        ((com.tencent.mm.videocomposition.j)localObject2).Ap(true);
        break label472;
        i = ((MultiMediaVideoChecker.a)localObject1).height;
        break label583;
        j = ((MultiMediaVideoChecker.a)localObject1).width;
        break label609;
      }
    }
    label837:
    localObject1 = (List)localObject4;
    Object localObject4 = com.tencent.mm.plugin.vlog.model.c.NkB;
    localObject1 = com.tencent.mm.plugin.vlog.model.c.a((List)localObject1, paramb.mfk, paramb.mfk.width, paramb.mfk.height, false, paramb.mfj);
    paramb.mfk.width = ((com.tencent.mm.plugin.vlog.model.a)localObject1).width;
    paramb.mfk.height = ((com.tencent.mm.plugin.vlog.model.a)localObject1).height;
    Log.i(this.TAG, "transcodeVideo abaResult:" + localObject1 + ", scene:" + paramb.mfj);
    if ((((com.tencent.mm.plugin.vlog.model.a)localObject1).Azu != null) && (((com.tencent.mm.plugin.vlog.model.a)localObject1).Azu.length >= 28))
    {
      ((aa.c)localObject3).aaBz = localObject1.Azu[27];
      Log.i(this.TAG, "export videoQuality: " + ((aa.c)localObject3).aaBz);
    }
    label1002:
    if (paramb.softEncode)
    {
      localObject1 = h.Nlm;
      localObject1 = h.a.a(new Size(j, i));
      j = ((Size)localObject1).getWidth();
      i = ((Size)localObject1).getHeight();
    }
    for (;;)
    {
      Log.i(this.TAG, "after process, output size:[" + j + ',' + i + ']');
      localObject1 = u.n(paramString2, true);
      if (localObject1 != null) {
        if (((CharSequence)localObject1).length() != 0) {
          break label1125;
        }
      }
      label1125:
      for (int k = 1; k != 0; k = 0)
      {
        AppMethodBeat.o(228934);
        return false;
      }
      localObject4 = new j.b(new Size(j, i), paramb.mfk.videoBitrate, paramb.mfk.fps, paramb.mfk.kXt, paramb.mfk.audioBitrate, paramb.mfk.audioSampleRate, paramb.mfk.audioChannelCount, true, paramb.mfh);
      if (paramb.softEncode)
      {
        Log.i(this.TAG, "softEncode, not need correct size");
        ((j.b)localObject4).correctSizeByCodecCapabilities = false;
      }
      localObject5 = f.NqU;
      f.a(paramString1, (j.b)localObject4);
      final long l = Util.currentTicks();
      paramString1 = new aa.a();
      paramString1.aaBx = false;
      paramString1 = (m)new a(this, l, paramString1, (com.tencent.mm.videocomposition.j)localObject2, (aa.c)localObject3, paramb, (j.b)localObject4, paramString2, paramb1);
      if (paramb.softEncode) {
        com.tencent.mm.videocomposition.j.a((com.tencent.mm.videocomposition.j)localObject2, (String)localObject1, (j.b)localObject4, (AssetWriterVideoEncoder)new h(), paramString1);
      }
      for (;;)
      {
        AppMethodBeat.o(228934);
        return true;
        com.tencent.mm.videocomposition.j.a((com.tencent.mm.videocomposition.j)localObject2, (String)localObject1, (j.b)localObject4, paramString1);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "errCode", "", "invoke"})
  static final class a
    extends q
    implements m<Boolean, Integer, x>
  {
    a(b paramb, long paramLong, aa.a parama, com.tencent.mm.videocomposition.j paramj, aa.c paramc, com.tencent.mm.modelvideo.b paramb1, j.b paramb2, String paramString, kotlin.g.a.b paramb3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.api.b
 * JD-Core Version:    0.7.0.1
 */