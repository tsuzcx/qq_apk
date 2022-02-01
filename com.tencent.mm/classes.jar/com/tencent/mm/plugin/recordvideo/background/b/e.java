package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.e.g;
import com.tencent.mm.media.i.c;
import com.tencent.mm.media.i.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "getUseX264Encode", "()Z", "setUseX264Encode", "(Z)V", "videoDuration", "videoFps", "videoMixHandlerThread", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "blurBgProvider", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c
  implements com.tencent.mm.media.i.b
{
  public static final e.a NFh;
  private static final long nCI;
  private static final long nCJ;
  private ArrayList<String> NEX;
  boolean NFi;
  private d NFj;
  private g NFk;
  private final String TAG;
  private int inputHeight;
  private int inputWidth;
  private final String nBT;
  private int nBU;
  private int nBV;
  private int nBW;
  private int nBY;
  private kotlin.g.a.b<? super Long, Bitmap> nBp;
  private long nBy;
  private int nCA;
  private final Runnable nCH;
  private kotlin.g.a.b<? super String, ah> nCf;
  private com.tencent.mm.media.e.b nCh;
  private com.tencent.mm.media.a.a nCj;
  private h nCl;
  private com.tencent.mm.media.f.a nCm;
  private com.tencent.mm.media.f.a nCn;
  private HandlerThread nCo;
  private HandlerThread nCp;
  private boolean nCq;
  private boolean nCr;
  private com.tencent.mm.media.i.f nCs;
  private long nCu;
  private final com.tencent.mm.media.util.a nCv;
  private boolean nCw;
  private boolean nCx;
  private boolean nCy;
  private int nCz;
  private int nxj;
  private volatile boolean nxq;
  private int nxx;
  private volatile boolean nzA;
  private final String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  
  static
  {
    AppMethodBeat.i(75300);
    NFh = new e.a((byte)0);
    nCI = 1000L;
    nCJ = 1000L;
    AppMethodBeat.o(75300);
  }
  
  public e(String paramString1, final ArrayList<String> paramArrayList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, boolean paramBoolean, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(75299);
    this.nBT = paramString1;
    this.NEX = paramArrayList;
    this.nxj = paramInt1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt2;
    this.outputHeight = paramInt3;
    this.nBU = paramInt4;
    this.nBV = paramInt5;
    this.nBW = paramInt6;
    this.nBY = paramInt7;
    this.NFi = paramBoolean;
    this.nCf = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxerFake";
    this.videoDuration = -1;
    this.nBy = paramLong1;
    this.remuxEndTime = -1L;
    this.nCv = new com.tencent.mm.media.util.a("remuxCost");
    paramString1 = this.NEX.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (y.ZC((String)paramString1.next()));
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((paramInt1 == 0) || (Util.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
      {
        Log.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.nBY);
        paramString1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brH();
        paramString1 = new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(75299);
        throw paramString1;
      }
      paramString1 = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.ue(this.nxj);
      y.bDX(y.bEo(this.outputFilePath));
      com.tencent.mm.plugin.recordvideo.c.f.NGM.gHt();
      paramString1 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      this.inputWidth = com.tencent.mm.plugin.recordvideo.c.f.getWidth();
      paramString1 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      this.inputHeight = com.tencent.mm.plugin.recordvideo.c.f.getHeight();
      paramString1 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      this.videoFps = com.tencent.mm.plugin.recordvideo.c.f.getFrameRate();
      paramString1 = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      this.videoDuration = com.tencent.mm.plugin.recordvideo.c.f.gHp();
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        if (!this.NFi) {
          break label1039;
        }
        Log.i(this.TAG, "mixMuxerController init useX264Encode, bitrate %s, width %s, height %s, fps %s", new Object[] { Integer.valueOf(this.nBU), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight), Integer.valueOf(this.nBY) });
        paramString1 = new h(this.nBy, this.remuxEndTime, this.nBU, this.outputWidth, this.outputHeight, this.NFi, this.nBY);
        label483:
        this.nCl = paramString1;
        paramString1 = this.TAG;
        paramArrayList = new StringBuilder();
        paramArrayList.append("create MediaCodecRemuxer, outputFilePath: ").append(this.outputFilePath).append(", inputWidth: ").append(this.inputWidth).append(", inputHeight: ").append(this.inputHeight).append(", videoFps: ").append(this.videoFps).append(" ,outputBitrate :").append(this.nBU).append(", outputAudioBitrate:").append(this.nBV).append(" , outputWidth: ").append(this.outputWidth).append(", outputHeight: ").append(this.outputHeight).append(", startTimeMs: ").append(paramLong1).append(", endTimeMs: ").append(paramLong2).append(" , outputFps: ").append(this.nBY).append(" , videoDuration: ");
        paramArrayList.append(this.videoDuration).append(" , remuxStartTime: ").append(this.nBy).append(" ,remuxEndTime: ").append(this.remuxEndTime);
        Log.printInfoStack(paramString1, paramArrayList.toString(), new Object[0]);
        this.nCn = null;
        this.nCs = new com.tencent.mm.media.i.f(this.nCl, this.nCn, this.outputFilePath, this.nxj, this.nBW);
        if (y.ZC(this.nBT))
        {
          paramString1 = this.nBT;
          s.checkNotNull(paramString1);
          paramString1 = new com.tencent.mm.media.f.a(paramString1);
          if (paramString1.hasError)
          {
            paramArrayList = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.brK();
          }
          paramArrayList = ah.aiuX;
          this.nCm = paramString1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.nBY > 0)
            {
              paramInt1 = Math.min(this.nBY, this.videoFps);
              paramArrayList = new com.tencent.mm.media.b.d();
              paramArrayList.bitrate = this.nBU;
              paramArrayList.frameRate = paramInt1;
              paramArrayList.nxP = this.outputHeight;
              paramArrayList.nxO = this.outputWidth;
              paramArrayList.nxS = true;
              paramb = (m)new i(this);
              locala = (kotlin.g.a.a)new j(this);
            }
          }
          catch (Exception paramString1)
          {
            final kotlin.g.a.a locala;
            label1039:
            Log.printErrStackTrace(this.TAG, (Throwable)paramString1, "remux impl error", new Object[0]);
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e(paramArrayList, (kotlin.g.a.b)new e(paramb, locala));
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e(paramArrayList, (kotlin.g.a.b)new g(paramb, locala));
            continue;
            Log.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder error", new Object[0]);
            paramString1 = com.tencent.mm.media.util.f.nFE;
            com.tencent.mm.media.util.f.brL();
            gHe();
            paramString1 = com.tencent.mm.plugin.recordvideo.f.d.NRp;
            com.tencent.mm.plugin.recordvideo.f.d.gJj();
            continue;
            paramString1 = null;
            continue;
          }
          try
          {
            if (this.NFi)
            {
              Log.i(this.TAG, "useX264Encode");
              this.NFk = new g(this.nCl.bufId, paramArrayList.nxO, paramArrayList.nxP);
              paramString1 = this.NFk;
              if (paramString1 != null) {
                paramString1.start();
              }
              if ((this.NFk != null) || (this.nCh != null))
              {
                if (this.nCh == null) {
                  continue;
                }
                paramString1 = this.nCh;
                s.checkNotNull(paramString1);
                paramString1 = paramString1.bph();
                this.NFj = new d(this.NEX, this.nBy, this.remuxEndTime, paramString1, this.outputWidth, this.outputHeight, this.NFi, this.nBY, (m)new h(this, paramArrayList));
              }
              this.nCH = new e..ExternalSyntheticLambda0(this);
              AppMethodBeat.o(75299);
              return;
              this.remuxEndTime = paramLong2;
              break;
              paramString1 = new h(this.nBy, this.remuxEndTime, this.nBU, this.NFi, null, 48);
              break label483;
              paramInt1 = this.videoFps;
              continue;
            }
            if (!com.tencent.mm.compatible.util.d.rb(23)) {
              continue;
            }
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.f(paramArrayList, (kotlin.g.a.b)new d(paramb, locala));
            this.nCh = paramString1;
            continue;
            paramArrayList.nxS = false;
          }
          catch (Exception paramString2)
          {
            if (!paramArrayList.nxS) {
              continue;
            }
          }
        }
        try
        {
          if (!com.tencent.mm.compatible.util.d.rb(23)) {
            continue;
          }
          paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.f(paramArrayList, (kotlin.g.a.b)new f(paramb, locala));
          this.nCh = paramString1;
          paramString1 = com.tencent.mm.plugin.recordvideo.f.d.NRp;
          com.tencent.mm.plugin.recordvideo.f.d.gJk();
        }
        catch (Exception paramString1)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder again error", new Object[0]);
          paramString1 = com.tencent.mm.media.util.f.nFE;
          com.tencent.mm.media.util.f.brL();
          gHe();
          paramString1 = com.tencent.mm.plugin.recordvideo.f.d.NRp;
          com.tencent.mm.plugin.recordvideo.f.d.gJj();
        }
      }
    }
  }
  
  private static final void a(e parame)
  {
    AppMethodBeat.i(279506);
    s.u(parame, "this$0");
    Log.i(parame.TAG, "decode end after " + nCJ + ", isFinishEncode:" + parame.nzA);
    if (!parame.nzA)
    {
      com.tencent.mm.media.util.f localf = com.tencent.mm.media.util.f.nFE;
      com.tencent.mm.media.util.f.bsi();
      parame.boZ();
    }
    AppMethodBeat.o(279506);
  }
  
  private final void boZ()
  {
    AppMethodBeat.i(75296);
    Log.i(this.TAG, "finishEncode %s", new Object[] { Boolean.valueOf(this.NFi) });
    Object localObject;
    if (this.NFi)
    {
      localObject = this.NFk;
      if (localObject != null) {
        g.a((g)localObject);
      }
      go(true);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.nCH);
      this.nzA = true;
      AppMethodBeat.o(75296);
      return;
      localObject = this.nCh;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).boZ();
      }
    }
  }
  
  private final void gHe()
  {
    try
    {
      AppMethodBeat.i(75298);
      Log.i(this.TAG, s.X("onDecoderEncoderFailed, isDecoder:", Boolean.FALSE));
      if (!this.nCw)
      {
        this.nCv.bbW();
        this.nCw = true;
      }
      try
      {
        localObject1 = this.nCn;
        if (localObject1 != null) {
          ((com.tencent.mm.media.f.a)localObject1).release();
        }
        localObject1 = this.nCo;
        if (localObject1 != null) {
          ((HandlerThread)localObject1).quit();
        }
        localObject1 = this.nCp;
        if (localObject1 != null) {
          ((HandlerThread)localObject1).quit();
        }
        y.deleteFile(this.outputFilePath);
        long l = Util.ticksToNow(this.nCu);
        Log.i(this.TAG, s.X("onDecoderEncoderFailed, finish, costTime:", Long.valueOf(l)));
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1;
          Log.printErrStackTrace(this.TAG, (Throwable)localException, s.X("onDecoderEncoderFailed error:", localException.getMessage()), new Object[0]);
        }
      }
      localObject1 = this.nCf;
      if (localObject1 != null) {
        ((kotlin.g.a.b)localObject1).invoke(null);
      }
      AppMethodBeat.o(75298);
      return;
    }
    finally {}
  }
  
  private final void go(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      long l;
      com.tencent.mm.media.util.f localf;
      try
      {
        AppMethodBeat.i(75297);
        Log.i(this.TAG, "finishRemux, isVideo: " + paramBoolean + ", isAudioRemuxFinish:" + this.nCy + ", isVideoRemuxFinish:" + this.nCx + ", isInvokeEndCallback:" + this.nCw);
        if (paramBoolean)
        {
          this.nCx = true;
          if ((!this.nCy) || (!this.nCx) || (this.nCw)) {
            break label374;
          }
          this.nCv.bbW();
          this.nCw = true;
          localObject1 = this.nCn;
          if (localObject1 != null) {
            ((com.tencent.mm.media.f.a)localObject1).release();
          }
          localObject1 = this.nCs;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.i.f)localObject1).nCY;
            if (localObject1 != null) {
              ((kotlin.g.a.b)localObject1).invoke(this.nCf);
            }
          }
          localObject1 = this.nCo;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          localObject1 = this.nCp;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          l = Util.ticksToNow(this.nCu);
          Log.i(this.TAG, "remux used " + l + " decodeFrame:" + this.nCz + ", encodeFrame:" + this.nxx + ", drawFrameCount:" + this.nCA);
        }
      }
      finally {}
      try
      {
        localObject1 = com.tencent.mm.plugin.sight.base.f.aVX(this.outputFilePath);
        if (localObject1 == null) {
          break label374;
        }
        localf = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.B(this.nxj, l);
        localf = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.g(((com.tencent.mm.plugin.sight.base.b)localObject1).videoBitrate, ((com.tencent.mm.plugin.sight.base.b)localObject1).frameRate, this.videoFps);
        if (this.nCz / this.nxx < 1.5D) {
          break label374;
        }
        localObject1 = com.tencent.mm.media.util.f.nFE;
        com.tencent.mm.media.util.f.brU();
        AppMethodBeat.o(75297);
        return;
      }
      catch (Exception localException) {}
      this.nCy = true;
      continue;
      label374:
      AppMethodBeat.o(75297);
    }
  }
  
  public final void E(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75293);
    s.u(paramb, "blendBitmapProvider");
    this.nBp = paramb;
    AppMethodBeat.o(75293);
  }
  
  public final void F(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75295);
    s.u(paramb, "blurBgProvider");
    AppMethodBeat.o(75295);
  }
  
  public final void I(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75292);
    s.u(paramBitmap, "bitmap");
    AppMethodBeat.o(75292);
  }
  
  public final int bpE()
  {
    AppMethodBeat.i(75294);
    Log.i(this.TAG, s.X("start remux, initFinish:", Boolean.valueOf(this.nCq)));
    this.nCu = Util.currentTicks();
    this.nCv.mHw.lYS = SystemClock.elapsedRealtime();
    Object localObject;
    if (Log.getLogLevel() > 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.c.f.NGM;
      if (!com.tencent.mm.plugin.recordvideo.c.f.gHq()) {
        this.nCq = false;
      }
    }
    if (this.nCq)
    {
      localObject = com.tencent.mm.plugin.recordvideo.f.d.NRp;
      com.tencent.mm.plugin.recordvideo.f.d.gJi();
      localObject = this.nCo;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      this.nCo = com.tencent.mm.ae.d.f("MediaCodecRemux_audioMix", (kotlin.g.a.a)new b(this));
      localObject = this.nCp;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      if (this.NFj != null) {
        this.nCp = com.tencent.mm.ae.d.f("MediaCodecRemux_videoMix", (kotlin.g.a.a)new c(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75294);
      return 0;
      this.nCr = true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    d(m<? super ByteBuffer, ? super MediaCodec.BufferInfo, ah> paramm, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    e(m<? super ByteBuffer, ? super MediaCodec.BufferInfo, ah> paramm, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    f(m<? super ByteBuffer, ? super MediaCodec.BufferInfo, ah> paramm, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, ah>
  {
    g(m<? super ByteBuffer, ? super MediaCodec.BufferInfo, ah> paramm, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "succ", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements m<d, Boolean, ah>
  {
    h(e parame, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, ah>
    {
      a(e parame)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements kotlin.g.a.a<ah>
    {
      b(e parame)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements m<ByteBuffer, MediaCodec.BufferInfo, ah>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, ah>
  {
    k(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.a<ah>
  {
    l(e parame, long paramLong)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.e
 * JD-Core Version:    0.7.0.1
 */