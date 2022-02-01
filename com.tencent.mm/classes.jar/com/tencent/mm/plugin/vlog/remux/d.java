package com.tencent.mm.plugin.vlog.remux;

import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.i;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import d.a.j;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.z;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "remuxModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "(Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;)V", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "beforeCropSize", "Landroid/graphics/Point;", "bufId", "", "cropRect", "Landroid/graphics/Rect;", "decoder", "Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder;", "encodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "finishCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "errorCode", "", "frameCount", "heightScale", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "musicExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "musicPath", "mute", "remuxForThumb", "remuxMusicFinish", "remuxVideoFinish", "startTick", "", "thumbPath", "videoMixHandlerThread", "widthScale", "cancel", "getThumbBitmap", "width", "height", "onFinish", "release", "remuxFinish", "remuxMusic", "remuxVideo", "setCropInfo", "rect", "setMusicPath", "path", "setPreviewSurfaceSize", "start", "Companion", "plugin-vlog_release"})
public final class d
  implements com.tencent.mm.plugin.recordvideo.background.c.c
{
  public static final a BJS;
  private final aa BIE;
  private b BJK;
  private final com.tencent.mm.media.b.d BJL;
  private volatile boolean BJM;
  private volatile boolean BJN;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, z> BJO;
  private boolean BJP;
  private Point BJQ;
  private y BJR;
  private final int bufId;
  private int frameCount;
  private long gkt;
  private com.tencent.mm.media.e.b hlL;
  private com.tencent.mm.media.a.a hlN;
  private i hlP;
  private com.tencent.mm.media.f.a hlQ;
  private HandlerThread hlS;
  private HandlerThread hlT;
  private String hml;
  private Rect hmm;
  private boolean hvp;
  private float lzb;
  private float lzc;
  private String thumbPath;
  
  static
  {
    AppMethodBeat.i(111088);
    BJS = new a((byte)0);
    AppMethodBeat.o(111088);
  }
  
  public d(aa paramaa, y paramy)
  {
    AppMethodBeat.i(111087);
    this.BIE = paramaa;
    this.BJR = paramy;
    this.bufId = SightVideoJNI.initDataBufferForRemux(false);
    this.BJL = new com.tencent.mm.media.b.d();
    this.lzb = 1.0F;
    this.lzc = 1.0F;
    paramaa = com.tencent.mm.plugin.recordvideo.e.b.xRl;
    this.thumbPath = com.tencent.mm.plugin.recordvideo.e.b.avV(this.BJR.pSc);
    this.BJL.bitrate = this.BJR.videoBitrate;
    this.BJL.frameRate = this.BJR.frameRate;
    this.BJL.targetHeight = this.BJR.targetHeight;
    this.BJL.targetWidth = this.BJR.targetWidth;
    this.hlP = new i(0L, ((com.tencent.mm.plugin.vlog.model.l)j.je(this.BIE.BGM)).endTime, this.BJR.videoBitrate, false);
    ad.i("MicroMsg.VLogRemuxer", "encodeConfig: " + this.BJL + ' ');
    ad.i("MicroMsg.VLogRemuxer", "remuxModel: " + this.BJR + ' ');
    AppMethodBeat.o(111087);
  }
  
  private final void cancel()
  {
    AppMethodBeat.i(111086);
    Object localObject = this.BJK;
    if (localObject != null) {
      ((b)localObject).release();
    }
    localObject = this.hlL;
    if (localObject != null) {
      ((com.tencent.mm.media.e.b)localObject).att();
    }
    localObject = this.hlT;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    localObject = this.hlS;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      AppMethodBeat.o(111086);
      return;
    }
    AppMethodBeat.o(111086);
  }
  
  private final void esM()
  {
    boolean bool = false;
    AppMethodBeat.i(111084);
    if ((this.BJM) && (this.BJN))
    {
      int i = this.hlP.a(null, this.BJR.pSc, this.BJR.audioSampleRate, this.BJR.audioChannelCount, false);
      if (i >= 0) {
        bool = true;
      }
      ad.i("MicroMsg.VLogRemuxer", "mux finish, cost:" + bt.aO(this.gkt) + ",succ:" + bool + "  result:" + i + ", path:" + this.BJR + ".outputPath");
      release();
      if (bool)
      {
        SightVideoJNI.optimizeMP4VFS(this.BJR.pSc);
        localObject = com.tencent.mm.plugin.recordvideo.e.b.xRl;
        com.tencent.mm.plugin.recordvideo.e.b.iP(this.BJR.pSc, this.thumbPath);
      }
      Object localObject = this.BJO;
      if (localObject != null)
      {
        ((r)localObject).a(this.BJR.pSc, this.thumbPath, Boolean.valueOf(bool), Integer.valueOf(-1));
        AppMethodBeat.o(111084);
        return;
      }
    }
    AppMethodBeat.o(111084);
  }
  
  public final void aDt(String paramString)
  {
    AppMethodBeat.i(111080);
    ad.i("MicroMsg.VLogRemuxer", "setMusicPath path");
    this.hml = paramString;
    AppMethodBeat.o(111080);
  }
  
  public final void c(r<? super String, ? super String, ? super Boolean, ? super Integer, z> paramr)
  {
    AppMethodBeat.i(111081);
    ad.i("MicroMsg.VLogRemuxer", "start");
    this.BJO = paramr;
    this.gkt = bt.HI();
    paramr = this.hlT;
    if (paramr != null) {
      paramr.quit();
    }
    this.hlT = com.tencent.mm.ad.c.a("VLogRemuxer_remuxVideo", false, (d.g.a.a)new i(this));
    paramr = this.hlS;
    if (paramr != null) {
      paramr.quit();
    }
    this.hlS = com.tencent.mm.ad.c.a("VLogRemuxer_remuxMusic", false, (d.g.a.a)new j(this));
    AppMethodBeat.o(111081);
  }
  
  public final void iq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111083);
    Point localPoint;
    float f;
    if (this.BJQ != null)
    {
      localPoint = this.BJQ;
      if (localPoint == null) {
        p.gfZ();
      }
      if (localPoint.x > 0)
      {
        localPoint = this.BJQ;
        if (localPoint == null) {
          p.gfZ();
        }
        if (localPoint.y > 0)
        {
          f = paramInt1;
          localPoint = this.BJQ;
          if (localPoint == null) {
            p.gfZ();
          }
          this.lzb = (f / localPoint.x);
          f = paramInt2;
          localPoint = this.BJQ;
          if (localPoint == null) {
            p.gfZ();
          }
        }
      }
    }
    for (this.lzc = (f / localPoint.y);; this.lzc = (paramInt2 / this.BJR.targetHeight))
    {
      ad.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + paramInt1 + ", " + paramInt2 + "], scale:[" + this.lzb + ", " + this.lzc + ']');
      AppMethodBeat.o(111083);
      return;
      this.lzb = (paramInt1 / this.BJR.targetWidth);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(111085);
    ad.i("MicroMsg.VLogRemuxer", "release");
    cancel();
    this.hlP.release();
    AppMethodBeat.o(111085);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, z>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "pts", "", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$1"})
  static final class e
    extends d.g.b.q
    implements m<Long, Integer, z>
  {
    e(com.tencent.mm.media.e.b paramb, d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "buffer", "Ljava/nio/IntBuffer;", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$3"})
  static final class f
    extends d.g.b.q
    implements m<IntBuffer, Integer, z>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<Long, z>
  {
    g(com.tencent.mm.media.e.b paramb)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<no name provided>", "", "iMediaCodecTransEncoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    j(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.d
 * JD-Core Version:    0.7.0.1
 */