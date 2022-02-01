package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.IntBuffer;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "", "width", "", "height", "textureWidth", "textureHeight", "widthScale", "", "heightScale", "loop", "", "previewPlay", "(IIIIFFZZ)V", "(IIZZ)V", "cropRect", "Landroid/graphics/Rect;", "drawCount", "durationMs", "getDurationMs", "()I", "setDurationMs", "(I)V", "getHeight", "lastPlayTime", "", "getLoop", "()Z", "setLoop", "(Z)V", "nextDrawTimeDelay", "onEnd", "Lkotlin/Function1;", "", "getOnEnd", "()Lkotlin/jvm/functions/Function1;", "setOnEnd", "(Lkotlin/jvm/functions/Function1;)V", "onProgress", "Lkotlin/Function2;", "getOnProgress", "()Lkotlin/jvm/functions/Function2;", "setOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "prepared", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "scriptReader", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "snapShotCallback", "Ljava/nio/IntBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "getSnapShotCallback", "setSnapShotCallback", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "getWidth", "drawPreloadFrame", "getNextPtsStep", "getSize", "Landroid/util/Size;", "pause", "playNextFrame", "blendBitmap", "Landroid/graphics/Bitmap;", "withSnapshot", "drawCallback", "Lkotlin/Function0;", "preloadOneFrame", "release", "reset", "resetPts", "resume", "setCallback", "setCropRect", "rect", "setFrameRate", "videoFps", "imageFps", "setMute", "mute", "setScript", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "musicUrl", "", "setSnapshotCallback", "callback", "setVLogSurface", "updateDrawSize", "videoDecodeEnd", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a BZI;
  private long ASt;
  private i BZA;
  private com.tencent.mm.media.j.b.b BZB;
  public k BZC;
  public m<? super Long, ? super Long, z> BZD;
  public d.g.a.b<? super Long, z> BZE;
  public d.g.a.b<? super IntBuffer, z> BZF;
  public long BZG;
  private final boolean BZH;
  private boolean bdb;
  private int gNs;
  private int gNt;
  private int gir;
  public final int height;
  private Rect hpa;
  int ipL;
  private float lDA;
  private float lDz;
  private boolean loop;
  long pts;
  public final int width;
  
  static
  {
    AppMethodBeat.i(191385);
    BZI = new a((byte)0);
    AppMethodBeat.o(191385);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2, false, false);
    AppMethodBeat.i(191384);
    this.lDz = paramFloat1;
    this.lDA = paramFloat2;
    this.gNs = paramInt3;
    this.gNt = paramInt4;
    ae.i("MicroMsg.VLogDirector", "create VLogDirector, scale:[" + paramFloat1 + ", " + paramFloat2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(191384);
  }
  
  private c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(191383);
    this.width = paramInt1;
    this.height = paramInt2;
    this.loop = paramBoolean1;
    this.BZH = paramBoolean2;
    this.BZA = new i(this.BZH);
    this.lDz = 1.0F;
    this.lDA = 1.0F;
    this.pts = -1L;
    AppMethodBeat.o(191383);
  }
  
  private final void ewo()
  {
    this.pts = 0L;
    this.gir = 0;
  }
  
  public final void a(final aa paramaa, int paramInt, String paramString)
  {
    AppMethodBeat.i(191373);
    p.h(paramaa, "scriptModel");
    p.h(paramString, "musicUrl");
    ae.i("MicroMsg.VLogDirector", hashCode() + "  setScript  durationMs :" + paramInt + "  musicUrl:" + paramString);
    this.ipL = paramInt;
    ewo();
    this.bdb = true;
    paramString = this.BZC;
    if (paramString != null)
    {
      paramString.i((a)new h(this, paramaa));
      AppMethodBeat.o(191373);
      return;
    }
    AppMethodBeat.o(191373);
  }
  
  public final void a(final k paramk)
  {
    AppMethodBeat.i(191377);
    p.h(paramk, "vLogSurface");
    ae.i("MicroMsg.VLogDirector", hashCode() + " setSurface");
    this.BZC = paramk;
    paramk.i((a)new i(this, paramk));
    AppMethodBeat.o(191377);
  }
  
  public final void cS(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(191378);
    ae.i("MicroMsg.VLogDirector", hashCode() + " updateDrawSize:[" + paramInt1 + ", " + paramInt2 + ']');
    k localk = this.BZC;
    if (localk != null)
    {
      localk.i((a)new j(this, paramInt1, paramInt2));
      AppMethodBeat.o(191378);
      return;
    }
    AppMethodBeat.o(191378);
  }
  
  public final void ewm()
  {
    AppMethodBeat.i(191375);
    i locali = this.BZA;
    locali.Cag = 33L;
    locali.Cah = 33L;
    ae.i("MicroMsg.VLogScriptReader", "videoPtsStep :" + locali.Cag + " imagePtsStep:" + locali.Cah);
    AppMethodBeat.o(191375);
  }
  
  public final void ewn()
  {
    AppMethodBeat.i(191379);
    k localk = this.BZC;
    if (localk != null)
    {
      localk.i((a)new b(this));
      AppMethodBeat.o(191379);
      return;
    }
    AppMethodBeat.o(191379);
  }
  
  public final void release()
  {
    AppMethodBeat.i(191381);
    ae.m("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 1", new Object[0]);
    Object localObject = this.BZC;
    if (localObject != null)
    {
      ae.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 2");
      ((k)localObject).i((a)new e(this));
    }
    localObject = this.BZC;
    if (localObject != null) {
      ((k)localObject).release();
    }
    localObject = e.BZU;
    e.clearCache();
    AppMethodBeat.o(191381);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(191376);
    if (paramRect != null)
    {
      ae.i("MicroMsg.VLogDirector", "setCropRect:" + paramRect + ", width:" + this.width + ", height:" + this.height + ", textureWidth:" + this.gNs + ", textureHeight:" + this.gNt);
      this.hpa = new Rect(paramRect);
      paramRect = this.BZB;
      if (paramRect != null)
      {
        paramRect.hqf = this.hpa;
        AppMethodBeat.o(191376);
        return;
      }
    }
    AppMethodBeat.o(191376);
  }
  
  public final void setMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(191382);
    k localk = this.BZC;
    if (localk != null)
    {
      localk.i((a)new g(this, paramBoolean));
      AppMethodBeat.o(191382);
      return;
    }
    AppMethodBeat.o(191382);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$drawPreloadFrame$1$1"})
  static final class b
    extends q
    implements a<z>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$pause$1$1"})
  public static final class c
    extends q
    implements a<z>
  {
    public c(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$playNextFrame$1$1"})
  static final class d
    extends q
    implements a<z>
  {
    d(k paramk, c paramc, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$release$1$1"})
  static final class e
    extends q
    implements a<z>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$resume$1$1"})
  public static final class f
    extends q
    implements a<z>
  {
    public f(c paramc)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$setMute$1$1"})
  static final class g
    extends q
    implements a<z>
  {
    g(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<z>
  {
    h(c paramc, aa paramaa)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<z>
  {
    i(c paramc, k paramk)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<z>
  {
    j(c paramc, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.c
 * JD-Core Version:    0.7.0.1
 */