package com.tencent.mm.plugin.vlog.remux;

import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.i;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.af;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "remuxModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "(Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;)V", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "beforeCropSize", "Landroid/graphics/Point;", "bufId", "", "cropRect", "Landroid/graphics/Rect;", "decoder", "Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder;", "encodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "finishCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "errorCode", "", "frameCount", "heightScale", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "musicExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "musicPath", "mute", "remuxForThumb", "remuxMusicFinish", "remuxVideoFinish", "startTick", "", "thumbPath", "videoMixHandlerThread", "widthScale", "cancel", "getThumbBitmap", "width", "height", "onFinish", "release", "remuxFinish", "remuxMusic", "remuxVideo", "setCropInfo", "rect", "setMusicPath", "path", "setPreviewSurfaceSize", "start", "Companion", "plugin-vlog_release"})
public final class d
  implements com.tencent.mm.plugin.recordvideo.background.c.c
{
  public static final a GDf;
  private final ah GBQ;
  private b GCX;
  private final com.tencent.mm.media.b.d GCY;
  private volatile boolean GCZ;
  private volatile boolean GDa;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, x> GDb;
  private boolean GDc;
  private Point GDd;
  private af GDe;
  private final int bufId;
  private int frameCount;
  private long gXF;
  private com.tencent.mm.media.e.b ihT;
  private com.tencent.mm.media.a.a ihV;
  private i ihX;
  private com.tencent.mm.media.f.a ihY;
  private HandlerThread iia;
  private HandlerThread iib;
  private String iiv;
  private Rect iiw;
  private boolean isb;
  private float mLi;
  private float mLj;
  private String thumbPath;
  
  static
  {
    AppMethodBeat.i(111088);
    GDf = new a((byte)0);
    AppMethodBeat.o(111088);
  }
  
  public d(ah paramah, af paramaf)
  {
    AppMethodBeat.i(111087);
    this.GBQ = paramah;
    this.GDe = paramaf;
    this.bufId = SightVideoJNI.initDataBufferForRemux(false);
    this.GCY = new com.tencent.mm.media.b.d();
    this.mLi = 1.0F;
    this.mLj = 1.0F;
    paramah = com.tencent.mm.plugin.recordvideo.e.c.Cic;
    this.thumbPath = com.tencent.mm.plugin.recordvideo.e.c.aLI(this.GDe.rpE);
    this.GCY.bitrate = this.GDe.videoBitrate;
    this.GCY.frameRate = this.GDe.frameRate;
    this.GCY.targetHeight = this.GDe.targetHeight;
    this.GCY.targetWidth = this.GDe.targetWidth;
    this.ihX = new i(0L, ((s)j.ku(this.GBQ.GzQ)).endTime, this.GDe.videoBitrate, false);
    Log.i("MicroMsg.VLogRemuxer", "encodeConfig: " + this.GCY + ' ');
    Log.i("MicroMsg.VLogRemuxer", "remuxModel: " + this.GDe + ' ');
    AppMethodBeat.o(111087);
  }
  
  private final void cancel()
  {
    AppMethodBeat.i(111086);
    Object localObject = this.GCX;
    if (localObject != null) {
      ((b)localObject).release();
    }
    localObject = this.ihT;
    if (localObject != null) {
      ((com.tencent.mm.media.e.b)localObject).aMj();
    }
    localObject = this.iib;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    localObject = this.iia;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      AppMethodBeat.o(111086);
      return;
    }
    AppMethodBeat.o(111086);
  }
  
  private final void fCs()
  {
    boolean bool = false;
    AppMethodBeat.i(111084);
    if ((this.GCZ) && (this.GDa))
    {
      int i = this.ihX.a(null, this.GDe.rpE, this.GDe.audioSampleRate, this.GDe.audioChannelCount, false);
      if (i >= 0) {
        bool = true;
      }
      Log.i("MicroMsg.VLogRemuxer", "mux finish, cost:" + Util.ticksToNow(this.gXF) + ",succ:" + bool + "  result:" + i + ", path:" + this.GDe + ".outputPath");
      release();
      if (bool)
      {
        SightVideoJNI.optimizeMP4VFS(this.GDe.rpE);
        localObject = com.tencent.mm.plugin.recordvideo.e.c.Cic;
        com.tencent.mm.plugin.recordvideo.e.c.jG(this.GDe.rpE, this.thumbPath);
      }
      Object localObject = this.GDb;
      if (localObject != null)
      {
        ((r)localObject).invoke(this.GDe.rpE, this.thumbPath, Boolean.valueOf(bool), Integer.valueOf(-1));
        AppMethodBeat.o(111084);
        return;
      }
    }
    AppMethodBeat.o(111084);
  }
  
  public final void aUg(String paramString)
  {
    AppMethodBeat.i(111080);
    Log.i("MicroMsg.VLogRemuxer", "setMusicPath path");
    this.iiv = paramString;
    AppMethodBeat.o(111080);
  }
  
  public final void e(r<? super String, ? super String, ? super Boolean, ? super Integer, x> paramr)
  {
    AppMethodBeat.i(111081);
    Log.i("MicroMsg.VLogRemuxer", "start");
    this.GDb = paramr;
    this.gXF = Util.currentTicks();
    paramr = this.iib;
    if (paramr != null) {
      paramr.quit();
    }
    this.iib = com.tencent.mm.ac.d.a("VLogRemuxer_remuxVideo", false, (kotlin.g.a.a)new i(this));
    paramr = this.iia;
    if (paramr != null) {
      paramr.quit();
    }
    this.iia = com.tencent.mm.ac.d.a("VLogRemuxer_remuxMusic", false, (kotlin.g.a.a)new j(this));
    AppMethodBeat.o(111081);
  }
  
  public final void jw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111083);
    Point localPoint;
    float f;
    if (this.GDd != null)
    {
      localPoint = this.GDd;
      if (localPoint == null) {
        p.hyc();
      }
      if (localPoint.x > 0)
      {
        localPoint = this.GDd;
        if (localPoint == null) {
          p.hyc();
        }
        if (localPoint.y > 0)
        {
          f = paramInt1;
          localPoint = this.GDd;
          if (localPoint == null) {
            p.hyc();
          }
          this.mLi = (f / localPoint.x);
          f = paramInt2;
          localPoint = this.GDd;
          if (localPoint == null) {
            p.hyc();
          }
        }
      }
    }
    for (this.mLj = (f / localPoint.y);; this.mLj = (paramInt2 / this.GDe.targetHeight))
    {
      Log.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + paramInt1 + ", " + paramInt2 + "], scale:[" + this.mLi + ", " + this.mLj + ']');
      AppMethodBeat.o(111083);
      return;
      this.mLi = (paramInt1 / this.GDe.targetWidth);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(111085);
    Log.i("MicroMsg.VLogRemuxer", "release");
    cancel();
    this.ihX.release();
    AppMethodBeat.o(111085);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "pts", "", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$1"})
  static final class e
    extends kotlin.g.b.q
    implements m<Long, Integer, x>
  {
    e(com.tencent.mm.media.e.b paramb, d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buffer", "Ljava/nio/IntBuffer;", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$3"})
  static final class f
    extends kotlin.g.b.q
    implements m<IntBuffer, Integer, x>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, x>
  {
    g(com.tencent.mm.media.e.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<no name provided>", "", "iMediaCodecTransEncoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    h(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(d paramd)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.d
 * JD-Core Version:    0.7.0.1
 */