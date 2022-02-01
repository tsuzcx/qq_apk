package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.a;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.nio.IntBuffer;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "", "width", "", "height", "textureWidth", "textureHeight", "widthScale", "", "heightScale", "loop", "", "previewPlay", "(IIIIFFZZ)V", "(IIZZ)V", "cropRect", "Landroid/graphics/Rect;", "drawCount", "durationMs", "getDurationMs", "()I", "setDurationMs", "(I)V", "getHeight", "lastPlayTime", "", "getLoop", "()Z", "setLoop", "(Z)V", "nextDrawTimeDelay", "onEnd", "Lkotlin/Function1;", "", "getOnEnd", "()Lkotlin/jvm/functions/Function1;", "setOnEnd", "(Lkotlin/jvm/functions/Function1;)V", "onProgress", "Lkotlin/Function2;", "getOnProgress", "()Lkotlin/jvm/functions/Function2;", "setOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "prepared", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "scriptReader", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "snapShotCallback", "Ljava/nio/IntBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "getSnapShotCallback", "setSnapShotCallback", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "getWidth", "drawPreloadFrame", "getNextPtsStep", "getSize", "Landroid/util/Size;", "pause", "playNextFrame", "blendBitmap", "Landroid/graphics/Bitmap;", "withSnapshot", "drawCallback", "Lkotlin/Function0;", "preloadOneFrame", "release", "reset", "resetPts", "resume", "setCallback", "setCropRect", "rect", "setFrameRate", "videoFps", "imageFps", "setMute", "mute", "setScript", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "musicUrl", "", "setSnapshotCallback", "callback", "setVLogSurface", "updateDrawSize", "videoDecodeEnd", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a BIj;
  private long AAY;
  private i BIb;
  private com.tencent.mm.media.j.b.b BIc;
  public k BId;
  public m<? super Long, ? super Long, z> BIe;
  public d.g.a.b<? super Long, z> BIf;
  public d.g.a.b<? super IntBuffer, z> BIg;
  public long BIh;
  private final boolean BIi;
  private boolean bdb;
  private int gKJ;
  private int gKK;
  private int gfZ;
  public final int height;
  private Rect hmm;
  int imR;
  private boolean loop;
  private float lzb;
  private float lzc;
  long pts;
  public final int width;
  
  static
  {
    AppMethodBeat.i(195925);
    BIj = new a((byte)0);
    AppMethodBeat.o(195925);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2, false, false);
    AppMethodBeat.i(195924);
    this.lzb = paramFloat1;
    this.lzc = paramFloat2;
    this.gKJ = paramInt3;
    this.gKK = paramInt4;
    ad.i("MicroMsg.VLogDirector", "create VLogDirector, scale:[" + paramFloat1 + ", " + paramFloat2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(195924);
  }
  
  private c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(195923);
    this.width = paramInt1;
    this.height = paramInt2;
    this.loop = paramBoolean1;
    this.BIi = paramBoolean2;
    this.BIb = new i(this.BIi);
    this.lzb = 1.0F;
    this.lzc = 1.0F;
    this.pts = -1L;
    AppMethodBeat.o(195923);
  }
  
  private final void esH()
  {
    this.pts = 0L;
    this.gfZ = 0;
  }
  
  public final void a(final aa paramaa, int paramInt, String paramString)
  {
    AppMethodBeat.i(195913);
    p.h(paramaa, "scriptModel");
    p.h(paramString, "musicUrl");
    ad.i("MicroMsg.VLogDirector", hashCode() + "  setScript  durationMs :" + paramInt + "  musicUrl:" + paramString);
    this.imR = paramInt;
    esH();
    this.bdb = true;
    paramString = this.BId;
    if (paramString != null)
    {
      paramString.h((a)new h(this, paramaa));
      AppMethodBeat.o(195913);
      return;
    }
    AppMethodBeat.o(195913);
  }
  
  public final void a(final k paramk)
  {
    AppMethodBeat.i(195917);
    p.h(paramk, "vLogSurface");
    ad.i("MicroMsg.VLogDirector", hashCode() + " setSurface");
    this.BId = paramk;
    paramk.h((a)new i(this, paramk));
    AppMethodBeat.o(195917);
  }
  
  public final void cS(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(195918);
    ad.i("MicroMsg.VLogDirector", hashCode() + " updateDrawSize:[" + paramInt1 + ", " + paramInt2 + ']');
    k localk = this.BId;
    if (localk != null)
    {
      localk.h((a)new j(this, paramInt1, paramInt2));
      AppMethodBeat.o(195918);
      return;
    }
    AppMethodBeat.o(195918);
  }
  
  public final void esF()
  {
    AppMethodBeat.i(195915);
    i locali = this.BIb;
    locali.BIH = 33L;
    locali.BII = 33L;
    ad.i("MicroMsg.VLogScriptReader", "videoPtsStep :" + locali.BIH + " imagePtsStep:" + locali.BII);
    AppMethodBeat.o(195915);
  }
  
  public final void esG()
  {
    AppMethodBeat.i(195919);
    k localk = this.BId;
    if (localk != null)
    {
      localk.h((a)new b(this));
      AppMethodBeat.o(195919);
      return;
    }
    AppMethodBeat.o(195919);
  }
  
  public final void release()
  {
    AppMethodBeat.i(195921);
    ad.m("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 1", new Object[0]);
    Object localObject = this.BId;
    if (localObject != null)
    {
      ad.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 2");
      ((k)localObject).h((a)new e(this));
    }
    localObject = this.BId;
    if (localObject != null) {
      ((k)localObject).release();
    }
    localObject = e.BIv;
    e.clearCache();
    AppMethodBeat.o(195921);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(195916);
    if (paramRect != null)
    {
      ad.i("MicroMsg.VLogDirector", "setCropRect:" + paramRect + ", width:" + this.width + ", height:" + this.height + ", textureWidth:" + this.gKJ + ", textureHeight:" + this.gKK);
      this.hmm = new Rect(paramRect);
      paramRect = this.BIc;
      if (paramRect != null)
      {
        paramRect.hnr = this.hmm;
        AppMethodBeat.o(195916);
        return;
      }
    }
    AppMethodBeat.o(195916);
  }
  
  public final void setMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(195922);
    k localk = this.BId;
    if (localk != null)
    {
      localk.h((a)new g(this, paramBoolean));
      AppMethodBeat.o(195922);
      return;
    }
    AppMethodBeat.o(195922);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$drawPreloadFrame$1$1"})
  static final class b
    extends q
    implements a<z>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$pause$1$1"})
  public static final class c
    extends q
    implements a<z>
  {
    public c(c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$playNextFrame$1$1"})
  static final class d
    extends q
    implements a<z>
  {
    d(k paramk, c paramc, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$release$1$1"})
  static final class e
    extends q
    implements a<z>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$resume$1$1"})
  public static final class f
    extends q
    implements a<z>
  {
    public f(c paramc)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$setMute$1$1"})
  static final class g
    extends q
    implements a<z>
  {
    g(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<z>
  {
    h(c paramc, aa paramaa)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<z>
  {
    i(c paramc, k paramk)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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