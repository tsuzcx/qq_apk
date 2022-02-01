package com.tencent.mm.plugin.vlog.remux;

import android.media.MediaFormat;
import android.os.HandlerThread;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.d.e;
import com.tencent.mm.media.d.g;
import com.tencent.mm.media.d.h;
import com.tencent.mm.plugin.vlog.model.ak;
import com.tencent.mm.plugin.vlog.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.e.c;
import kotlin.g.a.m;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder;", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "materials", "", "Lcom/tencent/mm/plugin/vlog/model/Material;", "(Ljava/util/List;)V", "curDecoderIndex", "", "curMaterialIndex", "currentAudioFrameInterval", "", "currentChannelCount", "currentPts", "currentSampleRate", "decoderList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "Lkotlin/collections/ArrayList;", "defaultMediaFormat", "Landroid/media/MediaFormat;", "lastAudioFramePts", "getMaterials", "()Ljava/util/List;", "sendVideoFrameDataHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "sendVideoFrameDataThread", "Landroid/os/HandlerThread;", "dumpFakeMaterialDecodeData", "", "material", "getChannelCount", "getMediaFormat", "getSampleRate", "hasVideo", "", "onVideoFrameDecode", "pcmData", "", "pts", "index", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "startDecoder", "stopDecoder", "videoDecodeEnd", "decoder", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "Companion", "VideoDecoder", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends e
{
  public static final c UdS;
  private final List<com.tencent.mm.plugin.vlog.model.s> UaY;
  private ArrayList<d> UdT;
  private volatile int UdU;
  private volatile int UdV;
  private MMHandler UdW;
  private HandlerThread UdX;
  MediaFormat UdY;
  private volatile int UdZ;
  private volatile int Uea;
  private long Ueb;
  private long Uec;
  private long Ued;
  
  static
  {
    AppMethodBeat.i(111019);
    UdS = new c((byte)0);
    AppMethodBeat.o(111019);
  }
  
  public b(final List<? extends com.tencent.mm.plugin.vlog.model.s> paramList)
  {
    super(null, "background", -1L, -1L, null, null);
    AppMethodBeat.i(111018);
    this.UaY = paramList;
    this.UdT = new ArrayList();
    this.UdZ = 1;
    this.Uea = 44100;
    this.Ueb = 23L;
    this.Uec = -1L;
    paramList = (Iterable)this.UaY;
    final int i = 0;
    Object localObject = paramList.iterator();
    if (((Iterator)localObject).hasNext())
    {
      paramList = ((Iterator)localObject).next();
      if (i < 0) {
        p.kkW();
      }
      final com.tencent.mm.plugin.vlog.model.s locals = (com.tencent.mm.plugin.vlog.model.s)paramList;
      final com.tencent.mm.media.f.a locala;
      long l1;
      long l2;
      if ((locals instanceof ak))
      {
        locala = new com.tencent.mm.media.f.a(locals.path);
        paramList = locala.nAt;
        if ((paramList != null) && (paramList.containsKey("frame-rate")))
        {
          int j = paramList.getInteger("frame-rate");
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "index:" + i + ", material:" + locals.path + ", audioFps:" + j);
        }
        l1 = ((ak)locals).Ubf;
        l2 = locals.endTime - locals.startTime + l1;
        if (!com.tencent.mm.compatible.util.d.rc(23)) {
          break label417;
        }
      }
      label417:
      for (paramList = (e)new g(locala, "background", l1, l2);; paramList = (e)new h(locala, "background", l1, l2))
      {
        paramList.nyx = ((m)new a(this, i, locals));
        paramList.nyy = ((kotlin.g.a.a)new b(this, i, locals, paramList, locala));
        this.UdT.add(new d(i, (ak)locals, paramList, locala, l1, l2));
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "add video decoder, index:" + i + ", material:" + locals.path + ", start:" + l1 + ',' + locals.startTime + ", end:" + l2 + ',' + locals.endTime);
        i += 1;
        break;
      }
    }
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("init finish, decoderList:", Integer.valueOf(this.UdT.size())));
    if (hSf())
    {
      this.UdZ = ((d)this.UdT.get(0)).Uel.getChannelCount();
      this.Uea = ((d)this.UdT.get(0)).Uel.getSampleRate();
      this.Ueb = 23L;
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "init currentChannelCount:" + this.UdZ + ", currentSampleRate:" + this.Uea + ", currentAudioFrameInterval:" + this.Ueb);
    }
    paramList = com.tencent.threadpool.c.d.jx("VLogAudioBackgroundDecoder_sendVideoFrameDataThread", 5);
    kotlin.g.b.s.s(paramList, "createMediaCodecThread(\"…ad\",Thread.NORM_PRIORITY)");
    this.UdX = paramList;
    this.UdX.start();
    this.UdW = new MMHandler(this.UdX.getLooper());
    paramList = new MediaFormat();
    paramList.setString("mime", "audio/mp4a-latm");
    paramList.setInteger("aac-profile", 2);
    paramList.setInteger("sample-rate", 44100);
    paramList.setInteger("channel-count", 1);
    paramList.setInteger("bitrate", 64000);
    paramList.setInteger("max-input-size", 16384);
    localObject = ah.aiuX;
    this.UdY = paramList;
    this.UdU = 0;
    this.UdV = 0;
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("init finish, defaultMediaFormat:", this.UdY));
    AppMethodBeat.o(111018);
  }
  
  private final void a(int paramInt, com.tencent.mm.plugin.vlog.model.s params, e parame, com.tencent.mm.media.f.a parama)
  {
    AppMethodBeat.i(111017);
    for (;;)
    {
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "videoDecodeEnd, index:" + paramInt + ", material:" + params.path + ", currentPts:" + this.Ued);
      if (parame != null) {}
      try
      {
        parame.boQ();
        if (parama != null) {
          parama.release();
        }
        if (paramInt + 1 < this.UaY.size())
        {
          params = (com.tencent.mm.plugin.vlog.model.s)this.UaY.get(paramInt + 1);
          this.UdV = (paramInt + 1);
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("nextMaterial:", params.path));
          if ((params instanceof ak))
          {
            parame = ((Iterable)this.UdT).iterator();
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
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "find start next decoder index:" + (paramInt + 1) + ", hasAudio:" + params.nBM.bpm());
                    if (params.nBM.bpm()) {
                      break label347;
                    }
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("next material not have audio: ", params.Uek.path));
                    a((com.tencent.mm.plugin.vlog.model.s)params.Uek);
                    Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("finish process mute video material, index:", Integer.valueOf(this.UdU)));
                    a(this.UdV, (com.tencent.mm.plugin.vlog.model.s)params.Uek, params.Uel, params.nBM);
                  }
                  this.UdU = (paramInt + 1);
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
          label347:
          this.UdZ = params.Uel.getChannelCount();
          this.Uea = params.Uel.getSampleRate();
          this.Uec = -1L;
          params.Uel.startDecoder();
        }
        if ((params instanceof q))
        {
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", "next material is image, startTime:" + params.startTime + ", endTime:" + params.endTime);
          a(params);
          Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("finish process image material, index:", Integer.valueOf(this.UdU)));
          paramInt = this.UdV;
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
    params = this.nyy;
    if (params != null) {
      params.invoke();
    }
    AppMethodBeat.o(111017);
  }
  
  private static final void a(long paramLong, ak paramak, b paramb, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(281340);
    kotlin.g.b.s.u(paramak, "$material");
    kotlin.g.b.s.u(paramb, "this$0");
    paramLong = paramLong - paramak.Ubf + paramak.startTime * 1000L;
    paramak = paramb.nyx;
    if (paramak != null) {
      paramak.invoke(paramArrayOfByte, Long.valueOf(paramLong));
    }
    paramb.Ued = paramLong;
    AppMethodBeat.o(281340);
  }
  
  private final void a(com.tencent.mm.plugin.vlog.model.s params)
  {
    AppMethodBeat.i(111016);
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", "dumpFakeMaterialDecodeData, currentChannelCount:" + this.UdZ + ", currentSampleRate:" + this.Uea + ", currentAudioFrameInterval:" + this.Ueb);
    long l1 = params.startTime;
    long l3 = params.endTime;
    long l2 = this.Ueb;
    if (l2 <= 0L)
    {
      params = new IllegalArgumentException("Step must be positive, was: " + l2 + '.');
      AppMethodBeat.o(111016);
      throw params;
    }
    l3 = c.A(l1, l3, l2);
    if (l1 <= l3) {}
    for (;;)
    {
      this.UdW.post(new b..ExternalSyntheticLambda1(this));
      if (l1 == l3)
      {
        AppMethodBeat.o(111016);
        return;
      }
      l1 += l2;
    }
  }
  
  private static final void a(b paramb)
  {
    AppMethodBeat.i(281342);
    kotlin.g.b.s.u(paramb, "this$0");
    int i = paramb.UdZ;
    m localm = paramb.nyx;
    if (localm != null) {
      localm.invoke(new byte[i * 2048], Long.valueOf(paramb.Ued));
    }
    paramb.Ued += paramb.Ueb * 1000L;
    AppMethodBeat.o(281342);
  }
  
  public final void boQ()
  {
    AppMethodBeat.i(111015);
    Log.printInfoStack("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("stopDecoder, decoderStop:", Boolean.valueOf(this.nyA)), new Object[0]);
    if (!this.nyA)
    {
      Iterator localIterator = ((Iterable)this.UdT).iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).Uel.boQ();
      }
      this.UdT.clear();
    }
    this.UdX.quitSafely();
    this.UdU = 0;
    this.UdV = 0;
    AppMethodBeat.o(111015);
  }
  
  public final int getChannelCount()
  {
    return this.UdZ;
  }
  
  public final int getSampleRate()
  {
    return this.Uea;
  }
  
  public final boolean hSf()
  {
    AppMethodBeat.i(111013);
    if (!((Collection)this.UdT).isEmpty())
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
    Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("startDecoder: ", Integer.valueOf(this.UdT.size())));
    if (hSf())
    {
      this.Ued = 0L;
      this.UdV = 0;
      this.UdU = 0;
      com.tencent.mm.plugin.vlog.model.s locals = (com.tencent.mm.plugin.vlog.model.s)this.UaY.get(0);
      if ((locals instanceof q))
      {
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", "firstMaterial is image, startTime:" + locals.startTime + ", endTime:" + locals.endTime);
        a(locals);
        Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("finish process first image material, index:", Integer.valueOf(this.UdU)));
        a(this.UdV, locals, null, null);
        AppMethodBeat.o(111014);
        return;
      }
      if (((d)this.UdT.get(0)).nBM.bpm())
      {
        this.UdZ = ((d)this.UdT.get(0)).Uel.getChannelCount();
        this.Uea = ((d)this.UdT.get(0)).Uel.getSampleRate();
        this.Uec = -1L;
        ((d)this.UdT.get(0)).Uel.startDecoder();
        AppMethodBeat.o(111014);
        return;
      }
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", kotlin.g.b.s.X("first video not have audio:", ((d)this.UdT.get(0)).Uek.path));
      a((com.tencent.mm.plugin.vlog.model.s)((d)this.UdT.get(0)).Uek);
      Log.i("MicroMsg.VLogAudioBackgroundDecoder", "finish process first mute video material");
      a(this.UdV, (com.tencent.mm.plugin.vlog.model.s)((d)this.UdT.get(0)).Uek, ((d)this.UdT.get(0)).Uel, ((d)this.UdT.get(0)).nBM);
    }
    AppMethodBeat.o(111014);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pcmData", "", "pts", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements m<byte[], Long, ah>
  {
    a(b paramb, int paramInt, com.tencent.mm.plugin.vlog.model.s params)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b paramb, int paramInt, com.tencent.mm.plugin.vlog.model.s params, e parame, com.tencent.mm.media.f.a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$Companion;", "", "()V", "DEFAULT_AUDIO_FRAME_INTERVAL", "", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/remux/VLogAudioBackgroundDecoder$VideoDecoder;", "", "index", "", "material", "Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "decoder", "Lcom/tencent/mm/media/decoder/IAudioDecoder;", "mediaExtractor", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "startTime", "", "endTime", "(ILcom/tencent/mm/plugin/vlog/model/VideoMaterial;Lcom/tencent/mm/media/decoder/IAudioDecoder;Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;JJ)V", "getDecoder", "()Lcom/tencent/mm/media/decoder/IAudioDecoder;", "getEndTime", "()J", "getIndex", "()I", "getMaterial", "()Lcom/tencent/mm/plugin/vlog/model/VideoMaterial;", "getMediaExtractor", "()Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "getStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
  {
    final ak Uek;
    final e Uel;
    private final long endTime;
    final int index;
    final com.tencent.mm.media.f.a nBM;
    private final long startTime;
    
    public d(int paramInt, ak paramak, e parame, com.tencent.mm.media.f.a parama, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111007);
      this.index = paramInt;
      this.Uek = paramak;
      this.Uel = parame;
      this.nBM = parama;
      this.startTime = paramLong1;
      this.endTime = paramLong2;
      AppMethodBeat.o(111007);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(111010);
      if (this == paramObject)
      {
        AppMethodBeat.o(111010);
        return true;
      }
      if (!(paramObject instanceof d))
      {
        AppMethodBeat.o(111010);
        return false;
      }
      paramObject = (d)paramObject;
      if (this.index != paramObject.index)
      {
        AppMethodBeat.o(111010);
        return false;
      }
      if (!kotlin.g.b.s.p(this.Uek, paramObject.Uek))
      {
        AppMethodBeat.o(111010);
        return false;
      }
      if (!kotlin.g.b.s.p(this.Uel, paramObject.Uel))
      {
        AppMethodBeat.o(111010);
        return false;
      }
      if (!kotlin.g.b.s.p(this.nBM, paramObject.nBM))
      {
        AppMethodBeat.o(111010);
        return false;
      }
      if (this.startTime != paramObject.startTime)
      {
        AppMethodBeat.o(111010);
        return false;
      }
      if (this.endTime != paramObject.endTime)
      {
        AppMethodBeat.o(111010);
        return false;
      }
      AppMethodBeat.o(111010);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(111009);
      int i = this.index;
      int j = this.Uek.hashCode();
      int k = this.Uel.hashCode();
      int m = this.nBM.hashCode();
      int n = q.a..ExternalSyntheticBackport0.m(this.startTime);
      int i1 = q.a..ExternalSyntheticBackport0.m(this.endTime);
      AppMethodBeat.o(111009);
      return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(111008);
      String str = "VideoDecoder(index=" + this.index + ", material=" + this.Uek + ", decoder=" + this.Uel + ", mediaExtractor=" + this.nBM + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ')';
      AppMethodBeat.o(111008);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.b
 * JD-Core Version:    0.7.0.1
 */