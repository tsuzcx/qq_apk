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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "remuxModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "(Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;)V", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "beforeCropSize", "Landroid/graphics/Point;", "bufId", "", "cropRect", "Landroid/graphics/Rect;", "decoder", "Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder;", "encodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "finishCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "errorCode", "", "frameCount", "heightScale", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "musicExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "musicPath", "mute", "remuxForThumb", "remuxMusicFinish", "remuxVideoFinish", "startTick", "", "thumbPath", "videoMixHandlerThread", "widthScale", "cancel", "getThumbBitmap", "width", "height", "onFinish", "release", "remuxFinish", "remuxMusic", "remuxVideo", "setCropInfo", "rect", "setMusicPath", "path", "setPreviewSurfaceSize", "start", "Companion", "plugin-vlog_release"})
public final class e
  implements com.tencent.mm.plugin.recordvideo.background.c.c
{
  public static final a NqP;
  private final ah NpB;
  private c NqH;
  private final com.tencent.mm.media.b.d NqI;
  private volatile boolean NqJ;
  private volatile boolean NqK;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, x> NqL;
  private boolean NqM;
  private Point NqN;
  private af NqO;
  private final int bufId;
  private int frameCount;
  private long jID;
  private com.tencent.mm.media.e.b kWH;
  private com.tencent.mm.media.a.a kWJ;
  private i kWL;
  private com.tencent.mm.media.f.a kWM;
  private HandlerThread kWO;
  private HandlerThread kWP;
  private String kXi;
  private Rect kXj;
  private boolean lhf;
  private float pMa;
  private float pMb;
  private String thumbPath;
  
  static
  {
    AppMethodBeat.i(111088);
    NqP = new a((byte)0);
    AppMethodBeat.o(111088);
  }
  
  public e(ah paramah, af paramaf)
  {
    AppMethodBeat.i(111087);
    this.NpB = paramah;
    this.NqO = paramaf;
    this.bufId = SightVideoJNI.initDataBufferForRemux(false);
    this.NqI = new com.tencent.mm.media.b.d();
    this.pMa = 1.0F;
    this.pMb = 1.0F;
    paramah = com.tencent.mm.plugin.recordvideo.e.d.IeU;
    this.thumbPath = com.tencent.mm.plugin.recordvideo.e.d.aWm(this.NqO.uVk);
    this.NqI.bitrate = this.NqO.videoBitrate;
    this.NqI.frameRate = this.NqO.frameRate;
    this.NqI.targetHeight = this.NqO.targetHeight;
    this.NqI.targetWidth = this.NqO.targetWidth;
    this.kWL = new i(0L, ((s)j.lq(this.NpB.Nnw)).endTime, this.NqO.videoBitrate, false, null, 48);
    Log.i("MicroMsg.VLogRemuxer", "encodeConfig: " + this.NqI + ' ');
    Log.i("MicroMsg.VLogRemuxer", "remuxModel: " + this.NqO + ' ');
    AppMethodBeat.o(111087);
  }
  
  private final void cancel()
  {
    AppMethodBeat.i(111086);
    Object localObject = this.NqH;
    if (localObject != null) {
      ((c)localObject).release();
    }
    localObject = this.kWH;
    if (localObject != null) {
      ((com.tencent.mm.media.e.b)localObject).aUy();
    }
    localObject = this.kWP;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    localObject = this.kWO;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      AppMethodBeat.o(111086);
      return;
    }
    AppMethodBeat.o(111086);
  }
  
  private final void gur()
  {
    boolean bool = false;
    AppMethodBeat.i(111084);
    if ((this.NqJ) && (this.NqK))
    {
      int i = this.kWL.a(null, this.NqO.uVk, this.NqO.audioSampleRate, this.NqO.audioChannelCount, false);
      if (i >= 0) {
        bool = true;
      }
      Log.i("MicroMsg.VLogRemuxer", "mux finish, cost:" + Util.ticksToNow(this.jID) + ",succ:" + bool + "  result:" + i + ", path:" + this.NqO + ".outputPath");
      release();
      if (bool)
      {
        SightVideoJNI.optimizeMP4VFS(this.NqO.uVk);
        localObject = com.tencent.mm.plugin.recordvideo.e.d.IeU;
        com.tencent.mm.plugin.recordvideo.e.d.jV(this.NqO.uVk, this.thumbPath);
      }
      Object localObject = this.NqL;
      if (localObject != null)
      {
        ((r)localObject).a(this.NqO.uVk, this.thumbPath, Boolean.valueOf(bool), Integer.valueOf(-1));
        AppMethodBeat.o(111084);
        return;
      }
    }
    AppMethodBeat.o(111084);
  }
  
  public final void bfF(String paramString)
  {
    AppMethodBeat.i(111080);
    Log.i("MicroMsg.VLogRemuxer", "setMusicPath path");
    this.kXi = paramString;
    AppMethodBeat.o(111080);
  }
  
  public final void e(r<? super String, ? super String, ? super Boolean, ? super Integer, x> paramr)
  {
    AppMethodBeat.i(111081);
    Log.i("MicroMsg.VLogRemuxer", "start");
    this.NqL = paramr;
    this.jID = Util.currentTicks();
    paramr = this.kWP;
    if (paramr != null) {
      paramr.quit();
    }
    this.kWP = com.tencent.mm.ae.d.a("VLogRemuxer_remuxVideo", false, (kotlin.g.a.a)new i(this));
    paramr = this.kWO;
    if (paramr != null) {
      paramr.quit();
    }
    this.kWO = com.tencent.mm.ae.d.a("VLogRemuxer_remuxMusic", false, (kotlin.g.a.a)new j(this));
    AppMethodBeat.o(111081);
  }
  
  public final void kJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111083);
    Point localPoint;
    float f;
    if (this.NqN != null)
    {
      localPoint = this.NqN;
      if (localPoint == null) {
        p.iCn();
      }
      if (localPoint.x > 0)
      {
        localPoint = this.NqN;
        if (localPoint == null) {
          p.iCn();
        }
        if (localPoint.y > 0)
        {
          f = paramInt1;
          localPoint = this.NqN;
          if (localPoint == null) {
            p.iCn();
          }
          this.pMa = (f / localPoint.x);
          f = paramInt2;
          localPoint = this.NqN;
          if (localPoint == null) {
            p.iCn();
          }
        }
      }
    }
    for (this.pMb = (f / localPoint.y);; this.pMb = (paramInt2 / this.NqO.targetHeight))
    {
      Log.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + paramInt1 + ", " + paramInt2 + "], scale:[" + this.pMa + ", " + this.pMb + ']');
      AppMethodBeat.o(111083);
      return;
      this.pMa = (paramInt1 / this.NqO.targetWidth);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(111085);
    Log.i("MicroMsg.VLogRemuxer", "release");
    cancel();
    this.kWL.release();
    AppMethodBeat.o(111085);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "buffer", "Ljava/nio/ByteBuffer;", "bufferInfo", "Landroid/media/MediaCodec$BufferInfo;", "format", "Landroid/media/MediaFormat;", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.q<ByteBuffer, MediaCodec.BufferInfo, MediaFormat, x>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "pts", "", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$1"})
  static final class e
    extends kotlin.g.b.q
    implements m<Long, Integer, x>
  {
    e(com.tencent.mm.media.e.b paramb, e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "buffer", "Ljava/nio/IntBuffer;", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$3"})
  static final class f
    extends kotlin.g.b.q
    implements m<IntBuffer, Integer, x>
  {
    f(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, x>
  {
    g(com.tencent.mm.media.e.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<no name provided>", "", "iMediaCodecTransEncoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.media.e.b, x>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    j(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.e
 * JD-Core Version:    0.7.0.1
 */