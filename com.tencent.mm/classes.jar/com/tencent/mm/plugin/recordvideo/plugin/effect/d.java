package com.tencent.mm.plugin.recordvideo.plugin.effect;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.EGLSurface;
import android.os.HandlerThread;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.y;
import java.util.ArrayList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterItemRenderMgr;", "", "()V", "eglEnvironment", "Lcom/tencent/mm/media/util/GLEnvironmentUtil$EGLEnvironment;", "eglHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "eglSurfaceMap", "Landroid/util/SparseArray;", "Landroid/opengl/EGLSurface;", "eglThread", "Landroid/os/HandlerThread;", "kotlin.jvm.PlatformType", "filterRender", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/render/FinderFilterRenderer;", "inputTexture", "", "inputTextureContext", "Landroid/opengl/EGLContext;", "inputTextureHeight", "inputTextureMirror", "", "inputTextureRotate", "inputTextureWidth", "renderContextCreated", "scaleRender", "com/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterItemRenderMgr$scaleRender$1", "Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterItemRenderMgr$scaleRender$1;", "surfaceHeight", "surfaceTextures", "Ljava/util/ArrayList;", "Landroid/graphics/SurfaceTexture;", "Lkotlin/collections/ArrayList;", "surfaceWidth", "textureContextChanged", "cancelLeftRender", "", "checkCreateRenderContext", "createGLContextAndRender", "queueEvent", "r", "Lkotlin/Function0;", "release", "releaseEglSurface", "hash", "releaseGLContextRender", "renderFilterToSurface", "surfaceTexture", "filterPath", "", "outWidth", "outHeight", "finishCallback", "scaleTexture", "setInputTextureInfo", "textureContext", "texture", "width", "height", "rotate", "mirror", "setup", "updateTextureContext", "Companion", "plugin-recordvideo_release"})
public final class d
{
  public static final a Lod;
  private SparseArray<EGLSurface> LnU;
  private ArrayList<SurfaceTexture> LnV;
  private com.tencent.mm.plugin.recordvideo.plugin.effect.a.b LnW;
  private e LnX;
  int LnY;
  boolean LnZ;
  boolean Loa;
  EGLContext Lob;
  volatile boolean Loc;
  private c.b gsl;
  int guC;
  int gvl;
  int gvm;
  HandlerThread qPJ;
  ap qPQ;
  private int surfaceHeight;
  private int surfaceWidth;
  
  static
  {
    AppMethodBeat.i(204193);
    Lod = new a((byte)0);
    AppMethodBeat.o(204193);
  }
  
  public d()
  {
    AppMethodBeat.i(204192);
    this.qPJ = com.tencent.e.c.d.gx("MicroMsg.FinderFilterItemRenderMgr", 5);
    this.LnU = new SparseArray();
    this.LnV = new ArrayList();
    this.LnW = new com.tencent.mm.plugin.recordvideo.plugin.effect.a.b();
    this.LnX = new e();
    EGLContext localEGLContext = EGL14.EGL_NO_CONTEXT;
    k.g(localEGLContext, "EGL14.EGL_NO_CONTEXT");
    this.Lob = localEGLContext;
    AppMethodBeat.o(204192);
  }
  
  public final void fYl()
  {
    AppMethodBeat.i(204190);
    ap localap = this.qPQ;
    if (localap != null)
    {
      localap.removeCallbacks(null);
      AppMethodBeat.o(204190);
      return;
    }
    AppMethodBeat.o(204190);
  }
  
  final void j(d.g.a.a<y> parama)
  {
    AppMethodBeat.i(204191);
    ap localap = this.qPQ;
    if (localap != null)
    {
      localap.post((Runnable)new e(parama));
      AppMethodBeat.o(204191);
      return;
    }
    AppMethodBeat.o(204191);
  }
  
  public final void le(int paramInt1, int paramInt2)
  {
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    this.Loa = false;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterItemRenderMgr$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(204183);
      d.f(this.Loe);
      AppMethodBeat.o(204183);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(d paramd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(d paramd, SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2, String paramString, d.g.a.a parama)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/plugin/effect/FinderFilterItemRenderMgr$scaleRender$1", "Lcom/tencent/mm/media/render/SurfaceTextureRenderer;", "scaleTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "getScaleTexture", "()Lcom/tencent/mm/media/globject/GLTextureObject;", "setScaleTexture", "(Lcom/tencent/mm/media/globject/GLTextureObject;)V", "doInitRenderProc", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProc;", "plugin-recordvideo_release"})
  public static final class e
    extends com.tencent.mm.media.i.d
  {
    com.tencent.mm.media.f.d Loh;
    
    e()
    {
      super();
    }
    
    public final com.tencent.mm.media.i.b.a akj()
    {
      AppMethodBeat.i(204187);
      Object localObject = new com.tencent.mm.media.i.b.d(this.guI, this.guJ, this.guK, this.guL, 2, 2);
      ((com.tencent.mm.media.i.b.a)localObject).guZ = ((d.g.a.b)new a(this));
      localObject = (com.tencent.mm.media.i.b.a)localObject;
      AppMethodBeat.o(204187);
      return localObject;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.b<com.tencent.mm.media.f.d, y>
    {
      a(d.e parame)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(d paramd)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(204189);
      d.g(this.Loe);
      ad.i("MicroMsg.FinderFilterItemRenderMgr", "updateTextureContext:" + d.h(this.Loe).hashCode());
      d.f(this.Loe);
      AppMethodBeat.o(204189);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.effect.d
 * JD-Core Version:    0.7.0.1
 */