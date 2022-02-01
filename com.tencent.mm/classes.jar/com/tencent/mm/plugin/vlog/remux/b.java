package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.e;
import com.tencent.mm.media.d.g;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.k.f;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "(Ljava/util/List;)V", "curDecoderIndex", "", "curMaterialIndex", "currentAudioFrameInterval", "", "currentChannelCount", "currentPts", "currentSampleRate", "decoderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "Lkotlin/collections/ArrayList;", "defaultMediaFormat", "Landroid/media/MediaFormat;", "lastAudioFramePts", "getMaterials", "()Ljava/util/List;", "sendVideoFrameDataHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "sendVideoFrameDataThread", "Landroid/os/HandlerThread;", "dumpFakeMaterialDecodeData", "", "material", "getChannelCount", "getMediaFormat", "getSampleRate", "hasVideo", "", "onVideoFrameDecode", "pcmData", "", "pts", "index", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "startDecoder", "stopDecoder", "videoDecodeEnd", "decoder", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "Companion", "VideoDecoder", "plugin-vlog_release"})
public final class b
  extends e
{
  public static final c Nqo;
  private final List<s> Nnw;
  private ArrayList<d> Nqd;
  private volatile int Nqe;
  private volatile int Nqf;
  private MMHandler Nqg;
  private HandlerThread Nqh;
  MediaFormat Nqi;
  private volatile int Nqj;
  private volatile int Nqk;
  private long Nql;
  private long Nqm;
  private long Nqn;
  
  static
  {
    AppMethodBeat.i(111019);
    Nqo = new c((byte)0);
    AppMethodBeat.o(111019);
  }
  
  public b(final List<? extends s> paramList)
  {
    super(null, "background", -1L, -1L, null, null);
    AppMethodBeat.i(111018);
    this.Nnw = paramList;
    this.Nqd = new ArrayList();
    this.Nqj = 1;
    this.Nqk = 44100;
    this.Nql = 23L;
    this.Nqm = -1L;
    paramList = (Iterable)this.Nnw;
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      final s locals = (s)paramList;
      final com.tencent.mm.media.f.a locala;
      long l1;
      long l2;
      if ((locals instanceof aj))
      {
        locala = new com.tencent.mm.media.f.a(locals.path);
        paramList = locala.kUW;
        if ((paramList != null) && (paramList.containsKey("frame-rate")))
        {
          int j = paramList.getInteger("frame-rate");
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "index:" + i + ", material:" + locals.path + ", audioFps:" + j);
        }
        l1 = ((aj)locals).NnC;
        l2 = locals.endTime - locals.startTime + l1;
        if (!com.tencent.mm.compatible.util.d.qW(23)) {
          break label417;
        }
      }
      label417:
      for (paramList = (e)new g(locala, "background", l1, l2);; paramList = (e)new com.tencent.mm.media.d.h(locala, "background", l1, l2))
      {
        paramList.kSX = ((m)new a(i, locals, this));
        paramList.kSY = ((kotlin.g.a.a)new b(i, locals, paramList, locala, this));
        this.Nqd.add(new d(i, (aj)locals, paramList, locala, l1, l2));
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "add video decoder, index:" + i + ", material:" + locals.path + ", start:" + l1 + ',' + locals.startTime + ", end:" + l2 + ',' + locals.endTime);
        i += 1;
        break;
      }
    }
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, decoderList:" + this.Nqd.size());
    if (guq())
    {
      this.Nqj = ((d)this.Nqd.get(0)).Nqw.aUo();
      this.Nqk = ((d)this.Nqd.get(0)).Nqw.getSampleRate();
      this.Nql = 23L;
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init currentChannelCount:" + this.Nqj + ", currentSampleRate:" + this.Nqk + ", currentAudioFrameInterval:" + this.Nql);
    }
    paramList = com.tencent.e.c.d.il("VLogAudioBackgroundDecoder_sendVideoFrameDataThread", 5);
    p.j(paramList, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.Nqh = paramList;
    this.Nqh.start();
    this.Nqg = new MMHandler(this.Nqh.getLooper());
    paramList = new MediaFormat();
    paramList.setString("mime", "audio/mp4a-latm");
    paramList.setInteger("aac-profile", 2);
    paramList.setInteger("sample-rate", 44100);
    paramList.setInteger("channel-count", 1);
    paramList.setInteger("bitrate", 64000);
    paramList.setInteger("max-input-size", 16384);
    this.Nqi = paramList;
    this.Nqe = 0;
    this.Nqf = 0;
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, defaultMediaFormat:" + this.Nqi);
    AppMethodBeat.o(111018);
  }
  
  private final void a(int paramInt, s params, e parame, com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(111017);
    for (;;)
    {
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd, index:" + paramInt + ", material:" + params.path + ", currentPts:" + this.Nqn);
      if (parame != null) {}
      try
      {
        parame.aUn();
        if (parama != null) {
          parama.release();
        }
        if (paramInt + 1 < this.Nnw.size())
        {
          params = (s)this.Nnw.get(paramInt + 1);
          this.Nqf = (paramInt + 1);
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "nextMaterial:" + params.path);
          if ((params instanceof aj))
          {
            parame = ((Iterable)this.Nqd).iterator();
            for (;;)
            {
              if (parame.hasNext())
              {
                params = parame.next();
                if (((d)params).index == paramInt + 1)
                {
                  i = 1;
                  if (i == 0) {
                    continue;
                  }
                  params = (d)params;
                  if (params != null)
                  {
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "find start next decoder index:" + (paramInt + 1) + ", hasAudio:" + params.kWy.aUF());
                    if (params.kWy.aUF()) {
                      break label374;
                    }
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "next material not have audio: " + params.Nqv.path);
                    a((s)params.Nqv);
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process mute video material, index:" + this.Nqe);
                    a(this.Nqf, (s)params.Nqv, params.Nqw, params.kWy);
                  }
                  this.Nqe = (paramInt + 1);
                  AppMethodBeat.o(111017);
                }
              }
            }
          }
        }
      }
      catch (Exception params)
      {
        for (;;)
        {
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd release decoder and extractor error");
          continue;
          int i = 0;
          continue;
          params = null;
          continue;
          label374:
          this.Nqj = params.Nqw.aUo();
          this.Nqk = params.Nqw.getSampleRate();
          this.Nqm = -1L;
          params.Nqw.startDecoder();
        }
        if ((params instanceof com.tencent.mm.plugin.vlog.model.q))
        {
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "next material is image, startTime:" + params.startTime + ", endTime:" + params.endTime);
          a(params);
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process image material, index:" + this.Nqe);
          paramInt = this.Nqf;
          parama = null;
          parame = null;
        }
        else
        {
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "cannot find next material");
          AppMethodBeat.o(111017);
          return;
        }
      }
    }
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish decode all material");
    params = this.kSY;
    if (params != null)
    {
      params.invoke();
      AppMethodBeat.o(111017);
      return;
    }
    AppMethodBeat.o(111017);
  }
  
  private final void a(s params)
  {
    AppMethodBeat.i(111016);
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "dumpFakeMaterialDecodeData, currentChannelCount:" + this.Nqj + ", currentSampleRate:" + this.Nqk + ", currentAudioFrameInterval:" + this.Nql);
    params = i.a((f)new kotlin.k.h(params.startTime, params.endTime), this.Nql);
    long l1 = params.first;
    long l2 = params.aaBW;
    long l3 = params.HIt;
    if (l3 >= 0L)
    {
      if (l1 > l2) {}
    }
    else {
      while (l1 >= l2) {
        for (;;)
        {
          this.Nqg.post((Runnable)new e(this));
          if (l1 == l2) {
            break;
          }
          l1 += l3;
        }
      }
    }
    AppMethodBeat.o(111016);
  }
  
  public final void aUn()
  {
    AppMethodBeat.i(111015);
    Log.printInfoStack("MicroMsg.VLogAudioBackgroundDecoder", "stopDecoder, decoderStop:" + this.kSO, new Object[0]);
    if (!this.kSO)
    {
      Iterator localIterator = ((Iterable)this.Nqd).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).Nqw.aUn();
      }
      this.Nqd.clear();
    }
    this.Nqh.quitSafely();
    this.Nqe = 0;
    this.Nqf = 0;
    AppMethodBeat.o(111015);
  }
  
  public final int aUo()
  {
    return this.Nqj;
  }
  
  public final int getSampleRate()
  {
    return this.Nqk;
  }
  
  public final boolean guq()
  {
    AppMethodBeat.i(111013);
    if (!((Collection)this.Nqd).isEmpty())
    {
      AppMethodBeat.o(111013);
      return true;
    }
    AppMethodBeat.o(111013);
    return false;
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(111014);
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "startDecoder: " + this.Nqd.size());
    if (guq())
    {
      this.Nqn = 0L;
      this.Nqf = 0;
      this.Nqe = 0;
      s locals = (s)this.Nnw.get(0);
      if ((locals instanceof com.tencent.mm.plugin.vlog.model.q))
      {
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "firstMaterial is image, startTime:" + locals.startTime + ", endTime:" + locals.endTime);
        a(locals);
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first image material, index:" + this.Nqe);
        a(this.Nqf, locals, null, null);
        AppMethodBeat.o(111014);
        return;
      }
      if (((d)this.Nqd.get(0)).kWy.aUF())
      {
        this.Nqj = ((d)this.Nqd.get(0)).Nqw.aUo();
        this.Nqk = ((d)this.Nqd.get(0)).Nqw.getSampleRate();
        this.Nqm = -1L;
        ((d)this.Nqd.get(0)).Nqw.startDecoder();
        AppMethodBeat.o(111014);
        return;
      }
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "first video not have audio:" + ((d)this.Nqd.get(0)).Nqv.path);
      a((s)((d)this.Nqd.get(0)).Nqv);
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first mute video material");
      a(this.Nqf, (s)((d)this.Nqd.get(0)).Nqv, ((d)this.Nqd.get(0)).Nqw, ((d)this.Nqd.get(0)).kWy);
    }
    AppMethodBeat.o(111014);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pcmData", "", "pts", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$2"})
  static final class a
    extends kotlin.g.b.q
    implements m<byte[], Long, x>
  {
    a(int paramInt, s params, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$3"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(int paramInt, s params, e parame, com.tencent.mm.media.f.a parama, b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$Companion;", "", "()V", "DEFAULT_AUDIO_FRAME_INTERVAL", "", "TAG", "", "plugin-vlog_release"})
  public static final class c {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "", "index", "", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "decoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "startTime", "", "endTime", "(ILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Lcom/tencent/mm/media/decoder/IAudioDecoder;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;JJ)V", "getDecoder", "()Lcom/tencent/mm/media/decoder/IAudioDecoder;", "getEndTime", "()J", "getIndex", "()I", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "getMediaExtractor", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class d
  {
    final aj Nqv;
    final e Nqw;
    private final long endTime;
    final int index;
    final com.tencent.mm.media.f.a kWy;
    private final long startTime;
    
    public d(int paramInt, aj paramaj, e parame, com.tencent.mm.media.f.a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111007);
      this.index = paramInt;
      this.Nqv = paramaj;
      this.Nqw = parame;
      this.kWy = parama;
      this.startTime = paramLong1;
      this.endTime = paramLong2;
      AppMethodBeat.o(111007);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111010);
      if (this != paramObject)
      {
        if ((paramObject instanceof d))
        {
          paramObject = (d)paramObject;
          if ((this.index != paramObject.index) || (!p.h(this.Nqv, paramObject.Nqv)) || (!p.h(this.Nqw, paramObject.Nqw)) || (!p.h(this.kWy, paramObject.kWy)) || (this.startTime != paramObject.startTime) || (this.endTime != paramObject.endTime)) {}
        }
      }
      else
      {
        AppMethodBeat.o(111010);
        return true;
      }
      AppMethodBeat.o(111010);
      return false;
    }
    
    public final int hashCode()
    {
      int k = 0;
      AppMethodBeat.i(111009);
      int m = this.index;
      Object localObject = this.Nqv;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.Nqw;
        if (localObject == null) {
          break label138;
        }
      }
      label138:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.kWy;
        if (localObject != null) {
          k = localObject.hashCode();
        }
        long l = this.startTime;
        int n = (int)(l ^ l >>> 32);
        l = this.endTime;
        int i1 = (int)(l ^ l >>> 32);
        AppMethodBeat.o(111009);
        return (((j + (i + m * 31) * 31) * 31 + k) * 31 + n) * 31 + i1;
        i = 0;
        break;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111008);
      String str = "VideoDecoder(index=" + this.index + ", material=" + this.Nqv + ", decoder=" + this.Nqw + ", mediaExtractor=" + this.kWy + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
      AppMethodBeat.o(111008);
      return str;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(111011);
      int i = b.c(this.Nqq);
      Object localObject = b.a(this.Nqq);
      if (localObject != null) {
        ((m)localObject).invoke(new byte[i * 2048], Long.valueOf(b.b(this.Nqq)));
      }
      localObject = this.Nqq;
      b.a((b)localObject, b.b((b)localObject) + b.d(this.Nqq) * 1000L);
      AppMethodBeat.o(111011);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(b paramb, long paramLong, aj paramaj, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(111012);
      long l = this.kWm - this.Nqx.NnC + this.Nqx.startTime * 1000L;
      m localm = b.a(this.Nqq);
      if (localm != null) {
        localm.invoke(this.Nqy, Long.valueOf(l));
      }
      b.a(this.Nqq, l);
      AppMethodBeat.o(111012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.b
 * JD-Core Version:    0.7.0.1
 */