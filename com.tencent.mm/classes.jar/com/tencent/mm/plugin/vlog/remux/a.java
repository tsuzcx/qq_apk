package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.e;
import com.tencent.mm.media.d.h;
import com.tencent.mm.plugin.vlog.model.aj;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "(Ljava/util/List;)V", "curDecoderIndex", "", "curMaterialIndex", "currentAudioFrameInterval", "", "currentChannelCount", "currentPts", "currentSampleRate", "decoderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "Lkotlin/collections/ArrayList;", "defaultMediaFormat", "Landroid/media/MediaFormat;", "lastAudioFramePts", "getMaterials", "()Ljava/util/List;", "sendVideoFrameDataHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "sendVideoFrameDataThread", "Landroid/os/HandlerThread;", "dumpFakeMaterialDecodeData", "", "material", "getChannelCount", "getMediaFormat", "getSampleRate", "hasVideo", "", "onVideoFrameDecode", "pcmData", "", "pts", "index", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "startDecoder", "stopDecoder", "videoDecodeEnd", "decoder", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "Companion", "VideoDecoder", "plugin-vlog_release"})
public final class a
  extends e
{
  public static final c GCD;
  private long GCA;
  private long GCB;
  private long GCC;
  private ArrayList<d> GCs;
  private volatile int GCt;
  private volatile int GCu;
  private MMHandler GCv;
  private HandlerThread GCw;
  MediaFormat GCx;
  private volatile int GCy;
  private volatile int GCz;
  private final List<s> GzQ;
  
  static
  {
    AppMethodBeat.i(111019);
    GCD = new c((byte)0);
    AppMethodBeat.o(111019);
  }
  
  public a(final List<? extends s> paramList)
  {
    super(null, "background", -1L, -1L, null, null);
    AppMethodBeat.i(111018);
    this.GzQ = paramList;
    this.GCs = new ArrayList();
    this.GCy = 1;
    this.GCz = 44100;
    this.GCA = 23L;
    this.GCB = -1L;
    paramList = (Iterable)this.GzQ;
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      final s locals = (s)paramList;
      final com.tencent.mm.media.f.a locala;
      long l1;
      long l2;
      if ((locals instanceof aj))
      {
        locala = new com.tencent.mm.media.f.a(locals.path);
        paramList = locala.igi;
        if ((paramList != null) && (paramList.containsKey("frame-rate")))
        {
          int j = paramList.getInteger("frame-rate");
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "index:" + i + ", material:" + locals.path + ", audioFps:" + j);
        }
        l1 = ((aj)locals).GzW;
        l2 = locals.endTime - locals.startTime + l1;
        if (!com.tencent.mm.compatible.util.d.oE(23)) {
          break label417;
        }
      }
      label417:
      for (paramList = (e)new com.tencent.mm.media.d.g(locala, "background", l1, l2);; paramList = (e)new h(locala, "background", l1, l2))
      {
        paramList.iej = ((m)new a(i, locals, this));
        paramList.iek = ((kotlin.g.a.a)new b(i, locals, paramList, locala, this));
        this.GCs.add(new d(i, (aj)locals, paramList, locala, l1, l2));
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "add video decoder, index:" + i + ", material:" + locals.path + ", start:" + l1 + ',' + locals.startTime + ", end:" + l2 + ',' + locals.endTime);
        i += 1;
        break;
      }
    }
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, decoderList:" + this.GCs.size());
    if (fCr())
    {
      this.GCy = ((d)this.GCs.get(0)).GCL.getChannelCount();
      this.GCz = ((d)this.GCs.get(0)).GCL.getSampleRate();
      this.GCA = 23L;
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init currentChannelCount:" + this.GCy + ", currentSampleRate:" + this.GCz + ", currentAudioFrameInterval:" + this.GCA);
    }
    paramList = com.tencent.f.c.d.hB("VLogAudioBackgroundDecoder_sendVideoFrameDataThread", 5);
    p.g(paramList, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.GCw = paramList;
    this.GCw.start();
    this.GCv = new MMHandler(this.GCw.getLooper());
    paramList = new MediaFormat();
    paramList.setString("mime", "audio/mp4a-latm");
    paramList.setInteger("aac-profile", 2);
    paramList.setInteger("sample-rate", 44100);
    paramList.setInteger("channel-count", 1);
    paramList.setInteger("bitrate", 64000);
    paramList.setInteger("max-input-size", 16384);
    this.GCx = paramList;
    this.GCt = 0;
    this.GCu = 0;
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, defaultMediaFormat:" + this.GCx);
    AppMethodBeat.o(111018);
  }
  
  private final void a(int paramInt, s params, e parame, com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(111017);
    for (;;)
    {
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd, index:" + paramInt + ", material:" + params.path + ", currentPts:" + this.GCC);
      if (parame != null) {}
      try
      {
        parame.aMc();
        if (parama != null) {
          parama.release();
        }
        if (paramInt + 1 < this.GzQ.size())
        {
          params = (s)this.GzQ.get(paramInt + 1);
          this.GCu = (paramInt + 1);
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "nextMaterial:" + params.path);
          if ((params instanceof aj))
          {
            parame = ((Iterable)this.GCs).iterator();
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
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "find start next decoder index:" + (paramInt + 1) + ", hasAudio:" + params.ihK.aMp());
                    if (params.ihK.aMp()) {
                      break label374;
                    }
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "next material not have audio: " + params.GCK.path);
                    a((s)params.GCK);
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process mute video material, index:" + this.GCt);
                    a(this.GCu, (s)params.GCK, params.GCL, params.ihK);
                  }
                  this.GCt = (paramInt + 1);
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
          this.GCy = params.GCL.getChannelCount();
          this.GCz = params.GCL.getSampleRate();
          this.GCB = -1L;
          params.GCL.startDecoder();
        }
        if ((params instanceof com.tencent.mm.plugin.vlog.model.q))
        {
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "next material is image, startTime:" + params.startTime + ", endTime:" + params.endTime);
          a(params);
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process image material, index:" + this.GCt);
          paramInt = this.GCu;
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
    params = this.iek;
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
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "dumpFakeMaterialDecodeData, currentChannelCount:" + this.GCy + ", currentSampleRate:" + this.GCz + ", currentAudioFrameInterval:" + this.GCA);
    params = kotlin.k.j.a((kotlin.k.g)new i(params.startTime, params.endTime), this.GCA);
    long l1 = params.first;
    long l2 = params.SZc;
    long l3 = params.BMh;
    if (l3 >= 0L)
    {
      if (l1 > l2) {}
    }
    else {
      while (l1 >= l2) {
        for (;;)
        {
          this.GCv.post((Runnable)new e(this));
          if (l1 == l2) {
            break;
          }
          l1 += l3;
        }
      }
    }
    AppMethodBeat.o(111016);
  }
  
  public final void aMc()
  {
    AppMethodBeat.i(111015);
    Log.printInfoStack("MicroMsg.VLogAudioBackgroundDecoder", "stopDecoder, decoderStop:" + this.ied, new Object[0]);
    if (!this.ied)
    {
      Iterator localIterator = ((Iterable)this.GCs).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).GCL.aMc();
      }
      this.GCs.clear();
    }
    this.GCw.quitSafely();
    this.GCt = 0;
    this.GCu = 0;
    AppMethodBeat.o(111015);
  }
  
  public final boolean fCr()
  {
    AppMethodBeat.i(111013);
    if (!((Collection)this.GCs).isEmpty())
    {
      AppMethodBeat.o(111013);
      return true;
    }
    AppMethodBeat.o(111013);
    return false;
  }
  
  public final int getChannelCount()
  {
    return this.GCy;
  }
  
  public final int getSampleRate()
  {
    return this.GCz;
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(111014);
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "startDecoder: " + this.GCs.size());
    if (fCr())
    {
      this.GCC = 0L;
      this.GCu = 0;
      this.GCt = 0;
      s locals = (s)this.GzQ.get(0);
      if ((locals instanceof com.tencent.mm.plugin.vlog.model.q))
      {
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "firstMaterial is image, startTime:" + locals.startTime + ", endTime:" + locals.endTime);
        a(locals);
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first image material, index:" + this.GCt);
        a(this.GCu, locals, null, null);
        AppMethodBeat.o(111014);
        return;
      }
      if (((d)this.GCs.get(0)).ihK.aMp())
      {
        this.GCy = ((d)this.GCs.get(0)).GCL.getChannelCount();
        this.GCz = ((d)this.GCs.get(0)).GCL.getSampleRate();
        this.GCB = -1L;
        ((d)this.GCs.get(0)).GCL.startDecoder();
        AppMethodBeat.o(111014);
        return;
      }
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "first video not have audio:" + ((d)this.GCs.get(0)).GCK.path);
      a((s)((d)this.GCs.get(0)).GCK);
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first mute video material");
      a(this.GCu, (s)((d)this.GCs.get(0)).GCK, ((d)this.GCs.get(0)).GCL, ((d)this.GCs.get(0)).ihK);
    }
    AppMethodBeat.o(111014);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pcmData", "", "pts", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$2"})
  static final class a
    extends kotlin.g.b.q
    implements m<byte[], Long, x>
  {
    a(int paramInt, s params, a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$3"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(int paramInt, s params, e parame, com.tencent.mm.media.f.a parama, a parama1)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$Companion;", "", "()V", "DEFAULT_AUDIO_FRAME_INTERVAL", "", "TAG", "", "plugin-vlog_release"})
  public static final class c {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "", "index", "", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "decoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "startTime", "", "endTime", "(ILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Lcom/tencent/mm/media/decoder/IAudioDecoder;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;JJ)V", "getDecoder", "()Lcom/tencent/mm/media/decoder/IAudioDecoder;", "getEndTime", "()J", "getIndex", "()I", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "getMediaExtractor", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class d
  {
    final aj GCK;
    final e GCL;
    private final long endTime;
    final com.tencent.mm.media.f.a ihK;
    final int index;
    private final long startTime;
    
    public d(int paramInt, aj paramaj, e parame, com.tencent.mm.media.f.a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111007);
      this.index = paramInt;
      this.GCK = paramaj;
      this.GCL = parame;
      this.ihK = parama;
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
          if ((this.index != paramObject.index) || (!p.j(this.GCK, paramObject.GCK)) || (!p.j(this.GCL, paramObject.GCL)) || (!p.j(this.ihK, paramObject.ihK)) || (this.startTime != paramObject.startTime) || (this.endTime != paramObject.endTime)) {}
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
      Object localObject = this.GCK;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.GCL;
        if (localObject == null) {
          break label138;
        }
      }
      label138:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.ihK;
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
      String str = "VideoDecoder(index=" + this.index + ", material=" + this.GCK + ", decoder=" + this.GCL + ", mediaExtractor=" + this.ihK + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
      AppMethodBeat.o(111008);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(111011);
      int i = a.c(this.GCF);
      Object localObject = a.a(this.GCF);
      if (localObject != null) {
        ((m)localObject).invoke(new byte[i * 2048], Long.valueOf(a.b(this.GCF)));
      }
      localObject = this.GCF;
      a.a((a)localObject, a.b((a)localObject) + a.d(this.GCF) * 1000L);
      AppMethodBeat.o(111011);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, long paramLong, aj paramaj, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(111012);
      long l = this.ihy - this.GCN.GzW + this.GCN.startTime * 1000L;
      m localm = a.a(this.GCF);
      if (localm != null) {
        localm.invoke(this.GCO, Long.valueOf(l));
      }
      a.a(this.GCF, l);
      AppMethodBeat.o(111012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a
 * JD-Core Version:    0.7.0.1
 */