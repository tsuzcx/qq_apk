package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.media.e.h;
import com.tencent.mm.media.i.c;
import com.tencent.mm.media.i.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "getUseX264Encode", "()Z", "setUseX264Encode", "(Z)V", "videoDuration", "videoFps", "videoMixHandlerThread", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "blurBgProvider", "Companion", "plugin-recordvideo_release"})
public final class e
  extends com.tencent.mm.media.i.d
  implements c
{
  public static final e.a HHR;
  private static final long kXw = 1000L;
  private static final long kXx = 1000L;
  private ArrayList<String> HHJ;
  private d HHO;
  private h HHP;
  boolean HHQ;
  private final String TAG;
  private volatile boolean kRI;
  private int kRP;
  private int kRX;
  private volatile boolean kTR;
  private kotlin.g.a.b<? super Long, Bitmap> kVT;
  private int kWE;
  private int kWF;
  private com.tencent.mm.media.e.b kWH;
  private com.tencent.mm.media.a.a kWJ;
  private i kWL;
  private com.tencent.mm.media.f.a kWM;
  private com.tencent.mm.media.f.a kWN;
  private HandlerThread kWO;
  private HandlerThread kWP;
  private boolean kWQ;
  private boolean kWR;
  private com.tencent.mm.media.i.g kWS;
  private long kWU;
  private final com.tencent.mm.media.k.a kWV;
  private boolean kWW;
  private boolean kWX;
  private boolean kWY;
  private int kWZ;
  private long kWc;
  private int kXa;
  private final Runnable kXh;
  private final String kXi;
  private int kXk;
  private int kXl;
  private int kXm;
  private int kXo;
  private kotlin.g.a.b<? super String, x> kXv;
  private final String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  
  static
  {
    AppMethodBeat.i(75300);
    HHR = new e.a((byte)0);
    kXw = 1000L;
    kXx = 1000L;
    AppMethodBeat.o(75300);
  }
  
  public e(String paramString1, final ArrayList<String> paramArrayList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, boolean paramBoolean, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(75299);
    this.kXi = paramString1;
    this.HHJ = paramArrayList;
    this.kRX = paramInt1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt2;
    this.outputHeight = paramInt3;
    this.kXk = paramInt4;
    this.kXl = paramInt5;
    this.kXm = paramInt6;
    this.kXo = paramInt7;
    this.HHQ = paramBoolean;
    this.kXv = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxerFake";
    this.videoDuration = -1;
    this.kWc = paramLong1;
    this.remuxEndTime = -1L;
    this.kWV = new com.tencent.mm.media.k.a("remuxCost");
    paramString1 = this.HHJ.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (u.agG((String)paramString1.next()));
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((paramInt1 == 0) || (Util.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
      {
        Log.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.kXo);
        paramString1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aWZ();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(75299);
        throw paramString1;
      }
      paramString1 = com.tencent.mm.media.k.f.laB;
      com.tencent.mm.media.k.f.uf(this.kRX);
      u.bBD(u.bBT(this.outputFilePath));
      com.tencent.mm.plugin.recordvideo.b.f.HJU.fvF();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
      this.kWE = com.tencent.mm.plugin.recordvideo.b.f.getWidth();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
      this.kWF = com.tencent.mm.plugin.recordvideo.b.f.getHeight();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
      this.videoFps = com.tencent.mm.plugin.recordvideo.b.f.getFrameRate();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.f.HJU;
      this.videoDuration = com.tencent.mm.plugin.recordvideo.b.f.fvB();
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        if (!this.HHQ) {
          break label1041;
        }
        Log.i(this.TAG, "mixMuxerController init useX264Encode, bitrate %s, width %s, height %s, fps %s", new Object[] { Integer.valueOf(this.kXk), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight), Integer.valueOf(this.kXo) });
        paramString1 = new i(this.kWc, this.remuxEndTime, this.kXk, this.outputWidth, this.outputHeight, this.HHQ, this.kXo);
        label486:
        this.kWL = paramString1;
        Log.printInfoStack(this.TAG, "create MediaCodecRemuxer, outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.kWE + ", inputHeight: " + this.kWF + ", videoFps: " + this.videoFps + " ,outputBitrate :" + this.kXk + ", outputAudioBitrate:" + this.kXl + " , outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.kXo + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.kWc + " ,remuxEndTime: " + this.remuxEndTime, new Object[0]);
        this.kWN = null;
        this.kWS = new com.tencent.mm.media.i.g(this.kWL, this.kWN, this.outputFilePath, this.kRX, this.kXm);
        if (u.agG(this.kXi))
        {
          paramString1 = this.kXi;
          if (paramString1 == null) {
            p.iCn();
          }
          paramString1 = new com.tencent.mm.media.f.a(paramString1);
          if (paramString1.kUZ)
          {
            paramArrayList = com.tencent.mm.media.k.f.laB;
            com.tencent.mm.media.k.f.aXc();
          }
          this.kWM = paramString1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.kXo > 0)
            {
              paramInt1 = Math.min(this.kXo, this.videoFps);
              paramArrayList = new com.tencent.mm.media.b.d();
              paramArrayList.bitrate = this.kXk;
              paramArrayList.frameRate = paramInt1;
              paramArrayList.targetHeight = this.outputHeight;
              paramArrayList.targetWidth = this.outputWidth;
              paramArrayList.kSj = true;
              paramb = (m)new j(this);
              locala = (kotlin.g.a.a)new k(this);
            }
          }
          catch (Exception paramString1)
          {
            final kotlin.g.a.a locala;
            label1041:
            Log.printErrStackTrace(this.TAG, (Throwable)paramString1, "remux impl error", new Object[0]);
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.f(paramArrayList, (kotlin.g.a.b)new f(paramb, locala));
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.f(paramArrayList, (kotlin.g.a.b)new h(paramb, locala));
            continue;
            Log.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder error", new Object[0]);
            paramString1 = com.tencent.mm.media.k.f.laB;
            com.tencent.mm.media.k.f.aXd();
            fvo();
            paramString1 = com.tencent.mm.plugin.recordvideo.d.d.HUG;
            com.tencent.mm.plugin.recordvideo.d.d.fxu();
            continue;
            paramString1 = null;
            continue;
          }
          try
          {
            if (this.HHQ)
            {
              Log.i(this.TAG, "useX264Encode");
              this.HHP = new h(this.kWL.bufId, paramArrayList.targetWidth, paramArrayList.targetHeight);
              paramString1 = this.HHP;
              if (paramString1 != null) {
                paramString1.start();
              }
              if ((this.HHP != null) || (this.kWH != null))
              {
                if (this.kWH == null) {
                  continue;
                }
                paramString1 = this.kWH;
                if (paramString1 == null) {
                  p.iCn();
                }
                paramString1 = paramString1.aUA();
                this.HHO = new d(this.HHJ, this.kWc, this.remuxEndTime, paramString1, this.outputWidth, this.outputHeight, this.HHQ, this.kXo, (m)new i(this, paramArrayList));
              }
              this.kXh = ((Runnable)new b(this));
              AppMethodBeat.o(75299);
              return;
              this.remuxEndTime = paramLong2;
              break;
              paramString1 = new i(this.kWc, this.remuxEndTime, this.kXk, this.HHQ, null, 48);
              break label486;
              paramInt1 = this.videoFps;
              continue;
            }
            if (!com.tencent.mm.compatible.util.d.qV(23)) {
              continue;
            }
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.g(paramArrayList, (kotlin.g.a.b)new e(paramb, locala));
            this.kWH = paramString1;
            continue;
            paramArrayList.kSj = false;
          }
          catch (Exception paramString2)
          {
            if (!paramArrayList.kSj) {
              continue;
            }
          }
        }
        try
        {
          if (!com.tencent.mm.compatible.util.d.qV(23)) {
            continue;
          }
          paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.g(paramArrayList, (kotlin.g.a.b)new g(paramb, locala));
          this.kWH = paramString1;
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.HUG;
          com.tencent.mm.plugin.recordvideo.d.d.fxv();
        }
        catch (Exception paramString1)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder again error", new Object[0]);
          paramString1 = com.tencent.mm.media.k.f.laB;
          com.tencent.mm.media.k.f.aXd();
          fvo();
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.HUG;
          com.tencent.mm.plugin.recordvideo.d.d.fxu();
        }
      }
    }
  }
  
  private final void aUx()
  {
    AppMethodBeat.i(75296);
    Log.i(this.TAG, "finishEncode %s", new Object[] { Boolean.valueOf(this.HHQ) });
    Object localObject;
    if (this.HHQ)
    {
      localObject = this.HHP;
      if (localObject != null) {
        h.a((h)localObject);
      }
      fE(true);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.kXh);
      this.kTR = true;
      AppMethodBeat.o(75296);
      return;
      localObject = this.kWH;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).aUx();
      }
    }
  }
  
  private final void fE(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      long l;
      com.tencent.mm.media.k.f localf;
      try
      {
        AppMethodBeat.i(75297);
        Log.i(this.TAG, "finishRemux, isVideo: " + paramBoolean + ", isAudioRemuxFinish:" + this.kWY + ", isVideoRemuxFinish:" + this.kWX + ", isInvokeEndCallback:" + this.kWW);
        if (paramBoolean)
        {
          this.kWX = true;
          if ((!this.kWY) || (!this.kWX) || (this.kWW)) {
            break label374;
          }
          this.kWV.aIZ();
          this.kWW = true;
          localObject1 = this.kWN;
          if (localObject1 != null) {
            ((com.tencent.mm.media.f.a)localObject1).release();
          }
          localObject1 = this.kWS;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.i.g)localObject1).kXQ;
            if (localObject1 != null) {
              ((kotlin.g.a.b)localObject1).invoke(this.kXv);
            }
          }
          localObject1 = this.kWO;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          localObject1 = this.kWP;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          l = Util.ticksToNow(this.kWU);
          Log.i(this.TAG, "remux used " + l + " decodeFrame:" + this.kWZ + ", encodeFrame:" + this.kRP + ", drawFrameCount:" + this.kXa);
        }
      }
      finally {}
      try
      {
        localObject1 = com.tencent.mm.plugin.sight.base.f.aYg(this.outputFilePath);
        if (localObject1 == null) {
          break label374;
        }
        localf = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.y(this.kRX, l);
        localf = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.g(((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate, ((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate, this.videoFps);
        if (this.kWZ / this.kRP < 1.5D) {
          break label374;
        }
        localObject1 = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXm();
        AppMethodBeat.o(75297);
        return;
      }
      catch (Exception localException) {}
      this.kWY = true;
      continue;
      label374:
      AppMethodBeat.o(75297);
    }
  }
  
  private final void fvo()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75298);
        Log.i(this.TAG, "onDecoderEncoderFailed, isDecoder:false");
        if (!this.kWW)
        {
          this.kWV.aIZ();
          this.kWW = true;
          try
          {
            localObject1 = this.kWN;
            if (localObject1 != null) {
              ((com.tencent.mm.media.f.a)localObject1).release();
            }
            localObject1 = this.kWO;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.kWP;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            u.deleteFile(this.outputFilePath);
            long l = Util.ticksToNow(this.kWU);
            Log.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Object localObject1;
            Log.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.kXv;
          if (localObject1 != null)
          {
            ((kotlin.g.a.b)localObject1).invoke(null);
            AppMethodBeat.o(75298);
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(75298);
    }
  }
  
  public final void A(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75292);
    p.k(paramBitmap, "bitmap");
    AppMethodBeat.o(75292);
  }
  
  public final int aUW()
  {
    AppMethodBeat.i(75294);
    Log.i(this.TAG, "start remux, initFinish:" + this.kWQ);
    this.kWU = Util.currentTicks();
    this.kWV.khd.reset();
    Object localObject;
    if (Log.getLogLevel() > 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.b.f.HJU;
      if (!com.tencent.mm.plugin.recordvideo.b.f.fvC()) {
        this.kWQ = false;
      }
    }
    if (this.kWQ)
    {
      localObject = com.tencent.mm.plugin.recordvideo.d.d.HUG;
      com.tencent.mm.plugin.recordvideo.d.d.fxt();
      localObject = this.kWO;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      this.kWO = com.tencent.mm.ae.d.a("MediaCodecRemux_audioMix", false, (kotlin.g.a.a)new c(this));
      localObject = this.kWP;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      if (this.HHO != null) {
        this.kWP = com.tencent.mm.ae.d.a("MediaCodecRemux_videoMix", false, (kotlin.g.a.a)new d(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75294);
      return 0;
      this.kWR = true;
    }
  }
  
  public final void k(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75293);
    p.k(paramb, "blendBitmapProvider");
    this.kVT = paramb;
    AppMethodBeat.o(75293);
  }
  
  public final void l(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75295);
    p.k(paramb, "blurBgProvider");
    AppMethodBeat.o(75295);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(75277);
      Log.i(e.a(this.HHS), "decode end after " + e.aVd() + ", isFinishEncode:" + e.u(this.HHS));
      if (!e.u(this.HHS))
      {
        com.tencent.mm.media.k.f localf = com.tencent.mm.media.k.f.laB;
        com.tencent.mm.media.k.f.aXA();
        e.v(this.HHS);
      }
      AppMethodBeat.o(75277);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    e(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    f(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    g(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    h(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "succ", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements m<d, Boolean, x>
  {
    i(e parame, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x>
    {
      a(e.i parami)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(e.i parami)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, x>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x>
  {
    l(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    m(e parame, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.e
 * JD-Core Version:    0.7.0.1
 */