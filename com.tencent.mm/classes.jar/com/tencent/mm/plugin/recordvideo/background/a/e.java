package com.tencent.mm.plugin.recordvideo.background.a;

import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.media.d.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.a.m;
import d.g.a.q;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "getUseX264Encode", "()Z", "setUseX264Encode", "(Z)V", "videoDuration", "videoFps", "videoMixHandlerThread", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "blurBgProvider", "Companion", "plugin-recordvideo_release"})
public final class e
  extends com.tencent.mm.media.h.d
  implements com.tencent.mm.media.h.c
{
  private static final long gtT = 1000L;
  private static final long gtU = 1000L;
  public static final e.a vfb;
  private final String TAG;
  private volatile boolean gmH;
  private int gmO;
  private int gmX;
  private volatile boolean gqt;
  private int gsY;
  private int gsZ;
  private d.g.a.b<? super Long, Bitmap> gsq;
  private final Runnable gtB;
  private final String gtC;
  private int gtF;
  private int gtG;
  private int gtH;
  private int gtI;
  private int gtJ;
  private int gtL;
  private d.g.a.b<? super String, y> gtS;
  private long gtb;
  private com.tencent.mm.media.d.b gtc;
  private com.tencent.mm.media.d.g gtd;
  private com.tencent.mm.media.a.a gte;
  private com.tencent.mm.media.h.i gtg;
  private com.tencent.mm.media.e.a gth;
  private com.tencent.mm.media.e.a gti;
  private HandlerThread gtj;
  private HandlerThread gtk;
  private boolean gtl;
  private boolean gtm;
  private com.tencent.mm.media.h.g gtn;
  private long gtp;
  private final com.tencent.mm.media.j.a gtq;
  private boolean gtr;
  private boolean gts;
  private boolean gtt;
  private int gtu;
  private int gtv;
  private final String outputFilePath;
  private long remuxEndTime;
  private ArrayList<String> veU;
  private d veZ;
  boolean vfa;
  private int videoDuration;
  private int videoFps;
  
  static
  {
    AppMethodBeat.i(75300);
    vfb = new e.a((byte)0);
    gtT = 1000L;
    gtU = 1000L;
    AppMethodBeat.o(75300);
  }
  
  public e(String paramString1, final ArrayList<String> paramArrayList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, boolean paramBoolean, d.g.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(75299);
    this.gtC = paramString1;
    this.veU = paramArrayList;
    this.gmX = paramInt1;
    this.outputFilePath = paramString2;
    this.gtF = paramInt2;
    this.gtG = paramInt3;
    this.gtH = paramInt4;
    this.gtI = paramInt5;
    this.gtJ = paramInt6;
    this.gtL = paramInt7;
    this.vfa = paramBoolean;
    this.gtS = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxerFake";
    this.videoDuration = -1;
    this.gtb = paramLong1;
    this.remuxEndTime = -1L;
    this.gtq = new com.tencent.mm.media.j.a("remuxCost");
    paramString1 = this.veU.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (com.tencent.mm.vfs.i.eK((String)paramString1.next()));
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((paramInt1 == 0) || (bt.isNullOrNil(this.outputFilePath)) || (this.gtF <= 0) || (this.gtG <= 0))
      {
        ad.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.gtF + ", outputHeight:" + this.gtG + ", videoFps:" + this.videoFps + ", outputFps:" + this.gtL);
        paramString1 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.alM();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(75299);
        throw paramString1;
      }
      paramString1 = com.tencent.mm.media.j.d.gwr;
      com.tencent.mm.media.j.d.mB(this.gmX);
      com.tencent.mm.vfs.i.aMF(com.tencent.mm.vfs.i.aMQ(this.outputFilePath));
      com.tencent.mm.plugin.recordvideo.b.e.vgG.dhq();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      this.gsY = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      this.gsZ = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      this.videoFps = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      this.videoDuration = com.tencent.mm.plugin.recordvideo.b.e.dhm();
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        if (!this.vfa) {
          break label1041;
        }
        ad.i(this.TAG, "mixMuxerController init useX264Encode, bitrate %s, width %s, height %s, fps %s", new Object[] { Integer.valueOf(this.gtH), Integer.valueOf(this.gtF), Integer.valueOf(this.gtG), Integer.valueOf(this.gtL) });
        paramString1 = new com.tencent.mm.media.h.i(this.gtb, this.remuxEndTime, this.gtH, this.gtF, this.gtG, this.vfa, this.gtL);
        label486:
        this.gtg = paramString1;
        ad.m(this.TAG, "create MediaCodecRemuxer, outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.gsY + ", inputHeight: " + this.gsZ + ", videoFps: " + this.videoFps + " ,outputBitrate :" + this.gtH + ", outputAudioBitrate:" + this.gtI + " , outputWidth: " + this.gtF + ", outputHeight: " + this.gtG + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.gtL + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.gtb + " ,remuxEndTime: " + this.remuxEndTime, new Object[0]);
        this.gti = null;
        this.gtn = new com.tencent.mm.media.h.g(this.gtg, this.gti, this.outputFilePath, this.gmX, this.gtJ);
        if (com.tencent.mm.vfs.i.eK(this.gtC))
        {
          paramString1 = this.gtC;
          if (paramString1 == null) {
            k.fvU();
          }
          paramString1 = new com.tencent.mm.media.e.a(paramString1);
          if (paramString1.gre)
          {
            paramArrayList = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.alR();
          }
          this.gth = paramString1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.gtL > 0)
            {
              paramInt1 = Math.min(this.gtL, this.videoFps);
              paramArrayList = new com.tencent.mm.media.b.d();
              paramArrayList.bitrate = this.gtH;
              paramArrayList.frameRate = paramInt1;
              paramArrayList.gni = this.gtG;
              paramArrayList.gnh = this.gtF;
              paramArrayList.gnn = true;
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
            paramString1 = (com.tencent.mm.media.d.b)new com.tencent.mm.media.d.e(paramArrayList, (d.g.a.b)new f(paramb, locala));
            continue;
            paramString1 = (com.tencent.mm.media.d.b)new com.tencent.mm.media.d.e(paramArrayList, (d.g.a.b)new h(paramb, locala));
            continue;
            ad.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder error", new Object[0]);
            paramString1 = com.tencent.mm.media.j.d.gwr;
            com.tencent.mm.media.j.d.alS();
            dhd();
            paramString1 = com.tencent.mm.plugin.recordvideo.d.c.vpz;
            com.tencent.mm.plugin.recordvideo.d.c.diB();
            continue;
            paramString1 = null;
            continue;
          }
          try
          {
            if (this.vfa)
            {
              ad.i(this.TAG, "useX264Encode");
              this.gtd = new com.tencent.mm.media.d.g(this.gtg.gmW, paramArrayList.gnh, paramArrayList.gni);
              paramString1 = this.gtd;
              if (paramString1 != null) {
                paramString1.start();
              }
              if ((this.gtd != null) || (this.gtc != null))
              {
                if (this.gtc == null) {
                  continue;
                }
                paramString1 = this.gtc;
                if (paramString1 == null) {
                  k.fvU();
                }
                paramString1 = paramString1.getInputSurface();
                this.veZ = new d(this.veU, this.gtb, this.remuxEndTime, paramString1, this.gtF, this.gtG, this.vfa, this.gtL, (m)new i(this, paramArrayList));
              }
              this.gtB = ((Runnable)new b(this));
              AppMethodBeat.o(75299);
              return;
              this.remuxEndTime = paramLong2;
              break;
              paramString1 = new com.tencent.mm.media.h.i(this.gtb, this.remuxEndTime, this.gtH, this.vfa);
              break label486;
              paramInt1 = this.videoFps;
              continue;
            }
            if (!com.tencent.mm.compatible.util.d.lf(23)) {
              continue;
            }
            paramString1 = (com.tencent.mm.media.d.b)new f(paramArrayList, (d.g.a.b)new e(paramb, locala));
            this.gtc = paramString1;
            continue;
            paramArrayList.gnn = false;
          }
          catch (Exception paramString2)
          {
            if (!paramArrayList.gnn) {
              continue;
            }
          }
        }
        try
        {
          if (!com.tencent.mm.compatible.util.d.lf(23)) {
            continue;
          }
          paramString1 = (com.tencent.mm.media.d.b)new f(paramArrayList, (d.g.a.b)new g(paramb, locala));
          this.gtc = paramString1;
          paramString1 = com.tencent.mm.plugin.recordvideo.d.c.vpz;
          com.tencent.mm.plugin.recordvideo.d.c.diC();
        }
        catch (Exception paramString1)
        {
          ad.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder again error", new Object[0]);
          paramString1 = com.tencent.mm.media.j.d.gwr;
          com.tencent.mm.media.j.d.alS();
          dhd();
          paramString1 = com.tencent.mm.plugin.recordvideo.d.c.vpz;
          com.tencent.mm.plugin.recordvideo.d.c.diB();
        }
      }
    }
  }
  
  private final void ajF()
  {
    AppMethodBeat.i(75296);
    ad.i(this.TAG, "finishEncode %s", new Object[] { Boolean.valueOf(this.vfa) });
    Object localObject;
    if (this.vfa)
    {
      localObject = this.gtd;
      if (localObject != null) {
        com.tencent.mm.media.d.g.a((com.tencent.mm.media.d.g)localObject);
      }
      dH(true);
    }
    for (;;)
    {
      aq.az(this.gtB);
      this.gqt = true;
      AppMethodBeat.o(75296);
      return;
      localObject = this.gtc;
      if (localObject != null) {
        ((com.tencent.mm.media.d.b)localObject).ajF();
      }
    }
  }
  
  private final void dH(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      long l;
      com.tencent.mm.media.j.d locald;
      try
      {
        AppMethodBeat.i(75297);
        ad.i(this.TAG, "finishRemux, isVideo: " + paramBoolean + ", isAudioRemuxFinish:" + this.gtt + ", isVideoRemuxFinish:" + this.gts + ", isInvokeEndCallback:" + this.gtr);
        if (paramBoolean)
        {
          this.gts = true;
          if ((!this.gtt) || (!this.gts) || (this.gtr)) {
            break label374;
          }
          this.gtq.agL();
          this.gtr = true;
          localObject1 = this.gti;
          if (localObject1 != null) {
            ((com.tencent.mm.media.e.a)localObject1).release();
          }
          localObject1 = this.gtn;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.h.g)localObject1).gun;
            if (localObject1 != null) {
              ((d.g.a.b)localObject1).aA(this.gtS);
            }
          }
          localObject1 = this.gtj;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          localObject1 = this.gtk;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          l = bt.aS(this.gtp);
          ad.i(this.TAG, "remux used " + l + " decodeFrame:" + this.gtu + ", encodeFrame:" + this.gmO + ", drawFrameCount:" + this.gtv);
        }
      }
      finally {}
      try
      {
        localObject1 = com.tencent.mm.plugin.sight.base.e.ano(this.outputFilePath);
        if (localObject1 == null) {
          break label374;
        }
        locald = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.x(this.gmX, l);
        locald = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.e(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate, this.videoFps);
        if (this.gtu / this.gmO < 1.5D) {
          break label374;
        }
        localObject1 = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.amb();
        AppMethodBeat.o(75297);
        return;
      }
      catch (Exception localException) {}
      this.gtt = true;
      continue;
      label374:
      AppMethodBeat.o(75297);
    }
  }
  
  private final void dhd()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75298);
        ad.i(this.TAG, "onDecoderEncoderFailed, isDecoder:false");
        if (!this.gtr)
        {
          this.gtq.agL();
          this.gtr = true;
          try
          {
            localObject1 = this.gti;
            if (localObject1 != null) {
              ((com.tencent.mm.media.e.a)localObject1).release();
            }
            localObject1 = this.gtj;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.gtk;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            com.tencent.mm.vfs.i.deleteFile(this.outputFilePath);
            long l = bt.aS(this.gtp);
            ad.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Object localObject1;
            ad.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.gtS;
          if (localObject1 != null)
          {
            ((d.g.a.b)localObject1).aA(null);
            AppMethodBeat.o(75298);
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(75298);
    }
  }
  
  public final int akd()
  {
    AppMethodBeat.i(75294);
    ad.i(this.TAG, "start remux, initFinish:" + this.gtl);
    this.gtp = bt.GC();
    this.gtq.ghu.reset();
    Object localObject;
    if (ad.getLogLevel() > 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.b.e.vgG;
      if (!com.tencent.mm.plugin.recordvideo.b.e.dho()) {
        this.gtl = false;
      }
    }
    if (this.gtl)
    {
      localObject = com.tencent.mm.plugin.recordvideo.d.c.vpz;
      com.tencent.mm.plugin.recordvideo.d.c.diA();
      localObject = this.gtj;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      this.gtj = com.tencent.mm.ad.c.a("MediaCodecRemux_audioMix", false, (d.g.a.a)new c(this));
      localObject = this.gtk;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      if (this.veZ != null) {
        this.gtk = com.tencent.mm.ad.c.a("MediaCodecRemux_videoMix", false, (d.g.a.a)new d(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75294);
      return 0;
      this.gtm = true;
    }
  }
  
  public final void e(d.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75293);
    k.h(paramb, "blendBitmapProvider");
    this.gsq = paramb;
    AppMethodBeat.o(75293);
  }
  
  public final void f(d.g.a.b<? super Long, Bitmap> paramb)
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(75277);
      ad.i(e.a(this.vfc), "decode end after " + e.aki() + ", isFinishEncode:" + e.s(this.vfc));
      if (!e.s(this.vfc))
      {
        com.tencent.mm.media.j.d locald = com.tencent.mm.media.j.d.gwr;
        com.tencent.mm.media.j.d.amp();
        e.t(this.vfc);
      }
      AppMethodBeat.o(75277);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    e(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    f(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    g(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    h(m paramm, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "succ", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements m<d, Boolean, y>
  {
    i(e parame, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, y>
    {
      a(e.i parami)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends d.g.b.l
    implements m<ByteBuffer, MediaCodec.BufferInfo, y>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class k
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    k(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends d.g.b.l
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, y>
  {
    l(e parame)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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