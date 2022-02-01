package com.tencent.mm.plugin.recordvideo.background.a;

import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.media.d.f;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.a.m;
import d.g.a.q;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "getUseX264Encode", "()Z", "setUseX264Encode", "(Z)V", "videoDuration", "videoFps", "videoMixHandlerThread", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "blurBgProvider", "Companion", "plugin-recordvideo_release"})
public final class e
  extends com.tencent.mm.media.h.d
  implements com.tencent.mm.media.h.c
{
  private static final long gUy = 1000L;
  private static final long gUz = 1000L;
  public static final e.a wnO;
  private final String TAG;
  private int gNB;
  private int gNK;
  private volatile boolean gNu;
  private volatile boolean gRb;
  private d.g.a.b<? super Long, Bitmap> gSX;
  private int gTG;
  private int gTH;
  private long gTJ;
  private com.tencent.mm.media.d.b gTK;
  private com.tencent.mm.media.d.g gTL;
  private com.tencent.mm.media.a.a gTM;
  private com.tencent.mm.media.h.i gTO;
  private com.tencent.mm.media.e.a gTP;
  private com.tencent.mm.media.e.a gTQ;
  private HandlerThread gTR;
  private HandlerThread gTS;
  private boolean gTT;
  private boolean gTU;
  private com.tencent.mm.media.h.g gTV;
  private long gTX;
  private final com.tencent.mm.media.j.a gTY;
  private boolean gTZ;
  private boolean gUa;
  private boolean gUb;
  private int gUc;
  private int gUd;
  private final Runnable gUj;
  private final String gUk;
  private int gUm;
  private int gUn;
  private int gUo;
  private int gUq;
  private d.g.a.b<? super String, y> gUx;
  private int grA;
  private int grB;
  private final String outputFilePath;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  private ArrayList<String> wnH;
  private d wnM;
  boolean wnN;
  
  static
  {
    AppMethodBeat.i(75300);
    wnO = new e.a((byte)0);
    gUy = 1000L;
    gUz = 1000L;
    AppMethodBeat.o(75300);
  }
  
  public e(String paramString1, final ArrayList<String> paramArrayList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, boolean paramBoolean, d.g.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(75299);
    this.gUk = paramString1;
    this.wnH = paramArrayList;
    this.gNK = paramInt1;
    this.outputFilePath = paramString2;
    this.grA = paramInt2;
    this.grB = paramInt3;
    this.gUm = paramInt4;
    this.gUn = paramInt5;
    this.gUo = paramInt6;
    this.gUq = paramInt7;
    this.wnN = paramBoolean;
    this.gUx = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxerFake";
    this.videoDuration = -1;
    this.gTJ = paramLong1;
    this.remuxEndTime = -1L;
    this.gTY = new com.tencent.mm.media.j.a("remuxCost");
    paramString1 = this.wnH.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (com.tencent.mm.vfs.i.eA((String)paramString1.next()));
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((paramInt1 == 0) || (bs.isNullOrNil(this.outputFilePath)) || (this.grA <= 0) || (this.grB <= 0))
      {
        ac.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.grA + ", outputHeight:" + this.grB + ", videoFps:" + this.videoFps + ", outputFps:" + this.gUq);
        paramString1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asG();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(75299);
        throw paramString1;
      }
      paramString1 = com.tencent.mm.media.j.d.gWO;
      com.tencent.mm.media.j.d.np(this.gNK);
      com.tencent.mm.vfs.i.aSh(com.tencent.mm.vfs.i.aSs(this.outputFilePath));
      com.tencent.mm.plugin.recordvideo.b.e.wps.duW();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.wps;
      this.gTG = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.wps;
      this.gTH = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.wps;
      this.videoFps = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.wps;
      this.videoDuration = com.tencent.mm.plugin.recordvideo.b.e.duT();
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        if (!this.wnN) {
          break label1041;
        }
        ac.i(this.TAG, "mixMuxerController init useX264Encode, bitrate %s, width %s, height %s, fps %s", new Object[] { Integer.valueOf(this.gUm), Integer.valueOf(this.grA), Integer.valueOf(this.grB), Integer.valueOf(this.gUq) });
        paramString1 = new com.tencent.mm.media.h.i(this.gTJ, this.remuxEndTime, this.gUm, this.grA, this.grB, this.wnN, this.gUq);
        label486:
        this.gTO = paramString1;
        ac.m(this.TAG, "create MediaCodecRemuxer, outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.gTG + ", inputHeight: " + this.gTH + ", videoFps: " + this.videoFps + " ,outputBitrate :" + this.gUm + ", outputAudioBitrate:" + this.gUn + " , outputWidth: " + this.grA + ", outputHeight: " + this.grB + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.gUq + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.gTJ + " ,remuxEndTime: " + this.remuxEndTime, new Object[0]);
        this.gTQ = null;
        this.gTV = new com.tencent.mm.media.h.g(this.gTO, this.gTQ, this.outputFilePath, this.gNK, this.gUo);
        if (com.tencent.mm.vfs.i.eA(this.gUk))
        {
          paramString1 = this.gUk;
          if (paramString1 == null) {
            k.fOy();
          }
          paramString1 = new com.tencent.mm.media.e.a(paramString1);
          if (paramString1.gRM)
          {
            paramArrayList = com.tencent.mm.media.j.d.gWO;
            com.tencent.mm.media.j.d.asJ();
          }
          this.gTP = paramString1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.gUq > 0)
            {
              paramInt1 = Math.min(this.gUq, this.videoFps);
              paramArrayList = new com.tencent.mm.media.b.d();
              paramArrayList.bitrate = this.gUm;
              paramArrayList.frameRate = paramInt1;
              paramArrayList.gNV = this.grB;
              paramArrayList.gNU = this.grA;
              paramArrayList.gNZ = true;
              paramb = (m)new j(this);
              locala = (d.g.a.a)new k(this);
            }
          }
          catch (Exception paramString1)
          {
            final d.g.a.a locala;
            label1041:
            ac.printErrStackTrace(this.TAG, (Throwable)paramString1, "remux impl error", new Object[0]);
            continue;
            paramString1 = (com.tencent.mm.media.d.b)new com.tencent.mm.media.d.e(paramArrayList, (d.g.a.b)new f(paramb, locala));
            continue;
            paramString1 = (com.tencent.mm.media.d.b)new com.tencent.mm.media.d.e(paramArrayList, (d.g.a.b)new h(paramb, locala));
            continue;
            ac.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder error", new Object[0]);
            paramString1 = com.tencent.mm.media.j.d.gWO;
            com.tencent.mm.media.j.d.asK();
            duL();
            paramString1 = com.tencent.mm.plugin.recordvideo.d.d.wyq;
            com.tencent.mm.plugin.recordvideo.d.d.dwu();
            continue;
            paramString1 = null;
            continue;
          }
          try
          {
            if (this.wnN)
            {
              ac.i(this.TAG, "useX264Encode");
              this.gTL = new com.tencent.mm.media.d.g(this.gTO.gNJ, paramArrayList.gNU, paramArrayList.gNV);
              paramString1 = this.gTL;
              if (paramString1 != null) {
                paramString1.start();
              }
              if ((this.gTL != null) || (this.gTK != null))
              {
                if (this.gTK == null) {
                  continue;
                }
                paramString1 = this.gTK;
                if (paramString1 == null) {
                  k.fOy();
                }
                paramString1 = paramString1.getInputSurface();
                this.wnM = new d(this.wnH, this.gTJ, this.remuxEndTime, paramString1, this.grA, this.grB, this.wnN, this.gUq, (m)new i(this, paramArrayList));
              }
              this.gUj = ((Runnable)new b(this));
              AppMethodBeat.o(75299);
              return;
              this.remuxEndTime = paramLong2;
              break;
              paramString1 = new com.tencent.mm.media.h.i(this.gTJ, this.remuxEndTime, this.gUm, this.wnN);
              break label486;
              paramInt1 = this.videoFps;
              continue;
            }
            if (!com.tencent.mm.compatible.util.d.kZ(23)) {
              continue;
            }
            paramString1 = (com.tencent.mm.media.d.b)new f(paramArrayList, (d.g.a.b)new e(paramb, locala));
            this.gTK = paramString1;
            continue;
            paramArrayList.gNZ = false;
          }
          catch (Exception paramString2)
          {
            if (!paramArrayList.gNZ) {
              continue;
            }
          }
        }
        try
        {
          if (!com.tencent.mm.compatible.util.d.kZ(23)) {
            continue;
          }
          paramString1 = (com.tencent.mm.media.d.b)new f(paramArrayList, (d.g.a.b)new g(paramb, locala));
          this.gTK = paramString1;
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.wyq;
          com.tencent.mm.plugin.recordvideo.d.d.dwv();
        }
        catch (Exception paramString1)
        {
          ac.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder again error", new Object[0]);
          paramString1 = com.tencent.mm.media.j.d.gWO;
          com.tencent.mm.media.j.d.asK();
          duL();
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.wyq;
          com.tencent.mm.plugin.recordvideo.d.d.dwu();
        }
      }
    }
  }
  
  private final void aqE()
  {
    AppMethodBeat.i(75296);
    ac.i(this.TAG, "finishEncode %s", new Object[] { Boolean.valueOf(this.wnN) });
    Object localObject;
    if (this.wnN)
    {
      localObject = this.gTL;
      if (localObject != null) {
        com.tencent.mm.media.d.g.a((com.tencent.mm.media.d.g)localObject);
      }
      ec(true);
    }
    for (;;)
    {
      ap.aB(this.gUj);
      this.gRb = true;
      AppMethodBeat.o(75296);
      return;
      localObject = this.gTK;
      if (localObject != null) {
        ((com.tencent.mm.media.d.b)localObject).aqE();
      }
    }
  }
  
  private final void duL()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75298);
        ac.i(this.TAG, "onDecoderEncoderFailed, isDecoder:false");
        if (!this.gTZ)
        {
          this.gTY.aic();
          this.gTZ = true;
          try
          {
            localObject1 = this.gTQ;
            if (localObject1 != null) {
              ((com.tencent.mm.media.e.a)localObject1).release();
            }
            localObject1 = this.gTR;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.gTS;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            com.tencent.mm.vfs.i.deleteFile(this.outputFilePath);
            long l = bs.aO(this.gTX);
            ac.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Object localObject1;
            ac.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.gUx;
          if (localObject1 != null)
          {
            ((d.g.a.b)localObject1).ay(null);
            AppMethodBeat.o(75298);
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(75298);
    }
  }
  
  private final void ec(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      long l;
      com.tencent.mm.media.j.d locald;
      try
      {
        AppMethodBeat.i(75297);
        ac.i(this.TAG, "finishRemux, isVideo: " + paramBoolean + ", isAudioRemuxFinish:" + this.gUb + ", isVideoRemuxFinish:" + this.gUa + ", isInvokeEndCallback:" + this.gTZ);
        if (paramBoolean)
        {
          this.gUa = true;
          if ((!this.gUb) || (!this.gUa) || (this.gTZ)) {
            break label374;
          }
          this.gTY.aic();
          this.gTZ = true;
          localObject1 = this.gTQ;
          if (localObject1 != null) {
            ((com.tencent.mm.media.e.a)localObject1).release();
          }
          localObject1 = this.gTV;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.h.g)localObject1).gUS;
            if (localObject1 != null) {
              ((d.g.a.b)localObject1).ay(this.gUx);
            }
          }
          localObject1 = this.gTR;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          localObject1 = this.gTS;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          l = bs.aO(this.gTX);
          ac.i(this.TAG, "remux used " + l + " decodeFrame:" + this.gUc + ", encodeFrame:" + this.gNB + ", drawFrameCount:" + this.gUd);
        }
      }
      finally {}
      try
      {
        localObject1 = com.tencent.mm.plugin.sight.base.e.asx(this.outputFilePath);
        if (localObject1 == null) {
          break label374;
        }
        locald = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.w(this.gNK, l);
        locald = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.f(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate, this.videoFps);
        if (this.gUc / this.gNB < 1.5D) {
          break label374;
        }
        localObject1 = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.asT();
        AppMethodBeat.o(75297);
        return;
      }
      catch (Exception localException) {}
      this.gUb = true;
      continue;
      label374:
      AppMethodBeat.o(75297);
    }
  }
  
  public final int arc()
  {
    AppMethodBeat.i(75294);
    ac.i(this.TAG, "start remux, initFinish:" + this.gTT);
    this.gTX = bs.Gn();
    this.gTY.gma.reset();
    Object localObject;
    if (ac.getLogLevel() > 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.b.e.wps;
      if (!com.tencent.mm.plugin.recordvideo.b.e.duU()) {
        this.gTT = false;
      }
    }
    if (this.gTT)
    {
      localObject = com.tencent.mm.plugin.recordvideo.d.d.wyq;
      com.tencent.mm.plugin.recordvideo.d.d.dwt();
      localObject = this.gTR;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      this.gTR = com.tencent.mm.ac.c.a("MediaCodecRemux_audioMix", false, (d.g.a.a)new c(this));
      localObject = this.gTS;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      if (this.wnM != null) {
        this.gTS = com.tencent.mm.ac.c.a("MediaCodecRemux_videoMix", false, (d.g.a.a)new d(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75294);
      return 0;
      this.gTU = true;
    }
  }
  
  public final void j(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75293);
    k.h(paramb, "blendBitmapProvider");
    this.gSX = paramb;
    AppMethodBeat.o(75293);
  }
  
  public final void k(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75295);
    k.h(paramb, "blurBgProvider");
    AppMethodBeat.o(75295);
  }
  
  public final void y(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75292);
    k.h(paramBitmap, "bitmap");
    AppMethodBeat.o(75292);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(75277);
      ac.i(e.a(this.wnP), "decode end after " + e.arg() + ", isFinishEncode:" + e.s(this.wnP));
      if (!e.s(this.wnP))
      {
        com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gWO;
        com.tencent.mm.media.j.d.ath();
        e.t(this.wnP);
      }
      AppMethodBeat.o(75277);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    e(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    f(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    g(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    h(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "succ", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements m<d, Boolean, y>
  {
    i(e parame, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, y>
    {
      a(e.i parami)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(e.i parami)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends d.g.b.l
    implements m<ByteBuffer, MediaCodec.BufferInfo, y>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends d.g.b.l
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, y>
  {
    l(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class m
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    m(e parame, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.a.e
 * JD-Core Version:    0.7.0.1
 */