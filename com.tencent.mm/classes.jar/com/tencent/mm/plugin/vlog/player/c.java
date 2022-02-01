package com.tencent.mm.plugin.vlog.player;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.IntBuffer;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/player/VLogDirector;", "", "width", "", "height", "textureWidth", "textureHeight", "widthScale", "", "heightScale", "loop", "", "previewPlay", "(IIIIFFZZ)V", "(IIZZ)V", "cropRect", "Landroid/graphics/Rect;", "drawCount", "durationMs", "getDurationMs", "()I", "setDurationMs", "(I)V", "getHeight", "lastPlayTime", "", "getLoop", "()Z", "setLoop", "(Z)V", "nextDrawTimeDelay", "onEnd", "Lkotlin/Function1;", "", "getOnEnd", "()Lkotlin/jvm/functions/Function1;", "setOnEnd", "(Lkotlin/jvm/functions/Function1;)V", "onProgress", "Lkotlin/Function2;", "getOnProgress", "()Lkotlin/jvm/functions/Function2;", "setOnProgress", "(Lkotlin/jvm/functions/Function2;)V", "prepared", "pts", "getPts", "()J", "setPts", "(J)V", "render", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcBlend;", "scriptReader", "Lcom/tencent/mm/plugin/vlog/player/VLogScriptReader;", "snapShotCallback", "Ljava/nio/IntBuffer;", "Lkotlin/ParameterName;", "name", "buffer", "getSnapShotCallback", "setSnapShotCallback", "vLogSurface", "Lcom/tencent/mm/plugin/vlog/player/VLogSurface;", "getWidth", "drawPreloadFrame", "getNextPtsStep", "getSize", "Landroid/util/Size;", "pause", "playNextFrame", "blendBitmap", "Landroid/graphics/Bitmap;", "withSnapshot", "drawCallback", "Lkotlin/Function0;", "preloadOneFrame", "release", "reset", "resetPts", "resume", "setCallback", "setCropRect", "rect", "setFrameRate", "videoFps", "imageFps", "setMute", "mute", "setScript", "scriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "musicUrl", "", "setSnapshotCallback", "callback", "setVLogSurface", "updateDrawSize", "videoDecodeEnd", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c.a UcT;
  private long FsW;
  private Rect Gl;
  private final boolean UcU;
  private h UcV;
  private com.tencent.mm.media.j.b.b UcW;
  public j UcX;
  public m<? super Long, ? super Long, kotlin.ah> UcY;
  public kotlin.g.a.b<? super Long, kotlin.ah> UcZ;
  public kotlin.g.a.b<? super IntBuffer, kotlin.ah> Uda;
  public long Udb;
  private boolean cGv;
  public final int height;
  private boolean loop;
  private int mVd;
  private int mVe;
  private int mbS;
  int oTN;
  long pts;
  private float sQQ;
  private float sQR;
  public final int width;
  
  static
  {
    AppMethodBeat.i(281238);
    UcT = new c.a((byte)0);
    AppMethodBeat.o(281238);
  }
  
  public c(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2, false, false);
    AppMethodBeat.i(281193);
    this.sQQ = paramFloat1;
    this.sQR = paramFloat2;
    this.mVd = paramInt3;
    this.mVe = paramInt4;
    Log.i("MicroMsg.VLogDirector", "create VLogDirector, scale:[" + paramFloat1 + ", " + paramFloat2 + "], texture:[" + paramInt3 + ", " + paramInt4 + ']');
    AppMethodBeat.o(281193);
  }
  
  private c(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(281188);
    this.width = paramInt1;
    this.height = paramInt2;
    this.loop = paramBoolean1;
    this.UcU = paramBoolean2;
    this.UcV = new h(this.UcU);
    this.sQQ = 1.0F;
    this.sQR = 1.0F;
    this.pts = -1L;
    AppMethodBeat.o(281188);
  }
  
  private final void hSb()
  {
    this.pts = 0L;
    this.mbS = 0;
  }
  
  public final void a(final com.tencent.mm.plugin.vlog.model.ah paramah, int paramInt, String paramString)
  {
    AppMethodBeat.i(281241);
    s.u(paramah, "scriptModel");
    s.u(paramString, "musicUrl");
    Log.i("MicroMsg.VLogDirector", hashCode() + "  setScript  durationMs :" + paramInt + "  musicUrl:" + paramString);
    this.oTN = paramInt;
    hSb();
    this.cGv = true;
    paramString = this.UcX;
    if (paramString != null) {
      paramString.H((a)new h(this, paramah));
    }
    AppMethodBeat.o(281241);
  }
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(281262);
    s.u(paramj, "vLogSurface");
    Log.i("MicroMsg.VLogDirector", hashCode() + " setSurface");
    this.UcX = paramj;
    paramj.H((a)new i(this, paramj));
    AppMethodBeat.o(281262);
  }
  
  public final void ej(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(281266);
    Log.i("MicroMsg.VLogDirector", hashCode() + " updateDrawSize:[" + paramInt1 + ", " + paramInt2 + ']');
    j localj = this.UcX;
    if (localj != null) {
      localj.H((a)new j(this, paramInt1, paramInt2));
    }
    AppMethodBeat.o(281266);
  }
  
  public final void hRZ()
  {
    AppMethodBeat.i(281246);
    h localh = this.UcV;
    localh.Udy = 33L;
    localh.Udz = 33L;
    Log.i("MicroMsg.VLogScriptReader", "videoPtsStep :" + localh.Udy + " imagePtsStep:" + localh.Udz);
    AppMethodBeat.o(281246);
  }
  
  public final void hSa()
  {
    AppMethodBeat.i(281271);
    j localj = this.UcX;
    if (localj != null) {
      localj.H((a)new b(this));
    }
    AppMethodBeat.o(281271);
  }
  
  public final void release()
  {
    AppMethodBeat.i(281295);
    Log.printInfoStack("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 1", new Object[0]);
    Object localObject = this.UcX;
    if (localObject != null)
    {
      Log.d("MicroMsg.VLogDirector", "VLogRelease into VLogDirector#release 2");
      ((j)localObject).H((a)new e(this));
    }
    localObject = this.UcX;
    if (localObject != null) {
      ((j)localObject).release();
    }
    localObject = e.Udl;
    e.clearCache();
    AppMethodBeat.o(281295);
  }
  
  public final void setCropRect(Rect paramRect)
  {
    AppMethodBeat.i(281255);
    if (paramRect != null)
    {
      Log.i("MicroMsg.VLogDirector", "setCropRect:" + paramRect + ", width:" + this.width + ", height:" + this.height + ", textureWidth:" + this.mVd + ", textureHeight:" + this.mVe);
      this.Gl = new Rect(paramRect);
      paramRect = this.UcW;
      if (paramRect != null) {
        paramRect.nDB = this.Gl;
      }
    }
    AppMethodBeat.o(281255);
  }
  
  public final void setMute(final boolean paramBoolean)
  {
    AppMethodBeat.i(281302);
    j localj = this.UcX;
    if (localj != null) {
      localj.H((a)new g(this, paramBoolean));
    }
    AppMethodBeat.o(281302);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<kotlin.ah>
  {
    b(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements a<kotlin.ah>
  {
    public c(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<kotlin.ah>
  {
    d(c paramc, j paramj, Bitmap paramBitmap, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<kotlin.ah>
  {
    e(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class f
    extends u
    implements a<kotlin.ah>
  {
    public f(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements a<kotlin.ah>
  {
    g(c paramc, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements a<kotlin.ah>
  {
    h(c paramc, com.tencent.mm.plugin.vlog.model.ah paramah)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements a<kotlin.ah>
  {
    i(c paramc, j paramj)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements a<kotlin.ah>
  {
    j(c paramc, int paramInt1, int paramInt2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.player.c
 * JD-Core Version:    0.7.0.1
 */