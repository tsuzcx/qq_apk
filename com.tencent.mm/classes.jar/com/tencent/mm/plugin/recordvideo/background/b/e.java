package com.tencent.mm.plugin.recordvideo.background.b;

import android.graphics.Bitmap;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.media.e.f;
import com.tencent.mm.media.i.c;
import com.tencent.mm.media.i.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "useX264Encode", "", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJZLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "getUseX264Encode", "()Z", "setUseX264Encode", "(Z)V", "videoDuration", "videoFps", "videoMixHandlerThread", "x264Encoder", "Lcom/tencent/mm/media/encoder/X264TransEncoder;", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "setVideoBlurBgProvider", "blurBgProvider", "Companion", "plugin-recordvideo_release"})
public final class e
  extends com.tencent.mm.media.i.d
  implements c
{
  public static final e.a BLG;
  private static final long iiK = 1000L;
  private static final long iiL = 1000L;
  private d BLD;
  private com.tencent.mm.media.e.g BLE;
  boolean BLF;
  private ArrayList<String> BLy;
  private final String TAG;
  private volatile boolean idb;
  private int idi;
  private int idq;
  private volatile boolean ifd;
  private int ihQ;
  private int ihR;
  private com.tencent.mm.media.e.b ihT;
  private com.tencent.mm.media.a.a ihV;
  private i ihX;
  private com.tencent.mm.media.f.a ihY;
  private com.tencent.mm.media.f.a ihZ;
  private kotlin.g.a.b<? super Long, Bitmap> ihf;
  private long iho;
  private int iiB;
  private kotlin.g.a.b<? super String, x> iiJ;
  private HandlerThread iia;
  private HandlerThread iib;
  private boolean iic;
  private boolean iid;
  private com.tencent.mm.media.i.g iie;
  private long iig;
  private final com.tencent.mm.media.k.a iih;
  private boolean iii;
  private boolean iij;
  private boolean iik;
  private int iil;
  private int iim;
  private final Runnable iiu;
  private final String iiv;
  private int iix;
  private int iiy;
  private int iiz;
  private final String outputFilePath;
  private int outputHeight;
  private int outputWidth;
  private long remuxEndTime;
  private int videoDuration;
  private int videoFps;
  
  static
  {
    AppMethodBeat.i(75300);
    BLG = new e.a((byte)0);
    iiK = 1000L;
    iiL = 1000L;
    AppMethodBeat.o(75300);
  }
  
  public e(String paramString1, final ArrayList<String> paramArrayList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, boolean paramBoolean, kotlin.g.a.b<? super String, x> paramb)
  {
    AppMethodBeat.i(75299);
    this.iiv = paramString1;
    this.BLy = paramArrayList;
    this.idq = paramInt1;
    this.outputFilePath = paramString2;
    this.outputWidth = paramInt2;
    this.outputHeight = paramInt3;
    this.iix = paramInt4;
    this.iiy = paramInt5;
    this.iiz = paramInt6;
    this.iiB = paramInt7;
    this.BLF = paramBoolean;
    this.iiJ = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxerFake";
    this.videoDuration = -1;
    this.iho = paramLong1;
    this.remuxEndTime = -1L;
    this.iih = new com.tencent.mm.media.k.a("remuxCost");
    paramString1 = this.BLy.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (s.YS((String)paramString1.next()));
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((paramInt1 == 0) || (Util.isNullOrNil(this.outputFilePath)) || (this.outputWidth <= 0) || (this.outputHeight <= 0))
      {
        Log.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.outputFilePath + ", outputWidth:" + this.outputWidth + ", outputHeight:" + this.outputHeight + ", videoFps:" + this.videoFps + ", outputFps:" + this.iiB);
        paramString1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOv();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(75299);
        throw paramString1;
      }
      paramString1 = com.tencent.mm.media.k.e.ilC;
      com.tencent.mm.media.k.e.rn(this.idq);
      s.boN(s.boZ(this.outputFilePath));
      com.tencent.mm.plugin.recordvideo.b.e.BNm.eJv();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      this.ihQ = com.tencent.mm.plugin.recordvideo.b.e.getWidth();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      this.ihR = com.tencent.mm.plugin.recordvideo.b.e.getHeight();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      this.videoFps = com.tencent.mm.plugin.recordvideo.b.e.getFrameRate();
      paramString1 = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      this.videoDuration = com.tencent.mm.plugin.recordvideo.b.e.eJs();
      if (paramLong2 == 0L)
      {
        this.remuxEndTime = this.videoDuration;
        if (!this.BLF) {
          break label1041;
        }
        Log.i(this.TAG, "mixMuxerController init useX264Encode, bitrate %s, width %s, height %s, fps %s", new Object[] { Integer.valueOf(this.iix), Integer.valueOf(this.outputWidth), Integer.valueOf(this.outputHeight), Integer.valueOf(this.iiB) });
        paramString1 = new i(this.iho, this.remuxEndTime, this.iix, this.outputWidth, this.outputHeight, this.BLF, this.iiB);
        label486:
        this.ihX = paramString1;
        Log.printInfoStack(this.TAG, "create MediaCodecRemuxer, outputFilePath: " + this.outputFilePath + ", inputWidth: " + this.ihQ + ", inputHeight: " + this.ihR + ", videoFps: " + this.videoFps + " ,outputBitrate :" + this.iix + ", outputAudioBitrate:" + this.iiy + " , outputWidth: " + this.outputWidth + ", outputHeight: " + this.outputHeight + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.iiB + " , videoDuration: " + this.videoDuration + " , remuxStartTime: " + this.iho + " ,remuxEndTime: " + this.remuxEndTime, new Object[0]);
        this.ihZ = null;
        this.iie = new com.tencent.mm.media.i.g(this.ihX, this.ihZ, this.outputFilePath, this.idq, this.iiz);
        if (s.YS(this.iiv))
        {
          paramString1 = this.iiv;
          if (paramString1 == null) {
            p.hyc();
          }
          paramString1 = new com.tencent.mm.media.f.a(paramString1);
          if (paramString1.igl)
          {
            paramArrayList = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOy();
          }
          this.ihY = paramString1;
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.iiB > 0)
            {
              paramInt1 = Math.min(this.iiB, this.videoFps);
              paramArrayList = new com.tencent.mm.media.b.d();
              paramArrayList.bitrate = this.iix;
              paramArrayList.frameRate = paramInt1;
              paramArrayList.targetHeight = this.outputHeight;
              paramArrayList.targetWidth = this.outputWidth;
              paramArrayList.idD = true;
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
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e(paramArrayList, (kotlin.g.a.b)new f(paramb, locala));
            continue;
            paramString1 = (com.tencent.mm.media.e.b)new com.tencent.mm.media.e.e(paramArrayList, (kotlin.g.a.b)new h(paramb, locala));
            continue;
            Log.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder error", new Object[0]);
            paramString1 = com.tencent.mm.media.k.e.ilC;
            com.tencent.mm.media.k.e.aOz();
            eJl();
            paramString1 = com.tencent.mm.plugin.recordvideo.d.d.BXS;
            com.tencent.mm.plugin.recordvideo.d.d.eLb();
            continue;
            paramString1 = null;
            continue;
          }
          try
          {
            if (this.BLF)
            {
              Log.i(this.TAG, "useX264Encode");
              this.BLE = new com.tencent.mm.media.e.g(this.ihX.bufId, paramArrayList.targetWidth, paramArrayList.targetHeight);
              paramString1 = this.BLE;
              if (paramString1 != null) {
                paramString1.start();
              }
              if ((this.BLE != null) || (this.ihT != null))
              {
                if (this.ihT == null) {
                  continue;
                }
                paramString1 = this.ihT;
                if (paramString1 == null) {
                  p.hyc();
                }
                paramString1 = paramString1.getInputSurface();
                this.BLD = new d(this.BLy, this.iho, this.remuxEndTime, paramString1, this.outputWidth, this.outputHeight, this.BLF, this.iiB, (m)new i(this, paramArrayList));
              }
              this.iiu = ((Runnable)new b(this));
              AppMethodBeat.o(75299);
              return;
              this.remuxEndTime = paramLong2;
              break;
              paramString1 = new i(this.iho, this.remuxEndTime, this.iix, this.BLF);
              break label486;
              paramInt1 = this.videoFps;
              continue;
            }
            if (!com.tencent.mm.compatible.util.d.oD(23)) {
              continue;
            }
            paramString1 = (com.tencent.mm.media.e.b)new f(paramArrayList, (kotlin.g.a.b)new e(paramb, locala));
            this.ihT = paramString1;
            continue;
            paramArrayList.idD = false;
          }
          catch (Exception paramString2)
          {
            if (!paramArrayList.idD) {
              continue;
            }
          }
        }
        try
        {
          if (!com.tencent.mm.compatible.util.d.oD(23)) {
            continue;
          }
          paramString1 = (com.tencent.mm.media.e.b)new f(paramArrayList, (kotlin.g.a.b)new g(paramb, locala));
          this.ihT = paramString1;
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.BXS;
          com.tencent.mm.plugin.recordvideo.d.d.eLc();
        }
        catch (Exception paramString1)
        {
          Log.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder again error", new Object[0]);
          paramString1 = com.tencent.mm.media.k.e.ilC;
          com.tencent.mm.media.k.e.aOz();
          eJl();
          paramString1 = com.tencent.mm.plugin.recordvideo.d.d.BXS;
          com.tencent.mm.plugin.recordvideo.d.d.eLb();
        }
      }
    }
  }
  
  private final void aMi()
  {
    AppMethodBeat.i(75296);
    Log.i(this.TAG, "finishEncode %s", new Object[] { Boolean.valueOf(this.BLF) });
    Object localObject;
    if (this.BLF)
    {
      localObject = this.BLE;
      if (localObject != null) {
        com.tencent.mm.media.e.g.a((com.tencent.mm.media.e.g)localObject);
      }
      eX(true);
    }
    for (;;)
    {
      MMHandlerThread.removeRunnable(this.iiu);
      this.ifd = true;
      AppMethodBeat.o(75296);
      return;
      localObject = this.ihT;
      if (localObject != null) {
        ((com.tencent.mm.media.e.b)localObject).aMi();
      }
    }
  }
  
  private final void eJl()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(75298);
        Log.i(this.TAG, "onDecoderEncoderFailed, isDecoder:false");
        if (!this.iii)
        {
          this.iih.aBw();
          this.iii = true;
          try
          {
            localObject1 = this.ihZ;
            if (localObject1 != null) {
              ((com.tencent.mm.media.f.a)localObject1).release();
            }
            localObject1 = this.iia;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            localObject1 = this.iib;
            if (localObject1 != null) {
              ((HandlerThread)localObject1).quit();
            }
            s.deleteFile(this.outputFilePath);
            long l = Util.ticksToNow(this.iig);
            Log.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Object localObject1;
            Log.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.iiJ;
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
  
  private final void eX(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      long l;
      com.tencent.mm.media.k.e locale;
      try
      {
        AppMethodBeat.i(75297);
        Log.i(this.TAG, "finishRemux, isVideo: " + paramBoolean + ", isAudioRemuxFinish:" + this.iik + ", isVideoRemuxFinish:" + this.iij + ", isInvokeEndCallback:" + this.iii);
        if (paramBoolean)
        {
          this.iij = true;
          if ((!this.iik) || (!this.iij) || (this.iii)) {
            break label374;
          }
          this.iih.aBw();
          this.iii = true;
          localObject1 = this.ihZ;
          if (localObject1 != null) {
            ((com.tencent.mm.media.f.a)localObject1).release();
          }
          localObject1 = this.iie;
          if (localObject1 != null)
          {
            localObject1 = ((com.tencent.mm.media.i.g)localObject1).ije;
            if (localObject1 != null) {
              ((kotlin.g.a.b)localObject1).invoke(this.iiJ);
            }
          }
          localObject1 = this.iia;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          localObject1 = this.iib;
          if (localObject1 != null) {
            ((HandlerThread)localObject1).quitSafely();
          }
          l = Util.ticksToNow(this.iig);
          Log.i(this.TAG, "remux used " + l + " decodeFrame:" + this.iil + ", encodeFrame:" + this.idi + ", drawFrameCount:" + this.iim);
        }
      }
      finally {}
      try
      {
        localObject1 = com.tencent.mm.plugin.sight.base.e.aNx(this.outputFilePath);
        if (localObject1 == null) {
          break label374;
        }
        locale = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.y(this.idq, l);
        locale = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.f(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject1).frameRate, this.videoFps);
        if (this.iil / this.idi < 1.5D) {
          break label374;
        }
        localObject1 = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOI();
        AppMethodBeat.o(75297);
        return;
      }
      catch (Exception localException) {}
      this.iik = true;
      continue;
      label374:
      AppMethodBeat.o(75297);
    }
  }
  
  public final void D(Bitmap paramBitmap)
  {
    AppMethodBeat.i(75292);
    p.h(paramBitmap, "bitmap");
    AppMethodBeat.o(75292);
  }
  
  public final int aMG()
  {
    AppMethodBeat.i(75294);
    Log.i(this.TAG, "start remux, initFinish:" + this.iic);
    this.iig = Util.currentTicks();
    this.iih.hvh.reset();
    Object localObject;
    if (Log.getLogLevel() > 0)
    {
      localObject = com.tencent.mm.plugin.recordvideo.b.e.BNm;
      if (!com.tencent.mm.plugin.recordvideo.b.e.eJt()) {
        this.iic = false;
      }
    }
    if (this.iic)
    {
      localObject = com.tencent.mm.plugin.recordvideo.d.d.BXS;
      com.tencent.mm.plugin.recordvideo.d.d.eLa();
      localObject = this.iia;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      this.iia = com.tencent.mm.ac.d.a("MediaCodecRemux_audioMix", false, (kotlin.g.a.a)new c(this));
      localObject = this.iib;
      if (localObject != null) {
        ((HandlerThread)localObject).quit();
      }
      if (this.BLD != null) {
        this.iib = com.tencent.mm.ac.d.a("MediaCodecRemux_videoMix", false, (kotlin.g.a.a)new d(this));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(75294);
      return 0;
      this.iid = true;
    }
  }
  
  public final void k(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75293);
    p.h(paramb, "blendBitmapProvider");
    this.ihf = paramb;
    AppMethodBeat.o(75293);
  }
  
  public final void l(kotlin.g.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(75295);
    p.h(paramb, "blurBgProvider");
    AppMethodBeat.o(75295);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame) {}
    
    public final void run()
    {
      AppMethodBeat.i(75277);
      Log.i(e.a(this.BLH), "decode end after " + e.aMK() + ", isFinishEncode:" + e.u(this.BLH));
      if (!e.u(this.BLH))
      {
        com.tencent.mm.media.k.e locale = com.tencent.mm.media.k.e.ilC;
        com.tencent.mm.media.k.e.aOW();
        e.v(this.BLH);
      }
      AppMethodBeat.o(75277);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    e(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    f(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    g(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    h(m paramm, kotlin.g.a.a parama)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lcom/tencent/mm/plugin/recordvideo/background/image2video/MediaCodecFakeDecoder;", "succ", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements m<d, Boolean, x>
  {
    i(e parame, com.tencent.mm.media.b.d paramd)
    {
      super();
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Ljava/nio/ByteBuffer;", "pts", "", "<anonymous parameter 2>", "Landroid/media/MediaCodec$BufferInfo;", "duplicate", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements r<ByteBuffer, Long, MediaCodec.BufferInfo, Boolean, x>
    {
      a(e.i parami)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "byteBuffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements m<ByteBuffer, MediaCodec.BufferInfo, x>
  {
    j(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class k
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    k(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x>
  {
    l(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.background.b.e
 * JD-Core Version:    0.7.0.1
 */