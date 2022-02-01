package com.tencent.mm.plugin.voip.video.render;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.opengl.EGLContext;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ac;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.j.c.b;
import d.y;
import java.util.ArrayList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "mIsRenderLocal", "", "(Z)V", "initCallback", "Lkotlin/Function1;", "", "mSharedGLContext", "Landroid/opengl/EGLContext;", "postCreatedGLContext", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "", "h", "flag", "", "setLocalRenderOrientation", "rotateDegree", "setSharedContext", "sharedContext", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public final class k
  extends b
{
  public static final k.a ATb;
  private d.g.a.b<? super b, y> ARZ;
  private boolean ASZ;
  private EGLContext ATa;
  
  static
  {
    AppMethodBeat.i(208871);
    ATb = new k.a((byte)0);
    AppMethodBeat.o(208871);
  }
  
  public k(boolean paramBoolean)
  {
    super(paramBoolean, ATb.hashCode());
    AppMethodBeat.i(208870);
    AppMethodBeat.o(208870);
  }
  
  public final void a(f paramf, ac paramac, Integer paramInteger, Boolean paramBoolean)
  {
    int j = 90;
    int i = 0;
    AppMethodBeat.i(208868);
    d.g.b.k.h(paramac, "renderSize");
    if (paramf != null)
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
        d.g.b.k.h(paramac, "cameraSize");
        if (paramf.eng() == 0) {
          break label172;
        }
        paramInteger = paramf.ARV;
        if (paramInteger != null) {
          paramInteger.cS(paramac.width, paramac.height);
        }
        paramac = paramf.ARV;
        if (paramac != null)
        {
          if (i == 90) {
            j = 270;
          }
          paramac.mE(j);
        }
        paramac = paramf.ARV;
        if (paramac != null) {
          paramac.gVi = bool;
        }
        label120:
        paramf = paramf.ARV;
        if (paramf == null) {
          break label240;
        }
      }
      label166:
      label172:
      label240:
      for (paramf = paramf.gVr;; paramf = null)
      {
        a(paramf);
        paramf = this.ARD;
        if (paramf == null) {
          break label245;
        }
        paramf.mE(0);
        AppMethodBeat.o(208868);
        return;
        i = 90;
        break;
        bool = false;
        break label44;
        paramInteger = paramf.ARV;
        if (paramInteger != null) {
          paramInteger.cS(paramac.width, paramac.height);
        }
        paramac = paramf.ARV;
        if (paramac != null) {
          paramac.mE(i);
        }
        paramac = paramf.ARV;
        if (paramac == null) {
          break label120;
        }
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramac.gVi = bool;
          break;
        }
      }
      label245:
      AppMethodBeat.o(208868);
      return;
    }
    paramf = this.ARD;
    if (paramf != null) {
      paramf.cS(paramac.width, paramac.height);
    }
    paramf = this.ARD;
    if (paramf != null)
    {
      if (paramInteger != null) {
        i = paramInteger.intValue();
      }
      paramf.mE(i);
      AppMethodBeat.o(208868);
      return;
    }
    AppMethodBeat.o(208868);
  }
  
  public final void a(d.g.a.b<? super b, y> paramb, f paramf)
  {
    AppMethodBeat.i(208867);
    if (paramf != null)
    {
      paramb = paramf.hcg;
      if (paramb != null) {}
      for (paramb = paramb.gWL;; paramb = null)
      {
        if (paramb != null)
        {
          this.ATa = paramb;
          ta(true);
        }
        paramb = (d.g.a.b)new b(this);
        if (!paramf.ASb.contains(paramb)) {
          paramf.ASb.add(paramb);
        }
        this.ARE = paramf.width;
        this.ARF = paramf.height;
        AppMethodBeat.o(208867);
        return;
      }
    }
    this.ARZ = paramb;
    ta(false);
    AppMethodBeat.o(208867);
  }
  
  public final void ta(boolean paramBoolean)
  {
    AppMethodBeat.i(208869);
    if (this.ASZ)
    {
      AppMethodBeat.o(208869);
      return;
    }
    if (paramBoolean)
    {
      if (this.ATa == null)
      {
        AppMethodBeat.o(208869);
        return;
      }
      i((d.g.a.a)new c(this));
      this.ASZ = true;
      AppMethodBeat.o(208869);
      return;
    }
    i((d.g.a.a)new d(this));
    this.ASZ = true;
    AppMethodBeat.o(208869);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.b<d, y>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    d(k paramk)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$2$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(d paramd, k.d paramd1) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(208864);
        this.ATe.ATc.i((d.g.a.a)new d.g.b.l(paramSurfaceTexture) {});
        AppMethodBeat.o(208864);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.k
 * JD-Core Version:    0.7.0.1
 */