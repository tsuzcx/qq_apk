package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ab;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "(Ljava/util/List;)V", "curDecoderIndex", "", "curMaterialIndex", "currentAudioFrameInterval", "", "currentChannelCount", "currentPts", "currentSampleRate", "decoderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "Lkotlin/collections/ArrayList;", "defaultMediaFormat", "Landroid/media/MediaFormat;", "lastAudioFramePts", "getMaterials", "()Ljava/util/List;", "sendVideoFrameDataHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "sendVideoFrameDataThread", "Landroid/os/HandlerThread;", "dumpFakeMaterialDecodeData", "", "material", "getChannelCount", "getMediaFormat", "getSampleRate", "hasVideo", "", "onVideoFrameDecode", "pcmData", "", "pts", "index", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "startDecoder", "stopDecoder", "videoDecodeEnd", "decoder", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "Companion", "VideoDecoder", "plugin-vlog_release"})
public final class a
  extends com.tencent.mm.media.d.e
{
  public static final c BJr;
  private final List<com.tencent.mm.plugin.vlog.model.l> BGM;
  private ArrayList<d> BJg;
  private volatile int BJh;
  private volatile int BJi;
  private ap BJj;
  private HandlerThread BJk;
  MediaFormat BJl;
  private volatile int BJm;
  private volatile int BJn;
  private long BJo;
  private long BJp;
  private long BJq;
  
  static
  {
    AppMethodBeat.i(111019);
    BJr = new c((byte)0);
    AppMethodBeat.o(111019);
  }
  
  public a(final List<? extends com.tencent.mm.plugin.vlog.model.l> paramList)
  {
    super(null, "background", -1L, -1L, null, null);
    AppMethodBeat.i(111018);
    this.BGM = paramList;
    this.BJg = new ArrayList();
    this.BJm = 1;
    this.BJn = 44100;
    this.BJo = 23L;
    this.BJp = -1L;
    paramList = (Iterable)this.BGM;
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        d.a.j.gfB();
      }
      final com.tencent.mm.plugin.vlog.model.l locall = (com.tencent.mm.plugin.vlog.model.l)paramList;
      final com.tencent.mm.media.f.a locala;
      long l1;
      long l2;
      if ((locall instanceof ab))
      {
        locala = new com.tencent.mm.media.f.a(locall.path);
        paramList = locala.hkb;
        if ((paramList != null) && (paramList.containsKey("frame-rate")))
        {
          int j = paramList.getInteger("frame-rate");
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "index:" + i + ", material:" + locall.path + ", audioFps:" + j);
        }
        l1 = ((ab)locall).BGQ;
        l2 = locall.endTime - locall.startTime + l1;
        if (!com.tencent.mm.compatible.util.d.lz(23)) {
          break label417;
        }
      }
      label417:
      for (paramList = (com.tencent.mm.media.d.e)new com.tencent.mm.media.d.g(locala, "background", l1, l2);; paramList = (com.tencent.mm.media.d.e)new com.tencent.mm.media.d.h(locala, "background", l1, l2))
      {
        paramList.hiz = ((m)new a(i, locall, this));
        paramList.hiA = ((d.g.a.a)new b(i, locall, paramList, locala, this));
        this.BJg.add(new d(i, (ab)locall, paramList, locala, l1, l2));
        ad.i("MicroMsg.VLogAudioBackgroundDecoder", "add video decoder, index:" + i + ", material:" + locall.path + ", start:" + l1 + ',' + locall.startTime + ", end:" + l2 + ',' + locall.endTime);
        i += 1;
        break;
      }
    }
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, decoderList:" + this.BJg.size());
    if (esL())
    {
      this.BJm = ((d)this.BJg.get(0)).BJz.getChannelCount();
      this.BJn = ((d)this.BJg.get(0)).BJz.getSampleRate();
      this.BJo = 23L;
      ad.i("MicroMsg.VLogAudioBackgroundDecoder", "init currentChannelCount:" + this.BJm + ", currentSampleRate:" + this.BJn + ", currentAudioFrameInterval:" + this.BJo);
    }
    paramList = com.tencent.e.c.d.gY("VLogAudioBackgroundDecoder_sendVideoFrameDataThread", 5);
    p.g(paramList, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.BJk = paramList;
    this.BJk.start();
    this.BJj = new ap(this.BJk.getLooper());
    paramList = new MediaFormat();
    paramList.setString("mime", "audio/mp4a-latm");
    paramList.setInteger("aac-profile", 2);
    paramList.setInteger("sample-rate", 44100);
    paramList.setInteger("channel-count", 1);
    paramList.setInteger("bitrate", 64000);
    paramList.setInteger("max-input-size", 16384);
    this.BJl = paramList;
    this.BJh = 0;
    this.BJi = 0;
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, defaultMediaFormat:" + this.BJl);
    AppMethodBeat.o(111018);
  }
  
  private final void a(int paramInt, com.tencent.mm.plugin.vlog.model.l paraml, com.tencent.mm.media.d.e parame, com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(111017);
    for (;;)
    {
      ad.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd, index:" + paramInt + ", material:" + paraml.path + ", currentPts:" + this.BJq);
      if (parame != null) {}
      try
      {
        parame.atm();
        if (parama != null) {
          parama.release();
        }
        if (paramInt + 1 < this.BGM.size())
        {
          paraml = (com.tencent.mm.plugin.vlog.model.l)this.BGM.get(paramInt + 1);
          this.BJi = (paramInt + 1);
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "nextMaterial:" + paraml.path);
          if ((paraml instanceof ab))
          {
            parame = ((Iterable)this.BJg).iterator();
            for (;;)
            {
              if (parame.hasNext())
              {
                paraml = parame.next();
                if (((d)paraml).index == paramInt + 1)
                {
                  i = 1;
                  if (i == 0) {
                    continue;
                  }
                  paraml = (d)paraml;
                  if (paraml != null)
                  {
                    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "find start next decoder index:" + (paramInt + 1) + ", hasAudio:" + paraml.hlB.aty());
                    if (paraml.hlB.aty()) {
                      break label374;
                    }
                    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "next material not have audio: " + paraml.BJy.path);
                    a((com.tencent.mm.plugin.vlog.model.l)paraml.BJy);
                    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process mute video material, index:" + this.BJh);
                    a(this.BJi, (com.tencent.mm.plugin.vlog.model.l)paraml.BJy, paraml.BJz, paraml.hlB);
                  }
                  this.BJh = (paramInt + 1);
                  AppMethodBeat.o(111017);
                }
              }
            }
          }
        }
      }
      catch (Exception paraml)
      {
        for (;;)
        {
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd release decoder and extractor error");
          continue;
          int i = 0;
          continue;
          paraml = null;
          continue;
          label374:
          this.BJm = paraml.BJz.getChannelCount();
          this.BJn = paraml.BJz.getSampleRate();
          this.BJp = -1L;
          paraml.BJz.startDecoder();
        }
        if ((paraml instanceof com.tencent.mm.plugin.vlog.model.j))
        {
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "next material is image, startTime:" + paraml.startTime + ", endTime:" + paraml.endTime);
          a(paraml);
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process image material, index:" + this.BJh);
          paramInt = this.BJi;
          parama = null;
          parame = null;
        }
        else
        {
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "cannot find next material");
          AppMethodBeat.o(111017);
          return;
        }
      }
    }
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish decode all material");
    paraml = this.hiA;
    if (paraml != null)
    {
      paraml.invoke();
      AppMethodBeat.o(111017);
      return;
    }
    AppMethodBeat.o(111017);
  }
  
  private final void a(com.tencent.mm.plugin.vlog.model.l paraml)
  {
    AppMethodBeat.i(111016);
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "dumpFakeMaterialDecodeData, currentChannelCount:" + this.BJm + ", currentSampleRate:" + this.BJn + ", currentAudioFrameInterval:" + this.BJo);
    paraml = d.k.h.a((d.k.e)new d.k.g(paraml.startTime, paraml.endTime), this.BJo);
    long l1 = paraml.first;
    long l2 = paraml.MMp;
    long l3 = paraml.xwe;
    if (l3 >= 0L)
    {
      if (l1 > l2) {}
    }
    else {
      while (l1 >= l2) {
        for (;;)
        {
          this.BJj.post((Runnable)new e(this));
          if (l1 == l2) {
            break;
          }
          l1 += l3;
        }
      }
    }
    AppMethodBeat.o(111016);
  }
  
  public final void atm()
  {
    AppMethodBeat.i(111015);
    ad.m("MicroMsg.VLogAudioBackgroundDecoder", "stopDecoder, decoderStop:" + this.his, new Object[0]);
    if (!this.his)
    {
      Iterator localIterator = ((Iterable)this.BJg).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).BJz.atm();
      }
      this.BJg.clear();
    }
    this.BJk.quitSafely();
    this.BJh = 0;
    this.BJi = 0;
    AppMethodBeat.o(111015);
  }
  
  public final boolean esL()
  {
    AppMethodBeat.i(111013);
    if (!((Collection)this.BJg).isEmpty())
    {
      AppMethodBeat.o(111013);
      return true;
    }
    AppMethodBeat.o(111013);
    return false;
  }
  
  public final int getChannelCount()
  {
    return this.BJm;
  }
  
  public final int getSampleRate()
  {
    return this.BJn;
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(111014);
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "startDecoder: " + this.BJg.size());
    if (esL())
    {
      this.BJq = 0L;
      this.BJi = 0;
      this.BJh = 0;
      com.tencent.mm.plugin.vlog.model.l locall = (com.tencent.mm.plugin.vlog.model.l)this.BGM.get(0);
      if ((locall instanceof com.tencent.mm.plugin.vlog.model.j))
      {
        ad.i("MicroMsg.VLogAudioBackgroundDecoder", "firstMaterial is image, startTime:" + locall.startTime + ", endTime:" + locall.endTime);
        a(locall);
        ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first image material, index:" + this.BJh);
        a(this.BJi, locall, null, null);
        AppMethodBeat.o(111014);
        return;
      }
      if (((d)this.BJg.get(0)).hlB.aty())
      {
        this.BJm = ((d)this.BJg.get(0)).BJz.getChannelCount();
        this.BJn = ((d)this.BJg.get(0)).BJz.getSampleRate();
        this.BJp = -1L;
        ((d)this.BJg.get(0)).BJz.startDecoder();
        AppMethodBeat.o(111014);
        return;
      }
      ad.i("MicroMsg.VLogAudioBackgroundDecoder", "first video not have audio:" + ((d)this.BJg.get(0)).BJy.path);
      a((com.tencent.mm.plugin.vlog.model.l)((d)this.BJg.get(0)).BJy);
      ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first mute video material");
      a(this.BJi, (com.tencent.mm.plugin.vlog.model.l)((d)this.BJg.get(0)).BJy, ((d)this.BJg.get(0)).BJz, ((d)this.BJg.get(0)).hlB);
    }
    AppMethodBeat.o(111014);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "pcmData", "", "pts", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$2"})
  static final class a
    extends q
    implements m<byte[], Long, z>
  {
    a(int paramInt, com.tencent.mm.plugin.vlog.model.l paraml, a parama)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$3"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(int paramInt, com.tencent.mm.plugin.vlog.model.l paraml, com.tencent.mm.media.d.e parame, com.tencent.mm.media.f.a parama, a parama1)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$Companion;", "", "()V", "DEFAULT_AUDIO_FRAME_INTERVAL", "", "TAG", "", "plugin-vlog_release"})
  public static final class c {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "", "index", "", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "decoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "startTime", "", "endTime", "(ILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Lcom/tencent/mm/media/decoder/IAudioDecoder;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;JJ)V", "getDecoder", "()Lcom/tencent/mm/media/decoder/IAudioDecoder;", "getEndTime", "()J", "getIndex", "()I", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "getMediaExtractor", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class d
  {
    final ab BJy;
    final com.tencent.mm.media.d.e BJz;
    private final long endTime;
    final com.tencent.mm.media.f.a hlB;
    final int index;
    private final long startTime;
    
    public d(int paramInt, ab paramab, com.tencent.mm.media.d.e parame, com.tencent.mm.media.f.a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111007);
      this.index = paramInt;
      this.BJy = paramab;
      this.BJz = parame;
      this.hlB = parama;
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
          if ((this.index != paramObject.index) || (!p.i(this.BJy, paramObject.BJy)) || (!p.i(this.BJz, paramObject.BJz)) || (!p.i(this.hlB, paramObject.hlB)) || (this.startTime != paramObject.startTime) || (this.endTime != paramObject.endTime)) {}
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
      Object localObject = this.BJy;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.BJz;
        if (localObject == null) {
          break label138;
        }
      }
      label138:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.hlB;
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
      String str = "VideoDecoder(index=" + this.index + ", material=" + this.BJy + ", decoder=" + this.BJz + ", mediaExtractor=" + this.hlB + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
      AppMethodBeat.o(111008);
      return str;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(111011);
      int i = a.c(this.BJt);
      Object localObject = a.a(this.BJt);
      if (localObject != null) {
        ((m)localObject).p(new byte[i * 2048], Long.valueOf(a.b(this.BJt)));
      }
      localObject = this.BJt;
      a.a((a)localObject, a.b((a)localObject) + a.d(this.BJt) * 1000L);
      AppMethodBeat.o(111011);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, long paramLong, ab paramab, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(111012);
      long l = this.hlp - this.BJA.BGQ + this.BJA.startTime * 1000L;
      m localm = a.a(this.BJt);
      if (localm != null) {
        localm.p(this.BJB, Long.valueOf(l));
      }
      a.a(this.BJt, l);
      AppMethodBeat.o(111012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a
 * JD-Core Version:    0.7.0.1
 */