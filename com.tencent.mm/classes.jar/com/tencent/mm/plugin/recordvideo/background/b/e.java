package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.media.e.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.l;
import d.z;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "getUseX264Encode", "()Z", "setUseX264Encode", "(Z)V", "videoDuration", "videoFps", "videoMixHandlerThread", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "blurBgProvider", "Companion", "plugin-recordvideo_release"})
public final class e
  extends com.tencent.mm.media.i.d
  implements com.tencent.mm.media.i.c
{
  private static final long hmA = 1000L;
  private static final long hmB = 1000L;
  public static final e.a xvE;
  private final String TAG;
  private int hhG;
  private volatile boolean hhr;
  private int hhy;
  private volatile boolean hjt;
  private d.g.a.b<? super Long, Bitmap> hkY;
  private int hlH;
  private int hlI;
  private long hlK;
  private com.tencent.mm.media.e.b hlL;
  private com.tencent.mm.media.e.g hlM;
  private com.tencent.mm.media.a.a hlN;
  private com.tencent.mm.media.i.i hlP;
  private com.tencent.mm.media.f.a hlQ;
  private com.tencent.mm.media.f.a hlR;
  private HandlerThread hlS;
  private HandlerThread hlT;
  private boolean hlU;
  private boolean hlV;
  private com.tencent.mm.media.i.g hlW;
  private long hlY;
  private final com.tencent.mm.media.k.a hlZ;
  private boolean hma;
  private boolean hmb;
  private boolean hmc;
  private int hmd;
  private int hme;
  private final Runnable hmk;
  private final String hml;
  private int hmn;
  private int hmo;
  private int hmp;
  private int hmr;
  private d.g.a.b<? super String, z> hmz;
  private final String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  private d xvC;
  boolean xvD;
  private ArrayList<String> xvx;
  
  static
  {
    AppMethodBeat.i(75300);
    xvE = new e.a((byte)0);
    hmA = 1000L;
    hmB = 1000L;
    AppMethodBeat.o(75300);
  }
  
  public e(String paramString1, final ArrayList<String> paramArrayList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, boolean paramBoolean, d.g.a.b<? super String, z> paramb)
  {
    AppMethodBeat.i(75299);
    this.hml = paramString1;
    this.xvx = paramArrayList;
    this.hhG = paramInt1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt2;
    this.outputHeight = paramInt3;
    this.hmn = paramInt4;
    this.hmo = paramInt5;
    this.hmp = paramInt6;
    this.hmr = paramInt7;
    this.xvD = paramBoolean;
    this.hmz = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxerFake";
    this.videoDuration = -1;
    this.hlK = paramLong1;
    this.remuxEndTime = -1L;
    this.hlZ = new com.tencent.mm.media.k.a("remuxCost");
    paramString1 = this.xvx.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (com.tencent.mm.vfs.i.fv((String)paramString1.next()));
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((paramInt1 == 0) || (bt.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
      {
        ad.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.hmr);
        paramString1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avt();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(75299);
        throw paramString1;
      }
      paramString1 = com.tencent.mm.media.k.d.hoU;
      com.tencent.mm.media.k.d.nO(this.hhG);
      com.tencent.mm.vfs.i.aYg(com.tencent.mm.vfs.i.aYr(this.outputFilePath));
      com.tencent.mm.plugin.recordvideo.b.e.xxi.dFr();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      this.hlH = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      this.hlI = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      this.videoFps = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      this.videoDuration = com.tencent.mm.plugin.recordvideo.b.e.dFo();
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        if (!this.xvD) {
          break label1041;
        }
        ad.i(this.TAG, "mixMuxerController init useX264Encode, bitrate %s, width %s, height %s, fps %s", new Object[] { Integer.valueOf(this.hmn), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight), Integer.valueOf(this.hmr) });
        paramString1 = new com.tencent.mm.media.i.i(this.hlK, this.remuxEndTime, this.hmn, this.outputWidth, this.outputHeight, this.xvD, this.hmr);
        label486:
        this.hlP = paramString1;
        ad.m(this.TAG, "create MediaCodecRemuxer, outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.hlH + ", inputHeight: " + this.hlI + ", videoFps: " + this.videoFps + " ,outputBitrate :" + this.hmn + ", outputAudioBitrate:" + this.hmo + " , outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.hmr + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.hlK + " ,remuxEndTime: " + this.remuxEndTime, new Object[0]);
        this.hlR = null;
        this.hlW = new com.tencent.mm.media.i.g(this.hlP, this.hlR, this.outputFilePath, this.hhG, this.hmp);
        if (com.tencent.mm.vfs.i.fv(this.hml))
        {
          paramString1 = this.hml;
          if (paramString1 == null) {
            p.gfZ();
          }
          paramString1 = new com.tencent.mm.media.f.a(paramString1);
          if (paramString1.hke)
          {
            paramArrayList = com.tencent.mm.media.k.d.hoU;
            com.tencent.mm.media.k.d.avw();
          }
          this.hlQ = paramString1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.hmr > 0)
            {
              paramInt1 = Math.min(this.hmr, this.videoFps);
              paramArrayList = new com.tencent.mm.media.b.d();
              paramArrayList.bitrate = this.hmn;
              paramArrayList.frameRate = paramInt1;
              paramArrayList.targetHeight = this.outputHeight;
              paramArrayList.targetWidth = this.outputWidth;
              paramArrayList.hhT = true;
              paramb = (m)new j(this);
              locala = (d.g.a.a)new k(this);
            }
          }
          catch (Exception paramString1)
          {
            final d.g.a.a locala;
            label1041:
            ad.printErrStackTrace(this.TAG, (Throwable)paramString1, "remux impl error", new Object[0]);
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e(paramArrayList, (d.g.a.b)new f(paramb, locala));
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e(paramArrayList, (d.g.a.b)new h(paramb, locala));
            continue;
            ad.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder error", new Object[0]);
            paramString1 = com.tencent.mm.media.k.d.hoU;
            com.tencent.mm.media.k.d.avx();
            dFh();
            paramString1 = com.tencent.mm.plugin.recordvideo.d.d.xHk;
            com.tencent.mm.plugin.recordvideo.d.d.dGO();
            continue;
            paramString1 = null;
            continue;
          }
          try
          {
            if (this.xvD)
            {
              ad.i(this.TAG, "useX264Encode");
              this.hlM = new com.tencent.mm.media.e.g(this.hlP.bufId, paramArrayList.targetWidth, paramArrayList.targetHeight);
              paramString1 = this.hlM;
              if (paramString1 != null) {
                paramString1.start();
              }
              if ((this.hlM != null) || (this.hlL != null))
              {
                if (this.hlL == null) {
                  continue;
                }
                paramString1 = this.hlL;
                if (paramString1 == null) {
                  p.gfZ();
                }
                paramString1 = paramString1.getInputSurface();
                this.xvC = new d(this.xvx, this.hlK, this.remuxEndTime, paramString1, this.outputWidth, this.outputHeight, this.xvD, this.hmr, (m)new i(this, paramArrayList));
              }
              this.hmk = ((Runnable)new b(this));
              AppMethodBeat.o(75299);
              return;
              this.remuxEndTime = paramLong2;
              break;
              paramString1 = new com.tencent.mm.media.i.i(this.hlK, this.remuxEndTime, this.hmn, this.xvD);
              break label486;
              paramInt1 = this.videoFps;
              continue;
            }
            if (!com.tencent.mm.compatible.util.d.ly(23)) {
              continue;
            }
            paramString1 = (com.tencent.mm.media.e.b)new f(paramArrayList, (d.g.a.b)new e(paramb, locala));
            this.hlL = paramString1;
            continue;
            paramArrayList.hhT = false;
          }
          catch (Exception paramString2)
          {
            if (!paramArrayList.hhT) {
              continue;
            }
          }
        }
        try
        {
          if (!com.tencent.mm.compatible.util.d.ly(23)) {
            continue;
          }
          paramString1 = (com.tencent.mm.media.e.b)new f(paramArrayList, (d.g.a.b)new g(paramb, locala));
          this.hlL = paramString1;
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.xHk;
          com.tencent.mm.plugin.recordvideo.d.d.dGP();
        }
        catch (Exception paramString1)
        {
          ad.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder again error", new Object[0]);
          paramString1 = com.tencent.mm.media.k.d.hoU;
          com.tencent.mm.media.k.d.avx();
          dFh();
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.xHk;
          com.tencent.mm.plugin.recordvideo.d.d.dGO();
        }
      }
    }
  }
  
  private final void ats()
  {
    AppMethodBeat.i(75296);
    ad.i(this.TAG, "finishEncode %s", new Object[] { Boolean.valueOf(this.xvD) });
    Object localObject;
    if (this.xvD)
    {
      localObject = this.hlM;
      if (localObject != null) {
        com.tencent.mm.media.e.g.a((com.tencent.mm.media.e.g)localObject);
      }
      ee(true);
    }
    for (;;)
    {
      aq.aA(this.hmk);
      this.hjt = true;
      AppMethodBeat.o(75296);
      return;
      localObject = this.hlL;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).ats();
      }
    }
  }
  
  private final void dFh()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75298);
        ad.i(this.TAG, "onDecoderEncoderFailed, isDecoder:false");
        if (!this.hma)
        {
          this.hlZ.akO();
          this.hma = true;
          try
          {
            localObject1 = this.hlR;
            if (localObject1 != null) {
              ((com.tencent.mm.media.f.a)localObject1).release();
            }
            localObject1 = this.hlS;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.hlT;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            com.tencent.mm.vfs.i.deleteFile(this.outputFilePath);
            long l = bt.aO(this.hlY);
            ad.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Object localObject1;
            ad.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.hmz;
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
  
  private final void ee(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      long l;
      com.tencent.mm.media.k.d locald;
      try
      {
        AppMethodBeat.i(75297);
        ad.i(this.TAG, "finishRemux, isVideo: " + paramBoolean + ", isAudioRemuxFinish:" + this.hmc + ", isVideoRemuxFinish:" + this.hmb + ", isInvokeEndCallback:" + this.hma);
        if (paramBoolean)
        {
          this.hmb = true;
          if ((!this.hmc) || (!this.hmb) || (this.hma)) {
            break label374;
          }
          this.hlZ.akO();
          this.hma = true;
          localObject1 = this.hlR;
          if (localObject1 != null) {
            ((com.tencent.mm.media.f.a)localObject1).release();
          }
          localObject1 = this.hlW;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.i.g)localObject1).hmV;
            if (localObject1 != null) {
              ((d.g.a.b)localObject1).invoke(this.hmz);
            }
          }
          localObject1 = this.hlS;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          localObject1 = this.hlT;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          l = bt.aO(this.hlY);
          ad.i(this.TAG, "remux used " + l + " decodeFrame:" + this.hmd + ", encodeFrame:" + this.hhy + ", drawFrameCount:" + this.hme);
        }
      }
      finally {}
      try
      {
        localObject1 = com.tencent.mm.plugin.sight.base.e.axx(this.outputFilePath);
        if (localObject1 == null) {
          break label374;
        }
        locald = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.w(this.hhG, l);
        locald = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.f(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate, this.videoFps);
        if (this.hmd / this.hhy < 1.5D) {
          break label374;
        }
        localObject1 = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avG();
        AppMethodBeat.o(75297);
        return;
      }
      catch (Exception localException) {}
      this.hmc = true;
      continue;
      label374:
      AppMethodBeat.o(75297);
    }
  }
  
  public final int atP()
  {
    AppMethodBeat.i(75294);
    ad.i(this.TAG, "start remux, initFinish:" + this.hlU);
    this.hlY = bt.HI();
    this.hlZ.gFK.reset();
    Object localObject;
    if (ad.getLogLevel() > 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.b.e.xxi;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dFp()) {
        this.hlU = false;
      }
    }
    if (this.hlU)
    {
      localObject = com.tencent.mm.plugin.recordvideo.d.d.xHk;
      com.tencent.mm.plugin.recordvideo.d.d.dGN();
      localObject = this.hlS;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      this.hlS = com.tencent.mm.ad.c.a("MediaCodecRemux_audioMix", false, (d.g.a.a)new c(this));
      localObject = this.hlT;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      if (this.xvC != null) {
        this.hlT = com.tencent.mm.ad.c.a("MediaCodecRemux_videoMix", false, (d.g.a.a)new d(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75294);
      return 0;
      this.hlV = true;
    }
  }
  
  public final void k(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75293);
    p.h(paramb, "blendBitmapProvider");
    this.hkY = paramb;
    AppMethodBeat.o(75293);
  }
  
  public final void l(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75295);
    p.h(paramb, "blurBgProvider");
    AppMethodBeat.o(75295);
  }
  
  public final void y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75292);
    p.h(paramBitmap, "bitmap");
    AppMethodBeat.o(75292);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(75277);
      ad.i(e.a(this.xvF), "decode end after " + e.atT() + ", isFinishEncode:" + e.s(this.xvF));
      if (!e.s(this.xvF))
      {
        com.tencent.mm.media.k.d locald = com.tencent.mm.media.k.d.hoU;
        com.tencent.mm.media.k.d.avU();
        e.t(this.xvF);
      }
      AppMethodBeat.o(75277);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class e
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    e(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    f(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    g(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    h(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "succ", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements m<d, Boolean, z>
  {
    i(e parame, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends d.g.b.q
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, z>
    {
      a(e.i parami)
      {
        super();
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends d.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, z>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    k(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, z>
  {
    l(e parame)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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