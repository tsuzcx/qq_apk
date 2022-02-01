package com.tencent.mm.plugin.vlog.remux;

import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.h.i;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.a.m;
import d.g.a.q;
import d.g.a.r;
import d.g.b.k;
import d.y;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "remuxModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "(Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;)V", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "beforeCropSize", "Landroid/graphics/Point;", "bufId", "", "cropRect", "Landroid/graphics/Rect;", "decoder", "Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder;", "encodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "finishCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "errorCode", "", "frameCount", "heightScale", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "musicExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "musicPath", "mute", "remuxForThumb", "remuxMusicFinish", "remuxVideoFinish", "startTick", "", "thumbPath", "videoMixHandlerThread", "widthScale", "cancel", "getThumbBitmap", "width", "height", "onFinish", "release", "remuxFinish", "remuxMusic", "remuxVideo", "setCropInfo", "rect", "setMusicPath", "path", "setPreviewSurfaceSize", "start", "Companion", "plugin-vlog_release"})
public final class g
  implements com.tencent.mm.plugin.recordvideo.background.b.c
{
  public static final a zbv;
  private Point Ltk;
  private long fNi;
  private int frameCount;
  private boolean gCJ;
  private final int gmW;
  private String gtC;
  private Rect gtE;
  private com.tencent.mm.media.d.b gtc;
  private com.tencent.mm.media.a.a gte;
  private i gtg;
  private com.tencent.mm.media.e.a gth;
  private HandlerThread gtj;
  private HandlerThread gtk;
  private float kAJ;
  private float kAK;
  private String thumbPath;
  private b zbn;
  private final com.tencent.mm.media.b.d zbo;
  private volatile boolean zbp;
  private volatile boolean zbq;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, y> zbr;
  private boolean zbs;
  private final h zbt;
  private com.tencent.mm.plugin.vlog.model.g zbu;
  
  static
  {
    AppMethodBeat.i(111088);
    zbv = new a((byte)0);
    AppMethodBeat.o(111088);
  }
  
  public g(h paramh, com.tencent.mm.plugin.vlog.model.g paramg)
  {
    AppMethodBeat.i(111087);
    this.zbt = paramh;
    this.zbu = paramg;
    this.gmW = SightVideoJNI.initDataBufferForRemux(false);
    this.zbo = new com.tencent.mm.media.b.d();
    this.kAJ = 1.0F;
    this.kAK = 1.0F;
    paramh = com.tencent.mm.plugin.recordvideo.e.b.vtE;
    this.thumbPath = com.tencent.mm.plugin.recordvideo.e.b.alU(this.zbu.oLh);
    this.zbo.bitrate = this.zbu.videoBitrate;
    this.zbo.frameRate = this.zbu.frameRate;
    this.zbo.gni = this.zbu.gni;
    this.zbo.gnh = this.zbu.gnh;
    this.gtg = new i(0L, ((com.tencent.mm.plugin.vlog.model.d)j.iA(this.zbt.yZs)).endTime, this.zbu.videoBitrate, false);
    ad.i("MicroMsg.VLogRemuxer", "encodeConfig: " + this.zbo + ' ');
    ad.i("MicroMsg.VLogRemuxer", "remuxModel: " + this.zbu + ' ');
    AppMethodBeat.o(111087);
  }
  
  private final void cancel()
  {
    AppMethodBeat.i(111086);
    Object localObject = this.zbn;
    if (localObject != null) {
      ((b)localObject).release();
    }
    localObject = this.gtc;
    if (localObject != null) {
      ((com.tencent.mm.media.d.b)localObject).ajG();
    }
    localObject = this.gtk;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    localObject = this.gtj;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      AppMethodBeat.o(111086);
      return;
    }
    AppMethodBeat.o(111086);
  }
  
  private final void dRe()
  {
    boolean bool = false;
    AppMethodBeat.i(111084);
    if ((this.zbp) && (this.zbq))
    {
      int i = this.gtg.a(null, this.zbu.oLh, this.zbu.audioSampleRate, this.zbu.gnH, false);
      if (i >= 0) {
        bool = true;
      }
      ad.i("MicroMsg.VLogRemuxer", "mux finish, cost:" + bt.aS(this.fNi) + ",succ:" + bool + "  result:" + i + ", path:" + this.zbu + ".outputPath");
      release();
      if (bool)
      {
        SightVideoJNI.optimizeMP4VFS(this.zbu.oLh);
        localObject = com.tencent.mm.plugin.recordvideo.e.b.vtE;
        com.tencent.mm.plugin.recordvideo.e.b.mT(this.zbu.oLh, this.thumbPath);
      }
      Object localObject = this.zbr;
      if (localObject != null)
      {
        ((r)localObject).a(this.zbu.oLh, this.thumbPath, Boolean.valueOf(bool), Integer.valueOf(-1));
        AppMethodBeat.o(111084);
        return;
      }
    }
    AppMethodBeat.o(111084);
  }
  
  public final void asX(String paramString)
  {
    AppMethodBeat.i(111080);
    ad.i("MicroMsg.VLogRemuxer", "setMusicPath path");
    this.gtC = paramString;
    AppMethodBeat.o(111080);
  }
  
  public final void b(r<? super String, ? super String, ? super Boolean, ? super Integer, y> paramr)
  {
    AppMethodBeat.i(111081);
    ad.i("MicroMsg.VLogRemuxer", "start");
    this.zbr = paramr;
    this.fNi = bt.GC();
    paramr = this.gtk;
    if (paramr != null) {
      paramr.quit();
    }
    this.gtk = com.tencent.mm.ad.c.a("VLogRemuxer_remuxVideo", false, (d.g.a.a)new i(this));
    paramr = this.gtj;
    if (paramr != null) {
      paramr.quit();
    }
    this.gtj = com.tencent.mm.ad.c.a("VLogRemuxer_remuxMusic", false, (d.g.a.a)new j(this));
    AppMethodBeat.o(111081);
  }
  
  public final void hN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111083);
    Point localPoint;
    float f;
    if (this.Ltk != null)
    {
      localPoint = this.Ltk;
      if (localPoint == null) {
        k.fvU();
      }
      if (localPoint.x > 0)
      {
        localPoint = this.Ltk;
        if (localPoint == null) {
          k.fvU();
        }
        if (localPoint.y > 0)
        {
          f = paramInt1;
          localPoint = this.Ltk;
          if (localPoint == null) {
            k.fvU();
          }
          this.kAJ = (f / localPoint.x);
          f = paramInt2;
          localPoint = this.Ltk;
          if (localPoint == null) {
            k.fvU();
          }
        }
      }
    }
    for (this.kAK = (f / localPoint.y);; this.kAK = (paramInt2 / this.zbu.gni))
    {
      ad.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + paramInt1 + ", " + paramInt2 + "], scale:[" + this.kAJ + ", " + this.kAK + ']');
      AppMethodBeat.o(111083);
      return;
      this.kAJ = (paramInt1 / this.zbu.gnh);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(111085);
    ad.i("MicroMsg.VLogRemuxer", "release");
    cancel();
    this.gtg.release();
    AppMethodBeat.o(111085);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class c
    extends d.g.b.l
    implements q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, y>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "pts", "", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$1"})
  static final class e
    extends d.g.b.l
    implements m<Long, Integer, y>
  {
    e(com.tencent.mm.media.d.b paramb, g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "buffer", "Ljava/nio/IntBuffer;", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$3"})
  static final class f
    extends d.g.b.l
    implements m<IntBuffer, Integer, y>
  {
    f(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Long, y>
  {
    g(com.tencent.mm.media.d.b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<no name provided>", "", "iMediaCodecTransEncoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, y>
  {
    h(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    i(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    j(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.g
 * JD-Core Version:    0.7.0.1
 */