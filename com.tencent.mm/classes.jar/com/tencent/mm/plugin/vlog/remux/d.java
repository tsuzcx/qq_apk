package com.tencent.mm.plugin.vlog.remux;

import android.graphics.Point;
import android.graphics.Rect;
import android.media.MediaCodec.BufferInfo;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.vlog.model.w;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import d.a.j;
import d.g.a.m;
import d.g.a.r;
import d.g.b.k;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/remux/VLogRemuxer;", "Lcom/tencent/mm/plugin/recordvideo/background/mixer/IVideoRemuxer;", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "remuxModel", "Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;", "(Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;Lcom/tencent/mm/plugin/vlog/model/VLogGenerateModel;)V", "audioCodec", "Lcom/tencent/mm/media/codec/MediaCodecAACCodec;", "audioMixHandlerThread", "Landroid/os/HandlerThread;", "beforeCropSize", "Landroid/graphics/Point;", "bufId", "", "cropRect", "Landroid/graphics/Rect;", "decoder", "Lcom/tencent/mm/plugin/vlog/remux/VLogDecoder;", "encodeConfig", "Lcom/tencent/mm/media/config/VideoCodecConfig;", "encoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "finishCallback", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "mixVideo", "mixThumb", "", "ret", "errorCode", "", "frameCount", "heightScale", "", "mixMuxerController", "Lcom/tencent/mm/media/remuxer/MixMuxerController;", "musicExtractorWrapper", "Lcom/tencent/mm/media/extractor/MediaExtractorWrapper;", "musicPath", "mute", "remuxForThumb", "remuxMusicFinish", "remuxVideoFinish", "startTick", "", "thumbPath", "videoMixHandlerThread", "widthScale", "cancel", "getThumbBitmap", "width", "height", "onFinish", "release", "remuxFinish", "remuxMusic", "remuxVideo", "setCropInfo", "rect", "setMusicPath", "path", "setPreviewSurfaceSize", "start", "Companion", "plugin-vlog_release"})
public final class d
  implements com.tencent.mm.plugin.recordvideo.background.b.c
{
  public static final d.a Asb;
  private final com.tencent.mm.plugin.vlog.model.y Aqh;
  private b ArT;
  private final com.tencent.mm.media.b.d ArU;
  private volatile boolean ArV;
  private volatile boolean ArW;
  private r<? super String, ? super String, ? super Boolean, ? super Integer, d.y> ArX;
  private boolean ArY;
  private Point ArZ;
  private w Asa;
  private long fQT;
  private int frameCount;
  private final int gNJ;
  private com.tencent.mm.media.d.b gTK;
  private com.tencent.mm.media.a.a gTM;
  private com.tencent.mm.media.h.i gTO;
  private com.tencent.mm.media.e.a gTP;
  private HandlerThread gTR;
  private HandlerThread gTS;
  private String gUk;
  private Rect gUl;
  private boolean hdh;
  private float lcb;
  private float lcc;
  private String thumbPath;
  
  static
  {
    AppMethodBeat.i(111088);
    Asb = new d.a((byte)0);
    AppMethodBeat.o(111088);
  }
  
  public d(com.tencent.mm.plugin.vlog.model.y paramy, w paramw)
  {
    AppMethodBeat.i(111087);
    this.Aqh = paramy;
    this.Asa = paramw;
    this.gNJ = SightVideoJNI.initDataBufferForRemux(false);
    this.ArU = new com.tencent.mm.media.b.d();
    this.lcb = 1.0F;
    this.lcc = 1.0F;
    paramy = com.tencent.mm.plugin.recordvideo.e.b.wDE;
    this.thumbPath = com.tencent.mm.plugin.recordvideo.e.b.aqV(this.Asa.poB);
    this.ArU.bitrate = this.Asa.videoBitrate;
    this.ArU.frameRate = this.Asa.frameRate;
    this.ArU.gNV = this.Asa.gNV;
    this.ArU.gNU = this.Asa.gNU;
    this.gTO = new com.tencent.mm.media.h.i(0L, ((com.tencent.mm.plugin.vlog.model.i)j.iQ(this.Aqh.AoV)).endTime, this.Asa.videoBitrate, false);
    ac.i("MicroMsg.VLogRemuxer", "encodeConfig: " + this.ArU + ' ');
    ac.i("MicroMsg.VLogRemuxer", "remuxModel: " + this.Asa + ' ');
    AppMethodBeat.o(111087);
  }
  
  private final void cancel()
  {
    AppMethodBeat.i(111086);
    Object localObject = this.ArT;
    if (localObject != null) {
      ((b)localObject).release();
    }
    localObject = this.gTK;
    if (localObject != null) {
      ((com.tencent.mm.media.d.b)localObject).aqF();
    }
    localObject = this.gTS;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    localObject = this.gTR;
    if (localObject != null)
    {
      ((HandlerThread)localObject).quitSafely();
      AppMethodBeat.o(111086);
      return;
    }
    AppMethodBeat.o(111086);
  }
  
  private final void efZ()
  {
    boolean bool = false;
    AppMethodBeat.i(111084);
    if ((this.ArV) && (this.ArW))
    {
      int i = this.gTO.a(null, this.Asa.poB, this.Asa.audioSampleRate, this.Asa.gOt, false);
      if (i >= 0) {
        bool = true;
      }
      ac.i("MicroMsg.VLogRemuxer", "mux finish, cost:" + bs.aO(this.fQT) + ",succ:" + bool + "  result:" + i + ", path:" + this.Asa + ".outputPath");
      release();
      if (bool)
      {
        SightVideoJNI.optimizeMP4VFS(this.Asa.poB);
        localObject = com.tencent.mm.plugin.recordvideo.e.b.wDE;
        com.tencent.mm.plugin.recordvideo.e.b.iC(this.Asa.poB, this.thumbPath);
      }
      Object localObject = this.ArX;
      if (localObject != null)
      {
        ((r)localObject).a(this.Asa.poB, this.thumbPath, Boolean.valueOf(bool), Integer.valueOf(-1));
        AppMethodBeat.o(111084);
        return;
      }
    }
    AppMethodBeat.o(111084);
  }
  
  public final void ayn(String paramString)
  {
    AppMethodBeat.i(111080);
    ac.i("MicroMsg.VLogRemuxer", "setMusicPath path");
    this.gUk = paramString;
    AppMethodBeat.o(111080);
  }
  
  public final void c(r<? super String, ? super String, ? super Boolean, ? super Integer, d.y> paramr)
  {
    AppMethodBeat.i(111081);
    ac.i("MicroMsg.VLogRemuxer", "start");
    this.ArX = paramr;
    this.fQT = bs.Gn();
    paramr = this.gTS;
    if (paramr != null) {
      paramr.quit();
    }
    this.gTS = com.tencent.mm.ac.c.a("VLogRemuxer_remuxVideo", false, (d.g.a.a)new d.i(this));
    paramr = this.gTR;
    if (paramr != null) {
      paramr.quit();
    }
    this.gTR = com.tencent.mm.ac.c.a("VLogRemuxer_remuxMusic", false, (d.g.a.a)new d.j(this));
    AppMethodBeat.o(111081);
  }
  
  public final void ib(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111083);
    Point localPoint;
    float f;
    if (this.ArZ != null)
    {
      localPoint = this.ArZ;
      if (localPoint == null) {
        k.fOy();
      }
      if (localPoint.x > 0)
      {
        localPoint = this.ArZ;
        if (localPoint == null) {
          k.fOy();
        }
        if (localPoint.y > 0)
        {
          f = paramInt1;
          localPoint = this.ArZ;
          if (localPoint == null) {
            k.fOy();
          }
          this.lcb = (f / localPoint.x);
          f = paramInt2;
          localPoint = this.ArZ;
          if (localPoint == null) {
            k.fOy();
          }
        }
      }
    }
    for (this.lcc = (f / localPoint.y);; this.lcc = (paramInt2 / this.Asa.gNV))
    {
      ac.i("MicroMsg.VLogRemuxer", "setPreviewSurfaceSize: [" + paramInt1 + ", " + paramInt2 + "], scale:[" + this.lcb + ", " + this.lcc + ']');
      AppMethodBeat.o(111083);
      return;
      this.lcb = (paramInt1 / this.Asa.gNU);
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(111085);
    ac.i("MicroMsg.VLogRemuxer", "release");
    cancel();
    this.gTO.release();
    AppMethodBeat.o(111085);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<d.y>
  {
    d(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "pts", "", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$1"})
  static final class e
    extends d.g.b.l
    implements m<Long, Integer, d.y>
  {
    e(com.tencent.mm.media.d.b paramb, d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "buffer", "Ljava/nio/IntBuffer;", "frameCount", "", "invoke", "com/tencent/mm/plugin/vlog/remux/VLogRemuxer$remuxVideo$1$3"})
  static final class f
    extends d.g.b.l
    implements m<IntBuffer, Integer, d.y>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Long, d.y>
  {
    g(com.tencent.mm.media.d.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<no name provided>", "", "iMediaCodecTransEncoder", "Lcom/tencent/mm/media/encoder/IMediaCodecTransEncoder;", "invoke"})
  static final class h
    extends d.g.b.l
    implements d.g.a.b<com.tencent.mm.media.d.b, d.y>
  {
    h(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.remux.d
 * JD-Core Version:    0.7.0.1
 */