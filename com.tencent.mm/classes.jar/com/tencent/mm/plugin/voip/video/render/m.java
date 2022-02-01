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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer;", "Lcom/tencent/mm/plugin/voip/video/render/IWindowSurfaceRenderer;", "mIsRenderLocal", "", "(Z)V", "initCallback", "Lkotlin/Function1;", "", "mSharedGLContext", "Landroid/opengl/EGLContext;", "postCreatedGLContext", "checkInit", "callback", "pboSurfaceRender", "Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;", "createEGLContext", "isUseShareContext", "drawFrame", "pBuff", "", "w", "", "h", "flag", "", "setLocalRenderOrientation", "rotateDegree", "setSharedContext", "sharedContext", "updateRendererSize", "renderSize", "Lcom/tencent/mm/compatible/deviceinfo/Size;", "mIsMirror", "(Lcom/tencent/mm/plugin/voip/video/render/PboSurfaceRender;Lcom/tencent/mm/compatible/deviceinfo/Size;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "Companion", "plugin-voip_release"})
public final class m
  extends c
{
  public static final m.a CKN;
  private b<? super c, z> CJD;
  private boolean CKL;
  private EGLContext CKM;
  
  static
  {
    AppMethodBeat.i(210655);
    CKN = new m.a((byte)0);
    AppMethodBeat.o(210655);
  }
  
  public m(boolean paramBoolean)
  {
    super(paramBoolean, CKN.hashCode());
    AppMethodBeat.i(210654);
    AppMethodBeat.o(210654);
  }
  
  public final void a(g paramg, ac paramac, Integer paramInteger, Boolean paramBoolean)
  {
    int j = 90;
    int i = 0;
    AppMethodBeat.i(210652);
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
        if (paramg.eEM() == 0) {
          break label172;
        }
        paramInteger = paramg.CJz;
        if (paramInteger != null) {
          paramInteger.cU(paramac.width, paramac.height);
        }
        paramac = paramg.CJz;
        if (paramac != null)
        {
          if (i == 90) {
            j = 270;
          }
          paramac.ng(j);
        }
        paramac = paramg.CJz;
        if (paramac != null) {
          paramac.hpZ = bool;
        }
        label120:
        paramg = paramg.CJz;
        if (paramg == null) {
          break label240;
        }
      }
      label166:
      label172:
      label240:
      for (paramg = paramg.hqi;; paramg = null)
      {
        a(paramg);
        paramg = this.CJf;
        if (paramg == null) {
          break label245;
        }
        paramg.ng(0);
        AppMethodBeat.o(210652);
        return;
        i = 90;
        break;
        bool = false;
        break label44;
        paramInteger = paramg.CJz;
        if (paramInteger != null) {
          paramInteger.cU(paramac.width, paramac.height);
        }
        paramac = paramg.CJz;
        if (paramac != null) {
          paramac.ng(i);
        }
        paramac = paramg.CJz;
        if (paramac == null) {
          break label120;
        }
        if (!bool) {}
        for (bool = true;; bool = false)
        {
          paramac.hpZ = bool;
          break;
        }
      }
      label245:
      AppMethodBeat.o(210652);
      return;
    }
    paramg = this.CJf;
    if (paramg != null) {
      paramg.cU(paramac.width, paramac.height);
    }
    paramg = this.CJf;
    if (paramg != null)
    {
      if (paramInteger != null) {
        i = paramInteger.intValue();
      }
      paramg.ng(i);
      AppMethodBeat.o(210652);
      return;
    }
    AppMethodBeat.o(210652);
  }
  
  public final void a(b<? super c, z> paramb, g paramg)
  {
    AppMethodBeat.i(210651);
    if (paramg != null)
    {
      paramb = paramg.hxc;
      if (paramb != null) {}
      for (paramb = paramb.hrF;; paramb = null)
      {
        if (paramb != null)
        {
          this.CKM = paramb;
          tR(true);
        }
        paramb = (b)new b(this);
        if (!paramg.CJF.contains(paramb)) {
          paramg.CJF.add(paramb);
        }
        this.CJg = paramg.width;
        this.CJh = paramg.height;
        AppMethodBeat.o(210651);
        return;
      }
    }
    this.CJD = paramb;
    tR(false);
    AppMethodBeat.o(210651);
  }
  
  public final void tR(boolean paramBoolean)
  {
    AppMethodBeat.i(210653);
    if (this.CKL)
    {
      AppMethodBeat.o(210653);
      return;
    }
    if (paramBoolean)
    {
      if (this.CKM == null)
      {
        AppMethodBeat.o(210653);
        return;
      }
      j((d.g.a.a)new c(this));
      this.CKL = true;
      AppMethodBeat.o(210653);
      return;
    }
    j((d.g.a.a)new d(this));
    this.CKL = true;
    AppMethodBeat.o(210653);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/media/globject/GLTextureObject;", "invoke"})
  static final class b
    extends q
    implements b<d, z>
  {
    b(m paramm)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(m paramm)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<z>
  {
    d(m paramm)
    {
      super();
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/graphics/SurfaceTexture;", "kotlin.jvm.PlatformType", "onFrameAvailable", "com/tencent/mm/plugin/voip/video/render/WindowSurfaceRenderer$createEGLContext$2$1$1"})
    static final class a
      implements SurfaceTexture.OnFrameAvailableListener
    {
      a(d paramd, m.d paramd1) {}
      
      public final void onFrameAvailable(final SurfaceTexture paramSurfaceTexture)
      {
        AppMethodBeat.i(210648);
        this.CKQ.CKO.j((d.g.a.a)new q(paramSurfaceTexture) {});
        AppMethodBeat.o(210648);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.render.m
 * JD-Core Version:    0.7.0.1
 */