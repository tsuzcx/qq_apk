package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import d.a.j;
import d.g.a.m;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "(Ljava/util/List;)V", "curDecoderIndex", "", "curMaterialIndex", "currentAudioFrameInterval", "", "currentChannelCount", "currentPts", "currentSampleRate", "decoderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "Lkotlin/collections/ArrayList;", "defaultMediaFormat", "Landroid/media/MediaFormat;", "lastAudioFramePts", "getMaterials", "()Ljava/util/List;", "sendVideoFrameDataHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "sendVideoFrameDataThread", "Landroid/os/HandlerThread;", "dumpFakeMaterialDecodeData", "", "material", "getChannelCount", "getMediaFormat", "getSampleRate", "hasVideo", "", "onVideoFrameDecode", "pcmData", "", "pts", "index", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "startDecoder", "stopDecoder", "videoDecodeEnd", "decoder", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "Companion", "VideoDecoder", "plugin-vlog_release"})
public final class a
  extends com.tencent.mm.media.c.e
{
  public static final a.c ArA;
  private final List<i> AoV;
  private ArrayList<a.d> Arp;
  private volatile int Arq;
  private volatile int Arr;
  private ao Ars;
  private HandlerThread Art;
  MediaFormat Aru;
  private volatile int Arv;
  private volatile int Arw;
  private long Arx;
  private long Ary;
  private long Arz;
  
  static
  {
    AppMethodBeat.i(111019);
    ArA = new a.c((byte)0);
    AppMethodBeat.o(111019);
  }
  
  public a(List<? extends i> paramList)
  {
    super(null, "background", -1L, -1L, null, null);
    AppMethodBeat.i(111018);
    this.AoV = paramList;
    this.Arp = new ArrayList();
    this.Arv = 1;
    this.Arw = 44100;
    this.Arx = 23L;
    this.Ary = -1L;
    paramList = (Iterable)this.AoV;
    int i = 0;
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = localIterator.next();
      if (i < 0) {
        j.fOc();
      }
      i locali = (i)paramList;
      com.tencent.mm.media.e.a locala;
      long l1;
      long l2;
      if ((locali instanceof z))
      {
        locala = new com.tencent.mm.media.e.a(locali.path);
        paramList = locala.gRJ;
        if ((paramList != null) && (paramList.containsKey("frame-rate")))
        {
          int j = paramList.getInteger("frame-rate");
          ac.i("MicroMsg.VLogAudioBackgroundDecoder", "index:" + i + ", material:" + locali.path + ", audioFps:" + j);
        }
        l1 = ((z)locali).Apa;
        l2 = locali.endTime - locali.startTime + l1;
        if (!com.tencent.mm.compatible.util.d.la(23)) {
          break label417;
        }
      }
      label417:
      for (paramList = (com.tencent.mm.media.c.e)new com.tencent.mm.media.c.g(locala, "background", l1, l2);; paramList = (com.tencent.mm.media.c.e)new com.tencent.mm.media.c.h(locala, "background", l1, l2))
      {
        paramList.gOA = ((m)new a.a(i, locali, this));
        paramList.gOB = ((d.g.a.a)new a.b(i, locali, paramList, locala, this));
        this.Arp.add(new a.d(i, (z)locali, paramList, locala, l1, l2));
        ac.i("MicroMsg.VLogAudioBackgroundDecoder", "add video decoder, index:" + i + ", material:" + locali.path + ", start:" + l1 + ',' + locali.startTime + ", end:" + l2 + ',' + locali.endTime);
        i += 1;
        break;
      }
    }
    ac.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, decoderList:" + this.Arp.size());
    if (efY())
    {
      this.Arv = ((a.d)this.Arp.get(0)).ArI.getChannelCount();
      this.Arw = ((a.d)this.Arp.get(0)).ArI.getSampleRate();
      this.Arx = 23L;
      ac.i("MicroMsg.VLogAudioBackgroundDecoder", "init currentChannelCount:" + this.Arv + ", currentSampleRate:" + this.Arw + ", currentAudioFrameInterval:" + this.Arx);
    }
    paramList = com.tencent.e.c.d.gA("VLogAudioBackgroundDecoder_sendVideoFrameDataThread", 5);
    k.g(paramList, "SpecialThreadFactory.cre…ad\",Thread.NORM_PRIORITY)");
    this.Art = paramList;
    this.Art.start();
    this.Ars = new ao(this.Art.getLooper());
    paramList = new MediaFormat();
    paramList.setString("mime", "audio/mp4a-latm");
    paramList.setInteger("aac-profile", 2);
    paramList.setInteger("sample-rate", 44100);
    paramList.setInteger("channel-count", 1);
    paramList.setInteger("bitrate", 64000);
    paramList.setInteger("max-input-size", 16384);
    this.Aru = paramList;
    this.Arq = 0;
    this.Arr = 0;
    ac.i("MicroMsg.VLogAudioBackgroundDecoder", "init finish, defaultMediaFormat:" + this.Aru);
    AppMethodBeat.o(111018);
  }
  
  private final void a(int paramInt, i parami, com.tencent.mm.media.c.e parame, com.tencent.mm.media.e.a parama)
  {
    AppMethodBeat.i(111017);
    for (;;)
    {
      ac.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd, index:" + paramInt + ", material:" + parami.path + ", currentPts:" + this.Arz);
      if (parame != null) {}
      try
      {
        parame.aqr();
        if (parama != null) {
          parama.release();
        }
        if (paramInt + 1 < this.AoV.size())
        {
          parami = (i)this.AoV.get(paramInt + 1);
          this.Arr = (paramInt + 1);
          ac.i("MicroMsg.VLogAudioBackgroundDecoder", "nextMaterial:" + parami.path);
          if ((parami instanceof z))
          {
            parame = ((Iterable)this.Arp).iterator();
            for (;;)
            {
              if (parame.hasNext())
              {
                parami = parame.next();
                if (((a.d)parami).index == paramInt + 1)
                {
                  i = 1;
                  if (i == 0) {
                    continue;
                  }
                  parami = (a.d)parami;
                  if (parami != null)
                  {
                    ac.i("MicroMsg.VLogAudioBackgroundDecoder", "find start next decoder index:" + (paramInt + 1) + ", hasAudio:" + parami.gTA.aqK());
                    if (parami.gTA.aqK()) {
                      break label374;
                    }
                    ac.i("MicroMsg.VLogAudioBackgroundDecoder", "next material not have audio: " + parami.ArH.path);
                    a((i)parami.ArH);
                    ac.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process mute video material, index:" + this.Arq);
                    a(this.Arr, (i)parami.ArH, parami.ArI, parami.gTA);
                  }
                  this.Arq = (paramInt + 1);
                  AppMethodBeat.o(111017);
                }
              }
            }
          }
        }
      }
      catch (Exception parami)
      {
        for (;;)
        {
          ac.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd release decoder and extractor error");
          continue;
          int i = 0;
          continue;
          parami = null;
          continue;
          label374:
          this.Arv = parami.ArI.getChannelCount();
          this.Arw = parami.ArI.getSampleRate();
          this.Ary = -1L;
          parami.ArI.startDecoder();
        }
        if ((parami instanceof com.tencent.mm.plugin.vlog.model.g))
        {
          ac.i("MicroMsg.VLogAudioBackgroundDecoder", "next material is image, startTime:" + parami.startTime + ", endTime:" + parami.endTime);
          a(parami);
          ac.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process image material, index:" + this.Arq);
          paramInt = this.Arr;
          parama = null;
          parame = null;
        }
        else
        {
          ac.i("MicroMsg.VLogAudioBackgroundDecoder", "cannot find next material");
          AppMethodBeat.o(111017);
          return;
        }
      }
    }
    ac.i("MicroMsg.VLogAudioBackgroundDecoder", "finish decode all material");
    parami = this.gOB;
    if (parami != null)
    {
      parami.invoke();
      AppMethodBeat.o(111017);
      return;
    }
    AppMethodBeat.o(111017);
  }
  
  private final void a(i parami)
  {
    AppMethodBeat.i(111016);
    ac.i("MicroMsg.VLogAudioBackgroundDecoder", "dumpFakeMaterialDecodeData, currentChannelCount:" + this.Arv + ", currentSampleRate:" + this.Arw + ", currentAudioFrameInterval:" + this.Arx);
    parami = d.k.h.a((d.k.e)new d.k.g(parami.startTime, parami.endTime), this.Arx);
    long l1 = parami.first;
    long l2 = parami.KVj;
    long l3 = parami.woo;
    if (l3 >= 0L)
    {
      if (l1 > l2) {}
    }
    else {
      while (l1 >= l2) {
        for (;;)
        {
          this.Ars.post((Runnable)new a.e(this));
          if (l1 == l2) {
            break;
          }
          l1 += l3;
        }
      }
    }
    AppMethodBeat.o(111016);
  }
  
  public final void aqr()
  {
    AppMethodBeat.i(111015);
    ac.m("MicroMsg.VLogAudioBackgroundDecoder", "stopDecoder, decoderStop:" + this.gOs, new Object[0]);
    if (!this.gOs)
    {
      Iterator localIterator = ((Iterable)this.Arp).iterator();
      while (localIterator.hasNext()) {
        ((a.d)localIterator.next()).ArI.aqr();
      }
      this.Arp.clear();
    }
    this.Art.quitSafely();
    this.Arq = 0;
    this.Arr = 0;
    AppMethodBeat.o(111015);
  }
  
  public final boolean efY()
  {
    AppMethodBeat.i(111013);
    if (!((Collection)this.Arp).isEmpty())
    {
      AppMethodBeat.o(111013);
      return true;
    }
    AppMethodBeat.o(111013);
    return false;
  }
  
  public final int getChannelCount()
  {
    return this.Arv;
  }
  
  public final int getSampleRate()
  {
    return this.Arw;
  }
  
  public final void startDecoder()
  {
    AppMethodBeat.i(111014);
    ac.i("MicroMsg.VLogAudioBackgroundDecoder", "startDecoder: " + this.Arp.size());
    if (efY())
    {
      this.Arz = 0L;
      this.Arr = 0;
      this.Arq = 0;
      i locali = (i)this.AoV.get(0);
      if ((locali instanceof com.tencent.mm.plugin.vlog.model.g))
      {
        ac.i("MicroMsg.VLogAudioBackgroundDecoder", "firstMaterial is image, startTime:" + locali.startTime + ", endTime:" + locali.endTime);
        a(locali);
        ac.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first image material, index:" + this.Arq);
        a(this.Arr, locali, null, null);
        AppMethodBeat.o(111014);
        return;
      }
      if (((a.d)this.Arp.get(0)).gTA.aqK())
      {
        this.Arv = ((a.d)this.Arp.get(0)).ArI.getChannelCount();
        this.Arw = ((a.d)this.Arp.get(0)).ArI.getSampleRate();
        this.Ary = -1L;
        ((a.d)this.Arp.get(0)).ArI.startDecoder();
        AppMethodBeat.o(111014);
        return;
      }
      ac.i("MicroMsg.VLogAudioBackgroundDecoder", "first video not have audio:" + ((a.d)this.Arp.get(0)).ArH.path);
      a((i)((a.d)this.Arp.get(0)).ArH);
      ac.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first mute video material");
      a(this.Arr, (i)((a.d)this.Arp.get(0)).ArH, ((a.d)this.Arp.get(0)).ArI, ((a.d)this.Arp.get(0)).gTA);
    }
    AppMethodBeat.o(111014);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(a parama, long paramLong, z paramz, byte[] paramArrayOfByte) {}
    
    public final void run()
    {
      AppMethodBeat.i(111012);
      long l = this.gTo - this.ArJ.Apa + this.ArJ.startTime * 1000L;
      m localm = a.a(this.ArC);
      if (localm != null) {
        localm.n(this.ArK, Long.valueOf(l));
      }
      a.a(this.ArC, l);
      AppMethodBeat.o(111012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.a
 * JD-Core Version:    0.7.0.1
 */