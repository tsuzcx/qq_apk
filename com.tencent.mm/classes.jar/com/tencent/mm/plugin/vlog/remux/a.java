package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.e;
import com.tencent.mm.media.d.h;
import com.tencent.mm.plugin.vlog.model.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.k.i;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "(Ljava/util/List;)V", "curDecoderIndex", "", "curMaterialIndex", "currentAudioFrameInterval", "", "currentChannelCount", "currentPts", "currentSampleRate", "decoderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "Lkotlin/collections/ArrayList;", "defaultMediaFormat", "Landroid/media/MediaFormat;", "lastAudioFramePts", "getMaterials", "()Ljava/util/List;", "sendVideoFrameDataHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "sendVideoFrameDataThread", "Landroid/os/HandlerThread;", "dumpFakeMaterialDecodeData", "", "material", "getChannelCount", "getMediaFormat", "getSampleRate", "hasVideo", "", "onVideoFrameDecode", "pcmData", "", "pts", "index", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "startDecoder", "stopDecoder", "videoDecodeEnd", "decoder", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "Companion", "VideoDecoder", "plugin-vlog_release"})
public final class a
  extends e
{
  public static final c CaQ;
  private final List<com.tencent.mm.plugin.vlog.model.l> BYl;
  private ArrayList<d> CaF;
  private volatile int CaG;
  private volatile int CaH;
  private aq CaI;
  private HandlerThread CaJ;
  MediaFormat CaK;
  private volatile int CaL;
  private volatile int CaM;
  private long CaN;
  private long CaO;
  private long CaP;
  
  static
  {
    AppMethodBeat.i(111019);
    CaQ = new c((byte)0);
    AppMethodBeat.o(111019);
  }
  
  public a(final List<? extends com.tencent.mm.plugin.vlog.model.l> paramList)
  {
    super(null, "background", -1L, -1L, null, null);
    AppMethodBeat.i(111018);
    this.BYl = paramList;
    this.CaF = new ArrayList();
    this.CaL = 1;
    this.CaM = 44100;
    this.CaN = 23L;
    this.CaO = -1L;
    paramList = (Iterable)this.BYl;
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        d.a.j.gkd();
      }
      final com.tencent.mm.plugin.vlog.model.l locall = (com.tencent.mm.plugin.vlog.model.l)paramList;
      final com.tencent.mm.media.f.a locala;
      long l1;
      long l2;
      if ((locall instanceof ab))
      {
        locala = new com.tencent.mm.media.f.a(locall.path);
        paramList = locala.hmP;
        if ((paramList != null) && (paramList.containsKey("frame-rate")))
        {
          int j = paramList.getInteger("frame-rate");
          ae.i("MicroMsg.VLogAudioBackgroundDecoder", "index:" + i + ", material:" + locall.path + ", audioFps:" + j);
        }
        l1 = ((ab)locall).BYp;
        l2 = locall.endTime - locall.startTime + l1;
        if (!com.tencent.mm.compatible.util.d.lB(23)) {
          break label417;
        }
      }
      label417:
      for (paramList = (e)new com.tencent.mm.media.d.g(locala, "background", l1, l2);; paramList = (e)new h(locala, "background", l1, l2))
      {
        paramList.hln = ((m)new a(i, locall, this));
        paramList.hlo = ((d.g.a.a)new b(i, locall, paramList, locala, this));
        this.CaF.add(new d(i, (ab)locall, paramList, locala, l1, l2));
        ae.i("MicroMsg.VLogAudioBackgroundDecoder", "add video decoder, index:" + i + ", material:" + locall.path + ", start:" + l1 + ',' + locall.startTime + ", end:" + l2 + ',' + locall.endTime);
        i += 1;
        break;
      }
    }
    ae.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, decoderList:" + this.CaF.size());
    if (ews())
    {
      this.CaL = ((d)this.CaF.get(0)).CaY.getChannelCount();
      this.CaM = ((d)this.CaF.get(0)).CaY.getSampleRate();
      this.CaN = 23L;
      ae.i("MicroMsg.VLogAudioBackgroundDecoder", "init currentChannelCount:" + this.CaL + ", currentSampleRate:" + this.CaM + ", currentAudioFrameInterval:" + this.CaN);
    }
    paramList = com.tencent.e.c.d.hh("VLogAudioBackgroundDecoder_sendVideoFrameDataThread", 5);
    p.g(paramList, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.CaJ = paramList;
    this.CaJ.start();
    this.CaI = new aq(this.CaJ.getLooper());
    paramList = new MediaFormat();
    paramList.setString("mime", "audio/mp4a-latm");
    paramList.setInteger("aac-profile", 2);
    paramList.setInteger("sample-rate", 44100);
    paramList.setInteger("channel-count", 1);
    paramList.setInteger("bitrate", 64000);
    paramList.setInteger("max-input-size", 16384);
    this.CaK = paramList;
    this.CaG = 0;
    this.CaH = 0;
    ae.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, defaultMediaFormat:" + this.CaK);
    AppMethodBeat.o(111018);
  }
  
  private final void a(int paramInt, com.tencent.mm.plugin.vlog.model.l paraml, e parame, com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(111017);
    for (;;)
    {
      ae.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd, index:" + paramInt + ", material:" + paraml.path + ", currentPts:" + this.CaP);
      if (parame != null) {}
      try
      {
        parame.atB();
        if (parama != null) {
          parama.release();
        }
        if (paramInt + 1 < this.BYl.size())
        {
          paraml = (com.tencent.mm.plugin.vlog.model.l)this.BYl.get(paramInt + 1);
          this.CaH = (paramInt + 1);
          ae.i("MicroMsg.VLogAudioBackgroundDecoder", "nextMaterial:" + paraml.path);
          if ((paraml instanceof ab))
          {
            parame = ((Iterable)this.CaF).iterator();
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
                    ae.i("MicroMsg.VLogAudioBackgroundDecoder", "find start next decoder index:" + (paramInt + 1) + ", hasAudio:" + paraml.hoq.atN());
                    if (paraml.hoq.atN()) {
                      break label374;
                    }
                    ae.i("MicroMsg.VLogAudioBackgroundDecoder", "next material not have audio: " + paraml.CaX.path);
                    a((com.tencent.mm.plugin.vlog.model.l)paraml.CaX);
                    ae.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process mute video material, index:" + this.CaG);
                    a(this.CaH, (com.tencent.mm.plugin.vlog.model.l)paraml.CaX, paraml.CaY, paraml.hoq);
                  }
                  this.CaG = (paramInt + 1);
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
          ae.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd release decoder and extractor error");
          continue;
          int i = 0;
          continue;
          paraml = null;
          continue;
          label374:
          this.CaL = paraml.CaY.getChannelCount();
          this.CaM = paraml.CaY.getSampleRate();
          this.CaO = -1L;
          paraml.CaY.startDecoder();
        }
        if ((paraml instanceof com.tencent.mm.plugin.vlog.model.j))
        {
          ae.i("MicroMsg.VLogAudioBackgroundDecoder", "next material is image, startTime:" + paraml.startTime + ", endTime:" + paraml.endTime);
          a(paraml);
          ae.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process image material, index:" + this.CaG);
          paramInt = this.CaH;
          parama = null;
          parame = null;
        }
        else
        {
          ae.i("MicroMsg.VLogAudioBackgroundDecoder", "cannot find next material");
          AppMethodBeat.o(111017);
          return;
        }
      }
    }
    ae.i("MicroMsg.VLogAudioBackgroundDecoder", "finish decode all material");
    paraml = this.hlo;
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
    ae.i("MicroMsg.VLogAudioBackgroundDecoder", "dumpFakeMaterialDecodeData, currentChannelCount:" + this.CaL + ", currentSampleRate:" + this.CaM + ", currentAudioFrameInterval:" + this.CaN);
    paraml = d.k.j.a((d.k.g)new i(paraml.startTime, paraml.endTime), this.CaN);
    long l1 = paraml.first;
    long l2 = paraml.Nju;
    long l3 = paraml.xMb;
    if (l3 >= 0L)
    {
      if (l1 > l2) {}
    }
    else {
      while (l1 >= l2) {
        for (;;)
        {
          this.CaI.post((Runnable)new e(this));
          if (l1 == l2) {
            break;
          }
          l1 += l3;
        }
      }
    }
    AppMethodBeat.o(111016);
  }
  
  public final void atB()
  {
    AppMethodBeat.i(111015);
    ae.m("MicroMsg.VLogAudioBackgroundDecoder", "stopDecoder, decoderStop:" + this.hlg, new Object[0]);
    if (!this.hlg)
    {
      Iterator localIterator = ((Iterable)this.CaF).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).CaY.atB();
      }
      this.CaF.clear();
    }
    this.CaJ.quitSafely();
    this.CaG = 0;
    this.CaH = 0;
    AppMethodBeat.o(111015);
  }
  
  public final boolean ews()
  {
    AppMethodBeat.i(111013);
    if (!((Collection)this.CaF).isEmpty())
    {
      AppMethodBeat.o(111013);
      return true;
    }
    AppMethodBeat.o(111013);
    return false;
  }
  
  public final int getChannelCount()
  {
    return this.CaL;
  }
  
  public final int getSampleRate()
  {
    return this.CaM;
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(111014);
    ae.i("MicroMsg.VLogAudioBackgroundDecoder", "startDecoder: " + this.CaF.size());
    if (ews())
    {
      this.CaP = 0L;
      this.CaH = 0;
      this.CaG = 0;
      com.tencent.mm.plugin.vlog.model.l locall = (com.tencent.mm.plugin.vlog.model.l)this.BYl.get(0);
      if ((locall instanceof com.tencent.mm.plugin.vlog.model.j))
      {
        ae.i("MicroMsg.VLogAudioBackgroundDecoder", "firstMaterial is image, startTime:" + locall.startTime + ", endTime:" + locall.endTime);
        a(locall);
        ae.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first image material, index:" + this.CaG);
        a(this.CaH, locall, null, null);
        AppMethodBeat.o(111014);
        return;
      }
      if (((d)this.CaF.get(0)).hoq.atN())
      {
        this.CaL = ((d)this.CaF.get(0)).CaY.getChannelCount();
        this.CaM = ((d)this.CaF.get(0)).CaY.getSampleRate();
        this.CaO = -1L;
        ((d)this.CaF.get(0)).CaY.startDecoder();
        AppMethodBeat.o(111014);
        return;
      }
      ae.i("MicroMsg.VLogAudioBackgroundDecoder", "first video not have audio:" + ((d)this.CaF.get(0)).CaX.path);
      a((com.tencent.mm.plugin.vlog.model.l)((d)this.CaF.get(0)).CaX);
      ae.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first mute video material");
      a(this.CaH, (com.tencent.mm.plugin.vlog.model.l)((d)this.CaF.get(0)).CaX, ((d)this.CaF.get(0)).CaY, ((d)this.CaF.get(0)).hoq);
    }
    AppMethodBeat.o(111014);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "pcmData", "", "pts", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$2"})
  static final class a
    extends q
    implements m<byte[], Long, z>
  {
    a(int paramInt, com.tencent.mm.plugin.vlog.model.l paraml, a parama)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$3"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(int paramInt, com.tencent.mm.plugin.vlog.model.l paraml, e parame, com.tencent.mm.media.f.a parama, a parama1)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$Companion;", "", "()V", "DEFAULT_AUDIO_FRAME_INTERVAL", "", "TAG", "", "plugin-vlog_release"})
  public static final class c {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "", "index", "", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "decoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "startTime", "", "endTime", "(ILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Lcom/tencent/mm/media/decoder/IAudioDecoder;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;JJ)V", "getDecoder", "()Lcom/tencent/mm/media/decoder/IAudioDecoder;", "getEndTime", "()J", "getIndex", "()I", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "getMediaExtractor", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class d
  {
    final ab CaX;
    final e CaY;
    private final long endTime;
    final com.tencent.mm.media.f.a hoq;
    final int index;
    private final long startTime;
    
    public d(int paramInt, ab paramab, e parame, com.tencent.mm.media.f.a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111007);
      this.index = paramInt;
      this.CaX = paramab;
      this.CaY = parame;
      this.hoq = parama;
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
          if ((this.index != paramObject.index) || (!p.i(this.CaX, paramObject.CaX)) || (!p.i(this.CaY, paramObject.CaY)) || (!p.i(this.hoq, paramObject.hoq)) || (this.startTime != paramObject.startTime) || (this.endTime != paramObject.endTime)) {}
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
      Object localObject = this.CaX;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.CaY;
        if (localObject == null) {
          break label138;
        }
      }
      label138:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.hoq;
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
      String str = "VideoDecoder(index=" + this.index + ", material=" + this.CaX + ", decoder=" + this.CaY + ", mediaExtractor=" + this.hoq + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
      AppMethodBeat.o(111008);
      return str;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(111011);
      int i = a.c(this.CaS);
      Object localObject = a.a(this.CaS);
      if (localObject != null) {
        ((m)localObject).p(new byte[i * 2048], Long.valueOf(a.b(this.CaS)));
      }
      localObject = this.CaS;
      a.a((a)localObject, a.b((a)localObject) + a.d(this.CaS) * 1000L);
      AppMethodBeat.o(111011);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, long paramLong, ab paramab, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(111012);
      long l = this.hoe - this.CaZ.BYp + this.CaZ.startTime * 1000L;
      m localm = a.a(this.CaS);
      if (localm != null) {
        localm.p(this.Cba, Long.valueOf(l));
      }
      a.a(this.CaS, l);
      AppMethodBeat.o(111012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a
 * JD-Core Version:    0.7.0.1
 */