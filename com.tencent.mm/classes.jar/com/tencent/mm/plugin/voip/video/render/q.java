package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ad;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "mIsRenderLocal", "", "(Z)V", "initCallback", "Lkotlin/Function1;", "", "mSharedGLContext", "Landroid/opengl/EGLContext;", "postCreatedGLContext", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "needRefresh", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "", "h", "flag", "", "getRenderSurface", "", "Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "()[Lcom/tencent/mm/plugin/voip/video/render/OpenGLSurface;", "setLocalRenderOrientation", "rotateDegree", "setMirror", "isMirror", "setSharedContext", "sharedContext", "updateLocalRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "updateRendererSize", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public final class q
  extends e
{
  public static final a Ogm;
  private b<? super e, x> Oez;
  private boolean Ogk;
  private EGLContext Ogl;
  
  static
  {
    AppMethodBeat.i(241210);
    Ogm = new a((byte)0);
    AppMethodBeat.o(241210);
  }
  
  public q(boolean paramBoolean)
  {
    super(paramBoolean, Ogm.hashCode());
    AppMethodBeat.i(241207);
    AppMethodBeat.o(241207);
  }
  
  public final void Bs(boolean paramBoolean)
  {
    AppMethodBeat.i(241197);
    if (this.Ogk)
    {
      AppMethodBeat.o(241197);
      return;
    }
    if (paramBoolean)
    {
      if (this.Ogl == null)
      {
        AppMethodBeat.o(241197);
        return;
      }
      j((kotlin.g.a.a)new c(this));
      this.Ogk = true;
      AppMethodBeat.o(241197);
      return;
    }
    j((kotlin.g.a.a)new d(this));
    this.Ogk = true;
    AppMethodBeat.o(241197);
  }
  
  public final void a(h paramh, ad paramad, Integer paramInteger, Boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(241195);
    p.k(paramad, "renderSize");
    if (paramh != null)
    {
      boolean bool;
      if (paramInteger != null)
      {
        i = paramInteger.intValue();
        if (paramBoolean == null) {
          break label201;
        }
        bool = paramBoolean.booleanValue();
        label40:
        p.k(paramad, "cameraSize");
        Log.printInfoStack("MicroMsg.PboSurfaceRender", "updatePboAndWindowsSize is " + paramad.width + " and " + paramad.height + " and " + i, new Object[0]);
        paramInteger = paramh.Oew;
        if (paramInteger != null) {
          paramInteger.dv(paramad.width, paramad.height);
        }
        paramad = paramh.Oew;
        if (paramad != null) {
          paramad.tm(i);
        }
        paramad = paramh.Oew;
        if (paramad != null)
        {
          if (bool) {
            break label207;
          }
          bool = true;
          label149:
          paramad.kYh = bool;
        }
        paramh = paramh.Oew;
        if (paramh == null) {
          break label213;
        }
      }
      label201:
      label207:
      label213:
      for (paramh = paramh.kYx;; paramh = null)
      {
        a(paramh);
        paramh = this.Oei;
        if (paramh == null) {
          break label218;
        }
        paramh.tm(0);
        AppMethodBeat.o(241195);
        return;
        i = 90;
        break;
        bool = false;
        break label40;
        bool = false;
        break label149;
      }
      label218:
      AppMethodBeat.o(241195);
      return;
    }
    paramh = this.Oei;
    if (paramh != null) {
      paramh.dv(paramad.width, paramad.height);
    }
    paramh = this.Oei;
    if (paramh != null)
    {
      if (paramInteger != null) {
        i = paramInteger.intValue();
      }
      paramh.tm(i);
      AppMethodBeat.o(241195);
      return;
    }
    AppMethodBeat.o(241195);
  }
  
  public final void a(b<? super e, x> paramb, h paramh, boolean paramBoolean)
  {
    AppMethodBeat.i(241193);
    if (paramh != null)
    {
      Object localObject = paramh.lav;
      if (localObject != null)
      {
        localObject = ((c.b)localObject).lau;
        if (localObject != null)
        {
          this.Ogl = ((EGLContext)localObject);
          Bs(true);
        }
        if (!paramBoolean) {
          break label107;
        }
        paramb = (b)new b(this);
        if (!paramh.OeA.contains(paramb)) {
          paramh.OeA.add(paramb);
        }
      }
      for (;;)
      {
        this.Oej = paramh.width;
        this.Oek = paramh.height;
        AppMethodBeat.o(241193);
        return;
        localObject = null;
        break;
        label107:
        this.Oez = paramb;
      }
    }
    this.Oez = paramb;
    Bs(false);
    AppMethodBeat.o(241193);
  }
  
  public final void alO(int paramInt)
  {
    AppMethodBeat.i(241201);
    o localo = this.Oei;
    if (localo != null)
    {
      localo.tm(paramInt);
      AppMethodBeat.o(241201);
      return;
    }
    AppMethodBeat.o(241201);
  }
  
  public final g[] gEq()
  {
    return new g[] { this.Oef, this.Oeg };
  }
  
  public final void setMirror(boolean paramBoolean)
  {
    o localo = this.Oei;
    if (localo != null) {
      localo.kYh = paramBoolean;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements b<d, x>
  {
    b(q paramq)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(q paramq)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$1$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(d paramd, q.c paramc) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(235783);
        this.Ogp.Ogn.j((kotlin.g.a.a)new kotlin.g.b.q(paramSurfaceTexture) {});
        AppMethodBeat.o(235783);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(q paramq)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$2$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(d paramd, q.d paramd1) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(235049);
        this.Ogr.Ogn.j((kotlin.g.a.a)new kotlin.g.b.q(paramSurfaceTexture) {});
        AppMethodBeat.o(235049);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.q
 * JD-Core Version:    0.7.0.1
 */