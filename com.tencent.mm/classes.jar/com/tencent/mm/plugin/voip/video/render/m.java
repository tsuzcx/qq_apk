package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.k.c.b;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.z;
import java.util.ArrayList;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "mIsRenderLocal", "", "(Z)V", "initCallback", "Lkotlin/Function1;", "", "mSharedGLContext", "Landroid/opengl/EGLContext;", "postCreatedGLContext", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "", "h", "flag", "", "setLocalRenderOrientation", "rotateDegree", "setSharedContext", "sharedContext", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public final class m
  extends c
{
  public static final m.a Ctj;
  private b<? super c, z> CrZ;
  private boolean Cth;
  private EGLContext Cti;
  
  static
  {
    AppMethodBeat.i(216234);
    Ctj = new m.a((byte)0);
    AppMethodBeat.o(216234);
  }
  
  public m(boolean paramBoolean)
  {
    super(paramBoolean, Ctj.hashCode());
    AppMethodBeat.i(216233);
    AppMethodBeat.o(216233);
  }
  
  public final void a(g paramg, ac paramac, Integer paramInteger, Boolean paramBoolean)
  {
    int j = 90;
    int i = 0;
    AppMethodBeat.i(216231);
    p.h(paramac, "renderSize");
    if (paramg != null)
    {
      boolean bool;
      if (paramInteger != null)
      {
        i = paramInteger.intValue();
        if (paramBoolean == null) {
          break label166;
        }
        bool = paramBoolean.booleanValue();
        label44:
        p.h(paramac, "cameraSize");
        if (paramg.eBe() == 0) {
          break label172;
        }
        paramInteger = paramg.CrV;
        if (paramInteger != null) {
          paramInteger.cU(paramac.width, paramac.height);
        }
        paramac = paramg.CrV;
        if (paramac != null)
        {
          if (i == 90) {
            j = 270;
          }
          paramac.nd(j);
        }
        paramac = paramg.CrV;
        if (paramac != null) {
          paramac.hnl = bool;
        }
        label120:
        paramg = paramg.CrV;
        if (paramg == null) {
          break label240;
        }
      }
      label166:
      label172:
      label240:
      for (paramg = paramg.hnu;; paramg = null)
      {
        a(paramg);
        paramg = this.CrB;
        if (paramg == null) {
          break label245;
        }
        paramg.nd(0);
        AppMethodBeat.o(216231);
        return;
        i = 90;
        break;
        bool = false;
        break label44;
        paramInteger = paramg.CrV;
        if (paramInteger != null) {
          paramInteger.cU(paramac.width, paramac.height);
        }
        paramac = paramg.CrV;
        if (paramac != null) {
          paramac.nd(i);
        }
        paramac = paramg.CrV;
        if (paramac == null) {
          break label120;
        }
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramac.hnl = bool;
          break;
        }
      }
      label245:
      AppMethodBeat.o(216231);
      return;
    }
    paramg = this.CrB;
    if (paramg != null) {
      paramg.cU(paramac.width, paramac.height);
    }
    paramg = this.CrB;
    if (paramg != null)
    {
      if (paramInteger != null) {
        i = paramInteger.intValue();
      }
      paramg.nd(i);
      AppMethodBeat.o(216231);
      return;
    }
    AppMethodBeat.o(216231);
  }
  
  public final void a(b<? super c, z> paramb, g paramg)
  {
    AppMethodBeat.i(216230);
    if (paramg != null)
    {
      paramb = paramg.huo;
      if (paramb != null) {}
      for (paramb = paramb.hoR;; paramb = null)
      {
        if (paramb != null)
        {
          this.Cti = paramb;
          tK(true);
        }
        paramb = (b)new b(this);
        if (!paramg.Csb.contains(paramb)) {
          paramg.Csb.add(paramb);
        }
        this.CrC = paramg.width;
        this.CrD = paramg.height;
        AppMethodBeat.o(216230);
        return;
      }
    }
    this.CrZ = paramb;
    tK(false);
    AppMethodBeat.o(216230);
  }
  
  public final void tK(boolean paramBoolean)
  {
    AppMethodBeat.i(216232);
    if (this.Cth)
    {
      AppMethodBeat.o(216232);
      return;
    }
    if (paramBoolean)
    {
      if (this.Cti == null)
      {
        AppMethodBeat.o(216232);
        return;
      }
      i((d.g.a.a)new c(this));
      this.Cth = true;
      AppMethodBeat.o(216232);
      return;
    }
    i((d.g.a.a)new d(this));
    this.Cth = true;
    AppMethodBeat.o(216232);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class b
    extends q
    implements b<d, z>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(m paramm)
    {
      super();
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$2$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(d paramd, m.d paramd1) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(216227);
        this.Ctm.Ctk.i((d.g.a.a)new q(paramSurfaceTexture) {});
        AppMethodBeat.o(216227);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.m
 * JD-Core Version:    0.7.0.1
 */