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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "", "width", "", "height", "textureWidth", "textureHeight", "widthScale", "", "heightScale", "loop", "", "previewPlay", "(IIIIFFZZ)V", "(IIZZ)V", "cropRect", "Landroid/graphics/Rect;", "drawCount", "durationMs", "getDurationMs", "()I", "setDurationMs", "(I)V", "getHeight", "lastPlayTime", "", "getLoop", "()Z", "setLoop", "(Z)V", "nextDrawTimeDelay", "onEnd", "Lkotlin/Function1;", "", "getOnEnd", "()Lkotlin/jvm/functions/Function1;", "setOnEnd", "(Lkotlin/jvm/functions/Function1;)V", "onProgress", "Lkotlin/Function2;", "getOnProgress", "()Lkotlin/jvm/functions/Function2;", "setOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "prepared", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "scriptReader", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "snapShotCallback", "Ljava/nio/IntBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "getSnapShotCallback", "setSnapShotCallback", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "getWidth", "drawPreloadFrame", "getNextPtsStep", "getSize", "Landroid/util/Size;", "pause", "playNextFrame", "blendBitmap", "Landroid/graphics/Bitmap;", "withSnapshot", "drawCallback", "Lkotlin/Function0;", "preloadOneFrame", "release", "reset", "resetPts", "resume", "setCallback", "setCropRect", "rect", "setFrameRate", "videoFps", "imageFps", "setMute", "mute", "setScript", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "musicUrl", "", "setSnapshotCallback", "callback", "setVLogSurface", "updateDrawSize", "videoDecodeEnd", "Companion", "plugin-vlog_release"})
public final class c
{
  public static final a GBv;
  private i GBn;
  private com.tencent.mm.media.j.b.b GBo;
  public k GBp;
  public m<? super Long, ? super Long, x> GBq;
  public kotlin.g.a.b<? super Long, x> GBr;
  public kotlin.g.a.b<? super IntBuffer, x> GBs;
  public long GBt;
  private final boolean GBu;
  private boolean bcY;
  private int gRJ;
  private int hDn;
  private int hDo;
  public final int height;
  private Rect iiw;
  int jkS;
  private boolean loop;
  private float mLi;
  private float mLj;
  long pts;
  private long vgi;
  public final int width;
  
  static
  {
    AppMethodBeat.i(190856);
    GBv = new a((byte)0);
    AppMethodBeat.o(190856);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2, false, false);
    AppMethodBeat.i(190855);
    this.mLi = paramFloat1;
    this.mLj = paramFloat2;
    this.hDn = paramInt3;
    this.hDo = paramInt4;
    Log.i("MicroMsg.VLogDirector", "create VLogDirector, scale:[" + paramFloat1 + ", " + paramFloat2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(190855);
  }
  
  private c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(190854);
    this.width = paramInt1;
    this.height = paramInt2;
    this.loop = paramBoolean1;
    this.GBu = paramBoolean2;
    this.GBn = new i(this.GBu);
    this.mLi = 1.0F;
    this.mLj = 1.0F;
    this.pts = -1L;
    AppMethodBeat.o(190854);
  }
  
  private final void fCn()
  {
    this.pts = 0L;
    this.gRJ = 0;
  }
  
  public final void a(final ah paramah, int paramInt, String paramString)
  {
    AppMethodBeat.i(190844);
    p.h(paramah, "scriptModel");
    p.h(paramString, "musicUrl");
    Log.i("MicroMsg.VLogDirector", hashCode() + "  setScript  durationMs :" + paramInt + "  musicUrl:" + paramString);
    this.jkS = paramInt;
    fCn();
    this.bcY = true;
    paramString = this.GBp;
    if (paramString != null)
    {
      paramString.j((a)new h(this, paramah));
      AppMethodBeat.o(190844);
      return;
    }
    AppMethodBeat.o(190844);
  }
  
  public final void a(final k paramk)
  {
    AppMethodBeat.i(190848);
    p.h(paramk, "vLogSurface");
    Log.i("MicroMsg.VLogDirector", hashCode() + " setSurface");
    this.GBp = paramk;
    paramk.j((a)new i(this, paramk));
    AppMethodBeat.o(190848);
  }
  
  public final void cX(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(190849);
    Log.i("MicroMsg.VLogDirector", hashCode() + " updateDrawSize:[" + paramInt1 + ", " + paramInt2 + ']');
    k localk = this.GBp;
    if (localk != null)
    {
      localk.j((a)new j(this, paramInt1, paramInt2));
      AppMethodBeat.o(190849);
      return;
    }
    AppMethodBeat.o(190849);
  }
  
  public final void fCl()
  {
    AppMethodBeat.i(190846);
    i locali = this.GBn;
    locali.GBT = 33L;
    locali.GBU = 33L;
    Log.i("MicroMsg.VLogScriptReader", "videoPtsStep :" + locali.GBT + " imagePtsStep:" + locali.GBU);
    AppMethodBeat.o(190846);
  }
  
  public final void fCm()
  {
    AppMethodBeat.i(190850);
    k localk = this.GBp;
    if (localk != null)
    {
      localk.j((a)new b(this));
      AppMethodBeat.o(190850);
      return;
    }
    AppMethodBeat.o(190850);
  }
  
  public final void release()
  {
    AppMethodBeat.i(190852);
    Log.printInfoStack("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 1", new Object[0]);
    Object localObject = this.GBp;
    if (localObject != null)
    {
      Log.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 2");
      ((k)localObject).j((a)new e(this));
    }
    localObject = this.GBp;
    if (localObject != null) {
      ((k)localObject).release();
    }
    localObject = e.GBH;
    e.clearCache();
    AppMethodBeat.o(190852);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(190847);
    if (paramRect != null)
    {
      Log.i("MicroMsg.VLogDirector", "setCropRect:" + paramRect + ", width:" + this.width + ", height:" + this.height + ", textureWidth:" + this.hDn + ", textureHeight:" + this.hDo);
      this.iiw = new Rect(paramRect);
      paramRect = this.GBo;
      if (paramRect != null)
      {
        paramRect.ijA = this.iiw;
        AppMethodBeat.o(190847);
        return;
      }
    }
    AppMethodBeat.o(190847);
  }
  
  public final void setMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(190853);
    k localk = this.GBp;
    if (localk != null)
    {
      localk.j((a)new g(this, paramBoolean));
      AppMethodBeat.o(190853);
      return;
    }
    AppMethodBeat.o(190853);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$drawPreloadFrame$1$1"})
  static final class b
    extends q
    implements a<x>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$pause$1$1"})
  public static final class c
    extends q
    implements a<x>
  {
    public c(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$playNextFrame$1$1"})
  static final class d
    extends q
    implements a<x>
  {
    d(k paramk, c paramc, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$release$1$1"})
  static final class e
    extends q
    implements a<x>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$resume$1$1"})
  public static final class f
    extends q
    implements a<x>
  {
    public f(c paramc)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/vlog/player/VLogDirector$setMute$1$1"})
  static final class g
    extends q
    implements a<x>
  {
    g(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements a<x>
  {
    h(c paramc, ah paramah)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class i
    extends q
    implements a<x>
  {
    i(c paramc, k paramk)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.c
 * JD-Core Version:    0.7.0.1
 */