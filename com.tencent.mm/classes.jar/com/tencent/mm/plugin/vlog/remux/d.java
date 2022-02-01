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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import d.a.j;
import d.g.a.m;
import d.g.a.r;
import d.g.b.p;
import d.z;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "remuxModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "(Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;)V", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "beforeCropSize", "Landroid/graphics/Point;", "bufId", "", "cropRect", "Landroid/graphics/Rect;", "decoder", "Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder;", "encodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "finishCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "errorCode", "", "frameCount", "heightScale", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "musicExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "musicPath", "mute", "remuxForThumb", "remuxMusicFinish", "remuxVideoFinish", "startTick", "", "thumbPath", "videoMixHandlerThread", "widthScale", "cancel", "getThumbBitmap", "width", "height", "onFinish", "release", "remuxFinish", "remuxMusic", "remuxVideo", "setCropInfo", "rect", "setMusicPath", "path", "setPreviewSurfaceSize", "start", "Companion", "plugin-vlog_release"})
public final class d
  implements com.tencent.mm.plugin.recordvideo.background.c.c
{
  public static final a Cbr;
  private final aa Cad;
  private b Cbj;
  private final com.tencent.mm.media.b.d Cbk;
  private volatile boolean Cbl;
  private volatile boolean Cbm;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, z> Cbn;
  private boolean Cbo;
  private Point Cbp;
  private y Cbq;
  private final int bufId;
  private int frameCount;
  private long gmN;
  private com.tencent.mm.media.a.a hoB;
  private i hoD;
  private com.tencent.mm.media.f.a hoE;
  private HandlerThread hoG;
  private HandlerThread hoH;
  private String hoZ;
  private com.tencent.mm.media.e.b hoz;
  private Rect hpa;
  private boolean hyd;
  private float lDA;
  private float lDz;
  private String thumbPath;
  
  static
  {
    AppMethodBeat.i(111088);
    Cbr = new a((byte)0);
    AppMethodBeat.o(111088);
  }
  
  public d(aa paramaa, y paramy)
  {
    AppMethodBeat.i(111087);
    this.Cad = paramaa;
    this.Cbq = paramy;
    this.bufId = SightVideoJNI.initDataBufferForRemux(false);
    this.Cbk = new com.tencent.mm.media.b.d();
    this.lDz = 1.0F;
    this.lDA = 1.0F;
    paramaa = com.tencent.mm.plugin.recordvideo.e.b.yhe;
    this.thumbPath = com.tencent.mm.plugin.recordvideo.e.b.axk(this.Cbq.pYH);
    this.Cbk.bitrate = this.Cbq.videoBitrate;
    this.Cbk.frameRate = this.Cbq.frameRate;
    this.Cbk.targetHeight = this.Cbq.targetHeight;
    this.Cbk.targetWidth = this.Cbq.targetWidth;
    this.hoD = new i(0L, ((com.tencent.mm.plugin.vlog.model.l)j.jn(this.Cad.BYl)).endTime, this.Cbq.videoBitrate, false);
    ae.i("MicroMsg.VLogRemuxer", "encodeConfig: " + this.Cbk + ' ');
    ae.i("MicroMsg.VLogRemuxer", "remuxModel: " + this.Cbq + ' ');
    AppMethodBeat.o(111087);
  }
  
  private final void cancel()
  {
    AppMethodBeat.i(111086);
    Object localObject = this.Cbj;
    if (localObject != null) {
      ((b)localObject).release();
    }
    localObject = this.hoz;
    if (localObject != null) {
      ((com.tencent.mm.media.e.b)localObject).atI();
    }
    localObject = this.hoH;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    localObject = this.hoG;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      AppMethodBeat.o(111086);
      return;
    }
    AppMethodBeat.o(111086);
  }
  
  private final void ewt()
  {
    boolean bool = false;
    AppMethodBeat.i(111084);
    if ((this.Cbl) && (this.Cbm))
    {
      int i = this.hoD.a(null, this.Cbq.pYH, this.Cbq.audioSampleRate, this.Cbq.audioChannelCount, false);
      if (i >= 0) {
        bool = true;
      }
      ae.i("MicroMsg.VLogRemuxer", "mux finish, cost:" + bu.aO(this.gmN) + ",succ:" + bool + "  result:" + i + ", path:" + this.Cbq + ".outputPath");
      release();
      if (bool)
      {
        SightVideoJNI.optimizeMP4VFS(this.Cbq.pYH);
        localObject = com.tencent.mm.plugin.recordvideo.e.b.yhe;
        com.tencent.mm.plugin.recordvideo.e.b.iV(this.Cbq.pYH, this.thumbPath);
      }
      Object localObject = this.Cbn;
      if (localObject != null)
      {
        ((r)localObject).a(this.Cbq.pYH, this.thumbPath, Boolean.valueOf(bool), Integer.valueOf(-1));
        AppMethodBeat.o(111084);
        return;
      }
    }
    AppMethodBeat.o(111084);
  }
  
  public final void aEM(String paramString)
  {
    AppMethodBeat.i(111080);
    ae.i("MicroMsg.VLogRemuxer", "setMusicPath path");
    this.hoZ = paramString;
    AppMethodBeat.o(111080);
  }
  
  public final void c(r<? super String, ? super String, ? super Boolean, ? super Integer, z> paramr)
  {
    AppMethodBeat.i(111081);
    ae.i("MicroMsg.VLogRemuxer", "start");
    this.Cbn = paramr;
    this.gmN = bu.HQ();
    paramr = this.hoH;
    if (paramr != null) {
      paramr.quit();
    }
    this.hoH = com.tencent.mm.ac.c.a("VLogRemuxer_remuxVideo", false, (d.g.a.a)new i(this));
    paramr = this.hoG;
    if (paramr != null) {
      paramr.quit();
    }
    this.hoG = com.tencent.mm.ac.c.a("VLogRemuxer_remuxMusic", false, (d.g.a.a)new j(this));
    AppMethodBeat.o(111081);
  }
  
  public final void iu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111083);
    Point localPoint;
    float f;
    if (this.Cbp != null)
    {
      localPoint = this.Cbp;
      if (localPoint == null) {
        p.gkB();
      }
      if (localPoint.x > 0)
      {
        localPoint = this.Cbp;
        if (localPoint == null) {
          p.gkB();
        }
        if (localPoint.y > 0)
        {
          f = paramInt1;
          localPoint = this.Cbp;
          if (localPoint == null) {
            p.gkB();
          }
          this.lDz = (f / localPoint.x);
          f = paramInt2;
          localPoint = this.Cbp;
          if (localPoint == null) {
            p.gkB();
          }
        }
      }
    }
    for (this.lDA = (f / localPoint.y);; this.lDA = (paramInt2 / this.Cbq.targetHeight))
    {
      ae.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + paramInt1 + ", " + paramInt2 + "], scale:[" + this.lDz + ", " + this.lDA + ']');
      AppMethodBeat.o(111083);
      return;
      this.lDz = (paramInt1 / this.Cbq.targetWidth);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(111085);
    ae.i("MicroMsg.VLogRemuxer", "release");
    cancel();
    this.hoD.release();
    AppMethodBeat.o(111085);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class c
    extends d.g.b.q
    implements d.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, z>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "pts", "", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$1"})
  static final class e
    extends d.g.b.q
    implements m<Long, Integer, z>
  {
    e(com.tencent.mm.media.e.b paramb, d paramd)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "buffer", "Ljava/nio/IntBuffer;", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$3"})
  static final class f
    extends d.g.b.q
    implements m<IntBuffer, Integer, z>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends d.g.b.q
    implements d.g.a.b<Long, z>
  {
    g(com.tencent.mm.media.e.b paramb)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<no name provided>", "", "iMediaCodecTransEncoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends d.g.b.q
    implements d.g.a.b<com.tencent.mm.media.e.b, z>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.q
    implements d.g.a.a<z>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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