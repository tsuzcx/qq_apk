package com.tencent.mm.plugin.story.image2video;

import a.f.a.m;
import a.f.b.k;
import a.l;
import a.y;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.b.a.ax;
import com.tencent.mm.media.g.h;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/image2video/MediaCodecFakeVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecVideoRemuxer;", "Lcom/tencent/mm/media/remuxer/IMediaCodecRemuxer;", "musicPath", "", "imageList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mixType", "", "outputFilePath", "outputWidth", "outputHeight", "outputBitrate", "outputAudioBitrate", "outputAudioSampleRate", "outputFps", "startTimeMs", "", "endTimeMs", "finishCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "path", "", "(Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;IIIIIIJJLkotlin/jvm/functions/Function1;)V", "TAG", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;", "backgroundExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "blendBitmapProvider", "Landroid/graphics/Bitmap;", "decodeFrameCount", "decoder", "Lcom/tencent/mm/plugin/story/image2video/MediaCodecFakeDecoder;", "delayCheckFinishEncodeRunnable", "Ljava/lang/Runnable;", "drawFrameCount", "encodeFrameCount", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "initFinish", "", "inputHeight", "inputWidth", "isAudioRemuxFinish", "isDecodeEnd", "isFinishEncode", "isInvokeEndCallback", "isVideoRemuxFinish", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "getMixType", "()I", "setMixType", "(I)V", "musicExtractorWrapper", "remuxCost", "Lcom/tencent/mm/media/util/CodeMan;", "remuxEndTime", "remuxStartTick", "remuxStartTime", "remuxerCallback", "Lcom/tencent/mm/media/remuxer/MediaCodecRemuxerCallback;", "startOnInitFinish", "videoDuration", "videoFps", "videoMixHandlerThread", "checkFinishEncode", "finishEncode", "finishRemux", "isVideo", "generateEncodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "onDecoderEncoderFailed", "isDecoder", "remux", "remuxImpl", "runAudioMix", "setVideoBlendBitmap", "bitmap", "setVideoBlendBitmapProvider", "Companion", "plugin-story_release"})
public final class f
  extends com.tencent.mm.media.g.d
  implements com.tencent.mm.media.g.c
{
  private static final long eXx = 1000L;
  private static final long eXy = 1000L;
  public static final f.a stj;
  private final String TAG;
  private volatile boolean eQY;
  private int eRf;
  private int eRn;
  private int eVA;
  private a.f.a.b<? super Long, Bitmap> eVY;
  private int eWJ;
  private int eWK;
  private long eWM;
  private long eWN;
  private com.tencent.mm.media.d.b eWO;
  private com.tencent.mm.media.a.a eWQ;
  private com.tencent.mm.media.g.j eWS;
  private com.tencent.mm.media.e.a eWT;
  private com.tencent.mm.media.e.a eWU;
  private al eWV;
  private al eWW;
  private boolean eWX;
  private boolean eWY;
  private h eWZ;
  private long eXa;
  private final com.tencent.mm.media.i.a eXb;
  private boolean eXc;
  private boolean eXd;
  private boolean eXe;
  private int eXf;
  private int eXg;
  private volatile boolean eXj;
  private final Runnable eXl;
  private final String eXm;
  private final String eXn;
  private int eXo;
  private int eXp;
  private int eXq;
  private int eXr;
  private int eXs;
  private int eXu;
  private a.f.a.b<? super String, y> eXw;
  private ArrayList<String> ste;
  private e sti;
  private int videoFps;
  
  static
  {
    AppMethodBeat.i(151019);
    stj = new f.a((byte)0);
    eXx = 1000L;
    eXy = 1000L;
    AppMethodBeat.o(151019);
  }
  
  public f(String paramString1, ArrayList<String> paramArrayList, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, long paramLong1, long paramLong2, a.f.a.b<? super String, y> paramb)
  {
    AppMethodBeat.i(151018);
    this.eXm = paramString1;
    this.ste = paramArrayList;
    this.eRn = paramInt1;
    this.eXn = paramString2;
    this.eXo = paramInt2;
    this.eXp = paramInt3;
    this.eXq = paramInt4;
    this.eXr = paramInt5;
    this.eXs = paramInt6;
    this.eXu = paramInt7;
    this.eXw = paramb;
    this.TAG = "MicroMsg.MediaCodecRemuxerFake";
    this.eVA = -1;
    this.eWM = paramLong1;
    this.eWN = -1L;
    this.eXb = new com.tencent.mm.media.i.a("remuxCost");
    paramString1 = this.ste.iterator();
    do
    {
      if (!paramString1.hasNext()) {
        break;
      }
    } while (com.tencent.mm.vfs.e.cN((String)paramString1.next()));
    for (paramInt1 = 0;; paramInt1 = 1)
    {
      if ((paramInt1 == 0) || (bo.isNullOrNil(this.eXn)) || (this.eXo <= 0) || (this.eXp <= 0))
      {
        ab.e(this.TAG, "create MediaCodecRemuxer error, outputFilePath:" + this.eXn + ", outputWidth:" + this.eXo + ", outputHeight:" + this.eXp + ", videoFps:" + this.videoFps + ", outputFps:" + this.eXu);
        paramString1 = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.We();
        paramString1 = (Throwable)new IllegalArgumentException("create MediaCodecRemuxer error");
        AppMethodBeat.o(151018);
        throw paramString1;
      }
      paramString1 = com.tencent.mm.media.i.c.eZC;
      com.tencent.mm.media.i.c.jZ(this.eRn);
      com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(this.eXn));
      d.czT();
      this.eWJ = d.Width;
      this.eWK = d.Height;
      this.videoFps = d.ssU;
      this.eVA = 15000;
      if (paramLong2 == 0L)
      {
        this.eWN = this.eVA;
        this.eWS = new com.tencent.mm.media.g.j(this.eWM, this.eWN, this.eXq);
        paramString1 = i.sFa;
        i.cDA().cw(this.eXo);
        paramString1 = i.sFa;
        i.cDA().cx(this.eXp);
        ab.b(this.TAG, "create MediaCodecRemuxer, outputFilePath: " + this.eXn + ", inputWidth: " + this.eWJ + ", inputHeight: " + this.eWK + ", videoFps: " + this.videoFps + " ,outputBitrate :" + this.eXq + ", outputAudioBitrate:" + this.eXr + " , outputWidth: " + this.eXo + ", outputHeight: " + this.eXp + ',' + " startTimeMs: " + paramLong1 + ", endTimeMs: " + paramLong2 + " , outputFps: " + this.eXu + " , videoDuration: " + this.eVA + " , remuxStartTime: " + this.eWM + " ,remuxEndTime: " + this.eWN, new Object[0]);
        this.eWU = null;
        this.eWZ = new h(this.eWS, this.eWU, this.eXn, this.eRn, this.eXs);
        if (com.tencent.mm.vfs.e.cN(this.eXm))
        {
          paramString1 = this.eXm;
          if (paramString1 == null) {
            a.f.b.j.ebi();
          }
          paramString1 = new com.tencent.mm.media.e.a(paramString1);
          if (paramString1.eUX)
          {
            paramArrayList = com.tencent.mm.media.i.c.eZC;
            com.tencent.mm.media.i.c.Wj();
          }
          this.eWT = paramString1;
          paramString1 = i.sFa;
          i.cDA().FC();
        }
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            if (this.eXu > 0)
            {
              paramInt1 = Math.min(this.eXu, this.videoFps);
              paramArrayList = new com.tencent.mm.media.b.c();
              paramArrayList.bitrate = this.eXq;
              paramArrayList.eRw = paramInt1;
              paramArrayList.eRv = this.eXp;
              paramArrayList.eRu = this.eXo;
              paramArrayList.eRA = true;
              paramString1 = i.sFa;
              i.cDA().cu(paramArrayList.bitrate);
              paramString1 = i.sFa;
              paramString1 = i.cDA();
              if (!paramArrayList.eRA) {
                continue;
              }
              paramLong1 = 1L;
              paramString1.cs(paramLong1);
              paramString1 = i.sFa;
              i.cDA().ct(paramArrayList.eRw);
              paramString1 = i.sFa;
              i.cDA().cv(paramArrayList.eRy);
              paramb = (m)new f.j(this);
              locala = (a.f.a.a)new f.k(this);
            }
          }
          catch (Exception paramString1)
          {
            a.f.a.a locala;
            ab.printErrStackTrace(this.TAG, (Throwable)paramString1, "remux impl error", new Object[0]);
            continue;
            paramLong1 = 2L;
            continue;
            paramString1 = (com.tencent.mm.media.d.b)new com.tencent.mm.media.d.e(paramArrayList, (a.f.a.b)new f.i(paramb, locala));
            continue;
            ab.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder error", new Object[0]);
            paramString1 = com.tencent.mm.media.i.c.eZC;
            com.tencent.mm.media.i.c.Wk();
            czU();
            paramString1 = com.tencent.mm.plugin.story.g.e.sEw;
            com.tencent.mm.plugin.story.g.e.cCQ();
            continue;
          }
          try
          {
            if (com.tencent.mm.compatible.util.d.fv(23))
            {
              paramString1 = (com.tencent.mm.media.d.b)new com.tencent.mm.media.d.f(paramArrayList, (a.f.a.b)new f.f(paramb, locala));
              this.eWO = paramString1;
              paramString1 = i.sFa;
              i.cDA().cy(1L);
              paramString1 = this.eWO;
              if (paramString1 != null)
              {
                paramString1 = paramString1.getInputSurface();
                this.sti = new e(this.ste, this.eWM, this.eWN, paramString1, this.eXo, this.eXp, (m)new f.e(this));
              }
              this.eXl = ((Runnable)new f.b(this));
              AppMethodBeat.o(151018);
              return;
              this.eWN = paramLong2;
              break;
              paramInt1 = this.videoFps;
              continue;
              paramLong1 = 2L;
              continue;
            }
            paramString1 = (com.tencent.mm.media.d.b)new com.tencent.mm.media.d.e(paramArrayList, (a.f.a.b)new f.g(paramb, locala));
            continue;
            paramArrayList.eRA = false;
          }
          catch (Exception paramString2)
          {
            if (!paramArrayList.eRA) {
              continue;
            }
          }
        }
        paramString1 = i.sFa;
        paramString1 = i.cDA();
        if (!paramArrayList.eRA) {
          continue;
        }
        paramLong1 = 1L;
        paramString1.cs(paramLong1);
        try
        {
          if (!com.tencent.mm.compatible.util.d.fv(23)) {
            continue;
          }
          paramString1 = (com.tencent.mm.media.d.b)new com.tencent.mm.media.d.f(paramArrayList, (a.f.a.b)new f.h(paramb, locala));
          this.eWO = paramString1;
          paramString1 = com.tencent.mm.plugin.story.g.e.sEw;
          com.tencent.mm.plugin.story.g.e.cCR();
        }
        catch (Exception paramString1)
        {
          ab.printErrStackTrace(this.TAG, (Throwable)paramString2, "create encoder again error", new Object[0]);
          paramString1 = com.tencent.mm.media.i.c.eZC;
          com.tencent.mm.media.i.c.Wk();
          czU();
          paramString1 = com.tencent.mm.plugin.story.g.e.sEw;
          com.tencent.mm.plugin.story.g.e.cCQ();
          continue;
        }
        paramString1 = i.sFa;
        i.cDA().cy(2L);
      }
    }
  }
  
  private final void UN()
  {
    AppMethodBeat.i(155291);
    ab.i(this.TAG, "finishEncode");
    com.tencent.mm.media.d.b localb = this.eWO;
    if (localb != null) {
      localb.UN();
    }
    al.ae(this.eXl);
    this.eXj = true;
    AppMethodBeat.o(155291);
  }
  
  private final void cB(boolean paramBoolean)
  {
    for (;;)
    {
      Object localObject1;
      long l;
      com.tencent.mm.media.i.c localc;
      try
      {
        AppMethodBeat.i(151016);
        ab.i(this.TAG, "finishRemux, isVideo: " + paramBoolean + ", isAudioRemuxFinish:" + this.eXe + ", isVideoRemuxFinish:" + this.eXd + ", isInvokeEndCallback:" + this.eXc);
        if (paramBoolean)
        {
          this.eXd = true;
          if ((!this.eXe) || (!this.eXd) || (this.eXc)) {
            break label382;
          }
          localObject1 = com.tencent.mm.plugin.story.g.e.sEw;
          com.tencent.mm.plugin.story.g.e.cCL();
          this.eXb.SS();
          this.eXc = true;
          localObject1 = this.eWU;
          if (localObject1 != null) {
            ((com.tencent.mm.media.e.a)localObject1).release();
          }
          localObject1 = this.eWZ;
          if (localObject1 != null)
          {
            localObject1 = ((h)localObject1).eXQ;
            if (localObject1 != null) {
              ((a.f.a.b)localObject1).S(this.eXw);
            }
          }
          localObject1 = this.eWV;
          if (localObject1 != null) {
            ((al)localObject1).quit();
          }
          localObject1 = this.eWW;
          if (localObject1 != null) {
            ((al)localObject1).quit();
          }
          l = bo.av(this.eXa);
          ab.i(this.TAG, "remux used " + l + " decodeFrame:" + this.eXf + ", encodeFrame:" + this.eRf + ", drawFrameCount:" + this.eXg);
        }
      }
      finally {}
      try
      {
        localObject1 = com.tencent.mm.plugin.sight.base.d.Zo(this.eXn);
        if (localObject1 == null) {
          break label382;
        }
        localc = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.v(this.eRn, l);
        localc = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.d(((com.tencent.mm.plugin.sight.base.a)localObject1).videoBitrate, ((com.tencent.mm.plugin.sight.base.a)localObject1).eRw, this.videoFps);
        if (this.eXf / this.eRf < 1.5D) {
          break label382;
        }
        localObject1 = com.tencent.mm.media.i.c.eZC;
        com.tencent.mm.media.i.c.Wt();
        AppMethodBeat.o(151016);
        return;
      }
      catch (Exception localException) {}
      this.eXe = true;
      continue;
      label382:
      AppMethodBeat.o(151016);
    }
  }
  
  private final void czU()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(151017);
        ab.i(this.TAG, "onDecoderEncoderFailed, isDecoder:false");
        if (!this.eXc)
        {
          this.eXb.SS();
          this.eXc = true;
          try
          {
            localObject1 = this.eWU;
            if (localObject1 != null) {
              ((com.tencent.mm.media.e.a)localObject1).release();
            }
            localObject1 = this.eWV;
            if (localObject1 != null) {
              ((al)localObject1).quit();
            }
            localObject1 = this.eWW;
            if (localObject1 != null) {
              ((al)localObject1).quit();
            }
            com.tencent.mm.vfs.e.deleteFile(this.eXn);
            long l = bo.av(this.eXa);
            ab.i(this.TAG, "onDecoderEncoderFailed, finish, costTime:".concat(String.valueOf(l)));
          }
          catch (Exception localException)
          {
            Object localObject1;
            ab.printErrStackTrace(this.TAG, (Throwable)localException, "onDecoderEncoderFailed error:" + localException.getMessage(), new Object[0]);
            continue;
          }
          localObject1 = this.eXw;
          if (localObject1 != null)
          {
            ((a.f.a.b)localObject1).S(null);
            AppMethodBeat.o(151017);
            return;
          }
        }
      }
      finally {}
      AppMethodBeat.o(151017);
    }
  }
  
  public final int Va()
  {
    AppMethodBeat.i(151015);
    ab.i(this.TAG, "start remux, initFinish:" + this.eWX);
    this.eXa = bo.yB();
    this.eXb.eMo.reset();
    if ((ab.getLogLevel() > 0) && (!d.ssX)) {
      this.eWX = false;
    }
    if (this.eWX)
    {
      Object localObject = com.tencent.mm.plugin.story.g.e.sEw;
      com.tencent.mm.plugin.story.g.e.cCK();
      localObject = this.eWV;
      if (localObject != null) {
        ((al)localObject).quit();
      }
      this.eWV = com.tencent.mm.ab.b.b((a.f.a.a)new c(this), "MediaCodecRemux_audioMix");
      localObject = this.eWW;
      if (localObject != null) {
        ((al)localObject).quit();
      }
      if (this.sti != null) {
        this.eWW = com.tencent.mm.ab.b.b((a.f.a.a)new f.d(this), "MediaCodecRemux_videoMix");
      }
    }
    for (;;)
    {
      AppMethodBeat.o(151015);
      return 0;
      this.eWY = true;
    }
  }
  
  public final void b(a.f.a.b<? super Long, Bitmap> paramb)
  {
    AppMethodBeat.i(151014);
    a.f.b.j.q(paramb, "blendBitmapProvider");
    this.eVY = paramb;
    AppMethodBeat.o(151014);
  }
  
  public final void p(Bitmap paramBitmap)
  {
    AppMethodBeat.i(151013);
    a.f.b.j.q(paramBitmap, "bitmap");
    AppMethodBeat.o(151013);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "invoke"})
  static final class c
    extends k
    implements a.f.a.a<y>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.image2video.f
 * JD-Core Version:    0.7.0.1
 */