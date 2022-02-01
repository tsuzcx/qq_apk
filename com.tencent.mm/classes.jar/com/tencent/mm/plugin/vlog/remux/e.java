package com.tencent.mm.plugin.vlog.remux;

import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.h;
import com.tencent.mm.plugin.recordvideo.util.f;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "remuxModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "(Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;)V", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "beforeCropSize", "Landroid/graphics/Point;", "bufId", "", "cropRect", "Landroid/graphics/Rect;", "decoder", "Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder;", "encodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "finishCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "errorCode", "", "frameCount", "heightScale", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "musicExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "musicPath", "mute", "remuxForThumb", "remuxMusicFinish", "remuxVideoFinish", "startTick", "", "thumbPath", "videoMixHandlerThread", "widthScale", "cancel", "getThumbBitmap", "width", "height", "onFinish", "release", "remuxFinish", "remuxMusic", "remuxVideo", "setCropInfo", "rect", "setMusicPath", "path", "setPreviewSurfaceSize", "start", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements com.tencent.mm.plugin.recordvideo.background.c.c
{
  public static final a Ueu;
  private Rect Gl;
  private final com.tencent.mm.plugin.vlog.model.ah Udv;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, kotlin.ah> UeA;
  private boolean UeB;
  private Point UeC;
  private af Uev;
  private c Uew;
  private final com.tencent.mm.media.b.d Uex;
  private volatile boolean Uey;
  private volatile boolean Uez;
  private final int bufId;
  private int frameCount;
  private long moe;
  private String nBT;
  private com.tencent.mm.media.e.b nCh;
  private com.tencent.mm.media.a.a nCj;
  private h nCl;
  private com.tencent.mm.media.f.a nCm;
  private HandlerThread nCo;
  private HandlerThread nCp;
  private boolean nLP;
  private float sQQ;
  private float sQR;
  private String thumbPath;
  
  static
  {
    AppMethodBeat.i(111088);
    Ueu = new a((byte)0);
    AppMethodBeat.o(111088);
  }
  
  public e(com.tencent.mm.plugin.vlog.model.ah paramah, af paramaf)
  {
    AppMethodBeat.i(111087);
    this.Udv = paramah;
    this.Uev = paramaf;
    this.bufId = SightVideoJNI.initDataBufferForRemux(false);
    this.Uex = new com.tencent.mm.media.b.d();
    this.sQQ = 1.0F;
    this.sQR = 1.0F;
    paramah = f.Obq;
    this.thumbPath = f.aTv(this.Uev.outputPath);
    this.Uex.bitrate = this.Uev.videoBitrate;
    this.Uex.frameRate = this.Uev.frameRate;
    this.Uex.nxP = this.Uev.nxP;
    this.Uex.nxO = this.Uev.nxO;
    this.nCl = new h(0L, ((com.tencent.mm.plugin.vlog.model.s)p.oM(this.Udv.UaY)).endTime, this.Uev.videoBitrate, false, null, 48);
    Log.i("MicroMsg.VLogRemuxer", "encodeConfig: " + this.Uex + ' ');
    Log.i("MicroMsg.VLogRemuxer", "remuxModel: " + this.Uev + ' ');
    AppMethodBeat.o(111087);
  }
  
  private final void cancel()
  {
    AppMethodBeat.i(111086);
    Object localObject = this.Uew;
    if (localObject != null) {
      ((c)localObject).release();
    }
    localObject = this.nCh;
    if (localObject != null) {
      ((com.tencent.mm.media.e.b)localObject).bpa();
    }
    localObject = this.nCp;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    localObject = this.nCo;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    AppMethodBeat.o(111086);
  }
  
  private final void hSg()
  {
    boolean bool = false;
    AppMethodBeat.i(111084);
    if ((this.Uey) && (this.Uez))
    {
      int i = this.nCl.a(null, this.Uev.outputPath, this.Uev.audioSampleRate, this.Uev.audioChannelCount, false);
      if (i >= 0) {
        bool = true;
      }
      Log.i("MicroMsg.VLogRemuxer", "mux finish, cost:" + Util.ticksToNow(this.moe) + ",succ:" + bool + "  result:" + i + ", path:" + this.Uev + ".outputPath");
      release();
      if (bool)
      {
        SightVideoJNI.optimizeMP4VFS(this.Uev.outputPath);
        localObject = f.Obq;
        f.lr(this.Uev.outputPath, this.thumbPath);
      }
      Object localObject = this.UeA;
      if (localObject != null) {
        ((r)localObject).a(this.Uev.outputPath, this.thumbPath, Boolean.valueOf(bool), Integer.valueOf(-1));
      }
    }
    AppMethodBeat.o(111084);
  }
  
  public final void bfm(String paramString)
  {
    AppMethodBeat.i(111080);
    Log.i("MicroMsg.VLogRemuxer", "setMusicPath path");
    this.nBT = paramString;
    AppMethodBeat.o(111080);
  }
  
  public final void f(r<? super String, ? super String, ? super Boolean, ? super Integer, kotlin.ah> paramr)
  {
    AppMethodBeat.i(111081);
    Log.i("MicroMsg.VLogRemuxer", "start");
    this.UeA = paramr;
    this.moe = Util.currentTicks();
    paramr = this.nCp;
    if (paramr != null) {
      paramr.quit();
    }
    this.nCp = com.tencent.mm.ae.d.f("VLogRemuxer_remuxVideo", (kotlin.g.a.a)new i(this));
    paramr = this.nCo;
    if (paramr != null) {
      paramr.quit();
    }
    this.nCo = com.tencent.mm.ae.d.f("VLogRemuxer_remuxMusic", (kotlin.g.a.a)new j(this));
    AppMethodBeat.o(111081);
  }
  
  public final void mz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111083);
    Point localPoint;
    float f;
    if (this.UeC != null)
    {
      localPoint = this.UeC;
      kotlin.g.b.s.checkNotNull(localPoint);
      if (localPoint.x > 0)
      {
        localPoint = this.UeC;
        kotlin.g.b.s.checkNotNull(localPoint);
        if (localPoint.y > 0)
        {
          f = paramInt1;
          localPoint = this.UeC;
          kotlin.g.b.s.checkNotNull(localPoint);
          this.sQQ = (f / localPoint.x);
          f = paramInt2;
          localPoint = this.UeC;
          kotlin.g.b.s.checkNotNull(localPoint);
        }
      }
    }
    for (this.sQR = (f / localPoint.y);; this.sQR = (paramInt2 / this.Uev.nxP))
    {
      Log.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + paramInt1 + ", " + paramInt2 + "], scale:[" + this.sQQ + ", " + this.sQR + ']');
      AppMethodBeat.o(111083);
      return;
      this.sQQ = (paramInt1 / this.Uev.nxO);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(111085);
    Log.i("MicroMsg.VLogRemuxer", "release");
    cancel();
    this.nCl.release();
    AppMethodBeat.o(111085);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, kotlin.ah>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "pts", "", "frameCount", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements m<Long, Integer, kotlin.ah>
  {
    e(e parame, com.tencent.mm.media.e.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<Long, kotlin.ah>
  {
    f(com.tencent.mm.media.e.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "buffer", "Ljava/nio/IntBuffer;", "frameCount", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements m<IntBuffer, Integer, kotlin.ah>
  {
    g(e parame)
    {
      super();
    }
    
    private static final void p(e parame)
    {
      AppMethodBeat.i(281328);
      kotlin.g.b.s.u(parame, "this$0");
      r localr = e.o(parame);
      if (localr != null) {
        localr.a("", e.m(parame), Boolean.TRUE, Integer.valueOf(-1));
      }
      AppMethodBeat.o(281328);
    }
  }
  
  @Metadata(d1={""}, d2={"<no name provided>", "", "iMediaCodecTransEncoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, kotlin.ah>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    j(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.e
 * JD-Core Version:    0.7.0.1
 */