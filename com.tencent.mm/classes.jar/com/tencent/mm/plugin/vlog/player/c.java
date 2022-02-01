package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.IntBuffer;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "", "width", "", "height", "textureWidth", "textureHeight", "widthScale", "", "heightScale", "loop", "", "previewPlay", "(IIIIFFZZ)V", "(IIZZ)V", "cropRect", "Landroid/graphics/Rect;", "drawCount", "durationMs", "getDurationMs", "()I", "setDurationMs", "(I)V", "getHeight", "lastPlayTime", "", "getLoop", "()Z", "setLoop", "(Z)V", "nextDrawTimeDelay", "onEnd", "Lkotlin/Function1;", "", "getOnEnd", "()Lkotlin/jvm/functions/Function1;", "setOnEnd", "(Lkotlin/jvm/functions/Function1;)V", "onProgress", "Lkotlin/Function2;", "getOnProgress", "()Lkotlin/jvm/functions/Function2;", "setOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "prepared", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "scriptReader", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "snapShotCallback", "Ljava/nio/IntBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "getSnapShotCallback", "setSnapShotCallback", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "getWidth", "drawPreloadFrame", "getNextPtsStep", "getSize", "Landroid/util/Size;", "pause", "playNextFrame", "blendBitmap", "Landroid/graphics/Bitmap;", "withSnapshot", "drawCallback", "Lkotlin/Function0;", "preloadOneFrame", "release", "reset", "resetPts", "resume", "setCallback", "setCropRect", "rect", "setFrameRate", "videoFps", "imageFps", "setMute", "mute", "setScript", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "musicUrl", "", "setSnapshotCallback", "callback", "setVLogSurface", "updateDrawSize", "videoDecodeEnd", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a Nph;
  private i NoZ;
  private com.tencent.mm.media.j.b.b Npa;
  public k Npb;
  public m<? super Long, ? super Long, x> Npc;
  public kotlin.g.a.b<? super Long, x> Npd;
  public kotlin.g.a.b<? super IntBuffer, x> Npe;
  public long Npf;
  private final boolean Npg;
  private boolean aMy;
  public final int height;
  private int jCf;
  private Rect kXj;
  private int krg;
  private int krh;
  private boolean loop;
  int maT;
  private float pMa;
  private float pMb;
  long pts;
  public final int width;
  private long zXq;
  
  static
  {
    AppMethodBeat.i(228109);
    Nph = new a((byte)0);
    AppMethodBeat.o(228109);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2, false, false);
    AppMethodBeat.i(228105);
    this.pMa = paramFloat1;
    this.pMb = paramFloat2;
    this.krg = paramInt3;
    this.krh = paramInt4;
    Log.i("MicroMsg.VLogDirector", "create VLogDirector, scale:[" + paramFloat1 + ", " + paramFloat2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(228105);
  }
  
  private c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(228098);
    this.width = paramInt1;
    this.height = paramInt2;
    this.loop = paramBoolean1;
    this.Npg = paramBoolean2;
    this.NoZ = new i(this.Npg);
    this.pMa = 1.0F;
    this.pMb = 1.0F;
    this.pts = -1L;
    AppMethodBeat.o(228098);
  }
  
  private final void gum()
  {
    this.pts = 0L;
    this.jCf = 0;
  }
  
  public final void a(final ah paramah, int paramInt, String paramString)
  {
    AppMethodBeat.i(228066);
    p.k(paramah, "scriptModel");
    p.k(paramString, "musicUrl");
    Log.i("MicroMsg.VLogDirector", hashCode() + "  setScript  durationMs :" + paramInt + "  musicUrl:" + paramString);
    this.maT = paramInt;
    gum();
    this.aMy = true;
    paramString = this.Npb;
    if (paramString != null)
    {
      paramString.i((a)new h(this, paramah));
      AppMethodBeat.o(228066);
      return;
    }
    AppMethodBeat.o(228066);
  }
  
  public final void a(final k paramk)
  {
    AppMethodBeat.i(228080);
    p.k(paramk, "vLogSurface");
    Log.i("MicroMsg.VLogDirector", hashCode() + " setSurface");
    this.Npb = paramk;
    paramk.i((a)new i(this, paramk));
    AppMethodBeat.o(228080);
  }
  
  public final void dt(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(228084);
    Log.i("MicroMsg.VLogDirector", hashCode() + " updateDrawSize:[" + paramInt1 + ", " + paramInt2 + ']');
    k localk = this.Npb;
    if (localk != null)
    {
      localk.i((a)new j(this, paramInt1, paramInt2));
      AppMethodBeat.o(228084);
      return;
    }
    AppMethodBeat.o(228084);
  }
  
  public final void guk()
  {
    AppMethodBeat.i(228073);
    i locali = this.NoZ;
    locali.NpE = 33L;
    locali.NpF = 33L;
    Log.i("MicroMsg.VLogScriptReader", "videoPtsStep :" + locali.NpE + " imagePtsStep:" + locali.NpF);
    AppMethodBeat.o(228073);
  }
  
  public final void gul()
  {
    AppMethodBeat.i(228085);
    k localk = this.Npb;
    if (localk != null)
    {
      localk.i((a)new b(this));
      AppMethodBeat.o(228085);
      return;
    }
    AppMethodBeat.o(228085);
  }
  
  public final void release()
  {
    AppMethodBeat.i(228093);
    Log.printInfoStack("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 1", new Object[0]);
    Object localObject = this.Npb;
    if (localObject != null)
    {
      Log.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 2");
      ((k)localObject).i((a)new e(this));
    }
    localObject = this.Npb;
    if (localObject != null) {
      ((k)localObject).release();
    }
    localObject = e.Nps;
    e.clearCache();
    AppMethodBeat.o(228093);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(228077);
    if (paramRect != null)
    {
      Log.i("MicroMsg.VLogDirector", "setCropRect:" + paramRect + ", width:" + this.width + ", height:" + this.height + ", textureWidth:" + this.krg + ", textureHeight:" + this.krh);
      this.kXj = new Rect(paramRect);
      paramRect = this.Npa;
      if (paramRect != null)
      {
        paramRect.kYu = this.kXj;
        AppMethodBeat.o(228077);
        return;
      }
    }
    AppMethodBeat.o(228077);
  }
  
  public final void setMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(228094);
    k localk = this.Npb;
    if (localk != null)
    {
      localk.i((a)new g(this, paramBoolean));
      AppMethodBeat.o(228094);
      return;
    }
    AppMethodBeat.o(228094);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$drawPreloadFrame$1$1"})
  static final class b
    extends q
    implements a<x>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$pause$1$1"})
  public static final class c
    extends q
    implements a<x>
  {
    public c(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$playNextFrame$1$1"})
  static final class d
    extends q
    implements a<x>
  {
    d(k paramk, c paramc, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$release$1$1"})
  static final class e
    extends q
    implements a<x>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$resume$1$1"})
  public static final class f
    extends q
    implements a<x>
  {
    public f(c paramc)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$setMute$1$1"})
  static final class g
    extends q
    implements a<x>
  {
    g(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(c paramc, ah paramah)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(c paramc, k paramk)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements a<x>
  {
    j(c paramc, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.c
 * JD-Core Version:    0.7.0.1
 */