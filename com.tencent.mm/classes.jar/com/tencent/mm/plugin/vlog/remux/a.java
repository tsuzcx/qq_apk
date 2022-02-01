package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.c;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "(Ljava/util/List;)V", "curDecoderIndex", "", "curMaterialIndex", "currentAudioFrameInterval", "", "currentChannelCount", "currentPts", "currentSampleRate", "decoderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "Lkotlin/collections/ArrayList;", "defaultMediaFormat", "Landroid/media/MediaFormat;", "lastAudioFramePts", "getMaterials", "()Ljava/util/List;", "sendVideoFrameDataHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "sendVideoFrameDataThread", "Landroid/os/HandlerThread;", "dumpFakeMaterialDecodeData", "", "material", "getChannelCount", "getMediaFormat", "getSampleRate", "hasVideo", "", "onVideoFrameDecode", "pcmData", "", "pts", "index", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "startDecoder", "stopDecoder", "videoDecodeEnd", "decoder", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "Companion", "VideoDecoder", "plugin-vlog_release"})
public final class a
  extends com.tencent.mm.media.c.e
{
  public static final c zay;
  private final List<com.tencent.mm.plugin.vlog.model.d> yZs;
  private ArrayList<d> zan;
  private volatile int zao;
  private volatile int zap;
  private ap zaq;
  private HandlerThread zar;
  MediaFormat zas;
  private volatile int zat;
  private volatile int zau;
  private long zav;
  private long zaw;
  private long zax;
  
  static
  {
    AppMethodBeat.i(111019);
    zay = new c((byte)0);
    AppMethodBeat.o(111019);
  }
  
  public a(final List<? extends com.tencent.mm.plugin.vlog.model.d> paramList)
  {
    super(null, "background", -1L, -1L, null, null);
    AppMethodBeat.i(111018);
    this.yZs = paramList;
    this.zan = new ArrayList();
    this.zat = 1;
    this.zau = 44100;
    this.zav = 23L;
    this.zaw = -1L;
    paramList = (Iterable)this.yZs;
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        j.fvx();
      }
      final com.tencent.mm.plugin.vlog.model.d locald = (com.tencent.mm.plugin.vlog.model.d)paramList;
      final com.tencent.mm.media.e.a locala;
      long l1;
      long l2;
      if ((locald instanceof i))
      {
        locala = new com.tencent.mm.media.e.a(locald.path);
        paramList = locala.grb;
        if ((paramList != null) && (paramList.containsKey("frame-rate")))
        {
          int j = paramList.getInteger("frame-rate");
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "index:" + i + ", material:" + locald.path + ", audioFps:" + j);
        }
        l1 = ((i)locald).yZx;
        l2 = locald.endTime - locald.startTime + l1;
        if (!com.tencent.mm.compatible.util.d.lg(23)) {
          break label417;
        }
      }
      label417:
      for (paramList = (com.tencent.mm.media.c.e)new com.tencent.mm.media.c.g(locala, "background", l1, l2);; paramList = (com.tencent.mm.media.c.e)new com.tencent.mm.media.c.h(locala, "background", l1, l2))
      {
        paramList.gnP = ((m)new a(i, locald, this));
        paramList.gnQ = ((d.g.a.a)new b(i, locald, paramList, locala, this));
        this.zan.add(new d(i, (i)locald, paramList, locala, l1, l2));
        ad.i("MicroMsg.VLogAudioBackgroundDecoder", "add video decoder, index:" + i + ", material:" + locald.path + ", start:" + l1 + ',' + locald.startTime + ", end:" + l2 + ',' + locald.endTime);
        i += 1;
        break;
      }
    }
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, decoderList:" + this.zan.size());
    if (dQZ())
    {
      this.zat = ((d)this.zan.get(0)).zaG.getChannelCount();
      this.zau = ((d)this.zan.get(0)).zaG.getSampleRate();
      this.zav = 23L;
      ad.i("MicroMsg.VLogAudioBackgroundDecoder", "init currentChannelCount:" + this.zat + ", currentSampleRate:" + this.zau + ", currentAudioFrameInterval:" + this.zav);
    }
    paramList = com.tencent.e.c.d.gw("VLogAudioBackgroundDecoder_sendVideoFrameDataThread", 5);
    k.g(paramList, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.zar = paramList;
    this.zar.start();
    this.zaq = new ap(this.zar.getLooper());
    paramList = new MediaFormat();
    paramList.setString("mime", "audio/mp4a-latm");
    paramList.setInteger("aac-profile", 2);
    paramList.setInteger("sample-rate", 44100);
    paramList.setInteger("channel-count", 1);
    paramList.setInteger("bitrate", 64000);
    paramList.setInteger("max-input-size", 16384);
    this.zas = paramList;
    this.zao = 0;
    this.zap = 0;
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, defaultMediaFormat:" + this.zas);
    AppMethodBeat.o(111018);
  }
  
  private final void a(int paramInt, com.tencent.mm.plugin.vlog.model.d paramd, com.tencent.mm.media.c.e parame, com.tencent.mm.media.e.a parama)
  {
    AppMethodBeat.i(111017);
    for (;;)
    {
      ad.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd, index:" + paramInt + ", material:" + paramd.path + ", currentPts:" + this.zax);
      if (parame != null) {}
      try
      {
        parame.ajs();
        if (parama != null) {
          parama.release();
        }
        if (paramInt + 1 < this.yZs.size())
        {
          paramd = (com.tencent.mm.plugin.vlog.model.d)this.yZs.get(paramInt + 1);
          this.zap = (paramInt + 1);
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "nextMaterial:" + paramd.path);
          if ((paramd instanceof i))
          {
            parame = ((Iterable)this.zan).iterator();
            for (;;)
            {
              if (parame.hasNext())
              {
                paramd = parame.next();
                if (((d)paramd).index == paramInt + 1)
                {
                  i = 1;
                  if (i == 0) {
                    continue;
                  }
                  paramd = (d)paramd;
                  if (paramd != null)
                  {
                    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "find start next decoder index:" + (paramInt + 1) + ", hasAudio:" + paramd.gsS.ajL());
                    if (paramd.gsS.ajL()) {
                      break label374;
                    }
                    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "next material not have audio: " + paramd.zaF.path);
                    a((com.tencent.mm.plugin.vlog.model.d)paramd.zaF);
                    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process mute video material, index:" + this.zao);
                    a(this.zap, (com.tencent.mm.plugin.vlog.model.d)paramd.zaF, paramd.zaG, paramd.gsS);
                  }
                  this.zao = (paramInt + 1);
                  AppMethodBeat.o(111017);
                }
              }
            }
          }
        }
      }
      catch (Exception paramd)
      {
        for (;;)
        {
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd release decoder and extractor error");
          continue;
          int i = 0;
          continue;
          paramd = null;
          continue;
          label374:
          this.zat = paramd.zaG.getChannelCount();
          this.zau = paramd.zaG.getSampleRate();
          this.zaw = -1L;
          paramd.zaG.startDecoder();
        }
        if ((paramd instanceof c))
        {
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "next material is image, startTime:" + paramd.startTime + ", endTime:" + paramd.endTime);
          a(paramd);
          ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process image material, index:" + this.zao);
          paramInt = this.zap;
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
    paramd = this.gnQ;
    if (paramd != null)
    {
      paramd.invoke();
      AppMethodBeat.o(111017);
      return;
    }
    AppMethodBeat.o(111017);
  }
  
  private final void a(com.tencent.mm.plugin.vlog.model.d paramd)
  {
    AppMethodBeat.i(111016);
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "dumpFakeMaterialDecodeData, currentChannelCount:" + this.zat + ", currentSampleRate:" + this.zau + ", currentAudioFrameInterval:" + this.zav);
    paramd = d.k.h.a((d.k.e)new d.k.g(paramd.startTime, paramd.endTime), this.zav);
    long l1 = paramd.first;
    long l2 = paramd.JhP;
    long l3 = paramd.vfC;
    if (l3 >= 0L)
    {
      if (l1 > l2) {}
    }
    else {
      while (l1 >= l2) {
        for (;;)
        {
          this.zaq.post((Runnable)new e(this));
          if (l1 == l2) {
            break;
          }
          l1 += l3;
        }
      }
    }
    AppMethodBeat.o(111016);
  }
  
  public final void ajs()
  {
    AppMethodBeat.i(111015);
    ad.m("MicroMsg.VLogAudioBackgroundDecoder", "stopDecoder, decoderStop:" + this.gnG, new Object[0]);
    if (!this.gnG)
    {
      Iterator localIterator = ((Iterable)this.zan).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).zaG.ajs();
      }
      this.zan.clear();
    }
    this.zar.quitSafely();
    this.zao = 0;
    this.zap = 0;
    AppMethodBeat.o(111015);
  }
  
  public final boolean dQZ()
  {
    AppMethodBeat.i(111013);
    if (!((Collection)this.zan).isEmpty())
    {
      AppMethodBeat.o(111013);
      return true;
    }
    AppMethodBeat.o(111013);
    return false;
  }
  
  public final int getChannelCount()
  {
    return this.zat;
  }
  
  public final int getSampleRate()
  {
    return this.zau;
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(111014);
    ad.i("MicroMsg.VLogAudioBackgroundDecoder", "startDecoder: " + this.zan.size());
    if (dQZ())
    {
      this.zax = 0L;
      this.zap = 0;
      this.zao = 0;
      com.tencent.mm.plugin.vlog.model.d locald = (com.tencent.mm.plugin.vlog.model.d)this.yZs.get(0);
      if ((locald instanceof c))
      {
        ad.i("MicroMsg.VLogAudioBackgroundDecoder", "firstMaterial is image, startTime:" + locald.startTime + ", endTime:" + locald.endTime);
        a(locald);
        ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first image material, index:" + this.zao);
        a(this.zap, locald, null, null);
        AppMethodBeat.o(111014);
        return;
      }
      if (((d)this.zan.get(0)).gsS.ajL())
      {
        this.zat = ((d)this.zan.get(0)).zaG.getChannelCount();
        this.zau = ((d)this.zan.get(0)).zaG.getSampleRate();
        this.zaw = -1L;
        ((d)this.zan.get(0)).zaG.startDecoder();
        AppMethodBeat.o(111014);
        return;
      }
      ad.i("MicroMsg.VLogAudioBackgroundDecoder", "first video not have audio:" + ((d)this.zan.get(0)).zaF.path);
      a((com.tencent.mm.plugin.vlog.model.d)((d)this.zan.get(0)).zaF);
      ad.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first mute video material");
      a(this.zap, (com.tencent.mm.plugin.vlog.model.d)((d)this.zan.get(0)).zaF, ((d)this.zan.get(0)).zaG, ((d)this.zan.get(0)).gsS);
    }
    AppMethodBeat.o(111014);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "pcmData", "", "pts", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$2"})
  static final class a
    extends d.g.b.l
    implements m<byte[], Long, y>
  {
    a(int paramInt, com.tencent.mm.plugin.vlog.model.d paramd, a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$1$3"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(int paramInt, com.tencent.mm.plugin.vlog.model.d paramd, com.tencent.mm.media.c.e parame, com.tencent.mm.media.e.a parama, a parama1)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$Companion;", "", "()V", "DEFAULT_AUDIO_FRAME_INTERVAL", "", "TAG", "", "plugin-vlog_release"})
  public static final class c {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "", "index", "", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "decoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "startTime", "", "endTime", "(ILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Lcom/tencent/mm/media/decoder/IAudioDecoder;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;JJ)V", "getDecoder", "()Lcom/tencent/mm/media/decoder/IAudioDecoder;", "getEndTime", "()J", "getIndex", "()I", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "getMediaExtractor", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"})
  public static final class d
  {
    private final long endTime;
    final com.tencent.mm.media.e.a gsS;
    final int index;
    private final long startTime;
    final i zaF;
    final com.tencent.mm.media.c.e zaG;
    
    public d(int paramInt, i parami, com.tencent.mm.media.c.e parame, com.tencent.mm.media.e.a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111007);
      this.index = paramInt;
      this.zaF = parami;
      this.zaG = parame;
      this.gsS = parama;
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
          if ((this.index != paramObject.index) || (!k.g(this.zaF, paramObject.zaF)) || (!k.g(this.zaG, paramObject.zaG)) || (!k.g(this.gsS, paramObject.gsS)) || (this.startTime != paramObject.startTime) || (this.endTime != paramObject.endTime)) {}
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
      Object localObject = this.zaF;
      int i;
      if (localObject != null)
      {
        i = localObject.hashCode();
        localObject = this.zaG;
        if (localObject == null) {
          break label138;
        }
      }
      label138:
      for (int j = localObject.hashCode();; j = 0)
      {
        localObject = this.gsS;
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
      String str = "VideoDecoder(index=" + this.index + ", material=" + this.zaF + ", decoder=" + this.zaG + ", mediaExtractor=" + this.gsS + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ")";
      AppMethodBeat.o(111008);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(111011);
      int i = a.c(this.zaA);
      Object localObject = a.a(this.zaA);
      if (localObject != null) {
        ((m)localObject).n(new byte[i * 2048], Long.valueOf(a.b(this.zaA)));
      }
      localObject = this.zaA;
      a.a((a)localObject, a.b((a)localObject) + a.d(this.zaA) * 1000L);
      AppMethodBeat.o(111011);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, long paramLong, i parami, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(111012);
      long l = this.gsH - this.zaH.yZx + this.zaH.startTime * 1000L;
      m localm = a.a(this.zaA);
      if (localm != null) {
        localm.n(this.zaI, Long.valueOf(l));
      }
      a.a(this.zaA, l);
      AppMethodBeat.o(111012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a
 * JD-Core Version:    0.7.0.1
 */