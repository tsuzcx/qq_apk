package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.media.e.f;
import com.tencent.mm.media.i.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "getUseX264Encode", "()Z", "setUseX264Encode", "(Z)V", "videoDuration", "videoFps", "videoMixHandlerThread", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "blurBgProvider", "Companion", "plugin-recordvideo_release"})
public final class e
  extends com.tencent.mm.media.i.d
  implements com.tencent.mm.media.i.c
{
  private static final long hpo = 1000L;
  private static final long hpp = 1000L;
  public static final e.a xLB;
  private final String TAG;
  private volatile boolean hkf;
  private int hkm;
  private int hku;
  private volatile boolean hmh;
  private d.g.a.b<? super Long, Bitmap> hnM;
  private long hnV;
  private com.tencent.mm.media.e.g hoA;
  private com.tencent.mm.media.a.a hoB;
  private i hoD;
  private com.tencent.mm.media.f.a hoE;
  private com.tencent.mm.media.f.a hoF;
  private HandlerThread hoG;
  private HandlerThread hoH;
  private boolean hoI;
  private boolean hoJ;
  private com.tencent.mm.media.i.g hoK;
  private long hoM;
  private final com.tencent.mm.media.k.a hoN;
  private boolean hoO;
  private boolean hoP;
  private boolean hoQ;
  private int hoR;
  private int hoS;
  private final Runnable hoY;
  private final String hoZ;
  private int how;
  private int hox;
  private com.tencent.mm.media.e.b hoz;
  private int hpb;
  private int hpc;
  private int hpd;
  private int hpf;
  private d.g.a.b<? super String, z> hpn;
  private final String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  boolean xLA;
  private ArrayList<String> xLu;
  private d xLz;
  
  static
  {
    AppMethodBeat.i(75300);
    xLB = new e.a((byte)0);
    hpo = 1000L;
    hpp = 1000L;
    AppMethodBeat.o(75300);
  }
  
  public e(String paramString1, final ArrayList<String> paramArrayList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, boolean paramBoolean, d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(75299);
    this.hoZ = paramString1;
    this.xLu = paramArrayList;
    this.hku = paramInt1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt2;
    this.outputHeight = paramInt3;
    this.hpb = paramInt4;
    this.hpc = paramInt5;
    this.hpd = paramInt6;
    this.hpf = paramInt7;
    this.xLA = paramBoolean;
    this.hpn = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxerFake";
    this.videoDuration = -1;
    this.hnV = paramLong1;
    this.remuxEndTime = -1L;
    this.hoN = new com.tencent.mm.media.k.a("remuxCost");
    paramString1 = this.xLu.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (o.fB((String)paramString1.next()));
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((paramInt1 == 0) || (bu.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
      {
        ae.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.hpf);
        paramString1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avI();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(75299);
        throw paramString1;
      }
      paramString1 = com.tencent.mm.media.k.d.hrI;
      com.tencent.mm.media.k.d.nR(this.hku);
      o.aZI(o.aZU(this.outputFilePath));
      com.tencent.mm.plugin.recordvideo.b.e.xNf.dII();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      this.how = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      this.hox = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      this.videoFps = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      this.videoDuration = com.tencent.mm.plugin.recordvideo.b.e.dIF();
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        if (!this.xLA) {
          break label1041;
        }
        ae.i(this.TAG, "mixMuxerController init useX264Encode, bitrate %s, width %s, height %s, fps %s", new Object[] { Integer.valueOf(this.hpb), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight), Integer.valueOf(this.hpf) });
        paramString1 = new i(this.hnV, this.remuxEndTime, this.hpb, this.outputWidth, this.outputHeight, this.xLA, this.hpf);
        label486:
        this.hoD = paramString1;
        ae.m(this.TAG, "create MediaCodecRemuxer, outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.how + ", inputHeight: " + this.hox + ", videoFps: " + this.videoFps + " ,outputBitrate :" + this.hpb + ", outputAudioBitrate:" + this.hpc + " , outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.hpf + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.hnV + " ,remuxEndTime: " + this.remuxEndTime, new Object[0]);
        this.hoF = null;
        this.hoK = new com.tencent.mm.media.i.g(this.hoD, this.hoF, this.outputFilePath, this.hku, this.hpd);
        if (o.fB(this.hoZ))
        {
          paramString1 = this.hoZ;
          if (paramString1 == null) {
            p.gkB();
          }
          paramString1 = new com.tencent.mm.media.f.a(paramString1);
          if (paramString1.hmS)
          {
            paramArrayList = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.avL();
          }
          this.hoE = paramString1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.hpf > 0)
            {
              paramInt1 = Math.min(this.hpf, this.videoFps);
              paramArrayList = new com.tencent.mm.media.b.d();
              paramArrayList.bitrate = this.hpb;
              paramArrayList.frameRate = paramInt1;
              paramArrayList.targetHeight = this.outputHeight;
              paramArrayList.targetWidth = this.outputWidth;
              paramArrayList.hkH = true;
              paramb = (m)new j(this);
              locala = (d.g.a.a)new k(this);
            }
          }
          catch (Exception paramString1)
          {
            final d.g.a.a locala;
            label1041:
            ae.printErrStackTrace(this.TAG, (Throwable)paramString1, "remux impl error", new Object[0]);
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e(paramArrayList, (d.g.a.b)new f(paramb, locala));
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e(paramArrayList, (d.g.a.b)new h(paramb, locala));
            continue;
            ae.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder error", new Object[0]);
            paramString1 = com.tencent.mm.media.k.d.hrI;
            com.tencent.mm.media.k.d.avM();
            dIy();
            paramString1 = com.tencent.mm.plugin.recordvideo.d.d.xXf;
            com.tencent.mm.plugin.recordvideo.d.d.dKf();
            continue;
            paramString1 = null;
            continue;
          }
          try
          {
            if (this.xLA)
            {
              ae.i(this.TAG, "useX264Encode");
              this.hoA = new com.tencent.mm.media.e.g(this.hoD.bufId, paramArrayList.targetWidth, paramArrayList.targetHeight);
              paramString1 = this.hoA;
              if (paramString1 != null) {
                paramString1.start();
              }
              if ((this.hoA != null) || (this.hoz != null))
              {
                if (this.hoz == null) {
                  continue;
                }
                paramString1 = this.hoz;
                if (paramString1 == null) {
                  p.gkB();
                }
                paramString1 = paramString1.getInputSurface();
                this.xLz = new d(this.xLu, this.hnV, this.remuxEndTime, paramString1, this.outputWidth, this.outputHeight, this.xLA, this.hpf, (m)new i(this, paramArrayList));
              }
              this.hoY = ((Runnable)new b(this));
              AppMethodBeat.o(75299);
              return;
              this.remuxEndTime = paramLong2;
              break;
              paramString1 = new i(this.hnV, this.remuxEndTime, this.hpb, this.xLA);
              break label486;
              paramInt1 = this.videoFps;
              continue;
            }
            if (!com.tencent.mm.compatible.util.d.lA(23)) {
              continue;
            }
            paramString1 = (com.tencent.mm.media.e.b)new f(paramArrayList, (d.g.a.b)new e(paramb, locala));
            this.hoz = paramString1;
            continue;
            paramArrayList.hkH = false;
          }
          catch (Exception paramString2)
          {
            if (!paramArrayList.hkH) {
              continue;
            }
          }
        }
        try
        {
          if (!com.tencent.mm.compatible.util.d.lA(23)) {
            continue;
          }
          paramString1 = (com.tencent.mm.media.e.b)new f(paramArrayList, (d.g.a.b)new g(paramb, locala));
          this.hoz = paramString1;
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.xXf;
          com.tencent.mm.plugin.recordvideo.d.d.dKg();
        }
        catch (Exception paramString1)
        {
          ae.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder again error", new Object[0]);
          paramString1 = com.tencent.mm.media.k.d.hrI;
          com.tencent.mm.media.k.d.avM();
          dIy();
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.xXf;
          com.tencent.mm.plugin.recordvideo.d.d.dKf();
        }
      }
    }
  }
  
  private final void atH()
  {
    AppMethodBeat.i(75296);
    ae.i(this.TAG, "finishEncode %s", new Object[] { Boolean.valueOf(this.xLA) });
    Object localObject;
    if (this.xLA)
    {
      localObject = this.hoA;
      if (localObject != null) {
        com.tencent.mm.media.e.g.a((com.tencent.mm.media.e.g)localObject);
      }
      eg(true);
    }
    for (;;)
    {
      ar.ay(this.hoY);
      this.hmh = true;
      AppMethodBeat.o(75296);
      return;
      localObject = this.hoz;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).atH();
      }
    }
  }
  
  private final void dIy()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75298);
        ae.i(this.TAG, "onDecoderEncoderFailed, isDecoder:false");
        if (!this.hoO)
        {
          this.hoN.ald();
          this.hoO = true;
          try
          {
            localObject1 = this.hoF;
            if (localObject1 != null) {
              ((com.tencent.mm.media.f.a)localObject1).release();
            }
            localObject1 = this.hoG;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.hoH;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            o.deleteFile(this.outputFilePath);
            long l = bu.aO(this.hoM);
            ae.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Object localObject1;
            ae.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.hpn;
          if (localObject1 != null)
          {
            ((d.g.a.b)localObject1).invoke(null);
            AppMethodBeat.o(75298);
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(75298);
    }
  }
  
  private final void eg(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      long l;
      com.tencent.mm.media.k.d locald;
      try
      {
        AppMethodBeat.i(75297);
        ae.i(this.TAG, "finishRemux, isVideo: " + paramBoolean + ", isAudioRemuxFinish:" + this.hoQ + ", isVideoRemuxFinish:" + this.hoP + ", isInvokeEndCallback:" + this.hoO);
        if (paramBoolean)
        {
          this.hoP = true;
          if ((!this.hoQ) || (!this.hoP) || (this.hoO)) {
            break label374;
          }
          this.hoN.ald();
          this.hoO = true;
          localObject1 = this.hoF;
          if (localObject1 != null) {
            ((com.tencent.mm.media.f.a)localObject1).release();
          }
          localObject1 = this.hoK;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.i.g)localObject1).hpJ;
            if (localObject1 != null) {
              ((d.g.a.b)localObject1).invoke(this.hpn);
            }
          }
          localObject1 = this.hoG;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          localObject1 = this.hoH;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          l = bu.aO(this.hoM);
          ae.i(this.TAG, "remux used " + l + " decodeFrame:" + this.hoR + ", encodeFrame:" + this.hkm + ", drawFrameCount:" + this.hoS);
        }
      }
      finally {}
      try
      {
        localObject1 = com.tencent.mm.plugin.sight.base.e.ayN(this.outputFilePath);
        if (localObject1 == null) {
          break label374;
        }
        locald = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.w(this.hku, l);
        locald = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.f(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate, this.videoFps);
        if (this.hoR / this.hkm < 1.5D) {
          break label374;
        }
        localObject1 = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.avV();
        AppMethodBeat.o(75297);
        return;
      }
      catch (Exception localException) {}
      this.hoQ = true;
      continue;
      label374:
      AppMethodBeat.o(75297);
    }
  }
  
  public final int aue()
  {
    AppMethodBeat.i(75294);
    ae.i(this.TAG, "start remux, initFinish:" + this.hoI);
    this.hoM = bu.HQ();
    this.hoN.gIr.reset();
    Object localObject;
    if (ae.getLogLevel() > 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.b.e.xNf;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dIG()) {
        this.hoI = false;
      }
    }
    if (this.hoI)
    {
      localObject = com.tencent.mm.plugin.recordvideo.d.d.xXf;
      com.tencent.mm.plugin.recordvideo.d.d.dKe();
      localObject = this.hoG;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      this.hoG = com.tencent.mm.ac.c.a("MediaCodecRemux_audioMix", false, (d.g.a.a)new c(this));
      localObject = this.hoH;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      if (this.xLz != null) {
        this.hoH = com.tencent.mm.ac.c.a("MediaCodecRemux_videoMix", false, (d.g.a.a)new d(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75294);
      return 0;
      this.hoJ = true;
    }
  }
  
  public final void k(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75293);
    p.h(paramb, "blendBitmapProvider");
    this.hnM = paramb;
    AppMethodBeat.o(75293);
  }
  
  public final void l(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75295);
    p.h(paramb, "blurBgProvider");
    AppMethodBeat.o(75295);
  }
  
  public final void z(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75292);
    p.h(paramBitmap, "bitmap");
    AppMethodBeat.o(75292);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(75277);
      ae.i(e.a(this.xLC), "decode end after " + e.aui() + ", isFinishEncode:" + e.s(this.xLC));
      if (!e.s(this.xLC))
      {
        com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hrI;
        com.tencent.mm.media.k.d.awj();
        e.t(this.xLC);
      }
      AppMethodBeat.o(75277);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    e(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    f(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    g(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    h(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "succ", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements m<d, Boolean, z>
  {
    i(e parame, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, z>
    {
      a(e.i parami)
      {
        super();
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.q
      implements d.g.a.a<z>
    {
      b(e.i parami)
      {
        super();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends d.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, z>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    k(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, z>
  {
    l(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    m(e parame, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.e
 * JD-Core Version:    0.7.0.1
 */