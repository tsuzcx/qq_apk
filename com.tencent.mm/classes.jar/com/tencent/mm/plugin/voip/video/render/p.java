package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "mIsRenderLocal", "", "(Z)V", "initCallback", "Lkotlin/Function1;", "", "getInitCallback", "()Lkotlin/jvm/functions/Function1;", "setInitCallback", "(Lkotlin/jvm/functions/Function1;)V", "mSharedGLContext", "Landroid/opengl/EGLContext;", "getMSharedGLContext", "()Landroid/opengl/EGLContext;", "setMSharedGLContext", "(Landroid/opengl/EGLContext;)V", "postCreatedGLContext", "getPostCreatedGLContext", "()Z", "setPostCreatedGLContext", "softPatchSize", "", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "h", "flag", "", "getRenderSurface", "", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "()[Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "recreate", "refreshFrame", "setLocalRenderOrientation", "rotateDegree", "setMirror", "isMirror", "setSharedContext", "sharedContext", "updateLocalRendererSize", "renderSize", "Landroid/util/Size;", "Companion", "plugin-voip_release"}, k=1, mv={1, 5, 1}, xi=48)
public class p
  extends f
{
  public static final p.a UUA;
  b<? super f, ah> USI;
  private boolean UUB;
  EGLContext UUC;
  private final int UUD;
  
  static
  {
    AppMethodBeat.i(293127);
    UUA = new p.a((byte)0);
    AppMethodBeat.o(293127);
  }
  
  public p(boolean paramBoolean)
  {
    super(paramBoolean, UUA.hashCode());
    AppMethodBeat.i(293113);
    this.UUD = ((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.ySq, 64);
    AppMethodBeat.o(293113);
  }
  
  public void GV(boolean paramBoolean)
  {
    AppMethodBeat.i(293161);
    if (this.UUB)
    {
      AppMethodBeat.o(293161);
      return;
    }
    Log.printInfoStack("MicroMsg.WindowSurfaceRenderer", "createEGLContext, isUseShareContext:" + paramBoolean + ", shareGLContext:" + this.UUC, new Object[0]);
    if (paramBoolean)
    {
      if (this.UUC == null)
      {
        AppMethodBeat.o(293161);
        return;
      }
      K((a)new c(this));
      this.UUB = true;
      AppMethodBeat.o(293161);
      return;
    }
    K((a)new d(this));
    this.UUB = true;
    AppMethodBeat.o(293161);
  }
  
  public void a(b<? super f, ah> paramb, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(293152);
    if (paramh != null)
    {
      d(paramh.ido());
      if (paramBoolean) {
        paramh.aO((b)new b(this));
      }
      for (;;)
      {
        this.USo = paramh.width;
        this.USp = paramh.height;
        AppMethodBeat.o(293152);
        return;
        this.USI = paramb;
      }
    }
    this.USI = paramb;
    ((f)this).GV(false);
    AppMethodBeat.o(293152);
  }
  
  public final void aru(int paramInt)
  {
    AppMethodBeat.i(293169);
    n localn = this.USn;
    if (localn != null) {
      localn.th(paramInt);
    }
    localn = this.USn;
    if (localn != null) {
      localn.arz(paramInt);
    }
    AppMethodBeat.o(293169);
  }
  
  protected final void d(EGLContext paramEGLContext)
  {
    AppMethodBeat.i(293142);
    if (paramEGLContext != null)
    {
      this.UUC = paramEGLContext;
      GV(true);
    }
    AppMethodBeat.o(293142);
  }
  
  protected final boolean idI()
  {
    return this.UUB;
  }
  
  protected final void idJ()
  {
    this.UUB = true;
  }
  
  public g[] idg()
  {
    return new g[] { this.USl, this.USm, this.URC };
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    AppMethodBeat.i(293179);
    n localn = this.USn;
    if (localn != null) {
      localn.gr(paramBoolean);
    }
    localn = this.USn;
    if (localn != null) {
      localn.GZ(paramBoolean);
    }
    AppMethodBeat.o(293179);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements b<d, ah>
  {
    b(p paramp)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(p paramp)
    {
      super();
    }
    
    private static final void a(final p paramp, final d paramd, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(292961);
      s.u(paramp, "this$0");
      s.u(paramd, "$this_apply");
      paramp.K((a)new a(paramSurfaceTexture, paramp, paramd));
      AppMethodBeat.o(292961);
    }
    
    private static final void b(p paramp)
    {
      AppMethodBeat.i(292965);
      s.u(paramp, "this$0");
      b localb = paramp.USI;
      if (localb != null) {
        localb.invoke(paramp);
      }
      AppMethodBeat.o(292965);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(SurfaceTexture paramSurfaceTexture, p paramp, d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(p paramp)
    {
      super();
    }
    
    private static final void a(final p paramp, final d paramd, SurfaceTexture paramSurfaceTexture)
    {
      AppMethodBeat.i(292963);
      s.u(paramp, "this$0");
      s.u(paramd, "$this_apply");
      paramp.K((a)new a(paramSurfaceTexture, paramp, paramd));
      AppMethodBeat.o(292963);
    }
    
    private static final void b(p paramp)
    {
      AppMethodBeat.i(292969);
      s.u(paramp, "this$0");
      b localb = paramp.USI;
      if (localb != null) {
        localb.invoke(paramp);
      }
      AppMethodBeat.o(292969);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(SurfaceTexture paramSurfaceTexture, p paramp, d paramd)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends u
    implements a<ah>
  {
    public e(p paramp, int paramInt1, int paramInt2, byte[] paramArrayOfByte, int paramInt3)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.p
 * JD-Core Version:    0.7.0.1
 */