package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.y;
import java.nio.IntBuffer;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "", "width", "", "height", "textureWidth", "textureHeight", "widthScale", "", "heightScale", "loop", "", "previewPlay", "(IIIIFFZZ)V", "(IIZZ)V", "cropRect", "Landroid/graphics/Rect;", "drawCount", "durationMs", "getDurationMs", "()I", "setDurationMs", "(I)V", "getHeight", "lastPlayTime", "", "getLoop", "()Z", "setLoop", "(Z)V", "nextDrawTimeDelay", "onEnd", "Lkotlin/Function1;", "", "getOnEnd", "()Lkotlin/jvm/functions/Function1;", "setOnEnd", "(Lkotlin/jvm/functions/Function1;)V", "onProgress", "Lkotlin/Function2;", "getOnProgress", "()Lkotlin/jvm/functions/Function2;", "setOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "prepared", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "scriptReader", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "snapShotCallback", "Ljava/nio/IntBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "getSnapShotCallback", "setSnapShotCallback", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "getWidth", "drawPreloadFrame", "getNextPtsStep", "getSize", "Landroid/util/Size;", "pause", "playNextFrame", "blendBitmap", "Landroid/graphics/Bitmap;", "withSnapshot", "drawCallback", "Lkotlin/Function0;", "preloadOneFrame", "release", "reset", "resetPts", "resume", "setCallback", "setCropRect", "rect", "setFrameRate", "videoFps", "imageFps", "setMute", "mute", "setScript", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "musicUrl", "", "setSnapshotCallback", "callback", "setVLogSurface", "updateDrawSize", "videoDecodeEnd", "Companion", "plugin-vlog_release"})
public final class h
{
  public static final a LrY;
  private k LrR;
  private com.tencent.mm.media.i.b.b LrS;
  public m LrT;
  public d.g.a.b<? super Long, y> LrU;
  public d.g.a.b<? super IntBuffer, y> LrV;
  public long LrW;
  private final boolean LrX;
  private boolean aRL;
  private int fIT;
  private Rect gtE;
  private int guI;
  private int guJ;
  final int height;
  int hsU;
  private float kAJ;
  private float kAK;
  private boolean loop;
  long pts;
  final int width;
  private long xWc;
  public d.g.a.m<? super Long, ? super Long, y> zaT;
  
  static
  {
    AppMethodBeat.i(201017);
    LrY = new a((byte)0);
    AppMethodBeat.o(201017);
  }
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2, false, false);
    AppMethodBeat.i(201016);
    this.kAJ = paramFloat1;
    this.kAK = paramFloat2;
    this.guI = paramInt3;
    this.guJ = paramInt4;
    ad.i("MicroMsg.VLogDirector", "create VLogDirector, scale:[" + paramFloat1 + ", " + paramFloat2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(201016);
  }
  
  private h(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201015);
    this.width = paramInt1;
    this.height = paramInt2;
    this.loop = paramBoolean1;
    this.LrX = paramBoolean2;
    this.LrR = new k(this.LrX);
    this.kAJ = 1.0F;
    this.kAK = 1.0F;
    this.pts = -1L;
    AppMethodBeat.o(201015);
  }
  
  private final void fYX()
  {
    this.pts = 0L;
    this.fIT = 0;
  }
  
  public final void a(final com.tencent.mm.plugin.vlog.model.h paramh, int paramInt, String paramString)
  {
    AppMethodBeat.i(201004);
    d.g.b.k.h(paramh, "scriptModel");
    d.g.b.k.h(paramString, "musicUrl");
    ad.i("MicroMsg.VLogDirector", hashCode() + "  setScript  durationMs :" + paramInt + "  musicUrl:" + paramString);
    this.hsU = paramInt;
    fYX();
    this.aRL = true;
    paramString = this.LrT;
    if (paramString != null)
    {
      paramString.j((a)new h(this, paramh));
      AppMethodBeat.o(201004);
      return;
    }
    AppMethodBeat.o(201004);
  }
  
  public final void a(final m paramm)
  {
    AppMethodBeat.i(201009);
    d.g.b.k.h(paramm, "vLogSurface");
    ad.i("MicroMsg.VLogDirector", hashCode() + " setSurface");
    this.LrT = paramm;
    paramm.j((a)new i(this, paramm));
    AppMethodBeat.o(201009);
  }
  
  public final void cR(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(201010);
    ad.i("MicroMsg.VLogDirector", hashCode() + " updateDrawSize:[" + paramInt1 + ", " + paramInt2 + ']');
    m localm = this.LrT;
    if (localm != null)
    {
      localm.j((a)new j(this, paramInt1, paramInt2));
      AppMethodBeat.o(201010);
      return;
    }
    AppMethodBeat.o(201010);
  }
  
  public final void fYV()
  {
    AppMethodBeat.i(201006);
    k localk = this.LrR;
    localk.Lso = 33L;
    localk.Lsp = 33L;
    ad.i("MicroMsg.VLogScriptReader", "videoPtsStep :" + localk.Lso + " imagePtsStep:" + localk.Lsp);
    AppMethodBeat.o(201006);
  }
  
  public final void fYW()
  {
    AppMethodBeat.i(201011);
    m localm = this.LrT;
    if (localm != null)
    {
      localm.j((a)new b(this));
      AppMethodBeat.o(201011);
      return;
    }
    AppMethodBeat.o(201011);
  }
  
  public final Size getSize()
  {
    AppMethodBeat.i(201008);
    Size localSize = new Size(this.width, this.height);
    AppMethodBeat.o(201008);
    return localSize;
  }
  
  public final void release()
  {
    AppMethodBeat.i(201013);
    ad.m("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 1", new Object[0]);
    Object localObject = this.LrT;
    if (localObject != null)
    {
      ad.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 2");
      ((m)localObject).j((a)new e(this));
    }
    localObject = this.LrT;
    if (localObject != null) {
      ((m)localObject).release();
    }
    localObject = d.yZX;
    d.clearCache();
    AppMethodBeat.o(201013);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(201007);
    if (paramRect != null)
    {
      ad.i("MicroMsg.VLogDirector", "setCropRect:" + paramRect + ", width:" + this.width + ", height:" + this.height + ", textureWidth:" + this.guI + ", textureHeight:" + this.guJ);
      this.gtE = new Rect(paramRect);
      paramRect = this.LrS;
      if (paramRect != null)
      {
        paramRect.guP = this.gtE;
        AppMethodBeat.o(201007);
        return;
      }
    }
    AppMethodBeat.o(201007);
  }
  
  public final void setMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(201014);
    m localm = this.LrT;
    if (localm != null)
    {
      localm.j((a)new g(this, paramBoolean));
      AppMethodBeat.o(201014);
      return;
    }
    AppMethodBeat.o(201014);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$drawPreloadFrame$1$1"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$pause$1$1"})
  public static final class c
    extends d.g.b.l
    implements a<y>
  {
    public c(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$playNextFrame$1$1"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(m paramm, h paramh, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$release$1$1"})
  static final class e
    extends d.g.b.l
    implements a<y>
  {
    e(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$resume$1$1"})
  public static final class f
    extends d.g.b.l
    implements a<y>
  {
    public f(h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$setMute$1$1"})
  static final class g
    extends d.g.b.l
    implements a<y>
  {
    g(h paramh, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class h
    extends d.g.b.l
    implements a<y>
  {
    h(h paramh, com.tencent.mm.plugin.vlog.model.h paramh1)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class i
    extends d.g.b.l
    implements a<y>
  {
    i(h paramh, m paramm)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements a<y>
  {
    j(h paramh, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.h
 * JD-Core Version:    0.7.0.1
 */