package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.g.a.m;
import d.g.b.k;
import java.nio.IntBuffer;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "", "width", "", "height", "textureWidth", "textureHeight", "widthScale", "", "heightScale", "loop", "", "previewPlay", "(IIIIFFZZ)V", "(IIZZ)V", "cropRect", "Landroid/graphics/Rect;", "drawCount", "durationMs", "getDurationMs", "()I", "setDurationMs", "(I)V", "getHeight", "lastPlayTime", "", "getLoop", "()Z", "setLoop", "(Z)V", "nextDrawTimeDelay", "onEnd", "Lkotlin/Function1;", "", "getOnEnd", "()Lkotlin/jvm/functions/Function1;", "setOnEnd", "(Lkotlin/jvm/functions/Function1;)V", "onProgress", "Lkotlin/Function2;", "getOnProgress", "()Lkotlin/jvm/functions/Function2;", "setOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "prepared", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "scriptReader", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "snapShotCallback", "Ljava/nio/IntBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "getSnapShotCallback", "setSnapShotCallback", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "getWidth", "drawPreloadFrame", "getNextPtsStep", "getSize", "Landroid/util/Size;", "pause", "playNextFrame", "blendBitmap", "Landroid/graphics/Bitmap;", "withSnapshot", "drawCallback", "Lkotlin/Function0;", "preloadOneFrame", "release", "reset", "resetPts", "resume", "setCallback", "setCropRect", "rect", "setFrameRate", "videoFps", "imageFps", "setMute", "mute", "setScript", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "musicUrl", "", "setSnapshotCallback", "callback", "setVLogSurface", "updateDrawSize", "videoDecodeEnd", "Companion", "plugin-vlog_release"})
public final class d
{
  public static final d.a ApL;
  private j ApD;
  private com.tencent.mm.media.i.b.b ApE;
  public l ApF;
  public m<? super Long, ? super Long, d.y> ApG;
  public d.g.a.b<? super Long, d.y> ApH;
  public d.g.a.b<? super IntBuffer, d.y> ApI;
  public long ApJ;
  private final boolean ApK;
  private boolean aSG;
  private int fMz;
  private Rect gUl;
  private int gqZ;
  private int gra;
  int hTw;
  final int height;
  private float lcb;
  private float lcc;
  private boolean loop;
  long pts;
  final int width;
  private long ziY;
  
  static
  {
    AppMethodBeat.i(207703);
    ApL = new d.a((byte)0);
    AppMethodBeat.o(207703);
  }
  
  public d(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2, false, false);
    AppMethodBeat.i(207702);
    this.lcb = paramFloat1;
    this.lcc = paramFloat2;
    this.gqZ = paramInt3;
    this.gra = paramInt4;
    ac.i("MicroMsg.VLogDirector", "create VLogDirector, scale:[" + paramFloat1 + ", " + paramFloat2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(207702);
  }
  
  private d(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(207701);
    this.width = paramInt1;
    this.height = paramInt2;
    this.loop = paramBoolean1;
    this.ApK = paramBoolean2;
    this.ApD = new j(this.ApK);
    this.lcb = 1.0F;
    this.lcc = 1.0F;
    this.pts = -1L;
    AppMethodBeat.o(207701);
  }
  
  private final void efU()
  {
    this.pts = 0L;
    this.fMz = 0;
  }
  
  public final void a(final com.tencent.mm.plugin.vlog.model.y paramy, int paramInt, String paramString)
  {
    AppMethodBeat.i(207690);
    k.h(paramy, "scriptModel");
    k.h(paramString, "musicUrl");
    ac.i("MicroMsg.VLogDirector", hashCode() + "  setScript  durationMs :" + paramInt + "  musicUrl:" + paramString);
    this.hTw = paramInt;
    efU();
    this.aSG = true;
    paramString = this.ApF;
    if (paramString != null)
    {
      paramString.h((a)new h(this, paramy));
      AppMethodBeat.o(207690);
      return;
    }
    AppMethodBeat.o(207690);
  }
  
  public final void a(final l paraml)
  {
    AppMethodBeat.i(207695);
    k.h(paraml, "vLogSurface");
    ac.i("MicroMsg.VLogDirector", hashCode() + " setSurface");
    this.ApF = paraml;
    paraml.h((a)new i(this, paraml));
    AppMethodBeat.o(207695);
  }
  
  public final void cQ(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(207696);
    ac.i("MicroMsg.VLogDirector", hashCode() + " updateDrawSize:[" + paramInt1 + ", " + paramInt2 + ']');
    l locall = this.ApF;
    if (locall != null)
    {
      locall.h((a)new j(this, paramInt1, paramInt2));
      AppMethodBeat.o(207696);
      return;
    }
    AppMethodBeat.o(207696);
  }
  
  public final void efS()
  {
    AppMethodBeat.i(207692);
    j localj = this.ApD;
    localj.Aqk = 33L;
    localj.Aql = 33L;
    ac.i("MicroMsg.VLogScriptReader", "videoPtsStep :" + localj.Aqk + " imagePtsStep:" + localj.Aql);
    AppMethodBeat.o(207692);
  }
  
  public final void efT()
  {
    AppMethodBeat.i(207697);
    l locall = this.ApF;
    if (locall != null)
    {
      locall.h((a)new b(this));
      AppMethodBeat.o(207697);
      return;
    }
    AppMethodBeat.o(207697);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(207694);
    Size localSize = new Size(this.width, this.height);
    AppMethodBeat.o(207694);
    return localSize;
  }
  
  public final void release()
  {
    AppMethodBeat.i(207699);
    ac.m("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 1", new Object[0]);
    Object localObject = this.ApF;
    if (localObject != null)
    {
      ac.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 2");
      ((l)localObject).h((a)new e(this));
    }
    localObject = this.ApF;
    if (localObject != null) {
      ((l)localObject).release();
    }
    localObject = f.ApY;
    f.clearCache();
    AppMethodBeat.o(207699);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(207693);
    if (paramRect != null)
    {
      ac.i("MicroMsg.VLogDirector", "setCropRect:" + paramRect + ", width:" + this.width + ", height:" + this.height + ", textureWidth:" + this.gqZ + ", textureHeight:" + this.gra);
      this.gUl = new Rect(paramRect);
      paramRect = this.ApE;
      if (paramRect != null)
      {
        paramRect.gVo = this.gUl;
        AppMethodBeat.o(207693);
        return;
      }
    }
    AppMethodBeat.o(207693);
  }
  
  public final void setMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(207700);
    l locall = this.ApF;
    if (locall != null)
    {
      locall.h((a)new g(this, paramBoolean));
      AppMethodBeat.o(207700);
      return;
    }
    AppMethodBeat.o(207700);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$drawPreloadFrame$1$1"})
  static final class b
    extends d.g.b.l
    implements a<d.y>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$pause$1$1"})
  public static final class c
    extends d.g.b.l
    implements a<d.y>
  {
    public c(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$playNextFrame$1$1"})
  static final class d
    extends d.g.b.l
    implements a<d.y>
  {
    d(l paraml, d paramd, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$release$1$1"})
  static final class e
    extends d.g.b.l
    implements a<d.y>
  {
    e(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$resume$1$1"})
  public static final class f
    extends d.g.b.l
    implements a<d.y>
  {
    public f(d paramd)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$setMute$1$1"})
  static final class g
    extends d.g.b.l
    implements a<d.y>
  {
    g(d paramd, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<d.y>
  {
    h(d paramd, com.tencent.mm.plugin.vlog.model.y paramy)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements a<d.y>
  {
    i(d paramd, l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements a<d.y>
  {
    j(d paramd, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.d
 * JD-Core Version:    0.7.0.1
 */